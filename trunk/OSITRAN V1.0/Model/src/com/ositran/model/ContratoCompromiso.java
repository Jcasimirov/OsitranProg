package com.ositran.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({ @NamedQuery(name = "ContratoCompromiso.findAll", query = "select o from ContratoCompromiso o") })
@Table(name = "T_CONTRATO_COMPROMISO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "sq_t_contrato_compromiso"))
public class ContratoCompromiso implements Serializable {
    private static final long serialVersionUID = -4038858335843227367L;
    @Column(name = "CCO_ALCANCE", nullable = false, length = 4000)
    private String ccoAlcance;
    @Column(name = "CCO_NETO", nullable = false)
    private Long ccoNeto;
    @Id
    @GeneratedValue(generator = "generator") 
    @Column(name = "CCO_ID", nullable = false)
    private Integer ccoId;
    @Column(name = "CCO_IGV", nullable = false)
    private Long ccoIgv;
    @Column(name = "CCO_PERIODO", nullable = false, length = 4000)
    private String ccoPeriodo;
    @Column(name = "CCO_PLAZO", nullable = false)
    private Integer ccoPlazo;
    @Column(name = "CCO_TIPO_CAMBIO", nullable = false)
    private Integer ccoTipoCambio;
    @Column(name = "CCO_TOTAL", nullable = false)
    private Long ccoTotal;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "POR_IGV", nullable = false)
    private Integer porIgv;
    //@Id
    @Column(name = "TCC_TIPO", nullable = false)
    private Integer tccTipo;
    @Column(name = "TIV_ID")
    private Integer tivId;

    public ContratoCompromiso() {
    }

    public ContratoCompromiso(String ccoAlcance, Long ccoNeto, Integer ccoId, Long ccoIgv, String ccoPeriodo,
                              Integer ccoPlazo, Integer ccoTipoCambio, Long ccoTotal, Integer conId,
                              Integer monId, Integer porIgv, Integer tccTipo, Integer tivId) {
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
    }

    public String getCcoAlcance() {
        return ccoAlcance;
    }

    public void setCcoAlcance(String ccoAlcance) {
        this.ccoAlcance = ccoAlcance;
    }

    public Long getCcoNeto() {
        return ccoNeto;
    }

    public void setCcoNeto(Long ccoNeto) {
        this.ccoNeto = ccoNeto;
    }

    public Integer getCcoId() {
        return ccoId;
    }

    public void setCcoId(Integer ccoId) {
        this.ccoId = ccoId;
    }

    public Long getCcoIgv() {
        return ccoIgv;
    }

    public void setCcoIgv(Long ccoIgv) {
        this.ccoIgv = ccoIgv;
    }

    public String getCcoPeriodo() {
        return ccoPeriodo;
    }

    public void setCcoPeriodo(String ccoPeriodo) {
        this.ccoPeriodo = ccoPeriodo;
    }

    public Integer getCcoPlazo() {
        return ccoPlazo;
    }

    public void setCcoPlazo(Integer ccoPlazo) {
        this.ccoPlazo = ccoPlazo;
    }

    public Integer getCcoTipoCambio() {
        return ccoTipoCambio;
    }

    public void setCcoTipoCambio(Integer ccoTipoCambio) {
        this.ccoTipoCambio = ccoTipoCambio;
    }

    public Long getCcoTotal() {
        return ccoTotal;
    }

    public void setCcoTotal(Long ccoTotal) {
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

    public Integer getPorIgv() {
        return porIgv;
    }

    public void setPorIgv(Integer porIgv) {
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
}
