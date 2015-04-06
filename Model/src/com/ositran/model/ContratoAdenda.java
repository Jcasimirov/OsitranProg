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
@NamedQueries({ @NamedQuery(name = "ContratoAdenda.findAll", query = "select o from ContratoAdenda o") })
@Table(name = "T_CONTRATO_ADENDA")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_CONTRATO_ADENDA"))
public class ContratoAdenda implements Serializable {
    private static final long serialVersionUID = 3393451982851266458L;
    @Column(name = "CAD_DESCRIPCION", nullable = false, length = 4000)
    private String cadDescripcion;
    @Column(name = "CAD_DOCUMENTO_FISICO")
    private String cadDocumentoFisico;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAD_FECHA")
    private Date cadFecha;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CAD_ID", nullable = false)
    private Integer cadId;
    @Column(name = "CAD_MONTO", nullable = false)
    private Long cadMonto;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "TAD_ID")
    private Integer tadId;    
    @Column(name = "CAD_ESTADO")
    private Integer cadEstado;
    @Column(name = "CAD_NOMBRE")
    private String cadNombre;
    

    public ContratoAdenda() {
    }

    public ContratoAdenda(String cadDescripcion, String cadDocumentoFisico, Date cadFecha, Integer cadId,
                          Long cadMonto, Integer conId, Integer monId, Integer tadId, Integer cadEstado) {
        this.cadDescripcion = cadDescripcion;
        this.cadDocumentoFisico = cadDocumentoFisico;
        this.cadFecha = cadFecha;
        this.cadId = cadId;
        this.cadMonto = cadMonto;
        this.conId = conId;
        this.monId = monId;
        this.tadId = tadId;
        this.cadEstado = cadEstado;
    }

    public String getCadDescripcion() {
        return cadDescripcion;
    }

    public void setCadDescripcion(String cadDescripcion) {
        this.cadDescripcion = cadDescripcion;
    }

    public String getCadDocumentoFisico() {
        return cadDocumentoFisico;
    }

    public void setCadDocumentoFisico(String cadDocumentoFisico) {
        this.cadDocumentoFisico = cadDocumentoFisico;
    }

    public Date getCadFecha() {
        return cadFecha;
    }

    public void setCadFecha(Date cadFecha) {
        this.cadFecha = cadFecha;
    }

    public Integer getCadId() {
        return cadId;
    }

    public void setCadId(Integer cadId) {
        this.cadId = cadId;
    }

    public Long getCadMonto() {
        return cadMonto;
    }

    public void setCadMonto(Long cadMonto) {
        this.cadMonto = cadMonto;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getTadId() {
        return tadId;
    }

    public void setTadId(Integer tadId) {
        this.tadId = tadId;
    }

    public Integer getCadEstado() {
        return cadEstado;
    }

    public void setCadEstado(Integer cadEstado) {
        this.cadEstado = cadEstado;
    }

    public String getCadNombre() {
        return cadNombre;
    }

    public void setCadNombre(String cadNombre) {
        this.cadNombre = cadNombre;
    }
}
