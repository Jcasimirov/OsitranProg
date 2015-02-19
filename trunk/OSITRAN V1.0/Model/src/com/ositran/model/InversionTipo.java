package com.ositran.model;

import java.io.Serializable;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
                 
public class InversionTipo implements Serializable {
  
    private static final long serialVersionUID = -8103932004553759425L;
    private String tivDescripcion;
    private int tivEstado;
    private Date tivFechaAlta;
    private Date tivFechaBaja;
    private Date tivFechaCambio;
    private int tivId;
    private String tivNombre;
    private String tivTerminal;
    private String tivUsuarioAlta;
    private String tivUsuarioBaja;
    private String tivUsuarioCambio;

    public InversionTipo() {
    }

    public InversionTipo(String tivDescripcion, int tivEstado, Date tivFechaAlta, Date tivFechaBaja,
                         Date tivFechaCambio, int tivId, String tivNombre, String tivTerminal,
                         String tivUsuarioAlta, String tivUsuarioBaja, String tivUsuarioCambio) {
        this.tivDescripcion = tivDescripcion;
        this.tivEstado = tivEstado;
        this.tivFechaAlta = tivFechaAlta;
        this.tivFechaBaja = tivFechaBaja;
        this.tivFechaCambio = tivFechaCambio;
        this.tivId = tivId;
        this.tivNombre = tivNombre;
        this.tivTerminal = tivTerminal;
        this.tivUsuarioAlta = tivUsuarioAlta;
        this.tivUsuarioBaja = tivUsuarioBaja;
        this.tivUsuarioCambio = tivUsuarioCambio;
    }

    public String getTivDescripcion() {
        return tivDescripcion;
    }

    public void setTivDescripcion(String tivDescripcion) {
        this.tivDescripcion = tivDescripcion;
    }

    public int getTivEstado() {
        return tivEstado;
    }

    public void setTivEstado(int tivEstado) {
        this.tivEstado = tivEstado;
    }

    public Date getTivFechaAlta() throws ParseException{
        Date fecha1= new Date();
        if (tivFechaAlta==null){
            return fecha1=tivFechaAlta;
            }
      
        return fecha1;
    }

    public void setTivFechaAlta(Date tivFechaAlta) {
        this.tivFechaAlta = tivFechaAlta;
    }

    public Date getTivFechaBaja() throws ParseException {
        Date fecha1= new Date();
        if (tivFechaBaja==null){
            return fecha1=tivFechaBaja;
            }
        else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println(tivFechaBaja);
                String fecha = dateFormat.format(tivFechaBaja);
                
                System.out.println(fecha);
                fecha1= dateFormat.parse(fecha);
            
            }
        return fecha1;
        
    }

    public void setTivFechaBaja(Date tivFechaBaja) {
        this.tivFechaBaja = tivFechaBaja;
    }

    public Date getTivFechaCambio() {
        return tivFechaCambio;
    }

    public void setTivFechaCambio(Date tivFechaCambio) {
        this.tivFechaCambio = tivFechaCambio;
    }

    public int getTivId() {
        return tivId;
    }

    public String getTivNombre() {
        return tivNombre;
    }

    public void setTivNombre(String tivNombre) {
        this.tivNombre = tivNombre;
    }

    public String getTivTerminal() {
        return tivTerminal;
    }

    public void setTivTerminal(String tivTerminal) {
        this.tivTerminal = tivTerminal;
    }

    public String getTivUsuarioAlta() {
        return tivUsuarioAlta;
    }

    public void setTivUsuarioAlta(String tivUsuarioAlta) {
        this.tivUsuarioAlta = tivUsuarioAlta;
    }

    public String getTivUsuarioBaja() {
        return tivUsuarioBaja;
    }

    public void setTivUsuarioBaja(String tivUsuarioBaja) {
        this.tivUsuarioBaja = tivUsuarioBaja;
    }

    public String getTivUsuarioCambio() {
        return tivUsuarioCambio;
    }

    public void setTivUsuarioCambio(String tivUsuarioCambio) {
        this.tivUsuarioCambio = tivUsuarioCambio;
    }
    public void setTivId(int tivId) {
        this.tivId = tivId;
    }
}
