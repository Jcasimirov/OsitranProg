package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

public class TContratoAnexoPK implements Serializable {
    private BigDecimal caxId;
    private BigDecimal conId;
    private BigDecimal tinId;

    public TContratoAnexoPK() {
    }

    public TContratoAnexoPK(BigDecimal caxId, BigDecimal conId, BigDecimal tinId) {
        this.caxId = caxId;
        this.conId = conId;
        this.tinId = tinId;
    }

    public boolean equals(Object other) {
        if (other instanceof TContratoAnexoPK) {
            final TContratoAnexoPK otherTContratoAnexoPK = (TContratoAnexoPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public BigDecimal getCaxId() {
        return caxId;
    }

    public void setCaxId(BigDecimal caxId) {
        this.caxId = caxId;
    }

    public BigDecimal getConId() {
        return conId;
    }

    public void setConId(BigDecimal conId) {
        this.conId = conId;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }
}
