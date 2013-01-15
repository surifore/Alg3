/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Classe des vues du Carrefour
 * @author Florian Delporte
 */
public interface CarrefourView extends Remote{

    /**
     * Permet aux vues d'être notifiées du changement du modèle
     * @param changement Si un changement de l'etat du carrefour a eu lieu.
     * @throws RemoteException Si une erreur survient pendant la communication
     */
    public void notifieChangement()throws RemoteException;

    /**
     * Permet à une vue d'être notifiée que tous les feux sont au rouge
     * @throws RemoteException Si une erreur survient pendant la communication
     */
    public void notifieTousRouge()throws RemoteException;

//    public boolean isFeu()throws RemoteException;
    
}
