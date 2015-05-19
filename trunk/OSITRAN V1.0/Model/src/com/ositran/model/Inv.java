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
@NamedQueries({ @NamedQuery(name = "Inv.findAll", query = "select o from Inv o") })
@Table(name = "T_INV")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_INV"))
public class Inv implements Serializable {
    private static final long serialVersionUID = -71310979566995376L;
    @Column(name = "INV_ESTADO_RECONOCIMIENTO", nullable = false)
    private Integer invEstadoReconocimiento;
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_EMISION_INFORME")
    private Date invFechaEmisionInforme;
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_EMISION_OFICIO")
    private Date invFechaEmisionOficio; 
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "INV_ID", nullable = false)
    private Integer invId;
    @Column(name = "INV_MONTO_TIPO_CAMBIO")
    private BigDecimal invMontoTipoCambio;
    @Column(name = "INV_MONTO_TOTAL_APROBADO", nullable = false)
    private BigDecimal invMontoTotalAprobado;
    @Column(name = "INV_MONTO_TOTAL_REAJUSTE", nullable = false)
    private BigDecimal invMontoTotalReajuste;
    @Column(name = "INV_NOTA", length = 4000)
    private String invNota;
    @Column(name = "INV_NUMERO_INFORME", nullable = false)
    private String invNumeroInforme;
    @Column(name = "INV_NUMERO_OFICIO", length = 50)
    private String invNumeroOficio;
    @Column(name = "INV_OBSERVACIONES", length = 20)
    private String invObservaciones;
    @Column(name = "INV_REG_SALIDA_INFORME", length = 50)
    private String invRegSalidaInforme;
    @Column(name = "INV_REG_SALIDA_OFICIO", length = 100)
    private String invRegSalidaOficio;
    @Column(name = "MON_ID")
    private Integer monId;
    //@Id
    @Column(name = "TIA_NUMERO", nullable = false)
    private Integer tiaNumero;
    @Column(name = "INV_ESTADO") 
    private Integer invEstado;
    @Column(name = "INV_NRO_DOC_FORMALIZACION") 
    private String invNroDocFormalizacion;
    @Column(name = "INV_FECHA_EMISION_FORM")
    private Date invFechaEmisionDocFomalizacion;
    @Column(name = "INV_IGV") 
    private Integer invIgv;
    @Column(name = "INV_NOTA_TIPO_CAMBIO") 
    private String  invNotaTipoCambio;
    public Inv() {
    }

    public Inv(Integer invEstadoReconocimiento, Date invFechaEmisionInforme, Date invFechaEmisionOficio,
               Integer invId, BigDecimal invMontoTipoCambio, BigDecimal invMontoTotalAprobado, BigDecimal invMontoTotalReajuste,
               String invNota, String invNumeroInforme, String invNumeroOficio, String invObservaciones,
               String invRegSalidaInforme, String invRegSalidaOficio, Integer Monid, Integer itrId,
               Integer tiaNumero, Integer invEstado, String invNroDocFormalizacion, Integer invIgv) {
        this.invEstadoReconocimiento = invEstadoReconocimiento;
        this.invFechaEmisionInforme = invFechaEmisionInforme;
        this.invFechaEmisionOficio = invFechaEmisionOficio;
        this.invId = invId;
        this.invMontoTipoCambio = invMontoTipoCambio;
        this.invMontoTotalAprobado = invMontoTotalAprobado;
        this.invMontoTotalReajuste = invMontoTotalReajuste;
        this.invNota = invNota;
        this.invNumeroInforme = invNumeroInforme;
        this.invNumeroOficio = invNumeroOficio;
        this.invObservaciones = invObservaciones;
        this.invRegSalidaInforme = invRegSalidaInforme;
        this.invRegSalidaOficio = invRegSalidaOficio;
        this.monId = Monid;
    
        this.tiaNumero = tiaNumero;
        this.invEstado = invEstado;
        this.invNroDocFormalizacion = invNroDocFormalizacion;
        this.invIgv = invIgv;
    }

    public Integer getInvEstadoReconocimiento() {
        return invEstadoReconocimiento;
    }

    public void setInvEstadoReconocimiento(Integer invEstadoReconocimiento) {
        this.invEstadoReconocimiento = invEstadoReconocimiento;
    }

    public Date getInvFechaEmisionInforme() {
        return invFechaEmisionInforme;
    }

    public void setInvFechaEmisionInforme(Date invFechaEmisionInforme) {
        this.invFechaEmisionInforme = invFechaEmisionInforme;
    }

    public Date getInvFechaEmisionOficio() {
        return invFechaEmisionOficio;
    }

    public void setInvFechaEmisionOficio(Date invFechaEmisionOficio) {
        this.invFechaEmisionOficio = invFechaEmisionOficio;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public BigDecimal getInvMontoTipoCambio() {
        return invMontoTipoCambio;
    }

    public void setInvMontoTipoCambio(BigDecimal invMontoTipoCambio) {
        this.invMontoTipoCambio = invMontoTipoCambio;
    }

    public BigDecimal getInvMontoTotalAprobado() {
        return invMontoTotalAprobado;
    }

    public void setInvMontoTotalAprobado(BigDecimal invMontoTotalAprobado) {
        this.invMontoTotalAprobado = invMontoTotalAprobado;
    }

    public BigDecimal getInvMontoTotalReajuste() {
        return invMontoTotalReajuste;
    }

    public void setInvMontoTotalReajuste(BigDecimal invMontoTotalReajuste) {
        this.invMontoTotalReajuste = invMontoTotalReajuste;
    }

    public String getInvNota() {
        return invNota;
    }

    public void setInvNota(String invNota) {
        this.invNota = invNota;
    }

    public String getInvNumeroInforme() {
        return invNumeroInforme;
    }

    public void setInvNumeroInforme(String invNumeroInforme) {
        this.invNumeroInforme = invNumeroInforme;
    }

    public String getInvNumeroOficio() {
        return invNumeroOficio;
    }

    public void setInvNumeroOficio(String invNumeroOficio) {
        this.invNumeroOficio = invNumeroOficio;
    }

    public String getInvObservaciones() {
        return invObservaciones;
    }

    public void setInvObservaciones(String invObservaciones) {
        this.invObservaciones = invObservaciones;
    }

    public String getInvRegSalidaInforme() {
        return invRegSalidaInforme;
    }

    public void setInvRegSalidaInforme(String invRegSalidaInforme) {
        this.invRegSalidaInforme = invRegSalidaInforme;
    }

    public String getInvRegSalidaOficio() {
        return invRegSalidaOficio;
    }

    public void setInvRegSalidaOficio(String invRegSalidaOficio) {
        this.invRegSalidaOficio = invRegSalidaOficio;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaNumero(Integer tiaNumero) {
        this.tiaNumero = tiaNumero;
    }   

    public Integer getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(Integer invEstado) {
        this.invEstado = invEstado;
    }

    public void setInvNroDocFormalizacion(String invNroDocFormalizacion) {
        this.invNroDocFormalizacion = invNroDocFormalizacion;
    }

    public String getInvNroDocFormalizacion() {
        return invNroDocFormalizacion;
    }

    public void setInvFechaEmisionDocFomalizacion(Date invFechaEmisionDocFomalizacion) {
        this.invFechaEmisionDocFomalizacion = invFechaEmisionDocFomalizacion;
    }

    public Date getInvFechaEmisionDocFomalizacion() {
        return invFechaEmisionDocFomalizacion;
    }

    public Integer getInvIgv() {
        return invIgv;
    }

    public void setInvIgv(Integer invIgv) {
        this.invIgv = invIgv;
    }

    public void setInvNotaTipoCambio(String invNotaTipoCambio) {
        this.invNotaTipoCambio = invNotaTipoCambio;
    }

    public String getInvNotaTipoCambio() {
        return invNotaTipoCambio;
    }
}
