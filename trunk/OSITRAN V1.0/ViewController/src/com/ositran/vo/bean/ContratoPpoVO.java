package com.ositran.vo.bean;

import java.io.InputStream;

import java.math.BigDecimal;

import java.util.Date;


public class ContratoPpoVO {
   
    private Integer conId;
    private Integer monId;
    private String ppoArchivoPdf;
    private Date ppoFecha;
    private Integer ppoId;
    private BigDecimal ppoMonto;
    private String ppoOficio;
    private Integer ppoEstado;
    private String ppoNombre;
    private InputStream filePpo;
    private String monNombre;

    private Date ppoFechaAlta;
    private Date ppoFechaBaja;
    private Date ppoFechaCambio;
    private String ppoUsuarioAlta;
    private String ppoUsuarioBaja;
    private String ppoUsuarioCambio;
    private String ppoTerminal;
    public ContratoPpoVO() {
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

    public String getPpoArchivoPdf() {
        return ppoArchivoPdf;
    }

    public void setPpoArchivoPdf(String ppoArchivoPdf) {
        this.ppoArchivoPdf = ppoArchivoPdf;
    }

    public Date getPpoFecha() {
        return ppoFecha;
    }

    public void setPpoFecha(Date ppoFecha) {
        this.ppoFecha = ppoFecha;
    }

    public Integer getPpoId() {
        return ppoId;
    }

    public void setPpoId(Integer ppoId) {
        this.ppoId = ppoId;
    }

    public BigDecimal getPpoMonto() {
        return ppoMonto;
    }

    public void setPpoMonto(BigDecimal ppoMonto) {
        this.ppoMonto = ppoMonto;
    }

    public String getPpoOficio() {
        return ppoOficio;
    }

    public void setPpoOficio(String ppoOficio) {
        this.ppoOficio = ppoOficio;
    }

    public Integer getPpoEstado() {
        return ppoEstado;
    }

    public void setPpoEstado(Integer ppoEstado) {
        this.ppoEstado = ppoEstado;
    }

    public String getPpoNombre() {
        return ppoNombre;
    }

    public void setPpoNombre(String ppoNombre) {
        this.ppoNombre = ppoNombre;
    }

    public InputStream getFilePpo() {
        return filePpo;
    }

    public void setFilePpo(InputStream filePpo) {
        this.filePpo = filePpo;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public void setPpoFechaAlta(Date ppoFechaAlta) {
        this.ppoFechaAlta = ppoFechaAlta;
    }

    public Date getPpoFechaAlta() {
        return ppoFechaAlta;
    }

    public void setPpoFechaBaja(Date ppoFechaBaja) {
        this.ppoFechaBaja = ppoFechaBaja;
    }

    public Date getPpoFechaBaja() {
        return ppoFechaBaja;
    }

    public void setPpoFechaCambio(Date ppoFechaCambio) {
        this.ppoFechaCambio = ppoFechaCambio;
    }

    public Date getPpoFechaCambio() {
        return ppoFechaCambio;
    }

    public void setPpoUsuarioAlta(String ppoUsuarioAlta) {
        this.ppoUsuarioAlta = ppoUsuarioAlta;
    }

    public String getPpoUsuarioAlta() {
        return ppoUsuarioAlta;
    }

    public void setPpoUsuarioBaja(String ppoUsuarioBaja) {
        this.ppoUsuarioBaja = ppoUsuarioBaja;
    }

    public String getPpoUsuarioBaja() {
        return ppoUsuarioBaja;
    }

    public void setPpoUsuarioCambio(String ppoUsuarioCambio) {
        this.ppoUsuarioCambio = ppoUsuarioCambio;
    }

    public String getPpoUsuarioCambio() {
        return ppoUsuarioCambio;
    }

    public void setPpoTerminal(String ppoTerminal) {
        this.ppoTerminal = ppoTerminal;
    }

    public String getPpoTerminal() {
        return ppoTerminal;
    }
}
