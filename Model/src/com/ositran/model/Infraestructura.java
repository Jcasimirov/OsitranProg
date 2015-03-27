package com.ositran.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({ @NamedQuery(name = "Infraestructura.findAll", query = "select o from Infraestructura o") })
@Table(name = "T_INFRAESTRUCTURA")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_INFRAESTRUCTURA"))

public class Infraestructura implements Serializable {
    private static final long serialVersionUID = 8660387470661914737L;
    @Column(name = "CSI_ID", nullable = false)
    private int csiId;
    @Column(name = "INF_ESTADO", nullable = false)
    private int infEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "INF_FECHA_ALTA", nullable = false)
    private Date infFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "INF_FECHA_BAJA")
    private Date infFechaBaja;
    @Id
    @Column(name = "INF_ID", nullable = false)
    @GeneratedValue(generator = "generator")
    private int infId;
    @Column(name = "INF_NOMBRE", nullable = false, length = 50)
    private String infNombre;
    @Column(name = "INF_TERMINAL", length = 20)
    private String infTerminal;
    @Column(name = "INF_USUARIO_ALTA", length = 20)
    private String infUsuarioAlta;
    @Column(name = "INF_USUARIO_BAJA", length = 20)
    private String infUsuarioBaja;
    @Column(name = "INF_USUARIO_CAMBIO", length = 20)
    private String infUsuarioCambio;
    @Temporal(TemporalType.DATE)
    @Column(name = "INFI_FECHA_CAMBIO")
    private Date infiFechaCambio;
    @Column(name = "TIN_ID", nullable = false)
    private int tinId;

    public Infraestructura() {
    }

    public Infraestructura(int csiId, int infEstado, Date infFechaAlta, Date infFechaBaja,
                           int infId, String infNombre, String infTerminal, String infUsuarioAlta,
                           String infUsuarioBaja, String infUsuarioCambio, Date infiFechaCambio, int tinId) {
        this.csiId = csiId;
        this.infEstado = infEstado;
        this.infFechaAlta = infFechaAlta;
        this.infFechaBaja = infFechaBaja;
        this.infId = infId;
        this.infNombre = infNombre;
        this.infTerminal = infTerminal;
        this.infUsuarioAlta = infUsuarioAlta;
        this.infUsuarioBaja = infUsuarioBaja;
        this.infUsuarioCambio = infUsuarioCambio;
        this.infiFechaCambio = infiFechaCambio;
        this.tinId = tinId;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getInfEstado() {
        return infEstado;
    }

    public void setInfEstado(int infEstado) {
        this.infEstado = infEstado;
    }

    public Date getInfFechaAlta() {
        return infFechaAlta;
    }

    public void setInfFechaAlta(Date infFechaAlta) {
        this.infFechaAlta = infFechaAlta;
    }

    public Date getInfFechaBaja() {
        return infFechaBaja;
    }

    public void setInfFechaBaja(Date infFechaBaja) {
        this.infFechaBaja = infFechaBaja;
    }


 

    public int getInfId() {
        return infId;
    }

    public String getInfNombre() {
        return infNombre;
    }

    public void setInfNombre(String infNombre) {
        this.infNombre = infNombre;
    }

    public String getInfTerminal() {
        return infTerminal;
    }

    public void setInfTerminal(String infTerminal) {
        this.infTerminal = infTerminal;
    }

    public String getInfUsuarioAlta() {
        return infUsuarioAlta;
    }

    public void setInfUsuarioAlta(String infUsuarioAlta) {
        this.infUsuarioAlta = infUsuarioAlta;
    }

    public String getInfUsuarioBaja() {
        return infUsuarioBaja;
    }

    public void setInfUsuarioBaja(String infUsuarioBaja) {
        this.infUsuarioBaja = infUsuarioBaja;
    }

    public String getInfUsuarioCambio() {
        return infUsuarioCambio;
    }

    public void setInfUsuarioCambio(String infUsuarioCambio) {
        this.infUsuarioCambio = infUsuarioCambio;
    }
    

    public Date getInfiFechaCambio() {
        return infiFechaCambio;
    }

    public void setInfiFechaCambio(Date infiFechaCambio) {
        this.infiFechaCambio = infiFechaCambio;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }


    public void setInfId(int infId) {
        this.infId = infId;
    }

}

