/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

/**
 * Les couleurs possibles pour un Feu.
 * @author Florian Delporte
 */
public enum CouleurEnum {
    VERT, ORANGE, ROUGE;

    /**
     * Permet de renvoyer le numéro de la couleur
     * @param couleur la couleur du Feu
     * @return le numéro de la couleur
     */
    public static short shortValueOf(CouleurEnum couleur) {
        switch (couleur) {
            case VERT:
                return 0;
            case ORANGE:
                return 1;
            case ROUGE:
                return 2;
            default:
                throw new IllegalArgumentException("Valeur d'énumération incorrecte.");
        }
    }
}
