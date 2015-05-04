package com.ositran.vo.bean;

import java.util.Date;

import javax.persistence.Column;

public class ContratoResSupDetalleVO {
    
    private Integer conId;
    private Integer rsdEstado;
    private Date rsdFechaAsignacion;
    private Integer rsdId;
    private String rsdNroDocumento;
    private Integer rsuId;
    private Integer tccTipo;
    private Integer tdoId;
    private Integer tipoSup;
    private Integer ccoId;
    private Integer infId;
    private Integer invId;
    private Integer codigoSup;
    
    private String nombresup;
    private String correoSupervisor;


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

    public void setTipoSup(Integer tipoSup) {
        this.tipoSup = tipoSup;
    }

    public Integer getTipoSup() {
        return tipoSup;
    }

    public void setCcoId(Integer ccoId) {
        this.ccoId = ccoId;
    }

    public Integer getCcoId() {
        return ccoId;
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

    public void setNombresup(String nombresup) {
        this.nombresup = nombresup;
    }

    public String getNombresup() {
        return nombresup;
    }

    public void setCodigoSup(Integer codigoSup) {
        this.codigoSup = codigoSup;
    }

    public Integer getCodigoSup() {
        return codigoSup;
    }

    public void setCorreoSupervisor(String correoSupervisor) {
        this.correoSupervisor = correoSupervisor;
    }

    public String getCorreoSupervisor() {
        return correoSupervisor;
    }

}
