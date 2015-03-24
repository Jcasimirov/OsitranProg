package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "TipoDocumento")
@NamedQueries({ @NamedQuery(name = "TipoDocumento.findAll", query = "select o from TipoDocumento o") })
@Table(name = "T_TIPO_DOCUMENTO")
@SequenceGenerator(name = "TIPO_DOCUMENTO_ID_SEQ_GEN", sequenceName = "TIPO_DOCUMENTO_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 7364990923850172691L;
    @Column(name = "TDO_DESCRIPCION", nullable = false, length = 100)
    private String tdoDescripcion;
    @Id
    @Column(name = "TDO_ID", nullable = false)
    private Integer tdoId;
    @Column(name = "TDO_NOMBRE", nullable = false, length = 100)
    private String tdoNombre;
  

    public TipoDocumento() {
    }

    public TipoDocumento(String tdoDescripcion, Integer tdoId, String tdoNombre) {
        this.tdoDescripcion = tdoDescripcion;
        this.tdoId = tdoId;
        this.tdoNombre = tdoNombre;
    }

    public void setTdoDescripcion(String tdoDescripcion) {
        this.tdoDescripcion = tdoDescripcion;
    }

    public String getTdoDescripcion() {
        return tdoDescripcion;
    }

    public void setTdoId(Integer tdoId) {
        this.tdoId = tdoId;
    }

    public Integer getTdoId() {
        return tdoId;
    }

    public void setTdoNombre(String tdoNombre) {
        this.tdoNombre = tdoNombre;
    }

    public String getTdoNombre() {
        return tdoNombre;
    }
}
