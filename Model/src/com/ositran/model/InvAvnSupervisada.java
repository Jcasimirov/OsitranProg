package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_INV_AVN_SUPERVISADA")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_INV_AVN_SUPERVISADA"))

public class InvAvnSupervisada implements Serializable {
    private static final long serialVersionUID = 780569910639441937L;
    @Column(name = "CSI_ID")
    private BigDecimal csiId;
    @Column(name = "IAS_ANYO", nullable = false)
    private Integer iasAnyo;
    @Column(name = "IAS_ASUNTO", length = 20)
    private String iasAsunto;
    @Column(name = "IAS_ESTADO", length = 20)
    private String iasEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAS_FECHA_EMISION")
    private Date iasFechaEmision;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAS_FECHA_RECEPCION")
    private Date iasFechaRecepcion;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAS_FECHA_REGISTRO")
    private Date iasFechaRegistro;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAS_FECHA_RESPUESTA")
    private Date iasFechaRespuesta;
    @Column(name = "IAS_HR", nullable = false)
    private BigDecimal iasHr;
    @Column(name = "IAS_NRO_CARTA", length = 50)
    private String iasNroCarta;
    @Column(name = "IAS_NRO_OFICIO", length = 20)
    private String iasNroOficio;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IAS_NUMERO")
    private BigDecimal iasNumero;
    @Column(name = "IAS_OBSERVACIONES", nullable = false, length = 4000)
    private String iasObservaciones;
    @Column(name = "IAS_PLAZO_DIAS")
    private BigDecimal iasPlazoDias;
    @Column(name = "IAS_REG_SALIDA", length = 20)
    private String iasRegSalida;
    @Column(name = "INV_ID")
    private BigDecimal invId;
    @Column(name = "TIN_ID")
    private BigDecimal tinId;
    
    @Column(name = "TIA_NUMERO")
    private int tiaNumero;
    

    public InvAvnSupervisada() {
    }

    public InvAvnSupervisada(BigDecimal csiId, Integer iasAnyo, String iasAsunto, String iasEstado,
                             Date iasFechaEmision, Date iasFechaRecepcion, Date iasFechaRegistro,
                             Date iasFechaRespuesta, BigDecimal iasHr, String iasNroCarta, String iasNroOficio,
                             BigDecimal iasNumero, String iasObservaciones, BigDecimal iasPlazoDias,
                             String iasRegSalida, BigDecimal invId, BigDecimal tinId) {
        this.csiId = csiId;
        this.iasAnyo = iasAnyo;
        this.iasAsunto = iasAsunto;
        this.iasEstado = iasEstado;
        this.iasFechaEmision = iasFechaEmision;
        this.iasFechaRecepcion = iasFechaRecepcion;
        this.iasFechaRegistro = iasFechaRegistro;
        this.iasFechaRespuesta = iasFechaRespuesta;
        this.iasHr = iasHr;
        this.iasNroCarta = iasNroCarta;
        this.iasNroOficio = iasNroOficio;
        this.iasNumero = iasNumero;
        this.iasObservaciones = iasObservaciones;
        this.iasPlazoDias = iasPlazoDias;
        this.iasRegSalida = iasRegSalida;
        this.invId = invId;
        this.tinId = tinId;
    }

    public BigDecimal getCsiId() {
        return csiId;
    }

    public void setCsiId(BigDecimal csiId) {
        this.csiId = csiId;
    }

    public Integer getIasAnyo() {
        return iasAnyo;
    }

    public void setIasAnyo(Integer iasAnyo) {
        this.iasAnyo = iasAnyo;
    }

    public String getIasAsunto() {
        return iasAsunto;
    }

    public void setIasAsunto(String iasAsunto) {
        this.iasAsunto = iasAsunto;
    }

    public String getIasEstado() {
        return iasEstado;
    }

    public void setIasEstado(String iasEstado) {
        this.iasEstado = iasEstado;
    }

    public Date getIasFechaEmision() {
        return iasFechaEmision;
    }

    public void setIasFechaEmision(Date iasFechaEmision) {
        this.iasFechaEmision = iasFechaEmision;
    }

    public Date getIasFechaRecepcion() {
        return iasFechaRecepcion;
    }

    public void setIasFechaRecepcion(Date iasFechaRecepcion) {
        this.iasFechaRecepcion = iasFechaRecepcion;
    }

    public Date getIasFechaRegistro() {
        return iasFechaRegistro;
    }

    public void setIasFechaRegistro(Date iasFechaRegistro) {
        this.iasFechaRegistro = iasFechaRegistro;
    }

    public Date getIasFechaRespuesta() {
        return iasFechaRespuesta;
    }

    public void setIasFechaRespuesta(Date iasFechaRespuesta) {
        this.iasFechaRespuesta = iasFechaRespuesta;
    }

    public BigDecimal getIasHr() {
        return iasHr;
    }

    public void setIasHr(BigDecimal iasHr) {
        this.iasHr = iasHr;
    }

    public String getIasNroCarta() {
        return iasNroCarta;
    }

    public void setIasNroCarta(String iasNroCarta) {
        this.iasNroCarta = iasNroCarta;
    }

    public String getIasNroOficio() {
        return iasNroOficio;
    }

    public void setIasNroOficio(String iasNroOficio) {
        this.iasNroOficio = iasNroOficio;
    }

    public BigDecimal getIasNumero() {
        return iasNumero;
    }

    public void setIasNumero(BigDecimal iasNumero) {
        this.iasNumero = iasNumero;
    }

    public String getIasObservaciones() {
        return iasObservaciones;
    }

    public void setIasObservaciones(String iasObservaciones) {
        this.iasObservaciones = iasObservaciones;
    }

    public BigDecimal getIasPlazoDias() {
        return iasPlazoDias;
    }

    public void setIasPlazoDias(BigDecimal iasPlazoDias) {
        this.iasPlazoDias = iasPlazoDias;
    }

    public String getIasRegSalida() {
        return iasRegSalida;
    }

    public void setIasRegSalida(String iasRegSalida) {
        this.iasRegSalida = iasRegSalida;
    }

    public BigDecimal getInvId() {
        return invId;
    }

    public void setInvId(BigDecimal invId) {
        this.invId = invId;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }


}
