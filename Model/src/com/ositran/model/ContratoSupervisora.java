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

/**
 * To create ID generator sequence "T_CONTRATO_SUPERVISORA_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_CONTRATO_SUPERVISORA_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Table(name = "T_CONTRATO_SUPERVISORA")
public class ContratoSupervisora implements Serializable {
    private static final long serialVersionUID = 3657750162709879454L;
    @Column(name = "CON_ID")
    private Integer conId;
    @Column(name = "CPS_ADELANTO_OTORGADO")
    private Integer cpsAdelantoOtorgado;
    @Column(name = "CPS_ANYO")
    private Integer cpsAnyo;
    @Column(name = "CPS_ARCHIVO_PDF")
    private String cpsArchivoPdf;
    @Column(name = "CPS_ASUNTO",    length = 4000)
    private String cpsAsunto;
    @Column(name = "CPS_CADUCIDAD", length = 4000)
    private String cpsCaducidad;
    @Column(name = "CPS_ESTADO")
    private Integer cpsEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_ADELANTO")
    private Date cpsFechaAdelanto;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_ALTA")
    private Date cpsFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_BAJA")
    private Date cpsFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_CAMBIO")
    private Date cpsFechaCambio;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_INICIO")
    private Date cpsFechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_REGISTRO")
    private Date cpsFechaRegistro;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_SUSCRIPCION")
    private Date cpsFechaSuscripcion;
    @Column(name = "CPS_GARANTIAS", length = 4000)
    private String cpsGarantias;
    @Column(name = "CPS_MONTO_CONTRATADO")
    private Integer cpsMontoContratado;
    @Id
    @Column(name = "CPS_NRO_DE_CONTRATO" )
    private Integer cpsNroDeContrato;
    @Column(name = "CPS_PENALIDADES" , length = 4000)
    private String cpsPenalidades;
    @Column(name = "CPS_PLAZO_CONTRATO" )
    private Integer cpsPlazoContrato;
    @Column(name = "CPS_STD" )
    private Integer cpsStd;
    @Column(name = "CPS_TERMINAL", length = 20)
    private String cpsTerminal;
    @Column(name = "CPS_USUARIO_ALTA", length = 20)
    private String cpsUsuarioAlta;
    @Column(name = "CPS_USUARIO_BAJA", length = 20)
    private String cpsUsuarioBaja;
    @Column(name = "CPS_USUARIO_CAMBIO", length = 20)
    private String cpsUsuarioCambio;
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "SUP_ID")
    private Integer supId;
    @Column(name = "TIN_ID")
    private Integer tinId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "CCO_ID")
    private Integer ccoId;
    @Column(name = "TCC_TIPO")
    private Integer tccTipo;
    @Column(name = "MCO_ID")
    private Integer mcoId;
    @Column(name = "INV_ID")
    private Integer invId;
    @Column(name = "CCO_PLAZO")
    private String ccoPlazo;
    @Column(name = "CCO_TOTAL")
    private BigDecimal ccoTotal;
    
    
    
        
    public ContratoSupervisora() {
    }


    public ContratoSupervisora(Integer conId, Integer cpsAdelantoOtorgado, Integer cpsAnyo, String cpsArchivoPdf,
                               String cpsAsunto, String cpsCaducidad, Integer cpsEstado, Date cpsFechaAdelanto,
                               Date cpsFechaAlta, Date cpsFechaBaja, Date cpsFechaCambio, Date cpsFechaInicio,
                               Date cpsFechaRegistro, Date cpsFechaSuscripcion, String cpsGarantias,
                               Integer cpsMontoContratado, Integer cpsNroDeContrato, String cpsPenalidades,
                               Integer cpsPlazoContrato, Integer cpsStd, String cpsTerminal, String cpsUsuarioAlta,
                               String cpsUsuarioBaja, String cpsUsuarioCambio, Integer csiId, Integer infId,
                               Integer supId, Integer tinId, Integer monId, Integer ccoId, Integer tccTipo,
                               Integer mcoId, Integer invId, String ccoPlazo, BigDecimal ccoTotal) {
        super();
        this.conId = conId;
        this.cpsAdelantoOtorgado = cpsAdelantoOtorgado;
        this.cpsAnyo = cpsAnyo;
        this.cpsArchivoPdf = cpsArchivoPdf;
        this.cpsAsunto = cpsAsunto;
        this.cpsCaducidad = cpsCaducidad;
        this.cpsEstado = cpsEstado;
        this.cpsFechaAdelanto = cpsFechaAdelanto;
        this.cpsFechaAlta = cpsFechaAlta;
        this.cpsFechaBaja = cpsFechaBaja;
        this.cpsFechaCambio = cpsFechaCambio;
        this.cpsFechaInicio = cpsFechaInicio;
        this.cpsFechaRegistro = cpsFechaRegistro;
        this.cpsFechaSuscripcion = cpsFechaSuscripcion;
        this.cpsGarantias = cpsGarantias;
        this.cpsMontoContratado = cpsMontoContratado;
        this.cpsNroDeContrato = cpsNroDeContrato;
        this.cpsPenalidades = cpsPenalidades;
        this.cpsPlazoContrato = cpsPlazoContrato;
        this.cpsStd = cpsStd;
        this.cpsTerminal = cpsTerminal;
        this.cpsUsuarioAlta = cpsUsuarioAlta;
        this.cpsUsuarioBaja = cpsUsuarioBaja;
        this.cpsUsuarioCambio = cpsUsuarioCambio;
        this.csiId = csiId;
        this.infId = infId;
        this.supId = supId;
        this.tinId = tinId;
        this.monId = monId;
        this.ccoId = ccoId;
        this.tccTipo = tccTipo;
        this.mcoId = mcoId;
        this.invId = invId;
        this.ccoPlazo = ccoPlazo;
        this.ccoTotal = ccoTotal;
    }


    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setCcoPlazo(String ccoPlazo) {
        this.ccoPlazo = ccoPlazo;
    }

    public String getCcoPlazo() {
        return ccoPlazo;
    }


    public void setCcoTotal(BigDecimal ccoTotal) {
        this.ccoTotal = ccoTotal;
    }

    public BigDecimal getCcoTotal() {
        return ccoTotal;
    }

    public void setMcoId(Integer mcoId) {
        this.mcoId = mcoId;
    }

    public Integer getMcoId() {
        return mcoId;
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

    public void setCpsAdelantoOtorgado(Integer cpsAdelantoOtorgado) {
        this.cpsAdelantoOtorgado = cpsAdelantoOtorgado;
    }

    public Integer getCpsAdelantoOtorgado() {
        return cpsAdelantoOtorgado;
    }

    public void setCpsAnyo(Integer cpsAnyo) {
        this.cpsAnyo = cpsAnyo;
    }

    public Integer getCpsAnyo() {
        return cpsAnyo;
    }

    public void setCpsArchivoPdf(String cpsArchivoPdf) {
        this.cpsArchivoPdf = cpsArchivoPdf;
    }

    public String getCpsArchivoPdf() {
        return cpsArchivoPdf;
    }

    public void setCpsAsunto(String cpsAsunto) {
        this.cpsAsunto = cpsAsunto;
    }

    public String getCpsAsunto() {
        return cpsAsunto;
    }

    public void setCpsCaducidad(String cpsCaducidad) {
        this.cpsCaducidad = cpsCaducidad;
    }

    public String getCpsCaducidad() {
        return cpsCaducidad;
    }

    public void setCpsEstado(Integer cpsEstado) {
        this.cpsEstado = cpsEstado;
    }

    public Integer getCpsEstado() {
        return cpsEstado;
    }

    public void setCpsFechaAdelanto(Date cpsFechaAdelanto) {
        this.cpsFechaAdelanto = cpsFechaAdelanto;
    }

    public Date getCpsFechaAdelanto() {
        return cpsFechaAdelanto;
    }

    public void setCpsFechaAlta(Date cpsFechaAlta) {
        this.cpsFechaAlta = cpsFechaAlta;
    }

    public Date getCpsFechaAlta() {
        return cpsFechaAlta;
    }

    public void setCpsFechaBaja(Date cpsFechaBaja) {
        this.cpsFechaBaja = cpsFechaBaja;
    }

    public Date getCpsFechaBaja() {
        return cpsFechaBaja;
    }

    public void setCpsFechaCambio(Date cpsFechaCambio) {
        this.cpsFechaCambio = cpsFechaCambio;
    }

    public Date getCpsFechaCambio() {
        return cpsFechaCambio;
    }

    public void setCpsFechaInicio(Date cpsFechaInicio) {
        this.cpsFechaInicio = cpsFechaInicio;
    }

    public Date getCpsFechaInicio() {
        return cpsFechaInicio;
    }

    public void setCpsFechaRegistro(Date cpsFechaRegistro) {
        this.cpsFechaRegistro = cpsFechaRegistro;
    }

    public Date getCpsFechaRegistro() {
        return cpsFechaRegistro;
    }

    public void setCpsFechaSuscripcion(Date cpsFechaSuscripcion) {
        this.cpsFechaSuscripcion = cpsFechaSuscripcion;
    }

    public Date getCpsFechaSuscripcion() {
        return cpsFechaSuscripcion;
    }

    public void setCpsGarantias(String cpsGarantias) {
        this.cpsGarantias = cpsGarantias;
    }

    public String getCpsGarantias() {
        return cpsGarantias;
    }

    public void setCpsMontoContratado(Integer cpsMontoContratado) {
        this.cpsMontoContratado = cpsMontoContratado;
    }

    public Integer getCpsMontoContratado() {
        return cpsMontoContratado;
    }

    public void setCpsNroDeContrato(Integer cpsNroDeContrato) {
        this.cpsNroDeContrato = cpsNroDeContrato;
    }

    public Integer getCpsNroDeContrato() {
        return cpsNroDeContrato;
    }

    public void setCpsPenalidades(String cpsPenalidades) {
        this.cpsPenalidades = cpsPenalidades;
    }

    public String getCpsPenalidades() {
        return cpsPenalidades;
    }

    public void setCpsPlazoContrato(Integer cpsPlazoContrato) {
        this.cpsPlazoContrato = cpsPlazoContrato;
    }

    public Integer getCpsPlazoContrato() {
        return cpsPlazoContrato;
    }

    public void setCpsStd(Integer cpsStd) {
        this.cpsStd = cpsStd;
    }

    public Integer getCpsStd() {
        return cpsStd;
    }

    public void setCpsTerminal(String cpsTerminal) {
        this.cpsTerminal = cpsTerminal;
    }

    public String getCpsTerminal() {
        return cpsTerminal;
    }

    public void setCpsUsuarioAlta(String cpsUsuarioAlta) {
        this.cpsUsuarioAlta = cpsUsuarioAlta;
    }

    public String getCpsUsuarioAlta() {
        return cpsUsuarioAlta;
    }

    public void setCpsUsuarioBaja(String cpsUsuarioBaja) {
        this.cpsUsuarioBaja = cpsUsuarioBaja;
    }

    public String getCpsUsuarioBaja() {
        return cpsUsuarioBaja;
    }

    public void setCpsUsuarioCambio(String cpsUsuarioCambio) {
        this.cpsUsuarioCambio = cpsUsuarioCambio;
    }

    public String getCpsUsuarioCambio() {
        return cpsUsuarioCambio;
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

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

}
