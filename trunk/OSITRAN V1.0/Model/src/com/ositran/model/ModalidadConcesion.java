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
 * To create ID generator sequence "T_MODALIDAD_CONCESION_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_MODALIDAD_CONCESION_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "ModalidadConcesion.findAll", query = "select o from ModalidadConcesion o") })
@Table(name = "T_MODALIDAD_CONCESION")
@SequenceGenerator(name = "ModalidadConcesion_Id_Seq_Gen", sequenceName = "T_MODALIDAD_CONCESION_ID_SEQ_GEN",
                   allocationSize = 50, initialValue = 50)
public class ModalidadConcesion implements Serializable {
    private static final long serialVersionUID = 4435829443044178951L;
    @Column(name = "MCO_DESCRIPCION", nullable = false, length = 100)
    private String mcoDescripcion;
    @Column(name = "MCO_ESTADO", nullable = false)
    private BigDecimal mcoEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "MCO_FECHA_ALTA")
    private Date mcoFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "MCO_FECHA_BAJA")
    private Date mcoFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "MCO_FECHA_CAMBIO")
    private Date mcoFechaCambio;
    @Id
    @Column(name = "MCO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ModalidadConcesion_Id_Seq_Gen")
    private BigDecimal mcoId;
    @Column(name = "MCO_NOMBRE", nullable = false, length = 100)
    private String mcoNombre;
    @Column(name = "MCO_TERMINAL", length = 20)
    private String mcoTerminal;
    @Column(name = "MCO_USUARIO_ALTA", length = 20)
    private String mcoUsuarioAlta;
    @Column(name = "MCO_USUARIO_BAJA", length = 20)
    private String mcoUsuarioBaja;
    @Column(name = "MCO_USUARIO_CAMBIO", length = 20)
    private String mcoUsuarioCambio;

    public ModalidadConcesion() {
    }

    public ModalidadConcesion(String mcoDescripcion, BigDecimal mcoEstado, Date mcoFechaAlta, Date mcoFechaBaja,
                              Date mcoFechaCambio, BigDecimal mcoId, String mcoNombre, String mcoTerminal,
                              String mcoUsuarioAlta, String mcoUsuarioBaja, String mcoUsuarioCambio) {
        this.mcoDescripcion = mcoDescripcion;
        this.mcoEstado = mcoEstado;
        this.mcoFechaAlta = mcoFechaAlta;
        this.mcoFechaBaja = mcoFechaBaja;
        this.mcoFechaCambio = mcoFechaCambio;
        this.mcoId = mcoId;
        this.mcoNombre = mcoNombre;
        this.mcoTerminal = mcoTerminal;
        this.mcoUsuarioAlta = mcoUsuarioAlta;
        this.mcoUsuarioBaja = mcoUsuarioBaja;
        this.mcoUsuarioCambio = mcoUsuarioCambio;
    }

    public String getMcoDescripcion() {
        return mcoDescripcion;
    }

    public void setMcoDescripcion(String mcoDescripcion) {
        this.mcoDescripcion = mcoDescripcion;
    }

    public BigDecimal getMcoEstado() {
        return mcoEstado;
    }

    public void setMcoEstado(BigDecimal mcoEstado) {
        this.mcoEstado = mcoEstado;
    }

    public Date getMcoFechaAlta() {
        return mcoFechaAlta;
    }

    public void setMcoFechaAlta(Date mcoFechaAlta) {
        this.mcoFechaAlta = mcoFechaAlta;
    }

    public Date getMcoFechaBaja() {
        return mcoFechaBaja;
    }

    public void setMcoFechaBaja(Date mcoFechaBaja) {
        this.mcoFechaBaja = mcoFechaBaja;
    }

    public Date getMcoFechaCambio() {
        return mcoFechaCambio;
    }

    public void setMcoFechaCambio(Date mcoFechaCambio) {
        this.mcoFechaCambio = mcoFechaCambio;
    }

    public BigDecimal getMcoId() {
        return mcoId;
    }

    public String getMcoNombre() {
        return mcoNombre;
    }

    public void setMcoNombre(String mcoNombre) {
        this.mcoNombre = mcoNombre;
    }

    public String getMcoTerminal() {
        return mcoTerminal;
    }

    public void setMcoTerminal(String mcoTerminal) {
        this.mcoTerminal = mcoTerminal;
    }

    public String getMcoUsuarioAlta() {
        return mcoUsuarioAlta;
    }

    public void setMcoUsuarioAlta(String mcoUsuarioAlta) {
        this.mcoUsuarioAlta = mcoUsuarioAlta;
    }

    public String getMcoUsuarioBaja() {
        return mcoUsuarioBaja;
    }

    public void setMcoUsuarioBaja(String mcoUsuarioBaja) {
        this.mcoUsuarioBaja = mcoUsuarioBaja;
    }

    public String getMcoUsuarioCambio() {
        return mcoUsuarioCambio;
    }

    public void setMcoUsuarioCambio(String mcoUsuarioCambio) {
        this.mcoUsuarioCambio = mcoUsuarioCambio;
    }
}
