package com.ositran.model;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({ @NamedQuery(name = "ContratoPenalidad.findAll", query = "select o from ContratoPenalidad o") })
@Table(name = "T_CONTRATO_PENALIDAD")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_CONTRATO_PENALIDAD"))
public class ContratoPenalidad implements Serializable {
    private static final long serialVersionUID = 7901626166022068969L;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "PES_ID")
    private Integer pesId;
    @Temporal(TemporalType.DATE)
    @Column(name = "TCP_FECHA")
    private Date tcpFecha;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "TCP_ID", nullable = false)
    private Integer tcpId;
    @Column(name = "TCP_MOTIVO", nullable = false, length = 4000)
    private String tcpMotivo;
    @Column(name = "TCP_TOTAL", nullable = false)
    private Long tcpTotal;

    public ContratoPenalidad() {
    }

    public ContratoPenalidad(Integer conId, Integer monId, Integer pesId, Date tcpFecha, Integer tcpId,
                             String tcpMotivo, Long tcpTotal) {
        this.conId = conId;
        this.monId = monId;
        this.pesId = pesId;
        this.tcpFecha = tcpFecha;
        this.tcpId = tcpId;
        this.tcpMotivo = tcpMotivo;
        this.tcpTotal = tcpTotal;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public Date getTcpFecha() {
        return tcpFecha;
    }

    public void setTcpFecha(Date tcpFecha) {
        this.tcpFecha = tcpFecha;
    }

    public Integer getTcpId() {
        return tcpId;
    }

    public void setTcpId(Integer tcpId) {
        this.tcpId = tcpId;
    }

    public String getTcpMotivo() {
        return tcpMotivo;
    }

    public void setTcpMotivo(String tcpMotivo) {
        this.tcpMotivo = tcpMotivo;
    }

    public Long getTcpTotal() {
        return tcpTotal;
    }

    public void setTcpTotal(Long tcpTotal) {
        this.tcpTotal = tcpTotal;
    }
}
