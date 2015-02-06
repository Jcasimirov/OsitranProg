package com.ositran.vo.bean;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class UsuarioVO implements Serializable {
        private static final long serialVersionUID = 616782273879451829L;
        private BigDecimal crgId;
        private BigDecimal rolId;
        private String usuContrasenya;
        private BigDecimal usuEsexterno;
        private BigDecimal usuEstado;
        private Date usuFechaAlta;
        private Date usuFechaBaja;
        private Date usuFechaCambio;
        private Integer usuId;
        private String usuNombre;
        private String usuTerminal;
        private String usuUsuarioAlta;
        private String usuUsuarioBaja;
        private String usuUsuarioCambio;

    
    public UsuarioVO() {
        super();
    }

    public void setCrgId(BigDecimal crgId) {
        this.crgId = crgId;
    }

    public BigDecimal getCrgId() {
        return crgId;
    }

    public void setRolId(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public BigDecimal getRolId() {
        return rolId;
    }

    public void setUsuContrasenya(String usuContrasenya) {
        this.usuContrasenya = usuContrasenya;
    }

    public String getUsuContrasenya() {
        return usuContrasenya;
    }

    public void setUsuEsexterno(BigDecimal usuEsexterno) {
        this.usuEsexterno = usuEsexterno;
    }

    public BigDecimal getUsuEsexterno() {
        return usuEsexterno;
    }

    public void setUsuEstado(BigDecimal usuEstado) {
        this.usuEstado = usuEstado;
    }

    public BigDecimal getUsuEstado() {
        return usuEstado;
    }

    public void setUsuFechaAlta(Date usuFechaAlta) {
        this.usuFechaAlta = usuFechaAlta;
    }

    public Date getUsuFechaAlta() {
        return usuFechaAlta;
    }

    public void setUsuFechaBaja(Date usuFechaBaja) {
        this.usuFechaBaja = usuFechaBaja;
    }

    public Date getUsuFechaBaja() {
        return usuFechaBaja;
    }

    public void setUsuFechaCambio(Date usuFechaCambio) {
        this.usuFechaCambio = usuFechaCambio;
    }

    public Date getUsuFechaCambio() {
        return usuFechaCambio;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuTerminal(String usuTerminal) {
        this.usuTerminal = usuTerminal;
    }

    public String getUsuTerminal() {
        return usuTerminal;
    }

    public void setUsuUsuarioAlta(String usuUsuarioAlta) {
        this.usuUsuarioAlta = usuUsuarioAlta;
    }

    public String getUsuUsuarioAlta() {
        return usuUsuarioAlta;
    }

    public void setUsuUsuarioBaja(String usuUsuarioBaja) {
        this.usuUsuarioBaja = usuUsuarioBaja;
    }

    public String getUsuUsuarioBaja() {
        return usuUsuarioBaja;
    }

    public void setUsuUsuarioCambio(String usuUsuarioCambio) {
        this.usuUsuarioCambio = usuUsuarioCambio;
    }

    public String getUsuUsuarioCambio() {
        return usuUsuarioCambio;
    }


}
