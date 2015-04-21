package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private Integer ireEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "IRE_FECHA_REGISTRO")
    private Date ireFechaRegistro;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IRE_ID", nullable = false)
    private Integer ireId;
    @Column(name = "IVR_MONTO_APROBADO", nullable = false)
    private BigDecimal ivrMontoAprobado;
    @Column(name = "IVR_MONTO_PRESENTADO", nullable = false)
    private BigDecimal ivrMontoPresentado;
    @Column(name = "MON_ID")
    private Integer monId;
    //@Id
    @Column(name = "TIA_NUMERO", nullable = false)
    private Integer tiaNumero;
    
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "TIN_ID")
    private Integer tinId;
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "CVA_ID")
    private Integer cvaId;
    public InvReconocimiento() {
    }

    public InvReconocimiento(Integer ireEstado, Date ireFechaRegistro, Integer ireId, BigDecimal ivrMontoAprobado,
                             BigDecimal ivrMontoPresentado, Integer monId, Integer tiaNumero) {
        this.ireEstado = ireEstado;
        this.ireFechaRegistro = ireFechaRegistro;
        this.ireId = ireId;
        this.ivrMontoAprobado = ivrMontoAprobado;
        this.ivrMontoPresentado = ivrMontoPresentado;
        this.monId = monId;
        this.tiaNumero = tiaNumero;
    }

   

    public Date getIreFechaRegistro() {
        return ireFechaRegistro;
    }

    public void setIreFechaRegistro(Date ireFechaRegistro) {
        this.ireFechaRegistro = ireFechaRegistro;
    }

 

    public BigDecimal getIvrMontoAprobado() {
        return ivrMontoAprobado;
    }

    public void setIvrMontoAprobado(BigDecimal ivrMontoAprobado) {
        this.ivrMontoAprobado = ivrMontoAprobado;
    }

    public BigDecimal getIvrMontoPresentado() {
        return ivrMontoPresentado;
    }

    public void setIvrMontoPresentado(BigDecimal ivrMontoPresentado) {
        this.ivrMontoPresentado = ivrMontoPresentado;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setCvaId(Integer cvaId) {
        this.cvaId = cvaId;
    }

    public Integer getCvaId() {
        return cvaId;
    }

    public void setIreEstado(Integer ireEstado) {
        this.ireEstado = ireEstado;
    }

    public Integer getIreEstado() {
        return ireEstado;
    }

    public void setIreId(Integer ireId) {
        this.ireId = ireId;
    }

    public Integer getIreId() {
        return ireId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setTiaNumero(Integer tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public Integer getTiaNumero() {
        return tiaNumero;
    }

}
