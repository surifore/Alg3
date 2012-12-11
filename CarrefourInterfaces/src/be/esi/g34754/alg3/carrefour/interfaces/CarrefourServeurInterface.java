/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.interfaces;

import be.esi.g34754.alg3.carrefour.FeuModel;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author g34754
 */
public interface CarrefourServeurInterface extends Remote{

    public void addListener(CarrefourView client)throws RemoteException;

    public FeuModel getModel()throws RemoteException;

    public void notifierChangement()throws RemoteException;
}
