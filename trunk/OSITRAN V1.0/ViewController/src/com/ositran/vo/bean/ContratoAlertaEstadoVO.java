package com.ositran.vo.bean;

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

public class ContratoAlertaEstadoVO {    
    private Integer caeId;
    private String caeNombre;

    public ContratoAlertaEstadoVO() {
        super();
    }


    public Integer getCaeId() {
        return caeId;
    }

    public void setCaeId(Integer caeId) {
        this.caeId = caeId;
    }

    public String getCaeNombre() {
        return caeNombre;
    }

    public void setCaeNombre(String caeNombre) {
        this.caeNombre = caeNombre;
    }
}
