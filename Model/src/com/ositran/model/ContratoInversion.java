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
@NamedQueries({ @NamedQuery(name = "ContratoInversion.findAll", query = "select o from ContratoInversion o") })
@Table(name = "T_CONTRATO_INVERSION")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_INVERSION"))
public class ContratoInversion implements Serializable {
    private static final long serialVersionUID = 5582300002098147769L;
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "INV_DESCRIPCION", nullable = false, length = 100)
    private String invDescripcion;
    @Id
    @GeneratedValue(generator = "generator") 
    @Column(name = "INV_ID", nullable = false)
    private Integer invId;
    @Column(name = "TIN_ID")
    private Integer tinId;
    @Column(name = "INV_ESTADO")
    private Integer invEstado;
    
    public ContratoInversion() {
    }

    public ContratoInversion(Integer conId, Integer csiId, Integer infId, String invDescripcion,
                             Integer invId, Integer tinId, Integer invEstado) {
        this.conId = conId;
        this.csiId = csiId;
        this.infId = infId;
        this.invDescripcion = invDescripcion;
        this.invId = invId;
        this.tinId = tinId;
        this.invEstado = invEstado;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public String getInvDescripcion() {
        return invDescripcion;
    }

    public void setInvDescripcion(String invDescripcion) {
        this.invDescripcion = invDescripcion;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(Integer invEstado) {
        this.invEstado = invEstado;
    }
}
