package com.ositran.vo.bean;

import java.util.Date;

public class ContratoAlertaVO {
    
    private Integer caeId;
    private String calAeropuerto; 
    private Integer calDiaPresentacion;   
    private Date calFechaFin;   
    private Date calFechaInicio;
    private Integer calId;   
    private String calNombreconcesion;
    private String calPlazo;  
    private Integer conId;
    private Integer perId;
    private Integer calEstado;
    private String caeNombre;

    public ContratoAlertaVO() {
        super();
    }


    public Integer getCaeId() {
        return caeId;
    }

    public void setCaeId(Integer caeId) {
        this.caeId = caeId;
    }

    public String getCalAeropuerto() {
        return calAeropuerto;
    }

    public void setCalAeropuerto(String calAeropuerto) {
        this.calAeropuerto = calAeropuerto;
    }

    public Integer getCalDiaPresentacion() {
        return calDiaPresentacion;
    }

    public void setCalDiaPresentacion(Integer calDiaPresentacion) {
        this.calDiaPresentacion = calDiaPresentacion;
    }

    public Date getCalFechaFin() {
        return calFechaFin;
    }

    public void setCalFechaFin(Date calFechaFin) {
        this.calFechaFin = calFechaFin;
    }

    public Date getCalFechaInicio() {
        return calFechaInicio;
    }

    public void setCalFechaInicio(Date calFechaInicio) {
        this.calFechaInicio = calFechaInicio;
    }

    public Integer getCalId() {
        return calId;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    public String getCalNombreconcesion() {
        return calNombreconcesion;
    }

    public void setCalNombreconcesion(String calNombreconcesion) {
        this.calNombreconcesion = calNombreconcesion; 
    }

    public String getCalPlazo() {
        return calPlazo;
    }

    public void setCalPlazo(String calPlazo) {
        this.calPlazo = calPlazo;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Integer getCalEstado() {
        return calEstado;
    }

    public void setCalEstado(Integer calEstado) {
        this.calEstado = calEstado;
    }

    public String getCaeNombre() {
        return caeNombre;
    }

    public void setCaeNombre(String caeNombre) {
        this.caeNombre = caeNombre;
    }
}