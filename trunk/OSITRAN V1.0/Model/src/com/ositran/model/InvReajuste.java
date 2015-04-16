package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
    private BigDecimal csiId;
    @Column(name = "INF_ID")
    private BigDecimal infId;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IRJ_ID", nullable = false)
    private BigDecimal irjId;
    @Column(name = "IRJ_MONTO_APROBADO", nullable = false)
    private Long irjMontoAprobado;
    @Column(name = "IRJ_MONTO_REAJUSTE", nullable = false)
    private Long irjMontoReajuste;
    @Column(name = "MON_ID")
    private BigDecimal monId;
    //@Id
    @Column(name = "TIA_NUMERO", nullable = false)
    private BigDecimal tiaNumero;
    @Column(name = "TIN_ID")
    private BigDecimal tinId;

    public InvReajuste() {
    }

    public InvReajuste(BigDecimal csiId, BigDecimal infId, BigDecimal irjId, Long irjMontoAprobado,
                       Long irjMontoReajuste, BigDecimal monId, BigDecimal tiaNumero, BigDecimal tinId) {
        this.csiId = csiId;
        this.infId = infId;
        this.irjId = irjId;
        this.irjMontoAprobado = irjMontoAprobado;
        this.irjMontoReajuste = irjMontoReajuste;
        this.monId = monId;
        this.tiaNumero = tiaNumero;
        this.tinId = tinId;
    }

    public BigDecimal getCsiId() {
        return csiId;
    }

    public void setCsiId(BigDecimal csiId) {
        this.csiId = csiId;
    }

    public BigDecimal getInfId() {
        return infId;
    }

    public void setInfId(BigDecimal infId) {
        this.infId = infId;
    }

    public BigDecimal getIrjId() {
        return irjId;
    }

    public void setIrjId(BigDecimal irjId) {
        this.irjId = irjId;
    }

    public Long getIrjMontoAprobado() {
        return irjMontoAprobado;
    }

    public void setIrjMontoAprobado(Long irjMontoAprobado) {
        this.irjMontoAprobado = irjMontoAprobado;
    }

    public Long getIrjMontoReajuste() {
        return irjMontoReajuste;
    }

    public void setIrjMontoReajuste(Long irjMontoReajuste) {
        this.irjMontoReajuste = irjMontoReajuste;
    }

    public BigDecimal getMonId() {
        return monId;
    }

    public void setMonId(BigDecimal monId) {
        this.monId = monId;
    }

    public BigDecimal getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaNumero(BigDecimal tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }
}
