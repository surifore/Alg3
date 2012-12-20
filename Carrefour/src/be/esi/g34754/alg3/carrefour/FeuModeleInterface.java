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
    
    public void notifierChangement();

    public void setEnPanne();

    public int getVitesse();
}
