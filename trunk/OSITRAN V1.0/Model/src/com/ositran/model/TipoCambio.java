package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "TipoCambio.findAll", query = "select o from TipoCambio o") })
@Table(name = "T_TIPO_CAMBIO")
@IdClass(TipoCambioPK.class)
public class TipoCambio implements Serializable {
    private static final long serialVersionUID = 4606476381038845547L;
    @Id
    @Column(name = "MON_ID", nullable = false)
    private BigDecimal monId;
    @Column(name = "TDC_ESTADO", nullable = false)
    private BigDecimal tdcEstado;
    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "TDC_FECHA", nullable = false)
    private Date tdcFecha;
    @Temporal(TemporalType.DATE)
    @Column(name = "TDC_FECHA_ALTA")
    private Date tdcFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "TDC_FECHA_BAJA")
    private Date tdcFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "TDC_FECHA_CAMBIO")
    private Date tdcFechaCambio;
    @Column(name = "TDC_IMPORTE_COMPRA")
    private Long tdcImporteCompra;
    @Column(name = "TDC_IMPORTE_VENTA", nullable = false)
    private Long tdcImporteVenta;
    @Column(name = "TDC_TERMINAL", length = 20)
    private String tdcTerminal;
    @Column(name = "TDC_USUARIO_ALTA", length = 20)
    private String tdcUsuarioAlta;
    @Column(name = "TDC_USUARIO_BAJA", length = 20)
    private String tdcUsuarioBaja;
    @Column(name = "TDC_USUARIO_CAMBIO", length = 20)
    private String tdcUsuarioCambio;

    public TipoCambio() {
    }

    public TipoCambio(BigDecimal monId, BigDecimal tdcEstado, Date tdcFecha, Date tdcFechaAlta, Date tdcFechaBaja,
                      Date tdcFechaCambio, Long tdcImporteCompra, Long tdcImporteVenta, String tdcTerminal,
                      String tdcUsuarioAlta, String tdcUsuarioBaja, String tdcUsuarioCambio) {
        this.monId = monId;
        this.tdcEstado = tdcEstado;
        this.tdcFecha = tdcFecha;
        this.tdcFechaAlta = tdcFechaAlta;
        this.tdcFechaBaja = tdcFechaBaja;
        this.tdcFechaCambio = tdcFechaCambio;
        this.tdcImporteCompra = tdcImporteCompra;
        this.tdcImporteVenta = tdcImporteVenta;
        this.tdcTerminal = tdcTerminal;
        this.tdcUsuarioAlta = tdcUsuarioAlta;
        this.tdcUsuarioBaja = tdcUsuarioBaja;
        this.tdcUsuarioCambio = tdcUsuarioCambio;
    }

    public BigDecimal getMonId() {
        return monId;
    }

    public void setMonId(BigDecimal monId) {
        this.monId = monId;
    }

    public BigDecimal getTdcEstado() {
        return tdcEstado;
    }

    public void setTdcEstado(BigDecimal tdcEstado) {
        this.tdcEstado = tdcEstado;
    }

    public Date getTdcFecha() {
        return tdcFecha;
    }

    public void setTdcFecha(Date tdcFecha) {
        this.tdcFecha = tdcFecha;
    }

    public Date getTdcFechaAlta() {
        return tdcFechaAlta;
    }

    public void setTdcFechaAlta(Date tdcFechaAlta) {
        this.tdcFechaAlta = tdcFechaAlta;
    }

    public Date getTdcFechaBaja() {
        return tdcFechaBaja;
    }

    public void setTdcFechaBaja(Date tdcFechaBaja) {
        this.tdcFechaBaja = tdcFechaBaja;
    }

    public Date getTdcFechaCambio() {
        return tdcFechaCambio;
    }

    public void setTdcFechaCambio(Date tdcFechaCambio) {
        this.tdcFechaCambio = tdcFechaCambio;
    }

    public Long getTdcImporteCompra() {
        return tdcImporteCompra;
    }

    public void setTdcImporteCompra(Long tdcImporteCompra) {
        this.tdcImporteCompra = tdcImporteCompra;
    }

    public Long getTdcImporteVenta() {
        return tdcImporteVenta;
    }

    public void setTdcImporteVenta(Long tdcImporteVenta) {
        this.tdcImporteVenta = tdcImporteVenta;
    }

    public String getTdcTerminal() {
        return tdcTerminal;
    }

    public void setTdcTerminal(String tdcTerminal) {
        this.tdcTerminal = tdcTerminal;
    }

    public String getTdcUsuarioAlta() {
        return tdcUsuarioAlta;
    }

    public void setTdcUsuarioAlta(String tdcUsuarioAlta) {
        this.tdcUsuarioAlta = tdcUsuarioAlta;
    }

    public String getTdcUsuarioBaja() {
        return tdcUsuarioBaja;
    }

    public void setTdcUsuarioBaja(String tdcUsuarioBaja) {
        this.tdcUsuarioBaja = tdcUsuarioBaja;
    }

    public String getTdcUsuarioCambio() {
        return tdcUsuarioCambio;
    }

    public void setTdcUsuarioCambio(String tdcUsuarioCambio) {
        this.tdcUsuarioCambio = tdcUsuarioCambio;
    }
}
