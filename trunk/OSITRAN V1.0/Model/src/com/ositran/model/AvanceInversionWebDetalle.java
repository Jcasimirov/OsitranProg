package com.ositran.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_AVANCE_INVERSION_WEB_DETALLE",uniqueConstraints = @UniqueConstraint(columnNames = {"TIV_ID"}))
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_INVERSIONTIPO"))
public class AvanceInversionWebDetalle implements Serializable {
    private static final long serialVersionUID = 4990163357962044635L;
    @Column(name = "CVA_ID")
    private int cvaId;
    @Column(name = "IWC_ID", nullable = false)
    private int iwcId;
    @Id
    @Column(name = "IWD_ID", nullable = false)
    private int iwdId;
    @Column(name = "IWD_IGV", nullable = false)
    private Long iwdIgv;
    @Column(name = "IWD_NETO", nullable = false)
    private Long iwdNeto;
    @Column(name = "IWD_TOTAL", nullable = false)
    private Long iwdTotal;

    public AvanceInversionWebDetalle() {
    }

    public AvanceInversionWebDetalle(int cvaId, int iwcId, int iwdId, Long iwdIgv, Long iwdNeto,
                                      Long iwdTotal) {
        this.cvaId = cvaId;
        this.iwcId = iwcId;
        this.iwdId = iwdId;
        this.iwdIgv = iwdIgv;
        this.iwdNeto = iwdNeto;
        this.iwdTotal = iwdTotal;
    }

    public int getCvaId() {
        return cvaId;
    }

    public void setCvaId(int cvaId) {
        this.cvaId = cvaId;
    }

    public int getIwcId() {
        return iwcId;
    }

    public void setIwcId(int iwcId) {
        this.iwcId = iwcId;
    }

    public int getIwdId() {
        return iwdId;
    }

    public void setIwdId(int iwdId) {
        this.iwdId = iwdId;
    }

    public Long getIwdIgv() {
        return iwdIgv;
    }

    public void setIwdIgv(Long iwdIgv) {
        this.iwdIgv = iwdIgv;
    }

    public Long getIwdNeto() {
        return iwdNeto;
    }

    public void setIwdNeto(Long iwdNeto) {
        this.iwdNeto = iwdNeto;
    }

    public Long getIwdTotal() {
        return iwdTotal;
    }

    public void setIwdTotal(Long iwdTotal) {
        this.iwdTotal = iwdTotal;
    }
}
