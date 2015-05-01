package com.ositran.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * To create ID generator sequence "T_FERIADO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_FERIADO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "TFeriado.findAll", query = "select o from TFeriado o") })
@Table(name = "T_FERIADO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "sq_t_feriado"))
public class TFeriado implements Serializable {
    private static final long serialVersionUID = 8120682435735847751L;
    @Column(name = "FER_ANYO")
    private Integer ferAnyo;
    @Column(name = "FER_DIA", nullable = false)
    private Integer ferDia;
    @Id
    @Column(name = "FER_ID", nullable = false)
    @GeneratedValue(generator = "generator")
    private BigDecimal ferId;
    @Column(name = "FER_MES", nullable = false)
    private Integer ferMes;
    @Column(name = "FER_TIPO", nullable = false)
    private Integer ferTipo;

    public TFeriado() {
    }

    public TFeriado(Integer ferAnyo, Integer ferDia, BigDecimal ferId, Integer ferMes, Integer ferTipo) {
        this.ferAnyo = ferAnyo;
        this.ferDia = ferDia;
        this.ferId = ferId;
        this.ferMes = ferMes;
        this.ferTipo = ferTipo;
    }
    
    public TFeriado(Integer ferAnyo, Integer ferMes, Integer ferDia) {
        this.ferAnyo = ferAnyo;
        this.ferDia = ferDia;
        this.ferMes = ferMes;
    }

    public Integer getFerAnyo() {
        return ferAnyo;
    }

    public void setFerAnyo(Integer ferAnyo) {
        this.ferAnyo = ferAnyo;
    }

    public Integer getFerDia() {
        return ferDia;
    }

    public void setFerDia(Integer ferDia) {
        this.ferDia = ferDia;
    }

    public BigDecimal getFerId() {
        return ferId;
    }

    public Integer getFerMes() {
        return ferMes;
    }

    public void setFerMes(Integer ferMes) {
        this.ferMes = ferMes;
    }

    public Integer getFerTipo() {
        return ferTipo;
    }

    public void setFerTipo(Integer ferTipo) {
        this.ferTipo = ferTipo;
    }
}
