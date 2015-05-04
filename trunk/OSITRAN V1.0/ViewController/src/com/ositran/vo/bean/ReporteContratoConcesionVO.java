package com.ositran.vo.bean;

public class ReporteContratoConcesionVO {
    
    private Integer conCsiId;//CON.CSI_ID
    private String csiNombre;// CONC.CSI_NOMBRE;
    private String cncNombre;// CONCES.CNC_NOMBRE;
    private String tinNombre;///private String TI.TIN_NOMBRE;
    private String mcoNombreModalidad;// MC.MCO_NOMBRE AS MODALIDAD;
    private String conFechaSuscripcion;//CON.CON_FECHA_SUSCRIPCION;
    private String conPlazoConcesion;//CON.CON_PLAZOCONCESION;
    private String tadTipoDocumento;//TA.TAD_NOMBRE;
    private String cadFecha;//private String CA.CAD_FECHA;
    private String cadDescripcion;// CA.CAD_DESCRIPCION;
    private String ccoPeriodo;//CC.CCO_PERIODO AS PERIODO
    private String ccoAlcance;// CC.CCO_ALCANCE;
    private String tivNomTipoInversion;// CC.TIV_ID;
    private String monMoneda;// M.MON_NOMBRE;
    private String ccoTotal;//CC.CCO_TOTAL

    public ReporteContratoConcesionVO() {
        super();
    }

    public ReporteContratoConcesionVO(Integer conCsiId, String csiNombre, String cncNombre, String tinNombre,
                                      String mcoNombreModalidad, String conFechaSuscripcion, String conPlazoConcesion,
                                      String tadTipoDocumento, String cadFecha, String cadDescripcion,
                                      String ccoPeriodo, String ccoAlcance, String tivNomTipoInversion,
                                      String monMoneda, String ccoTotal) {
        super();
        this.conCsiId = conCsiId;
        this.csiNombre = csiNombre;
        this.cncNombre = cncNombre;
        this.tinNombre = tinNombre;
        this.mcoNombreModalidad = mcoNombreModalidad;
        this.conFechaSuscripcion = conFechaSuscripcion;
        this.conPlazoConcesion = conPlazoConcesion;
        this.tadTipoDocumento = tadTipoDocumento;
        this.cadFecha = cadFecha;
        this.cadDescripcion = cadDescripcion;
        this.ccoPeriodo = ccoPeriodo;
        this.ccoAlcance = ccoAlcance;
        this.tivNomTipoInversion = tivNomTipoInversion;
        this.monMoneda = monMoneda;
        this.ccoTotal = ccoTotal;
    }

    public void setConCsiId(Integer conCsiId) {
        this.conCsiId = conCsiId;
    }

    public Integer getConCsiId() {
        return conCsiId;
    }

    public void setCsiNombre(String csiNombre) {
        this.csiNombre = csiNombre;
    }

    public String getCsiNombre() {
        return csiNombre;
    }

    public void setCncNombre(String cncNombre) {
        this.cncNombre = cncNombre;
    }

    public String getCncNombre() {
        return cncNombre;
    }

    public void setTinNombre(String tinNombre) {
        this.tinNombre = tinNombre;
    }

    public String getTinNombre() {
        return tinNombre;
    }

    public void setMcoNombreModalidad(String mcoNombreModalidad) {
        this.mcoNombreModalidad = mcoNombreModalidad;
    }

    public String getMcoNombreModalidad() {
        return mcoNombreModalidad;
    }

    public void setConFechaSuscripcion(String conFechaSuscripcion) {
        this.conFechaSuscripcion = conFechaSuscripcion;
    }

    public String getConFechaSuscripcion() {
        return conFechaSuscripcion;
    }

    public void setConPlazoConcesion(String conPlazoConcesion) {
        this.conPlazoConcesion = conPlazoConcesion;
    }

    public String getConPlazoConcesion() {
        return conPlazoConcesion;
    }

    public void setTadTipoDocumento(String tadTipoDocumento) {
        this.tadTipoDocumento = tadTipoDocumento;
    }

    public String getTadTipoDocumento() {
        return tadTipoDocumento;
    }

    public void setCadFecha(String cadFecha) {
        this.cadFecha = cadFecha;
    }

    public String getCadFecha() {
        return cadFecha;
    }

    public void setCadDescripcion(String cadDescripcion) {
        this.cadDescripcion = cadDescripcion;
    }

    public String getCadDescripcion() {
        return cadDescripcion;
    }

    public void setCcoPeriodo(String ccoPeriodo) {
        this.ccoPeriodo = ccoPeriodo;
    }

    public String getCcoPeriodo() {
        return ccoPeriodo;
    }

    public void setCcoAlcance(String ccoAlcance) {
        this.ccoAlcance = ccoAlcance;
    }

    public String getCcoAlcance() {
        return ccoAlcance;
    }

    public void setTivNomTipoInversion(String tivNomTipoInversion) {
        this.tivNomTipoInversion = tivNomTipoInversion;
    }

    public String getTivNomTipoInversion() {
        return tivNomTipoInversion;
    }

    public void setMonMoneda(String monMoneda) {
        this.monMoneda = monMoneda;
    }

    public String getMonMoneda() {
        return monMoneda;
    }

    public void setCcoTotal(String ccoTotal) {
        this.ccoTotal = ccoTotal;
    }

    public String getCcoTotal() {
        return ccoTotal;
    }
}
