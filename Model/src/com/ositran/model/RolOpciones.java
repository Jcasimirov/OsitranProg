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
@Table(name = "T_ROL_OPCIONES",uniqueConstraints = @UniqueConstraint(columnNames = {"RXO_ID"}))
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "EmpresaSupervisora_Id_Seq_Gen"))
public class RolOpciones implements Serializable {
    private static final long serialVersionUID = 4090813506078356308L;
    @Column(name = "MEN_ID", nullable = false)
    private int menId;
    @Column(name = "ROL_ID", nullable = false)
    private int rolId;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "RXO_ID", nullable = false)
    private int rxoId;
    @Column(name = "TRO_AGREGAR", nullable = false)
    private int troAgregar;
    @Column(name = "TRO_CONSULTAR", nullable = false)
    private int troConsultar;
    @Column(name = "TRO_ELIMINAR", nullable = false)
    private int troEliminar;
    @Column(name = "TRO_ESTADO", nullable = false)
    private int troEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "TRO_FECHA_ALTA")
    private Date troFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "TRO_FECHA_BAJA")
    private Date troFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "TRO_FECHA_CAMBIO")
    private Date troFechaCambio;
    @Column(name = "TRO_MODIFICAR", nullable = false)
    private int troModificar;
    @Column(name = "TRO_TERMINAL", length = 20)
    private String troTerminal;
    @Column(name = "TRO_USUARIO_ALTA", length = 20)
    private String troUsuarioAlta;
    @Column(name = "TRO_USUARIO_BAJA", length = 20)
    private String troUsuarioBaja;
    @Column(name = "TRO_USUARIO_CAMBIO", length = 20)
    private String troUsuarioCambio;

    public RolOpciones() {
    }

    public RolOpciones(int menId, int rolId, int rxoId, int troAgregar,
                       int troConsultar, int troEliminar, int troEstado, Date troFechaAlta,
                       Date troFechaBaja, Date troFechaCambio, int troModificar, String troTerminal,
                       String troUsuarioAlta, String troUsuarioBaja, String troUsuarioCambio) {
        this.menId = menId;
        this.rolId = rolId;
        this.rxoId = rxoId;
        this.troAgregar = troAgregar;
        this.troConsultar = troConsultar;
        this.troEliminar = troEliminar;
        this.troEstado = troEstado;
        this.troFechaAlta = troFechaAlta;
        this.troFechaBaja = troFechaBaja;
        this.troFechaCambio = troFechaCambio;
        this.troModificar = troModificar;
        this.troTerminal = troTerminal;
        this.troUsuarioAlta = troUsuarioAlta;
        this.troUsuarioBaja = troUsuarioBaja;
        this.troUsuarioCambio = troUsuarioCambio;
    }

    public int getMenId() {
        return menId;
    }

    public void setMenId(int menId) {
        this.menId = menId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getRxoId() {
        return rxoId;
    }

    public int getTroAgregar() {
        return troAgregar;
    }

    public void setTroAgregar(int troAgregar) {
        this.troAgregar = troAgregar;
    }

    public int getTroConsultar() {
        return troConsultar;
    }

    public void setTroConsultar(int troConsultar) {
        this.troConsultar = troConsultar;
    }

    public int getTroEliminar() {
        return troEliminar;
    }

    public void setTroEliminar(int troEliminar) {
        this.troEliminar = troEliminar;
    }

    public int getTroEstado() {
        return troEstado;
    }

    public void setTroEstado(int troEstado) {
        this.troEstado = troEstado;
    }

    public Date getTroFechaAlta() {
        return troFechaAlta;
    }

    public void setTroFechaAlta(Date troFechaAlta) {
        this.troFechaAlta = troFechaAlta;
    }

    public Date getTroFechaBaja() {
        return troFechaBaja;
    }

    public void setTroFechaBaja(Date troFechaBaja) {
        this.troFechaBaja = troFechaBaja;
    }

    public Date getTroFechaCambio() {
        return troFechaCambio;
    }

    public void setTroFechaCambio(Date troFechaCambio) {
        this.troFechaCambio = troFechaCambio;
    }

    public int getTroModificar() {
        return troModificar;
    }

    public void setTroModificar(int troModificar) {
        this.troModificar = troModificar;
    }

    public String getTroTerminal() {
        return troTerminal;
    }

    public void setTroTerminal(String troTerminal) {
        this.troTerminal = troTerminal;
    }

    public String getTroUsuarioAlta() {
        return troUsuarioAlta;
    }

    public void setTroUsuarioAlta(String troUsuarioAlta) {
        this.troUsuarioAlta = troUsuarioAlta;
    }

    public String getTroUsuarioBaja() {
        return troUsuarioBaja;
    }

    public void setTroUsuarioBaja(String troUsuarioBaja) {
        this.troUsuarioBaja = troUsuarioBaja;
    }

    public String getTroUsuarioCambio() {
        return troUsuarioCambio;
    }

    public void setTroUsuarioCambio(String troUsuarioCambio) {
        this.troUsuarioCambio = troUsuarioCambio;
    }
}
