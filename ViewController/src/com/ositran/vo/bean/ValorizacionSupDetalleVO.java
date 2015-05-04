package com.ositran.vo.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ValorizacionSupDetalleVO {
    
    private Integer cvaId;
    private double igv;
    private Integer monId;
    private double neto;
    private double ttotal;
    private Integer tvsHr;
    
    private String aeropuertos;
    private String descripcionInversion;
    private String nombreMoneda;
    
    private int contador;
    
    private double totalAprobado;
    
    private int fila;
    
    
    
    public ValorizacionSupDetalleVO() {
    }


    public ValorizacionSupDetalleVO(Integer cvaId, Long igv, Integer monId, Long neto, Long ttotal, Integer tvsHr, double totalAprobado, int fila) {
        super();
        this.cvaId = cvaId;
        this.igv = igv;
        this.monId = monId;
        this.neto = neto;
        this.ttotal = ttotal;
        this.tvsHr = tvsHr;
        this.totalAprobado = totalAprobado;
        this.fila = fila;
    }


    public void setCvaId(Integer cvaId) {
        this.cvaId = cvaId;
    }

    public Integer getCvaId() {
        return cvaId;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getIgv() {
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


    public void setTtotal(double ttotal) {
        this.ttotal = ttotal;
    }

    public double getTtotal() {
        return ttotal;
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

    public void setTotalAprobado(double totalAprobado) {
        this.totalAprobado = totalAprobado;
    }

    public double getTotalAprobado() {
        return totalAprobado;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getFila() {
        return fila;
    }
}
