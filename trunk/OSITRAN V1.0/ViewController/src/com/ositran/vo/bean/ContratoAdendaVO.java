package com.ositran.vo.bean;


import java.io.InputStream;

import java.math.BigDecimal;

import java.util.Date;

public class ContratoAdendaVO {
    public ContratoAdendaVO() {
        super();
    }
    
    private String cadDescripcion;
    private String cadDocumentoFisico;
    private InputStream inputStreamNuevaAdenda;
    private Date cadFecha;
    private Integer cadId;
    private BigDecimal cadMonto;
    private Integer conId;
    private Integer monId;
    private Integer tadId;
    private Integer cadEstado;
    private String cadNombre;
    private String cadFechaDescripcion;
    private String tadNombre;
    private Integer cadCompromisoInversion; 
    private String monNombre;
    private boolean boocadCompromisoInversion; 
    
    private Date cadFechaAlta;
    private Date cadFechaBaja;
    private String cadUsuarioAlta;
    private String cadUsuarioBaja;
    private Date cadFechaCambio;
    private String cadUsuarioCambio;
    private String cadTerminal;
    
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

    public BigDecimal getCadMonto() {
        return cadMonto;
    }

    public void setCadMonto(BigDecimal cadMonto) {
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


    public void setCadFechaDescripcion(String cadFechaDescripcion) {
        this.cadFechaDescripcion = cadFechaDescripcion;
    }

    public String getCadFechaDescripcion() {
        return cadFechaDescripcion;
    }

    public void setInputStreamNuevaAdenda(InputStream inputStreamNuevaAdenda) {
        this.inputStreamNuevaAdenda = inputStreamNuevaAdenda;
    }

    public InputStream getInputStreamNuevaAdenda() {
        return inputStreamNuevaAdenda;
    }

    public void setTadNombre(String tadNombre) {
        this.tadNombre = tadNombre;
    }

    public String getTadNombre() {
        return tadNombre;
    }

    public void setCadCompromisoInversion(Integer cadCompromisoInversion) {
        this.cadCompromisoInversion = cadCompromisoInversion;
    }

    public Integer getCadCompromisoInversion() {
        return cadCompromisoInversion;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setBoocadCompromisoInversion(boolean boocadCompromisoInversion) {
        this.boocadCompromisoInversion = boocadCompromisoInversion;
    }

    public boolean isBoocadCompromisoInversion() {
        return boocadCompromisoInversion;
    }

    public void setCadFechaAlta(Date cadFechaAlta) {
        this.cadFechaAlta = cadFechaAlta;
    }

    public Date getCadFechaAlta() {
        return cadFechaAlta;
    }

    public void setCadFechaBaja(Date cadFechaBaja) {
        this.cadFechaBaja = cadFechaBaja;
    }

    public Date getCadFechaBaja() {
        return cadFechaBaja;
    }

    public void setCadUsuarioAlta(String cadUsuarioAlta) {
        this.cadUsuarioAlta = cadUsuarioAlta;
    }

    public String getCadUsuarioAlta() {
        return cadUsuarioAlta;
    }

    public void setCadUsuarioBaja(String cadUsuarioBaja) {
        this.cadUsuarioBaja = cadUsuarioBaja;
    }

    public String getCadUsuarioBaja() {
        return cadUsuarioBaja;
    }

    public void setCadFechaCambio(Date cadFechaCambio) {
        this.cadFechaCambio = cadFechaCambio;
    }

    public Date getCadFechaCambio() {
        return cadFechaCambio;
    }

    public void setCadUsuarioCambio(String cadUsuarioCambio) {
        this.cadUsuarioCambio = cadUsuarioCambio;
    }

    public String getCadUsuarioCambio() {
        return cadUsuarioCambio;
    }

    public void setCadTerminal(String cadTerminal) {
        this.cadTerminal = cadTerminal;
    }

    public String getCadTerminal() {
        return cadTerminal;
    }
}
