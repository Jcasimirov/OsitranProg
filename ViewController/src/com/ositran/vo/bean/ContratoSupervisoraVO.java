package com.ositran.vo.bean;

import java.io.InputStream;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ContratoSupervisoraVO {
    
    private Integer conId;
    private Integer cpsAdelantoOtorgado;
    private Integer cpsAnyo;
    private String cpsArchivoPdf;
    private String cpsAsunto;
    private String cpsCaducidad;
    private Integer cpsEstado;
    private Date cpsFechaAdelanto;
    private Date cpsFechaAlta;
    private Date cpsFechaBaja;
    private Date cpsFechaCambio;
    private Date cpsFechaInicio;
    private Date cpsFechaRegistro;
    private Date cpsFechaSuscripcion;
    private String cpsGarantias;
    private Integer cpsMontoContratado;
    private Integer cpsNroDeContrato;
    private String cpsPenalidades;
    private Integer cpsPlazoContrato;
    private Integer cpsStd;
    private String cpsTerminal;
    private String cpsUsuarioAlta;
    private String cpsUsuarioBaja;
    private String cpsUsuarioCambio;
    private Integer csiId;
    private Integer infId;
    private Integer supId;
    private Integer tinId;
    private Integer monId;
    private Integer ccoId;
    private Integer tccTipo;    
    private Integer mcoId;
    private Integer invId;
    private String ccoPlazo;
    private BigDecimal ccoTotal;
    
    private String cenDocumentoFisico;
    private String cenDocumentoFisicoA;
    private String cenFechaDescripcion;
    private Integer cenEntrega;
    private InputStream inputStreamNuevaEntrega;
    private InputStream inputStreamNuevaEntregaA;
    private Integer contador;
    private String nombreInfraestructura;
    private String nombreSupervisora;
    private String nombreMoneda;
    private String nombreConcesion;
    private String nombreInfraTipo;
    
    public ContratoSupervisoraVO(){
    }


    public ContratoSupervisoraVO(Integer conId, Integer cpsAdelantoOtorgado, Integer cpsAnyo, String cpsArchivoPdf,
                                 String cpsAsunto, String cpsCaducidad, Integer cpsEstado, Date cpsFechaAdelanto,
                                 Date cpsFechaAlta, Date cpsFechaBaja, Date cpsFechaCambio, Date cpsFechaInicio,
                                 Date cpsFechaRegistro, Date cpsFechaSuscripcion, String cpsGarantias,
                                 Integer cpsMontoContratado, Integer cpsNroDeContrato, String cpsPenalidades,
                                 Integer cpsPlazoContrato, Integer cpsStd, String cpsTerminal, String cpsUsuarioAlta,
                                 String cpsUsuarioBaja, String cpsUsuarioCambio, Integer csiId, Integer infId,
                                 Integer supId, Integer tinId, Integer monId, Integer ccoId, Integer tccTipo,
                                 Integer mcoId, Integer invId, String ccoPlazo, BigDecimal ccoTotal,
                                 String cenDocumentoFisico, String cenDocumentoFisicoA, String cenFechaDescripcion,
                                 Integer cenEntrega, InputStream inputStreamNuevaEntrega,
                                 InputStream inputStreamNuevaEntregaA, Integer contador, String nombreInfraestructura,
                                 String nombreSupervisora, String nombreMoneda, String nombreConcesion,
                                 String nombreInfraTipo) {
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
        this.cenDocumentoFisico = cenDocumentoFisico;
        this.cenDocumentoFisicoA = cenDocumentoFisicoA;
        this.cenFechaDescripcion = cenFechaDescripcion;
        this.cenEntrega = cenEntrega;
        this.inputStreamNuevaEntrega = inputStreamNuevaEntrega;
        this.inputStreamNuevaEntregaA = inputStreamNuevaEntregaA;
        this.contador = contador;
        this.nombreInfraestructura = nombreInfraestructura;
        this.nombreSupervisora = nombreSupervisora;
        this.nombreMoneda = nombreMoneda;
        this.nombreConcesion = nombreConcesion;
        this.nombreInfraTipo = nombreInfraTipo;
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

    public void setCenDocumentoFisico(String cenDocumentoFisico) {
        this.cenDocumentoFisico = cenDocumentoFisico;
    }

    public String getCenDocumentoFisico() {
        return cenDocumentoFisico;
    }

    public void setCenDocumentoFisicoA(String cenDocumentoFisicoA) {
        this.cenDocumentoFisicoA = cenDocumentoFisicoA;
    }

    public String getCenDocumentoFisicoA() {
        return cenDocumentoFisicoA;
    }

    public void setCenFechaDescripcion(String cenFechaDescripcion) {
        this.cenFechaDescripcion = cenFechaDescripcion;
    }

    public String getCenFechaDescripcion() {
        return cenFechaDescripcion;
    }

    public void setCenEntrega(Integer cenEntrega) {
        this.cenEntrega = cenEntrega;
    }

    public Integer getCenEntrega() {
        return cenEntrega;
    }

    public void setInputStreamNuevaEntrega(InputStream inputStreamNuevaEntrega) {
        this.inputStreamNuevaEntrega = inputStreamNuevaEntrega;
    }

    public InputStream getInputStreamNuevaEntrega() {
        return inputStreamNuevaEntrega;
    }

    public void setInputStreamNuevaEntregaA(InputStream inputStreamNuevaEntregaA) {
        this.inputStreamNuevaEntregaA = inputStreamNuevaEntregaA;
    }

    public InputStream getInputStreamNuevaEntregaA() {
        return inputStreamNuevaEntregaA;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer getContador() {
        return contador;
    }

    public void setNombreInfraestructura(String nombreInfraestructura) {
        this.nombreInfraestructura = nombreInfraestructura;
    }

    public String getNombreInfraestructura() {
        return nombreInfraestructura;
    }

    public void setNombreSupervisora(String nombreSupervisora) {
        this.nombreSupervisora = nombreSupervisora;
    }

    public String getNombreSupervisora() {
        return nombreSupervisora;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreConcesion(String nombreConcesion) {
        this.nombreConcesion = nombreConcesion;
    }

    public String getNombreConcesion() {
        return nombreConcesion;
    }

    public void setNombreInfraTipo(String nombreInfraTipo) {
        this.nombreInfraTipo = nombreInfraTipo;
    }

    public String getNombreInfraTipo() {
        return nombreInfraTipo;
    }

}
