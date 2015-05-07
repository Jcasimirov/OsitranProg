package com.ositran.vo.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ValorizacionSupDetalleVO {
    private Integer tvsId;
    private Integer cvaId;
    private BigDecimal igv;
    private Integer monId;
    private BigDecimal neto;
    private BigDecimal ttotal;
    private BigDecimal totalAprobado;
    
    
    
    private String aeropuertos;
    private String descripcionInversion;
    private String nombreMoneda;
    private int contador;
    private int fila;
    
    
    
    public ValorizacionSupDetalleVO() {
    }


    public ValorizacionSupDetalleVO(Integer tvsId, Integer cvaId, BigDecimal igv, Integer monId, BigDecimal neto,
                                    BigDecimal ttotal, BigDecimal totalAprobado, String aeropuertos,
                                    String descripcionInversion, String nombreMoneda, int contador, int fila) {
        super();
        this.tvsId = tvsId;
        this.cvaId = cvaId;
        this.igv = igv;
        this.monId = monId;
        this.neto = neto;
        this.ttotal = ttotal;
        this.totalAprobado = totalAprobado;
        this.aeropuertos = aeropuertos;
        this.descripcionInversion = descripcionInversion;
        this.nombreMoneda = nombreMoneda;
        this.contador = contador;
        this.fila = fila;
    }


    public void setTvsId(Integer tvsId) {
        this.tvsId = tvsId;
    }

    public Integer getTvsId() {
        return tvsId;
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

    public void setNeto(BigDecimal neto) {
        this.neto = neto;
    }

    public BigDecimal getNeto() {
        return neto;
    }

    public void setTtotal(BigDecimal ttotal) {
        this.ttotal = ttotal;
    }

    public BigDecimal getTtotal() {
        return ttotal;
    }

    public void setTotalAprobado(BigDecimal totalAprobado) {
        this.totalAprobado = totalAprobado;
    }

    public BigDecimal getTotalAprobado() {
        return totalAprobado;
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

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getFila() {
        return fila;
    }
}
