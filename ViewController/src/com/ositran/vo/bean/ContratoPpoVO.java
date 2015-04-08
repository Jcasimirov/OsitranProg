package com.ositran.vo.bean;

import java.io.InputStream;

import java.util.Date;


public class ContratoPpoVO {
   
    private Integer conId;
    private Integer monId;
    private String ppoArchivoPdf;
    private Date ppoFecha;
    private Integer ppoId;
    private Long ppoMonto;
    private String ppoOficio;
    private Integer ppoEstado;
    private String ppoNombre;
    private InputStream filePpo;
    private String monNombre;

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

    public Long getPpoMonto() {
        return ppoMonto;
    }

    public void setPpoMonto(Long ppoMonto) {
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
}
