/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import java.io.Serializable;

/**
 *
 * @author g34754
 */
public class FeuVoiture extends Feu implements Serializable{


    public FeuVoiture() {
        this.rouge = 1;
        this.orange = 1;
        this.vert = 1;
        this.enPanne = false;
        etat=new EtatFeu(CouleurEnum.ROUGE, true);
        pieton=false;
    }

    public FeuVoiture(int vert, int orange, int rouge) {
        this.rouge = rouge;
        this.orange = orange;
        this.vert = vert;
        this.enPanne = false;
        etat=new EtatFeu(CouleurEnum.ROUGE, true);
        pieton=false;
    }
    
}
