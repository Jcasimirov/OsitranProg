package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

public class InversionTipoDescripcionPK implements Serializable {
    private BigDecimal itdId;
    private BigDecimal tivId;

    public InversionTipoDescripcionPK() {
    }

    public InversionTipoDescripcionPK(BigDecimal itdId, BigDecimal tivId) {
        this.itdId = itdId;
        this.tivId = tivId;
    }

    public boolean equals(Object other) {
        if (other instanceof InversionTipoDescripcionPK) {
            final InversionTipoDescripcionPK otherInversionTipoDescripcionPK = (InversionTipoDescripcionPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public BigDecimal getItdId() {
        return itdId;
    }

    public void setItdId(BigDecimal itdId) {
        this.itdId = itdId;
    }

    public BigDecimal getTivId() {
        return tivId;
    }

    public void setTivId(BigDecimal tivId) {
        this.tivId = tivId;
    }
}
