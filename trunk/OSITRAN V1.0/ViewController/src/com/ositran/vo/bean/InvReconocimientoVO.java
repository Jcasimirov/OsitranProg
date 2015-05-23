package com.ositran.vo.bean;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class InvReconocimientoVO implements Serializable{
    @SuppressWarnings("compatibility:-6409320412639288448")
    private static final long serialVersionUID = 1L;

    private Integer ireEstado;

    private Date ireFechaRegistro;
 
    private Integer ireId;

    private BigDecimal ivrMontoAprobado;

    private BigDecimal ivrMontoPresentado;

    private Integer monId;

    private Integer tiaNumero;
    private Integer iadId;
    private Integer csiId;
  
    private Integer tinId;
 
    private int infId;

    private String nombreInfraestructura;
    private String desConcepto;
    private String nombreMoneda;
    private String nombreInversion;
    
    private BigDecimal montoAprobadoConIGV;
    private BigDecimal montoAprobadoSinIGV;
    private BigDecimal montoPresentadoConIGV;
    private BigDecimal montoPresentadoSinIGV;

    public void setIreFechaRegistro(Date ireFechaRegistro) {
        this.ireFechaRegistro = ireFechaRegistro;
    }

    public Date getIreFechaRegistro() {
        return ireFechaRegistro;
    }



    public void setIvrMontoAprobado(BigDecimal ivrMontoAprobado) {
        this.ivrMontoAprobado = ivrMontoAprobado;
    }

    public BigDecimal getIvrMontoAprobado() {
        return ivrMontoAprobado;
    }

    public void setIvrMontoPresentado(BigDecimal ivrMontoPresentado) {
        this.ivrMontoPresentado = ivrMontoPresentado;
    }

    public BigDecimal getIvrMontoPresentado() {
        return ivrMontoPresentado;
    }

   

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setInfId(int infId) {
        this.infId = infId;
    }

    public int getInfId() {
        return infId;
    }



    public void setNombreInfraestructura(String nombreInfraestructura) {
        this.nombreInfraestructura = nombreInfraestructura;
    }

    public String getNombreInfraestructura() {
        return nombreInfraestructura;
    }

    public void setDesConcepto(String desConcepto) {
        this.desConcepto = desConcepto;
    }

    public String getDesConcepto() {
        return desConcepto;
    }

    public void setIreEstado(Integer ireEstado) {
        this.ireEstado = ireEstado;
    }

    public Integer getIreEstado() {
        return ireEstado;
    }

    public void setIreId(Integer ireId) {
        this.ireId = ireId;
    }

    public Integer getIreId() {
        return ireId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setTiaNumero(Integer tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public Integer getTiaNumero() {
        return tiaNumero;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setIadId(Integer iadId) {
        this.iadId = iadId;
    }

    public Integer getIadId() {
        return iadId;
    }

    public void setNombreInversion(String nombreInversion) {
        this.nombreInversion = nombreInversion;
    }

    public String getNombreInversion() {
        return nombreInversion;
    }

    public void setMontoAprobadoConIGV(BigDecimal montoAprobadoConIGV) {
        this.montoAprobadoConIGV = montoAprobadoConIGV;
    }

    public BigDecimal getMontoAprobadoConIGV() {
        return montoAprobadoConIGV;
    }

    public void setMontoAprobadoSinIGV(BigDecimal montoAprobadoSinIGV) {
        this.montoAprobadoSinIGV = montoAprobadoSinIGV;
    }

    public BigDecimal getMontoAprobadoSinIGV() {
        return montoAprobadoSinIGV;
    }

    public void setMontoPresentadoConIGV(BigDecimal montoPresentadoConIGV) {
        this.montoPresentadoConIGV = montoPresentadoConIGV;
    }

    public BigDecimal getMontoPresentadoConIGV() {
        return montoPresentadoConIGV;
    }

    public void setMontoPresentadoSinIGV(BigDecimal montoPresentadoSinIGV) {
        this.montoPresentadoSinIGV = montoPresentadoSinIGV;
    }

    public BigDecimal getMontoPresentadoSinIGV() {
        return montoPresentadoSinIGV;
    }


}
