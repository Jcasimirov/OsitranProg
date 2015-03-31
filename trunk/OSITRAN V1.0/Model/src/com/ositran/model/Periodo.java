package com.ositran.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({ @NamedQuery(name = "Periodo.findAll", query = "select o from Periodo o") })
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_PERIODO"))
@Table(name = "T_PERIODO")

public class Periodo implements Serializable {
    private static final long serialVersionUID = -6631118244370905156L;
    @Column(name = "PER_CANTIDADEND�AS", nullable = false)
    private Integer perCantidadend�as;
    @Column(name = "PER_DESCRIPCION", nullable = false, length = 100)
    private String perDescripcion;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "PER_ID", nullable = false)
    private Integer perId;
    @Column(name = "PER_NOMBRE", nullable = false, length = 100)
    private String perNombre;

    public Periodo() {
    }

    public Periodo(Integer perCantidadend�as, String perDescripcion, Integer perId, String perNombre) {
        this.perCantidadend�as = perCantidadend�as;
        this.perDescripcion = perDescripcion;
        this.perId = perId;
        this.perNombre = perNombre;
    }

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
