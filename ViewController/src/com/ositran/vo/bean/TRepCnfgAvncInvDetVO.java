package com.ositran.vo.bean;

import java.io.Serializable;

import java.math.BigDecimal;

public class TRepCnfgAvncInvDetVO {
    private BigDecimal aidId;
    private BigDecimal caiId;
    private boolean caiMontoTotalConReajuste;
    private boolean caiMontoTotalSinAjuste;
    private BigDecimal csiId;
    private BigDecimal tinId;
    /**añadido*/
    private String concesionNombre;
    /**añadido*/
    private String infraestructuraTipo;
    /**añadido*/
    private String tipoMontoTotal;

    public TRepCnfgAvncInvDetVO() {
        aidId=null;
        caiId=null;
        caiMontoTotalConReajuste=false;
        caiMontoTotalSinAjuste=false;
        csiId=null;
        tinId=null;
        concesionNombre=null;
        infraestructuraTipo=null;
        tipoMontoTotal="sinAjuste";
    }

    public TRepCnfgAvncInvDetVO(BigDecimal aidId, BigDecimal caiId, boolean caiMontoTotalConReajuste,
                              boolean caiMontoTotalSinAjuste, BigDecimal csiId, BigDecimal tinId) {
        this.aidId = aidId;
        this.caiId = caiId;
        this.caiMontoTotalConReajuste = caiMontoTotalConReajuste;
        this.caiMontoTotalSinAjuste = caiMontoTotalSinAjuste;
        this.csiId = csiId;
        this.tinId = tinId;
    }

    public BigDecimal getAidId() {
        return aidId;
    }

    public void setAidId(BigDecimal aidId) {
        this.aidId = aidId;
    }

    public BigDecimal getCaiId() {
        return caiId;
    }

    public void setCaiId(BigDecimal caiId) {
        this.caiId = caiId;
    }

    public BigDecimal getCsiId() {
        return csiId;
    }

    public void setCsiId(BigDecimal csiId) {
        this.csiId = csiId;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }

    public void setConcesionNombre(String concesionNombre) {
        this.concesionNombre = concesionNombre;
    }

    public String getConcesionNombre() {
        return concesionNombre;
    }

    public void setInfraestructuraTipo(String infraestructuraTipo) {
        this.infraestructuraTipo = infraestructuraTipo;
    }

    public String getInfraestructuraTipo() {
        return infraestructuraTipo;
    }

    public void setCaiMontoTotalConReajuste(boolean caiMontoTotalConReajuste) {
        this.caiMontoTotalConReajuste = caiMontoTotalConReajuste;
    }

    public boolean isCaiMontoTotalConReajuste() {
        return caiMontoTotalConReajuste;
    }

    public void setCaiMontoTotalSinAjuste(boolean caiMontoTotalSinAjuste) {
        this.caiMontoTotalSinAjuste = caiMontoTotalSinAjuste;
    }

    public boolean isCaiMontoTotalSinAjuste() {
        return caiMontoTotalSinAjuste;
    }

    public void setTipoMontoTotal(String tipoMontoTotal) {
        this.tipoMontoTotal = tipoMontoTotal;
    }

    public String getTipoMontoTotal() {
        return tipoMontoTotal;
    }
    
}
