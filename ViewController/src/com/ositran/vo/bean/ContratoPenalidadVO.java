
package com.ositran.vo.bean;

import java.io.InputStream;

import java.util.Date;


public class ContratoPenalidadVO {
    
    private Integer conId;    
    private Integer monId;    
    private Integer pesId;
    private Date tcpFecha;
    private String tcpFechaDescripcion;
    private Integer tcpId;
    private String tcpMotivo;
    private Long tcpTotal;
    private String tcpEstado;
    private String monNombre;
    private String tcpDocumentoFisico;
    private InputStream inputStreamNuevaPenalidad;
    private Date tcpFechaAlta;
    private Date tcpFechaBaja;
    private Date tcpFechaCambio;
    private String tcpUsuarioAlta;
    private String tcpUsuarioBaja;
    private String tcpUsuarioCambio;
    private String tcpTerminal;
    public ContratoPenalidadVO() {
        super();
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

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public Date getTcpFecha() {
        return tcpFecha;
    }

    public void setTcpFecha(Date tcpFecha) {
        this.tcpFecha = tcpFecha;
    }

    public Integer getTcpId() {
        return tcpId;
    }

    public void setTcpId(Integer tcpId) {
        this.tcpId = tcpId;
    }

    public String getTcpMotivo() {
        return tcpMotivo;
    }

    public void setTcpMotivo(String tcpMotivo) {
        this.tcpMotivo = tcpMotivo;
    }

    public Long getTcpTotal() {
        return tcpTotal;
    }

    public void setTcpTotal(Long tcpTotal) {
        this.tcpTotal = tcpTotal;
    }

    public String getTcpEstado() {
        return tcpEstado;
    }

    public void setTcpEstado(String tcpEstado) {
        this.tcpEstado = tcpEstado;
    }

    public void setTcpFechaDescripcion(String tcpFechaDescripcion) {
        this.tcpFechaDescripcion = tcpFechaDescripcion;
    }

    public String getTcpFechaDescripcion() {
        return tcpFechaDescripcion;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setTcpDocumentoFisico(String tcpDocumentoFisico) {
        this.tcpDocumentoFisico = tcpDocumentoFisico;
    }

    public String getTcpDocumentoFisico() {
        return tcpDocumentoFisico;
    }


    public void setInputStreamNuevaPenalidad(InputStream inputStreamNuevaPenalidad) {
        this.inputStreamNuevaPenalidad = inputStreamNuevaPenalidad;
    }

    public InputStream getInputStreamNuevaPenalidad() {
        return inputStreamNuevaPenalidad;
    }

    public void setTcpFechaAlta(Date tcpFechaAlta) {
        this.tcpFechaAlta = tcpFechaAlta;
    }

    public Date getTcpFechaAlta() {
        return tcpFechaAlta;
    }

    public void setTcpFechaBaja(Date tcpFechaBaja) {
        this.tcpFechaBaja = tcpFechaBaja;
    }

    public Date getTcpFechaBaja() {
        return tcpFechaBaja;
    }

    public void setTcpFechaCambio(Date tcpFechaCambio) {
        this.tcpFechaCambio = tcpFechaCambio;
    }

    public Date getTcpFechaCambio() {
        return tcpFechaCambio;
    }

    public void setTcpUsuarioAlta(String tcpUsuarioAlta) {
        this.tcpUsuarioAlta = tcpUsuarioAlta;
    }

    public String getTcpUsuarioAlta() {
        return tcpUsuarioAlta;
    }

    public void setTcpUsuarioBaja(String tcpUsuarioBaja) {
        this.tcpUsuarioBaja = tcpUsuarioBaja;
    }

    public String getTcpUsuarioBaja() {
        return tcpUsuarioBaja;
    }

    public void setTcpUsuarioCambio(String tcpUsuarioCambio) {
        this.tcpUsuarioCambio = tcpUsuarioCambio;
    }

    public String getTcpUsuarioCambio() {
        return tcpUsuarioCambio;
    }

    public void setTcpTerminal(String tcpTerminal) {
        this.tcpTerminal = tcpTerminal;
    }

    public String getTcpTerminal() {
        return tcpTerminal;
    }
}
