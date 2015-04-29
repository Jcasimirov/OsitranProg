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
@NamedQueries({ @NamedQuery(name = "ContratoCompromiso.findAll", query = "select o from ContratoCompromiso o") })
@Table(name = "T_CONTRATO_COMPROMISO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_COMPROMISO"))
public class ContratoCompromiso implements Serializable {
    private static final long serialVersionUID = -4038858335843227367L;
    @Column(name = "CCO_ALCANCE", nullable = false, length = 4000)
    private String ccoAlcance;
    @Column(name = "CCO_NETO")
    private BigDecimal ccoNeto;
    @Id
    @GeneratedValue(generator = "generator") 
    @Column(name = "CCO_ID", nullable = false)
    private Integer ccoId;
    @Column(name = "CCO_IGV")
    private BigDecimal ccoIgv;
    @Column(name = "CCO_PERIODO", nullable = false, length = 4000)
    private String ccoPeriodo;
    @Column(name = "CCO_PLAZO", nullable = false)
    private String ccoPlazo;
    @Column(name = "CCO_TIPO_CAMBIO", nullable = false)
    private BigDecimal ccoTipoCambio;
    @Column(name = "CCO_TOTAL", nullable = false)
    private BigDecimal ccoTotal;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "POR_IGV")
    private BigDecimal porIgv;
    //@Id
    @Column(name = "TCC_TIPO")
    private Integer tccTipo;
    @Column(name = "TIV_ID")
    private Integer tivId;
    @Column(name = "CCO_ESTADO")
    private Integer ccoEstado;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "CCO_FECHA_ALTA", nullable = false)
    private Date ccoFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CCO_FECHA_BAJA")
    private Date ccoFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CCO_FECHA_CAMBIO")
    private Date ccoFechaCambio;
    @Column(name = "CCO_USUARIO_ALTA", length = 20)
    private String ccoUsuarioAlta;
    @Column(name = "CCO_USUARIO_BAJA", length = 20)
    private String ccoUsuarioBaja;
    @Column(name = "CCO_USUARIO_CAMBIO", length = 20)
    private String ccoUsuarioCambio;
    
    public ContratoCompromiso() {
    }

    public ContratoCompromiso(String ccoAlcance, BigDecimal ccoNeto, Integer ccoId, BigDecimal ccoIgv, String ccoPeriodo,
                              String ccoPlazo, BigDecimal ccoTipoCambio, BigDecimal ccoTotal, Integer conId,
                              Integer monId, BigDecimal porIgv, Integer tccTipo, Integer tivId, Integer ccoEstado) {
        this.ccoAlcance = ccoAlcance;
        this.ccoNeto = ccoNeto;
        this.ccoId = ccoId;
        this.ccoIgv = ccoIgv;
        this.ccoPeriodo = ccoPeriodo;
        this.ccoPlazo = ccoPlazo;
        this.ccoTipoCambio = ccoTipoCambio;
        this.ccoTotal = ccoTotal;
        this.conId = conId;
        this.monId = monId;
        this.porIgv = porIgv;
        this.tccTipo = tccTipo;
        this.tivId = tivId;
        this.ccoEstado  = ccoEstado;
    }

    public String getCcoAlcance() {
        return ccoAlcance;
    }

    public void setCcoAlcance(String ccoAlcance) {
        this.ccoAlcance = ccoAlcance;
    }

    public BigDecimal getCcoNeto() {
        return ccoNeto;
    }

    public void setCcoNeto(BigDecimal ccoNeto) {
        this.ccoNeto = ccoNeto;
    }

    public Integer getCcoId() {
        return ccoId;
    }

    public void setCcoId(Integer ccoId) {
        this.ccoId = ccoId;
    }

    public BigDecimal getCcoIgv() {
        return ccoIgv;
    }

    public void setCcoIgv(BigDecimal ccoIgv) {
        this.ccoIgv = ccoIgv;
    }

    public String getCcoPeriodo() {
        return ccoPeriodo;
    }

    public void setCcoPeriodo(String ccoPeriodo) {
        this.ccoPeriodo = ccoPeriodo;
    }

    public String getCcoPlazo() {
        return ccoPlazo;
    }

    public void setCcoPlazo(String ccoPlazo) {
        this.ccoPlazo = ccoPlazo;
    }

    public BigDecimal getCcoTipoCambio() {
        return ccoTipoCambio;
    }

    public void setCcoTipoCambio(BigDecimal ccoTipoCambio) {
        this.ccoTipoCambio = ccoTipoCambio;
    }

    public BigDecimal getCcoTotal() {
        return ccoTotal;
    }

    public void setCcoTotal(BigDecimal ccoTotal) {
        this.ccoTotal = ccoTotal;
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

    public BigDecimal getPorIgv() {
        return porIgv;
    }

    public void setPorIgv(BigDecimal porIgv) {
        this.porIgv = porIgv;
    }

    public Integer getTccTipo() {
        return tccTipo;
    }

    public void setTccTipo(Integer tccTipo) {
        this.tccTipo = tccTipo;
    }

    public Integer getTivId() {
        return tivId;
    }

    public void setTivId(Integer tivId) {
        this.tivId = tivId;
    }

    public Integer getCcoEstado() {
        return ccoEstado;
    }

    public void setCcoEstado(Integer ccoEstado) {
        this.ccoEstado = ccoEstado;
    }

    public void setCcoFechaAlta(Date ccoFechaAlta) {
        this.ccoFechaAlta = ccoFechaAlta;
    }

    public Date getCcoFechaAlta() {
        return ccoFechaAlta;
    }

    public void setCcoFechaBaja(Date ccoFechaBaja) {
        this.ccoFechaBaja = ccoFechaBaja;
    }

    public Date getCcoFechaBaja() {
        return ccoFechaBaja;
    }

    public void setCcoFechaCambio(Date ccoFechaCambio) {
        this.ccoFechaCambio = ccoFechaCambio;
    }

    public Date getCcoFechaCambio() {
        return ccoFechaCambio;
    }

    public void setCcoUsuarioAlta(String ccoUsuarioAlta) {
        this.ccoUsuarioAlta = ccoUsuarioAlta;
    }

    public String getCcoUsuarioAlta() {
        return ccoUsuarioAlta;
    }

    public void setCcoUsuarioBaja(String ccoUsuarioBaja) {
        this.ccoUsuarioBaja = ccoUsuarioBaja;
    }

    public String getCcoUsuarioBaja() {
        return ccoUsuarioBaja;
    }

    public void setCcoUsuarioCambio(String ccoUsuarioCambio) {
        this.ccoUsuarioCambio = ccoUsuarioCambio;
    }

    public String getCcoUsuarioCambio() {
        return ccoUsuarioCambio;
    }
}
