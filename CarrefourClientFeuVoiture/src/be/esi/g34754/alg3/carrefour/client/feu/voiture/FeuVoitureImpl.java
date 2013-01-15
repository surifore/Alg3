/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.client.feu.voiture;

import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author g34754
 */
public class FeuVoitureImpl extends UnicastRemoteObject implements CarrefourView {
    private FeuVoiture parent;

    public FeuVoitureImpl(FeuVoiture aThis) throws RemoteException{
        this.parent=aThis;
    }

    @Override
    public void notifieChangement() throws RemoteException {
        parent.initLed();
    }

    @Override
    public void notifieTousRouge() throws RemoteException {        
    }

//    @Override
//    public boolean isFeu() throws RemoteException {
//        return true;
//    }
}
