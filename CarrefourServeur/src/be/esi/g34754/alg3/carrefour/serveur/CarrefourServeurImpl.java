/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.serveur;

import be.esi.g34754.alg3.carrefour.FeuModel;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourServeurInterface;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author g34754
 */
class CarrefourServeurImpl extends UnicastRemoteObject implements CarrefourServeurInterface {
    
    private FeuModel feux;

    public CarrefourServeurImpl() throws RemoteException{
        feux=new FeuModel(5,2,8);
    }

    @Override
    public void addListener(CarrefourView client) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FeuModel getModel() throws RemoteException {
        return feux;
    }
    
}
