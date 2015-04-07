package com.ositran.vo.bean;

import java.util.Date;


public class ContratoCaoVO {

    private Date caoFecha;
    private Integer caoId;
    private Long caoMonto;
    private String caoOficio;
    private String caoPdf;
    private Integer conId;
    private Integer monId;
    private Integer caoEstado;
    private String caoNombre;
    private String monNombre;
    

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

    public Long getCaoMonto() {
        return caoMonto;
    }

    public void setCaoMonto(Long caoMonto) {
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
}

