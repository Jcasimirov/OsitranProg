package com.ositran.vo.bean;
import java.util.Date;
import java.util.Observer;

public class RolVO  {
    private String rolDescripcion;
    private int rolEstado;
    private Date rolFechaAlta;
    private Date rolFechaBaja;
    private Date rolFechaCambio;
    private int rolId;
    private String rolNombre;
    private String rolTerminal;
    private String rolUsuarioAlta;
    private String rolUsuarioBaja;
    private String rolUsuarioCambio;

    public RolVO() {
    }

    public RolVO(String rolDescripcion, int rolEstado, Date rolFechaAlta, Date rolFechaBaja, Date rolFechaCambio,
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
}
