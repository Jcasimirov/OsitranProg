package com.ositran.vo.bean;

import java.io.InputStream;

import java.math.BigDecimal;

import java.util.Date;

public class ContratoHitoVO {
  
    private Integer conId;
    private Date htoFecha;
    private String htoFechaDescripcion;
    private Integer htoId;
    private BigDecimal htoMonto;
    private String htoOficio;
    private String htoPdf;
    private Integer monId;
    private Integer htoEstado;
    private String htoNombre;
    private InputStream fileHito;
    private String monNombre;

    private Date htoFechaAlta;
    private Date htoFechaBaja;
    private Date htoFechaCambio;
    private String htoUsuarioAlta;
    private String htoUsuarioBaja;
    private String htoUsuarioCambio;
    private String htoTerminal;
    
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

    public void setHtoFechaAlta(Date htoFechaAlta) {
        this.htoFechaAlta = htoFechaAlta;
    }

    public Date getHtoFechaAlta() {
        return htoFechaAlta;
    }

    public void setHtoFechaBaja(Date htoFechaBaja) {
        this.htoFechaBaja = htoFechaBaja;
    }

    public Date getHtoFechaBaja() {
        return htoFechaBaja;
    }

    public void setHtoFechaCambio(Date htoFechaCambio) {
        this.htoFechaCambio = htoFechaCambio;
    }

    public Date getHtoFechaCambio() {
        return htoFechaCambio;
    }

    public void setHtoUsuarioAlta(String htoUsuarioAlta) {
        this.htoUsuarioAlta = htoUsuarioAlta;
    }

    public String getHtoUsuarioAlta() {
        return htoUsuarioAlta;
    }

    public void setHtoUsuarioBaja(String htoUsuarioBaja) {
        this.htoUsuarioBaja = htoUsuarioBaja;
    }

    public String getHtoUsuarioBaja() {
        return htoUsuarioBaja;
    }

    public void setHtoUsuarioCambio(String htoUsuarioCambio) {
        this.htoUsuarioCambio = htoUsuarioCambio;
    }

    public String getHtoUsuarioCambio() {
        return htoUsuarioCambio;
    }

    public void setHtoTerminal(String htoTerminal) {
        this.htoTerminal = htoTerminal;
    }

    public String getHtoTerminal() {
        return htoTerminal;
    }

    public void setHtoFechaDescripcion(String htoFechaDescripcion) {
        this.htoFechaDescripcion = htoFechaDescripcion;
    }

    public String getHtoFechaDescripcion() {
        return htoFechaDescripcion;
    }
}
