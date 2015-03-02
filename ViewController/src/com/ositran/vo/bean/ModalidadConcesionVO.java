package com.ositran.vo.bean;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class ModalidadConcesionVO {
    
    
    private String mcoDescripcion;    
    private Integer mcoEstado;    
    private Date mcoFechaAlta;    
    private Date mcoFechaBaja;   
    private Date mcoFechaCambio;   
    private Integer mcoId;    
    private String mcoNombre;    
    private String mcoTerminal;    
    private String mcoUsuarioAlta;    
    private String mcoUsuarioBaja;   
    private String mcoUsuarioCambio;
    
    public ModalidadConcesionVO() {
        super();
    }


    public void setMcoDescripcion(String mcoDescripcion) {
        this.mcoDescripcion = mcoDescripcion;
    }

    public String getMcoDescripcion() {
        return mcoDescripcion;
    }

    public void setMcoEstado(Integer mcoEstado) {
        this.mcoEstado = mcoEstado;
    }

    public Integer getMcoEstado() {
        return mcoEstado;
    }

    public void setMcoFechaAlta(Date mcoFechaAlta) {
        this.mcoFechaAlta = mcoFechaAlta;
    }

    public Date getMcoFechaAlta() {
        return mcoFechaAlta;
    }

    public void setMcoFechaBaja(Date mcoFechaBaja) {
        this.mcoFechaBaja = mcoFechaBaja;
    }

    public Date getMcoFechaBaja() {
        return mcoFechaBaja;
    }

    public void setMcoFechaCambio(Date mcoFechaCambio) {
        this.mcoFechaCambio = mcoFechaCambio;
    }

    public Date getMcoFechaCambio() {
        return mcoFechaCambio;
    }

    public void setMcoId(Integer mcoId) {
        this.mcoId = mcoId;
    }

    public Integer getMcoId() {
        return mcoId;
    }

    public void setMcoNombre(String mcoNombre) {
        this.mcoNombre = mcoNombre;
    }

    public String getMcoNombre() {
        return mcoNombre;
    }

    public void setMcoTerminal(String mcoTerminal) {
        this.mcoTerminal = mcoTerminal;
    }

    public String getMcoTerminal() {
        return mcoTerminal;
    }

    public void setMcoUsuarioAlta(String mcoUsuarioAlta) {
        this.mcoUsuarioAlta = mcoUsuarioAlta;
    }

    public String getMcoUsuarioAlta() {
        return mcoUsuarioAlta;
    }

    public void setMcoUsuarioBaja(String mcoUsuarioBaja) {
        this.mcoUsuarioBaja = mcoUsuarioBaja;
    }

    public String getMcoUsuarioBaja() {
        return mcoUsuarioBaja;
    }

    public void setMcoUsuarioCambio(String mcoUsuarioCambio) {
        this.mcoUsuarioCambio = mcoUsuarioCambio;
    }

    public String getMcoUsuarioCambio() {
        return mcoUsuarioCambio;
    }


   
}
