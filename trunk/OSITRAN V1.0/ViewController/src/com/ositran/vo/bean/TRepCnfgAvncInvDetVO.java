package com.ositran.vo.bean;

import com.ositran.model.TRepCnfgAvncInvDet;

import java.io.Serializable;

import java.math.BigDecimal;

public class TRepCnfgAvncInvDetVO {
    private BigDecimal aidId;
    private BigDecimal caiId;
    private Integer caiMontoTotalConReajuste;
    private Integer caiMontoTotalSinAjuste;
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
        caiMontoTotalConReajuste=null;
        caiMontoTotalSinAjuste=null;
        csiId=null;
        tinId=null;
        concesionNombre=null;
        infraestructuraTipo=null;
        tipoMontoTotal="sinAjuste";
    }
    
    public TRepCnfgAvncInvDetVO(TRepCnfgAvncInvDet entidadBD) {
        aidId=entidadBD.getAidId();
        caiId=entidadBD.getCaiId();
        caiMontoTotalConReajuste=entidadBD.getCaiMontoTotalConReajuste();
        caiMontoTotalSinAjuste=entidadBD.getCaiMontoTotalSinAjuste();
        csiId=entidadBD.getCsiId();
        tinId=entidadBD.getTinId();
        concesionNombre=null;
        infraestructuraTipo=null;
        tipoMontoTotal=null;
    }

    public TRepCnfgAvncInvDetVO(BigDecimal aidId, BigDecimal caiId, Integer caiMontoTotalConReajuste,
                              Integer caiMontoTotalSinAjuste, BigDecimal csiId, BigDecimal tinId) {
        this.aidId = aidId;
        this.caiId = caiId;
        this.caiMontoTotalConReajuste = caiMontoTotalConReajuste;
        this.caiMontoTotalSinAjuste = caiMontoTotalSinAjuste;
        this.csiId = csiId;
        this.tinId = tinId;
    }
    
    public TRepCnfgAvncInvDet devuelveEntidadBD() {
        TRepCnfgAvncInvDet entidadBD=new TRepCnfgAvncInvDet();
        entidadBD.setAidId(aidId);
        entidadBD.setCaiId(caiId);
        entidadBD.setCaiMontoTotalConReajuste(caiMontoTotalConReajuste);
        entidadBD.setCaiMontoTotalSinAjuste(caiMontoTotalSinAjuste);
        entidadBD.setCsiId(csiId);
        entidadBD.setTinId(tinId);
        return entidadBD;
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

    public void setTipoMontoTotal(String tipoMontoTotal) {
        this.tipoMontoTotal = tipoMontoTotal;
    }

    public String getTipoMontoTotal() {
        return tipoMontoTotal;
    }

    public void setCaiMontoTotalConReajuste(Integer caiMontoTotalConReajuste) {
        this.caiMontoTotalConReajuste = caiMontoTotalConReajuste;
    }

    public Integer getCaiMontoTotalConReajuste() {
        return caiMontoTotalConReajuste;
    }

    public void setCaiMontoTotalSinAjuste(Integer caiMontoTotalSinAjuste) {
        this.caiMontoTotalSinAjuste = caiMontoTotalSinAjuste;
    }

    public Integer getCaiMontoTotalSinAjuste() {
        return caiMontoTotalSinAjuste;
    }

}
