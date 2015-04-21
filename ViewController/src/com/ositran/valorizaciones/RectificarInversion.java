package com.ositran.valorizaciones;

import com.ositran.service.ConcesionarioService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.InvReajusteService;
import com.ositran.service.InvReconocimientoService;
import com.ositran.service.InversionAvanceEstadoService;
import com.ositran.service.MonedaService;
import com.ositran.service.NotificacionService;
import com.ositran.service.PeriodoService;
import com.ositran.service.TipoInversionServices;
import com.ositran.service.ValorizacionConceptoService;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.util.Constantes;
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
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.PeriodoVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TipoInversionVO;
import com.ositran.vo.bean.UsuarioVO;
import com.ositran.vo.bean.ValorizacionConceptoVO;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
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
    @ManagedProperty(value = "#{invAvnVO}")
    private InvAvnVO invAvnVO;
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
    
    @ManagedProperty(value = "#{valorizacionConceptoServiceImpl}")
    ValorizacionConceptoService valorizacionConceptoServiceImpl;
    
    // Lista Bean VO
    private List<ValorizacionConceptoVO> listaValorizacionConceptos = new ArrayList<ValorizacionConceptoVO>();
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


    public final int formulario = 29;
    private RolOpcionesVO rolOpcion;
    private boolean renderAeropuertos;
    private Date fechaInicioSuscripcion;
    private Date fechaFinSuscripcion;
    private String nombreConcesion;


    private UsuarioVO usuario;
    private int tipoInfraestructura;

    private BigDecimal totalivrMontoPresentado=new BigDecimal("0");
    private BigDecimal totalivrMontoAprobado=new BigDecimal("0");
    private BigDecimal totalirjMontoAprobado=new BigDecimal("0");
    private BigDecimal totalirjMontoReajuste=new BigDecimal("0");
    
    public void validarSesion() throws IOException {
        /* rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
        usuario=Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        tipoInfraestructura= Reutilizar.getNewInstance().obtenerDatosEmpleadoLogueado().getTinId();*/
    }

    public RectificarInversion() {
        super();

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

    // Metodo para Filtrar  el combo la Concesi�n de buscar contrato
    public void filtrarConcesion() {
        try {
            listaConcesiones = concesionServiceImpl.filtrarConcesion(tipoinfra);
            System.out.println("listaConcesiones:"+listaConcesiones.size());
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

    public void listarInfraEstructuras() throws SQLException {
        try {
            listarInfraestructura = infraestructuraServiceImpl.query();
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
            for (MonedaVO moneda : listarTipoMonedas) {
                if (invAvn.getMonId() == moneda.getMonId())
                    invAvn.setNombreMoneda(moneda.getMonNombre());
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
    public void cargarValorizacionConceptos(){
        try {
         listaValorizacionConceptos=valorizacionConceptoServiceImpl.query();
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
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


    public void buscarContratos() {
        System.out.println("actualizarContratoMB.buscarContratos");
        try {
            listaContrato =
                contratoConcesionServiceImp.buscarxNombreConcesion(nombreConcesion.toUpperCase().trim(), tipoinfra,
                                                                   concesion, fechaInicioSuscripcion,
                                                                   fechaFinSuscripcion);
        /*  for (ContratoVO aux : listaContrato) {
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


        if (tipoInfraestructura == Constantes.TIPINFAEROPUERTOS) {
            RequestContext.getCurrentInstance().update("frmInversion:tablaContratoInversion");
            RequestContext.getCurrentInstance().update("frmAgregarInversion:AeropuertoInversion");
        }
    }


    public void listarDeclaraciones(int codigoContrato) {
        try {
            listaValorizaciones = notificacionServiceImpl.obtenerDeclaracionesxIdContrato(codigoContrato);
            cargarDescripcionesMoneda(listaValorizaciones);
            cargarEstadosdelAvanceInversion(listaValorizaciones);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void seleccionarDeclaracion(ActionEvent e) throws SQLException {
        invAvnVO = (InvAvnVO) e.getComponent().getAttributes().get("idDeclaracion");
        System.out.println("contratoVO.getNombreConcesion():"+contratoVO.getNombreConcesion());
        invAvnVO.setNombreConcesion(contratoVO.getNombreConcesion());
        invAvnVO.setNombreConcesion(contratoVO.getNombreConcesion());
        invAvnVO.setNombreTipoInfraestructura(contratoVO.getNombreTipoInfraestructura());
        invAvnVO.setNombreModalidad(contratoVO.getNombreModalidad());
        System.out.println("seleccionarDeclaracion");
       
        cargarDatosCompromiso(invAvnVO.getCcoId());
        cargarReconocimiento(invAvnVO.getTiaNumero());
        cargarReajuste(invAvnVO.getTiaNumero());
    }
    
    public void cargarDatosCompromiso(int ccoId) {
        try {
            ContratoCompromisoVO contratoCompromisoVO = contratoCompromisoServiceImpl.get(ccoId);
            invAvnVO.setPlazo(contratoCompromisoVO.getCcoPlazo());
            invAvnVO.setTotal(contratoCompromisoVO.getCcoTotal());
            for (MonedaVO moneda : listarTipoMonedas) {
                if (contratoCompromisoVO.getMonId() == moneda.getMonId()) {
                    invAvnVO.setNombreMoneda(moneda.getMonNombre());
                    System.out.println("invAvnVO.getNombreMoneda():"+invAvnVO.getNombreMoneda());
                    break;
                }
            }
            invAvnVO.setPeriodo(contratoCompromisoVO.getCcoPeriodo());
        } catch (Exception e) {
            System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
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

            contratoVO.setConFechaCambio(new Date());
            contratoVO.setConUsuarioCambio(usuario.getUsuAlias());
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

    public void cargarReconocimiento(int tiaNumero){
        try {
         listaReconocimiento =  invReconocimientoServiceImpl.getInvReconocimientosAvance(tiaNumero);
            System.out.println(listaReconocimiento.size());
            for (InvReconocimientoVO invReconocimiento : listaReconocimiento) {
                System.out.println("invReconocimiento.getIvrMontoAprobado()??????:"+invReconocimiento.getIvrMontoAprobado());
                if(invReconocimiento.getIvrMontoAprobado()!=null)
                    totalivrMontoAprobado=totalivrMontoAprobado.add(invReconocimiento.getIvrMontoAprobado());                
                if(invReconocimiento.getIvrMontoPresentado()!=null)
                    totalivrMontoPresentado=totalivrMontoPresentado.add(invReconocimiento.getIvrMontoPresentado());
                
            }
            cargarDescripcionesInfraestructura(listaReconocimiento);
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }
    public void cargarDescripcionesInfraestructura(List<?> lista){
        for(Object item : lista){
            for(InfraestructuraVO infraestructuraVO : listarInfraestructura){
                if(item instanceof InvReconocimientoVO){
                    InvReconocimientoVO aux=((InvReconocimientoVO)item);
                    if(aux.getInfId()==infraestructuraVO.getInfId()){
                            aux.setNombreInfraestructura(infraestructuraVO.getInfNombre());
                    }
                }
                if(item instanceof InvReajusteVO){
                    InvReajusteVO aux=((InvReajusteVO)item);
                    if(aux.getInfId()==infraestructuraVO.getInfId())
                            aux.setNombreInfraestructura(infraestructuraVO.getInfNombre());
                }
            }
           
        }
    }
    public void cargarDescripcionesMoneda(){
        
    }
    public void cargarReajuste(int tiaNumero){
        try {
          listaReajuste =  invReajusteServiceImpl.getInvReajustesAvance(tiaNumero);
            for (InvReajusteVO invReajuste : listaReajuste) {
                if(invReajuste.getIrjMontoAprobado()!=null)
                    totalirjMontoAprobado=totalirjMontoAprobado.add(invReajuste.getIrjMontoAprobado());
                if(invReajuste.getIrjMontoReajuste()!=null)
                    totalirjMontoReajuste=totalirjMontoReajuste.add(invReajuste.getIrjMontoReajuste());
            }
            System.out.println("totalirjMontoReajuste??????:"+totalirjMontoAprobado);
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
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

    public void setValorizacionConceptoServiceImpl(ValorizacionConceptoService valorizacionConceptoServiceImpl) {
        this.valorizacionConceptoServiceImpl = valorizacionConceptoServiceImpl;
    }

    public ValorizacionConceptoService getValorizacionConceptoServiceImpl() {
        return valorizacionConceptoServiceImpl;
    }

    public void setListaValorizacionConceptos(List<ValorizacionConceptoVO> listaValorizacionConceptos) {
        this.listaValorizacionConceptos = listaValorizacionConceptos;
    }

    public List<ValorizacionConceptoVO> getListaValorizacionConceptos() {
        return listaValorizacionConceptos;
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

}
