package com.ositran.model;
import java.io.Serializable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "T_INFRAESTRUCTURA_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_INFRAESTRUCTURA_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Infraestructura.findAll", query = "select o from Infraestructura o") })
@Table(name = "T_INFRAESTRUCTURA")
@SequenceGenerator(name = "SEQ_INFRAESTRUCTURA", sequenceName = "SEQ_INFRAESTRUCTURA",
                   allocationSize = 50, initialValue = 50)
public class Infraestructura implements Serializable {
    private static final long serialVersionUID = -8279982721881574888L;
    @Column(name = "INF_ESTADO")
    private Integer infEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "INF_FECHA_ALTA")
    private Date infFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "INF_FECHA_BAJA")
    private Date infFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "INF_FECHA_CAMBIO")
    private Date infFechaCambio;
    @Id
    @Column(name = "INF_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INFRAESTRUCTURA")
    private Integer infId;
    @Column(name = "INF_NOMBRE", length = 100)
    private String infNombre;
    @Column(name = "INF_TERMINAL", length = 50)
    private String infTerminal;
    @Column(name = "INF_USUARIO_ALTA", length = 50)
    private String infUsuarioAlta;
    @Column(name = "INF_USUARIO_BAJA", length = 50)
    private String infUsuarioBaja;
    @Column(name = "INF_USUARIO_CAMBIO", length = 50)
    private String infUsuarioCambio;
    @ManyToOne
    @JoinColumn(name = "CSI_ID")
    private Concesion concesion;

    public Infraestructura() {
    }

    public Infraestructura(Concesion concesion, Integer infEstado, Date infFechaAlta, Date infFechaBaja,
                           Date infFechaCambio, Integer infId, String infNombre, String infTerminal,
                           String infUsuarioAlta, String infUsuarioBaja, String infUsuarioCambio) {
        this.concesion = concesion;
        this.infEstado = infEstado;
        this.infFechaAlta = infFechaAlta;
        this.infFechaBaja = infFechaBaja;
        this.infFechaCambio = infFechaCambio;
        this.infId = infId;
        this.infNombre = infNombre;
        this.infTerminal = infTerminal;
        this.infUsuarioAlta = infUsuarioAlta;
        this.infUsuarioBaja = infUsuarioBaja;
        this.infUsuarioCambio = infUsuarioCambio;
    }


    public Integer getInfEstado() {
        return infEstado;
    }

    public void setInfEstado(Integer infEstado) {
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

    public Date getInfFechaCambio() {
        return infFechaCambio;
    }

    public void setInfFechaCambio(Date infFechaCambio) {
        this.infFechaCambio = infFechaCambio;
    }

    public Integer getInfId() {
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

    public Concesion getConcesion() {
        return concesion;
    }

    public void setConcesion(Concesion concesion) {
        this.concesion = concesion;
    }


    public void setInfId(Integer infId) {
        this.infId = infId;
    }

}
