/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.client.adm;

import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Classe de vue du modèle
 * @author Florian Delporte
 */
public class ClientAdmImpl extends UnicastRemoteObject implements CarrefourView{
    private ClientAdm parent;

    /**
     * Construit un objet de vue au modèle
     * @param aThis la fenêtre qui construit cet objet
     * @throws RemoteException lorsque le serveur n'est pas accessible
     */
    public ClientAdmImpl(ClientAdm aThis) throws RemoteException{
        this.parent=aThis;
    }

    /**
     * Action effectuée lorsqu'un changement du modèle est notifié
     * @throws RemoteException lorsque le serveur n'est pas accessible
     */
    @Override
    public void notifieChangement() throws RemoteException {
    }

    /**
     * Permet de modifier les paramètres du carrefour lorsque tous les feux sont au rouge
     * @throws RemoteException lorsque le serveur n'est pas accessible
     */
    @Override
    public void notifieTousRouge() throws RemoteException {
        parent.notifieTousRouge();
    }

//    /**
//     * Permet de savoir si un feu est 
//     * @return
//     * @throws RemoteException 
//     */
//    @Override
//    public boolean isFeu() throws RemoteException {
//        return false;
//    }
}
