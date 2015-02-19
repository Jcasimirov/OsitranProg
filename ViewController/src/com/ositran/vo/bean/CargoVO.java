package com.ositran.vo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class CargoVO {
    
    private String crgDescripcion;
    private Integer crgEstado;
    private Date crgFechaAlta;
    private Date crgFechaBaja;
    private Date crgFechaCambio;
    private Integer crgId;
    private String crgNombre;
    private String crgTerminal;
    private String crgUsuarioAlta;
    private String crgUsuarioBaja;
    private String crgUsuarioCambio;

    
    public CargoVO() {
        super();
    }

    public void setCrgDescripcion(String crgDescripcion) {
        this.crgDescripcion = crgDescripcion;
    }

    public String getCrgDescripcion() {
        return crgDescripcion;
    }

    public void setCrgEstado(Integer crgEstado) {
        this.crgEstado = crgEstado;
    }

    public Integer getCrgEstado() {
        return crgEstado;
    }

    public void setCrgFechaAlta(Date crgFechaAlta) {
        this.crgFechaAlta = crgFechaAlta;
    }

    public Date getCrgFechaAlta() {
        return crgFechaAlta;
    }

    public void setCrgFechaBaja(Date crgFechaBaja) {
        this.crgFechaBaja = crgFechaBaja;
    }

    public Date getCrgFechaBaja() {
        return crgFechaBaja;
    }

    public void setCrgFechaCambio(Date crgFechaCambio) {
        this.crgFechaCambio = crgFechaCambio;
    }

    public Date getCrgFechaCambio() {
        return crgFechaCambio;
    }

    public void setCrgId(Integer crgId) {
        this.crgId = crgId;
    }

    public Integer getCrgId() {
        return crgId;
    }

    public void setCrgNombre(String crgNombre) {
        this.crgNombre = crgNombre;
    }

    public String getCrgNombre() {
        return crgNombre;
    }

    public void setCrgTerminal(String crgTerminal) {
        this.crgTerminal = crgTerminal;
    }

    public String getCrgTerminal() {
        return crgTerminal;
    }

    public void setCrgUsuarioAlta(String crgUsuarioAlta) {
        this.crgUsuarioAlta = crgUsuarioAlta;
    }

    public String getCrgUsuarioAlta() {
        return crgUsuarioAlta;
    }

    public void setCrgUsuarioBaja(String crgUsuarioBaja) {
        this.crgUsuarioBaja = crgUsuarioBaja;
    }

    public String getCrgUsuarioBaja() {
        return crgUsuarioBaja;
    }

    public void setCrgUsuarioCambio(String crgUsuarioCambio) {
        this.crgUsuarioCambio = crgUsuarioCambio;
    }

    public String getCrgUsuarioCambio() {
        return crgUsuarioCambio;
    }

}
