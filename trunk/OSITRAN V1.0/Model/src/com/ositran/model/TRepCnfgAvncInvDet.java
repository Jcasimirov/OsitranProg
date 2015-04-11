package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({ @NamedQuery(name = "TRepCnfgAvncInvDet.findAll", query = "select o from TRepCnfgAvncInvDet o") })
@Table(name = "T_REP_CNFG_AVNC_INV_DET")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_REP_CNFG_AVNC_INV_DET"))
public class TRepCnfgAvncInvDet implements Serializable {
    private static final long serialVersionUID = -3678388447713983166L;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "AID_ID", nullable = false)
    private BigDecimal aidId;
    @Column(name = "CAI_ID", nullable = false)
    private BigDecimal caiId;
    @Column(name = "CAI_MONTO_TOTAL_CON_REAJUSTE", nullable = false)
    private Integer caiMontoTotalConReajuste;
    @Column(name = "CAI_MONTO_TOTAL_SIN_AJUSTE", nullable = false)
    private Integer caiMontoTotalSinAjuste;
    @Column(name = "CSI_ID")
    private BigDecimal csiId;
    @Column(name = "TIN_ID")
    private BigDecimal tinId;

    public TRepCnfgAvncInvDet() {
    }

    public TRepCnfgAvncInvDet(BigDecimal aidId, BigDecimal caiId, Integer caiMontoTotalConReajuste,
                              Integer caiMontoTotalSinAjuste, BigDecimal csiId, BigDecimal tinId) {
        this.aidId = aidId;
        this.caiId = caiId;
        this.caiMontoTotalConReajuste = caiMontoTotalConReajuste;
        this.caiMontoTotalSinAjuste = caiMontoTotalSinAjuste;
        this.csiId = csiId;
        this.tinId = tinId;
    }

    public BigDecimal getAidId() {
        return aidId;
    }

    public void setAidId(BigDecimal aidId) {
        this.aidId = aidId;
    }

    public BigDecimal getCaiId() {
        return caiId;
    }

    public void setCaiId(BigDecimal caiId) {
        this.caiId = caiId;
    }

    public Integer getCaiMontoTotalConReajuste() {
        return caiMontoTotalConReajuste;
    }

    public void setCaiMontoTotalConReajuste(Integer caiMontoTotalConReajuste) {
        this.caiMontoTotalConReajuste = caiMontoTotalConReajuste;
    }

    public Integer getCaiMontoTotalSinAjuste() {
        return caiMontoTotalSinAjuste;
    }

    public void setCaiMontoTotalSinAjuste(Integer caiMontoTotalSinAjuste) {
        this.caiMontoTotalSinAjuste = caiMontoTotalSinAjuste;
    }

    public BigDecimal getCsiId() {
        return csiId;
    }

    public void setCsiId(BigDecimal csiId) {
        this.csiId = csiId;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }
}
