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
@Table(name = "T_INV_TIPO_REVISION")
public class InvTipoRevision implements Serializable {
    private static final long serialVersionUID = 6843751563638949948L;
    @Column(name = "ITR_DESCRIPCION", nullable = false, length = 4000)
    private String itrDescripcion;
    @Id
    @Column(name = "ITR_ID", nullable = false)
    private Integer itrId;

    public InvTipoRevision() {
    }

    public InvTipoRevision(String itrDescripcion, Integer itrId) {
        this.itrDescripcion = itrDescripcion;
        this.itrId = itrId;
    }

    public String getItrDescripcion() {
        return itrDescripcion;
    }

    public void setItrDescripcion(String itrDescripcion) {
        this.itrDescripcion = itrDescripcion;
    }


    public void setItrId(Integer itrId) {
        this.itrId = itrId;
    }

    public Integer getItrId() {
        return itrId;
    }
}
