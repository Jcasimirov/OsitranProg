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
@NamedQueries({ @NamedQuery(name = "Inversion.findAll", query = "select o from Inversion o") })
@Table(name = "T_INVERSION")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_INVERSION"))
public class Inversion implements Serializable {
    private static final long serialVersionUID = 4950860685481990821L;
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "INV_DESCRIPCION", nullable = false, length = 100)
    private String invDescripcion;
    @Column(name = "INV_ESTADO", nullable = false)
    private Integer invEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_ALTA", nullable = false)
    private Date invFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_BAJA")
    private Date invFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "INV_FECHA_CAMBIO")
    private Date invFechaCambio;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "INV_ID", nullable = false)
    private Integer invId;
    @Column(name = "INV_NOMBRE", nullable = false, length = 100)
    private String invNombre;
    @Column(name = "INV_TERMINAL", length = 20)
    private String invTerminal;
    @Column(name = "INV_USUARIO_ALTA", length = 20)
    private String invUsuarioAlta;
    @Column(name = "INV_USUARIO_BAJA", length = 20)
    private String invUsuarioBaja;
    @Column(name = "INV_USUARIO_CAMBIO", length = 20)
    private String invUsuarioCambio;
    @Column(name = "SUP_ID")
    private Integer supId;

    public Inversion() {
    }

    public Inversion(Integer infId, String invDescripcion, Integer invEstado, Date invFechaAlta,
                     Date invFechaBaja, Date invFechaCambio, Integer invId, String invNombre, String invTerminal,
                     String invUsuarioAlta, String invUsuarioBaja, String invUsuarioCambio, Integer supId) {
        this.infId = infId;
        this.invDescripcion = invDescripcion;
        this.invEstado = invEstado;
        this.invFechaAlta = invFechaAlta;
        this.invFechaBaja = invFechaBaja;
        this.invFechaCambio = invFechaCambio;
        this.invId = invId;
        this.invNombre = invNombre;
        this.invTerminal = invTerminal;
        this.invUsuarioAlta = invUsuarioAlta;
        this.invUsuarioBaja = invUsuarioBaja;
        this.invUsuarioCambio = invUsuarioCambio;
        this.supId = supId;
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

    public Integer getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(Integer invEstado) {
        this.invEstado = invEstado;
    }

    public Date getInvFechaAlta() {
        return invFechaAlta;
    }

    public void setInvFechaAlta(Date invFechaAlta) {
        this.invFechaAlta = invFechaAlta;
    }

    public Date getInvFechaBaja() {
        return invFechaBaja;
    }

    public void setInvFechaBaja(Date invFechaBaja) {
        this.invFechaBaja = invFechaBaja;
    }

    public Date getInvFechaCambio() {
        return invFechaCambio;
    }

    public void setInvFechaCambio(Date invFechaCambio) {
        this.invFechaCambio = invFechaCambio;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public String getInvNombre() {
        return invNombre;
    }

    public void setInvNombre(String invNombre) {
        this.invNombre = invNombre;
    }

    public String getInvTerminal() {
        return invTerminal;
    }

    public void setInvTerminal(String invTerminal) {
        this.invTerminal = invTerminal;
    }

    public String getInvUsuarioAlta() {
        return invUsuarioAlta;
    }

    public void setInvUsuarioAlta(String invUsuarioAlta) {
        this.invUsuarioAlta = invUsuarioAlta;
    }

    public String getInvUsuarioBaja() {
        return invUsuarioBaja;
    }

    public void setInvUsuarioBaja(String invUsuarioBaja) {
        this.invUsuarioBaja = invUsuarioBaja;
    }

    public String getInvUsuarioCambio() {
        return invUsuarioCambio;
    }

    public void setInvUsuarioCambio(String invUsuarioCambio) {
        this.invUsuarioCambio = invUsuarioCambio;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }
}
