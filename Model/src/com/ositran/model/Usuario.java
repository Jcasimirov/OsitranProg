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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_USUARIO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_USUARIO"))

public class Usuario implements Serializable {
    private static final long serialVersionUID = -3837699421831960554L;
    @Column(name = "CRG_ID")
    private Integer crgId;
    @Column(name = "ROL_ID", nullable = false)
    private Integer rolId;
    @Column(name = "USU_CONTRASENYA", nullable = false, length = 20)
    private String usuContrasenya;
    @Column(name = "USU_ESEXTERNO", nullable = false)
    private Integer usuEsexterno;
    @Column(name = "USU_ESTADO", nullable = false)
    private Integer usuEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "USU_FECHA_ALTA")
    private Date usuFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "USU_FECHA_BAJA")
    private Date usuFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "USU_FECHA_CAMBIO")
    private Date usuFechaCambio;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "USU_ID", nullable = false)
    private Integer usuId;
    @Column(name = "USU_NOMBRE", nullable = false, length = 100)
    private String usuNombre;
    @Column(name = "USU_TERMINAL", length = 20)
    private String usuTerminal;
    @Column(name = "USU_USUARIO", nullable = false, length = 20)
    private String usuUsuario;
    @Column(name = "USU_USUARIO_ALTA", length = 20)
    private String usuUsuarioAlta;
    @Column(name = "USU_USUARIO_BAJA", length = 20)
    private String usuUsuarioBaja;
    @Column(name = "USU_USUARIO_CAMBIO", length = 20)
    private String usuUsuarioCambio;

    public Usuario() {
    }

    public Usuario(Integer crgId, Integer rolId, String usuContrasenya, Integer usuEsexterno,
                   Integer usuEstado, Date usuFechaAlta, Date usuFechaBaja, Date usuFechaCambio, Integer usuId,
                   String usuNombre, String usuTerminal, String usuUsuario, String usuUsuarioAlta,
                   String usuUsuarioBaja, String usuUsuarioCambio) {
        this.crgId = crgId;
        this.rolId = rolId;
        this.usuContrasenya = usuContrasenya;
        this.usuEsexterno = usuEsexterno;
        this.usuEstado = usuEstado;
        this.usuFechaAlta = usuFechaAlta;
        this.usuFechaBaja = usuFechaBaja;
        this.usuFechaCambio = usuFechaCambio;
        this.usuId = usuId;
        this.usuNombre = usuNombre;
        this.usuTerminal = usuTerminal;
        this.usuUsuario = usuUsuario;
        this.usuUsuarioAlta = usuUsuarioAlta;
        this.usuUsuarioBaja = usuUsuarioBaja;
        this.usuUsuarioCambio = usuUsuarioCambio;
    }

    public Integer getCrgId() {
        return crgId;
    }

    public void setCrgId(Integer crgId) {
        this.crgId = crgId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getUsuContrasenya() {
        return usuContrasenya;
    }

    public void setUsuContrasenya(String usuContrasenya) {
        this.usuContrasenya = usuContrasenya;
    }

    public Integer getUsuEsexterno() {
        return usuEsexterno;
    }

    public void setUsuEsexterno(Integer usuEsexterno) {
        this.usuEsexterno = usuEsexterno;
    }

    public Integer getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Integer usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Date getUsuFechaAlta() {
        return usuFechaAlta;
    }

    public void setUsuFechaAlta(Date usuFechaAlta) {
        this.usuFechaAlta = usuFechaAlta;
    }

    public Date getUsuFechaBaja() {
        return usuFechaBaja;
    }

    public void setUsuFechaBaja(Date usuFechaBaja) {
        this.usuFechaBaja = usuFechaBaja;
    }

    public Date getUsuFechaCambio() {
        return usuFechaCambio;
    }

    public void setUsuFechaCambio(Date usuFechaCambio) {
        this.usuFechaCambio = usuFechaCambio;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuTerminal() {
        return usuTerminal;
    }

    public void setUsuTerminal(String usuTerminal) {
        this.usuTerminal = usuTerminal;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuUsuarioAlta() {
        return usuUsuarioAlta;
    }

    public void setUsuUsuarioAlta(String usuUsuarioAlta) {
        this.usuUsuarioAlta = usuUsuarioAlta;
    }

    public String getUsuUsuarioBaja() {
        return usuUsuarioBaja;
    }

    public void setUsuUsuarioBaja(String usuUsuarioBaja) {
        this.usuUsuarioBaja = usuUsuarioBaja;
    }

    public String getUsuUsuarioCambio() {
        return usuUsuarioCambio;
    }

    public void setUsuUsuarioCambio(String usuUsuarioCambio) {
        this.usuUsuarioCambio = usuUsuarioCambio;
    }
}
