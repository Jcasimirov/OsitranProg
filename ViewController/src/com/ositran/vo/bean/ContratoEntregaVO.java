package com.ositran.vo.bean;

import java.io.InputStream;

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
    private String cenFechaDescripcion;
    
    private InputStream inputStreamNuevaEntrega;
    
    private Date cenFechaAlta;
    private Date cenFechaBaja;
    private String cenUsuarioAlta;
    private String cenUsuarioBaja;
    private Date cenFechaCambio;
    private String cenUsuarioCambio;
    private String cenTerminal;
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

    public void setCenFechaDescripcion(String cenFechaDescripcion) {
        this.cenFechaDescripcion = cenFechaDescripcion;
    }

    public String getCenFechaDescripcion() {
        return cenFechaDescripcion;
    }

    public void setInputStreamNuevaEntrega(InputStream inputStreamNuevaEntrega) {
        this.inputStreamNuevaEntrega = inputStreamNuevaEntrega;
    }

    public InputStream getInputStreamNuevaEntrega() {
        return inputStreamNuevaEntrega;
    }


    public void setCenFechaAlta(Date cenFechaAlta) {
        this.cenFechaAlta = cenFechaAlta;
    }

    public Date getCenFechaAlta() {
        return cenFechaAlta;
    }

    public void setCenFechaBaja(Date cenFechaBaja) {
        this.cenFechaBaja = cenFechaBaja;
    }

    public Date getCenFechaBaja() {
        return cenFechaBaja;
    }

    public void setCenUsuarioAlta(String cenUsuarioAlta) {
        this.cenUsuarioAlta = cenUsuarioAlta;
    }

    public String getCenUsuarioAlta() {
        return cenUsuarioAlta;
    }

    public void setCenUsuarioBaja(String cenUsuarioBaja) {
        this.cenUsuarioBaja = cenUsuarioBaja;
    }

    public String getCenUsuarioBaja() {
        return cenUsuarioBaja;
    }

    public void setCenFechaCambio(Date cenFechaCambio) {
        this.cenFechaCambio = cenFechaCambio;
    }

    public Date getCenFechaCambio() {
        return cenFechaCambio;
    }

    public void setCenUsuarioCambio(String cenUsuarioCambio) {
        this.cenUsuarioCambio = cenUsuarioCambio;
    }

    public String getCenUsuarioCambio() {
        return cenUsuarioCambio;
    }

    public void setCenTerminal(String cenTerminal) {
        this.cenTerminal = cenTerminal;
    }

    public String getCenTerminal() {
        return cenTerminal;
    }
}
