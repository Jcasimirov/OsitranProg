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
@NamedQueries({ @NamedQuery(name = "ContratoAlerta.findAll", query = "select o from ContratoAlerta o") })
@Table(name = "T_CONTRATO_ALERTA")

@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_ALERTA"))
public class ContratoAlerta implements Serializable {
    private static final long serialVersionUID = 8920954827070543587L;
    @Column(name = "CAE_ID")
    private Integer caeId;
    @Column(name = "CAL_AEROPUERTO")
    private String calAeropuerto;    
    @Column(name = "CAL_DIA_PRESENTACION")
    private Integer calDiaPresentacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAL_FECHA_FIN")
    private Date calFechaFin;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAL_FECHA_INICIO")
    private Date calFechaInicio;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CAL_ID", nullable = false)
    private Integer calId;
    @Column(name = "CAL_NOMBRECONCESION", length = 4000)
    private String calNombreconcesion;
    @Column(name = "CAL_PLAZO")
    private Date calPlazo;
    //@Id
    @Column(name = "CON_ID")
    private Integer conId;
    @Column(name = "PER_ID")
    private Integer perId;    
    @Column(name = "CAL_ESTADO")
    private Integer calEstado;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "CAL_FECHA_ALTA")
    private Date calFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAL_FECHA_BAJA")
    private Date calFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAL_FECHA_CAMBIO")
    private Date calFechaCambio;
    @Column(name = "CAL_USUARIO_ALTA", length = 100)
    private String calUsuarioAlta;
    @Column(name = "CAL_USUARIO_BAJA", length = 100)
    private String calUsuarioBaja;
    @Column(name = "CAL_USUARIO_CAMBIO", length = 100)
    private String calUsuarioCambio;
    @Column(name = "CAL_TERMINAL", length = 20)
    private String calTerminal;
 
    
    @Column(name = "CAL_FECHA_LIMITE")
    private Date calFechaLimite;
    @Column(name = "CAL_TIPO")
    private Integer calTipo;
    @Column(name = "CAL_CORREO")
    private String calCorreo;   
    
    @Column(name = "TIN_ID")
    private Integer tinId;
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "INV_ID")
    private Integer invId;
    @Column(name = "TCC_TIPO")
    private Integer tccTipo;
    @Column(name = "CCO_ID")
    private Integer ccoId;
    @Column(name = "MCO_ID")
    private Integer mcoId;
    @Column(name = "CAL_CANTIDAD_PLAZO")
    private Integer calCantidadPlazo;
    @Column(name = "CAL_MESOANIO_PLAZO")
    private Integer calMesoanioPlazo;
    @Column(name = "CAL_PLAZODESCRIPCION")
    private String calPlazoDescripcion;
    @Column(name = "ALE_NOMBRE")
    private String aleNombre;
    @Column(name = "ALE_DIAMES")
    private Integer aleDiaMes;
    
    @Column(name = "CAL_NOMBRE_SUPERVISOR")
    private String calNombreSupervisor;

    
    
    
    
    public ContratoAlerta() {
    }

    public ContratoAlerta(Integer caeId, String calAeropuerto, Integer calDiaPresentacion, Date calFechaFin,
                          Date calFechaInicio, Integer calId, String calNombreconcesion, Date calPlazo,
                          Integer conId, Integer perId, Integer calEstado) {
        this.caeId = caeId;
        this.calAeropuerto = calAeropuerto;
        this.calDiaPresentacion = calDiaPresentacion;
        this.calFechaFin = calFechaFin;
        this.calFechaInicio = calFechaInicio;
        this.calId = calId;
        this.calNombreconcesion = calNombreconcesion;
        this.calPlazo = calPlazo;
        this.conId = conId;
        this.perId = perId;
        this.calEstado = calEstado;
    }

    public Integer getCaeId() {
        return caeId;
    }

    public void setCaeId(Integer caeId) {
        this.caeId = caeId;
    }

    public String getCalAeropuerto() {
        return calAeropuerto;
    }

    public void setCalAeropuerto(String calAeropuerto) {
        this.calAeropuerto = calAeropuerto;
    }

    public Integer getCalDiaPresentacion() {
        return calDiaPresentacion;
    }

    public void setCalDiaPresentacion(Integer calDiaPresentación) {
        this.calDiaPresentacion = calDiaPresentación;
    }

    public Date getCalFechaFin() {
        return calFechaFin;
    }

    public void setCalFechaFin(Date calFechaFin) {
        this.calFechaFin = calFechaFin;
    }

    public Date getCalFechaInicio() {
        return calFechaInicio;
    }

    public void setCalFechaInicio(Date calFechaInicio) {
        this.calFechaInicio = calFechaInicio;
    }

    public Integer getCalId() {
        return calId;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    public String getCalNombreconcesion() {
        return calNombreconcesion;
    }

    public void setCalNombreconcesion(String calNombreconcesion) {
        this.calNombreconcesion = calNombreconcesion;
    }

    public Date getCalPlazo() {
        return calPlazo;
    }

    public void setCalPlazo(Date calPlazo) {
        this.calPlazo = calPlazo;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Integer getCalEstado() {
        return calEstado;
    }

    public void setCalEstado(Integer calEstado) {
        this.calEstado = calEstado;
    }

    public void setCalFechaAlta(Date calFechaAlta) {
        this.calFechaAlta = calFechaAlta;
    }

    public Date getCalFechaAlta() {
        return calFechaAlta;
    }

    public void setCalFechaBaja(Date calFechaBaja) {
        this.calFechaBaja = calFechaBaja;
    }

    public Date getCalFechaBaja() {
        return calFechaBaja;
    }

    public void setCalFechaCambio(Date calFechaCambio) {
        this.calFechaCambio = calFechaCambio;
    }

    public Date getCalFechaCambio() {
        return calFechaCambio;
    }

    public void setCalUsuarioAlta(String calUsuarioAlta) {
        this.calUsuarioAlta = calUsuarioAlta;
    }

    public String getCalUsuarioAlta() {
        return calUsuarioAlta;
    }

    public void setCalUsuarioBaja(String calUsuarioBaja) {
        this.calUsuarioBaja = calUsuarioBaja;
    }

    public String getCalUsuarioBaja() {
        return calUsuarioBaja;
    }

    public void setCalUsuarioCambio(String calUsuarioCambio) {
        this.calUsuarioCambio = calUsuarioCambio;
    }

    public String getCalUsuarioCambio() {
        return calUsuarioCambio;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
    }

    public void setCalFechaLimite(Date calFechaLimite) {
        this.calFechaLimite = calFechaLimite;
    }

    public Date getCalFechaLimite() {
        return calFechaLimite;
    }

    public void setCalTipo(Integer calTipo) {
        this.calTipo = calTipo;
    }

    public Integer getCalTipo() {
        return calTipo;
    }

    public void setCalCorreo(String calCorreo) {
        this.calCorreo = calCorreo;
    }

    public String getCalCorreo() {
        return calCorreo;
    }

    public void setCsiId(Integer csiId) {
        this.csiId = csiId;
    }

    public Integer getCsiId() {
        return csiId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setTccTipo(Integer tccTipo) {
        this.tccTipo = tccTipo;
    }

    public Integer getTccTipo() {
        return tccTipo;
    }

    public void setCcoId(Integer ccoId) {
        this.ccoId = ccoId;
    }

    public Integer getCcoId() {
        return ccoId;
    }

    public void setMcoId(Integer mcoId) {
        this.mcoId = mcoId;
    }

    public Integer getMcoId() {
        return mcoId;
    }

    public void setCalTerminal(String calTerminal) {
        this.calTerminal = calTerminal;
    }

    public String getCalTerminal() {
        return calTerminal;
    }

    public void setCalCantidadPlazo(Integer calCantidadPlazo) {
        this.calCantidadPlazo = calCantidadPlazo;
    }

    public Integer getCalCantidadPlazo() {
        return calCantidadPlazo;
    }

    public void setCalMesoanioPlazo(Integer calMesoanioPlazo) {
        this.calMesoanioPlazo = calMesoanioPlazo;
    }

    public Integer getCalMesoanioPlazo() {
        return calMesoanioPlazo;
    }


    public void setCalPlazoDescripcion(String calPlazoDescripcion) {
        this.calPlazoDescripcion = calPlazoDescripcion;
    }

    public String getCalPlazoDescripcion() {
        return calPlazoDescripcion;
    }

    public void setAleNombre(String aleNombre) {
        this.aleNombre = aleNombre;
    }

    public String getAleNombre() {
        return aleNombre;
    }

    public void setAleDiaMes(Integer aleDiaMes) {
        this.aleDiaMes = aleDiaMes;
    }

    public Integer getAleDiaMes() {
        return aleDiaMes;
    }

    public void setCalNombreSupervisor(String calNombreSupervisor) {
        this.calNombreSupervisor = calNombreSupervisor;
    }
    public String getCalNombreSupervisor() {
        return calNombreSupervisor;
    }


}
