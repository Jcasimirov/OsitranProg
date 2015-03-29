package com.ositran.vo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ValorizacionSupVO {
    public ValorizacionSupVO() {
           }


    public ValorizacionSupVO(Integer monId, Long tvsBruto, Integer tvsHr, Long tvsIgv, Date tvsInfFechaEmision,
                             Integer tvsInfNumero, String tvsInfRegSalida, Date tvsMemFechaEmision,
                             Integer tvsMemNumero, String tvsMemRegSalida, Long tvsNeto, Date tvsOfiFechaEmision,
                             Integer tvsOfiNumero, String tvsOfiRegSalida) {
        
        this.monId = monId;
        this.tvsBruto = tvsBruto;
        this.tvsHr = tvsHr;
        this.tvsIgv = tvsIgv;
        this.tvsInfFechaEmision = tvsInfFechaEmision;
        this.tvsInfNumero = tvsInfNumero;
        this.tvsInfRegSalida = tvsInfRegSalida;
        this.tvsMemFechaEmision = tvsMemFechaEmision;
        this.tvsMemNumero = tvsMemNumero;
        this.tvsMemRegSalida = tvsMemRegSalida;
        this.tvsNeto = tvsNeto;
        this.tvsOfiFechaEmision = tvsOfiFechaEmision;
        this.tvsOfiNumero = tvsOfiNumero;
        this.tvsOfiRegSalida = tvsOfiRegSalida;
    }

    private Integer monId;
    private Long tvsBruto;
    private Integer tvsHr;
    private Long tvsIgv;
    private Date tvsInfFechaEmision;
    private Integer tvsInfNumero;
    private String tvsInfRegSalida;
    private Date tvsMemFechaEmision;
    private Integer tvsMemNumero;
    private String tvsMemRegSalida;
    private Long tvsNeto;
    private Date tvsOfiFechaEmision;
    private Integer tvsOfiNumero;
    private String tvsOfiRegSalida;


    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setTvsBruto(Long tvsBruto) {
        this.tvsBruto = tvsBruto;
    }

    public Long getTvsBruto() {
        return tvsBruto;
    }

    public void setTvsHr(Integer tvsHr) {
        this.tvsHr = tvsHr;
    }

    public Integer getTvsHr() {
        return tvsHr;
    }

    public void setTvsIgv(Long tvsIgv) {
        this.tvsIgv = tvsIgv;
    }

    public Long getTvsIgv() {
        return tvsIgv;
    }

    public void setTvsInfFechaEmision(Date tvsInfFechaEmision) {
        this.tvsInfFechaEmision = tvsInfFechaEmision;
    }

    public Date getTvsInfFechaEmision() {
        return tvsInfFechaEmision;
    }

    public void setTvsInfNumero(Integer tvsInfNumero) {
        this.tvsInfNumero = tvsInfNumero;
    }

    public Integer getTvsInfNumero() {
        return tvsInfNumero;
    }

    public void setTvsInfRegSalida(String tvsInfRegSalida) {
        this.tvsInfRegSalida = tvsInfRegSalida;
    }

    public String getTvsInfRegSalida() {
        return tvsInfRegSalida;
    }

    public void setTvsMemFechaEmision(Date tvsMemFechaEmision) {
        this.tvsMemFechaEmision = tvsMemFechaEmision;
    }

    public Date getTvsMemFechaEmision() {
        return tvsMemFechaEmision;
    }

    public void setTvsMemNumero(Integer tvsMemNumero) {
        this.tvsMemNumero = tvsMemNumero;
    }

    public Integer getTvsMemNumero() {
        return tvsMemNumero;
    }

    public void setTvsMemRegSalida(String tvsMemRegSalida) {
        this.tvsMemRegSalida = tvsMemRegSalida;
    }

    public String getTvsMemRegSalida() {
        return tvsMemRegSalida;
    }

    public void setTvsNeto(Long tvsNeto) {
        this.tvsNeto = tvsNeto;
    }

    public Long getTvsNeto() {
        return tvsNeto;
    }

    public void setTvsOfiFechaEmision(Date tvsOfiFechaEmision) {
        this.tvsOfiFechaEmision = tvsOfiFechaEmision;
    }

    public Date getTvsOfiFechaEmision() {
        return tvsOfiFechaEmision;
    }

    public void setTvsOfiNumero(Integer tvsOfiNumero) {
        this.tvsOfiNumero = tvsOfiNumero;
    }

    public Integer getTvsOfiNumero() {
        return tvsOfiNumero;
    }

    public void setTvsOfiRegSalida(String tvsOfiRegSalida) {
        this.tvsOfiRegSalida = tvsOfiRegSalida;
    }

    public String getTvsOfiRegSalida() {
        return tvsOfiRegSalida;
    }
}
