package com.ositran.vo.bean;

import java.io.InputStream;

import java.math.BigDecimal;

import java.util.Date;


public class ContratoCaoVO {

    private Date caoFecha;
    private Integer caoId;
    private BigDecimal caoMonto;
    private String caoOficio;
    private String caoPdf;
    private Integer conId;
    private Integer monId;
    private Integer caoEstado;
    private String caoNombre;
    private String monNombre;
    private InputStream fileCao;

    public ContratoCaoVO() {
    }

    public Date getCaoFecha() {
        return caoFecha;
    }

    public void setCaoFecha(Date caoFecha) {
        this.caoFecha = caoFecha;
    }

    public Integer getCaoId() {
        return caoId;
    }

    public void setCaoId(Integer caoId) {
        this.caoId = caoId;
    }

    public BigDecimal getCaoMonto() {
        return caoMonto;
    }

    public void setCaoMonto(BigDecimal caoMonto) {
        this.caoMonto = caoMonto;
    }

    public String getCaoOficio() {
        return caoOficio;
    }

    public void setCaoOficio(String caoOficio) {
        this.caoOficio = caoOficio;
    }

    public String getCaoPdf() {
        return caoPdf;
    }

    public void setCaoPdf(String caoPdf) {
        this.caoPdf = caoPdf;
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

    public Integer getCaoEstado() {
        return caoEstado;
    }

    public void setCaoEstado(Integer caoEstado) {
        this.caoEstado = caoEstado;
    }

    public String getCaoNombre() {
        return caoNombre;
    }

    public void setCaoNombre(String caoNombre) {
        this.caoNombre = caoNombre;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public InputStream getFileCao() {
        return fileCao;
    }

    public void setFileCao(InputStream fileCao) {
        this.fileCao = fileCao;
    }
}

