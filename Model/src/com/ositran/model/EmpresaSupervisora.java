package com.ositran.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * To create ID generator sequence "T_EMPRESA_SUPERVISORA_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_EMPRESA_SUPERVISORA_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "EmpresaSupervisora.findAll", query = "select o from EmpresaSupervisora o") })
@Table(name = "T_EMPRESA_SUPERVISORA")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_EMPRESA_SUPERVISORA"))

public class EmpresaSupervisora implements Serializable {
    private static final long serialVersionUID = -5138390938685448144L;
    @Column(name = "SUP_CORREO", length = 100)
    private String supCorreo;
    @Column(name = "SUP_DIRECCION", length = 100)
    private String supDireccion;
    @Column(name = "SUP_ESTADO", nullable = false)
    private Integer supEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "SUP_FECHA_ALTA", nullable = false)
    private Date supFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "SUP_FECHA_BAJA")
    private Date supFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "SUP_FECHA_CAMBIO")
    private Date supFechaCambio;
    @Id
    @Column(name = "SUP_ID", nullable = false)
    @GeneratedValue(generator = "generator")
    private Integer supId;
    @Column(name = "SUP_JEFE_SUPERVISION", length = 1000)
    private String supJefeSupervision;
    @Column(name = "SUP_NOMBRE", nullable = false, length = 100)
    private String supNombre;
    @Column(name = "SUP_NRO_DOCUMENTO", length = 20)
    private String supNroDocumento;
    @Column(name = "SUP_OBRA", length = 4000)
    private String supObra;
    @Column(name = "SUP_REPRESENTANTE_LEGAL", length = 100)
    private String supRepresentanteLegal;
    @Column(name = "SUP_SIGLAS", nullable = false, length = 100)
    private String supSiglas;
    @Column(name = "SUP_TELEFONO", length = 15)
    private String supTelefono;
    @Column(name = "SUP_TERMINAL", length = 20)
    private String supTerminal;
    @Column(name = "SUP_USUARIO_ALTA", length = 20)
    private String supUsuarioAlta;
    @Column(name = "SUP_USUARIO_BAJA", length = 20)
    private String supUsuarioBaja;
    @Column(name = "SUP_USUARIO_CAMBIO", length = 20)
    private String supUsuarioCambio;
    @Column(name = "TDO_ID")
    private Integer tdoId;

    public EmpresaSupervisora() {
    }

    public EmpresaSupervisora(String supCorreo, String supDireccion, Integer supEstado, Date supFechaAlta,
                               Date supFechaBaja, Date supFechaCambio, Integer supId, String supJefeSupervision,
                               String supNombre, String supNroDocumento, String supObra, String supRepresentanteLegal,
                               String supSiglas, String supTelefono, String supTerminal, String supUsuarioAlta,
                               String supUsuarioBaja, String supUsuarioCambio, Integer tdoId) {
        this.supCorreo = supCorreo;
        this.supDireccion = supDireccion;
        this.supEstado = supEstado;
        this.supFechaAlta = supFechaAlta;
        this.supFechaBaja = supFechaBaja;
        this.supFechaCambio = supFechaCambio;
        this.supId = supId;
        this.supJefeSupervision = supJefeSupervision;
        this.supNombre = supNombre;
        this.supNroDocumento = supNroDocumento;
        this.supObra = supObra;
        this.supRepresentanteLegal = supRepresentanteLegal;
        this.supSiglas = supSiglas;
        this.supTelefono = supTelefono;
        this.supTerminal = supTerminal;
        this.supUsuarioAlta = supUsuarioAlta;
        this.supUsuarioBaja = supUsuarioBaja;
        this.supUsuarioCambio = supUsuarioCambio;
        this.tdoId = tdoId;
    }


    public void setSupCorreo(String supCorreo) {
        this.supCorreo = supCorreo;
    }

    public String getSupCorreo() {
        return supCorreo;
    }

    public void setSupDireccion(String supDireccion) {
        this.supDireccion = supDireccion;
    }

    public String getSupDireccion() {
        return supDireccion;
    }

    public void setSupEstado(Integer supEstado) {
        this.supEstado = supEstado;
    }

    public Integer getSupEstado() {
        return supEstado;
    }

    public void setSupFechaAlta(Date supFechaAlta) {
        this.supFechaAlta = supFechaAlta;
    }

    public Date getSupFechaAlta() {
        return supFechaAlta;
    }

    public void setSupFechaBaja(Date supFechaBaja) {
        this.supFechaBaja = supFechaBaja;
    }

    public Date getSupFechaBaja() {
        return supFechaBaja;
    }

    public void setSupFechaCambio(Date supFechaCambio) {
        this.supFechaCambio = supFechaCambio;
    }

    public Date getSupFechaCambio() {
        return supFechaCambio;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupJefeSupervision(String supJefeSupervision) {
        this.supJefeSupervision = supJefeSupervision;
    }

    public String getSupJefeSupervision() {
        return supJefeSupervision;
    }

    public void setSupNombre(String supNombre) {
        this.supNombre = supNombre;
    }

    public String getSupNombre() {
        return supNombre;
    }

    public void setSupNroDocumento(String supNroDocumento) {
        this.supNroDocumento = supNroDocumento;
    }

    public String getSupNroDocumento() {
        return supNroDocumento;
    }

    public void setSupObra(String supObra) {
        this.supObra = supObra;
    }

    public String getSupObra() {
        return supObra;
    }

    public void setSupRepresentanteLegal(String supRepresentanteLegal) {
        this.supRepresentanteLegal = supRepresentanteLegal;
    }

    public String getSupRepresentanteLegal() {
        return supRepresentanteLegal;
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

    public void setSupTerminal(String supTerminal) {
        this.supTerminal = supTerminal;
    }

    public String getSupTerminal() {
        return supTerminal;
    }

    public void setSupUsuarioAlta(String supUsuarioAlta) {
        this.supUsuarioAlta = supUsuarioAlta;
    }

    public String getSupUsuarioAlta() {
        return supUsuarioAlta;
    }

    public void setSupUsuarioBaja(String supUsuarioBaja) {
        this.supUsuarioBaja = supUsuarioBaja;
    }

    public String getSupUsuarioBaja() {
        return supUsuarioBaja;
    }

    public void setSupUsuarioCambio(String supUsuarioCambio) {
        this.supUsuarioCambio = supUsuarioCambio;
    }

    public String getSupUsuarioCambio() {
        return supUsuarioCambio;
    }

    public void setTdoId(Integer tdoId) {
        this.tdoId = tdoId;
    }

    public Integer getTdoId() {
        return tdoId;
    }

}
