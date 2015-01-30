package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "T_MONEDA_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_MONEDA_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Moneda.findAll", query = "select o from Moneda o") })
@Table(name = "T_MONEDA")
@SequenceGenerator(name = "Moneda_Id_Seq_Gen", sequenceName = "T_MONEDA_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Moneda implements Serializable {
    private static final long serialVersionUID = 1183645929031299392L;
    @Column(name = "MON_ESTADO", nullable = false)
    private BigDecimal monEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "MON_FECHA_ALTA")
    private Date monFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "MON_FECHA_BAJA")
    private Date monFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "MON_FECHA_CAMBIO")
    private Date monFechaCambio;
    @Id
    @Column(name = "MON_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Moneda_Id_Seq_Gen")
    private BigDecimal monId;
    @Column(name = "MON_NOMBRE", nullable = false, length = 50)
    private String monNombre;
    @Column(name = "MON_SIMBOLO", length = 3)
    private String monSimbolo;
    @Column(name = "MON_TERMINAL", length = 20)
    private String monTerminal;
    @Column(name = "MON_USUARIO_ALTA", length = 20)
    private String monUsuarioAlta;
    @Column(name = "MON_USUARIO_BAJA", length = 20)
    private String monUsuarioBaja;
    @Column(name = "MON_USUARIO_CAMBIO", length = 20)
    private String monUsuarioCambio;
    @OneToMany(mappedBy = "TMoneda", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<TipoCambio> TTipoCambioList;
    @OneToMany(mappedBy = "TMoneda1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Contrato> TContratoList1;
    @OneToMany(mappedBy = "TMoneda2", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ExpReconocimientoDetalle> TExpReconocimientoDetalleList;

    public Moneda() {
    }

    public Moneda(BigDecimal monEstado, Date monFechaAlta, Date monFechaBaja, Date monFechaCambio, BigDecimal monId,
                  String monNombre, String monSimbolo, String monTerminal, String monUsuarioAlta, String monUsuarioBaja,
                  String monUsuarioCambio) {
        this.monEstado = monEstado;
        this.monFechaAlta = monFechaAlta;
        this.monFechaBaja = monFechaBaja;
        this.monFechaCambio = monFechaCambio;
        this.monId = monId;
        this.monNombre = monNombre;
        this.monSimbolo = monSimbolo;
        this.monTerminal = monTerminal;
        this.monUsuarioAlta = monUsuarioAlta;
        this.monUsuarioBaja = monUsuarioBaja;
        this.monUsuarioCambio = monUsuarioCambio;
    }

    public BigDecimal getMonEstado() {
        return monEstado;
    }

    public void setMonEstado(BigDecimal monEstado) {
        this.monEstado = monEstado;
    }

    public Date getMonFechaAlta() {
        return monFechaAlta;
    }

    public void setMonFechaAlta(Date monFechaAlta) {
        this.monFechaAlta = monFechaAlta;
    }

    public Date getMonFechaBaja() {
        return monFechaBaja;
    }

    public void setMonFechaBaja(Date monFechaBaja) {
        this.monFechaBaja = monFechaBaja;
    }

    public Date getMonFechaCambio() {
        return monFechaCambio;
    }

    public void setMonFechaCambio(Date monFechaCambio) {
        this.monFechaCambio = monFechaCambio;
    }

    public BigDecimal getMonId() {
        return monId;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public String getMonSimbolo() {
        return monSimbolo;
    }

    public void setMonSimbolo(String monSimbolo) {
        this.monSimbolo = monSimbolo;
    }

    public String getMonTerminal() {
        return monTerminal;
    }

    public void setMonTerminal(String monTerminal) {
        this.monTerminal = monTerminal;
    }

    public String getMonUsuarioAlta() {
        return monUsuarioAlta;
    }

    public void setMonUsuarioAlta(String monUsuarioAlta) {
        this.monUsuarioAlta = monUsuarioAlta;
    }

    public String getMonUsuarioBaja() {
        return monUsuarioBaja;
    }

    public void setMonUsuarioBaja(String monUsuarioBaja) {
        this.monUsuarioBaja = monUsuarioBaja;
    }

    public String getMonUsuarioCambio() {
        return monUsuarioCambio;
    }

    public void setMonUsuarioCambio(String monUsuarioCambio) {
        this.monUsuarioCambio = monUsuarioCambio;
    }

    public List<TipoCambio> getTTipoCambioList() {
        return TTipoCambioList;
    }

    public void setTTipoCambioList(List<TipoCambio> TTipoCambioList) {
        this.TTipoCambioList = TTipoCambioList;
    }

    public TipoCambio addTipoCambio(TipoCambio tipoCambio) {
        getTTipoCambioList().add(tipoCambio);
        tipoCambio.setTMoneda(this);
        return tipoCambio;
    }

    public TipoCambio removeTipoCambio(TipoCambio tipoCambio) {
        getTTipoCambioList().remove(tipoCambio);
        tipoCambio.setTMoneda(null);
        return tipoCambio;
    }

    public List<Contrato> getTContratoList1() {
        return TContratoList1;
    }

    public void setTContratoList1(List<Contrato> TContratoList1) {
        this.TContratoList1 = TContratoList1;
    }

    public Contrato addContrato(Contrato contrato) {
        getTContratoList1().add(contrato);
        contrato.setTMoneda1(this);
        return contrato;
    }

    public Contrato removeContrato(Contrato contrato) {
        getTContratoList1().remove(contrato);
        contrato.setTMoneda1(null);
        return contrato;
    }

    public List<ExpReconocimientoDetalle> getTExpReconocimientoDetalleList() {
        return TExpReconocimientoDetalleList;
    }

    public void setTExpReconocimientoDetalleList(List<ExpReconocimientoDetalle> TExpReconocimientoDetalleList) {
        this.TExpReconocimientoDetalleList = TExpReconocimientoDetalleList;
    }

    public ExpReconocimientoDetalle addExpReconocimientoDetalle(ExpReconocimientoDetalle expReconocimientoDetalle) {
        getTExpReconocimientoDetalleList().add(expReconocimientoDetalle);
        expReconocimientoDetalle.setTMoneda2(this);
        return expReconocimientoDetalle;
    }

    public ExpReconocimientoDetalle removeExpReconocimientoDetalle(ExpReconocimientoDetalle expReconocimientoDetalle) {
        getTExpReconocimientoDetalleList().remove(expReconocimientoDetalle);
        expReconocimientoDetalle.setTMoneda2(null);
        return expReconocimientoDetalle;
    }
}
