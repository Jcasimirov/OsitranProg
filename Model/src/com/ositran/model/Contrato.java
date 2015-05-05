package com.ositran.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO"))
@Table(name = "T_CONTRATO")
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1607891868505474553L;
    @Column(name = "CNC_ID")
    private Integer cncId;
    @Column(name = "CON_ANYO", nullable = false)
    private Integer conAnyo;
    @Column(name = "CON_ASUNTO", nullable = false, length = 4000)
    private String conAsunto;
    @Column(name = "CON_AVANCEOBRA")
    private Integer conAvanceobra;
    @Column(name = "CON_DIAMES")
    private Integer conDiames;
    @Column(name = "CON_DOMICILIO_LEGAL", length = 100)
    private String conDomicilioLegal;
    @Column(name = "CON_ESTADO", nullable = false)
    private Integer conEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_ALTA", nullable = false)
    private Date conFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_BAJA")
    private Date conFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_CAMBIO")
    private Date conFechaCambio;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_REGISTRO")
    private Date conFechaRegistro;
    @Temporal(TemporalType.DATE)
    @Column(name = "CON_FECHA_SUSCRIPCION")
    private Date conFechaSuscripcion;
    @Column(name = "CON_FICHARESUMEN")
    private String conFicharesumen;
    @Id
    @Column(name = "CON_ID", nullable = false)
    @GeneratedValue(generator = "generator")
    private Integer conId;
    @Column(name = "CON_NUMERO", nullable = false)
    private Integer conNumero;
    @Column(name = "CON_PDFCONTRATO")
    private String conPdfcontrato;

    @Column(name = "CON_PLAZOREVISION")
    private Integer conPlazorevision;
    @Column(name = "CON_TERMINAL", length = 20)
    private String conTerminal;
    @Column(name = "CON_TIPODIAS")
    private Integer conTipodias;
    @Column(name = "CON_USUARIO_ALTA", length = 20)
    private String conUsuarioAlta;
    @Column(name = "CON_USUARIO_BAJA", length = 20)
    private String conUsuarioBaja;
    @Column(name = "CON_USUARIO_CAMBIO", length = 20)
    private String conUsuarioCambio;
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "MCO_ID", nullable = false)
    private Integer mcoId;
    @Column(name = "PER_ID")
    private Integer perId;
    @Column(name = "TIN_ID")
    private Integer tinId;

    @Temporal(TemporalType.DATE)
    @Column(name = "CON_PLAZOCONCESION")
    private Date conPlazoconcesion;
    @Column(name = "CON_DIA_PLAZOCONCESION")
    private Integer conDiaPlazoconcesion;
    @Column(name = "CON_MESOANIO_PLAZOCONCESION")
    private Integer conMesoAnioPlazoconcesion;
    @Column(name = "CON_NOTA_PLAZOCONCESION", length = 4000)
    private String conNotaPlazoConcesion;
    public Contrato() {
    }

    public Contrato(Integer cncId, Integer conAnyo, String conAsunto, Integer conAvanceobra, Integer conDiames,
                    String conDomicilioLegal, Integer conEstado, Date conFechaAlta, Date conFechaBaja,
                    Date conFechaCambio, Date conFechaRegistro, Date conFechaSuscripcion, String conFicharesumen,
                    Integer conId, Integer conNumero, String conPdfcontrato, Date conPlazoconcesion,
                    Integer conPlazorevision, String conTerminal, Integer conTipodias, String conUsuarioAlta,
                    String conUsuarioBaja, String conUsuarioCambio, Integer csiId, Integer mcoId, Integer perId,
                    Integer tinId) {
        this.cncId = cncId;
        this.conAnyo = conAnyo;
        this.conAsunto = conAsunto;
        this.conAvanceobra = conAvanceobra;
        this.conDiames = conDiames;
        this.conDomicilioLegal = conDomicilioLegal;
        this.conEstado = conEstado;
        this.conFechaAlta = conFechaAlta;
        this.conFechaBaja = conFechaBaja;
        this.conFechaCambio = conFechaCambio;
        this.conFechaRegistro = conFechaRegistro;
        this.conFechaSuscripcion = conFechaSuscripcion;
        this.conFicharesumen = conFicharesumen;
        this.conId = conId;
        this.conNumero = conNumero;
        this.conPdfcontrato = conPdfcontrato;
        this.conPlazoconcesion = conPlazoconcesion;
        this.conPlazorevision = conPlazorevision;
        this.conTerminal = conTerminal;
        this.conTipodias = conTipodias;
        this.conUsuarioAlta = conUsuarioAlta;
        this.conUsuarioBaja = conUsuarioBaja;
        this.conUsuarioCambio = conUsuarioCambio;
        this.csiId = csiId;
        this.mcoId = mcoId;
        this.perId = perId;
        this.tinId = tinId;
    }


    public void setCncId(Integer cncId) {
        this.cncId = cncId;
    }

    public Integer getCncId() {
        return cncId;
    }

    public void setConAnyo(Integer conAnyo) {
        this.conAnyo = conAnyo;
    }

    public Integer getConAnyo() {
        return conAnyo;
    }

    public void setConAsunto(String conAsunto) {
        this.conAsunto = conAsunto;
    }

    public String getConAsunto() {
        return conAsunto;
    }

    public void setConAvanceobra(Integer conAvanceobra) {
        this.conAvanceobra = conAvanceobra;
    }

    public Integer getConAvanceobra() {
        return conAvanceobra;
    }

    public void setConDiames(Integer conDiames) {
        this.conDiames = conDiames;
    }

    public Integer getConDiames() {
        return conDiames;
    }

    public void setConDomicilioLegal(String conDomicilioLegal) {
        this.conDomicilioLegal = conDomicilioLegal;
    }

    public String getConDomicilioLegal() {
        return conDomicilioLegal;
    }

    public void setConEstado(Integer conEstado) {
        this.conEstado = conEstado;
    }

    public Integer getConEstado() {
        return conEstado;
    }

    public void setConFechaAlta(Date conFechaAlta) {
        this.conFechaAlta = conFechaAlta;
    }

    public Date getConFechaAlta() {
        return conFechaAlta;
    }

    public void setConFechaBaja(Date conFechaBaja) {
        this.conFechaBaja = conFechaBaja;
    }

    public Date getConFechaBaja() {
        return conFechaBaja;
    }

    public void setConFechaCambio(Date conFechaCambio) {
        this.conFechaCambio = conFechaCambio;
    }

    public Date getConFechaCambio() {
        return conFechaCambio;
    }

    public void setConFechaRegistro(Date conFechaRegistro) {
        this.conFechaRegistro = conFechaRegistro;
    }

    public Date getConFechaRegistro() {
        return conFechaRegistro;
    }

    public void setConFechaSuscripcion(Date conFechaSuscripcion) {
        this.conFechaSuscripcion = conFechaSuscripcion;
    }

    public Date getConFechaSuscripcion() {
        return conFechaSuscripcion;
    }

    public void setConFicharesumen(String conFicharesumen) {
        this.conFicharesumen = conFicharesumen;
    }

    public String getConFicharesumen() {
        return conFicharesumen;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConNumero(Integer conNumero) {
        this.conNumero = conNumero;
    }

    public Integer getConNumero() {
        return conNumero;
    }

    public void setConPdfcontrato(String conPdfcontrato) {
        this.conPdfcontrato = conPdfcontrato;
    }

    public String getConPdfcontrato() {
        return conPdfcontrato;
    }

    public void setConPlazoconcesion(Date conPlazoconcesion) {
        this.conPlazoconcesion = conPlazoconcesion;
    }

    public Date getConPlazoconcesion() {
        return conPlazoconcesion;
    }

    public void setConPlazorevision(Integer conPlazorevision) {
        this.conPlazorevision = conPlazorevision;
    }

    public Integer getConPlazorevision() {
        return conPlazorevision;
    }

    public void setConTerminal(String conTerminal) {
        this.conTerminal = conTerminal;
    }

    public String getConTerminal() {
        return conTerminal;
    }

    public void setConTipodias(Integer conTipodias) {
        this.conTipodias = conTipodias;
    }

    public Integer getConTipodias() {
        return conTipodias;
    }

    public void setConUsuarioAlta(String conUsuarioAlta) {
        this.conUsuarioAlta = conUsuarioAlta;
    }

    public String getConUsuarioAlta() {
        return conUsuarioAlta;
    }

    public void setConUsuarioBaja(String conUsuarioBaja) {
        this.conUsuarioBaja = conUsuarioBaja;
    }

    public String getConUsuarioBaja() {
        return conUsuarioBaja;
    }

    public void setConUsuarioCambio(String conUsuarioCambio) {
        this.conUsuarioCambio = conUsuarioCambio;
    }

    public String getConUsuarioCambio() {
        return conUsuarioCambio;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setMcoId(Integer mcoId) {
        this.mcoId = mcoId;
    }

    public Integer getMcoId() {
        return mcoId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setConDiaPlazoconcesion(Integer conDiaPlazoconcesion) {
        this.conDiaPlazoconcesion = conDiaPlazoconcesion;
    }

    public Integer getConDiaPlazoconcesion() {
        return conDiaPlazoconcesion;
    }

    public void setConMesoAnioPlazoconcesion(Integer conMesoAnioPlazoconcesion) {
        this.conMesoAnioPlazoconcesion = conMesoAnioPlazoconcesion;
    }

    public Integer getConMesoAnioPlazoconcesion() {
        return conMesoAnioPlazoconcesion;
    }

    public void setConNotaPlazoConcesion(String conNotaPlazoConcesion) {
        this.conNotaPlazoConcesion = conNotaPlazoConcesion;
    }

    public String getConNotaPlazoConcesion() {
        return conNotaPlazoConcesion;
    }

}
