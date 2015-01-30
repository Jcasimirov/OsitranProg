package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "T_CONCESIONARIO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_CONCESIONARIO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Concesionario.findAll", query = "select o from Concesionario o") })
@Table(name = "T_CONCESIONARIO")
@SequenceGenerator(name = "Concesionario_Id_Seq_Gen", sequenceName = "T_CONCESIONARIO_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Concesionario implements Serializable {
    private static final long serialVersionUID = -1146886847274353223L;
    @Column(name = "CNC_CORREO", length = 20)
    private String cncCorreo;
    @Column(name = "CNC_DESCRIPCION", nullable = false, length = 100)
    private String cncDescripcion;
    @Column(name = "CNC_DIRECCION", length = 20)
    private String cncDireccion;
    @Column(name = "CNC_ESTADO", nullable = false)
    private BigDecimal cncEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CNC_FECHA_ALTA")
    private Date cncFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CNC_FECHA_BAJA")
    private Date cncFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CNC_FECHA_CAMBIO")
    private Date cncFechaCambio;
    @Id
    @Column(name = "CNC_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Concesionario_Id_Seq_Gen")
    private BigDecimal cncId;
    @Column(name = "CNC_NOMBRE", nullable = false, length = 100)
    private String cncNombre;
    @Column(name = "CNC_NRO_DOCUMENTO", length = 20)
    private String cncNroDocumento;
    @Column(name = "CNC_REPRESENTANTE_LEGAL", length = 20)
    private String cncRepresentanteLegal;
    @Column(name = "CNC_TELEFONO", length = 15)
    private String cncTelefono;
    @Column(name = "CNC_TERMINAL", length = 20)
    private String cncTerminal;
    @Column(name = "CNC_USUARIO_ALTA", length = 20)
    private String cncUsuarioAlta;
    @Column(name = "CNC_USUARIO_BAJA", length = 20)
    private String cncUsuarioBaja;
    @Column(name = "CNC_USUARIO_CAMBIO", length = 20)
    private String cncUsuarioCambio;
    @ManyToOne
    @JoinColumn(name = "CRG_ID")
    private Cargo cargo2;
    @OneToMany(mappedBy = "TConcesionario", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Contrato> TContratoList;
    @ManyToOne
    @JoinColumn(name = "TDO_ID")
    private TipoDocumento TTipoDocumento;

    public Concesionario() {
    }

    public Concesionario(String cncCorreo, String cncDescripcion, String cncDireccion, BigDecimal cncEstado,
                         Date cncFechaAlta, Date cncFechaBaja, Date cncFechaCambio, BigDecimal cncId, String cncNombre,
                         String cncNroDocumento, String cncRepresentanteLegal, String cncTelefono, String cncTerminal,
                         String cncUsuarioAlta, String cncUsuarioBaja, String cncUsuarioCambio, Cargo cargo2,
                         TipoDocumento TTipoDocumento) {
        this.cncCorreo = cncCorreo;
        this.cncDescripcion = cncDescripcion;
        this.cncDireccion = cncDireccion;
        this.cncEstado = cncEstado;
        this.cncFechaAlta = cncFechaAlta;
        this.cncFechaBaja = cncFechaBaja;
        this.cncFechaCambio = cncFechaCambio;
        this.cncId = cncId;
        this.cncNombre = cncNombre;
        this.cncNroDocumento = cncNroDocumento;
        this.cncRepresentanteLegal = cncRepresentanteLegal;
        this.cncTelefono = cncTelefono;
        this.cncTerminal = cncTerminal;
        this.cncUsuarioAlta = cncUsuarioAlta;
        this.cncUsuarioBaja = cncUsuarioBaja;
        this.cncUsuarioCambio = cncUsuarioCambio;
        this.cargo2 = cargo2;
        this.TTipoDocumento = TTipoDocumento;
    }

    public String getCncCorreo() {
        return cncCorreo;
    }

    public void setCncCorreo(String cncCorreo) {
        this.cncCorreo = cncCorreo;
    }

    public String getCncDescripcion() {
        return cncDescripcion;
    }

    public void setCncDescripcion(String cncDescripcion) {
        this.cncDescripcion = cncDescripcion;
    }

    public String getCncDireccion() {
        return cncDireccion;
    }

    public void setCncDireccion(String cncDireccion) {
        this.cncDireccion = cncDireccion;
    }

    public BigDecimal getCncEstado() {
        return cncEstado;
    }

    public void setCncEstado(BigDecimal cncEstado) {
        this.cncEstado = cncEstado;
    }

    public Date getCncFechaAlta() {
        return cncFechaAlta;
    }

    public void setCncFechaAlta(Date cncFechaAlta) {
        this.cncFechaAlta = cncFechaAlta;
    }

    public Date getCncFechaBaja() {
        return cncFechaBaja;
    }

    public void setCncFechaBaja(Date cncFechaBaja) {
        this.cncFechaBaja = cncFechaBaja;
    }

    public Date getCncFechaCambio() {
        return cncFechaCambio;
    }

    public void setCncFechaCambio(Date cncFechaCambio) {
        this.cncFechaCambio = cncFechaCambio;
    }

    public BigDecimal getCncId() {
        return cncId;
    }

    public String getCncNombre() {
        return cncNombre;
    }

    public void setCncNombre(String cncNombre) {
        this.cncNombre = cncNombre;
    }

    public String getCncNroDocumento() {
        return cncNroDocumento;
    }

    public void setCncNroDocumento(String cncNroDocumento) {
        this.cncNroDocumento = cncNroDocumento;
    }

    public String getCncRepresentanteLegal() {
        return cncRepresentanteLegal;
    }

    public void setCncRepresentanteLegal(String cncRepresentanteLegal) {
        this.cncRepresentanteLegal = cncRepresentanteLegal;
    }

    public String getCncTelefono() {
        return cncTelefono;
    }

    public void setCncTelefono(String cncTelefono) {
        this.cncTelefono = cncTelefono;
    }

    public String getCncTerminal() {
        return cncTerminal;
    }

    public void setCncTerminal(String cncTerminal) {
        this.cncTerminal = cncTerminal;
    }

    public String getCncUsuarioAlta() {
        return cncUsuarioAlta;
    }

    public void setCncUsuarioAlta(String cncUsuarioAlta) {
        this.cncUsuarioAlta = cncUsuarioAlta;
    }

    public String getCncUsuarioBaja() {
        return cncUsuarioBaja;
    }

    public void setCncUsuarioBaja(String cncUsuarioBaja) {
        this.cncUsuarioBaja = cncUsuarioBaja;
    }

    public String getCncUsuarioCambio() {
        return cncUsuarioCambio;
    }

    public void setCncUsuarioCambio(String cncUsuarioCambio) {
        this.cncUsuarioCambio = cncUsuarioCambio;
    }


    public Cargo getCargo2() {
        return cargo2;
    }

    public void setCargo2(Cargo cargo2) {
        this.cargo2 = cargo2;
    }

    public List<Contrato> getTContratoList() {
        return TContratoList;
    }

    public void setTContratoList(List<Contrato> TContratoList) {
        this.TContratoList = TContratoList;
    }

    public Contrato addContrato(Contrato contrato) {
        getTContratoList().add(contrato);
        contrato.setTConcesionario(this);
        return contrato;
    }

    public Contrato removeContrato(Contrato contrato) {
        getTContratoList().remove(contrato);
        contrato.setTConcesionario(null);
        return contrato;
    }

    public TipoDocumento getTTipoDocumento() {
        return TTipoDocumento;
    }

    public void setTTipoDocumento(TipoDocumento TTipoDocumento) {
        this.TTipoDocumento = TTipoDocumento;
    }
}
