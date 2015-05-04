package com.ositran.model;

import java.io.Serializable;

import java.util.Date;
import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_INV_AVN_DETALLE")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_INV_AVN_DETALLE"))

public class ValorizacionInversionAvanceDetalle implements Serializable {
    private static final double serialVersionUID = -8422886764978732689L;
    @Column(name = "IAD_IGV")

    private BigDecimal igv;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IAD_ID")
    private int iad_Id;
    @Column(name = "MON_ID")
    private int monId;
    @Column(name = "TIA_MONTO_PRESENTADO", nullable = false)
    private BigDecimal montoPresentado;
    @Column(name = "TIA_NUMERO", nullable = false)
    private int tiaNumero;
    @Column(name = "TIA_TOTAL", nullable = false)
    private BigDecimal tiaTotal;
    @Column(name = "TIV_ID", nullable = false)
    private int tivId;
    @Column(name = "DTI_ID", nullable = false)
    private int dtiId;
    @Column(name = "IAD_PDF")
    private String iadPDF;  
    @Column(name = "IAD_DESCRIPCION")
    private String iadDescripcion;
    @Column(name = "IAD_FEC_INICIO")
    private Date iadFechaInicio;
    @Column(name = "IAD_FEC_FIN")
    private Date iadFechaFin;
    @Column(name = "TIN_ID")
    private Integer tinId;    
    @Column(name = "CSI_ID")
    private Integer csiId;
    @Column(name = "INF_ID")
    private Integer infId;
    @Column(name = "INV_ID")
    private Integer invId;    
    
    
    

        
        
    
    public ValorizacionInversionAvanceDetalle() {
    }


    public ValorizacionInversionAvanceDetalle(int cnvId, BigDecimal igv, int monId, BigDecimal montoPresentado,
                                              int tiaNumero, BigDecimal tiaTotal, Integer tinId, Integer csiId,
                                              Integer infId, Integer invId, String iadPDF) {
   

        this.igv = igv;
        this.monId = monId;
        this.montoPresentado = montoPresentado;
        this.tiaNumero = tiaNumero;
        this.tiaTotal = tiaTotal;
        this.tinId = tinId;
        this.csiId = csiId;
        this.infId = infId;
        this.invId = invId;
        this.iadPDF = iadPDF;
    }


    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIad_Id(int iad_Id) {
        this.iad_Id = iad_Id;
    }

    public int getIad_Id() {
        return iad_Id;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getMonId() {
        return monId;
    }

    public void setMontoPresentado(BigDecimal montoPresentado) {
        this.montoPresentado = montoPresentado;
    }

    public BigDecimal getMontoPresentado() {
        return montoPresentado;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaTotal(BigDecimal tiaTotal) {
        this.tiaTotal = tiaTotal;
    }

    public BigDecimal getTiaTotal() {
        return tiaTotal;
    }

    public void setTivId(int tivId) {
        this.tivId = tivId;
    }

    public int getTivId() {
        return tivId;
    }

    public void setDtiId(int dtiId) {
        this.dtiId = dtiId;
    }

    public int getDtiId() {
        return dtiId;
    }

    public void setIadPDF(String iadPDF) {
        this.iadPDF = iadPDF;
    }

    public String getIadPDF() {
        return iadPDF;
    }

    public void setIadDescripcion(String iadDescripcion) {
        this.iadDescripcion = iadDescripcion;
    }

    public String getIadDescripcion() {
        return iadDescripcion;
    }

    public void setIadFechaInicio(Date iadFechaInicio) {
        this.iadFechaInicio = iadFechaInicio;
    }

    public Date getIadFechaInicio() {
        return iadFechaInicio;
    }

    public void setIadFechaFin(Date iadFechaFin) {
        this.iadFechaFin = iadFechaFin;
    }

    public Date getIadFechaFin() {
        return iadFechaFin;
    }

    public void setTinId(Integer tinId) {
        this.tinId = tinId;
    }

    public Integer getTinId() {
        return tinId;
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

}
