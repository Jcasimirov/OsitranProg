package com.ositran.vo.bean;

import java.math.BigDecimal;

import java.util.Date;

public class InvReconocimientoVO {
    private BigDecimal ireEstado;

    private Date ireFechaRegistro;
 
    private BigDecimal ireId;

    private Long ivrMontoAprobado;

    private Long ivrMontoPresentado;

    private BigDecimal monId;

    private BigDecimal tiaNumero;

    private Integer csiId;
  
    private Integer tinId;
 
    private Integer infId;
    private Integer cvaId;
    private String nombreInfraestructura;
    private String desConcepto;
    
    public void setIreEstado(BigDecimal ireEstado) {
        this.ireEstado = ireEstado;
    }

    public BigDecimal getIreEstado() {
        return ireEstado;
    }

    public void setIreFechaRegistro(Date ireFechaRegistro) {
        this.ireFechaRegistro = ireFechaRegistro;
    }

    public Date getIreFechaRegistro() {
        return ireFechaRegistro;
    }

    public void setIreId(BigDecimal ireId) {
        this.ireId = ireId;
    }

    public BigDecimal getIreId() {
        return ireId;
    }

    public void setIvrMontoAprobado(Long ivrMontoAprobado) {
        this.ivrMontoAprobado = ivrMontoAprobado;
    }

    public Long getIvrMontoAprobado() {
        return ivrMontoAprobado;
    }

    public void setIvrMontoPresentado(Long ivrMontoPresentado) {
        this.ivrMontoPresentado = ivrMontoPresentado;
    }

    public Long getIvrMontoPresentado() {
        return ivrMontoPresentado;
    }

    public void setMonId(BigDecimal monId) {
        this.monId = monId;
    }

    public BigDecimal getMonId() {
        return monId;
    }

    public void setTiaNumero(BigDecimal tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public BigDecimal getTiaNumero() {
        return tiaNumero;
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

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setCvaId(Integer cvaId) {
        this.cvaId = cvaId;
    }

    public Integer getCvaId() {
        return cvaId;
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
}
