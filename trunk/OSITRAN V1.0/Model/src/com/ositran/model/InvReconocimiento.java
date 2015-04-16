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
@NamedQueries({ @NamedQuery(name = "InvReconocimiento.findAll", query = "select o from InvReconocimiento o") })
@Table(name = "T_INV_RECONOCIMIENTO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_INV_RECONOCIMIENTO"))
public class InvReconocimiento implements Serializable {
    private static final long serialVersionUID = -1528610907457548562L;
    @Column(name = "IRE_ESTADO", nullable = false)
    private BigDecimal ireEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "IRE_FECHA_REGISTRO")
    private Date ireFechaRegistro;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IRE_ID", nullable = false)
    private BigDecimal ireId;
    @Column(name = "IVR_MONTO_APROBADO", nullable = false)
    private Long ivrMontoAprobado;
    @Column(name = "IVR_MONTO_PRESENTADO", nullable = false)
    private Long ivrMontoPresentado;
    @Column(name = "MON_ID")
    private BigDecimal monId;
    //@Id
    @Column(name = "TIA_NUMERO", nullable = false)
    private BigDecimal tiaNumero;

    public InvReconocimiento() {
    }

    public InvReconocimiento(BigDecimal ireEstado, Date ireFechaRegistro, BigDecimal ireId, Long ivrMontoAprobado,
                             Long ivrMontoPresentado, BigDecimal monId, BigDecimal tiaNumero) {
        this.ireEstado = ireEstado;
        this.ireFechaRegistro = ireFechaRegistro;
        this.ireId = ireId;
        this.ivrMontoAprobado = ivrMontoAprobado;
        this.ivrMontoPresentado = ivrMontoPresentado;
        this.monId = monId;
        this.tiaNumero = tiaNumero;
    }

    public BigDecimal getIreEstado() {
        return ireEstado;
    }

    public void setIreEstado(BigDecimal ireEstado) {
        this.ireEstado = ireEstado;
    }

    public Date getIreFechaRegistro() {
        return ireFechaRegistro;
    }

    public void setIreFechaRegistro(Date ireFechaRegistro) {
        this.ireFechaRegistro = ireFechaRegistro;
    }

    public BigDecimal getIreId() {
        return ireId;
    }

    public void setIreId(BigDecimal ireId) {
        this.ireId = ireId;
    }

    public Long getIvrMontoAprobado() {
        return ivrMontoAprobado;
    }

    public void setIvrMontoAprobado(Long ivrMontoAprobado) {
        this.ivrMontoAprobado = ivrMontoAprobado;
    }

    public Long getIvrMontoPresentado() {
        return ivrMontoPresentado;
    }

    public void setIvrMontoPresentado(Long ivrMontoPresentado) {
        this.ivrMontoPresentado = ivrMontoPresentado;
    }

    public BigDecimal getMonId() {
        return monId;
    }

    public void setMonId(BigDecimal monId) {
        this.monId = monId;
    }

    public BigDecimal getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaNumero(BigDecimal tiaNumero) {
        this.tiaNumero = tiaNumero;
    }
}
