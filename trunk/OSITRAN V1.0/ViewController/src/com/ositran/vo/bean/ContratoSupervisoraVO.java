package com.ositran.vo.bean;

import java.io.InputStream;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ContratoSupervisoraVO {
    
    private int conId;
    private int cpsAdelantoOtorgado;
    private int cpsAnyo;
    private String cpsArchivoPdf;
    private String cpsAsunto;
    private String cpsCaducidad;
    private int cpsEstado;
    private Date cpsFechaAdelanto;
    private Date cpsFechaAlta;
    private Date cpsFechaBaja;
    private Date cpsFechaCambio;
    private Date cpsFechaInicio;
    private Date cpsFechaRegistro;
    private Date cpsFechaSuscripcion;
    private String cpsGarantias;
    private int cpsMontoContratado;
    private int cpsNroDeContrato;
    private String cpsPenalidades;
    private int cpsPlazoContrato;
    private int cpsStd;
    private String cpsTerminal;
    private String cpsUsuarioAlta;
    private String cpsUsuarioBaja;
    private String cpsUsuarioCambio;
    private int csiId;
    private int infId;
    private int supId;
    private int tinId;
    
    
    private String cenDocumentoFisico;
        private String cenFechaDescripcion;
        private Integer cenEntrega;
        private InputStream inputStreamNuevaEntrega;  
    private int contador;
    
    
    
    public ContratoSupervisoraVO(){
    }


    public ContratoSupervisoraVO(int conId, int cpsAdelantoOtorgado, int cpsAnyo, String cpsArchivoPdf,
                                 String cpsAsunto, String cpsCaducidad, int cpsEstado, Date cpsFechaAdelanto,
                                 Date cpsFechaAlta, Date cpsFechaBaja, Date cpsFechaCambio, Date cpsFechaInicio,
                                 Date cpsFechaRegistro, Date cpsFechaSuscripcion, String cpsGarantias,
                                 int cpsMontoContratado, int cpsNroDeContrato, String cpsPenalidades,
                                 int cpsPlazoContrato, int cpsStd, String cpsTerminal, String cpsUsuarioAlta,
                                 String cpsUsuarioBaja, String cpsUsuarioCambio, int csiId, int infId, int supId,
                                 int tinId) {
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
    }


    public void setConId(int conId) {
        this.conId = conId;
    }

    public int getConId() {
        return conId;
    }

    public void setCpsAdelantoOtorgado(int cpsAdelantoOtorgado) {
        this.cpsAdelantoOtorgado = cpsAdelantoOtorgado;
    }

    public int getCpsAdelantoOtorgado() {
        return cpsAdelantoOtorgado;
    }

    public void setCpsAnyo(int cpsAnyo) {
        this.cpsAnyo = cpsAnyo;
    }

    public int getCpsAnyo() {
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

    public void setCpsEstado(int cpsEstado) {
        this.cpsEstado = cpsEstado;
    }

    public int getCpsEstado() {
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

    public void setCpsMontoContratado(int cpsMontoContratado) {
        this.cpsMontoContratado = cpsMontoContratado;
    }

    public int getCpsMontoContratado() {
        return cpsMontoContratado;
    }

    public void setCpsNroDeContrato(int cpsNroDeContrato) {
        this.cpsNroDeContrato = cpsNroDeContrato;
    }

    public int getCpsNroDeContrato() {
        return cpsNroDeContrato;
    }

    public void setCpsPenalidades(String cpsPenalidades) {
        this.cpsPenalidades = cpsPenalidades;
    }

    public String getCpsPenalidades() {
        return cpsPenalidades;
    }

    public void setCpsPlazoContrato(int cpsPlazoContrato) {
        this.cpsPlazoContrato = cpsPlazoContrato;
    }

    public int getCpsPlazoContrato() {
        return cpsPlazoContrato;
    }

    public void setCpsStd(int cpsStd) {
        this.cpsStd = cpsStd;
    }

    public int getCpsStd() {
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


    public void setCenDocumentoFisico(String cenDocumentoFisico) {
        this.cenDocumentoFisico = cenDocumentoFisico;
    }

    public String getCenDocumentoFisico() {
        return cenDocumentoFisico;
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

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }
}
