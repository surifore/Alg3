/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.dto;

/**
 *
 * @author Florian
 */
public class ParametresDto {
    
    private int[] dureeRouge;
    private int[] dureeVert;
    private int[] dureeOrange;
    private int dureeTousRouge;

    public ParametresDto(int[] dureeVert, int[] dureeOrange, int[] dureeRouge, int dureeTousRouge) {
        this.dureeRouge = dureeRouge;
        this.dureeVert = dureeVert;
        this.dureeOrange = dureeOrange;
        this.dureeTousRouge = dureeTousRouge;
    }

    /**
     * Get the value of dureeTousRouge
     *
     * @return the value of dureeTousRouge
     */
    public int getDureeTousRouge() {
        return dureeTousRouge;
    }

    /**
     * Set the value of dureeTousRouge
     *
     * @param dureeTousRouge new value of dureeTousRouge
     */
    public void setDureeTousRouge(int dureeTousRouge) {
        this.dureeTousRouge = dureeTousRouge;
    }

    /**
     * Get the value of dureeOrange
     *
     * @return the value of dureeOrange
     */
    public int getDureeOrange(int i) {
        return dureeOrange[i];
    }

    /**
     * Set the value of dureeOrange
     *
     * @param dureeOrange new value of dureeOrange
     */
    public void setDureeOrange(int i,int dureeOrange) {
        this.dureeOrange[i] = dureeOrange;
    }

    /**
     * Get the value of dureeVert
     *
     * @return the value of dureeVert
     */
    public int getDureeVert(int i) {
        return dureeVert[i];
    }

    /**
     * Set the value of dureeVert
     *
     * @param dureeVert new value of dureeVert
     */
    public void setDureeVert(int i,int dureeVert) {
        this.dureeVert[i]= dureeVert;
    }

    /**
     * Get the value of dureeRouge
     *
     * @return the value of dureeRouge
     */
    public int getDureeRouge(int i) {
        return dureeRouge[i];
    }

    /**
     * Set the value of dureeRouge
     *
     * @param dureeRouge new value of dureeRouge
     */
    public void setDureeRouge(int i,int dureeRouge) {
        this.dureeRouge[i] = dureeRouge;
    }

}
