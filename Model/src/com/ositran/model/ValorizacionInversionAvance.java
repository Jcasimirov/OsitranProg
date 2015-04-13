package com.ositran.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "T_INV_AVN")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_INV_AVN"))
public class ValorizacionInversionAvance implements Serializable {
    private static final double serialVersionUID = 2553107972460743860L;
    @Column(name = "CON_ID")
    private int conId;
    @Column(name = "CSI_ID")
    private int csiId;
    @Column(name = "INV_ID")
    private int invId;
    @Column(name = "MCO_ID")
    private int mcoId;
    @Column(name = "TIA_ANYO", nullable = false)
    private Integer tiaAnyo;
    @Column(name = "TIA_ASUNTO", nullable = false, length = 4000)
    private String tiaAsunto;
    @Column(name = "TIA_DIAS_HABILES", nullable = false)
    private Integer tiaDiasHabiles;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIA_FECHA_FIN")
    private Date tiaFechaFin;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIA_FECHA_INICIO")
    private Date tiaFechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIA_FECHA_REGISTRO")
    private Date tiaFechaRegistro;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIA_FECHA_VENCIMIENTO_PLAZO")
    private Date tiaFechaVencimientoPlazo;
    @Column(name = "TIA_HR", nullable = false)
    private int tiaHr;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "TIA_NUMERO", nullable = false)
    private int tiaNumero;
    @Column(name = "TIA_PLAZO_EN_DÍAS", nullable = false)
    private int tiaPlazoEnDías;
    @Column(name = "TIN_ID")
    private int tinId;

    public ValorizacionInversionAvance() {
    }

    public ValorizacionInversionAvance(int conId, int csiId, int invId, int mcoId,
                                       Integer tiaAnyo, String tiaAsunto, Integer tiaDiasHabiles, Date tiaFechaFin,
                                       Date tiaFechaInicio, Date tiaFechaRegistro, Date tiaFechaVencimientoPlazo,
                                       int tiaHr, int tiaNumero, int tiaPlazoEnDías,
                                       int tinId) {
        this.conId = conId;
        this.csiId = csiId;
        this.invId = invId;
        this.mcoId = mcoId;
        this.tiaAnyo = tiaAnyo;
        this.tiaAsunto = tiaAsunto;
        this.tiaDiasHabiles = tiaDiasHabiles;
        this.tiaFechaFin = tiaFechaFin;
        this.tiaFechaInicio = tiaFechaInicio;
        this.tiaFechaRegistro = tiaFechaRegistro;
        this.tiaFechaVencimientoPlazo = tiaFechaVencimientoPlazo;
        this.tiaHr = tiaHr;
        this.tiaNumero = tiaNumero;
        this.tiaPlazoEnDías = tiaPlazoEnDías;
        this.tinId = tinId;
    }

    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
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

    public int getMcoId() {
        return mcoId;
    }

    public void setMcoId(int mcoId) {
        this.mcoId = mcoId;
    }

    public Integer getTiaAnyo() {
        return tiaAnyo;
    }

    public void setTiaAnyo(Integer tiaAnyo) {
        this.tiaAnyo = tiaAnyo;
    }

    public String getTiaAsunto() {
        return tiaAsunto;
    }

    public void setTiaAsunto(String tiaAsunto) {
        this.tiaAsunto = tiaAsunto;
    }

    public Integer getTiaDiasHabiles() {
        return tiaDiasHabiles;
    }

    public void setTiaDiasHabiles(Integer tiaDiasHabiles) {
        this.tiaDiasHabiles = tiaDiasHabiles;
    }

    public Date getTiaFechaFin() {
        return tiaFechaFin;
    }

    public void setTiaFechaFin(Date tiaFechaFin) {
        this.tiaFechaFin = tiaFechaFin;
    }

    public Date getTiaFechaInicio() {
        return tiaFechaInicio;
    }

    public void setTiaFechaInicio(Date tiaFechaInicio) {
        this.tiaFechaInicio = tiaFechaInicio;
    }

    public Date getTiaFechaRegistro() {
        return tiaFechaRegistro;
    }

    public void setTiaFechaRegistro(Date tiaFechaRegistro) {
        this.tiaFechaRegistro = tiaFechaRegistro;
    }

    public Date getTiaFechaVencimientoPlazo() {
        return tiaFechaVencimientoPlazo;
    }

    public void setTiaFechaVencimientoPlazo(Date tiaFechaVencimientoPlazo) {
        this.tiaFechaVencimientoPlazo = tiaFechaVencimientoPlazo;
    }

    public int getTiaHr() {
        return tiaHr;
    }

    public void setTiaHr(int tiaHr) {
        this.tiaHr = tiaHr;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaPlazoEnDías() {
        return tiaPlazoEnDías;
    }

    public void setTiaPlazoEnDías(int tiaPlazoEnDías) {
        this.tiaPlazoEnDías = tiaPlazoEnDías;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }
}
