package com.ositran.vo.bean;

import java.util.Date;

public class ContratoAlertaVO {
    
    private Integer caeId;
    private String calAeropuerto; 
    private Integer calDiaPresentacion;   
    private Date calFechaFin;   
    private Date calFechaInicio;
    private String calFechaFinDescripcion;
    private String calFechaInicioDescripcion;
    private String calFechaLimiteDescripcion;
    
    private Integer calId; 
    private Integer conId;
    private Integer perId;
    private Integer tinId;
    private Integer csiId;
    private Integer infId;
    private Integer invId;
    private Integer tccTipo;
    private Integer ccoId;
    private Integer mcoId;
    
    
    private String calNombreconcesion;
    

    private Integer calEstado;
    private String caeNombre;

    private Date calFechaAlta;
    private Date calFechaBaja;
    private Date calFechaCambio;
    private String calUsuarioAlta;
    private String calUsuarioBaja;
    private String calUsuarioCambio;
    private String calTerminal;

    private Date calFechaLimite;
    private Integer calTipo;
    private Integer aleDiaMes;
    private Date calPlazo;
    private String calCorreo;

    
    
    public ContratoAlertaVO() {
        super();
    }


    public Integer getCaeId() {
        return caeId;
    }

    public void setCaeId(Integer caeId) {
        this.caeId = caeId;
    }

    public String getCalAeropuerto() {
        return calAeropuerto;
    }

    public void setCalAeropuerto(String calAeropuerto) {
        this.calAeropuerto = calAeropuerto;
    }

    public Integer getCalDiaPresentacion() {
        return calDiaPresentacion;
    }

    public void setCalDiaPresentacion(Integer calDiaPresentacion) {
        this.calDiaPresentacion = calDiaPresentacion;
    }

    public Date getCalFechaFin() {
        return calFechaFin;
    }

    public void setCalFechaFin(Date calFechaFin) {
        this.calFechaFin = calFechaFin;
    }

    public Date getCalFechaInicio() {
        return calFechaInicio;
    }

    public void setCalFechaInicio(Date calFechaInicio) {
        this.calFechaInicio = calFechaInicio;
    }

    public Integer getCalId() {
        return calId;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    public String getCalNombreconcesion() {
        return calNombreconcesion;
    }

    public void setCalNombreconcesion(String calNombreconcesion) {
        this.calNombreconcesion = calNombreconcesion; 
    }

    public Date getCalPlazo() {
        return calPlazo;
    }

    public void setCalPlazo(Date calPlazo) {
        this.calPlazo = calPlazo;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Integer getCalEstado() {
        return calEstado;
    }

    public void setCalEstado(Integer calEstado) {
        this.calEstado = calEstado;
    }

    public String getCaeNombre() {
        return caeNombre;
    }

    public void setCaeNombre(String caeNombre) {
        this.caeNombre = caeNombre;
    }

    public void setCalFechaAlta(Date calFechaAlta) {
        this.calFechaAlta = calFechaAlta;
    }

    public Date getCalFechaAlta() {
        return calFechaAlta;
    }

    public void setCalFechaBaja(Date calFechaBaja) {
        this.calFechaBaja = calFechaBaja;
    }

    public Date getCalFechaBaja() {
        return calFechaBaja;
    }

    public void setCalFechaCambio(Date calFechaCambio) {
        this.calFechaCambio = calFechaCambio;
    }

    public Date getCalFechaCambio() {
        return calFechaCambio;
    }

    public void setCalUsuarioAlta(String calUsuarioAlta) {
        this.calUsuarioAlta = calUsuarioAlta;
    }

    public String getCalUsuarioAlta() {
        return calUsuarioAlta;
    }

    public void setCalUsuarioBaja(String calUsuarioBaja) {
        this.calUsuarioBaja = calUsuarioBaja;
    }

    public String getCalUsuarioBaja() {
        return calUsuarioBaja;
    }

    public void setCalUsuarioCambio(String calUsuarioCambio) {
        this.calUsuarioCambio = calUsuarioCambio;
    }

    public String getCalUsuarioCambio() {
        return calUsuarioCambio;
    }

    public void setCalTerminal(String calTerminal) {
        this.calTerminal = calTerminal;
    }

    public String getCalTerminal() {
        return calTerminal;
    }

    public void setCalFechaFinDescripcion(String calFechaFinDescripcion) {
        this.calFechaFinDescripcion = calFechaFinDescripcion;
    }

    public String getCalFechaFinDescripcion() {
        return calFechaFinDescripcion;
    }

    public void setCalFechaInicioDescripcion(String calFechaInicioDescripcion) {
        this.calFechaInicioDescripcion = calFechaInicioDescripcion;
    }

    public String getCalFechaInicioDescripcion() {
        return calFechaInicioDescripcion;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setCalFechaLimite(Date calFechaLimite) {
        this.calFechaLimite = calFechaLimite;
    }

    public Date getCalFechaLimite() {
        return calFechaLimite;
    }

    public void setCalTipo(Integer calTipo) {
        this.calTipo = calTipo;
    }

    public Integer getCalTipo() {
        return calTipo;
    }

  

    public void setAleDiaMes(Integer aleDiaMes) {
        this.aleDiaMes = aleDiaMes;
    }

    public Integer getAleDiaMes() {
        return aleDiaMes;
    }


    public void setCalCorreo(String calCorreo) {
        this.calCorreo = calCorreo;
    }

    public String getCalCorreo() {
        return calCorreo;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setTccTipo(Integer tccTipo) {
        this.tccTipo = tccTipo;
    }

    public Integer getTccTipo() {
        return tccTipo;
    }

    public void setCcoId(Integer ccoId) {
        this.ccoId = ccoId;
    }

    public Integer getCcoId() {
        return ccoId;
    }

    public void setMcoId(Integer mcoId) {
        this.mcoId = mcoId;
    }

    public Integer getMcoId() {
        return mcoId;
    }

    public void setCalFechaLimiteDescripcion(String calFechaLimiteDescripcion) {
        this.calFechaLimiteDescripcion = calFechaLimiteDescripcion;
    }

    public String getCalFechaLimiteDescripcion() {
        return calFechaLimiteDescripcion;
    }
}
