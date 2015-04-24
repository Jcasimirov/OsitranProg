package com.ositran.model;

import java.io.Serializable;
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
    private int conId;
    @Column(name = "CPS_ADELANTO_OTORGADO")
    private int cpsAdelantoOtorgado;
    @Column(name = "CPS_ANYO")
    private int cpsAnyo;
    @Column(name = "CPS_ARCHIVO_PDF")
    private String cpsArchivoPdf;
    @Column(name = "CPS_ASUNTO",    length = 4000)
    private String cpsAsunto;
    @Column(name = "CPS_CADUCIDAD", length = 4000)
    private String cpsCaducidad;
    @Column(name = "CPS_ESTADO")
    private int cpsEstado;
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
    private int cpsMontoContratado;
    @Id
    @Column(name = "CPS_NRO_DE_CONTRATO" )
    private int cpsNroDeContrato;
    @Column(name = "CPS_PENALIDADES" , length = 4000)
    private String cpsPenalidades;
    @Column(name = "CPS_PLAZO_CONTRATO" )
    private int cpsPlazoContrato;
    @Column(name = "CPS_STD" )
    private int cpsStd;
    @Column(name = "CPS_TERMINAL", length = 20)
    private String cpsTerminal;
    @Column(name = "CPS_USUARIO_ALTA", length = 20)
    private String cpsUsuarioAlta;
    @Column(name = "CPS_USUARIO_BAJA", length = 20)
    private String cpsUsuarioBaja;
    @Column(name = "CPS_USUARIO_CAMBIO", length = 20)
    private String cpsUsuarioCambio;
    @Column(name = "CSI_ID")
    private int csiId;
    @Column(name = "INF_ID")
    private int infId;
    @Column(name = "SUP_ID")
    private int supId;
    @Column(name = "TIN_ID")
    private int tinId;

    public ContratoSupervisora() {
    }

    public ContratoSupervisora(int conId, int cpsAdelantoOtorgado, int cpsAnyo, String cpsArchivoPdf,
                               String cpsAsunto, String cpsCaducidad, int cpsEstado, Date cpsFechaAdelanto,
                               Date cpsFechaAlta, Date cpsFechaBaja, Date cpsFechaCambio, Date cpsFechaInicio,
                               Date cpsFechaRegistro, Date cpsFechaSuscripcion, String cpsGarantias,
                               int cpsMontoContratado, int cpsNroDeContrato, String cpsPenalidades,
                               int cpsPlazoContrato, int cpsStd, String cpsTerminal,
                               String cpsUsuarioAlta, String cpsUsuarioBaja, String cpsUsuarioCambio, int csiId,
                               int infId, int supId, int tinId) {
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
    }

    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }

    public int getCpsAdelantoOtorgado() {
        return cpsAdelantoOtorgado;
    }

    public void setCpsAdelantoOtorgado(int cpsAdelantoOtorgado) {
        this.cpsAdelantoOtorgado = cpsAdelantoOtorgado;
    }

    public int getCpsAnyo() {
        return cpsAnyo;
    }

    public void setCpsAnyo(int cpsAnyo) {
        this.cpsAnyo = cpsAnyo;
    }

    public String getCpsArchivoPdf() {
        return cpsArchivoPdf;
    }

    public void setCpsArchivoPdf(String cpsArchivoPdf) {
        this.cpsArchivoPdf = cpsArchivoPdf;
    }

    public String getCpsAsunto() {
        return cpsAsunto;
    }

    public void setCpsAsunto(String cpsAsunto) {
        this.cpsAsunto = cpsAsunto;
    }

    public String getCpsCaducidad() {
        return cpsCaducidad;
    }

    public void setCpsCaducidad(String cpsCaducidad) {
        this.cpsCaducidad = cpsCaducidad;
    }

    public int getCpsEstado() {
        return cpsEstado;
    }

    public void setCpsEstado(int cpsEstado) {
        this.cpsEstado = cpsEstado;
    }

    public Date getCpsFechaAdelanto() {
        return cpsFechaAdelanto;
    }

    public void setCpsFechaAdelanto(Date cpsFechaAdelanto) {
        this.cpsFechaAdelanto = cpsFechaAdelanto;
    }

    public Date getCpsFechaAlta() {
        return cpsFechaAlta;
    }

    public void setCpsFechaAlta(Date cpsFechaAlta) {
        this.cpsFechaAlta = cpsFechaAlta;
    }

    public Date getCpsFechaBaja() {
        return cpsFechaBaja;
    }

    public void setCpsFechaBaja(Date cpsFechaBaja) {
        this.cpsFechaBaja = cpsFechaBaja;
    }

    public Date getCpsFechaCambio() {
        return cpsFechaCambio;
    }

    public void setCpsFechaCambio(Date cpsFechaCambio) {
        this.cpsFechaCambio = cpsFechaCambio;
    }

    public Date getCpsFechaInicio() {
        return cpsFechaInicio;
    }

    public void setCpsFechaInicio(Date cpsFechaInicio) {
        this.cpsFechaInicio = cpsFechaInicio;
    }

    public Date getCpsFechaRegistro() {
        return cpsFechaRegistro;
    }

    public void setCpsFechaRegistro(Date cpsFechaRegistro) {
        this.cpsFechaRegistro = cpsFechaRegistro;
    }

    public Date getCpsFechaSuscripcion() {
        return cpsFechaSuscripcion;
    }

    public void setCpsFechaSuscripcion(Date cpsFechaSuscripcion) {
        this.cpsFechaSuscripcion = cpsFechaSuscripcion;
    }

    public String getCpsGarantias() {
        return cpsGarantias;
    }

    public void setCpsGarantias(String cpsGarantias) {
        this.cpsGarantias = cpsGarantias;
    }

    public int getCpsMontoContratado() {
        return cpsMontoContratado;
    }

    public void setCpsMontoContratado(int cpsMontoContratado) {
        this.cpsMontoContratado = cpsMontoContratado;
    }

    public int getCpsNroDeContrato() {
        return cpsNroDeContrato;
    }

    public String getCpsPenalidades() {
        return cpsPenalidades;
    }

    public void setCpsPenalidades(String cpsPenalidades) {
        this.cpsPenalidades = cpsPenalidades;
    }

    public int getCpsPlazoContrato() {
        return cpsPlazoContrato;
    }

    public void setCpsPlazoContrato(int cpsPlazoContrato) {
        this.cpsPlazoContrato = cpsPlazoContrato;
    }

    public int getCpsStd() {
        return cpsStd;
    }

    public void setCpsStd(int cpsStd) {
        this.cpsStd = cpsStd;
    }

    public String getCpsTerminal() {
        return cpsTerminal;
    }

    public void setCpsTerminal(String cpsTerminal) {
        this.cpsTerminal = cpsTerminal;
    }

    public String getCpsUsuarioAlta() {
        return cpsUsuarioAlta;
    }

    public void setCpsUsuarioAlta(String cpsUsuarioAlta) {
        this.cpsUsuarioAlta = cpsUsuarioAlta;
    }

    public String getCpsUsuarioBaja() {
        return cpsUsuarioBaja;
    }

    public void setCpsUsuarioBaja(String cpsUsuarioBaja) {
        this.cpsUsuarioBaja = cpsUsuarioBaja;
    }

    public String getCpsUsuarioCambio() {
        return cpsUsuarioCambio;
    }

    public void setCpsUsuarioCambio(String cpsUsuarioCambio) {
        this.cpsUsuarioCambio = cpsUsuarioCambio;
    }



    public void setCpsNroDeContrato(int cpsNroDeContrato) {
        this.cpsNroDeContrato = cpsNroDeContrato;
    }


    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setInfId(int infId) {
        this.infId = infId;
    }

    public int getInfId() {
        return infId;
    }

    public void setSupId(int supId) {
        this.supId = supId;
    }

    public int getSupId() {
        return supId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }

    public int getTinId() {
        return tinId;
    }
}
