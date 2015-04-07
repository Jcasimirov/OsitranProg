package com.ositran.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * To create ID generator sequence "T_INFRAESTRUCTURA_TIPO_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_INFRAESTRUCTURA_TIPO_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Table(name = "T_INFRAESTRUCTURA_TIPO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_INFRAESTRUCTURA_TIPO"))

public class InfraestructuraTipo implements Serializable {
    private static final long serialVersionUID = -9018333581388462967L;
    @Column(name = "TIN_DESCRIPCION", nullable = false, length = 100)
    private String tinDescripcion;
    @Column(name = "TIN_ESTADO", nullable = false)
    private int tinEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIN_FECHA_ALTA", nullable = false)
    private Date tinFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIN_FECHA_BAJA")
    private Date tinFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIN_FECHA_CAMBIO")
    private Date tinFechaCambio;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "TIN_ID", nullable = false)
    private int tinId;
    @Column(name = "TIN_NOMBRE", nullable = false, length = 50)
    private String tinNombre;
    @Column(name = "TIN_TERMINAL", length = 20)
    private String tinTerminal;
    @Column(name = "TIN_USUARIO_ALTA", length = 20)
    private String tinUsuarioAlta;
    @Column(name = "TIN_USUARIO_BAJA", length = 20)
    private String tinUsuarioBaja;
    @Column(name = "TIN_USUARIO_CAMBIO", length = 20)
    private String tinUsuarioCambio;

    public InfraestructuraTipo() {
    }

    public InfraestructuraTipo(String tinDescripcion, int tinEstado, Date tinFechaAlta, Date tinFechaBaja,
                               Date tinFechaCambio, int tinId, String tinNombre, String tinTerminal,
                               String tinUsuarioAlta, String tinUsuarioBaja, String tinUsuarioCambio) {
        this.tinDescripcion = tinDescripcion;
        this.tinEstado = tinEstado;
        this.tinFechaAlta = tinFechaAlta;
        this.tinFechaBaja = tinFechaBaja;
        this.tinFechaCambio = tinFechaCambio;
        this.tinId = tinId;
        this.tinNombre = tinNombre;
        this.tinTerminal = tinTerminal;
        this.tinUsuarioAlta = tinUsuarioAlta;
        this.tinUsuarioBaja = tinUsuarioBaja;
        this.tinUsuarioCambio = tinUsuarioCambio;
    }

    public String getTinDescripcion() {
        return tinDescripcion;
    }

    public void setTinDescripcion(String tinDescripcion) {
        this.tinDescripcion = tinDescripcion;
    }

    public int getTinEstado() {
        return tinEstado;
    }

    public void setTinEstado(int tinEstado) {
        this.tinEstado = tinEstado;
    }

    public Date getTinFechaAlta() {
        return tinFechaAlta;
    }

    public void setTinFechaAlta(Date tinFechaAlta) {
        this.tinFechaAlta = tinFechaAlta;
    }

    public Date getTinFechaBaja() {
        return tinFechaBaja;
    }

    public void setTinFechaBaja(Date tinFechaBaja) {
        this.tinFechaBaja = tinFechaBaja;
    }

    public Date getTinFechaCambio() {
        return tinFechaCambio;
    }

    public void setTinFechaCambio(Date tinFechaCambio) {
        this.tinFechaCambio = tinFechaCambio;
    }

  

    public String getTinNombre() {
        return tinNombre;
    }

    public void setTinNombre(String tinNombre) {
        this.tinNombre = tinNombre;
    }

    public String getTinTerminal() {
        return tinTerminal;
    }

    public void setTinTerminal(String tinTerminal) {
        this.tinTerminal = tinTerminal;
    }

    public String getTinUsuarioAlta() {
        return tinUsuarioAlta;
    }

    public void setTinUsuarioAlta(String tinUsuarioAlta) {
        this.tinUsuarioAlta = tinUsuarioAlta;
    }

    public String getTinUsuarioBaja() {
        return tinUsuarioBaja;
    }

    public void setTinUsuarioBaja(String tinUsuarioBaja) {
        this.tinUsuarioBaja = tinUsuarioBaja;
    }

    public String getTinUsuarioCambio() {
        return tinUsuarioCambio;
    }

    public void setTinUsuarioCambio(String tinUsuarioCambio) {
        this.tinUsuarioCambio = tinUsuarioCambio;
    }


    public void setTinId(int tinId) {
        this.tinId = tinId;
    }
    
    public int getTinId() {
        return tinId;
    }

}
