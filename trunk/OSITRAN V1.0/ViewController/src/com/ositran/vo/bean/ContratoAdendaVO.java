package com.ositran.vo.bean;


import java.util.Date;

public class ContratoAdendaVO {
    public ContratoAdendaVO() {
        super();
    }
    
    private String cadDescripcion;
    private String cadDocumentoFisico;
    private Date cadFecha;
    private Integer cadId;
    private Long cadMonto;
    private Integer conId;
    private Integer monId;
    private Integer tadId;
    private Integer cadEstado;
    private String cadNombre;

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

    public Long getCadMonto() {
        return cadMonto;
    }

    public void setCadMonto(Long cadMonto) {
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

    public Integer getTadId() {
        return tadId;
    }

    public void setTadId(Integer tadId) {
        this.tadId = tadId;
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
}
