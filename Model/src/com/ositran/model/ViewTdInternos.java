package com.ositran.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VIEW_TD_INTERNOS")
public class ViewTdInternos implements Serializable {
    private static final long serialVersionUID = -4850312500448899395L;
    @Column(nullable = false)
    private Integer anyo;
    @Column(name = "ANYO_HT_REFE", nullable = false)
    private Integer anyoHtRefe;
    @Column(length = 20)
    private String asunto;
    @Column(length = 50)
    private String cargo;
    @Column(name = "COD_DESTINATARIO", length = 3)
    private String codDestinatario;
    @Column(name = "COD_REMITENTE", length = 3)
    private String codRemitente;
    @Column(name = "COD_TIP_EMPRESA", length = 3)
    private String codTipEmpresa;
    @Column(name = "COD__TIP__DOC", length = 3)
    private String cod_Tip_Doc;
    @Column(length = 100)
    private String empresa;
    @Temporal(TemporalType.DATE)
    @Column(name = "FEC_DOC")
    private Date fecDoc;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;
    @Column(name = "HT_REFERENCIA", length = 50)
    private String htReferencia;
    @Column(name = "NOM_DESTINATARIO", length = 100)
    private String nomDestinatario;
    @Id
    @Column(name = "NRO_REGISTRO", nullable = false, length = 6)
    private String nroRegistro;
    @Column(name = "NUM_DOC", length = 50)
    private String numDoc;
    @Column(length = 100)
    private String remitente;
    @Column(name = "TIP_DOC", length = 20)
    private String tipDoc;
    @Column(name = "TIPO_DESTINO", length = 1)
    private String tipoDestino;
    @Column(name = "TIPO_EMPRESA", length = 50)
    private String tipoEmpresa;

    public ViewTdInternos() {
    }

    public ViewTdInternos(Integer anyo, Integer anyoHtRefe, String asunto, String cargo, String codDestinatario,
                          String codRemitente, String codTipEmpresa, String cod_Tip_Doc, String empresa, Date fecDoc,
                          Date fechaRegistro, String htReferencia, String nomDestinatario, String nroRegistro,
                          String numDoc, String remitente, String tipDoc, String tipoDestino, String tipoEmpresa) {
        this.anyo = anyo;
        this.anyoHtRefe = anyoHtRefe;
        this.asunto = asunto;
        this.cargo = cargo;
        this.codDestinatario = codDestinatario;
        this.codRemitente = codRemitente;
        this.codTipEmpresa = codTipEmpresa;
        this.cod_Tip_Doc = cod_Tip_Doc;
        this.empresa = empresa;
        this.fecDoc = fecDoc;
        this.fechaRegistro = fechaRegistro;
        this.htReferencia = htReferencia;
        this.nomDestinatario = nomDestinatario;
        this.nroRegistro = nroRegistro;
        this.numDoc = numDoc;
        this.remitente = remitente;
        this.tipDoc = tipDoc;
        this.tipoDestino = tipoDestino;
        this.tipoEmpresa = tipoEmpresa;
    }

    public Integer getAnyo() {
        return anyo;
    }

    public void setAnyo(Integer anyo) {
        this.anyo = anyo;
    }

    public Integer getAnyoHtRefe() {
        return anyoHtRefe;
    }

    public void setAnyoHtRefe(Integer anyoHtRefe) {
        this.anyoHtRefe = anyoHtRefe;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCodDestinatario() {
        return codDestinatario;
    }

    public void setCodDestinatario(String codDestinatario) {
        this.codDestinatario = codDestinatario;
    }

    public String getCodRemitente() {
        return codRemitente;
    }

    public void setCodRemitente(String codRemitente) {
        this.codRemitente = codRemitente;
    }

    public String getCodTipEmpresa() {
        return codTipEmpresa;
    }

    public void setCodTipEmpresa(String codTipEmpresa) {
        this.codTipEmpresa = codTipEmpresa;
    }

    public String getCod_Tip_Doc() {
        return cod_Tip_Doc;
    }

    public void setCod_Tip_Doc(String cod_Tip_Doc) {
        this.cod_Tip_Doc = cod_Tip_Doc;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Date getFecDoc() {
        return fecDoc;
    }

    public void setFecDoc(Date fecDoc) {
        this.fecDoc = fecDoc;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getHtReferencia() {
        return htReferencia;
    }

    public void setHtReferencia(String htReferencia) {
        this.htReferencia = htReferencia;
    }

    public String getNomDestinatario() {
        return nomDestinatario;
    }

    public void setNomDestinatario(String nomDestinatario) {
        this.nomDestinatario = nomDestinatario;
    }

    public String getNroRegistro() {
        return nroRegistro;
    }

    public void setNroRegistro(String nroRegistro) {
        this.nroRegistro = nroRegistro;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getTipoDestino() {
        return tipoDestino;
    }

    public void setTipoDestino(String tipoDestino) {
        this.tipoDestino = tipoDestino;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }
}
