package com.ositran.model.reportes;

/*
 * Clase: EmpSupInf
 * Descripcion: Esta clase contiene los atributos para el reporte de Empresa Supervisora VS Infraestructura
 * Autor: E. Alfredo Panitz R.
 * Fecha: 30/04/2015
 */

public class EmpSupInf {
    
    private String nomTipInfraestructura;
    private String nomConcesion;
    private String nomModalidad;
    private String nomEmpSupervisora;


    public String getNomConcesion() {
        return nomConcesion;
    }

    public void setNomConcesion(String nomConcesion) {
        this.nomConcesion = nomConcesion;
    }

    public String getNomModalidad() {
        return nomModalidad;
    }

    public void setNomModalidad(String nomModalidad) {
        this.nomModalidad = nomModalidad;
    }

    public String getNomEmpSupervisora() {
        return nomEmpSupervisora;
    }

    public void setNomEmpSupervisora(String nomEmpSupervisora) {
        this.nomEmpSupervisora = nomEmpSupervisora;
    }

    public String getNomTipInfraestructura() {
        return nomTipInfraestructura;
    }

    public void setNomTipInfraestructura(String nomTipInfraestructura) {
        this.nomTipInfraestructura = nomTipInfraestructura;
    }
}
