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
    private EtatFeu etat;
    
    public FeuPieton(){
        rouge=1;
        vert=1;
        clignotement=3;
        enPanne=true;
        etat=new EtatFeu(CouleurEnum.ROUGE, true);
    }

    public FeuPieton( int vert, int clignottement,int rouge) {
        this.rouge = rouge;
        this.vert = vert;
        this.clignotement = clignottement;
        this.enPanne=true;
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
