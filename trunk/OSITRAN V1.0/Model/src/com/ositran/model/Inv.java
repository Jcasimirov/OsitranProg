package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
    @GeneratedValue(generator = "generator")
    @Column(name = "INV_ID", nullable = false)
    private Integer invId;
    @Column(name = "INV_MONTO_TIPO_CAMBIO", nullable = false)
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
    @Column(name = "MONEDA_ID", nullable = false)
    private Integer monId;
    @Column(name = "ITR_ID")
    private Integer itrId;
    //@Id
    @Column(name = "TIA_NUMERO", nullable = false)
    private Integer tiaNumero;
    @Column(name = "TIV_ID")
    private Integer tivId;
    @Column(name = "INV_ESTADO") 
    private Integer invEstado;

    public Inv() {
    }

    public Inv(Integer invEstadoReconocimiento, Date invFechaEmisionInforme, Date invFechaEmisionOficio,
               Integer invId, BigDecimal invMontoTipoCambio, BigDecimal invMontoTotalAprobado, BigDecimal invMontoTotalReajuste,
               String invNota, String invNumeroInforme, String invNumeroOficio, String invObservaciones,
               String invRegSalidaInforme, String invRegSalidaOficio, Integer Monid, Integer itrId,
               Integer tiaNumero, Integer tivId, Integer invEstado) {
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
        this.itrId = itrId;
        this.tiaNumero = tiaNumero;
        this.tivId = tivId;
        this.invEstado = invEstado;
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

    public Integer getItrId() {
        return itrId;
    }

    public void setItrId(Integer itrId) {
        this.itrId = itrId;
    }

    public Integer getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaNumero(Integer tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public Integer getTivId() {
        return tivId;
    }

    public void setTivId(Integer tivId) {
        this.tivId = tivId;
    }

    public Integer getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(Integer invEstado) {
        this.invEstado = invEstado;
    }
}
