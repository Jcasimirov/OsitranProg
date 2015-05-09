package com.ositran.model.reportes;

public class ReportAlertaAeropuerto {
    
    private String nomTipoAlerta;
    private String nomTipoInfraestructura;
    private String nomModalidad;
    private String nomAeropuerto;
    private String nomInversion;
    private String nomConcesion;
    private String cantEtapa;
    private String fechaLimite;
    private String diasRestantes;
    private String diasExceso;
    private String nomEstado;
    
    public ReportAlertaAeropuerto() {
        super();
    }

    public String getNomTipoAlerta() {
        return nomTipoAlerta;
    }

    public void setNomTipoAlerta(String nomTipoAlerta) {
        this.nomTipoAlerta = nomTipoAlerta;
    }

    public String getNomTipoInfraestructura() {
        return nomTipoInfraestructura;
    }

    public void setNomTipoInfraestructura(String nomTipoInfraestructura) {
        this.nomTipoInfraestructura = nomTipoInfraestructura;
    }

    public String getNomModalidad() {
        return nomModalidad;
    }

    public void setNomModalidad(String nomModalidad) {
        this.nomModalidad = nomModalidad;
    }

    public String getNomAeropuerto() {
        return nomAeropuerto;
    }

    public void setNomAeropuerto(String nomAeropuerto) {
        this.nomAeropuerto = nomAeropuerto;
    }

    public String getNomInversion() {
        return nomInversion;
    }

    public void setNomInversion(String nomInversion) {
        this.nomInversion = nomInversion;
    }

    public String getNomConcesion() {
        return nomConcesion;
    }

    public void setNomConcesion(String nomConcesion) {
        this.nomConcesion = nomConcesion;
    }

    public String getCantEtapa() {
        return cantEtapa;
    }

    public void setCantEtapa(String cantEtapa) {
        this.cantEtapa = cantEtapa;
    }

    public String getDiasRestantes() {
        return diasRestantes;
    }

    public void setDiasRestantes(String diasRestantes) {
        this.diasRestantes = diasRestantes;
    }

    public String getDiasExceso() {
        return diasExceso;
    }

    public void setDiasExceso(String diasExceso) {
        this.diasExceso = diasExceso;
    }

    public String getNomEstado() {
        return nomEstado;
    }

    public void setNomEstado(String nomEstado) {
        this.nomEstado = nomEstado;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
}
