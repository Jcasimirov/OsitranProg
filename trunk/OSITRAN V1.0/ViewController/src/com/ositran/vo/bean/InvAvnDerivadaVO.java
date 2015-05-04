package com.ositran.vo.bean;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;


public class InvAvnDerivadaVO {
    private BigDecimal csiId;
    private Integer iadAnyo;
    private String iadAsunto;
    private Integer iadDiasHabiles;
    private Date iadFechaEmision;
    private Date iadFechaFin;
    private Date iadFechaInicio;
    private Date iadFechaRecepcion;
    private Date iadFechaRegistro;
    private Date iadFechaRespuesta;
    private Date iadFechaVencimiento;
    private BigDecimal iadHr;
    private String iadNroCarta;
    private BigDecimal iadNumero;
    private Integer iadPlazoDias;
    private Long iadPlazoEnDias;
    private String iadRegSalida;
    private BigDecimal iadTipoDias;
    private BigDecimal iasEstado;
    private Date iasFechaAlta;
    private Date iasFechaBaja;
    private Date iasFechaCambio;
    private String iasTerminal;
    private String iasUsuarioAlta;
    private String iasUsuarioBaja;
    private String iasUsuarioCambio;
    private BigDecimal invId;
    private BigDecimal mcoId;
    private String nroOficio;
    private BigDecimal tinId;
    
    private int iadTipoSup;
    
    private int supID ;
    private int tsiID;
    private int tiaNumero;
  


    public void setCsiId(BigDecimal csiId) {
        this.csiId = csiId;
    }

    public BigDecimal getCsiId() {
        return csiId;
    }

    public void setIadAnyo(Integer iadAnyo) {
        this.iadAnyo = iadAnyo;
    }

    public Integer getIadAnyo() {
        return iadAnyo;
    }

    public void setIadAsunto(String iadAsunto) {
        this.iadAsunto = iadAsunto;
    }

    public String getIadAsunto() {
        return iadAsunto;
    }

    public void setIadDiasHabiles(Integer iadDiasHabiles) {
        this.iadDiasHabiles = iadDiasHabiles;
    }

    public Integer getIadDiasHabiles() {
        return iadDiasHabiles;
    }

    public void setIadFechaEmision(Date iadFechaEmision) {
        this.iadFechaEmision = iadFechaEmision;
    }

    public Date getIadFechaEmision() {
        return iadFechaEmision;
    }

    public void setIadFechaFin(Date iadFechaFin) {
        this.iadFechaFin = iadFechaFin;
    }

    public Date getIadFechaFin() {
        return iadFechaFin;
    }

    public void setIadFechaInicio(Date iadFechaInicio) {
        this.iadFechaInicio = iadFechaInicio;
    }

    public Date getIadFechaInicio() {
        return iadFechaInicio;
    }

    public void setIadFechaRecepcion(Date iadFechaRecepcion) {
        this.iadFechaRecepcion = iadFechaRecepcion;
    }

    public Date getIadFechaRecepcion() {
        return iadFechaRecepcion;
    }

    public void setIadFechaRegistro(Date iadFechaRegistro) {
        this.iadFechaRegistro = iadFechaRegistro;
    }

    public Date getIadFechaRegistro() {
        return iadFechaRegistro;
    }

    public void setIadFechaRespuesta(Date iadFechaRespuesta) {
        this.iadFechaRespuesta = iadFechaRespuesta;
    }

    public Date getIadFechaRespuesta() {
        return iadFechaRespuesta;
    }

    public void setIadFechaVencimiento(Date iadFechaVencimiento) {
        this.iadFechaVencimiento = iadFechaVencimiento;
    }

    public Date getIadFechaVencimiento() {
        return iadFechaVencimiento;
    }

    public void setIadHr(BigDecimal iadHr) {
        this.iadHr = iadHr;
    }

    public BigDecimal getIadHr() {
        return iadHr;
    }

    public void setIadNroCarta(String iadNroCarta) {
        this.iadNroCarta = iadNroCarta;
    }

    public String getIadNroCarta() {
        return iadNroCarta;
    }

    public void setIadNumero(BigDecimal iadNumero) {
        this.iadNumero = iadNumero;
    }

    public BigDecimal getIadNumero() {
        return iadNumero;
    }

    public void setIadPlazoDias(Integer iadPlazoDias) {
        this.iadPlazoDias = iadPlazoDias;
    }

    public Integer getIadPlazoDias() {
        return iadPlazoDias;
    }

    public void setIadPlazoEnDias(Long iadPlazoEnDias) {
        this.iadPlazoEnDias = iadPlazoEnDias;
    }

    public Long getIadPlazoEnDias() {
        return iadPlazoEnDias;
    }

    public void setIadRegSalida(String iadRegSalida) {
        this.iadRegSalida = iadRegSalida;
    }

    public String getIadRegSalida() {
        return iadRegSalida;
    }

    public void setIadTipoDias(BigDecimal iadTipoDias) {
        this.iadTipoDias = iadTipoDias;
    }

    public BigDecimal getIadTipoDias() {
        return iadTipoDias;
    }

    public void setIasEstado(BigDecimal iasEstado) {
        this.iasEstado = iasEstado;
    }

    public BigDecimal getIasEstado() {
        return iasEstado;
    }

    public void setIasFechaAlta(Date iasFechaAlta) {
        this.iasFechaAlta = iasFechaAlta;
    }

    public Date getIasFechaAlta() {
        return iasFechaAlta;
    }

    public void setIasFechaBaja(Date iasFechaBaja) {
        this.iasFechaBaja = iasFechaBaja;
    }

    public Date getIasFechaBaja() {
        return iasFechaBaja;
    }

    public void setIasFechaCambio(Date iasFechaCambio) {
        this.iasFechaCambio = iasFechaCambio;
    }

    public Date getIasFechaCambio() {
        return iasFechaCambio;
    }

    public void setIasTerminal(String iasTerminal) {
        this.iasTerminal = iasTerminal;
    }

    public String getIasTerminal() {
        return iasTerminal;
    }

    public void setIasUsuarioAlta(String iasUsuarioAlta) {
        this.iasUsuarioAlta = iasUsuarioAlta;
    }

    public String getIasUsuarioAlta() {
        return iasUsuarioAlta;
    }

    public void setIasUsuarioBaja(String iasUsuarioBaja) {
        this.iasUsuarioBaja = iasUsuarioBaja;
    }

    public String getIasUsuarioBaja() {
        return iasUsuarioBaja;
    }

    public void setIasUsuarioCambio(String iasUsuarioCambio) {
        this.iasUsuarioCambio = iasUsuarioCambio;
    }

    public String getIasUsuarioCambio() {
        return iasUsuarioCambio;
    }

    public void setInvId(BigDecimal invId) {
        this.invId = invId;
    }

    public BigDecimal getInvId() {
        return invId;
    }

    public void setMcoId(BigDecimal mcoId) {
        this.mcoId = mcoId;
    }

    public BigDecimal getMcoId() {
        return mcoId;
    }

    public void setNroOficio(String nroOficio) {
        this.nroOficio = nroOficio;
    }

    public String getNroOficio() {
        return nroOficio;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }

    public BigDecimal getTinId() {
        return tinId;
    }


    public void setIadTipoSup(int iadTipoSup) {
        this.iadTipoSup = iadTipoSup;
    }

    public int getIadTipoSup() {
        return iadTipoSup;
    }

    public void setSupID(int supID) {
        this.supID = supID;
    }

    public int getSupID() {
        return supID;
    }

    public void setTsiID(int tsiID) {
        this.tsiID = tsiID;
    }

    public int getTsiID() {
        return tsiID;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }


}
