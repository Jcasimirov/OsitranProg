package com.ositran.vo.bean;

import java.math.BigDecimal;

import java.util.Date;


public class ContratoCompromisoVO {
    private String ccoAlcance;
    private BigDecimal ccoNeto;
    private Integer ccoId;
    private BigDecimal ccoIgv;
    private String ccoPeriodo;
    private String ccoPlazo;
    private BigDecimal ccoTipoCambio;
    private BigDecimal ccoTotal;
    private Integer conId;
    private Integer monId;
    private BigDecimal porIgv;
    private Integer tccTipo;
    private Integer tivId;
    private String tivNombre;
    private String monNombre;
    private Integer ccoEstado;

    private Date ccoFechaAlta;
    private Date ccoFechaBaja;
    private Date ccoFechaCambio;
    private String ccoUsuarioAlta;
    private String ccoUsuarioBaja;
    private String ccoUsuarioCambio;
    private String ccoTerminal;
    public ContratoCompromisoVO() {
        super();
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

    public void setTivNombre(String tivNombre) {
        this.tivNombre = tivNombre;
    }

    public String getTivNombre() {
        return tivNombre;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public String getMonNombre() {
        return monNombre;
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

    public void setCcoTerminal(String ccoTerminal) {
        this.ccoTerminal = ccoTerminal;
    }

    public String getCcoTerminal() {
        return ccoTerminal;
    }
}
