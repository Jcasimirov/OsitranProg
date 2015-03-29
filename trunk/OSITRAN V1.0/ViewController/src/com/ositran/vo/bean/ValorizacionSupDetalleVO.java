package com.ositran.vo.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ValorizacionSupDetalleVO {
    
    private Integer cvaId;
    private Long igv;
    private Integer monId;
    private Long neto;
    private Long total;
    private Integer tvsHr;
    
    public ValorizacionSupDetalleVO() {
    }


    public ValorizacionSupDetalleVO(Integer cvaId, Long igv, Integer monId, Long neto, Long total, Integer tvsHr) {
        super();
        this.cvaId = cvaId;
        this.igv = igv;
        this.monId = monId;
        this.neto = neto;
        this.total = total;
        this.tvsHr = tvsHr;
    }


    public void setCvaId(Integer cvaId) {
        this.cvaId = cvaId;
    }

    public Integer getCvaId() {
        return cvaId;
    }

    public void setIgv(Long igv) {
        this.igv = igv;
    }

    public Long getIgv() {
        return igv;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setNeto(Long neto) {
        this.neto = neto;
    }

    public Long getNeto() {
        return neto;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public void setTvsHr(Integer tvsHr) {
        this.tvsHr = tvsHr;
    }

    public Integer getTvsHr() {
        return tvsHr;
    }

}
