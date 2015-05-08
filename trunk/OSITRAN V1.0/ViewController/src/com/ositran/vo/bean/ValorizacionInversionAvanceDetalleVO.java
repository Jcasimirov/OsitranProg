package com.ositran.vo.bean;


import java.math.BigDecimal;

import java.util.Date;

public class ValorizacionInversionAvanceDetalleVO {
    public ValorizacionInversionAvanceDetalleVO() {
        super();
    }
    private BigDecimal igv;
    private int monId;
    private BigDecimal montoPresentado;
    private int tiaNumero;
    private BigDecimal tiaTotal;
    private int iad_Id;
    private int tivId;
    private int dtiId;
    private String iadPDF;   
    private int infId;
    private int csiId;
    private int tinId;
    private int invId;
    
    private String iadDescripcion;
    private Date iadFechaInicio;
    private Date iadFechaFin;
    private String aeropuertos;
    private String descripcionInversion;
    private String nombreMoneda;
   private BigDecimal iasMontoRevisado;
   private BigDecimal montoRevisado;
    private String nombreInversion;

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getMonId() {
        return monId;
    }

    public void setMontoPresentado(BigDecimal montoPresentado) {
        this.montoPresentado = montoPresentado;
    }

    public BigDecimal getMontoPresentado() {
        return montoPresentado;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaTotal(BigDecimal tiaTotal) {
        this.tiaTotal = tiaTotal;
    }

    public BigDecimal getTiaTotal() {
        return tiaTotal;
    }


    public void setAeropuertos(String aeropuertos) {
        this.aeropuertos = aeropuertos;
    }

    public String getAeropuertos() {
        return aeropuertos;
    }

    public void setDescripcionInversion(String descripcionInversion) {
        this.descripcionInversion = descripcionInversion;
    }

    public String getDescripcionInversion() {
        return descripcionInversion;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setIad_Id(int iad_Id) {
        this.iad_Id = iad_Id;
    }

    public int getIad_Id() {
        return iad_Id;
    }


    public void setTivId(int tivId) {
        this.tivId = tivId;
    }

    public int getTivId() {
        return tivId;
    }

    public void setDtiId(int dtiId) {
        this.dtiId = dtiId;
    }

    public int getDtiId() {
        return dtiId;
    }

    public void setIadPDF(String iadPDF) {
        this.iadPDF = iadPDF;
    }

    public String getIadPDF() {
        return iadPDF;
    }

    public void setIadDescripcion(String iadDescripcion) {
        this.iadDescripcion = iadDescripcion;
    }

    public String getIadDescripcion() {
        return iadDescripcion;
    }

    public void setIadFechaInicio(Date iadFechaInicio) {
        this.iadFechaInicio = iadFechaInicio;
    }

    public Date getIadFechaInicio() {
        return iadFechaInicio;
    }

    public void setIadFechaFin(Date iadFechaFin) {
        this.iadFechaFin = iadFechaFin;
    }

    public Date getIadFechaFin() {
        return iadFechaFin;
    }


    public void setIasMontoRevisado(BigDecimal iasMontoRevisado) {
        this.iasMontoRevisado = iasMontoRevisado;
    }

    public BigDecimal getIasMontoRevisado() {
        return iasMontoRevisado;
    }

    public void setMontoRevisado(BigDecimal montoRevisado) {
        this.montoRevisado = montoRevisado;
    }

    public BigDecimal getMontoRevisado() {
        return montoRevisado;
    }



    public int getInfId() {
        return infId;
    }

    public void setInfId(int infId) {
        this.infId = infId;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }

    public int getInvId() {
        return invId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
    }

    public void setNombreInversion(String nombreInversion) {
        this.nombreInversion = nombreInversion;
    }

    public String getNombreInversion() {
        return nombreInversion;
    }
}


