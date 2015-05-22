package com.ositran.vo.bean;

import java.io.InputStream;

import java.math.BigDecimal;

import java.util.Date;


public class InvAvnVO{
    
    private Integer conId;
    private Integer csiId;
    private Integer iaeId;
    private String iaeNombreEstado;
    private Integer invId;
    private Integer mcoId;
    private Integer monId;
    private Integer tiaAnyo;
    private String tiaAsunto;
    private Integer tiaDiasHabiles;
    private Date tiaFechaFin;
    private Date tiaFechaInicio;
    private Date tiaFechaRegistro;
    private String tiaFechaRegistroDescripcion;
    private Date tiaFechaVencimientoPlazo;
    private Integer tiaHr;
    private BigDecimal tiaMontoTotalAprobado;
    private BigDecimal tiaMontoTotalPresentado;
    private BigDecimal tiaMontoTotalReajustado;
    private int tiaNumero;
    private Integer tiaPlazoEnDías;
    private Integer tinId;
    private Integer tiaAprobadoPor;
    private String tiaRutaNot;
    private String nombreConcesion;
    private String nombreTipoInfraestructura;
    private String nombreModalidad;
    // Datos de Tablas externas
        private int moneda;
        private String estado;
        private String aprobadopor;
        private Date fechaNotificacion;        
        private String nombreMoneda;
        
    // Para Cargar Archivo
        
        private InputStream nombreFile ;
        private String periodo;
        private Integer ccoId;
        private BigDecimal total;
        private String plazo;
        private String tiaObservaciones;
        private BigDecimal tiaIgvMonto;
        private BigDecimal tiaIgv;
    public void setTiaRutaNot(String tiaRutaNot) {
        this.tiaRutaNot = tiaRutaNot;
    }

    public String getTiaRutaNot() {
        return tiaRutaNot;
    }

    public void setNombreFile(InputStream nombreFile) {
        this.nombreFile = nombreFile;
    }

    public InputStream getNombreFile() {
        return nombreFile;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setIaeId(Integer iaeId) {
        this.iaeId = iaeId;
    }

    public Integer getIaeId() {
        return iaeId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setMcoId(Integer mcoId) {
        this.mcoId = mcoId;
    }

    public Integer getMcoId() {
        return mcoId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setTiaAnyo(Integer tiaAnyo) {
        this.tiaAnyo = tiaAnyo;
    }

    public Integer getTiaAnyo() {
        return tiaAnyo;
    }

    public void setTiaAsunto(String tiaAsunto) {
        this.tiaAsunto = tiaAsunto;
    }

    public String getTiaAsunto() {
        return tiaAsunto;
    }

    public void setTiaDiasHabiles(Integer tiaDiasHabiles) {
        this.tiaDiasHabiles = tiaDiasHabiles;
    }

    public Integer getTiaDiasHabiles() {
        return tiaDiasHabiles;
    }

    public void setTiaFechaFin(Date tiaFechaFin) {
        this.tiaFechaFin = tiaFechaFin;
    }

    public Date getTiaFechaFin() {
        return tiaFechaFin;
    }

    public void setTiaFechaInicio(Date tiaFechaInicio) {
        this.tiaFechaInicio = tiaFechaInicio;
    }

    public Date getTiaFechaInicio() {
        return tiaFechaInicio;
    }

    public void setTiaFechaRegistro(Date tiaFechaRegistro) {
        this.tiaFechaRegistro = tiaFechaRegistro;
    }

    public Date getTiaFechaRegistro() {
        return tiaFechaRegistro;
    }

    public void setTiaFechaVencimientoPlazo(Date tiaFechaVencimientoPlazo) {
        this.tiaFechaVencimientoPlazo = tiaFechaVencimientoPlazo;
    }

    public Date getTiaFechaVencimientoPlazo() {
        return tiaFechaVencimientoPlazo;
    }

    public void setTiaHr(Integer tiaHr) {
        this.tiaHr = tiaHr;
    }

    public Integer getTiaHr() {
        return tiaHr;
    }

    public void setTiaMontoTotalAprobado(BigDecimal tiaMontoTotalAprobado) {
        this.tiaMontoTotalAprobado = tiaMontoTotalAprobado;
    }

    public BigDecimal getTiaMontoTotalAprobado() {
        return tiaMontoTotalAprobado;
    }

    public void setTiaMontoTotalPresentado(BigDecimal tiaMontoTotalPresentado) {
        this.tiaMontoTotalPresentado = tiaMontoTotalPresentado;
    }

    public BigDecimal getTiaMontoTotalPresentado() {
        return tiaMontoTotalPresentado;
    }

    public void setTiaMontoTotalReajustado(BigDecimal tiaMontoTotalReajustado) {
        this.tiaMontoTotalReajustado = tiaMontoTotalReajustado;
    }

    public BigDecimal getTiaMontoTotalReajustado() {
        return tiaMontoTotalReajustado;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaPlazoEnDías(Integer tiaPlazoEnDías) {
        this.tiaPlazoEnDías = tiaPlazoEnDías;
    }

    public Integer getTiaPlazoEnDías() {
        return tiaPlazoEnDías;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }


    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setAprobadopor(String aprobadopor) {
        this.aprobadopor = aprobadopor;
    }

    public String getAprobadopor() {
        return aprobadopor;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setNombreTipoInfraestructura(String nombreTipoInfraestructura) {
        this.nombreTipoInfraestructura = nombreTipoInfraestructura;
    }

    public String getNombreTipoInfraestructura() {
        return nombreTipoInfraestructura;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setTiaAprobadoPor(Integer tiaAprobadoPor) {
        this.tiaAprobadoPor = tiaAprobadoPor;
    }

    public Integer getTiaAprobadoPor() {
        return tiaAprobadoPor;
    }


    public void setIaeNombreEstado(String iaeNombreEstado) {
        this.iaeNombreEstado = iaeNombreEstado;
    }

    public String getIaeNombreEstado() {
        return iaeNombreEstado;
    }

    public void setNombreConcesion(String nombreConcesion) {
        this.nombreConcesion = nombreConcesion;
    }

    public String getNombreConcesion() {
        return nombreConcesion;
    }

    public void setNombreModalidad(String nombreModalidad) {
        this.nombreModalidad = nombreModalidad;
    }

    public String getNombreModalidad() {
        return nombreModalidad;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setCcoId(Integer ccoId) {
        this.ccoId = ccoId;
    }

    public Integer getCcoId() {
        return ccoId;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setTiaObservaciones(String tiaObservaciones) {
        this.tiaObservaciones = tiaObservaciones;
    }

    public String getTiaObservaciones() {
        return tiaObservaciones;
    }

    public void setTiaFechaRegistroDescripcion(String tiaFechaRegistroDescripcion) {
        this.tiaFechaRegistroDescripcion = tiaFechaRegistroDescripcion;
    }

    public String getTiaFechaRegistroDescripcion() {
        return tiaFechaRegistroDescripcion;
    }

    public void setTiaIgvMonto(BigDecimal tiaIgvMonto) {
        this.tiaIgvMonto = tiaIgvMonto;
    }

    public BigDecimal getTiaIgvMonto() {
        return tiaIgvMonto;
    }

    public void setTiaIgv(BigDecimal tiaIgv) {
        this.tiaIgv = tiaIgv;
    }

    public BigDecimal getTiaIgv() {
        return tiaIgv;
    }
}
