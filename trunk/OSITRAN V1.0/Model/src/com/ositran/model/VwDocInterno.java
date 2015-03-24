package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VW_DOC_INTERNO")
public class VwDocInterno implements Serializable {
    private static final long serialVersionUID = -7917652155016613779L;
    @Column(name = "VDI_ANYO", nullable = false)
    private Integer vdiAnyo;
    @Column(name = "VDI_AREA", length = 100)
    private String vdiArea;
    @Column(name = "VDI_ASUNTO", length = 100)
    private String vdiAsunto;
    @Column(name = "VDI_DESTINO", length = 100)
    private String vdiDestino;
    @Temporal(TemporalType.DATE)
    @Column(name = "VDI_FECHA")
    private Date vdiFecha;
    @Temporal(TemporalType.DATE)
    @Column(name = "VDI_FECHA_REGISTRO")
    private Date vdiFechaRegistro;
    @Id
    @Column(name = "VDI_HR", nullable = false)
    private Integer vdiHr;
    @Column(name = "VDI_NOMBRE", length = 100)
    private String vdiNombre;
    @Column(name = "VDI_NROREGISTROSALIDA", length = 100)
    private String vdiNroregistrosalida;
    @Column(name = "VDI_NUMERO", length = 100)
    private String vdiNumero;
    @Column(name = "VDI_QUIENREMITE", length = 100)
    private String vdiQuienremite;
    @Column(name = "VDI_TIPO", nullable = false)
    private Integer vdiTipo;

    public VwDocInterno() {
    }

    public VwDocInterno(Integer vdiAnyo, String vdiArea, String vdiAsunto, String vdiDestino, Date vdiFecha,
                        Date vdiFechaRegistro, Integer vdiHr, String vdiNombre, String vdiNroregistrosalida,
                        String vdiNumero, String vdiQuienremite, Integer vdiTipo) {
        this.vdiAnyo = vdiAnyo;
        this.vdiArea = vdiArea;
        this.vdiAsunto = vdiAsunto;
        this.vdiDestino = vdiDestino;
        this.vdiFecha = vdiFecha;
        this.vdiFechaRegistro = vdiFechaRegistro;
        this.vdiHr = vdiHr;
        this.vdiNombre = vdiNombre;
        this.vdiNroregistrosalida = vdiNroregistrosalida;
        this.vdiNumero = vdiNumero;
        this.vdiQuienremite = vdiQuienremite;
        this.vdiTipo = vdiTipo;
    }


    public void setVdiAnyo(Integer vdiAnyo) {
        this.vdiAnyo = vdiAnyo;
    }

    public Integer getVdiAnyo() {
        return vdiAnyo;
    }

    public void setVdiArea(String vdiArea) {
        this.vdiArea = vdiArea;
    }

    public String getVdiArea() {
        return vdiArea;
    }

    public void setVdiAsunto(String vdiAsunto) {
        this.vdiAsunto = vdiAsunto;
    }

    public String getVdiAsunto() {
        return vdiAsunto;
    }

    public void setVdiDestino(String vdiDestino) {
        this.vdiDestino = vdiDestino;
    }

    public String getVdiDestino() {
        return vdiDestino;
    }

    public void setVdiFecha(Date vdiFecha) {
        this.vdiFecha = vdiFecha;
    }

    public Date getVdiFecha() {
        return vdiFecha;
    }

    public void setVdiFechaRegistro(Date vdiFechaRegistro) {
        this.vdiFechaRegistro = vdiFechaRegistro;
    }

    public Date getVdiFechaRegistro() {
        return vdiFechaRegistro;
    }

    public void setVdiHr(Integer vdiHr) {
        this.vdiHr = vdiHr;
    }

    public Integer getVdiHr() {
        return vdiHr;
    }

    public void setVdiNombre(String vdiNombre) {
        this.vdiNombre = vdiNombre;
    }

    public String getVdiNombre() {
        return vdiNombre;
    }

    public void setVdiNroregistrosalida(String vdiNroregistrosalida) {
        this.vdiNroregistrosalida = vdiNroregistrosalida;
    }

    public String getVdiNroregistrosalida() {
        return vdiNroregistrosalida;
    }

    public void setVdiNumero(String vdiNumero) {
        this.vdiNumero = vdiNumero;
    }

    public String getVdiNumero() {
        return vdiNumero;
    }

    public void setVdiQuienremite(String vdiQuienremite) {
        this.vdiQuienremite = vdiQuienremite;
    }

    public String getVdiQuienremite() {
        return vdiQuienremite;
    }

    public void setVdiTipo(Integer vdiTipo) {
        this.vdiTipo = vdiTipo;
    }

    public Integer getVdiTipo() {
        return vdiTipo;
    }
}
