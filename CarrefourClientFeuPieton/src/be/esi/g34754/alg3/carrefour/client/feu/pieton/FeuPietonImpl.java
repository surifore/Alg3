/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.client.feu.pieton;

import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Objet étant une vue du modèle
 * @author Florian Delporte
 */
class FeuPietonImpl extends UnicastRemoteObject implements CarrefourView {
    private FeuPieton parent;

    /**
     * Construit une vue du modèle
     * @param aThis la fenêtre qui construit cette vue
     * @throws RemoteException si le serveur est inaccesible
     */
    public FeuPietonImpl(FeuPieton aThis) throws RemoteException{
        this.parent=aThis;
    }

    /**
     * Permet à la vue d'être notifiée du changement d'une led
     * @throws RemoteException si le serveur est inaccesible
     */
    @Override
    public void notifieChangement() throws RemoteException {
        parent.initLed();
    }

    /**
     * Notifie à la vue que tous les feux sont au rouge
     * @throws RemoteException si le serveur est inaccesible
     */
    @Override
    public void notifieTousRouge() throws RemoteException {
    }

//    @Override
//    public boolean isFeu() throws RemoteException {
//        return true;
//    }
    
}
