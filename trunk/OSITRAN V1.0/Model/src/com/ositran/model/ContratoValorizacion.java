package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "ContratoValorizacion.findAll", query = "select o from ContratoValorizacion o") })
@Table(name = "T_CONTRATO_VALORIZACION")
public class ContratoValorizacion implements Serializable {
    private static final long serialVersionUID = -2594529446434159711L;
    @Column(length = 20)
    private String alcance;
    @Column(name = "CVA_MONTO", nullable = false)
    private Long cvaMonto;
    @Temporal(TemporalType.DATE)
    @Column(name = "CVL_FECHA")
    private Date cvlFecha;
    @Column(name = "CVL_ID", nullable = false)
    private BigDecimal cvlId;
    private BigDecimal duración;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;
    @ManyToOne
    @JoinColumn(name = "CVA_ID")
    private ConceptoValorizacion TConceptoValorizacion;
    @ManyToOne
    @JoinColumns({
                 @JoinColumn(name = "CON_ID", referencedColumnName = "CON_ID"),
                 @JoinColumn(name = "TIN_ID", referencedColumnName = "TIN_ID")
        })
    private Contrato TContrato3;

    public ContratoValorizacion() {
    }

    public ContratoValorizacion(String alcance, Contrato TContrato3, ConceptoValorizacion TConceptoValorizacion,
                                Long cvaMonto, Date cvlFecha, BigDecimal cvlId, BigDecimal duración, Date fechaInicio) {
        this.alcance = alcance;
        this.TContrato3 = TContrato3;
        this.TConceptoValorizacion = TConceptoValorizacion;
        this.cvaMonto = cvaMonto;
        this.cvlFecha = cvlFecha;
        this.cvlId = cvlId;
        this.duración = duración;
        this.fechaInicio = fechaInicio;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }


    public Long getCvaMonto() {
        return cvaMonto;
    }

    public void setCvaMonto(Long cvaMonto) {
        this.cvaMonto = cvaMonto;
    }

    public Date getCvlFecha() {
        return cvlFecha;
    }

    public void setCvlFecha(Date cvlFecha) {
        this.cvlFecha = cvlFecha;
    }

    public BigDecimal getCvlId() {
        return cvlId;
    }

    public void setCvlId(BigDecimal cvlId) {
        this.cvlId = cvlId;
    }

    public BigDecimal getDuración() {
        return duración;
    }

    public void setDuración(BigDecimal duración) {
        this.duración = duración;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    public ConceptoValorizacion getTConceptoValorizacion() {
        return TConceptoValorizacion;
    }

    public void setTConceptoValorizacion(ConceptoValorizacion TConceptoValorizacion) {
        this.TConceptoValorizacion = TConceptoValorizacion;
    }

    public Contrato getTContrato3() {
        return TContrato3;
    }

    public void setTContrato3(Contrato TContrato3) {
        this.TContrato3 = TContrato3;
    }
}
