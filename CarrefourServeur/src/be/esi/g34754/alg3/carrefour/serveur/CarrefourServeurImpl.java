/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.serveur;

import be.esi.g34754.alg3.carrefour.FeuModel;
import be.esi.g34754.alg3.carrefour.FeuModeleInterface;
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

    private FeuModeleInterface feux;
    private List<CarrefourView> clients;

    public CarrefourServeurImpl() throws RemoteException {
        feux = new FeuModel(5, 2, 8, 1);
        clients = new ArrayList<CarrefourView>();
        feux.addCarrefourListener(this);
        feux.demarrer();
    }

    @Override
    public void addListener(CarrefourView client) throws RemoteException {
        clients.add(client);
        feux.addCarrefourListener(this);
    }

    @Override
    public FeuModeleInterface getModel() throws RemoteException {
        return feux;
    }

    @Override
    public void notifieChangement() {
        List<CarrefourView> clientCopy = new ArrayList<CarrefourView>();
        clientCopy.addAll(clients);
        for (CarrefourView client : clientCopy) {
            try {
                client.notifieChangement();
            } catch (RemoteException ex) {
                try {
                    System.out.println("Attention "+client.isFeu() );
                    if ((client.isFeu())) {
                        feux.setStop();
                    }
                    clients.remove(client);
                } catch (RemoteException ex1) {
                }
            }
        }
    }

    @Override
    public void setModel(FeuModeleInterface model) {
        feux = model;
        feux.addCarrefourListener(this);
        feux.demarrer();
    }

    @Override
    public void notifieTousRouge() throws RemoteException {
        List<CarrefourView> clientCopy = new ArrayList<CarrefourView>();
        clientCopy.addAll(clients);
        for (CarrefourView client : clientCopy) {
            try {
                client.notifieTousRouge();
            } catch (RemoteException ex) {
                clients.remove(client);
                feux.setStop();
            }
        }
    }

    @Override
    public void setArret() throws RemoteException {
        feux.setArret();
    }

    @Override
    public boolean isFeu() throws RemoteException {
        return false;
    }
}
