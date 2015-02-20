package com.ositran.model;
import java.io.Serializable;
import java.util.Date;



public class Infraestructura  {
    private Integer csiId;
    private Date infFechaAlta;
    private Date infFechaBaja;
    private Date infFechaCambio;
    private Integer infId;
    private String infNombre;
    private String infTerminal;
    private String infUsuarioAlta;
    private String infUsuarioBaja;
    private String infUsuarioCambio;
    private Integer infEstado;

    public Infraestructura() {
    }

    public Infraestructura(Integer csiId, Date infFechaAlta, Date infFechaBaja, Date infFechaCambio,
                           Integer infId, String infNombre, String infTerminal, String infUsuarioAlta,
                           String infUsuarioBaja, String infUsuarioCambio,Integer infEstado) {
        this.csiId = csiId;
        this.infFechaAlta = infFechaAlta;
        this.infFechaBaja = infFechaBaja;
        this.infFechaCambio = infFechaCambio;
        this.infId = infId;
        this.infNombre = infNombre;
        this.infTerminal = infTerminal;
        this.infUsuarioAlta = infUsuarioAlta;
        this.infUsuarioBaja = infUsuarioBaja;
        this.infUsuarioCambio = infUsuarioCambio;
        this.infEstado = infEstado;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Date getInfFechaAlta() {
        return infFechaAlta;
    }

    public void setInfFechaAlta(Date infFechaAlta) {
        this.infFechaAlta = infFechaAlta;
    }

    public Date getInfFechaBaja() {
        return infFechaBaja;
    }

    public void setInfFechaBaja(Date infFechaBaja) {
        this.infFechaBaja = infFechaBaja;
    }

    public Date getInfFechaCambio() {
        return infFechaCambio;
    }

    public void setInfFechaCambio(Date infFechaCambio) {
        this.infFechaCambio = infFechaCambio;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public String getInfNombre() {
        return infNombre;
    }

    public void setInfNombre(String infNombre) {
        this.infNombre = infNombre;
    }

    public String getInfTerminal() {
        return infTerminal;
    }

    public void setInfTerminal(String infTerminal) {
        this.infTerminal = infTerminal;
    }

    public String getInfUsuarioAlta() {
        return infUsuarioAlta;
    }

    public void setInfUsuarioAlta(String infUsuarioAlta) {
        this.infUsuarioAlta = infUsuarioAlta;
    }

    public String getInfUsuarioBaja() {
        return infUsuarioBaja;
    }

    public void setInfUsuarioBaja(String infUsuarioBaja) {
        this.infUsuarioBaja = infUsuarioBaja;
    }

    public String getInfUsuarioCambio() {
        return infUsuarioCambio;
    }

    public void setInfUsuarioCambio(String infUsuarioCambio) {
        this.infUsuarioCambio = infUsuarioCambio;
    }


    public void setInfEstado(Integer infEstado) {
        this.infEstado = infEstado;
    }

    public Integer getInfEstado() {
        return infEstado;
    }


}
