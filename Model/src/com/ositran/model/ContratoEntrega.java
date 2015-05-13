package com.ositran.model;

import java.io.Serializable;

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
@NamedQueries({ @NamedQuery(name = "ContratoEntrega.findAll", query = "select o from ContratoEntrega o") })
@Table(name = "T_CONTRATO_ENTREGA")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_ENTREGA"))
public class ContratoEntrega implements Serializable {
    private static final long serialVersionUID = -5323475895238864355L;
    @Column(name = "CEN_DESCRIPCION", nullable = false, length = 4000)
    private String cenDescripcion;
    @Column(name = "CEN_DOCUMENTO_FISICO")
    private String cenDocumentoFisico;
    @Temporal(TemporalType.DATE)
    @Column(name = "CEN_FECHA")
    private Date cenFecha;
    @Id
    @GeneratedValue(generator = "generator") 
    @Column(name = "CEN_ID", nullable = false)
    private Integer cenId;
    @Column(name = "CEN_MONTO", nullable = false)
    private Long cenMonto;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "MON_ID")
    private Integer monId;
    
    @Column(name = "CEN_ESTADO")
    private Integer cenEstado;
    @Column(name = "CEN_NOMBRE")
    private String cenNombre;
    public ContratoEntrega() {
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CEN_FECHA_ALTA", nullable = false)
    private Date cenFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CEN_FECHA_BAJA")
    private Date cenFechaBaja;
   
    @Column(name = "CEN_USUARIO_ALTA", length = 20)
    private String cenUsuarioAlta;
    @Column(name = "CEN_USUARIO_BAJA", length = 20)
    private String cenUsuarioBaja;
   
    @Temporal(TemporalType.DATE)
    @Column(name = "CEN_FECHA_CAMBIO")
    private Date cenFechaCambio;
    @Column(name = "CEN_USUARIO_CAMBIO", length = 20)
    private String cenUsuarioCambio;
    @Column(name = "CEN_TERMINAL", length = 20)
    private String cenTerminal;    
    public ContratoEntrega(String cenDescripcion, String cenDocumentoFisico, Date cenFecha, Integer cenId,
                           Long cenMonto, Integer conId, Integer monId, Integer cenEstado, String cenNombre) {
        this.cenDescripcion = cenDescripcion;
        this.cenDocumentoFisico = cenDocumentoFisico;
        this.cenFecha = cenFecha;
        this.cenId = cenId;
        this.cenMonto = cenMonto;
        this.conId = conId;
        this.monId = monId;
        this.cenNombre = cenNombre;
        this.cenEstado = cenEstado;
    }

    public String getCenDescripcion() {
        return cenDescripcion;
    }

    public void setCenDescripcion(String cenDescripcion) {
        this.cenDescripcion = cenDescripcion;
    }

    public String getCenDocumentoFisico() {
        return cenDocumentoFisico;
    }

    public void setCenDocumentoFisico(String cenDocumentoFisico) {
        this.cenDocumentoFisico = cenDocumentoFisico;
    }

    public Date getCenFecha() {
        return cenFecha;
    }

    public void setCenFecha(Date cenFecha) {
        this.cenFecha = cenFecha;
    }

    public Integer getCenId() {
        return cenId;
    }

    public void setCenId(Integer cenId) {
        this.cenId = cenId;
    }

    public Long getCenMonto() {
        return cenMonto;
    }

    public void setCenMonto(Long cenMonto) {
        this.cenMonto = cenMonto;
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

    public Integer getCenEstado() {
        return cenEstado;
    }

    public void setCenEstado(Integer cenEstado) {
        this.cenEstado = cenEstado;
    }

    public String getCenNombre() {
        return cenNombre;
    }

    public void setCenNombre(String cenNombre) {
        this.cenNombre = cenNombre;
    }

    public void setCenFechaAlta(Date cenFechaAlta) {
        this.cenFechaAlta = cenFechaAlta;
    }

    public Date getCenFechaAlta() {
        return cenFechaAlta;
    }

    public void setCenFechaBaja(Date cenFechaBaja) {
        this.cenFechaBaja = cenFechaBaja;
    }

    public Date getCenFechaBaja() {
        return cenFechaBaja;
    }

    public void setCenUsuarioAlta(String cenUsuarioAlta) {
        this.cenUsuarioAlta = cenUsuarioAlta;
    }

    public String getCenUsuarioAlta() {
        return cenUsuarioAlta;
    }

    public void setCenUsuarioBaja(String cenUsuarioBaja) {
        this.cenUsuarioBaja = cenUsuarioBaja;
    }

    public String getCenUsuarioBaja() {
        return cenUsuarioBaja;
    }

    public void setCenFechaCambio(Date cenFechaCambio) {
        this.cenFechaCambio = cenFechaCambio;
    }

    public Date getCenFechaCambio() {
        return cenFechaCambio;
    }

    public void setCenUsuarioCambio(String cenUsuarioCambio) {
        this.cenUsuarioCambio = cenUsuarioCambio;
    }

    public String getCenUsuarioCambio() {
        return cenUsuarioCambio;
    }

    public void setCenTerminal(String cenTerminal) {
        this.cenTerminal = cenTerminal;
    }

    public String getCenTerminal() {
        return cenTerminal;
    }
}
