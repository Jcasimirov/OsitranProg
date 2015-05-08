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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "T_OPCIONES",uniqueConstraints = @UniqueConstraint(columnNames = {"OPC_ID"}))
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_OPCIONES"))
public class Men implements Serializable {
    private static final long serialVersionUID = 7895582654359795714L;

    @Column(name="OPC_DESCRIPCION",nullable = false, length = 4000)
    private String descripcion;
    @Column(name = "OPC_ESTADO", nullable = false)
    private int menEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "OPC_FECHA_ALTA")
    private Date menFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "OPC_FECHA_BAJA")
    private Date menFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "OPC_FECHA_CAMBIO")
    private Date menFechaCambio;
    @Column(name = "OPC_FORMULARIO", nullable = false, length = 4000)
    private String menFormulario;
    @Id
    @Column(name = "OPC_ID", nullable = false)
    @GeneratedValue(generator = "generator")
    private int menId;
    @Column(name = "OPC_NOMBRE", nullable = false, length = 4000)
    private String menNombre;
    @Column(name = "OPC_PADRE")
    private int menPadre;
    @Column(name = "OPC_TERMINAL", length = 20)
    private String menTerminal;
    @Column(name = "OPC_USUARIO_ALTA", length = 20)
    private String menUsuarioAlta;
    @Column(name = "OPC_USUARIO_BAJA", length = 20)
    private String menUsuarioBaja;
    @Column(name = "OPC_USUARIO_CAMBIO", length = 20)
    private String menUsuarioCambio;
    @Column(name = "OPC_URL", length = 2000)
    private String menUrl;

    public Men() {
    }

    public Men(String descripcion, int menEstado, Date menFechaAlta, Date menFechaBaja, Date menFechaCambio,
               String menFormulario, int menId, String menNombre, int menPadre, String menTerminal,
               String menUsuarioAlta, String menUsuarioBaja, String menUsuarioCambio) {
        this.descripcion = descripcion;
        this.menEstado = menEstado;
        this.menFechaAlta = menFechaAlta;
        this.menFechaBaja = menFechaBaja;
        this.menFechaCambio = menFechaCambio;
        this.menFormulario = menFormulario;
        this.menId = menId;
        this.menNombre = menNombre;
        this.menPadre = menPadre;
        this.menTerminal = menTerminal;
        this.menUsuarioAlta = menUsuarioAlta;
        this.menUsuarioBaja = menUsuarioBaja;
        this.menUsuarioCambio = menUsuarioCambio;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setMenEstado(int menEstado) {
        this.menEstado = menEstado;
    }

    public int getMenEstado() {
        return menEstado;
    }

    public void setMenFechaAlta(Date menFechaAlta) {
        this.menFechaAlta = menFechaAlta;
    }

    public Date getMenFechaAlta() {
        return menFechaAlta;
    }

    public void setMenFechaBaja(Date menFechaBaja) {
        this.menFechaBaja = menFechaBaja;
    }

    public Date getMenFechaBaja() {
        return menFechaBaja;
    }

    public void setMenFechaCambio(Date menFechaCambio) {
        this.menFechaCambio = menFechaCambio;
    }

    public Date getMenFechaCambio() {
        return menFechaCambio;
    }

    public void setMenFormulario(String menFormulario) {
        this.menFormulario = menFormulario;
    }

    public String getMenFormulario() {
        return menFormulario;
    }

    public void setMenId(int menId) {
        this.menId = menId;
    }

    public int getMenId() {
        return menId;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenPadre(int menPadre) {
        this.menPadre = menPadre;
    }

    public int getMenPadre() {
        return menPadre;
    }

    public void setMenTerminal(String menTerminal) {
        this.menTerminal = menTerminal;
    }

    public String getMenTerminal() {
        return menTerminal;
    }

    public void setMenUsuarioAlta(String menUsuarioAlta) {
        this.menUsuarioAlta = menUsuarioAlta;
    }

    public String getMenUsuarioAlta() {
        return menUsuarioAlta;
    }

    public void setMenUsuarioBaja(String menUsuarioBaja) {
        this.menUsuarioBaja = menUsuarioBaja;
    }

    public String getMenUsuarioBaja() {
        return menUsuarioBaja;
    }

    public void setMenUsuarioCambio(String menUsuarioCambio) {
        this.menUsuarioCambio = menUsuarioCambio;
    }

    public String getMenUsuarioCambio() {
        return menUsuarioCambio;
    }

    public void setMenUrl(String menUrl) {
        this.menUrl = menUrl;
    }

    public String getMenUrl() {
        return menUrl;
    }

}
