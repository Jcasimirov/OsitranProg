package com.ositran.model.reportes;

import java.util.List;

public class InversionesTipoConcepto {
    private String nomConcesion;
    private String nomConcesionario;
    private String nomModalidad;
    private String nomTipoInfraestructura;
    private List<InversionesTipoConceptoDetalle> lstDetalle;
    private String IdDetalle;
    public InversionesTipoConcepto() {
        super();
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

    public String getNomModalidad() {
        return nomModalidad;
    }

    public void setNomModalidad(String nomModalidad) {
        this.nomModalidad = nomModalidad;
    }

    public List<InversionesTipoConceptoDetalle> getLstDetalle() {
        return lstDetalle;
    }

    public void setLstDetalle(List<InversionesTipoConceptoDetalle> lstDetalle) {
        this.lstDetalle = lstDetalle;
    }

   

    public String getNomTipoInfraestructura() {
        return nomTipoInfraestructura;
    }

    public void setNomTipoInfraestructura(String nomTipoInfraestructura) {
        this.nomTipoInfraestructura = nomTipoInfraestructura;
    }

    public String getIdDetalle() {
        return IdDetalle;
    }

    public void setIdDetalle(String IdDetalle) {
        this.IdDetalle = IdDetalle;
    }
}
