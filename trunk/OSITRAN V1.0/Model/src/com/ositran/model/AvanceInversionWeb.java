package com.ositran.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_AVANCE_INVERSION_WEB")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_AVANCE_INVERSION_WEB"))

public class AvanceInversionWeb implements Serializable {
    private static final long serialVersionUID = -4685816540624051037L;
    @Column(name = "CSI_ID", nullable = false)
    private int csiId;
    @Column(name = "INV_ID")
    private int invId;
    @Temporal(TemporalType.DATE)
    @Column(name = "IWC_FECHA_FIN")
    private Date iwcFechaFin;
    @Temporal(TemporalType.DATE)
    @Column(name = "IWC_FECHA_INICIO")
    private Date iwcFechaInicio;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IWC_ID", nullable = false)
    private int iwcId;
    @Column(name = "MCO_ID", nullable = false)
    private int mcoId;
    @Column(name = "MON_ID")
    private int monId;
    @Column(name = "TIN_ID", nullable = false)
    private int tinId;

    public AvanceInversionWeb() {
    }

    public AvanceInversionWeb(int csiId, int invId, Date iwcFechaFin, Date iwcFechaInicio,
                               int iwcId, int mcoId, int monId, int tinId) {
        this.csiId = csiId;
        this.invId = invId;
        this.iwcFechaFin = iwcFechaFin;
        this.iwcFechaInicio = iwcFechaInicio;
        this.iwcId = iwcId;
        this.mcoId = mcoId;
        this.monId = monId;
        this.tinId = tinId;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getInvId() {
        return invId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
    }

    public Date getIwcFechaFin() {
        return iwcFechaFin;
    }

    public void setIwcFechaFin(Date iwcFechaFin) {
        this.iwcFechaFin = iwcFechaFin;
    }

    public Date getIwcFechaInicio() {
        return iwcFechaInicio;
    }

    public void setIwcFechaInicio(Date iwcFechaInicio) {
        this.iwcFechaInicio = iwcFechaInicio;
    }

    public int getIwcId() {
        return iwcId;
    }

    public void setIwcId(int iwcId) {
        this.iwcId = iwcId;
    }

    public int getMcoId() {
        return mcoId;
    }

    public void setMcoId(int mcoId) {
        this.mcoId = mcoId;
    }

    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }
}
