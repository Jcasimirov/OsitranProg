package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "T_CONCEPTO_VALORIZACION_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_CONCEPTO_VALORIZACION_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "ConceptoValorizacion.findAll", query = "select o from ConceptoValorizacion o") })
@Table(name = "T_CONCEPTO_VALORIZACION")
@SequenceGenerator(name = "ConceptoValorizacion_Id_Seq_Gen", sequenceName = "T_CONCEPTO_VALORIZACION_ID_SEQ_GEN",
                   allocationSize = 50, initialValue = 50)
public class ConceptoValorizacion implements Serializable {
    private static final long serialVersionUID = 2941433165915685195L;
    @Column(name = "CVA_DESCRIPCION", nullable = false, length = 100)
    private String cvaDescripcion;
    @Column(name = "CVA_ESTADO", nullable = false)
    private BigDecimal cvaEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CVA_FECHA_ALTA")
    private Date cvaFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CVA_FECHA_BAJA")
    private Date cvaFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CVA_FECHA_CAMBIO")
    private Date cvaFechaCambio;
    @Id
    @Column(name = "CVA_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ConceptoValorizacion_Id_Seq_Gen")
    private BigDecimal cvaId;
    @Column(name = "CVA_NOMBRE", nullable = false, length = 100)
    private String cvaNombre;
    @Column(name = "CVA_TERMINAL", length = 20)
    private String cvaTerminal;
    @Column(name = "CVA_USUARIO_ALTA", length = 20)
    private String cvaUsuarioAlta;
    @Column(name = "CVA_USUARIO_BAJA", length = 20)
    private String cvaUsuarioBaja;
    @Column(name = "CVA_USUARIO_CAMBIO", length = 20)
    private String cvaUsuarioCambio;
    @OneToMany(mappedBy = "TConceptoValorizacion", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ContratoValorizacion> TContratoValorizacionList;

    public ConceptoValorizacion() {
    }

    public ConceptoValorizacion(String cvaDescripcion, BigDecimal cvaEstado, Date cvaFechaAlta, Date cvaFechaBaja,
                                Date cvaFechaCambio, BigDecimal cvaId, String cvaNombre, String cvaTerminal,
                                String cvaUsuarioAlta, String cvaUsuarioBaja, String cvaUsuarioCambio) {
        this.cvaDescripcion = cvaDescripcion;
        this.cvaEstado = cvaEstado;
        this.cvaFechaAlta = cvaFechaAlta;
        this.cvaFechaBaja = cvaFechaBaja;
        this.cvaFechaCambio = cvaFechaCambio;
        this.cvaId = cvaId;
        this.cvaNombre = cvaNombre;
        this.cvaTerminal = cvaTerminal;
        this.cvaUsuarioAlta = cvaUsuarioAlta;
        this.cvaUsuarioBaja = cvaUsuarioBaja;
        this.cvaUsuarioCambio = cvaUsuarioCambio;
    }

    public String getCvaDescripcion() {
        return cvaDescripcion;
    }

    public void setCvaDescripcion(String cvaDescripcion) {
        this.cvaDescripcion = cvaDescripcion;
    }

    public BigDecimal getCvaEstado() {
        return cvaEstado;
    }

    public void setCvaEstado(BigDecimal cvaEstado) {
        this.cvaEstado = cvaEstado;
    }

    public Date getCvaFechaAlta() {
        return cvaFechaAlta;
    }

    public void setCvaFechaAlta(Date cvaFechaAlta) {
        this.cvaFechaAlta = cvaFechaAlta;
    }

    public Date getCvaFechaBaja() {
        return cvaFechaBaja;
    }

    public void setCvaFechaBaja(Date cvaFechaBaja) {
        this.cvaFechaBaja = cvaFechaBaja;
    }

    public Date getCvaFechaCambio() {
        return cvaFechaCambio;
    }

    public void setCvaFechaCambio(Date cvaFechaCambio) {
        this.cvaFechaCambio = cvaFechaCambio;
    }

    public BigDecimal getCvaId() {
        return cvaId;
    }

    public String getCvaNombre() {
        return cvaNombre;
    }

    public void setCvaNombre(String cvaNombre) {
        this.cvaNombre = cvaNombre;
    }

    public String getCvaTerminal() {
        return cvaTerminal;
    }

    public void setCvaTerminal(String cvaTerminal) {
        this.cvaTerminal = cvaTerminal;
    }

    public String getCvaUsuarioAlta() {
        return cvaUsuarioAlta;
    }

    public void setCvaUsuarioAlta(String cvaUsuarioAlta) {
        this.cvaUsuarioAlta = cvaUsuarioAlta;
    }

    public String getCvaUsuarioBaja() {
        return cvaUsuarioBaja;
    }

    public void setCvaUsuarioBaja(String cvaUsuarioBaja) {
        this.cvaUsuarioBaja = cvaUsuarioBaja;
    }

    public String getCvaUsuarioCambio() {
        return cvaUsuarioCambio;
    }

    public void setCvaUsuarioCambio(String cvaUsuarioCambio) {
        this.cvaUsuarioCambio = cvaUsuarioCambio;
    }

    public List<ContratoValorizacion> getTContratoValorizacionList() {
        return TContratoValorizacionList;
    }

    public void setTContratoValorizacionList(List<ContratoValorizacion> TContratoValorizacionList) {
        this.TContratoValorizacionList = TContratoValorizacionList;
    }

    public ContratoValorizacion addContratoValorizacion(ContratoValorizacion contratoValorizacion) {
        getTContratoValorizacionList().add(contratoValorizacion);
        contratoValorizacion.setTConceptoValorizacion(this);
        return contratoValorizacion;
    }

    public ContratoValorizacion removeContratoValorizacion(ContratoValorizacion contratoValorizacion) {
        getTContratoValorizacionList().remove(contratoValorizacion);
        contratoValorizacion.setTConceptoValorizacion(null);
        return contratoValorizacion;
    }
}
