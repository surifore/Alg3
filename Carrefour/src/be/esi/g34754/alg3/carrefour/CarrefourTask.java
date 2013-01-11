/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import be.esi.g34754.alg3.carrefour.database.CarrefourDB;
import be.esi.g34754.alg3.carrefour.entity.ChangementFeu;
import be.esi.g34754.alg3.carrefour.interfaces.FeuModeleInterface;
import java.io.Serializable;
import java.util.TimerTask;

/**
 *
 * @author g34754
 */
public class CarrefourTask extends TimerTask implements Serializable {

    private Etat etat;
    private int[] restant;
    private FeuModeleInterface model;
    protected boolean arret;

    public CarrefourTask(Etat etat, FeuModeleInterface model) {
        this.model = model;
        this.etat = etat;
        this.arret = false;
        etat.setFeuxP_NS(new EtatFeu(CouleurEnum.ROUGE, false));
        etat.setFeuxV_NS(new EtatFeu(CouleurEnum.VERT, false));
        etat.setFeuxP_EO(new EtatFeu(CouleurEnum.VERT, false));
        etat.setFeuxV_EO(new EtatFeu(CouleurEnum.ROUGE, false));
        restant = new int[4];
        restant[0] = etat.getFeuxP_NS().getRouge();
        restant[1] = etat.getFeuxV_NS().getVert();
        restant[2] = etat.getFeuxP_EO().getVert();
        restant[3] = etat.getFeuxV_EO().getRouge();
    }

    //TODO vérifier que pas erreur dans carrefour avant de faire fire et si incorrect met tt en panne
    @Override
    public void run() {
        if ((etat.getFeuxP_NS().isStop() && etat.getFeuxP_NS().etat.getCouleur().equals(CouleurEnum.ROUGE))
                && (etat.getFeuxV_NS().isStop() && etat.getFeuxV_NS().etat.getCouleur().equals(CouleurEnum.ROUGE))
                && (etat.getFeuxP_EO().isStop() && etat.getFeuxP_EO().etat.getCouleur().equals(CouleurEnum.ROUGE))
                && (etat.getFeuxV_EO().isStop() && etat.getFeuxV_EO().etat.getCouleur().equals(CouleurEnum.ROUGE)))
            if (!isArret()) {
                model.setEnPanne();
                arret = false;
            } else {
                model.refresh();
                arret = false;
                etat.getFeuxP_EO().setStop(false);
                etat.getFeuxV_EO().setStop(false);
                etat.getFeuxP_NS().setStop(false);
                etat.getFeuxV_NS().setStop(false);
            }
        else {
            restant[0] = mAJ(etat.getFeuxP_NS(), restant[0]);
            restant[1] = mAJ(etat.getFeuxP_EO(), restant[1]);
            restant[2] = mAJ(etat.getFeuxV_NS(), restant[2]);
            restant[3] = mAJ(etat.getFeuxV_EO(), restant[3]);
            model.notifierChangement();
        }
    }

    private int mAJ(Feu feu, int restant) {
        if (!feu.isEnPanne())
            if (!feu.isStop()) {
                if (restant == 0) {
                    restant = feu.setEtatSuivant();
                    new CarrefourDB().saveChangement(new ChangementFeu(etat));
                }
                restant--;
            } else if (!feu.etat.getCouleur().equals(CouleurEnum.ROUGE)) {
                if (feu.etat.getCouleur().equals(CouleurEnum.VERT))
                    restant = 0;
                if (restant == 0){
                    restant = feu.setEtatSuivant();
                    new CarrefourDB().saveChangement(new ChangementFeu(etat));
                }
                restant--;
            }
        return restant;
    }

    /**
     * @return the arret
     */
    public boolean isArret() {
        return arret;
    }

    /**
     * @param arret the arret to set
     */
    public void setArret(boolean arret) {
        this.arret = arret;
    }

    int[] getRestant() {
        return restant;
    }

    void decremente(int decrement) {
        for (int i = 0; i < 4; i++) {
            restant[i] -= decrement;
        }
    }
}
