package com.ositran.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_USUARIO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_USUARIO"))

public class Usuario implements Serializable {
    private static final long serialVersionUID = 4384387181132541472L;
    @Column(name = "ROL_ID", nullable = false)
    private Integer rolId;
    @Column(name = "USU_ALIAS", nullable = false, length = 20)
    private String usuAlias;
    @Column(name = "USU_CONTRASENYA", nullable = false, length = 4000)
    private String usuContrasenya;
    @Column(name = "USU_CORREO", length = 20)
    private String usuCorreo;
    @Column(name = "USU_DESCRIPCION", length = 100)
    private String usuDescripcion;
    @Column(name = "USU_ESEXTERNO")
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
    @Column(name = "USU_ID", nullable = false, length = 20)
    @GeneratedValue(generator = "generator")
    private Integer usuId;
    @Column(name = "USU_NOMBRE", nullable = false, length = 100)
    private String usuNombre;
    @Column(name = "USU_TERMINAL", length = 20)
    private String usuTerminal;
    @Column(name = "USU_USUARIO_ALTA", length = 20)
    private String usuUsuarioAlta;
    @Column(name = "USU_USUARIO_BAJA", length = 20)
    private String usuUsuarioBaja;
    @Column(name = "USU_USUARIO_CAMBIO", length = 20)
    private String usuUsuarioCambio;

    public Usuario() {
    }

    public Usuario(Integer rolId, String usuAlias, String usuContrasenya, String usuCorreo, String usuDescripcion,
                   Integer usuEsexterno, Integer usuEstado, Date usuFechaAlta, Date usuFechaBaja,
                   Date usuFechaCambio, Integer usuId, String usuNombre, String usuTerminal, String usuUsuarioAlta,
                   String usuUsuarioBaja, String usuUsuarioCambio) {
        this.rolId = rolId;
        this.usuAlias = usuAlias;
        this.usuContrasenya = usuContrasenya;
        this.usuCorreo = usuCorreo;
        this.usuDescripcion = usuDescripcion;
        this.usuEsexterno = usuEsexterno;
        this.usuEstado = usuEstado;
        this.usuFechaAlta = usuFechaAlta;
        this.usuFechaBaja = usuFechaBaja;
        this.usuFechaCambio = usuFechaCambio;
        this.usuId = usuId;
        this.usuNombre = usuNombre;
        this.usuTerminal = usuTerminal;
        this.usuUsuarioAlta = usuUsuarioAlta;
        this.usuUsuarioBaja = usuUsuarioBaja;
        this.usuUsuarioCambio = usuUsuarioCambio;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getUsuAlias() {
        return usuAlias;
    }

    public void setUsuAlias(String usuAlias) {
        this.usuAlias = usuAlias;
    }

    public String getUsuContrasenya() {
        return usuContrasenya;
    }

    public void setUsuContrasenya(String usuContrasenya) {
        this.usuContrasenya = usuContrasenya;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuDescripcion() {
        return usuDescripcion;
    }

    public void setUsuDescripcion(String usuDescripcion) {
        this.usuDescripcion = usuDescripcion;
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


    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public Integer getUsuId() {
        return usuId;
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
