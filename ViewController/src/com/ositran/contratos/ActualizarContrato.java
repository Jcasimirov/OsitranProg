package com.ositran.contratos;

import com.ositran.service.ConcesionarioService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoEntregaService;
import com.ositran.service.MonedaService;
import com.ositran.service.PeriodoService;
import com.ositran.service.TipoInversionServices;
import com.ositran.serviceimpl.AdendaTipoServiceImpl;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoAdendaServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.util.Constantes;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.AdendaTipoVO;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.ContratoAdendaVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoEntregaVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.PeriodoVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.io.FileNotFoundException;
import java.io.IOException;

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
    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
    ContratoCompromisoService contratoCompromisoServiceImpl;
    @ManagedProperty(value = "#{monedaServiceImpl}")
    MonedaService monedaServiceImpl;
    @ManagedProperty(value = "#{periodoServiceImpl}")
    PeriodoService periodoServiceImpl;

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
    @ManagedProperty(value = "#{tipoInversionVO}")
    private TipoInversionVO tipoInversionVO;
    @ManagedProperty(value = "#{periodoVO}")
    private PeriodoVO periodoVO;
    // Lista Bean VO

    List<InfraestructuraTipoVO> listaTipoInfraestructura=new ArrayList<InfraestructuraTipoVO>();

    List<ConcesionVO> listaConcesiones=new ArrayList<ConcesionVO>();

    List<ModalidadConcesionVO> listaModalidad=new ArrayList<ModalidadConcesionVO>();

    List<ContratoVO> listaContrato=new ArrayList<ContratoVO>();

    List<ContratoAdendaVO> listContratoAdenda=new ArrayList<ContratoAdendaVO>();

    List<ContratoEntregaVO> listarEntregas=new ArrayList<ContratoEntregaVO>();

    List<MonedaVO> listarTipoMonedas=new ArrayList<MonedaVO>();
    
    List<PeriodoVO> listarPeriodos = new ArrayList<PeriodoVO>();
    List<AdendaTipoVO> listarAdendasTipo = new ArrayList<AdendaTipoVO>();
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
    private DefaultStreamedContent downloadContratoPDF;
    private DefaultStreamedContent downloadFichaResumen;
    private DefaultStreamedContent downloadAdendas;
    private DefaultStreamedContent downloadEntregas;

    private int tipoArchivoEnContratoConcesion;
    // Metodos Get y Set

    public ActualizarContrato() {
        super();

    }
    public void listarTiposMoneda(){
        try {
            listarTipoMonedas = monedaServiceImpl.query();
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

    // Metodo para Filtrar la Lista de Concesión
    public void filtrarConcesion() {
        try {
            listaConcesiones = concesionServiceImpl.filtrarConcesion(tipoinfra);
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

    // Metodo para Buscar Contrato de Concesion y llenar los demas tabs

    public void buscarContratos() {
        System.out.println("actualizarContratoMB.buscarContratos");
        try {
            listaContrato =
                this.contratoConcesionServiceImp.buscarContratos(tipoinfra, concesion, modalidad, fechaInicio,
                                                                 fechaFin);
            System.out.println("listaContrato.size():" + listaContrato.size());
            for (ContratoVO aux : listaContrato) {
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


            }

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

    public void seleccionarContrato(ActionEvent e) {
        contratoVO = (ContratoVO) e.getComponent().getAttributes().get("idcontrato");
        cargarDatosConcesionario(contratoVO.getCncId());
        cargarListaAdendas(contratoVO.getConId());
        cargarListaContratoEntregas(contratoVO.getConId());
        cargarDatosAvanceReportedeObra();
        resetDialogoBuscarContrato();
    }
    /*--Reporte de Avance de Obra
     * periodoseleccionado=contratoVO.getPerId();
     * aplicaAvancedeObra=contratoVO.getConAvanceobra() == 1 ? true : false;
     * contratoVO.conDiames
     * --Plazos de Revisión
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
            Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTAFICHASRESUMEN +
                                                                contratoVO.getConFicharesumen(),
                                                                contratoVO.getInputStreamFichaResumen());
            Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTACONTRATOSPDF + contratoVO.getConPdfcontrato(),
                                                                contratoVO.getInputStreamContratoPDF());
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

    }

    public void subirFichaResumen(FileUploadEvent event) throws IOException {
        contratoVO.setConFicharesumen(event.getFile().getFileName());
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
            }


        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void agregarAdenda() {
        try {
            System.out.println("contratoNuevaAdendaVO.getTadId():"+contratoNuevaAdendaVO.getTadId());
            contratoNuevaAdendaVO.setCadMonto(1L);            
            contratoNuevaAdendaVO.setTadNombre(obtenerNombreTipoAdenda(contratoNuevaAdendaVO.getTadId()));
            contratoNuevaAdendaVO.setCadFechaDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoNuevaAdendaVO.getCadFecha()));
            listContratoAdenda.add(contratoNuevaAdendaVO);
            contratoAdendaServiceImpl.insert(contratoNuevaAdendaVO);
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
        }finally{

            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }

    }

    public void borrarAdenda(ActionEvent e) {
        try {
            ContratoAdendaVO adenda = (ContratoAdendaVO) e.getComponent().getAttributes().get("adenda");
            listContratoAdenda.remove(adenda);
            adenda.setCadEstado(0);
            contratoAdendaServiceImpl.update(adenda);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                          Constantes.ELIMINARMENSAJESATISFACTORIO));
            RequestContext.getCurrentInstance().execute("popupAgregarAdenda.hide();");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORBORRAR));
        }finally{           
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
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

    public void resetearNuevaAdenda() {
        if(contratoVO!=null){
        contratoNuevaAdendaVO = new ContratoAdendaVO();
        contratoNuevaAdendaVO.setConId(contratoVO.getConId());
            RequestContext.getCurrentInstance().update("tab:frmNuevaAdendaDlg:pnlNuevaAdendaDlg");  
            RequestContext.getCurrentInstance().update("tab:frmNuevaAdendaDlg:pnlNuevaAdendaBtnDlg");             
            RequestContext.getCurrentInstance().execute("popupAgregarAdenda.show();");  
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.SELECCIONECONTRATO));
            RequestContext.getCurrentInstance().update("tab:form:mensaje");    
        }
    }

    public void listarTiposAdendas() {
        try {
            listarAdendasTipo = adendaTipoServiceImpl.query();
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
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



    //************************Termina Contrato Adenda**********************//
    public void limpiarCampos() {
        nombre = "";
        contratoId = 0;
        documento = "";
        objeto = "";
        fecha = null;
        adendaTipo = 0;
    }

    //*********************************************************************//
    //**************************Empieza Contrato Entrega********************//
    //*********************************************************************//

    public void cargarListaContratoEntregas(int idcontrato) {
        try {
            listarEntregas = contratoEntregaServiceImpl.getEntregasContrato(idcontrato);
            for (ContratoEntregaVO e : listarEntregas) {
                System.out.println("e.getConId()+e.getCenId(): " + e.getConId() + e.getCenId());
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public void resetearNuevaEntrega() {
        if(contratoVO!=null){
        contratoNuevaEntregaVO = new ContratoEntregaVO();
        contratoNuevaEntregaVO.setConId(contratoVO.getConId());
        RequestContext.getCurrentInstance().update("tab:frmNuevaEntregaDlg:pnlNuevaEntregaDlg");  
        RequestContext.getCurrentInstance().update("tab:frmNuevaEntregaDlg:pnlNuevaEntregaBtnDlg");  
        RequestContext.getCurrentInstance().execute("popupAgregarEntrega.show();");  
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.SELECCIONECONTRATO));
 
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
    }

    public void agregarEntrega() {

        try {
            System.out.println("agregarEntrega: " + contratoNuevaEntregaVO.getConId());
            contratoNuevaEntregaVO.setCenFechaDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoNuevaEntregaVO.getCenFecha()));
            contratoNuevaEntregaVO.setCenMonto(1L);
            contratoNuevaEntregaVO.setMonId(1);
            contratoNuevaEntregaVO.setCenEntrega(1);
            listarEntregas.add(contratoNuevaEntregaVO);
            contratoEntregaServiceImpl.insert(contratoNuevaEntregaVO);
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
        }finally{
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
    }

    public void borrarEntrega(ActionEvent e) {
        try {
            ContratoEntregaVO entrega = (ContratoEntregaVO) e.getComponent().getAttributes().get("entrega");
            listarEntregas.remove(entrega);
            entrega.setCenEstado(0);
            contratoEntregaServiceImpl.update(entrega);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.EXITO,
                                                                          Constantes.ELIMINARMENSAJESATISFACTORIO));
            RequestContext.getCurrentInstance().execute("popupAgregarEntrega.hide();");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR,
                                                                          Constantes.ERRORBORRAR));
        }finally{
            RequestContext.getCurrentInstance().update("tab:form:mensaje");
        }
    }
    
    public void subirArchivoEntrega(FileUploadEvent event) throws IOException {
        contratoNuevaEntregaVO.setCenDocumentoFisico(event.getFile().getFileName());
        contratoNuevaEntregaVO.setInputStreamNuevaEntrega(event.getFile().getInputstream());

    }
    public void preDownloadEntrega(String nombreArchivo) {
        try {
            downloadEntregas =
                Reutilizar.getNewInstance().preDownload(Constantes.RUTAADENDAENTREGA + nombreArchivo);
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

}
