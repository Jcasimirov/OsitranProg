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
@NamedQueries({ @NamedQuery(name = "Concesion.findAll", query = "select o from Concesion o") })
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_CONCESION"))

@Table(name = "T_CONCESION")


public class Concesion implements Serializable {
    private static final long serialVersionUID = 4553963258432302939L;
    @Column(name = "CSI_ESTADO", nullable = false)
    private int csiEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CSI_FECHA_ALTA", nullable = false)
    private Date csiFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CSI_FECHA_BAJA")
    private Date csiFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CSI_FECHA_CAMBIO")
    private Date csiFechaCambio;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CSI_ID", nullable = false)
    private int csiId;
    @Column(name = "CSI_NOMBRE", nullable = false, length = 50)
    private String csiNombre;
    @Column(name = "CSI_TERMINAL", length = 20)
    private String csiTerminal;
    @Column(name = "CSI_USUARIO_ALTA", length = 20)
    private String csiUsuarioAlta;
    @Column(name = "CSI_USUARIO_BAJA", length = 20)
    private String csiUsuarioBaja;
    @Column(name = "CSI_USUARIO_CAMBIO", length = 20)
    private String csiUsuarioCambio;
    @Column(name = "TIN_ID", nullable = false)
    private int tinId;

    public Concesion() {
    }

    public Concesion(int csiEstado, Date csiFechaAlta, Date csiFechaBaja, Date csiFechaCambio, int csiId,
                     String csiNombre, String csiTerminal, String csiUsuarioAlta, String csiUsuarioBaja,
                     String csiUsuarioCambio, int tinId) {
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

    public int getCsiEstado() {
        return csiEstado;
    }

    public void setCsiEstado(int csiEstado) {
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

    public int getCsiId() {
        return csiId;
    }

    public void setCsiId(int csiId) {
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

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }
    
    
    
}
