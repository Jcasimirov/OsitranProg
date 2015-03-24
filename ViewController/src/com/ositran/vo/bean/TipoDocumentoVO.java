package com.ositran.vo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class TipoDocumentoVO {
    
    private String tdoDescripcion;    
    private Integer tdoId;    
    private String tdoNombre;    
    
    public TipoDocumentoVO() {
        super();
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
