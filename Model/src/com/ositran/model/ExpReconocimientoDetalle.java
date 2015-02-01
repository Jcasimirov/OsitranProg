package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
              @NamedQuery(name = "ExpReconocimientoDetalle.findAll",
                          query = "select o from ExpReconocimientoDetalle o") })
@Table(name = "T_EXP_RECONOCIMIENTO_DETALLE")
public class ExpReconocimientoDetalle implements Serializable {
    private static final long serialVersionUID = -7887717886146502682L;
    @Column(name = "CNV_ID")
    private BigDecimal cnvId;
    @Column(name = "ERC_STD", nullable = false, length = 20)
    private String ercStd;
    @Column(name = "ERD_ID", nullable = false)
    private BigDecimal erdId;
    @Column(name = "ERD_VALOR_TOTAL", nullable = false)
    private Long erdValorTotal;
    @Column(name = "MON_ID")
    private BigDecimal monId;

    public ExpReconocimientoDetalle() {
    }

    public ExpReconocimientoDetalle(BigDecimal cnvId, String ercStd, BigDecimal erdId, Long erdValorTotal,
                                    BigDecimal monId) {
        this.cnvId = cnvId;
        this.ercStd = ercStd;
        this.erdId = erdId;
        this.erdValorTotal = erdValorTotal;
        this.monId = monId;
    }

    public BigDecimal getCnvId() {
        return cnvId;
    }

    public void setCnvId(BigDecimal cnvId) {
        this.cnvId = cnvId;
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

    public BigDecimal getMonId() {
        return monId;
    }

    public void setMonId(BigDecimal monId) {
        this.monId = monId;
    }
}
