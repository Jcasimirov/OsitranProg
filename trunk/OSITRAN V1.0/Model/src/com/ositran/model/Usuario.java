package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Usuario.findAll", query = "select o from Usuario o") })
@Table(name = "T_USUARIO")
public class Usuario implements Serializable {
    private static final long serialVersionUID = -4566870633849833918L;
    @Column(name = "USU_CONTRASENYA", nullable = false, length = 20)
    private String usuContrasenya;
    @Column(name = "USU_ESEXTERNO", nullable = false)
    private BigDecimal usuEsexterno;
    @Column(name = "USU_ESTADO", nullable = false)
    private BigDecimal usuEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "USU_FECHA_ALTA")
    private Date usuFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "USU_FECHA_BAJA")
    private Date usuFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "USU_FECHA_CAMBIO")
    private Date usuFechaCambio;
    @Id
    @Column(name = "USU_ID", nullable = false, length = 20)
    private String usuId;
    @Column(name = "USU_NOMBRE", nullable = false, length = 100)
    private String usuNombre;
    @Column(name = "USU_TERMINAL", length = 20)
    private String usuTerminal;
    @Column(name = "USU_USUARIO_ALTA", length = 20)
    private String usuUsuarioAlta;
    @Column(name = "USU_USUARIO_BAJA", length = 20)
    private String usuUsuarioBaja;
    @Column(name = "USU_USUARIO_CAMBIO", length = 20)
    private String usuUsuarioCambio;
    @ManyToOne
    @JoinColumn(name = "CRG_ID")
    private Cargo cargo;
    @ManyToOne
    @JoinColumn(name = "ROL_ID")
    private Rol TRol;

    public Usuario() {
    }

    public Usuario(Cargo cargo, Rol TRol, String usuContrasenya, BigDecimal usuEsexterno, BigDecimal usuEstado,
                   Date usuFechaAlta, Date usuFechaBaja, Date usuFechaCambio, String usuId, String usuNombre,
                   String usuTerminal, String usuUsuarioAlta, String usuUsuarioBaja, String usuUsuarioCambio) {
        this.cargo = cargo;
        this.TRol = TRol;
        this.usuContrasenya = usuContrasenya;
        this.usuEsexterno = usuEsexterno;
        this.usuEstado = usuEstado;
        this.usuFechaAlta = usuFechaAlta;
        this.usuFechaBaja = usuFechaBaja;
        this.usuFechaCambio = usuFechaCambio;
        this.usuId = usuId;
        this.usuNombre = usuNombre;
        this.usuTerminal = usuTerminal;
        this.usuUsuarioAlta = usuUsuarioAlta;
        this.usuUsuarioBaja = usuUsuarioBaja;
        this.usuUsuarioCambio = usuUsuarioCambio;
    }


    public String getUsuContrasenya() {
        return usuContrasenya;
    }

    public void setUsuContrasenya(String usuContrasenya) {
        this.usuContrasenya = usuContrasenya;
    }

    public BigDecimal getUsuEsexterno() {
        return usuEsexterno;
    }

    public void setUsuEsexterno(BigDecimal usuEsexterno) {
        this.usuEsexterno = usuEsexterno;
    }

    public BigDecimal getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(BigDecimal usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Date getUsuFechaAlta() {
        return usuFechaAlta;
    }

    public void setUsuFechaAlta(Date usuFechaAlta) {
        this.usuFechaAlta = usuFechaAlta;
    }

    public Date getUsuFechaBaja() {
        return usuFechaBaja;
    }

    public void setUsuFechaBaja(Date usuFechaBaja) {
        this.usuFechaBaja = usuFechaBaja;
    }

    public Date getUsuFechaCambio() {
        return usuFechaCambio;
    }

    public void setUsuFechaCambio(Date usuFechaCambio) {
        this.usuFechaCambio = usuFechaCambio;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuTerminal() {
        return usuTerminal;
    }

    public void setUsuTerminal(String usuTerminal) {
        this.usuTerminal = usuTerminal;
    }

    public String getUsuUsuarioAlta() {
        return usuUsuarioAlta;
    }

    public void setUsuUsuarioAlta(String usuUsuarioAlta) {
        this.usuUsuarioAlta = usuUsuarioAlta;
    }

    public String getUsuUsuarioBaja() {
        return usuUsuarioBaja;
    }

    public void setUsuUsuarioBaja(String usuUsuarioBaja) {
        this.usuUsuarioBaja = usuUsuarioBaja;
    }

    public String getUsuUsuarioCambio() {
        return usuUsuarioCambio;
    }

    public void setUsuUsuarioCambio(String usuUsuarioCambio) {
        this.usuUsuarioCambio = usuUsuarioCambio;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Rol getTRol() {
        return TRol;
    }

    public void setTRol(Rol TRol) {
        this.TRol = TRol;
    }
}
