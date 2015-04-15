package com.ositran.vo.bean;

import com.ositran.model.TRepCnfgAvncInvCab;

import java.math.BigDecimal;

import java.util.Date;

public class TRepCnfgAvncInvCabVO {
    private BigDecimal caiEstado;
    private Date caiFechaAlta;
    private Date caiFechaBaja;
    private Date caiFechaCambio;
    private Date caiFechaEmision;
    private BigDecimal caiId;
    private String caiMotivoDeCambio;
    private String caiNumeroDeDocumento;
    private String caiReferencia;
    private String caiTerminal;
    private String caiUsuarioAlta;
    private String caiUsuarioBaja;
    private String caiUsuarioCambio;

    public TRepCnfgAvncInvCabVO() {
    }

    public TRepCnfgAvncInvCabVO(BigDecimal caiEstado, Date caiFechaAlta, Date caiFechaBaja, Date caiFechaCambio,
                              Date caiFechaEmision, BigDecimal caiId, String caiMotivoDeCambio,
                              String caiNumeroDeDocumento, String caiReferencia, String caiTerminal,
                              String caiUsuarioAlta, String caiUsuarioBaja, String caiUsuarioCambio) {
        this.caiEstado = caiEstado;
        this.caiFechaAlta = caiFechaAlta;
        this.caiFechaBaja = caiFechaBaja;
        this.caiFechaCambio = caiFechaCambio;
        this.caiFechaEmision = caiFechaEmision;
        this.caiId = caiId;
        this.caiMotivoDeCambio = caiMotivoDeCambio;
        this.caiNumeroDeDocumento = caiNumeroDeDocumento;
        this.caiReferencia = caiReferencia;
        this.caiTerminal = caiTerminal;
        this.caiUsuarioAlta = caiUsuarioAlta;
        this.caiUsuarioBaja = caiUsuarioBaja;
        this.caiUsuarioCambio = caiUsuarioCambio;
    }
    
    public TRepCnfgAvncInvCabVO(TRepCnfgAvncInvCab entidadBD) {
        this.caiEstado = entidadBD.getCaiEstado();
        this.caiFechaAlta = entidadBD.getCaiFechaAlta();
        this.caiFechaBaja = entidadBD.getCaiFechaBaja();
        this.caiFechaCambio = entidadBD.getCaiFechaCambio();
        this.caiFechaEmision = entidadBD.getCaiFechaEmision();
        this.caiId = entidadBD.getCaiId();
        this.caiMotivoDeCambio = entidadBD.getCaiMotivoDeCambio();
        this.caiNumeroDeDocumento = entidadBD.getCaiNumeroDeDocumento();
        this.caiReferencia = entidadBD.getCaiReferencia();
        this.caiTerminal = entidadBD.getCaiTerminal();
        this.caiUsuarioAlta = entidadBD.getCaiUsuarioAlta();
        this.caiUsuarioBaja = entidadBD.getCaiUsuarioBaja();
        this.caiUsuarioCambio = entidadBD.getCaiUsuarioCambio();
    }
    
    public TRepCnfgAvncInvCab devuelveEntidadBD() {
        TRepCnfgAvncInvCab entidadBD=new TRepCnfgAvncInvCab();
        entidadBD.setCaiEstado(caiEstado);
        entidadBD.setCaiFechaAlta(caiFechaAlta);
        entidadBD.setCaiFechaBaja(caiFechaBaja);
        entidadBD.setCaiFechaCambio(caiFechaCambio);
        entidadBD.setCaiFechaEmision(caiFechaEmision);
        entidadBD.setCaiId(caiId);
        entidadBD.setCaiMotivoDeCambio(caiMotivoDeCambio);
        entidadBD.setCaiNumeroDeDocumento(caiNumeroDeDocumento);
        entidadBD.setCaiReferencia(caiReferencia);
        entidadBD.setCaiTerminal(caiTerminal);
        entidadBD.setCaiUsuarioAlta(caiUsuarioAlta);
        entidadBD.setCaiUsuarioBaja(caiUsuarioBaja);
        entidadBD.setCaiUsuarioCambio(caiUsuarioCambio);
        return entidadBD;
    }

    public BigDecimal getCaiEstado() {
        return caiEstado;
    }

    public void setCaiEstado(BigDecimal caiEstado) {
        this.caiEstado = caiEstado;
    }

    public Date getCaiFechaAlta() {
        return caiFechaAlta;
    }

    public void setCaiFechaAlta(Date caiFechaAlta) {
        this.caiFechaAlta = caiFechaAlta;
    }

    public Date getCaiFechaBaja() {
        return caiFechaBaja;
    }

    public void setCaiFechaBaja(Date caiFechaBaja) {
        this.caiFechaBaja = caiFechaBaja;
    }

    public Date getCaiFechaCambio() {
        return caiFechaCambio;
    }

    public void setCaiFechaCambio(Date caiFechaCambio) {
        this.caiFechaCambio = caiFechaCambio;
    }

    public Date getCaiFechaEmision() {
        return caiFechaEmision;
    }

    public void setCaiFechaEmision(Date caiFechaEmision) {
        this.caiFechaEmision = caiFechaEmision;
    }

    public BigDecimal getCaiId() {
        return caiId;
    }

    public void setCaiId(BigDecimal caiId) {
        this.caiId = caiId;
    }

    public String getCaiMotivoDeCambio() {
        return caiMotivoDeCambio;
    }

    public void setCaiMotivoDeCambio(String caiMotivoDeCambio) {
        this.caiMotivoDeCambio = caiMotivoDeCambio;
    }

    public String getCaiNumeroDeDocumento() {
        return caiNumeroDeDocumento;
    }

    public void setCaiNumeroDeDocumento(String caiNumeroDeDocumento) {
        this.caiNumeroDeDocumento = caiNumeroDeDocumento;
    }

    public String getCaiReferencia() {
        return caiReferencia;
    }

    public void setCaiReferencia(String caiReferencia) {
        this.caiReferencia = caiReferencia;
    }

    public String getCaiTerminal() {
        return caiTerminal;
    }

    public void setCaiTerminal(String caiTerminal) {
        this.caiTerminal = caiTerminal;
    }

    public String getCaiUsuarioAlta() {
        return caiUsuarioAlta;
    }

    public void setCaiUsuarioAlta(String caiUsuarioAlta) {
        this.caiUsuarioAlta = caiUsuarioAlta;
    }

    public String getCaiUsuarioBaja() {
        return caiUsuarioBaja;
    }

    public void setCaiUsuarioBaja(String caiUsuarioBaja) {
        this.caiUsuarioBaja = caiUsuarioBaja;
    }

    public String getCaiUsuarioCambio() {
        return caiUsuarioCambio;
    }

    public void setCaiUsuarioCambio(String caiUsuarioCambio) {
        this.caiUsuarioCambio = caiUsuarioCambio;
    }
    
}
