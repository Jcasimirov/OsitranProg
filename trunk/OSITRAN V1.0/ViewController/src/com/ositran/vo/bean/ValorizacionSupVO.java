package com.ositran.vo.bean;

import java.math.BigDecimal;

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
    private Integer supId;
    private Integer tvsAnyo;
    private String tvsAsunto;
    private BigDecimal tvsBruto;
    private Integer tvsEstado;
    private Date tvsFechaRegistro;
    private Integer tvsId;
    private Integer tvsHr;
    private BigDecimal tvsIgv;
    private Date tvsInfFechaEmision;
    private String tvsInfNumero;
    private String tvsInfRegSalida;
    private Date tvsMemFechaEmision;
    private String tvsMemNumero;
    private String tvsMemRegSalida;
    private BigDecimal tvsNeto;
    private Date tvsOfiFechaEmision;
    private String tvsOfiNumero;
    private String tvsOfiRegSalida;
    private BigDecimal tvsAprobado;
    private String tvsObservacion;
    private String nombreMoneda;
    private String nombreEstado;
   
    private Date tvsFechaAprob;     
    private BigDecimal tvsMontoTotalAprob;
    private Integer tvsUsuarioAprob;
    private Integer tvsTinId;
    private Integer tvsCsiId;
    private Integer tvsCcoId; 
    private Integer tvsTccTipo;
    private Integer tvsMcoId; 
    private Integer tvsInfId;    
    private Integer tvsInvId;
    private BigDecimal tvsCcoTotal;
    private String tvsCcoPlazo;


    public ValorizacionSupVO(Integer monId, Integer supId, Integer tvsAnyo, String tvsAsunto, BigDecimal tvsBruto,
                             Integer tvsEstado, Date tvsFechaRegistro, Integer tvsId, Integer tvsHr, BigDecimal tvsIgv,
                             Date tvsInfFechaEmision, String tvsInfNumero, String tvsInfRegSalida,
                             Date tvsMemFechaEmision, String tvsMemNumero, String tvsMemRegSalida, BigDecimal tvsNeto,
                             Date tvsOfiFechaEmision, String tvsOfiNumero, String tvsOfiRegSalida,
                             BigDecimal tvsAprobado, String tvsObservacion, String nombreMoneda, String nombreEstado,
                             Date tvsFechaAprob, BigDecimal tvsMontoTotalAprob, Integer tvsUsuarioAprob,
                             Integer tvsTinId, Integer tvsCsiId, Integer tvsCcoId, Integer tvsTccTipo, Integer tvsMcoId,
                             Integer tvsInfId, Integer tvsInvId, BigDecimal tvsCcoTotal, String tvsCcoPlazo) {
        super();
        this.monId = monId;
        this.supId = supId;
        this.tvsAnyo = tvsAnyo;
        this.tvsAsunto = tvsAsunto;
        this.tvsBruto = tvsBruto;
        this.tvsEstado = tvsEstado;
        this.tvsFechaRegistro = tvsFechaRegistro;
        this.tvsId = tvsId;
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
        this.tvsAprobado = tvsAprobado;
        this.tvsObservacion = tvsObservacion;
        this.nombreMoneda = nombreMoneda;
        this.nombreEstado = nombreEstado;
        this.tvsFechaAprob = tvsFechaAprob;
        this.tvsMontoTotalAprob = tvsMontoTotalAprob;
        this.tvsUsuarioAprob = tvsUsuarioAprob;
        this.tvsTinId = tvsTinId;
        this.tvsCsiId = tvsCsiId;
        this.tvsCcoId = tvsCcoId;
        this.tvsTccTipo = tvsTccTipo;
        this.tvsMcoId = tvsMcoId;
        this.tvsInfId = tvsInfId;
        this.tvsInvId = tvsInvId;
        this.tvsCcoTotal = tvsCcoTotal;
        this.tvsCcoPlazo = tvsCcoPlazo;
    }


    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
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

    public void setTvsAsunto(String tvsAsunto) {
        this.tvsAsunto = tvsAsunto;
    }

    public String getTvsAsunto() {
        return tvsAsunto;
    }

    public void setTvsBruto(BigDecimal tvsBruto) {
        this.tvsBruto = tvsBruto;
    }

    public BigDecimal getTvsBruto() {
        return tvsBruto;
    }

    public void setTvsEstado(Integer tvsEstado) {
        this.tvsEstado = tvsEstado;
    }

    public Integer getTvsEstado() {
        return tvsEstado;
    }

    public void setTvsFechaRegistro(Date tvsFechaRegistro) {
        this.tvsFechaRegistro = tvsFechaRegistro;
    }

    public Date getTvsFechaRegistro() {
        return tvsFechaRegistro;
    }

    public void setTvsId(Integer tvsId) {
        this.tvsId = tvsId;
    }

    public Integer getTvsId() {
        return tvsId;
    }

    public void setTvsHr(Integer tvsHr) {
        this.tvsHr = tvsHr;
    }

    public Integer getTvsHr() {
        return tvsHr;
    }

    public void setTvsIgv(BigDecimal tvsIgv) {
        this.tvsIgv = tvsIgv;
    }

    public BigDecimal getTvsIgv() {
        return tvsIgv;
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

    public void setTvsNeto(BigDecimal tvsNeto) {
        this.tvsNeto = tvsNeto;
    }

    public BigDecimal getTvsNeto() {
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

    public void setTvsAprobado(BigDecimal tvsAprobado) {
        this.tvsAprobado = tvsAprobado;
    }

    public BigDecimal getTvsAprobado() {
        return tvsAprobado;
    }

    public void setTvsObservacion(String tvsObservacion) {
        this.tvsObservacion = tvsObservacion;
    }

    public String getTvsObservacion() {
        return tvsObservacion;
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

    public void setTvsFechaAprob(Date tvsFechaAprob) {
        this.tvsFechaAprob = tvsFechaAprob;
    }

    public Date getTvsFechaAprob() {
        return tvsFechaAprob;
    }

    public void setTvsMontoTotalAprob(BigDecimal tvsMontoTotalAprob) {
        this.tvsMontoTotalAprob = tvsMontoTotalAprob;
    }

    public BigDecimal getTvsMontoTotalAprob() {
        return tvsMontoTotalAprob;
    }

    public void setTvsUsuarioAprob(Integer tvsUsuarioAprob) {
        this.tvsUsuarioAprob = tvsUsuarioAprob;
    }

    public Integer getTvsUsuarioAprob() {
        return tvsUsuarioAprob;
    }

    public void setTvsTinId(Integer tvsTinId) {
        this.tvsTinId = tvsTinId;
    }

    public Integer getTvsTinId() {
        return tvsTinId;
    }

    public void setTvsCsiId(Integer tvsCsiId) {
        this.tvsCsiId = tvsCsiId;
    }

    public Integer getTvsCsiId() {
        return tvsCsiId;
    }

    public void setTvsCcoId(Integer tvsCcoId) {
        this.tvsCcoId = tvsCcoId;
    }

    public Integer getTvsCcoId() {
        return tvsCcoId;
    }

    public void setTvsTccTipo(Integer tvsTccTipo) {
        this.tvsTccTipo = tvsTccTipo;
    }

    public Integer getTvsTccTipo() {
        return tvsTccTipo;
    }

    public void setTvsMcoId(Integer tvsMcoId) {
        this.tvsMcoId = tvsMcoId;
    }

    public Integer getTvsMcoId() {
        return tvsMcoId;
    }

    public void setTvsInfId(Integer tvsInfId) {
        this.tvsInfId = tvsInfId;
    }

    public Integer getTvsInfId() {
        return tvsInfId;
    }

    public void setTvsInvId(Integer tvsInvId) {
        this.tvsInvId = tvsInvId;
    }

    public Integer getTvsInvId() {
        return tvsInvId;
    }

    public void setTvsCcoTotal(BigDecimal tvsCcoTotal) {
        this.tvsCcoTotal = tvsCcoTotal;
    }

    public BigDecimal getTvsCcoTotal() {
        return tvsCcoTotal;
    }

    public void setTvsCcoPlazo(String tvsCcoPlazo) {
        this.tvsCcoPlazo = tvsCcoPlazo;
    }

    public String getTvsCcoPlazo() {
        return tvsCcoPlazo;
    }

}
