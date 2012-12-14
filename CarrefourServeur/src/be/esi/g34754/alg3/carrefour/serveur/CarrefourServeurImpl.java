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
class CarrefourServeurImpl extends UnicastRemoteObject implements CarrefourServeurInterface, CarrefourView {
    
    private FeuModel feux;
    private List<CarrefourView> clients;
    private List<CarrefourView> clientsSave;

    public CarrefourServeurImpl() throws RemoteException{
        feux=new FeuModel(5,2,8,this);
        clients=new ArrayList<CarrefourView>();
        clientsSave=new ArrayList<CarrefourView>();
        feux.addCarrefourListener(this);
    }

    @Override
    public void addListener(CarrefourView client) throws RemoteException{
        clients.add(client);
        clientsSave.add(client);
        feux.addCarrefourListener(this);
    }

    @Override
    public FeuModel getModel() throws RemoteException {
        return feux;
    }
    
    @Override
    public void notifieChangement(){
        for(CarrefourView client:clientsSave){
            try {
                client.notifieChangement();
            } catch (RemoteException ex) {
                clients.remove(client);
                feux.setStop();
            }
        }
    }
    
}
