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
 * To create ID generator sequence "T_EMPRESA_SUPERVISORA_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_EMPRESA_SUPERVISORA_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "EmpresaSupervisora.findAll", query = "select o from EmpresaSupervisora o") })
@Table(name = "T_EMPRESA_SUPERVISORA")
@SequenceGenerator(name = "EmpresaSupervisora_Id_Seq_Gen", sequenceName = "T_EMPRESA_SUPERVISORA_ID_SEQ_GEN",
                   allocationSize = 50, initialValue = 50)
public class EmpresaSupervisora implements Serializable {
    private static final long serialVersionUID = -5138390938685448144L;
    @Column(name = "CRG_ID")
    private BigDecimal crgId;
    @Column(name = "SUP_CORREO", length = 20)
    private String supCorreo;
    @Column(name = "SUP_DESCRIPCION", nullable = false, length = 100)
    private String supDescripcion;
    @Column(name = "SUP_DIRECCION", length = 20)
    private String supDireccion;
    @Column(name = "SUP_ESTADO", nullable = false)
    private BigDecimal supEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "SUP_FECHA_ALTA")
    private Date supFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "SUP_FECHA_BAJA")
    private Date supFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "SUP_FECHA_CAMBIO")
    private Date supFechaCambio;
    @Id
    @Column(name = "SUP_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmpresaSupervisora_Id_Seq_Gen")
    private BigDecimal supId;
    @Column(name = "SUP_NOMBRE", nullable = false, length = 100)
    private String supNombre;
    @Column(name = "SUP_NRO_DOCUMENTO", length = 20)
    private String supNroDocumento;
    @Column(name = "SUP_REPRESENTANTE_LEGAL", length = 20)
    private String supRepresentanteLegal;
    @Column(name = "SUP_TELEFONO", length = 15)
    private String supTelefono;
    @Column(name = "SUP_TERMINAL", length = 20)
    private String supTerminal;
    @Column(name = "SUP_USUARIO_ALTA", length = 20)
    private String supUsuarioAlta;
    @Column(name = "SUP_USUARIO_BAJA", length = 20)
    private String supUsuarioBaja;
    @Column(name = "SUP_USUARIO_CAMBIO", length = 20)
    private String supUsuarioCambio;
    @Column(name = "TDO_ID")
    private BigDecimal tdoId;

    public EmpresaSupervisora() {
    }

    public EmpresaSupervisora(BigDecimal crgId, String supCorreo, String supDescripcion, String supDireccion,
                              BigDecimal supEstado, Date supFechaAlta, Date supFechaBaja, Date supFechaCambio,
                              BigDecimal supId, String supNombre, String supNroDocumento, String supRepresentanteLegal,
                              String supTelefono, String supTerminal, String supUsuarioAlta, String supUsuarioBaja,
                              String supUsuarioCambio, BigDecimal tdoId) {
        this.crgId = crgId;
        this.supCorreo = supCorreo;
        this.supDescripcion = supDescripcion;
        this.supDireccion = supDireccion;
        this.supEstado = supEstado;
        this.supFechaAlta = supFechaAlta;
        this.supFechaBaja = supFechaBaja;
        this.supFechaCambio = supFechaCambio;
        this.supId = supId;
        this.supNombre = supNombre;
        this.supNroDocumento = supNroDocumento;
        this.supRepresentanteLegal = supRepresentanteLegal;
        this.supTelefono = supTelefono;
        this.supTerminal = supTerminal;
        this.supUsuarioAlta = supUsuarioAlta;
        this.supUsuarioBaja = supUsuarioBaja;
        this.supUsuarioCambio = supUsuarioCambio;
        this.tdoId = tdoId;
    }

    public BigDecimal getCrgId() {
        return crgId;
    }

    public void setCrgId(BigDecimal crgId) {
        this.crgId = crgId;
    }

    public String getSupCorreo() {
        return supCorreo;
    }

    public void setSupCorreo(String supCorreo) {
        this.supCorreo = supCorreo;
    }

    public String getSupDescripcion() {
        return supDescripcion;
    }

    public void setSupDescripcion(String supDescripcion) {
        this.supDescripcion = supDescripcion;
    }

    public String getSupDireccion() {
        return supDireccion;
    }

    public void setSupDireccion(String supDireccion) {
        this.supDireccion = supDireccion;
    }

    public BigDecimal getSupEstado() {
        return supEstado;
    }

    public void setSupEstado(BigDecimal supEstado) {
        this.supEstado = supEstado;
    }

    public Date getSupFechaAlta() {
        return supFechaAlta;
    }

    public void setSupFechaAlta(Date supFechaAlta) {
        this.supFechaAlta = supFechaAlta;
    }

    public Date getSupFechaBaja() {
        return supFechaBaja;
    }

    public void setSupFechaBaja(Date supFechaBaja) {
        this.supFechaBaja = supFechaBaja;
    }

    public Date getSupFechaCambio() {
        return supFechaCambio;
    }

    public void setSupFechaCambio(Date supFechaCambio) {
        this.supFechaCambio = supFechaCambio;
    }

    public BigDecimal getSupId() {
        return supId;
    }

    public String getSupNombre() {
        return supNombre;
    }

    public void setSupNombre(String supNombre) {
        this.supNombre = supNombre;
    }

    public String getSupNroDocumento() {
        return supNroDocumento;
    }

    public void setSupNroDocumento(String supNroDocumento) {
        this.supNroDocumento = supNroDocumento;
    }

    public String getSupRepresentanteLegal() {
        return supRepresentanteLegal;
    }

    public void setSupRepresentanteLegal(String supRepresentanteLegal) {
        this.supRepresentanteLegal = supRepresentanteLegal;
    }

    public String getSupTelefono() {
        return supTelefono;
    }

    public void setSupTelefono(String supTelefono) {
        this.supTelefono = supTelefono;
    }

    public String getSupTerminal() {
        return supTerminal;
    }

    public void setSupTerminal(String supTerminal) {
        this.supTerminal = supTerminal;
    }

    public String getSupUsuarioAlta() {
        return supUsuarioAlta;
    }

    public void setSupUsuarioAlta(String supUsuarioAlta) {
        this.supUsuarioAlta = supUsuarioAlta;
    }

    public String getSupUsuarioBaja() {
        return supUsuarioBaja;
    }

    public void setSupUsuarioBaja(String supUsuarioBaja) {
        this.supUsuarioBaja = supUsuarioBaja;
    }

    public String getSupUsuarioCambio() {
        return supUsuarioCambio;
    }

    public void setSupUsuarioCambio(String supUsuarioCambio) {
        this.supUsuarioCambio = supUsuarioCambio;
    }

    public BigDecimal getTdoId() {
        return tdoId;
    }

    public void setTdoId(BigDecimal tdoId) {
        this.tdoId = tdoId;
    }
}
