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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_INV_AVN",uniqueConstraints = @UniqueConstraint(columnNames = {"TIA_NUMERO"}))
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_INV_AVN"))
public class ValorizacionInversionAvance implements Serializable {
    private static final double serialVersionUID = 2553107972460743860L;
    @Column(name = "CON_ID")
    private int conId;
    @Column(name = "CSI_ID")
    private int csiId;
    @Column(name = "IAE_ID")
    private int iaeId;
    @Column(name = "INV_ID")
    private int invId;
    @Column(name = "MCO_ID")
    private int mcoId;
    @Column(name = "MON_ID")
    private int monId;
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
    @Column(name = "TIA_MONTO_TOTAL_APROBADO", length = 4000)
    private String tiaMontoTotalAprobado;
    @Column(name = "TIA_MONTO_TOTAL_PRESENTADO", nullable = false)
    private double tiaMontoTotalPresentado;
    @Column(name = "TIA_MONTO_TOTAL_REAJUSTADO", nullable = false)
    private double tiaMontoTotalReajustado;
    @Column(name = "TIA_PLAZO_EN_DIAS", nullable = false)
    private int tiaPlazoEnDias;
    @Column(name = "TIN_ID")
    private int tinId;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "TIA_NUMERO", nullable = false)
    private int tiaNumero;
   

    public ValorizacionInversionAvance() {
    }

    public ValorizacionInversionAvance(int conId, int csiId, int invId, int mcoId,
                                       Integer tiaAnyo, String tiaAsunto, Integer tiaDiasHabiles, Date tiaFechaFin,
                                       Date tiaFechaInicio, Date tiaFechaRegistro, Date tiaFechaVencimientoPlazo,
                                       int tiaHr, int tiaNumero, int tiaPlazoEnDias,
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
        this.tiaPlazoEnDias = tiaPlazoEnDias;
        this.tinId = tinId;
    }


    public void setConId(int conId) {
        this.conId = conId;
    }

    public int getConId() {
        return conId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setIaeId(int iaeId) {
        this.iaeId = iaeId;
    }

    public int getIaeId() {
        return iaeId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
    }

    public int getInvId() {
        return invId;
    }

    public void setMcoId(int mcoId) {
        this.mcoId = mcoId;
    }

    public int getMcoId() {
        return mcoId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getMonId() {
        return monId;
    }

    public void setTiaAnyo(Integer tiaAnyo) {
        this.tiaAnyo = tiaAnyo;
    }

    public Integer getTiaAnyo() {
        return tiaAnyo;
    }

    public void setTiaAsunto(String tiaAsunto) {
        this.tiaAsunto = tiaAsunto;
    }

    public String getTiaAsunto() {
        return tiaAsunto;
    }

    public void setTiaDiasHabiles(Integer tiaDiasHabiles) {
        this.tiaDiasHabiles = tiaDiasHabiles;
    }

    public Integer getTiaDiasHabiles() {
        return tiaDiasHabiles;
    }

    public void setTiaFechaFin(Date tiaFechaFin) {
        this.tiaFechaFin = tiaFechaFin;
    }

    public Date getTiaFechaFin() {
        return tiaFechaFin;
    }

    public void setTiaFechaInicio(Date tiaFechaInicio) {
        this.tiaFechaInicio = tiaFechaInicio;
    }

    public Date getTiaFechaInicio() {
        return tiaFechaInicio;
    }

    public void setTiaFechaRegistro(Date tiaFechaRegistro) {
        this.tiaFechaRegistro = tiaFechaRegistro;
    }

    public Date getTiaFechaRegistro() {
        return tiaFechaRegistro;
    }

    public void setTiaFechaVencimientoPlazo(Date tiaFechaVencimientoPlazo) {
        this.tiaFechaVencimientoPlazo = tiaFechaVencimientoPlazo;
    }

    public Date getTiaFechaVencimientoPlazo() {
        return tiaFechaVencimientoPlazo;
    }

    public void setTiaHr(int tiaHr) {
        this.tiaHr = tiaHr;
    }

    public int getTiaHr() {
        return tiaHr;
    }

    public void setTiaMontoTotalAprobado(String tiaMontoTotalAprobado) {
        this.tiaMontoTotalAprobado = tiaMontoTotalAprobado;
    }

    public String getTiaMontoTotalAprobado() {
        return tiaMontoTotalAprobado;
    }

    public void setTiaMontoTotalPresentado(double tiaMontoTotalPresentado) {
        this.tiaMontoTotalPresentado = tiaMontoTotalPresentado;
    }

    public double getTiaMontoTotalPresentado() {
        return tiaMontoTotalPresentado;
    }

    public void setTiaMontoTotalReajustado(double tiaMontoTotalReajustado) {
        this.tiaMontoTotalReajustado = tiaMontoTotalReajustado;
    }

    public double getTiaMontoTotalReajustado() {
        return tiaMontoTotalReajustado;
    }

    public void setTiaPlazoEnDias(int tiaPlazoEnDias) {
        this.tiaPlazoEnDias = tiaPlazoEnDias;
    }

    public int getTiaPlazoEnDias() {
        return tiaPlazoEnDias;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }


}
