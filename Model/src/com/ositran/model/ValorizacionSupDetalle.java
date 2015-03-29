package com.ositran.model;

import java.io.Serializable;
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
    @Column(nullable = false)
    private Long igv;
    @Column(name = "MON_ID", nullable = false)
    private Integer monId;
    @Column(nullable = false)
    private Long neto;
    @Column(nullable = false)
    private Long total;
    @Column(name = "TVS_HR", nullable = false)
    private Integer tvsHr;

    public ValorizacionSupDetalle() {
    }

    public ValorizacionSupDetalle(Integer cvaId, Long igv, Integer monId, Long neto, Long total,
                                  Integer tvsHr) {
        this.cvaId = cvaId;
        this.igv = igv;
        this.monId = monId;
        this.neto = neto;
        this.total = total;
        this.tvsHr = tvsHr;
    }

    public Integer getCvaId() {
        return cvaId;
    }

    public void setCvaId(Integer cvaId) {
        this.cvaId = cvaId;
    }

    public Long getIgv() {
        return igv;
    }

    public void setIgv(Long igv) {
        this.igv = igv;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Long getNeto() {
        return neto;
    }

    public void setNeto(Long neto) {
        this.neto = neto;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTvsHr() {
        return tvsHr;
    }

    public void setTvsHr(Integer tvsHr) {
        this.tvsHr = tvsHr;
    }
}
