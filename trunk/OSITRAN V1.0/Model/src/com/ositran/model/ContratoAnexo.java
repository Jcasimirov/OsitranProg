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
@NamedQueries({ @NamedQuery(name = "TContratoAnexo.findAll", query = "select o from TContratoAnexo o") })
@Table(name = "T_CONTRATO_ANEXO")

public class ContratoAnexo implements Serializable {
    private static final long serialVersionUID = -3356747595198249329L;
    @Column(name = "CAX_DOCUMENTO_FISICO")
    private String caxDocumentoFisico;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAX_FECHA")
    private Date caxFecha;
    @Id
    @Column(name = "CAX_ID", nullable = false)
    private BigDecimal caxId;
    @Id
    @Column(name = "CON_ID", nullable = false)
    private BigDecimal conId;
    @Id
    @Column(name = "TIN_ID", nullable = false)
    private BigDecimal tinId;

    public ContratoAnexo() {
    }

    public ContratoAnexo(String caxDocumentoFisico, Date caxFecha, BigDecimal caxId, BigDecimal conId,
                          BigDecimal tinId) {
        this.caxDocumentoFisico = caxDocumentoFisico;
        this.caxFecha = caxFecha;
        this.caxId = caxId;
        this.conId = conId;
        this.tinId = tinId;
    }

    public String getCaxDocumentoFisico() {
        return caxDocumentoFisico;
    }

    public void setCaxDocumentoFisico(String caxDocumentoFisico) {
        this.caxDocumentoFisico = caxDocumentoFisico;
    }

    public Date getCaxFecha() {
        return caxFecha;
    }

    public void setCaxFecha(Date caxFecha) {
        this.caxFecha = caxFecha;
    }

    public BigDecimal getCaxId() {
        return caxId;
    }

    public void setCaxId(BigDecimal caxId) {
        this.caxId = caxId;
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
