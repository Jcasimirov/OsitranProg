package com.ositran.vo.bean;

public class ReporteEmpresaSupervisoraVO {
    
    private Integer supId;
    private String supNombre;
    private String supDireccion;
    private String supCorreo;
    private String supSiglas;
    private String supTelefono;
    private String supRepresentanteLegal;
    private String supJefeSupervision;
    private String cpsFechaSuscripcion;
    private String supEstado;
    private String mcoNombre;
    private String cpsFechaInicio;
    private String cpsPlazoContrato;
    private String tinNombre;
    private String cpsMontoContratado;
    private String csiNombre;

    public ReporteEmpresaSupervisoraVO() {
        super();
    }

    public ReporteEmpresaSupervisoraVO(Integer supId, String supNombre, String supDireccion, String supCorreo,
                                       String supSiglas, String supTelefono, String supRepresentanteLegal,
                                       String supJefeSupervision, String cpsFechaSuscripcion, String supEstado,
                                       String mcoNombre, String cpsFechaInicio, String cpsPlazoContrato,
                                       String tinNombre, String cpsMontoContratado, String csiNombre) {
        super();
        this.supId = supId;
        this.supNombre = supNombre;
        this.supDireccion = supDireccion;
        this.supCorreo = supCorreo;
        this.supSiglas = supSiglas;
        this.supTelefono = supTelefono;
        this.supRepresentanteLegal = supRepresentanteLegal;
        this.supJefeSupervision = supJefeSupervision;
        this.cpsFechaSuscripcion = cpsFechaSuscripcion;
        this.supEstado = supEstado;
        this.mcoNombre = mcoNombre;
        this.cpsFechaInicio = cpsFechaInicio;
        this.cpsPlazoContrato = cpsPlazoContrato;
        this.tinNombre = tinNombre;
        this.cpsMontoContratado = cpsMontoContratado;
        this.csiNombre = csiNombre;
    }


    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupNombre(String supNombre) {
        this.supNombre = supNombre;
    }

    public String getSupNombre() {
        return supNombre;
    }

    public void setSupDireccion(String supDireccion) {
        this.supDireccion = supDireccion;
    }

    public String getSupDireccion() {
        return supDireccion;
    }

    public void setSupCorreo(String supCorreo) {
        this.supCorreo = supCorreo;
    }

    public String getSupCorreo() {
        return supCorreo;
    }

    public void setSupSiglas(String supSiglas) {
        this.supSiglas = supSiglas;
    }

    public String getSupSiglas() {
        return supSiglas;
    }

    public void setSupTelefono(String supTelefono) {
        this.supTelefono = supTelefono;
    }

    public String getSupTelefono() {
        return supTelefono;
    }

    public void setSupRepresentanteLegal(String supRepresentanteLegal) {
        this.supRepresentanteLegal = supRepresentanteLegal;
    }

    public String getSupRepresentanteLegal() {
        return supRepresentanteLegal;
    }

    public void setSupJefeSupervision(String supJefeSupervision) {
        this.supJefeSupervision = supJefeSupervision;
    }

    public String getSupJefeSupervision() {
        return supJefeSupervision;
    }

    public void setCpsFechaSuscripcion(String cpsFechaSuscripcion) {
        this.cpsFechaSuscripcion = cpsFechaSuscripcion;
    }

    public String getCpsFechaSuscripcion() {
        return cpsFechaSuscripcion;
    }

    public void setSupEstado(String supEstado) {
        this.supEstado = supEstado;
    }

    public String getSupEstado() {
        return supEstado;
    }

    public void setMcoNombre(String mcoNombre) {
        this.mcoNombre = mcoNombre;
    }

    public String getMcoNombre() {
        return mcoNombre;
    }

    public void setCpsFechaInicio(String cpsFechaInicio) {
        this.cpsFechaInicio = cpsFechaInicio;
    }

    public String getCpsFechaInicio() {
        return cpsFechaInicio;
    }

    public void setCpsPlazoContrato(String cpsPlazoContrato) {
        this.cpsPlazoContrato = cpsPlazoContrato;
    }

    public String getCpsPlazoContrato() {
        return cpsPlazoContrato;
    }

    public void setTinNombre(String tinNombre) {
        this.tinNombre = tinNombre;
    }

    public String getTinNombre() {
        return tinNombre;
    }

    public void setCpsMontoContratado(String cpsMontoContratado) {
        this.cpsMontoContratado = cpsMontoContratado;
    }

    public String getCpsMontoContratado() {
        return cpsMontoContratado;
    }

    public void setCsiNombre(String csiNombre) {
        this.csiNombre = csiNombre;
    }

    public String getCsiNombre() {
        return csiNombre;
    }

}
