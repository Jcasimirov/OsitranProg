package com.ositran.vo.bean;

import java.util.Date;

public class ContratoInversionVO {
    
    private Integer conId;
    private Integer csiId;
    private Integer infId;
    private String invDescripcion;
    private Integer invId;
    private Integer tinId;
    private Integer invEstado;
    private String infNombre;
    
    private Date invFechaAlta;
    private Date invFechaBaja;
    private Date invFechaCambio;
    private String invUsuarioAlta;
    private String invUsuarioBaja;
    private String invUsuarioCambio;
    private String invTerminal;
    
    public ContratoInversionVO() {
        super();
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public String getInvDescripcion() {
        return invDescripcion;
    }

    public void setInvDescripcion(String invDescripcion) {
        this.invDescripcion = invDescripcion;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(Integer invEstado) {
        this.invEstado = invEstado;
    }

    public String getInfNombre() {
        return infNombre;
    }

    public void setInfNombre(String infNombre) {
        this.infNombre = infNombre;
    }

    public void setInvFechaAlta(Date invFechaAlta) {
        this.invFechaAlta = invFechaAlta;
    }

    public Date getInvFechaAlta() {
        return invFechaAlta;
    }

    public void setInvFechaBaja(Date invFechaBaja) {
        this.invFechaBaja = invFechaBaja;
    }

    public Date getInvFechaBaja() {
        return invFechaBaja;
    }

    public void setInvFechaCambio(Date invFechaCambio) {
        this.invFechaCambio = invFechaCambio;
    }

    public Date getInvFechaCambio() {
        return invFechaCambio;
    }

    public void setInvUsuarioAlta(String invUsuarioAlta) {
        this.invUsuarioAlta = invUsuarioAlta;
    }

    public String getInvUsuarioAlta() {
        return invUsuarioAlta;
    }

    public void setInvUsuarioBaja(String invUsuarioBaja) {
        this.invUsuarioBaja = invUsuarioBaja;
    }

    public String getInvUsuarioBaja() {
        return invUsuarioBaja;
    }

    public void setInvUsuarioCambio(String invUsuarioCambio) {
        this.invUsuarioCambio = invUsuarioCambio;
    }

    public String getInvUsuarioCambio() {
        return invUsuarioCambio;
    }

    public void setInvTerminal(String invTerminal) {
        this.invTerminal = invTerminal;
    }

    public String getInvTerminal() {
        return invTerminal;
    }
}
