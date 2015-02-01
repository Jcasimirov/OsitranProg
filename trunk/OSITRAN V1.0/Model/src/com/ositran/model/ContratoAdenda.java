package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "TContratoAdenda.findAll", query = "select o from TContratoAdenda o") })
@Table(name = "T_CONTRATO_ADENDA")
@IdClass(TContratoAdendaPK.class)
public class ContratoAdenda implements Serializable {
    private static final long serialVersionUID = 7186127727239284151L;
    @Column(name = "CAD_DOCUMENTO_FISICO")
    private String cadDocumentoFisico;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAD_FECHA")
    private Date cadFecha;
    @Id
    @Column(name = "CAD_ID", nullable = false)
    private BigDecimal cadId;
    @Id
    @Column(name = "CON_ID", nullable = false)
    private BigDecimal conId;
    @Id
    @Column(name = "TIN_ID", nullable = false)
    private BigDecimal tinId;

    public ContratoAdenda() {
    }

    public ContratoAdenda(String cadDocumentoFisico, Date cadFecha, BigDecimal cadId, BigDecimal conId,
                           BigDecimal tinId) {
        this.cadDocumentoFisico = cadDocumentoFisico;
        this.cadFecha = cadFecha;
        this.cadId = cadId;
        this.conId = conId;
        this.tinId = tinId;
    }

    public String getCadDocumentoFisico() {
        return cadDocumentoFisico;
    }

    public void setCadDocumentoFisico(String cadDocumentoFisico) {
        this.cadDocumentoFisico = cadDocumentoFisico;
    }

    public Date getCadFecha() {
        return cadFecha;
    }

    public void setCadFecha(Date cadFecha) {
        this.cadFecha = cadFecha;
    }

    public BigDecimal getCadId() {
        return cadId;
    }

    public void setCadId(BigDecimal cadId) {
        this.cadId = cadId;
    }

    public BigDecimal getConId() {
        return conId;
    }

    public void setConId(BigDecimal conId) {
        this.conId = conId;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }
}
