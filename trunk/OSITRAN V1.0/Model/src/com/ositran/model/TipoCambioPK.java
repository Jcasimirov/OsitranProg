package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class TipoCambioPK implements Serializable {
    private BigDecimal monId;
    private Date tdcFecha;

    public TipoCambioPK() {
    }

    public TipoCambioPK(BigDecimal monId, Date tdcFecha) {
        this.monId = monId;
        this.tdcFecha = tdcFecha;
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

    public BigDecimal getMonId() {
        return monId;
    }

    public void setMonId(BigDecimal monId) {
        this.monId = monId;
    }

    public Date getTdcFecha() {
        return tdcFecha;
    }

    public void setTdcFecha(Date tdcFecha) {
        this.tdcFecha = tdcFecha;
    }
}
