package com.ositran.model;

import java.io.Serializable;


import java.math.BigDecimal;

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
@NamedQueries({ @NamedQuery(name = "ContratoPpo.findAll", query = "select o from ContratoPpo o") })
@Table(name = "T_CONTRATO_PPO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_PPO"))
public class ContratoPpo implements Serializable {
    private static final long serialVersionUID = -3386497231833748913L;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "PPO_ARCHIVO_PDF")
    private String ppoArchivoPdf;
    @Temporal(TemporalType.DATE)
    @Column(name = "PPO_FECHA")
    private Date ppoFecha;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "PPO_ID", nullable = false)
    private Integer ppoId;
    @Column(name = "PPO_MONTO", nullable = false)
    private BigDecimal ppoMonto;
    @Column(name = "PPO_ESTADO")
    private Integer ppoEstado;
    @Column(name = "PPO_NOMBRE")
    private String ppoNombre;
    
    

    public ContratoPpo() {
    }

    public ContratoPpo(Integer conId, Integer monId, String ppoArchivoPdf, Date ppoFecha, Integer ppoId,
                       BigDecimal ppoMonto, Integer ppoEstado, String ppoNombre) {
        this.conId = conId;
        this.monId = monId;
        this.ppoArchivoPdf = ppoArchivoPdf;
        this.ppoFecha = ppoFecha;
        this.ppoId = ppoId;
        this.ppoMonto = ppoMonto;        
        this.ppoEstado = ppoEstado;
        this.ppoNombre = ppoNombre;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public String getPpoArchivoPdf() {
        return ppoArchivoPdf;
    }

    public void setPpoArchivoPdf(String ppoArchivoPdf) {
        this.ppoArchivoPdf = ppoArchivoPdf;
    }

    public Date getPpoFecha() {
        return ppoFecha;
    }

    public void setPpoFecha(Date ppoFecha) {
        this.ppoFecha = ppoFecha;
    }

    public Integer getPpoId() {
        return ppoId;
    }

    public void setPpoId(Integer ppoId) {
        this.ppoId = ppoId;
    }

    public BigDecimal getPpoMonto() {
        return ppoMonto;
    }

    public void setPpoMonto(BigDecimal ppoMonto) {
        this.ppoMonto = ppoMonto;
    }

    public Integer getPpoEstado() {
        return ppoEstado;
    }

    public void setPpoEstado(Integer ppoEstado) {
        this.ppoEstado = ppoEstado;
    }

    public String getPpoNombre() {
        return ppoNombre;
    }

    public void setPpoNombre(String ppoNombre) {
        this.ppoNombre = ppoNombre;
    }
}
