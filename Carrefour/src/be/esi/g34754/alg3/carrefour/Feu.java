/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import java.io.Serializable;

/**
 * Classe d'un Feu du carrefour
 * @author Florian Delporte
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

    /**
     * Permet à un feu d'être mis à l'état suivant.
     * @return la durée de l'état suivant.
     */
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
     * Retourne la durée de la durée du feu rouge
     * @return la durée de la durée du feu rouge
     */
    public int getRouge() {
        return rouge;
    }

    /**
     * Modifie la durée du feu rouge
     * @param rouge the rouge to set
     */
    public void setRouge(int rouge) {
        this.rouge = rouge;
    }

    /**
     * Retourne la durée de la durée du feu vert
     * @return la durée de la durée du feu vert
     */
    public int getVert() {
        return vert;
    }

    /**
     * Modifie la durée du feu vert
     * @param rouge the vert to set
     */
    public void setVert(int vert) {
        this.vert = vert;
    }

    /**
     * Retourne la durée de la durée du feu orange
     * @return la durée de la durée du feu orange
     */
    public int getOrange() {
        return orange;
    }

    /**
     * Modifie la durée du feu orange
     * @param rouge the orange to set
     */
    public void setOrange(int orange) {
        this.orange = orange;
    }

    /**
     * Permet de savoir si un feu est en panne
     * @return si un feu est en panne
     */
    public boolean isEnPanne() {
        return enPanne;
    }

    /**
     * Permet de mettre un feu en panne
     * @param enPanne la valeur à attribuer au feu.
     */
    public void setEnPanne(boolean enPanne) {
        this.enPanne = enPanne;
    }

    /**
     * Permet de savoir si un feu est un feu pieton
     * @return si un feu est un feu pieton
     */
    public boolean isPieton() {
        return pieton;
    }

    /**
     * modifie le type de feu
     * @param pieton le type de feu.
     */
    public void setPieton(boolean pieton) {
        this.pieton = pieton;
    }

    /**
     * Permet de récupérer l'état d'un feu
     * @return l'état du feu
     */
    public EtatFeu getEtat() {
        return etat;
    }

    /**
     * Modifie l'état d'un feu
     * @param etat l'état du feu à attribuer
     */
    public void setEtat(EtatFeu etat) {
        this.etat = etat;
    }
    
    /**
     * Modifie la couleur du feu
     * @param etat la couleur du feu
     */
    public void setEtat(CouleurEnum color) {
        etat.setCouleur(color);
    }
    
    /**
     * Modifie le clignotement du feu
     * @param etat le clignotement du feu     
     */
    public void setEtat(boolean clignotant) {
        etat.setClignotant(clignotant);
    }
    
    /**
     * Permet de savoir si le feu est à arrêter
     * @return savoir si le feu est à arrêter
     */
    public boolean isStop() {
        return stop;
    }

    /**
     * Permet d'arrêter le feu
     * @param stop arrêter le feu
     */
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    /**
     * Retourne la durée où tous les feux sont au rouge
     * @return la durée où tous les feux sont au rouge
     */
    public int getTousRouge() {
        return tousRouge;
    }

    /**
     * Modifie la durée où tous les feux sont au rouge
     * @param tousRouge la durée où tous les feux sont au rouge à attribuer
     */
    public void setTousRouge(int tousRouge) {
        this.tousRouge = tousRouge;
    }

}
