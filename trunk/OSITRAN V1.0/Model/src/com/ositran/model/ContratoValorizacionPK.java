package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

public class ContratoValorizacionPK implements Serializable {
    private BigDecimal conId;
    private BigDecimal cvlId;
    private BigDecimal tinId;

    public ContratoValorizacionPK() {
    }

    public ContratoValorizacionPK(BigDecimal conId, BigDecimal cvlId, BigDecimal tinId) {
        this.conId = conId;
        this.cvlId = cvlId;
        this.tinId = tinId;
    }

    public boolean equals(Object other) {
        if (other instanceof ContratoValorizacionPK) {
            final ContratoValorizacionPK otherContratoValorizacionPK = (ContratoValorizacionPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public BigDecimal getConId() {
        return conId;
    }

    public void setConId(BigDecimal conId) {
        this.conId = conId;
    }

    public BigDecimal getCvlId() {
        return cvlId;
    }

    public void setCvlId(BigDecimal cvlId) {
        this.cvlId = cvlId;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }
}
