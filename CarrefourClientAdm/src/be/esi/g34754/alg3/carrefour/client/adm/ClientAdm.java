/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.client.adm;

import be.esi.g34754.alg3.carrefour.FeuModel;
import be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton;
import be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author g34754
 */
public class ClientAdm extends javax.swing.JFrame {

    private FeuModel model;
    private Properties prop;

    /**
     * Creates new form ClientAdm
     */
    public ClientAdm() {
        initComponents();
        prop = new Properties();
        try {
            prop.load(new FileInputStream("src/be/esi/g34754/alg3/carrefour/client/adm/dureeFeux.properties"));
        } catch (IOException ex) {
        }
        initSliders();
        axeNS.add(new FeuPieton(null));
        axeNS.add(new FeuVoiture(null));
        axeEO.add(new FeuPieton(null));
        axeEO.add(new FeuVoiture(null));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        VNSRouge = new javax.swing.JSlider();
        VNSVert = new javax.swing.JSlider();
        VEORouge = new javax.swing.JSlider();
        VEOOrange = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VNSOrange = new javax.swing.JSlider();
        VEOVert = new javax.swing.JSlider();
        jPanel2 = new javax.swing.JPanel();
        PNSRouge = new javax.swing.JSlider();
        PNSVert = new javax.swing.JSlider();
        PEORouge = new javax.swing.JSlider();
        PEOOrange = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PNSOrange = new javax.swing.JSlider();
        PEOVert = new javax.swing.JSlider();
        appliquer = new javax.swing.JButton();
        annuler = new javax.swing.JButton();
        visualiser = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        axeNS = new javax.swing.JPanel();
        axeEO = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        fermer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administration du carrefour");
        setMaximumSize(new java.awt.Dimension(786, 673));
        setMinimumSize(new java.awt.Dimension(786, 673));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Feux Voitures", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 51)));

        VNSRouge.setBackground(new java.awt.Color(255, 0, 51));
        VNSRouge.setMajorTickSpacing(2);
        VNSRouge.setMaximum(5);
        VNSRouge.setMinimum(1);
        VNSRouge.setMinorTickSpacing(1);
        VNSRouge.setPaintLabels(true);
        VNSRouge.setPaintTicks(true);
        VNSRouge.setSnapToTicks(true);

        VNSVert.setBackground(new java.awt.Color(51, 255, 51));
        VNSVert.setMajorTickSpacing(2);
        VNSVert.setMaximum(5);
        VNSVert.setMinimum(1);
        VNSVert.setMinorTickSpacing(1);
        VNSVert.setPaintLabels(true);
        VNSVert.setPaintTicks(true);
        VNSVert.setSnapToTicks(true);

        VEORouge.setBackground(new java.awt.Color(255, 0, 51));
        VEORouge.setMajorTickSpacing(2);
        VEORouge.setMaximum(5);
        VEORouge.setMinimum(1);
        VEORouge.setMinorTickSpacing(1);
        VEORouge.setPaintLabels(true);
        VEORouge.setPaintTicks(true);
        VEORouge.setSnapToTicks(true);

        VEOOrange.setBackground(new java.awt.Color(255, 153, 51));
        VEOOrange.setMajorTickSpacing(2);
        VEOOrange.setMaximum(5);
        VEOOrange.setMinimum(1);
        VEOOrange.setMinorTickSpacing(1);
        VEOOrange.setPaintLabels(true);
        VEOOrange.setPaintTicks(true);
        VEOOrange.setSnapToTicks(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Axe Nord - Sud");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Axe Est - Ouest");

        VNSOrange.setBackground(new java.awt.Color(255, 153, 51));
        VNSOrange.setMajorTickSpacing(2);
        VNSOrange.setMaximum(5);
        VNSOrange.setMinimum(1);
        VNSOrange.setMinorTickSpacing(1);
        VNSOrange.setPaintLabels(true);
        VNSOrange.setPaintTicks(true);
        VNSOrange.setSnapToTicks(true);

        VEOVert.setBackground(new java.awt.Color(51, 255, 51));
        VEOVert.setMajorTickSpacing(2);
        VEOVert.setMaximum(5);
        VEOVert.setMinimum(1);
        VEOVert.setMinorTickSpacing(1);
        VEOVert.setPaintLabels(true);
        VEOVert.setPaintTicks(true);
        VEOVert.setSnapToTicks(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VNSVert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VEOVert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VEOOrange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VNSOrange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VNSRouge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VEORouge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VNSVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VNSOrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VNSRouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VEOVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VEOOrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VEORouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Feux Pietons", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 51)));

        PNSRouge.setBackground(new java.awt.Color(255, 0, 51));
        PNSRouge.setMajorTickSpacing(2);
        PNSRouge.setMaximum(5);
        PNSRouge.setMinimum(1);
        PNSRouge.setMinorTickSpacing(1);
        PNSRouge.setPaintLabels(true);
        PNSRouge.setPaintTicks(true);
        PNSRouge.setSnapToTicks(true);

        PNSVert.setBackground(new java.awt.Color(51, 255, 51));
        PNSVert.setMajorTickSpacing(2);
        PNSVert.setMaximum(5);
        PNSVert.setMinimum(1);
        PNSVert.setMinorTickSpacing(1);
        PNSVert.setPaintLabels(true);
        PNSVert.setPaintTicks(true);
        PNSVert.setSnapToTicks(true);

        PEORouge.setBackground(new java.awt.Color(255, 0, 51));
        PEORouge.setMajorTickSpacing(2);
        PEORouge.setMaximum(5);
        PEORouge.setMinimum(1);
        PEORouge.setMinorTickSpacing(1);
        PEORouge.setPaintLabels(true);
        PEORouge.setPaintTicks(true);
        PEORouge.setSnapToTicks(true);

        PEOOrange.setBackground(new java.awt.Color(255, 153, 51));
        PEOOrange.setMajorTickSpacing(2);
        PEOOrange.setMaximum(5);
        PEOOrange.setMinimum(1);
        PEOOrange.setMinorTickSpacing(1);
        PEOOrange.setPaintLabels(true);
        PEOOrange.setPaintTicks(true);
        PEOOrange.setSnapToTicks(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Axe Nord - Sud");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Axe Est - Ouest");

        PNSOrange.setBackground(new java.awt.Color(255, 153, 51));
        PNSOrange.setMajorTickSpacing(2);
        PNSOrange.setMaximum(5);
        PNSOrange.setMinimum(1);
        PNSOrange.setMinorTickSpacing(1);
        PNSOrange.setPaintLabels(true);
        PNSOrange.setPaintTicks(true);
        PNSOrange.setSnapToTicks(true);

        PEOVert.setBackground(new java.awt.Color(51, 255, 51));
        PEOVert.setMajorTickSpacing(2);
        PEOVert.setMaximum(5);
        PEOVert.setMinimum(1);
        PEOVert.setMinorTickSpacing(1);
        PEOVert.setPaintLabels(true);
        PEOVert.setPaintTicks(true);
        PEOVert.setSnapToTicks(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PNSVert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PEOVert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PEOOrange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PNSOrange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PNSRouge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PEORouge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PNSVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PNSOrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PNSRouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PEOVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PEOOrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PEORouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        appliquer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        appliquer.setForeground(new java.awt.Color(51, 153, 0));
        appliquer.setText("Appliquer");
        appliquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliquerActionPerformed(evt);
            }
        });

        annuler.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        annuler.setForeground(new java.awt.Color(255, 0, 0));
        annuler.setText("Réinitialiser");
        annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });

        visualiser.setText("Visualiser");
        visualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualiserActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prévisualisation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        axeNS.setBorder(javax.swing.BorderFactory.createTitledBorder("Axe Nord - Sud"));
        axeNS.setLayout(new java.awt.GridLayout());

        axeEO.setBorder(javax.swing.BorderFactory.createTitledBorder("Axe Est - Ouest"));
        axeEO.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(axeNS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(axeEO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(axeEO, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(axeNS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(10);
        jSlider1.setMinimum(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setName(""); // NOI18N

        jLabel5.setText("Vitesse de la visualisation:");

        fermer.setText("Fermer");
        fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(visualiser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(annuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(appliquer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fermer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(visualiser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(annuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(appliquer)
                        .addComponent(fermer))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void visualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualiserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_visualiserActionPerformed

    private void appliquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliquerActionPerformed
        // TODO add your handling code here:
        //TODO mettre tout au rouge puis setmodel
    }//GEN-LAST:event_appliquerActionPerformed

    private void annulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerActionPerformed
        setCurrentValues(prop);
    }//GEN-LAST:event_annulerActionPerformed

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        System.exit(0);
    }//GEN-LAST:event_fermerActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientAdm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider PEOOrange;
    private javax.swing.JSlider PEORouge;
    private javax.swing.JSlider PEOVert;
    private javax.swing.JSlider PNSOrange;
    private javax.swing.JSlider PNSRouge;
    private javax.swing.JSlider PNSVert;
    private javax.swing.JSlider VEOOrange;
    private javax.swing.JSlider VEORouge;
    private javax.swing.JSlider VEOVert;
    private javax.swing.JSlider VNSOrange;
    private javax.swing.JSlider VNSRouge;
    private javax.swing.JSlider VNSVert;
    private javax.swing.JButton annuler;
    private javax.swing.JButton appliquer;
    private javax.swing.JPanel axeEO;
    private javax.swing.JPanel axeNS;
    private javax.swing.JButton fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton visualiser;
    // End of variables declaration//GEN-END:variables

    private void setMaximum(Properties prop) {
        VNSVert.setMaximum(Integer.parseInt(prop.getProperty("maxVert", "15")));
        VNSOrange.setMaximum(Integer.parseInt(prop.getProperty("maxOrange", "10")));
        VNSRouge.setMaximum(Integer.parseInt(prop.getProperty("maxRouge", "20")));
        PNSVert.setMaximum(Integer.parseInt(prop.getProperty("maxVert", "15")));
        PNSOrange.setMaximum(Integer.parseInt(prop.getProperty("maxOrange", "10")));
        PNSRouge.setMaximum(Integer.parseInt(prop.getProperty("maxRouge", "20")));
        VEOVert.setMaximum(Integer.parseInt(prop.getProperty("maxVert", "15")));
        VEOOrange.setMaximum(Integer.parseInt(prop.getProperty("maxOrange", "10")));
        VEORouge.setMaximum(Integer.parseInt(prop.getProperty("maxRouge", "20")));
        PEOVert.setMaximum(Integer.parseInt(prop.getProperty("maxVert", "15")));
        PEOOrange.setMaximum(Integer.parseInt(prop.getProperty("maxOrange", "10")));
        PEORouge.setMaximum(Integer.parseInt(prop.getProperty("maxRouge", "20")));
    }

    private void setMinimum(Properties prop) {
        VNSVert.setMinimum(Integer.parseInt(prop.getProperty("minVert", "3")));
        VNSOrange.setMinimum(Integer.parseInt(prop.getProperty("minOrange", "1")));
        VNSRouge.setMinimum(Integer.parseInt(prop.getProperty("minRouge", "5")));
        PNSVert.setMinimum(Integer.parseInt(prop.getProperty("minVert", "3")));
        PNSOrange.setMinimum(Integer.parseInt(prop.getProperty("minOrange", "1")));
        PNSRouge.setMinimum(Integer.parseInt(prop.getProperty("minRouge", "5")));
        VEOVert.setMinimum(Integer.parseInt(prop.getProperty("minVert", "3")));
        VEOOrange.setMinimum(Integer.parseInt(prop.getProperty("minOrange", "1")));
        VEORouge.setMinimum(Integer.parseInt(prop.getProperty("minRouge", "5")));
        PEOVert.setMinimum(Integer.parseInt(prop.getProperty("minVert", "3")));
        PEOOrange.setMinimum(Integer.parseInt(prop.getProperty("minOrange", "1")));
        PEORouge.setMinimum(Integer.parseInt(prop.getProperty("minRouge", "5")));
    }

    private void setCurrentValues(Properties prop) {
        VNSVert.setValue(Integer.parseInt(prop.getProperty("VoitureVert_NS", "3")));
        VNSOrange.setValue(Integer.parseInt(prop.getProperty("VoitureOrange_NS", "1")));
        VNSRouge.setValue(Integer.parseInt(prop.getProperty("VoitureRouge_NS", "5")));
        PNSVert.setValue(Integer.parseInt(prop.getProperty("PietonVert_NS", "3")));
        PNSOrange.setValue(Integer.parseInt(prop.getProperty("PietonOrange_NS", "1")));
        PNSRouge.setValue(Integer.parseInt(prop.getProperty("PietonRouge_NS", "5")));
        VEOVert.setValue(Integer.parseInt(prop.getProperty("VoitureVert_EO", "3")));
        VEOOrange.setValue(Integer.parseInt(prop.getProperty("VoitureOrange_EO", "1")));
        VEORouge.setValue(Integer.parseInt(prop.getProperty("VoitureRouge_EO", "5")));
        PEOVert.setValue(Integer.parseInt(prop.getProperty("PietonVert_EO", "3")));
        PEOOrange.setValue(Integer.parseInt(prop.getProperty("PietonOrange_EO", "1")));
        PEORouge.setValue(Integer.parseInt(prop.getProperty("PietonRouge_EO", "5")));
    }

    private void initSliders() {
        setMaximum(prop);
        setMinimum(prop);
        setCurrentValues(prop);
    }
}
