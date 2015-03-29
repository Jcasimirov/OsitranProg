package com.ositran.vo.bean;

import com.ositran.model.Inversion;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class InversionVO {
    
    private static final long serialVersionUID = 4950860685481990821L;
    private Integer infId;
    private Integer tinId;
    private Integer csiId;
    private Integer conId;
    private String invDescripcion;
    private Integer invId;
    
    
    public InversionVO() {
    }

    public InversionVO(Integer infId, Integer tinId, Integer csiId, String invDescripcion, Integer invId,
                     int conId) {
        super();
        this.infId = infId;
        this.tinId = tinId;
        this.csiId = csiId;
        this.invDescripcion = invDescripcion;
        this.invId = invId;
        this.conId = conId;
        
    }


    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setInvDescripcion(String invDescripcion) {
        this.invDescripcion = invDescripcion;
    }

    public String getInvDescripcion() {
        return invDescripcion;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getInvId() {
        return invId;
    }
}
