/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.outils;

import java.util.TimerTask;

/**
 * Action effectuée par la led quand elle clignote
 * @author Florian Delporte
 */
public class LedTimerTask extends TimerTask{
    private Led led;

    /**
     * Construit l'action effectuée par la led quand elle clignote
     * @param led la led qui doit clignoter
     */
    public LedTimerTask(Led led) {
        this.led = led;
    }

    /**
     * action effectuée par la led
     */
    @Override
    public void run() {
        led.inverse();
    }
    
}
