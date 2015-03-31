package com.ositran.vo.bean;
public class PeriodoVO {
    public PeriodoVO() {
        super();
    }
    

    private Integer perCantidadendías;
    private String perDescripcion;
    private Integer perId;
    private String perNombre;


    public Integer getPerCantidadendías() {
        return perCantidadendías;
    }

    public void setPerCantidadendías(Integer perCantidadendías) {
        this.perCantidadendías = perCantidadendías;
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
