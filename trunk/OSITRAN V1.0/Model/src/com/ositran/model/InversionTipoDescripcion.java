package com.ositran.model;
import java.io.Serializable;
import java.util.Date;

public class InversionTipoDescripcion implements Serializable {
    private static final long serialVersionUID = 35556266185801467L;
    private String itdDescripcion;
    private int itdEstado;
    private Date itdFechaAlta;
    private Date itdFechaBaja;
    private Date itdFechaCambio;
    private int itdId;
    private String itdNombre;
    private String itdTerminal;
    private String itdUsuarioAlta;
    private String itdUsuarioBaja;
    private String itdUsuarioCambio;
    private int tivId;

    public InversionTipoDescripcion() {
    }

    public InversionTipoDescripcion(String itdDescripcion, int itdEstado, Date itdFechaAlta, Date itdFechaBaja,
                                    Date itdFechaCambio, int itdId, String itdNombre, String itdTerminal,
                                    String itdUsuarioAlta, String itdUsuarioBaja, String itdUsuarioCambio,
                                    int tivId) {
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

    public int getItdEstado() {
        return itdEstado;
    }

    public void setItdEstado(int itdEstado) {
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

    public int getItdId() {
        return itdId;
    }

    public void setItdId(int itdId) {
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

    public int getTivId() {
        return tivId;
    }

    public void setTivId(int tivId) {
        this.tivId = tivId;
    }
}
