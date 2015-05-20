package com.ositran.vo.bean;

import java.math.BigDecimal;

public class InvReajusteVO {
    private Integer csiId;   
    private int infId;
    private Integer tinId;
    
    private Integer irjId;
   
    private BigDecimal irjMontoAprobado;
  
    private BigDecimal irjMontoReajuste;
   
    private Integer monId;
   
    private Integer tiaNumero;
    
    private String nombreInfraestructura;
    private String desConcepto;
    private String nombreMoneda;
    private Integer iadId;
    
    private String nombreInversion;
    
    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setInfId(int infId) {
        this.infId = infId;
    }

    public int getInfId() {
        return infId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setIrjId(Integer irjId) {
        this.irjId = irjId;
    }

    public Integer getIrjId() {
        return irjId;
    }

    public void setIrjMontoAprobado(BigDecimal irjMontoAprobado) {
        this.irjMontoAprobado = irjMontoAprobado;
    }

    public BigDecimal getIrjMontoAprobado() {
        return irjMontoAprobado;
    }

    public void setIrjMontoReajuste(BigDecimal irjMontoReajuste) {
        this.irjMontoReajuste = irjMontoReajuste;
    }

    public BigDecimal getIrjMontoReajuste() {
        return irjMontoReajuste;
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

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
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
}
