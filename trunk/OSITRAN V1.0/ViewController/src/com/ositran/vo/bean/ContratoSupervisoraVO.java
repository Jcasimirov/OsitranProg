package com.ositran.vo.bean;

import java.io.InputStream;

import java.util.Date;

public class ContratoSupervisoraVO {
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
    private Integer infraestructura;
    private Integer tipoInfraestructura;
    private Integer concesion;
    private Integer empresaSupervisora;
    //private String ContratoSupervisoraAdendaList;
    private Integer contrato;
    //PDF
    private String cenDocumentoFisico;
    private String cenFechaDescripcion;
    private Integer cenEntrega;
    private InputStream inputStreamNuevaEntrega;    
    
    public ContratoSupervisoraVO(){
    }

    public ContratoSupervisoraVO(Integer cpsAdelantoOtorgado, Integer cpsAnyo, String cpsArchivoPdf, String cpsAsunto,
                                 String cpsCaducidad, Integer cpsEstado, Date cpsFechaAdelanto, Date cpsFechaAlta,
                                 Date cpsFechaBaja, Date cpsFechaCambio, Date cpsFechaInicio, Date cpsFechaRegistro,
                                 Date cpsFechaSuscripcion, String cpsGarantias, Integer cpsMontoContratado,
                                 Integer cpsNroDeContrato, String cpsPenalidades, Integer cpsPlazoContrato,
                                 Integer cpsStd, String cpsTerminal, String cpsUsuarioAlta, String cpsUsuarioBaja,
                                 String cpsUsuarioCambio, Integer infraestructura, Integer tipoInfraestructura,
                                 Integer concesion, Integer empresaSupervisora, Integer contrato) {
        super();
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
        this.infraestructura = infraestructura;
        this.tipoInfraestructura = tipoInfraestructura;
        this.concesion = concesion;
        this.empresaSupervisora = empresaSupervisora;
        this.contrato = contrato;
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

    public void setInfraestructura(Integer infraestructura) {
        this.infraestructura = infraestructura;
    }

    public Integer getInfraestructura() {
        return infraestructura;
    }

    public void setTipoInfraestructura(Integer tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public Integer getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setConcesion(Integer concesion) {
        this.concesion = concesion;
    }

    public Integer getConcesion() {
        return concesion;
    }

    public void setEmpresaSupervisora(Integer empresaSupervisora) {
        this.empresaSupervisora = empresaSupervisora;
    }

    public Integer getEmpresaSupervisora() {
        return empresaSupervisora;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    public Integer getContrato() {
        return contrato;
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

}
