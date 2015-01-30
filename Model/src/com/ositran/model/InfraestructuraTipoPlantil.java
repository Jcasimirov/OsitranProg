package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
              @NamedQuery(name = "InfraestructuraTipoPlantil.findAll",
                          query = "select o from InfraestructuraTipoPlantil o") })
@Table(name = "T_INFRAESTRUCTURA_TIPO_PLANTIL")
public class InfraestructuraTipoPlantil implements Serializable {
    private static final long serialVersionUID = -6424775326177344157L;
    @Column(name = "TIN_ID", nullable = false)
    private BigDecimal tinId;
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
    @Column(name = "UTC_ID", nullable = false)
    private BigDecimal utcId;
    @Column(name = "UTC_TERMINAL", length = 20)
    private String utcTerminal;
    @Column(name = "UTC_USUARIO_ALTA", length = 20)
    private String utcUsuarioAlta;
    @Column(name = "UTC_USUARIO_BAJA", length = 20)
    private String utcUsuarioBaja;
    @Column(name = "UTC_USUARIO_CAMBIO", length = 20)
    private String utcUsuarioCambio;

    public InfraestructuraTipoPlantil() {
    }

    public InfraestructuraTipoPlantil(BigDecimal tinId, BigDecimal utcEstado, Date utcFechaAlta, Date utcFechaBaja,
                                      Date utcFechaCambio, BigDecimal utcId, String utcTerminal, String utcUsuarioAlta,
                                      String utcUsuarioBaja, String utcUsuarioCambio) {
        this.tinId = tinId;
        this.utcEstado = utcEstado;
        this.utcFechaAlta = utcFechaAlta;
        this.utcFechaBaja = utcFechaBaja;
        this.utcFechaCambio = utcFechaCambio;
        this.utcId = utcId;
        this.utcTerminal = utcTerminal;
        this.utcUsuarioAlta = utcUsuarioAlta;
        this.utcUsuarioBaja = utcUsuarioBaja;
        this.utcUsuarioCambio = utcUsuarioCambio;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
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

    public void setUtcId(BigDecimal utcId) {
        this.utcId = utcId;
    }

    public String getUtcTerminal() {
        return utcTerminal;
    }

    public void setUtcTerminal(String utcTerminal) {
        this.utcTerminal = utcTerminal;
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
