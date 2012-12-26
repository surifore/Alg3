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
public class FeuPieton extends Feu implements Serializable{
    
    public FeuPieton(){
        rouge=1;
        vert=1;
        orange=3;
        enPanne=false;
        etat=new EtatFeu(CouleurEnum.ORANGE, true);
        pieton=true;
        tousRouge=1;
    }

    public FeuPieton( int vert, int orange,int rouge,int tousRouge) {
        this.rouge = rouge;
        this.vert = vert;
        this.orange = orange;
        this.enPanne=false;
        etat=new EtatFeu(CouleurEnum.ORANGE, true);
        pieton=true;
        this.tousRouge=tousRouge;
    }

    void setFeux(int vert, int orange, int rouge) {
        this.rouge = rouge;
        this.vert = vert;
        this.orange = orange;
    }
}
