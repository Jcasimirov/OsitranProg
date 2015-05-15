
package com.ositran.vo.bean;

import java.io.Serializable;

import java.util.Date;

public class InfraestructuraVO implements Serializable{
    @SuppressWarnings("compatibility:-4778268853630525484")
    private static final long serialVersionUID = 3438273668343714903L;

    private int csiId;
 
    private int infEstado;
    private Date infFechaAlta;
    private Date infFechaBaja;
    private int infId;
    private String infNombre;
    private String infTerminal;
    private String infUsuarioAlta;
    private String infUsuarioBaja;
    private String infUsuarioCambio;
    private Date infiFechaCambio;
    private int tinId;

    public InfraestructuraVO() {
    }

    public InfraestructuraVO(int csiId, int infEstado, Date infFechaAlta, Date infFechaBaja,
                           int infId, String infNombre, String infTerminal, String infUsuarioAlta,
                           String infUsuarioBaja, String infUsuarioCambio, Date infiFechaCambio, int tinId) {
        this.csiId = csiId;
        this.infEstado = infEstado;
        this.infFechaAlta = infFechaAlta;
        this.infFechaBaja = infFechaBaja;
        this.infId = infId;
        this.infNombre = infNombre;
        this.infTerminal = infTerminal;
        this.infUsuarioAlta = infUsuarioAlta;
        this.infUsuarioBaja = infUsuarioBaja;
        this.infUsuarioCambio = infUsuarioCambio;
        this.infiFechaCambio = infiFechaCambio;
        this.tinId = tinId;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getInfEstado() {
        return infEstado;
    }

    public void setInfEstado(int infEstado) {
        this.infEstado = infEstado;
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

    public int getInfId() {
        return infId;
    }

    public void setInfId(int infId) {
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

    public Date getInfiFechaCambio() {
        return infiFechaCambio;
    }

    public void setInfiFechaCambio(Date infiFechaCambio) {
        this.infiFechaCambio = infiFechaCambio;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }
}