package com.ositran.vo.bean;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class ViewTdInternosVO {
    
    private Integer anyo;
    private Integer anyoHtRefe;
    private String asunto;
    private String cargo;
    private String codDestinatario;
    private String codRemitente;
    private String codTipEmpresa;
    private String cod_Tip_Doc;
    private String empresa;
    private Date fecDoc;
    private Date fechaRegistro;
    private String htReferencia;
    private String nomDestinatario;
    private String nroRegistro;
    private String numDoc;
    private String remitente;
    private String tipDoc;
    private String tipoDestino;
    private String tipoEmpresa;


    public void setAnyo(Integer anyo) {
        this.anyo = anyo;
    }

    public Integer getAnyo() {
        return anyo;
    }

    public void setAnyoHtRefe(Integer anyoHtRefe) {
        this.anyoHtRefe = anyoHtRefe;
    }

    public Integer getAnyoHtRefe() {
        return anyoHtRefe;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCodDestinatario(String codDestinatario) {
        this.codDestinatario = codDestinatario;
    }

    public String getCodDestinatario() {
        return codDestinatario;
    }

    public void setCodRemitente(String codRemitente) {
        this.codRemitente = codRemitente;
    }

    public String getCodRemitente() {
        return codRemitente;
    }

    public void setCodTipEmpresa(String codTipEmpresa) {
        this.codTipEmpresa = codTipEmpresa;
    }

    public String getCodTipEmpresa() {
        return codTipEmpresa;
    }

    public void setCod_Tip_Doc(String cod_Tip_Doc) {
        this.cod_Tip_Doc = cod_Tip_Doc;
    }

    public String getCod_Tip_Doc() {
        return cod_Tip_Doc;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setFecDoc(Date fecDoc) {
        this.fecDoc = fecDoc;
    }

    public Date getFecDoc() {
        return fecDoc;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setHtReferencia(String htReferencia) {
        this.htReferencia = htReferencia;
    }

    public String getHtReferencia() {
        return htReferencia;
    }

    public void setNomDestinatario(String nomDestinatario) {
        this.nomDestinatario = nomDestinatario;
    }

    public String getNomDestinatario() {
        return nomDestinatario;
    }

    public void setNroRegistro(String nroRegistro) {
        this.nroRegistro = nroRegistro;
    }

    public String getNroRegistro() {
        return nroRegistro;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipoDestino(String tipoDestino) {
        this.tipoDestino = tipoDestino;
    }

    public String getTipoDestino() {
        return tipoDestino;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }
}
