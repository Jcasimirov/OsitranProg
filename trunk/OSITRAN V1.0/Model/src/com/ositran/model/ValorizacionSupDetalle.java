package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_VALORIZACION_SUP_DETALLE")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_VALORIZACION_SUP_DETALLE"))
public class ValorizacionSupDetalle implements Serializable {
    private static final long serialVersionUID = -6895999228460826945L;
    @Id
    @Column(name = "CVA_ID", nullable = false)
    @GeneratedValue(generator = "generator")    
    private Integer cvaId;
    @Column(name="VSD_IGV")
    private double igv;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name="VSD_NETO")
    private double neto;
    @Column(name="VSD_TOTAL")
    private double total;
    @Column(name = "TVS_HR")
    private Integer tvsHr;
    @Column(name="VSD_TOTAL_APROBADO")
    private double totalAprobado;

    public ValorizacionSupDetalle() {
    }

    public ValorizacionSupDetalle(Integer cvaId, Long igv, Integer monId, Long neto, Long total,
                                  Integer tvsHr, double totalAprobado) {
        this.cvaId = cvaId;
        this.igv = igv;
        this.monId = monId;
        this.neto = neto;
        this.total = total;
        this.tvsHr = tvsHr;
        this.totalAprobado = totalAprobado;
    }

    public void setCvaId(Integer cvaId) {
        this.cvaId = cvaId;
    }

    public Integer getCvaId() {
        return cvaId;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getIgv() {
        return igv;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    public double getNeto() {
        return neto;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTvsHr(Integer tvsHr) {
        this.tvsHr = tvsHr;
    }

    public Integer getTvsHr() {
        return tvsHr;
    }

    public void setTotalAprobado(double totalAprobado) {
        this.totalAprobado = totalAprobado;
    }

    public double getTotalAprobado() {
        return totalAprobado;
    }
}
