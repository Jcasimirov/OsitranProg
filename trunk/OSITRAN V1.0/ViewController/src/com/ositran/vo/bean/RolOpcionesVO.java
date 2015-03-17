package com.ositran.vo.bean;

import java.util.Date;

public class RolOpcionesVO {
    private int menId;
    private int rolId;
    private int troAgregar;
    private int troConsultar;
    private int troEliminar;
    private int troEstado;
    private Date troFechaAlta;
    private Date troFechaBaja;
    private Date troFechaCambio;
    private int troModificar;
    private String troTerminal;
    private String troUsuarioAlta;
    private String troUsuarioBaja;
    private String troUsuarioCambio;
    private String descripcion;

    public RolOpcionesVO() {
    }

    public RolOpcionesVO(int menId, int rolId, int rxoId, int troAgregar,
                       int troConsultar, int troEliminar, int troEstado, Date troFechaAlta,
                       Date troFechaBaja, Date troFechaCambio, int troModificar, String troTerminal,
                       String troUsuarioAlta, String troUsuarioBaja, String troUsuarioCambio) {
        this.menId = menId;
        this.rolId = rolId;
       
        this.troAgregar = troAgregar;
        this.troConsultar = troConsultar;
        this.troEliminar = troEliminar;
        this.troEstado = troEstado;
        this.troFechaAlta = troFechaAlta;
        this.troFechaBaja = troFechaBaja;
        this.troFechaCambio = troFechaCambio;
        this.troModificar = troModificar;
        this.troTerminal = troTerminal;
        this.troUsuarioAlta = troUsuarioAlta;
        this.troUsuarioBaja = troUsuarioBaja;
        this.troUsuarioCambio = troUsuarioCambio;
    }

    public int getMenId() {
        return menId;
    }

    public void setMenId(int menId) {
        this.menId = menId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }



    public int getTroAgregar() {
        return troAgregar;
    }

    public void setTroAgregar(int troAgregar) {
        this.troAgregar = troAgregar;
    }

    public int getTroConsultar() {
        return troConsultar;
    }

    public void setTroConsultar(int troConsultar) {
        this.troConsultar = troConsultar;
    }

    public int getTroEliminar() {
        return troEliminar;
    }

    public void setTroEliminar(int troEliminar) {
        this.troEliminar = troEliminar;
    }

    public int getTroEstado() {
        return troEstado;
    }

    public void setTroEstado(int troEstado) {
        this.troEstado = troEstado;
    }

    public Date getTroFechaAlta() {
        return troFechaAlta;
    }

    public void setTroFechaAlta(Date troFechaAlta) {
        this.troFechaAlta = troFechaAlta;
    }

    public Date getTroFechaBaja() {
        return troFechaBaja;
    }

    public void setTroFechaBaja(Date troFechaBaja) {
        this.troFechaBaja = troFechaBaja;
    }

    public Date getTroFechaCambio() {
        return troFechaCambio;
    }

    public void setTroFechaCambio(Date troFechaCambio) {
        this.troFechaCambio = troFechaCambio;
    }

    public int getTroModificar() {
        return troModificar;
    }

    public void setTroModificar(int troModificar) {
        this.troModificar = troModificar;
    }

    public String getTroTerminal() {
        return troTerminal;
    }

    public void setTroTerminal(String troTerminal) {
        this.troTerminal = troTerminal;
    }

    public String getTroUsuarioAlta() {
        return troUsuarioAlta;
    }

    public void setTroUsuarioAlta(String troUsuarioAlta) {
        this.troUsuarioAlta = troUsuarioAlta;
    }

    public String getTroUsuarioBaja() {
        return troUsuarioBaja;
    }

    public void setTroUsuarioBaja(String troUsuarioBaja) {
        this.troUsuarioBaja = troUsuarioBaja;
    }

    public String getTroUsuarioCambio() {
        return troUsuarioCambio;
    }

    public void setTroUsuarioCambio(String troUsuarioCambio) {
        this.troUsuarioCambio = troUsuarioCambio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
