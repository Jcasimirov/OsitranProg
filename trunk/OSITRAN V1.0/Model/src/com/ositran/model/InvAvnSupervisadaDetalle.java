package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

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
@Table(name = "T_INV_AVN_SUPERVISADA_DETALLE")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_INV_AVN_SUPERVISADA_DETAL"))


public class InvAvnSupervisadaDetalle implements Serializable {
    private static final long serialVersionUID = -7222958702420110713L;
    @Column(name = "ASD_ESTADO", nullable = false)
    private BigDecimal asdEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "ASD_FECHA_REGISTRO")
    private Date asdFechaRegistro;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ASD_ID", nullable = false)
    private BigDecimal asdId;
    @Column(name = "IAS_NUMERO", nullable = false)
    private BigDecimal iasNumero;
    @Column(name = "ISD_IGV", nullable = false)
    private BigDecimal isdIgv;
    @Column(name = "ISD_MONTO_PRESENTADO", nullable = false)
    private BigDecimal isdMontoPresentado;
    @Column(name = "MON_ID")
    private int monId;
    @Column(name = "TIA_TOTAL")
    private BigDecimal tiaTotal;
    @Column(name = "IAS_MONTO_REVISADO", nullable = false)
    private BigDecimal iasMontoRevisado;
    public InvAvnSupervisadaDetalle() {
    }


    public void setAsdEstado(BigDecimal asdEstado) {
        this.asdEstado = asdEstado;
    }

    public BigDecimal getAsdEstado() {
        return asdEstado;
    }

    public void setAsdFechaRegistro(Date asdFechaRegistro) {
        this.asdFechaRegistro = asdFechaRegistro;
    }

    public Date getAsdFechaRegistro() {
        return asdFechaRegistro;
    }

    public void setAsdId(BigDecimal asdId) {
        this.asdId = asdId;
    }

    public BigDecimal getAsdId() {
        return asdId;
    }

    public void setIasNumero(BigDecimal iasNumero) {
        this.iasNumero = iasNumero;
    }

    public BigDecimal getIasNumero() {
        return iasNumero;
    }


    public void setIsdMontoPresentado(BigDecimal isdMontoPresentado) {
        this.isdMontoPresentado = isdMontoPresentado;
    }

    public BigDecimal getIsdMontoPresentado() {
        return isdMontoPresentado;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getMonId() {
        return monId;
    }

    public void setTiaTotal(BigDecimal tiaTotal) {
        this.tiaTotal = tiaTotal;
    }

    public BigDecimal getTiaTotal() {
        return tiaTotal;
    }

    public void setIasMontoRevisado(BigDecimal iasMontoRevisado) {
        this.iasMontoRevisado = iasMontoRevisado;
    }

    public BigDecimal getIasMontoRevisado() {
        return iasMontoRevisado;
    }

    public void setIsdIgv(BigDecimal isdIgv) {
        this.isdIgv = isdIgv;
    }

    public BigDecimal getIsdIgv() {
        return isdIgv;
    }
}
