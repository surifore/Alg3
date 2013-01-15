/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

//import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Le modèle d'un Carrefour
 *
 * @author Florian Delporte
 */
public class FeuModel implements FeuModeleInterface, Serializable {

    private List<CarrefourView> vues;
    private Etat etat;
    private TimerCarrefour demarrage;
    private CarrefourTask tache;
    protected int vitesse;

    /**
     * Permet de créer un modèle
     *
     * @param vitesse la vitesse d'exécution du modèle
     */
    public FeuModel(int vitesse) {
        etat = new Etat();
        vues = new ArrayList<CarrefourView>();
        demarrage = new TimerCarrefour();
        this.vitesse = vitesse;
    }

    /**
     * Permet de créer un modèle
     *
     * @param vert la durée du feu vert
     * @param orange la durée du feu orange
     * @param rouge la durée du feu rouge
     * @param vitesse la vitesse d'exécution du modèle
     */
    public FeuModel(int vert, int orange, int rouge, int vitesse) {
        etat = new Etat(new FeuPieton(vert, orange, rouge, 1), new FeuPieton(vert, orange, rouge, 1),
                new FeuVoiture(vert, orange, rouge, 1), new FeuVoiture(vert, orange, rouge, 1));
        vues = new ArrayList<CarrefourView>();
        demarrage = new TimerCarrefour();
        this.vitesse = vitesse;
    }

    /**
     * Retourne l'état du carrefour
     *
     * @return l'état du carrefour
     */
    @Override
    public Etat getEtat() {
//        demarrage = new TimerCarrefour();
        return new Etat(etat.getFeuxP_NS(), etat.getFeuxP_EO(), etat.getFeuxV_NS(), etat.getFeuxV_EO());
    }

    /**
     * Permet d'ajouter une vue au modèle.
     *
     * @param add la vue à ajouter au modèle
     */
    @Override
    public void addCarrefourListener(CarrefourView add) {
        vues.add(add);
        fire();
    }

    /**
     * Permet de retirer une vue du modèle
     *
     * @param add la vue à retirer du modèle
     */
    @Override
    public void removeCarrefourListener(CarrefourView add) {
        vues.remove(add);
        fire();
    }

    /**
     * Permet au modèle de notifier un changement aux vues qui lui sont abonnées
     */
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

    /**
     * Permet de mettre tous les feux au rouge
     */
    @Override
    public void setStop() {
        etat.getFeuxP_EO().setStop(true);
        etat.getFeuxV_EO().setStop(true);
        etat.getFeuxP_NS().setStop(true);
        etat.getFeuxV_NS().setStop(true);
    }

    /**
     * Permet de mettre tous les feux en panne
     */
    @Override
    public void setEnPanne() {
        etat.getFeuxP_EO().setEnPanne(true);
        etat.getFeuxV_EO().setEnPanne(true);
        etat.getFeuxP_NS().setEnPanne(true);
        etat.getFeuxV_NS().setEnPanne(true);
        fire();
    }

    /**
     * @return the vitesse d'exécution du carrefour
     */
    @Override
    public int getVitesse() {
        return vitesse;
    }

    /**
     * Permet de démarrer l'exécution du carrefour
     */
    @Override
    public final void demarrer(boolean principal) {
        tache = new CarrefourTask(etat, this, principal);
        demarrage.schedule(tache, 0, 1000 / vitesse);
    }

    /**
     * modifie la durée pendant lequel tous les feux sont au rouge
     *
     * @param value
     */
    @Override
    public void setTousRouge(int value) {
        etat.setTousRouge(value);
    }

    /**
     * Permet de mettre tous les feux au rouge
     */
    @Override
    public void setArret() {
        tache.setArret(true);
        setStop();
    }

    /**
     * Met à jour les vues du carrefour
     */
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

    /**
     * Permet d'arrêter l'exécution du Carrefour
     */
    @Override
    public void arreter() {
        demarrage.cancel();
    }

    /**
     * Permet de demander le pâssage du feuPieton au vert
     *
     * @param axeNS l'axe sur lequel le pieton demande le passage au vert.
     */
    @Override
    public void demandeVert(boolean axeNS) {
        int restant[] = tache.getRestant();
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("../dureeFeux.properties"));
        } catch (IOException ex) {
            try {
                prop.load(new FileInputStream("dureeFeux.properties"));
            } catch (IOException ex1) {
            }
        }
        int min = Integer.parseInt(prop.getProperty("minVert", "3"));

        if (axeNS) {
            if (restant[2] > min) {
                tache.decremente(restant[2] - min);
            } else {
                tache.decremente(restant[2]);
            }
        } else if (restant[3] > min) {
            tache.decremente(restant[3] - min);
        } else {
            tache.decremente(restant[3]);
        }
    }
}
