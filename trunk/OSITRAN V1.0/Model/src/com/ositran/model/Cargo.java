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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "T_CARGO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_CARGO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Cargo.findAll", query = "select o from Cargo o") })
@Table(name = "T_CARGO")
@SequenceGenerator(name = "Cargo_Id_Seq_Gen", sequenceName = "T_CARGO_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Cargo implements Serializable {
    private static final long serialVersionUID = 3373119794034213826L;
    @Column(name = "CRG_DESCRIPCION", nullable = false, length = 100)
    private String crgDescripcion;
    @Column(name = "CRG_ESTADO", nullable = false)
    private BigDecimal crgEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CRG_FECHA_ALTA")
    private Date crgFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CRG_FECHA_BAJA")
    private Date crgFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CRG_FECHA_CAMBIO")
    private Date crgFechaCambio;
    @Id
    @Column(name = "CRG_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cargo_Id_Seq_Gen")
    private BigDecimal crgId;
    @Column(name = "CRG_NOMBRE", nullable = false, length = 100)
    private String crgNombre;
    @Column(name = "CRG_TERMINAL", length = 20)
    private String crgTerminal;
    @Column(name = "CRG_USUARIO_ALTA", length = 20)
    private String crgUsuarioAlta;
    @Column(name = "CRG_USUARIO_BAJA", length = 20)
    private String crgUsuarioBaja;
    @Column(name = "CRG_USUARIO_CAMBIO", length = 20)
    private String crgUsuarioCambio;
    @OneToMany(mappedBy = "cargo2", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Concesionario> TConcesionarioList;
    @OneToMany(mappedBy = "cargo", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Usuario> TUsuarioList;
    @OneToMany(mappedBy = "cargo1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<EmpresaSupervisora> TEmpresaSupervisoraList;

    public Cargo() {
    }

    public Cargo(String crgDescripcion, BigDecimal crgEstado, Date crgFechaAlta, Date crgFechaBaja, Date crgFechaCambio,
                 BigDecimal crgId, String crgNombre, String crgTerminal, String crgUsuarioAlta, String crgUsuarioBaja,
                 String crgUsuarioCambio) {
        this.crgDescripcion = crgDescripcion;
        this.crgEstado = crgEstado;
        this.crgFechaAlta = crgFechaAlta;
        this.crgFechaBaja = crgFechaBaja;
        this.crgFechaCambio = crgFechaCambio;
        this.crgId = crgId;
        this.crgNombre = crgNombre;
        this.crgTerminal = crgTerminal;
        this.crgUsuarioAlta = crgUsuarioAlta;
        this.crgUsuarioBaja = crgUsuarioBaja;
        this.crgUsuarioCambio = crgUsuarioCambio;
    }

    public String getCrgDescripcion() {
        return crgDescripcion;
    }

    public void setCrgDescripcion(String crgDescripcion) {
        this.crgDescripcion = crgDescripcion;
    }

    public BigDecimal getCrgEstado() {
        return crgEstado;
    }

    public void setCrgEstado(BigDecimal crgEstado) {
        this.crgEstado = crgEstado;
    }

    public Date getCrgFechaAlta() {
        return crgFechaAlta;
    }

    public void setCrgFechaAlta(Date crgFechaAlta) {
        this.crgFechaAlta = crgFechaAlta;
    }

    public Date getCrgFechaBaja() {
        return crgFechaBaja;
    }

    public void setCrgFechaBaja(Date crgFechaBaja) {
        this.crgFechaBaja = crgFechaBaja;
    }

    public Date getCrgFechaCambio() {
        return crgFechaCambio;
    }

    public void setCrgFechaCambio(Date crgFechaCambio) {
        this.crgFechaCambio = crgFechaCambio;
    }

    public BigDecimal getCrgId() {
        return crgId;
    }

    public String getCrgNombre() {
        return crgNombre;
    }

    public void setCrgNombre(String crgNombre) {
        this.crgNombre = crgNombre;
    }

    public String getCrgTerminal() {
        return crgTerminal;
    }

    public void setCrgTerminal(String crgTerminal) {
        this.crgTerminal = crgTerminal;
    }

    public String getCrgUsuarioAlta() {
        return crgUsuarioAlta;
    }

    public void setCrgUsuarioAlta(String crgUsuarioAlta) {
        this.crgUsuarioAlta = crgUsuarioAlta;
    }

    public String getCrgUsuarioBaja() {
        return crgUsuarioBaja;
    }

    public void setCrgUsuarioBaja(String crgUsuarioBaja) {
        this.crgUsuarioBaja = crgUsuarioBaja;
    }

    public String getCrgUsuarioCambio() {
        return crgUsuarioCambio;
    }

    public void setCrgUsuarioCambio(String crgUsuarioCambio) {
        this.crgUsuarioCambio = crgUsuarioCambio;
    }

    public List<Concesionario> getTConcesionarioList() {
        return TConcesionarioList;
    }

    public void setTConcesionarioList(List<Concesionario> TConcesionarioList) {
        this.TConcesionarioList = TConcesionarioList;
    }

    public Concesionario addConcesionario(Concesionario concesionario) {
        getTConcesionarioList().add(concesionario);
        concesionario.setCargo2(this);
        return concesionario;
    }

    public Concesionario removeConcesionario(Concesionario concesionario) {
        getTConcesionarioList().remove(concesionario);
        concesionario.setCargo2(null);
        return concesionario;
    }

    public List<Usuario> getTUsuarioList() {
        return TUsuarioList;
    }

    public void setTUsuarioList(List<Usuario> TUsuarioList) {
        this.TUsuarioList = TUsuarioList;
    }

    public Usuario addUsuario(Usuario usuario) {
        getTUsuarioList().add(usuario);
        usuario.setCargo(this);
        return usuario;
    }

    public Usuario removeUsuario(Usuario usuario) {
        getTUsuarioList().remove(usuario);
        usuario.setCargo(null);
        return usuario;
    }

    public List<EmpresaSupervisora> getTEmpresaSupervisoraList() {
        return TEmpresaSupervisoraList;
    }

    public void setTEmpresaSupervisoraList(List<EmpresaSupervisora> TEmpresaSupervisoraList) {
        this.TEmpresaSupervisoraList = TEmpresaSupervisoraList;
    }

    public EmpresaSupervisora addEmpresaSupervisora(EmpresaSupervisora empresaSupervisora) {
        getTEmpresaSupervisoraList().add(empresaSupervisora);
        empresaSupervisora.setCargo1(this);
        return empresaSupervisora;
    }

    public EmpresaSupervisora removeEmpresaSupervisora(EmpresaSupervisora empresaSupervisora) {
        getTEmpresaSupervisoraList().remove(empresaSupervisora);
        empresaSupervisora.setCargo1(null);
        return empresaSupervisora;
    }
}
