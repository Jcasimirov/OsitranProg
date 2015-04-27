package com.ositran.contratos;

import com.ositran.service.ConcesionarioService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoEntregaService;
import com.ositran.service.ContratoPenalidadEstadoService;
import com.ositran.service.ContratoPenalidadService;
import com.ositran.service.MonedaService;
import com.ositran.service.PeriodoService;
import com.ositran.service.TipoInversionServices;
import com.ositran.serviceimpl.AdendaTipoServiceImpl;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoAdendaServiceImpl;
import com.ositran.serviceimpl.ContratoAlertaEstadoServiceImpl;
import com.ositran.serviceimpl.ContratoAlertaServiceImpl;
import com.ositran.serviceimpl.ContratoCaoServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoHitoServiceImpl;
import com.ositran.serviceimpl.ContratoInversionServiceImpl;
import com.ositran.serviceimpl.ContratoPpoServiceImpl;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.util.Constantes;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.AdendaTipoVO;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.ContratoAdendaVO;
import com.ositran.vo.bean.ContratoAlertaEstadoVO;
import com.ositran.vo.bean.ContratoAlertaVO;
import com.ositran.vo.bean.ContratoCaoVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoEntregaVO;
import com.ositran.vo.bean.ContratoHitoVO;
import com.ositran.vo.bean.ContratoInversionVO;
import com.ositran.vo.bean.ContratoPenalidadEstadoVO;
import com.ositran.vo.bean.ContratoPenalidadVO;
import com.ositran.vo.bean.ContratoPpoVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.PeriodoVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TipoInversionVO;
import com.ositran.vo.bean.UsuarioVO;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "actualizarContratoMB")
@ViewScoped
public class ActualizarContrato {


    // Service
    // campos de formulario


    @ManagedProperty(value = "#{ContratoAdendaVO}")
    ContratoAdendaVO contratoAdendaVO;
    @ManagedProperty(value = "#{contratoNuevaAdendaVO}")
    ContratoAdendaVO contratoNuevaAdendaVO;
    @ManagedProperty(value = "#{contratoNuevaEntregaVO}")
    ContratoEntregaVO contratoNuevaEntregaVO;
    @ManagedProperty(value = "#{adendaTipoServiceImpl}")
    private AdendaTipoServiceImpl adendaTipoServiceImpl;
    @ManagedProperty(value = "#{contratoAdendaServiceImpl}")
    private ContratoAdendaServiceImpl contratoAdendaServiceImpl;
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
    @ManagedProperty(value = "#{contratoEntregaServiceImpl}")
    ContratoEntregaService contratoEntregaServiceImpl;
    @ManagedProperty(value = "#{contratoPenalidadEstadoServiceImpl}")
    ContratoPenalidadEstadoService contratoPenalidadEstadoServiceImpl;
    @ManagedProperty(value = "#{contratoPenalidadServiceImpl}")
    ContratoPenalidadService contratoPenalidadServiceImpl;
    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
    ContratoCompromisoService contratoCompromisoServiceImpl;
    @ManagedProperty(value = "#{monedaServiceImpl}")
    MonedaService monedaServiceImpl;
    @ManagedProperty(value = "#{periodoServiceImpl}")

    PeriodoService periodoServiceImpl;
    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    private InfraestructuraServiceImpl infraestructuraServiceImpl;

    @ManagedProperty(value = "#{contratoVO}")
    private ContratoVO contratoVO;
    @ManagedProperty(value = "#{concesionarioVO}")
    private ConcesionarioVO concesionarioVO;
    @ManagedProperty(value = "#{contratoEntregaVO}")
    private ContratoEntregaVO contratoEntregaVO;
    @ManagedProperty(value = "#{monedaVO}")
    private MonedaVO monedaVO;
    @ManagedProperty(value = "#{contratoCompromisoVO}")
    private ContratoCompromisoVO contratoCompromisoVO;
    @ManagedProperty(value = "#{contratoNuevoCompromisoVO}")
    private ContratoCompromisoVO contratoNuevoCompromisoVO;
    @ManagedProperty(value = "#{contratoNuevaPenalidadVO}")
    private ContratoPenalidadVO contratoNuevaPenalidadVO;
    @ManagedProperty(value = "#{contratoNuevoCompromisoSupervisadoVO}")
    private ContratoCompromisoVO contratoNuevoCompromisoSupervisadoVO;
    @ManagedProperty(value = "#{tipoInversionVO}")
    private TipoInversionVO tipoInversionVO;
    @ManagedProperty(value = "#{periodoVO}")
    private PeriodoVO periodoVO;
    @ManagedProperty(value = "#{contratoInversionVO}")
    private ContratoInversionVO contratoInversionVO;
    @ManagedProperty(value = "#{contratoInversionServiceImpl}")
    private ContratoInversionServiceImpl contratoInversionServiceImpl;
    List<ContratoInversionVO> listContratoInversion;

    @ManagedProperty(value = "#{contratoAlertaVO}")
    private ContratoAlertaVO contratoAlertaVO;
    @ManagedProperty(value = "#{contratoAlertaServiceImpl}")
    private ContratoAlertaServiceImpl contratoAlertaServiceImpl;
    List<ContratoAlertaVO> listContratoAlerta;

    @ManagedProperty(value = "#{contratoAlertaEstadoVO}")
    private ContratoAlertaEstadoVO contratoAlertaEstadoVO;    
    @ManagedProperty(value = "#{contratoAlertaEstadoServiceImpl}")
    private ContratoAlertaEstadoServiceImpl contratoAlertaEstadoServiceImpl;
    private List<ContratoAlertaEstadoVO> listContratoAlertaEstado;
    
    @ManagedProperty(value = "#{contratoCaoVO}")
    private ContratoCaoVO contratoCaoVO;
    @ManagedProperty(value = "#{contratoCaoServiceImpl}")
    private ContratoCaoServiceImpl contratoCaoServiceImpl;
    private List<ContratoCaoVO> listContratoCaoVO;

    @ManagedProperty(value = "#{contratoHitoVO}")
    private ContratoHitoVO contratoHitoVO;
    @ManagedProperty(value = "#{contratoHitoServiceImpl}")
    private ContratoHitoServiceImpl contratoHitoServiceImpl;
    private List<ContratoHitoVO> listContratoHitoVO;

    @ManagedProperty(value = "#{contratoPpoVO}")
    private ContratoPpoVO contratoPpoVO;
    @ManagedProperty(value = "#{contratoPpoServiceImpl}")
    private ContratoPpoServiceImpl contratoPpoServiceImpl;
    private List<ContratoPpoVO> listContratoPpoVO;

    // Lista Bean VO

    List<InfraestructuraTipoVO> listaTipoInfraestructura = new ArrayList<InfraestructuraTipoVO>();
    List<InfraestructuraVO> listaInfraestructura = new ArrayList<InfraestructuraVO>();

    List<ConcesionVO> listaConcesiones = new ArrayList<ConcesionVO>();

    List<ModalidadConcesionVO> listaModalidad = new ArrayList<ModalidadConcesionVO>();

    List<ContratoVO> listaContrato = new ArrayList<ContratoVO>();

    List<ContratoAdendaVO> listContratoAdenda = new ArrayList<ContratoAdendaVO>();

    List<ContratoEntregaVO> listarEntregas = new ArrayList<ContratoEntregaVO>();

    List<MonedaVO> listarTipoMonedas = new ArrayList<MonedaVO>();
    List<ContratoPenalidadVO> listarContratoPenalidad = new ArrayList<ContratoPenalidadVO>();
    List<ContratoPenalidadEstadoVO> listarContratoPenalidadEstado = new ArrayList<ContratoPenalidadEstadoVO>();
    List<PeriodoVO> listarPeriodos = new ArrayList<PeriodoVO>();
    List<AdendaTipoVO> listarAdendasTipo = new ArrayList<AdendaTipoVO>();
    List<ContratoCompromisoVO> listarContratoCompromiso = new ArrayList<ContratoCompromisoVO>();
    List<ContratoCompromisoVO> listarContratoCompromisoSupervisado = new ArrayList<ContratoCompromisoVO>();
    List<TipoInversionVO> listaTipoInversion = new ArrayList<TipoInversionVO>();
    private List<InfraestructuraVO> listarInfraestructura = new ArrayList<InfraestructuraVO>();
    private List<AdendaTipoVO> listaAdendaTipo;
    private Integer adendaTipo = 0;
    private String nombre;
    private String objeto;
    private Date fecha;
    private String documento;
    private Integer contratoId;
    private Integer adendaId;
    private boolean aplicaAvancedeObra;
    private boolean diascalendario;
    private int periodoseleccionado;
    private UploadedFile fileContrato;
    private UploadedFile fileFicharesumen;
    private DefaultStreamedContent downloadPenalidades;
    private DefaultStreamedContent downloadContratoPDF;
    private DefaultStreamedContent downloadFichaResumen;
    private DefaultStreamedContent downloadAdendas;
    private DefaultStreamedContent downloadEntregas;
    private DefaultStreamedContent downloadCao;
    private DefaultStreamedContent downloadHito;
    private DefaultStreamedContent downloadPpo;

    public final int formulario = 29;
    private RolOpcionesVO rolOpcion;
    private boolean renderAeropuertos;

    // CAO
    private String nombreCAO;
    private Integer codigoCAO;
    private Date fechaCAO;
    private BigDecimal montoCAO;
    private String documentoCAO;
    private Integer monedaCAOId;
    private Integer codigoCao;
    private String nombreCao2;

    // HITO
    private String nombreHito;
    private Integer codigoHito;
    private Date fechaHito;
    private BigDecimal montoHito;
    private String documentoHito;
    private Integer monedaHitoId;
    private Integer codigoHito2;
    private String nombreHito2;

    //PPO
    private String nombrePpo;
    private Integer codigoPpo;
    private Date fechaPpo;
    private BigDecimal montoPpo;
    private String documentoPpo;
    private Integer monedaPpoId;
    private Integer codigoPpo2;
    private String nombrePpo2;
    //inversion
    private Integer infraestructuraId = 0;
    private String descInversion;
    private String nombreInversion;
    private Integer codigoInversion;

    //alertas
    private String nombAeropuerto;
    private String descAlerta;
    private Date fechaIniAlerta;
    private Date fechaFinAlerta;
    private String plazoAlerta;
    private Integer diaPresAlerta;
    private String nombreAlerta;
    private Integer codigoAlerta;
    private int incIgv;
    private boolean activaIGV=true;
    private boolean tabDeshabilitado=true;
    private int tipoArchivoEnContratoConcesion;
    private int incIgvSup;
    private boolean activaIGVSup=true;
    private double tipocambiosup;
    private String nombreConcesion;
    private Date fechaInicioSuscripcion;
    private Date fechaFinSuscripcion;
    private String campo;
    private UsuarioVO usuario;
    private int tipoInfraestructura;
    
    
    private ContratoAdendaVO idAdendaEliminar;
    private ContratoEntregaVO idEntregaEliminar;
    private ContratoCompromisoVO idCompromisoEliminarI;
    private ContratoCompromisoVO idCompromisoEliminarS;
    private ContratoPenalidadVO idPenalidadEliminar;
    public void validarSesion() throws IOException {
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
        usuario=Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        tipoInfraestructura= Reutilizar.getNewInstance().obtenerDatosEmpleadoLogueado().getTinId();
    }

    public ActualizarContrato() {
        super();

    }

    public void listarTiposAdendas() {
        try {
            listarAdendasTipo = adendaTipoServiceImpl.query();
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }

    public void listarTiposMoneda() {
        try {
            List<MonedaVO> lista=new ArrayList<MonedaVO>();
            listarTipoMonedas = monedaServiceImpl.query();
            for (MonedaVO moneda : listarTipoMonedas) {
                if(moneda.getMonId()!=0)
                    lista.add(moneda);
           }
            listarTipoMonedas=lista;
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    public void listarEstadosAlerta() {
        try {
            listContratoAlertaEstado = contratoAlertaEstadoServiceImpl.query();
        } catch (Exception e) {
            // TODO: Add catch code
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
    public void ListarConcesiones() {
        try {
            listaConcesiones = concesionServiceImpl.query();
            System.out.println("listaConcesiones:" + listaConcesiones.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Metodo para Filtrar la Lista de Concesi�n
    public void filtrarConcesion() {
        try {
            listaConcesiones = concesionServiceImpl.filtrarConcesion(tipoinfra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo para Listar Modalidad de Concesi�n
    public void ListarModalidad() throws SQLException {
        try {
            listaModalidad = this.modalidadServiceImp.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
    public void resetearCamposBuscarContratos(){
        tipoinfra=0;
        concesion=0;
        fechaInicioSuscripcion=null;
        fechaFinSuscripcion=null;      
    }
    // Metodo para Buscar Contrato de Concesion y llenar los demas tabs
    public void abrirBuscarContratos(){
        if(nombreConcesion.length()!=0){
            resetearCamposBuscarContratos();
            buscarContratos();        
        }
    }
    public void buscarContratos() {
           System.out.println("actualizarContratoMB.buscarContratos");
           try {
               listaContrato =
               contratoConcesionServiceImp.buscarxNombreConcesion(nombreConcesion.toUpperCase().trim(),tipoinfra,concesion,fechaInicioSuscripcion,fechaFinSuscripcion);
               System.out.println("listaConcesiones.size()"+listaConcesiones.size());
               /*   for (ContratoVO aux : listaContrato) {
                   for (ConcesionVO concesion : listaConcesiones) {
                       if (concesion.getCsiId() == aux.getCsiId())
                           aux.setNombreConcesion(concesion.getCsiNombre());
                   }
                   for (InfraestructuraTipoVO infraestructuratipo : listaTipoInfraestructura) {
                       if (infraestructuratipo.getTinId() == aux.getTinId())
                           aux.setNombreTipoInfraestructura(infraestructuratipo.getTinNombre());
                   }
                   for (ModalidadConcesionVO modalidad : listaModalidad) {
                       if (modalidad.getMcoId() == aux.getMcoId())
                           aux.setNombreModalidad(modalidad.getMcoNombre());
                   }


               } */
                /*  for (int i = 0; i < listaContrato.size(); i++) {
                   listaContrato.get(i).setNombreConcesion(concesionServiceImpl.get(listaContrato.get(i).getCsiId()).getCsiNombre());
                   //listaContrato.get(i).setNombreConcesionario(concesionarioServiceImpl.get(listaContrato.get(i).getCncId()).getCncNombre());
                   listaContrato.get(i).setNombreModalidad(modalidadServiceImp.get(listaContrato.get(i).getMcoId()).getMcoNombre());
                   listaContrato.get(i).setNombreTipoInfraestructura(infraestructuraTipoServiceImpl.get(listaContrato.get(i).getTinId()).getTinNombre());

               } */

           } catch (Exception e) {
               // TODO: Add catch code
               e.printStackTrace();
           }


       }
    public void resetAvanceObra(){
        periodoseleccionado=0;
        contratoVO.setConDiames(null);
    }
    public void elegirDiames(){
        if(periodoseleccionado==-1){
            
        }
    }
    public void seleccionarContrato(ActionEvent e) {
        contratoVO = (ContratoVO) e.getComponent().getAttributes().get("idcontrato");
        listarTiposMoneda();
        cargarDatosConcesionario(contratoVO.getCncId());
        cargarListaAdendas(contratoVO.getConId());
        cargarListaContratoEntregas(contratoVO.getConId());
        cargarDatosAvanceReportedeObra();
        cargarInfraestructurasContrato(contratoVO.getConId());
        cargarListaInversiones(contratoVO.getConId());
        cargarListaAlertas(contratoVO.getConId());
        cargarListaCaos(contratoVO.getConId());
        cargarListaHitos(contratoVO.getConId());
        cargarListaPpos(contratoVO.getConId());
        resetDialogoBuscarContrato();
        listaContratoCompromiso(contratoVO.getConId());
        listaContratoCompromisoSupervisado(contratoVO.getConId());
        listaContratoPenalidad(contratoVO.getConId());
        tabDeshabilitado=false;
        if(tipoInfraestructura==Constantes.TIPINFAEROPUERTOS){
            RequestContext.getCurrentInstance().update("tab:frmInversion:tablaContratoInversion");
            RequestContext.getCurrentInstance().update("tab:frmAgregarInversion:AeropuertoInversion");
        }
    }
    /*--Reporte de Avance de Obra
     * periodoseleccionado=contratoVO.getPerId();
     * aplicaAvancedeObra=contratoVO.getConAvanceobra() == 1 ? true : false;
     * contratoVO.conDiames
     * --Plazos de Revisi�n
     * contratoVO.conPlazorevision
     * contratoVO.conTipodias
     * --Otros Datos
     * contratoVO.conFechaSuscripcion
     * contratoVO.conPlazoconcesion
     * contratoVO.conPdfcontrato
     * contratoVO.conFicharesumen*/
    public void guardarContrato() {
        try {
            contratoVO.setPerId(periodoseleccionado);
            contratoVO.setConAvanceobra(aplicaAvancedeObra ? 1 : 0);
            if(contratoVO.getInputStreamFichaResumen()!=null)
                            Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTAFICHASRESUMEN +
                                                                            contratoVO.getConFicharesumen(),
                                                                            contratoVO.getInputStreamFichaResumen());
            System.out.println("ANTES ARCHIVO CREADO");
            if(contratoVO.getInputStreamContratoPDF()!=null){
                            Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTACONTRATOSPDF +
                                                                            contratoVO.getConPdfcontrato(),
                                                                            contratoVO.getInputStreamContratoPDF());
                            System.out.println("ARCHIVO CREADO");
            }
            contratoVO.setConFechaCambio(new Date());
            contratoVO.setConUsuarioCambio(usuario.getUsuAlias());
            contratoVO.setConTerminal(usuario.getUsuTerminal());
            contratoConcesionServiceImp.update(contratoVO);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                          Constantes.EXITOCONTRATOACTUALIZADO));
        } catch (Exception sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORGUARDAR));
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

    public void cargarDatosAvanceReportedeObra() {
        aplicaAvancedeObra = contratoVO.getConAvanceobra() == 1 ? true : false;
        cargarPeriodo();
    }

    public void cargarPeriodo() {
        periodoseleccionado = contratoVO.getPerId();
    }

    public void cargarDatosConcesionario(int idconcesionario) {
        try {
            concesionarioVO = concesionarioServiceImpl.get(idconcesionario);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

    }


    //*********************************************************************//
    //**************************Empieza Contrato Adenda********************//
    //*********************************************************************//
    public void cargarListaAdendas(int idcontrato) {
        try {
            System.out.println("idcontrato: " + idcontrato);
            listContratoAdenda = contratoAdendaServiceImpl.getAdendasContrato(idcontrato);
            for (ContratoAdendaVO contratoAdendaVO : listContratoAdenda) {
                System.out.println("contratoAdendaVO.getCadEstado(): " + contratoAdendaVO.getCadEstado());
                for (AdendaTipoVO aux : listarAdendasTipo) {
                    if (aux.getTadId() == contratoAdendaVO.getTadId()) {
                        contratoAdendaVO.setTadNombre(aux.getTadNombre());
                    }
                }
                if(tipoInfraestructura!=Constantes.TIPINFAEROPUERTOS){
                    for (MonedaVO aux : listarTipoMonedas) {
                        if (aux.getMonId() == contratoAdendaVO.getMonId()) {
                            contratoAdendaVO.setMonNombre(aux.getMonNombre());
                        }
                    } 
                }
            }
          
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void agregarAdenda() {
        if(contratoNuevaAdendaVO.getCadNombre().equals("")){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Nombre"));   
        } else if (contratoNuevaAdendaVO.getTadId()==null || contratoNuevaAdendaVO.getTadId() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha seleccionado el Tipo de Adenda"));                    
        } else if (contratoNuevaAdendaVO.getCadDescripcion().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Objeto"));                      
        }
        
        else if (contratoNuevaAdendaVO.getCadFecha()==null) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                      "No ha seleccionado la Fecha"));             
        } 
        else if (contratoNuevaAdendaVO.getCadDocumentoFisico().equals("")) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                      "No ha seleccionado ningun documento"));             
        } 
       
        else {
            if(tipoInfraestructura!=Constantes.TIPINFAEROPUERTOS){
                        if(contratoNuevaAdendaVO.getCadMonto()==null || contratoNuevaAdendaVO.getCadMonto().equals("0")){
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                          "No ha ingresado el Monto"));   
                        } 
                        else if(contratoNuevaAdendaVO.getCadCompromisoInversion()==null){
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                          "No ha ingresado el Comp. Inv. Concesionario"));   
                        } 
                        else if(contratoNuevaAdendaVO.getMonId()==null || contratoNuevaAdendaVO.getMonId()==0  ){
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                          "No ha ingresado el Tipo de Moneda"));   
                        }else{
                            ejecutarGrabarAdenda();
                        }
            
            }else{
                ejecutarGrabarAdenda();                
            }
        }
    }
    public void ejecutarGrabarAdenda(){
        try {
            if(contratoNuevaAdendaVO.getCadCompromisoInversion()!=null)
                contratoNuevaAdendaVO.setBoocadCompromisoInversion(contratoNuevaAdendaVO.getCadCompromisoInversion()==1?true:false);
            if(tipoInfraestructura==Constantes.TIPINFAEROPUERTOS){
                contratoNuevaAdendaVO.setCadMonto(new BigDecimal("0"));
                contratoNuevaAdendaVO.setMonId(0);
                contratoNuevaAdendaVO.setMonNombre("");
                contratoNuevaAdendaVO.setCadCompromisoInversion(0);
                contratoNuevaAdendaVO.setBoocadCompromisoInversion(false);
                contratoNuevaAdendaVO.setCadCompromisoInversion(0);
            }                
            contratoNuevaAdendaVO.setTadNombre(obtenerNombreTipoAdenda(contratoNuevaAdendaVO.getTadId()));
            contratoNuevaAdendaVO.setCadFechaDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoNuevaAdendaVO.getCadFecha()));
            contratoNuevaAdendaVO.setCadEstado(1); 
            /*AUDITORIA*/
            Date fechaActual=new Date();
            contratoNuevaAdendaVO.setCadFechaAlta(fechaActual);
            contratoNuevaAdendaVO.setCadUsuarioAlta(usuario.getUsuAlias());
            contratoNuevaAdendaVO.setCadTerminal(usuario.getUsuTerminal());
            /*FIN AUDITORIA*/
            contratoAdendaServiceImpl.insert(contratoNuevaAdendaVO);
            listContratoAdenda.add(contratoNuevaAdendaVO);
            cargarListaAdendas(contratoVO.getConId());
            Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTAADENDA+contratoNuevaAdendaVO.getCadDocumentoFisico(), contratoNuevaAdendaVO.getInputStreamNuevaAdenda());
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                          Constantes.GRABARMENSAJESATISFACTORIO));
            RequestContext.getCurrentInstance().execute("popupAgregarAdenda.hide();");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORGUARDAR));
        } finally {
        
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
    }
    public void cargarEliminarAdenda(ActionEvent e){
      idAdendaEliminar=(ContratoAdendaVO) e.getComponent().getAttributes().get("adenda");
    }
    public void borrarAdenda() {
        try {   
            
            idAdendaEliminar.setCadEstado(0);
            /*AUDITORIA*/
            Date fechaActual=new Date();
            idAdendaEliminar.setCadFechaBaja(fechaActual);
            idAdendaEliminar.setCadUsuarioBaja(usuario.getUsuAlias());
            idAdendaEliminar.setCadTerminal(usuario.getUsuTerminal());
            /*FIN AUDITORIA*/
            contratoAdendaServiceImpl.update(idAdendaEliminar);
            listContratoAdenda.remove(idAdendaEliminar);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                          Constantes.ELIMINARMENSAJESATISFACTORIO));
            RequestContext.getCurrentInstance().execute("dlgEliminarAdenda.hide();");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORBORRAR));
        } finally {
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
    }


    public void resetearNuevaAdenda() {
            contratoNuevaAdendaVO = new ContratoAdendaVO();
            contratoNuevaAdendaVO.setConId(contratoVO.getConId());
            RequestContext.getCurrentInstance().update("tab:frmNuevaAdendaDlg:pnlNuevaAdendaDlg");
            RequestContext.getCurrentInstance().update("tab:frmNuevaAdendaDlg:pnlNuevaAdendaBtnDlg");
            RequestContext.getCurrentInstance().execute("popupAgregarAdenda.show();");
        
    }


    public void subirAdenda(FileUploadEvent event) throws IOException {
        contratoNuevaAdendaVO.setCadDocumentoFisico(event.getFile().getFileName());
        contratoNuevaAdendaVO.setInputStreamNuevaAdenda(event.getFile().getInputstream());

    }

    public void preDownloadAdendas(String nombreArchivo) {
        try {
            downloadAdendas = Reutilizar.getNewInstance().preDownload(Constantes.RUTAADENDA + nombreArchivo);
        } catch (FileNotFoundException fnfe) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                          Constantes.ARCHIVONOENCONTRADO));
        }
    }

    public void preDownloadCao(String nombreArchivo) {
        try {
            downloadCao = Reutilizar.getNewInstance().preDownload(Constantes.RUTACAO + nombreArchivo);
        } catch (FileNotFoundException fnfe) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                          Constantes.ARCHIVONOENCONTRADO));
        }
    }
    
    public void preDownloadHito(String nombreArchivo) {
        try {
            setDownloadHito(Reutilizar.getNewInstance().preDownload(Constantes.RUTAHITO + nombreArchivo));
        } catch (FileNotFoundException fnfe) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                          Constantes.ARCHIVONOENCONTRADO));
        }
    }
    
    public void preDownloadPpo(String nombreArchivo) {
        try {
            setDownloadPpo(Reutilizar.getNewInstance().preDownload(Constantes.RUTAPPO + nombreArchivo));
        } catch (FileNotFoundException fnfe) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                          Constantes.ARCHIVONOENCONTRADO));
        }
    }

    public String obtenerNombreTipoAdenda(int tadid) {
        String nombreadenda = "";
        for (AdendaTipoVO adendaTipoVO : listarAdendasTipo) {
            if (tadid == adendaTipoVO.getTadId()) {
                nombreadenda = adendaTipoVO.getTadNombre();
            }
            ;
        }
        return nombreadenda;
    }
   
    //************************Termina Contrato Adenda**********************//
    public void limpiarCampos() {
        nombre = "";
        contratoId = 0;
        documento = "";
        objeto = "";
        fecha = null;
        adendaTipo = 0;
    }

    
    public void limpiarCamposHito(){
        nombreHito = null;
        fechaHito = null;        
        montoHito = null;
        monedaHitoId = null;
        documentoHito  = null;
        
    }
    
    public void limpiarCamposHito2(){
        contratoHitoVO = null;
        contratoHitoVO.setMonId(0);
        
    }

    //*********************************************************************//
    //**************************Empieza Contrato Entrega********************//
    //*********************************************************************//

    public void cargarListaContratoEntregas(int idcontrato) {
        try {
            listarEntregas = contratoEntregaServiceImpl.getEntregasContrato(idcontrato);
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public void resetearNuevaEntrega() {
  
            contratoNuevaEntregaVO = new ContratoEntregaVO();
            contratoNuevaEntregaVO.setConId(contratoVO.getConId());
            RequestContext.getCurrentInstance().update("tab:frmNuevaEntregaDlg:pnlNuevaEntregaDlg");
            RequestContext.getCurrentInstance().update("tab:frmNuevaEntregaDlg:pnlNuevaEntregaBtnDlg");
            RequestContext.getCurrentInstance().execute("popupAgregarEntrega.show();");
        
    }

    public void agregarEntrega() {
            if(contratoNuevaEntregaVO.getCenNombre().equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                              "No ha ingresado el Nombre"));   
            } else if (contratoNuevaEntregaVO.getCenDescripcion().equals("")) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                              "No ha ingresado la Descripcion"));                    
            } else if (contratoNuevaEntregaVO.getCenFecha()==null) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                              "No ha seleccionado la Fecha"));                      
            }else if (contratoNuevaEntregaVO.getCenDocumentoFisico().equals("")) {
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                          "No ha seleccionado ningun documento"));             
            } 
            
            else {
            try {
            System.out.println("agregarEntrega: " + contratoNuevaEntregaVO.getConId());
            contratoNuevaEntregaVO.setCenFechaDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoNuevaEntregaVO.getCenFecha()));
            contratoNuevaEntregaVO.setCenMonto(1L);
            contratoNuevaEntregaVO.setMonId(1);
            contratoNuevaEntregaVO.setCenEstado(1);
            /*AUDITORIA*/
            Date fechaActual=new Date();
            contratoNuevaEntregaVO.setCenFechaAlta(fechaActual);
            contratoNuevaEntregaVO.setCenUsuarioAlta(usuario.getUsuAlias());
            contratoNuevaEntregaVO.setCenTerminal(usuario.getUsuTerminal());
                
            /*FIN AUDITORIA*/
            contratoEntregaServiceImpl.insert(contratoNuevaEntregaVO);
            listarEntregas.add(contratoNuevaEntregaVO);
            Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTAADENDAENTREGA+contratoNuevaEntregaVO.getCenDocumentoFisico(), contratoNuevaEntregaVO.getInputStreamNuevaEntrega());
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                          Constantes.GRABARMENSAJESATISFACTORIO));
            RequestContext.getCurrentInstance().execute("popupAgregarEntrega.hide();");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORGUARDAR));
        } finally {
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
        }
    }
    public void cargarEliminarEntrega(ActionEvent e){
      idEntregaEliminar=(ContratoEntregaVO) e.getComponent().getAttributes().get("entrega");
    }
    public void borrarEntrega() {
        try {
            idEntregaEliminar.setCenEstado(0);
            /*AUDITORIA*/
            Date fechaActual=new Date();
            idEntregaEliminar.setCenFechaBaja(fechaActual);
            idEntregaEliminar.setCenUsuarioBaja(usuario.getUsuAlias());
            idEntregaEliminar.setCenTerminal(usuario.getUsuTerminal());
            /*FIN AUDITORIA*/
            contratoEntregaServiceImpl.update(idEntregaEliminar);
            listarEntregas.remove(idEntregaEliminar);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                          Constantes.ELIMINARMENSAJESATISFACTORIO));
            RequestContext.getCurrentInstance().execute("dlgEliminarEntrega.hide();");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORBORRAR));
        } finally {
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
    }

    public void subirArchivoEntrega(FileUploadEvent event) throws IOException {
        contratoNuevaEntregaVO.setCenDocumentoFisico(event.getFile().getFileName());
        contratoNuevaEntregaVO.setInputStreamNuevaEntrega(event.getFile().getInputstream());

    }


    public void subirArchivoCao(FileUploadEvent event) throws IOException {
        //contratoCaoVO.setCaoPdf(event.getFile().getFileName());
        documentoCAO = event.getFile().getFileName();
        contratoCaoVO.setFileCao(event.getFile().getInputstream());
        System.out.println("documentoCAO: " + documentoCAO);

    }

    public void subirArchivoHito(FileUploadEvent event) throws IOException {
        //contratoCaoVO.setCaoPdf(event.getFile().getFileName());
        documentoHito = event.getFile().getFileName();
        getContratoHitoVO().setHtoPdf(documentoHito);
        getContratoHitoVO().setFileHito(event.getFile().getInputstream());
        System.out.println("documentoHito: " + documentoHito);

    }
    
    public void subirArchivoPpo(FileUploadEvent event) throws IOException {
        //contratoCaoVO.setCaoPdf(event.getFile().getFileName());
        documentoPpo = event.getFile().getFileName();
        getContratoPpoVO().setFilePpo(event.getFile().getInputstream());
        System.out.println("documentoPpo: " + documentoPpo);

    }

    public void preDownloadEntrega(String nombreArchivo) {
        try {
            downloadEntregas = Reutilizar.getNewInstance().preDownload(Constantes.RUTAADENDAENTREGA + nombreArchivo);
        } catch (FileNotFoundException fnfe) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                          Constantes.ARCHIVONOENCONTRADO));
        }
    }
    //*********************************************************************//
    //**************************Termina Contrato Entrega********************//
    //*********************************************************************//

    public void setListContratoAdenda(List<ContratoAdendaVO> listContratoAdenda) {
        this.listContratoAdenda = listContratoAdenda;
    }

    public List<ContratoAdendaVO> getListContratoAdenda() {
        return listContratoAdenda;
    }

    public void setContratoAdendaVO(ContratoAdendaVO contratoAdendaVO) {
        this.contratoAdendaVO = contratoAdendaVO;
    }

    public ContratoAdendaVO getContratoAdendaVO() {
        return contratoAdendaVO;
    }

    public void setAdendaTipoServiceImpl(AdendaTipoServiceImpl adendaTipoServiceImpl) {
        this.adendaTipoServiceImpl = adendaTipoServiceImpl;
    }

    public AdendaTipoServiceImpl getAdendaTipoServiceImpl() {
        return adendaTipoServiceImpl;
    }

    public void setContratoAdendaServiceImpl(ContratoAdendaServiceImpl contratoAdendaServiceImpl) {
        this.contratoAdendaServiceImpl = contratoAdendaServiceImpl;
    }

    public ContratoAdendaServiceImpl getContratoAdendaServiceImpl() {
        return contratoAdendaServiceImpl;
    }

    public void setListaAdendaTipo(List<AdendaTipoVO> listaAdendaTipo) {
        this.listaAdendaTipo = listaAdendaTipo;
    }

    public List<AdendaTipoVO> getListaAdendaTipo() {
        return listaAdendaTipo;
    }

    public void setAdendaTipo(Integer adendaTipo) {
        this.adendaTipo = adendaTipo;
    }

    public Integer getAdendaTipo() {
        return adendaTipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setContratoId(Integer contratoId) {
        this.contratoId = contratoId;
    }

    public Integer getContratoId() {
        return contratoId;
    }

    public void setAdendaId(Integer adendaId) {
        this.adendaId = adendaId;
    }

    public Integer getAdendaId() {
        return adendaId;
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

    public void setAplicaAvancedeObra(boolean aplicaAvancedeObra) {
        this.aplicaAvancedeObra = aplicaAvancedeObra;
    }

    public boolean isAplicaAvancedeObra() {
        return aplicaAvancedeObra;
    }

    public void setPeriodoseleccionado(int periodoseleccionado) {
        this.periodoseleccionado = periodoseleccionado;
    }

    public int getPeriodoseleccionado() {
        return periodoseleccionado;
    }

    public void setDiascalendario(boolean diascalendario) {
        this.diascalendario = diascalendario;
    }

    public boolean isDiascalendario() {
        return diascalendario;
    }

    public void setFileContrato(UploadedFile fileContrato) {
        this.fileContrato = fileContrato;
    }

    public UploadedFile getFileContrato() {
        return fileContrato;
    }

    public void setFileFicharesumen(UploadedFile fileFicharesumen) {
        this.fileFicharesumen = fileFicharesumen;
    }

    public UploadedFile getFileFicharesumen() {
        return fileFicharesumen;
    }

    public void setTipoInversionServicesImpl(TipoInversionServices tipoInversionServicesImpl) {
        this.tipoInversionServicesImpl = tipoInversionServicesImpl;
    }

    public TipoInversionServices getTipoInversionServicesImpl() {
        return tipoInversionServicesImpl;
    }

    public void setContratoEntregaServiceImpl(ContratoEntregaService contratoEntregaServiceImpl) {
        this.contratoEntregaServiceImpl = contratoEntregaServiceImpl;
    }

    public ContratoEntregaService getContratoEntregaServiceImpl() {
        return contratoEntregaServiceImpl;
    }

    public void setContratoCompromisoServiceImpl(ContratoCompromisoService contratoCompromisoServiceImpl) {
        this.contratoCompromisoServiceImpl = contratoCompromisoServiceImpl;
    }

    public ContratoCompromisoService getContratoCompromisoServiceImpl() {
        return contratoCompromisoServiceImpl;
    }

    public void setContratoEntregaVO(ContratoEntregaVO contratoEntregaVO) {
        this.contratoEntregaVO = contratoEntregaVO;
    }

    public ContratoEntregaVO getContratoEntregaVO() {
        return contratoEntregaVO;
    }


    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }

    public void setContratoCompromisoVO(ContratoCompromisoVO contratoCompromisoVO) {
        this.contratoCompromisoVO = contratoCompromisoVO;
    }

    public ContratoCompromisoVO getContratoCompromisoVO() {
        return contratoCompromisoVO;
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

    public void setListarAdendasTipo(List<AdendaTipoVO> listarAdendasTipo) {
        this.listarAdendasTipo = listarAdendasTipo;
    }

    public List<AdendaTipoVO> getListarAdendasTipo() {
        return listarAdendasTipo;
    }


    public void setTipoArchivoEnContratoConcesion(int tipoArchivoEnContratoConcesion) {
        this.tipoArchivoEnContratoConcesion = tipoArchivoEnContratoConcesion;
    }

    public int getTipoArchivoEnContratoConcesion() {
        return tipoArchivoEnContratoConcesion;
    }

    public void setDownloadAdendas(DefaultStreamedContent downloadAdendas) {
        this.downloadAdendas = downloadAdendas;
    }

    public DefaultStreamedContent getDownloadAdendas() {
        return downloadAdendas;
    }


    public void setDownloadEntregas(DefaultStreamedContent downloadEntregas) {
        this.downloadEntregas = downloadEntregas;
    }

    public DefaultStreamedContent getDownloadEntregas() {
        return downloadEntregas;
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


    // Metodo Para Listar Infraestructuras

    public void cargarInfraestructurasContrato(Integer contratoId) {
        try {

            listaInfraestructura = infraestructuraServiceImpl.getInfraestructurasContrato(contratoId);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
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

    public String getDescInversion() {
        return descInversion;
    }

    public void setDescInversion(String descInversion) {
        this.descInversion = descInversion;
    }

    public void guardarContratoInversion() {
        if (infraestructuraId == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha seleccionado la Infraestructura")); 
        } else if (descInversion.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Inversi�n"));
        } else {
            try {

                contratoInversionVO.setConId(contratoVO.getConId());
                contratoInversionVO.setCsiId(contratoVO.getCsiId());
                contratoInversionVO.setTinId(contratoVO.getTinId());
                contratoInversionVO.setInfId(infraestructuraId);
                contratoInversionVO.setInvDescripcion(descInversion);
                contratoInversionVO.setInvEstado(1);
                /*AUDITORIA*/
                Date fechaActual=new Date();
                contratoInversionVO.setInvFechaAlta(fechaActual);
                contratoInversionVO.setInvUsuarioAlta(usuario.getUsuAlias());
                contratoInversionVO.setInvTerminal(usuario.getUsuTerminal());
                /*FIN AUDITORIA*/
                contratoInversionServiceImpl.insert(contratoInversionVO);

                cargarListaInversiones(contratoVO.getConId());
                limpiarCamposInversion();
                RequestContext.getCurrentInstance().execute("popupAgregarInversion.hide()");

            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar la Inversion "));

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar la Inversion "));
            }

        }
    }
    public void limpiarCamposInversion(){
        infraestructuraId = 0;
        descInversion = null;
    }

    public ContratoInversionVO getContratoInversionVO() {
        return contratoInversionVO;
    }

    public void setContratoInversionVO(ContratoInversionVO contratoInversionVO) {
        this.contratoInversionVO = contratoInversionVO;
    }

    public ContratoInversionServiceImpl getContratoInversionServiceImpl() {
        return contratoInversionServiceImpl;
    }

    public void setContratoInversionServiceImpl(ContratoInversionServiceImpl contratoInversionServiceImpl) {
        this.contratoInversionServiceImpl = contratoInversionServiceImpl;
    }

    public List<ContratoInversionVO> getListContratoInversion() {
        return listContratoInversion;
    }

    public void setListContratoInversion(List<ContratoInversionVO> listContratoInversion) {
        this.listContratoInversion = listContratoInversion;
    }

    public void cargarListaInversiones(int idcontrato) {
        try {
            System.out.println("idcontrato: " + idcontrato);
            listContratoInversion = contratoInversionServiceImpl.getInversionesContrato(idcontrato);
            for (ContratoInversionVO contratoInversionVO : listContratoInversion) {
                for (InfraestructuraVO aux : listaInfraestructura) {
                    if (aux.getInfId() == contratoInversionVO.getInfId()) {
                        contratoInversionVO.setInfNombre(aux.getInfNombre());
                    }
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public List<InfraestructuraVO> getListarInfraestructura() {
        return listarInfraestructura;
    }

    public void setListarInfraestructura(List<InfraestructuraVO> listarInfraestructura) {
        this.listarInfraestructura = listarInfraestructura;
    }

    public String getNombAeropuerto() {
        return nombAeropuerto;
    }

    public void setNombAeropuerto(String nombAeropuerto) {
        this.nombAeropuerto = nombAeropuerto;
    }

    public String getDescAlerta() {
        return descAlerta;
    }

    public void setDescAlerta(String descAlerta) {
        this.descAlerta = descAlerta;
    }

    public Date getFechaIniAlerta() {
        return fechaIniAlerta;
    }

    public void setFechaIniAlerta(Date fechaIniAlerta) {
        this.fechaIniAlerta = fechaIniAlerta;
    }

    public Date getFechaFinAlerta() {
        return fechaFinAlerta;
    }

    public void setFechaFinAlerta(Date fechaFinAlerta) {
        this.fechaFinAlerta = fechaFinAlerta;
    }

    public Integer getDiaPresAlerta() {
        return diaPresAlerta;
    }

    public void setDiaPresAlerta(Integer diaPresAlerta) {
        this.diaPresAlerta = diaPresAlerta;
    }

    public void guardarAlerta() {

        if (nombAeropuerto.equals("")) {
            System.out.print("nombAeropuerto" + nombAeropuerto);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Aeropuerto")); 
        } else if (descAlerta.equals("")) {
            System.out.print("descAlerta" + descAlerta);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Descripci�n")); 
        } else if (fechaIniAlerta == null) {
            System.out.print("fechaIniAlerta: " + fechaIniAlerta);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Fecha de Inicio"));
        } else if (fechaFinAlerta == null) {
            System.out.print("fechaFinAlerta" + fechaFinAlerta);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Fecha Final"));            
        } else if (plazoAlerta.equals("")) {
            System.out.print("plazoAlerta: " + plazoAlerta);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Plazo"));  
        } else if (diaPresAlerta == null || diaPresAlerta < 1) {
            System.out.print("diaPresAlerta: " + diaPresAlerta);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Dia de Presentaci�n")); 
        } else {
            try {
                System.out.print("diaPresAlerta: " + diaPresAlerta);
                contratoAlertaVO.setConId(contratoVO.getConId());
                contratoAlertaVO.setCaeId(1); // valor inicial de la Alerta relacionado a la tabla EstadoAlerta
                contratoAlertaVO.setPerId(1); // para el cas ode aerupuerto se setea 1 por default y no se muestra para otros casos revisar tabla Periodo
                contratoAlertaVO.setCalAeropuerto(nombAeropuerto);
                contratoAlertaVO.setCalDiaPresentacion(diaPresAlerta);
                contratoAlertaVO.setCalEstado(1);
                contratoAlertaVO.setCalPlazo(plazoAlerta);
                contratoAlertaVO.setCalFechaInicio(fechaIniAlerta);
                contratoAlertaVO.setCalFechaFin(fechaFinAlerta);
                contratoAlertaVO.setCalNombreconcesion(descAlerta);
                /*AUDITORIA*/
                Date fechaActual=new Date();
                contratoAlertaVO.setCalFechaAlta(fechaActual);
                contratoAlertaVO.setCalUsuarioAlta(usuario.getUsuAlias());
                contratoAlertaVO.setCalTerminal(usuario.getUsuTerminal());
                /*FIN AUDITORIA*/
                contratoAlertaServiceImpl.insert(contratoAlertaVO);

                cargarListaAlertas(contratoVO.getConId());
                limpiarCamposAlerta();
                RequestContext.getCurrentInstance().execute("popupAgregarAlerta.hide()");

            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar la Alerta "));

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar la Alerta "));
            }

        }
    }
    public void limpiarCamposAlerta(){
        nombAeropuerto = null;
        diaPresAlerta = null;
        plazoAlerta = null;
        fechaIniAlerta = null;
        fechaFinAlerta = null;
        descAlerta = null;
        
    }

    public String getPlazoAlerta() {
        return plazoAlerta;
    }

    public void setPlazoAlerta(String plazoAlerta) {
        this.plazoAlerta = plazoAlerta;
    }

    public ContratoAlertaServiceImpl getContratoAlertaServiceImpl() {
        return contratoAlertaServiceImpl;
    }

    public void setContratoAlertaServiceImpl(ContratoAlertaServiceImpl contratoAlertaServiceImpl) {
        this.contratoAlertaServiceImpl = contratoAlertaServiceImpl;
    }

    public List<ContratoAlertaVO> getListContratoAlerta() {
        return listContratoAlerta;
    }

    public void setListContratoAlerta(List<ContratoAlertaVO> listContratoAlerta) {
        this.listContratoAlerta = listContratoAlerta;
    }

    public ContratoAlertaVO getContratoAlertaVO() {
        return contratoAlertaVO;
    }

    public void setContratoAlertaVO(ContratoAlertaVO contratoAlertaVO) {
        this.contratoAlertaVO = contratoAlertaVO;
    }

    public void cargarListaCaos(int idcontrato) {
        try {
            System.out.println("idcontrato: " + idcontrato);
            setListContratoCaoVO(contratoCaoServiceImpl.getCaosContrato(idcontrato));
            for (ContratoCaoVO contratoCaoVO : getListContratoCaoVO()) {
                for (MonedaVO aux : listarTipoMonedas) {
                    if (aux.getMonId() == contratoCaoVO.getMonId()) {
                        contratoCaoVO.setMonNombre(aux.getMonNombre());
                    }
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
    
    public void cargarListaHitos(int idcontrato) {
        try {
            System.out.println("idcontrato: " + idcontrato);
            setListContratoHitoVO(getContratoHitoServiceImpl().getHitosContrato(idcontrato));
            for (ContratoHitoVO contratoHitoVO : getListContratoHitoVO()) {
                for (MonedaVO aux : listarTipoMonedas) {
                    if (aux.getMonId() == contratoHitoVO.getMonId()) {
                        contratoHitoVO.setMonNombre(aux.getMonNombre());
                    }
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
    
    
    public void cargarListaPpos(int idcontrato) {
            try {
                System.out.println("idcontrato: " + idcontrato);
            setListContratoPpoVO(getContratoPpoServiceImpl().getPposContrato(idcontrato));
                for (ContratoPpoVO contratoPpoVO : getListContratoPpoVO()) {
                    for (MonedaVO aux : listarTipoMonedas) {
                        if (aux.getMonId() == contratoPpoVO.getMonId()) {
                            contratoPpoVO.setMonNombre(aux.getMonNombre());
                        }
                    }
                }
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }

    public void cargarListaAlertas(int idcontrato) {
        try {
            System.out.println("idcontrato: " + idcontrato);
            listContratoAlerta = contratoAlertaServiceImpl.getAlertasContrato(idcontrato);
            listarEstadosAlerta();
            for (ContratoAlertaVO contratoAlertaVO : listContratoAlerta) {
                for(ContratoAlertaEstadoVO aux : listContratoAlertaEstado){
                    if(aux.getCaeId() == contratoAlertaVO.getCaeId()){
                        contratoAlertaVO.setCaeNombre(aux.getCaeNombre());
                    }
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public String getNombreAlerta() {
        return nombreAlerta;
    }

    public void setNombreAlerta(String nombreAlerta) {
        this.nombreAlerta = nombreAlerta;
    }

    public Integer getCodigoAlerta() {
        return codigoAlerta;
    }

    public void setCodigoAlerta(Integer codigoAlerta) {
        this.codigoAlerta = codigoAlerta;
    }

    public void activarAlerta(ActionEvent event) throws SQLException {
        int codigo = (Integer) event.getComponent().getAttributes().get("codigoAlerta");
        contratoAlertaVO = contratoAlertaServiceImpl.get(codigo);
        contratoAlertaVO.setCalEstado(1);
        contratoAlertaServiceImpl.update(contratoAlertaVO);

        cargarListaAlertas(contratoVO.getConId());
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Activo la Alerta");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void desactivarAlerta(ActionEvent event) throws SQLException {
        int codigo = (Integer) event.getComponent().getAttributes().get("codigoAlertaD");
        contratoAlertaVO = contratoAlertaServiceImpl.get(codigo);
        contratoAlertaVO.setCalEstado(2);
        contratoAlertaServiceImpl.update(contratoAlertaVO);

        cargarListaAlertas(contratoVO.getConId());
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Activo la Alerta");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminarAlerta(ActionEvent event) throws SQLException {
        int codigo = (Integer) event.getComponent().getAttributes().get("codigoAlertaE");
        contratoAlertaVO = contratoAlertaServiceImpl.get(codigo);
        contratoAlertaVO.setCalEstado(0);
        /*AUDITORIA*/
        Date fechaActual=new Date();
        contratoAlertaVO.setCalFechaBaja(fechaActual);
        contratoAlertaVO.setCalUsuarioBaja(usuario.getUsuAlias());
        contratoAlertaVO.setCalTerminal(usuario.getUsuTerminal());
        /*FIN AUDITORIA*/
        contratoAlertaServiceImpl.update(contratoAlertaVO);

        cargarListaAlertas(contratoVO.getConId());

        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Activo la Alerta");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminarInversion(ActionEvent event) throws SQLException {
        System.out.println("### INICIO ELIMINAR INVERSION");
        int codigo = (Integer) event.getComponent().getAttributes().get("codigoInversionE");
        contratoInversionVO = contratoInversionServiceImpl.get(codigo);
        contratoInversionVO.setInvEstado(0);
        /*AUDITORIA*/
        Date fechaActual=new Date();
        contratoInversionVO.setInvFechaBaja(fechaActual);
        contratoInversionVO.setInvUsuarioBaja(usuario.getUsuAlias());
        contratoInversionVO.setInvTerminal(usuario.getUsuTerminal());
        /*FIN AUDITORIA*/
        contratoInversionServiceImpl.update(contratoInversionVO);
        System.out.println("### FIN ELIMINAR INVERSION");
        cargarListaInversiones(contratoVO.getConId());
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Elimino la Inversion");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminarCao(ActionEvent event) throws SQLException {
        System.out.println("### INICIO ELIMINAR CAO");
        int codigo = (Integer) event.getComponent().getAttributes().get("codigoCaoE");
        contratoCaoVO = contratoCaoServiceImpl.get(codigo);
        contratoCaoVO.setCaoEstado(0);
        /*AUDITORIA*/
        Date fechaActual=new Date();
        contratoCaoVO.setCaoFechaBaja(fechaActual);
        contratoCaoVO.setCaoUsuarioBaja(usuario.getUsuAlias());
        contratoCaoVO.setCaoTerminal(usuario.getUsuTerminal());
        /*FIN AUDITORIA*/
        contratoCaoServiceImpl.update(contratoCaoVO);
        System.out.println("### FIN ELIMINAR CAO");
        cargarListaCaos(contratoVO.getConId());
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Elimino El Registro");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminarHito(ActionEvent event) throws SQLException {
        System.out.println("### INICIO ELIMINAR HITO");
        int codigo = (Integer) event.getComponent().getAttributes().get("codigoHitoE");
        setContratoHitoVO(getContratoHitoServiceImpl().get(codigo));
        getContratoHitoVO().setHtoEstado(0);
        /*AUDITORIA*/
        Date fechaActual=new Date();
        contratoHitoVO.setHtoFechaBaja(fechaActual);
        contratoHitoVO.setHtoUsuarioBaja(usuario.getUsuAlias());
        contratoHitoVO.setHtoTerminal(usuario.getUsuTerminal());
        /*FIN AUDITORIA*/
        getContratoHitoServiceImpl().update(getContratoHitoVO());
        System.out.println("### FIN ELIMINAR HITO");
        cargarListaHitos(getContratoHitoVO().getConId());
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Elimino El Registro");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminarPpo(ActionEvent event) throws SQLException {
        System.out.println("### INICIO ELIMINAR PPO");        
        int codigo = (Integer) event.getComponent().getAttributes().get("codigoPpoE");
        System.out.println("codigo: " + codigo);
        setContratoPpoVO(getContratoPpoServiceImpl().get(codigo));
        getContratoPpoVO().setPpoEstado(0);
        /*AUDITORIA*/
        Date fechaActual=new Date();
        contratoPpoVO.setPpoFechaBaja(fechaActual);
        contratoPpoVO.setPpoUsuarioBaja(usuario.getUsuAlias());
        contratoPpoVO.setPpoTerminal(usuario.getUsuTerminal());
        /*FIN AUDITORIA*/
        getContratoPpoServiceImpl().update(getContratoPpoVO());
        System.out.println("### FIN ELIMINAR PPO");
        cargarListaPpos(getContratoPpoVO().getConId());
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Elimino El Registro");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarActivarAlerta() throws SQLException {

        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idContratoAlerta");
        Integer idcodigo = Integer.valueOf(str.toString());
        contratoAlertaVO = contratoAlertaServiceImpl.get(idcodigo);
        //fin de de captura de codigo a modificar
        codigoAlerta = contratoAlertaVO.getCalId();
        nombreAlerta = contratoAlertaVO.getCalAeropuerto();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Activo con Exito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);


    }

    public void cargarDesactivarAlerta() throws SQLException {

        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idContratoAlertaD");
        Integer idcodigo = Integer.valueOf(str.toString());
        contratoAlertaVO = contratoAlertaServiceImpl.get(idcodigo);
        //fin de de captura de codigo a modificar
        codigoAlerta = contratoAlertaVO.getCalId();
        nombreAlerta = contratoAlertaVO.getCalAeropuerto();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Desactivo con Exito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarEliminarAlerta() throws SQLException {

        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idContratoAlertaE");
        Integer idcodigo = Integer.valueOf(str.toString());
        contratoAlertaVO = contratoAlertaServiceImpl.get(idcodigo);
        //fin de de captura de codigo a modificar
        codigoAlerta = contratoAlertaVO.getCalId();
        nombreAlerta = contratoAlertaVO.getCalAeropuerto();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Elimino con Exito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);


    }


    public void cargarEliminarInversion() throws SQLException {

        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idContratoInversionE");
        Integer idcodigo = Integer.valueOf(str.toString());
        contratoInversionVO = contratoInversionServiceImpl.get(idcodigo);
        //fin de de captura de codigo a modificar
        codigoInversion = contratoInversionVO.getInvId();
        nombreInversion = contratoInversionVO.getInvDescripcion();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Elimino con Exito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);


    }

    public void cargarEliminarCao() throws SQLException {

        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idContratoCaoE");
        Integer idcodigo = Integer.valueOf(str.toString());
        contratoCaoVO = contratoCaoServiceImpl.get(idcodigo);
        //fin de de captura de codigo a modificar
        codigoCao = contratoCaoVO.getCaoId();
        nombreCao2 = contratoCaoVO.getCaoNombre();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Elimino con Exito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);


    }
    
    public void cargarEliminarHito() throws SQLException {

        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idContratoHitoE");
        Integer idcodigo = Integer.valueOf(str.toString());
        setContratoHitoVO(getContratoHitoServiceImpl().get(idcodigo));
        //fin de de captura de codigo a modificar
        codigoHito = getContratoHitoVO().getHtoId();
        nombreHito2 = getContratoHitoVO().getHtoNombre();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Elimino con Exito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void cargarModificarHito() throws SQLException {

        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idContratoHitoM");
        Integer idcodigo = Integer.valueOf(str.toString());
        setContratoHitoVO(getContratoHitoServiceImpl().get(idcodigo));            
    }
    
    public void cargarEliminarPpo() throws SQLException {

        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idContratoPpoE");
        Integer idcodigo = Integer.valueOf(str.toString());
        setContratoPpoVO(getContratoPpoServiceImpl().get(idcodigo));
        //fin de de captura de codigo a modificar
        codigoPpo = getContratoPpoVO().getPpoId();
        nombrePpo2 = getContratoPpoVO().getPpoNombre();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se Elimino con Exito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public String getNombreInversion() {
        return nombreInversion;
    }

    public void setNombreInversion(String nombreInversion) {
        this.nombreInversion = nombreInversion;
    }

    public Integer getCodigoInversion() {
        return codigoInversion;
    }

    public void setCodigoInversion(Integer codigoInversion) {
        this.codigoInversion = codigoInversion;
    }

    public void setContratoNuevaAdendaVO(ContratoAdendaVO contratoNuevaAdendaVO) {
        this.contratoNuevaAdendaVO = contratoNuevaAdendaVO;
    }

    public ContratoAdendaVO getContratoNuevaAdendaVO() {
        return contratoNuevaAdendaVO;
    }

    public void setListarEntregas(List<ContratoEntregaVO> listarEntregas) {
        this.listarEntregas = listarEntregas;
    }

    public List<ContratoEntregaVO> getListarEntregas() {
        return listarEntregas;
    }


    public void setContratoNuevaEntregaVO(ContratoEntregaVO contratoNuevaEntregaVO) {
        this.contratoNuevaEntregaVO = contratoNuevaEntregaVO;
    }

    public ContratoEntregaVO getContratoNuevaEntregaVO() {
        return contratoNuevaEntregaVO;
    }

    public void setListarTipoMonedas(List<MonedaVO> listarTipoMonedas) {
        this.listarTipoMonedas = listarTipoMonedas;
    }

    public List<MonedaVO> getListarTipoMonedas() {
        return listarTipoMonedas;
    }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

    public String getNombreCAO() {
        return nombreCAO;
    }

    public void setNombreCAO(String nombreCAO) {
        this.nombreCAO = nombreCAO;
    }

    public Integer getCodigoCAO() {
        return codigoCAO;
    }

    public void setCodigoCAO(Integer codigoCAO) {
        this.codigoCAO = codigoCAO;
    }

    public Date getFechaCAO() {
        return fechaCAO;
    }

    public void setFechaCAO(Date fechaCAO) {
        this.fechaCAO = fechaCAO;
    }


    public BigDecimal getMontoCAO() {
        return montoCAO;
    }

    public void setMontoCAO(BigDecimal montoCAO) {
        this.montoCAO = montoCAO;
    }

    public String getDocumentoCAO() {
        return documentoCAO;
    }

    public void setDocumentoCAO(String documentoCAO) {
        this.documentoCAO = documentoCAO;
    }

    public Integer getMonedaCAOId() {
        return monedaCAOId;
    }

    public void setMonedaCAOId(Integer monedaCAOId) {
        this.monedaCAOId = monedaCAOId;
    }

    public void guardarCAO() {
        System.out.println("############# INI GUARDAR CAO");
        
        if(nombreCAO.equals("")){
                System.out.println("nombreCAO: " + nombreCAO);
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                              "No ha ingresado la Inversi�n"));  
        } else if (fechaCAO == null) {
            System.out.println("fechaCAO: " + fechaCAO);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Fecha")); 
        } else if (montoCAO == null) {
            System.out.println("montoCAO: " + montoCAO);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Monto")); 
        } else if(monedaCAOId == 0) {
            System.out.println("monedaCAOId: " + monedaCAOId);
            
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No se ha seleccionado la Moneda")); 
        } else if (documentoCAO.equals("")) {
            System.out.println("documentoCAO: " + documentoCAO);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Documento")); 
        } else {
            try {
                //Date date = new Date();
                //DateFormat fechaHora = new SimpleDateFormat("yyyyMMdd_HHmmss");
                //String convertido = fechaHora.format(date);
                //documentoCAO = "DOCUMENT_CAO_" + convertido;

                Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTACAO + documentoCAO,
                                                                    contratoCaoVO.getFileCao());

                contratoCaoVO.setConId(contratoVO.getConId());
                System.out.println("contratoVO.getConId(): " + contratoVO.getConId());
                contratoCaoVO.setCaoEstado(1);
                contratoCaoVO.setCaoMonto(montoCAO);
                System.out.println("montoCAO:" + montoCAO);
                contratoCaoVO.setMonId(monedaCAOId);
                System.out.println("monedaCAOId: " + monedaCAOId);
                contratoCaoVO.setCaoFecha(fechaCAO);
                System.out.println("fechaCAO: " + fechaCAO);
                contratoCaoVO.setCaoNombre(nombreCAO);
                System.out.println("nombreCAO:" + nombreCAO);
                contratoCaoVO.setCaoPdf(documentoCAO);
                System.out.println("documentoCAO:" + documentoCAO);
                /*AUDITORIA*/
                Date fechaActual=new Date();
                contratoCaoVO.setCaoFechaAlta(fechaActual);
                contratoCaoVO.setCaoUsuarioAlta(usuario.getUsuAlias());
                contratoCaoVO.setCaoTerminal(usuario.getUsuTerminal());
                /*FIN AUDITORIA*/
                contratoCaoServiceImpl.insert(contratoCaoVO);
                System.out.println("guardo ok");

                cargarListaCaos(contratoVO.getConId());
                limpiarCamposCao();
                RequestContext.getCurrentInstance().execute("popupAgregarCAO.hide()");

            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar el CAO "));
                s.printStackTrace();
                System.out.println("ERROR SQLE: " + s.getMessage());
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar el CAO "));
                e.printStackTrace();
                System.out.println("ERROR E: " + e.getMessage());
            }
            System.out.println("############# FIN GUARDAR CAO");

        }
    }
    
    public void limpiarCamposCao(){
        monedaCAOId = 0;
        fechaCAO = null;        
        montoCAO = null;
        documentoCAO = null;
        nombreCAO = null;
    }
    
    public void guardarPpo() {
            System.out.println("############# INI GUARDAR Ppo");
            if(nombrePpo.equals("")){
                System.out.println("nombrePpo: " + nombrePpo);
                FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                  "No ha ingresado el Aeropuerto"));
            } else if (fechaPpo == null) {
                System.out.println("fechaPpo: " + fechaPpo);
                FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                  "No ha ingresado la Fecha"));
            } else if (montoPpo == null) {
                System.out.println("montoPpo: " + montoPpo);
                FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                  "No ha ingresado el Monto"));
            }else if(monedaPpoId == 0) {
                System.out.println("monedaPpoId: " + monedaPpoId);
                FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                  "No ha seleccionado la Moneda"));
            } else if (documentoPpo.equals("")) {
                System.out.println("documentoPpo: " + documentoPpo);
                FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                  "No ha ingresado el Docuemento"));
            } else {
                try {
                    //Date date = new Date();
                    //DateFormat fechaHora = new SimpleDateFormat("yyyyMMdd_HHmmss");
                    //String convertido = fechaHora.format(date);
                    //documentoCAO = "DOCUMENT_CAO_" + convertido;

                    Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTAPPO + documentoPpo,
                                                                    getContratoPpoVO().getFilePpo());

                getContratoPpoVO().setConId(contratoVO.getConId());
                    System.out.println("contratoVO.getConId(): " + contratoVO.getConId());
                getContratoPpoVO().setPpoEstado(1);
                getContratoPpoVO().setPpoMonto(montoPpo);
                    System.out.println("montoPpo:" + montoPpo);
                getContratoPpoVO().setMonId(monedaPpoId);
                    System.out.println("monedaPpoId: " + monedaPpoId);
                getContratoPpoVO().setPpoFecha(fechaPpo);
                    System.out.println("fechaPpo: " + fechaPpo);
                getContratoPpoVO().setPpoNombre(nombrePpo);
                    System.out.println("nombrePpo:" + nombrePpo);
                getContratoPpoVO().setPpoArchivoPdf(documentoPpo);
                    System.out.println("documentoPpo:" + documentoPpo);
                    /*AUDITORIA*/
                    Date fechaActual=new Date();
                    contratoPpoVO.setPpoFechaAlta(fechaActual);
                    contratoPpoVO.setPpoUsuarioAlta(usuario.getUsuAlias());
                    contratoPpoVO.setPpoTerminal(usuario.getUsuTerminal());
                    /*FIN AUDITORIA*/
                getContratoPpoServiceImpl().insert(getContratoPpoVO());
                    System.out.println("guardo ok");

                    cargarListaPpos(contratoVO.getConId());
                    limpiarCamposPpo();
                    RequestContext.getCurrentInstance().execute("popupAgregarPPO.hide()");

                } catch (SQLException s) {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                  " No se pudo registrar el PPO "));
                    s.printStackTrace();
                    System.out.println("ERROR SQLE: " + s.getMessage());
                } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                  " No se pudo registrar el PPO "));
                    e.printStackTrace();
                    System.out.println("ERROR E: " + e.getMessage());
                }
                System.out.println("############# FIN GUARDAR CAO");

            }
        }
    
    public void limpiarCamposPpo(){
        montoPpo = null;
        monedaPpoId = 0;
        fechaPpo = null;       
        nombrePpo = null;
        documentoPpo = null;
    }
    public void guardarHito() {
        System.out.println("############# INI GUARDAR HITO");
        if(nombreHito.equals("")){
            System.out.println("nombreHito: " + nombreHito);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Aeropuerto"));   
        } else if (fechaHito == null) {
            System.out.println("fechaHito: " + fechaHito);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Fecha"));                    
        } else if (montoHito == null) {
            System.out.println("montoHito: " + montoHito);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Monto"));                      
        }else if (monedaHitoId == 0) {
            System.out.println("monedaHitoId: " + monedaHitoId);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha selecionado la Moneda"));        
        } else if (documentoHito.equals("")) {
            System.out.println("documentoHito: " + documentoHito);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Documento"));             
        } else {
            try {
                //Date date = new Date();
                //DateFormat fechaHora = new SimpleDateFormat("yyyyMMdd_HHmmss");
                //String convertido = fechaHora.format(date);
                //documentoCAO = "DOCUMENT_CAO_" + convertido;

                Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTAHITO + documentoHito,
                                                                    getContratoHitoVO().getFileHito());

                contratoHitoVO.setConId(contratoVO.getConId());
                System.out.println("contratoVO.getConId(): " + contratoVO.getConId());
                contratoHitoVO.setHtoEstado(1);
                contratoHitoVO.setHtoMonto(montoHito);
                System.out.println("montoHito:" + montoHito);
                contratoHitoVO.setMonId(monedaHitoId);
                System.out.println("monedaHitoId: " + monedaHitoId);
                contratoHitoVO.setHtoFecha(fechaHito);
                System.out.println("fechaHito: " + fechaHito);
             
                contratoHitoVO.setHtoNombre(nombreHito);
                System.out.println("nombreHito:" + nombreHito);
                contratoHitoVO.setHtoPdf(documentoHito);
                System.out.println("documentoHito:" + documentoHito);
                /*AUDITORIA*/
                Date fechaActual=new Date();
                contratoHitoVO.setHtoFechaAlta(fechaActual);
                contratoHitoVO.setHtoUsuarioAlta(usuario.getUsuAlias());
                contratoHitoVO.setHtoTerminal(usuario.getUsuTerminal());
                /*FIN AUDITORIA*/
                contratoHitoServiceImpl.insert(contratoHitoVO);
                System.out.println("guardo ok");

                cargarListaHitos(contratoVO.getConId());
                limpiarCamposHito();
                RequestContext.getCurrentInstance().execute("popupAgregarHito.hide()");

            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar el Hito "));
                s.printStackTrace();
                System.out.println("ERROR SQLE: " + s.getMessage());
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar el Hito "));
                e.printStackTrace();
                System.out.println("ERROR E: " + e.getMessage());
            }
            System.out.println("############# FIN GUARDAR CAO");

        }
    }
    
    
    
    public void actualizarHito() {
        System.out.println("############# INI ACTUALIZAR HITO");
        if(contratoHitoVO.getHtoNombre().equals("")){
            System.out.println("nombreHito: " + contratoHitoVO.getHtoNombre());
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Aeropuerto"));   
        } else if (contratoHitoVO.getHtoFecha() == null) {
            System.out.println("fechaHito: " + contratoHitoVO.getHtoFecha());
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado la Fecha"));                    
        } else if (contratoHitoVO.getHtoMonto() == null) {
            System.out.println("montoHito: " + contratoHitoVO.getHtoMonto());
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Monto"));                      
        }else if (contratoHitoVO.getMonId() == 0) {
            System.out.println("monedaHitoId: " + contratoHitoVO.getMonId());
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha selecionado la Moneda"));        
        } else if (contratoHitoVO.getHtoPdf().equals("")) {
            System.out.println("documentoHito: " + contratoHitoVO.getHtoPdf());
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Documento"));             
        } else {
            try {
                //Date date = new Date();
                //DateFormat fechaHora = new SimpleDateFormat("yyyyMMdd_HHmmss");
                //String convertido = fechaHora.format(date);
                //documentoCAO = "DOCUMENT_CAO_" + convertido;
                if (getContratoHitoVO().getFileHito() != null){
                    Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTAHITO + contratoHitoVO.getHtoPdf(),
                                                                    getContratoHitoVO().getFileHito());
                }
                
                System.out.println("guardo ok");
                /*AUDITORIA*/
                Date fechaActual=new Date();
                contratoHitoVO.setHtoFechaCambio(fechaActual);
                contratoHitoVO.setHtoUsuarioCambio(usuario.getUsuAlias());
                contratoHitoVO.setHtoTerminal(usuario.getUsuTerminal());
                /*FIN AUDITORIA*/
                getContratoHitoServiceImpl().update(getContratoHitoVO());
                cargarListaHitos(contratoVO.getConId());
                //limpiarCamposHito2();
                RequestContext.getCurrentInstance().execute("popupModificarHito.hide()");

            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar el Hito "));
                s.printStackTrace();
                System.out.println("ERROR SQLE: " + s.getMessage());
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar el Hito "));
                e.printStackTrace();
                System.out.println("ERROR E: " + e.getMessage());
            }
            System.out.println("############# FIN ACTUALIZAT HITO");

        }
    }

    public ContratoCaoServiceImpl getContratoCaoServiceImpl() {
        return contratoCaoServiceImpl;
    }

    public void setContratoCaoServiceImpl(ContratoCaoServiceImpl contratoCaoServiceImpl) {
        this.contratoCaoServiceImpl = contratoCaoServiceImpl;
    }

    public ContratoCaoVO getContratoCaoVO() {
        return contratoCaoVO;
    }

    public void setContratoCaoVO(ContratoCaoVO contratoCaoVO) {
        this.contratoCaoVO = contratoCaoVO;
    }

    public List<ContratoCaoVO> getListContratoCaoVO() {
        return listContratoCaoVO;
    }

    public void setListContratoCaoVO(List<ContratoCaoVO> listContratoCaoVO) {
        this.listContratoCaoVO = listContratoCaoVO;
    }

    public Integer getCodigoCao() {
        return codigoCao;
    }

    public void setCodigoCao(Integer codigoCao) {
        this.codigoCao = codigoCao;
    }


    public String getNombreCao2() {
        return nombreCao2;
    }

    public void setNombreCao2(String nombreCao2) {
        this.nombreCao2 = nombreCao2;
    }

    public DefaultStreamedContent getDownloadCao() {
        return downloadCao;
    }

    public void setDownloadCao(DefaultStreamedContent downloadCao) {
        this.downloadCao = downloadCao;
    }

    public String getNombreHito() {
        return nombreHito;
    }

    public void setNombreHito(String nombreHito) {
        this.nombreHito = nombreHito;
    }

    public Integer getCodigoHito() {
        return codigoHito;
    }

    public void setCodigoHito(Integer codigoHito) {
        this.codigoHito = codigoHito;
    }

    public Date getFechaHito() {
        return fechaHito;
    }

    public void setFechaHito(Date fechaHito) {
        this.fechaHito = fechaHito;
    }



    public BigDecimal getMontoHito() {
        return montoHito;
    }

    public void setMontoHito(BigDecimal montoHito) {
        this.montoHito = montoHito;
    }

    public String getDocumentoHito() {
        return documentoHito;
    }

    public void setDocumentoHito(String documentoHito) {
        this.documentoHito = documentoHito;
    }

    public Integer getMonedaHitoId() {
        return monedaHitoId;
    }

    public void setMonedaHitoId(Integer monedaHitoId) {
        this.monedaHitoId = monedaHitoId;
    }

    public String getNombreHito2() {
        return nombreHito2;
    }

    public void setNombreHito2(String nombreHito2) {
        this.nombreHito2 = nombreHito2;
    }

    public Integer getCodigoHito2() {
        return codigoHito2;
    }

    public void setCodigoHito2(Integer codigoHito2) {
        this.codigoHito2 = codigoHito2;
    }

    public String getNombrePpo() {
        return nombrePpo;
    }

    public void setNombrePpo(String nombrePpo) {
        this.nombrePpo = nombrePpo;
    }

    public Integer getCodigoPpo() {
        return codigoPpo;
    }

    public void setCodigoPpo(Integer codigoPpo) {
        this.codigoPpo = codigoPpo;
    }

    public Date getFechaPpo() {
        return fechaPpo;
    }

    public void setFechaPpo(Date fechaPpo) {
        this.fechaPpo = fechaPpo;
    }


    public BigDecimal getMontoPpo() {
        return montoPpo;
    }

    public void setMontoPpo(BigDecimal montoPpo) {
        this.montoPpo = montoPpo;
    }

    public String getDocumentoPpo() {
        return documentoPpo;
    }

    public void setDocumentoPpo(String documentoPpo) {
        this.documentoPpo = documentoPpo;
    }

    public Integer getMonedaPpoId() {
        return monedaPpoId;
    }

    public void setMonedaPpoId(Integer monedaPpoId) {
        this.monedaPpoId = monedaPpoId;
    }

    public Integer getCodigoPpo2() {
        return codigoPpo2;
    }

    public void setCodigoPpo2(Integer codigoPpo2) {
        this.codigoPpo2 = codigoPpo2;
    }

    public String getNombrePpo2() {
        return nombrePpo2;
    }

    public void setNombrePpo2(String nombrePpo2) {
        this.nombrePpo2 = nombrePpo2;
    }

    public DefaultStreamedContent getDownloadHito() {
        return downloadHito;
    }

    public void setDownloadHito(DefaultStreamedContent downloadHito) {
        this.downloadHito = downloadHito;
    }

    public DefaultStreamedContent getDownloadPpo() {
        return downloadPpo;
    }

    public void setDownloadPpo(DefaultStreamedContent downloadPpo) {
        this.downloadPpo = downloadPpo;
    }

    public ContratoHitoServiceImpl getContratoHitoServiceImpl() {
        return contratoHitoServiceImpl;
    }

    public void setContratoHitoServiceImpl(ContratoHitoServiceImpl contratoHitoServiceImpl) {
        this.contratoHitoServiceImpl = contratoHitoServiceImpl;
    }

    public ContratoHitoVO getContratoHitoVO() {
        return contratoHitoVO;
    }

    public void setContratoHitoVO(ContratoHitoVO contratoHitoVO) {
        this.contratoHitoVO = contratoHitoVO;
    }

    public List<ContratoHitoVO> getListContratoHitoVO() {
        return listContratoHitoVO;
    }

    public void setListContratoHitoVO(List<ContratoHitoVO> listContratoHitoVO) {
        this.listContratoHitoVO = listContratoHitoVO;
    }

    public ContratoPpoVO getContratoPpoVO() {
        return contratoPpoVO;
    }

    public void setContratoPpoVO(ContratoPpoVO contratoPpoVO) {
        this.contratoPpoVO = contratoPpoVO;
    }

    public ContratoPpoServiceImpl getContratoPpoServiceImpl() {
        return contratoPpoServiceImpl;
    }

    public void setContratoPpoServiceImpl(ContratoPpoServiceImpl contratoPpoServiceImpl) {
        this.contratoPpoServiceImpl = contratoPpoServiceImpl;
    }

    public List<ContratoPpoVO> getListContratoPpoVO() {
        return listContratoPpoVO;
    }

    public void setListContratoPpoVO(List<ContratoPpoVO> listContratoPpoVO) {
        this.listContratoPpoVO = listContratoPpoVO;
    }
    
    //*********************************************************************//
    //**************************EMPIEZA CONTRATO COMPROMISO********************//
    //*********************************************************************//  
    public void listaContratoCompromiso(int codigocontrato){
        try {
            listarContratoCompromiso =
                contratoCompromisoServiceImpl.getCompromisosContrato(codigocontrato);
            System.out.println("listarContratoCompromiso.size():"+listarContratoCompromiso.size());
            listarContratoCompromiso= descripciones(listarContratoCompromiso);
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }
    
    public List<ContratoCompromisoVO>  descripciones(List<ContratoCompromisoVO> lista){
        for (ContratoCompromisoVO contratoComprom : lista) {
            for (TipoInversionVO tipoInversion : listaTipoInversion) {
                if(contratoComprom.getTivId()!=null && tipoInversion.getTivId()==contratoComprom.getTivId()){
                    contratoComprom.setTivNombre(tipoInversion.getTivNombre());
                }
           }
           for (MonedaVO moneda : listarTipoMonedas) {
               if(moneda.getMonId()==contratoComprom.getMonId()){
                   contratoComprom.setMonNombre(moneda.getMonNombre());
               }
           }
        }
        return lista;
    }
    public List<ContratoCompromisoVO>  descripcionesSup(List<ContratoCompromisoVO> lista){
        for (ContratoCompromisoVO contratoComprom : lista) {
            
           for (MonedaVO moneda : listarTipoMonedas) {
               if(moneda.getMonId()==contratoComprom.getMonId()){
                   contratoComprom.setMonNombre(moneda.getMonNombre());
               }
           }
        }
        return lista;
    }
    public void resetearNuevoCompromisoInversion(){
            contratoNuevoCompromisoVO=new ContratoCompromisoVO();
            contratoNuevoCompromisoVO.setConId(contratoVO.getConId());
            incIgv=0;
        activaIGV=true;
    }
    public void listarTipoInversion(){
        try {
            listaTipoInversion = tipoInversionServicesImpl.query();
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
    }

    public void activaCamposIGV(){
        if(incIgv==1){
            activaIGV=false;
        }else{
            contratoNuevoCompromisoVO.setCcoNeto(null);
            contratoNuevoCompromisoVO.setCcoIgv(null);
            contratoNuevoCompromisoVO.setPorIgv(null);
            activaIGV=true;    
        }
    }
    public void calculaNeto(AjaxBehaviorEvent event){
        if(contratoNuevoCompromisoVO.getPorIgv()!=null && contratoNuevoCompromisoVO.getCcoTotal()!=null){
        BigDecimal calculadoIGV=(contratoNuevoCompromisoVO.getCcoTotal()).multiply(contratoNuevoCompromisoVO.getPorIgv()); 
        contratoNuevoCompromisoVO.setCcoIgv(calculadoIGV);  
        contratoNuevoCompromisoVO.setCcoNeto(contratoNuevoCompromisoVO.getCcoTotal().subtract(contratoNuevoCompromisoVO.getCcoIgv()));
        }else{
            contratoNuevoCompromisoVO.setCcoNeto(null);
        }
    }
    
    public void grabarContratoCompromisoIndicado(){
       
        if(contratoNuevoCompromisoVO.getCcoPeriodo().equals("")){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Periodo/Etapa"));   
        } else if (contratoNuevoCompromisoVO.getCcoAlcance().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Alcance"));                    
        } else if (contratoNuevoCompromisoVO.getTivId()== null || contratoNuevoCompromisoVO.getTivId()==0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha seleccionado el Tipo de Inversion"));                      
        }else if (contratoNuevoCompromisoVO.getMonId()==null || contratoNuevoCompromisoVO.getMonId()==0) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                      "No ha seleccionado el Tipo de Moneda"));             
        } else if (contratoNuevoCompromisoVO.getCcoTotal()==null || contratoNuevoCompromisoVO.getCcoTotal().equals("0")) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                      "No ha ingresado el Valor Total"));             
        } else if (contratoNuevoCompromisoVO.getCcoPlazo().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Plazo"));                    
        }
        else if (incIgv==1) {
                    
                    if (contratoNuevoCompromisoVO.getPorIgv()==null) {
                                           FacesContext.getCurrentInstance().addMessage(null,
                                                                                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                                         "No ha ingresado el % IGV"));             
                    }else{
                        ejecutarCompromisoIndicado();
                    }
        } 
        else {
            ejecutarCompromisoIndicado();
        }
    }
    public void ejecutarCompromisoIndicado(){
        try {
            System.out.println("try grabarContratoCompromisoIndicado");
            contratoNuevoCompromisoVO.setCcoTipoCambio(new BigDecimal("0.0"));
            contratoNuevoCompromisoVO.setTccTipo(Constantes.SUPERVISADOXINDICACION);
            contratoNuevoCompromisoVO.setCcoEstado(1);
            if(incIgv==0){
                contratoNuevoCompromisoVO.setCcoNeto(null);
                contratoNuevoCompromisoVO.setCcoIgv(null);
                contratoNuevoCompromisoVO.setPorIgv(null);
            }
            /*AUDITORIA*/
            Date fechaActual=new Date();
            contratoNuevoCompromisoVO.setCcoFechaAlta(fechaActual);
            contratoNuevoCompromisoVO.setCcoUsuarioAlta(usuario.getUsuAlias());
            contratoNuevoCompromisoVO.setCcoTerminal(usuario.getUsuTerminal());
            /*FIN AUDITORIA*/
            contratoCompromisoServiceImpl.insert(contratoNuevoCompromisoVO);
            listarContratoCompromiso.add(contratoNuevoCompromisoVO);
            listarContratoCompromiso=descripciones(listarContratoCompromiso);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                  Constantes.GRABARMENSAJESATISFACTORIO));
            RequestContext.getCurrentInstance().execute("popupAgregarCompromiso.hide();"); 
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORGUARDAR));
        }finally{
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
    }
    public void cargarEliminarCompromiso(ActionEvent e){
        idCompromisoEliminarI=(ContratoCompromisoVO) e.getComponent().getAttributes().get("compromiso");
    }
    public void borrarCompromiso() {
        try {

            idCompromisoEliminarI.setCcoEstado(0);
            idCompromisoEliminarI.setCcoTipoCambio(new BigDecimal("0.0"));
            idCompromisoEliminarI.setTccTipo(Constantes.SUPERVISADOXINDICACION);
            /*AUDITORIA*/
            Date fechaActual=new Date();
            idCompromisoEliminarI.setCcoFechaBaja(fechaActual);
            idCompromisoEliminarI.setCcoUsuarioBaja(usuario.getUsuAlias());
            idCompromisoEliminarI.setCcoTerminal(usuario.getUsuTerminal());
            /*FIN AUDITORIA*/
            contratoCompromisoServiceImpl.update(idCompromisoEliminarI);
            listarContratoCompromiso.remove(idCompromisoEliminarI);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                          Constantes.ELIMINARMENSAJESATISFACTORIO));
            RequestContext.getCurrentInstance().execute("dlgEliminarCompromisoI.hide();");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORBORRAR));
        }finally{           
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
    }
    
    //*********************************************************************//
    //**********EMPIEZA CONTRATO COMPROMISO SUPERVISADO********************//
    //*********************************************************************// 
    public void listaContratoCompromisoSupervisado(int codigocontrato){
        try {
            listarContratoCompromisoSupervisado =
                contratoCompromisoServiceImpl.querySupervisado(codigocontrato);
            System.out.println("listarContratoCompromisoSupervisado.size():"+listarContratoCompromisoSupervisado.size());
            listarContratoCompromisoSupervisado= descripciones(listarContratoCompromisoSupervisado);
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }
    
    public void resetearNuevoCompromisoSupervisado(){
            contratoNuevoCompromisoSupervisadoVO=new ContratoCompromisoVO();
            contratoNuevoCompromisoSupervisadoVO.setConId(contratoVO.getConId());
            incIgvSup=0;
    }
    public void activaCamposIGVSupervisado(){
        if(incIgvSup==1){
            activaIGVSup=false;
        }else{
            contratoNuevoCompromisoSupervisadoVO.setCcoNeto(null);
            contratoNuevoCompromisoSupervisadoVO.setCcoIgv(null);
            contratoNuevoCompromisoSupervisadoVO.setPorIgv(null);
            activaIGVSup=true;    
        }
    }
    public void calculaNetoSupervisado(AjaxBehaviorEvent event){
        if(contratoNuevoCompromisoSupervisadoVO.getPorIgv()!=null && contratoNuevoCompromisoSupervisadoVO.getCcoTotal()!=null){
        BigDecimal calculadoIGV=(contratoNuevoCompromisoSupervisadoVO.getCcoTotal()).multiply(contratoNuevoCompromisoSupervisadoVO.getPorIgv()); 
        contratoNuevoCompromisoSupervisadoVO.setCcoIgv(calculadoIGV);  
        contratoNuevoCompromisoSupervisadoVO.setCcoNeto(contratoNuevoCompromisoSupervisadoVO.getCcoTotal().subtract(contratoNuevoCompromisoSupervisadoVO.getCcoIgv()));
        }else{
            contratoNuevoCompromisoSupervisadoVO.setCcoNeto(null);
        }
    }
    public void grabarContratoCompromisoSupervisado(){
        if(contratoNuevoCompromisoSupervisadoVO.getCcoPeriodo().equals("")){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Periodo/Etapa"));   
        } else if (contratoNuevoCompromisoSupervisadoVO.getCcoAlcance().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Alcance"));                    
        } else if (contratoNuevoCompromisoSupervisadoVO.getMonId()==null) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                      "No ha seleccionado el Tipo de Moneda"));             
        } else if (contratoNuevoCompromisoSupervisadoVO.getCcoTotal()==null ) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                      "No ha ingresado el Valor Total"));             
        } else if (contratoNuevoCompromisoSupervisadoVO.getCcoPlazo().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "No ha ingresado el Plazo"));                    
        }
        else if (contratoNuevoCompromisoSupervisadoVO.getCcoTipoCambio()==null) {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                  "No ha ingresado el Tipo de Cambio"));                    
        }
        else if (incIgvSup==1) {
                    
                    if (contratoNuevoCompromisoSupervisadoVO.getPorIgv()==null) {
                                           FacesContext.getCurrentInstance().addMessage(null,
                                                                                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                                         "No ha ingresado el % IGV"));             
                    }else{
                        ejecutarCompromisoSupervisado();
                    }
        } 
        else {
            ejecutarCompromisoSupervisado();
        }
       
    }
    public void ejecutarCompromisoSupervisado(){
        System.out.println("tipocambiosup:"+tipocambiosup);
        try {
            contratoNuevoCompromisoSupervisadoVO.setTccTipo(Constantes.SUPERVISADOXOSITRAN);          
            contratoNuevoCompromisoSupervisadoVO.setCcoEstado(1);
            //contratoNuevoCompromisoSupervisadoVO.setCcoTipoCambio(tipocambiosup);
            contratoNuevoCompromisoSupervisadoVO.setTivId(0);
            if(incIgvSup==0){
                contratoNuevoCompromisoSupervisadoVO.setCcoNeto(null);
                contratoNuevoCompromisoSupervisadoVO.setCcoIgv(null);
                contratoNuevoCompromisoSupervisadoVO.setPorIgv(null);
            }
            /*AUDITORIA*/
            Date fechaActual=new Date();
            contratoNuevoCompromisoSupervisadoVO.setCcoFechaAlta(fechaActual);
            contratoNuevoCompromisoSupervisadoVO.setCcoUsuarioAlta(usuario.getUsuAlias());
            contratoNuevoCompromisoSupervisadoVO.setCcoTerminal(usuario.getUsuTerminal());
            /*FIN AUDITORIA*/
            contratoCompromisoServiceImpl.insert(contratoNuevoCompromisoSupervisadoVO);
            listarContratoCompromisoSupervisado.add(contratoNuevoCompromisoSupervisadoVO);
            listarContratoCompromisoSupervisado=descripciones(listarContratoCompromisoSupervisado);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                  Constantes.GRABARMENSAJESATISFACTORIO));
            RequestContext.getCurrentInstance().execute("popupAgregarCompromisoSupervisado.hide();"); 
        } catch (Exception sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORGUARDAR));
        }finally{
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
    }
    public void cargarEliminarCompromisoSupervisado(ActionEvent e){
        idCompromisoEliminarS = (ContratoCompromisoVO) e.getComponent().getAttributes().get("comsup");
    }
    public void borrarCompromisoSupervisado() {
        try {           
            idCompromisoEliminarS.setCcoEstado(0);
            idCompromisoEliminarS.setTccTipo(Constantes.SUPERVISADOXINDICACION);
            /*AUDITORIA*/
            Date fechaActual=new Date();
            idCompromisoEliminarS.setCcoFechaBaja(fechaActual);
            idCompromisoEliminarS.setCcoUsuarioBaja(usuario.getUsuAlias());
            idCompromisoEliminarS.setCcoTerminal(usuario.getUsuTerminal());
            /*FIN AUDITORIA*/
            contratoCompromisoServiceImpl.update(idCompromisoEliminarS);
            listarContratoCompromisoSupervisado.remove(idCompromisoEliminarS);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                          Constantes.ELIMINARMENSAJESATISFACTORIO));
            RequestContext.getCurrentInstance().execute("dlgEliminarCompromisoS.hide();");
        } catch (Exception sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORBORRAR));
        }finally{           
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
    }
    public void setContratoNuevoCompromisoVO(ContratoCompromisoVO contratoNuevoCompromisoVO) {
        this.contratoNuevoCompromisoVO = contratoNuevoCompromisoVO;
    }

    public ContratoCompromisoVO getContratoNuevoCompromisoVO() {
        return contratoNuevoCompromisoVO;
    }

    public void setListarContratoCompromiso(List<ContratoCompromisoVO> listarContratoCompromiso) {
        this.listarContratoCompromiso = listarContratoCompromiso;
    }

    public List<ContratoCompromisoVO> getListarContratoCompromiso() {
        return listarContratoCompromiso;
    }

    public void setListaTipoInversion(List<TipoInversionVO> listaTipoInversion) {
        this.listaTipoInversion = listaTipoInversion;
    }

    public List<TipoInversionVO> getListaTipoInversion() {
        return listaTipoInversion;
    }

    public void setIncIgv(int incIgv) {
        this.incIgv = incIgv;
    }

    public int getIncIgv() {
        return incIgv;
    }

    public void setActivaIGV(boolean activaIGV) {
        this.activaIGV = activaIGV;
    }

    public boolean isActivaIGV() {
        return activaIGV;
    }

    public void setTabDeshabilitado(boolean tabDeshabilitado) {
        this.tabDeshabilitado = tabDeshabilitado;
    }

    public boolean isTabDeshabilitado() {
        return tabDeshabilitado;
    }

    public ContratoAlertaEstadoVO getContratoAlertaEstadoVO() {
        return contratoAlertaEstadoVO;
    }

    public void setContratoAlertaEstadoVO(ContratoAlertaEstadoVO contratoAlertaEstadoVO) {
        this.contratoAlertaEstadoVO = contratoAlertaEstadoVO;
    }

    public ContratoAlertaEstadoServiceImpl getContratoAlertaEstadoServiceImpl() {
        return contratoAlertaEstadoServiceImpl;
    }

    public void setContratoAlertaEstadoServiceImpl(ContratoAlertaEstadoServiceImpl contratoAlertaEstadoServiceImpl) {
        this.contratoAlertaEstadoServiceImpl = contratoAlertaEstadoServiceImpl;
    }

    public List<ContratoAlertaEstadoVO> getListContratoAlertaEstado() {
        return listContratoAlertaEstado;
    }

    public void setListContratoAlertaEstado(List<ContratoAlertaEstadoVO> listContratoAlertaEstado) {
        this.listContratoAlertaEstado = listContratoAlertaEstado;
    }


    public void setListarContratoCompromisoSupervisado(List<ContratoCompromisoVO> listarContratoCompromisoSupervisado) {
        this.listarContratoCompromisoSupervisado = listarContratoCompromisoSupervisado;
    }

    public List<ContratoCompromisoVO> getListarContratoCompromisoSupervisado() {
        return listarContratoCompromisoSupervisado;
    }

    public void setContratoNuevoCompromisoSupervisadoVO(ContratoCompromisoVO contratoNuevoCompromisoSupervisadoVO) {
        this.contratoNuevoCompromisoSupervisadoVO = contratoNuevoCompromisoSupervisadoVO;
    }

    public ContratoCompromisoVO getContratoNuevoCompromisoSupervisadoVO() {
        return contratoNuevoCompromisoSupervisadoVO;
    }

    public void setIncIgvSup(int incIgvSup) {
        this.incIgvSup = incIgvSup;
    }

    public int getIncIgvSup() {
        return incIgvSup;
    }


    public void setActivaIGVSup(boolean activaIGVSup) {
        this.activaIGVSup = activaIGVSup;
    }

    public boolean isActivaIGVSup() {
        return activaIGVSup;
    }

    public void setTipocambiosup(double tipocambiosup) {
        this.tipocambiosup = tipocambiosup;
    }

    public double getTipocambiosup() {
        return tipocambiosup;
    }
    //*********************************************************************//
     //**************************Empieza Contrato Penalidad********************//
     //*********************************************************************//
     public void listaContratoPenalidad(int codigocontrato){
         try {
             listarContratoPenalidad =
                 contratoPenalidadServiceImpl.getPenalidadesContrato(codigocontrato);
             System.out.println("listarContratoCompromisoSupervisado.size():"+listarContratoPenalidad.size());
             listarContratoPenalidad=descripcionesPenalidad(listarContratoPenalidad);
         } catch (SQLException sqle) {
             // TODO: Add catch code
             sqle.printStackTrace();
         }
     }
     public List<ContratoPenalidadVO> descripcionesPenalidad(List<ContratoPenalidadVO> lista){
         for (ContratoPenalidadVO contratoPenalidad : lista) {
            for (MonedaVO moneda : listarTipoMonedas) {
                if(moneda.getMonId()==contratoPenalidad.getMonId()){
                    contratoPenalidad.setMonNombre(moneda.getMonNombre());
                }
            }
        }
         return lista;
     }
     public void resetearNuevaPenalidad(){
             contratoNuevaPenalidadVO=new ContratoPenalidadVO();
             contratoNuevaPenalidadVO.setConId(contratoVO.getConId());
     }
    
     public void grabarContratoPenalidad(){
         if(contratoNuevaPenalidadVO.getTcpMotivo().equals("")){
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                           "No ha ingresado la Etapa"));   
         }else if (contratoNuevaPenalidadVO.getMonId()==null) {
                                 FacesContext.getCurrentInstance().addMessage(null,
                                                                              new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                               "No ha seleccionado el Tipo de Moneda"));             
         }else if (contratoNuevaPenalidadVO.getTcpTotal()==null || contratoNuevaPenalidadVO.getTcpTotal()==0){
             FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                      "No ha ingresado el Monto"));             
         }else if (contratoNuevaPenalidadVO.getTcpFecha()==null) {
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                           "No ha seleccionado la Fecha"));                    
         }else if (contratoNuevaPenalidadVO.getPesId()==null) {
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                           "No ha seleccionado el Estado"));                      
         }else if (contratoNuevaPenalidadVO.getTcpDocumentoFisico().equals("")) {
                         FacesContext.getCurrentInstance().addMessage(null,
                                                                      new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                                       "No ha seleccionado ningun documento"));             
         } 
         
         else {
                 System.out.println("tipocambiosup:"+tipocambiosup);
                 try {               
                     contratoNuevaPenalidadVO.setTcpEstado("1");
                     /*AUDITORIA*/
                     Date fechaActual=new Date();
                     contratoNuevaPenalidadVO.setTcpFechaAlta(fechaActual);
                     contratoNuevaPenalidadVO.setTcpUsuarioAlta(usuario.getUsuAlias());
                     contratoNuevaPenalidadVO.setTcpTerminal(usuario.getUsuTerminal());
                     /*FIN AUDITORIA*/
                     contratoPenalidadServiceImpl.insert(contratoNuevaPenalidadVO);            
                     listarContratoPenalidad.add(contratoNuevaPenalidadVO);    
                     listaContratoPenalidad(contratoVO.getConId());
                     Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTAPENALIDADES+contratoNuevaPenalidadVO.getTcpDocumentoFisico(), contratoNuevaPenalidadVO.getInputStreamNuevaPenalidad());
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                           Constantes.GRABARMENSAJESATISFACTORIO));
                     RequestContext.getCurrentInstance().execute("popupAgregarPenalidad.hide();"); 
                 } catch (Exception sqle) {
                     sqle.printStackTrace();
                     FacesContext.getCurrentInstance().addMessage(null,
                                                                  new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                                   Constantes.ERRORGUARDAR));
                 }finally{
                     RequestContext.getCurrentInstance().update("tab:form:mensaje");
                 }
         }
     }
     public void cargarElimimarPenalidad(ActionEvent e){
      idPenalidadEliminar =  (ContratoPenalidadVO) e.getComponent().getAttributes().get("penalidad");
     }
     public void borrarPenalidad() {
         try {
            
             idPenalidadEliminar.setTcpEstado("0");
             /*AUDITORIA*/
             Date fechaActual=new Date();
             idPenalidadEliminar.setTcpFechaBaja(fechaActual);
             idPenalidadEliminar.setTcpUsuarioBaja(usuario.getUsuAlias());
             idPenalidadEliminar.setTcpTerminal(usuario.getUsuTerminal());
             /*FIN AUDITORIA*/
             contratoPenalidadServiceImpl.update(idPenalidadEliminar);
             listarContratoPenalidad.remove(idPenalidadEliminar);
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                           Constantes.ELIMINARMENSAJESATISFACTORIO));
             RequestContext.getCurrentInstance().execute("dlgEliminarPenalidad.hide();");
         } catch (Exception sqle) {
             sqle.printStackTrace();
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                           Constantes.ERRORBORRAR));
         }finally{           
             RequestContext.getCurrentInstance().update("tab:form:mensaje");
         }
     }
     public void listarPenalidadEstado(){
         try {
             listarContratoPenalidadEstado = contratoPenalidadEstadoServiceImpl.query();
         } catch (SQLException sqle) {
             // TODO: Add catch code
             sqle.printStackTrace();
         }
     }
     public void preDownloadPenalidades(String nombreArchivo) {
         try {
             System.out.println("nombreArchivo:"+nombreArchivo);
             downloadPenalidades= Reutilizar.getNewInstance().preDownload(Constantes.RUTAPENALIDADES + nombreArchivo);
         } catch (FileNotFoundException fnfe) {
             FacesContext.getCurrentInstance().addMessage(null,
                                                          new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                           Constantes.ARCHIVONOENCONTRADO));
         }
     }
     public void subirArchivoPenalidad(FileUploadEvent event) throws IOException {
         contratoNuevaPenalidadVO.setTcpDocumentoFisico(event.getFile().getFileName());
         contratoNuevaPenalidadVO.setInputStreamNuevaPenalidad(event.getFile().getInputstream());

     }
     public void setContratoNuevaPenalidadVO(ContratoPenalidadVO contratoNuevaPenalidadVO) {
         this.contratoNuevaPenalidadVO = contratoNuevaPenalidadVO;
     }

     public ContratoPenalidadVO getContratoNuevaPenalidadVO() {
         return contratoNuevaPenalidadVO;
     }


     public void setListarContratoPenalidad(List<ContratoPenalidadVO> listarContratoPenalidad) {
         this.listarContratoPenalidad = listarContratoPenalidad;
     }

     public List<ContratoPenalidadVO> getListarContratoPenalidad() {
         return listarContratoPenalidad;
     }

     public void setContratoPenalidadServiceImpl(ContratoPenalidadService contratoPenalidadServiceImpl) {
         this.contratoPenalidadServiceImpl = contratoPenalidadServiceImpl;
     }

     public ContratoPenalidadService getContratoPenalidadServiceImpl() {
         return contratoPenalidadServiceImpl;
     }

     public void setContratoPenalidadEstadoServiceImpl(ContratoPenalidadEstadoService contratoPenalidadEstadoServiceImpl) {
         this.contratoPenalidadEstadoServiceImpl = contratoPenalidadEstadoServiceImpl;
     }

     public ContratoPenalidadEstadoService getContratoPenalidadEstadoServiceImpl() {
         return contratoPenalidadEstadoServiceImpl;
     }

     public void setListarContratoPenalidadEstado(List<ContratoPenalidadEstadoVO> listarContratoPenalidadEstado) {
         this.listarContratoPenalidadEstado = listarContratoPenalidadEstado;
     }

     public List<ContratoPenalidadEstadoVO> getListarContratoPenalidadEstado() {
         return listarContratoPenalidadEstado;
     }

     public void setDownloadPenalidades(DefaultStreamedContent downloadPenalidades) {
         this.downloadPenalidades = downloadPenalidades;
     }

     public DefaultStreamedContent getDownloadPenalidades() {
         return downloadPenalidades;
     }

     public void setNombreConcesion(String nombreConcesion) {
         this.nombreConcesion = nombreConcesion;
     }

     public String getNombreConcesion() {
         return nombreConcesion;
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

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

    public void setRenderAeropuertos(boolean renderAeropuertos) {
        this.renderAeropuertos = renderAeropuertos;
    }

    public boolean isRenderAeropuertos() {
        return renderAeropuertos;
    }

    public void setTipoInfraestructura(int tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public int getTipoInfraestructura() {
        return tipoInfraestructura;
    }
}
