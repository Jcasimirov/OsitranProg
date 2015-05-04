package com.ositran.vo.bean;

import java.math.BigDecimal;

import java.util.Date;

public class InvVO {
    
    private Integer invEstadoReconocimiento;
    private Date invFechaEmisionInforme;
    private Date invFechaEmisionOficio;    
    private Integer invId;
    private BigDecimal invMontoTipoCambio;
    private BigDecimal invMontoTotalAprobado;
    private BigDecimal invMontoTotalReajuste;
    private String invNumeroInforme;
    private String invNumeroOficio;
    private String invObservaciones;
    private String invRegSalidaInforme;
    private String invRegSalidaOficio;
    private Integer monId;
    private Integer tiaNumero;    
    private Integer invEstado;
    private String invNota;
    private String invNroDocFormalizacion;
    private Date invFechaEmisionDocFomalizacion;

    private BigDecimal invConIGV;
    private BigDecimal invPorcentajeIGV;

    private Integer invIgv;

    public InvVO() {
        super();
    }

    public Integer getInvEstadoReconocimiento() {
        return invEstadoReconocimiento;
    }

    public void setInvEstadoReconocimiento(Integer invEstadoReconocimiento) {
        this.invEstadoReconocimiento = invEstadoReconocimiento;
    }

    public Date getInvFechaEmisionInforme() {
        return invFechaEmisionInforme;
    }

    public void setInvFechaEmisionInforme(Date invFechaEmisionInforme) {
        this.invFechaEmisionInforme = invFechaEmisionInforme;
    }

    public Date getInvFechaEmisionOficio() {
        return invFechaEmisionOficio;
    }

    public void setInvFechaEmisionOficio(Date invFechaEmisionOficio) {
        this.invFechaEmisionOficio = invFechaEmisionOficio;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public BigDecimal getInvMontoTipoCambio() {
        return invMontoTipoCambio;
    }

    public void setInvMontoTipoCambio(BigDecimal invMontoTipoCambio) {
        this.invMontoTipoCambio = invMontoTipoCambio;
    }

    public BigDecimal getInvMontoTotalAprobado() {
        return invMontoTotalAprobado;
    }

    public void setInvMontoTotalAprobado(BigDecimal invMontoTotalAprobado) {
        this.invMontoTotalAprobado = invMontoTotalAprobado;
    }

    public BigDecimal getInvMontoTotalReajuste() {
        return invMontoTotalReajuste;
    }

    public void setInvMontoTotalReajuste(BigDecimal invMontoTotalReajuste) {
        this.invMontoTotalReajuste = invMontoTotalReajuste;
    }

    public String getInvNota() {
        return invNota;
    }

    public void setInvNota(String invNota) {
        this.invNota = invNota;
    }

    public String getInvNumeroInforme() {
        return invNumeroInforme;
    }

    public void setInvNumeroInforme(String invNumeroInforme) {
        this.invNumeroInforme = invNumeroInforme;
    }

    public String getInvNumeroOficio() {
        return invNumeroOficio;
    }

    public void setInvNumeroOficio(String invNumeroOficio) {
        this.invNumeroOficio = invNumeroOficio;
    }

    public String getInvObservaciones() {
        return invObservaciones;
    }

    public void setInvObservaciones(String invObservaciones) {
        this.invObservaciones = invObservaciones;
    }

    public String getInvRegSalidaInforme() {
        return invRegSalidaInforme;
    }

    public void setInvRegSalidaInforme(String invRegSalidaInforme) {
        this.invRegSalidaInforme = invRegSalidaInforme;
    }

    public String getInvRegSalidaOficio() {
        return invRegSalidaOficio;
    }

    public void setInvRegSalidaOficio(String invRegSalidaOficio) {
        this.invRegSalidaOficio = invRegSalidaOficio;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }


    public Integer getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaNumero(Integer tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public Integer getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(Integer invEstado) {
        this.invEstado = invEstado;
    }

    public void setInvNroDocFormalizacion(String invNroDocFormalizacion) {
        this.invNroDocFormalizacion = invNroDocFormalizacion;
    }

    public String getInvNroDocFormalizacion() {
        return invNroDocFormalizacion;
    }

    public void setInvFechaEmisionDocFomalizacion(Date invFechaEmisionDocFomalizacion) {
        this.invFechaEmisionDocFomalizacion = invFechaEmisionDocFomalizacion;
    }

    public Date getInvFechaEmisionDocFomalizacion() {
        return invFechaEmisionDocFomalizacion;
    }


    public void setInvConIGV(BigDecimal invConIGV) {
        this.invConIGV = invConIGV;
    }

    public BigDecimal getInvConIGV() {
        return invConIGV;
    }

    public void setInvPorcentajeIGV(BigDecimal invPorcentajeIGV) {
        this.invPorcentajeIGV = invPorcentajeIGV;
    }

    public BigDecimal getInvPorcentajeIGV() {
        return invPorcentajeIGV;
    }

    public Integer getInvIgv() {
        return invIgv;
    }

    public void setInvIgv(Integer invIgv) {
        this.invIgv = invIgv;
    }

}
