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
@NamedQueries({ @NamedQuery(name = "ContratoCao.findAll", query = "select o from ContratoCao o") })
@Table(name = "T_CONTRATO_CAO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_CAO"))
public class ContratoCao implements Serializable {
    private static final long serialVersionUID = -1519274592126508975L;
    @Temporal(TemporalType.DATE)
    @Column(name = "CAO_FECHA")
    private Date caoFecha;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CAO_ID", nullable = false)
    private Integer caoId;
    @Column(name = "CAO_MONTO", nullable = false)
    private Long caoMonto;
    @Column(name = "CAO_OFICIO", length = 20)
    private String caoOficio;
    @Column(name = "CAO_PDF")
    private String caoPdf;
    //@Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "CAO_ESTADO")
    private Integer caoEstado;
    @Column(name = "CAO_NOMBRE")
    private String caoNombre;
    
    

    public ContratoCao() {
    }

    public ContratoCao(Date caoFecha, Integer caoId, Long caoMonto, String caoOficio, String caoPdf,
                       Integer conId, Integer monId, Integer caoEstado, String caoNombre) {
        this.caoFecha = caoFecha;
        this.caoId = caoId;
        this.caoMonto = caoMonto;
        this.caoOficio = caoOficio;
        this.caoPdf = caoPdf;
        this.conId = conId;
        this.monId = monId;
        this.caoEstado = caoEstado;
        this.caoNombre = caoNombre;
    }

    public Date getCaoFecha() {
        return caoFecha;
    }

    public void setCaoFecha(Date caoFecha) {
        this.caoFecha = caoFecha;
    }

    public Integer getCaoId() {
        return caoId;
    }

    public void setCaoId(Integer caoId) {
        this.caoId = caoId;
    }

    public Long getCaoMonto() {
        return caoMonto;
    }

    public void setCaoMonto(Long caoMonto) {
        this.caoMonto = caoMonto;
    }

    public String getCaoOficio() {
        return caoOficio;
    }

    public void setCaoOficio(String caoOficio) {
        this.caoOficio = caoOficio;
    }

    public String getCaoPdf() {
        return caoPdf;
    }

    public void setCaoPdf(String caoPdf) {
        this.caoPdf = caoPdf;
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

    public Integer getCaoEstado() {
        return caoEstado;
    }

    public void setCaoEstado(Integer caoEstado) {
        this.caoEstado = caoEstado;
    }

    public String getCaoNombre() {
        return caoNombre;
    }

    public void setCaoNombre(String caoNombre) {
        this.caoNombre = caoNombre;
    }
}
