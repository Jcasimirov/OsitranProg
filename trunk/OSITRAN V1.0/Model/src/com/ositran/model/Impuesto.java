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
 * To create ID generator sequence "T_IMPUESTO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_IMPUESTO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Impuesto.findAll", query = "select o from Impuesto o") })
@Table(name = "T_IMPUESTO")
@SequenceGenerator(name = "Impuesto_Id_Seq_Gen", sequenceName = "T_IMPUESTO_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Impuesto implements Serializable {
    private static final long serialVersionUID = 2292487305666610807L;
    @Column(name = "IMP_DESCRIPCION", nullable = false, length = 100)
    private String impDescripcion;
    @Column(name = "IMP_ESTADO", nullable = false)
    private BigDecimal impEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "IMP_FECHA_ALTA")
    private Date impFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "IMP_FECHA_BAJA")
    private Date impFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "IMP_FECHA_CAMBIO")
    private Date impFechaCambio;
    @Id
    @Column(name = "IMP_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Impuesto_Id_Seq_Gen")
    private BigDecimal impId;
    @Column(name = "IMP_NOMBRE", nullable = false, length = 100)
    private String impNombre;
    @Column(name = "IMP_PORCENTAJE", nullable = false)
    private Long impPorcentaje;
    @Column(name = "IMP_TERMINAL", length = 20)
    private String impTerminal;
    @Column(name = "IMP_USUARIO_ALTA", length = 20)
    private String impUsuarioAlta;
    @Column(name = "IMP_USUARIO_BAJA", length = 20)
    private String impUsuarioBaja;
    @Column(name = "IMP_USUARIO_CAMBIO", length = 20)
    private String impUsuarioCambio;

    public Impuesto() {
    }

    public Impuesto(String impDescripcion, BigDecimal impEstado, Date impFechaAlta, Date impFechaBaja,
                    Date impFechaCambio, BigDecimal impId, String impNombre, Long impPorcentaje, String impTerminal,
                    String impUsuarioAlta, String impUsuarioBaja, String impUsuarioCambio) {
        this.impDescripcion = impDescripcion;
        this.impEstado = impEstado;
        this.impFechaAlta = impFechaAlta;
        this.impFechaBaja = impFechaBaja;
        this.impFechaCambio = impFechaCambio;
        this.impId = impId;
        this.impNombre = impNombre;
        this.impPorcentaje = impPorcentaje;
        this.impTerminal = impTerminal;
        this.impUsuarioAlta = impUsuarioAlta;
        this.impUsuarioBaja = impUsuarioBaja;
        this.impUsuarioCambio = impUsuarioCambio;
    }

    public String getImpDescripcion() {
        return impDescripcion;
    }

    public void setImpDescripcion(String impDescripcion) {
        this.impDescripcion = impDescripcion;
    }

    public BigDecimal getImpEstado() {
        return impEstado;
    }

    public void setImpEstado(BigDecimal impEstado) {
        this.impEstado = impEstado;
    }

    public Date getImpFechaAlta() {
        return impFechaAlta;
    }

    public void setImpFechaAlta(Date impFechaAlta) {
        this.impFechaAlta = impFechaAlta;
    }

    public Date getImpFechaBaja() {
        return impFechaBaja;
    }

    public void setImpFechaBaja(Date impFechaBaja) {
        this.impFechaBaja = impFechaBaja;
    }

    public Date getImpFechaCambio() {
        return impFechaCambio;
    }

    public void setImpFechaCambio(Date impFechaCambio) {
        this.impFechaCambio = impFechaCambio;
    }

    public BigDecimal getImpId() {
        return impId;
    }

    public String getImpNombre() {
        return impNombre;
    }

    public void setImpNombre(String impNombre) {
        this.impNombre = impNombre;
    }

    public Long getImpPorcentaje() {
        return impPorcentaje;
    }

    public void setImpPorcentaje(Long impPorcentaje) {
        this.impPorcentaje = impPorcentaje;
    }

    public String getImpTerminal() {
        return impTerminal;
    }

    public void setImpTerminal(String impTerminal) {
        this.impTerminal = impTerminal;
    }

    public String getImpUsuarioAlta() {
        return impUsuarioAlta;
    }

    public void setImpUsuarioAlta(String impUsuarioAlta) {
        this.impUsuarioAlta = impUsuarioAlta;
    }

    public String getImpUsuarioBaja() {
        return impUsuarioBaja;
    }

    public void setImpUsuarioBaja(String impUsuarioBaja) {
        this.impUsuarioBaja = impUsuarioBaja;
    }

    public String getImpUsuarioCambio() {
        return impUsuarioCambio;
    }

    public void setImpUsuarioCambio(String impUsuarioCambio) {
        this.impUsuarioCambio = impUsuarioCambio;
    }
}
