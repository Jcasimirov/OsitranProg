package com.ositran.vo.bean;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ContratoSubInversionesVO {

    private int conId;
    private int csiId;
    private int infId;
    private int sivEstado;
    private Date sivFechaFinal;
    private Date sivFechaInicial;
    private int sivId;
    private String sivNombre;
    private String sivUmero;
    private int tdoId;
    private int tinId;
    private int tsiId;
    
    private String nombreSupervicion;
    private String concesionNombre;
    private int contador;
    private String estadoNombre;

    public ContratoSubInversionesVO(){
        
        }

    public ContratoSubInversionesVO(int conId, int csiId, int infId, int sivEstado,
                                   Date sivFechaFinal, Date sivFechaInicial, int sivId, String sivNombre,
                                   String sivUmero, int tdoId, int tinId, int tsiId) {
        this.conId = conId;
        this.csiId = csiId;
        this.infId = infId;
        this.sivEstado = sivEstado;
        this.sivFechaFinal = sivFechaFinal;
        this.sivFechaInicial = sivFechaInicial;
        this.sivId = sivId;
        this.sivNombre = sivNombre;
        this.sivUmero = sivUmero;
        this.tdoId = tdoId;
        this.tinId = tinId;
        this.tsiId = tsiId;
    }

    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getInfId() {
        return infId;
    }

    public void setInfId(int infId) {
        this.infId = infId;
    }

    public int getSivEstado() {
        return sivEstado;
    }

    public void setSivEstado(int sivEstado) {
        this.sivEstado = sivEstado;
    }

    public Date getSivFechaFinal() {
        return sivFechaFinal;
    }

    public void setSivFechaFinal(Date sivFechaFinal) {
        this.sivFechaFinal = sivFechaFinal;
    }

    public Date getSivFechaInicial() {
        return sivFechaInicial;
    }

    public void setSivFechaInicial(Date sivFechaInicial) {
        this.sivFechaInicial = sivFechaInicial;
    }

    public int getSivId() {
        return sivId;
    }

    public void setSivId(int sivId) {
        this.sivId = sivId;
    }

    public String getSivNombre() {
        return sivNombre;
    }

    public void setSivNombre(String sivNombre) {
        this.sivNombre = sivNombre;
    }

    public String getSivUmero() {
        return sivUmero;
    }

    public void setSivUmero(String sivUmero) {
        this.sivUmero = sivUmero;
    }

    public int getTdoId() {
        return tdoId;
    }

    public void setTdoId(int tdoId) {
        this.tdoId = tdoId;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }

    public int getTsiId() {
        return tsiId;
    }

    public void setTsiId(int tsiId) {
        this.tsiId = tsiId;
    }


    public void setNombreSupervicion(String nombreSupervicion) {
        this.nombreSupervicion = nombreSupervicion;
    }

    public String getNombreSupervicion() {
        return nombreSupervicion;
    }

    public void setConcesionNombre(String concesionNombre) {
        this.concesionNombre = concesionNombre;
    }

    public String getConcesionNombre() {
        return concesionNombre;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }


    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }
}
