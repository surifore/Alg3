/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.outils;

import java.util.TimerTask;

/**
 *
 * @author g34754
 */
public class LedTimerTask extends TimerTask{
    private Led led;

    public LedTimerTask(Led led) {
        this.led = led;
    }

    @Override
    public void run() {
        led.inverse();
    }
    
}
