/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import be.esi.g34754.alg3.carrefour.interfaces.CarrefourServeurInterface;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author g34754
 */
public class FeuModel implements Serializable {

    private List<CarrefourView> vues;
    private Etat etat;
    private TimerCarrefour demarrage;

    public FeuModel() {
        etat = new Etat();
        vues = new ArrayList<CarrefourView>();
        demarrage = new TimerCarrefour();
    }

    public FeuModel(int vert, int orange, int rouge) {
        etat = new Etat(new FeuPieton(vert, orange, rouge), new FeuPieton(vert, orange, rouge),
                new FeuVoiture(vert, orange, rouge), new FeuVoiture(vert, orange, rouge));
        vues = new ArrayList<CarrefourView>();
        demarrage = new TimerCarrefour();
        demarrage.schedule(new CarrefourTask(etat, this), 0, 1000);
    }

    public Etat getEtat() {
        demarrage = new TimerCarrefour();
        return new Etat(etat.getFeuxP_NS(), etat.getFeuxP_EO(), etat.getFeuxV_NS(), etat.getFeuxV_EO());
    }

    public void addCarrefourListener(CarrefourView add) {
        vues.add(add);
        fire();
    }

    public void removeCarrefourListener(CarrefourView add) {
        vues.remove(add);
        fire();
    }

    public void notifierChangement() {
        fire();
    }

    private void fire() {
        for (CarrefourView vue : vues) {
            try {
                vue.notifieChangement();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Erreur lors de la communication avec le serveur",
                        "RemoteException", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void setStop() {
        etat.getFeuxP_EO().setStop(true);
        etat.getFeuxV_EO().setStop(true);
        etat.getFeuxP_NS().setStop(true);
        etat.getFeuxV_NS().setStop(true);
    }

    public void setEnPanne() {
        etat.getFeuxP_EO().setEnPanne(true);
        etat.getFeuxV_EO().setEnPanne(true);
        etat.getFeuxP_NS().setEnPanne(true);
        etat.getFeuxV_NS().setEnPanne(true);
        fire();
    }

    public void setFeux(CarrefourDto c) {
        etat.getFeuxP_EO().setFeux(c.getpEOVert(),c.getpEOOrange(),c.getpEORouge());
        etat.getFeuxV_EO().setFeux(c.getvEOVert(),c.getvEOOrange(),c.getvEORouge());
        etat.getFeuxP_NS().setFeux(c.getpNSVert(),c.getpNSOrange(),c.getpNSRouge());
        etat.getFeuxV_NS().setFeux(c.getvNSVert(),c.getvNSOrange(),c.getvNSRouge());
    }

    public void start(int value) {
        demarrage.schedule(new CarrefourTask(etat, this), 0, value*1000);
    }
}
