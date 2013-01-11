/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

/**
 *
 * @author g34754
 */
public enum CouleurEnum {

    VERT, ORANGE, ROUGE;

    public static short shortValueOf(String toString) {
        switch (toString) {
            case "VERT":
                return 0;
            case "ORANGE":
                return 1;
            case "ROUGE":
                return 2;
            default:
                throw new IllegalArgumentException("Valeur d'énumération incorrecte.");
        }
    }
}
