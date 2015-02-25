package com.ositran.model;

import java.io.Serializable;

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
 * To create ID generator sequence "T_CARGO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_CARGO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity(name = "Cargo")
@NamedQueries({ @NamedQuery(name = "Cargo.findAll", query = "select o from Cargo o") })
@Table(name = "T_CARGO")
@SequenceGenerator(name = "Cargo_Id_Seq_Gen", sequenceName = "CARGO_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Cargo implements Serializable {
    private static final long serialVersionUID = -8206359419423189848L;
    @Column(name = "CRG_DESCRIPCION", nullable = false, length = 100)
    private String crgDescripcion;
    @Column(name = "CRG_ESTADO", nullable = false)
    private Integer crgEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CRG_FECHA_ALTA")
    private Date crgFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CRG_FECHA_BAJA")
    private Date crgFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CRG_FECHA_CAMBIO")
    private Date crgFechaCambio;
    @Id
    @Column(name = "CRG_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TCargo_Id_Seq_Gen")
    private Integer crgId;
    @Column(name = "CRG_NOMBRE", nullable = false, length = 100)
    private String crgNombre;
    @Column(name = "CRG_TERMINAL", length = 20)
    private String crgTerminal;
    @Column(name = "CRG_USUARIO_ALTA", length = 20)
    private String crgUsuarioAlta;
    @Column(name = "CRG_USUARIO_BAJA", length = 20)
    private String crgUsuarioBaja;
    @Column(name = "CRG_USUARIO_CAMBIO", length = 20)
    private String crgUsuarioCambio;

    public Cargo() {
    }

    public Cargo(String crgDescripcion, Integer crgEstado, Date crgFechaAlta, Date crgFechaBaja,
                  Date crgFechaCambio, Integer crgId, String crgNombre, String crgTerminal, String crgUsuarioAlta,
                  String crgUsuarioBaja, String crgUsuarioCambio) {
        this.crgDescripcion = crgDescripcion;
        this.crgEstado = crgEstado;
        this.crgFechaAlta = crgFechaAlta;
        this.crgFechaBaja = crgFechaBaja;
        this.crgFechaCambio = crgFechaCambio;
        this.crgId = crgId;
        this.crgNombre = crgNombre;
        this.crgTerminal = crgTerminal;
        this.crgUsuarioAlta = crgUsuarioAlta;
        this.crgUsuarioBaja = crgUsuarioBaja;
        this.crgUsuarioCambio = crgUsuarioCambio;
    }


    public void setCrgDescripcion(String crgDescripcion) {
        this.crgDescripcion = crgDescripcion;
    }

    public String getCrgDescripcion() {
        return crgDescripcion;
    }

    public void setCrgEstado(Integer crgEstado) {
        this.crgEstado = crgEstado;
    }

    public Integer getCrgEstado() {
        return crgEstado;
    }

    public void setCrgFechaAlta(Date crgFechaAlta) {
        this.crgFechaAlta = crgFechaAlta;
    }

    public Date getCrgFechaAlta() {
        return crgFechaAlta;
    }

    public void setCrgFechaBaja(Date crgFechaBaja) {
        this.crgFechaBaja = crgFechaBaja;
    }

    public Date getCrgFechaBaja() {
        return crgFechaBaja;
    }

    public void setCrgFechaCambio(Date crgFechaCambio) {
        this.crgFechaCambio = crgFechaCambio;
    }

    public Date getCrgFechaCambio() {
        return crgFechaCambio;
    }

    public void setCrgId(Integer crgId) {
        this.crgId = crgId;
    }

    public Integer getCrgId() {
        return crgId;
    }

    public void setCrgNombre(String crgNombre) {
        this.crgNombre = crgNombre;
    }

    public String getCrgNombre() {
        return crgNombre;
    }

    public void setCrgTerminal(String crgTerminal) {
        this.crgTerminal = crgTerminal;
    }

    public String getCrgTerminal() {
        return crgTerminal;
    }

    public void setCrgUsuarioAlta(String crgUsuarioAlta) {
        this.crgUsuarioAlta = crgUsuarioAlta;
    }

    public String getCrgUsuarioAlta() {
        return crgUsuarioAlta;
    }

    public void setCrgUsuarioBaja(String crgUsuarioBaja) {
        this.crgUsuarioBaja = crgUsuarioBaja;
    }

    public String getCrgUsuarioBaja() {
        return crgUsuarioBaja;
    }

    public void setCrgUsuarioCambio(String crgUsuarioCambio) {
        this.crgUsuarioCambio = crgUsuarioCambio;
    }

    public String getCrgUsuarioCambio() {
        return crgUsuarioCambio;
    }
}
