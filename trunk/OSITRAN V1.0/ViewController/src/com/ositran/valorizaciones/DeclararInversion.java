package com.ositran.valorizaciones;

import com.ositran.service.ConcesionarioService;
import com.ositran.service.MonedaService;
import com.ositran.service.PeriodoService;
import com.ositran.service.TipoInversionServices;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoCompromisoServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoInversionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.InvReajusteServiceImpl;
import com.ositran.serviceimpl.InvReconocimientoServiceImpl;
import com.ositran.serviceimpl.InvServiceImpl;
import com.ositran.serviceimpl.InversionAvanceEstadoServiceImpl;
import com.ositran.serviceimpl.InversionDescripcionServicesImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.serviceimpl.NotificacionServiceImpl;
import com.ositran.serviceimpl.ValorizacionInversionAvanceDetalleServiceImpl;
import com.ositran.util.Constantes;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoInversionVO;
import com.ositran.vo.bean.ContratoRespSupVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InvAvnEstadoVO;
import com.ositran.vo.bean.InvAvnVO;
import com.ositran.vo.bean.InvReajusteVO;
import com.ositran.vo.bean.InvReconocimientoVO;
import com.ositran.vo.bean.InvVO;
import com.ositran.vo.bean.InversionDescripcionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.PeriodoVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TipoInversionVO;
import com.ositran.vo.bean.UsuarioVO;
import com.ositran.vo.bean.ValorizacionInversionAvanceDetalleVO;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;

@ManagedBean(name = "declararInversionMB")
@ViewScoped
public class DeclararInversion {

    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    private ContratoConcesionServiceImpl contratoConcesionServiceImp;
    @ManagedProperty(value = "#{contratoVO}")
    private ContratoVO contratoVO;
    @ManagedProperty(value = "#{monedaServiceImpl}")
    private MonedaService monedaServiceImpl;
    private MonedaVO monedaVO;
    private List<MonedaVO> listaTipoMonedas = new ArrayList<MonedaVO>();
    HashMap<String,Object> monedaDescripcionMemoria=new HashMap<String,Object>();
    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{concesionServiceImpl}")
    private ConcesionServiceImpl concesionServiceImpl;

    @ManagedProperty(value = "#{concesionarioServiceImpl}")
    private ConcesionarioService concesionarioServiceImpl;

    @ManagedProperty(value = "#{concesionarioVO}")
    private ConcesionarioVO concesionarioVO;

    @ManagedProperty(value = "#{modalidadServiceImp}")
    private ModalidadConcesionServiceImpl modalidadServiceImp;

    private List<PeriodoVO> listarPeriodos = new ArrayList<PeriodoVO>();

    private List<ContratoVO> listaContrato = new ArrayList<ContratoVO>();

    @ManagedProperty(value = "#{periodoServiceImpl}")
    private PeriodoService periodoServiceImpl;

    @ManagedProperty(value = "#{tipoInversionServicesImpl}")
    private TipoInversionServices tipoInversionServicesImpl;
    private List<TipoInversionVO> listaTipoInversion = new ArrayList<TipoInversionVO>();

    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    private InfraestructuraServiceImpl infraestructuraServiceImpl;

    @ManagedProperty(value = "#{contratoInversionServiceImpl}")
    private ContratoInversionServiceImpl contratoInversionServiceImpl;
    private List<ContratoInversionVO> listaInversiones;

    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
    private ContratoCompromisoServiceImpl contratoCompromisoServiceImpl;

    @ManagedProperty(value = "#{contratoCompromisoVO}")
    private ContratoCompromisoVO contratoCompromisoVO;
    private List<ContratoCompromisoVO> listaContratoCompromiso;

    @ManagedProperty(value = "#{contratoRespSupVO}")
    private ContratoRespSupVO contratoRespSupVO;

    @ManagedProperty(value = "#{notificacionServiceImpl}")
    private NotificacionServiceImpl notificacionServiceImpl;
    private List<InvAvnVO> listaInvAvnVO = new ArrayList<InvAvnVO>();
    @ManagedProperty(value = "#{invAvnVO}")
    private InvAvnVO invAvnVO;

    @ManagedProperty(value = "#{inversionAvanceEstadoServiceImpl}")
    private InversionAvanceEstadoServiceImpl inversionAvanceEstadoServiceImpl;
    private List<InvAvnEstadoVO> listaInvAvnEstadoVO = new ArrayList<InvAvnEstadoVO>();

    @ManagedProperty(value = "#{invServiceImpl}")
    private InvServiceImpl invServiceImpl;
    @ManagedProperty(value = "#{invVO}")
    private InvVO invVO;

    @ManagedProperty(value = "#{invReconocimientoServiceImpl}")
    private InvReconocimientoServiceImpl invReconocimientoServiceImpl;
    private List<InvReconocimientoVO> listaInvReconocimientoVO = new ArrayList<InvReconocimientoVO>();

    @ManagedProperty(value = "#{invReajusteServiceImpl}")
    private InvReajusteServiceImpl invReajusteServiceImpl;
    private List<InvReajusteVO> listaInvReajusteVO = new ArrayList<InvReajusteVO>();

    @ManagedProperty(value = "#{valorizacionInversionAvanceDetalleServiceImpl}")
    private ValorizacionInversionAvanceDetalleServiceImpl valorizacionInversionAvanceDetalleServiceImpl;
    private List<ValorizacionInversionAvanceDetalleVO> listaInvAvanceDetalleVO;
    @ManagedProperty(value = "#{valorizacionInversionAvanceDetalleVO}")
    private ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO;

    @ManagedProperty(value = "#{inversionDescripcionServicesImpl}")
    private InversionDescripcionServicesImpl inversionDescripcionServicesImpl;
    private List<InversionDescripcionVO> ListaInversionDescripcionVO;
    private InversionDescripcionVO inversionDescripcionVO;

    private String nombreConcesion;
    private int tipoinfra;
    int modalidad, concesion;
    private Date fechaInicio;
    Date fechaFin;
    private Date fechaInicioSuscripcion;
    private Date fechaFinSuscripcion;
    private Integer infraestructuraId = 0;
    private Integer contratoCompromisoId = 0;
    private int codigoAeropuerto;
    private int codigoContrato;
    private int codigoInversion;
    private int tipoInfraestructura;

    private DefaultStreamedContent downloadFichaResumen;
    private List<ConcesionVO> listaConcesiones;
    private List<InfraestructuraTipoVO> listaTipoInfraestructura;
    private List<InfraestructuraVO> listaInfraestructura;
    HashMap<String,Object> infraestructuraMemoria=new HashMap<String,Object>();
    private List<ModalidadConcesionVO> listaModalidad;


    // seguridad
    private RolOpcionesVO rolOpcion;
    private UsuarioVO usuario;
    public final int formulario = 30;

    // datos de inv
    private Integer reconoEstado = 0;
    private String reconoObs;
    private BigDecimal totalMontoPresentado = BigDecimal.ZERO;
    private BigDecimal totalMontoAprobado = BigDecimal.ZERO;
    private BigDecimal totalMontoReajustado = BigDecimal.ZERO;
    private int cantFilas;

    private boolean renderMostrarIGV = false;
    private BigDecimal igv = BigDecimal.ZERO;
    private boolean deshabilitadoxObservado;

    private BigDecimal totalivrMontoAprobado = BigDecimal.ZERO;
    private BigDecimal totalirjMontoAprobado = BigDecimal.ZERO;
    private BigDecimal totalirjMontoReajuste = BigDecimal.ZERO;

    private BigDecimal totalivrMontoAprobadoI = BigDecimal.ZERO;
    private BigDecimal totalirjMontoReajusteI = BigDecimal.ZERO;
    private InvReconocimientoVO invReconocimientoVO;
    private InvReajusteVO invReajusteVO;
    private boolean mostrarxDeclaracionCargada = false;
    private boolean deshabilitadoxDeclaracionNoCargada = true;
    private Date fechaactual;
    public DeclararInversion() {
        super();
     
    }


    public void validarSesion() throws IOException {
        setRolOpcion(ControlAcceso.getNewInstance().validarSesion(formulario));
        setUsuario(Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado());
        setTipoInfraestructura(Reutilizar.getNewInstance().obtenerDatosEmpleadoLogueado().getTinId());
        if (getTipoInfraestructura() != 2) {
            setCantFilas(3);
        } else {
            setCantFilas(4);
        }
        invVO.setInvEstadoReconocimiento(-1);
    }
    // Metodo para Buscar Contrato de Concesion y llenar los demas tabs
    public void abrirBuscarContratos() {
        resetearCamposBuscarContratos();
        if (nombreConcesion.length() != 0) {
        buscarContratos();
        }
        System.out.println("abrirBuscarContratos()");
    }
    // Metodo para Filtrar la Lista de Concesión

    /**Se filtrara siemrpre para tener solamente las concesiones
     * con el tipo de infraestructura del usuario que se logueo**/
    public void filtrarConcesion() {
        try {
            listaConcesiones = getConcesionServiceImpl().filtrarConcesion(tipoInfraestructura);
        } catch (Exception e) {
            System.out.println("listaConcesiones e");
            e.printStackTrace();
        }
    }

    public void buscarContratos() {
        try {
            setListaContrato(getContratoConcesionServiceImp().buscarxNombreConcesion(getNombreConcesion().toUpperCase().trim(),
                                                                                     tipoInfraestructura,
                                                                                     getConcesion(),
                                                                                     getFechaInicioSuscripcion(),
                                                                                     getFechaFinSuscripcion()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void seleccionarContrato(ActionEvent e) {
        limpiarFormulario();
        monedaVO = null;
        listaInvAvnVO = null;
        listaContratoCompromiso = null;
        contratoCompromisoVO = null;
        invVO=new InvVO();
        invAvnVO=new InvAvnVO();
        setContratoVO((ContratoVO) e.getComponent().getAttributes().get("idcontrato"));
        listarTiposMoneda();
        cargarDatosConcesionario(getContratoVO().getCncId());
        cargarInfraestructurasContrato(getContratoVO().getConId());
        contratoCompromisoId = 0;
        cargarListaCompromisos();
        resetDialogoBuscarContrato();
    }

    // Metodo Para Listar Infraestructuras

    public void cargarInfraestructurasContrato(Integer contratoId) {
        try {
            listaInfraestructura = getInfraestructuraServiceImpl().getInfraestructurasContrato(contratoId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetDialogoBuscarContrato() {
        tipoinfra = 0;
        concesion = 0;
        modalidad = 0;
        setListaContrato(null);
        listaContrato = new ArrayList<ContratoVO>();
    }

    public void resetearCamposBuscarContratos() {
        concesion = 0;
        listaContrato=new ArrayList<ContratoVO>();
    }

    public ContratoConcesionServiceImpl getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }

    public void setContratoConcesionServiceImp(ContratoConcesionServiceImpl contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public List<ContratoVO> getListaContrato() {
        return listaContrato;
    }

    public void setListaContrato(List<ContratoVO> listaContrato) {
        this.listaContrato = listaContrato;
    }

    public int getTipoinfra() {
        return tipoinfra;
    }

    public void setTipoinfra(int tipoinfra) {
        this.tipoinfra = tipoinfra;
    }

    public int getModalidad() {
        return modalidad;
    }

    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }

    public int getConcesion() {
        return concesion;
    }

    public void setConcesion(int concesion) {
        this.concesion = concesion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicioSuscripcion() {
        return fechaInicioSuscripcion;
    }

    public void setFechaInicioSuscripcion(Date fechaInicioSuscripcion) {
        this.fechaInicioSuscripcion = fechaInicioSuscripcion;
    }

    public Date getFechaFinSuscripcion() {
        return fechaFinSuscripcion;
    }

    public void setFechaFinSuscripcion(Date fechaFinSuscripcion) {
        this.fechaFinSuscripcion = fechaFinSuscripcion;
    }

    public List<ConcesionVO> getListaConcesiones() {
        return listaConcesiones;
    }

    public void setListaConcesiones(List<ConcesionVO> listaConcesiones) {
        this.listaConcesiones = listaConcesiones;
    }

    public List<InfraestructuraTipoVO> getListaTipoInfraestructura() {
        return listaTipoInfraestructura;
    }

    public void setListaTipoInfraestructura(List<InfraestructuraTipoVO> listaTipoInfraestructura) {
        this.listaTipoInfraestructura = listaTipoInfraestructura;
    }

    public List<InfraestructuraVO> getListaInfraestructura() {
        return listaInfraestructura;
    }

    public void setListaInfraestructura(List<InfraestructuraVO> listaInfraestructura) {
        this.listaInfraestructura = listaInfraestructura;
    }

    public List<ModalidadConcesionVO> getListaModalidad() {
        return listaModalidad;
    }

    public void setListaModalidad(List<ModalidadConcesionVO> listaModalidad) {
        this.listaModalidad = listaModalidad;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public void listarTiposMoneda() {
        try {
            listaTipoMonedas = getMonedaServiceImpl().query();
            monedaDescripcionMemoria.put("0", "");
            for (MonedaVO monedaVO : listaTipoMonedas) {
               monedaDescripcionMemoria.put(""+monedaVO.getMonId(), monedaVO.getMonNombre());
           }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    public List<MonedaVO> getListaTipoMonedas() {
        return listaTipoMonedas;
    }

    public void setListaTipoMonedas(List<MonedaVO> listaTipoMonedas) {
        this.listaTipoMonedas = listaTipoMonedas;
    }

    public MonedaService getMonedaServiceImpl() {
        return monedaServiceImpl;
    }

    public void setMonedaServiceImpl(MonedaService monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }

    public String getNombreConcesion() {
        return nombreConcesion;
    }

    public void setNombreConcesion(String nombreConcesion) {
        this.nombreConcesion = nombreConcesion;
    }

    public void listarTiposdeInfraestructura() throws SQLException {
        try {
            listaTipoInfraestructura = getInfraestructuraTipoServiceImpl().query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public void ListarModalidad() throws SQLException {
        try {
            listaModalidad = this.getModalidadServiceImp().query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    public ConcesionServiceImpl getConcesionServiceImpl() {
        return concesionServiceImpl;
    }

    public void setConcesionServiceImpl(ConcesionServiceImpl concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public void preDownloadFichaResumen(String nombreArchivo) {
        try {
            setDownloadFichaResumen(Reutilizar.getNewInstance().preDownload(Constantes.RUTAFICHASRESUMEN +
                                                                            nombreArchivo));
        } catch (FileNotFoundException fnfe) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                          Constantes.ARCHIVONOENCONTRADO));
        }
    }

    public DefaultStreamedContent getDownloadFichaResumen() {
        return downloadFichaResumen;
    }

    public void setDownloadFichaResumen(DefaultStreamedContent downloadFichaResumen) {
        this.downloadFichaResumen = downloadFichaResumen;
    }

    public void cargarDatosConcesionario(int idconcesionario) {
        try {
            setConcesionarioVO(getConcesionarioServiceImpl().get(idconcesionario));
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

    }

    public ConcesionarioService getConcesionarioServiceImpl() {
        return concesionarioServiceImpl;
    }

    public void setConcesionarioServiceImpl(ConcesionarioService concesionarioServiceImpl) {
        this.concesionarioServiceImpl = concesionarioServiceImpl;
    }

    public ConcesionarioVO getConcesionarioVO() {
        return concesionarioVO;
    }

    public void setConcesionarioVO(ConcesionarioVO concesionarioVO) {
        this.concesionarioVO = concesionarioVO;

    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public int getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setTipoInfraestructura(int tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public ModalidadConcesionServiceImpl getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public void setModalidadServiceImp(ModalidadConcesionServiceImpl modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public void listaPeriodos() {
        try {
            setListarPeriodos(getPeriodoServiceImpl().query());
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }

    public List<PeriodoVO> getListarPeriodos() {
        return listarPeriodos;
    }

    public void setListarPeriodos(List<PeriodoVO> listarPeriodos) {
        this.listarPeriodos = listarPeriodos;
    }

    public PeriodoService getPeriodoServiceImpl() {
        return periodoServiceImpl;
    }

    public void setPeriodoServiceImpl(PeriodoService periodoServiceImpl) {
        this.periodoServiceImpl = periodoServiceImpl;
    }

    public void listarTipoInversion() {
        try {
            setListaTipoInversion(getTipoInversionServicesImpl().query());
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

    }

    public TipoInversionServices getTipoInversionServicesImpl() {
        return tipoInversionServicesImpl;
    }

    public void setTipoInversionServicesImpl(TipoInversionServices tipoInversionServicesImpl) {
        this.tipoInversionServicesImpl = tipoInversionServicesImpl;
    }

    public List<TipoInversionVO> getListaTipoInversion() {
        return listaTipoInversion;
    }

    public void setListaTipoInversion(List<TipoInversionVO> listaTipoInversion) {
        this.listaTipoInversion = listaTipoInversion;
    }

    public InfraestructuraServiceImpl getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }

    public void setInfraestructuraServiceImpl(InfraestructuraServiceImpl infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public Integer getInfraestructuraId() {
        return infraestructuraId;
    }

    public void setInfraestructuraId(Integer infraestructuraId) {
        this.infraestructuraId = infraestructuraId;
    }

    public void cargarPeriodos() throws Exception {
        try {
            listaContratoCompromiso = contratoCompromisoServiceImpl.getCompromisosContrato(contratoVO.getConId());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


    public void cargarInversiones() throws Exception {
        try {

            listaInversiones =
                getContratoInversionServiceImpl().ListaPorAeropuerto(contratoVO.getConId(), contratoVO.getTinId(),
                                                                     contratoVO.getCsiId(), infraestructuraId);
            contratoRespSupVO.setInfId(infraestructuraId);
            if (listaInversiones == null || listaInversiones.size() == 0) {
                try {
                    listaContratoCompromiso = contratoCompromisoServiceImpl.query1(contratoVO.getConId());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public List<ContratoInversionVO> getListaInversiones() {
        return listaInversiones;
    }

    public void setListaInversiones(List<ContratoInversionVO> listaInversiones) {
        this.listaInversiones = listaInversiones;
    }

    public int getCodigoAeropuerto() {
        return codigoAeropuerto;
    }

    public void setCodigoAeropuerto(int codigoAeropuerto) {
        this.codigoAeropuerto = codigoAeropuerto;
    }

    public ContratoCompromisoServiceImpl getContratoCompromisoServiceImpl() {
        return contratoCompromisoServiceImpl;
    }

    public void setContratoCompromisoServiceImpl(ContratoCompromisoServiceImpl contratoCompromisoServiceImpl) {
        this.contratoCompromisoServiceImpl = contratoCompromisoServiceImpl;
    }

    public List<ContratoCompromisoVO> getListaContratoCompromiso() {
        return listaContratoCompromiso;
    }

    public void setListaContratoCompromiso(List<ContratoCompromisoVO> listaContratoCompromiso) {
        this.listaContratoCompromiso = listaContratoCompromiso;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public ContratoRespSupVO getContratoRespSupVO() {
        return contratoRespSupVO;
    }

    public void setContratoRespSupVO(ContratoRespSupVO contratoRespSupVO) {
        this.contratoRespSupVO = contratoRespSupVO;
    }


    public int getCodigoInversion() {
        return codigoInversion;
    }

    public void setCodigoInversion(int codigoInversion) {
        this.codigoInversion = codigoInversion;
    }

    public void cargarListaCompromisos() {
        try {
            listaContratoCompromiso = contratoCompromisoServiceImpl.query1(contratoVO.getConId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cargarDatosCompromiso() {

        try {
            limpiarFormulario();
            System.out.println("contratoCompromisoId" + contratoCompromisoId);
            contratoCompromisoVO = contratoCompromisoServiceImpl.get(contratoCompromisoId);
            monedaVO = monedaServiceImpl.get(contratoCompromisoVO.getMonId());
            contratoCompromisoVO.setMonNombre(monedaVO.getMonNombre());
            listarInversionesSupervisadas(contratoCompromisoVO.getCcoId());
            if (listaInvAvnVO.size() > 0) {
                deshabilitadoxDeclaracionNoCargada = false;
                
            }

        } catch (Exception e) {

            System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
            e.printStackTrace();
        }
    }


    public void limpiarCompromiso() {
        monedaVO = null;
        listaInvAvnVO = null;
        listaContratoCompromiso = null;
    }

    public void listarInversionesSupervisadas(int contratoCompromiso) {
        try {
            listaInvAvnVO = notificacionServiceImpl.ListarDeclaracionesSupervContratoCompromiso(contratoCompromiso);
            listaInvAvnEstadoVO = inversionAvanceEstadoServiceImpl.query();
            for (InvAvnVO invAvnVO : listaInvAvnVO) {
                for (InvAvnEstadoVO invAvnEstadoVO : listaInvAvnEstadoVO) {

                    if (invAvnEstadoVO.getIaeId() == invAvnVO.getIaeId()) {
                        invAvnVO.setIaeNombreEstado(invAvnEstadoVO.getIaeNombre());
                    }
                }
                for (MonedaVO moneda : listaTipoMonedas) {
                    if (moneda.getMonId() == invAvnVO.getMonId()) {
                        invAvnVO.setNombreMoneda(moneda.getMonNombre());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ContratoInversionServiceImpl getContratoInversionServiceImpl() {
        return contratoInversionServiceImpl;
    }

    public void setContratoInversionServiceImpl(ContratoInversionServiceImpl contratoInversionServiceImpl) {
        this.contratoInversionServiceImpl = contratoInversionServiceImpl;
    }

    public Integer getContratoCompromisoId() {
        return contratoCompromisoId;
    }

    public void setContratoCompromisoId(Integer contratoCompromisoId) {
        this.contratoCompromisoId = contratoCompromisoId;
    }

    public ContratoCompromisoVO getContratoCompromisoVO() {
        return contratoCompromisoVO;
    }

    public void setContratoCompromisoVO(ContratoCompromisoVO contratoCompromisoVO) {
        this.contratoCompromisoVO = contratoCompromisoVO;
    }

    public NotificacionServiceImpl getNotificacionServiceImpl() {
        return notificacionServiceImpl;
    }

    public void setNotificacionServiceImpl(NotificacionServiceImpl notificacionServiceImpl) {
        this.notificacionServiceImpl = notificacionServiceImpl;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }

    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }

    public List<InvAvnVO> getListaInvAvnVO() {
        return listaInvAvnVO;
    }

    public void setListaInvAvnVO(List<InvAvnVO> listaInvAvnVO) {
        this.listaInvAvnVO = listaInvAvnVO;
    }

    public InversionAvanceEstadoServiceImpl getInversionAvanceEstadoServiceImpl() {
        return inversionAvanceEstadoServiceImpl;
    }

    public void setInversionAvanceEstadoServiceImpl(InversionAvanceEstadoServiceImpl inversionAvanceEstadoServiceImpl) {
        this.inversionAvanceEstadoServiceImpl = inversionAvanceEstadoServiceImpl;
    }


    public void cargarDetalleInversion(SelectEvent event) {
        mostrarxDeclaracionCargada = true;
        invAvnVO = (InvAvnVO) event.getObject();
        try {
            System.out.println("INI cargarDetalleInversion");
            listaInvReconocimientoVO = new ArrayList<InvReconocimientoVO>();
            totalMontoAprobado = new BigDecimal(0);
            totalivrMontoAprobadoI = new BigDecimal(0);
            totalMontoPresentado = new BigDecimal(0);
            totalirjMontoReajusteI = new BigDecimal(0);
            totalMontoReajustado = new BigDecimal(0);
            listaInvReajusteVO = new ArrayList<InvReajusteVO>();
            InvReconocimientoVO invReconocimientoVO = new InvReconocimientoVO();
            InvReajusteVO invReajusteVO = new InvReajusteVO();
            listaInvAvanceDetalleVO =
                valorizacionInversionAvanceDetalleServiceImpl.getInvAvanceDetallesInvAvance(((InvAvnVO) event.getObject()).getTiaNumero());
            ListaInversionDescripcionVO = inversionDescripcionServicesImpl.queryAllIdtEstado();

            for (ValorizacionInversionAvanceDetalleVO invAvanceDetalleVO : listaInvAvanceDetalleVO) {
                invReconocimientoVO = new InvReconocimientoVO();
                invReajusteVO = new InvReajusteVO();
                invReconocimientoVO.setCsiId(invAvanceDetalleVO.getCsiId());
                invReconocimientoVO.setInfId(invAvanceDetalleVO.getInfId());
                invReconocimientoVO.setTinId(invAvanceDetalleVO.getTinId());
                invReconocimientoVO.setMonId(invAvanceDetalleVO.getMonId());
                invReconocimientoVO.setTiaNumero(invAvanceDetalleVO.getTiaNumero()); // inversion

                invReconocimientoVO.setIadId(invAvanceDetalleVO.getIad_Id());
                invReconocimientoVO.setIreEstado(1);

                invReconocimientoVO.setIvrMontoPresentado(invAvanceDetalleVO.getMontoPresentado());
                invReconocimientoVO.setIvrMontoAprobado(invAvanceDetalleVO.getMontoPresentado());
                invReajusteVO.setIrjMontoAprobado(invAvanceDetalleVO.getMontoPresentado());
                invReajusteVO.setIrjMontoReajuste(invAvanceDetalleVO.getMontoPresentado());
                /**Redondea**/
                invReconocimientoVO.setIvrMontoPresentado(Reutilizar.getNewInstance().redondearBigDecimal(invReconocimientoVO.getIvrMontoPresentado()));
                invReconocimientoVO.setIvrMontoAprobado(Reutilizar.getNewInstance().redondearBigDecimal(invReconocimientoVO.getIvrMontoAprobado()));
                invReajusteVO.setIrjMontoAprobado(Reutilizar.getNewInstance().redondearBigDecimal(invReajusteVO.getIrjMontoAprobado()));
                invReajusteVO.setIrjMontoReajuste(Reutilizar.getNewInstance().redondearBigDecimal(invReajusteVO.getIrjMontoReajuste()));
                /**Fin Redondea**/
                totalMontoPresentado = totalMontoPresentado.add(invReconocimientoVO.getIvrMontoPresentado());
                totalMontoAprobado = totalMontoAprobado.add(invReconocimientoVO.getIvrMontoAprobado());
                totalMontoReajustado = totalMontoReajustado.add(invReajusteVO.getIrjMontoReajuste());

                invReajusteVO.setCsiId(invAvanceDetalleVO.getCsiId());
                invReajusteVO.setInfId(invAvanceDetalleVO.getInfId());
                invReajusteVO.setTinId(invAvanceDetalleVO.getTinId());
                invReajusteVO.setMonId(invAvanceDetalleVO.getMonId());
                invReajusteVO.setIadId(invAvanceDetalleVO.getIad_Id());
                invReajusteVO.setTiaNumero(invAvanceDetalleVO.getTiaNumero()); // inversion
                invReconocimientoVO.setMonId(invAvnVO.getMonId());
                invReajusteVO.setMonId(invAvnVO.getMonId());
                invReconocimientoVO.setNombreMoneda(monedaDescripcionMemoria.get(""+invAvnVO.getMonId()).toString()); // infraestructura
                invReajusteVO.setNombreMoneda(monedaDescripcionMemoria.get(""+invAvnVO.getMonId()).toString());
                   
                for (InfraestructuraVO infraestructuraVO : listaInfraestructura) {
                    if (infraestructuraVO.getInfId() == invAvanceDetalleVO.getInfId()) {
                        invReconocimientoVO.setNombreInfraestructura(infraestructuraVO.getInfNombre());
                        invReajusteVO.setNombreInfraestructura(infraestructuraVO.getInfNombre());
                    }
                }

                for (InversionDescripcionVO inversionDescripcionVO : ListaInversionDescripcionVO) {
                    if (inversionDescripcionVO.getItdId() == invAvanceDetalleVO.getDtiId()) {
                        invReconocimientoVO.setDesConcepto(inversionDescripcionVO.getItdNombre());
                        invReajusteVO.setDesConcepto(inversionDescripcionVO.getItdNombre());
                    }
                }
                invReconocimientoVO.setNombreInversion(invAvanceDetalleVO.getNombreInversion());
                invReajusteVO.setNombreInversion(invAvanceDetalleVO.getNombreInversion());
                listaInvReconocimientoVO.add(invReconocimientoVO);
                listaInvReajusteVO.add(invReajusteVO);
            }
            totalivrMontoAprobadoI = totalivrMontoAprobadoI.add(totalMontoAprobado);
            totalirjMontoReajusteI = totalirjMontoReajusteI.add(totalMontoReajustado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        totalMontoPresentado = Reutilizar.getNewInstance().redondearBigDecimal(totalMontoPresentado);
        totalMontoAprobado = Reutilizar.getNewInstance().redondearBigDecimal(totalMontoAprobado);
        totalMontoReajustado = Reutilizar.getNewInstance().redondearBigDecimal(totalMontoReajustado);
        totalivrMontoAprobadoI = Reutilizar.getNewInstance().redondearBigDecimal(totalivrMontoAprobadoI);
        totalirjMontoReajusteI = Reutilizar.getNewInstance().redondearBigDecimal(totalirjMontoReajusteI);
    }

    public void resetIGV() {
        if (!renderMostrarIGV) {
            setTotalivrMontoAprobadoI(totalMontoAprobado);
            setTotalirjMontoReajusteI(totalMontoReajustado);
            setIgv(BigDecimal.ZERO);
        }
    }

    public void editarReconocimiento(ActionEvent event) {
        invReconocimientoVO = (InvReconocimientoVO) event.getComponent().getAttributes().get("reconocimiento");
    }

    public void editarReajuste(ActionEvent event) {
        invReajusteVO = (InvReajusteVO) event.getComponent().getAttributes().get("reajuste");
    }

    public void grabarReconocimiento(ActionEvent event) {
        InvReconocimientoVO reconocimientoSeleccionado =
            (InvReconocimientoVO) event.getComponent().getAttributes().get("reconocimiento");
        if (reconocimientoSeleccionado.getIvrMontoAprobado() == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "El Monto no Puede ser vacío"));
            RequestContext.getCurrentInstance().update("form:mensaje");
        } else if (reconocimientoSeleccionado.getIvrMontoPresentado().compareTo(reconocimientoSeleccionado.getIvrMontoAprobado()) < 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "El Monto Presentado no puede ser mayor al Monto Aprobado"));
            RequestContext.getCurrentInstance().update("form:mensaje");
        } else {
            totalMontoAprobado = BigDecimal.ZERO;
            totalMontoReajustado = BigDecimal.ZERO;
            totalivrMontoAprobadoI = BigDecimal.ZERO;
            totalirjMontoReajusteI = BigDecimal.ZERO;
            for (InvReconocimientoVO invReconocimientoVO : listaInvReconocimientoVO) {
                invReconocimientoVO.setIvrMontoAprobado(Reutilizar.getNewInstance().redondearBigDecimal(invReconocimientoVO.getIvrMontoAprobado()));
                if (invReconocimientoVO.getIvrMontoAprobado() != null) {
                    totalMontoAprobado = totalMontoAprobado.add(invReconocimientoVO.getIvrMontoAprobado());
                   
                }
               
            }
            for (InvReajusteVO invReajuste : listaInvReajusteVO) {                
                if (invReajuste.getIadId().equals(reconocimientoSeleccionado.getIadId())) {
                    invReajuste.setIrjMontoAprobado(Reutilizar.getNewInstance().redondearBigDecimal(reconocimientoSeleccionado.getIvrMontoAprobado()));
                    invReajuste.setIrjMontoReajuste(Reutilizar.getNewInstance().redondearBigDecimal(reconocimientoSeleccionado.getIvrMontoAprobado()));
                   
                }
                if (invReajuste.getIrjMontoReajuste() != null) {
                    totalMontoReajustado = totalMontoReajustado.add(invReajuste.getIrjMontoReajuste());
                   
                }
            }
            totalivrMontoAprobadoI = totalivrMontoAprobadoI.add(totalMontoAprobado);
            totalirjMontoReajusteI = totalirjMontoReajusteI.add(totalMontoReajustado);
            RequestContext.getCurrentInstance().update("form:tablaReconocimiento");
            RequestContext.getCurrentInstance().update("form:tablaReajuste");
            RequestContext.getCurrentInstance().update("form");
            RequestContext.getCurrentInstance().execute("_dlgEditarReconocimiento.hide();");
        }
    }

    public void grabarReajuste(ActionEvent event) {
        InvReajusteVO reajuste = (InvReajusteVO) event.getComponent().getAttributes().get("reajuste");
        if (reajuste.getIrjMontoReajuste() == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "El Monto no puede ser vacío"));
            RequestContext.getCurrentInstance().update("form:mensaje");
        } else if (reajuste != null && reajuste.getIrjMontoAprobado().compareTo(reajuste.getIrjMontoReajuste()) < 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "El monto Aprobado no puede ser mayor al Monto Reajustado"));
            RequestContext.getCurrentInstance().update("form:mensaje");
        } else {
            totalMontoReajustado = BigDecimal.ZERO;
            totalirjMontoReajusteI = BigDecimal.ZERO;
            for (InvReajusteVO invReajuste : listaInvReajusteVO) {
                if (invReajuste.getIadId().equals(reajuste.getIadId()))
                    invReajuste.setIrjMontoReajuste(Reutilizar.getNewInstance().redondearBigDecimal(reajuste.getIrjMontoReajuste()));
                if (invReajuste.getIrjMontoReajuste() != null)
                    totalMontoReajustado = totalMontoReajustado.add(invReajuste.getIrjMontoReajuste());
            }
            totalirjMontoReajusteI = totalirjMontoReajusteI.add(totalMontoReajustado);
            RequestContext.getCurrentInstance().update("form:tablaReajuste");
            RequestContext.getCurrentInstance().update("form");
            RequestContext.getCurrentInstance().execute("_dlgEditarReajuste.hide();");
        }
    }

    public void cargarReajuste(RowEditEvent event) {
        InvReconocimientoVO reconocimiento = null;
        InvReajusteVO reajuste = null;
        Object obj = event.getObject();
        if (obj instanceof InvReconocimientoVO) {
            reconocimiento = (InvReconocimientoVO) obj;
        } else if (obj instanceof InvReajusteVO) {
            reajuste = (InvReajusteVO) obj;
        }

        if (reconocimiento != null &&
            reconocimiento.getIvrMontoPresentado().compareTo(reconocimiento.getIvrMontoAprobado()) < 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "El monto Aprobado no puede ser mayor al Monto Presentado"));
        } else if (reajuste != null && reajuste.getIrjMontoAprobado().compareTo(reajuste.getIrjMontoReajuste()) < 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "El monto Reajuste no puede ser mayor al Monto Aprobado"));
        } else {
            totalMontoAprobado = BigDecimal.ZERO;
            totalivrMontoAprobadoI = BigDecimal.ZERO;
            totalMontoReajustado = BigDecimal.ZERO;
            totalirjMontoReajusteI = BigDecimal.ZERO;


            for (InvReconocimientoVO invReconocimientoVO : listaInvReconocimientoVO) {
                if (invReconocimientoVO.getIvrMontoAprobado() != null) {
                    totalMontoAprobado = totalMontoAprobado.add(invReconocimientoVO.getIvrMontoAprobado());
                    System.out.println("InvReconocimientoVOtotalMontoAprobado:" + totalMontoAprobado);
                }
                for (InvReajusteVO invReajusteVO : listaInvReajusteVO) {

                    if (invReconocimientoVO.getIadId() == invReajusteVO.getIadId()) {
                        invReajusteVO.setIrjMontoAprobado(invReconocimientoVO.getIvrMontoAprobado());
                        if (invReajusteVO.getIrjMontoReajuste() != null) {
                            totalMontoReajustado = totalMontoReajustado.add(invReajusteVO.getIrjMontoReajuste());
                        }
                    }
                }

            }
            totalivrMontoAprobadoI = totalMontoAprobado.add(igv.multiply(totalMontoAprobado));
            totalirjMontoReajusteI = totalMontoReajustado.add(igv.multiply(totalMontoReajustado));
        }
        totalivrMontoAprobadoI = Reutilizar.getNewInstance().redondearBigDecimal(totalivrMontoAprobadoI);
        totalirjMontoReajusteI = Reutilizar.getNewInstance().redondearBigDecimal(totalirjMontoReajusteI);
        totalMontoReajustado = Reutilizar.getNewInstance().redondearBigDecimal(totalMontoReajustado);
        totalMontoAprobado = Reutilizar.getNewInstance().redondearBigDecimal(totalMontoAprobado);
    }

    public Integer getReconoEstado() {
        return reconoEstado;
    }

    public void setReconoEstado(Integer reconoEstado) {
        this.reconoEstado = reconoEstado;
    }

    public InvVO getInvVO() {
        return invVO;
    }

    public void setInvVO(InvVO invVO) {
        this.invVO = invVO;
    }

    public String getReconoObs() {
        return reconoObs;
    }

    public void setReconoObs(String reconoObs) {
        this.reconoObs = reconoObs;
    }

    public List<InvReconocimientoVO> getListaInvReconocimientoVO() {
        return listaInvReconocimientoVO;
    }

    public void setListaInvReconocimientoVO(List<InvReconocimientoVO> listaInvReconocimientoVO) {
        this.listaInvReconocimientoVO = listaInvReconocimientoVO;
    }

    public List<InvReajusteVO> getListaInvReajusteVO() {
        return listaInvReajusteVO;
    }

    public void setListaInvReajusteVO(List<InvReajusteVO> listaInvReajusteVO) {
        this.listaInvReajusteVO = listaInvReajusteVO;
    }

    public InvReconocimientoServiceImpl getInvReconocimientoServiceImpl() {
        return invReconocimientoServiceImpl;
    }

    public void setInvReconocimientoServiceImpl(InvReconocimientoServiceImpl invReconocimientoServiceImpl) {
        this.invReconocimientoServiceImpl = invReconocimientoServiceImpl;
    }

    public InvReajusteServiceImpl getInvReajusteServiceImpl() {
        return invReajusteServiceImpl;
    }

    public void setInvReajusteServiceImpl(InvReajusteServiceImpl invReajusteServiceImpl) {
        this.invReajusteServiceImpl = invReajusteServiceImpl;
    }

    public ValorizacionInversionAvanceDetalleServiceImpl getValorizacionInversionAvanceDetalleServiceImpl() {
        return valorizacionInversionAvanceDetalleServiceImpl;
    }

    public void setValorizacionInversionAvanceDetalleServiceImpl(ValorizacionInversionAvanceDetalleServiceImpl valorizacionInversionAvanceDetalleServiceImpl) {
        this.valorizacionInversionAvanceDetalleServiceImpl = valorizacionInversionAvanceDetalleServiceImpl;
    }

    public List<ValorizacionInversionAvanceDetalleVO> getListaInvAvanceDetalleVO() {
        return listaInvAvanceDetalleVO;
    }

    public void setListaInvAvanceDetalleVO(List<ValorizacionInversionAvanceDetalleVO> listaInvAvanceDetalleVO) {
        this.listaInvAvanceDetalleVO = listaInvAvanceDetalleVO;
    }

    public ValorizacionInversionAvanceDetalleVO getValorizacionInversionAvanceDetalleVO() {
        return valorizacionInversionAvanceDetalleVO;
    }

    public void setValorizacionInversionAvanceDetalleVO(ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO) {
        this.valorizacionInversionAvanceDetalleVO = valorizacionInversionAvanceDetalleVO;
    }

    public InversionDescripcionServicesImpl getInversionDescripcionServicesImpl() {
        return inversionDescripcionServicesImpl;
    }

    public void setInversionDescripcionServicesImpl(InversionDescripcionServicesImpl inversionDescripcionServicesImpl) {
        this.inversionDescripcionServicesImpl = inversionDescripcionServicesImpl;
    }

    public InversionDescripcionVO getInversionDescripcionVO() {
        return inversionDescripcionVO;
    }

    public void setInversionDescripcionVO(InversionDescripcionVO inversionDescripcionVO) {
        this.inversionDescripcionVO = inversionDescripcionVO;
    }

    public List<InversionDescripcionVO> getListaInversionDescripcionVO() {
        return ListaInversionDescripcionVO;
    }

    public void setListaInversionDescripcionVO(List<InversionDescripcionVO> ListaInversionDescripcionVO) {
        this.ListaInversionDescripcionVO = ListaInversionDescripcionVO;
    }

    public void limpiarDatos() {
        System.out.println("llega a limpiar");
    }

    public BigDecimal getTotalMontoPresentado() {
        return totalMontoPresentado;
    }

    public void setTotalMontoPresentado(BigDecimal totalMontoPresentado) {
        this.totalMontoPresentado = totalMontoPresentado;
    }

    public BigDecimal getTotalMontoAprobado() {
        return totalMontoAprobado;
    }

    public void setTotalMontoAprobado(BigDecimal totalMontoAprobado) {
        this.totalMontoAprobado = totalMontoAprobado;
    }

    public BigDecimal getTotalMontoReajustado() {
        return totalMontoReajustado;
    }

    public void prepararMontosObservados() {
        if (invVO.getInvEstadoReconocimiento() == 2) {
            resetCamposIGV();
            setTotalivrMontoAprobadoI(BigDecimal.ZERO);
            setTotalirjMontoReajusteI(BigDecimal.ZERO);
            invAvnVO.setTiaMontoTotalAprobado(BigDecimal.ZERO);
            invAvnVO.setTiaMontoTotalReajustado(BigDecimal.ZERO);
            invVO.setInvIgv(0);
        } else {

            invAvnVO.setTiaMontoTotalAprobado(totalMontoAprobado);
            invAvnVO.setTiaMontoTotalReajustado(totalMontoReajustado);
            setTotalivrMontoAprobadoI(totalMontoAprobado);
            setTotalirjMontoReajusteI(totalMontoReajustado);
        }
    }

    public void guardarDeclaracion() {
        System.out.println("totalivrMontoAprobadoI"+totalivrMontoAprobadoI);
        System.out.println("totalirjMontoReajusteI"+totalirjMontoReajusteI);
        if (invVO.getInvEstadoReconocimiento() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha seleccionado el Estado de Reconocimiento"));
        } else if (invAvnVO.getTiaObservaciones() == null || invAvnVO.getTiaObservaciones().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha ingresado las Observaciones"));
        } else if (invVO.getInvNumeroInforme() == null || invVO.getInvNumeroInforme().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha ingresado el Numero de Informe"));
        } else if (invVO.getInvFechaEmisionInforme() == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha ingresado la Fecha de Emisión del Informe"));
        } else if (invVO.getInvRegSalidaInforme() == null || invVO.getInvRegSalidaInforme().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha ingresado el Registro de Salida del Informe"));
        } else if (invVO.getInvNumeroOficio() == null || invVO.getInvNumeroOficio().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha ingresado el Número de Oficio"));
        } else if (invVO.getInvFechaEmisionOficio() == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha ingresado la Fecha del Oficio"));
        } else if (invVO.getInvRegSalidaOficio() == null || invVO.getInvRegSalidaOficio().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha ingresado el Registro de Salida Oficio"));
        } else if (invAvnVO.getMonId() == 1 && invVO.getInvNotaTipoCambio().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha Ingresado la Nota para el Tipo de Cambio"));
        } else if (invAvnVO.getMonId() == 1 && (invVO.getInvMontoTipoCambio()==null || invVO.getInvMontoTipoCambio().compareTo(BigDecimal.ZERO)==0)) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha ingresado el Monto Tipo de Cambio"));
        } else if (invVO.getInvNota() == null || invVO.getInvNota().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No ha ingresado la Nota"));
        }else {
            try {
                if (renderMostrarIGV) {
                    invVO.setInvIgv(1);
                } else {
                    invVO.setInvIgv(0);
                }
                invVO.setTiaNumero(invAvnVO.getTiaNumero());
                invVO.setInvEstado(1);
                invVO.setInvMontoTotalAprobado(totalivrMontoAprobadoI);
                invVO.setInvMontoTotalReajuste(totalirjMontoReajusteI);
                if (invVO.getInvEstadoReconocimiento() == 1) {
                    invAvnVO.setIaeId(Constantes.ESTADORECONOCIMIENTO_DECLARADO);

                }
                if (invVO.getInvEstadoReconocimiento() == 2) {
                    invAvnVO.setIaeId(Constantes.ESTADORECONOCIMIENTO_OBSERVADO);
                }
               
                invVO.setMonId(invAvnVO.getMonId());
                invVO.setInvEstadoReconocimiento(invAvnVO.getIaeId());
                invVO.setInvMontoTotalAprobado(totalivrMontoAprobadoI);
                invVO.setInvMontoTotalReajuste(totalirjMontoReajusteI);
                invAvnVO.setTiaMontoTotalAprobado(totalivrMontoAprobadoI);
                invAvnVO.setTiaMontoTotalReajustado(totalirjMontoReajusteI);
                invServiceImpl.insertDeclaracion(invAvnVO, invVO, listaInvReconocimientoVO, listaInvReajusteVO);

                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito",
                                                                              "Se Declaró la Inversión"));
                listarInversionesSupervisadas(contratoCompromisoVO.getCcoId());
                limpiarFormulario();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void limpiarFormulario() {
        invAvnVO = new InvAvnVO();
        invVO = new InvVO();
        listaInvReajusteVO = new ArrayList<InvReajusteVO>();
        listaInvReconocimientoVO = new ArrayList<InvReconocimientoVO>();
        totalMontoAprobado = new BigDecimal(0);
        totalivrMontoAprobadoI = new BigDecimal(0);
        totalMontoPresentado = new BigDecimal(0);
        totalMontoReajustado = new BigDecimal(0);
        totalirjMontoReajusteI = new BigDecimal(0);
            listaInvAvnVO=new ArrayList<InvAvnVO>();
            deshabilitadoxDeclaracionNoCargada = true;
        resetCamposIGV();

    }
    public void limpiarTodo() {
        invAvnVO = new InvAvnVO();
        invVO = new InvVO();
        listaInvReajusteVO = new ArrayList<InvReajusteVO>();
        listaInvReconocimientoVO = new ArrayList<InvReconocimientoVO>();
        totalMontoAprobado = new BigDecimal(0);
        totalivrMontoAprobadoI = new BigDecimal(0);
        totalMontoPresentado = new BigDecimal(0);
        totalMontoReajustado = new BigDecimal(0);
        totalirjMontoReajusteI = new BigDecimal(0);
            listaInvAvnVO=new ArrayList<InvAvnVO>();
            deshabilitadoxDeclaracionNoCargada = true;
        contratoCompromisoId=0;
        contratoCompromisoVO=new ContratoCompromisoVO();
        contratoVO=new ContratoVO();
        resetCamposIGV();
        mostrarxDeclaracionCargada = false;
    }
    public void setTotalMontoReajustado(BigDecimal totalMontoReajustado) {
        this.totalMontoReajustado = totalMontoReajustado;
    }

    public InvServiceImpl getInvServiceImpl() {
        return invServiceImpl;
    }

    public void setInvServiceImpl(InvServiceImpl invServiceImpl) {
        this.invServiceImpl = invServiceImpl;
    }

    public int getCantFilas() {
        return cantFilas;
    }

    public void setCantFilas(int cantFilas) {
        this.cantFilas = cantFilas;
    }

    public boolean isRenderMostrarIGV() {
        return renderMostrarIGV;
    }

    public void setRenderMostrarIGV(boolean renderMostrarIGV) {
        this.renderMostrarIGV = renderMostrarIGV;
    }

    public void resetCamposIGV() {
        renderMostrarIGV = false;
        setIgv(BigDecimal.ZERO);

    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public boolean isDeshabilitadoxObservado() {
        return deshabilitadoxObservado;
    }

    public void setDeshabilitadoxObservado(boolean deshabilitadoxObservado) {
        this.deshabilitadoxObservado = deshabilitadoxObservado;
    }


    public BigDecimal getTotalivrMontoAprobadoI() {
        return totalivrMontoAprobadoI;
    }

    public void setTotalivrMontoAprobadoI(BigDecimal totalivrMontoAprobadoI) {
        this.totalivrMontoAprobadoI = totalivrMontoAprobadoI;
    }

    public BigDecimal getTotalirjMontoReajusteI() {
        return totalirjMontoReajusteI;
    }

    public void setTotalirjMontoReajusteI(BigDecimal totalirjMontoReajusteI) {
        this.totalirjMontoReajusteI = totalirjMontoReajusteI;
    }

    public BigDecimal getTotalirjMontoAprobado() {
        return totalirjMontoAprobado;
    }

    public void setTotalirjMontoAprobado(BigDecimal totalirjMontoAprobado) {
        this.totalirjMontoAprobado = totalirjMontoAprobado;
    }

    public BigDecimal getTotalirjMontoReajuste() {
        return totalirjMontoReajuste;
    }

    public void setTotalirjMontoReajuste(BigDecimal totalirjMontoReajuste) {
        this.totalirjMontoReajuste = totalirjMontoReajuste;
    }

    public void calularMontosconIGV() {
        totalivrMontoAprobadoI = totalMontoAprobado;
        totalirjMontoReajusteI = totalMontoReajustado;
        totalivrMontoAprobadoI = totalivrMontoAprobadoI.add(igv.multiply(totalivrMontoAprobadoI));
        totalirjMontoReajusteI = totalirjMontoReajusteI.add(igv.multiply(totalirjMontoReajusteI));

        totalivrMontoAprobadoI = Reutilizar.getNewInstance().redondearBigDecimal(totalivrMontoAprobadoI);
        totalirjMontoReajusteI = Reutilizar.getNewInstance().redondearBigDecimal(totalirjMontoReajusteI);
    }

    public void setInvReconocimientoVO(InvReconocimientoVO invReconocimientoVO) {
        this.invReconocimientoVO = invReconocimientoVO;
    }

    public InvReconocimientoVO getInvReconocimientoVO() {
        return invReconocimientoVO;
    }

    public void setInvReajusteVO(InvReajusteVO invReajusteVO) {
        this.invReajusteVO = invReajusteVO;
    }

    public InvReajusteVO getInvReajusteVO() {
        return invReajusteVO;
    }

    public void setInvAvnVO(InvAvnVO invAvnVO) {
        this.invAvnVO = invAvnVO;
    }

    public InvAvnVO getInvAvnVO() {
        return invAvnVO;
    }

    public void setMostrarxDeclaracionCargada(boolean mostrarxDeclaracionCargada) {
        this.mostrarxDeclaracionCargada = mostrarxDeclaracionCargada;
    }

    public boolean isMostrarxDeclaracionCargada() {
        return mostrarxDeclaracionCargada;
    }

    public void setDeshabilitadoxDeclaracionNoCargada(boolean deshabilitadoxDeclaracionNoCargada) {
        this.deshabilitadoxDeclaracionNoCargada = deshabilitadoxDeclaracionNoCargada;
    }

    public boolean isDeshabilitadoxDeclaracionNoCargada() {
        return deshabilitadoxDeclaracionNoCargada;
    }

    public void setFechaactual(Date fechaactual) {
        this.fechaactual = fechaactual;
    }

    public Date getFechaactual() {
        fechaactual=new Date();
        return fechaactual;
    }
}
