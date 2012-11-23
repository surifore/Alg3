/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

/**
 *
 * @author g34754
 */
public class EtatFeu {
    private CouleurEnum couleur;
    private boolean clignotant;

    public EtatFeu(CouleurEnum couleur, boolean clignottant) {
        this.couleur = couleur;
        this.clignotant = clignottant;
    }

    /**
     * @return the couleur
     */
    public CouleurEnum getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(CouleurEnum couleur) {
        this.couleur = couleur;
    }

    /**
     * @return the clignottant
     */
    public boolean isClignotant() {
        return clignotant;
    }

    /**
     * @param clignotant the clignottant to set
     */
    public void setClignotant(boolean clignotant) {
        this.clignotant = clignotant;
    }
    
    
}
