package com.ositran.vo.bean;

import java.util.Date;

public class ContratoResSupDetalleVO {
    
    private Integer conId;
    private Integer rsdEstado;
    private Date rsdFechaAsignacion;
    private Integer rsdId;
    private String rsdNroDocumento;
    private Integer rsuId;
    private Integer tccTipo;
    private Integer tdoId;


    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setRsdEstado(Integer rsdEstado) {
        this.rsdEstado = rsdEstado;
    }

    public Integer getRsdEstado() {
        return rsdEstado;
    }

    public void setRsdFechaAsignacion(Date rsdFechaAsignacion) {
        this.rsdFechaAsignacion = rsdFechaAsignacion;
    }

    public Date getRsdFechaAsignacion() {
        return rsdFechaAsignacion;
    }

    public void setRsdId(Integer rsdId) {
        this.rsdId = rsdId;
    }

    public Integer getRsdId() {
        return rsdId;
    }

    public void setRsdNroDocumento(String rsdNroDocumento) {
        this.rsdNroDocumento = rsdNroDocumento;
    }

    public String getRsdNroDocumento() {
        return rsdNroDocumento;
    }

    public void setRsuId(Integer rsuId) {
        this.rsuId = rsuId;
    }

    public Integer getRsuId() {
        return rsuId;
    }

    public void setTccTipo(Integer tccTipo) {
        this.tccTipo = tccTipo;
    }

    public Integer getTccTipo() {
        return tccTipo;
    }

    public void setTdoId(Integer tdoId) {
        this.tdoId = tdoId;
    }

    public Integer getTdoId() {
        return tdoId;
    }


}
