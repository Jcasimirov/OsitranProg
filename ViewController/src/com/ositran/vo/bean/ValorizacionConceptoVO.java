package com.ositran.vo.bean;


public class ValorizacionConceptoVO {

    private String cvaDescripcion;
    private Integer cvaEstado;
    private Integer cvaId;
    private String cvaNombre;


    public void setCvaDescripcion(String cvaDescripcion) {
        this.cvaDescripcion = cvaDescripcion;
    }

    public String getCvaDescripcion() {
        return cvaDescripcion;
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

    public void setCvaNombre(String cvaNombre) {
        this.cvaNombre = cvaNombre;
    }

    public String getCvaNombre() {
        return cvaNombre;
    }
}
