package com.ositran.vo.bean;

import javax.persistence.Column;


public class ContratoRespSupVO {
    
    private Integer csiId;
    private Integer infId;
    private Integer invId;
    private Integer mcoId;
    private Integer rsuId;
    private Integer tinId;
    private Integer tsiId;
    private Integer ccoId;
    private Integer tccTipo;
    private Integer conId;

    
    public ContratoRespSupVO() {
        super();
    }


    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setMcoId(Integer mcoId) {
        this.mcoId = mcoId;
    }

    public Integer getMcoId() {
        return mcoId;
    }

    public void setRsuId(Integer rsuId) {
        this.rsuId = rsuId;
    }

    public Integer getRsuId() {
        return rsuId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setTsiId(Integer tsiId) {
        this.tsiId = tsiId;
    }

    public Integer getTsiId() {
        return tsiId;
    }

    public void setCcoId(Integer ccoId) {
        this.ccoId = ccoId;
    }

    public Integer getCcoId() {
        return ccoId;
    }

    public void setTccTipo(Integer tccTipo) {
        this.tccTipo = tccTipo;
    }

    public Integer getTccTipo() {
        return tccTipo;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }
}
