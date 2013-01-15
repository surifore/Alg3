/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import java.io.Serializable;

/**
 * Gestion d'un feu voiture
 * @author Florian Delporte
 */
public class FeuVoiture extends Feu implements Serializable{

    /**
     * Construit un feu voiture
     */
    public FeuVoiture() {
        this.rouge = 1;
        this.orange = 1;
        this.vert = 1;
        this.enPanne = false;
        etat=new EtatFeu(CouleurEnum.ROUGE, true);
        pieton=false;
        this.tousRouge=1;
    }
    
    public FeuVoiture(CouleurEnum color,boolean enPanne){
        etat=new EtatFeu(color, enPanne);
    }

    /**
     * Construit un feu Voiture
     * @param vert la durée du vert
     * @param orange la durée de l'orange
     * @param rouge la durée du rouge
     * @param tousRouge la durée où tous les feux sont au rouge.
     */
    public FeuVoiture(int vert, int orange, int rouge,int tousRouge) {
        this.rouge = rouge;
        this.orange = orange;
        this.vert = vert;
        this.enPanne = false;
        etat=new EtatFeu(CouleurEnum.ROUGE, true);
        pieton=false;
        this.tousRouge=tousRouge;
    }

    /**
     * Modifie les durée des feux
     * @param vert la durée du vert
     * @param orange la durée de l'orange
     * @param rouge la durée du rouge
     */
    void setFeux(int vert, int orange, int rouge) {
        this.rouge = rouge;
        this.vert = vert;
        this.orange = orange;
    }
    
}
