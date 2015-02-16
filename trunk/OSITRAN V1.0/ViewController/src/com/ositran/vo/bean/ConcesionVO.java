package com.ositran.vo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ConcesionVO {
    
    
    public ConcesionVO() {
        super();
    }
    

    private Date tcoFechaAlta;
    private Date tcoFechaBaja;
    private Date tcoFechaCambio;
    private Integer tcoId;
    private String tcoNombre;
    private String tcoTerminal;
    private String tcoUsuarioAlta;
    private String tcoUsuarioBaja;
    private String tcoUsuarioCambio;
    private Integer tinId;


    public void setTcoFechaAlta(Date tcoFechaAlta) {
        this.tcoFechaAlta = tcoFechaAlta;
    }

    public Date getTcoFechaAlta() {
        return tcoFechaAlta;
    }

    public void setTcoFechaBaja(Date tcoFechaBaja) {
        this.tcoFechaBaja = tcoFechaBaja;
    }

    public Date getTcoFechaBaja() {
        return tcoFechaBaja;
    }

    public void setTcoFechaCambio(Date tcoFechaCambio) {
        this.tcoFechaCambio = tcoFechaCambio;
    }

    public Date getTcoFechaCambio() {
        return tcoFechaCambio;
    }

    public void setTcoId(Integer tcoId) {
        this.tcoId = tcoId;
    }

    public Integer getTcoId() {
        return tcoId;
    }

    public void setTcoNombre(String tcoNombre) {
        this.tcoNombre = tcoNombre;
    }

    public String getTcoNombre() {
        return tcoNombre;
    }

    public void setTcoTerminal(String tcoTerminal) {
        this.tcoTerminal = tcoTerminal;
    }

    public String getTcoTerminal() {
        return tcoTerminal;
    }

    public void setTcoUsuarioAlta(String tcoUsuarioAlta) {
        this.tcoUsuarioAlta = tcoUsuarioAlta;
    }

    public String getTcoUsuarioAlta() {
        return tcoUsuarioAlta;
    }

    public void setTcoUsuarioBaja(String tcoUsuarioBaja) {
        this.tcoUsuarioBaja = tcoUsuarioBaja;
    }

    public String getTcoUsuarioBaja() {
        return tcoUsuarioBaja;
    }

    public void setTcoUsuarioCambio(String tcoUsuarioCambio) {
        this.tcoUsuarioCambio = tcoUsuarioCambio;
    }

    public String getTcoUsuarioCambio() {
        return tcoUsuarioCambio;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }


}
