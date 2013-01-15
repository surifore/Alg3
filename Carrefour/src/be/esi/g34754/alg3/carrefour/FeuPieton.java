/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import java.io.Serializable;

/**
 * Le Feu Pieton
 * @author Florian Delporte
 */
public class FeuPieton extends Feu implements Serializable{
    
    /**
     * Construit un feu pieton
     */
    public FeuPieton(){
        rouge=1;
        vert=1;
        orange=3;
        enPanne=false;
        etat=new EtatFeu(CouleurEnum.ORANGE, true);
        pieton=true;
        tousRouge=1;
    }
    
    public FeuPieton(CouleurEnum color,boolean clignotant){
        etat=new EtatFeu(color, clignotant);
    }

    /**
     * Construit un feu pieton avec les durée des différents feux.
     * @param vert la durée du vert
     * @param orange la durée de l'orange
     * @param rouge la durée du rouge
     * @param tousRouge la durée où tous les feux sont au rouge
     */
    public FeuPieton( int vert, int orange,int rouge,int tousRouge) {
        this.rouge = rouge;
        this.vert = vert;
        this.orange = orange;
        this.enPanne=false;
        etat=new EtatFeu(CouleurEnum.ORANGE, true);
        pieton=true;
        this.tousRouge=tousRouge;
    }

    /**
     * Attribue la durée des feux.
     * @param vert la durée du feu vert
     * @param orange la durée du feu orange
     * @param rouge la durée du feu rouge
     */
    void setFeux(int vert, int orange, int rouge) {
        this.rouge = rouge;
        this.vert = vert;
        this.orange = orange;
    }
}
