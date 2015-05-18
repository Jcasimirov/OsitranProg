package com.ositran.contratos;


import com.ositran.model.Infraestructura;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.DatosStdService;
import com.ositran.service.EmpresaSupervisoraService;
import com.ositran.service.InversionService;
import com.ositran.service.ModalidadConcesionService;
import com.ositran.service.ValorizacionInversionAvanceService;
import com.ositran.serviceimpl.AdendaTipoServiceImpl;
import com.ositran.serviceimpl.ContratoAdendaServiceImpl;
import com.ositran.serviceimpl.ContratoEmpresaSupervisoraAdendaServiceImpl;
import com.ositran.serviceimpl.ContratoEmpresaSupervisoraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.serviceimpl.MonedaServiceImpl;
import com.ositran.serviceimpl.ValorizacionInversionAvanceServiceImpl;
import com.ositran.util.Constantes;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.util.Util;
import com.ositran.vo.bean.AdendaTipoVO;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoAdendaVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoSupervisoraAdendaVO;
import com.ositran.vo.bean.ContratoSupervisoraVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InversionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.RolVO;
import com.ositran.vo.bean.UsuarioVO;
import com.ositran.vo.bean.ValorizacionSupDetalleVO;
import com.ositran.vo.bean.ViewTdInternosVO;

import java.io.IOException;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;


@ManagedBean(name = "manteContEmprSupervisora")
@ViewScoped
public class MantenimientoContratEmprSupervisor {
    public final int formulario = 27;
    private RolOpcionesVO rolOpcion;
    private UsuarioVO usuario;
    private int tipoInfraestructura;
    private int tipoInfraestructuraGlobal;    

    public void validarSesion() throws IOException {
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
        tipoInfraestructuraGlobal = Reutilizar.getNewInstance().obtenerDatosEmpleadoLogueado().getTinId();
        usuario = Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        tipoInfraestructura = Reutilizar.getNewInstance().obtenerDatosEmpleadoLogueado().getTinId();
    }

    private int codigoEliminar;
    //editar//
    private int contratoE;
    private String supIdE;
    private String t_modconcE;
    private int tinIdE;
    private int csiIdE;
    private int adelantoE;
    private int plazocontrE;
    private int montocontrE;
    private String nrohrE;
    private String añohrE;
    private String fregE;
    private String asuntohrE;
    private String cpsPenalidadesE;
    private String cpsCaducidadE;
    private String cpsGarantiasE;
    private String t_concesionE;
    private String t_tinfraE;
    private Date fechaInicioE;
    private Date fechaSuscripcionE;
    private Date fechaAdelantoE;
    private int contratoSeleccionado;

    //finEditar//
    private boolean dia;
    private boolean mes;
    private boolean año;
    private int codigoContratoCompromiso;
    private int codigoContratoCompromisoE;
    private String seleccionaTipoInfraestructura;
    private String btnbuscar;
    private String nrohr;
    private String añohr;
    private String freg;
    private String asuntohr;
    private String contratoConcesion;

    private String t_tinfra;
    private String t_modconc;
    private String t_conce;

    private String plazo;
    private BigDecimal total;
    private String nombreEmpresaSupervisora;
    private String nombreMoneda;
    private int codigoEmpresaSupervisora;
    private int codigoMoneda;
    private int contratoCompromisoSeleccionado;
    private int contratoCompromisoSeleccionadoE;
    private int codigoContrato;
    private int codigoContratoE;
    private int tipoInfraestructuraSeleccionada;
    private int infraestructuraSeleccionada;
    private int infraestructuraSeleccionadaE;
    private int inversionSeleccionada;
    private int inversionSeleccionadaE;
    private int monedaSeleccionada;
    private int monedaSeleccionada1;
    private int adendasTipoSeleccionada;
    private int cpsNroDeContrato;
    private int cpsPlazoContrato;
    private int cpsMontoContratado;
    private int cpsAdelantoOtorgado;
    private int codigoConcesion;

    private String cpsPenalidades;
    private String cpsCaducidad;
    private String cpsGarantias;
    private String cenDocumentoFisico;
    private String empresaSupervisora;
    private Date cpsFechaInicio;
    private Date cpsFechaSuscripcion;
    private Date cpsFechaAdelanto;
    private int adendaPlazo;
    private int adendaMonto;
    private Date adendaFecha;
    private String adendaPDF;

    private int codigoTipoInfra;
    private int codigoModalidadConcesion;
    private int codigoInfraestructura;
    private int ccoId;
    private int tccTipo;

    MonedaVO monedaVO = new MonedaVO();
    private List<ContratoSupervisoraVO> listarEntregas = new ArrayList<ContratoSupervisoraVO>();
    private List<ContratoAdendaVO> listContratoAdenda = new ArrayList<ContratoAdendaVO>();
    private List<AdendaTipoVO> listarAdendasTipo = new ArrayList<AdendaTipoVO>();
    private List<MonedaVO> listaMoneda = new ArrayList<MonedaVO>();
    private List<MonedaVO> listaMoneda1 = new ArrayList<MonedaVO>();
    private List<InfraestructuraVO> listaInfraestructuras = new ArrayList<InfraestructuraVO>();
    private List<InfraestructuraVO> listaInfraestructurasC = new ArrayList<InfraestructuraVO>();
    
    private List<InfraestructuraVO> listaInfraestructurasE = new ArrayList<InfraestructuraVO>();
    private List<InfraestructuraTipoVO> listaInfraestructuraTipo = new ArrayList<InfraestructuraTipoVO>();
    private List<ContratoSupervisoraVO> listaContratoSupervisora = new ArrayList<ContratoSupervisoraVO>();
    private List<ContratoVO> listaContratos = new ArrayList<ContratoVO>();
    private List<ContratoVO> listaContratosE = new ArrayList<ContratoVO>();
    private List<ContratoCompromisoVO> listaContratoCompromiso = new ArrayList<ContratoCompromisoVO>();
    private List<ContratoCompromisoVO> listaContratoCompromisoE = new ArrayList<ContratoCompromisoVO>();
    private List<EmpresaSupervisoraVO> listaEmpresaSup = new ArrayList<EmpresaSupervisoraVO>();
    private List<EmpresaSupervisoraVO> listaEmpresaSupE = new ArrayList<EmpresaSupervisoraVO>();
    private List<ContratoSupervisoraAdendaVO> listaAdenda = new ArrayList<ContratoSupervisoraAdendaVO>();
    private List<ContratoSupervisoraAdendaVO> listaAdenda1 = new ArrayList<ContratoSupervisoraAdendaVO>();
    private List<InversionVO> listaInversiones = new ArrayList<InversionVO>();
    
    
    Util util = new Util();

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    InfraestructuraTipoVO infraestructuraTipoVO;

    @ManagedProperty(value = "#{viewTdInternosVO}")
    ViewTdInternosVO viewTdInternosVO;

    @ManagedProperty(value = "#{datosStdServiceImpl}")
    DatosStdService datosStdServiceImpl;

    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionService contratoConcesionServiceImp;

    @ManagedProperty(value = "#{concesionVO}")
    ConcesionVO concesionVO;

    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionService concesionServiceImpl;

    @ManagedProperty(value = "#{contratoVO}")
    ContratoVO contratoVO;

    @ManagedProperty(value = "#{modalidadConcesionVO}")
    ModalidadConcesionVO modalidadConcesionVO;

    @ManagedProperty(value = "#{modalidadConcesionServiceImpl}")
    ModalidadConcesionServiceImpl modalidadConcesionServiceImpl;

    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    InfraestructuraServiceImpl infraestructuraServiceImpl;

    @ManagedProperty(value = "#{infraestructuraVO}")
    InfraestructuraVO infraestructuraVO;

    @ManagedProperty(value = "#{infraestructura}")
    Infraestructura infraestructura;

    @ManagedProperty(value = "#{inversionServiceImpl}")
    InversionService inversionServiceImpl;

    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
    ContratoCompromisoService contratoCompromisoServiceImpl;

    @ManagedProperty(value = "#{contratoCompromisoVO}")
    ContratoCompromisoVO contratoCompromisoVO;

    @ManagedProperty(value = "#{contratoSupervisoraVO}")
    ContratoSupervisoraVO contratoSupervisoraVO;

    @ManagedProperty(value = "#{contratoSupervisoraAdendaVO}")
    ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO = new ContratoSupervisoraAdendaVO();

    @ManagedProperty(value = "#{monedaServiceImpl}")
    private MonedaServiceImpl monedaServiceImpl;

    @ManagedProperty(value = "#{empresaSupervisoraServiceImpl}")
    EmpresaSupervisoraService empresaSupervisoraServiceImpl;

    @ManagedProperty(value = "#{contratoNuevaAdendaVO}")
    ContratoAdendaVO contratoNuevaAdendaVO;

    @ManagedProperty(value = "#{adendaTipoServiceImpl}")
    AdendaTipoServiceImpl adendaTipoServiceImpl;

    @ManagedProperty(value = "#{contratoAdendaServiceImpl}")
    ContratoAdendaServiceImpl contratoAdendaServiceImpl;

    @ManagedProperty(value = "#{contratoEmpresaSupervisoraServiceImpl}")
    ContratoEmpresaSupervisoraServiceImpl contratoEmpresaSupervisoraServiceImpl;

    @ManagedProperty(value = "#{contratoEmpresaSupervisoraAdendaServiceImpl}")
    ContratoEmpresaSupervisoraAdendaServiceImpl contratoEmpresaSupervisoraAdendaServiceImpl;

    @ManagedProperty(value = "#{modalidadVO}")
    ModalidadConcesionVO modalidadVO;

    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionService modalidadServiceImp;


    public void listanombrerol() {
        try {
            for (ContratoSupervisoraVO cEmpreSup : listaContratoSupervisora) {
                InfraestructuraTipoVO infratipo = getInfraestructuraTipoServiceImpl().get(cEmpreSup.getTinId());
                cEmpreSup.setNombreInfraestructura(infratipo.getTinNombre());
                EmpresaSupervisoraVO empsup = getEmpresaSupervisoraServiceImpl().get(cEmpreSup.getSupId());
                cEmpreSup.setNombreSupervisora(empsup.getSupNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ContratoSupervisoraVO> cargarListaContratosEmpresaSupervisora() throws SQLException {
        try {
            listaContratoSupervisora = contratoEmpresaSupervisoraServiceImpl.query();
            listanombrerol();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaContratoSupervisora;
    }
    //fin listar datatable--//


    //cargar lista de tipo de infraestructura--//
    public void cargarListaInfraestructuraTipo() {
        try {
            //listanombrerol();
            listaInfraestructuraTipo = infraestructuraTipoServiceImpl.query();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    // fin de carga de lista de tipo infraestructura--//

    //--buscar std--//
    public void BuscarStd() throws SQLException {

        if (nrohr.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese Nro de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!nrohr.trim().equals("") && Integer.parseInt(nrohr) < 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese Nro de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (añohr.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese un Año de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!añohr.trim().equals("") && Integer.parseInt(añohr) < 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!añohr.trim().equals("") && añohr.length() < 4) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {

            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
            try {
                viewTdInternosVO = datosStdServiceImpl.BuscaStd(Integer.parseInt(añohr), nrohr);
                if (viewTdInternosVO != null && viewTdInternosVO.getFechaRegistro() != null) {
                    freg = dt1.format(viewTdInternosVO.getFechaRegistro());
                    asuntohr = viewTdInternosVO.getAsunto();
                    añohr = viewTdInternosVO.getAnyo().toString();
                    nrohr = viewTdInternosVO.getNroRegistro();
                } else {
                    freg = "";
                    asuntohr = "";
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No se Encontraron Registros");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void BuscarStdE() throws SQLException {

        if (nrohrE.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese Nro de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!nrohrE.trim().equals("") && Integer.parseInt(nrohrE) < 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese Nro de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (añohrE.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese un Año de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!añohrE.trim().equals("") && Integer.parseInt(añohrE) < 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!añohrE.trim().equals("") && añohrE.length() < 4) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {

            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
            try {
                viewTdInternosVO = datosStdServiceImpl.BuscaStd(Integer.parseInt(añohrE), nrohrE);
                if (viewTdInternosVO != null && viewTdInternosVO.getFechaRegistro() != null) {
                    fregE = dt1.format(viewTdInternosVO.getFechaRegistro());
                    asuntohrE = viewTdInternosVO.getAsunto();
                    añohrE = viewTdInternosVO.getAnyo().toString();
                    nrohrE = viewTdInternosVO.getNroRegistro();
                } else {
                    fregE = "";
                    asuntohrE = "";
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No se Encontraron Registros");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //--fin buscar std--//

    //----buscar contrato concesion--//
    public void cargarListaContratos() {
        try {
            listaContratos = contratoConcesionServiceImp.buscarContratos1(tipoInfraestructura);
            System.out.println("el codigo es ASDASDASFDSGFDSD");

            System.out.println(tipoInfraestructura);
            for (ContratoVO contra : listaContratos) {
                ConcesionVO concesion = new ConcesionVO();

                concesion = concesionServiceImpl.get(contra.getCsiId());
                contra.setNombreConcesion(concesion.getCsiNombre());
                contra.setCodigoConcesion(concesion.getCsiId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elegirContrato(ContratoVO contratoVO) {

        try {
            codigoConcesion = contratoVO.getCsiId();
            concesionVO = concesionServiceImpl.get(codigoConcesion);
            codigoModalidadConcesion = contratoVO.getMcoId();
            codigoTipoInfra = concesionVO.getTinId();
            codigoContrato = contratoVO.getConId();
            t_conce = concesionVO.getCsiNombre();
            modalidadVO = modalidadServiceImp.get(codigoModalidadConcesion);
            t_modconc = modalidadVO.getMcoNombre();
            infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(codigoTipoInfra);
            t_tinfra = infraestructuraTipoVO.getTinNombre();
            listaInfraestructuras = infraestructuraServiceImpl.query2(concesionVO.getCsiId());
            listaContratoCompromiso = contratoCompromisoServiceImpl.query1(codigoContrato);

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "La ficha ingresada no existe. Puede hacer el ingreso manualmente"));
            e.printStackTrace();
        }
    }
    
    public void cargarInversion() {
        try {
            if (codigoInfraestructura == 111) {
            } else {
                infraestructuraVO = infraestructuraServiceImpl.get2(codigoInfraestructura);
                infraestructura.setCsiId(infraestructuraVO.getCsiId());
                infraestructura.setInfId(infraestructuraVO.getInfId());
                infraestructura.setTinId(infraestructuraVO.getTinId());
                listaInversiones = inversionServiceImpl.query1(infraestructura, codigoContrato);
            }
            cargarAeropuertoValoracion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cargarAeropuertoValoracion() {
        if (codigoInfraestructura == 111) {
            listaInfraestructurasC = new ArrayList<InfraestructuraVO>();
            for (InfraestructuraVO infraVO : listaInfraestructuras) {
                listaInfraestructurasC.add(infraVO);
            }
        } else {
            listaInfraestructurasC = new ArrayList<InfraestructuraVO>();
            for (InfraestructuraVO infraVO : listaInfraestructuras) {
                if (infraVO.getInfId() == codigoInfraestructura) {
                    listaInfraestructurasC.add(infraVO);
                }
            }
        }

    }

    public void cargarDatosCompromiso() {
        try {


            contratoCompromisoVO = contratoCompromisoServiceImpl.get(contratoCompromisoSeleccionado);
            codigoContratoCompromiso = contratoCompromisoVO.getCcoId();
            plazo = contratoCompromisoVO.getCcoPlazo();
            total = contratoCompromisoVO.getCcoTotal();
            codigoMoneda = contratoCompromisoVO.getMonId();
            monedaVO = monedaServiceImpl.get(codigoMoneda);
            nombreMoneda = monedaVO.getMonNombre();
            total = contratoCompromisoVO.getCcoTotal();
            codigoMoneda = contratoCompromisoVO.getMonId();
            ccoId = contratoCompromisoVO.getCcoId();
            tccTipo = contratoCompromisoVO.getTccTipo();


        } catch (Exception e) {
            System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
            e.printStackTrace();
        }
    }
    //---fin buscar contrato concesion---//
    //PDF  --//
    public void subirArchivoEntrega(FileUploadEvent event) throws IOException {
        contratoSupervisoraVO.setCenDocumentoFisico(event.getFile().getFileName());
        contratoSupervisoraVO.setInputStreamNuevaEntrega(event.getFile().getInputstream());
    }

    public void subirAdendaEntrega(FileUploadEvent event) throws IOException {
        contratoSupervisoraAdendaVO.setCenDocumentoFisicoA(event.getFile().getFileName());
        System.out.println(event.getFile().getFileName());
        contratoSupervisoraAdendaVO.setInputStreamNuevaEntregaA(event.getFile().getInputstream());
    }
    // fin PDF --//

    //---  cargar moneda lista --//
    public void cargarListaMoneda() {
        try {
            listaMoneda = monedaServiceImpl.query();
            listaMoneda1 = monedaServiceImpl.query();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    //--- fin cargar moneda lista --//
    //--buscar empresa supervisora --//
    public void buscarEmpresaSup() throws Exception {
        try {
            listaEmpresaSup = empresaSupervisoraServiceImpl.query();
            System.out.println("lista de empresa total " + listaEmpresaSup.size());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void elegirEmpresa(EmpresaSupervisoraVO empresaSupervisoraVO) {

        nombreEmpresaSupervisora = empresaSupervisoraVO.getSupNombre();
        codigoEmpresaSupervisora = empresaSupervisoraVO.getSupId();

    }
    //+++++++++++++++++++ EDITAR
    public void buscarEmpresaSupE() throws Exception {
        try {
            listaEmpresaSupE = empresaSupervisoraServiceImpl.query();
            System.out.println("lista de empresa total " + listaEmpresaSupE.size());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void elegirEmpresaE(EmpresaSupervisoraVO empresaSupervisoraVO) {

        nombreEmpresaSupervisora = empresaSupervisoraVO.getSupNombre();
        codigoEmpresaSupervisora = empresaSupervisoraVO.getSupId();

    }
    //--fin busqueda empresa supervisora --//
    //----Guardar contrato empresa supervisora --//
    public void grabar() throws SQLException {
        if (cpsNroDeContrato == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar Nro de contrato"));

        } else if (cpsMontoContratado < cpsAdelantoOtorgado) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "El Monto no puede ser menor al Adelanto"));
        } else if (cpsPlazoContrato == 0) {


            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar PLazo"));
        } else if (cpsMontoContratado == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar Monto Contratado"));
        } else if (cpsAdelantoOtorgado == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar Adelanto Otorgado"));
        } else if (cpsPenalidades.trim().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar Penalidad"));
        } else if (cpsCaducidad.trim().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar Causales"));
        } else if (cpsGarantias.trim().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar Garantías"));
        } else if(nrohr.trim().equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                              "Ingresar Número HR"));
            } 
        else if(añohr.trim().equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                              "Ingresar Año HR"));
        } else if(t_conce.trim().equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                              "Seleccionar contrato"));
            }
        else if(nombreEmpresaSupervisora.trim().equals("")){
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                                      "Seleccionar empresa supervisora"));
                    }
        else if(plazo.trim().equals("")){
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                                      "Seleccionar Etapa"));
                    }
                
        
        else {

            try {

                contratoSupervisoraVO.setCpsNroDeContrato(cpsNroDeContrato);
                contratoSupervisoraVO.setCpsFechaInicio(cpsFechaInicio);
                contratoSupervisoraVO.setCpsFechaSuscripcion(cpsFechaSuscripcion);
                contratoSupervisoraVO.setCpsPlazoContrato(cpsPlazoContrato);
                contratoSupervisoraVO.setCpsMontoContratado(cpsMontoContratado);
                contratoSupervisoraVO.setCpsAdelantoOtorgado(cpsAdelantoOtorgado);
                contratoSupervisoraVO.setCpsFechaAdelanto(cpsFechaAdelanto);
                contratoSupervisoraVO.setCpsPenalidades(cpsPenalidades);
                contratoSupervisoraVO.setCpsCaducidad(cpsCaducidad);
                contratoSupervisoraVO.setCpsGarantias(cpsGarantias);
                contratoSupervisoraVO.setCenDocumentoFisico(cenDocumentoFisico);
                Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTAADENDAENTREGA +
                                                                    contratoSupervisoraVO.getCenDocumentoFisico(),
                                                                    contratoSupervisoraVO.getInputStreamNuevaEntrega());
                contratoSupervisoraVO.setCpsStd(Integer.parseInt(nrohr));
                contratoSupervisoraVO.setCpsAnyo(Integer.parseInt(añohr));
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                contratoSupervisoraVO.setCpsFechaRegistro(dt1.parse(freg));
                contratoSupervisoraVO.setCpsAsunto(asuntohr);
                contratoSupervisoraVO.setSupId(codigoEmpresaSupervisora);
                contratoSupervisoraVO.setConId(codigoContrato);

                contratoSupervisoraVO.setCpsEstado(1);
                contratoSupervisoraVO.setCpsFechaAlta(new Date());
                contratoSupervisoraVO.setCpsUsuarioAlta(usuario.getUsuAlias());
                contratoSupervisoraVO.setCpsTerminal(util.obtenerIpCliente());
                contratoSupervisoraVO.setCsiId(codigoConcesion); // concesion
                contratoSupervisoraVO.setTinId(codigoTipoInfra); // tipo infraestructura codigoTipoInfra
                contratoSupervisoraVO.setMcoId(codigoModalidadConcesion);
                //contratoSupervisoraVO.setInfId(infraestructuraSeleccionada); //infraestructura (aeropuertos)
                //contratoSupervisoraVO.setInvId(inversionSeleccionada); // codigo inversion
                contratoSupervisoraVO.setCcoId(ccoId);
                contratoSupervisoraVO.setTccTipo(tccTipo);
                contratoSupervisoraVO.setCcoPlazo(plazo); //plazo
                contratoSupervisoraVO.setCcoTotal(total); //total
                contratoSupervisoraVO.setMonId(codigoMoneda); // plazo moneda


                int idCabecera = contratoEmpresaSupervisoraServiceImpl.insert(contratoSupervisoraVO);

                for (ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO : listaAdenda) {
                    contratoSupervisoraAdendaVO.setCpsNroDeContrato(idCabecera);
                    contratoEmpresaSupervisoraAdendaServiceImpl.insert(contratoSupervisoraAdendaVO);
                }
                RequestContext.getCurrentInstance().execute("dialogRegConEmpSup.hide()");
                listanombrerol();
                cargarListaContratosEmpresaSupervisora();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                              "Se Registró con Éxito"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            
    }
    //--Fin guardar contrato empresa superisora --//
    //----limpiar campos--//
    public void limpiarCampos() {

        nrohr = "";
        añohr = "";
        freg = "";
        asuntohr = "";
        nombreEmpresaSupervisora = "";
        t_conce = "";
        t_tinfra = "";
        t_modconc = "";
        listaInfraestructuras = new ArrayList<InfraestructuraVO>();
        nombreMoneda = "";
        listaContratoCompromiso = new ArrayList<ContratoCompromisoVO>();
        plazo = "";
        total = new BigDecimal("0");
        codigoMoneda = 0;
        cpsNroDeContrato = 0;
        cpsFechaInicio = null;
        cpsFechaSuscripcion = null;
        cpsPlazoContrato = 0;
        cpsMontoContratado = 0;
        
        cpsAdelantoOtorgado = 0;
        cpsFechaAdelanto = null;
        cpsPenalidades = "";
        cpsCaducidad = "";
        cpsGarantias = "";
        cenDocumentoFisico = "";
        listaAdenda = new ArrayList<ContratoSupervisoraAdendaVO>();

    }
    //-- fin limpiar campos--//
    //---VERrrrr---
    public void cargarVer(ContratoSupervisoraVO contratoSupervisoraV) {

        try {

            listanombrerol();
            contratoSupervisoraVO = contratoSupervisoraV;
            concesionVO = concesionServiceImpl.get(contratoSupervisoraVO.getCsiId());
            contratoE = contratoSupervisoraVO.getCpsNroDeContrato();

            fechaInicioE = contratoSupervisoraVO.getCpsFechaInicio();
            fechaSuscripcionE = contratoSupervisoraVO.getCpsFechaSuscripcion();
            plazocontrE = contratoSupervisoraVO.getCpsPlazoContrato();
            montocontrE = contratoSupervisoraVO.getCpsMontoContratado();
            adelantoE = contratoSupervisoraVO.getCpsAdelantoOtorgado();
            fechaAdelantoE = contratoSupervisoraVO.getCpsFechaAdelanto();
            cpsPenalidadesE = contratoSupervisoraVO.getCpsPenalidades();
            cpsCaducidadE = contratoSupervisoraVO.getCpsCaducidad();
            cpsGarantiasE = contratoSupervisoraVO.getCpsGarantias();

            asuntohrE = contratoSupervisoraVO.getCpsAsunto();
            fregE = String.valueOf(contratoSupervisoraVO.getCpsFechaRegistro());
            nrohrE = String.valueOf(contratoSupervisoraVO.getCpsStd());
            añohrE = String.valueOf(contratoSupervisoraVO.getCpsAnyo());

            InfraestructuraTipoVO infraestructuraTipoVO = new InfraestructuraTipoVO();
            infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(contratoSupervisoraVO.getTinId());
            t_tinfraE = infraestructuraTipoVO.getTinNombre();

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
    //---Fin ver
    //----Editar contrato empresa supervisora --//
    public void cargarEditar() {
        try {
            listanombrerol();
            SimpleDateFormat dt3 = new SimpleDateFormat("dd-MM-yyyy");
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            Object str = requestMap.get("idModificar");
            Integer idcodigo = Integer.valueOf(str.toString());
            contratoSupervisoraVO = contratoEmpresaSupervisoraServiceImpl.get(idcodigo);
            contratoSeleccionado = contratoSupervisoraVO.getConId();
            contratoE = contratoSupervisoraVO.getCpsNroDeContrato();
            fechaInicioE = contratoSupervisoraVO.getCpsFechaInicio();
            fechaSuscripcionE = contratoSupervisoraVO.getCpsFechaSuscripcion();
            plazocontrE = contratoSupervisoraVO.getCpsPlazoContrato();
            montocontrE = contratoSupervisoraVO.getCpsMontoContratado();

            //moneda
            adelantoE = contratoSupervisoraVO.getCpsAdelantoOtorgado();
            fechaAdelantoE = contratoSupervisoraVO.getCpsFechaAdelanto();
            cpsPenalidadesE = contratoSupervisoraVO.getCpsPenalidades();
            cpsCaducidadE = contratoSupervisoraVO.getCpsCaducidad();
            cpsGarantiasE = contratoSupervisoraVO.getCpsGarantias();
            //pdf
            listaAdenda1 =
                contratoEmpresaSupervisoraAdendaServiceImpl.getContratoSupervisoraAdenda(contratoSupervisoraVO.getCpsNroDeContrato());

            asuntohrE = contratoSupervisoraVO.getCpsAsunto();
            
            
            fregE = dt3.format(contratoSupervisoraVO.getCpsFechaRegistro());
            nrohrE = String.valueOf(contratoSupervisoraVO.getCpsStd());
            añohrE = String.valueOf(contratoSupervisoraVO.getCpsAnyo());


            EmpresaSupervisoraVO empresaSupervisoraVO = new EmpresaSupervisoraVO();
            empresaSupervisoraVO = empresaSupervisoraServiceImpl.get(contratoSupervisoraVO.getSupId());
            nombreEmpresaSupervisora = empresaSupervisoraVO.getSupNombre();
            codigoEmpresaSupervisora = empresaSupervisoraVO.getSupId();


            ConcesionVO concesionVO = new ConcesionVO();
            concesionVO = concesionServiceImpl.get(contratoSupervisoraVO.getCsiId());
            t_conce = concesionVO.getCsiNombre();
            codigoConcesion = concesionVO.getCsiId();

            InfraestructuraTipoVO infraestructuraTipoVO = new InfraestructuraTipoVO();
            infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(contratoSupervisoraVO.getTinId());
            t_tinfra = infraestructuraTipoVO.getTinNombre();
            codigoTipoInfra = infraestructuraTipoVO.getTinId();

            ModalidadConcesionVO modalidadConcesionVO = new ModalidadConcesionVO();
            modalidadConcesionVO = modalidadConcesionServiceImpl.get(contratoSupervisoraVO.getMcoId());
            t_modconc = modalidadConcesionVO.getMcoNombre();
            codigoModalidadConcesion = modalidadConcesionVO.getMcoId();

            contratoCompromisoVO = contratoCompromisoServiceImpl.get(contratoSupervisoraVO.getCcoId());
            plazo = contratoCompromisoVO.getCcoPlazo(); //plazo
            total = contratoCompromisoVO.getCcoTotal(); //total
            monedaVO = monedaServiceImpl.get(contratoCompromisoVO.getMonId());
            codigoMoneda = monedaVO.getMonId(); //moneda
            nombreMoneda = monedaVO.getMonNombre();
            contratoCompromisoSeleccionadoE = contratoCompromisoVO.getCcoId();
            System.out.println("asdfgwedfnmsdfljsdm");
            System.out.println(contratoCompromisoSeleccionadoE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar() throws SQLException {

        try {
            SimpleDateFormat dt2 = new SimpleDateFormat("dd-mm-yyyy");

            contratoSupervisoraVO.setCpsNroDeContrato(contratoE);

            /*  contratoSupervisoraVO.setCpsAnyo(Integer.parseInt(añohrE));
                        contratoSupervisoraVO.setCpsStd(Integer.parseInt(nrohrE));
                        contratoSupervisoraVO.setCpsFechaRegistro(dt2.parse(fregE));
                        contratoSupervisoraVO.setCpsAsunto(asuntohrE);  */

            contratoSupervisoraVO.setCpsFechaInicio(fechaInicioE);
            contratoSupervisoraVO.setCpsFechaSuscripcion(fechaSuscripcionE);
            contratoSupervisoraVO.setCpsAdelantoOtorgado(adelantoE);
            contratoSupervisoraVO.setCpsPlazoContrato(plazocontrE);
            contratoSupervisoraVO.setCpsMontoContratado(montocontrE);
            contratoSupervisoraVO.setCpsFechaAdelanto(fechaAdelantoE);
            contratoSupervisoraVO.setCpsPenalidades(cpsPenalidadesE);
            contratoSupervisoraVO.setCpsCaducidad(cpsCaducidadE);
            contratoSupervisoraVO.setCpsGarantias(cpsGarantiasE);
            contratoSupervisoraVO.setConId(codigoContratoE);
            contratoSupervisoraVO.setCpsEstado(1);
            contratoSupervisoraVO.setCpsFechaCambio(util.getObtenerFechaHoy());
            contratoSupervisoraVO.setCpsUsuarioCambio(usuario.getUsuAlias());

            contratoSupervisoraVO.setSupId(codigoEmpresaSupervisora);
            contratoSupervisoraVO.setConId(contratoSeleccionado);
            contratoSupervisoraVO.setCsiId(codigoConcesion);
            contratoSupervisoraVO.setTinId(codigoTipoInfra);
            contratoSupervisoraVO.setMcoId(codigoModalidadConcesion);
            //contratoSupervisoraVO.setInfId(1);
            //contratoSupervisoraVO.setInfId(1);
            contratoSupervisoraVO.setCcoPlazo(plazo); //plazo
            contratoSupervisoraVO.setCcoTotal(total);
            contratoSupervisoraVO.setMonId(codigoMoneda);
            contratoSupervisoraVO.setTccTipo(tccTipo);
            contratoSupervisoraVO.setCcoId(ccoId);


            //pdf */

            contratoEmpresaSupervisoraServiceImpl.update(contratoSupervisoraVO);
            RequestContext.getCurrentInstance().execute("popupeditar.hide()");
            listanombrerol();
            cargarListaContratosEmpresaSupervisora();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se Modificó con Éxito"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // --------editar ------

    public void cargarListaContratosE() {
        try {
            listaContratosE = contratoConcesionServiceImp.buscarContratos1(tipoInfraestructura);

            for (ContratoVO contra : listaContratosE) {
                ConcesionVO concesion = new ConcesionVO();

                concesion = concesionServiceImpl.get(contra.getCsiId());
                contra.setNombreConcesion(concesion.getCsiNombre());
                contra.setCodigoConcesion(concesion.getCsiId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elegirContratoE(ContratoVO contratoVO) {

        try {
            codigoConcesion = contratoVO.getCsiId();
            concesionVO = concesionServiceImpl.get(codigoConcesion);
            codigoModalidadConcesion = contratoVO.getMcoId();
            codigoTipoInfra = concesionVO.getTinId();
            codigoContratoE = contratoVO.getConId();
            t_conce = concesionVO.getCsiNombre();
            modalidadVO = modalidadServiceImp.get(codigoModalidadConcesion);
            t_modconc = modalidadVO.getMcoNombre();
            infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(codigoTipoInfra);
            t_tinfra = infraestructuraTipoVO.getTinNombre();
            listaInfraestructurasE = infraestructuraServiceImpl.query2(concesionVO.getCsiId());
            listaContratoCompromisoE = contratoCompromisoServiceImpl.query1(codigoContratoE);

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "La ficha ingresada no existe. Puede hacer el ingreso manualmente"));
            e.printStackTrace();
        }
    }

    public void cargarDatosCompromisoE() {

        try {
            contratoCompromisoVO = contratoCompromisoServiceImpl.get(contratoCompromisoSeleccionadoE);
            codigoContratoCompromisoE = contratoCompromisoVO.getCcoId();
            plazo = contratoCompromisoVO.getCcoPlazo();
            total = contratoCompromisoVO.getCcoTotal();
            codigoMoneda = contratoCompromisoVO.getMonId();
            monedaVO = monedaServiceImpl.get(codigoMoneda);
            nombreMoneda = monedaVO.getMonNombre();
            total = contratoCompromisoVO.getCcoTotal();
            codigoMoneda = contratoCompromisoVO.getMonId();
            ccoId = contratoCompromisoVO.getCcoId();
            tccTipo = contratoCompromisoVO.getTccTipo();


        } catch (Exception e) {
            System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
            e.printStackTrace();
        }
    }
    //--Fin editar contrato empresa superisora --//

    //----Buscar --//
    public void buscarTipoInfraestructura() {
        try {
            if (tipoInfraestructuraSeleccionada == 0) {
                int contador = 1;
                listaContratoSupervisora = contratoEmpresaSupervisoraServiceImpl.query();
                for (int i = 0; i < listaContratoSupervisora.size(); i++) {
                    listanombrerol();
                    listaContratoSupervisora.get(i).setContador(contador);
                    contador++;
                }
            } else {
                int contador = 1;
                listaContratoSupervisora =
                    contratoEmpresaSupervisoraServiceImpl.queryTD(tipoInfraestructuraSeleccionada);
                for (int i = 0; i < listaContratoSupervisora.size(); i++) {
                    listanombrerol();
                    listaContratoSupervisora.get(i).setContador(contador);
                    contador++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ContratoSupervisoraVO> buscarConEmpSup() throws SQLException {
        try {
            listaContratoSupervisora =
                this.contratoEmpresaSupervisoraServiceImpl.filtrarContraEmpSup(empresaSupervisora);
            listanombrerol();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaContratoSupervisora;
    }

    public void cargarTodo() {
        try {

            int contador = 1;
            listaContratoSupervisora = contratoEmpresaSupervisoraServiceImpl.query();
            for (int i = 0; i < listaContratoSupervisora.size(); i++) {
                listanombrerol();
                listaContratoSupervisora.get(i).setContador(contador);
                contador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " No se pudo listar"));
        }
    }
    //-- fin Buscar --//

    //--eliminar--//
    public void cargarEliminar() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("nroContrato");
        codigoEliminar = Integer.valueOf(str.toString());
        System.out.println("EL CÓDIGO ES :     " + codigoEliminar);
    }

    public void eliminar() throws SQLException {
        try {
            contratoEmpresaSupervisoraServiceImpl.delete(codigoEliminar);
            cargarListaContratosEmpresaSupervisora();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se Eliminó con Éxito"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //--fin eliminar--//


    //---guardar tabla   ---//
    public void tAdenda() {
        if (cpsNroDeContrato == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar Número de contrato"));
        } else {
            RequestContext.getCurrentInstance().execute("agregarAdenda.show();");
        }

    }

    public void guardarTabla() {
        if (adendaPlazo == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar plazo"));
        } else if (adendaMonto == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar Monto"));
        } else if (adendaFecha == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar Fecha"));
        } else {
            try {
                MonedaVO monNombre = getMonedaServiceImpl().get(monedaSeleccionada1);
                contratoSupervisoraAdendaVO = new ContratoSupervisoraAdendaVO();
                contratoSupervisoraAdendaVO.setCpsNroDeContrato(cpsNroDeContrato);
                if (dia) {
                    contratoSupervisoraAdendaVO.setCsaPlazo(adendaPlazo + " " + "días");
                } else if (mes) {
                    contratoSupervisoraAdendaVO.setCsaPlazo(adendaPlazo + " " + "mes");
                } else if (año) {
                    contratoSupervisoraAdendaVO.setCsaPlazo(adendaPlazo + " " + "año");
                }
                contratoSupervisoraAdendaVO.setCsaMonto(adendaMonto);
                contratoSupervisoraAdendaVO.setCsaFecha(adendaFecha);


                contratoSupervisoraAdendaVO.setMonId(monedaSeleccionada1);
                contratoSupervisoraAdendaVO.setNombreMoneda(monNombre.getMonNombre());
                contratoSupervisoraAdendaVO.setCsaAdenda(adendaPDF);
                RequestContext.getCurrentInstance().execute("agregarAdenda.hide()");
                listanombrerol();
                if (listaAdenda.size() > 0) {
                    listaAdenda.add(listaAdenda.size() - 1, contratoSupervisoraAdendaVO);
                } else {
                    listaAdenda.add(contratoSupervisoraAdendaVO);
                }

                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                              "Se agregó Adenda Correctamente"));
                //(listaAdenda.add(contratoSupervisoraAdendaVO);

                //contratoEmpresaSupervisoraAdendaServiceImpl.insert(contratoSupervisoraAdendaVO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //--- fin guardar tabla   ---//

    //--quitar lista --//

    public void quitarLista() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("indexLista");
        int idcodigo = Integer.valueOf(str.toString());
        listaAdenda.remove(idcodigo);
    }

    //--fin quitar lista -- //


    // -- -- GETTER AND SETTER  -- //


    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
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

    public void setCodigoEliminar(int codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }

    public int getCodigoEliminar() {
        return codigoEliminar;
    }

    public void setContratoE(int contratoE) {
        this.contratoE = contratoE;
    }

    public int getContratoE() {
        return contratoE;
    }

    public void setSupIdE(String supIdE) {
        this.supIdE = supIdE;
    }

    public String getSupIdE() {
        return supIdE;
    }

    public void setT_modconcE(String t_modconcE) {
        this.t_modconcE = t_modconcE;
    }

    public String getT_modconcE() {
        return t_modconcE;
    }

    public void setTinIdE(int tinIdE) {
        this.tinIdE = tinIdE;
    }

    public int getTinIdE() {
        return tinIdE;
    }

    public void setCsiIdE(int csiIdE) {
        this.csiIdE = csiIdE;
    }

    public int getCsiIdE() {
        return csiIdE;
    }

    public void setAdelantoE(int adelantoE) {
        this.adelantoE = adelantoE;
    }

    public int getAdelantoE() {
        return adelantoE;
    }

    public void setPlazocontrE(int plazocontrE) {
        this.plazocontrE = plazocontrE;
    }

    public int getPlazocontrE() {
        return plazocontrE;
    }

    public void setMontocontrE(int montocontrE) {
        this.montocontrE = montocontrE;
    }

    public int getMontocontrE() {
        return montocontrE;
    }

    public void setNrohrE(String nrohrE) {
        this.nrohrE = nrohrE;
    }

    public String getNrohrE() {
        return nrohrE;
    }

    public void setAñohrE(String añohrE) {
        this.añohrE = añohrE;
    }

    public String getAñohrE() {
        return añohrE;
    }

    public void setFregE(String fregE) {
        this.fregE = fregE;
    }

    public String getFregE() {
        return fregE;
    }

    public void setAsuntohrE(String asuntohrE) {
        this.asuntohrE = asuntohrE;
    }

    public String getAsuntohrE() {
        return asuntohrE;
    }

    public void setCpsPenalidadesE(String cpsPenalidadesE) {
        this.cpsPenalidadesE = cpsPenalidadesE;
    }

    public String getCpsPenalidadesE() {
        return cpsPenalidadesE;
    }

    public void setCpsCaducidadE(String cpsCaducidadE) {
        this.cpsCaducidadE = cpsCaducidadE;
    }

    public String getCpsCaducidadE() {
        return cpsCaducidadE;
    }

    public void setCpsGarantiasE(String cpsGarantiasE) {
        this.cpsGarantiasE = cpsGarantiasE;
    }

    public String getCpsGarantiasE() {
        return cpsGarantiasE;
    }

    public void setT_concesionE(String t_concesionE) {
        this.t_concesionE = t_concesionE;
    }

    public String getT_concesionE() {
        return t_concesionE;
    }

    public void setT_tinfraE(String t_tinfraE) {
        this.t_tinfraE = t_tinfraE;
    }

    public String getT_tinfraE() {
        return t_tinfraE;
    }

    public void setFechaInicioE(Date fechaInicioE) {
        this.fechaInicioE = fechaInicioE;
    }

    public Date getFechaInicioE() {
        return fechaInicioE;
    }

    public void setFechaSuscripcionE(Date fechaSuscripcionE) {
        this.fechaSuscripcionE = fechaSuscripcionE;
    }

    public Date getFechaSuscripcionE() {
        return fechaSuscripcionE;
    }

    public void setFechaAdelantoE(Date fechaAdelantoE) {
        this.fechaAdelantoE = fechaAdelantoE;
    }

    public Date getFechaAdelantoE() {
        return fechaAdelantoE;
    }

    public void setContratoSeleccionado(int contratoSeleccionado) {
        this.contratoSeleccionado = contratoSeleccionado;
    }

    public int getContratoSeleccionado() {
        return contratoSeleccionado;
    }

    public void setDia(boolean dia) {
        this.dia = dia;
    }

    public boolean isDia() {
        return dia;
    }

    public void setMes(boolean mes) {
        this.mes = mes;
    }

    public boolean isMes() {
        return mes;
    }

    public void setAño(boolean año) {
        this.año = año;
    }

    public boolean isAño() {
        return año;
    }

    public void setCodigoContratoCompromiso(int codigoContratoCompromiso) {
        this.codigoContratoCompromiso = codigoContratoCompromiso;
    }

    public int getCodigoContratoCompromiso() {
        return codigoContratoCompromiso;
    }

    public void setCodigoContratoCompromisoE(int codigoContratoCompromisoE) {
        this.codigoContratoCompromisoE = codigoContratoCompromisoE;
    }

    public int getCodigoContratoCompromisoE() {
        return codigoContratoCompromisoE;
    }

    public void setSeleccionaTipoInfraestructura(String seleccionaTipoInfraestructura) {
        this.seleccionaTipoInfraestructura = seleccionaTipoInfraestructura;
    }

    public String getSeleccionaTipoInfraestructura() {
        return seleccionaTipoInfraestructura;
    }

    public void setBtnbuscar(String btnbuscar) {
        this.btnbuscar = btnbuscar;
    }

    public String getBtnbuscar() {
        return btnbuscar;
    }

    public void setNrohr(String nrohr) {
        this.nrohr = nrohr;
    }

    public String getNrohr() {
        return nrohr;
    }

    public void setAñohr(String añohr) {
        this.añohr = añohr;
    }

    public String getAñohr() {
        return añohr;
    }

    public void setFreg(String freg) {
        this.freg = freg;
    }

    public String getFreg() {
        return freg;
    }

    public void setAsuntohr(String asuntohr) {
        this.asuntohr = asuntohr;
    }

    public String getAsuntohr() {
        return asuntohr;
    }

    public void setContratoConcesion(String contratoConcesion) {
        this.contratoConcesion = contratoConcesion;
    }

    public String getContratoConcesion() {
        return contratoConcesion;
    }

    public void setT_tinfra(String t_tinfra) {
        this.t_tinfra = t_tinfra;
    }

    public String getT_tinfra() {
        return t_tinfra;
    }

    public void setT_modconc(String t_modconc) {
        this.t_modconc = t_modconc;
    }

    public String getT_modconc() {
        return t_modconc;
    }

    public void setT_conce(String t_conce) {
        this.t_conce = t_conce;
    }

    public String getT_conce() {
        return t_conce;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setNombreEmpresaSupervisora(String nombreEmpresaSupervisora) {
        this.nombreEmpresaSupervisora = nombreEmpresaSupervisora;
    }

    public String getNombreEmpresaSupervisora() {
        return nombreEmpresaSupervisora;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setCodigoEmpresaSupervisora(int codigoEmpresaSupervisora) {
        this.codigoEmpresaSupervisora = codigoEmpresaSupervisora;
    }

    public int getCodigoEmpresaSupervisora() {
        return codigoEmpresaSupervisora;
    }

    public void setCodigoMoneda(int codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public int getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setContratoCompromisoSeleccionado(int contratoCompromisoSeleccionado) {
        this.contratoCompromisoSeleccionado = contratoCompromisoSeleccionado;
    }

    public int getContratoCompromisoSeleccionado() {
        return contratoCompromisoSeleccionado;
    }

    public void setContratoCompromisoSeleccionadoE(int contratoCompromisoSeleccionadoE) {
        this.contratoCompromisoSeleccionadoE = contratoCompromisoSeleccionadoE;
    }

    public int getContratoCompromisoSeleccionadoE() {
        return contratoCompromisoSeleccionadoE;
    }

    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContratoE(int codigoContratoE) {
        this.codigoContratoE = codigoContratoE;
    }

    public int getCodigoContratoE() {
        return codigoContratoE;
    }

    public void setTipoInfraestructuraSeleccionada(int tipoInfraestructuraSeleccionada) {
        this.tipoInfraestructuraSeleccionada = tipoInfraestructuraSeleccionada;
    }

    public int getTipoInfraestructuraSeleccionada() {
        return tipoInfraestructuraSeleccionada;
    }

    public void setInfraestructuraSeleccionada(int infraestructuraSeleccionada) {
        this.infraestructuraSeleccionada = infraestructuraSeleccionada;
    }

    public int getInfraestructuraSeleccionada() {
        return infraestructuraSeleccionada;
    }

    public void setInfraestructuraSeleccionadaE(int infraestructuraSeleccionadaE) {
        this.infraestructuraSeleccionadaE = infraestructuraSeleccionadaE;
    }

    public int getInfraestructuraSeleccionadaE() {
        return infraestructuraSeleccionadaE;
    }

    public void setInversionSeleccionada(int inversionSeleccionada) {
        this.inversionSeleccionada = inversionSeleccionada;
    }

    public int getInversionSeleccionada() {
        return inversionSeleccionada;
    }

    public void setInversionSeleccionadaE(int inversionSeleccionadaE) {
        this.inversionSeleccionadaE = inversionSeleccionadaE;
    }

    public int getInversionSeleccionadaE() {
        return inversionSeleccionadaE;
    }

    public void setMonedaSeleccionada(int monedaSeleccionada) {
        this.monedaSeleccionada = monedaSeleccionada;
    }

    public int getMonedaSeleccionada() {
        return monedaSeleccionada;
    }

    public void setMonedaSeleccionada1(int monedaSeleccionada1) {
        this.monedaSeleccionada1 = monedaSeleccionada1;
    }

    public int getMonedaSeleccionada1() {
        return monedaSeleccionada1;
    }

    public void setAdendasTipoSeleccionada(int adendasTipoSeleccionada) {
        this.adendasTipoSeleccionada = adendasTipoSeleccionada;
    }

    public int getAdendasTipoSeleccionada() {
        return adendasTipoSeleccionada;
    }

    public void setCpsNroDeContrato(int cpsNroDeContrato) {
        this.cpsNroDeContrato = cpsNroDeContrato;
    }

    public int getCpsNroDeContrato() {
        return cpsNroDeContrato;
    }

    public void setCpsPlazoContrato(int cpsPlazoContrato) {
        this.cpsPlazoContrato = cpsPlazoContrato;
    }

    public int getCpsPlazoContrato() {
        return cpsPlazoContrato;
    }

    public void setCpsMontoContratado(int cpsMontoContratado) {
        this.cpsMontoContratado = cpsMontoContratado;
    }

    public int getCpsMontoContratado() {
        return cpsMontoContratado;
    }

    public void setCpsAdelantoOtorgado(int cpsAdelantoOtorgado) {
        this.cpsAdelantoOtorgado = cpsAdelantoOtorgado;
    }

    public int getCpsAdelantoOtorgado() {
        return cpsAdelantoOtorgado;
    }

    public void setCodigoConcesion(int codigoConcesion) {
        this.codigoConcesion = codigoConcesion;
    }

    public int getCodigoConcesion() {
        return codigoConcesion;
    }

    public void setCpsPenalidades(String cpsPenalidades) {
        this.cpsPenalidades = cpsPenalidades;
    }

    public String getCpsPenalidades() {
        return cpsPenalidades;
    }

    public void setCpsCaducidad(String cpsCaducidad) {
        this.cpsCaducidad = cpsCaducidad;
    }

    public String getCpsCaducidad() {
        return cpsCaducidad;
    }

    public void setCpsGarantias(String cpsGarantias) {
        this.cpsGarantias = cpsGarantias;
    }

    public String getCpsGarantias() {
        return cpsGarantias;
    }

    public void setCenDocumentoFisico(String cenDocumentoFisico) {
        this.cenDocumentoFisico = cenDocumentoFisico;
    }

    public String getCenDocumentoFisico() {
        return cenDocumentoFisico;
    }

    public void setEmpresaSupervisora(String empresaSupervisora) {
        this.empresaSupervisora = empresaSupervisora;
    }

    public String getEmpresaSupervisora() {
        return empresaSupervisora;
    }

    public void setCpsFechaInicio(Date cpsFechaInicio) {
        this.cpsFechaInicio = cpsFechaInicio;
    }

    public Date getCpsFechaInicio() {
        return cpsFechaInicio;
    }

    public void setCpsFechaSuscripcion(Date cpsFechaSuscripcion) {
        this.cpsFechaSuscripcion = cpsFechaSuscripcion;
    }

    public Date getCpsFechaSuscripcion() {
        return cpsFechaSuscripcion;
    }

    public void setCpsFechaAdelanto(Date cpsFechaAdelanto) {
        this.cpsFechaAdelanto = cpsFechaAdelanto;
    }

    public Date getCpsFechaAdelanto() {
        return cpsFechaAdelanto;
    }

    public void setAdendaPlazo(int adendaPlazo) {
        this.adendaPlazo = adendaPlazo;
    }

    public int getAdendaPlazo() {
        return adendaPlazo;
    }

    public void setAdendaMonto(int adendaMonto) {
        this.adendaMonto = adendaMonto;
    }

    public int getAdendaMonto() {
        return adendaMonto;
    }

    public void setAdendaFecha(Date adendaFecha) {
        this.adendaFecha = adendaFecha;
    }

    public Date getAdendaFecha() {
        return adendaFecha;
    }

    public void setAdendaPDF(String adendaPDF) {
        this.adendaPDF = adendaPDF;
    }

    public String getAdendaPDF() {
        return adendaPDF;
    }

    public void setCodigoTipoInfra(int codigoTipoInfra) {
        this.codigoTipoInfra = codigoTipoInfra;
    }

    public int getCodigoTipoInfra() {
        return codigoTipoInfra;
    }

    public void setCodigoModalidadConcesion(int codigoModalidadConcesion) {
        this.codigoModalidadConcesion = codigoModalidadConcesion;
    }

    public int getCodigoModalidadConcesion() {
        return codigoModalidadConcesion;
    }

    public void setCodigoInfraestructura(int codigoInfraestructura) {
        this.codigoInfraestructura = codigoInfraestructura;
    }

    public int getCodigoInfraestructura() {
        return codigoInfraestructura;
    }

    public void setCcoId(int ccoId) {
        this.ccoId = ccoId;
    }

    public int getCcoId() {
        return ccoId;
    }

    public void setTccTipo(int tccTipo) {
        this.tccTipo = tccTipo;
    }

    public int getTccTipo() {
        return tccTipo;
    }

    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }

    public void setListarEntregas(List<ContratoSupervisoraVO> listarEntregas) {
        this.listarEntregas = listarEntregas;
    }

    public List<ContratoSupervisoraVO> getListarEntregas() {
        return listarEntregas;
    }

    public void setListContratoAdenda(List<ContratoAdendaVO> listContratoAdenda) {
        this.listContratoAdenda = listContratoAdenda;
    }

    public List<ContratoAdendaVO> getListContratoAdenda() {
        return listContratoAdenda;
    }

    public void setListarAdendasTipo(List<AdendaTipoVO> listarAdendasTipo) {
        this.listarAdendasTipo = listarAdendasTipo;
    }

    public List<AdendaTipoVO> getListarAdendasTipo() {
        return listarAdendasTipo;
    }

    public void setListaMoneda(List<MonedaVO> listaMoneda) {
        this.listaMoneda = listaMoneda;
    }

    public List<MonedaVO> getListaMoneda() {
        return listaMoneda;
    }

    public void setListaMoneda1(List<MonedaVO> listaMoneda1) {
        this.listaMoneda1 = listaMoneda1;
    }

    public List<MonedaVO> getListaMoneda1() {
        return listaMoneda1;
    }

    public void setListaInfraestructuras(List<InfraestructuraVO> listaInfraestructuras) {
        this.listaInfraestructuras = listaInfraestructuras;
    }

    public List<InfraestructuraVO> getListaInfraestructuras() {
        return listaInfraestructuras;
    }

    public void setListaInfraestructurasE(List<InfraestructuraVO> listaInfraestructurasE) {
        this.listaInfraestructurasE = listaInfraestructurasE;
    }

    public List<InfraestructuraVO> getListaInfraestructurasE() {
        return listaInfraestructurasE;
    }

    public void setListaInfraestructuraTipo(List<InfraestructuraTipoVO> listaInfraestructuraTipo) {
        this.listaInfraestructuraTipo = listaInfraestructuraTipo;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructuraTipo() {
        return listaInfraestructuraTipo;
    }

    public void setListaContratoSupervisora(List<ContratoSupervisoraVO> listaContratoSupervisora) {
        this.listaContratoSupervisora = listaContratoSupervisora;
    }

    public List<ContratoSupervisoraVO> getListaContratoSupervisora() {
        return listaContratoSupervisora;
    }

    public void setListaContratos(List<ContratoVO> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<ContratoVO> getListaContratos() {
        return listaContratos;
    }

    public void setListaContratosE(List<ContratoVO> listaContratosE) {
        this.listaContratosE = listaContratosE;
    }

    public List<ContratoVO> getListaContratosE() {
        return listaContratosE;
    }

    public void setListaContratoCompromiso(List<ContratoCompromisoVO> listaContratoCompromiso) {
        this.listaContratoCompromiso = listaContratoCompromiso;
    }

    public List<ContratoCompromisoVO> getListaContratoCompromiso() {
        return listaContratoCompromiso;
    }

    public void setListaContratoCompromisoE(List<ContratoCompromisoVO> listaContratoCompromisoE) {
        this.listaContratoCompromisoE = listaContratoCompromisoE;
    }

    public List<ContratoCompromisoVO> getListaContratoCompromisoE() {
        return listaContratoCompromisoE;
    }

    public void setListaEmpresaSup(List<EmpresaSupervisoraVO> listaEmpresaSup) {
        this.listaEmpresaSup = listaEmpresaSup;
    }

    public List<EmpresaSupervisoraVO> getListaEmpresaSup() {
        return listaEmpresaSup;
    }

    public void setListaEmpresaSupE(List<EmpresaSupervisoraVO> listaEmpresaSupE) {
        this.listaEmpresaSupE = listaEmpresaSupE;
    }

    public List<EmpresaSupervisoraVO> getListaEmpresaSupE() {
        return listaEmpresaSupE;
    }

    public void setListaAdenda(List<ContratoSupervisoraAdendaVO> listaAdenda) {
        this.listaAdenda = listaAdenda;
    }

    public List<ContratoSupervisoraAdendaVO> getListaAdenda() {
        return listaAdenda;
    }

    public void setListaAdenda1(List<ContratoSupervisoraAdendaVO> listaAdenda1) {
        this.listaAdenda1 = listaAdenda1;
    }

    public List<ContratoSupervisoraAdendaVO> getListaAdenda1() {
        return listaAdenda1;
    }

    public void setUtil(Util util) {
        this.util = util;
    }

    public Util getUtil() {
        return util;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    public void setViewTdInternosVO(ViewTdInternosVO viewTdInternosVO) {
        this.viewTdInternosVO = viewTdInternosVO;
    }

    public ViewTdInternosVO getViewTdInternosVO() {
        return viewTdInternosVO;
    }

    public void setDatosStdServiceImpl(DatosStdService datosStdServiceImpl) {
        this.datosStdServiceImpl = datosStdServiceImpl;
    }

    public DatosStdService getDatosStdServiceImpl() {
        return datosStdServiceImpl;
    }

    public void setContratoConcesionServiceImp(ContratoConcesionService contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public ContratoConcesionService getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }

    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }

    public void setConcesionServiceImpl(ConcesionService concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public ConcesionService getConcesionServiceImpl() {
        return concesionServiceImpl;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    public void setModalidadConcesionVO(ModalidadConcesionVO modalidadConcesionVO) {
        this.modalidadConcesionVO = modalidadConcesionVO;
    }

    public ModalidadConcesionVO getModalidadConcesionVO() {
        return modalidadConcesionVO;
    }

    public void setModalidadConcesionServiceImpl(ModalidadConcesionServiceImpl modalidadConcesionServiceImpl) {
        this.modalidadConcesionServiceImpl = modalidadConcesionServiceImpl;
    }

    public ModalidadConcesionServiceImpl getModalidadConcesionServiceImpl() {
        return modalidadConcesionServiceImpl;
    }

    public void setInfraestructuraServiceImpl(InfraestructuraServiceImpl infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public InfraestructuraServiceImpl getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }

    public void setInfraestructuraVO(InfraestructuraVO infraestructuraVO) {
        this.infraestructuraVO = infraestructuraVO;
    }

    public InfraestructuraVO getInfraestructuraVO() {
        return infraestructuraVO;
    }

    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }

    public Infraestructura getInfraestructura() {
        return infraestructura;
    }

    public void setInversionServiceImpl(InversionService inversionServiceImpl) {
        this.inversionServiceImpl = inversionServiceImpl;
    }

    public InversionService getInversionServiceImpl() {
        return inversionServiceImpl;
    }

    public void setContratoCompromisoServiceImpl(ContratoCompromisoService contratoCompromisoServiceImpl) {
        this.contratoCompromisoServiceImpl = contratoCompromisoServiceImpl;
    }

    public ContratoCompromisoService getContratoCompromisoServiceImpl() {
        return contratoCompromisoServiceImpl;
    }

    public void setContratoCompromisoVO(ContratoCompromisoVO contratoCompromisoVO) {
        this.contratoCompromisoVO = contratoCompromisoVO;
    }

    public ContratoCompromisoVO getContratoCompromisoVO() {
        return contratoCompromisoVO;
    }

    public void setContratoSupervisoraVO(ContratoSupervisoraVO contratoSupervisoraVO) {
        this.contratoSupervisoraVO = contratoSupervisoraVO;
    }

    public ContratoSupervisoraVO getContratoSupervisoraVO() {
        return contratoSupervisoraVO;
    }

    public void setContratoSupervisoraAdendaVO(ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO) {
        this.contratoSupervisoraAdendaVO = contratoSupervisoraAdendaVO;
    }

    public ContratoSupervisoraAdendaVO getContratoSupervisoraAdendaVO() {
        return contratoSupervisoraAdendaVO;
    }

    public void setMonedaServiceImpl(MonedaServiceImpl monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }

    public MonedaServiceImpl getMonedaServiceImpl() {
        return monedaServiceImpl;
    }

    public void setEmpresaSupervisoraServiceImpl(EmpresaSupervisoraService empresaSupervisoraServiceImpl) {
        this.empresaSupervisoraServiceImpl = empresaSupervisoraServiceImpl;
    }

    public EmpresaSupervisoraService getEmpresaSupervisoraServiceImpl() {
        return empresaSupervisoraServiceImpl;
    }

    public void setContratoNuevaAdendaVO(ContratoAdendaVO contratoNuevaAdendaVO) {
        this.contratoNuevaAdendaVO = contratoNuevaAdendaVO;
    }

    public ContratoAdendaVO getContratoNuevaAdendaVO() {
        return contratoNuevaAdendaVO;
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

    public void setContratoEmpresaSupervisoraServiceImpl(ContratoEmpresaSupervisoraServiceImpl contratoEmpresaSupervisoraServiceImpl) {
        this.contratoEmpresaSupervisoraServiceImpl = contratoEmpresaSupervisoraServiceImpl;
    }

    public ContratoEmpresaSupervisoraServiceImpl getContratoEmpresaSupervisoraServiceImpl() {
        return contratoEmpresaSupervisoraServiceImpl;
    }

    public void setContratoEmpresaSupervisoraAdendaServiceImpl(ContratoEmpresaSupervisoraAdendaServiceImpl contratoEmpresaSupervisoraAdendaServiceImpl) {
        this.contratoEmpresaSupervisoraAdendaServiceImpl = contratoEmpresaSupervisoraAdendaServiceImpl;
    }

    public ContratoEmpresaSupervisoraAdendaServiceImpl getContratoEmpresaSupervisoraAdendaServiceImpl() {
        return contratoEmpresaSupervisoraAdendaServiceImpl;
    }

    public void setModalidadVO(ModalidadConcesionVO modalidadVO) {
        this.modalidadVO = modalidadVO;
    }

    public ModalidadConcesionVO getModalidadVO() {
        return modalidadVO;
    }

    public void setModalidadServiceImp(ModalidadConcesionService modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionService getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public void setTipoInfraestructuraGlobal(int tipoInfraestructuraGlobal) {
        this.tipoInfraestructuraGlobal = tipoInfraestructuraGlobal;
    }

    public int getTipoInfraestructuraGlobal() {
        return tipoInfraestructuraGlobal;
    }

    public void setListaInfraestructurasC(List<InfraestructuraVO> listaInfraestructurasC) {
        this.listaInfraestructurasC = listaInfraestructurasC;
    }

    public List<InfraestructuraVO> getListaInfraestructurasC() {
        return listaInfraestructurasC;
    }

    public void setListaInversiones(List<InversionVO> listaInversiones) {
        this.listaInversiones = listaInversiones;
    }

    public List<InversionVO> getListaInversiones() {
        return listaInversiones;
    }
    
}
