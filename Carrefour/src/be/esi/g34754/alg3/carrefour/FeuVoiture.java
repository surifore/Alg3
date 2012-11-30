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
public class FeuVoiture  implements Serializable{
    /**
     * La durée en minu
     */
    private int rouge;
    private int orange;
    private int vert;
    private boolean enPanne;
    private EtatFeu etat;

    public FeuVoiture() {
        this.rouge = 1;
        this.orange = 1;
        this.vert = 1;
        this.enPanne = true;
        etat=new EtatFeu(CouleurEnum.ROUGE, true);
    }

    public FeuVoiture(int vert, int orange, int rouge) {
        this.rouge = rouge;
        this.orange = orange;
        this.vert = vert;
        this.enPanne = true;
        etat=new EtatFeu(CouleurEnum.ROUGE, true);
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

    /**
     * @return the etat
     */
    public EtatFeu getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(EtatFeu etat) {
        this.etat = etat;
    }
    
    /**
     * @param etat the etat to set
     */
    public void setEtat(CouleurEnum color) {
        etat.setCouleur(color);
    }

    void setClignotant(boolean b) {
        etat.setClignotant(b);
    }
    
}
