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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_CONTRATO_JEFE_AREA",uniqueConstraints = @UniqueConstraint(columnNames = {"CJA_ID"}))
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_ROL_OPCIONES"))
public class ContratoJefeArea implements Serializable {
    private static final long serialVersionUID = -226428555351516491L;
    @Column(name = "CJA_ESTADO", nullable = false)
    private int cjaEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CJA_FECHA_FINAL")
    private Date cjaFechaFinal;
    @Temporal(TemporalType.DATE)
    @Column(name = "CJA_FECHA_INICIAL")
    private Date cjaFechaInicial;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CJA_ID", nullable = false)
    private int cjaId;
    @Column(name = "CJA_NRO_DOCUMENTO", length = 50)
    private String cjaNroDocumento;
    @Column(name = "CON_ID", nullable = false)
    private int conId;
    @Column(name = "CSI_ID")
    private int csiId;
    @Column(name = "TDO_ID")
    private int tdoId;
    @Column(name = "TIN_ID", nullable = false)
    private int tinId;

    public ContratoJefeArea() {
    }

    public ContratoJefeArea(int cjaEstado, Date cjaFechaFinal, Date cjaFechaInicial, int cjaId,
                            String cjaNroDocumento, int conId, int csiId, int tdoId,
                            int tinId) {
        this.cjaEstado = cjaEstado;
        this.cjaFechaFinal = cjaFechaFinal;
        this.cjaFechaInicial = cjaFechaInicial;
        this.cjaId = cjaId;
        this.cjaNroDocumento = cjaNroDocumento;
        this.conId = conId;
        this.csiId = csiId;
        this.tdoId = tdoId;
        this.tinId = tinId;
    }

    public int getCjaEstado() {
        return cjaEstado;
    }

    public void setCjaEstado(int cjaEstado) {
        this.cjaEstado = cjaEstado;
    }

    public Date getCjaFechaFinal() {
        return cjaFechaFinal;
    }

    public void setCjaFechaFinal(Date cjaFechaFinal) {
        this.cjaFechaFinal = cjaFechaFinal;
    }

    public Date getCjaFechaInicial() {
        return cjaFechaInicial;
    }

    public void setCjaFechaInicial(Date cjaFechaInicial) {
        this.cjaFechaInicial = cjaFechaInicial;
    }

    public int getCjaId() {
        return cjaId;
    }

    public void setCjaId(int cjaId) {
        this.cjaId = cjaId;
    }

    public String getCjaNroDocumento() {
        return cjaNroDocumento;
    }

    public void setCjaNroDocumento(String cjaNroDocumento) {
        this.cjaNroDocumento = cjaNroDocumento;
    }

    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getTdoId() {
        return tdoId;
    }

    public void setTdoId(int tdoId) {
        this.tdoId = tdoId;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }
}
