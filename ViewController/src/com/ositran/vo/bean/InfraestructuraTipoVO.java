package com.ositran.vo.bean;

import java.util.Date;

public class InfraestructuraTipoVO {
    private String tinDescripcion;   
    private int tinEstado;   
    private Date tinFechaAlta;    
    private Date tinFechaBaja;   
    private Date tinFechaCambio;   
    private int tinId;    
    private String tinNombre;    
    private String tinTerminal;   
    private String tinUsuarioAlta;   
    private String tinUsuarioBaja;   
    private String tinUsuarioCambio;
    private int contador;
    public InfraestructuraTipoVO() {
    }

    public InfraestructuraTipoVO(String tinDescripcion, int tinEstado, Date tinFechaAlta, Date tinFechaBaja,
                               Date tinFechaCambio, int tinId, String tinNombre, String tinTerminal,
                               String tinUsuarioAlta, String tinUsuarioBaja, String tinUsuarioCambio) {
        this.tinDescripcion = tinDescripcion;
        this.tinEstado = tinEstado;
        this.tinFechaAlta = tinFechaAlta;
        this.tinFechaBaja = tinFechaBaja;
        this.tinFechaCambio = tinFechaCambio;
        this.tinId = tinId;
        this.tinNombre = tinNombre;
        this.tinTerminal = tinTerminal;
        this.tinUsuarioAlta = tinUsuarioAlta;
        this.tinUsuarioBaja = tinUsuarioBaja;
        this.tinUsuarioCambio = tinUsuarioCambio;
    }

    public String getTinDescripcion() {
        return tinDescripcion;
    }

    public void setTinDescripcion(String tinDescripcion) {
        this.tinDescripcion = tinDescripcion;
    }

    public int getTinEstado() {
        return tinEstado;
    }

    public void setTinEstado(int tinEstado) {
        this.tinEstado = tinEstado;
    }

    public Date getTinFechaAlta() {
        return tinFechaAlta;
    }

    public void setTinFechaAlta(Date tinFechaAlta) {
        this.tinFechaAlta = tinFechaAlta;
    }

    public Date getTinFechaBaja() {
        return tinFechaBaja;
    }

    public void setTinFechaBaja(Date tinFechaBaja) {
        this.tinFechaBaja = tinFechaBaja;
    }

    public Date getTinFechaCambio() {
        return tinFechaCambio;
    }

    public void setTinFechaCambio(Date tinFechaCambio) {
        this.tinFechaCambio = tinFechaCambio;
    }

    public int getTinId() {
        return tinId;
    }

    public String getTinNombre() {
        return tinNombre;
    }

    public void setTinNombre(String tinNombre) {
        this.tinNombre = tinNombre;
    }

    public String getTinTerminal() {
        return tinTerminal;
    }

    public void setTinTerminal(String tinTerminal) {
        this.tinTerminal = tinTerminal;
    }

    public String getTinUsuarioAlta() {
        return tinUsuarioAlta;
    }

    public void setTinUsuarioAlta(String tinUsuarioAlta) {
        this.tinUsuarioAlta = tinUsuarioAlta;
    }

    public String getTinUsuarioBaja() {
        return tinUsuarioBaja;
    }

    public void setTinUsuarioBaja(String tinUsuarioBaja) {
        this.tinUsuarioBaja = tinUsuarioBaja;
    }

    public String getTinUsuarioCambio() {
        return tinUsuarioCambio;
    }

    public void setTinUsuarioCambio(String tinUsuarioCambio) {
        this.tinUsuarioCambio = tinUsuarioCambio;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }
}
