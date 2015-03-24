package com.ositran.vo.bean;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class VwDocInternoVO {
    
    private Integer vdiAnyo;    
    private String vdiArea;    
    private String vdiAsunto;   
    private String vdiDestino;   
    private Date vdiFecha;    
    private Date vdiFechaRegistro;    
    private Integer vdiHr;    
    private String vdiNombre;    
    private String vdiNroregistrosalida;    
    private String vdiNumero;    
    private String vdiQuienremite;   
    private Integer vdiTipo;


    public void setVdiAnyo(Integer vdiAnyo) {
        this.vdiAnyo = vdiAnyo;
    }

    public Integer getVdiAnyo() {
        return vdiAnyo;
    }

    public void setVdiArea(String vdiArea) {
        this.vdiArea = vdiArea;
    }

    public String getVdiArea() {
        return vdiArea;
    }

    public void setVdiAsunto(String vdiAsunto) {
        this.vdiAsunto = vdiAsunto;
    }

    public String getVdiAsunto() {
        return vdiAsunto;
    }

    public void setVdiDestino(String vdiDestino) {
        this.vdiDestino = vdiDestino;
    }

    public String getVdiDestino() {
        return vdiDestino;
    }

    public void setVdiFecha(Date vdiFecha) {
        this.vdiFecha = vdiFecha;
    }

    public Date getVdiFecha() {
        return vdiFecha;
    }

    public void setVdiFechaRegistro(Date vdiFechaRegistro) {
        this.vdiFechaRegistro = vdiFechaRegistro;
    }

    public Date getVdiFechaRegistro() {
        return vdiFechaRegistro;
    }

    public void setVdiHr(Integer vdiHr) {
        this.vdiHr = vdiHr;
    }

    public Integer getVdiHr() {
        return vdiHr;
    }

    public void setVdiNombre(String vdiNombre) {
        this.vdiNombre = vdiNombre;
    }

    public String getVdiNombre() {
        return vdiNombre;
    }

    public void setVdiNroregistrosalida(String vdiNroregistrosalida) {
        this.vdiNroregistrosalida = vdiNroregistrosalida;
    }

    public String getVdiNroregistrosalida() {
        return vdiNroregistrosalida;
    }

    public void setVdiNumero(String vdiNumero) {
        this.vdiNumero = vdiNumero;
    }

    public String getVdiNumero() {
        return vdiNumero;
    }

    public void setVdiQuienremite(String vdiQuienremite) {
        this.vdiQuienremite = vdiQuienremite;
    }

    public String getVdiQuienremite() {
        return vdiQuienremite;
    }

    public void setVdiTipo(Integer vdiTipo) {
        this.vdiTipo = vdiTipo;
    }

    public Integer getVdiTipo() {
        return vdiTipo;
    }


}
