package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "T_MONEDA_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_MONEDA_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Moneda.findAll", query = "select o from Moneda o") })
@Table(name = "T_MONEDA")
@SequenceGenerator(name = "Moneda_Id_Seq_Gen", sequenceName = "T_MONEDA_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Moneda implements Serializable {
    private static final long serialVersionUID = -5006168602848989530L;
    @Column(name = "MON_ESTADO", nullable = false)
    private BigDecimal monEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "MON_FECHA_ALTA")
    private Date monFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "MON_FECHA_BAJA")
    private Date monFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "MON_FECHA_CAMBIO")
    private Date monFechaCambio;
    @Id
    @Column(name = "MON_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Moneda_Id_Seq_Gen")
    private BigDecimal monId;
    @Column(name = "MON_NOMBRE", nullable = false, length = 50)
    private String monNombre;
    @Column(name = "MON_SIMBOLO", length = 3)
    private String monSimbolo;
    @Column(name = "MON_TERMINAL", length = 20)
    private String monTerminal;
    @Column(name = "MON_USUARIO_ALTA", length = 20)
    private String monUsuarioAlta;
    @Column(name = "MON_USUARIO_BAJA", length = 20)
    private String monUsuarioBaja;
    @Column(name = "MON_USUARIO_CAMBIO", length = 20)
    private String monUsuarioCambio;
    @Column(name = "MON_ABREVIATURA", length = 3)
    private String monAbreviatura;

    public Moneda() {
    }

    public Moneda(BigDecimal monEstado, Date monFechaAlta, Date monFechaBaja, Date monFechaCambio, BigDecimal monId,
                  String monNombre, String monSimbolo, String monTerminal, String monUsuarioAlta, String monUsuarioBaja,
                  String monUsuarioCambio, String monAbreviatura) {
        this.monEstado = monEstado;
        this.monFechaAlta = monFechaAlta;
        this.monFechaBaja = monFechaBaja;
        this.monFechaCambio = monFechaCambio;
        this.monId = monId;
        this.monNombre = monNombre;
        this.monSimbolo = monSimbolo;
        this.monTerminal = monTerminal;
        this.monUsuarioAlta = monUsuarioAlta;
        this.monUsuarioBaja = monUsuarioBaja;
        this.monUsuarioCambio = monUsuarioCambio;
        this.monAbreviatura = monAbreviatura;
    }

    public BigDecimal getMonEstado() {
        return monEstado;
    }

    public void setMonEstado(BigDecimal monEstado) {
        this.monEstado = monEstado;
    }

    public Date getMonFechaAlta() {
        return monFechaAlta;
    }

    public void setMonFechaAlta(Date monFechaAlta) {
        this.monFechaAlta = monFechaAlta;
    }

    public Date getMonFechaBaja() {
        return monFechaBaja;
    }

    public void setMonFechaBaja(Date monFechaBaja) {
        this.monFechaBaja = monFechaBaja;
    }

    public Date getMonFechaCambio() {
        return monFechaCambio;
    }

    public void setMonFechaCambio(Date monFechaCambio) {
        this.monFechaCambio = monFechaCambio;
    }

    public BigDecimal getMonId() {
        return monId;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public String getMonSimbolo() {
        return monSimbolo;
    }

    public void setMonSimbolo(String monSimbolo) {
        this.monSimbolo = monSimbolo;
    }

    public String getMonTerminal() {
        return monTerminal;
    }

    public void setMonTerminal(String monTerminal) {
        this.monTerminal = monTerminal;
    }

    public String getMonUsuarioAlta() {
        return monUsuarioAlta;
    }

    public void setMonUsuarioAlta(String monUsuarioAlta) {
        this.monUsuarioAlta = monUsuarioAlta;
    }

    public String getMonUsuarioBaja() {
        return monUsuarioBaja;
    }

    public void setMonUsuarioBaja(String monUsuarioBaja) {
        this.monUsuarioBaja = monUsuarioBaja;
    }

    public String getMonUsuarioCambio() {
        return monUsuarioCambio;
    }

    public void setMonUsuarioCambio(String monUsuarioCambio) {
        this.monUsuarioCambio = monUsuarioCambio;
    }
    public void setMonId(BigDecimal monId){
        this.monId = monId;
    }

    public String getMonAbreviatura() {
        return monAbreviatura;
    }

    public void setMonAbreviatura(String monAbreviatura) {
        this.monAbreviatura = monAbreviatura;
    }
}
