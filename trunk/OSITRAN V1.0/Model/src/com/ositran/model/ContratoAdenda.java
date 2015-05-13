package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({ @NamedQuery(name = "ContratoAdenda.findAll", query = "select o from ContratoAdenda o") })
@Table(name = "T_CONTRATO_ADENDA")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_ADENDA"))
public class ContratoAdenda implements Serializable {
    private static final long serialVersionUID = 3393451982851266458L;
    @Column(name = "CAD_DESCRIPCION", nullable = false, length = 4000)
    private String cadDescripcion;
    @Column(name = "CAD_DOCUMENTO_FISICO")
    private String cadDocumentoFisico;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAD_FECHA")
    private Date cadFecha;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CAD_ID", nullable = false)
    private Integer cadId;
    @Column(name = "CAD_MONTO", nullable = false)
    private BigDecimal cadMonto;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "MON_ID")
    private Integer monId;
   
    @Column(name = "CAD_ESTADO")
    private Integer cadEstado;
    @Column(name = "CAD_NOMBRE")
    private String cadNombre;
    @Column(name = "TAD_ID")
    private Integer tadId;
    
    @Column(name = "CAD_COMPROMISO_INVERSION")
    private Integer cadCompromisoInversion;        
    public ContratoAdenda() {
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "CAD_FECHA_ALTA", nullable = false)
    private Date cadFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAD_FECHA_BAJA")
    private Date cadFechaBaja;
    @Column(name = "CAD_USUARIO_ALTA", length = 20)
    private String cadUsuarioAlta;
    @Column(name = "CAD_USUARIO_BAJA", length = 20)
    private String cadUsuarioBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAD_FECHA_CAMBIO")
    private Date cadFechaCambio;
    @Column(name = "CAD_USUARIO_CAMBIO", length = 20)
    private String cadUsuarioCambio;
    @Column(name = "CAD_TERMINAL", length = 20)
    private String cadTerminal;
    
    public ContratoAdenda(String cadDescripcion, String cadDocumentoFisico, Date cadFecha, Integer cadId,
                          BigDecimal cadMonto, Integer conId, Integer monId, Integer tadId, Integer cadEstado) {
        this.cadDescripcion = cadDescripcion;
        this.cadDocumentoFisico = cadDocumentoFisico;
        this.cadFecha = cadFecha;
        this.cadId = cadId;
        this.cadMonto = cadMonto;
        this.conId = conId;
        this.monId = monId;

        this.cadEstado = cadEstado;
    }

    public String getCadDescripcion() {
        return cadDescripcion;
    }

    public void setCadDescripcion(String cadDescripcion) {
        this.cadDescripcion = cadDescripcion;
    }

    public String getCadDocumentoFisico() {
        return cadDocumentoFisico;
    }

    public void setCadDocumentoFisico(String cadDocumentoFisico) {
        this.cadDocumentoFisico = cadDocumentoFisico;
    }

    public Date getCadFecha() {
        return cadFecha;
    }

    public void setCadFecha(Date cadFecha) {
        this.cadFecha = cadFecha;
    }

    public Integer getCadId() {
        return cadId;
    }

    public void setCadId(Integer cadId) {
        this.cadId = cadId;
    }

    public BigDecimal getCadMonto() {
        return cadMonto;
    }

    public void setCadMonto(BigDecimal cadMonto) {
        this.cadMonto = cadMonto;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getCadEstado() {
        return cadEstado;
    }

    public void setCadEstado(Integer cadEstado) {
        this.cadEstado = cadEstado;
    }

    public String getCadNombre() {
        return cadNombre;
    }

    public void setCadNombre(String cadNombre) {
        this.cadNombre = cadNombre;
    }

    public void setTadId(Integer tadId) {
        this.tadId = tadId;
    }

    public Integer getTadId() {
        return tadId;
    }

    public void setCadCompromisoInversion(Integer cadCompromisoInversion) {
        this.cadCompromisoInversion = cadCompromisoInversion;
    }

    public Integer getCadCompromisoInversion() {
        return cadCompromisoInversion;
    }

    public void setCadFechaAlta(Date cadFechaAlta) {
        this.cadFechaAlta = cadFechaAlta;
    }

    public Date getCadFechaAlta() {
        return cadFechaAlta;
    }

    public void setCadFechaBaja(Date cadFechaBaja) {
        this.cadFechaBaja = cadFechaBaja;
    }

    public Date getCadFechaBaja() {
        return cadFechaBaja;
    }

    public void setCadUsuarioAlta(String cadUsuarioAlta) {
        this.cadUsuarioAlta = cadUsuarioAlta;
    }

    public String getCadUsuarioAlta() {
        return cadUsuarioAlta;
    }

    public void setCadUsuarioBaja(String cadUsuarioBaja) {
        this.cadUsuarioBaja = cadUsuarioBaja;
    }

    public String getCadUsuarioBaja() {
        return cadUsuarioBaja;
    }

    public void setCadFechaCambio(Date cadFechaCambio) {
        this.cadFechaCambio = cadFechaCambio;
    }

    public Date getCadFechaCambio() {
        return cadFechaCambio;
    }

    public void setCadUsuarioCambio(String cadUsuarioCambio) {
        this.cadUsuarioCambio = cadUsuarioCambio;
    }

    public String getCadUsuarioCambio() {
        return cadUsuarioCambio;
    }

    public void setCadTerminal(String cadTerminal) {
        this.cadTerminal = cadTerminal;
    }

    public String getCadTerminal() {
        return cadTerminal;
    }
}
