/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;

/**
 *
 * @author g34754
 */
public interface FeuModeleInterface {

    /**
     * retourne à la vue l'état du modèle
     */
    public Etat getEtat();

    /**
     * permet à la vue de s'abonner en tant qu'observateur du modèle
     */
    public void addCarrefourListener(CarrefourView add);

    /**
     * permet à la vue de se désabonner en tant qu'observateur du modèle
     */
    public void removeCarrefourListener(CarrefourView add);

    /**
     * Permet de notifier le changement du modèle
     * @param changementEtat si un changement de l'état du Carrefour a eu lieu
     */
    public void notifierChangement();

    /**
     * Permet de mettre le carrefour en panne
     */
    public void setEnPanne();

    /**
     * retourne la vitesse d'exécution du carrefour
     * @return la vitesse d'exécution du carrefour
     */
    public int getVitesse();

    /**
     * Démarre l'exécution du carrefour
     */
    public void demarrer(boolean principal);

    
    /**
     * Rafraichit le modèle
     */
    public void refresh();

    /**
     * Passe tous les feux du modèle au rouge
     */
    public void setStop();

    /**
     * Modifie la durée durant laquelle tous les feux sont au rouge
     * @param value 
     */
    public void setTousRouge(int value);    

    /**
     * Permet d'arrêter les feux du carrefour
     */
    public void setArret();

    /**
     * Permet d'arrêter l'exécution du carrefour
     */
    public void arreter();

    /**
     * Permet de demander au feu pieton d'un certai axe de passer au vert
     * @param axeNS l'axe sur lequel le feu doit passer au vert
     */
    public void demandeVert(boolean axeNS);
}
