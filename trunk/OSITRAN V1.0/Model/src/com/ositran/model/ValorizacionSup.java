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
    @Column(name = "SUP_ID")
    private Integer supId;
    @Column(name = "TVS_ANYO")
    private Integer tvsAnyo;
    @Column(name = "TVS_ASUNTO", length = 100)
    private String tvsAsunto;
    @Column(name = "TVS_BRUTO", nullable = false)
    private Long tvsBruto;
    @Column(name = "TVS_ESTADO")
    private Integer tvsEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "TVS_FECHA_REGISTRO")
    private Date tvsFechaRegistro;
    @Id
    @Column(name = "TVS_HR", nullable = false)
    @GeneratedValue(generator = "generator")
    private Integer tvsHr;
    @Column(name = "TVS_IGV", nullable = false)
    private Long tvsIgv;
    @Temporal(TemporalType.DATE)
    @Column(name = "TVS_INF_FECHA_EMISION")
    private Date tvsInfFechaEmision;
    @Column(name = "TVS_INF_NUMERO")
    private String tvsInfNumero;
    @Column(name = "TVS_INF_REG_SALIDA", length = 100)
    private String tvsInfRegSalida;
    @Temporal(TemporalType.DATE)
    @Column(name = "TVS_MEM_FECHA_EMISION")
    private Date tvsMemFechaEmision;
    @Column(name = "TVS_MEM_NUMERO")
    private String tvsMemNumero;
    @Column(name = "TVS_MEM_REG_SALIDA", length = 100)
    private String tvsMemRegSalida;
    @Column(name = "TVS_NETO", nullable = false)
    private Long tvsNeto;
    @Temporal(TemporalType.DATE)
    @Column(name = "TVS_OFI_FECHA_EMISION")
    private Date tvsOfiFechaEmision;
    @Column(name = "TVS_OFI_NUMERO")
    private String tvsOfiNumero;
    @Column(name = "TVS_OFI_REG_SALIDA", length = 100)
    private String tvsOfiRegSalida;
    @Column(name = "TVS_APROBADO")
    private Long tvsAprobado;
    @Column(name = "TVS_OBSERVACION", length = 4000)
    private String tvsObservacion;

    public ValorizacionSup() {
    }

    public ValorizacionSup(Integer monId, Integer supId, Integer tvsAnyo, String tvsAsunto, Long tvsBruto,
                           Integer tvsEstado, Date tvsFechaRegistro, Integer tvsHr, Long tvsIgv,
                           Date tvsInfFechaEmision, String tvsInfNumero, String tvsInfRegSalida,
                           Date tvsMemFechaEmision, String tvsMemNumero, String tvsMemRegSalida, Long tvsNeto,
                           Date tvsOfiFechaEmision, String tvsOfiNumero, String tvsOfiRegSalida, Long tvsAprobado, String tvsObservacion) {
        this.monId = monId;
        this.supId = supId;
        this.tvsAnyo = tvsAnyo;
        this.tvsAsunto = tvsAsunto;
        this.tvsBruto = tvsBruto;
        this.tvsEstado = tvsEstado;
        this.tvsFechaRegistro = tvsFechaRegistro;
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
        this.tvsAprobado = tvsAprobado;
        this.tvsObservacion = tvsObservacion;
    }


    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setTvsAnyo(Integer tvsAnyo) {
        this.tvsAnyo = tvsAnyo;
    }

    public Integer getTvsAnyo() {
        return tvsAnyo;
    }

    public void setTvsAsunto(String tvsAsunto) {
        this.tvsAsunto = tvsAsunto;
    }

    public String getTvsAsunto() {
        return tvsAsunto;
    }

    public void setTvsBruto(Long tvsBruto) {
        this.tvsBruto = tvsBruto;
    }

    public Long getTvsBruto() {
        return tvsBruto;
    }

    public void setTvsEstado(Integer tvsEstado) {
        this.tvsEstado = tvsEstado;
    }

    public Integer getTvsEstado() {
        return tvsEstado;
    }

    public void setTvsFechaRegistro(Date tvsFechaRegistro) {
        this.tvsFechaRegistro = tvsFechaRegistro;
    }

    public Date getTvsFechaRegistro() {
        return tvsFechaRegistro;
    }

    public void setTvsHr(Integer tvsHr) {
        this.tvsHr = tvsHr;
    }

    public Integer getTvsHr() {
        return tvsHr;
    }

    public void setTvsIgv(Long tvsIgv) {
        this.tvsIgv = tvsIgv;
    }

    public Long getTvsIgv() {
        return tvsIgv;
    }

    public void setTvsInfFechaEmision(Date tvsInfFechaEmision) {
        this.tvsInfFechaEmision = tvsInfFechaEmision;
    }

    public Date getTvsInfFechaEmision() {
        return tvsInfFechaEmision;
    }

    public void setTvsInfNumero(String tvsInfNumero) {
        this.tvsInfNumero = tvsInfNumero;
    }

    public String getTvsInfNumero() {
        return tvsInfNumero;
    }

    public void setTvsInfRegSalida(String tvsInfRegSalida) {
        this.tvsInfRegSalida = tvsInfRegSalida;
    }

    public String getTvsInfRegSalida() {
        return tvsInfRegSalida;
    }

    public void setTvsMemFechaEmision(Date tvsMemFechaEmision) {
        this.tvsMemFechaEmision = tvsMemFechaEmision;
    }

    public Date getTvsMemFechaEmision() {
        return tvsMemFechaEmision;
    }

    public void setTvsMemNumero(String tvsMemNumero) {
        this.tvsMemNumero = tvsMemNumero;
    }

    public String getTvsMemNumero() {
        return tvsMemNumero;
    }

    public void setTvsMemRegSalida(String tvsMemRegSalida) {
        this.tvsMemRegSalida = tvsMemRegSalida;
    }

    public String getTvsMemRegSalida() {
        return tvsMemRegSalida;
    }

    public void setTvsNeto(Long tvsNeto) {
        this.tvsNeto = tvsNeto;
    }

    public Long getTvsNeto() {
        return tvsNeto;
    }

    public void setTvsOfiFechaEmision(Date tvsOfiFechaEmision) {
        this.tvsOfiFechaEmision = tvsOfiFechaEmision;
    }

    public Date getTvsOfiFechaEmision() {
        return tvsOfiFechaEmision;
    }

    public void setTvsOfiNumero(String tvsOfiNumero) {
        this.tvsOfiNumero = tvsOfiNumero;
    }

    public String getTvsOfiNumero() {
        return tvsOfiNumero;
    }

    public void setTvsOfiRegSalida(String tvsOfiRegSalida) {
        this.tvsOfiRegSalida = tvsOfiRegSalida;
    }

    public String getTvsOfiRegSalida() {
        return tvsOfiRegSalida;
    }


    public void setTvsAprobado(Long tvsAprobado) {
        this.tvsAprobado = tvsAprobado;
    }

    public Long getTvsAprobado() {
        return tvsAprobado;
    }

    public void setTvsObservacion(String tvsObservacion) {
        this.tvsObservacion = tvsObservacion;
    }

    public String getTvsObservacion() {
        return tvsObservacion;
    }
}
