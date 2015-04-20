package com.ositran.vo.bean;

import java.math.BigDecimal;

public class ValorizacionConceptoVO {

    private String cvaDescripcion;
    private BigDecimal cvaEstado;
    private BigDecimal cvaId;
    private String cvaNombre;


    public void setCvaDescripcion(String cvaDescripcion) {
        this.cvaDescripcion = cvaDescripcion;
    }

    public String getCvaDescripcion() {
        return cvaDescripcion;
    }

    public void setCvaEstado(BigDecimal cvaEstado) {
        this.cvaEstado = cvaEstado;
    }

    public BigDecimal getCvaEstado() {
        return cvaEstado;
    }

    public void setCvaId(BigDecimal cvaId) {
        this.cvaId = cvaId;
    }

    public BigDecimal getCvaId() {
        return cvaId;
    }

    public void setCvaNombre(String cvaNombre) {
        this.cvaNombre = cvaNombre;
    }

    public String getCvaNombre() {
        return cvaNombre;
    }
}
