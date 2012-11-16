/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

/**
 *
 * @author g34754
 */
public class FeuVoiture {
    /**
     * La durée en minu
     */
    private int rouge;
    private int orange;
    private int vert;
    private boolean enPanne;

    public FeuVoiture() {
        this.rouge = 1;
        this.orange = 1;
        this.vert = 1;
        this.enPanne = false;
    }

    public FeuVoiture(int rouge, int orange, int vert, boolean clignote) {
        this.rouge = rouge;
        this.orange = orange;
        this.vert = vert;
        this.enPanne = clignote;
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
     * @return the orange
     */
    public int getOrange() {
        return orange;
    }

    /**
     * @param orange the orange to set
     */
    public void setOrange(int orange) {
        this.orange = orange;
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

    /**
     * @return the clignote
     */
    public boolean isEnPanne() {
        return enPanne;
    }

    /**
     * @param enPanne the clignote to set
     */
    public void setEnPanne(boolean enPanne) {
        this.enPanne = enPanne;
    }
}
