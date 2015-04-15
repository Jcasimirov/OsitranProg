package com.ositran.model;

import java.io.Serializable;
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
    @Column(name = "CNV_ID")
    private int cnvId;
    @Column(name = "IAD_IGV",nullable = false)
    private double igv;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IAD_ID")
    private int iad_Id;
    @Column(name = "MON_ID")
    private int monId;
    @Column(name = "TIA_MONTO_PRESENTADO", nullable = false)
    private double montoPresentado;
   
    @Column(name = "TIA_NUMERO", nullable = false)
    private int tiaNumero;
    @Column(name = "TIA_TOTAL", nullable = false)
    private double tiaTotal;
    @Column(name = "TIV_ID", nullable = false)
    private int tivId;
    @Column(name = "DTI_ID", nullable = false)
    private int dtiId;
    @Column(name = "IAD_PDF")
    private int iadPDF;    
        
        
    
    public ValorizacionInversionAvanceDetalle() {
    }

    public ValorizacionInversionAvanceDetalle(int cnvId, double igv, int monId, double montoPresentado,
                                              int tiaNumero, double tiaTotal) {
        this.cnvId = cnvId;
        this.igv = igv;
        this.monId = monId;
        this.montoPresentado = montoPresentado;
        this.tiaNumero = tiaNumero;
        this.tiaTotal = tiaTotal;
    }

    public int getCnvId() {
        return cnvId;
    }

    public void setCnvId(int cnvId) {
        this.cnvId = cnvId;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public double getMontoPresentado() {
        return montoPresentado;
    }

    public void setMontoPresentado(double montoPresentado) {
        this.montoPresentado = montoPresentado;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public double getTiaTotal() {
        return tiaTotal;
    }

    public void setTiaTotal(double tiaTotal) {
        this.tiaTotal = tiaTotal;
    }


    public void setIad_Id(int iad_Id) {
        this.iad_Id = iad_Id;
    }

    public int getIad_Id() {
        return iad_Id;
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

    public void setIadPDF(int iadPDF) {
        this.iadPDF = iadPDF;
    }

    public int getIadPDF() {
        return iadPDF;
    }
}
