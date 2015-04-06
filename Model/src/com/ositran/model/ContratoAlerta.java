package com.ositran.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
    @Column(name = "CAL_AEROPUERTO", nullable = false, length = 4000)
    private String calAeropuerto;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAL_DIA_PRESENTACIÓN")
    private Date calDiaPresentación;
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
    @Column(name = "CAL_NOMBRECONCESION", nullable = false, length = 4000)
    private String calNombreconcesion;
    @Column(name = "CAL_PLAZO", nullable = false)
    private String calPlazo;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "PER_ID")
    private Integer perId;    
    @Column(name = "CAL_ESTADO")
    private Integer calEstado;
    

    public ContratoAlerta() {
    }

    public ContratoAlerta(Integer caeId, String calAeropuerto, Date calDiaPresentación, Date calFechaFin,
                          Date calFechaInicio, Integer calId, String calNombreconcesion, String calPlazo,
                          Integer conId, Integer perId, Integer calEstado) {
        this.caeId = caeId;
        this.calAeropuerto = calAeropuerto;
        this.calDiaPresentación = calDiaPresentación;
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

    public Date getCalDiaPresentación() {
        return calDiaPresentación;
    }

    public void setCalDiaPresentación(Date calDiaPresentación) {
        this.calDiaPresentación = calDiaPresentación;
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

    public String getCalPlazo() {
        return calPlazo;
    }

    public void setCalPlazo(String calPlazo) {
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
}
