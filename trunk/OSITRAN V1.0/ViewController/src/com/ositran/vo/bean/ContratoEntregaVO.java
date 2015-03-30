package com.ositran.vo.bean;

import java.util.Date;

public class ContratoEntregaVO {
    private String cenDescripcion;
    private String cenDocumentoFisico;
    private Date cenFecha;
    private Integer cenId;
    private Long cenMonto;
    private Integer conId;
    private Integer monId;
    private String cenNombre;
    private Integer cenEstado;

    public ContratoEntregaVO() {
        super();
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

    public String getCenNombre() {
        return cenNombre;
    }

    public void setCenNombre(String cenNombre) {
        this.cenNombre = cenNombre;
    }

    public Integer getCenEstado() {
        return cenEstado;
    }

    public void setCenEstado(Integer cenEstado) {
        this.cenEstado = cenEstado;
    }
}
