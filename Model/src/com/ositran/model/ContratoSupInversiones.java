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
@Table(name = "T_CONTRATO_SUP_INVERSIONES",uniqueConstraints = @UniqueConstraint(columnNames = {"SIV_ID"}))
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_ROL_OPCIONES"))

public class ContratoSupInversiones implements Serializable {
    private static final long serialVersionUID = 7491494841277593058L;
    @Column(name = "CON_ID", nullable = false)
    private int conId;
    @Column(name = "CSI_ID")
    private int csiId;
    @Column(name = "INF_ID")
    private int infId;
    @Column(name = "SIV_ESTADO", nullable = false)
    private int sivEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "SIV_FECHA_FINAL")
    private Date sivFechaFinal;
    @Temporal(TemporalType.DATE)
    @Column(name = "SIV_FECHA_INICIAL")
    private Date sivFechaInicial;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "SIV_ID", nullable = false)
    private int sivId;
    @Column(name = "SIV_NOMBRE", length = 20)
    private String sivNombre;
    @Column(name = "SIV_NUMERO", length = 20)
    private String sivNumero;
    @Column(name = "TDO_ID")
    private int tdoId;
    @Column(name = "TIN_ID")
    private int tinId;
    @Column(name = "TSI_ID")
    private int tsiId;

    public ContratoSupInversiones() {
    }

    public ContratoSupInversiones(int conId, int csiId, int infId, int sivEstado,
                                   Date sivFechaFinal, Date sivFechaInicial, int sivId, String sivNombre,
                                   String sivNumero, int tdoId, int tinId, int tsiId) {
        this.conId = conId;
        this.csiId = csiId;
        this.infId = infId;
        this.sivEstado = sivEstado;
        this.sivFechaFinal = sivFechaFinal;
        this.sivFechaInicial = sivFechaInicial;
        this.sivId = sivId;
        this.sivNombre = sivNombre;
        this.tdoId = tdoId;
        this.tinId = tinId;
        this.tsiId = tsiId;
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

    public int getInfId() {
        return infId;
    }

    public void setInfId(int infId) {
        this.infId = infId;
    }

    public int getSivEstado() {
        return sivEstado;
    }

    public void setSivEstado(int sivEstado) {
        this.sivEstado = sivEstado;
    }

    public Date getSivFechaFinal() {
        return sivFechaFinal;
    }

    public void setSivFechaFinal(Date sivFechaFinal) {
        this.sivFechaFinal = sivFechaFinal;
    }

    public Date getSivFechaInicial() {
        return sivFechaInicial;
    }

    public void setSivFechaInicial(Date sivFechaInicial) {
        this.sivFechaInicial = sivFechaInicial;
    }

    public int getSivId() {
        return sivId;
    }

    public void setSivId(int sivId) {
        this.sivId = sivId;
    }

    public String getSivNombre() {
        return sivNombre;
    }

    public void setSivNombre(String sivNombre) {
        this.sivNombre = sivNombre;
    }


    public void setSivNumero(String sivNumero) {
        this.sivNumero = sivNumero;
    }

    public String getSivNumero() {
        return sivNumero;
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

    public int getTsiId() {
        return tsiId;
    }

    public void setTsiId(int tsiId) {
        this.tsiId = tsiId;
    }
    
    
}
