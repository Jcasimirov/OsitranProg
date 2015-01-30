package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class TipoCambioPK implements Serializable {
    private Date tdcFecha;
    private BigDecimal TMoneda;

    public TipoCambioPK() {
    }

    public TipoCambioPK(Date tdcFecha, BigDecimal TMoneda) {
        this.tdcFecha = tdcFecha;
        this.TMoneda = TMoneda;
    }

    public boolean equals(Object other) {
        if (other instanceof TipoCambioPK) {
            final TipoCambioPK otherTipoCambioPK = (TipoCambioPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Date getTdcFecha() {
        return tdcFecha;
    }

    public void setTdcFecha(Date tdcFecha) {
        this.tdcFecha = tdcFecha;
    }

    public BigDecimal getTMoneda() {
        return TMoneda;
    }

    public void setTMoneda(BigDecimal TMoneda) {
        this.TMoneda = TMoneda;
    }
}
