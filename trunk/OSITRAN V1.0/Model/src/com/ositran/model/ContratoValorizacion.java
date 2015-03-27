package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "ContratoValorizacion.findAll", query = "select o from ContratoValorizacion o") })
@Table(name = "T_CONTRATO_VALORIZACION")

public class ContratoValorizacion implements Serializable {
    private static final long serialVersionUID = 3454886805327416604L;
    @Column(length = 20)
    private String alcance;
    @Id
    @Column(name = "CON_ID", nullable = false)
    private BigDecimal conId;
    @Column(name = "CVA_ID")
    private BigDecimal cvaId;
    @Column(name = "CVA_MONTO", nullable = false)
    private Long cvaMonto;
    @Temporal(TemporalType.DATE)
    @Column(name = "CVL_FECHA")
    private Date cvlFecha;
    @Id
    @Column(name = "CVL_ID", nullable = false)
    private BigDecimal cvlId;
    private BigDecimal duración;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;
    @Id
    @Column(name = "TIN_ID", nullable = false)
    private BigDecimal tinId;

    public ContratoValorizacion() {
    }

    public ContratoValorizacion(String alcance, BigDecimal conId, BigDecimal cvaId, Long cvaMonto, Date cvlFecha,
                                BigDecimal cvlId, BigDecimal duración, Date fechaInicio, BigDecimal tinId) {
        this.alcance = alcance;
        this.conId = conId;
        this.cvaId = cvaId;
        this.cvaMonto = cvaMonto;
        this.cvlFecha = cvlFecha;
        this.cvlId = cvlId;
        this.duración = duración;
        this.fechaInicio = fechaInicio;
        this.tinId = tinId;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public BigDecimal getConId() {
        return conId;
    }

    public void setConId(BigDecimal conId) {
        this.conId = conId;
    }

    public BigDecimal getCvaId() {
        return cvaId;
    }

    public void setCvaId(BigDecimal cvaId) {
        this.cvaId = cvaId;
    }

    public Long getCvaMonto() {
        return cvaMonto;
    }

    public void setCvaMonto(Long cvaMonto) {
        this.cvaMonto = cvaMonto;
    }

    public Date getCvlFecha() {
        return cvlFecha;
    }

    public void setCvlFecha(Date cvlFecha) {
        this.cvlFecha = cvlFecha;
    }

    public BigDecimal getCvlId() {
        return cvlId;
    }

    public void setCvlId(BigDecimal cvlId) {
        this.cvlId = cvlId;
    }

    public BigDecimal getDuración() {
        return duración;
    }

    public void setDuración(BigDecimal duración) {
        this.duración = duración;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }
}
