package com.ositran.model;
import java.io.Serializable;

import java.math.BigDecimal;

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
@Table(name = "T_INV_AVN_DERIVADA")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_INV_AVN_DERIVADA"))

public class InvAvnDerivada implements Serializable {
    private static final long serialVersionUID = -5883192881244593649L;
    @Column(name = "CSI_ID")
    private BigDecimal csiId;
    @Column(name = "IAD_ANYO")
    private Integer iadAnyo;
    @Column(name = "IAD_ASUNTO")
    private String iadAsunto;
    @Column(name = "IAD_DIAS_HABILES")
    private Integer iadDiasHabiles;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_EMISION")
    private Date iadFechaEmision;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_FIN")
    private Date iadFechaFin;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_INICIO")
    private Date iadFechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_RECEPCION")
    private Date iadFechaRecepcion;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_REGISTRO")
    private Date iadFechaRegistro;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_RESPUESTA")
    private Date iadFechaRespuesta;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_VENCIMIENTO")
    private Date iadFechaVencimiento;
    @Column(name = "IAD_HR")
    private BigDecimal iadHr;
    @Column(name = "IAD_NRO_CARTA", length = 20)
    private String iadNroCarta;
    
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IAD_NUMERO")
    private BigDecimal iadNumero;
    @Column(name = "IAD_PLAZO_DIAS")
    private Integer iadPlazoDias;
    @Column(name = "IAD_PLAZO_EN_DIAS")
    private Long iadPlazoEnDias;
    @Column(name = "IAD_REG_SALIDA", length = 20)
    private String iadRegSalida;
    @Column(name = "IAD_TIPO_DIAS")
    private BigDecimal iadTipoDias;
    @Column(name = "IAS_ESTADO")
    private BigDecimal iasEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAS_FECHA_ALTA")
    private Date iasFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAS_FECHA_BAJA")
    private Date iasFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAS_FECHA_CAMBIO")
    private Date iasFechaCambio;
    @Column(name = "IAS_TERMINAL", length = 20)
    private String iasTerminal;
    @Column(name = "IAS_USUARIO_ALTA", length = 20)
    private String iasUsuarioAlta;
    @Column(name = "IAS_USUARIO_BAJA", length = 20)
    private String iasUsuarioBaja;
    @Column(name = "IAS_USUARIO_CAMBIO", length = 20)
    private String iasUsuarioCambio;
    @Column(name = "INV_ID")
    private BigDecimal invId;
    @Column(name = "MCO_ID")
    private BigDecimal mcoId;
    @Column(name = "NRO_OFICIO", length = 50)
    private String nroOficio;
    @Column(name = "TIN_ID")
    private BigDecimal tinId;
    
    @Column(name = "IAD_TIPOSUP")
    private int iadTipoSup;
    @Column(name = "SUP_ID")
    private int supID ;
    @Column(name = "TSI_ID")
    private int tsiID;
    @Column(name = "TIA_NUMERO")
    private int tiaNumero;

    
    
    

    public InvAvnDerivada() {
    }

    public InvAvnDerivada(BigDecimal csiId, Integer iadAnyo, String iadAsunto, Integer iadDiasHabiles,
                            Date iadFechaEmision, Date iadFechaFin, Date iadFechaInicio, Date iadFechaRecepcion,
                            Date iadFechaRegistro, Date iadFechaRespuesta, Date iadFechaVencimiento, BigDecimal iadHr,
                            String iadNroCarta, BigDecimal iadNumero, Integer iadPlazoDias, Long iadPlazoEnDias,
                            String iadRegSalida, BigDecimal iadTipoDias, BigDecimal iasEstado, Date iasFechaAlta,
                            Date iasFechaBaja, Date iasFechaCambio, String iasTerminal, String iasUsuarioAlta,
                            String iasUsuarioBaja, String iasUsuarioCambio, BigDecimal invId, BigDecimal mcoId,
                            String nroOficio, BigDecimal tinId) {
        this.csiId = csiId;
        this.iadAnyo = iadAnyo;
        this.iadAsunto = iadAsunto;
        this.iadDiasHabiles = iadDiasHabiles;
        this.iadFechaEmision = iadFechaEmision;
        this.iadFechaFin = iadFechaFin;
        this.iadFechaInicio = iadFechaInicio;
        this.iadFechaRecepcion = iadFechaRecepcion;
        this.iadFechaRegistro = iadFechaRegistro;
        this.iadFechaRespuesta = iadFechaRespuesta;
        this.iadFechaVencimiento = iadFechaVencimiento;
        this.iadHr = iadHr;
        this.iadNroCarta = iadNroCarta;
        this.iadNumero = iadNumero;
        this.iadPlazoDias = iadPlazoDias;
        this.iadPlazoEnDias = iadPlazoEnDias;
        this.iadRegSalida = iadRegSalida;
        this.iadTipoDias = iadTipoDias;
        this.iasEstado = iasEstado;
        this.iasFechaAlta = iasFechaAlta;
        this.iasFechaBaja = iasFechaBaja;
        this.iasFechaCambio = iasFechaCambio;
        this.iasTerminal = iasTerminal;
        this.iasUsuarioAlta = iasUsuarioAlta;
        this.iasUsuarioBaja = iasUsuarioBaja;
        this.iasUsuarioCambio = iasUsuarioCambio;
        this.invId = invId;
        this.mcoId = mcoId;
        this.nroOficio = nroOficio;
        this.tinId = tinId;
    }

    public void setSupID(int supID) {
        this.supID = supID;
    }

    public int getSupID() {
        return supID;
    }

    public void setTsiID(int tsiID) {
        this.tsiID = tsiID;
    }

    public int getTsiID() {
        return tsiID;
    }

    public void setTiaNumero(int tiaNumero) {
        this.tiaNumero = tiaNumero;
    }

    public int getTiaNumero() {
        return tiaNumero;
    }

    public BigDecimal getCsiId() {
        return csiId;
    }

    public void setCsiId(BigDecimal csiId) {
        this.csiId = csiId;
    }

    public Integer getIadAnyo() {
        return iadAnyo;
    }

    public void setIadAnyo(Integer iadAnyo) {
        this.iadAnyo = iadAnyo;
    }

    public String getIadAsunto() {
        return iadAsunto;
    }

    public void setIadAsunto(String iadAsunto) {
        this.iadAsunto = iadAsunto;
    }

    public Integer getIadDiasHabiles() {
        return iadDiasHabiles;
    }

    public void setIadDiasHabiles(Integer iadDiasHabiles) {
        this.iadDiasHabiles = iadDiasHabiles;
    }

    public Date getIadFechaEmision() {
        return iadFechaEmision;
    }

    public void setIadFechaEmision(Date iadFechaEmision) {
        this.iadFechaEmision = iadFechaEmision;
    }

    public Date getIadFechaFin() {
        return iadFechaFin;
    }

    public void setIadFechaFin(Date iadFechaFin) {
        this.iadFechaFin = iadFechaFin;
    }

    public Date getIadFechaInicio() {
        return iadFechaInicio;
    }

    public void setIadFechaInicio(Date iadFechaInicio) {
        this.iadFechaInicio = iadFechaInicio;
    }

    public Date getIadFechaRecepcion() {
        return iadFechaRecepcion;
    }

    public void setIadFechaRecepcion(Date iadFechaRecepcion) {
        this.iadFechaRecepcion = iadFechaRecepcion;
    }

    public Date getIadFechaRegistro() {
        return iadFechaRegistro;
    }

    public void setIadFechaRegistro(Date iadFechaRegistro) {
        this.iadFechaRegistro = iadFechaRegistro;
    }

    public Date getIadFechaRespuesta() {
        return iadFechaRespuesta;
    }

    public void setIadFechaRespuesta(Date iadFechaRespuesta) {
        this.iadFechaRespuesta = iadFechaRespuesta;
    }

    public Date getIadFechaVencimiento() {
        return iadFechaVencimiento;
    }

    public void setIadFechaVencimiento(Date iadFechaVencimiento) {
        this.iadFechaVencimiento = iadFechaVencimiento;
    }

    public BigDecimal getIadHr() {
        return iadHr;
    }

    public void setIadHr(BigDecimal iadHr) {
        this.iadHr = iadHr;
    }

    public String getIadNroCarta() {
        return iadNroCarta;
    }

    public void setIadNroCarta(String iadNroCarta) {
        this.iadNroCarta = iadNroCarta;
    }

    public BigDecimal getIadNumero() {
        return iadNumero;
    }

    public void setIadNumero(BigDecimal iadNumero) {
        this.iadNumero = iadNumero;
    }

    public Integer getIadPlazoDias() {
        return iadPlazoDias;
    }

    public void setIadPlazoDias(Integer iadPlazoDias) {
        this.iadPlazoDias = iadPlazoDias;
    }

    public Long getIadPlazoEnDias() {
        return iadPlazoEnDias;
    }

    public void setIadPlazoEnDias(Long iadPlazoEnDias) {
        this.iadPlazoEnDias = iadPlazoEnDias;
    }

    public String getIadRegSalida() {
        return iadRegSalida;
    }

    public void setIadRegSalida(String iadRegSalida) {
        this.iadRegSalida = iadRegSalida;
    }

    public BigDecimal getIadTipoDias() {
        return iadTipoDias;
    }

    public void setIadTipoDias(BigDecimal iadTipoDias) {
        this.iadTipoDias = iadTipoDias;
    }

    public BigDecimal getIasEstado() {
        return iasEstado;
    }

    public void setIasEstado(BigDecimal iasEstado) {
        this.iasEstado = iasEstado;
    }

    public Date getIasFechaAlta() {
        return iasFechaAlta;
    }

    public void setIasFechaAlta(Date iasFechaAlta) {
        this.iasFechaAlta = iasFechaAlta;
    }

    public Date getIasFechaBaja() {
        return iasFechaBaja;
    }

    public void setIasFechaBaja(Date iasFechaBaja) {
        this.iasFechaBaja = iasFechaBaja;
    }

    public Date getIasFechaCambio() {
        return iasFechaCambio;
    }

    public void setIasFechaCambio(Date iasFechaCambio) {
        this.iasFechaCambio = iasFechaCambio;
    }

    public String getIasTerminal() {
        return iasTerminal;
    }

    public void setIasTerminal(String iasTerminal) {
        this.iasTerminal = iasTerminal;
    }

    public String getIasUsuarioAlta() {
        return iasUsuarioAlta;
    }

    public void setIasUsuarioAlta(String iasUsuarioAlta) {
        this.iasUsuarioAlta = iasUsuarioAlta;
    }

    public String getIasUsuarioBaja() {
        return iasUsuarioBaja;
    }

    public void setIasUsuarioBaja(String iasUsuarioBaja) {
        this.iasUsuarioBaja = iasUsuarioBaja;
    }

    public String getIasUsuarioCambio() {
        return iasUsuarioCambio;
    }

    public void setIasUsuarioCambio(String iasUsuarioCambio) {
        this.iasUsuarioCambio = iasUsuarioCambio;
    }

    public BigDecimal getInvId() {
        return invId;
    }

    public void setInvId(BigDecimal invId) {
        this.invId = invId;
    }

    public BigDecimal getMcoId() {
        return mcoId;
    }

    public void setMcoId(BigDecimal mcoId) {
        this.mcoId = mcoId;
    }

    public String getNroOficio() {
        return nroOficio;
    }

    public void setNroOficio(String nroOficio) {
        this.nroOficio = nroOficio;
    }

    public BigDecimal getTinId() {
        return tinId;
    }

    public void setTinId(BigDecimal tinId) {
        this.tinId = tinId;
    }


    public void setIadTipoSup(int iadTipoSup) {
        this.iadTipoSup = iadTipoSup;
    }

    public int getIadTipoSup() {
        return iadTipoSup;
    }

}
