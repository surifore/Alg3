/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.util.List;

/**
 *
 * @author g34754
 */
public class FeuModel {
    private FeuPieton feuxP[];
    private FeuVoiture feuxV[];
    private List<CarrefourView> listeners;

    public FeuModel() {
        feuxP=new FeuPieton[2];
        feuxV=new FeuVoiture[2];
    }
    
    
    
    
}
