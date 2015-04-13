package com.ositran.vo.bean;

public class ValorizacionInversionAvanceDetalleVO {
    public ValorizacionInversionAvanceDetalleVO() {
        super();
    }
    

    private int cnvId;
    private double igv;
    private int monId;
    private double montoPresentado;
    private int tiaNumero;
    private double tiaTotal;
    
    private String aeropuertos;
    private String descripcionInversion;
    private String nombreMoneda;


    public void setCnvId(int cnvId) {
        this.cnvId = cnvId;
    }

    public int getCnvId() {
        return cnvId;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getIgv() {
        return igv;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getMonId() {
        return monId;
    }

    public void setMontoPresentado(double montoPresentado) {
        this.montoPresentado = montoPresentado;
    }

    public double getMontoPresentado() {
        return montoPresentado;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaTotal(double tiaTotal) {
        this.tiaTotal = tiaTotal;
    }

    public double getTiaTotal() {
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
}
