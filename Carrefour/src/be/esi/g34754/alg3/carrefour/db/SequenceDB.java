/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.db;

/**
 * Classe d'accès au gestionnaire de persistance pour les Séquences
 */
public class SequenceDB {

    static final String CHANGEMENT = "Changement", PARAMETRE = "Parametre", ALERTES = "Alertes";

    static synchronized int getNumSuivant(String sequence) throws CarrefourDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            String query = "Update SEQUENCE set SEQ_COUNT= SEQ_COUNT+1 where SEQ_NAME='" + sequence + "'";
            java.sql.PreparedStatement update = connexion.prepareStatement(query);
            update.execute();
            java.sql.Statement stmt = connexion.createStatement();
            query = "Select SEQ_COUNT FROM Sequence where SEQ_NAME='" + sequence + "'";
            java.sql.ResultSet rs = stmt.executeQuery(query);
            int nvId;
            if (rs.next()) {
                nvId = rs.getInt("SEQ_COUNT");
                return nvId;
            } else {
                throw new CarrefourDbException("Nouveau n° de séquence inaccessible!");
            }
        } catch (java.sql.SQLException eSQL) {
            throw new CarrefourDbException("Nouveau n° de séquence inaccessible!\n" + eSQL.getMessage());
        }

    }
}
