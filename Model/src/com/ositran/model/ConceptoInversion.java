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
 * To create ID generator sequence "T_CONCEPTO_INVERSION_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_CONCEPTO_INVERSION_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "TConceptoInversion.findAll", query = "select o from TConceptoInversion o") })
@Table(name = "T_CONCEPTO_INVERSION")
@SequenceGenerator(name = "TConceptoInversion_Id_Seq_Gen", sequenceName = "T_CONCEPTO_INVERSION_ID_SEQ_GEN",
                   allocationSize = 50, initialValue = 50)
public class ConceptoInversion implements Serializable {
    private static final long serialVersionUID = -5887686883945486858L;
    @Column(name = "CNV_DESCRIPCION", nullable = false, length = 100)
    private String cnvDescripcion;
    @Column(name = "CNV_ESTADO", nullable = false)
    private BigDecimal cnvEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CNV_FECHA_ALTA")
    private Date cnvFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CNV_FECHA_BAJA")
    private Date cnvFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CNV_FECHA_CAMBIO")
    private Date cnvFechaCambio;
    @Id
    @Column(name = "CNV_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TConceptoInversion_Id_Seq_Gen")
    private BigDecimal cnvId;
    @Column(name = "CNV_NOMBRE", nullable = false, length = 50)
    private String cnvNombre;
    @Column(name = "CNV_TERMINAL", length = 20)
    private String cnvTerminal;
    @Column(name = "CNV_USUARIO_ALTA", length = 20)
    private String cnvUsuarioAlta;
    @Column(name = "CNV_USUARIO_BAJA", length = 20)
    private String cnvUsuarioBaja;
    @Column(name = "CNV_USUARIO_CAMBIO", length = 20)
    private String cnvUsuarioCambio;

    public ConceptoInversion() {
    }

    public ConceptoInversion(String cnvDescripcion, BigDecimal cnvEstado, Date cnvFechaAlta, Date cnvFechaBaja,
                              Date cnvFechaCambio, BigDecimal cnvId, String cnvNombre, String cnvTerminal,
                              String cnvUsuarioAlta, String cnvUsuarioBaja, String cnvUsuarioCambio) {
        this.cnvDescripcion = cnvDescripcion;
        this.cnvEstado = cnvEstado;
        this.cnvFechaAlta = cnvFechaAlta;
        this.cnvFechaBaja = cnvFechaBaja;
        this.cnvFechaCambio = cnvFechaCambio;
        this.cnvId = cnvId;
        this.cnvNombre = cnvNombre;
        this.cnvTerminal = cnvTerminal;
        this.cnvUsuarioAlta = cnvUsuarioAlta;
        this.cnvUsuarioBaja = cnvUsuarioBaja;
        this.cnvUsuarioCambio = cnvUsuarioCambio;
    }

    public String getCnvDescripcion() {
        return cnvDescripcion;
    }

    public void setCnvDescripcion(String cnvDescripcion) {
        this.cnvDescripcion = cnvDescripcion;
    }

    public BigDecimal getCnvEstado() {
        return cnvEstado;
    }

    public void setCnvEstado(BigDecimal cnvEstado) {
        this.cnvEstado = cnvEstado;
    }

    public Date getCnvFechaAlta() {
        return cnvFechaAlta;
    }

    public void setCnvFechaAlta(Date cnvFechaAlta) {
        this.cnvFechaAlta = cnvFechaAlta;
    }

    public Date getCnvFechaBaja() {
        return cnvFechaBaja;
    }

    public void setCnvFechaBaja(Date cnvFechaBaja) {
        this.cnvFechaBaja = cnvFechaBaja;
    }

    public Date getCnvFechaCambio() {
        return cnvFechaCambio;
    }

    public void setCnvFechaCambio(Date cnvFechaCambio) {
        this.cnvFechaCambio = cnvFechaCambio;
    }

    public BigDecimal getCnvId() {
        return cnvId;
    }

    public String getCnvNombre() {
        return cnvNombre;
    }

    public void setCnvNombre(String cnvNombre) {
        this.cnvNombre = cnvNombre;
    }

    public String getCnvTerminal() {
        return cnvTerminal;
    }

    public void setCnvTerminal(String cnvTerminal) {
        this.cnvTerminal = cnvTerminal;
    }

    public String getCnvUsuarioAlta() {
        return cnvUsuarioAlta;
    }

    public void setCnvUsuarioAlta(String cnvUsuarioAlta) {
        this.cnvUsuarioAlta = cnvUsuarioAlta;
    }

    public String getCnvUsuarioBaja() {
        return cnvUsuarioBaja;
    }

    public void setCnvUsuarioBaja(String cnvUsuarioBaja) {
        this.cnvUsuarioBaja = cnvUsuarioBaja;
    }

    public String getCnvUsuarioCambio() {
        return cnvUsuarioCambio;
    }

    public void setCnvUsuarioCambio(String cnvUsuarioCambio) {
        this.cnvUsuarioCambio = cnvUsuarioCambio;
    }
}
