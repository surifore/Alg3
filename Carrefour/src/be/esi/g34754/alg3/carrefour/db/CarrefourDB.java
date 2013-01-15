/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.db;

import be.esi.g34754.alg3.carrefour.dto.CarrefourDto;
import be.esi.g34754.alg3.carrefour.dto.ParametresDto;
import be.esi.g34754.alg3.carrefour.CouleurEnum;
import be.esi.g34754.alg3.carrefour.Etat;
import be.esi.g34754.alg3.carrefour.Feu;
import be.esi.g34754.alg3.carrefour.FeuPieton;
import be.esi.g34754.alg3.carrefour.FeuVoiture;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Florian
 */
public class CarrefourDB {

    public static void saveChangement(Etat etat) throws CarrefourDbException {
        try {
            int num = SequenceDB.getNumSuivant(SequenceDB.CHANGEMENT);
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert;
            insert = connexion.prepareStatement(
                    "Insert into Changement(id, feuPNS, feuPEO, feuVNS, feuVEO, date, panne) "
                    + "values(?, ?, ?,?,?,?,? )");
            insert.setInt(1, num);
            if (etat.getFeuxP_NS().getEtat().getCouleur().equals(CouleurEnum.VERT)) {
                if (etat.getFeuxP_NS().getEtat().isClignotant()) {
                    insert.setString(2, CouleurEnum.ORANGE.name());
                } else {
                    insert.setString(2, etat.getFeuxP_NS().getEtat().getCouleur().name());
                }
            } else {
                insert.setString(2, etat.getFeuxP_NS().getEtat().getCouleur().name());
            }
            insert.setString(3, etat.getFeuxP_EO().getEtat().getCouleur().name());
            insert.setString(4, etat.getFeuxV_NS().getEtat().getCouleur().name());
            insert.setString(5, etat.getFeuxV_EO().getEtat().getCouleur().name());
            insert.setLong(6, (new java.util.Date().getTime()) / 1000);
            insert.setInt(7, (etat.isEnPanne()) ? 1 : 0);
            insert.executeUpdate();
        } catch (Exception ex) {
            throw new CarrefourDbException("Changement: ajout impossible\n" + ex.getMessage());
        }
    }

    public static void saveAlerte(String alerte) throws CarrefourDbException {
        try {
            int num = SequenceDB.getNumSuivant(SequenceDB.ALERTES);
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert;
            insert = connexion.prepareStatement(
                    "Insert into Alertes(id, error_message) "
                    + "values(?, ?)");
            insert.setInt(1, num);
            insert.setString(2, alerte);
            insert.executeUpdate();
        } catch (Exception ex) {
            throw new CarrefourDbException("Alerte: ajout impossible\n" + ex.getMessage());
        }
    }

    public static void saveParametres(ParametresDto param) throws CarrefourDbException {
        try {
            int num = SequenceDB.getNumSuivant(SequenceDB.PARAMETRE);
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert;
            insert = connexion.prepareStatement(
                    "Insert into Parametre(id, VertFeuPNS, OrangeFeuPNS, RougeFeuPNS,"
                    + "VertFeuPEO, OrangeFeuPEO, RougeFeuPEO,"
                    + "VertFeuVNS, OrangeFeuVNS, RougeFeuVNS,"
                    + "VertFeuVEO, OrangeFeuVEO, RougeFeuVEO,"
                    + "tousRouge,date) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insert.setInt(1, num);
            insert.setInt(2, param.getDureeVert(0));
            insert.setInt(3, param.getDureeOrange(0));
            insert.setInt(4, param.getDureeRouge(0));

            insert.setInt(5, param.getDureeVert(1));
            insert.setInt(6, param.getDureeOrange(1));
            insert.setInt(7, param.getDureeRouge(1));

            insert.setInt(8, param.getDureeVert(2));
            insert.setInt(9, param.getDureeOrange(2));
            insert.setInt(10, param.getDureeRouge(2));

            insert.setInt(11, param.getDureeVert(3));
            insert.setInt(12, param.getDureeOrange(3));
            insert.setInt(13, param.getDureeRouge(3));

            insert.setInt(14, param.getDureeTousRouge());

            insert.setLong(15, new Date().getTime() / 1000);

            insert.executeUpdate();
        } catch (Exception ex) {
            throw new CarrefourDbException("Paramètres: ajout impossible\n" + ex.getMessage());
        }
    }

    public static CarrefourDto getChangement(Calendar cal) throws CarrefourDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            String query = "Select * from Changement where date <= ?";
            java.sql.PreparedStatement stmt = connexion.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setLong(1, cal.getTimeInMillis() / 1000);
            java.sql.ResultSet rs = stmt.executeQuery();
            if (rs.last()) {
                if (rs.getInt("panne") == 0) {
                    FeuPieton feuPNS = new FeuPieton();
                    feuPNS.setEtat((CouleurEnum.valueOf(rs.getString("feuPNS")).equals(CouleurEnum.ORANGE)) ? CouleurEnum.VERT : CouleurEnum.valueOf(rs.getString("feuPNS")));
                    if (CouleurEnum.valueOf(rs.getString("feuPNS")).equals(CouleurEnum.ORANGE)) {
                        feuPNS.setEtat(true);
                    }
                    FeuPieton feuPEO = new FeuPieton();
                    feuPEO.setEtat((CouleurEnum.valueOf(rs.getString("feuPEO")).equals(CouleurEnum.ORANGE)) ? CouleurEnum.VERT : CouleurEnum.valueOf(rs.getString("feuPEO")));
                    if (CouleurEnum.valueOf(rs.getString("feuPEO")).equals(CouleurEnum.ORANGE)) {
                        feuPEO.setEtat(true);
                    }
                    FeuVoiture feuVNS = new FeuVoiture();
                    feuPNS.setEtat(CouleurEnum.valueOf(rs.getString("feuVNS")));

                    FeuVoiture feuVEO = new FeuVoiture();
                    feuPNS.setEtat(CouleurEnum.valueOf(rs.getString("feuVEO")));

                    return new CarrefourDto(feuPNS, feuPEO, feuVNS, feuVEO);
                } else {
                    return new CarrefourDto(true);
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new CarrefourDbException("getChangement: " + ex.getMessage());
        }
    }

    public static ParametresDto getParametres(Calendar cal) throws CarrefourDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            String query = "Select * from Parametre where date <= ?";
            java.sql.PreparedStatement stmt = connexion.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setLong(1, cal.getTimeInMillis() / 1000);
            java.sql.ResultSet rs = stmt.executeQuery();
            if (rs.last()) {
                int[] dureeVert = new int[4];
                dureeVert[0] = rs.getInt("VertFeuPNS");
                dureeVert[1] = rs.getInt("VertFeuPEO");
                dureeVert[2] = rs.getInt("VertFeuVNS");
                dureeVert[3] = rs.getInt("VertFeuVEO");
                int[] dureeOrange = new int[4];
                dureeOrange[0] = rs.getInt("OrangeFeuPNS");
                dureeOrange[1] = rs.getInt("OrangeFeuPEO");
                dureeOrange[2] = rs.getInt("OrangeFeuVNS");
                dureeOrange[3] = rs.getInt("OrangeFeuVEO");
                int[] dureeRouge = new int[4];
                dureeRouge[0] = rs.getInt("RougeFeuPNS");
                dureeRouge[1] = rs.getInt("RougeFeuPEO");
                dureeRouge[2] = rs.getInt("RougeFeuVNS");
                dureeRouge[3] = rs.getInt("RougeFeuVEO");
                return new ParametresDto(dureeVert, dureeOrange, dureeRouge, rs.getInt("tousRouge"));
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new CarrefourDbException("getChangement: " + ex.getMessage());
        }
    }
}
