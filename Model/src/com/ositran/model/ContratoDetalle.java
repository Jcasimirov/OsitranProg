package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "ContratoDetalle.findAll", query = "select o from ContratoDetalle o") })
@Table(name = "T_CONTRATO_DETALLE")
@IdClass(ContratoDetallePK.class)
public class ContratoDetalle implements Serializable {
    private static final long serialVersionUID = -4020496820996844247L;
    @Id
    @Column(name = "CND_CORRELATIVO", nullable = false)
    private BigDecimal cndCorrelativo;
    @Column(name = "CND_REFERENCIA", nullable = false, length = 4000)
    private String cndReferencia;
    @Temporal(TemporalType.DATE)
    @Column(name = "CND_VALOR_FECHA")
    private Date cndValorFecha;
    @Column(name = "CND_VALOR_NUMERICO")
    private Long cndValorNumerico;
    @Column(name = "CND_VALOR_TEXTO", length = 200)
    private String cndValorTexto;
    @Id
    @Column(name = "CON_ID", nullable = false)
    private BigDecimal conId;
    @Id
    @Column(name = "TIN_ID", nullable = false)
    private BigDecimal tinId;
    @Id
    @Column(name = "UTC_ID", nullable = false)
    private BigDecimal utcId;

    public ContratoDetalle() {
    }

    public ContratoDetalle(BigDecimal cndCorrelativo, String cndReferencia, Date cndValorFecha, Long cndValorNumerico,
                           String cndValorTexto, BigDecimal conId, BigDecimal tinId, BigDecimal utcId) {
        this.cndCorrelativo = cndCorrelativo;
        this.cndReferencia = cndReferencia;
        this.cndValorFecha = cndValorFecha;
        this.cndValorNumerico = cndValorNumerico;
        this.cndValorTexto = cndValorTexto;
        this.conId = conId;
        this.tinId = tinId;
        this.utcId = utcId;
    }

    public BigDecimal getCndCorrelativo() {
        return cndCorrelativo;
    }

    public void setCndCorrelativo(BigDecimal cndCorrelativo) {
        this.cndCorrelativo = cndCorrelativo;
    }

    public String getCndReferencia() {
        return cndReferencia;
    }

    public void setCndReferencia(String cndReferencia) {
        this.cndReferencia = cndReferencia;
    }

    public Date getCndValorFecha() {
        return cndValorFecha;
    }

    public void setCndValorFecha(Date cndValorFecha) {
        this.cndValorFecha = cndValorFecha;
    }

    public Long getCndValorNumerico() {
        return cndValorNumerico;
    }

    public void setCndValorNumerico(Long cndValorNumerico) {
        this.cndValorNumerico = cndValorNumerico;
    }

    public String getCndValorTexto() {
        return cndValorTexto;
    }

    public void setCndValorTexto(String cndValorTexto) {
        this.cndValorTexto = cndValorTexto;
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
