package com.ositran.vo.bean;

import java.util.Date;

public class ValorizacionInversionAvanceVO {
    public ValorizacionInversionAvanceVO() {
        super();
    }

    private int conId;
    private int csiId;
    private int invId;
    private int mcoId;
    private Integer tiaAnyo;
    private String tiaAsunto;
    private Integer tiaDiasHabiles;
    private Date tiaFechaFin;
    private Date tiaFechaInicio;
    private Date tiaFechaRegistro;
    private Date tiaFechaVencimientoPlazo;
    private int tiaHr;
    private int tiaNumero;
    private int tiaPlazoEnDías;
    private int tinId;


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

    public void setTiaPlazoEnDías(int tiaPlazoEnDías) {
        this.tiaPlazoEnDías = tiaPlazoEnDías;
    }

    public int getTiaPlazoEnDías() {
        return tiaPlazoEnDías;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }

    public int getTinId() {
        return tinId;
    }
}
