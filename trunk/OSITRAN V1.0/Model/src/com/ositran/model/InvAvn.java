package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "InvAvn.findAll", query = "select o from InvAvn o") })
@Table(name = "T_INV_AVN")
public class InvAvn implements Serializable {
    private static final long serialVersionUID = 271670407741238178L;
    @Column(name = "CON_ID")
    private Integer conId;
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "IAE_ID")
    private Integer iaeId;
    @Column(name = "INV_ID")
    private Integer invId;
    @Column(name = "MCO_ID")
    private Integer mcoId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "TIA_ANYO", nullable = false)
    private Integer tiaAnyo;
    @Column(name = "TIA_ASUNTO", nullable = false, length = 4000)
    private String tiaAsunto;
    @Column(name = "TIA_DIAS_HABILES")
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
    private Integer tiaHr;
    @Column(name = "TIA_MONTO_TOTAL_APROBADO")
    private Long tiaMontoTotalAprobado;
    @Column(name = "TIA_MONTO_TOTAL_PRESENTADO")
    private Long tiaMontoTotalPresentado;
    @Column(name = "TIA_MONTO_TOTAL_REAJUSTADO")
    private Long tiaMontoTotalReajustado;
    @Id
    @Column(name = "TIA_NUMERO")
    private Integer tiaNumero;
    @Column(name = "TIA_PLAZO_EN_DIAS")
    private Integer tiaPlazoEnDías;
    @Column(name = "TIN_ID")
    private Integer tinId;    
    @Column(name = "TIA_APROBADO_POR")
    private Integer tiaAprobadoPor;
    
    @Column(name = "TIA_RUTA_NOT")
    private String tiaRutaNot;
    
    
    

    public InvAvn() {
    }

    public InvAvn(Integer conId, Integer csiId, Integer iaeId, Integer invId, Integer mcoId,
                  Integer monId, Integer tiaAnyo, String tiaAsunto, Integer tiaDiasHabiles, Date tiaFechaFin,
                  Date tiaFechaInicio, Date tiaFechaRegistro, Date tiaFechaVencimientoPlazo, Integer tiaHr,
                  Long tiaMontoTotalAprobado, Long tiaMontoTotalPresentado, Long tiaMontoTotalReajustado,
                  Integer tiaNumero, Integer tiaPlazoEnDías, Integer tinId, Integer tiaAprobadoPor, String tiaRutaNot) {
        this.conId = conId;
        this.csiId = csiId;
        this.iaeId = iaeId;
        this.invId = invId;
        this.mcoId = mcoId;
        this.monId = monId;
        this.tiaAnyo = tiaAnyo;
        this.tiaAsunto = tiaAsunto;
        this.tiaDiasHabiles = tiaDiasHabiles;
        this.tiaFechaFin = tiaFechaFin;
        this.tiaFechaInicio = tiaFechaInicio;
        this.tiaFechaRegistro = tiaFechaRegistro;
        this.tiaFechaVencimientoPlazo = tiaFechaVencimientoPlazo;
        this.tiaHr = tiaHr;
        this.tiaMontoTotalAprobado = tiaMontoTotalAprobado;
        this.tiaMontoTotalPresentado = tiaMontoTotalPresentado;
        this.tiaMontoTotalReajustado = tiaMontoTotalReajustado;
        this.tiaNumero = tiaNumero;
        this.tiaPlazoEnDías = tiaPlazoEnDías;
        this.tinId = tinId;
        this.tiaAprobadoPor = tiaAprobadoPor;
        this.tiaRutaNot = tiaRutaNot;
    }


    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setIaeId(Integer iaeId) {
        this.iaeId = iaeId;
    }

    public Integer getIaeId() {
        return iaeId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setMcoId(Integer mcoId) {
        this.mcoId = mcoId;
    }

    public Integer getMcoId() {
        return mcoId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
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

    public void setTiaHr(Integer tiaHr) {
        this.tiaHr = tiaHr;
    }

    public Integer getTiaHr() {
        return tiaHr;
    }

    public void setTiaMontoTotalAprobado(Long tiaMontoTotalAprobado) {
        this.tiaMontoTotalAprobado = tiaMontoTotalAprobado;
    }

    public Long getTiaMontoTotalAprobado() {
        return tiaMontoTotalAprobado;
    }

    public void setTiaMontoTotalPresentado(Long tiaMontoTotalPresentado) {
        this.tiaMontoTotalPresentado = tiaMontoTotalPresentado;
    }

    public Long getTiaMontoTotalPresentado() {
        return tiaMontoTotalPresentado;
    }

    public void setTiaMontoTotalReajustado(Long tiaMontoTotalReajustado) {
        this.tiaMontoTotalReajustado = tiaMontoTotalReajustado;
    }

    public Long getTiaMontoTotalReajustado() {
        return tiaMontoTotalReajustado;
    }

    public void setTiaNumero(Integer tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public Integer getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaPlazoEnDías(Integer tiaPlazoEnDías) {
        this.tiaPlazoEnDías = tiaPlazoEnDías;
    }

    public Integer getTiaPlazoEnDías() {
        return tiaPlazoEnDías;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setTiaAprobadoPor(Integer tiaAprobadoPor) {
        this.tiaAprobadoPor = tiaAprobadoPor;
    }

    public Integer getTiaAprobadoPor() {
        return tiaAprobadoPor;
    }


    public void setTiaRutaNot(String tiaRutaNot) {
        this.tiaRutaNot = tiaRutaNot;
    }

    public String getTiaRutaNot() {
        return tiaRutaNot;
    }
}
