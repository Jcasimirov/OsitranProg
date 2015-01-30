package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

public class ExpReconocimientoDetallePK implements Serializable {
    private String ercStd;
    private BigDecimal erdId;

    public ExpReconocimientoDetallePK() {
    }

    public ExpReconocimientoDetallePK(String ercStd, BigDecimal erdId) {
        this.ercStd = ercStd;
        this.erdId = erdId;
    }

    public boolean equals(Object other) {
        if (other instanceof ExpReconocimientoDetallePK) {
            final ExpReconocimientoDetallePK otherExpReconocimientoDetallePK = (ExpReconocimientoDetallePK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
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
}
