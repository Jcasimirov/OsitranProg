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

@Entity
@NamedQueries({ @NamedQuery(name = "InvReajuste.findAll", query = "select o from InvReajuste o") })
@Table(name = "T_INV_REAJUSTE")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_INV_REAJUSTE"))
public class InvReajuste implements Serializable {
    private static final long serialVersionUID = -102984099843979792L;
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "TIN_ID")
    private Integer tinId;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IRJ_ID", nullable = false)
    private Integer irjId;
    @Column(name = "IRJ_MONTO_APROBADO", nullable = false)
    private BigDecimal irjMontoAprobado;
    @Column(name = "IRJ_MONTO_REAJUSTE", nullable = false)
    private BigDecimal irjMontoReajuste;
    @Column(name = "MON_ID")
    private Integer monId;
    //@Id
    @Column(name = "TIA_NUMERO", nullable = false)
    private Integer tiaNumero;


    public InvReajuste() {
    }


    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setIrjId(Integer irjId) {
        this.irjId = irjId;
    }

    public Integer getIrjId() {
        return irjId;
    }

    public void setIrjMontoAprobado(BigDecimal irjMontoAprobado) {
        this.irjMontoAprobado = irjMontoAprobado;
    }

    public BigDecimal getIrjMontoAprobado() {
        return irjMontoAprobado;
    }

    public void setIrjMontoReajuste(BigDecimal irjMontoReajuste) {
        this.irjMontoReajuste = irjMontoReajuste;
    }

    public BigDecimal getIrjMontoReajuste() {
        return irjMontoReajuste;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setTiaNumero(Integer tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public Integer getTiaNumero() {
        return tiaNumero;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }


}
