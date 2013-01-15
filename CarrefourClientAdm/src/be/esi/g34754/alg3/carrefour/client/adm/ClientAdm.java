/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.client.adm;

import be.esi.g34754.alg3.carrefour.dto.CarrefourDto;
import be.esi.g34754.alg3.carrefour.dto.ParametresDto;
import be.esi.g34754.alg3.carrefour.CarrefourException;
import be.esi.g34754.alg3.carrefour.CouleurEnum;
import be.esi.g34754.alg3.carrefour.Etat;
import be.esi.g34754.alg3.carrefour.EtatFeu;
import be.esi.g34754.alg3.carrefour.Feu;
import be.esi.g34754.alg3.carrefour.FeuModel;
import be.esi.g34754.alg3.carrefour.FeuModeleInterface;
import be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton;
import be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture;
import be.esi.g34754.alg3.carrefour.db.CarrefourDB;
import be.esi.g34754.alg3.carrefour.db.CarrefourDbException;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourServeurInterface;
import be.esi.g34754.alg3.carrefour.interfaces.CarrefourView;
import be.esi.g34754.rmioutils.Connection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Fenêtre d'administration du carrefour
 *
 * @author Florian Delporte
 */
public class ClientAdm extends javax.swing.JFrame {

    private FeuModeleInterface model;
    private final CarrefourServeurInterface serveur;
    private CarrefourView client;
    private Properties prop;
    private FeuPieton feuP_NS;
    private FeuPieton feuP_EO;
    private FeuVoiture feuV_NS;
    private FeuVoiture feuV_EO;
    private boolean visualisationDemarree;

    /**
     * Creates new form ClientAdm
     */
    public ClientAdm(CarrefourServeurInterface serveur) {
        this.serveur = serveur;
        initComponents();
        prop = new Properties();
        try {
            prop.load(new FileInputStream("../dureeFeux.properties"));
        } catch (IOException ex) {
            try {
                prop.load(new FileInputStream("dureeFeux.properties"));
            } catch (IOException ex1) {
            }
        }
        try {
            this.client = new ClientAdmImpl(this);
            serveur.addListener(client);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        initSliders();
        feuP_EO = new FeuPieton();
        feuP_EO.setAxeNS(false);
        feuP_NS = new FeuPieton();
        feuV_EO = new FeuVoiture();
        feuV_EO.setAxeNS(false);
        feuV_NS = new FeuVoiture();
        axeNS.add(feuV_NS);
        axeNS.add(feuP_NS);
        axeEO.add(feuV_EO);
        axeEO.add(feuP_EO);
        feuVoiture6.setAxeNS(false);
        feuVoiture7.setAxeNS(false);
        feuPieton6.setAxeNS(false);
        feuPieton7.setAxeNS(false);
        noDataEtat.setVisible(false);
        noDataParam.setVisible(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                desabonner();
            }
        });

        date.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                assignerParam();
            }
        });
    }

    /**
     * Permet de se désabonner du serveur
     */
    public void desabonner() {
        try {
            serveur.removeListener(client);
        } catch (RemoteException ex) {
        }
    }

    public void assignerParam() {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date.getDate());
        cal.set(cal.get(GregorianCalendar.YEAR), cal.get(GregorianCalendar.MONTH), cal.get(GregorianCalendar.DATE),
                Integer.parseInt(heure.getValue().toString()),
                Integer.parseInt(minute.getValue().toString()),
                Integer.parseInt(secondes.getValue().toString()));

        try {
            CarrefourDto etatCarrefour = CarrefourDB.getChangement(cal);
            if (etatCarrefour != null) {
                noDataEtat.setVisible(false);
                initLed(etatCarrefour);
            } else {
                noDataEtat.setVisible(true);
            }
            ParametresDto param = CarrefourDB.getParametres(cal);
            if (param != null) {
                noDataParam.setVisible(false);
                initParam(param);
            } else {
                noDataParam.setVisible(true);
            }
        } catch (CarrefourDbException ex) {
            Logger.getLogger(ClientAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tempsReelPanel = new javax.swing.JPanel();
        feuPieton5 = new be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton(serveur);
        feuVoiture5 = new be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture(serveur);
        feuVoiture6 = new be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture(serveur);
        feuPieton6 = new be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton(serveur);
        feuVoiture7 = new be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture(serveur);
        feuPieton7 = new be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton(serveur);
        feuVoiture8 = new be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture(serveur);
        feuPieton8 = new be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton(serveur);
        admPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PNSRouge = new javax.swing.JSlider();
        PNSVert = new javax.swing.JSlider();
        PEORouge = new javax.swing.JSlider();
        PEOOrange = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PNSOrange = new javax.swing.JSlider();
        PEOVert = new javax.swing.JSlider();
        jPanel3 = new javax.swing.JPanel();
        axeNS = new javax.swing.JPanel();
        axeEO = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        VNSRouge = new javax.swing.JSlider();
        VNSVert = new javax.swing.JSlider();
        VEORouge = new javax.swing.JSlider();
        VEOOrange = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VNSOrange = new javax.swing.JSlider();
        VEOVert = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        sliderTousRouge = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        vitesse = new javax.swing.JSlider();
        annuler = new javax.swing.JButton();
        appliquer = new javax.swing.JButton();
        fermer = new javax.swing.JButton();
        visualiser = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        etatAxeNS = new javax.swing.JPanel();
        etatFeuPietonNS = new be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton();
        etatFeuVoitureNS = new be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture();
        etatAxeEO = new javax.swing.JPanel();
        etatFeuPietonEO = new be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton();
        etatFeuVoitureEO = new be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture();
        noDataEtat = new javax.swing.JLabel();
        minute = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        heure = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        axeNS2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        paramPNSV = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        paramPNSO = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        paramPNSR = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        paramVNSV = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        paramVNSO = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        paramVNSR = new javax.swing.JLabel();
        axeEO2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        paramPEOV = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        paramPEOO = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        paramPEOR = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        paramVEOV = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        paramVEOO = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        paramVEOR = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        paramTousRouge = new javax.swing.JLabel();
        noDataParam = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        secondes = new javax.swing.JSpinner();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        heure1 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        minute1 = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        secondes1 = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        nbChangement = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        nbAlertes = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administration du carrefour");
        setMinimumSize(new java.awt.Dimension(786, 779));
        setResizable(false);

        feuPieton5.setAxeNS(true);

        feuVoiture5.setAxeNS(true);

        feuVoiture8.setAxeNS(true);

        feuPieton8.setAxeNS(true);

        javax.swing.GroupLayout tempsReelPanelLayout = new javax.swing.GroupLayout(tempsReelPanel);
        tempsReelPanel.setLayout(tempsReelPanelLayout);
        tempsReelPanelLayout.setHorizontalGroup(
            tempsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tempsReelPanelLayout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(feuVoiture6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feuPieton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tempsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tempsReelPanelLayout.createSequentialGroup()
                        .addComponent(feuVoiture5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(feuPieton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tempsReelPanelLayout.createSequentialGroup()
                        .addComponent(feuVoiture8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(feuPieton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feuVoiture7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feuPieton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        tempsReelPanelLayout.setVerticalGroup(
            tempsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempsReelPanelLayout.createSequentialGroup()
                .addGroup(tempsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tempsReelPanelLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addGroup(tempsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tempsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(feuVoiture7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(tempsReelPanelLayout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(feuPieton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(tempsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(feuVoiture6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(tempsReelPanelLayout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(feuPieton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(tempsReelPanelLayout.createSequentialGroup()
                        .addGroup(tempsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tempsReelPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(feuVoiture5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tempsReelPanelLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(feuPieton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(121, 121, 121)
                        .addGroup(tempsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(feuVoiture8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tempsReelPanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(feuPieton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Temps Réel", tempsReelPanel);

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
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prévisualisation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        axeNS.setBorder(javax.swing.BorderFactory.createTitledBorder("Axe Nord - Sud"));
        axeNS.setLayout(new java.awt.GridLayout(1, 0));

        axeEO.setBorder(javax.swing.BorderFactory.createTitledBorder("Axe Est - Ouest"));
        axeEO.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(axeNS, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(axeEO, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(axeNS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
            .addComponent(axeEO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VNSVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VNSOrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VNSRouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VEOVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VEOOrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VEORouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel6.setText("Durée où tous les feux sont au rouge:");

        sliderTousRouge.setMajorTickSpacing(1);
        sliderTousRouge.setMaximum(10);
        sliderTousRouge.setMinimum(1);
        sliderTousRouge.setMinorTickSpacing(1);
        sliderTousRouge.setPaintLabels(true);
        sliderTousRouge.setPaintTicks(true);
        sliderTousRouge.setSnapToTicks(true);
        sliderTousRouge.setValue(2);

        jLabel5.setText("Vitesse de la visualisation:");

        vitesse.setMajorTickSpacing(1);
        vitesse.setMaximum(10);
        vitesse.setMinimum(1);
        vitesse.setPaintLabels(true);
        vitesse.setPaintTicks(true);
        vitesse.setSnapToTicks(true);
        vitesse.setToolTipText("");
        vitesse.setName(""); // NOI18N

        annuler.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        annuler.setForeground(new java.awt.Color(255, 0, 0));
        annuler.setText("Réinitialiser");
        annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });

        appliquer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        appliquer.setForeground(new java.awt.Color(51, 153, 0));
        appliquer.setText("Appliquer");
        appliquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliquerActionPerformed(evt);
            }
        });

        fermer.setText("Sauvegarder");
        fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerActionPerformed(evt);
            }
        });

        visualiser.setText("Visualiser");
        visualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualiserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout admPanelLayout = new javax.swing.GroupLayout(admPanel);
        admPanel.setLayout(admPanelLayout);
        admPanelLayout.setHorizontalGroup(
            admPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(admPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(admPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sliderTousRouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(admPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vitesse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(visualiser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(annuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appliquer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fermer)))
                .addContainerGap())
        );
        admPanelLayout.setVerticalGroup(
            admPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(admPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sliderTousRouge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(admPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vitesse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(admPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(admPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(annuler)
                            .addComponent(appliquer)
                            .addComponent(fermer)
                            .addComponent(visualiser))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Administration", admPanel);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Etat du Carrefour"));

        etatAxeNS.setBorder(javax.swing.BorderFactory.createTitledBorder("Axe Nord - Sud"));

        javax.swing.GroupLayout etatAxeNSLayout = new javax.swing.GroupLayout(etatAxeNS);
        etatAxeNS.setLayout(etatAxeNSLayout);
        etatAxeNSLayout.setHorizontalGroup(
            etatAxeNSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, etatAxeNSLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(etatFeuVoitureNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etatFeuPietonNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        etatAxeNSLayout.setVerticalGroup(
            etatAxeNSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etatAxeNSLayout.createSequentialGroup()
                .addComponent(etatFeuVoitureNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(etatAxeNSLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(etatFeuPietonNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        etatAxeEO.setBorder(javax.swing.BorderFactory.createTitledBorder("Axe Est - Ouest"));

        javax.swing.GroupLayout etatAxeEOLayout = new javax.swing.GroupLayout(etatAxeEO);
        etatAxeEO.setLayout(etatAxeEOLayout);
        etatAxeEOLayout.setHorizontalGroup(
            etatAxeEOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, etatAxeEOLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(etatFeuVoitureEO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etatFeuPietonEO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        etatAxeEOLayout.setVerticalGroup(
            etatAxeEOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etatAxeEOLayout.createSequentialGroup()
                .addComponent(etatFeuVoitureEO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(etatAxeEOLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(etatFeuPietonEO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        noDataEtat.setForeground(new java.awt.Color(153, 0, 0));
        noDataEtat.setText("Pas de données à cette date");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noDataEtat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(etatAxeNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etatAxeEO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(noDataEtat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etatAxeNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etatAxeEO, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        minute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        minute.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minuteStateChanged(evt);
            }
        });

        jLabel9.setText(":");

        heure.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        heure.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                heureStateChanged(evt);
            }
        });

        jLabel8.setText("Heure:");

        jLabel7.setText("Date:");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Paramètres"));

        axeNS2.setBorder(javax.swing.BorderFactory.createTitledBorder("Axe Nord - Sud"));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Pieton"));

        jLabel11.setText("Vert:");

        jLabel13.setText("Orange:");

        jLabel15.setText("Rouge:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramPNSV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramPNSO, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramPNSR, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(paramPNSR, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(paramPNSO, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(paramPNSV, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Voiture"));

        jLabel17.setText("Vert:");

        jLabel19.setText("Orange:");

        jLabel21.setText("Rouge:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramVNSV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramVNSO, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramVNSR, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(paramVNSR, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(paramVNSO, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(paramVNSV, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout axeNS2Layout = new javax.swing.GroupLayout(axeNS2);
        axeNS2.setLayout(axeNS2Layout);
        axeNS2Layout.setHorizontalGroup(
            axeNS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(axeNS2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(axeNS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        axeNS2Layout.setVerticalGroup(
            axeNS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(axeNS2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        axeEO2.setBorder(javax.swing.BorderFactory.createTitledBorder("Axe Est - Ouest"));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Pieton"));

        jLabel23.setText("Vert:");

        jLabel25.setText("Orange:");

        jLabel27.setText("Rouge:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramPEOV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramPEOO, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramPEOR, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(paramPEOR, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(paramPEOO, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(paramPEOV, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Voiture"));

        jLabel29.setText("Vert:");

        jLabel31.setText("Orange:");

        jLabel33.setText("Rouge:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramVEOV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramVEOO, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramVEOR, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(paramVEOR, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(paramVEOO, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(paramVEOV, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout axeEO2Layout = new javax.swing.GroupLayout(axeEO2);
        axeEO2.setLayout(axeEO2Layout);
        axeEO2Layout.setHorizontalGroup(
            axeEO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(axeEO2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(axeEO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        axeEO2Layout.setVerticalGroup(
            axeEO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(axeEO2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Tous rouges:");

        paramTousRouge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paramTousRouge.setText(" ");

        noDataParam.setForeground(new java.awt.Color(153, 0, 0));
        noDataParam.setText("Pas de données à cette date");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(axeNS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(axeEO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(paramTousRouge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(noDataParam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(noDataParam)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paramTousRouge))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(axeNS2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(axeEO2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setText(":");

        secondes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        secondes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                secondesStateChanged(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Période"));

        jLabel12.setText("Date de fin:");

        jLabel14.setText("Heure:");

        heure1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        jLabel16.setText(":");

        minute1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));

        jLabel18.setText(":");

        secondes1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));

        jLabel20.setText("Nombre de changements:");

        jLabel22.setText("Nombre d'alertes:");

        jButton1.setText("Visualiser l'exécution sur la période donnée");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heure1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(6, 6, 6)
                        .addComponent(minute1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nbChangement, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nbAlertes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(heure1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minute1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(secondes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbChangement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbAlertes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(heure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(secondes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Données", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void appliquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliquerActionPerformed
        if (valide()) {
            try {
                ecrireProperties();
                CarrefourDB.saveParametres(getParamDto());
                serveur.setArret();
            } catch (CarrefourDbException ex) {
                Logger.getLogger(ClientAdm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(ClientAdm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_appliquerActionPerformed

    private void annulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerActionPerformed
        setCurrentValues();
    }//GEN-LAST:event_annulerActionPerformed

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        ecrireProperties();
    }//GEN-LAST:event_fermerActionPerformed

    private void visualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualiserActionPerformed
        if (!visualisationDemarree) {
            model = new FeuModel(vitesse.getValue());
            setValuesModel();
            feuP_EO.setModel(model);
            feuP_NS.setModel(model);
            feuV_EO.setModel(model);
            feuV_NS.setModel(model);
            model.demarrer(false);
            visualisationDemarree = true;
        } else {
            model.arreter();
            model = null;
            feuP_EO.removeFromModel();
            feuP_EO.clearLed();
            feuP_NS.removeFromModel();
            feuP_NS.clearLed();
            feuV_EO.removeFromModel();
            feuV_EO.clearLed();
            feuV_NS.removeFromModel();
            feuV_NS.clearLed();
            visualisationDemarree = false;
        }
    }//GEN-LAST:event_visualiserActionPerformed

    private void heureStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_heureStateChanged
        assignerParam();
    }//GEN-LAST:event_heureStateChanged

    private void minuteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minuteStateChanged
        assignerParam();
    }//GEN-LAST:event_minuteStateChanged

    private void secondesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_secondesStateChanged
        assignerParam();
    }//GEN-LAST:event_secondesStateChanged

    public static void main(String[] args) {
        Connection<CarrefourServeurInterface> conn = new Connection("Carrefour", "localhost", 1099);
        conn.setVisible(true);
        CarrefourServeurInterface model;
        model = conn.getRemoteObject();
        ClientAdm gui = new ClientAdm(model);
        gui.setVisible(true);
        gui.pack();
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
    private javax.swing.JPanel admPanel;
    private javax.swing.JButton annuler;
    private javax.swing.JButton appliquer;
    private javax.swing.JPanel axeEO;
    private javax.swing.JPanel axeEO2;
    private javax.swing.JPanel axeNS;
    private javax.swing.JPanel axeNS2;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser date1;
    private javax.swing.JPanel etatAxeEO;
    private javax.swing.JPanel etatAxeNS;
    private be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton etatFeuPietonEO;
    private be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton etatFeuPietonNS;
    private be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture etatFeuVoitureEO;
    private be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture etatFeuVoitureNS;
    private javax.swing.JButton fermer;
    private be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton feuPieton5;
    private be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton feuPieton6;
    private be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton feuPieton7;
    private be.esi.g34754.alg3.carrefour.client.feu.pieton.FeuPieton feuPieton8;
    private be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture feuVoiture5;
    private be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture feuVoiture6;
    private be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture feuVoiture7;
    private be.esi.g34754.alg3.carrefour.client.feu.voiture.FeuVoiture feuVoiture8;
    private javax.swing.JSpinner heure;
    private javax.swing.JSpinner heure1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner minute;
    private javax.swing.JSpinner minute1;
    private javax.swing.JLabel nbAlertes;
    private javax.swing.JLabel nbChangement;
    private javax.swing.JLabel noDataEtat;
    private javax.swing.JLabel noDataParam;
    private javax.swing.JLabel paramPEOO;
    private javax.swing.JLabel paramPEOR;
    private javax.swing.JLabel paramPEOV;
    private javax.swing.JLabel paramPNSO;
    private javax.swing.JLabel paramPNSR;
    private javax.swing.JLabel paramPNSV;
    private javax.swing.JLabel paramTousRouge;
    private javax.swing.JLabel paramVEOO;
    private javax.swing.JLabel paramVEOR;
    private javax.swing.JLabel paramVEOV;
    private javax.swing.JLabel paramVNSO;
    private javax.swing.JLabel paramVNSR;
    private javax.swing.JLabel paramVNSV;
    private javax.swing.JSpinner secondes;
    private javax.swing.JSpinner secondes1;
    private javax.swing.JSlider sliderTousRouge;
    private javax.swing.JPanel tempsReelPanel;
    private javax.swing.JToggleButton visualiser;
    private javax.swing.JSlider vitesse;
    // End of variables declaration//GEN-END:variables

    private void setMaximum() {
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
        sliderTousRouge.setMaximum(Integer.parseInt(prop.getProperty("maxTousRouge", "10")));
    }

    private void setMinimum() {
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
        sliderTousRouge.setMinimum(Integer.parseInt(prop.getProperty("minTousRouge", "1")));
    }

    private void setCurrentValues() {
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
        sliderTousRouge.setValue(Integer.parseInt(prop.getProperty("TousRouge", "1")));
    }

    private void initSliders() {
        setMaximum();
        setMinimum();
        setCurrentValues();
    }

    private void setValuesModel() {
        Feu feu = model.getEtat().getFeuxP_EO();
        feu.setVert(PEOVert.getValue());
        feu.setOrange(PEOOrange.getValue());
        feu.setRouge(PEORouge.getValue());

        feu = model.getEtat().getFeuxV_EO();
        feu.setVert(VEOVert.getValue());
        feu.setOrange(VEOOrange.getValue());
        feu.setRouge(VEORouge.getValue());

        feu = model.getEtat().getFeuxP_NS();
        feu.setVert(PNSVert.getValue());
        feu.setOrange(PNSOrange.getValue());
        feu.setRouge(PNSRouge.getValue());

        feu = model.getEtat().getFeuxV_NS();
        feu.setVert(VNSVert.getValue());
        feu.setOrange(VNSOrange.getValue());
        feu.setRouge(VNSRouge.getValue());

        model.setTousRouge(sliderTousRouge.getValue());
    }

    private boolean valide() {
        String erreurs = "Liste des erreurs:\n";
        boolean erreur = false;
        try {
            model = new FeuModel(1);
            setValuesModel();
            Etat etat = model.getEtat();
            int[] restant;
            restant = new int[4];
            restant[0] = model.getEtat().getFeuxP_NS().getRouge();
            restant[1] = model.getEtat().getFeuxV_NS().getVert();
            restant[2] = model.getEtat().getFeuxP_EO().getVert();
            restant[3] = model.getEtat().getFeuxV_EO().getRouge();
            for (int i = 0; i < model.getEtat().getDureeCycle(); i++) {
                restant[0] = mAJ(model.getEtat().getFeuxP_NS(), restant[0]);
                restant[1] = mAJ(model.getEtat().getFeuxP_EO(), restant[1]);
                restant[2] = mAJ(model.getEtat().getFeuxV_NS(), restant[2]);
                restant[3] = mAJ(model.getEtat().getFeuxV_EO(), restant[3]);
                try {
                    etat.validation();
                } catch (CarrefourException ex) {
                    erreurs += ex.getMessage();
                    erreur = true;
                }
            }
        } catch (CarrefourException ex) {
            erreurs += ex.getMessage();
            erreur = true;
        }
        if (erreur) {
            JOptionPane.showMessageDialog(this,
                    "Erreur lors de la validation des paramètres:\n" + erreurs,
                    "Erreur de paramètres", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private int mAJ(Feu feu, int restant) {
        if (restant == 0) {
            restant = feu.setEtatSuivant();
        }
        restant--;
        if (!feu.getEtat().getCouleur().equals(CouleurEnum.ROUGE)) {
            if (feu.getEtat().getCouleur().equals(CouleurEnum.VERT)) {
                restant = 0;
            }
            if (restant == 0) {
                restant = feu.setEtatSuivant();
            }
            restant--;
        }

        return restant;
    }

    /**
     * Permet de notifier que tous les feux sont au rouge
     *
     * @throws RemoteException lorsque le serveur n'est pas accessible
     */
    public void notifieTousRouge() throws RemoteException {
        model = new FeuModel(1);
        setValuesModel();
        serveur.setModel(model);
    }

    private void ecrireProperties() {
        prop.setProperty("VoitureVert_NS", "" + VNSVert.getValue());
        prop.setProperty("VoitureOrange_NS", "" + VNSOrange.getValue());
        prop.setProperty("VoitureRouge_NS", "" + VNSRouge.getValue());
        prop.setProperty("PietonVert_NS", "" + PNSVert.getValue());
        prop.setProperty("PietonOrange_NS", "" + PNSOrange.getValue());
        prop.setProperty("PietonRouge_NS", "" + PNSRouge.getValue());
        prop.setProperty("VoitureVert_EO", "" + VEOVert.getValue());
        prop.setProperty("VoitureOrange_EO", "" + VEOOrange.getValue());
        prop.setProperty("VoitureRouge_EO", "" + VEORouge.getValue());
        prop.setProperty("PietonVert_EO", "" + PEOVert.getValue());
        prop.setProperty("PietonOrange_EO", "" + PEOOrange.getValue());
        prop.setProperty("PietonRouge_EO", "" + PEORouge.getValue());
        prop.getProperty("TousRouge", "" + sliderTousRouge.getValue());
        try {
            prop.store(new FileOutputStream("src/be/esi/g34754/alg3/carrefour/client/adm/dureeFeux.properties"), "Sauvegarde des paramètres");
        } catch (IOException ex) {
            Logger.getLogger(ClientAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initLed(CarrefourDto e) {
        be.esi.g34754.alg3.carrefour.FeuPieton feuPNS = new be.esi.g34754.alg3.carrefour.FeuPieton(e.getFeu(0).getEtat().getCouleur(), e.getFeu(0).getEtat().isClignotant());
        feuPNS.setEnPanne(e.isEnPanne());
        etatFeuPietonNS.setLeds(feuPNS);

        be.esi.g34754.alg3.carrefour.FeuPieton feuPEO = new be.esi.g34754.alg3.carrefour.FeuPieton(e.getFeu(1).getEtat().getCouleur(), e.getFeu(1).getEtat().isClignotant());
        feuPEO.setEnPanne(e.isEnPanne());
        etatFeuPietonEO.setLeds(feuPEO);

        be.esi.g34754.alg3.carrefour.FeuVoiture feuVNS = new be.esi.g34754.alg3.carrefour.FeuVoiture(e.getFeu(2).getEtat().getCouleur(), e.getFeu(2).getEtat().isClignotant());
        feuVNS.setEnPanne(e.isEnPanne());
        etatFeuVoitureNS.setLeds(feuVNS);

        be.esi.g34754.alg3.carrefour.FeuVoiture feuVEO = new be.esi.g34754.alg3.carrefour.FeuVoiture(e.getFeu(3).getEtat().getCouleur(), e.getFeu(3).getEtat().isClignotant());
        feuVEO.setEnPanne(e.isEnPanne());
        etatFeuVoitureEO.setLeds(feuVEO);
    }

    private void initParam(ParametresDto param) {
        paramPNSV.setText("" + param.getDureeVert(0));
        paramPNSO.setText("" + param.getDureeOrange(0));
        paramPNSR.setText("" + param.getDureeRouge(0));

        paramPEOV.setText("" + param.getDureeVert(1));
        paramPEOO.setText("" + param.getDureeOrange(1));
        paramPEOR.setText("" + param.getDureeRouge(1));

        paramVNSV.setText("" + param.getDureeVert(2));
        paramVNSO.setText("" + param.getDureeOrange(2));
        paramVNSR.setText("" + param.getDureeRouge(2));

        paramVEOV.setText("" + param.getDureeVert(3));
        paramVEOO.setText("" + param.getDureeOrange(3));
        paramVEOR.setText("" + param.getDureeRouge(3));

        paramTousRouge.setText("" + param.getDureeTousRouge());
    }

    private ParametresDto getParamDto() {
        int[] dureeVert = new int[4];
        dureeVert[0] = PNSVert.getValue();
        dureeVert[1] = PEOVert.getValue();
        dureeVert[2] = VNSVert.getValue();
        dureeVert[3] = VEOVert.getValue();
        int[] dureeOrange = new int[4];
        dureeOrange[0] = PNSOrange.getValue();
        dureeOrange[1] = PEOOrange.getValue();
        dureeOrange[2] = VNSOrange.getValue();
        dureeOrange[3] = VEOOrange.getValue();
        int[] dureeRouge = new int[4];
        dureeRouge[0] = PNSRouge.getValue();
        dureeRouge[1] = PEORouge.getValue();
        dureeRouge[2] = VNSRouge.getValue();
        dureeRouge[3] = VEORouge.getValue();
        return new ParametresDto(dureeVert, dureeOrange, dureeRouge, sliderTousRouge.getValue());
    }
}
