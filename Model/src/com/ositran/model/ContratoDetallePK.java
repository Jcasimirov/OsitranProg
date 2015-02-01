package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

public class ContratoDetallePK implements Serializable {
    private BigDecimal cndCorrelativo;
    private BigDecimal conId;
    private BigDecimal tinId;
    private BigDecimal utcId;

    public ContratoDetallePK() {
    }

    public ContratoDetallePK(BigDecimal cndCorrelativo, BigDecimal conId, BigDecimal tinId, BigDecimal utcId) {
        this.cndCorrelativo = cndCorrelativo;
        this.conId = conId;
        this.tinId = tinId;
        this.utcId = utcId;
    }

    public boolean equals(Object other) {
        if (other instanceof ContratoDetallePK) {
            final ContratoDetallePK otherContratoDetallePK = (ContratoDetallePK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public BigDecimal getCndCorrelativo() {
        return cndCorrelativo;
    }

    public void setCndCorrelativo(BigDecimal cndCorrelativo) {
        this.cndCorrelativo = cndCorrelativo;
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

    public BigDecimal getUtcId() {
        return utcId;
    }

    public void setUtcId(BigDecimal utcId) {
        this.utcId = utcId;
    }
}
