package com.ositran.vo.bean;

import java.util.Date;

public class ContratoHitoVO {
  
    private Integer conId;
    private Date htoFecha;
    private Integer htoId;
    private Integer htoMonto;
    private String htoOficio;
    private String htoPdf;
    private Integer monId;

    public ContratoHitoVO() {
        super();
    }


    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Date getHtoFecha() {
        return htoFecha;
    }

    public void setHtoFecha(Date htoFecha) {
        this.htoFecha = htoFecha;
    }

    public Integer getHtoId() {
        return htoId;
    }

    public void setHtoId(Integer htoId) {
        this.htoId = htoId;
    }

    public Integer getHtoMonto() {
        return htoMonto;
    }

    public void setHtoMonto(Integer htoMonto) {
        this.htoMonto = htoMonto;
    }

    public String getHtoOficio() {
        return htoOficio;
    }

    public void setHtoOficio(String htoOficio) {
        this.htoOficio = htoOficio;
    }

    public String getHtoPdf() {
        return htoPdf;
    }

    public void setHtoPdf(String htoPdf) {
        this.htoPdf = htoPdf;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }
}
