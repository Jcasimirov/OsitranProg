package com.ositran.vo.bean;
public class PeriodoVO {
    public PeriodoVO() {
        super();
    }
    

    private Integer perCantidadend�as;
    private String perDescripcion;
    private Integer perId;
    private String perNombre;


    public Integer getPerCantidadend�as() {
        return perCantidadend�as;
    }

    public void setPerCantidadend�as(Integer perCantidadend�as) {
        this.perCantidadend�as = perCantidadend�as;
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
