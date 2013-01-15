/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.dto;

import be.esi.g34754.alg3.carrefour.Feu;
import be.esi.g34754.alg3.carrefour.FeuPieton;
import be.esi.g34754.alg3.carrefour.FeuVoiture;

/**
 *
 * @author Florian
 */
public class CarrefourDto {
    
    private Feu[] feux;
    private boolean enPanne;

    public CarrefourDto(Feu[] feux) {
        this.feux = feux;
    }

    public CarrefourDto(boolean enPanne) {
        this.enPanne = enPanne;
    }
    
    public CarrefourDto(FeuPieton feuPNS,FeuPieton feuPEO,FeuVoiture feuVNS,FeuVoiture feuVEO) {
        this.feux = new Feu[4];
        feux[0]=feuPNS;
        feux[1]=feuPEO;
        feux[2]=feuVNS;
        feux[3]=feuVEO;
    }

    /**
     * Get the value of feux
     *
     * @return the value of feux
     */
    public Feu getFeu(int i) {
        return feux[i];
    }

    /**
     * Set the value of feux
     *
     * @param feux new value of feux
     */
    public void setFeux(int i,Feu feu) {
        this.feux[i] = feu;
    }

    public boolean isEnPanne() {
        return enPanne;
    }

    public void setEnPanne(boolean enPanne) {
        this.enPanne = enPanne;
    }
    
}
