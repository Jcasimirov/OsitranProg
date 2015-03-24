package com.ositran.model;

import java.io.Serializable;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

@Entity
@Table(name = "VW_SUPERVISORINVERSIONES")
public class VSupInv implements Serializable {
    private static final long serialVersionUID = -8154584022329658272L;
    @Column(name = "CRG_ID")
    private int crgId;
    @Column(name = "TDO_ID")
    private int tdoId;
    @Column(name = "TIN_ID")
    private int tinId;
    @Column(name = "TSI_CORREO", length = 20)
    private String tsiCorreo;
    @Column(name = "TSI_DESCRIPCION", length = 100)
    private String tsiDescripcion;
    @Column(name = "TSI_DIRECCION", length = 20)
    private String tsiDireccion;
    @Column(name = "TSI_ENCARGADO", nullable = false)
    private int tsiEncargado;
    @Column(name = "TSI_ESTADO", nullable = false)
    private int tsiEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "TSI_FECHA_ALTA", nullable = false)
    private Date tsiFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "TSI_FECHA_BAJA")
    private Date tsiFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "TSI_FECHA_CAMBIO")
    private Date tsiFechaCambio;
    @Column(name = "TSI_HABILITADO", nullable = false)
    private int tsiHabilitado;
    @Id
    @Column(name = "TSI_ID", nullable = false)
    private int tsiId;
    @Column(name = "TSI_NOMBRE", nullable = false, length = 100)
    private String tsiNombre;
    @Column(name = "TSI_NRO_DOCUMENTO", length = 20)
    private String tsiNroDocumento;
    @Column(name = "TSI_SIGLAS", nullable = false, length = 4000)
    private String tsiSiglas;
    @Column(name = "TSI_TELEFONO", length = 20)
    private String tsiTelefono;
    @Column(name = "TSI_TERMINAL", length = 20)
    private String tsiTerminal;
    @Column(name = "TSI_USUARIO_ALTA", length = 20)
    private String tsiUsuarioAlta;
    @Column(name = "TSI_USUARIO_BAJA", length = 20)
    private String tsiUsuarioBaja;
    @Column(name = "TSI_USUARIO_CAMBIO", length = 20)
    private String tsiUsuarioCambio;

    public VSupInv() {
    }

    public VSupInv(int crgId, int tdoId, int tinId, String tsiCorreo, String tsiDescripcion,
                        String tsiDireccion, int tsiEncargado, int tsiEstado, Date tsiFechaAlta,
                        Date tsiFechaBaja, Date tsiFechaCambio, int tsiHabilitado, int tsiId,
                        String tsiNombre, String tsiNroDocumento, String tsiSiglas, String tsiTelefono,
                        String tsiTerminal, String tsiUsuarioAlta, String tsiUsuarioBaja, String tsiUsuarioCambio) {
        this.crgId = crgId;
        this.tdoId = tdoId;
        this.tinId = tinId;
        this.tsiCorreo = tsiCorreo;
        this.tsiDescripcion = tsiDescripcion;
        this.tsiDireccion = tsiDireccion;
        this.tsiEncargado = tsiEncargado;
        this.tsiEstado = tsiEstado;
        this.tsiFechaAlta = tsiFechaAlta;
        this.tsiFechaBaja = tsiFechaBaja;
        this.tsiFechaCambio = tsiFechaCambio;
        this.tsiHabilitado = tsiHabilitado;
        this.tsiId = tsiId;
        this.tsiNombre = tsiNombre;
        this.tsiNroDocumento = tsiNroDocumento;
        this.tsiSiglas = tsiSiglas;
        this.tsiTelefono = tsiTelefono;
        this.tsiTerminal = tsiTerminal;
        this.tsiUsuarioAlta = tsiUsuarioAlta;
        this.tsiUsuarioBaja = tsiUsuarioBaja;
        this.tsiUsuarioCambio = tsiUsuarioCambio;
    }

    public int getCrgId() {
        return crgId;
    }

    public void setCrgId(int crgId) {
        this.crgId = crgId;
    }

    public int getTdoId() {
        return tdoId;
    }

    public void setTdoId(int tdoId) {
        this.tdoId = tdoId;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }

    public String getTsiCorreo() {
        return tsiCorreo;
    }

    public void setTsiCorreo(String tsiCorreo) {
        this.tsiCorreo = tsiCorreo;
    }

    public String getTsiDescripcion() {
        return tsiDescripcion;
    }

    public void setTsiDescripcion(String tsiDescripcion) {
        this.tsiDescripcion = tsiDescripcion;
    }

    public String getTsiDireccion() {
        return tsiDireccion;
    }

    public void setTsiDireccion(String tsiDireccion) {
        this.tsiDireccion = tsiDireccion;
    }

    public int getTsiEncargado() {
        return tsiEncargado;
    }

    public void setTsiEncargado(int tsiEncargado) {
        this.tsiEncargado = tsiEncargado;
    }

    public int getTsiEstado() {
        return tsiEstado;
    }

    public void setTsiEstado(int tsiEstado) {
        this.tsiEstado = tsiEstado;
    }

    public Date getTsiFechaAlta() {
        return tsiFechaAlta;
    }

    public void setTsiFechaAlta(Date tsiFechaAlta) {
        this.tsiFechaAlta = tsiFechaAlta;
    }

    public Date getTsiFechaBaja() {
        return tsiFechaBaja;
    }

    public void setTsiFechaBaja(Date tsiFechaBaja) {
        this.tsiFechaBaja = tsiFechaBaja;
    }

    public Date getTsiFechaCambio() {
        return tsiFechaCambio;
    }

    public void setTsiFechaCambio(Date tsiFechaCambio) {
        this.tsiFechaCambio = tsiFechaCambio;
    }

    public int getTsiHabilitado() {
        return tsiHabilitado;
    }

    public void setTsiHabilitado(int tsiHabilitado) {
        this.tsiHabilitado = tsiHabilitado;
    }

    public int getTsiId() {
        return tsiId;
    }

    public void setTsiId(int tsiId) {
        this.tsiId = tsiId;
    }

    public String getTsiNombre() {
        return tsiNombre;
    }

    public void setTsiNombre(String tsiNombre) {
        this.tsiNombre = tsiNombre;
    }

    public String getTsiNroDocumento() {
        return tsiNroDocumento;
    }

    public void setTsiNroDocumento(String tsiNroDocumento) {
        this.tsiNroDocumento = tsiNroDocumento;
    }

    public String getTsiSiglas() {
        return tsiSiglas;
    }

    public void setTsiSiglas(String tsiSiglas) {
        this.tsiSiglas = tsiSiglas;
    }

    public String getTsiTelefono() {
        return tsiTelefono;
    }

    public void setTsiTelefono(String tsiTelefono) {
        this.tsiTelefono = tsiTelefono;
    }

    public String getTsiTerminal() {
        return tsiTerminal;
    }

    public void setTsiTerminal(String tsiTerminal) {
        this.tsiTerminal = tsiTerminal;
    }

    public String getTsiUsuarioAlta() {
        return tsiUsuarioAlta;
    }

    public void setTsiUsuarioAlta(String tsiUsuarioAlta) {
        this.tsiUsuarioAlta = tsiUsuarioAlta;
    }

    public String getTsiUsuarioBaja() {
        return tsiUsuarioBaja;
    }

    public void setTsiUsuarioBaja(String tsiUsuarioBaja) {
        this.tsiUsuarioBaja = tsiUsuarioBaja;
    }

    public String getTsiUsuarioCambio() {
        return tsiUsuarioCambio;
    }

    public void setTsiUsuarioCambio(String tsiUsuarioCambio) {
        this.tsiUsuarioCambio = tsiUsuarioCambio;
    }
}
