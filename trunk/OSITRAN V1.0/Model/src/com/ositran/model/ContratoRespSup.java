package com.ositran.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_CONTRATO_RESP_SUP")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_RESP_SUP"))

public class ContratoRespSup implements Serializable {
    private static final long serialVersionUID = 8322753168104584805L;
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "INV_ID")
    private Integer invId;
    @Column(name = "MCO_ID")
    private Integer mcoId;
    @Id
    @Column(name = "RSU_ID", nullable = false)
    @GeneratedValue(generator = "generator")
    private Integer rsuId;
    @Column(name = "TIN_ID")
    private Integer tinId;
    @Column(name = "TSI_ID")
    private Integer tsiId;
    @Column(name = "CCO_ID")
    private Integer ccoId;
    @Column(name = "TCC_TIPO")
    private Integer tccTipo;
    @Column(name = "CON_ID")
    private Integer conId;

    public ContratoRespSup() {
    }

    public ContratoRespSup(Integer csiId, Integer infId, Integer invId, Integer mcoId, Integer rsuId,
                           Integer tinId, Integer tsiId,Integer ccoId,Integer tccTipo,Integer conId) {
        this.csiId = csiId;
        this.infId = infId;
        this.invId = invId;
        this.mcoId = mcoId;
        this.rsuId = rsuId;
        this.tinId = tinId;
        this.tsiId = tsiId;
        this.ccoId = ccoId;
        this.tccTipo = tccTipo;
        this.conId = conId;
    }


    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setMcoId(Integer mcoId) {
        this.mcoId = mcoId;
    }

    public Integer getMcoId() {
        return mcoId;
    }

    public void setRsuId(Integer rsuId) {
        this.rsuId = rsuId;
    }

    public Integer getRsuId() {
        return rsuId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setTsiId(Integer tsiId) {
        this.tsiId = tsiId;
    }

    public Integer getTsiId() {
        return tsiId;
    }

    public void setCcoId(Integer ccoId) {
        this.ccoId = ccoId;
    }

    public Integer getCcoId() {
        return ccoId;
    }

    public void setTccTipo(Integer tccTipo) {
        this.tccTipo = tccTipo;
    }

    public Integer getTccTipo() {
        return tccTipo;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }
}
