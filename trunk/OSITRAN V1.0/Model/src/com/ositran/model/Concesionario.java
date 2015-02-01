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
 * To create ID generator sequence "T_CONCESIONARIO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_CONCESIONARIO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "TConcesionario.findAll", query = "select o from TConcesionario o") })
@Table(name = "T_CONCESIONARIO")
@SequenceGenerator(name = "TConcesionario_Id_Seq_Gen", sequenceName = "T_CONCESIONARIO_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Concesionario implements Serializable {
    private static final long serialVersionUID = -5209185194740198073L;
    @Column(name = "CNC_CORREO", length = 20)
    private String cncCorreo;
    @Column(name = "CNC_DESCRIPCION", nullable = false, length = 100)
    private String cncDescripcion;
    @Column(name = "CNC_DIRECCION", length = 20)
    private String cncDireccion;
    @Column(name = "CNC_ESTADO", nullable = false)
    private BigDecimal cncEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CNC_FECHA_ALTA")
    private Date cncFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CNC_FECHA_BAJA")
    private Date cncFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CNC_FECHA_CAMBIO")
    private Date cncFechaCambio;
    @Id
    @Column(name = "CNC_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TConcesionario_Id_Seq_Gen")
    private BigDecimal cncId;
    @Column(name = "CNC_NOMBRE", nullable = false, length = 100)
    private String cncNombre;
    @Column(name = "CNC_NRO_DOCUMENTO", length = 20)
    private String cncNroDocumento;
    @Column(name = "CNC_REPRESENTANTE_LEGAL", length = 20)
    private String cncRepresentanteLegal;
    @Column(name = "CNC_TELEFONO", length = 15)
    private String cncTelefono;
    @Column(name = "CNC_TERMINAL", length = 20)
    private String cncTerminal;
    @Column(name = "CNC_USUARIO_ALTA", length = 20)
    private String cncUsuarioAlta;
    @Column(name = "CNC_USUARIO_BAJA", length = 20)
    private String cncUsuarioBaja;
    @Column(name = "CNC_USUARIO_CAMBIO", length = 20)
    private String cncUsuarioCambio;
    @Column(name = "CRG_ID")
    private BigDecimal crgId;
    @Column(name = "TDO_ID")
    private BigDecimal tdoId;

    public Concesionario() {
    }

    public Concesionario(String cncCorreo, String cncDescripcion, String cncDireccion, BigDecimal cncEstado,
                          Date cncFechaAlta, Date cncFechaBaja, Date cncFechaCambio, BigDecimal cncId, String cncNombre,
                          String cncNroDocumento, String cncRepresentanteLegal, String cncTelefono, String cncTerminal,
                          String cncUsuarioAlta, String cncUsuarioBaja, String cncUsuarioCambio, BigDecimal crgId,
                          BigDecimal tdoId) {
        this.cncCorreo = cncCorreo;
        this.cncDescripcion = cncDescripcion;
        this.cncDireccion = cncDireccion;
        this.cncEstado = cncEstado;
        this.cncFechaAlta = cncFechaAlta;
        this.cncFechaBaja = cncFechaBaja;
        this.cncFechaCambio = cncFechaCambio;
        this.cncId = cncId;
        this.cncNombre = cncNombre;
        this.cncNroDocumento = cncNroDocumento;
        this.cncRepresentanteLegal = cncRepresentanteLegal;
        this.cncTelefono = cncTelefono;
        this.cncTerminal = cncTerminal;
        this.cncUsuarioAlta = cncUsuarioAlta;
        this.cncUsuarioBaja = cncUsuarioBaja;
        this.cncUsuarioCambio = cncUsuarioCambio;
        this.crgId = crgId;
        this.tdoId = tdoId;
    }

    public String getCncCorreo() {
        return cncCorreo;
    }

    public void setCncCorreo(String cncCorreo) {
        this.cncCorreo = cncCorreo;
    }

    public String getCncDescripcion() {
        return cncDescripcion;
    }

    public void setCncDescripcion(String cncDescripcion) {
        this.cncDescripcion = cncDescripcion;
    }

    public String getCncDireccion() {
        return cncDireccion;
    }

    public void setCncDireccion(String cncDireccion) {
        this.cncDireccion = cncDireccion;
    }

    public BigDecimal getCncEstado() {
        return cncEstado;
    }

    public void setCncEstado(BigDecimal cncEstado) {
        this.cncEstado = cncEstado;
    }

    public Date getCncFechaAlta() {
        return cncFechaAlta;
    }

    public void setCncFechaAlta(Date cncFechaAlta) {
        this.cncFechaAlta = cncFechaAlta;
    }

    public Date getCncFechaBaja() {
        return cncFechaBaja;
    }

    public void setCncFechaBaja(Date cncFechaBaja) {
        this.cncFechaBaja = cncFechaBaja;
    }

    public Date getCncFechaCambio() {
        return cncFechaCambio;
    }

    public void setCncFechaCambio(Date cncFechaCambio) {
        this.cncFechaCambio = cncFechaCambio;
    }

    public BigDecimal getCncId() {
        return cncId;
    }

    public String getCncNombre() {
        return cncNombre;
    }

    public void setCncNombre(String cncNombre) {
        this.cncNombre = cncNombre;
    }

    public String getCncNroDocumento() {
        return cncNroDocumento;
    }

    public void setCncNroDocumento(String cncNroDocumento) {
        this.cncNroDocumento = cncNroDocumento;
    }

    public String getCncRepresentanteLegal() {
        return cncRepresentanteLegal;
    }

    public void setCncRepresentanteLegal(String cncRepresentanteLegal) {
        this.cncRepresentanteLegal = cncRepresentanteLegal;
    }

    public String getCncTelefono() {
        return cncTelefono;
    }

    public void setCncTelefono(String cncTelefono) {
        this.cncTelefono = cncTelefono;
    }

    public String getCncTerminal() {
        return cncTerminal;
    }

    public void setCncTerminal(String cncTerminal) {
        this.cncTerminal = cncTerminal;
    }

    public String getCncUsuarioAlta() {
        return cncUsuarioAlta;
    }

    public void setCncUsuarioAlta(String cncUsuarioAlta) {
        this.cncUsuarioAlta = cncUsuarioAlta;
    }

    public String getCncUsuarioBaja() {
        return cncUsuarioBaja;
    }

    public void setCncUsuarioBaja(String cncUsuarioBaja) {
        this.cncUsuarioBaja = cncUsuarioBaja;
    }

    public String getCncUsuarioCambio() {
        return cncUsuarioCambio;
    }

    public void setCncUsuarioCambio(String cncUsuarioCambio) {
        this.cncUsuarioCambio = cncUsuarioCambio;
    }

    public BigDecimal getCrgId() {
        return crgId;
    }

    public void setCrgId(BigDecimal crgId) {
        this.crgId = crgId;
    }

    public BigDecimal getTdoId() {
        return tdoId;
    }

    public void setTdoId(BigDecimal tdoId) {
        this.tdoId = tdoId;
    }
}
