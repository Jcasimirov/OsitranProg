package com.ositran.model;

import java.io.Serializable;



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
@NamedQueries({ @NamedQuery(name = "Concesion.findAll", query = "select o from Concesion o") })
@Table(name = "T_CONCESION")
public class Concesion implements Serializable {
    private static final long serialVersionUID = 4553963258432302939L;
    @Column(name = "CSI_ESTADO")
    private Integer csiEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CSI_FECHA_ALTA")
    private Date csiFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CSI_FECHA_BAJA")
    private Date csiFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CSI_FECHA_CAMBIO")
    private Date csiFechaCambio;
    @Id
    @Column(name = "CSI_ID", nullable = false)
    private Integer csiId;
    @Column(name = "CSI_NOMBRE", length = 50)
    private String csiNombre;
    @Column(name = "CSI_TERMINAL", length = 50)
    private String csiTerminal;
    @Column(name = "CSI_USUARIO_ALTA", length = 50)
    private String csiUsuarioAlta;
    @Column(name = "CSI_USUARIO_BAJA", length = 50)
    private String csiUsuarioBaja;
    @Column(name = "CSI_USUARIO_CAMBIO", length = 50)
    private String csiUsuarioCambio;
    @Column(name = "TIN_ID")
    private Integer tinId;

    public Concesion() {
    }

    public Concesion(Integer csiEstado, Date csiFechaAlta, Date csiFechaBaja, Date csiFechaCambio, Integer csiId,
                     String csiNombre, String csiTerminal, String csiUsuarioAlta, String csiUsuarioBaja,
                     String csiUsuarioCambio, Integer tinId) {
        this.csiEstado = csiEstado;
        this.csiFechaAlta = csiFechaAlta;
        this.csiFechaBaja = csiFechaBaja;
        this.csiFechaCambio = csiFechaCambio;
        this.csiId = csiId;
        this.csiNombre = csiNombre;
        this.csiTerminal = csiTerminal;
        this.csiUsuarioAlta = csiUsuarioAlta;
        this.csiUsuarioBaja = csiUsuarioBaja;
        this.csiUsuarioCambio = csiUsuarioCambio;
        this.tinId = tinId;
    }

    public Integer getCsiEstado() {
        return csiEstado;
    }

    public void setCsiEstado(Integer csiEstado) {
        this.csiEstado = csiEstado;
    }

    public Date getCsiFechaAlta() {
        return csiFechaAlta;
    }

    public void setCsiFechaAlta(Date csiFechaAlta) {
        this.csiFechaAlta = csiFechaAlta;
    }

    public Date getCsiFechaBaja() {
        return csiFechaBaja;
    }

    public void setCsiFechaBaja(Date csiFechaBaja) {
        this.csiFechaBaja = csiFechaBaja;
    }

    public Date getCsiFechaCambio() {
        return csiFechaCambio;
    }

    public void setCsiFechaCambio(Date csiFechaCambio) {
        this.csiFechaCambio = csiFechaCambio;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public String getCsiNombre() {
        return csiNombre;
    }

    public void setCsiNombre(String csiNombre) {
        this.csiNombre = csiNombre;
    }

    public String getCsiTerminal() {
        return csiTerminal;
    }

    public void setCsiTerminal(String csiTerminal) {
        this.csiTerminal = csiTerminal;
    }

    public String getCsiUsuarioAlta() {
        return csiUsuarioAlta;
    }

    public void setCsiUsuarioAlta(String csiUsuarioAlta) {
        this.csiUsuarioAlta = csiUsuarioAlta;
    }

    public String getCsiUsuarioBaja() {
        return csiUsuarioBaja;
    }

    public void setCsiUsuarioBaja(String csiUsuarioBaja) {
        this.csiUsuarioBaja = csiUsuarioBaja;
    }

    public String getCsiUsuarioCambio() {
        return csiUsuarioCambio;
    }

    public void setCsiUsuarioCambio(String csiUsuarioCambio) {
        this.csiUsuarioCambio = csiUsuarioCambio;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }
}
