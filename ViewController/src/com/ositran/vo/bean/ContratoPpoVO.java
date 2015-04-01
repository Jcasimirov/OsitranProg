package com.ositran.vo.bean;

import java.util.Date;


public class ContratoPpoVO {
   
    private Integer conId;
    private Integer monId;
    private String ppoArchivoPdf;
    private Date ppoFecha;
    private Integer ppoId;
    private Integer ppoMonto;
    private String ppoOficio;
    private Integer ppoEstado;

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

    public Integer getPpoMonto() {
        return ppoMonto;
    }

    public void setPpoMonto(Integer ppoMonto) {
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
}
