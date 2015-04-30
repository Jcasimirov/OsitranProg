package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({
              @NamedQuery(name = "ValorizacionNotificacion.findAll",
                          query = "select o from ValorizacionNotificacion o") })
@Table(name = "T_VALORIZACION_NOTIFICACION")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_VALORIZACION_NOTIFICACION"))
public class ValorizacionNotificacion implements Serializable {
    private static final long serialVersionUID = -3642854306280392028L;
    @Column(name = "ITR_ID")
    private Integer itrId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "TIA_NUMERO")
    private Integer tiaNumero;
    @Column(name = "TIN_ID")
    private Integer tinId;
    @Column(name = "VAN_ANYO_HR", nullable = false)
    private Integer vanAnyoHr;
    @Column(name = "VAN_ARCHIVO_CARGO")
    private String vanArchivoCargo;
    @Column(name = "VAN_ARCHIVO_INVERSION")
    private String vanArchivoInversion;
    @Column(name = "VAN_ESTADO", nullable = false)
    private Integer vanEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "VAN_FECHA_ALTA", nullable = false)
    private Date vanFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "VAN_FECHA_BAJA")
    private Date vanFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "VAN_FECHA_CAMBIO")
    private Date vanFechaCambio;
    @Temporal(TemporalType.DATE)
    @Column(name = "VAN_FECHA_NOTIFICACION")
    private Date vanFechaNotificacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "VAN_FECHA_REGISTRO")
    private Date vanFechaRegistro;
    @Id
    @Column(name = "VAN_ID", nullable = false)
    @GeneratedValue(generator = "generator")
    private Integer vanId;
    @Column(name = "VAN_NRO_CARGO", length = 50)
    private String vanNroCargo;
    @Column(name = "VAN_NRO_HR", nullable = false)
    private Integer vanNroHr;
    @Column(name = "VAN_TERMINAL", length = 20)
    private String vanTerminal;
    @Column(name = "VAN_TOTAL_PRESENTADO", nullable = false)
    private BigDecimal vanTotalPresentado;
    @Column(name = "VAN_TOTAL_RECONOCIDO", nullable = false)
    private BigDecimal vanTotalReconocido;
    @Column(name = "VAN_USUARIO_ALTA", length = 20)
    private String vanUsuarioAlta;
    @Column(name = "VAN_USUARIO_BAJA", length = 20)
    private String vanUsuarioBaja;
    @Column(name = "VAN_USUARIO_CAMBIO", length = 20)
    private String vanUsuarioCambio;

    public ValorizacionNotificacion() {
    }

    public ValorizacionNotificacion(Integer itrId, Integer monId, Integer tiaNumero, Integer tinId,
                                    Integer vanAnyoHr, String vanArchivoCargo, String vanArchivoInversion,
                                    Integer vanEstado, Date vanFechaAlta, Date vanFechaBaja, Date vanFechaCambio,
                                    Date vanFechaNotificacion, Date vanFechaRegistro, Integer vanId,
                                    String vanNroCargo, Integer vanNroHr, String vanTerminal,
                                    BigDecimal vanTotalPresentado, BigDecimal vanTotalReconocido, String vanUsuarioAlta,
                                    String vanUsuarioBaja, String vanUsuarioCambio) {
        this.itrId = itrId;
        this.monId = monId;
        this.tiaNumero = tiaNumero;
        this.tinId = tinId;
        this.vanAnyoHr = vanAnyoHr;
        this.vanArchivoCargo = vanArchivoCargo;
        this.vanArchivoInversion = vanArchivoInversion;
        this.vanEstado = vanEstado;
        this.vanFechaAlta = vanFechaAlta;
        this.vanFechaBaja = vanFechaBaja;
        this.vanFechaCambio = vanFechaCambio;
        this.vanFechaNotificacion = vanFechaNotificacion;
        this.vanFechaRegistro = vanFechaRegistro;
        this.vanId = vanId;
        this.vanNroCargo = vanNroCargo;
        this.vanNroHr = vanNroHr;
        this.vanTerminal = vanTerminal;
        this.vanTotalPresentado = vanTotalPresentado;
        this.vanTotalReconocido = vanTotalReconocido;
        this.vanUsuarioAlta = vanUsuarioAlta;
        this.vanUsuarioBaja = vanUsuarioBaja;
        this.vanUsuarioCambio = vanUsuarioCambio;
    }

    public void setItrId(Integer itrId) {
        this.itrId = itrId;
    }

    public Integer getItrId() {
        return itrId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setTiaNumero(Integer tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public Integer getTiaNumero() {
        return tiaNumero;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setVanAnyoHr(Integer vanAnyoHr) {
        this.vanAnyoHr = vanAnyoHr;
    }

    public Integer getVanAnyoHr() {
        return vanAnyoHr;
    }

    public void setVanArchivoCargo(String vanArchivoCargo) {
        this.vanArchivoCargo = vanArchivoCargo;
    }

    public String getVanArchivoCargo() {
        return vanArchivoCargo;
    }

    public void setVanArchivoInversion(String vanArchivoInversion) {
        this.vanArchivoInversion = vanArchivoInversion;
    }

    public String getVanArchivoInversion() {
        return vanArchivoInversion;
    }

    public void setVanEstado(Integer vanEstado) {
        this.vanEstado = vanEstado;
    }

    public Integer getVanEstado() {
        return vanEstado;
    }

    public void setVanFechaAlta(Date vanFechaAlta) {
        this.vanFechaAlta = vanFechaAlta;
    }

    public Date getVanFechaAlta() {
        return vanFechaAlta;
    }

    public void setVanFechaBaja(Date vanFechaBaja) {
        this.vanFechaBaja = vanFechaBaja;
    }

    public Date getVanFechaBaja() {
        return vanFechaBaja;
    }

    public void setVanFechaCambio(Date vanFechaCambio) {
        this.vanFechaCambio = vanFechaCambio;
    }

    public Date getVanFechaCambio() {
        return vanFechaCambio;
    }

    public void setVanFechaNotificacion(Date vanFechaNotificacion) {
        this.vanFechaNotificacion = vanFechaNotificacion;
    }

    public Date getVanFechaNotificacion() {
        return vanFechaNotificacion;
    }

    public void setVanFechaRegistro(Date vanFechaRegistro) {
        this.vanFechaRegistro = vanFechaRegistro;
    }

    public Date getVanFechaRegistro() {
        return vanFechaRegistro;
    }

    public void setVanId(Integer vanId) {
        this.vanId = vanId;
    }

    public Integer getVanId() {
        return vanId;
    }

    public void setVanNroCargo(String vanNroCargo) {
        this.vanNroCargo = vanNroCargo;
    }

    public String getVanNroCargo() {
        return vanNroCargo;
    }

    public void setVanNroHr(Integer vanNroHr) {
        this.vanNroHr = vanNroHr;
    }

    public Integer getVanNroHr() {
        return vanNroHr;
    }

    public void setVanTerminal(String vanTerminal) {
        this.vanTerminal = vanTerminal;
    }

    public String getVanTerminal() {
        return vanTerminal;
    }

    public void setVanTotalPresentado(BigDecimal vanTotalPresentado) {
        this.vanTotalPresentado = vanTotalPresentado;
    }

    public BigDecimal getVanTotalPresentado() {
        return vanTotalPresentado;
    }

    public void setVanTotalReconocido(BigDecimal vanTotalReconocido) {
        this.vanTotalReconocido = vanTotalReconocido;
    }

    public BigDecimal getVanTotalReconocido() {
        return vanTotalReconocido;
    }

    public void setVanUsuarioAlta(String vanUsuarioAlta) {
        this.vanUsuarioAlta = vanUsuarioAlta;
    }

    public String getVanUsuarioAlta() {
        return vanUsuarioAlta;
    }

    public void setVanUsuarioBaja(String vanUsuarioBaja) {
        this.vanUsuarioBaja = vanUsuarioBaja;
    }

    public String getVanUsuarioBaja() {
        return vanUsuarioBaja;
    }

    public void setVanUsuarioCambio(String vanUsuarioCambio) {
        this.vanUsuarioCambio = vanUsuarioCambio;
    }

    public String getVanUsuarioCambio() {
        return vanUsuarioCambio;
    }
}
