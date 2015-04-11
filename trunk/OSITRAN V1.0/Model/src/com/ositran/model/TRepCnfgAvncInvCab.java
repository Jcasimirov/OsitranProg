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
@NamedQueries({ @NamedQuery(name = "TRepCnfgAvncInvCab.findAll", query = "select o from TRepCnfgAvncInvCab o") })
@Table(name = "T_REP_CNFG_AVNC_INV_CAB")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_REP_CNFG_AVNC_INV_CAB"))
public class TRepCnfgAvncInvCab implements Serializable {
    private static final long serialVersionUID = 481948154769699959L;
    @Column(name = "CAI_ESTADO", nullable = false)
    private BigDecimal caiEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAI_FECHA_ALTA", nullable = false)
    private Date caiFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAI_FECHA_BAJA")
    private Date caiFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAI_FECHA_CAMBIO")
    private Date caiFechaCambio;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAI_FECHA_EMISION")
    private Date caiFechaEmision;
    @Id
    @GeneratedValue(generator = "generator")

    @Column(name = "CAI_ID", nullable = false)
    private BigDecimal caiId;
    @Column(name = "CAI_MOTIVO_DE_CAMBIO", length = 50)
    private String caiMotivoDeCambio;
    @Column(name = "CAI_NUMERO_DE_DOCUMENTO", length = 50)
    private String caiNumeroDeDocumento;
    @Column(name = "CAI_REFERENCIA", length = 20)
    private String caiReferencia;
    @Column(name = "CAI_TERMINAL", length = 20)
    private String caiTerminal;
    @Column(name = "CAI_USUARIO_ALTA", length = 20)
    private String caiUsuarioAlta;
    @Column(name = "CAI_USUARIO_BAJA", length = 20)
    private String caiUsuarioBaja;
    @Column(name = "CAI_USUARIO_CAMBIO", length = 20)
    private String caiUsuarioCambio;

    public TRepCnfgAvncInvCab() {
    }

    public TRepCnfgAvncInvCab(BigDecimal caiEstado, Date caiFechaAlta, Date caiFechaBaja, Date caiFechaCambio,
                              Date caiFechaEmision, BigDecimal caiId, String caiMotivoDeCambio,
                              String caiNumeroDeDocumento, String caiReferencia, String caiTerminal,
                              String caiUsuarioAlta, String caiUsuarioBaja, String caiUsuarioCambio) {
        this.caiEstado = caiEstado;
        this.caiFechaAlta = caiFechaAlta;
        this.caiFechaBaja = caiFechaBaja;
        this.caiFechaCambio = caiFechaCambio;
        this.caiFechaEmision = caiFechaEmision;
        this.caiId = caiId;
        this.caiMotivoDeCambio = caiMotivoDeCambio;
        this.caiNumeroDeDocumento = caiNumeroDeDocumento;
        this.caiReferencia = caiReferencia;
        this.caiTerminal = caiTerminal;
        this.caiUsuarioAlta = caiUsuarioAlta;
        this.caiUsuarioBaja = caiUsuarioBaja;
        this.caiUsuarioCambio = caiUsuarioCambio;
    }

    public BigDecimal getCaiEstado() {
        return caiEstado;
    }

    public void setCaiEstado(BigDecimal caiEstado) {
        this.caiEstado = caiEstado;
    }

    public Date getCaiFechaAlta() {
        return caiFechaAlta;
    }

    public void setCaiFechaAlta(Date caiFechaAlta) {
        this.caiFechaAlta = caiFechaAlta;
    }

    public Date getCaiFechaBaja() {
        return caiFechaBaja;
    }

    public void setCaiFechaBaja(Date caiFechaBaja) {
        this.caiFechaBaja = caiFechaBaja;
    }

    public Date getCaiFechaCambio() {
        return caiFechaCambio;
    }

    public void setCaiFechaCambio(Date caiFechaCambio) {
        this.caiFechaCambio = caiFechaCambio;
    }

    public Date getCaiFechaEmision() {
        return caiFechaEmision;
    }

    public void setCaiFechaEmision(Date caiFechaEmision) {
        this.caiFechaEmision = caiFechaEmision;
    }

    public BigDecimal getCaiId() {
        return caiId;
    }

    public void setCaiId(BigDecimal caiId) {
        this.caiId = caiId;
    }

    public String getCaiMotivoDeCambio() {
        return caiMotivoDeCambio;
    }

    public void setCaiMotivoDeCambio(String caiMotivoDeCambio) {
        this.caiMotivoDeCambio = caiMotivoDeCambio;
    }

    public String getCaiNumeroDeDocumento() {
        return caiNumeroDeDocumento;
    }

    public void setCaiNumeroDeDocumento(String caiNumeroDeDocumento) {
        this.caiNumeroDeDocumento = caiNumeroDeDocumento;
    }

    public String getCaiReferencia() {
        return caiReferencia;
    }

    public void setCaiReferencia(String caiReferencia) {
        this.caiReferencia = caiReferencia;
    }

    public String getCaiTerminal() {
        return caiTerminal;
    }

    public void setCaiTerminal(String caiTerminal) {
        this.caiTerminal = caiTerminal;
    }

    public String getCaiUsuarioAlta() {
        return caiUsuarioAlta;
    }

    public void setCaiUsuarioAlta(String caiUsuarioAlta) {
        this.caiUsuarioAlta = caiUsuarioAlta;
    }

    public String getCaiUsuarioBaja() {
        return caiUsuarioBaja;
    }

    public void setCaiUsuarioBaja(String caiUsuarioBaja) {
        this.caiUsuarioBaja = caiUsuarioBaja;
    }

    public String getCaiUsuarioCambio() {
        return caiUsuarioCambio;
    }

    public void setCaiUsuarioCambio(String caiUsuarioCambio) {
        this.caiUsuarioCambio = caiUsuarioCambio;
    }
}
