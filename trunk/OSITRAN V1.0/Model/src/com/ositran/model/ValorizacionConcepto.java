package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "ValorizacionConcepto.findAll", query = "select o from ValorizacionConcepto o") })
@Table(name = "T_VALORIZACION_CONCEPTO")
public class ValorizacionConcepto implements Serializable {
    private static final long serialVersionUID = 6103162993576008505L;
    @Column(name = "CVA_DESCRIPCION", nullable = false, length = 100)
    private String cvaDescripcion;
    @Column(name = "CVA_ESTADO", nullable = false)
    private BigDecimal cvaEstado;
    @Id
    @Column(name = "CVA_ID", nullable = false)
    private BigDecimal cvaId;
    @Column(name = "CVA_NOMBRE", nullable = false, length = 100)
    private String cvaNombre;

    public ValorizacionConcepto() {
    }

    public ValorizacionConcepto(String cvaDescripcion, BigDecimal cvaEstado, BigDecimal cvaId, String cvaNombre) {
        this.cvaDescripcion = cvaDescripcion;
        this.cvaEstado = cvaEstado;
        this.cvaId = cvaId;
        this.cvaNombre = cvaNombre;
    }

    public String getCvaDescripcion() {
        return cvaDescripcion;
    }

    public void setCvaDescripcion(String cvaDescripcion) {
        this.cvaDescripcion = cvaDescripcion;
    }

    public BigDecimal getCvaEstado() {
        return cvaEstado;
    }

    public void setCvaEstado(BigDecimal cvaEstado) {
        this.cvaEstado = cvaEstado;
    }

    public BigDecimal getCvaId() {
        return cvaId;
    }

    public void setCvaId(BigDecimal cvaId) {
        this.cvaId = cvaId;
    }

    public String getCvaNombre() {
        return cvaNombre;
    }

    public void setCvaNombre(String cvaNombre) {
        this.cvaNombre = cvaNombre;
    }
}
