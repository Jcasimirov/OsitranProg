package com.ositran.model;

import java.io.Serializable;

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
@NamedQueries({ @NamedQuery(name = "ContratoInversion.findAll", query = "select o from ContratoInversion o") })
@Table(name = "T_CONTRATO_INVERSION")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_INVERSION"))
public class ContratoInversion implements Serializable {
    private static final long serialVersionUID = 5582300002098147769L;
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "INV_DESCRIPCION", nullable = false, length = 100)
    private String invDescripcion;
    @Id
    @GeneratedValue(generator = "generator") 
    @Column(name = "INV_ID", nullable = false)
    private Integer invId;
    @Column(name = "TIN_ID")
    private Integer tinId;
    @Column(name = "INV_ESTADO")
    private Integer invEstado;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_ALTA")
    private Date invFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_BAJA")
    private Date invFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_CAMBIO")
    private Date invFechaCambio;
    @Column(name = "INV_USUARIO_ALTA", length = 20)
    private String invUsuarioAlta;
    @Column(name = "INV_USUARIO_BAJA", length = 20)
    private String invUsuarioBaja;
    @Column(name = "INV_USUARIO_CAMBIO", length = 20)
    private String invUsuarioCambio;
    @Column(name = "INV_TERMINAL", length = 20)
    private String invTerminal;
    public ContratoInversion() {
    }

    public ContratoInversion(Integer conId, Integer csiId, Integer infId, String invDescripcion,
                             Integer invId, Integer tinId, Integer invEstado) {
        this.conId = conId;
        this.csiId = csiId;
        this.infId = infId;
        this.invDescripcion = invDescripcion;
        this.invId = invId;
        this.tinId = tinId;
        this.invEstado = invEstado;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public String getInvDescripcion() {
        return invDescripcion;
    }

    public void setInvDescripcion(String invDescripcion) {
        this.invDescripcion = invDescripcion;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(Integer invEstado) {
        this.invEstado = invEstado;
    }

    public void setInvFechaAlta(Date invFechaAlta) {
        this.invFechaAlta = invFechaAlta;
    }

    public Date getInvFechaAlta() {
        return invFechaAlta;
    }

    public void setInvFechaBaja(Date invFechaBaja) {
        this.invFechaBaja = invFechaBaja;
    }

    public Date getInvFechaBaja() {
        return invFechaBaja;
    }

    public void setInvFechaCambio(Date invFechaCambio) {
        this.invFechaCambio = invFechaCambio;
    }

    public Date getInvFechaCambio() {
        return invFechaCambio;
    }

    public void setInvUsuarioAlta(String invUsuarioAlta) {
        this.invUsuarioAlta = invUsuarioAlta;
    }

    public String getInvUsuarioAlta() {
        return invUsuarioAlta;
    }

    public void setInvUsuarioBaja(String invUsuarioBaja) {
        this.invUsuarioBaja = invUsuarioBaja;
    }

    public String getInvUsuarioBaja() {
        return invUsuarioBaja;
    }

    public void setInvUsuarioCambio(String invUsuarioCambio) {
        this.invUsuarioCambio = invUsuarioCambio;
    }

    public String getInvUsuarioCambio() {
        return invUsuarioCambio;
    }

    public void setInvTerminal(String invTerminal) {
        this.invTerminal = invTerminal;
    }

    public String getInvTerminal() {
        return invTerminal;
    }
}
