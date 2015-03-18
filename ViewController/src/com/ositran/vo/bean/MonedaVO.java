package com.ositran.vo.bean;

import com.ositran.model.Moneda;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class MonedaVO {
   
    private BigDecimal monEstado;   
    private Date monFechaAlta;   
    private Date monFechaBaja; 
    private Date monFechaCambio;  
    private BigDecimal monId;   
    private String monNombre;  
    private String monSimbolo;
    private String monTerminal;
    private String monUsuarioAlta;
    private String monUsuarioBaja;
    private String monUsuarioCambio;

    public MonedaVO() {
    }

    public MonedaVO(BigDecimal monEstado, Date monFechaAlta, Date monFechaBaja, Date monFechaCambio, BigDecimal monId,
                  String monNombre, String monSimbolo, String monTerminal, String monUsuarioAlta, String monUsuarioBaja,
                  String monUsuarioCambio) {
        this.monEstado = monEstado;
        this.monFechaAlta = monFechaAlta;
        this.monFechaBaja = monFechaBaja;
        this.monFechaCambio = monFechaCambio;
        this.monId = monId;
        this.monNombre = monNombre;
        this.monSimbolo = monSimbolo;
        this.monTerminal = monTerminal;
        this.monUsuarioAlta = monUsuarioAlta;
        this.monUsuarioBaja = monUsuarioBaja;
        this.monUsuarioCambio = monUsuarioCambio;
    }

    public BigDecimal getMonEstado() {
        return monEstado;
    }

    public void setMonEstado(BigDecimal monEstado) {
        this.monEstado = monEstado;
    }

    public Date getMonFechaAlta() {
        return monFechaAlta;
    }

    public void setMonFechaAlta(Date monFechaAlta) {
        this.monFechaAlta = monFechaAlta;
    }

    public Date getMonFechaBaja() {
        return monFechaBaja;
    }

    public void setMonFechaBaja(Date monFechaBaja) {
        this.monFechaBaja = monFechaBaja;
    }

    public Date getMonFechaCambio() {
        return monFechaCambio;
    }

    public void setMonFechaCambio(Date monFechaCambio) {
        this.monFechaCambio = monFechaCambio;
    }

    public BigDecimal getMonId() {
        return monId;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public String getMonSimbolo() {
        return monSimbolo;
    }

    public void setMonSimbolo(String monSimbolo) {
        this.monSimbolo = monSimbolo;
    }

    public String getMonTerminal() {
        return monTerminal;
    }

    public void setMonTerminal(String monTerminal) {
        this.monTerminal = monTerminal;
    }

    public String getMonUsuarioAlta() {
        return monUsuarioAlta;
    }

    public void setMonUsuarioAlta(String monUsuarioAlta) {
        this.monUsuarioAlta = monUsuarioAlta;
    }

    public String getMonUsuarioBaja() {
        return monUsuarioBaja;
    }

    public void setMonUsuarioBaja(String monUsuarioBaja) {
        this.monUsuarioBaja = monUsuarioBaja;
    }

    public String getMonUsuarioCambio() {
        return monUsuarioCambio;
    }

    public void setMonUsuarioCambio(String monUsuarioCambio) {
        this.monUsuarioCambio = monUsuarioCambio;
    }
    public void setMonId(BigDecimal monId){
        this.monId = monId;
    }
    }