package com.ositran.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_CONCESIONARIO",uniqueConstraints = @UniqueConstraint(columnNames = {"CNC_ID"}))
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONCESIONARIO"))

public class Concesionario implements Serializable {
    private static final long serialVersionUID = -5209185194740198073L;
    @Column(name = "CNC_CORREO", length = 20)
    private String cncCorreo;
    @Column(name = "CNC_DESCRIPCION", nullable = false, length = 100)
    private String cncDescripcion;
    @Column(name = "CNC_DIRECCION", length = 20)
    private String cncDireccion;
    @Column(name = "CNC_ESTADO", nullable = false)
    private int cncEstado;
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
    @GeneratedValue(generator = "generator")
    @Column(name = "CNC_ID", nullable = false)
    private int cncId;
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
    @Column(name = "TDO_ID")
    private int tdoId;
    @Column(name = "CNC_SIGLAS")
    private String cncSiglas;

    public Concesionario() {
    }

    public Concesionario(String cncCorreo, String cncDescripcion, String cncDireccion, int cncEstado,
                          Date cncFechaAlta, Date cncFechaBaja, Date cncFechaCambio, int cncId, String cncNombre,
                          String cncNroDocumento, String cncRepresentanteLegal, String cncTelefono, String cncTerminal,
                          String cncUsuarioAlta, String cncUsuarioBaja, String cncUsuarioCambio, int crgId,
                          int tdoId) {
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

    public int getCncEstado() {
        return cncEstado;
    }

    public void setCncEstado(int cncEstado) {
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

    public int getCncId() {
        return cncId;
    }

    public void setCncId(int cncId) {
        this.cncId = cncId;
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

    public int getTdoId() {
        return tdoId;
    }

    public void setTdoId(int tdoId) {
        this.tdoId = tdoId;
    }


    public void setCncSiglas(String cncSiglas) {
        this.cncSiglas = cncSiglas;
    }

    public String getCncSiglas() {
        return cncSiglas;
    }
}
