/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import java.io.Serializable;

/**
 * Contient l'état d'un Feu.
 * @author Florian Delporte
 */
public class EtatFeu  implements Serializable{
    private CouleurEnum couleur;
    private boolean clignotant;

    /**
     * Construit l'état du Feu
     * @param couleur la couleur du Feu à attribuer
     * @param clignotant Le clignottement du feu
     */
    public EtatFeu(CouleurEnum couleur, boolean clignotant) {
        this.couleur = couleur;
        this.clignotant = clignotant;
    }

    /**
     * Renvoie la couleur du feu
     * @return la couleur du feu
     */
    public CouleurEnum getCouleur() {
        return couleur;
    }

    /**
     * Modifie la couleur du feu
     * @param couleur la couleur du Feu à attribuer
     */
    public void setCouleur(CouleurEnum couleur) {
        this.couleur = couleur;
    }

    /**
     * Renvoie le clignottement du Feu
     * @return le clignottement du feu
     */
    public boolean isClignotant() {
        return clignotant;
    }

    /**
     * Modifie le clignottement du feu
     * @param clignotant le clignottement du feu
     */
    public void setClignotant(boolean clignotant) {
        this.clignotant = clignotant;
    }
    
    
}
