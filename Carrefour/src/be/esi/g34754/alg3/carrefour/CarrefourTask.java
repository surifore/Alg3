/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import be.esi.g34754.alg3.carrefour.interfaces.CarrefourServeurInterface;
import java.rmi.RemoteException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g34754
 */
public class CarrefourTask extends TimerTask {

    private Etat etat;
    private int[] restant;
    private CarrefourServeurInterface serveur;

    public CarrefourTask(Etat etat,CarrefourServeurInterface serveur) {
        this.serveur=serveur;
        this.etat=etat;
        etat.setFeuxP_NS(new EtatFeu(CouleurEnum.ROUGE, false));
        etat.setFeuxV_NS(new EtatFeu(CouleurEnum.VERT, false));
        etat.setFeuxP_EO(new EtatFeu(CouleurEnum.VERT, false));
        etat.setFeuxV_EO(new EtatFeu(CouleurEnum.ROUGE, false));
        restant= new int[4];
        restant[0]=etat.getFeuxP_NS().getRouge();
        restant[1]=etat.getFeuxV_NS().getVert();
        restant[2]=etat.getFeuxP_EO().getVert();
        restant[3]=etat.getFeuxV_EO().getRouge();
    }

    //TODO vérifier que pas erreur dans carrefour avant de faire fire et si incorrect met tt en panne
    @Override
    public void run() {
        restant[0]=mAJ(etat.getFeuxP_NS(),restant[0]);
        restant[1]=mAJ(etat.getFeuxP_EO(),restant[1]);
        restant[2]=mAJ(etat.getFeuxV_NS(),restant[2]);
        restant[3]=mAJ(etat.getFeuxV_EO(),restant[3]);
        try {
            serveur.notifierChangement();
        } catch (RemoteException ex) {
            Logger.getLogger(CarrefourTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(etat);
    }

    private int mAJ(Feu feu,int restant) {
        if(!feu.isEnPanne()){
            if(restant==0){
                restant=feu.setEtatSuivant();
            }
            restant--;
        }
        return restant;
    }
}
