package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Igv.findAll", query = "select o from Igv o") })
@Table(name = "T_IGV")
public class Igv implements Serializable {
    private static final long serialVersionUID = -4845809735559799973L;
    @Column(name = "IGV_DESCRIP", length = 100)
    private String igvDescrip;
    @Id
    @Column(name = "IGV_ID", nullable = false)
    private Integer igvId;
    @Column(name = "IGV_PERCENT", nullable = false)
    private Double igvPercent;

    public Igv() {
    }

    public Igv(String igvDescrip, Integer igvId, Double igvPercent) {
        this.igvDescrip = igvDescrip;
        this.igvId = igvId;
        this.igvPercent = igvPercent;
    }

    public String getIgvDescrip() {
        return igvDescrip;
    }

    public void setIgvDescrip(String igvDescrip) {
        this.igvDescrip = igvDescrip;
    }


    public void setIgvId(Integer igvId) {
        this.igvId = igvId;
    }

    public Integer getIgvId() {
        return igvId;
    }

    public void setIgvPercent(Double igvPercent) {
        this.igvPercent = igvPercent;
    }

    public Double getIgvPercent() {
        return igvPercent;
    }
}
