package com.ositran.vo.bean;

import com.ositran.model.InfraestructuraTipo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ConcesionVO {
    
    
    public ConcesionVO() {
        super();
    }

    public ConcesionVO(Date csiFechaAlta, Date csiFechaBaja, Date csiFechaCambio, Integer csiId, String csiNombre,
                       String csiTerminal, String csiUsuarioAlta, String csiUsuarioBaja, String csiUsuarioCambio,
                     Integer csiEstado,Integer tinId) {
        super();
        this.csiFechaAlta = csiFechaAlta;
        this.csiFechaBaja = csiFechaBaja;
        this.csiFechaCambio = csiFechaCambio;
        this.csiId = csiId;
        this.csiNombre = csiNombre;
        this.csiTerminal = csiTerminal;
        this.csiUsuarioAlta = csiUsuarioAlta;
        this.csiUsuarioBaja = csiUsuarioBaja;
        this.csiUsuarioCambio = csiUsuarioCambio;
        this.tinId = tinId;
        this.csiEstado = csiEstado;
    }

    private Date csiFechaAlta;
    private Date csiFechaBaja;
    private Date csiFechaCambio;
    private Integer csiId;
    private String csiNombre;
    private String csiTerminal;
    private String csiUsuarioAlta;
    private String csiUsuarioBaja;
    private String csiUsuarioCambio;

    private Integer tinId;
 
    private InfraestructuraTipo infraestructuraTipo;
   
    private Integer csiEstado;


    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }


    public void setCsiFechaAlta(Date csiFechaAlta) {
        this.csiFechaAlta = csiFechaAlta;
    }

    public Date getCsiFechaAlta() {
        return csiFechaAlta;
    }

    public void setCsiFechaBaja(Date csiFechaBaja) {
        this.csiFechaBaja = csiFechaBaja;
    }

    public Date getCsiFechaBaja() {
        return csiFechaBaja;
    }

    public void setCsiFechaCambio(Date csiFechaCambio) {
        this.csiFechaCambio = csiFechaCambio;
    }

    public Date getCsiFechaCambio() {
        return csiFechaCambio;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setCsiNombre(String csiNombre) {
        this.csiNombre = csiNombre;
    }

    public String getCsiNombre() {
        return csiNombre;
    }

    public void setCsiTerminal(String csiTerminal) {
        this.csiTerminal = csiTerminal;
    }

    public String getCsiTerminal() {
        return csiTerminal;
    }

    public void setCsiUsuarioAlta(String csiUsuarioAlta) {
        this.csiUsuarioAlta = csiUsuarioAlta;
    }

    public String getCsiUsuarioAlta() {
        return csiUsuarioAlta;
    }

    public void setCsiUsuarioBaja(String csiUsuarioBaja) {
        this.csiUsuarioBaja = csiUsuarioBaja;
    }

    public String getCsiUsuarioBaja() {
        return csiUsuarioBaja;
    }

    public void setCsiUsuarioCambio(String csiUsuarioCambio) {
        this.csiUsuarioCambio = csiUsuarioCambio;
    }

    public String getCsiUsuarioCambio() {
        return csiUsuarioCambio;
    }


    

    public void setCsiEstado(Integer csiEstado) {
        this.csiEstado = csiEstado;
    }

    public Integer getCsiEstado() {
        return csiEstado;
    }


    public void setInfraestructuraTipo(InfraestructuraTipo infraestructuraTipo) {
        this.infraestructuraTipo = infraestructuraTipo;
    }

    public InfraestructuraTipo getInfraestructuraTipo() {
        return infraestructuraTipo;
    }

}
