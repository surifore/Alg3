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
public interface CarrefourServeurInterface extends Remote{

    public void addListener(CarrefourView client)throws RemoteException;

    public FeuModeleInterface getModel()throws RemoteException;

    public void setModel(FeuModeleInterface model)throws RemoteException;

    public void setArret()throws RemoteException;

    public void removeListener(CarrefourView client)throws RemoteException;

    public void demandeVert(boolean axeNS)throws RemoteException;
}
