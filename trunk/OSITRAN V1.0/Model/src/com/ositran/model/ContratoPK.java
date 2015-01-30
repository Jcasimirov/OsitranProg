package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

public class ContratoPK implements Serializable {
    private BigDecimal conId;
    private BigDecimal tinId;

    public ContratoPK() {
    }

    public ContratoPK(BigDecimal conId, BigDecimal tinId) {
        this.conId = conId;
        this.tinId = tinId;
    }

    public boolean equals(Object other) {
        if (other instanceof ContratoPK) {
            final ContratoPK otherContratoPK = (ContratoPK) other;
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

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }
}
