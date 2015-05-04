package com.ositran.vo.bean;


public class PeriodoVO {
    public PeriodoVO() {
        super();
    }
    

    private Integer perCantidadendias;
    private String perDescripcion;
    private Integer perId;
    private String perNombre;


    public Integer getPerCantidadendias() {
        return perCantidadendias;
    }

    public void setPerCantidadendias(Integer perCantidadendias) {
        this.perCantidadendias = perCantidadendias;
    }

    public String getPerDescripcion() {
        return perDescripcion;
    }

    public void setPerDescripcion(String perDescripcion) {
        this.perDescripcion = perDescripcion;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }
}
