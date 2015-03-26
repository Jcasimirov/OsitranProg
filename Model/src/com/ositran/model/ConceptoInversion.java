package com.ositran.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * To create ID generator sequence "SQ_T_CONCEPTO_INVERSION":
 * CREATE SEQUENCE "SQ_T_CONCEPTO_INVERSION" INCREMENT BY 50 START WITH 50;
 */

@Entity
@NamedQueries({ @NamedQuery(name = "ConceptoInversion.findAll", query = "select o from ConceptoInversion o") })
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONCEPTO_INVERSION"))

@Table(name = "T_CONCEPTO_INVERSION")

public class ConceptoInversion implements Serializable {
    private static final long serialVersionUID = -5887686883945486858L;
    @Column(name = "CNV_DESCRIPCION", nullable = false, length = 100)
    private String cnvDescripcion;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CNV_ID", nullable = false)
    private Integer cnvId;
    @Column(name = "CNV_NOMBRE", nullable = false, length = 50)
    private String cnvNombre;

    public ConceptoInversion() {
    }

    public ConceptoInversion(String cnvDescripcion, Integer cnvId, String cnvNombre) {
        this.cnvDescripcion = cnvDescripcion;
        this.cnvId = cnvId;
        this.cnvNombre = cnvNombre;
    }

    public String getCnvDescripcion() {
        return cnvDescripcion;
    }

    public void setCnvDescripcion(String cnvDescripcion) {
        this.cnvDescripcion = cnvDescripcion;
    }

    public Integer getCnvId() {
        return cnvId;
    }

    public String getCnvNombre() {
        return cnvNombre;
    }

    public void setCnvNombre(String cnvNombre) {
        this.cnvNombre = cnvNombre;
    }

    public void setCnvId(Integer cnvId) {
        this.cnvId = cnvId;
    }
}
