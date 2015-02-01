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
 * To create ID generator sequence "T_INFRAESTRUCTURA_TIPO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_INFRAESTRUCTURA_TIPO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "InfraestructuraTipo.findAll", query = "select o from InfraestructuraTipo o") })
@Table(name = "T_INFRAESTRUCTURA_TIPO")
@SequenceGenerator(name = "InfraestructuraTipo_Id_Seq_Gen", sequenceName = "T_INFRAESTRUCTURA_TIPO_ID_SEQ_GEN",
                   allocationSize = 50, initialValue = 50)
public class InfraestructuraTipo implements Serializable {
    private static final long serialVersionUID = -9018333581388462967L;
    @Column(name = "TIN_DESCRIPCION", nullable = false, length = 100)
    private String tinDescripcion;
    @Column(name = "TIN_ESTADO", nullable = false)
    private BigDecimal tinEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIN_FECHA_ALTA")
    private Date tinFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIN_FECHA_BAJA")
    private Date tinFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIN_FECHA_CAMBIO")
    private Date tinFechaCambio;
    @Id
    @Column(name = "TIN_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InfraestructuraTipo_Id_Seq_Gen")
    private BigDecimal tinId;
    @Column(name = "TIN_NOMBRE", nullable = false, length = 50)
    private String tinNombre;
    @Column(name = "TIN_TERMINAL", length = 20)
    private String tinTerminal;
    @Column(name = "TIN_USUARIO_ALTA", length = 20)
    private String tinUsuarioAlta;
    @Column(name = "TIN_USUARIO_BAJA", length = 20)
    private String tinUsuarioBaja;
    @Column(name = "TIN_USUARIO_CAMBIO", length = 20)
    private String tinUsuarioCambio;

    public InfraestructuraTipo() {
    }

    public InfraestructuraTipo(String tinDescripcion, BigDecimal tinEstado, Date tinFechaAlta, Date tinFechaBaja,
                               Date tinFechaCambio, BigDecimal tinId, String tinNombre, String tinTerminal,
                               String tinUsuarioAlta, String tinUsuarioBaja, String tinUsuarioCambio) {
        this.tinDescripcion = tinDescripcion;
        this.tinEstado = tinEstado;
        this.tinFechaAlta = tinFechaAlta;
        this.tinFechaBaja = tinFechaBaja;
        this.tinFechaCambio = tinFechaCambio;
        this.tinId = tinId;
        this.tinNombre = tinNombre;
        this.tinTerminal = tinTerminal;
        this.tinUsuarioAlta = tinUsuarioAlta;
        this.tinUsuarioBaja = tinUsuarioBaja;
        this.tinUsuarioCambio = tinUsuarioCambio;
    }

    public String getTinDescripcion() {
        return tinDescripcion;
    }

    public void setTinDescripcion(String tinDescripcion) {
        this.tinDescripcion = tinDescripcion;
    }

    public BigDecimal getTinEstado() {
        return tinEstado;
    }

    public void setTinEstado(BigDecimal tinEstado) {
        this.tinEstado = tinEstado;
    }

    public Date getTinFechaAlta() {
        return tinFechaAlta;
    }

    public void setTinFechaAlta(Date tinFechaAlta) {
        this.tinFechaAlta = tinFechaAlta;
    }

    public Date getTinFechaBaja() {
        return tinFechaBaja;
    }

    public void setTinFechaBaja(Date tinFechaBaja) {
        this.tinFechaBaja = tinFechaBaja;
    }

    public Date getTinFechaCambio() {
        return tinFechaCambio;
    }

    public void setTinFechaCambio(Date tinFechaCambio) {
        this.tinFechaCambio = tinFechaCambio;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public String getTinNombre() {
        return tinNombre;
    }

    public void setTinNombre(String tinNombre) {
        this.tinNombre = tinNombre;
    }

    public String getTinTerminal() {
        return tinTerminal;
    }

    public void setTinTerminal(String tinTerminal) {
        this.tinTerminal = tinTerminal;
    }

    public String getTinUsuarioAlta() {
        return tinUsuarioAlta;
    }

    public void setTinUsuarioAlta(String tinUsuarioAlta) {
        this.tinUsuarioAlta = tinUsuarioAlta;
    }

    public String getTinUsuarioBaja() {
        return tinUsuarioBaja;
    }

    public void setTinUsuarioBaja(String tinUsuarioBaja) {
        this.tinUsuarioBaja = tinUsuarioBaja;
    }

    public String getTinUsuarioCambio() {
        return tinUsuarioCambio;
    }

    public void setTinUsuarioCambio(String tinUsuarioCambio) {
        this.tinUsuarioCambio = tinUsuarioCambio;
    }
}
