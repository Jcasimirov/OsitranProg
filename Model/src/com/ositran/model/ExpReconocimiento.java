package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "ExpReconocimiento.findAll", query = "select o from ExpReconocimiento o") })
@Table(name = "T_EXP_RECONOCIMIENTO")
public class ExpReconocimiento implements Serializable {
    private static final long serialVersionUID = -2516407756338396698L;
    @Column(name = "ERC_CONCEPTO")
    private Long ercConcepto;
    @Column(name = "ERC_ESTADO", nullable = false)
    private BigDecimal ercEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "ERC_FECHA_ALTA")
    private Date ercFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "ERC_FECHA_BAJA")
    private Date ercFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "ERC_FECHA_CAMBIO")
    private Date ercFechaCambio;
    @Column(name = "ERC_PORCENTAJE_AMORTIZACION")
    private Long ercPorcentajeAmortizacion;
    @Id
    @Column(name = "ERC_STD", nullable = false, length = 20)
    private String ercStd;
    @Column(name = "ERC_TERMINAL", length = 20)
    private String ercTerminal;
    @Column(name = "ERC_USUARIO_ALTA", length = 20)
    private String ercUsuarioAlta;
    @Column(name = "ERC_USUARIO_BAJA", length = 20)
    private String ercUsuarioBaja;
    @Column(name = "ERC_USUARIO_CAMBIO", length = 20)
    private String ercUsuarioCambio;
    @Column(name = "ERC_VALOR_BRUTO")
    private Long ercValorBruto;
    @Column(name = "ERC_VALOR_IGV")
    private Long ercValorIgv;
    @Column(name = "ERC_VALOR_TOTAL")
    private Long ercValorTotal;
    @Column(name = "ERC_VALOR_TOTAL_EXPEDIENTE")
    private Long ercValorTotalExpediente;
    @Column(length = 20)
    private String igv;
    @Column(name = "IMP_ID")
    private BigDecimal impId;
    @Column(name = "MON_ID")
    private BigDecimal monId;

    public ExpReconocimiento() {
    }

    public ExpReconocimiento(Long ercConcepto, BigDecimal ercEstado, Date ercFechaAlta, Date ercFechaBaja,
                             Date ercFechaCambio, Long ercPorcentajeAmortizacion, String ercStd, String ercTerminal,
                             String ercUsuarioAlta, String ercUsuarioBaja, String ercUsuarioCambio, Long ercValorBruto,
                             Long ercValorIgv, Long ercValorTotal, Long ercValorTotalExpediente, String igv,
                             BigDecimal impId, BigDecimal monId) {
        this.ercConcepto = ercConcepto;
        this.ercEstado = ercEstado;
        this.ercFechaAlta = ercFechaAlta;
        this.ercFechaBaja = ercFechaBaja;
        this.ercFechaCambio = ercFechaCambio;
        this.ercPorcentajeAmortizacion = ercPorcentajeAmortizacion;
        this.ercStd = ercStd;
        this.ercTerminal = ercTerminal;
        this.ercUsuarioAlta = ercUsuarioAlta;
        this.ercUsuarioBaja = ercUsuarioBaja;
        this.ercUsuarioCambio = ercUsuarioCambio;
        this.ercValorBruto = ercValorBruto;
        this.ercValorIgv = ercValorIgv;
        this.ercValorTotal = ercValorTotal;
        this.ercValorTotalExpediente = ercValorTotalExpediente;
        this.igv = igv;
        this.impId = impId;
        this.monId = monId;
    }

    public Long getErcConcepto() {
        return ercConcepto;
    }

    public void setErcConcepto(Long ercConcepto) {
        this.ercConcepto = ercConcepto;
    }

    public BigDecimal getErcEstado() {
        return ercEstado;
    }

    public void setErcEstado(BigDecimal ercEstado) {
        this.ercEstado = ercEstado;
    }

    public Date getErcFechaAlta() {
        return ercFechaAlta;
    }

    public void setErcFechaAlta(Date ercFechaAlta) {
        this.ercFechaAlta = ercFechaAlta;
    }

    public Date getErcFechaBaja() {
        return ercFechaBaja;
    }

    public void setErcFechaBaja(Date ercFechaBaja) {
        this.ercFechaBaja = ercFechaBaja;
    }

    public Date getErcFechaCambio() {
        return ercFechaCambio;
    }

    public void setErcFechaCambio(Date ercFechaCambio) {
        this.ercFechaCambio = ercFechaCambio;
    }

    public Long getErcPorcentajeAmortizacion() {
        return ercPorcentajeAmortizacion;
    }

    public void setErcPorcentajeAmortizacion(Long ercPorcentajeAmortizacion) {
        this.ercPorcentajeAmortizacion = ercPorcentajeAmortizacion;
    }

    public String getErcStd() {
        return ercStd;
    }

    public void setErcStd(String ercStd) {
        this.ercStd = ercStd;
    }

    public String getErcTerminal() {
        return ercTerminal;
    }

    public void setErcTerminal(String ercTerminal) {
        this.ercTerminal = ercTerminal;
    }

    public String getErcUsuarioAlta() {
        return ercUsuarioAlta;
    }

    public void setErcUsuarioAlta(String ercUsuarioAlta) {
        this.ercUsuarioAlta = ercUsuarioAlta;
    }

    public String getErcUsuarioBaja() {
        return ercUsuarioBaja;
    }

    public void setErcUsuarioBaja(String ercUsuarioBaja) {
        this.ercUsuarioBaja = ercUsuarioBaja;
    }

    public String getErcUsuarioCambio() {
        return ercUsuarioCambio;
    }

    public void setErcUsuarioCambio(String ercUsuarioCambio) {
        this.ercUsuarioCambio = ercUsuarioCambio;
    }

    public Long getErcValorBruto() {
        return ercValorBruto;
    }

    public void setErcValorBruto(Long ercValorBruto) {
        this.ercValorBruto = ercValorBruto;
    }

    public Long getErcValorIgv() {
        return ercValorIgv;
    }

    public void setErcValorIgv(Long ercValorIgv) {
        this.ercValorIgv = ercValorIgv;
    }

    public Long getErcValorTotal() {
        return ercValorTotal;
    }

    public void setErcValorTotal(Long ercValorTotal) {
        this.ercValorTotal = ercValorTotal;
    }

    public Long getErcValorTotalExpediente() {
        return ercValorTotalExpediente;
    }

    public void setErcValorTotalExpediente(Long ercValorTotalExpediente) {
        this.ercValorTotalExpediente = ercValorTotalExpediente;
    }

    public String getIgv() {
        return igv;
    }

    public void setIgv(String igv) {
        this.igv = igv;
    }

    public BigDecimal getImpId() {
        return impId;
    }

    public void setImpId(BigDecimal impId) {
        this.impId = impId;
    }

    public BigDecimal getMonId() {
        return monId;
    }

    public void setMonId(BigDecimal monId) {
        this.monId = monId;
    }
}
