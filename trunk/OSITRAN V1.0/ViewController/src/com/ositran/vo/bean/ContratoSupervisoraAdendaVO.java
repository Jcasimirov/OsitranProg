package com.ositran.vo.bean;

import java.io.InputStream;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ContratoSupervisoraAdendaVO {
    
    private Integer cpsId;
    private Integer cpsNroDeContrato;
    private String csaAdenda;
    private Date csaFecha;
    private Integer csaMonto;
    private Integer csaPlazo;
    private Integer monId;
    private String cenDocumentoFisicoA;
    private InputStream inputStreamNuevaEntregaA;
    
    public ContratoSupervisoraAdendaVO() {
        super();
    }


    public ContratoSupervisoraAdendaVO(Integer cpsId, Integer cpsNroDeContrato, String csaAdenda, Date csaFecha,
                                       Integer csaMonto, Integer csaPlazo, Integer monId) {
        super();
        this.cpsId = cpsId;
        this.cpsNroDeContrato = cpsNroDeContrato;
        this.csaAdenda = csaAdenda;
        this.csaFecha = csaFecha;
        this.csaMonto = csaMonto;
        this.csaPlazo = csaPlazo;
        this.monId = monId;
    }


    public void setCpsId(Integer cpsId) {
        this.cpsId = cpsId;
    }

    public Integer getCpsId() {
        return cpsId;
    }

    public void setCpsNroDeContrato(Integer cpsNroDeContrato) {
        this.cpsNroDeContrato = cpsNroDeContrato;
    }

    public Integer getCpsNroDeContrato() {
        return cpsNroDeContrato;
    }

    public void setCsaAdenda(String csaAdenda) {
        this.csaAdenda = csaAdenda;
    }

    public String getCsaAdenda() {
        return csaAdenda;
    }

    public void setCsaFecha(Date csaFecha) {
        this.csaFecha = csaFecha;
    }

    public Date getCsaFecha() {
        return csaFecha;
    }

    public void setCsaMonto(Integer csaMonto) {
        this.csaMonto = csaMonto;
    }

    public Integer getCsaMonto() {
        return csaMonto;
    }

    public void setCsaPlazo(Integer csaPlazo) {
        this.csaPlazo = csaPlazo;
    }

    public Integer getCsaPlazo() {
        return csaPlazo;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setCenDocumentoFisicoA(String cenDocumentoFisicoA) {
        this.cenDocumentoFisicoA = cenDocumentoFisicoA;
    }

    public String getCenDocumentoFisicoA() {
        return cenDocumentoFisicoA;
    }

    public void setInputStreamNuevaEntregaA(InputStream inputStreamNuevaEntregaA) {
        this.inputStreamNuevaEntregaA = inputStreamNuevaEntregaA;
    }

    public InputStream getInputStreamNuevaEntregaA() {
        return inputStreamNuevaEntregaA;
    }
}
