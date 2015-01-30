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
@NamedQueries({ @NamedQuery(name = "ContratoAdenda.findAll", query = "select o from ContratoAdenda o") })
@Table(name = "T_CONTRATO_ADENDA")
public class ContratoAdenda implements Serializable {
    private static final long serialVersionUID = -6311343627610219850L;
    @Column(name = "CAD_DOCUMENTO_FISICO")
    private String cadDocumentoFisico;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAD_FECHA")
    private Date cadFecha;
    @Column(name = "CAD_ID", nullable = false)
    private BigDecimal cadId;
    @ManyToOne
    @JoinColumns({
                 @JoinColumn(name = "CON_ID", referencedColumnName = "CON_ID"),
                 @JoinColumn(name = "TIN_ID", referencedColumnName = "TIN_ID")
        })
    private Contrato TContrato5;

    public ContratoAdenda() {
    }

    public ContratoAdenda(String cadDocumentoFisico, Date cadFecha, BigDecimal cadId, Contrato TContrato5) {
        this.cadDocumentoFisico = cadDocumentoFisico;
        this.cadFecha = cadFecha;
        this.cadId = cadId;
        this.TContrato5 = TContrato5;
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


    public Contrato getTContrato5() {
        return TContrato5;
    }

    public void setTContrato5(Contrato TContrato5) {
        this.TContrato5 = TContrato5;
    }
}
