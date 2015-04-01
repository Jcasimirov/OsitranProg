package com.ositran.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({ @NamedQuery(name = "ContratoHito.findAll", query = "select o from ContratoHito o") })
@Table(name = "T_CONTRATO_HITO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "sq_t_contrato_hito"))
public class ContratoHito implements Serializable {
    private static final long serialVersionUID = 3483267862987759620L;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Temporal(TemporalType.DATE)
    @Column(name = "HTO_FECHA")
    private Date htoFecha;
    @Id
    @GeneratedValue(generator = "generator")    
    @Column(name = "HTO_ID", nullable = false)
    private Integer htoId;
    @Column(name = "HTO_MONTO", nullable = false)
    private Integer htoMonto;
    @Column(name = "HTO_OFICIO", length = 20)
    private String htoOficio;
    @Column(name = "HTO_PDF")
    private String htoPdf;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "HTO_ESTADO")
    private Integer htoEstado;
    

    public ContratoHito() {
    }

    public ContratoHito(Integer conId, Date htoFecha, Integer htoId, Integer htoMonto, String htoOficio,
                        String htoPdf, Integer monId, Integer htoEstado) {
        this.conId = conId;
        this.htoFecha = htoFecha;
        this.htoId = htoId;
        this.htoMonto = htoMonto;
        this.htoOficio = htoOficio;
        this.htoPdf = htoPdf;
        this.monId = monId;
        this.htoEstado = htoEstado;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Date getHtoFecha() {
        return htoFecha;
    }

    public void setHtoFecha(Date htoFecha) {
        this.htoFecha = htoFecha;
    }

    public Integer getHtoId() {
        return htoId;
    }

    public void setHtoId(Integer htoId) {
        this.htoId = htoId;
    }

    public Integer getHtoMonto() {
        return htoMonto;
    }

    public void setHtoMonto(Integer htoMonto) {
        this.htoMonto = htoMonto;
    }

    public String getHtoOficio() {
        return htoOficio;
    }

    public void setHtoOficio(String htoOficio) {
        this.htoOficio = htoOficio;
    }

    public String getHtoPdf() {
        return htoPdf;
    }

    public void setHtoPdf(String htoPdf) {
        this.htoPdf = htoPdf;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getHtoEstado() {
        return htoEstado;
    }

    public void setHtoEstado(Integer htoEstado) {
        this.htoEstado = htoEstado;
    }
}
