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
 * To create ID generator sequence "T_INVERSION_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_INVERSION_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Inversion.findAll", query = "select o from Inversion o") })
@Table(name = "T_INVERSION")
@SequenceGenerator(name = "Inversion_Id_Seq_Gen", sequenceName = "T_INVERSION_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Inversion implements Serializable {
    private static final long serialVersionUID = -5219289995732602006L;
    @Column(name = "INV_DESCRIPCION", nullable = false, length = 100)
    private String invDescripcion;
    @Column(name = "INV_ESTADO", nullable = false)
    private BigDecimal invEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_ALTA")
    private Date invFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_BAJA")
    private Date invFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_CAMBIO")
    private Date invFechaCambio;
    @Id
    @Column(name = "INV_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Inversion_Id_Seq_Gen")
    private BigDecimal invId;
    @Column(name = "INV_NOMBRE", nullable = false, length = 100)
    private String invNombre;
    @Column(name = "INV_TERMINAL", length = 20)
    private String invTerminal;
    @Column(name = "INV_USUARIO_ALTA", length = 20)
    private String invUsuarioAlta;
    @Column(name = "INV_USUARIO_BAJA", length = 20)
    private String invUsuarioBaja;
    @Column(name = "INV_USUARIO_CAMBIO", length = 20)
    private String invUsuarioCambio;
    @Column(name = "TIV_ID")
    private BigDecimal tivId;

    public Inversion() {
    }

    public Inversion(String invDescripcion, BigDecimal invEstado, Date invFechaAlta, Date invFechaBaja,
                     Date invFechaCambio, BigDecimal invId, String invNombre, String invTerminal, String invUsuarioAlta,
                     String invUsuarioBaja, String invUsuarioCambio, BigDecimal tivId) {
        this.invDescripcion = invDescripcion;
        this.invEstado = invEstado;
        this.invFechaAlta = invFechaAlta;
        this.invFechaBaja = invFechaBaja;
        this.invFechaCambio = invFechaCambio;
        this.invId = invId;
        this.invNombre = invNombre;
        this.invTerminal = invTerminal;
        this.invUsuarioAlta = invUsuarioAlta;
        this.invUsuarioBaja = invUsuarioBaja;
        this.invUsuarioCambio = invUsuarioCambio;
        this.tivId = tivId;
    }

    public String getInvDescripcion() {
        return invDescripcion;
    }

    public void setInvDescripcion(String invDescripcion) {
        this.invDescripcion = invDescripcion;
    }

    public BigDecimal getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(BigDecimal invEstado) {
        this.invEstado = invEstado;
    }

    public Date getInvFechaAlta() {
        return invFechaAlta;
    }

    public void setInvFechaAlta(Date invFechaAlta) {
        this.invFechaAlta = invFechaAlta;
    }

    public Date getInvFechaBaja() {
        return invFechaBaja;
    }

    public void setInvFechaBaja(Date invFechaBaja) {
        this.invFechaBaja = invFechaBaja;
    }

    public Date getInvFechaCambio() {
        return invFechaCambio;
    }

    public void setInvFechaCambio(Date invFechaCambio) {
        this.invFechaCambio = invFechaCambio;
    }

    public BigDecimal getInvId() {
        return invId;
    }

    public String getInvNombre() {
        return invNombre;
    }

    public void setInvNombre(String invNombre) {
        this.invNombre = invNombre;
    }

    public String getInvTerminal() {
        return invTerminal;
    }

    public void setInvTerminal(String invTerminal) {
        this.invTerminal = invTerminal;
    }

    public String getInvUsuarioAlta() {
        return invUsuarioAlta;
    }

    public void setInvUsuarioAlta(String invUsuarioAlta) {
        this.invUsuarioAlta = invUsuarioAlta;
    }

    public String getInvUsuarioBaja() {
        return invUsuarioBaja;
    }

    public void setInvUsuarioBaja(String invUsuarioBaja) {
        this.invUsuarioBaja = invUsuarioBaja;
    }

    public String getInvUsuarioCambio() {
        return invUsuarioCambio;
    }

    public void setInvUsuarioCambio(String invUsuarioCambio) {
        this.invUsuarioCambio = invUsuarioCambio;
    }

    public BigDecimal getTivId() {
        return tivId;
    }

    public void setTivId(BigDecimal tivId) {
        this.tivId = tivId;
    }
}
