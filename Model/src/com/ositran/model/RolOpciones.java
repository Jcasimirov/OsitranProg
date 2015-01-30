package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "T_ROL_OPCIONES_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_ROL_OPCIONES_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "RolOpciones.findAll", query = "select o from RolOpciones o") })
@Table(name = "T_ROL_OPCIONES")
@SequenceGenerator(name = "RolOpciones_Id_Seq_Gen", sequenceName = "T_ROL_OPCIONES_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class RolOpciones implements Serializable {
    private static final long serialVersionUID = 3304670110087025994L;
    @Id
    @Column(name = "RXO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RolOpciones_Id_Seq_Gen")
    private BigDecimal rxoId;
    @Column(name = "TRO_AGREGAR", nullable = false)
    private BigDecimal troAgregar;
    @Column(name = "TRO_CONSULTAR", nullable = false)
    private BigDecimal troConsultar;
    @Column(name = "TRO_ELIMINAR", nullable = false)
    private BigDecimal troEliminar;
    @Column(name = "TRO_ESTADO", nullable = false)
    private BigDecimal troEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "TRO_FECHA_ALTA")
    private Date troFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "TRO_FECHA_BAJA")
    private Date troFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "TRO_FECHA_CAMBIO")
    private Date troFechaCambio;
    @Column(name = "TRO_MODIFICAR", nullable = false)
    private BigDecimal troModificar;
    @Column(name = "TRO_TERMINAL", length = 20)
    private String troTerminal;
    @Column(name = "TRO_USUARIO_ALTA", length = 20)
    private String troUsuarioAlta;
    @Column(name = "TRO_USUARIO_BAJA", length = 20)
    private String troUsuarioBaja;
    @Column(name = "TRO_USUARIO_CAMBIO", length = 20)
    private String troUsuarioCambio;
    @ManyToOne
    @JoinColumn(name = "MEN_ID")
    private Men TMen;
    @ManyToOne
    @JoinColumn(name = "ROL_ID")
    private Rol TRol1;

    public RolOpciones() {
    }

    public RolOpciones(Men TMen, Rol TRol1, BigDecimal rxoId, BigDecimal troAgregar, BigDecimal troConsultar,
                       BigDecimal troEliminar, BigDecimal troEstado, Date troFechaAlta, Date troFechaBaja,
                       Date troFechaCambio, BigDecimal troModificar, String troTerminal, String troUsuarioAlta,
                       String troUsuarioBaja, String troUsuarioCambio) {
        this.TMen = TMen;
        this.TRol1 = TRol1;
        this.rxoId = rxoId;
        this.troAgregar = troAgregar;
        this.troConsultar = troConsultar;
        this.troEliminar = troEliminar;
        this.troEstado = troEstado;
        this.troFechaAlta = troFechaAlta;
        this.troFechaBaja = troFechaBaja;
        this.troFechaCambio = troFechaCambio;
        this.troModificar = troModificar;
        this.troTerminal = troTerminal;
        this.troUsuarioAlta = troUsuarioAlta;
        this.troUsuarioBaja = troUsuarioBaja;
        this.troUsuarioCambio = troUsuarioCambio;
    }


    public BigDecimal getRxoId() {
        return rxoId;
    }

    public BigDecimal getTroAgregar() {
        return troAgregar;
    }

    public void setTroAgregar(BigDecimal troAgregar) {
        this.troAgregar = troAgregar;
    }

    public BigDecimal getTroConsultar() {
        return troConsultar;
    }

    public void setTroConsultar(BigDecimal troConsultar) {
        this.troConsultar = troConsultar;
    }

    public BigDecimal getTroEliminar() {
        return troEliminar;
    }

    public void setTroEliminar(BigDecimal troEliminar) {
        this.troEliminar = troEliminar;
    }

    public BigDecimal getTroEstado() {
        return troEstado;
    }

    public void setTroEstado(BigDecimal troEstado) {
        this.troEstado = troEstado;
    }

    public Date getTroFechaAlta() {
        return troFechaAlta;
    }

    public void setTroFechaAlta(Date troFechaAlta) {
        this.troFechaAlta = troFechaAlta;
    }

    public Date getTroFechaBaja() {
        return troFechaBaja;
    }

    public void setTroFechaBaja(Date troFechaBaja) {
        this.troFechaBaja = troFechaBaja;
    }

    public Date getTroFechaCambio() {
        return troFechaCambio;
    }

    public void setTroFechaCambio(Date troFechaCambio) {
        this.troFechaCambio = troFechaCambio;
    }

    public BigDecimal getTroModificar() {
        return troModificar;
    }

    public void setTroModificar(BigDecimal troModificar) {
        this.troModificar = troModificar;
    }

    public String getTroTerminal() {
        return troTerminal;
    }

    public void setTroTerminal(String troTerminal) {
        this.troTerminal = troTerminal;
    }

    public String getTroUsuarioAlta() {
        return troUsuarioAlta;
    }

    public void setTroUsuarioAlta(String troUsuarioAlta) {
        this.troUsuarioAlta = troUsuarioAlta;
    }

    public String getTroUsuarioBaja() {
        return troUsuarioBaja;
    }

    public void setTroUsuarioBaja(String troUsuarioBaja) {
        this.troUsuarioBaja = troUsuarioBaja;
    }

    public String getTroUsuarioCambio() {
        return troUsuarioCambio;
    }

    public void setTroUsuarioCambio(String troUsuarioCambio) {
        this.troUsuarioCambio = troUsuarioCambio;
    }

    public Men getTMen() {
        return TMen;
    }

    public void setTMen(Men TMen) {
        this.TMen = TMen;
    }

    public Rol getTRol1() {
        return TRol1;
    }

    public void setTRol1(Rol TRol1) {
        this.TRol1 = TRol1;
    }
}
