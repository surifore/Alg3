/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour;

import java.util.TimerTask;

/**
 *
 * @author g34754
 */
public class CarrefourTask extends TimerTask {

    private long duree;
    private Etat etat;

    public CarrefourTask(Etat etat) {
        duree = 0;
        this.etat=etat;
        etat.setFeuxP_NS(new EtatFeu(CouleurEnum.ROUGE, false));
        etat.setFeuxV_NS(new EtatFeu(CouleurEnum.VERT, false));
        etat.setFeuxP_EO(new EtatFeu(CouleurEnum.VERT, false));
        etat.setFeuxV_EO(new EtatFeu(CouleurEnum.ROUGE, false));
    }

    @Override
    public void run() {
        mAJPieton(etat.getFeuxP_NS());
        mAJPieton(etat.getFeuxP_EO());
        mAJVoiture(etat.getFeuxV_NS());
        mAJVoiture(etat.getFeuxV_EO());
        System.out.println(etat);
        ++duree;
    }

    private void mAJPieton(FeuPieton feu) {
        int etape=(int)duree%(feu.getRouge()+feu.getVert()+feu.getClignotement());
        if(!feu.isEnPanne()){
            if(etape%feu.getVert()>0){
                etape=etape-feu.getVert();
                if(etape%feu.getClignotement()>0){
                    if(!feu.getEtat().getCouleur().equals(CouleurEnum.ROUGE)){
                        feu.setEtat(CouleurEnum.ROUGE);
                        feu.setClignotant(false);
                    }
                }else{
                    if(!feu.getEtat().getCouleur().equals(CouleurEnum.VERT)&&feu.getEtat().isClignotant()){
                        feu.setEtat(CouleurEnum.VERT);
                        feu.setClignotant(true);
                    }
                }
            }else{
                if(!feu.getEtat().getCouleur().equals(CouleurEnum.VERT)&&!feu.getEtat().isClignotant()){
                        feu.setEtat(CouleurEnum.VERT);
                        feu.setClignotant(false);
                    }
            }
        }
    }
    
    private void mAJVoiture(FeuVoiture feu) {
        int etape=(int)duree%(feu.getRouge()+feu.getVert()+feu.getOrange());
        if(!feu.isEnPanne()){
            if(etape%feu.getVert()>0){
                etape=etape-feu.getVert();
                if(etape%feu.getOrange()>0){
                    if(!feu.getEtat().getCouleur().equals(CouleurEnum.ROUGE)){
                        feu.setEtat(CouleurEnum.ROUGE);
                    }
                }else{
                    if(!feu.getEtat().getCouleur().equals(CouleurEnum.ORANGE)){
                        feu.setEtat(CouleurEnum.ORANGE);
                    }
                }
            }else{
                if(!feu.getEtat().getCouleur().equals(CouleurEnum.VERT)){
                        feu.setEtat(CouleurEnum.VERT);
                    }
            }
        }
    }
}
