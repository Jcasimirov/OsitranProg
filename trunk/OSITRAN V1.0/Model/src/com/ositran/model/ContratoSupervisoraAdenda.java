package com.ositran.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * To create ID generator sequence "T_CONTRATO_SUPERVISORA_ADENDA_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_CONTRATO_SUPERVISORA_ADENDA_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Table(name = "T_CONTRATO_SUPERVISORA_ADENDA")
public class ContratoSupervisoraAdenda implements Serializable {
    private static final long serialVersionUID = 2222782168772073439L;
    @Id
    @Column(name = "CPS_NRO_DE_CONTRATO")
    private Integer cpsNroDeContrato;
    @Column(name = "CSA_ADENDA")
    private String csaAdenda;
    @Temporal(TemporalType.DATE)
    @Column(name = "CSA_FECHA")
    private Date csaFecha;
    @Column(name = "CSA_MONTO")
    private Integer csaMonto;
    @Column(name = "CSA_PLAZO")
    private String csaPlazo;
    @Column(name = "MON_ID")
    private Integer monId;

    public ContratoSupervisoraAdenda() {
    }

    public ContratoSupervisoraAdenda(Integer cpsNroDeContrato, String csaAdenda, Date csaFecha,
                                      Integer csaMonto, String csaPlazo, Integer monId) {
        this.cpsNroDeContrato = cpsNroDeContrato;
        this.csaAdenda = csaAdenda;
        this.csaFecha = csaFecha;
        this.csaMonto = csaMonto;
        this.csaPlazo = csaPlazo;
        this.monId = monId;
    }

   

    public Integer getCpsNroDeContrato() {
        return cpsNroDeContrato;
    }

    public void setCpsNroDeContrato(Integer cpsNroDeContrato) {
        this.cpsNroDeContrato = cpsNroDeContrato;
    }

    public String getCsaAdenda() {
        return csaAdenda;
    }

    public void setCsaAdenda(String csaAdenda) {
        this.csaAdenda = csaAdenda;
    }

    public Date getCsaFecha() {
        return csaFecha;
    }

    public void setCsaFecha(Date csaFecha) {
        this.csaFecha = csaFecha;
    }

    public Integer getCsaMonto() {
        return csaMonto;
    }

    public void setCsaMonto(Integer csaMonto) {
        this.csaMonto = csaMonto;
    }


    public void setCsaPlazo(String csaPlazo) {
        this.csaPlazo = csaPlazo;
    }

    public String getCsaPlazo() {
        return csaPlazo;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

   
}
