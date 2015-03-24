package com.ositran.vo.bean;

import java.util.Date;

public class ConcesionVO {
    private int csiEstado;
    private Date csiFechaAlta;
    private Date csiFechaBaja;
    private Date csiFechaCambio;
    private int csiId;
    private String csiNombre;
    private String csiTerminal;
    private String csiUsuarioAlta;
    private String csiUsuarioBaja;
    private String csiUsuarioCambio;
    private int tinId;
    private int correla;
    private String nombreTipoInfra;

    public ConcesionVO() {
    }

    public ConcesionVO(int csiEstado, Date csiFechaAlta, Date csiFechaBaja, Date csiFechaCambio, int csiId,
                     String csiNombre, String csiTerminal, String csiUsuarioAlta, String csiUsuarioBaja,
                     String csiUsuarioCambio, int tinId) {
        this.csiEstado = csiEstado;
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
    }

    public int getCsiEstado() {
        return csiEstado;
    }

    public void setCsiEstado(int csiEstado) {
        this.csiEstado = csiEstado;
    }

    public Date getCsiFechaAlta() {
        return csiFechaAlta;
    }

    public void setCsiFechaAlta(Date csiFechaAlta) {
        this.csiFechaAlta = csiFechaAlta;
    }

    public Date getCsiFechaBaja() {
        return csiFechaBaja;
    }

    public void setCsiFechaBaja(Date csiFechaBaja) {
        this.csiFechaBaja = csiFechaBaja;
    }

    public Date getCsiFechaCambio() {
        return csiFechaCambio;
    }

    public void setCsiFechaCambio(Date csiFechaCambio) {
        this.csiFechaCambio = csiFechaCambio;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public String getCsiNombre() {
        return csiNombre;
    }

    public void setCsiNombre(String csiNombre) {
        this.csiNombre = csiNombre;
    }

    public String getCsiTerminal() {
        return csiTerminal;
    }

    public void setCsiTerminal(String csiTerminal) {
        this.csiTerminal = csiTerminal;
    }

    public String getCsiUsuarioAlta() {
        return csiUsuarioAlta;
    }

    public void setCsiUsuarioAlta(String csiUsuarioAlta) {
        this.csiUsuarioAlta = csiUsuarioAlta;
    }

    public String getCsiUsuarioBaja() {
        return csiUsuarioBaja;
    }

    public void setCsiUsuarioBaja(String csiUsuarioBaja) {
        this.csiUsuarioBaja = csiUsuarioBaja;
    }

    public String getCsiUsuarioCambio() {
        return csiUsuarioCambio;
    }

    public void setCsiUsuarioCambio(String csiUsuarioCambio) {
        this.csiUsuarioCambio = csiUsuarioCambio;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }


    public void setCorrela(int correla) {
        this.correla = correla;
    }

    public int getCorrela() {
        return correla;
    }

    public void setNombreTipoInfra(String nombreTipoInfra) {
        this.nombreTipoInfra = nombreTipoInfra;
    }

    public String getNombreTipoInfra() {
        return nombreTipoInfra;
    }

}
