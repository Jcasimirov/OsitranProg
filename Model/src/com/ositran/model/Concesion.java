package com.ositran.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Concesion.findAll", query = "select o from Concesion o") })
@Table(name = "T_CONCESION")
@SequenceGenerator(name = "SEQ_CONCESION", sequenceName = "SEQ_CONCESION", allocationSize = 50,
                   initialValue = 50)
public class Concesion implements Serializable {
    @Temporal(TemporalType.DATE)
    @Column(name = "TCO_FECHA_ALTA")
    private Date tcoFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "TCO_FECHA_BAJA")
    private Date tcoFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "TCO_FECHA_CAMBIO")
    private Date tcoFechaCambio;
    @Id
    @Column(name = "TCO_ID", nullable = false)
    private Integer tcoId;
    @Column(name = "TCO_NOMBRE", length = 50)
    private String tcoNombre;
    @Column(name = "TCO_TERMINAL", length = 50)
    private String tcoTerminal;
    @Column(name = "TCO_USUARIO_ALTA", length = 50)
    private String tcoUsuarioAlta;
    @Column(name = "TCO_USUARIO_BAJA", length = 50)
    private String tcoUsuarioBaja;
    @Column(name = "TCO_USUARIO_CAMBIO", length = 50)
    private String tcoUsuarioCambio;
    @Column(name = "TIN_ID")
    private Integer tinId;

    public Concesion() {
    }

    public Concesion(Date tcoFechaAlta, Date tcoFechaBaja, Date tcoFechaCambio, Integer tcoId, String tcoNombre,
                     String tcoTerminal, String tcoUsuarioAlta, String tcoUsuarioBaja, String tcoUsuarioCambio,
                     Integer tinId) {
        this.tcoFechaAlta = tcoFechaAlta;
        this.tcoFechaBaja = tcoFechaBaja;
        this.tcoFechaCambio = tcoFechaCambio;
        this.tcoId = tcoId;
        this.tcoNombre = tcoNombre;
        this.tcoTerminal = tcoTerminal;
        this.tcoUsuarioAlta = tcoUsuarioAlta;
        this.tcoUsuarioBaja = tcoUsuarioBaja;
        this.tcoUsuarioCambio = tcoUsuarioCambio;
        this.tinId = tinId;
    }


    public Date getTcoFechaAlta() {
        return tcoFechaAlta;
    }

    public void setTcoFechaAlta(Date tcoFechaAlta) {
        this.tcoFechaAlta = tcoFechaAlta;
    }

    public Date getTcoFechaBaja() {
        return tcoFechaBaja;
    }

    public void setTcoFechaBaja(Date tcoFechaBaja) {
        this.tcoFechaBaja = tcoFechaBaja;
    }

    public Date getTcoFechaCambio() {
        return tcoFechaCambio;
    }

    public void setTcoFechaCambio(Date tcoFechaCambio) {
        this.tcoFechaCambio = tcoFechaCambio;
    }

    public Integer getTcoId() {
        return tcoId;
    }

    public void setTcoId(Integer tcoId) {
        this.tcoId = tcoId;
    }

    public String getTcoNombre() {
        return tcoNombre;
    }

    public void setTcoNombre(String tcoNombre) {
        this.tcoNombre = tcoNombre;
    }

    public String getTcoTerminal() {
        return tcoTerminal;
    }

    public void setTcoTerminal(String tcoTerminal) {
        this.tcoTerminal = tcoTerminal;
    }

    public String getTcoUsuarioAlta() {
        return tcoUsuarioAlta;
    }

    public void setTcoUsuarioAlta(String tcoUsuarioAlta) {
        this.tcoUsuarioAlta = tcoUsuarioAlta;
    }

    public String getTcoUsuarioBaja() {
        return tcoUsuarioBaja;
    }

    public void setTcoUsuarioBaja(String tcoUsuarioBaja) {
        this.tcoUsuarioBaja = tcoUsuarioBaja;
    }

    public String getTcoUsuarioCambio() {
        return tcoUsuarioCambio;
    }

    public void setTcoUsuarioCambio(String tcoUsuarioCambio) {
        this.tcoUsuarioCambio = tcoUsuarioCambio;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }
}
