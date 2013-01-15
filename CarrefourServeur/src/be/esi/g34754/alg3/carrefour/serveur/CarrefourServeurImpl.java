/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.serveur;

import be.esi.g34754.alg3.carrefour.dto.ParametresDto;
import be.esi.g34754.alg3.carrefour.CouleurEnum;
import be.esi.g34754.alg3.carrefour.Etat;
import be.esi.g34754.alg3.carrefour.Feu;
import be.esi.g34754.alg3.carrefour.FeuModel;
import be.esi.g34754.alg3.carrefour.FeuModeleInterface;
import be.esi.g34754.alg3.carrefour.db.CarrefourDB;
import be.esi.g34754.alg3.carrefour.db.CarrefourDbException;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourServeurInterface;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Serveur contenant le modèle du Carrefour
 *
 * @author Florian Delporte
 */
public class CarrefourServeurImpl extends UnicastRemoteObject implements CarrefourServeurInterface, CarrefourView {

    private FeuModeleInterface feux;
    private List<CarrefourView> clients;

    public CarrefourServeurImpl() throws RemoteException {
        feux = new FeuModel(5, 2, 8, 1);
        clients = new ArrayList<CarrefourView>();
        feux.addCarrefourListener(this);
        feux.demarrer(true);
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
                feux.setStop();
                clients.remove(client);
            }
        }
    }

    @Override
    public void setModel(FeuModeleInterface model) {
        feux = model;
        Etat etat = model.getEtat();
        Feu pNS = etat.getFeu(0);
        Feu pEO = etat.getFeu(1);
        Feu vNS = etat.getFeu(2);
        Feu vEO = etat.getFeu(3);
        int[] dureeVert = {pNS.getVert(), pEO.getVert(), vNS.getVert(), vEO.getVert()};
        int[] dureeOrange = {pNS.getOrange(), pEO.getOrange(), vNS.getOrange(), vEO.getOrange()};
        int[] dureeRouge = {pNS.getRouge(), pEO.getRouge(), vNS.getRouge(), vEO.getRouge()};
        try {
            CarrefourDB.saveParametres(new ParametresDto(dureeVert, dureeOrange, dureeRouge, pNS.getTousRouge()));
        } catch (CarrefourDbException ex) {
            try {
                CarrefourDB.saveAlerte("CarrefourDBException:\n" + ex.getMessage());
            } catch (CarrefourDbException ex1) {
                JOptionPane.showMessageDialog(null, "Accès à la base de donnée impossible\n"+ex1.getMessage(),
                        "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        feux.addCarrefourListener(this);
        feux.demarrer(true);
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
    public void removeListener(CarrefourView client) throws RemoteException {
        clients.remove(client);
    }

    @Override
    public void demandeVert(boolean axeNS) throws RemoteException {
        if (feux.getEtat().getFeu(true, axeNS).getEtat().getCouleur().equals(CouleurEnum.VERT))
            feux.demandeVert(axeNS);
    }
}
