/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author g34754
 */
public class FeuModel implements FeuModeleInterface,Serializable {

    private List<CarrefourView> vues;
    private Etat etat;
    private TimerCarrefour demarrage;
    private CarrefourTask tache;
    protected int vitesse;

    public FeuModel(int vitesse) {
        etat = new Etat();
        vues = new ArrayList<CarrefourView>();
        demarrage = new TimerCarrefour();
        this.vitesse=vitesse;
    }

    public FeuModel(int vert, int orange, int rouge,int vitesse) {
        etat = new Etat(new FeuPieton(vert, orange, rouge,1), new FeuPieton(vert, orange, rouge,1),
                new FeuVoiture(vert, orange, rouge,1), new FeuVoiture(vert, orange, rouge,1));
        vues = new ArrayList<CarrefourView>();
        demarrage = new TimerCarrefour();
        this.vitesse=vitesse;
    }

    @Override
    public Etat getEtat() {
        demarrage = new TimerCarrefour();
        return new Etat(etat.getFeuxP_NS(), etat.getFeuxP_EO(), etat.getFeuxV_NS(), etat.getFeuxV_EO());
    }

    @Override
    public void addCarrefourListener(CarrefourView add) {
        vues.add(add);
        fire();
    }

    @Override
    public void removeCarrefourListener(CarrefourView add) {
        vues.remove(add);
        fire();
    }

    @Override
    public void notifierChangement() {
        fire();
    }

    private void fire() {
        List<CarrefourView> clientCopy = new ArrayList<CarrefourView>();
        clientCopy.addAll(vues);
        for (CarrefourView vue : clientCopy) {
            try {
                vue.notifieChangement();
            } catch (RemoteException ex) {
                vues.remove(vue);
            }
        }
    }

    @Override
    public void setStop() {
        etat.getFeuxP_EO().setStop(true);
        etat.getFeuxV_EO().setStop(true);
        etat.getFeuxP_NS().setStop(true);
        etat.getFeuxV_NS().setStop(true);
    }

    @Override
    public void setEnPanne() {
        etat.getFeuxP_EO().setEnPanne(true);
        etat.getFeuxV_EO().setEnPanne(true);
        etat.getFeuxP_NS().setEnPanne(true);
        etat.getFeuxV_NS().setEnPanne(true);
        fire();
    }

    /**
     * @return the vitesse
     */
    @Override
    public int getVitesse() {
        return vitesse;
    }

    @Override
    public final void demarrer() {
        tache=new CarrefourTask(etat, this);
        demarrage.schedule(tache, 0, 1000/vitesse);
    }

    public void setTousRouge(int value) {
        etat.setTousRouge(value);
    }

    @Override
    public void setArret() {
        tache.setArret(true);
        setStop();
    }

    @Override
    public void refresh() {
        for (CarrefourView vue : vues) {
            try {
                vue.notifieTousRouge();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Erreur lors de la communication avec le serveur",
                        "RemoteException", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
