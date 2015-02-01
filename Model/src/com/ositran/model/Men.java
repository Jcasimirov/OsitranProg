package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "T_MEN_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_MEN_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Men.findAll", query = "select o from Men o") })
@Table(name = "T_MEN")
@SequenceGenerator(name = "Men_Id_Seq_Gen", sequenceName = "T_MEN_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class Men implements Serializable {
    private static final long serialVersionUID = 7895582654359795714L;
    @Column(nullable = false, length = 4000)
    private String descripcion;
    @Column(name = "MEN_ESTADO", nullable = false)
    private BigDecimal menEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "MEN_FECHA_ALTA")
    private Date menFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "MEN_FECHA_BAJA")
    private Date menFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "MEN_FECHA_CAMBIO")
    private Date menFechaCambio;
    @Column(name = "MEN_FORMULARIO", nullable = false, length = 4000)
    private String menFormulario;
    @Id
    @Column(name = "MEN_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Men_Id_Seq_Gen")
    private BigDecimal menId;
    @Column(name = "MEN_NOMBRE", nullable = false, length = 4000)
    private String menNombre;
    @Column(name = "MEN_PADRE")
    private BigDecimal menPadre;
    @Column(name = "MEN_TERMINAL", length = 20)
    private String menTerminal;
    @Column(name = "MEN_USUARIO_ALTA", length = 20)
    private String menUsuarioAlta;
    @Column(name = "MEN_USUARIO_BAJA", length = 20)
    private String menUsuarioBaja;
    @Column(name = "MEN_USUARIO_CAMBIO", length = 20)
    private String menUsuarioCambio;

    public Men() {
    }

    public Men(String descripcion, BigDecimal menEstado, Date menFechaAlta, Date menFechaBaja, Date menFechaCambio,
               String menFormulario, BigDecimal menId, String menNombre, BigDecimal menPadre, String menTerminal,
               String menUsuarioAlta, String menUsuarioBaja, String menUsuarioCambio) {
        this.descripcion = descripcion;
        this.menEstado = menEstado;
        this.menFechaAlta = menFechaAlta;
        this.menFechaBaja = menFechaBaja;
        this.menFechaCambio = menFechaCambio;
        this.menFormulario = menFormulario;
        this.menId = menId;
        this.menNombre = menNombre;
        this.menPadre = menPadre;
        this.menTerminal = menTerminal;
        this.menUsuarioAlta = menUsuarioAlta;
        this.menUsuarioBaja = menUsuarioBaja;
        this.menUsuarioCambio = menUsuarioCambio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMenEstado() {
        return menEstado;
    }

    public void setMenEstado(BigDecimal menEstado) {
        this.menEstado = menEstado;
    }

    public Date getMenFechaAlta() {
        return menFechaAlta;
    }

    public void setMenFechaAlta(Date menFechaAlta) {
        this.menFechaAlta = menFechaAlta;
    }

    public Date getMenFechaBaja() {
        return menFechaBaja;
    }

    public void setMenFechaBaja(Date menFechaBaja) {
        this.menFechaBaja = menFechaBaja;
    }

    public Date getMenFechaCambio() {
        return menFechaCambio;
    }

    public void setMenFechaCambio(Date menFechaCambio) {
        this.menFechaCambio = menFechaCambio;
    }

    public String getMenFormulario() {
        return menFormulario;
    }

    public void setMenFormulario(String menFormulario) {
        this.menFormulario = menFormulario;
    }

    public BigDecimal getMenId() {
        return menId;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public BigDecimal getMenPadre() {
        return menPadre;
    }

    public void setMenPadre(BigDecimal menPadre) {
        this.menPadre = menPadre;
    }

    public String getMenTerminal() {
        return menTerminal;
    }

    public void setMenTerminal(String menTerminal) {
        this.menTerminal = menTerminal;
    }

    public String getMenUsuarioAlta() {
        return menUsuarioAlta;
    }

    public void setMenUsuarioAlta(String menUsuarioAlta) {
        this.menUsuarioAlta = menUsuarioAlta;
    }

    public String getMenUsuarioBaja() {
        return menUsuarioBaja;
    }

    public void setMenUsuarioBaja(String menUsuarioBaja) {
        this.menUsuarioBaja = menUsuarioBaja;
    }

    public String getMenUsuarioCambio() {
        return menUsuarioCambio;
    }

    public void setMenUsuarioCambio(String menUsuarioCambio) {
        this.menUsuarioCambio = menUsuarioCambio;
    }
}
