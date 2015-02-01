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
 * To create ID generator sequence "T_INVERSION_TIPO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_INVERSION_TIPO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "InversionTipo.findAll", query = "select o from InversionTipo o") })
@Table(name = "T_INVERSION_TIPO")
@SequenceGenerator(name = "InversionTipo_Id_Seq_Gen", sequenceName = "T_INVERSION_TIPO_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class InversionTipo implements Serializable {
    private static final long serialVersionUID = -8103932004553759425L;
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
    @Id
    @Column(name = "TIV_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InversionTipo_Id_Seq_Gen")
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
