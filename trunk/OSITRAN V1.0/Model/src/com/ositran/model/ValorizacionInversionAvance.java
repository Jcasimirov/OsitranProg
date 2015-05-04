package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

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
@Table(name = "T_INV_AVN",uniqueConstraints = @UniqueConstraint(columnNames = {"TIA_NUMERO"}))
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_INV_AVN"))
public class ValorizacionInversionAvance implements Serializable {
    
    private static final double serialVersionUID = -8313961451913199541L;
    @Column(name = "CCO_ID")
    private int ccoId;
    @Column(name = "CON_ID")
    private int conId;
    @Column(name = "CSI_ID")
    private int csiId;
    @Column(name = "IAE_ID")
    private int iaeId;
    @Column(name = "INV_ID")
    private int invId;
    @Column(name = "MCO_ID")
    private int mcoId;
    @Column(name = "MON_ID")
    private int monId;
    @Column(name = "TCC_TIPO")
    private int tccTipo;
    @Column(name = "TIA_ANYO", nullable = false)
    private Integer tiaAnyo;
    @Column(name = "TIA_APROBADO_POR")
    private int tiaAprobadoPor;
    @Column(name = "TIA_ASUNTO", nullable = false, length = 4000)
    private String tiaAsunto;
    @Column(name = "TIA_DIAS_HABILES", nullable = false)
    private Integer tiaDiasHabiles;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIA_FECHA_FIN")
    private Date tiaFechaFin;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIA_FECHA_INICIO")
    private Date tiaFechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIA_FECHA_REGISTRO")
    private Date tiaFechaRegistro;
    @Temporal(TemporalType.DATE)
    @Column(name = "TIA_FECHA_VENCIMIENTO_PLAZO")
    private Date tiaFechaVencimientoPlazo;
    @Column(name = "TIA_HR", nullable = false)
    private int tiaHr;
    @Column(name = "TIA_MONTO_TOTAL_APROBADO", length = 4000)
    private String tiaMontoTotalAprobado;
    @Column(name = "TIA_MONTO_TOTAL_PRESENTADO")
    private BigDecimal tiaMontoTotalPresentado;
    @Column(name = "TIA_MONTO_TOTAL_REAJUSTADO")
    private BigDecimal tiaMontoTotalReajustado;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "TIA_NUMERO", nullable = false)
    private int tiaNumero;
    @Column(name = "TIA_PLAZO_EN_DIAS", nullable = false)
    private int tiaPlazoEnDias;
    @Column(name = "TIA_RUTA_NOT")
    private String tiaRutaNot;
    @Column(name = "TIN_ID")
    private int tinId;
    

    public ValorizacionInversionAvance() {
    }

    public ValorizacionInversionAvance(int ccoId, int conId, int csiId, int iaeId, int invId,
                         int mcoId, int monId, int tccTipo, Integer tiaAnyo,
                         int tiaAprobadoPor, String tiaAsunto, Integer tiaDiasHabiles, Date tiaFechaFin,
                         Date tiaFechaInicio, Date tiaFechaRegistro, Date tiaFechaVencimientoPlazo, int tiaHr,
                         String tiaMontoTotalAprobado, BigDecimal tiaMontoTotalPresentado, BigDecimal tiaMontoTotalReajustado,
                         int tiaNumero, int tiaPlazoEnDias, String tiaRutaNot, int tinId) {
        this.ccoId = ccoId;
        this.conId = conId;
        this.csiId = csiId;
        this.iaeId = iaeId;
        this.invId = invId;
        this.mcoId = mcoId;
        this.monId = monId;
        this.tccTipo = tccTipo;
        this.tiaAnyo = tiaAnyo;
        this.tiaAprobadoPor = tiaAprobadoPor;
        this.tiaAsunto = tiaAsunto;
        this.tiaDiasHabiles = tiaDiasHabiles;
        this.tiaFechaFin = tiaFechaFin;
        this.tiaFechaInicio = tiaFechaInicio;
        this.tiaFechaRegistro = tiaFechaRegistro;
        this.tiaFechaVencimientoPlazo = tiaFechaVencimientoPlazo;
        this.tiaHr = tiaHr;
        this.tiaMontoTotalAprobado = tiaMontoTotalAprobado;
        this.tiaMontoTotalPresentado = tiaMontoTotalPresentado;
        this.tiaMontoTotalReajustado = tiaMontoTotalReajustado;
        this.tiaNumero = tiaNumero;
        this.tiaPlazoEnDias = tiaPlazoEnDias;
        this.tiaRutaNot = tiaRutaNot;
        this.tinId = tinId;
    }

    public int getCcoId() {
        return ccoId;
    }

    public void setCcoId(int ccoId) {
        this.ccoId = ccoId;
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

    public int getIaeId() {
        return iaeId;
    }

    public void setIaeId(int iaeId) {
        this.iaeId = iaeId;
    }

    public int getInvId() {
        return invId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
    }

    public int getMcoId() {
        return mcoId;
    }

    public void setMcoId(int mcoId) {
        this.mcoId = mcoId;
    }

    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getTccTipo() {
        return tccTipo;
    }

    public void setTccTipo(int tccTipo) {
        this.tccTipo = tccTipo;
    }

    public Integer getTiaAnyo() {
        return tiaAnyo;
    }

    public void setTiaAnyo(Integer tiaAnyo) {
        this.tiaAnyo = tiaAnyo;
    }

    public int getTiaAprobadoPor() {
        return tiaAprobadoPor;
    }

    public void setTiaAprobadoPor(int tiaAprobadoPor) {
        this.tiaAprobadoPor = tiaAprobadoPor;
    }

    public String getTiaAsunto() {
        return tiaAsunto;
    }

    public void setTiaAsunto(String tiaAsunto) {
        this.tiaAsunto = tiaAsunto;
    }

    public Integer getTiaDiasHabiles() {
        return tiaDiasHabiles;
    }

    public void setTiaDiasHabiles(Integer tiaDiasHabiles) {
        this.tiaDiasHabiles = tiaDiasHabiles;
    }

    public Date getTiaFechaFin() {
        return tiaFechaFin;
    }

    public void setTiaFechaFin(Date tiaFechaFin) {
        this.tiaFechaFin = tiaFechaFin;
    }

    public Date getTiaFechaInicio() {
        return tiaFechaInicio;
    }

    public void setTiaFechaInicio(Date tiaFechaInicio) {
        this.tiaFechaInicio = tiaFechaInicio;
    }

    public Date getTiaFechaRegistro() {
        return tiaFechaRegistro;
    }

    public void setTiaFechaRegistro(Date tiaFechaRegistro) {
        this.tiaFechaRegistro = tiaFechaRegistro;
    }

    public Date getTiaFechaVencimientoPlazo() {
        return tiaFechaVencimientoPlazo;
    }

    public void setTiaFechaVencimientoPlazo(Date tiaFechaVencimientoPlazo) {
        this.tiaFechaVencimientoPlazo = tiaFechaVencimientoPlazo;
    }

    public int getTiaHr() {
        return tiaHr;
    }

    public void setTiaHr(int tiaHr) {
        this.tiaHr = tiaHr;
    }

    public String getTiaMontoTotalAprobado() {
        return tiaMontoTotalAprobado;
    }

    public void setTiaMontoTotalAprobado(String tiaMontoTotalAprobado) {
        this.tiaMontoTotalAprobado = tiaMontoTotalAprobado;
    }


    public void setTiaMontoTotalPresentado(BigDecimal tiaMontoTotalPresentado) {
        this.tiaMontoTotalPresentado = tiaMontoTotalPresentado;
    }

    public BigDecimal getTiaMontoTotalPresentado() {
        return tiaMontoTotalPresentado;
    }

    public void setTiaMontoTotalReajustado(BigDecimal tiaMontoTotalReajustado) {
        this.tiaMontoTotalReajustado = tiaMontoTotalReajustado;
    }

    public BigDecimal getTiaMontoTotalReajustado() {
        return tiaMontoTotalReajustado;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaPlazoEnDias() {
        return tiaPlazoEnDias;
    }

    public void setTiaPlazoEnDias(int tiaPlazoEnDias) {
        this.tiaPlazoEnDias = tiaPlazoEnDias;
    }

    public String getTiaRutaNot() {
        return tiaRutaNot;
    }

    public void setTiaRutaNot(String tiaRutaNot) {
        this.tiaRutaNot = tiaRutaNot;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }
    
    
    
    
    

}
