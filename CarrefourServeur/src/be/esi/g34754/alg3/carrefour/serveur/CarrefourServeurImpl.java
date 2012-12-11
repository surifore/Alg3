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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g34754
 */
class CarrefourServeurImpl extends UnicastRemoteObject implements CarrefourServeurInterface {
    
    private FeuModel feux;
    private List<CarrefourView> clients;

    public CarrefourServeurImpl() throws RemoteException{
        feux=new FeuModel(5,2,8,this);
        clients=new ArrayList<CarrefourView>();
    }

    @Override
    public void addListener(CarrefourView client) throws RemoteException{
        clients.add(client);
        System.out.println("Ajouté");
    }

    @Override
    public FeuModel getModel() throws RemoteException {
        return feux;
    }

    @Override
    public void notifierChangement() throws RemoteException {
        System.out.println("clients:"+clients);
        for(CarrefourView client:clients){
            client.notifieChangement();
            System.out.println("notification");
        }            
    }
    
}
