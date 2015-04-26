package com.ositran.vo.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ValorizacionSupDetalleVO {
    
    private Integer cvaId;
    private BigDecimal igv;
    private Integer monId;
    private double neto;
    private double total;
    private Integer tvsHr;
    private BigDecimal tTotal;
    private String aeropuertos;
    private String descripcionInversion;
    private String nombreMoneda;
    
    private int contador;
    
    
    
    public ValorizacionSupDetalleVO() {
    }


    public ValorizacionSupDetalleVO(int cvaId, BigDecimal igv, Integer monId, double neto, double total,
                                    Integer tvsHr, String aeropuertos, String descripcionInversion, String nombreMoneda,
                                    int contador) {
        super();
        this.cvaId = cvaId;
        this.igv = igv;
        this.monId = monId;
        this.neto = neto;
        this.total = total;
        this.tvsHr = tvsHr;
        this.aeropuertos = aeropuertos;
        this.descripcionInversion = descripcionInversion;
        this.nombreMoneda = nombreMoneda;
        this.contador = contador;
    }


    public void setCvaId(Integer cvaId) {
        this.cvaId = cvaId;
    }

    public Integer getCvaId() {
        return cvaId;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    public double getNeto() {
        return neto;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTvsHr(Integer tvsHr) {
        this.tvsHr = tvsHr;
    }

    public Integer getTvsHr() {
        return tvsHr;
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

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setTTotal(BigDecimal tTotal) {
        this.tTotal = tTotal;
    }

    public BigDecimal getTTotal() {
        return tTotal;
    }

}
