package be.esi.g34754.alg3.carrefour;

import java.io.Serializable;

/**
 * État des feux. Cet état peut transiter du modèle à une vue.
 *
 * Il s'agit d'un DTO (data transfer Object) dont le seul rôle est le stockage
 * de données en vue de transfert.
 *
 */
public class Etat implements Serializable {

    private FeuPieton pNS;
    private FeuPieton pEO;
    private FeuVoiture vNS;
    private FeuVoiture vEO;

    public Etat() {
        this.pNS = new FeuPieton();
        this.pEO = new FeuPieton();
        this.vNS = new FeuVoiture();
        this.vEO = new FeuVoiture();
    }

    public Etat(FeuPieton feuxP_NS, FeuPieton feuxP_EO, FeuVoiture feuxV_NS, FeuVoiture feuxV_EO) {
        this.pNS = feuxP_NS;
        this.pEO = feuxP_EO;
        this.vNS = feuxV_NS;
        this.vEO = feuxV_EO;
    }

    /**
     * @return the feuxP_NS
     */
    public FeuPieton getFeuxP_NS() {
        return pNS;
    }

    /**
     * @param feuxP_NS the feuxP_NS to set
     */
    public void setFeuxP_NS(EtatFeu etat) {
        this.pNS.setEtat(etat);
    }

    /**
     * @return the feuxP_EO
     */
    public FeuPieton getFeuxP_EO() {
        return pEO;
    }

    /**
     * @param feuxP_EO the feuxP_EO to set
     */
    public void setFeuxP_EO(EtatFeu etat) {
        this.pEO.setEtat(etat);
    }

    /**
     * @return the feuxV_NS
     */
    public FeuVoiture getFeuxV_NS() {
        return vNS;
    }

    /**
     * @param feuxV_NS the feuxV_NS to set
     */
    public void setFeuxV_NS(EtatFeu etat) {
        this.vNS.setEtat(etat);
    }

    /**
     * @return the feuxV_EO
     */
    public FeuVoiture getFeuxV_EO() {
        return vEO;
    }

    /**
     * @param feuxV_EO the feuxV_EO to set
     */
    public void setFeuxV_EO(EtatFeu etat) {
        this.vEO.setEtat(etat);
    }

    public String toString() {
        String str = "Etat du carrefour\n";
        str += "-----------------\n";
        str += "Axe Nord-Sud:\n";
        str += "-------------\n";
        str += "Feu voiture:" + vNS.getEtat().getCouleur() + " "
                + (vNS.getEtat().isClignotant() ? "clignotant\n" : "\n");
        str += "Feu pieton:" + pNS.getEtat().getCouleur() + " "
                + (pNS.getEtat().isClignotant() ? "clignotant\n" : "\n");
        str += "Axe Est-Ouest:\n";
        str += "--------------\n";
        str += "Feu voiture:" + vEO.getEtat().getCouleur() + " "
                + (vEO.getEtat().isClignotant() ? "clignotant\n" : "\n");
        str += "Feu pieton:" + pEO.getEtat().getCouleur() + " "
                + (pEO.getEtat().isClignotant() ? "clignotant\n" : "\n");
        return str;
    }

    void setTousRouge(int value) {
        this.pNS.setTousRouge(value);
        this.pEO.setTousRouge(value);
        this.vNS.setTousRouge(value);
        this.vEO.setTousRouge(value);
    }

    public int getDureeCycle() throws CarrefourException {
        int cycle = pNS.vert + pNS.orange + pNS.rouge;
        if (cycle != pEO.vert + pEO.orange + pEO.rouge
                || cycle != vNS.vert + vNS.orange + vNS.rouge
                || cycle != vEO.vert + vEO.orange + vEO.rouge) {
            throw new CarrefourException("La durée totale des feux doit être unique.");
        }
        return cycle;

    }

    public void validation() throws CarrefourException {
        String erreurs = "";
        boolean erreur = false;
        boolean[] erreurExistante = new boolean[2];
        for (int i = 0; i < 2; i++) {
            erreurExistante[i] = false;
        }
        if ((pNS.etat.getCouleur().equals(CouleurEnum.VERT) || pNS.etat.getCouleur().equals(CouleurEnum.ORANGE)) && !vNS.etat.getCouleur().equals(CouleurEnum.ROUGE)) {
            if (erreurExistante[0]) {
                erreurs += "Problème sur l'axe NS: Les pietons et les voitures peuvent avancer en même temps\n";
                erreur = true;
                erreurExistante[0] = true;
            }
        }
        if ((pEO.etat.getCouleur().equals(CouleurEnum.VERT) || pEO.etat.getCouleur().equals(CouleurEnum.ORANGE)) && !vEO.etat.getCouleur().equals(CouleurEnum.ROUGE)) {
            if (erreurExistante[1]) {
                erreurs += "Problème sur l'axe EO: Les pietons et les voitures peuvent avancer en même temps\n";
                erreur = true;
                erreurExistante[1] = true;
            }
        }
        if (erreur) {
            throw new CarrefourException(erreurs);
        }
    }
}
