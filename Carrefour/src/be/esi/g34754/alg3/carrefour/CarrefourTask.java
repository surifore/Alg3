/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import be.esi.g34754.alg3.carrefour.db.CarrefourDB;
import be.esi.g34754.alg3.carrefour.db.CarrefourDbException;
import java.awt.HeadlessException;
import java.io.Serializable;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 * Classe permettant au timer de mettre à jour l'état du Carrefour
 *
 * @author Florian Delporte
 */
public class CarrefourTask extends TimerTask implements Serializable {

    private Etat etat;
    private int[] restant;
    private FeuModeleInterface model;
    protected boolean arret;
    private boolean modelPrincipal;
    private boolean changementEtat;

    /**
     * Construit une tâche pour la mise à jour du carrefour
     *
     * @param etat L'état du modèle
     * @param model le modèle à observer
     */
    public CarrefourTask(Etat etat, FeuModeleInterface model, boolean principal) {
        this.model = model;
        this.etat = etat;
        this.arret = false;
        this.modelPrincipal = principal;
        etat.setFeuxP_NS(new EtatFeu(CouleurEnum.ROUGE, false));
        etat.setFeuxV_NS(new EtatFeu(CouleurEnum.VERT, false));
        etat.setFeuxP_EO(new EtatFeu(CouleurEnum.VERT, false));
        etat.setFeuxV_EO(new EtatFeu(CouleurEnum.ROUGE, false));
        restant = new int[4];
        restant[0] = etat.getFeuxP_NS().getRouge();
        restant[1] = etat.getFeuxV_NS().getVert();
        restant[2] = etat.getFeuxP_EO().getVert();
        restant[3] = etat.getFeuxV_EO().getRouge();
        changementEtat = false;
    }

    //TODO vérifier que pas erreur dans carrefour avant de faire fire et si incorrect met tt en panne
    /**
     * La mise à jour à effectuer sur le Carrefour
     */
    @Override
    public void run() {
        if (!etat.isEnPanne()) {
            if ((etat.getFeuxP_NS().isStop() && etat.getFeuxP_NS().etat.getCouleur().equals(CouleurEnum.ROUGE))
                    && (etat.getFeuxV_NS().isStop() && etat.getFeuxV_NS().etat.getCouleur().equals(CouleurEnum.ROUGE))
                    && (etat.getFeuxP_EO().isStop() && etat.getFeuxP_EO().etat.getCouleur().equals(CouleurEnum.ROUGE))
                    && (etat.getFeuxV_EO().isStop() && etat.getFeuxV_EO().etat.getCouleur().equals(CouleurEnum.ROUGE))) {
                if (!isArret()) {
                    model.setEnPanne();
                    arret = false;
                    EcritDB();
                } else {
                    model.refresh();
                    arret = false;
                    etat.getFeuxP_EO().setStop(false);
                    etat.getFeuxV_EO().setStop(false);
                    etat.getFeuxP_NS().setStop(false);
                    etat.getFeuxV_NS().setStop(false);
                    EcritDB();
                }
            } else {
                restant[0] = mAJ(etat.getFeuxP_NS(), restant[0]);
                restant[1] = mAJ(etat.getFeuxP_EO(), restant[1]);
                restant[2] = mAJ(etat.getFeuxV_NS(), restant[2]);
                restant[3] = mAJ(etat.getFeuxV_EO(), restant[3]);
                model.notifierChangement();
                if (changementEtat) {
                    EcritDB();
                }
                changementEtat = false;
            }
        }
    }

    private int mAJ(Feu feu, int restant) {
        if (!feu.isEnPanne()) {
            if (!feu.isStop()) {
                if (restant == 0) {
                    restant = feu.setEtatSuivant();
                    changementEtat = true;
                }
                restant--;
            } else if (!feu.etat.getCouleur().equals(CouleurEnum.ROUGE)) {
                if (feu.etat.getCouleur().equals(CouleurEnum.VERT)) {
                    restant = 0;
                }
                if (restant == 0) {
                    restant = feu.setEtatSuivant();
                    changementEtat = true;
                }
                restant--;
            }
        }
        return restant;
    }

    /**
     * Si la tâche doit être arrêtée
     *
     * @return Si la tâche doit être arrêtée
     */
    public boolean isArret() {
        return arret;
    }

    /**
     * Permet d'arrêter la mise à jour du Carrefour
     *
     * @param arret Permet d'arrêter la mise à jour du Carrefour
     */
    public void setArret(boolean arret) {
        this.arret = arret;
    }

    /**
     * Permet de récupérer le temps restant pour chaque feu.
     *
     * @return le temps restant pour chaque feu.
     */
    int[] getRestant() {
        return restant;
    }

    /**
     * Permet de diminuer le temps de l'ensemble du Carrefour.
     *
     * @param decrement le temps à décrémenter au temps total du Carrefour.
     */
    void decremente(int decrement) {
        for (int i = 0; i < 4; i++) {
            for (int j = decrement; i > 0; restant[i]--) {
                if (restant[i] == 0) {
                    restant[i] = etat.getFeu(i).setEtatSuivant();
                }
            }
        }
    }

    private void EcritDB() throws HeadlessException {
        if (modelPrincipal) {
            try {
                CarrefourDB.saveChangement(etat);
            } catch (CarrefourDbException ex) {
                try {
                    CarrefourDB.saveAlerte("CarrefourDBException:\n" + ex.getMessage());
                } catch (CarrefourDbException ex1) {
                    JOptionPane.showMessageDialog(null, "Accès à la base de donnée impossible",
                            "Database Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
