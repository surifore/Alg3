/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.entity;

import be.esi.g34754.alg3.carrefour.CouleurEnum;
import be.esi.g34754.alg3.carrefour.Etat;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Florian
 */
@Entity
public class ChangementFeu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private short colorVNS;
    private short colorVEO;
    private short colorPNS;
    private short colorPEO;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateChangement;
    private short heureChangement;
    private short minuteChangement;
    private short secondeChangement;

    public ChangementFeu(Etat etat) {
        colorVNS=CouleurEnum.shortValueOf(etat.getFeuxV_NS().getEtat().getCouleur().toString());
        colorPNS=CouleurEnum.shortValueOf(etat.getFeuxP_NS().getEtat().getCouleur().toString());
        colorVEO=CouleurEnum.shortValueOf(etat.getFeuxV_EO().getEtat().getCouleur().toString());
        colorPEO=CouleurEnum.shortValueOf(etat.getFeuxP_EO().getEtat().getCouleur().toString());
        GregorianCalendar date=new GregorianCalendar();
        dateChangement=date.getGregorianChange();
        heureChangement=(short)date.get(Calendar.HOUR);
        minuteChangement=(short)date.get(Calendar.MINUTE);
        secondeChangement=(short)date.get(Calendar.SECOND);
    }
    
    public ChangementFeu() {        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChangementFeu))
            return false;
        ChangementFeu other = (ChangementFeu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "be.esi.g34754.alg3.carrefour.entity.ChangementFeu[ id=" + id + " ]";
    }

    /**
     * @return the colorVNS
     */
    public short getColorVNS() {
        return colorVNS;
    }

    /**
     * @param colorVNS the colorVNS to set
     */
    public void setColorVNS(short colorVNS) {
        this.colorVNS = colorVNS;
    }

    /**
     * @return the colorVEO
     */
    public short getColorVEO() {
        return colorVEO;
    }

    /**
     * @param colorVEO the colorVEO to set
     */
    public void setColorVEO(short colorVEO) {
        this.colorVEO = colorVEO;
    }

    /**
     * @return the colorPNS
     */
    public short getColorPNS() {
        return colorPNS;
    }

    /**
     * @param colorPNS the colorPNS to set
     */
    public void setColorPNS(short colorPNS) {
        this.colorPNS = colorPNS;
    }

    /**
     * @return the colorPEO
     */
    public short getColorPEO() {
        return colorPEO;
    }

    /**
     * @param colorPEO the colorPEO to set
     */
    public void setColorPEO(short colorPEO) {
        this.colorPEO = colorPEO;
    }

    public Date getDateChangement() {
        return dateChangement;
    }

    public void setDateChangement(Date dateChangement) {
        this.dateChangement = dateChangement;
    }

    public short getHeureChangement() {
        return heureChangement;
    }

    public void setHeureChangement(short heureChangement) {
        this.heureChangement = heureChangement;
    }

    public short getMinuteChangement() {
        return minuteChangement;
    }

    public void setMinuteChangement(short minuteChangement) {
        this.minuteChangement = minuteChangement;
    }

    public short getSecondeChangement() {
        return secondeChangement;
    }

    public void setSecondeChangement(short secondeChangement) {
        this.secondeChangement = secondeChangement;
    }
    
}
