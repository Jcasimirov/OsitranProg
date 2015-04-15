package com.ositran.vo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ValorizacionInversionAvanceVO {
    public ValorizacionInversionAvanceVO() {
        super();
    }  
    
    private int conId;
    private int csiId;
    private int iaeId;
    private int invId;
    private int mcoId;
    private int monId;
    private Integer tiaAnyo;
    private String tiaAsunto;
    private Integer tiaDiasHabiles;
    private Date tiaFechaFin;
    private Date tiaFechaInicio;
    private Date tiaFechaRegistro;
    private Date tiaFechaVencimientoPlazo;
    private int tiaHr;
    
    
    private String tiaMontoTotalAprobado;
    private double tiaMontoTotalPresentado;
    private double tiaMontoTotalReajustado;
    private int tiaPlazoEnDias;
    private int tinId;
    
    
    private int tiaNumero;
    
    
    
    public void setConId(int conId) {
        this.conId = conId;
    }

    public int getConId() {
        return conId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
    }

    public int getInvId() {
        return invId;
    }

    public void setMcoId(int mcoId) {
        this.mcoId = mcoId;
    }

    public int getMcoId() {
        return mcoId;
    }

    public void setTiaAnyo(Integer tiaAnyo) {
        this.tiaAnyo = tiaAnyo;
    }

    public Integer getTiaAnyo() {
        return tiaAnyo;
    }

    public void setTiaAsunto(String tiaAsunto) {
        this.tiaAsunto = tiaAsunto;
    }

    public String getTiaAsunto() {
        return tiaAsunto;
    }

    public void setTiaDiasHabiles(Integer tiaDiasHabiles) {
        this.tiaDiasHabiles = tiaDiasHabiles;
    }

    public Integer getTiaDiasHabiles() {
        return tiaDiasHabiles;
    }

    public void setTiaFechaFin(Date tiaFechaFin) {
        this.tiaFechaFin = tiaFechaFin;
    }

    public Date getTiaFechaFin() {
        return tiaFechaFin;
    }

    public void setTiaFechaInicio(Date tiaFechaInicio) {
        this.tiaFechaInicio = tiaFechaInicio;
    }

    public Date getTiaFechaInicio() {
        return tiaFechaInicio;
    }

    public void setTiaFechaRegistro(Date tiaFechaRegistro) {
        this.tiaFechaRegistro = tiaFechaRegistro;
    }

    public Date getTiaFechaRegistro() {
        return tiaFechaRegistro;
    }

    public void setTiaFechaVencimientoPlazo(Date tiaFechaVencimientoPlazo) {
        this.tiaFechaVencimientoPlazo = tiaFechaVencimientoPlazo;
    }

    public Date getTiaFechaVencimientoPlazo() {
        return tiaFechaVencimientoPlazo;
    }

    public void setTiaHr(int tiaHr) {
        this.tiaHr = tiaHr;
    }

    public int getTiaHr() {
        return tiaHr;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }

    public int getTinId() {
        return tinId;
    }


    public void setIaeId(int iaeId) {
        this.iaeId = iaeId;
    }

    public int getIaeId() {
        return iaeId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getMonId() {
        return monId;
    }

    public void setTiaMontoTotalAprobado(String tiaMontoTotalAprobado) {
        this.tiaMontoTotalAprobado = tiaMontoTotalAprobado;
    }

    public String getTiaMontoTotalAprobado() {
        return tiaMontoTotalAprobado;
    }

    public void setTiaMontoTotalPresentado(double tiaMontoTotalPresentado) {
        this.tiaMontoTotalPresentado = tiaMontoTotalPresentado;
    }

    public double getTiaMontoTotalPresentado() {
        return tiaMontoTotalPresentado;
    }

    public void setTiaMontoTotalReajustado(double tiaMontoTotalReajustado) {
        this.tiaMontoTotalReajustado = tiaMontoTotalReajustado;
    }

    public double getTiaMontoTotalReajustado() {
        return tiaMontoTotalReajustado;
    }

    public void setTiaPlazoEnDias(int tiaPlazoEnDias) {
        this.tiaPlazoEnDias = tiaPlazoEnDias;
    }

    public int getTiaPlazoEnDias() {
        return tiaPlazoEnDias;
    }
}
