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
@NamedQueries({ @NamedQuery(name = "TipoDocumento.findAll", query = "select o from TipoDocumento o") })
@Table(name = "T_TIPO_DOCUMENTO")
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = -2739651295995188898L;
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

    public String getTdoDescripcion() {
        return tdoDescripcion;
    }

    public void setTdoDescripcion(String tdoDescripcion) {
        this.tdoDescripcion = tdoDescripcion;
    }

    public void setTdoId(Integer tdoId) {
        this.tdoId = tdoId;
    }

    public Integer getTdoId() {
        return tdoId;
    }

    public String getTdoNombre() {
        return tdoNombre;
    }

    public void setTdoNombre(String tdoNombre) {
        this.tdoNombre = tdoNombre;
    }
}
