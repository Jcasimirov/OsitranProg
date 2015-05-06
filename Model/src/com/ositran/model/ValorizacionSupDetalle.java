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
    @Column(name = "VSD_ID", nullable = false)
    private Integer vsdId;
    @GeneratedValue(generator = "generator")            
    @Column(name = "CVA_ID")    
    private Integer cvaId;
    @Column(name="VSD_IGV")
    private BigDecimal igv;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name="VSD_NETO")
    private BigDecimal neto;
    @Column(name="VSD_TTOTAL")
    private BigDecimal ttotal;
    @Column(name = "TVS_HR")
    private Integer tvsHr;
    @Column(name="VSD_TOTAL_APROBADO")
    private BigDecimal totalAprobado;

    public ValorizacionSupDetalle() {
    }

    public ValorizacionSupDetalle(Integer vsdId, Integer cvaId, BigDecimal igv, Integer monId, BigDecimal neto,
                                  BigDecimal ttotal, Integer tvsHr, BigDecimal totalAprobado) {
        super();
        this.vsdId = vsdId;
        this.cvaId = cvaId;
        this.igv = igv;
        this.monId = monId;
        this.neto = neto;
        this.ttotal = ttotal;
        this.tvsHr = tvsHr;
        this.totalAprobado = totalAprobado;
    }

    public void setVsdId(Integer vsdId) {
        this.vsdId = vsdId;
    }

    public Integer getVsdId() {
        return vsdId;
    }

    public void setCvaId(Integer cvaId) {
        this.cvaId = cvaId;
    }

    public Integer getCvaId() {
        return cvaId;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setNeto(BigDecimal neto) {
        this.neto = neto;
    }

    public BigDecimal getNeto() {
        return neto;
    }

    public void setTtotal(BigDecimal ttotal) {
        this.ttotal = ttotal;
    }

    public BigDecimal getTtotal() {
        return ttotal;
    }

    public void setTvsHr(Integer tvsHr) {
        this.tvsHr = tvsHr;
    }

    public Integer getTvsHr() {
        return tvsHr;
    }

    public void setTotalAprobado(BigDecimal totalAprobado) {
        this.totalAprobado = totalAprobado;
    }

    public BigDecimal getTotalAprobado() {
        return totalAprobado;
    }

}
