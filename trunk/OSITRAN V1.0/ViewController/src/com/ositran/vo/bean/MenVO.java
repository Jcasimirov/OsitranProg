package com.ositran.vo.bean;

import java.util.Date;

public class MenVO {
  
    private String descripcion;
    private int menEstado;
    private Date menFechaAlta;
    private Date menFechaBaja;
    private Date menFechaCambio;
    private String menFormulario;
    private int menId;
    private String menNombre;
    private int menPadre;
    private String menTerminal;
    private String menUsuarioAlta;
    private String menUsuarioBaja;
    private String menUsuarioCambio;
    private String menUrl;
    private int contador;
    private String nombreFormulario;
    //*************************************************
    private boolean crear;
    private boolean eliminar;
    private boolean actualizar;
    private boolean lectura;
    private int  codigoRolOpciones;
    private boolean todo=false;
    
    //**********************************************

    public MenVO() {
    }

    public MenVO(String descripcion, int menEstado, Date menFechaAlta, Date menFechaBaja, Date menFechaCambio,
               String menFormulario, int menId, String menNombre, int menPadre, String menTerminal,
               String menUsuarioAlta, String menUsuarioBaja, String menUsuarioCambio) {
        this.descripcion = descripcion;
        this.menEstado = menEstado;
        this.menFechaAlta = menFechaAlta;
        this.menFechaBaja = menFechaBaja;
        this.menFechaCambio = menFechaCambio;
        this.menFormulario = menFormulario;
        this.menId = menId;
        this.menNombre = menNombre;
        this.menPadre = menPadre;
        this.menTerminal = menTerminal;
        this.menUsuarioAlta = menUsuarioAlta;
        this.menUsuarioBaja = menUsuarioBaja;
        this.menUsuarioCambio = menUsuarioCambio;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setMenEstado(int menEstado) {
        this.menEstado = menEstado;
    }

    public int getMenEstado() {
        return menEstado;
    }

    public void setMenFechaAlta(Date menFechaAlta) {
        this.menFechaAlta = menFechaAlta;
    }

    public Date getMenFechaAlta() {
        return menFechaAlta;
    }

    public void setMenFechaBaja(Date menFechaBaja) {
        this.menFechaBaja = menFechaBaja;
    }

    public Date getMenFechaBaja() {
        return menFechaBaja;
    }

    public void setMenFechaCambio(Date menFechaCambio) {
        this.menFechaCambio = menFechaCambio;
    }

    public Date getMenFechaCambio() {
        return menFechaCambio;
    }

    public void setMenFormulario(String menFormulario) {
        this.menFormulario = menFormulario;
    }

    public String getMenFormulario() {
        return menFormulario;
    }

    public void setMenId(int menId) {
        this.menId = menId;
    }

    public int getMenId() {
        return menId;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenPadre(int menPadre) {
        this.menPadre = menPadre;
    }

    public int getMenPadre() {
        return menPadre;
    }

    public void setMenTerminal(String menTerminal) {
        this.menTerminal = menTerminal;
    }

    public String getMenTerminal() {
        return menTerminal;
    }

    public void setMenUsuarioAlta(String menUsuarioAlta) {
        this.menUsuarioAlta = menUsuarioAlta;
    }

    public String getMenUsuarioAlta() {
        return menUsuarioAlta;
    }

    public void setMenUsuarioBaja(String menUsuarioBaja) {
        this.menUsuarioBaja = menUsuarioBaja;
    }

    public String getMenUsuarioBaja() {
        return menUsuarioBaja;
    }

    public void setMenUsuarioCambio(String menUsuarioCambio) {
        this.menUsuarioCambio = menUsuarioCambio;
    }

    public String getMenUsuarioCambio() {
        return menUsuarioCambio;
    }
    //*******************************Opciones


    public void setCrear(boolean crear) {
        this.crear = crear;
    }

    public boolean isCrear() {
        return crear;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }

    public boolean isActualizar() {
        return actualizar;
    }

    public void setLectura(boolean lectura) {
        this.lectura = lectura;
    }

    public boolean isLectura() {
        return lectura;
    }


    public void setCodigoRolOpciones(int codigoRolOpciones) {
        this.codigoRolOpciones = codigoRolOpciones;
    }

    public int getCodigoRolOpciones() {
        return codigoRolOpciones;
    }

    public void setTodo(boolean todo) {
        this.todo = todo;
    }

    public boolean isTodo() {
        return todo;
    }


    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }


    public void setMenUrl(String menUrl) {
        this.menUrl = menUrl;
    }

    public String getMenUrl() {
        return menUrl;
    }


    public void setNombreFormulario(String nombreFormulario) {
        this.nombreFormulario = nombreFormulario;
    }

    public String getNombreFormulario() {
        return nombreFormulario;
    }

}
