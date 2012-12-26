/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author g34754
 */
public interface CarrefourView extends Remote{

    public void notifieChangement()throws RemoteException;

    public void notifieTousRouge()throws RemoteException;
    
}
