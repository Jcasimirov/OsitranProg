package com.ositran.valorizaciones;

import com.ositran.service.ConcesionarioService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.InvReajusteService;
import com.ositran.service.InvReconocimientoService;
import com.ositran.service.InvService;
import com.ositran.service.InversionAvanceEstadoService;
import com.ositran.service.InversionDescripcionServices;
import com.ositran.service.MonedaService;
import com.ositran.service.NotificacionService;
import com.ositran.service.PeriodoService;
import com.ositran.service.TipoInversionServices;
import com.ositran.service.ValorizacionInversionAvanceDetalleService;
import com.ositran.service.ValorizacionInversionAvanceService;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoInversionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.util.Constantes;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoInversionVO;
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
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

@ManagedBean(name = "rectificarInversion")
@ViewScoped
public class RectificarInversion {

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionServiceImpl concesionServiceImpl;

    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionServiceImpl modalidadServiceImp;

    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionServiceImpl contratoConcesionServiceImp;

    @ManagedProperty(value = "#{concesionarioServiceImpl}")
    ConcesionarioService concesionarioServiceImpl;
    @ManagedProperty(value = "#{tipoInversionServicesImpl}")
    TipoInversionServices tipoInversionServicesImpl;


    @ManagedProperty(value = "#{monedaServiceImpl}")
    MonedaService monedaServiceImpl;
    @ManagedProperty(value = "#{periodoServiceImpl}")
    PeriodoService periodoServiceImpl;
    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    private InfraestructuraServiceImpl infraestructuraServiceImpl;


    @ManagedProperty(value = "#{contratoInversionServiceImpl}")
    private ContratoInversionServiceImpl contratoInversionServiceImpl;
    
    @ManagedProperty(value = "#{contratoVO}")
    private ContratoVO contratoVO;
    @ManagedProperty(value = "#{concesionarioVO}")
    private ConcesionarioVO concesionarioVO;
    @ManagedProperty(value = "#{monedaVO}")
    private MonedaVO monedaVO;

    @ManagedProperty(value = "#{tipoInversionVO}")
    private TipoInversionVO tipoInversionVO;
    @ManagedProperty(value = "#{periodoVO}")
    private PeriodoVO periodoVO;
    @ManagedProperty(value = "#{contratoInversionVO}")
    private ContratoInversionVO contratoInversionVO;
    List<ContratoInversionVO> listContratoInversion;
    HashMap<String,Object> nombreinversion=new HashMap<String,Object>();
    @ManagedProperty(value = "#{invAvnVO}")
    private InvAvnVO invAvnVO;
    @ManagedProperty(value = "#{invVO}")
    private InvVO invVO;
    @ManagedProperty(value = "#{notificacionServiceImpl}")
    private NotificacionService notificacionServiceImpl;
    @ManagedProperty(value = "#{inversionAvanceEstadoServiceImpl}")
    private InversionAvanceEstadoService inversionAvanceEstadoServiceImpl;
    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
    ContratoCompromisoService contratoCompromisoServiceImpl;

    @ManagedProperty(value = "#{invReconocimientoServiceImpl}")
    InvReconocimientoService invReconocimientoServiceImpl;


    @ManagedProperty(value = "#{invReajusteServiceImpl}")
    InvReajusteService invReajusteServiceImpl;

    @ManagedProperty(value = "#{inversionDescripcionServicesImpl}")
    InversionDescripcionServices inversionDescripcionServicesImpl;
    
    @ManagedProperty(value = "#{valorizacionInversionAvanceDetalleServiceImpl}")
    ValorizacionInversionAvanceDetalleService valorizacionInversionAvanceDetalleServiceImpl;
    
    @ManagedProperty(value = "#{invServiceImpl}")
    InvService invServiceImpl;
    @ManagedProperty(value = "#{valorizacionInversionAvanceServiceImpl}")
    ValorizacionInversionAvanceService valorizacionInversionAvanceServiceImpl;
    
    // Lista Bean VO
    private List<InversionDescripcionVO> listaConceptos = new ArrayList<InversionDescripcionVO>();
    private List<ValorizacionInversionAvanceDetalleVO> listaValorizacionInversionAvanceDetalleVO =
        new ArrayList<ValorizacionInversionAvanceDetalleVO>();
    private List<InvReconocimientoVO> listaReconocimiento = new ArrayList<InvReconocimientoVO>();
    private List<InvReajusteVO> listaReajuste = new ArrayList<InvReajusteVO>();
    private List<InvAvnVO> listaValorizaciones = new ArrayList<InvAvnVO>();
    private List<InvAvnEstadoVO> listarEstadosIA = new ArrayList<InvAvnEstadoVO>();
    List<InfraestructuraTipoVO> listaTipoInfraestructura = new ArrayList<InfraestructuraTipoVO>();
    List<InfraestructuraVO> listaInfraestructura = new ArrayList<InfraestructuraVO>();

    List<ConcesionVO> listaConcesiones = new ArrayList<ConcesionVO>();

    List<ModalidadConcesionVO> listaModalidad = new ArrayList<ModalidadConcesionVO>();

    List<ContratoVO> listaContrato = new ArrayList<ContratoVO>();

    List<MonedaVO> listarTipoMonedas = new ArrayList<MonedaVO>();

    List<PeriodoVO> listarPeriodos = new ArrayList<PeriodoVO>();

    List<TipoInversionVO> listaTipoInversion = new ArrayList<TipoInversionVO>();
    private List<InfraestructuraVO> listarInfraestructura = new ArrayList<InfraestructuraVO>();

    private Integer contratoId;

    private DefaultStreamedContent downloadContratoPDF;
    private DefaultStreamedContent downloadFichaResumen;


    public final int formulario = 36;
    private RolOpcionesVO rolOpcion;
    private boolean renderAeropuertos;
    private Date fechaInicioSuscripcion;
    private Date fechaFinSuscripcion;
    private String nombreConcesion;


    private UsuarioVO usuario;
    private int tipoInfraestructura;

    private BigDecimal totalivrMontoPresentado = BigDecimal.ZERO;
    private BigDecimal totalivrMontoAprobado = BigDecimal.ZERO;
    private BigDecimal totalirjMontoAprobado = BigDecimal.ZERO;
    private BigDecimal totalirjMontoReajuste = BigDecimal.ZERO;


    private InvReconocimientoVO invReconocimientoVO;
    private InvReajusteVO invReajusteVO;
    private boolean renderMostrarIGV = false;
    private BigDecimal igv = BigDecimal.ZERO;


    private int estadoReconocimiento;
    private boolean deshabilitadoxObservado;
    private boolean deshabilitadoxDeclaracionNoCargada=true;
    private boolean mostrarxDeclaracionCargada=false;
    private boolean readOnlyMontoTipoCambio=false;

    public void validarSesion() throws IOException {
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
       
        usuario=Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        tipoInfraestructura= Reutilizar.getNewInstance().obtenerDatosEmpleadoLogueado().getTinId();
        System.out.println("tipoInfraestructura:"+tipoInfraestructura);
    }

    public RectificarInversion() {
        super();

    }
    /*EN LA TABLA T_INV EL CAMPO INV_ID ES UN SECUENCIAL Y NO ES FK DE T_INV_AVN*/
    public void cargarInversionesInvxTiaNumero(int tianumero){
        try {
            invVO=invServiceImpl.obtenerInversion(tianumero);
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }
    public void listarTiposMoneda() {
        try {
            List<MonedaVO> lista = new ArrayList<MonedaVO>();
            listarTipoMonedas = monedaServiceImpl.query();
            for (MonedaVO moneda : listarTipoMonedas) {
                if (moneda.getMonId() != 0)
                    lista.add(moneda);
            }
            listarTipoMonedas = lista;
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    public void listarEstadosDelaInversion() {
        try {
            listarEstadosIA = inversionAvanceEstadoServiceImpl.query();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void listaPeriodos() {
        try {
            listarPeriodos = periodoServiceImpl.query();
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }
    // Metodo Para Listar Tipo de Infraestructuras

    public void listarTiposdeInfraestructura() throws SQLException {
        try {
            listaTipoInfraestructura = getInfraestructuraTipoServiceImpl().query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    // Metodo para Filtrar  el combo la Concesión de buscar contrato
    public void filtrarConcesion() {
        try {
            listaConcesiones = concesionServiceImpl.filtrarConcesion(tipoInfraestructura);
            System.out.println("listaConcesiones:" + listaConcesiones.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Metodo para Listar Modalidad de Concesión
    public void ListarModalidad() throws SQLException {
        try {
            listaModalidad = this.modalidadServiceImp.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    public void listarInfraEstructuras() throws SQLException {
        try {
            listarInfraestructura = infraestructuraServiceImpl.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
    public void obtenerDeatalleInversionAvanceInvAvn(int tiaNumero){
        try {
            listaValorizacionInversionAvanceDetalleVO = valorizacionInversionAvanceDetalleServiceImpl.getInvAvanceDetallesInvAvance(tiaNumero);
            for (ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO : listaValorizacionInversionAvanceDetalleVO) {
                System.out.println("cargando detalle inversion===="+valorizacionInversionAvanceDetalleVO.getInvId());
           }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
    public void resetearCamposBuscarContratos() {
        tipoinfra = 0;
        concesion = 0;
        fechaInicioSuscripcion = null;
        fechaFinSuscripcion = null;
    }

    public void cargarDescripcionesMoneda(List<InvAvnVO> listaDeclaraciones) {
        for (InvAvnVO invAvn : listaDeclaraciones) {
            System.out.println("################invAvn.getMonId():"+invAvn.getMonId());
            for (MonedaVO moneda : listarTipoMonedas) {
                if (invAvn.getMonId() == moneda.getMonId()){
                    invAvn.setNombreMoneda(moneda.getMonNombre());
                    System.out.println("################invAvn.getMonId():"+invAvn.getMonId());
                }
                   
            }
        }
    }

    public void cargarEstadosdelAvanceInversion(List<InvAvnVO> listaDeclaraciones) {
        for (InvAvnVO invAvn : listaDeclaraciones) {
            for (InvAvnEstadoVO estadosIA : listarEstadosIA) {
                if (invAvn.getIaeId() == estadosIA.getIaeId())
                    invAvn.setIaeNombreEstado(estadosIA.getIaeNombre());
            }
        }
    }

    // Metodo para Buscar Contrato de Concesion y llenar los demas tabs
    public void abrirBuscarContratos() {
        if (nombreConcesion.length() != 0) {
            resetearCamposBuscarContratos();
            buscarContratos();
        }
    }

    public void cargarConceptos() {
        try {
            listaConceptos = inversionDescripcionServicesImpl.query();
        } catch (Exception sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }
    // Metodo Para Listar Infraestructuras

    public void cargarInfraestructurasContrato(Integer contratoId) {
        try {
            listaInfraestructura = infraestructuraServiceImpl.getInfraestructurasContrato(contratoId);
            System.out.println("listaInfraestructura#########:"+listaInfraestructura.size());
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }


    public void buscarContratos() {
 
        try {
            listaContrato =
                contratoConcesionServiceImp.buscarxNombreConcesion(nombreConcesion.toUpperCase().trim(), tipoInfraestructura,
                                                                   concesion, fechaInicioSuscripcion,
                                                                   fechaFinSuscripcion);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }


    }

    public void seleccionarContrato(ActionEvent e) {
        contratoVO = (ContratoVO) e.getComponent().getAttributes().get("idcontrato");
        cargarInfraestructurasContrato(contratoVO.getConId());
        resetDialogoBuscarContrato();
        listarDeclaraciones(contratoVO.getConId());
        cargarListaInversiones(contratoVO.getConId());
    }


    public void listarDeclaraciones(int codigoContrato) {
        try {
            System.out.println("codigoContrato:"+codigoContrato);
            listaValorizaciones = notificacionServiceImpl.obtenerDeclaracionesxIdContrato(codigoContrato);
            cargarDescripcionesMoneda(listaValorizaciones);
            cargarEstadosdelAvanceInversion(listaValorizaciones);
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public void seleccionarDeclaracion(ActionEvent e) throws SQLException {
        invAvnVO = (InvAvnVO) e.getComponent().getAttributes().get("idDeclaracion");
        invAvnVO.setNombreConcesion(contratoVO.getNombreConcesion());
        invAvnVO.setNombreTipoInfraestructura(contratoVO.getNombreTipoInfraestructura());
        invAvnVO.setNombreModalidad(contratoVO.getNombreModalidad());
        cargarInversionesInvxTiaNumero(invAvnVO.getTiaNumero());
        obtenerDeatalleInversionAvanceInvAvn(invAvnVO.getTiaNumero());
        cargarDatosCompromiso(invAvnVO.getCcoId());
        cargarReconocimiento(invAvnVO.getTiaNumero());
        cargarReajuste(invAvnVO.getTiaNumero());
        deshabilitadoxDeclaracionNoCargada=false;
        mostrarxDeclaracionCargada=true;
        resetCamposIGV();
    }
    public void resetCamposIGV(){
        renderMostrarIGV=invVO.getInvIgv()==1?true:false;;
        igv=BigDecimal.ZERO;
        
    }
    public void resetTipoCambio(){
        if(invVO.getMonId()==Constantes.SOLES){
        invVO.setInvMontoTipoCambio(BigDecimal.ZERO);
        readOnlyMontoTipoCambio=true;
        }else{
            readOnlyMontoTipoCambio=false;
        }
    }
    public void guardarRectificarReconocimiento(){
        try {     
         if (invAvnVO.getIaeId() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha seleccionado el Estado de Reconocimiento"));
        } else if (invAvnVO.getTiaObservaciones()==null || invAvnVO.getTiaObservaciones().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado las Observaciones"));
        } else if (invVO.getInvNumeroInforme()==null || invVO.getInvNumeroInforme().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Numero de Informe"));
        } else if (invVO.getInvFechaEmisionInforme()==null || invVO.getInvFechaEmisionInforme().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Fecha de Emisión del Informe"));
        } else if (invVO.getInvRegSalidaInforme()==null || invVO.getInvRegSalidaInforme().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Registro de Salida del Informe"));
        } else if (invVO.getInvNumeroOficio()==null || invVO.getInvNumeroOficio().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Numero de Oficio"));
        } else if (invVO.getInvFechaEmisionOficio()==null || invVO.getInvFechaEmisionOficio().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Fecha del Oficio"));
        } else if (invVO.getInvRegSalidaOficio()==null || invVO.getInvRegSalidaOficio().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Inversión"));
        } else if (invVO.getMonId()==null || invVO.getMonId() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ha seleccionado el Tipo de Cambio"));
        } else if (invVO.getInvMontoTipoCambio()==null || invVO.getInvMontoTipoCambio().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Monto"));
        } else if (invVO.getInvNota()==null || invVO.getInvNota().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Nota"));
        }else{

                invVO.setInvEstadoReconocimiento(invAvnVO.getIaeId()==Constantes.ESTADORECONOCIMIENTO_DECLARADO?Constantes.ESTADORECONOCIMIENTO_RECTIFICADO:Constantes.ESTADORECONOCIMIENTO_OBSERVADO);
                invAvnVO.setIaeId(invVO.getInvEstadoReconocimiento());
                notificacionServiceImpl.updateRectificacion(invAvnVO,listaReconocimiento,listaReajuste,invVO);
                listarDeclaraciones(contratoVO.getConId());
                reseteaCampos();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                              Constantes.GRABARMENSAJESATISFACTORIO));  
            }
            
           
        } catch (Exception sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORGUARDAR));
        }
    }
    public void reseteaCampos(){
        invVO=new InvVO();
        invAvnVO=new InvAvnVO(); 
        listaReconocimiento=new ArrayList<InvReconocimientoVO>();
        listaReajuste=new ArrayList<InvReajusteVO>();
        totalirjMontoAprobado=BigDecimal.ZERO;
        totalirjMontoReajuste=BigDecimal.ZERO;
        totalivrMontoAprobado=BigDecimal.ZERO;
        totalivrMontoPresentado=BigDecimal.ZERO;
        renderMostrarIGV=false;
        estadoReconocimiento=0;
        if(listaValorizaciones.size()==0)
            deshabilitadoxDeclaracionNoCargada=true;
    }
    public void cargarDatosCompromiso(int ccoId) {
        try {
            ContratoCompromisoVO contratoCompromisoVO = contratoCompromisoServiceImpl.get(ccoId);
            invAvnVO.setPlazo(contratoCompromisoVO.getCcoPlazo());
            invAvnVO.setTotal(contratoCompromisoVO.getCcoTotal());
            for (MonedaVO moneda : listarTipoMonedas) {
                if (contratoCompromisoVO.getMonId() == moneda.getMonId()) {
                    invAvnVO.setMonId(moneda.getMonId());
                    invAvnVO.setNombreMoneda(moneda.getMonNombre());
                    break;
                }
            }
            invAvnVO.setPeriodo(contratoCompromisoVO.getCcoPeriodo());
        } catch (Exception e) {
            System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
        }

    }
 

    public void resetDialogoBuscarContrato() {
        tipoinfra = 0;
        concesion = 0;
        modalidad = 0;
        listaContrato = null;
        listaContrato = new ArrayList<>();
    }

    public void subirContratoPDF(FileUploadEvent event) throws IOException {
        contratoVO.setConPdfcontrato(event.getFile().getFileName());
        contratoVO.setInputStreamContratoPDF(event.getFile().getInputstream());

    }

    public void subirFichaResumen(FileUploadEvent event) throws IOException {
        contratoVO.setConFicharesumen(event.getFile().getFileName());
        contratoVO.setInputStreamFichaResumen(event.getFile().getInputstream());
    }

    public void preDownloadContratoPDF(String nombreArchivo) {
        try {
            downloadContratoPDF = Reutilizar.getNewInstance().preDownload(Constantes.RUTACONTRATOSPDF + nombreArchivo);
        } catch (FileNotFoundException fnfe) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                          Constantes.ARCHIVONOENCONTRADO));
        }
    }

    public void preDownloadFichaResumen(String nombreArchivo) {
        try {
            downloadFichaResumen =
                Reutilizar.getNewInstance().preDownload(Constantes.RUTAFICHASRESUMEN + nombreArchivo);
        } catch (FileNotFoundException fnfe) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                          Constantes.ARCHIVONOENCONTRADO));
        }
    }

    public void cargarReconocimiento(int tiaNumero) {
        try {
            listaReconocimiento = invReconocimientoServiceImpl.getInvReconocimientosAvance(tiaNumero);
            System.out.println("listaReconocimiento.size():"+listaReconocimiento.size());
            calcularTotalesReconocimiento(listaReconocimiento);
            cargarDescripcionesInfraestructura(listaReconocimiento);
            cargarDescripcionesMonedas(listaReconocimiento);
            cargarDescripcionesConcepto(listaReconocimiento);
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }

    public void calcularTotalesReconocimiento(List<InvReconocimientoVO> listaReconocimiento) {
        setTotalivrMontoAprobado(BigDecimal.ZERO);
        setTotalivrMontoPresentado(BigDecimal.ZERO);
        for (InvReconocimientoVO invReconocimiento : listaReconocimiento) {
            if (invReconocimiento.getIvrMontoAprobado() != null)
                totalivrMontoAprobado = totalivrMontoAprobado.add(invReconocimiento.getIvrMontoAprobado());
            if (invReconocimiento.getIvrMontoPresentado() != null)
                totalivrMontoPresentado = totalivrMontoPresentado.add(invReconocimiento.getIvrMontoPresentado());
        }
    }

    public void cargarReajuste(int tiaNumero) {
        try {

            listaReajuste = invReajusteServiceImpl.getInvReajustesAvance(tiaNumero);
            calcularTotalesResumen(listaReajuste);
            cargarDescripcionesInfraestructura(listaReajuste);
            cargarDescripcionesMonedas(listaReajuste);
            cargarDescripcionesConcepto(listaReajuste);

        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }
    public void deshabilitarxObservado() {
        if (estadoReconocimiento == 2) {
            deshabilitadoxObservado = true;
            resetCamposIGV();
            calcularTotalesResumen(listaReajuste);
            calcularTotalesReconocimiento(listaReconocimiento);
                
        } else {
            deshabilitadoxObservado = false;
        }
    }

    public void resetMontosconIGV() {
        if (!renderMostrarIGV) {
            invVO.setInvMontoTotalAprobado(totalivrMontoAprobado);
            invVO.setInvMontoTotalReajuste(totalirjMontoReajuste);
            setIgv(BigDecimal.ZERO);
        }
    }

    public void calularMontosconIGV() {
        invVO.setInvMontoTotalAprobado(totalivrMontoAprobado);
        invVO.setInvMontoTotalReajuste(totalirjMontoReajuste);
        invVO.setInvMontoTotalAprobado(invVO.getInvMontoTotalAprobado().add(igv.multiply(invVO.getInvMontoTotalAprobado())));
        invVO.setInvMontoTotalReajuste(invVO.getInvMontoTotalReajuste().add(igv.multiply(invVO.getInvMontoTotalReajuste())));
    }
    public void calcularTotalesResumen(List<InvReajusteVO> listaReajuste) {
        setTotalirjMontoAprobado(BigDecimal.ZERO);
        setTotalirjMontoReajuste(BigDecimal.ZERO);
        invVO.setInvMontoTotalAprobado(totalirjMontoAprobado);
        invVO.setInvMontoTotalReajuste(totalirjMontoReajuste);
        for (InvReajusteVO invReajuste : listaReajuste) {
            if (invReajuste.getIrjMontoAprobado() != null) {
                totalirjMontoAprobado = totalirjMontoAprobado.add(invReajuste.getIrjMontoAprobado());
            }

            if (invReajuste.getIrjMontoReajuste() != null) {
                totalirjMontoReajuste = totalirjMontoReajuste.add(invReajuste.getIrjMontoReajuste());
            }
        }
        invVO.setInvMontoTotalAprobado(totalirjMontoAprobado);
        invVO.setInvMontoTotalReajuste(totalirjMontoReajuste);
    }

    public void cargarDescripcionesInfraestructura(List<?> lista) {
        for (Object item : lista) {
            for (InfraestructuraVO infraestructuraVO : listarInfraestructura) {
                if (item instanceof InvReconocimientoVO) {
                    InvReconocimientoVO aux = ((InvReconocimientoVO) item);
                    if (aux.getInfId() == infraestructuraVO.getInfId()) {
                        aux.setNombreInfraestructura(infraestructuraVO.getInfNombre());                       
                    }
                }
                if (item instanceof InvReajusteVO) {
                    InvReajusteVO aux = ((InvReajusteVO) item);
                    if (aux.getInfId() == infraestructuraVO.getInfId())
                        aux.setNombreInfraestructura(infraestructuraVO.getInfNombre());
                }
            }

        }
    }

    public void cargarDescripcionesMonedas(List<?> lista) {
        for (Object item : lista) {
            for (MonedaVO moneda : listarTipoMonedas) {
                if (item instanceof InvReconocimientoVO) {
                    InvReconocimientoVO aux = ((InvReconocimientoVO) item);
                    if (aux.getMonId() == moneda.getMonId()) {                        
                        aux.setNombreMoneda(moneda.getMonNombre());
                    }
                }
                if (item instanceof InvReajusteVO) {
                    InvReajusteVO aux = ((InvReajusteVO) item);
                    if (aux.getMonId() == moneda.getMonId())
                        aux.setNombreMoneda(moneda.getMonNombre());
                }
            }

        }
    }
    public void cargarListaInversiones(int idcontrato) {
        try {
            listContratoInversion = contratoInversionServiceImpl.getInversionesContratoenRectificacion(idcontrato);
            nombreinversion.put("0", "");
            for (ContratoInversionVO contratoInversionVO : listContratoInversion) {
                nombreinversion.put(contratoInversionVO.getInvId().toString(), contratoInversionVO.getInvDescripcion());
           }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void cargarDescripcionesConcepto(List<?> lista) {
        for (Object item : lista) {
            if (item instanceof InvReconocimientoVO) {
                InvReconocimientoVO aux = ((InvReconocimientoVO) item);
                for (ValorizacionInversionAvanceDetalleVO invAvnDetalle : listaValorizacionInversionAvanceDetalleVO) {
                    System.out.println("invAvnDetalle.getInvId();"+invAvnDetalle.getInvId());
                    if (invAvnDetalle.getTiaNumero() == aux.getTiaNumero() && invAvnDetalle.getIad_Id() == aux.getIadId()) {
                        for (InversionDescripcionVO concepto : listaConceptos) {
                            if (invAvnDetalle.getTivId() == concepto.getTivId()&&invAvnDetalle.getDtiId()==concepto.getItdId()) {
                                aux.setDesConcepto(concepto.getItdNombre());                               
                            }
                        }
                        System.out.println("InvReconocimientoVO--invAvnDetalle.getInvId()========##"+invAvnDetalle.getInvId());
                        aux.setNombreInversion((nombreinversion.get(""+invAvnDetalle.getInvId())!=0)? (nombreinversion.get(""+invAvnDetalle.getInvId()).toString()):"");
                    }
                }
            }
            if (item instanceof InvReajusteVO) {
                InvReajusteVO aux = ((InvReajusteVO) item);
                    for (ValorizacionInversionAvanceDetalleVO invAvnDetalle : listaValorizacionInversionAvanceDetalleVO) {
                        System.out.println("invAvnDetalle.getInvId();"+invAvnDetalle.getInvId());
                        if (invAvnDetalle.getTiaNumero() == aux.getTiaNumero() && invAvnDetalle.getIad_Id() == aux.getIadId()) {
                            for (InversionDescripcionVO concepto : listaConceptos) {
                                if (invAvnDetalle.getTivId() == concepto.getTivId()&&invAvnDetalle.getDtiId()==concepto.getItdId()) {
                                    aux.setDesConcepto(concepto.getItdNombre());
                                    
                                }
                            }
                            System.out.println("InvReajusteVO--invAvnDetalle.getInvId()========##"+invAvnDetalle.getInvId());
                            aux.setNombreInversion((nombreinversion.get(""+invAvnDetalle.getInvId())!=0)?(nombreinversion.get(""+invAvnDetalle.getInvId()).toString()):"");
                        }
                    }
            }
        }
    }


    public void editarReconocimiento(ActionEvent e) {
        invReconocimientoVO = (InvReconocimientoVO) e.getComponent().getAttributes().get("reconocimiento");
    }

    public void grabarReconocimiento(ActionEvent e) {
        InvReconocimientoVO rec = (InvReconocimientoVO) e.getComponent().getAttributes().get("reconocimiento");
        Integer idreconocimiento=rec.getIreId();
        BigDecimal montoAprobado =Reutilizar.getNewInstance().redondearBigDecimal(rec.getIvrMontoAprobado());
        BigDecimal montoPresentado = Reutilizar.getNewInstance().redondearBigDecimal(rec.getIvrMontoPresentado());
        if (montoAprobado.compareTo(BigDecimal.ZERO) == 0 || montoAprobado.compareTo(new BigDecimal("0.00")) == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          "El Monto no puede ser Cero"));
        } else if (montoAprobado.compareTo(BigDecimal.ZERO) < 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          "El Monto no puede ser Negativo"));
        }else if (montoAprobado.compareTo(montoPresentado) > 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          "El Monto Aprobado no puede ser Mayor al Monto Presentado"));
        }else {
            try {
                for (InvReconocimientoVO invReconocimientoVO : listaReconocimiento) {
                    if (idreconocimiento == invReconocimientoVO.getIreId()) {
                        invReconocimientoVO.setIvrMontoAprobado(montoAprobado);
                    }
                }
                calcularTotalesReconocimiento(listaReconocimiento);
                for (InvReajusteVO invReconocimientoVO : listaReajuste) {
                    if (idreconocimiento == invReconocimientoVO.getIrjId()) {
                        invReconocimientoVO.setIrjMontoAprobado(montoAprobado);
                    }
                }
                calcularTotalesResumen(listaReajuste);              
                RequestContext.getCurrentInstance().execute("_dlgReconocimiento.hide();");
                RequestContext.getCurrentInstance().update("form:tblResultadoReconocimiento");
                RequestContext.getCurrentInstance().update("form:tblReajuste");
                RequestContext.getCurrentInstance().update("form:resumenMonPre");

            } catch (Exception e1) {
                e1.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              Constantes.ERROR,
                                                                              Constantes.ERROR));
            }
        }
    }

    public void editarReajuste(ActionEvent e) {
        invReajusteVO = (InvReajusteVO) e.getComponent().getAttributes().get("reajuste");
    }

    public void grabarReajuste(ActionEvent e) {
        
        InvReajusteVO rea = (InvReajusteVO) e.getComponent().getAttributes().get("reajuste");
        Integer idreajuste=rea.getIrjId();
        BigDecimal montoReajuste = Reutilizar.getNewInstance().redondearBigDecimal(rea.getIrjMontoReajuste());
        BigDecimal montoAprobado = Reutilizar.getNewInstance().redondearBigDecimal(rea.getIrjMontoAprobado());
        if (montoReajuste.compareTo(BigDecimal.ZERO) == 0 || montoReajuste.compareTo(new BigDecimal("0.00")) == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          "El Monto no puede ser Cero"));
        } else if (montoReajuste.compareTo(BigDecimal.ZERO) < 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          "El Monto no puede ser Negativo"));
        } else if (montoReajuste.compareTo(montoAprobado) > 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          "El Monto Reajustado no puede ser Mayor al Monto Aprobado"));
        } else {
            try {
                for (InvReajusteVO invReconocimientoVO : listaReajuste) {
                    if (idreajuste == invReconocimientoVO.getIrjId()) {
                        invReconocimientoVO.setIrjMontoReajuste(montoReajuste);
                    }
                }
                calcularTotalesResumen(listaReajuste);
                RequestContext.getCurrentInstance().execute("_dlgRejuste.hide();");
                RequestContext.getCurrentInstance().update("form:tblReajuste");
                RequestContext.getCurrentInstance().update("form:resumenMonRea");
            } catch (Exception e1) {
                e1.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              Constantes.ERROR,
                                                                              Constantes.ERROR));
            }
        }
    }
    public void setContratoId(Integer contratoId) {
        this.contratoId = contratoId;
    }

    public Integer getContratoId() {
        return contratoId;
    }


    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }


    public void setConcesionServiceImpl(ConcesionServiceImpl concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public ConcesionServiceImpl getConcesionServiceImpl() {
        return concesionServiceImpl;
    }

    public void setModalidadServiceImp(ModalidadConcesionServiceImpl modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionServiceImpl getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public void setContratoConcesionServiceImp(ContratoConcesionServiceImpl contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public ContratoConcesionServiceImpl getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }


    public void setListaTipoInfraestructura(List<InfraestructuraTipoVO> listaTipoInfraestructura) {
        this.listaTipoInfraestructura = listaTipoInfraestructura;
    }

    public List<InfraestructuraTipoVO> getListaTipoInfraestructura() {
        return listaTipoInfraestructura;
    }

    public void setListaConcesiones(List<ConcesionVO> listaConcesiones) {
        this.listaConcesiones = listaConcesiones;
    }

    public List<ConcesionVO> getListaConcesiones() {
        return listaConcesiones;
    }

    public void setListaModalidad(List<ModalidadConcesionVO> listaModalidad) {
        this.listaModalidad = listaModalidad;
    }

    public List<ModalidadConcesionVO> getListaModalidad() {
        return listaModalidad;
    }

    public void setListaContrato(List<ContratoVO> listaContrato) {
        this.listaContrato = listaContrato;
    }

    public List<ContratoVO> getListaContrato() {
        return listaContrato;
    }


    public void setConcesionarioServiceImpl(ConcesionarioService concesionarioServiceImpl) {
        this.concesionarioServiceImpl = concesionarioServiceImpl;
    }

    public ConcesionarioService getConcesionarioServiceImpl() {
        return concesionarioServiceImpl;
    }

    // Parametros de busqueda
    int tipoinfra, modalidad, concesion;
    Date fechaInicio, fechaFin;


    public void setTipoinfra(int tipoinfra) {
        this.tipoinfra = tipoinfra;
    }

    public int getTipoinfra() {
        return tipoinfra;
    }


    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }

    public int getModalidad() {
        return modalidad;
    }


    public void setConcesion(int concesion) {
        this.concesion = concesion;
    }

    public int getConcesion() {
        return concesion;
    }


    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    public void setConcesionarioVO(ConcesionarioVO concesionarioVO) {
        this.concesionarioVO = concesionarioVO;
    }

    public ConcesionarioVO getConcesionarioVO() {
        return concesionarioVO;
    }


    public void setTipoInversionServicesImpl(TipoInversionServices tipoInversionServicesImpl) {
        this.tipoInversionServicesImpl = tipoInversionServicesImpl;
    }

    public TipoInversionServices getTipoInversionServicesImpl() {
        return tipoInversionServicesImpl;
    }

    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }


    public void setTipoInversionVO(TipoInversionVO tipoInversionVO) {
        this.tipoInversionVO = tipoInversionVO;
    }

    public TipoInversionVO getTipoInversionVO() {
        return tipoInversionVO;
    }


    public void setPeriodoServiceImpl(PeriodoService periodoServiceImpl) {
        this.periodoServiceImpl = periodoServiceImpl;
    }

    public PeriodoService getPeriodoServiceImpl() {
        return periodoServiceImpl;
    }

    public void setPeriodoVO(PeriodoVO periodoVO) {
        this.periodoVO = periodoVO;
    }

    public PeriodoVO getPeriodoVO() {
        return periodoVO;
    }

    public void setListarPeriodos(List<PeriodoVO> listarPeriodos) {
        this.listarPeriodos = listarPeriodos;
    }

    public List<PeriodoVO> getListarPeriodos() {
        return listarPeriodos;
    }

    public void setMonedaServiceImpl(MonedaService monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }

    public MonedaService getMonedaServiceImpl() {
        return monedaServiceImpl;
    }


    public void setDownloadContratoPDF(DefaultStreamedContent downloadContratoPDF) {
        this.downloadContratoPDF = downloadContratoPDF;
    }

    public DefaultStreamedContent getDownloadContratoPDF() {
        return downloadContratoPDF;
    }

    public void setDownloadFichaResumen(DefaultStreamedContent downloadFichaResumen) {
        this.downloadFichaResumen = downloadFichaResumen;
    }

    public DefaultStreamedContent getDownloadFichaResumen() {
        return downloadFichaResumen;
    }

    public List<InfraestructuraVO> getListaInfraestructura() {
        return listaInfraestructura;
    }

    public void setListaInfraestructura(List<InfraestructuraVO> listaInfraestructura) {
        this.listaInfraestructura = listaInfraestructura;
    }

    public InfraestructuraServiceImpl getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }

    public void setInfraestructuraServiceImpl(InfraestructuraServiceImpl infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public void setContratoInversionVO(ContratoInversionVO contratoInversionVO) {
        this.contratoInversionVO = contratoInversionVO;
    }

    public ContratoInversionVO getContratoInversionVO() {
        return contratoInversionVO;
    }


    public void setListarTipoMonedas(List<MonedaVO> listarTipoMonedas) {
        this.listarTipoMonedas = listarTipoMonedas;
    }

    public List<MonedaVO> getListarTipoMonedas() {
        return listarTipoMonedas;
    }

    public void setListaTipoInversion(List<TipoInversionVO> listaTipoInversion) {
        this.listaTipoInversion = listaTipoInversion;
    }

    public List<TipoInversionVO> getListaTipoInversion() {
        return listaTipoInversion;
    }

    public void setListarInfraestructura(List<InfraestructuraVO> listarInfraestructura) {
        this.listarInfraestructura = listarInfraestructura;
    }

    public List<InfraestructuraVO> getListarInfraestructura() {
        return listarInfraestructura;
    }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

    public void setRenderAeropuertos(boolean renderAeropuertos) {
        this.renderAeropuertos = renderAeropuertos;
    }

    public boolean isRenderAeropuertos() {
        return renderAeropuertos;
    }

    public void setFechaInicioSuscripcion(Date fechaInicioSuscripcion) {
        this.fechaInicioSuscripcion = fechaInicioSuscripcion;
    }

    public Date getFechaInicioSuscripcion() {
        return fechaInicioSuscripcion;
    }

    public void setFechaFinSuscripcion(Date fechaFinSuscripcion) {
        this.fechaFinSuscripcion = fechaFinSuscripcion;
    }

    public Date getFechaFinSuscripcion() {
        return fechaFinSuscripcion;
    }

    public void setNombreConcesion(String nombreConcesion) {
        this.nombreConcesion = nombreConcesion;
    }

    public String getNombreConcesion() {
        return nombreConcesion;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setTipoInfraestructura(int tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public int getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setListaValorizaciones(List<InvAvnVO> listaValorizaciones) {
        this.listaValorizaciones = listaValorizaciones;
    }

    public List<InvAvnVO> getListaValorizaciones() {
        return listaValorizaciones;
    }

    public void setNotificacionServiceImpl(NotificacionService notificacionServiceImpl) {
        this.notificacionServiceImpl = notificacionServiceImpl;
    }

    public NotificacionService getNotificacionServiceImpl() {
        return notificacionServiceImpl;
    }

    public void setInversionAvanceEstadoServiceImpl(InversionAvanceEstadoService inversionAvanceEstadoServiceImpl) {
        this.inversionAvanceEstadoServiceImpl = inversionAvanceEstadoServiceImpl;
    }

    public InversionAvanceEstadoService getInversionAvanceEstadoServiceImpl() {
        return inversionAvanceEstadoServiceImpl;
    }

    public void setInvAvnVO(InvAvnVO invAvnVO) {
        this.invAvnVO = invAvnVO;
    }

    public InvAvnVO getInvAvnVO() {
        return invAvnVO;
    }

    public void setListarEstadosIA(List<InvAvnEstadoVO> listarEstadosIA) {
        this.listarEstadosIA = listarEstadosIA;
    }

    public List<InvAvnEstadoVO> getListarEstadosIA() {
        return listarEstadosIA;
    }


    public void setContratoCompromisoServiceImpl(ContratoCompromisoService contratoCompromisoServiceImpl) {
        this.contratoCompromisoServiceImpl = contratoCompromisoServiceImpl;
    }

    public ContratoCompromisoService getContratoCompromisoServiceImpl() {
        return contratoCompromisoServiceImpl;
    }


    public void setInvReconocimientoServiceImpl(InvReconocimientoService invReconocimientoServiceImpl) {
        this.invReconocimientoServiceImpl = invReconocimientoServiceImpl;
    }

    public InvReconocimientoService getInvReconocimientoServiceImpl() {
        return invReconocimientoServiceImpl;
    }

    public void setInvReajusteServiceImpl(InvReajusteService invReajusteServiceImpl) {
        this.invReajusteServiceImpl = invReajusteServiceImpl;
    }

    public InvReajusteService getInvReajusteServiceImpl() {
        return invReajusteServiceImpl;
    }

    public void setListaReconocimiento(List<InvReconocimientoVO> listaReconocimiento) {
        this.listaReconocimiento = listaReconocimiento;
    }

    public List<InvReconocimientoVO> getListaReconocimiento() {
        return listaReconocimiento;
    }

    public void setListaReajuste(List<InvReajusteVO> listaReajuste) {
        this.listaReajuste = listaReajuste;
    }

    public List<InvReajusteVO> getListaReajuste() {
        return listaReajuste;
    }


    public void setInversionDescripcionServicesImpl(InversionDescripcionServices inversionDescripcionServicesImpl) {
        this.inversionDescripcionServicesImpl = inversionDescripcionServicesImpl;
    }

    public InversionDescripcionServices getInversionDescripcionServicesImpl() {
        return inversionDescripcionServicesImpl;
    }


    public void setListaConceptos(List<InversionDescripcionVO> listaConceptos) {
        this.listaConceptos = listaConceptos;
    }

    public List<InversionDescripcionVO> getListaConceptos() {
        return listaConceptos;
    }


    public void setTotalivrMontoPresentado(BigDecimal totalivrMontoPresentado) {
        this.totalivrMontoPresentado = totalivrMontoPresentado;
    }

    public BigDecimal getTotalivrMontoPresentado() {
        return totalivrMontoPresentado;
    }

    public void setTotalivrMontoAprobado(BigDecimal totalivrMontoAprobado) {
        this.totalivrMontoAprobado = totalivrMontoAprobado;
    }

    public BigDecimal getTotalivrMontoAprobado() {
        return totalivrMontoAprobado;
    }

    public void setTotalirjMontoAprobado(BigDecimal totalirjMontoAprobado) {
        this.totalirjMontoAprobado = totalirjMontoAprobado;
    }

    public BigDecimal getTotalirjMontoAprobado() {
        return totalirjMontoAprobado;
    }

    public void setTotalirjMontoReajuste(BigDecimal totalirjMontoReajuste) {
        this.totalirjMontoReajuste = totalirjMontoReajuste;
    }

    public BigDecimal getTotalirjMontoReajuste() {
        return totalirjMontoReajuste;
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

    public void setRenderMostrarIGV(boolean renderMostrarIGV) {
        this.renderMostrarIGV = renderMostrarIGV;
    }

    public boolean isRenderMostrarIGV() {
        return renderMostrarIGV;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setInvVO(InvVO invVO) {
        this.invVO = invVO;
    }

    public InvVO getInvVO() {
        return invVO;
    }

    public void setEstadoReconocimiento(int estadoReconocimiento) {
        this.estadoReconocimiento = estadoReconocimiento;
    }

    public int getEstadoReconocimiento() {
        return estadoReconocimiento;
    }

    public void setDeshabilitadoxObservado(boolean deshabilitadoxObservado) {
        this.deshabilitadoxObservado = deshabilitadoxObservado;
    }

    public boolean isDeshabilitadoxObservado() {
        return deshabilitadoxObservado;
    }

    public void setListaValorizacionInversionAvanceDetalleVO(List<ValorizacionInversionAvanceDetalleVO> listaValorizacionInversionAvanceDetalleVO) {
        this.listaValorizacionInversionAvanceDetalleVO = listaValorizacionInversionAvanceDetalleVO;
    }

    public List<ValorizacionInversionAvanceDetalleVO> getListaValorizacionInversionAvanceDetalleVO() {
        return listaValorizacionInversionAvanceDetalleVO;
    }

    public void setValorizacionInversionAvanceDetalleServiceImpl(ValorizacionInversionAvanceDetalleService valorizacionInversionAvanceDetalleServiceImpl) {
        this.valorizacionInversionAvanceDetalleServiceImpl = valorizacionInversionAvanceDetalleServiceImpl;
    }

    public ValorizacionInversionAvanceDetalleService getValorizacionInversionAvanceDetalleServiceImpl() {
        return valorizacionInversionAvanceDetalleServiceImpl;
    }

    public void setInvServiceImpl(InvService invServiceImpl) {
        this.invServiceImpl = invServiceImpl;
    }

    public InvService getInvServiceImpl() {
        return invServiceImpl;
    }


    public void setValorizacionInversionAvanceServiceImpl(ValorizacionInversionAvanceService valorizacionInversionAvanceServiceImpl) {
        this.valorizacionInversionAvanceServiceImpl = valorizacionInversionAvanceServiceImpl;
    }

    public ValorizacionInversionAvanceService getValorizacionInversionAvanceServiceImpl() {
        return valorizacionInversionAvanceServiceImpl;
    }

    public void setDeshabilitadoxDeclaracionNoCargada(boolean deshabilitadoxDeclaracionNoCargada) {
        this.deshabilitadoxDeclaracionNoCargada = deshabilitadoxDeclaracionNoCargada;
    }

    public boolean isDeshabilitadoxDeclaracionNoCargada() {
        return deshabilitadoxDeclaracionNoCargada;
    }

    public void setMostrarxDeclaracionCargada(boolean mostrarxDeclaracionCargada) {
        this.mostrarxDeclaracionCargada = mostrarxDeclaracionCargada;
    }

    public boolean isMostrarxDeclaracionCargada() {
        return mostrarxDeclaracionCargada;
    }

    public void setReadOnlyMontoTipoCambio(boolean readOnlyMontoTipoCambio) {
        this.readOnlyMontoTipoCambio = readOnlyMontoTipoCambio;
    }

    public boolean isReadOnlyMontoTipoCambio() {
        return readOnlyMontoTipoCambio;
    }

    public void setContratoInversionServiceImpl(ContratoInversionServiceImpl contratoInversionServiceImpl) {
        this.contratoInversionServiceImpl = contratoInversionServiceImpl;
    }

    public ContratoInversionServiceImpl getContratoInversionServiceImpl() {
        return contratoInversionServiceImpl;
    }
}
