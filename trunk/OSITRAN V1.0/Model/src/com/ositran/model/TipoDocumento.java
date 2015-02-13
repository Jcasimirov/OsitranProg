package com.ositran.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "T_TIPO_DOCUMENTO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_TIPO_DOCUMENTO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "TipoDocumento.findAll", query = "select o from TipoDocumento o") })
@Table(name = "T_TIPO_DOCUMENTO")
@SequenceGenerator(name = "TipoDocumento_Id_Seq_Gen", sequenceName = "T_TIPO_DOCUMENTO_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 5818531903952105836L;
    @Column(name = "TDO_DESCRIPCION", nullable = false, length = 100)
    private String tdoDescripcion;
    @Column(name = "TDO_ESTADO", nullable = false)
    private Integer tdoEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "TDO_FECHA_ALTA")
    private Date tdoFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "TDO_FECHA_BAJA")
    private Date tdoFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "TDO_FECHA_CAMBIO")
    private Date tdoFechaCambio;
    @Id
    @Column(name = "TDO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TipoDocumento_Id_Seq_Gen")
    private Integer tdoId;
    @Column(name = "TDO_NOMBRE", nullable = false, length = 100)
    private String tdoNombre;
    @Column(name = "TDO_TERMINAL", length = 20)
    private String tdoTerminal;
    @Column(name = "TDO_USUARIO_ALTA", length = 20)
    private String tdoUsuarioAlta;
    @Column(name = "TDO_USUARIO_BAJA", length = 20)
    private String tdoUsuarioBaja;
    @Column(name = "TDO_USUARIO_CAMBIO", length = 20)
    private String tdoUsuarioCambio;

    public TipoDocumento() {
    }

    public TipoDocumento(String tdoDescripcion, Integer tdoEstado, Date tdoFechaAlta, Date tdoFechaBaja,
                         Date tdoFechaCambio, Integer tdoId, String tdoNombre, String tdoTerminal,
                         String tdoUsuarioAlta, String tdoUsuarioBaja, String tdoUsuarioCambio) {
        this.tdoDescripcion = tdoDescripcion;
        this.tdoEstado = tdoEstado;
        this.tdoFechaAlta = tdoFechaAlta;
        this.tdoFechaBaja = tdoFechaBaja;
        this.tdoFechaCambio = tdoFechaCambio;
        this.tdoId = tdoId;
        this.tdoNombre = tdoNombre;
        this.tdoTerminal = tdoTerminal;
        this.tdoUsuarioAlta = tdoUsuarioAlta;
        this.tdoUsuarioBaja = tdoUsuarioBaja;
        this.tdoUsuarioCambio = tdoUsuarioCambio;
    }

    public String getTdoDescripcion() {
        return tdoDescripcion;
    }

    public void setTdoDescripcion(String tdoDescripcion) {
        this.tdoDescripcion = tdoDescripcion;
    }

    public Integer getTdoEstado() {
        return tdoEstado;
    }

    public void setTdoEstado(Integer tdoEstado) {
        this.tdoEstado = tdoEstado;
    }

    public Date getTdoFechaAlta() {
        return tdoFechaAlta;
    }

    public void setTdoFechaAlta(Date tdoFechaAlta) {
        this.tdoFechaAlta = tdoFechaAlta;
    }

    public Date getTdoFechaBaja() {
        return tdoFechaBaja;
    }

    public void setTdoFechaBaja(Date tdoFechaBaja) {
        this.tdoFechaBaja = tdoFechaBaja;
    }

    public Date getTdoFechaCambio() {
        return tdoFechaCambio;
    }

    public void setTdoFechaCambio(Date tdoFechaCambio) {
        this.tdoFechaCambio = tdoFechaCambio;
    }

    public Integer getTdoId() {
        return tdoId;
    }

    public String getTdoNombre() {
        return tdoNombre;
    }

    public void setTdoNombre(String tdoNombre) {
        this.tdoNombre = tdoNombre;
    }

    public String getTdoTerminal() {
        return tdoTerminal;
    }

    public void setTdoTerminal(String tdoTerminal) {
        this.tdoTerminal = tdoTerminal;
    }

    public String getTdoUsuarioAlta() {
        return tdoUsuarioAlta;
    }

    public void setTdoUsuarioAlta(String tdoUsuarioAlta) {
        this.tdoUsuarioAlta = tdoUsuarioAlta;
    }

    public String getTdoUsuarioBaja() {
        return tdoUsuarioBaja;
    }

    public void setTdoUsuarioBaja(String tdoUsuarioBaja) {
        this.tdoUsuarioBaja = tdoUsuarioBaja;
    }

    public String getTdoUsuarioCambio() {
        return tdoUsuarioCambio;
    }

    public void setTdoUsuarioCambio(String tdoUsuarioCambio) {
        this.tdoUsuarioCambio = tdoUsuarioCambio;
    }

    public void setTdoId(Integer tdoId) {
        this.tdoId = tdoId;
    }
}
