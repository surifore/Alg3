/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.client.feu.voiture;

import be.esi.g34754.alg3.carrefour.CouleurEnum;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourServeurInterface;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import java.awt.Color;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g34754
 */
public class FeuVoiture extends javax.swing.JPanel implements Serializable {

    private CarrefourServeurInterface serveur;
    private CarrefourView client;
    private boolean axeNS;

    /**
     * Creates new form FeuPieto
     */
    public FeuVoiture(CarrefourServeurInterface serveur) {
        try {
            initComponents();
            this.serveur = serveur;
            ledRouge.setColor(Color.red);
            ledVert.setColor(Color.green);
            client = new FeuVoitureImpl(this);
            axeNS = true;
            if (serveur != null) {
                initLed();
                serveur.addListener(client);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(FeuVoiture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setAxeNS(boolean axeNS) {
        this.axeNS = axeNS;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ledVert = new be.esi.g34754.alg3.carrefour.outils.Led();
        ledRouge = new be.esi.g34754.alg3.carrefour.outils.Led();
        ledOrange = new be.esi.g34754.alg3.carrefour.outils.Led();

        setMaximumSize(new java.awt.Dimension(106, 317));
        setMinimumSize(new java.awt.Dimension(106, 317));

        ledVert.setColor(java.awt.Color.green);

        javax.swing.GroupLayout ledVertLayout = new javax.swing.GroupLayout(ledVert);
        ledVert.setLayout(ledVertLayout);
        ledVertLayout.setHorizontalGroup(
            ledVertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );
        ledVertLayout.setVerticalGroup(
            ledVertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        ledRouge.setClignotant(false);
        ledRouge.setColor(java.awt.Color.red);

        javax.swing.GroupLayout ledRougeLayout = new javax.swing.GroupLayout(ledRouge);
        ledRouge.setLayout(ledRougeLayout);
        ledRougeLayout.setHorizontalGroup(
            ledRougeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );
        ledRougeLayout.setVerticalGroup(
            ledRougeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );

        ledOrange.setColor(java.awt.Color.orange);

        javax.swing.GroupLayout ledOrangeLayout = new javax.swing.GroupLayout(ledOrange);
        ledOrange.setLayout(ledOrangeLayout);
        ledOrangeLayout.setHorizontalGroup(
            ledOrangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );
        ledOrangeLayout.setVerticalGroup(
            ledOrangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ledVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(ledRouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(ledOrange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ledRouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ledOrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ledVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private be.esi.g34754.alg3.carrefour.outils.Led ledOrange;
    private be.esi.g34754.alg3.carrefour.outils.Led ledRouge;
    private be.esi.g34754.alg3.carrefour.outils.Led ledVert;
    // End of variables declaration//GEN-END:variables

    public void initLed() {
        if (serveur != null) {
            try {
                if (axeNS) {
                    led(serveur.getModel().getEtat().getFeuxV_NS());
                } else {
                    led(serveur.getModel().getEtat().getFeuxV_EO());
                }
            } catch (RemoteException ex) {
                Logger.getLogger(FeuVoiture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void led(be.esi.g34754.alg3.carrefour.FeuVoiture feu) {
        if (feu.isEnPanne()) {
            ledRouge.setOn(false);
            ledOrange.setOn(true);
            ledOrange.setClignotant(true);
            ledVert.setOn(false);
        } else {
            if (feu.getEtat().getCouleur() == CouleurEnum.VERT) {
                ledRouge.setOn(false);
                ledOrange.setOn(false);
                ledVert.setOn(true);
            } else if (feu.getEtat().getCouleur() == CouleurEnum.ORANGE) {
                ledRouge.setOn(false);
                ledOrange.setOn(true);
                ledVert.setOn(false);
            } else {
                ledRouge.setOn(true);
                ledOrange.setOn(false);
                ledVert.setOn(false);
            }
        }
    }
}