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
@NamedQueries({ @NamedQuery(name = "ContratoEntrega.findAll", query = "select o from ContratoEntrega o") })
@Table(name = "T_CONTRATO_ENTREGA")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_CONTRATO_ENTREGA"))
public class ContratoEntrega implements Serializable {
    private static final long serialVersionUID = -5323475895238864355L;
    @Column(name = "CEN_DESCRIPCION", nullable = false, length = 4000)
    private String cenDescripcion;
    @Column(name = "CEN_DOCUMENTO_FISICO")
    private String cenDocumentoFisico;
    @Temporal(TemporalType.DATE)
    @Column(name = "CEN_FECHA")
    private Date cenFecha;
    @Id
    @GeneratedValue(generator = "generator") 
    @Column(name = "CEN_ID", nullable = false)
    private Integer cenId;
    @Column(name = "CEN_MONTO", nullable = false)
    private Long cenMonto;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "MON_ID")
    private Integer monId;
    
    @Column(name = "CEN_ESTADO")
    private Integer cenEstado;
    @Column(name = "CEN_NOMBRE")
    private String cenNombre;
    @Column(name = "CEN_ENTREGA") 
    private Integer cenEntrega; 
    public ContratoEntrega() {
    }

    public ContratoEntrega(String cenDescripcion, String cenDocumentoFisico, Date cenFecha, Integer cenId,
                           Long cenMonto, Integer conId, Integer monId, Integer cenEstado, String cenNombre) {
        this.cenDescripcion = cenDescripcion;
        this.cenDocumentoFisico = cenDocumentoFisico;
        this.cenFecha = cenFecha;
        this.cenId = cenId;
        this.cenMonto = cenMonto;
        this.conId = conId;
        this.monId = monId;
        this.cenNombre = cenNombre;
        this.cenEstado = cenEstado;
    }

    public String getCenDescripcion() {
        return cenDescripcion;
    }

    public void setCenDescripcion(String cenDescripcion) {
        this.cenDescripcion = cenDescripcion;
    }

    public String getCenDocumentoFisico() {
        return cenDocumentoFisico;
    }

    public void setCenDocumentoFisico(String cenDocumentoFisico) {
        this.cenDocumentoFisico = cenDocumentoFisico;
    }

    public Date getCenFecha() {
        return cenFecha;
    }

    public void setCenFecha(Date cenFecha) {
        this.cenFecha = cenFecha;
    }

    public Integer getCenId() {
        return cenId;
    }

    public void setCenId(Integer cenId) {
        this.cenId = cenId;
    }

    public Long getCenMonto() {
        return cenMonto;
    }

    public void setCenMonto(Long cenMonto) {
        this.cenMonto = cenMonto;
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

    public Integer getCenEstado() {
        return cenEstado;
    }

    public void setCenEstado(Integer cenEstado) {
        this.cenEstado = cenEstado;
    }

    public String getCenNombre() {
        return cenNombre;
    }

    public void setCenNombre(String cenNombre) {
        this.cenNombre = cenNombre;
    }

    public void setCenEntrega(Integer cenEntrega) {
        this.cenEntrega = cenEntrega;
    }

    public Integer getCenEntrega() {
        return cenEntrega;
    }
}
