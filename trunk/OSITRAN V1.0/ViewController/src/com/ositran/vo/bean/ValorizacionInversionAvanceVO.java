package com.ositran.vo.bean;

import java.math.BigDecimal;

import java.util.Date;

public class ValorizacionInversionAvanceVO {
    public ValorizacionInversionAvanceVO() {
        super();
    }  
    
    private static final double serialVersionUID = -8313961451913199541L;
    private int ccoId;
    private int conId;
    private int csiId;
    private int iaeId;
    private int invId;
    private int mcoId;
    private int monId;
    private int tccTipo;
    private Integer tiaAnyo;
    private int tiaAprobadoPor;
    private String tiaAsunto;
    private Integer tiaDiasHabiles;
    private Date tiaFechaFin;
    private Date tiaFechaInicio;
    private Date tiaFechaRegistro;
    private Date tiaFechaVencimientoPlazo;
    private int tiaHr;
    private String tiaMontoTotalAprobado;
    private BigDecimal tiaMontoTotalPresentado;
    private BigDecimal tiaMontoTotalReajustado;
    private int tiaNumero;
    private int tiaPlazoEnDias;
    private String tiaRutaNot;
    private int tinId;
    private String monedaNombre;
    private String  estadoNombre;
    private String contratoConcesionNombre;
    private String concesionNombre;
    private BigDecimal tiaIgvMonto;
    private int tiaIgv;

    public void setCcoId(int ccoId) {
        this.ccoId = ccoId;
    }

    public int getCcoId() {
        return ccoId;
    }

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

    public void setIaeId(int iaeId) {
        this.iaeId = iaeId;
    }

    public int getIaeId() {
        return iaeId;
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

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getMonId() {
        return monId;
    }

    public void setTccTipo(int tccTipo) {
        this.tccTipo = tccTipo;
    }

    public int getTccTipo() {
        return tccTipo;
    }

    public void setTiaAnyo(Integer tiaAnyo) {
        this.tiaAnyo = tiaAnyo;
    }

    public Integer getTiaAnyo() {
        return tiaAnyo;
    }

    public void setTiaAprobadoPor(int tiaAprobadoPor) {
        this.tiaAprobadoPor = tiaAprobadoPor;
    }

    public int getTiaAprobadoPor() {
        return tiaAprobadoPor;
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

    public void setTiaMontoTotalAprobado(String tiaMontoTotalAprobado) {
        this.tiaMontoTotalAprobado = tiaMontoTotalAprobado;
    }

    public String getTiaMontoTotalAprobado() {
        return tiaMontoTotalAprobado;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaPlazoEnDias(int tiaPlazoEnDias) {
        this.tiaPlazoEnDias = tiaPlazoEnDias;
    }

    public int getTiaPlazoEnDias() {
        return tiaPlazoEnDias;
    }

    public void setTiaRutaNot(String tiaRutaNot) {
        this.tiaRutaNot = tiaRutaNot;
    }

    public String getTiaRutaNot() {
        return tiaRutaNot;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }

    public int getTinId() {
        return tinId;
    }

    public void setMonedaNombre(String monedaNombre) {
        this.monedaNombre = monedaNombre;
    }

    public String getMonedaNombre() {
        return monedaNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setTiaMontoTotalPresentado(BigDecimal tiaMontoTotalPresentado) {
        this.tiaMontoTotalPresentado = tiaMontoTotalPresentado;
    }

    public BigDecimal getTiaMontoTotalPresentado() {
        return tiaMontoTotalPresentado;
    }

    public void setTiaMontoTotalReajustado(BigDecimal tiaMontoTotalReajustado) {
        this.tiaMontoTotalReajustado = tiaMontoTotalReajustado;
    }

    public BigDecimal getTiaMontoTotalReajustado() {
        return tiaMontoTotalReajustado;
    }

    public void setContratoConcesionNombre(String contratoConcesionNombre) {
        this.contratoConcesionNombre = contratoConcesionNombre;
    }

    public String getContratoConcesionNombre() {
        return contratoConcesionNombre;
    }


    public void setConcesionNombre(String concesionNombre) {
        this.concesionNombre = concesionNombre;
    }

    public String getConcesionNombre() {
        return concesionNombre;
    }


    public void setTiaIgvMonto(BigDecimal tiaIgvMonto) {
        this.tiaIgvMonto = tiaIgvMonto;
    }

    public BigDecimal getTiaIgvMonto() {
        return tiaIgvMonto;
    }

    public void setTiaIgv(int tiaIgv) {
        this.tiaIgv = tiaIgv;
    }

    public int getTiaIgv() {
        return tiaIgv;
    }
}
