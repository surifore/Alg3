/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.outils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.util.Timer;
import javax.swing.BoxLayout;

/**
 * Cette classe permet de créer un javabean représentant un panel comprenant une
 * led. Cette led sera positionnée en haut à gauche du panel et aura une taille
 * maximale tout en gardant une forme ronde.
 *
 * @author Florian Delporte
 */
public class Led extends javax.swing.JPanel implements Serializable {

    private Color color;
    private boolean clignote;
    private Timer clignoteTimer;
    private boolean on;
    private int multiplicateur;
    /**
     * Le cercle qui simule la Led.
     */
    protected Ellipse2D oval;
    /**
     * Le nom de la propriété correspondant à la couleur de la led.
     */
    public static final String COULEUR_CHANGED = "color";
    /**
     * Le nom de la propriété correspondant à l'état (Allumé/éteint) de la led.
     */
    public static final String ALLUME_CHANGED = "on";

    /**
     * Crée un panel contenant une led sans couleur et éteinte. Cette led sera
     * positionnée en haut à gauche du panel et aura une taille maximale tout en
     * gardant une forme ronde.
     */
    public Led() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        color = null;
        on = false;
        oval = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
        clignote = false;
        clignoteTimer = new Timer();
        multiplicateur = 1;
    }

    /**
     * Récupère la couleur de la led.
     *
     * @return la couleur
     */
    public Color getColor() {
        return color;
    }

    /**
     * Assigne une couleur à la led.
     *
     * @param color la couleur à assigner à la led.
     */
    public void setColor(Color color) {
        Color save = this.color;
        this.color = color;
        firePropertyChange(COULEUR_CHANGED, save, color);
    }

    /**
     * Récupère l'état De la Led: allumé ou éteint.
     *
     * @return l'état de la Led. True=Allumé, false=éteint.
     */
    public boolean isOn() {
        return on;
    }

    /**
     * Assigne un état à la Led.
     *
     * @param on L'état à mettre dans la Led. True = allumé,false=éteint.
     */
    public void setOn(boolean on) {
        boolean save = this.on;
        this.on = on;
        firePropertyChange(ALLUME_CHANGED, save, on);
        repaint();
    }

    /**
     * Dessine un Cercle en haut à gauche du panel et lui donne une taille
     * maximale afin qu'il reste un cercle.
     *
     * @param g Les graphiques contenus dans la fenêtre.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int rayon = (getWidth() < getHeight()) ? getWidth() : getHeight();
        oval = new Ellipse2D.Double(0, 0, rayon, rayon);
        g.drawOval(0, 0, rayon, rayon);
        if (on) {
            g.setColor(color);
            g.fillOval(0, 0, rayon, rayon);
        }
    }

    /**
     * Inverse l'état(allumé,éteint) de la Led.
     */
    public void inverse() {
        setOn(!on);
    }

    public boolean isClignotant() {
        return clignote;
    }

    public void setClignotant(boolean clignote) {
        if (this.clignote != clignote) {
            this.clignote = clignote;
            if (this.clignote) {
                clignoteTimer = new Timer();
                clignoteTimer.schedule(new LedTimerTask(this), 0, 500 / multiplicateur);
            } else {
                clignoteTimer.cancel();
            }
        }
    }

    /**
     * @return the multiplicateur
     */
    public int getMultiplicateur() {
        return multiplicateur;
    }

    /**
     * @param multiplicateur the multiplicateur to set
     */
    public void setMultiplicateur(int multiplicateur) {
        if (multiplicateur <= 0) {
            throw new IllegalArgumentException("Le multiplicateur de vitesse ne peut pas être négatif ou nul.");
        }
        this.multiplicateur = multiplicateur;
    }
}
