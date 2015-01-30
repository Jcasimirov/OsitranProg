package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
              @NamedQuery(name = "ExpReconocimientoDetalle.findAll",
                          query = "select o from ExpReconocimientoDetalle o") })
@Table(name = "T_EXP_RECONOCIMIENTO_DETALLE")
@IdClass(ExpReconocimientoDetallePK.class)
public class ExpReconocimientoDetalle implements Serializable {
    private static final long serialVersionUID = 1716627267284713873L;
    @Id
    @Column(name = "ERC_STD", nullable = false, length = 20)
    private String ercStd;
    @Id
    @Column(name = "ERD_ID", nullable = false)
    private BigDecimal erdId;
    @Column(name = "ERD_VALOR_TOTAL", nullable = false)
    private Long erdValorTotal;
    @ManyToOne
    @JoinColumn(name = "MON_ID")
    private Moneda TMoneda2;
    @ManyToOne
    @JoinColumn(name = "CNV_ID")
    private ConceptoInversion TConceptoInversion;

    public ExpReconocimientoDetalle() {
    }

    public ExpReconocimientoDetalle(ConceptoInversion TConceptoInversion, String ercStd, BigDecimal erdId,
                                    Long erdValorTotal, Moneda TMoneda2) {
        this.TConceptoInversion = TConceptoInversion;
        this.ercStd = ercStd;
        this.erdId = erdId;
        this.erdValorTotal = erdValorTotal;
        this.TMoneda2 = TMoneda2;
    }


    public String getErcStd() {
        return ercStd;
    }

    public void setErcStd(String ercStd) {
        this.ercStd = ercStd;
    }

    public BigDecimal getErdId() {
        return erdId;
    }

    public void setErdId(BigDecimal erdId) {
        this.erdId = erdId;
    }

    public Long getErdValorTotal() {
        return erdValorTotal;
    }

    public void setErdValorTotal(Long erdValorTotal) {
        this.erdValorTotal = erdValorTotal;
    }


    public Moneda getTMoneda2() {
        return TMoneda2;
    }

    public void setTMoneda2(Moneda TMoneda2) {
        this.TMoneda2 = TMoneda2;
    }

    public ConceptoInversion getTConceptoInversion() {
        return TConceptoInversion;
    }

    public void setTConceptoInversion(ConceptoInversion TConceptoInversion) {
        this.TConceptoInversion = TConceptoInversion;
    }
}
