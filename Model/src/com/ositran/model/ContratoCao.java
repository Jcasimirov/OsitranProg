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
@NamedQueries({ @NamedQuery(name = "ContratoCao.findAll", query = "select o from ContratoCao o") })
@Table(name = "T_CONTRATO_CAO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_CAO"))
public class ContratoCao implements Serializable {
    private static final long serialVersionUID = -1519274592126508975L;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAO_FECHA")
    private Date caoFecha;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CAO_ID", nullable = false)
    private Integer caoId;
    @Column(name = "CAO_MONTO", nullable = false)
    private BigDecimal caoMonto;
    @Column(name = "CAO_PDF")
    private String caoPdf;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "CAO_ESTADO")
    private Integer caoEstado;
    @Column(name = "CAO_NOMBRE")
    private String caoNombre;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "CAO_FECHA_ALTA", nullable = false)
    private Date caoFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAO_FECHA_BAJA")
    private Date caoFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAO_FECHA_CAMBIO")
    private Date caoFechaCambio;
    @Column(name = "CAO_USUARIO_ALTA", length = 20)
    private String caoUsuarioAlta;
    @Column(name = "CAO_USUARIO_BAJA", length = 20)
    private String caoUsuarioBaja;
    @Column(name = "CAO_USUARIO_CAMBIO", length = 20)
    private String caoUsuarioCambio;
    @Column(name = "CAO_TERMINAL", length = 20)
    private String caoTerminal;

    public ContratoCao() {
    }

    public ContratoCao(Date caoFecha, Integer caoId, BigDecimal caoMonto, String caoPdf,
                       Integer conId, Integer monId, Integer caoEstado, String caoNombre) {
        this.caoFecha = caoFecha;
        this.caoId = caoId;
        this.caoMonto = caoMonto;        
        this.caoPdf = caoPdf;
        this.conId = conId;
        this.monId = monId;
        this.caoEstado = caoEstado;
        this.caoNombre = caoNombre;
    }

    public Date getCaoFecha() {
        return caoFecha;
    }

    public void setCaoFecha(Date caoFecha) {
        this.caoFecha = caoFecha;
    }

    public Integer getCaoId() {
        return caoId;
    }

    public void setCaoId(Integer caoId) {
        this.caoId = caoId;
    }

    public BigDecimal getCaoMonto() {
        return caoMonto;
    }

    public void setCaoMonto(BigDecimal caoMonto) {
        this.caoMonto = caoMonto;
    }

    public String getCaoPdf() {
        return caoPdf;
    }

    public void setCaoPdf(String caoPdf) {
        this.caoPdf = caoPdf;
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

    public Integer getCaoEstado() {
        return caoEstado;
    }

    public void setCaoEstado(Integer caoEstado) {
        this.caoEstado = caoEstado;
    }

    public String getCaoNombre() {
        return caoNombre;
    }

    public void setCaoNombre(String caoNombre) {
        this.caoNombre = caoNombre;
    }

    public void setCaoFechaAlta(Date caoFechaAlta) {
        this.caoFechaAlta = caoFechaAlta;
    }

    public Date getCaoFechaAlta() {
        return caoFechaAlta;
    }

    public void setCaoFechaBaja(Date caoFechaBaja) {
        this.caoFechaBaja = caoFechaBaja;
    }

    public Date getCaoFechaBaja() {
        return caoFechaBaja;
    }

    public void setCaoFechaCambio(Date caoFechaCambio) {
        this.caoFechaCambio = caoFechaCambio;
    }

    public Date getCaoFechaCambio() {
        return caoFechaCambio;
    }

    public void setCaoUsuarioAlta(String caoUsuarioAlta) {
        this.caoUsuarioAlta = caoUsuarioAlta;
    }

    public String getCaoUsuarioAlta() {
        return caoUsuarioAlta;
    }

    public void setCaoUsuarioBaja(String caoUsuarioBaja) {
        this.caoUsuarioBaja = caoUsuarioBaja;
    }

    public String getCaoUsuarioBaja() {
        return caoUsuarioBaja;
    }

    public void setCaoUsuarioCambio(String caoUsuarioCambio) {
        this.caoUsuarioCambio = caoUsuarioCambio;
    }

    public String getCaoUsuarioCambio() {
        return caoUsuarioCambio;
    }

    public void setCaoTerminal(String caoTerminal) {
        this.caoTerminal = caoTerminal;
    }

    public String getCaoTerminal() {
        return caoTerminal;
    }
}
