package com.ositran.vo.bean;

import java.io.InputStream;

import java.math.BigDecimal;

import java.util.Date;

public class ContratoHitoVO {
  
    private Integer conId;
    private Date htoFecha;
    private Integer htoId;
    private BigDecimal htoMonto;
    private String htoOficio;
    private String htoPdf;
    private Integer monId;
    private Integer htoEstado;
    private String htoNombre;
    private InputStream fileHito;
    private String monNombre;

    public ContratoHitoVO() {
        super();
    }


    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Date getHtoFecha() {
        return htoFecha;
    }

    public void setHtoFecha(Date htoFecha) {
        this.htoFecha = htoFecha;
    }

    public Integer getHtoId() {
        return htoId;
    }

    public void setHtoId(Integer htoId) {
        this.htoId = htoId;
    }

    public BigDecimal getHtoMonto() {
        return htoMonto;
    }

    public void setHtoMonto(BigDecimal htoMonto) {
        this.htoMonto = htoMonto;
    }

    public String getHtoOficio() {
        return htoOficio;
    }

    public void setHtoOficio(String htoOficio) {
        this.htoOficio = htoOficio;
    }

    public String getHtoPdf() {
        return htoPdf;
    }

    public void setHtoPdf(String htoPdf) {
        this.htoPdf = htoPdf;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getHtoEstado() {
        return htoEstado;
    }

    public void setHtoEstado(Integer htoEstado) {
        this.htoEstado = htoEstado;
    }

    public InputStream getFileHito() {
        return fileHito;
    }

    public void setFileHito(InputStream fileHito) {
        this.fileHito = fileHito;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public String getHtoNombre() {
        return htoNombre;
    }

    public void setHtoNombre(String htoNombre) {
        this.htoNombre = htoNombre;
    }
}
