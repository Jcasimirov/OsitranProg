package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
              @NamedQuery(name = "InversionTipoDescripcion.findAll",
                          query = "select o from InversionTipoDescripcion o") })
@Table(name = "T_INVERSION_TIPO_DESCRIPCION")
public class InversionTipoDescripcion implements Serializable {
    private static final long serialVersionUID = 35556266185801467L;
    @Column(name = "ITD_DESCRIPCION", nullable = false, length = 100)
    private String itdDescripcion;
    @Column(name = "ITD_ESTADO", nullable = false)
    private BigDecimal itdEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "ITD_FECHA_ALTA")
    private Date itdFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "ITD_FECHA_BAJA")
    private Date itdFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "ITD_FECHA_CAMBIO")
    private Date itdFechaCambio;
    @Column(name = "ITD_ID", nullable = false)
    private BigDecimal itdId;
    @Column(name = "ITD_NOMBRE", nullable = false, length = 100)
    private String itdNombre;
    @Column(name = "ITD_TERMINAL", length = 20)
    private String itdTerminal;
    @Column(name = "ITD_USUARIO_ALTA", length = 20)
    private String itdUsuarioAlta;
    @Column(name = "ITD_USUARIO_BAJA", length = 20)
    private String itdUsuarioBaja;
    @Column(name = "ITD_USUARIO_CAMBIO", length = 20)
    private String itdUsuarioCambio;
    @Column(name = "TIV_ID", nullable = false)
    private BigDecimal tivId;

    public InversionTipoDescripcion() {
    }

    public InversionTipoDescripcion(String itdDescripcion, BigDecimal itdEstado, Date itdFechaAlta, Date itdFechaBaja,
                                    Date itdFechaCambio, BigDecimal itdId, String itdNombre, String itdTerminal,
                                    String itdUsuarioAlta, String itdUsuarioBaja, String itdUsuarioCambio,
                                    BigDecimal tivId) {
        this.itdDescripcion = itdDescripcion;
        this.itdEstado = itdEstado;
        this.itdFechaAlta = itdFechaAlta;
        this.itdFechaBaja = itdFechaBaja;
        this.itdFechaCambio = itdFechaCambio;
        this.itdId = itdId;
        this.itdNombre = itdNombre;
        this.itdTerminal = itdTerminal;
        this.itdUsuarioAlta = itdUsuarioAlta;
        this.itdUsuarioBaja = itdUsuarioBaja;
        this.itdUsuarioCambio = itdUsuarioCambio;
        this.tivId = tivId;
    }

    public String getItdDescripcion() {
        return itdDescripcion;
    }

    public void setItdDescripcion(String itdDescripcion) {
        this.itdDescripcion = itdDescripcion;
    }

    public BigDecimal getItdEstado() {
        return itdEstado;
    }

    public void setItdEstado(BigDecimal itdEstado) {
        this.itdEstado = itdEstado;
    }

    public Date getItdFechaAlta() {
        return itdFechaAlta;
    }

    public void setItdFechaAlta(Date itdFechaAlta) {
        this.itdFechaAlta = itdFechaAlta;
    }

    public Date getItdFechaBaja() {
        return itdFechaBaja;
    }

    public void setItdFechaBaja(Date itdFechaBaja) {
        this.itdFechaBaja = itdFechaBaja;
    }

    public Date getItdFechaCambio() {
        return itdFechaCambio;
    }

    public void setItdFechaCambio(Date itdFechaCambio) {
        this.itdFechaCambio = itdFechaCambio;
    }

    public BigDecimal getItdId() {
        return itdId;
    }

    public void setItdId(BigDecimal itdId) {
        this.itdId = itdId;
    }

    public String getItdNombre() {
        return itdNombre;
    }

    public void setItdNombre(String itdNombre) {
        this.itdNombre = itdNombre;
    }

    public String getItdTerminal() {
        return itdTerminal;
    }

    public void setItdTerminal(String itdTerminal) {
        this.itdTerminal = itdTerminal;
    }

    public String getItdUsuarioAlta() {
        return itdUsuarioAlta;
    }

    public void setItdUsuarioAlta(String itdUsuarioAlta) {
        this.itdUsuarioAlta = itdUsuarioAlta;
    }

    public String getItdUsuarioBaja() {
        return itdUsuarioBaja;
    }

    public void setItdUsuarioBaja(String itdUsuarioBaja) {
        this.itdUsuarioBaja = itdUsuarioBaja;
    }

    public String getItdUsuarioCambio() {
        return itdUsuarioCambio;
    }

    public void setItdUsuarioCambio(String itdUsuarioCambio) {
        this.itdUsuarioCambio = itdUsuarioCambio;
    }

    public BigDecimal getTivId() {
        return tivId;
    }

    public void setTivId(BigDecimal tivId) {
        this.tivId = tivId;
    }
}
