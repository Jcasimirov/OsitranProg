package com.ositran.vo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class TipoDocumentoVO {
    
    private String tdoDescripcion;    
    private Integer tdoEstado;    
    private Date tdoFechaAlta;    
    private Date tdoFechaBaja;    
    private Date tdoFechaCambio;    
    private Integer tdoId;    
    private String tdoNombre;    
    private String tdoTerminal;    
    private String tdoUsuarioAlta;    
    private String tdoUsuarioBaja;    
    private String tdoUsuarioCambio;

    
    public TipoDocumentoVO() {
        super();
    }


    public void setTdoDescripcion(String tdoDescripcion) {
        this.tdoDescripcion = tdoDescripcion;
    }

    public String getTdoDescripcion() {
        return tdoDescripcion;
    }

    public void setTdoEstado(Integer tdoEstado) {
        this.tdoEstado = tdoEstado;
    }

    public Integer getTdoEstado() {
        return tdoEstado;
    }

    public void setTdoFechaAlta(Date tdoFechaAlta) {
        this.tdoFechaAlta = tdoFechaAlta;
    }

    public Date getTdoFechaAlta() {
        return tdoFechaAlta;
    }

    public void setTdoFechaBaja(Date tdoFechaBaja) {
        this.tdoFechaBaja = tdoFechaBaja;
    }

    public Date getTdoFechaBaja() {
        return tdoFechaBaja;
    }

    public void setTdoFechaCambio(Date tdoFechaCambio) {
        this.tdoFechaCambio = tdoFechaCambio;
    }

    public Date getTdoFechaCambio() {
        return tdoFechaCambio;
    }

    public void setTdoId(Integer tdoId) {
        this.tdoId = tdoId;
    }

    public Integer getTdoId() {
        return tdoId;
    }

    public void setTdoNombre(String tdoNombre) {
        this.tdoNombre = tdoNombre;
    }

    public String getTdoNombre() {
        return tdoNombre;
    }

    public void setTdoTerminal(String tdoTerminal) {
        this.tdoTerminal = tdoTerminal;
    }

    public String getTdoTerminal() {
        return tdoTerminal;
    }

    public void setTdoUsuarioAlta(String tdoUsuarioAlta) {
        this.tdoUsuarioAlta = tdoUsuarioAlta;
    }

    public String getTdoUsuarioAlta() {
        return tdoUsuarioAlta;
    }

    public void setTdoUsuarioBaja(String tdoUsuarioBaja) {
        this.tdoUsuarioBaja = tdoUsuarioBaja;
    }

    public String getTdoUsuarioBaja() {
        return tdoUsuarioBaja;
    }

    public void setTdoUsuarioCambio(String tdoUsuarioCambio) {
        this.tdoUsuarioCambio = tdoUsuarioCambio;
    }

    public String getTdoUsuarioCambio() {
        return tdoUsuarioCambio;
    }


}
