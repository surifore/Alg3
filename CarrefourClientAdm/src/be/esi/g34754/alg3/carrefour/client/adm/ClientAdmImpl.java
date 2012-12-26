/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.client.adm;

import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author g34754
 */
public class ClientAdmImpl extends UnicastRemoteObject implements CarrefourView{
    private ClientAdm parent;

    public ClientAdmImpl(ClientAdm aThis) throws RemoteException{
        this.parent=aThis;
    }

    @Override
    public void notifieChangement() throws RemoteException {
    }

    @Override
    public void notifieTousRouge() throws RemoteException {
        parent.notifieTousRouge();
    }

    @Override
    public boolean isFeu() throws RemoteException {
        return false;
    }
}
