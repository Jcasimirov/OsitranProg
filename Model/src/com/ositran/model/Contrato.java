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
@NamedQueries({ @NamedQuery(name = "TContrato.findAll", query = "select o from TContrato o") })
@Table(name = "T_CONTRATO")
@IdClass(TContratoPK.class)
public class Contrato implements Serializable {
    private static final long serialVersionUID = -6231748415809997361L;
    @Column(name = "CNC_ID")
    private BigDecimal cncId;
    @Column(name = "CON_CONCESION", nullable = false, length = 4000)
    private String conConcesion;
    @Column(name = "CON_ESTADO", nullable = false)
    private BigDecimal conEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_ALTA")
    private Date conFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_BAJA")
    private Date conFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_CAMBIO")
    private Date conFechaCambio;
    @Id
    @Column(name = "CON_ID", nullable = false)
    private BigDecimal conId;
    @Column(name = "CON_TERMINAL", length = 20)
    private String conTerminal;
    @Column(name = "CON_USUARIO_ALTA", length = 20)
    private String conUsuarioAlta;
    @Column(name = "CON_USUARIO_BAJA", length = 20)
    private String conUsuarioBaja;
    @Column(name = "CON_USUARIO_CAMBIO", length = 20)
    private String conUsuarioCambio;
    @Column(name = "MCO_ID", nullable = false)
    private BigDecimal mcoId;
    @Column(name = "MON_ID")
    private BigDecimal monId;
    @Id
    @Column(name = "TIN_ID", nullable = false)
    private BigDecimal tinId;
    @Column(name = "TIV_ID")
    private BigDecimal tivId;
    @Column(name = "TOTAL_DE_LA_VALORIZACIÓN")
    private BigDecimal totalDeLaValorización;

    public Contrato() {
    }

    public Contrato(BigDecimal cncId, String conConcesion, BigDecimal conEstado, Date conFechaAlta, Date conFechaBaja,
                     Date conFechaCambio, BigDecimal conId, String conTerminal, String conUsuarioAlta,
                     String conUsuarioBaja, String conUsuarioCambio, BigDecimal mcoId, BigDecimal monId,
                     BigDecimal tinId, BigDecimal tivId, BigDecimal totalDeLaValorización) {
        this.cncId = cncId;
        this.conConcesion = conConcesion;
        this.conEstado = conEstado;
        this.conFechaAlta = conFechaAlta;
        this.conFechaBaja = conFechaBaja;
        this.conFechaCambio = conFechaCambio;
        this.conId = conId;
        this.conTerminal = conTerminal;
        this.conUsuarioAlta = conUsuarioAlta;
        this.conUsuarioBaja = conUsuarioBaja;
        this.conUsuarioCambio = conUsuarioCambio;
        this.mcoId = mcoId;
        this.monId = monId;
        this.tinId = tinId;
        this.tivId = tivId;
        this.totalDeLaValorización = totalDeLaValorización;
    }

    public BigDecimal getCncId() {
        return cncId;
    }

    public void setCncId(BigDecimal cncId) {
        this.cncId = cncId;
    }

    public String getConConcesion() {
        return conConcesion;
    }

    public void setConConcesion(String conConcesion) {
        this.conConcesion = conConcesion;
    }

    public BigDecimal getConEstado() {
        return conEstado;
    }

    public void setConEstado(BigDecimal conEstado) {
        this.conEstado = conEstado;
    }

    public Date getConFechaAlta() {
        return conFechaAlta;
    }

    public void setConFechaAlta(Date conFechaAlta) {
        this.conFechaAlta = conFechaAlta;
    }

    public Date getConFechaBaja() {
        return conFechaBaja;
    }

    public void setConFechaBaja(Date conFechaBaja) {
        this.conFechaBaja = conFechaBaja;
    }

    public Date getConFechaCambio() {
        return conFechaCambio;
    }

    public void setConFechaCambio(Date conFechaCambio) {
        this.conFechaCambio = conFechaCambio;
    }

    public BigDecimal getConId() {
        return conId;
    }

    public void setConId(BigDecimal conId) {
        this.conId = conId;
    }

    public String getConTerminal() {
        return conTerminal;
    }

    public void setConTerminal(String conTerminal) {
        this.conTerminal = conTerminal;
    }

    public String getConUsuarioAlta() {
        return conUsuarioAlta;
    }

    public void setConUsuarioAlta(String conUsuarioAlta) {
        this.conUsuarioAlta = conUsuarioAlta;
    }

    public String getConUsuarioBaja() {
        return conUsuarioBaja;
    }

    public void setConUsuarioBaja(String conUsuarioBaja) {
        this.conUsuarioBaja = conUsuarioBaja;
    }

    public String getConUsuarioCambio() {
        return conUsuarioCambio;
    }

    public void setConUsuarioCambio(String conUsuarioCambio) {
        this.conUsuarioCambio = conUsuarioCambio;
    }

    public BigDecimal getMcoId() {
        return mcoId;
    }

    public void setMcoId(BigDecimal mcoId) {
        this.mcoId = mcoId;
    }

    public BigDecimal getMonId() {
        return monId;
    }

    public void setMonId(BigDecimal monId) {
        this.monId = monId;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }

    public BigDecimal getTivId() {
        return tivId;
    }

    public void setTivId(BigDecimal tivId) {
        this.tivId = tivId;
    }

    public BigDecimal getTotalDeLaValorización() {
        return totalDeLaValorización;
    }

    public void setTotalDeLaValorización(BigDecimal totalDeLaValorización) {
        this.totalDeLaValorización = totalDeLaValorización;
    }
}
