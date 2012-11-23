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
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author g34754
 */
public class FeuModel implements FeuModeleInterface, Serializable {
    
    private List<CarrefourView> vues;
    private Etat etat;
    private Timer demarrage;

    public FeuModel() {
        etat=new Etat();
        vues=new ArrayList<CarrefourView>();
        demarrage=new Timer();
        demarrage.schedule(new CarrefourTask(etat),0,1000);
    }

    public FeuModel(int vert, int orange, int rouge) {
        etat=new Etat(new FeuPieton(vert, orange, rouge), new FeuPieton(vert, orange, rouge),
                new FeuVoiture(vert, orange, rouge), new FeuVoiture(vert,orange,rouge));
        vues=new ArrayList<CarrefourView>();
        demarrage=new Timer();
        demarrage.schedule(new CarrefourTask(etat),0,1000);
    }

    @Override
    public Etat getEtat() {
        demarrage=new Timer();
        return new Etat(etat.getFeuxP_NS(),etat.getFeuxP_EO(),etat.getFeuxV_NS(),etat.getFeuxV_EO());
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

    private void fire(){
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
    
    
}
