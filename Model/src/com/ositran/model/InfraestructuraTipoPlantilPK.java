package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

public class InfraestructuraTipoPlantilPK implements Serializable {
    private BigDecimal tinId;
    private BigDecimal utcId;

    public InfraestructuraTipoPlantilPK() {
    }

    public InfraestructuraTipoPlantilPK(BigDecimal tinId, BigDecimal utcId) {
        this.tinId = tinId;
        this.utcId = utcId;
    }

    public boolean equals(Object other) {
        if (other instanceof InfraestructuraTipoPlantilPK) {
            final InfraestructuraTipoPlantilPK otherInfraestructuraTipoPlantilPK = (InfraestructuraTipoPlantilPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
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
