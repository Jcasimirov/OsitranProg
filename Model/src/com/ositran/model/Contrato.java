package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Contrato.findAll", query = "select o from Contrato o") })
@Table(name = "T_CONTRATO")
@IdClass(ContratoPK.class)
public class Contrato implements Serializable {
    private static final long serialVersionUID = -6903223429923833848L;
    @Column(name = "CON_CONCESION", nullable = false, length = 4000)
    private String conConcesion;
    @Column(name = "CON_ESTADO", nullable = false)
    private BigDecimal conEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_ALTA")
    private Date conFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_BAJA")
    private Date conFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_CAMBIO")
    private Date conFechaCambio;
    @Id
    @Column(name = "CON_ID", nullable = false)
    private BigDecimal conId;
    @Column(name = "CON_TERMINAL", length = 20)
    private String conTerminal;
    @Column(name = "CON_USUARIO_ALTA", length = 20)
    private String conUsuarioAlta;
    @Column(name = "CON_USUARIO_BAJA", length = 20)
    private String conUsuarioBaja;
    @Column(name = "CON_USUARIO_CAMBIO", length = 20)
    private String conUsuarioCambio;
    @Id
    @Column(name = "TIN_ID", nullable = false)
    private BigDecimal tinId;
    @Column(name = "TIV_ID")
    private BigDecimal tivId;
    @Column(name = "TOTAL_DE_LA_VALORIZACIÓN")
    private BigDecimal totalDeLaValorización;
    @ManyToOne
    @JoinColumn(name = "CNC_ID")
    private Concesionario TConcesionario;
    @OneToMany(mappedBy = "TContrato1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ContratoAnexo> TContratoAnexoList1;
    @OneToMany(mappedBy = "TContrato3", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ContratoValorizacion> TContratoValorizacionList2;
    @ManyToOne
    @JoinColumn(name = "MON_ID")
    private Moneda TMoneda1;
    @ManyToOne
    @JoinColumn(name = "MCO_ID")
    private ModalidadConcesion TModalidadConcesion;
    @OneToMany(mappedBy = "TContrato5", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ContratoAdenda> TContratoAdendaList1;

    public Contrato() {
    }

    public Contrato(Concesionario TConcesionario, String conConcesion, BigDecimal conEstado, Date conFechaAlta,
                    Date conFechaBaja, Date conFechaCambio, BigDecimal conId, String conTerminal, String conUsuarioAlta,
                    String conUsuarioBaja, String conUsuarioCambio, ModalidadConcesion TModalidadConcesion,
                    Moneda TMoneda1, BigDecimal tinId, BigDecimal tivId, BigDecimal totalDeLaValorización) {
        this.TConcesionario = TConcesionario;
        this.conConcesion = conConcesion;
        this.conEstado = conEstado;
        this.conFechaAlta = conFechaAlta;
        this.conFechaBaja = conFechaBaja;
        this.conFechaCambio = conFechaCambio;
        this.conId = conId;
        this.conTerminal = conTerminal;
        this.conUsuarioAlta = conUsuarioAlta;
        this.conUsuarioBaja = conUsuarioBaja;
        this.conUsuarioCambio = conUsuarioCambio;
        this.TModalidadConcesion = TModalidadConcesion;
        this.TMoneda1 = TMoneda1;
        this.tinId = tinId;
        this.tivId = tivId;
        this.totalDeLaValorización = totalDeLaValorización;
    }


    public String getConConcesion() {
        return conConcesion;
    }

    public void setConConcesion(String conConcesion) {
        this.conConcesion = conConcesion;
    }

    public BigDecimal getConEstado() {
        return conEstado;
    }

    public void setConEstado(BigDecimal conEstado) {
        this.conEstado = conEstado;
    }

    public Date getConFechaAlta() {
        return conFechaAlta;
    }

    public void setConFechaAlta(Date conFechaAlta) {
        this.conFechaAlta = conFechaAlta;
    }

    public Date getConFechaBaja() {
        return conFechaBaja;
    }

    public void setConFechaBaja(Date conFechaBaja) {
        this.conFechaBaja = conFechaBaja;
    }

    public Date getConFechaCambio() {
        return conFechaCambio;
    }

    public void setConFechaCambio(Date conFechaCambio) {
        this.conFechaCambio = conFechaCambio;
    }

    public BigDecimal getConId() {
        return conId;
    }

    public void setConId(BigDecimal conId) {
        this.conId = conId;
    }

    public String getConTerminal() {
        return conTerminal;
    }

    public void setConTerminal(String conTerminal) {
        this.conTerminal = conTerminal;
    }

    public String getConUsuarioAlta() {
        return conUsuarioAlta;
    }

    public void setConUsuarioAlta(String conUsuarioAlta) {
        this.conUsuarioAlta = conUsuarioAlta;
    }

    public String getConUsuarioBaja() {
        return conUsuarioBaja;
    }

    public void setConUsuarioBaja(String conUsuarioBaja) {
        this.conUsuarioBaja = conUsuarioBaja;
    }

    public String getConUsuarioCambio() {
        return conUsuarioCambio;
    }

    public void setConUsuarioCambio(String conUsuarioCambio) {
        this.conUsuarioCambio = conUsuarioCambio;
    }


    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }

    public BigDecimal getTivId() {
        return tivId;
    }

    public void setTivId(BigDecimal tivId) {
        this.tivId = tivId;
    }

    public BigDecimal getTotalDeLaValorización() {
        return totalDeLaValorización;
    }

    public void setTotalDeLaValorización(BigDecimal totalDeLaValorización) {
        this.totalDeLaValorización = totalDeLaValorización;
    }

    public Concesionario getTConcesionario() {
        return TConcesionario;
    }

    public void setTConcesionario(Concesionario TConcesionario) {
        this.TConcesionario = TConcesionario;
    }

    public List<ContratoAnexo> getTContratoAnexoList1() {
        return TContratoAnexoList1;
    }

    public void setTContratoAnexoList1(List<ContratoAnexo> TContratoAnexoList1) {
        this.TContratoAnexoList1 = TContratoAnexoList1;
    }

    public ContratoAnexo addContratoAnexo(ContratoAnexo contratoAnexo) {
        getTContratoAnexoList1().add(contratoAnexo);
        contratoAnexo.setTContrato1(this);
        return contratoAnexo;
    }

    public ContratoAnexo removeContratoAnexo(ContratoAnexo contratoAnexo) {
        getTContratoAnexoList1().remove(contratoAnexo);
        contratoAnexo.setTContrato1(null);
        return contratoAnexo;
    }

    public List<ContratoValorizacion> getTContratoValorizacionList2() {
        return TContratoValorizacionList2;
    }

    public void setTContratoValorizacionList2(List<ContratoValorizacion> TContratoValorizacionList2) {
        this.TContratoValorizacionList2 = TContratoValorizacionList2;
    }

    public ContratoValorizacion addContratoValorizacion(ContratoValorizacion contratoValorizacion) {
        getTContratoValorizacionList2().add(contratoValorizacion);
        contratoValorizacion.setTContrato3(this);
        return contratoValorizacion;
    }

    public ContratoValorizacion removeContratoValorizacion(ContratoValorizacion contratoValorizacion) {
        getTContratoValorizacionList2().remove(contratoValorizacion);
        contratoValorizacion.setTContrato3(null);
        return contratoValorizacion;
    }

    public Moneda getTMoneda1() {
        return TMoneda1;
    }

    public void setTMoneda1(Moneda TMoneda1) {
        this.TMoneda1 = TMoneda1;
    }

    public ModalidadConcesion getTModalidadConcesion() {
        return TModalidadConcesion;
    }

    public void setTModalidadConcesion(ModalidadConcesion TModalidadConcesion) {
        this.TModalidadConcesion = TModalidadConcesion;
    }

    public List<ContratoAdenda> getTContratoAdendaList1() {
        return TContratoAdendaList1;
    }

    public void setTContratoAdendaList1(List<ContratoAdenda> TContratoAdendaList1) {
        this.TContratoAdendaList1 = TContratoAdendaList1;
    }

    public ContratoAdenda addContratoAdenda(ContratoAdenda contratoAdenda) {
        getTContratoAdendaList1().add(contratoAdenda);
        contratoAdenda.setTContrato5(this);
        return contratoAdenda;
    }

    public ContratoAdenda removeContratoAdenda(ContratoAdenda contratoAdenda) {
        getTContratoAdendaList1().remove(contratoAdenda);
        contratoAdenda.setTContrato5(null);
        return contratoAdenda;
    }
}
