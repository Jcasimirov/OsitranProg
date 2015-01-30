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
@NamedQueries({ @NamedQuery(name = "InversionTipo.findAll", query = "select o from InversionTipo o") })
@Table(name = "T_INVERSION_TIPO")
public class InversionTipo implements Serializable {
    private static final long serialVersionUID = 4518793286156267528L;
    @Column(name = "TIV_DESCRIPCION", nullable = false, length = 100)
    private String tivDescripcion;
    @Column(name = "TIV_ESTADO", nullable = false)
    private BigDecimal tivEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIV_FECHA_ALTA")
    private Date tivFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIV_FECHA_BAJA")
    private Date tivFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIV_FECHA_CAMBIO")
    private Date tivFechaCambio;
    @Column(name = "TIV_ID", nullable = false)
    private BigDecimal tivId;
    @Column(name = "TIV_NOMBRE", nullable = false, length = 100)
    private String tivNombre;
    @Column(name = "TIV_TERMINAL", length = 20)
    private String tivTerminal;
    @Column(name = "TIV_USUARIO_ALTA", length = 20)
    private String tivUsuarioAlta;
    @Column(name = "TIV_USUARIO_BAJA", length = 20)
    private String tivUsuarioBaja;
    @Column(name = "TIV_USUARIO_CAMBIO", length = 20)
    private String tivUsuarioCambio;

    public InversionTipo() {
    }

    public InversionTipo(String tivDescripcion, BigDecimal tivEstado, Date tivFechaAlta, Date tivFechaBaja,
                         Date tivFechaCambio, BigDecimal tivId, String tivNombre, String tivTerminal,
                         String tivUsuarioAlta, String tivUsuarioBaja, String tivUsuarioCambio) {
        this.tivDescripcion = tivDescripcion;
        this.tivEstado = tivEstado;
        this.tivFechaAlta = tivFechaAlta;
        this.tivFechaBaja = tivFechaBaja;
        this.tivFechaCambio = tivFechaCambio;
        this.tivId = tivId;
        this.tivNombre = tivNombre;
        this.tivTerminal = tivTerminal;
        this.tivUsuarioAlta = tivUsuarioAlta;
        this.tivUsuarioBaja = tivUsuarioBaja;
        this.tivUsuarioCambio = tivUsuarioCambio;
    }

    public String getTivDescripcion() {
        return tivDescripcion;
    }

    public void setTivDescripcion(String tivDescripcion) {
        this.tivDescripcion = tivDescripcion;
    }

    public BigDecimal getTivEstado() {
        return tivEstado;
    }

    public void setTivEstado(BigDecimal tivEstado) {
        this.tivEstado = tivEstado;
    }

    public Date getTivFechaAlta() {
        return tivFechaAlta;
    }

    public void setTivFechaAlta(Date tivFechaAlta) {
        this.tivFechaAlta = tivFechaAlta;
    }

    public Date getTivFechaBaja() {
        return tivFechaBaja;
    }

    public void setTivFechaBaja(Date tivFechaBaja) {
        this.tivFechaBaja = tivFechaBaja;
    }

    public Date getTivFechaCambio() {
        return tivFechaCambio;
    }

    public void setTivFechaCambio(Date tivFechaCambio) {
        this.tivFechaCambio = tivFechaCambio;
    }

    public BigDecimal getTivId() {
        return tivId;
    }

    public void setTivId(BigDecimal tivId) {
        this.tivId = tivId;
    }

    public String getTivNombre() {
        return tivNombre;
    }

    public void setTivNombre(String tivNombre) {
        this.tivNombre = tivNombre;
    }

    public String getTivTerminal() {
        return tivTerminal;
    }

    public void setTivTerminal(String tivTerminal) {
        this.tivTerminal = tivTerminal;
    }

    public String getTivUsuarioAlta() {
        return tivUsuarioAlta;
    }

    public void setTivUsuarioAlta(String tivUsuarioAlta) {
        this.tivUsuarioAlta = tivUsuarioAlta;
    }

    public String getTivUsuarioBaja() {
        return tivUsuarioBaja;
    }

    public void setTivUsuarioBaja(String tivUsuarioBaja) {
        this.tivUsuarioBaja = tivUsuarioBaja;
    }

    public String getTivUsuarioCambio() {
        return tivUsuarioCambio;
    }

    public void setTivUsuarioCambio(String tivUsuarioCambio) {
        this.tivUsuarioCambio = tivUsuarioCambio;
    }
}
