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

/**
 * To create ID generator sequence "T_VALORIZACION_SUP_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_VALORIZACION_SUP_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Table(name = "T_VALORIZACION_SUP")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_VALORIZACION_SUP"))
public class ValorizacionSup implements Serializable {
    private static final long serialVersionUID = -4251708818679706624L;
    @Column(name = "MON_ID")
    private Integer monId;
    @Column(name = "TVS_BRUTO", nullable = false)
    private Long tvsBruto;
    @Id
    @Column(name = "TVS_HR", nullable = false)
    @GeneratedValue(generator = "generator")
    private Integer tvsHr;
    @Column(name = "TVS_IGV", nullable = false)
    private Long tvsIgv;
    @Temporal(TemporalType.DATE)
    @Column(name = "TVS_INF_FECHA_EMISION")
    private Date tvsInfFechaEmision;
    @Column(name = "TVS_INF_NUMERO", nullable = false)
    private Integer tvsInfNumero;
    @Column(name = "TVS_INF_REG_SALIDA", length = 100)
    private String tvsInfRegSalida;
    @Temporal(TemporalType.DATE)
    @Column(name = "TVS_MEM_FECHA_EMISION")
    private Date tvsMemFechaEmision;
    @Column(name = "TVS_MEM_NUMERO", nullable = false)
    private Integer tvsMemNumero;
    @Column(name = "TVS_MEM_REG_SALIDA", length = 100)
    private String tvsMemRegSalida;
    @Column(name = "TVS_NETO", nullable = false)
    private Long tvsNeto;
    @Temporal(TemporalType.DATE)
    @Column(name = "TVS_OFI_FECHA_EMISION")
    private Date tvsOfiFechaEmision;
    @Column(name = "TVS_OFI_NUMERO", nullable = false)
    private Integer tvsOfiNumero;
    @Column(name = "TVS_OFI_REG_SALIDA", length = 100)
    private String tvsOfiRegSalida;

    public ValorizacionSup() {
    }

    public ValorizacionSup(Integer monId, Long tvsBruto, Integer tvsHr, Long tvsIgv, Date tvsInfFechaEmision,
                           Integer tvsInfNumero, String tvsInfRegSalida, Date tvsMemFechaEmision,
                           Integer tvsMemNumero, String tvsMemRegSalida, Long tvsNeto, Date tvsOfiFechaEmision,
                           Integer tvsOfiNumero, String tvsOfiRegSalida) {
        this.monId = monId;
        this.tvsBruto = tvsBruto;
        this.tvsHr = tvsHr;
        this.tvsIgv = tvsIgv;
        this.tvsInfFechaEmision = tvsInfFechaEmision;
        this.tvsInfNumero = tvsInfNumero;
        this.tvsInfRegSalida = tvsInfRegSalida;
        this.tvsMemFechaEmision = tvsMemFechaEmision;
        this.tvsMemNumero = tvsMemNumero;
        this.tvsMemRegSalida = tvsMemRegSalida;
        this.tvsNeto = tvsNeto;
        this.tvsOfiFechaEmision = tvsOfiFechaEmision;
        this.tvsOfiNumero = tvsOfiNumero;
        this.tvsOfiRegSalida = tvsOfiRegSalida;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Long getTvsBruto() {
        return tvsBruto;
    }

    public void setTvsBruto(Long tvsBruto) {
        this.tvsBruto = tvsBruto;
    }

    public Integer getTvsHr() {
        return tvsHr;
    }

    public Long getTvsIgv() {
        return tvsIgv;
    }

    public void setTvsIgv(Long tvsIgv) {
        this.tvsIgv = tvsIgv;
    }

    public Date getTvsInfFechaEmision() {
        return tvsInfFechaEmision;
    }

    public void setTvsInfFechaEmision(Date tvsInfFechaEmision) {
        this.tvsInfFechaEmision = tvsInfFechaEmision;
    }

    public Integer getTvsInfNumero() {
        return tvsInfNumero;
    }

    public void setTvsInfNumero(Integer tvsInfNumero) {
        this.tvsInfNumero = tvsInfNumero;
    }

    public String getTvsInfRegSalida() {
        return tvsInfRegSalida;
    }

    public void setTvsInfRegSalida(String tvsInfRegSalida) {
        this.tvsInfRegSalida = tvsInfRegSalida;
    }

    public Date getTvsMemFechaEmision() {
        return tvsMemFechaEmision;
    }

    public void setTvsMemFechaEmision(Date tvsMemFechaEmision) {
        this.tvsMemFechaEmision = tvsMemFechaEmision;
    }

    public Integer getTvsMemNumero() {
        return tvsMemNumero;
    }

    public void setTvsMemNumero(Integer tvsMemNumero) {
        this.tvsMemNumero = tvsMemNumero;
    }

    public String getTvsMemRegSalida() {
        return tvsMemRegSalida;
    }

    public void setTvsMemRegSalida(String tvsMemRegSalida) {
        this.tvsMemRegSalida = tvsMemRegSalida;
    }

    public Long getTvsNeto() {
        return tvsNeto;
    }

    public void setTvsNeto(Long tvsNeto) {
        this.tvsNeto = tvsNeto;
    }

    public Date getTvsOfiFechaEmision() {
        return tvsOfiFechaEmision;
    }

    public void setTvsOfiFechaEmision(Date tvsOfiFechaEmision) {
        this.tvsOfiFechaEmision = tvsOfiFechaEmision;
    }

    public Integer getTvsOfiNumero() {
        return tvsOfiNumero;
    }

    public void setTvsOfiNumero(Integer tvsOfiNumero) {
        this.tvsOfiNumero = tvsOfiNumero;
    }

    public String getTvsOfiRegSalida() {
        return tvsOfiRegSalida;
    }

    public void setTvsOfiRegSalida(String tvsOfiRegSalida) {
        this.tvsOfiRegSalida = tvsOfiRegSalida;
    }

    public void setTvsHr(Integer tvsHr) {
        this.tvsHr = tvsHr;
    }
}
