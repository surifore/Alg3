/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.interfaces;

import be.esi.g34754.alg3.carrefour.FeuModeleInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface du serveur du Carrefour
 * @author Florian Delporte
 */
public interface CarrefourServeurInterface extends Remote{

    /**
     * Ajoute une vue au serveur
     * @param client la vue à ajouter au serveur
     * @throws RemoteException Si une erreur survient pendant la communication
     */
    public void addListener(CarrefourView client)throws RemoteException;

    /**
     * Récupère le modèle 
     * @return le modèle du Carrefour
     * @throws RemoteException Si une erreur survient pendant la communication
     */
    public FeuModeleInterface getModel()throws RemoteException;

    /**
     * Modifie le modèle du Carrefour
     * @param model le modèle à attribuer au carrefour
     * @throws RemoteException Si une erreur survient pendant la communication
     */
    public void setModel(FeuModeleInterface model)throws RemoteException;

    /**
     * Permet d'arrêter le carrefour et de tout passer au rouge
     * @throws RemoteException Si une erreur survient pendant la communication
     */
    public void setArret()throws RemoteException;

    /**
     * Permet de retirer une vue du serveur
     * @param client la vue à supprimer du serveur
     * @throws RemoteException Si une erreur survient pendant la communication
     */
    public void removeListener(CarrefourView client)throws RemoteException;

    /**
     * Permet de signaler au modèle qu'un pieton a demandé le passage au vert
     * @param axeNS l'axe sur lequel la demande a été faite.
     * @throws RemoteException Si une erreur survient pendant la communication
     */
    public void demandeVert(boolean axeNS)throws RemoteException;
}
