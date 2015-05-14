package com.ositran.vo.bean;

import java.util.Date;


public class UsuarioVO{
    private Integer rolId;
    private String usuAlias;
    private String usuContrasenya;
    private String usuCorreo;
    private String usuDescripcion;
    private Integer usuEsexterno;
    private Integer usuEstado;
    private Date usuFechaAlta;
    private Date usuFechaBaja;
    private Date usuFechaCambio;
    private Integer usuId;
    private String usuNombre;
    private String usuTerminal;
    private String usuUsuarioAlta;
    private String usuUsuarioBaja;
    private String usuUsuarioCambio;
    private int contador;
    private Integer supInvId;
  
    
    //Atributo Rol
    private String nombreRol;
    private String nombreInfra;
    
    public UsuarioVO(){
        }


    public UsuarioVO(Integer rolId, String usuAlias, String usuContrasenya, String usuCorreo, String usuDescripcion,
                     Integer usuEsexterno, Integer usuEstado, Date usuFechaAlta, Date usuFechaBaja, Date usuFechaCambio,
                     Integer usuId, String usuNombre, String usuTerminal, String usuUsuarioAlta, String usuUsuarioBaja,
                     String usuUsuarioCambio, int contador, Integer supInvId,  String nombreRol,
                     String nombreInfra) {
        super();
        this.rolId = rolId;
        this.usuAlias = usuAlias;
        this.usuContrasenya = usuContrasenya;
        this.usuCorreo = usuCorreo;
        this.usuDescripcion = usuDescripcion;
        this.usuEsexterno = usuEsexterno;
        this.usuEstado = usuEstado;
        this.usuFechaAlta = usuFechaAlta;
        this.usuFechaBaja = usuFechaBaja;
        this.usuFechaCambio = usuFechaCambio;
        this.usuId = usuId;
        this.usuNombre = usuNombre;
        this.usuTerminal = usuTerminal;
        this.usuUsuarioAlta = usuUsuarioAlta;
        this.usuUsuarioBaja = usuUsuarioBaja;
        this.usuUsuarioCambio = usuUsuarioCambio;
        this.contador = contador;
        this.supInvId = supInvId;

        this.nombreRol = nombreRol;
        this.nombreInfra = nombreInfra;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setUsuAlias(String usuAlias) {
        this.usuAlias = usuAlias;
    }

    public String getUsuAlias() {
        return usuAlias;
    }

    public void setUsuContrasenya(String usuContrasenya) {
        this.usuContrasenya = usuContrasenya;
    }

    public String getUsuContrasenya() {
        return usuContrasenya;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuDescripcion(String usuDescripcion) {
        this.usuDescripcion = usuDescripcion;
    }

    public String getUsuDescripcion() {
        return usuDescripcion;
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

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setSupInvId(Integer supInvId) {
        this.supInvId = supInvId;
    }

    public Integer getSupInvId() {
        return supInvId;
    }

 

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreInfra(String nombreInfra) {
        this.nombreInfra = nombreInfra;
    }

    public String getNombreInfra() {
        return nombreInfra;
    }

}
