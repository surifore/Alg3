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
public abstract class Feu implements Serializable {

    protected int rouge;
    protected int vert;
    protected int orange;
    protected int tousRouge;
    protected boolean enPanne;
    protected boolean pieton;
    protected EtatFeu etat;
    protected boolean stop;

    public int setEtatSuivant() {
        int restant = -1;
        switch (etat.getCouleur()) {
            case ROUGE:
                etat.setCouleur(CouleurEnum.VERT);
                restant = getVert();
                break;
            case VERT:
                if (isPieton()&&etat.isClignotant()) {
                    etat.setClignotant(false);
                    etat.setCouleur(CouleurEnum.ROUGE);
                    restant=getRouge()+getTousRouge();
                }else if(isPieton()){
                    etat.setClignotant(true);
                    restant=getOrange();
                }else{
                    etat.setCouleur(CouleurEnum.ORANGE);                    
                    restant=getOrange();
                }break;
            case ORANGE:
                etat.setCouleur(CouleurEnum.ROUGE);
                restant=getRouge()+getTousRouge();
        }
        return restant;
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
     * @return the enPanne
     */
    public boolean isEnPanne() {
        return enPanne;
    }

    /**
     * @param enPanne the enPanne to set
     */
    public void setEnPanne(boolean enPanne) {
        this.enPanne = enPanne;
    }

    /**
     * @return the pieton
     */
    public boolean isPieton() {
        return pieton;
    }

    /**
     * @param pieton the pieton to set
     */
    public void setPieton(boolean pieton) {
        this.pieton = pieton;
    }

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
    
    /**
     * @param etat the etat to set
     */
    public void setEtat(boolean clignotant) {
        etat.setClignotant(clignotant);
    }
    
    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    /**
     * @return the tousRouge
     */
    public int getTousRouge() {
        return tousRouge;
    }

    /**
     * @param tousRouge the tousRouge to set
     */
    public void setTousRouge(int tousRouge) {
        this.tousRouge = tousRouge;
    }

}
