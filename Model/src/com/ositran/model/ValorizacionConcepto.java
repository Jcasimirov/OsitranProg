package com.ositran.model;

import java.io.Serializable;

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
    @Column(name = "CVA_DESCRIPCION",  length = 100)
    private String cvaDescripcion;
    @Column(name = "CVA_ESTADO")
    private Integer cvaEstado;
    @Id
    @Column(name = "CVA_ID", nullable = false)
    private Integer cvaId;
    @Column(name = "CVA_NOMBRE", length = 100)
    private String cvaNombre;

    public ValorizacionConcepto() {
    }

    public ValorizacionConcepto(String cvaDescripcion, Integer cvaEstado, Integer cvaId, String cvaNombre) {
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


    public void setCvaEstado(Integer cvaEstado) {
        this.cvaEstado = cvaEstado;
    }

    public Integer getCvaEstado() {
        return cvaEstado;
    }

    public void setCvaId(Integer cvaId) {
        this.cvaId = cvaId;
    }

    public Integer getCvaId() {
        return cvaId;
    }

    public String getCvaNombre() {
        return cvaNombre;
    }

    public void setCvaNombre(String cvaNombre) {
        this.cvaNombre = cvaNombre;
    }
}
