package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "ContratoAnexo.findAll", query = "select o from ContratoAnexo o") })
@Table(name = "T_CONTRATO_ANEXO")
public class ContratoAnexo implements Serializable {
    private static final long serialVersionUID = 4386338815053095849L;
    @Column(name = "CAX_DOCUMENTO_FISICO")
    private String caxDocumentoFisico;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAX_FECHA")
    private Date caxFecha;
    @Column(name = "CAX_ID", nullable = false)
    private BigDecimal caxId;
    @ManyToOne
    @JoinColumns({
                 @JoinColumn(name = "CON_ID", referencedColumnName = "CON_ID"),
                 @JoinColumn(name = "TIN_ID", referencedColumnName = "TIN_ID")
        })
    private Contrato TContrato1;

    public ContratoAnexo() {
    }

    public ContratoAnexo(String caxDocumentoFisico, Date caxFecha, BigDecimal caxId, Contrato TContrato1) {
        this.caxDocumentoFisico = caxDocumentoFisico;
        this.caxFecha = caxFecha;
        this.caxId = caxId;
        this.TContrato1 = TContrato1;
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


    public Contrato getTContrato1() {
        return TContrato1;
    }

    public void setTContrato1(Contrato TContrato1) {
        this.TContrato1 = TContrato1;
    }
}
