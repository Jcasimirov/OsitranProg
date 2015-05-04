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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_CONTRATO_RES_SUP_DETALLE")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_RES_SUP_DETALLE"))

public class ContratoResSupDetalle implements Serializable {
    private static final long serialVersionUID = -4065964131419106799L;
    @Column(name = "CON_ID")
    private Integer conId;
    @Column(name = "RSD_ESTADO", nullable = false)
    private Integer rsdEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "RSD_FECHA_ASIGNACION")
    private Date rsdFechaAsignacion;
    @Id
    @Column(name = "RSD_ID", nullable = false)
    @GeneratedValue(generator = "generator")
    private Integer rsdId;
    @Column(name = "RSD_NRO_DOCUMENTO", length = 20)
    private String rsdNroDocumento;
    
    @Column(name = "RSU_ID", nullable = false)
    private Integer rsuId;
    @Column(name = "TCC_TIPO")
    private Integer tccTipo;
    @Column(name = "TDO_ID")
    private Integer tdoId;    
    @Column(name = "CCO_ID")
    private Integer ccoId;      
    @Column(name = "TIPO_SUPERVISOR")
    private Integer tipoSup;    
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "INV_ID")
    private Integer invId;
    @Column(name = "CODIGO_SUP")
    private Integer codigoSup;
    
    public ContratoResSupDetalle() {
    }

    public ContratoResSupDetalle(Integer conId, Integer rsdEstado, Date rsdFechaAsignacion, Integer rsdId,
                                 String rsdNroDocumento, Integer rsuId, Integer tccTipo, Integer tdoId, Integer tipoSup, Integer ccoId, Integer infId, Integer invId, Integer codigoSup) {
        this.conId = conId;
        this.rsdEstado = rsdEstado;
        this.rsdFechaAsignacion = rsdFechaAsignacion;
        this.rsdId = rsdId;
        this.rsdNroDocumento = rsdNroDocumento;
        this.rsuId = rsuId;
        this.tccTipo = tccTipo;
        this.tdoId = tdoId;
        this.tipoSup = tipoSup;
        this.ccoId = ccoId;
        this.infId = infId;
        this.invId = invId;
        this.codigoSup = codigoSup;
    }


    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setRsdEstado(Integer rsdEstado) {
        this.rsdEstado = rsdEstado;
    }

    public Integer getRsdEstado() {
        return rsdEstado;
    }

    public void setRsdFechaAsignacion(Date rsdFechaAsignacion) {
        this.rsdFechaAsignacion = rsdFechaAsignacion;
    }

    public Date getRsdFechaAsignacion() {
        return rsdFechaAsignacion;
    }

    public void setRsdId(Integer rsdId) {
        this.rsdId = rsdId;
    }

    public Integer getRsdId() {
        return rsdId;
    }

    public void setRsdNroDocumento(String rsdNroDocumento) {
        this.rsdNroDocumento = rsdNroDocumento;
    }

    public String getRsdNroDocumento() {
        return rsdNroDocumento;
    }

    public void setRsuId(Integer rsuId) {
        this.rsuId = rsuId;
    }

    public Integer getRsuId() {
        return rsuId;
    }

    public void setTccTipo(Integer tccTipo) {
        this.tccTipo = tccTipo;
    }

    public Integer getTccTipo() {
        return tccTipo;
    }

    public void setTdoId(Integer tdoId) {
        this.tdoId = tdoId;
    }

    public Integer getTdoId() {
        return tdoId;
    }

    public void setTipoSup(Integer tipoSup) {
        this.tipoSup = tipoSup;
    }

    public Integer getTipoSup() {
        return tipoSup;
    }

    public void setCcoId(Integer ccoId) {
        this.ccoId = ccoId;
    }

    public Integer getCcoId() {
        return ccoId;
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

    public void setCodigoSup(Integer codigoSup) {
        this.codigoSup = codigoSup;
    }

    public Integer getCodigoSup() {
        return codigoSup;
    }
}
