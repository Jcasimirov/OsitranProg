package com.ositran.vo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class IgvVO {
    
    private Integer igvEstado;    
    private Date igvFechaAlta;    
    private Date igvFechaBaja;    
    private Date igvFechaCambio;    
    private Date igvFechacaducidad;    
    private Date igvFechavigencia;    
    private Integer igvId;    
    private Double igvPorcentaje;   
    private String igvTerminal;    
    private String igvUsuarioAlta;    
    private String igvUsuarioBaja;    
    private String igvUsuarioCambio;

    
    public IgvVO() {
        super();
    }


    public void setIgvEstado(Integer igvEstado) {
        this.igvEstado = igvEstado;
    }

    public Integer getIgvEstado() {
        return igvEstado;
    }

    public void setIgvFechaAlta(Date igvFechaAlta) {
        this.igvFechaAlta = igvFechaAlta;
    }

    public Date getIgvFechaAlta() {
        return igvFechaAlta;
    }

    public void setIgvFechaBaja(Date igvFechaBaja) {
        this.igvFechaBaja = igvFechaBaja;
    }

    public Date getIgvFechaBaja() {
        return igvFechaBaja;
    }

    public void setIgvFechaCambio(Date igvFechaCambio) {
        this.igvFechaCambio = igvFechaCambio;
    }

    public Date getIgvFechaCambio() {
        return igvFechaCambio;
    }

    public void setIgvFechacaducidad(Date igvFechacaducidad) {
        this.igvFechacaducidad = igvFechacaducidad;
    }

    public Date getIgvFechacaducidad() {
        return igvFechacaducidad;
    }

    public void setIgvFechavigencia(Date igvFechavigencia) {
        this.igvFechavigencia = igvFechavigencia;
    }

    public Date getIgvFechavigencia() {
        return igvFechavigencia;
    }

    public void setIgvId(Integer igvId) {
        this.igvId = igvId;
    }

    public Integer getIgvId() {
        return igvId;
    }

    public void setIgvPorcentaje(Double igvPorcentaje) {
        this.igvPorcentaje = igvPorcentaje;
    }

    public Double getIgvPorcentaje() {
        return igvPorcentaje;
    }

    public void setIgvTerminal(String igvTerminal) {
        this.igvTerminal = igvTerminal;
    }

    public String getIgvTerminal() {
        return igvTerminal;
    }

    public void setIgvUsuarioAlta(String igvUsuarioAlta) {
        this.igvUsuarioAlta = igvUsuarioAlta;
    }

    public String getIgvUsuarioAlta() {
        return igvUsuarioAlta;
    }

    public void setIgvUsuarioBaja(String igvUsuarioBaja) {
        this.igvUsuarioBaja = igvUsuarioBaja;
    }

    public String getIgvUsuarioBaja() {
        return igvUsuarioBaja;
    }

    public void setIgvUsuarioCambio(String igvUsuarioCambio) {
        this.igvUsuarioCambio = igvUsuarioCambio;
    }

    public String getIgvUsuarioCambio() {
        return igvUsuarioCambio;
    }

}
