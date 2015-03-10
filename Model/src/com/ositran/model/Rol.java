package com.ositran.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "T_ROL",uniqueConstraints = @UniqueConstraint(columnNames = {"ROL_ID"}))
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "EmpresaSupervisora_Id_Seq_Gen"))
public class Rol implements Serializable {
    private static final long serialVersionUID = 6192435439624100845L;
    @Column(name = "ROL_DESCRIPCION", nullable = false, length = 100)
    private String rolDescripcion;
    @Column(name = "ROL_ESTADO", nullable = false)
    private int rolEstado;
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
    @GeneratedValue(generator = "generator")
    @Column(name = "ROL_ID", nullable = false)
    private int rolId;
  
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

    public Rol() {
    }

    public Rol(String rolDescripcion, int rolEstado, Date rolFechaAlta, Date rolFechaBaja, Date rolFechaCambio,
               int rolId, String rolNombre, String rolTerminal, String rolUsuarioAlta, String rolUsuarioBaja,
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

    public int getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(int rolEstado) {
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

    public int getRolId() {
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
    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
}
