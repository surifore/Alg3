/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.serveur;

import be.esi.g34754.alg3.carrefour.FeuModel;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourServeurInterface;
import java.io.Serializable;

/**
 *
 * @author g34754
 */
class CarrefourServeurImpl implements CarrefourServeurInterface,Serializable {
    
    private FeuModel feux;

    public CarrefourServeurImpl() {
        feux=new FeuModel(5,2,8);
    }
    
}
