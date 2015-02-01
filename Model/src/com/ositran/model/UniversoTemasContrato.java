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
 * To create ID generator sequence "T_UNIVERSO_TEMAS_CONTRATO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_UNIVERSO_TEMAS_CONTRATO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "UniversoTemasContrato.findAll", query = "select o from UniversoTemasContrato o") })
@Table(name = "T_UNIVERSO_TEMAS_CONTRATO")
@SequenceGenerator(name = "UniversoTemasContrato_Id_Seq_Gen", sequenceName = "T_UNIVERSO_TEMAS_CONTRATO_ID_SEQ_GEN",
                   allocationSize = 50, initialValue = 50)
public class UniversoTemasContrato implements Serializable {
    private static final long serialVersionUID = 6943886878681842421L;
    @Column(name = "UTC_DESCRIPCION", nullable = false, length = 4000)
    private String utcDescripcion;
    @Column(name = "UTC_ESTADO", nullable = false)
    private BigDecimal utcEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "UTC_FECHA_ALTA")
    private Date utcFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "UTC_FECHA_BAJA")
    private Date utcFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "UTC_FECHA_CAMBIO")
    private Date utcFechaCambio;
    @Id
    @Column(name = "UTC_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UniversoTemasContrato_Id_Seq_Gen")
    private BigDecimal utcId;
    @Column(name = "UTC_NOMBRE", nullable = false, length = 50)
    private String utcNombre;
    @Column(name = "UTC_TERMINAL", length = 20)
    private String utcTerminal;
    @Column(name = "UTC_TIPO_DATO", nullable = false, length = 1)
    private String utcTipoDato;
    @Column(name = "UTC_TODASLASINFRAESTRUCTURAS", nullable = false)
    private BigDecimal utcTodaslasinfraestructuras;
    @Column(name = "UTC_USUARIO_ALTA", length = 20)
    private String utcUsuarioAlta;
    @Column(name = "UTC_USUARIO_BAJA", length = 20)
    private String utcUsuarioBaja;
    @Column(name = "UTC_USUARIO_CAMBIO", length = 20)
    private String utcUsuarioCambio;

    public UniversoTemasContrato() {
    }

    public UniversoTemasContrato(String utcDescripcion, BigDecimal utcEstado, Date utcFechaAlta, Date utcFechaBaja,
                                 Date utcFechaCambio, BigDecimal utcId, String utcNombre, String utcTerminal,
                                 String utcTipoDato, BigDecimal utcTodaslasinfraestructuras, String utcUsuarioAlta,
                                 String utcUsuarioBaja, String utcUsuarioCambio) {
        this.utcDescripcion = utcDescripcion;
        this.utcEstado = utcEstado;
        this.utcFechaAlta = utcFechaAlta;
        this.utcFechaBaja = utcFechaBaja;
        this.utcFechaCambio = utcFechaCambio;
        this.utcId = utcId;
        this.utcNombre = utcNombre;
        this.utcTerminal = utcTerminal;
        this.utcTipoDato = utcTipoDato;
        this.utcTodaslasinfraestructuras = utcTodaslasinfraestructuras;
        this.utcUsuarioAlta = utcUsuarioAlta;
        this.utcUsuarioBaja = utcUsuarioBaja;
        this.utcUsuarioCambio = utcUsuarioCambio;
    }

    public String getUtcDescripcion() {
        return utcDescripcion;
    }

    public void setUtcDescripcion(String utcDescripcion) {
        this.utcDescripcion = utcDescripcion;
    }

    public BigDecimal getUtcEstado() {
        return utcEstado;
    }

    public void setUtcEstado(BigDecimal utcEstado) {
        this.utcEstado = utcEstado;
    }

    public Date getUtcFechaAlta() {
        return utcFechaAlta;
    }

    public void setUtcFechaAlta(Date utcFechaAlta) {
        this.utcFechaAlta = utcFechaAlta;
    }

    public Date getUtcFechaBaja() {
        return utcFechaBaja;
    }

    public void setUtcFechaBaja(Date utcFechaBaja) {
        this.utcFechaBaja = utcFechaBaja;
    }

    public Date getUtcFechaCambio() {
        return utcFechaCambio;
    }

    public void setUtcFechaCambio(Date utcFechaCambio) {
        this.utcFechaCambio = utcFechaCambio;
    }

    public BigDecimal getUtcId() {
        return utcId;
    }

    public String getUtcNombre() {
        return utcNombre;
    }

    public void setUtcNombre(String utcNombre) {
        this.utcNombre = utcNombre;
    }

    public String getUtcTerminal() {
        return utcTerminal;
    }

    public void setUtcTerminal(String utcTerminal) {
        this.utcTerminal = utcTerminal;
    }

    public String getUtcTipoDato() {
        return utcTipoDato;
    }

    public void setUtcTipoDato(String utcTipoDato) {
        this.utcTipoDato = utcTipoDato;
    }

    public BigDecimal getUtcTodaslasinfraestructuras() {
        return utcTodaslasinfraestructuras;
    }

    public void setUtcTodaslasinfraestructuras(BigDecimal utcTodaslasinfraestructuras) {
        this.utcTodaslasinfraestructuras = utcTodaslasinfraestructuras;
    }

    public String getUtcUsuarioAlta() {
        return utcUsuarioAlta;
    }

    public void setUtcUsuarioAlta(String utcUsuarioAlta) {
        this.utcUsuarioAlta = utcUsuarioAlta;
    }

    public String getUtcUsuarioBaja() {
        return utcUsuarioBaja;
    }

    public void setUtcUsuarioBaja(String utcUsuarioBaja) {
        this.utcUsuarioBaja = utcUsuarioBaja;
    }

    public String getUtcUsuarioCambio() {
        return utcUsuarioCambio;
    }

    public void setUtcUsuarioCambio(String utcUsuarioCambio) {
        this.utcUsuarioCambio = utcUsuarioCambio;
    }
}
