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
@NamedQueries({ @NamedQuery(name = "ContratoHito.findAll", query = "select o from ContratoHito o") })
@Table(name = "T_CONTRATO_HITO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_HITO"))
public class ContratoHito implements Serializable {
    private static final long serialVersionUID = 3483267862987759620L;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Temporal(TemporalType.DATE)
    @Column(name = "HTO_FECHA")
    private Date htoFecha;
    @Id
    @GeneratedValue(generator = "generator")    
    @Column(name = "HTO_ID", nullable = false)
    private Integer htoId;
    @Column(name = "HTO_MONTO", nullable = false)
    private BigDecimal htoMonto;
    @Column(name = "HTO_PDF")
    private String htoPdf;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "HTO_ESTADO")
    private Integer htoEstado;
    @Column(name = "HTO_NOMBRE")
    private String htoNombre;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "HTO_FECHA_ALTA", nullable = false)
    private Date htoFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "HTO_FECHA_BAJA")
    private Date htoFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "HTO_FECHA_CAMBIO")
    private Date htoFechaCambio;
    @Column(name = "HTO_USUARIO_ALTA", length = 20)
    private String htoUsuarioAlta;
    @Column(name = "HTO_USUARIO_BAJA", length = 20)
    private String htoUsuarioBaja;
    @Column(name = "HTO_USUARIO_CAMBIO", length = 20)
    private String htoUsuarioCambio;
    @Column(name = "HTO_TERMINAL", length = 20)
    private String htoTerminal;
    public ContratoHito() {
    }

    public ContratoHito(Integer conId, Date htoFecha, Integer htoId, BigDecimal htoMonto,
                        String htoPdf, Integer monId, Integer htoEstado, String htoNombre) {
        this.conId = conId;
        this.htoFecha = htoFecha;
        this.htoId = htoId;
        this.htoMonto = htoMonto;        
        this.htoPdf = htoPdf;
        this.monId = monId;
        this.htoEstado = htoEstado;
        this.htoNombre = htoNombre;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Date getHtoFecha() {
        return htoFecha;
    }

    public void setHtoFecha(Date htoFecha) {
        this.htoFecha = htoFecha;
    }

    public Integer getHtoId() {
        return htoId;
    }

    public void setHtoId(Integer htoId) {
        this.htoId = htoId;
    }

    public BigDecimal getHtoMonto() {
        return htoMonto;
    }

    public void setHtoMonto(BigDecimal htoMonto) {
        this.htoMonto = htoMonto;
    }

    public String getHtoPdf() {
        return htoPdf;
    }

    public void setHtoPdf(String htoPdf) {
        this.htoPdf = htoPdf;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getHtoEstado() {
        return htoEstado;
    }

    public void setHtoEstado(Integer htoEstado) {
        this.htoEstado = htoEstado;
    }

    public String getHtoNombre() {
        return htoNombre;
    }

    public void setHtoNombre(String htoNombre) {
        this.htoNombre = htoNombre;
    }

    public void setHtoFechaAlta(Date htoFechaAlta) {
        this.htoFechaAlta = htoFechaAlta;
    }

    public Date getHtoFechaAlta() {
        return htoFechaAlta;
    }

    public void setHtoFechaBaja(Date htoFechaBaja) {
        this.htoFechaBaja = htoFechaBaja;
    }

    public Date getHtoFechaBaja() {
        return htoFechaBaja;
    }

    public void setHtoFechaCambio(Date htoFechaCambio) {
        this.htoFechaCambio = htoFechaCambio;
    }

    public Date getHtoFechaCambio() {
        return htoFechaCambio;
    }

    public void setHtoUsuarioAlta(String htoUsuarioAlta) {
        this.htoUsuarioAlta = htoUsuarioAlta;
    }

    public String getHtoUsuarioAlta() {
        return htoUsuarioAlta;
    }

    public void setHtoUsuarioBaja(String htoUsuarioBaja) {
        this.htoUsuarioBaja = htoUsuarioBaja;
    }

    public String getHtoUsuarioBaja() {
        return htoUsuarioBaja;
    }

    public void setHtoUsuarioCambio(String htoUsuarioCambio) {
        this.htoUsuarioCambio = htoUsuarioCambio;
    }

    public String getHtoUsuarioCambio() {
        return htoUsuarioCambio;
    }

    public void setHtoTerminal(String htoTerminal) {
        this.htoTerminal = htoTerminal;
    }

    public String getHtoTerminal() {
        return htoTerminal;
    }
}
