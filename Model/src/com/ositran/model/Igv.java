package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.net.InetAddress;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.net.*;

import javax.persistence.GeneratedValue;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/* @Entity
@NamedQueries({ @NamedQuery(name = "Igv.findAll", query = "select o from Igv o") })
@Table(name = "T_IGV")
@SequenceGenerator(name = "SEQ_IGV", sequenceName = "T_SEQ_IGV", allocationSize = 50,
                   initialValue = 50) */

@Entity
@Table(name = "T_IGV")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_IGV"))
public class Igv implements Serializable {
    private static final long serialVersionUID = -5795321833849861310L;
    @Column(name = "IGV_ESTADO")
    private Integer igvEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "IGV_FECHA_ALTA")
    private Date igvFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "IGV_FECHA_BAJA")
    private Date igvFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "IGV_FECHA_CAMBIO")
    private Date igvFechaCambio;
    @Temporal(TemporalType.DATE)
    @Column(name = "IGV_FECHACADUCIDAD")
    private Date igvFechacaducidad;
    @Temporal(TemporalType.DATE)
    @Column(name = "IGV_FECHAVIGENCIA")
    private Date igvFechavigencia;
    @Id
    @GeneratedValue(generator = "generator")    
    @Column(name = "IGV_ID", nullable = false)
    private Integer igvId;
    @Column(name = "IGV_PORCENTAJE", nullable = false)
    private Double igvPorcentaje;
    @Column(name = "IGV_TERMINAL", length = 20)
    private String igvTerminal;
    @Column(name = "IGV_USUARIO_ALTA", length = 50)
    private String igvUsuarioAlta;
    @Column(name = "IGV_USUARIO_BAJA", length = 50)
    private String igvUsuarioBaja;
    @Column(name = "IGV_USUARIO_CAMBIO", length = 50)
    private String igvUsuarioCambio;

    public Igv() {
    }

    public Igv(Integer igvEstado, Date igvFechaAlta, Date igvFechaBaja, Date igvFechaCambio, Date igvFechacaducidad,
               Date igvFechavigencia, Integer igvId, Double igvPorcentaje, String igvTerminal,
               String igvUsuarioAlta, String igvUsuarioBaja, String igvUsuarioCambio) {
        this.igvEstado = igvEstado;
        this.igvFechaAlta = igvFechaAlta;
        this.igvFechaBaja = igvFechaBaja;
        this.igvFechaCambio = igvFechaCambio;
        this.igvFechacaducidad = igvFechacaducidad;
        this.igvFechavigencia = igvFechavigencia;
        this.igvId = igvId;
        this.igvPorcentaje = igvPorcentaje;
        this.igvTerminal = igvTerminal;
        this.igvUsuarioAlta = igvUsuarioAlta;
        this.igvUsuarioBaja = igvUsuarioBaja;
        this.igvUsuarioCambio = igvUsuarioCambio;
    }

    public void setIgvEstado(Integer igvEstado) {
        this.igvEstado = igvEstado;
    }

    public Integer getIgvEstado() {
        return igvEstado;
    }

    public void setIgvFechaAlta(Date igvFechaAlta) {
        this.igvFechaAlta = igvFechaAlta;
    }

    public Date getIgvFechaAlta() {
        return igvFechaAlta;
    }

    public void setIgvFechaBaja(Date igvFechaBaja) {
        this.igvFechaBaja = igvFechaBaja;
    }

    public Date getIgvFechaBaja() {
        return igvFechaBaja;
    }

    public void setIgvFechaCambio(Date igvFechaCambio) {
        this.igvFechaCambio = igvFechaCambio;
    }

    public Date getIgvFechaCambio() {
        return igvFechaCambio;
    }

    public void setIgvFechacaducidad(Date igvFechacaducidad) {
        this.igvFechacaducidad = igvFechacaducidad;
    }

    public Date getIgvFechacaducidad() {
        return igvFechacaducidad;
    }

    public void setIgvFechavigencia(Date igvFechavigencia) {
        this.igvFechavigencia = igvFechavigencia;
    }

    public Date getIgvFechavigencia() {
        return igvFechavigencia;
    }

    public void setIgvId(Integer igvId) {
        this.igvId = igvId;
    }

    public Integer getIgvId() {
        return igvId;
    }

    public void setIgvPorcentaje(Double igvPorcentaje) {
        this.igvPorcentaje = igvPorcentaje;
    }

    public Double getIgvPorcentaje() {
        return igvPorcentaje;
    }

    public void setIgvTerminal(String igvTerminal) {
        this.igvTerminal = igvTerminal;
        }

    public String getIgvTerminal() {
        return igvTerminal;
    }

    public void setIgvUsuarioAlta(String igvUsuarioAlta) {
        this.igvUsuarioAlta = igvUsuarioAlta;
    }

    public String getIgvUsuarioAlta() {
        return igvUsuarioAlta;
    }

    public void setIgvUsuarioBaja(String igvUsuarioBaja) {
        this.igvUsuarioBaja = igvUsuarioBaja;
    }

    public String getIgvUsuarioBaja() {
        return igvUsuarioBaja;
    }

    public void setIgvUsuarioCambio(String igvUsuarioCambio) {
        this.igvUsuarioCambio = igvUsuarioCambio;
    }

    public String getIgvUsuarioCambio() {
        return igvUsuarioCambio;
    }
}
