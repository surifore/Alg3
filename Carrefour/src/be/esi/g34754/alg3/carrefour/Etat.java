package be.esi.g34754.alg3.carrefour;

import java.io.Serializable;

/**
 * État des feux. Cet état peut transiter du modèle à une vue.
 *
 * Il s'agit d'un DTO (data transfer Object) dont le seul rôle est le stockage de données en vue de transfert.
 * 
 */
public class Etat implements Serializable{
    private FeuPieton feuxP_NS;
    private FeuPieton feuxP_EO;
    private FeuVoiture feuxV_NS;
    private FeuVoiture feuxV_EO;

    public Etat() {
        this.feuxP_NS = new FeuPieton();
        this.feuxP_EO = new FeuPieton();
        this.feuxV_NS = new FeuVoiture();
        this.feuxV_EO = new FeuVoiture();
    }

    public Etat(FeuPieton feuxP_NS, FeuPieton feuxP_EO, FeuVoiture feuxV_NS, FeuVoiture feuxV_EO) {
        this.feuxP_NS = feuxP_NS;
        this.feuxP_EO = feuxP_EO;
        this.feuxV_NS = feuxV_NS;
        this.feuxV_EO = feuxV_EO;
    }

    /**
     * @return the feuxP_NS
     */
    public FeuPieton getFeuxP_NS() {
        return feuxP_NS;
    }

    /**
     * @param feuxP_NS the feuxP_NS to set
     */
    public void setFeuxP_NS(EtatFeu etat) {
        this.feuxP_NS.setEtat(etat);
    }

    /**
     * @return the feuxP_EO
     */
    public FeuPieton getFeuxP_EO() {
        return feuxP_EO;
    }

    /**
     * @param feuxP_EO the feuxP_EO to set
     */
    public void setFeuxP_EO(EtatFeu etat) {
        this.feuxP_EO.setEtat(etat);
    }

    /**
     * @return the feuxV_NS
     */
    public FeuVoiture getFeuxV_NS() {
        return feuxV_NS;
    }

    /**
     * @param feuxV_NS the feuxV_NS to set
     */
    public void setFeuxV_NS(EtatFeu etat) {
        this.feuxV_NS.setEtat(etat);
    }

    /**
     * @return the feuxV_EO
     */
    public FeuVoiture getFeuxV_EO() {
        return feuxV_EO;
    }

    /**
     * @param feuxV_EO the feuxV_EO to set
     */
    public void setFeuxV_EO(EtatFeu etat) {
        this.feuxV_EO.setEtat(etat);
    }
    
    public String toString(){
        String str= "Etat du carrefour\n";
        str+=       "-----------------\n";
        str+=       "Axe Nord-Sud:\n";
        str+=       "-------------\n";
        str+=       "Feu voiture:" + feuxV_NS.getEtat().getCouleur() + " " 
                + (feuxV_NS.getEtat().isClignotant()?"clignotant\n":"\n");
        str+=       "Feu pieton:" + feuxP_NS.getEtat().getCouleur() + " " 
                + (feuxP_NS.getEtat().isClignotant()?"clignotant\n":"\n");
        str+=       "Axe Est-Ouest:\n";
        str+=       "--------------\n";
        str+=       "Feu voiture:" + feuxV_EO.getEtat().getCouleur() + " " 
                + (feuxV_EO.getEtat().isClignotant()?"clignotant\n":"\n");
        str+=       "Feu pieton:" + feuxP_EO.getEtat().getCouleur() + " " 
                + (feuxP_EO.getEtat().isClignotant()?"clignotant\n":"\n");
        return str;
    }

}
