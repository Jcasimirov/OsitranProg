package com.ositran.vo.bean;

import com.ositran.model.ContratoJefeArea;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ContratoJefeAreaVO {
  
    private static final long serialVersionUID = -226428555351516491L;
    private int cjaEstado;
    private Date cjaFechaFinal;
    private Date cjaFechaInicial;
    private int cjaId;
    private String cjaNroDocumento;
    private int conId;
    private int csiId;
    private int tdoId;
    private int tinId;
    
    private String nombreJefeArea;
    private String concesionNombre;
    private int contador;

    public ContratoJefeAreaVO() {
    }

    public ContratoJefeAreaVO(int cjaEstado, Date cjaFechaFinal, Date cjaFechaInicial, int cjaId,
                            String cjaNroDocumento, int conId, int csiId, int tdoId,
                            int tinId) {
        this.cjaEstado = cjaEstado;
        this.cjaFechaFinal = cjaFechaFinal;
        this.cjaFechaInicial = cjaFechaInicial;
        this.cjaId = cjaId;
        this.cjaNroDocumento = cjaNroDocumento;
        this.conId = conId;
        this.csiId = csiId;
        this.tdoId = tdoId;
        this.tinId = tinId;
    }

    public int getCjaEstado() {
        return cjaEstado;
    }

    public void setCjaEstado(int cjaEstado) {
        this.cjaEstado = cjaEstado;
    }

    public Date getCjaFechaFinal() {
        return cjaFechaFinal;
    }

    public void setCjaFechaFinal(Date cjaFechaFinal) {
        this.cjaFechaFinal = cjaFechaFinal;
    }

    public Date getCjaFechaInicial() {
        return cjaFechaInicial;
    }

    public void setCjaFechaInicial(Date cjaFechaInicial) {
        this.cjaFechaInicial = cjaFechaInicial;
    }

    public int getCjaId() {
        return cjaId;
    }

    public void setCjaId(int cjaId) {
        this.cjaId = cjaId;
    }

    public String getCjaNroDocumento() {
        return cjaNroDocumento;
    }

    public void setCjaNroDocumento(String cjaNroDocumento) {
        this.cjaNroDocumento = cjaNroDocumento;
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


    public void setNombreJefeArea(String nombreJefeArea) {
        this.nombreJefeArea = nombreJefeArea;
    }

    public String getNombreJefeArea() {
        return nombreJefeArea;
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

}
