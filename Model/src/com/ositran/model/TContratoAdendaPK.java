package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

public class TContratoAdendaPK implements Serializable {
    private BigDecimal cadId;
    private BigDecimal conId;
    private BigDecimal tinId;

    public TContratoAdendaPK() {
    }

    public TContratoAdendaPK(BigDecimal cadId, BigDecimal conId, BigDecimal tinId) {
        this.cadId = cadId;
        this.conId = conId;
        this.tinId = tinId;
    }

    public boolean equals(Object other) {
        if (other instanceof TContratoAdendaPK) {
            final TContratoAdendaPK otherTContratoAdendaPK = (TContratoAdendaPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public BigDecimal getCadId() {
        return cadId;
    }

    public void setCadId(BigDecimal cadId) {
        this.cadId = cadId;
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
