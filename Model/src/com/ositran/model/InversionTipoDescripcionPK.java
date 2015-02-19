package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

public class InversionTipoDescripcionPK implements Serializable {
    private int itdId;
    private int tivId;

    public InversionTipoDescripcionPK() {
    }

    public InversionTipoDescripcionPK(int itdId, int tivId) {
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

    public void setItdId(int itdId) {
        this.itdId = itdId;
    }

    public int getItdId() {
        return itdId;
    }

    public void setTivId(int tivId) {
        this.tivId = tivId;
    }

    public int getTivId() {
        return tivId;
    }

}
