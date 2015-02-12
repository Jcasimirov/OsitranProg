package com.ositran.vo.bean;

import javax.persistence.Column;

public class ConcesionVO {
    public ConcesionVO() {
        super();
    }

    private static final long serialVersionUID = -4142361587235073974L;
    private Integer conId;
    private String conNombre;
    private String conNominfra;
    private String conTipoinfra;


    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConNombre(String conNombre) {
        this.conNombre = conNombre;
    }

    public String getConNombre() {
        return conNombre;
    }

    public void setConNominfra(String conNominfra) {
        this.conNominfra = conNominfra;
    }

    public String getConNominfra() {
        return conNominfra;
    }

    public void setConTipoinfra(String conTipoinfra) {
        this.conTipoinfra = conTipoinfra;
    }

    public String getConTipoinfra() {
        return conTipoinfra;
    }
}
