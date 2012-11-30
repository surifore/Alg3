/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.serveur;

import be.esi.g34754.alg3.carrefour.interfaces.CarrefourServeurInterface;
import java.net.MalformedURLException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author g34754
 */
public class ServeurMain {
    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        try {
            CarrefourServeurInterface serveur=new CarrefourServeurImpl();
            java.rmi.Naming.rebind("Carrefour", serveur);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServeurMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Erreur: l'URL fournie est mal formée", "MalformedURLException", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (RemoteException ex) {
            Logger.getLogger(ServeurMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Erreur lors de la connexion", "RemoteException", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
