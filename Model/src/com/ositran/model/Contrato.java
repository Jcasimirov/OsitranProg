package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({ @NamedQuery(name = "TContrato.findAll", query = "select o from TContrato o") })
@Table(name = "T_CONTRATO")
@IdClass(TContratoPK.class)
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "Seq_Contrato"))
public class Contrato implements Serializable {
    private static final long serialVersionUID = -6231748415809997361L;
    @Column(name = "CNC_ID")
    private Integer cncId;
    @Column(name = "CON_CONCESION", nullable = false, length = 4000)
    private String conConcesion;
    @Column(name = "CON_ESTADO", nullable = false)
    private Integer conEstado;
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
    @GeneratedValue(generator = "generator")
    private Integer conId;
    @Column(name = "CON_TERMINAL", length = 20)
    private String conTerminal;
    @Column(name = "CON_USUARIO_ALTA", length = 20)
    private String conUsuarioAlta;
    @Column(name = "CON_USUARIO_BAJA", length = 20)
    private String conUsuarioBaja;
    @Column(name = "CON_USUARIO_CAMBIO", length = 20)
    private String conUsuarioCambio;
    @Column(name = "MCO_ID", nullable = false)
    private Integer mcoId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Id
    @Column(name = "TIN_ID", nullable = false)
    private Integer tinId;
    @Column(name = "TIV_ID")
    private Integer tivId;
    @Column(name = "TOTAL_DE_LA_VALORIZACIÓN")
    private Integer totalDeLaValorización;
    
    @Column(name = "CON_AVANCEOBRA")    
    private Integer avanceObra;

    public Contrato() {
    }

    public Contrato(Integer cncId, String conConcesion, Integer conEstado, Date conFechaAlta, Date conFechaBaja,
                     Date conFechaCambio, Integer conId, String conTerminal, String conUsuarioAlta,
                     String conUsuarioBaja, String conUsuarioCambio, Integer mcoId, Integer monId,
                     Integer tinId, Integer tivId, Integer totalDeLaValorización, Integer avanceObra) {
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
        // mlorenzo
        this.avanceObra = avanceObra;
    }


    public void setCncId(Integer cncId) {
        this.cncId = cncId;
    }

    public Integer getCncId() {
        return cncId;
    }

    public void setConConcesion(String conConcesion) {
        this.conConcesion = conConcesion;
    }

    public String getConConcesion() {
        return conConcesion;
    }

    public void setConEstado(Integer conEstado) {
        this.conEstado = conEstado;
    }

    public Integer getConEstado() {
        return conEstado;
    }

    public void setConFechaAlta(Date conFechaAlta) {
        this.conFechaAlta = conFechaAlta;
    }

    public Date getConFechaAlta() {
        return conFechaAlta;
    }

    public void setConFechaBaja(Date conFechaBaja) {
        this.conFechaBaja = conFechaBaja;
    }

    public Date getConFechaBaja() {
        return conFechaBaja;
    }

    public void setConFechaCambio(Date conFechaCambio) {
        this.conFechaCambio = conFechaCambio;
    }

    public Date getConFechaCambio() {
        return conFechaCambio;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConTerminal(String conTerminal) {
        this.conTerminal = conTerminal;
    }

    public String getConTerminal() {
        return conTerminal;
    }

    public void setConUsuarioAlta(String conUsuarioAlta) {
        this.conUsuarioAlta = conUsuarioAlta;
    }

    public String getConUsuarioAlta() {
        return conUsuarioAlta;
    }

    public void setConUsuarioBaja(String conUsuarioBaja) {
        this.conUsuarioBaja = conUsuarioBaja;
    }

    public String getConUsuarioBaja() {
        return conUsuarioBaja;
    }

    public void setConUsuarioCambio(String conUsuarioCambio) {
        this.conUsuarioCambio = conUsuarioCambio;
    }

    public String getConUsuarioCambio() {
        return conUsuarioCambio;
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

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setTivId(Integer tivId) {
        this.tivId = tivId;
    }

    public Integer getTivId() {
        return tivId;
    }

    public void setTotalDeLaValorización(Integer totalDeLaValorización) {
        this.totalDeLaValorización = totalDeLaValorización;
    }

    public Integer getTotalDeLaValorización() {
        return totalDeLaValorización;
    }

    public Integer getAvanceObra() {
        return avanceObra;
    }

    public void setAvanceObra(Integer avanceObra) {
        this.avanceObra = avanceObra;
    }
}
