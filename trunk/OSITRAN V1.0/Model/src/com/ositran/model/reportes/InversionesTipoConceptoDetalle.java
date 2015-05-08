package com.ositran.model.reportes;

public class InversionesTipoConceptoDetalle {
    private String anio;
    private String mes;
    private String nomConcepto;
    private String montoReconocido;
    
    public InversionesTipoConceptoDetalle() {
        super();
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getNomConcepto() {
        return nomConcepto;
    }

    public void setNomConcepto(String nomConcepto) {
        this.nomConcepto = nomConcepto;
    }

    public String getMontoReconocido() {
        return montoReconocido;
    }

    public void setMontoReconocido(String montoReconocido) {
        this.montoReconocido = montoReconocido;
    }
}
