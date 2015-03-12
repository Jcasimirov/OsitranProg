package com.ositran.vo.bean;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class UsuarioVO{
    private Integer crgId;
    private Integer rolId;
    private String usuContrasenya;
    private Integer usuEsexterno;
    private Integer usuEstado;
    private Date usuFechaAlta;
    private Date usuFechaBaja;
    private Date usuFechaCambio;
    private Integer usuId;
    private String usuNombre;
    private String usuCorreo;
    private String usuTerminal;
    private String usuUsuario;
    private String usuUsuarioAlta;
    private String usuUsuarioBaja;
    private String usuUsuarioCambio;

    
    public UsuarioVO() {
        super();
    }


    public UsuarioVO(Integer crgId, Integer rolId, String usuContrasenya, Integer usuEsexterno, Integer usuEstado,
                     Date usuFechaAlta, Date usuFechaBaja, Date usuFechaCambio, Integer usuId, String usuNombre,
                     String usuCorreo, String usuTerminal, String usuUsuario, String usuUsuarioAlta, String usuUsuarioBaja,
                     String usuUsuarioCambio) {
        super();
        this.crgId = crgId;
        this.rolId = rolId;
        this.usuContrasenya = usuContrasenya;
        this.usuEsexterno = usuEsexterno;
        this.usuEstado = usuEstado;
        this.usuFechaAlta = usuFechaAlta;
        this.usuFechaBaja = usuFechaBaja;
        this.usuFechaCambio = usuFechaCambio;
        this.usuId = usuId;
        this.usuNombre = usuNombre;
        this.usuCorreo = usuCorreo;
        this.usuTerminal = usuTerminal;
        this.usuUsuario = usuUsuario;
        this.usuUsuarioAlta = usuUsuarioAlta;
        this.usuUsuarioBaja = usuUsuarioBaja;
        this.usuUsuarioCambio = usuUsuarioCambio;
    }


    public void setCrgId(Integer crgId) {
        this.crgId = crgId;
    }

    public Integer getCrgId() {
        return crgId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setUsuContrasenya(String usuContrasenya) {
        this.usuContrasenya = usuContrasenya;
    }

    public String getUsuContrasenya() {
        return usuContrasenya;
    }

    public void setUsuEsexterno(Integer usuEsexterno) {
        this.usuEsexterno = usuEsexterno;
    }

    public Integer getUsuEsexterno() {
        return usuEsexterno;
    }

    public void setUsuEstado(Integer usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Integer getUsuEstado() {
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


    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuTerminal(String usuTerminal) {
        this.usuTerminal = usuTerminal;
    }

    public String getUsuTerminal() {
        return usuTerminal;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuUsuario() {
        return usuUsuario;
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
