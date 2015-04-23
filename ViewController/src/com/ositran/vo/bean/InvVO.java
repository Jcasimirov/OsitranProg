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
    private Integer itrId;
    private Integer tiaNumero;
    private Integer tivId;
    private Integer invEstado;
    private String invNota;
    private Long invNroDocFormalizacion;
    private Date invFechaEmisionDocFomalizacion;
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

    public Integer getItrId() {
        return itrId;
    }

    public void setItrId(Integer itrId) {
        this.itrId = itrId;
    }

    public Integer getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaNumero(Integer tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public Integer getTivId() {
        return tivId;
    }

    public void setTivId(Integer tivId) {
        this.tivId = tivId;
    }

    public Integer getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(Integer invEstado) {
        this.invEstado = invEstado;
    }

    public void setInvNroDocFormalizacion(Long invNroDocFormalizacion) {
        this.invNroDocFormalizacion = invNroDocFormalizacion;
    }

    public Long getInvNroDocFormalizacion() {
        return invNroDocFormalizacion;
    }

    public void setInvFechaEmisionDocFomalizacion(Date invFechaEmisionDocFomalizacion) {
        this.invFechaEmisionDocFomalizacion = invFechaEmisionDocFomalizacion;
    }

    public Date getInvFechaEmisionDocFomalizacion() {
        return invFechaEmisionDocFomalizacion;
    }

}