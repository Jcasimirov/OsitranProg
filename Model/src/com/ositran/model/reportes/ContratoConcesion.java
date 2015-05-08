package com.ositran.model.reportes;

import java.util.List;

public class ContratoConcesion {
    
    private String nomConcesion;
    private String nomConcesionario;
    private String nomTipoInfraestructura;
    private String nomModalidad;
    private String fechaSuscripcionContrato;
    private String plazoConcesion;
    private List<ContratoConcesionAdenda> lstAdendas;
    private List<ContratoConcesionEtapa> lstPeriodo;
        
    public ContratoConcesion() {
        super();
    }

    public List<ContratoConcesionEtapa> getLstPeriodo() {
        return lstPeriodo;
    }

    public void setLstPeriodo(List<ContratoConcesionEtapa> lstPeriodo) {
        this.lstPeriodo = lstPeriodo;
    }

    public List<ContratoConcesionAdenda> getLstAdendas() {
        return lstAdendas;
    }

    public void setLstAdendas(List<ContratoConcesionAdenda> lstAdendas) {
        this.lstAdendas = lstAdendas;
    }

    public String getNomConcesion() {
        return nomConcesion;
    }

    public void setNomConcesion(String nomConcesion) {
        this.nomConcesion = nomConcesion;
    }

    public String getNomConcesionario() {
        return nomConcesionario;
    }

    public void setNomConcesionario(String nomConcesionario) {
        this.nomConcesionario = nomConcesionario;
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

    public String getFechaSuscripcionContrato() {
        return fechaSuscripcionContrato;
    }

    public void setFechaSuscripcionContrato(String fechaSuscripcionContrato) {
        this.fechaSuscripcionContrato = fechaSuscripcionContrato;
    }

    public String getPlazoConcesion() {
        return plazoConcesion;
    }

    public void setPlazoConcesion(String plazoConcesion) {
        this.plazoConcesion = plazoConcesion;
    }
}
