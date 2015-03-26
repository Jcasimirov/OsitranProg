package com.ositran.vo.bean;

import java.util.Date;

import javax.persistence.Column;

public class InversionVO {
    
    private Integer infId;
    
    private String invDescripcion;
    
    private Integer invEstado;
    private Date invFechaAlta;
    private Date invFechaBaja;
    private Date invFechaCambio;
    private Integer invId;
    private String invNombre;
    private String invTerminal;
    private String invUsuarioAlta;
    private String invUsuarioBaja;
    private String invUsuarioCambio;
    private Integer supId;

    public InversionVO() {
        super();
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

    public Integer getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(Integer invEstado) {
        this.invEstado = invEstado;
    }

    public Date getInvFechaAlta() {
        return invFechaAlta;
    }

    public void setInvFechaAlta(Date invFechaAlta) {
        this.invFechaAlta = invFechaAlta;
    }

    public Date getInvFechaBaja() {
        return invFechaBaja;
    }

    public void setInvFechaBaja(Date invFechaBaja) {
        this.invFechaBaja = invFechaBaja;
    }

    public Date getInvFechaCambio() {
        return invFechaCambio;
    }

    public void setInvFechaCambio(Date invFechaCambio) {
        this.invFechaCambio = invFechaCambio;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public String getInvNombre() {
        return invNombre;
    }

    public void setInvNombre(String invNombre) {
        this.invNombre = invNombre;
    }

    public String getInvTerminal() {
        return invTerminal;
    }

    public void setInvTerminal(String invTerminal) {
        this.invTerminal = invTerminal;
    }

    public String getInvUsuarioAlta() {
        return invUsuarioAlta;
    }

    public void setInvUsuarioAlta(String invUsuarioAlta) {
        this.invUsuarioAlta = invUsuarioAlta;
    }

    public String getInvUsuarioBaja() {
        return invUsuarioBaja;
    }

    public void setInvUsuarioBaja(String invUsuarioBaja) {
        this.invUsuarioBaja = invUsuarioBaja;
    }

    public String getInvUsuarioCambio() {
        return invUsuarioCambio;
    }

    public void setInvUsuarioCambio(String invUsuarioCambio) {
        this.invUsuarioCambio = invUsuarioCambio;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }
}
