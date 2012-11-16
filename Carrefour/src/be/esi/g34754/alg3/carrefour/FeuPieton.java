/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

/**
 *
 * @author g34754
 */
public class FeuPieton {
    private int rouge;
    private int vert;
    private int clignotement;
    private boolean enPanne;
    
    public FeuPieton(){
        rouge=1;
        vert=1;
        clignotement=3;
    }

    public FeuPieton(int rouge, int vert, int clignottement,boolean enPanne) {
        this.rouge = rouge;
        this.vert = vert;
        this.clignotement = clignottement;
        this.enPanne=enPanne;
    }
    

    /**
     * @return the rouge
     */
    public int getRouge() {
        return rouge;
    }

    /**
     * @param rouge the rouge to set
     */
    public void setRouge(int rouge) {
        this.rouge = rouge;
    }

    /**
     * @return the vert
     */
    public int getVert() {
        return vert;
    }

    /**
     * @param vert the vert to set
     */
    public void setVert(int vert) {
        this.vert = vert;
    }

    public int getClignotement() {
        return clignotement;
    }

    public void setClignotement(int clignotement) {
        this.clignotement = clignotement;
    }

    public boolean isEnPanne() {
        return enPanne;
    }

    public void setEnPanne(boolean enPanne) {
        this.enPanne = enPanne;
    }
}
