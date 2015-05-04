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
@Table(name = "T_INV_AVN_DERIVADA")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_INV_AVN_DERIVADA"))
public class DerivarReconocimientoSupervisor implements Serializable {
    private static final Long serialVersionUID = -2681439446291471079L;
    @Column(name = "CSI_ID")
    private int csiId;
    @Column(name = "IAD_ANYO")
    private int iadAnyo;
    @Column(name = "IAD_ASUNTO")
    private String iadAsunto;
    @Column(name = "IAD_DIAS_HABILES")
    private int iadDiasHabiles;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_EMISI�N")
    private Date iadFechaEmisi�n;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_FIN")
    private Date iadFechaFin;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_INICIO")
    private Date iadFechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_RECEPCI�N")
    private Date iadFechaRecepci�n;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_REGISTRO")
    private Date iadFechaRegistro;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_RESPUESTA")
    private Date iadFechaRespuesta;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAD_FECHA_VENCIMIENTO")
    private Date iadFechaVencimiento;
    @Column(name = "IAD_HR", nullable = false)
    private int iadHr;
    @Column(name = "IAD_NRO_CARTA", length = 20)
    private String iadNroCarta;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "IAD_NUMERO", nullable = false)
    private int iadNumero;
    @Column(name = "IAD_PLAZO_D�AS", nullable = false)
    private int iadPlazoD�as;
    @Column(name = "IAD_PLAZO_EN_D�AS", nullable = false)
    private double iadPlazoEnD�as;
    @Column(name = "IAD_REG_SALIDA", length = 20)
    private String iadRegSalida;
    @Column(name = "IAD_TIPO_D�AS", nullable = false)
    private int iadTipoD�as;
    @Column(name = "IAS_ESTADO", nullable = false)
    private int iasEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "IAS_FECHA_ALTA", nullable = false)
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
    private int invId;
    @Column(name = "MCO_ID")
    private int mcoId;
    @Column(name = "NRO_OFICIO", length = 50)
    private String nroOficio;
    @Column(name = "TIN_ID")
    private int tinId;

    public DerivarReconocimientoSupervisor() {
    }

    public DerivarReconocimientoSupervisor(int csiId, int iadAnyo, String iadAsunto, int iadDiasHabiles,
                           Date iadFechaEmisi�n, Date iadFechaFin, Date iadFechaInicio, Date iadFechaRecepci�n,
                           Date iadFechaRegistro, Date iadFechaRespuesta, Date iadFechaVencimiento, int iadHr,
                           String iadNroCarta, int iadNumero, int iadPlazoD�as, double iadPlazoEnD�as,
                           String iadRegSalida, int iadTipoD�as, int iasEstado, Date iasFechaAlta,
                           Date iasFechaBaja, Date iasFechaCambio, String iasTerminal, String iasUsuarioAlta,
                           String iasUsuarioBaja, String iasUsuarioCambio, int invId, int mcoId,
                           String nroOficio, int tinId) {
        this.csiId = csiId;
        this.iadAnyo = iadAnyo;
        this.iadAsunto = iadAsunto;
        this.iadDiasHabiles = iadDiasHabiles;
        this.iadFechaEmisi�n = iadFechaEmisi�n;
        this.iadFechaFin = iadFechaFin;
        this.iadFechaInicio = iadFechaInicio;
        this.iadFechaRecepci�n = iadFechaRecepci�n;
        this.iadFechaRegistro = iadFechaRegistro;
        this.iadFechaRespuesta = iadFechaRespuesta;
        this.iadFechaVencimiento = iadFechaVencimiento;
        this.iadHr = iadHr;
        this.iadNroCarta = iadNroCarta;
        this.iadNumero = iadNumero;
        this.iadPlazoD�as = iadPlazoD�as;
        this.iadPlazoEnD�as = iadPlazoEnD�as;
        this.iadRegSalida = iadRegSalida;
        this.iadTipoD�as = iadTipoD�as;
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

    public int getCsiId() {
        return csiId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getIadAnyo() {
        return iadAnyo;
    }

    public void setIadAnyo(int iadAnyo) {
        this.iadAnyo = iadAnyo;
    }

    public String getIadAsunto() {
        return iadAsunto;
    }

    public void setIadAsunto(String iadAsunto) {
        this.iadAsunto = iadAsunto;
    }

    public int getIadDiasHabiles() {
        return iadDiasHabiles;
    }

    public void setIadDiasHabiles(int iadDiasHabiles) {
        this.iadDiasHabiles = iadDiasHabiles;
    }

    public Date getIadFechaEmisi�n() {
        return iadFechaEmisi�n;
    }

    public void setIadFechaEmisi�n(Date iadFechaEmisi�n) {
        this.iadFechaEmisi�n = iadFechaEmisi�n;
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

    public Date getIadFechaRecepci�n() {
        return iadFechaRecepci�n;
    }

    public void setIadFechaRecepci�n(Date iadFechaRecepci�n) {
        this.iadFechaRecepci�n = iadFechaRecepci�n;
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

    public int getIadHr() {
        return iadHr;
    }

    public void setIadHr(int iadHr) {
        this.iadHr = iadHr;
    }

    public String getIadNroCarta() {
        return iadNroCarta;
    }

    public void setIadNroCarta(String iadNroCarta) {
        this.iadNroCarta = iadNroCarta;
    }

    public int getIadNumero() {
        return iadNumero;
    }

    public void setIadNumero(int iadNumero) {
        this.iadNumero = iadNumero;
    }

    public int getIadPlazoD�as() {
        return iadPlazoD�as;
    }

    public void setIadPlazoD�as(int iadPlazoD�as) {
        this.iadPlazoD�as = iadPlazoD�as;
    }

    public double getIadPlazoEnD�as() {
        return iadPlazoEnD�as;
    }

    public void setIadPlazoEnD�as(double iadPlazoEnD�as) {
        this.iadPlazoEnD�as = iadPlazoEnD�as;
    }

    public String getIadRegSalida() {
        return iadRegSalida;
    }

    public void setIadRegSalida(String iadRegSalida) {
        this.iadRegSalida = iadRegSalida;
    }

    public int getIadTipoD�as() {
        return iadTipoD�as;
    }

    public void setIadTipoD�as(int iadTipoD�as) {
        this.iadTipoD�as = iadTipoD�as;
    }

    public int getIasEstado() {
        return iasEstado;
    }

    public void setIasEstado(int iasEstado) {
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

    public String getNroOficio() {
        return nroOficio;
    }

    public void setNroOficio(String nroOficio) {
        this.nroOficio = nroOficio;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }
}
