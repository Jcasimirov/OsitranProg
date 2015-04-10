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
@NamedQueries({ @NamedQuery(name = "ContratoSupervisora.findAll", query = "select o from ContratoSupervisora o") })
@Table(name = "T_CONTRATO_SUPERVISORA")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_CONTRATO_SUPERVISORA"))
public class ContratoSupervisora implements Serializable {
    private static final long serialVersionUID = -2053453098288078717L;
    @Column(name = "CPS_ADELANTO_OTORGADO", nullable = false)
    private Integer cpsAdelantoOtorgado;
    @Column(name = "CPS_ANYO", nullable = false)
    private Integer cpsAnyo;
    @Column(name = "CPS_ARCHIVO_PDF")
    private String cpsArchivoPdf;
    @Column(name = "CPS_ASUNTO", nullable = false, length = 4000)
    private String cpsAsunto;
    @Column(name = "CPS_CADUCIDAD", nullable = false, length = 4000)
    private String cpsCaducidad;
    @Column(name = "CPS_ESTADO", nullable = false)
    private Integer cpsEstado;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_ADELANTO")
    private Date cpsFechaAdelanto;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_ALTA")
    private Date cpsFechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_BAJA")
    private Date cpsFechaBaja;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_CAMBIO")
    private Date cpsFechaCambio;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_INICIO")
    private Date cpsFechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_REGISTRO")
    private Date cpsFechaRegistro;
    @Temporal(TemporalType.DATE)
    @Column(name = "CPS_FECHA_SUSCRIPCION")
    private Date cpsFechaSuscripcion;
    @Column(name = "CPS_GARANTIAS", nullable = false, length = 4000)
    private String cpsGarantias;
    @Column(name = "CPS_MONTO_CONTRATADO", nullable = false)
    private Integer cpsMontoContratado;
    @Id
    @Column(name = "CPS_NRO_DE_CONTRATO", nullable = false)
    @GeneratedValue(generator = "generator")
    private Integer cpsNroDeContrato;
    @Column(name = "CPS_PENALIDADES", nullable = false, length = 4000)
    private String cpsPenalidades;
    @Column(name = "CPS_PLAZO_CONTRATO", nullable = false)
    private Integer cpsPlazoContrato;
    @Column(name = "CPS_STD", nullable = false)
    private Integer cpsStd;
    @Column(name = "CPS_TERMINAL", length = 20)
    private String cpsTerminal;
    @Column(name = "CPS_USUARIO_ALTA", length = 20)
    private String cpsUsuarioAlta;
    @Column(name = "CPS_USUARIO_BAJA", length = 20)
    private String cpsUsuarioBaja;
    
    @Column(name = "CPS_USUARIO_CAMBIO", length = 20)    
    private String cpsUsuarioCambio;
    
    @Column(name = "INF_ID")    
    private Integer infraestructura;
    
    @Column(name = "TIN_ID")    
    private Integer tipoInfraestructura;
    
    @Column(name = "CSI_ID")    
    private Integer concesion;
    
    @Column(name = "SUP_ID")
    private Integer empresaSupervisora;
        
    @Column(name = "CON_ID")
    private Integer contrato;
    
    /*
    @ManyToOne
    @JoinColumns({
                 @JoinColumn(name = "INF_ID", referencedColumnName = "INF_ID"),
                 @JoinColumn(name = "TIN_ID", referencedColumnName = "TIN_ID"),
                 @JoinColumn(name = "CSI_ID", referencedColumnName = "CSI_ID")
        })
    private Infraestructura infraestructura2;
    @ManyToOne
    @JoinColumn(name = "SUP_ID")
    private EmpresaSupervisora empresaSupervisora;
    @OneToOne(mappedBy = "contratoSupervisora")
    private ContratoSupervisoraAdenda TContratoSupervisoraAdendaList;
    @ManyToOne
    @JoinColumn(name = "CON_ID")
    private Contrato contrato;
    */
    
    public ContratoSupervisora() {
    }

    public ContratoSupervisora(Integer cpsAdelantoOtorgado, Integer cpsAnyo, String cpsArchivoPdf, String cpsAsunto,
                               String cpsCaducidad, Integer cpsEstado, Date cpsFechaAdelanto, Date cpsFechaAlta,
                               Date cpsFechaBaja, Date cpsFechaCambio, Date cpsFechaInicio, Date cpsFechaRegistro,
                               Date cpsFechaSuscripcion, String cpsGarantias, Integer cpsMontoContratado,
                               Integer cpsNroDeContrato, String cpsPenalidades, Integer cpsPlazoContrato,
                               Integer cpsStd, String cpsTerminal, String cpsUsuarioAlta, String cpsUsuarioBaja,
                               String cpsUsuarioCambio, Integer infraestructura, Integer tipoInfraestructura,
                               Integer concesion, Integer empresaSupervisora, Integer contrato) {
        super();
        this.cpsAdelantoOtorgado = cpsAdelantoOtorgado;
        this.cpsAnyo = cpsAnyo;
        this.cpsArchivoPdf = cpsArchivoPdf;
        this.cpsAsunto = cpsAsunto;
        this.cpsCaducidad = cpsCaducidad;
        this.cpsEstado = cpsEstado;
        this.cpsFechaAdelanto = cpsFechaAdelanto;
        this.cpsFechaAlta = cpsFechaAlta;
        this.cpsFechaBaja = cpsFechaBaja;
        this.cpsFechaCambio = cpsFechaCambio;
        this.cpsFechaInicio = cpsFechaInicio;
        this.cpsFechaRegistro = cpsFechaRegistro;
        this.cpsFechaSuscripcion = cpsFechaSuscripcion;
        this.cpsGarantias = cpsGarantias;
        this.cpsMontoContratado = cpsMontoContratado;
        this.cpsNroDeContrato = cpsNroDeContrato;
        this.cpsPenalidades = cpsPenalidades;
        this.cpsPlazoContrato = cpsPlazoContrato;
        this.cpsStd = cpsStd;
        this.cpsTerminal = cpsTerminal;
        this.cpsUsuarioAlta = cpsUsuarioAlta;
        this.cpsUsuarioBaja = cpsUsuarioBaja;
        this.cpsUsuarioCambio = cpsUsuarioCambio;
        this.infraestructura = infraestructura;
        this.tipoInfraestructura = tipoInfraestructura;
        this.concesion = concesion;
        this.empresaSupervisora = empresaSupervisora;
        this.contrato = contrato;
    }

    public Integer getCpsAdelantoOtorgado() {
        return cpsAdelantoOtorgado;
    }

    public void setCpsAdelantoOtorgado(Integer cpsAdelantoOtorgado) {
        this.cpsAdelantoOtorgado = cpsAdelantoOtorgado;
    }

    public Integer getCpsAnyo() {
        return cpsAnyo;
    }

    public void setCpsAnyo(Integer cpsAnyo) {
        this.cpsAnyo = cpsAnyo;
    }

    public String getCpsArchivoPdf() {
        return cpsArchivoPdf;
    }

    public void setCpsArchivoPdf(String cpsArchivoPdf) {
        this.cpsArchivoPdf = cpsArchivoPdf;
    }

    public String getCpsAsunto() {
        return cpsAsunto;
    }

    public void setCpsAsunto(String cpsAsunto) {
        this.cpsAsunto = cpsAsunto;
    }

    public String getCpsCaducidad() {
        return cpsCaducidad;
    }

    public void setCpsCaducidad(String cpsCaducidad) {
        this.cpsCaducidad = cpsCaducidad;
    }

    public Integer getCpsEstado() {
        return cpsEstado;
    }

    public void setCpsEstado(Integer cpsEstado) {
        this.cpsEstado = cpsEstado;
    }

    public Date getCpsFechaAdelanto() {
        return cpsFechaAdelanto;
    }

    public void setCpsFechaAdelanto(Date cpsFechaAdelanto) {
        this.cpsFechaAdelanto = cpsFechaAdelanto;
    }

    public Date getCpsFechaAlta() {
        return cpsFechaAlta;
    }

    public void setCpsFechaAlta(Date cpsFechaAlta) {
        this.cpsFechaAlta = cpsFechaAlta;
    }

    public Date getCpsFechaBaja() {
        return cpsFechaBaja;
    }

    public void setCpsFechaBaja(Date cpsFechaBaja) {
        this.cpsFechaBaja = cpsFechaBaja;
    }

    public Date getCpsFechaCambio() {
        return cpsFechaCambio;
    }

    public void setCpsFechaCambio(Date cpsFechaCambio) {
        this.cpsFechaCambio = cpsFechaCambio;
    }

    public Date getCpsFechaInicio() {
        return cpsFechaInicio;
    }

    public void setCpsFechaInicio(Date cpsFechaInicio) {
        this.cpsFechaInicio = cpsFechaInicio;
    }

    public Date getCpsFechaRegistro() {
        return cpsFechaRegistro;
    }

    public void setCpsFechaRegistro(Date cpsFechaRegistro) {
        this.cpsFechaRegistro = cpsFechaRegistro;
    }

    public Date getCpsFechaSuscripcion() {
        return cpsFechaSuscripcion;
    }

    public void setCpsFechaSuscripcion(Date cpsFechaSuscripcion) {
        this.cpsFechaSuscripcion = cpsFechaSuscripcion;
    }

    public String getCpsGarantias() {
        return cpsGarantias;
    }

    public void setCpsGarantias(String cpsGarantias) {
        this.cpsGarantias = cpsGarantias;
    }

    public Integer getCpsMontoContratado() {
        return cpsMontoContratado;
    }

    public void setCpsMontoContratado(Integer cpsMontoContratado) {
        this.cpsMontoContratado = cpsMontoContratado;
    }

    public Integer getCpsNroDeContrato() {
        return cpsNroDeContrato;
    }

    public void setCpsNroDeContrato(Integer cpsNroDeContrato) {
        this.cpsNroDeContrato = cpsNroDeContrato;
    }

    public String getCpsPenalidades() {
        return cpsPenalidades;
    }

    public void setCpsPenalidades(String cpsPenalidades) {
        this.cpsPenalidades = cpsPenalidades;
    }

    public Integer getCpsPlazoContrato() {
        return cpsPlazoContrato;
    }

    public void setCpsPlazoContrato(Integer cpsPlazoContrato) {
        this.cpsPlazoContrato = cpsPlazoContrato;
    }

    public Integer getCpsStd() {
        return cpsStd;
    }

    public void setCpsStd(Integer cpsStd) {
        this.cpsStd = cpsStd;
    }

    public String getCpsTerminal() {
        return cpsTerminal;
    }

    public void setCpsTerminal(String cpsTerminal) {
        this.cpsTerminal = cpsTerminal;
    }

    public String getCpsUsuarioAlta() {
        return cpsUsuarioAlta;
    }

    public void setCpsUsuarioAlta(String cpsUsuarioAlta) {
        this.cpsUsuarioAlta = cpsUsuarioAlta;
    }

    public String getCpsUsuarioBaja() {
        return cpsUsuarioBaja;
    }

    public void setCpsUsuarioBaja(String cpsUsuarioBaja) {
        this.cpsUsuarioBaja = cpsUsuarioBaja;
    }

    public String getCpsUsuarioCambio() {
        return cpsUsuarioCambio;
    }

    public void setCpsUsuarioCambio(String cpsUsuarioCambio) {
        this.cpsUsuarioCambio = cpsUsuarioCambio;
    }

    /*
    public Infraestructura getInfraestructura2() {
        return infraestructura2;
    }

    public void setInfraestructura2(Infraestructura infraestructura2) {
        this.infraestructura2 = infraestructura2;
    }

    public EmpresaSupervisora getEmpresaSupervisora() {
        return empresaSupervisora;
    }

    public void setEmpresaSupervisora(EmpresaSupervisora empresaSupervisora) {
        this.empresaSupervisora = empresaSupervisora;
    }

    public ContratoSupervisoraAdenda getTContratoSupervisoraAdendaList() {
        return TContratoSupervisoraAdendaList;
    }

    public void setTContratoSupervisoraAdendaList(ContratoSupervisoraAdenda TContratoSupervisoraAdendaList) {
        this.TContratoSupervisoraAdendaList = TContratoSupervisoraAdendaList;
    }

    public Contrato getContrato7() {
        return contrato;
    }

    public void setContrato7(Contrato contrato7) {
        this.contrato = contrato7;
    }*/


    public void setInfraestructura(Integer infraestructura) {
        this.infraestructura = infraestructura;
    }

    public Integer getInfraestructura() {
        return infraestructura;
    }


    public void setTipoInfraestructura(Integer tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public Integer getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setConcesion(Integer concesion) {
        this.concesion = concesion;
    }

    public Integer getConcesion() {
        return concesion;
    }

    public void setEmpresaSupervisora(Integer empresaSupervisora) {
        this.empresaSupervisora = empresaSupervisora;
    }

    public Integer getEmpresaSupervisora() {
        return empresaSupervisora;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    public Integer getContrato() {
        return contrato;
    }
    
    
}
