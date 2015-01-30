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
 * To create ID generator sequence "T_ROL_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_ROL_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Rol.findAll", query = "select o from Rol o") })
@Table(name = "T_ROL")
@SequenceGenerator(name = "Rol_Id_Seq_Gen", sequenceName = "T_ROL_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class Rol implements Serializable {
    private static final long serialVersionUID = 8317917103857394003L;
    @Column(name = "ROL_DESCRIPCION", nullable = false, length = 100)
    private String rolDescripcion;
    @Column(name = "ROL_ESTADO", nullable = false)
    private BigDecimal rolEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "ROL_FECHA_ALTA")
    private Date rolFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "ROL_FECHA_BAJA")
    private Date rolFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "ROL_FECHA_CAMBIO")
    private Date rolFechaCambio;
    @Id
    @Column(name = "ROL_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Rol_Id_Seq_Gen")
    private BigDecimal rolId;
    @Column(name = "ROL_NOMBRE", nullable = false, length = 100)
    private String rolNombre;
    @Column(name = "ROL_TERMINAL", length = 20)
    private String rolTerminal;
    @Column(name = "ROL_USUARIO_ALTA", length = 20)
    private String rolUsuarioAlta;
    @Column(name = "ROL_USUARIO_BAJA", length = 20)
    private String rolUsuarioBaja;
    @Column(name = "ROL_USUARIO_CAMBIO", length = 20)
    private String rolUsuarioCambio;
    @OneToMany(mappedBy = "TRol", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Usuario> TUsuarioList1;
    @OneToMany(mappedBy = "TRol1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<RolOpciones> TRolOpcionesList1;

    public Rol() {
    }

    public Rol(String rolDescripcion, BigDecimal rolEstado, Date rolFechaAlta, Date rolFechaBaja, Date rolFechaCambio,
               BigDecimal rolId, String rolNombre, String rolTerminal, String rolUsuarioAlta, String rolUsuarioBaja,
               String rolUsuarioCambio) {
        this.rolDescripcion = rolDescripcion;
        this.rolEstado = rolEstado;
        this.rolFechaAlta = rolFechaAlta;
        this.rolFechaBaja = rolFechaBaja;
        this.rolFechaCambio = rolFechaCambio;
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.rolTerminal = rolTerminal;
        this.rolUsuarioAlta = rolUsuarioAlta;
        this.rolUsuarioBaja = rolUsuarioBaja;
        this.rolUsuarioCambio = rolUsuarioCambio;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public BigDecimal getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(BigDecimal rolEstado) {
        this.rolEstado = rolEstado;
    }

    public Date getRolFechaAlta() {
        return rolFechaAlta;
    }

    public void setRolFechaAlta(Date rolFechaAlta) {
        this.rolFechaAlta = rolFechaAlta;
    }

    public Date getRolFechaBaja() {
        return rolFechaBaja;
    }

    public void setRolFechaBaja(Date rolFechaBaja) {
        this.rolFechaBaja = rolFechaBaja;
    }

    public Date getRolFechaCambio() {
        return rolFechaCambio;
    }

    public void setRolFechaCambio(Date rolFechaCambio) {
        this.rolFechaCambio = rolFechaCambio;
    }

    public BigDecimal getRolId() {
        return rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolTerminal() {
        return rolTerminal;
    }

    public void setRolTerminal(String rolTerminal) {
        this.rolTerminal = rolTerminal;
    }

    public String getRolUsuarioAlta() {
        return rolUsuarioAlta;
    }

    public void setRolUsuarioAlta(String rolUsuarioAlta) {
        this.rolUsuarioAlta = rolUsuarioAlta;
    }

    public String getRolUsuarioBaja() {
        return rolUsuarioBaja;
    }

    public void setRolUsuarioBaja(String rolUsuarioBaja) {
        this.rolUsuarioBaja = rolUsuarioBaja;
    }

    public String getRolUsuarioCambio() {
        return rolUsuarioCambio;
    }

    public void setRolUsuarioCambio(String rolUsuarioCambio) {
        this.rolUsuarioCambio = rolUsuarioCambio;
    }

    public List<Usuario> getTUsuarioList1() {
        return TUsuarioList1;
    }

    public void setTUsuarioList1(List<Usuario> TUsuarioList1) {
        this.TUsuarioList1 = TUsuarioList1;
    }

    public Usuario addUsuario(Usuario usuario) {
        getTUsuarioList1().add(usuario);
        usuario.setTRol(this);
        return usuario;
    }

    public Usuario removeUsuario(Usuario usuario) {
        getTUsuarioList1().remove(usuario);
        usuario.setTRol(null);
        return usuario;
    }

    public List<RolOpciones> getTRolOpcionesList1() {
        return TRolOpcionesList1;
    }

    public void setTRolOpcionesList1(List<RolOpciones> TRolOpcionesList1) {
        this.TRolOpcionesList1 = TRolOpcionesList1;
    }

    public RolOpciones addRolOpciones(RolOpciones rolOpciones) {
        getTRolOpcionesList1().add(rolOpciones);
        rolOpciones.setTRol1(this);
        return rolOpciones;
    }

    public RolOpciones removeRolOpciones(RolOpciones rolOpciones) {
        getTRolOpcionesList1().remove(rolOpciones);
        rolOpciones.setTRol1(null);
        return rolOpciones;
    }
}
