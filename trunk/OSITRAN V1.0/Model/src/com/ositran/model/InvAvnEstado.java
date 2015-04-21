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
@NamedQueries({ @NamedQuery(name = "InvAvnEstado.findAll", query = "select o from InvAvnEstado o") })
@Table(name = "T_INV_AVN_ESTADO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_INV_AVN_ESTADO"))
public class InvAvnEstado implements Serializable {
    private static final long serialVersionUID = 3779841224915524951L;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IAE_ID", nullable = false)
    private Integer iaeId;
    @Column(name = "IAE_NOMBRE", nullable = false, length = 50)
    private String iaeNombre;

    public InvAvnEstado() {
    }

    public InvAvnEstado(Integer iaeId, String iaeNombre) {
        this.iaeId = iaeId;
        this.iaeNombre = iaeNombre;
    }

    public Integer getIaeId() {
        return iaeId;
    }

    public void setIaeId(Integer iaeId) {
        this.iaeId = iaeId;
    }

    public String getIaeNombre() {
        return iaeNombre;
    }

    public void setIaeNombre(String iaeNombre) {
        this.iaeNombre = iaeNombre;
    }
}
