package com.ositran.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({ @NamedQuery(name = "Inversion.findAll", query = "select o from Inversion o") })
@Table(name = "T_INVERSION")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_INVERSION"))
public class Inversion implements Serializable {
    private static final long serialVersionUID = 4950860685481990821L;
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "TIN_ID")
    private Integer tinId;
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "CON_ID")
    private Integer conId;
    @Column(name = "INV_DESCRIPCION", nullable = false, length = 100)
    private String invDescripcion;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "INV_ID", nullable = false)
    private Integer invId;
    
    
    public Inversion() {
    }

    public Inversion(Integer infId, Integer tinId, Integer csiId, String invDescripcion, Integer invId,
                     int conId) {
        super();
        this.infId = infId;
        this.tinId = tinId;
        this.csiId = csiId;
        this.invDescripcion = invDescripcion;
        this.invId = invId;
        this.conId = conId;
        
    }


    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setInvDescripcion(String invDescripcion) {
        this.invDescripcion = invDescripcion;
    }

    public String getInvDescripcion() {
        return invDescripcion;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getInvId() {
        return invId;
    }

}
