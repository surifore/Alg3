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

    /**
     * Construit l'état des feux du Carrefour.
     */
    public Etat() {
        this.pNS = new FeuPieton();
        this.pEO = new FeuPieton();
        this.vNS = new FeuVoiture();
        this.vEO = new FeuVoiture();
    }

    /**
     * Construit l'état des feux du Carrefour à partir des 4 feux.
     *
     * @param feuxP_NS le FeuPieton de l'axe Nord-Sud
     * @param feuxP_EO le FeuPieton de l'axe Est-Ouest
     * @param feuxV_NS le FeuVoiture de l'axe Nord-Sud
     * @param feuxV_EO le FeuVoiture de l'axe Est-Ouest
     */
    public Etat(FeuPieton feuxP_NS, FeuPieton feuxP_EO, FeuVoiture feuxV_NS, FeuVoiture feuxV_EO) {
        this.pNS = feuxP_NS;
        this.pEO = feuxP_EO;
        this.vNS = feuxV_NS;
        this.vEO = feuxV_EO;
    }

    /**
     * Permet de récupérer le FeuPieton sur l'axe Nord-Sud
     *
     * @return le FeuPieton sur l'axe Nord-Sud
     */
    public FeuPieton getFeuxP_NS() {
        return pNS;
    }

    /**
     * Attribue un FeuPieton sur l'axe Nord-Sud
     *
     * @param feuxP_NS le FeuPieton pour l'axe Nord-Sud
     */
    public void setFeuxP_NS(EtatFeu etat) {
        this.pNS.setEtat(etat);
    }

    /**
     * Permet de récupérer le FeuPieton sur l'axe Est-Ouest
     *
     * @return le FeuPieton sur l'axe Est-Ouest
     */
    public FeuPieton getFeuxP_EO() {
        return pEO;
    }

    /**
     * Attribue un FeuPieton sur l'axe Est-Ouest
     *
     * @param feuxP_NS le FeuPieton pour l'axe Est-Ouest
     */
    public void setFeuxP_EO(EtatFeu etat) {
        this.pEO.setEtat(etat);
    }

    /**
     * Permet de récupérer le FeuPieton sur l'axe Nord-Sud
     *
     * @return le FeuPieton sur l'axe Nord-Sud
     */
    public FeuVoiture getFeuxV_NS() {
        return vNS;
    }

    /**
     * Attribue un FeuPieton sur l'axe Nord-Sud
     *
     * @param feuxP_NS le FeuPieton pour l'axe Nord-Sud
     */
    public void setFeuxV_NS(EtatFeu etat) {
        this.vNS.setEtat(etat);
    }

    /**
     * Permet de récupérer le FeuPieton sur l'axe Est-Ouest
     *
     * @return le FeuPieton sur l'axe Est-Ouest
     */
    public FeuVoiture getFeuxV_EO() {
        return vEO;
    }

    /**
     * Attribue un FeuPieton sur l'axe Est-Ouest
     *
     * @param feuxP_NS le FeuPieton pour l'axe Est-Ouest
     */
    public void setFeuxV_EO(EtatFeu etat) {
        this.vEO.setEtat(etat);
    }

    /**
     * Affiche l'état du Carrefour
     *
     * @return l'état du Carrefour
     */
    @Override
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

    /**
     * Permet d'attribuer une durée à la période où tous les feux sont à rouges
     *
     * @param value durée de la période où tous les feux sont à rouges
     */
    void setTousRouge(int value) {
        this.pNS.setTousRouge(value);
        this.pEO.setTousRouge(value);
        this.vNS.setTousRouge(value);
        this.vEO.setTousRouge(value);
    }

    /**
     * Retourne la durée totale d'un cycle du Carrefour
     *
     * @return la durée totale d'un cycle du Carrefour
     * @throws CarrefourException Lorsque tous les feux n'ont pas la même durée
     * totale.
     */
    public int getDureeCycle() throws CarrefourException {
        int cycle = pNS.vert + pNS.orange + pNS.rouge;
        if (cycle != pEO.vert + pEO.orange + pEO.rouge
                || cycle != vNS.vert + vNS.orange + vNS.rouge
                || cycle != vEO.vert + vEO.orange + vEO.rouge) {
            throw new CarrefourException("La durée totale des feux doit être unique.");
        }
        return cycle;

    }

    /**
     * Peremt de valider l'état du Carrefour.
     *
     * @throws CarrefourException Lorsque le Carrefour se trouve dans un état
     * incorrect.
     */
    public void validation() throws CarrefourException {
        String erreurs = "";
        boolean erreur = false;
        boolean[] erreurExistante = new boolean[2];
        for (int i = 0; i < 2; i++) {
            erreurExistante[i] = false;
        }
        if ((pNS.etat.getCouleur().equals(CouleurEnum.VERT)) && !vNS.etat.getCouleur().equals(CouleurEnum.ROUGE)) {
            if (erreurExistante[0]) {
                erreurs += "Problème sur l'axe NS: Les pietons et les voitures peuvent avancer en même temps\n";
                erreur = true;
                erreurExistante[0] = true;
            }
        }
        if ((vNS.etat.getCouleur().equals(CouleurEnum.VERT) || vNS.etat.getCouleur().equals(CouleurEnum.ORANGE)) && !pNS.etat.getCouleur().equals(CouleurEnum.ROUGE)) {
            if (erreurExistante[0]) {
                erreurs += "Problème sur l'axe NS: Les pietons et les voitures peuvent avancer en même temps\n";
                erreur = true;
                erreurExistante[0] = true;
            }
        }
        if ((pEO.etat.getCouleur().equals(CouleurEnum.VERT)) && !vEO.etat.getCouleur().equals(CouleurEnum.ROUGE)) {
            if (erreurExistante[1]) {
                erreurs += "Problème sur l'axe EO: Les pietons et les voitures peuvent avancer en même temps\n";
                erreur = true;
                erreurExistante[1] = true;
            }
        }
        if ((vEO.etat.getCouleur().equals(CouleurEnum.VERT) || vEO.etat.getCouleur().equals(CouleurEnum.ORANGE)) && !pEO.etat.getCouleur().equals(CouleurEnum.ROUGE)) {
            if (erreurExistante[0]) {
                erreurs += "Problème sur l'axe EO: Les pietons et les voitures peuvent avancer en même temps\n";
                erreur = true;
                erreurExistante[0] = true;
            }
        }
        if ((vNS.etat.getCouleur().equals(CouleurEnum.VERT) || vNS.etat.getCouleur().equals(CouleurEnum.ORANGE)) && !vEO.etat.getCouleur().equals(CouleurEnum.ROUGE)) {
            if (erreurExistante[0]) {
                erreurs += "Problème sur l'axe NS: Les pietons et les voitures peuvent avancer en même temps\n";
                erreur = true;
                erreurExistante[0] = true;
            }
        }
        if (erreur) {
            throw new CarrefourException(erreurs);
        }
    }

    /**
     * Permet de récupérer le Feu en fonction de si c'est un FeuVoiture ou si
     * c'est sur l'axe Nord-Sud
     *
     * @param voiture Le feu recherché est un FeuVoiture
     * @param axeNS Le feu recherché est sur l'axe Nord-Sud
     * @return Le Feu recherché
     */
    public Feu getFeu(boolean voiture, boolean axeNS) {
        if (voiture) {
            if (axeNS) {
                return vNS;
            } else {
                return vEO;
            }
        } else if (axeNS) {
            return pNS;
        } else {
            return pEO;
        }
    }

    /**
     * Permet de récupérer le Feu en fonction de son numéro. 0 correspond au
     * FeuPieton sur l'axe Nord-Sud. 1 correspond au FeuPieton sur l'axe
     * Est-Ouest. 2 correspond au FeuVoiture sur l'axe Nord-Sud. 3 correspond au
     * Feu Voiture sur l'axe Est-Ouest.
     *
     * @param i le numéro du feu recherché
     * @return le Feu recherché.
     */
    public Feu getFeu(int i) {
        switch (i) {
            case 0:
                return pNS;
            case 1:
                return pEO;
            case 2:
                return vNS;
            case 3:
                return vEO;
            default:
                throw new IllegalArgumentException("Numéro de feu incorrect");
        }
    }
    
    public boolean isEnPanne(){
        return pNS.enPanne;
    }
   
}
