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


    private Integer monId;
    private double tvsBruto;
    private Integer tvsHr;
    private double tvsIgv;
    private Date tvsInfFechaEmision;
    private String tvsInfNumero;
    private String tvsInfRegSalida;
    private Date tvsMemFechaEmision;
    private String tvsMemNumero;
    private String tvsMemRegSalida;
    private double tvsNeto;
    private Date tvsOfiFechaEmision;
    private String tvsOfiNumero;
    private String tvsOfiRegSalida;
    private Integer tvsEstado;
    private Integer supId;
    private Integer tvsAnyo;    
    private Date tvsFechaRegistro;
    private String tvsAsunto;
    private String nombreMoneda;
    private String nombreEstado;
    private long tvsAprobado;
    private String tvsObservacion;
    private Integer tvsId;


    public ValorizacionSupVO(Integer monId, double tvsBruto, Integer tvsHr, double tvsIgv, Date tvsInfFechaEmision,
                             String tvsInfNumero, String tvsInfRegSalida, Date tvsMemFechaEmision, String tvsMemNumero,
                             String tvsMemRegSalida, double tvsNeto, Date tvsOfiFechaEmision, String tvsOfiNumero,
                             String tvsOfiRegSalida, Integer tvsEstado, Integer supId, Integer tvsAnyo,
                             Date tvsFechaRegistro, String tvsAsunto, String nombreMoneda, String nombreEstado,
                             long tvsAprobado, String tvsObservacion, Integer tvsId) {
        super();
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
        this.tvsEstado = tvsEstado;
        this.supId = supId;
        this.tvsAnyo = tvsAnyo;
        this.tvsFechaRegistro = tvsFechaRegistro;
        this.tvsAsunto = tvsAsunto;
        this.nombreMoneda = nombreMoneda;
        this.nombreEstado = nombreEstado;
        this.tvsAprobado = tvsAprobado;
        this.tvsObservacion = tvsObservacion;
        this.tvsId = tvsId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public void setTvsId(Integer tvsId) {
        this.tvsId = tvsId;
    }

    public Integer getTvsId() {
        return tvsId;
    }

    public Integer getMonId() {
        return monId;
    }

  
    public void setTvsHr(Integer tvsHr) {
        this.tvsHr = tvsHr;
    }

    public Integer getTvsHr() {
        return tvsHr;
    }

   
    public void setTvsInfFechaEmision(Date tvsInfFechaEmision) {
        this.tvsInfFechaEmision = tvsInfFechaEmision;
    }

    public Date getTvsInfFechaEmision() {
        return tvsInfFechaEmision;
    }

    public void setTvsInfNumero(String tvsInfNumero) {
        this.tvsInfNumero = tvsInfNumero;
    }

    public String getTvsInfNumero() {
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

    public void setTvsMemNumero(String tvsMemNumero) {
        this.tvsMemNumero = tvsMemNumero;
    }

    public String getTvsMemNumero() {
        return tvsMemNumero;
    }

    public void setTvsMemRegSalida(String tvsMemRegSalida) {
        this.tvsMemRegSalida = tvsMemRegSalida;
    }

    public String getTvsMemRegSalida() {
        return tvsMemRegSalida;
    }


    public void setTvsBruto(double tvsBruto) {
        this.tvsBruto = tvsBruto;
    }

    public double getTvsBruto() {
        return tvsBruto;
    }

    public void setTvsIgv(double tvsIgv) {
        this.tvsIgv = tvsIgv;
    }

    public double getTvsIgv() {
        return tvsIgv;
    }

    public void setTvsNeto(double tvsNeto) {
        this.tvsNeto = tvsNeto;
    }

    public double getTvsNeto() {
        return tvsNeto;
    }

    public void setTvsOfiFechaEmision(Date tvsOfiFechaEmision) {
        this.tvsOfiFechaEmision = tvsOfiFechaEmision;
    }

    public Date getTvsOfiFechaEmision() {
        return tvsOfiFechaEmision;
    }

    public void setTvsOfiNumero(String tvsOfiNumero) {
        this.tvsOfiNumero = tvsOfiNumero;
    }

    public String getTvsOfiNumero() {
        return tvsOfiNumero;
    }

    public void setTvsOfiRegSalida(String tvsOfiRegSalida) {
        this.tvsOfiRegSalida = tvsOfiRegSalida;
    }

    public String getTvsOfiRegSalida() {
        return tvsOfiRegSalida;
    }

    public void setTvsEstado(Integer tvsEstado) {
        this.tvsEstado = tvsEstado;
    }

    public Integer getTvsEstado() {
        return tvsEstado;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setTvsAnyo(Integer tvsAnyo) {
        this.tvsAnyo = tvsAnyo;
    }

    public Integer getTvsAnyo() {
        return tvsAnyo;
    }

    public void setTvsFechaRegistro(Date tvsFechaRegistro) {
        this.tvsFechaRegistro = tvsFechaRegistro;
    }

    public Date getTvsFechaRegistro() {
        return tvsFechaRegistro;
    }

    public void setTvsAsunto(String tvsAsunto) {
        this.tvsAsunto = tvsAsunto;
    }

    public String getTvsAsunto() {
        return tvsAsunto;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setTvsAprobado(long tvsAprobado) {
        this.tvsAprobado = tvsAprobado;
    }

    public long getTvsAprobado() {
        return tvsAprobado;
    }

    public void setTvsObservacion(String tvsObservacion) {
        this.tvsObservacion = tvsObservacion;
    }

    public String getTvsObservacion() {
        return tvsObservacion;
    }
}
