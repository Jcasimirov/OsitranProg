package com.ositran.contratos;


import com.ositran.model.Infraestructura;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.DatosStdService;
import com.ositran.service.EmpresaSupervisoraService;
import com.ositran.service.InversionService;
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
    //public final int formulario = 27;
    //private RolOpcionesVO rolOpcion;

    //public void validarSesion() throws IOException {
      //  rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
    //}

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


    //finEditar//
    private boolean dia;
    private boolean mes;
    private boolean año;

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
    private int codigoEmpresaSupervisora;
    private int codigoMoneda;
    private String nombreMoneda;
    private int contratoCompromisoSeleccionado;
    private int contratoCompromisoSeleccionadoE;
    private int codigoContrato;
    private int codigoContratoE;
    private int añohrbus;
    private int nrohrbus;
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
    private List<MonedaVO> listaMoneda = new ArrayList<>();
    private List<MonedaVO> listaMoneda1 = new ArrayList<>();
    private List<InfraestructuraVO> listaInfraestructuras = new ArrayList<>();
    private List<InfraestructuraVO> listaInfraestructurasE = new ArrayList<>();
    private List<InfraestructuraTipoVO> listaInfraestructuraTipo = new ArrayList<>();
    private List<ContratoSupervisoraVO> listaContratoSupervisora = new ArrayList<>();
    private List<ContratoVO> listaContratos = new ArrayList<>();
    private List<ContratoVO> listaContratosE = new ArrayList<>();
   
    private List<ContratoCompromisoVO> listaContratoCompromiso = new ArrayList<>();
    private List<ContratoCompromisoVO> listaContratoCompromisoE = new ArrayList<>();
    private List<EmpresaSupervisoraVO> listaEmpresaSup;
    private List<EmpresaSupervisoraVO> listaEmpresaSupE;
    private List<ContratoSupervisoraAdendaVO> listaAdenda = new ArrayList<>();
    private List<ContratoSupervisoraAdendaVO> listaAdenda1 = new ArrayList<>();


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

    public void listanombrerol() {
        try {
            for (ContratoSupervisoraVO cEmpreSup : listaContratoSupervisora) {
                InfraestructuraTipoVO infratipo = getInfraestructuraTipoServiceImpl().get(cEmpreSup.getTinId());
                cEmpreSup.setNombreInfraestructura(infratipo.getTinNombre());
                EmpresaSupervisoraVO empsup = getEmpresaSupervisoraServiceImpl().get(cEmpreSup.getSupId());
                cEmpreSup.setNombreSupervisora(empsup.getSupNombre());
            }
        } catch (Exception e) {
            // TODO: Add catch code
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

        SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
        try {
            viewTdInternosVO = datosStdServiceImpl.BuscaStd(Integer.parseInt(añohr), nrohr);
            if (viewTdInternosVO != null) {
                freg = dt1.format(viewTdInternosVO.getFechaRegistro());
                asuntohr = viewTdInternosVO.getAsunto();

            } else {
                freg = "";
                asuntohr = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void BuscarStdE() throws SQLException {

        SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
        try {
            viewTdInternosVO = datosStdServiceImpl.BuscaStd(Integer.parseInt(añohrE), nrohrE);
            if (viewTdInternosVO != null) {
                fregE = dt1.format(viewTdInternosVO.getFechaRegistro());
                asuntohrE = viewTdInternosVO.getAsunto();

            } else {
                freg = "";
                asuntohr = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //--fin buscar std--//

    //----buscar contrato concesion--//
    public void cargarListaContratos() {
        try {
            listanombrerol();
            listaContratos = contratoConcesionServiceImp.query();

            for (ContratoVO contra : listaContratos) {
                concesionVO = concesionServiceImpl.get(contra.getCsiId());
                contratoVO = contratoConcesionServiceImp.get(contra.getConId());

                modalidadConcesionVO = modalidadConcesionServiceImpl.get(contra.getMcoId());
                infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(contra.getTinId());

                codigoContrato = contratoVO.getConId();

                contra.setConId(concesionVO.getCsiId());
                contra.setNombreConcesion(concesionVO.getCsiNombre());

                contra.setNombreModalidad(modalidadConcesionVO.getMcoNombre());
                contra.setMcoId(modalidadConcesionVO.getMcoId());

                contra.setNombreInfraTipo(infraestructuraTipoVO.getTinNombre());
                contra.setTinId(infraestructuraTipoVO.getTinId());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elegirContrato(ContratoVO contrato1) {
        try {
            //listanombrerol();
            codigoContrato = contrato1.getConId();

            concesionVO = concesionServiceImpl.get(contrato1.getCncId());
            listaInfraestructuras = infraestructuraServiceImpl.query2(concesionVO.getCsiId());
            listaContratoCompromiso = contratoCompromisoServiceImpl.query1(codigoContrato);

            t_conce = contrato1.getNombreConcesion();
            codigoConcesion = contrato1.getCsiId();

            t_tinfra = contrato1.getNombreInfraTipo();
            codigoTipoInfra = contrato1.getTinId();

            t_modconc = contrato1.getNombreModalidad();
            codigoModalidadConcesion = contrato1.getMcoId();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarDatosCompromiso() {
        try {
            listanombrerol();
            contratoCompromisoVO = contratoCompromisoServiceImpl.get(contratoCompromisoSeleccionado);
            plazo = contratoCompromisoVO.getCcoPlazo();
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
        } else if (freg.equals(0) || asuntohr.equals(0)) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar Datos STD"));
        } else if (cpsMontoContratado < cpsAdelantoOtorgado) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "El Monto no puede ser menor al Adelanto"));
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
                contratoSupervisoraVO.setCpsFechaRegistro(new Date(freg));
                contratoSupervisoraVO.setCpsAsunto(asuntohr);
                contratoSupervisoraVO.setSupId(codigoEmpresaSupervisora);
                contratoSupervisoraVO.setConId(codigoContrato);

                contratoSupervisoraVO.setCpsEstado(1);
                contratoSupervisoraVO.setCpsFechaAlta(new Date());
                contratoSupervisoraVO.setCpsUsuarioAlta("Jcasimiro");
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
                                                                              "Se Registro con Exito"));
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
        listaInfraestructuras = new ArrayList<>();
        
        listaContratoCompromiso = new ArrayList<>();
        plazo = "";
        total = new BigDecimal("0");
        codigoMoneda = 0;
        cpsNroDeContrato = 0;
        cpsFechaInicio = null;
        cpsFechaSuscripcion = null;
        cpsPlazoContrato = 0;
        cpsMontoContratado = 0;
        //listaMoneda  = new ArrayList<>();
        cpsAdelantoOtorgado = 0;
        cpsFechaAdelanto = null;
        cpsPenalidades = "";
        cpsCaducidad = "";
        cpsGarantias = "";
        cenDocumentoFisico = "";
        listaAdenda = new ArrayList<>();

    }
    //-- fin limpiar campos--//


    //---VERrrrr---
    public void cargarVer(ContratoSupervisoraVO contratoSupervisoraV) {
        
        try {
            
            listanombrerol();           
            contratoSupervisoraVO = contratoSupervisoraV;
            concesionVO=concesionServiceImpl.get(contratoSupervisoraVO.getCsiId());
            contratoE =  contratoSupervisoraVO.getCpsNroDeContrato();

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

            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            Object str = requestMap.get("idModificar");
            Integer idcodigo = Integer.valueOf(str.toString());
            contratoSupervisoraVO = contratoEmpresaSupervisoraServiceImpl.get(idcodigo);

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
            fregE = String.valueOf(contratoSupervisoraVO.getCpsFechaRegistro());
            nrohrE = String.valueOf(contratoSupervisoraVO.getCpsStd());
            añohrE = String.valueOf(contratoSupervisoraVO.getCpsAnyo());

            
            EmpresaSupervisoraVO empresaSupervisoraVO = new EmpresaSupervisoraVO();
            empresaSupervisoraVO = empresaSupervisoraServiceImpl.get(contratoSupervisoraVO.getSupId());
            nombreEmpresaSupervisora = empresaSupervisoraVO.getSupNombre();
            codigoEmpresaSupervisora= empresaSupervisoraVO.getSupId();
            
            
            ConcesionVO concesionVO = new ConcesionVO();
            concesionVO = concesionServiceImpl.get(contratoSupervisoraVO.getCsiId());
            t_conce = concesionVO.getCsiNombre();
            
            InfraestructuraTipoVO infraestructuraTipoVO = new InfraestructuraTipoVO();
            infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(contratoSupervisoraVO.getTinId());
            t_tinfra = infraestructuraTipoVO.getTinNombre();
           
            
            ModalidadConcesionVO modalidadConcesionVO = new ModalidadConcesionVO();
            modalidadConcesionVO = modalidadConcesionServiceImpl.get(contratoSupervisoraVO.getMcoId());
            t_modconc = modalidadConcesionVO.getMcoNombre();
            
            
            //aeropuerto
            //inversion


            //lsita


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
            contratoSupervisoraVO.setCpsUsuarioCambio("Cambio");

            contratoSupervisoraVO.setSupId(codigoEmpresaSupervisora);

            contratoSupervisoraVO.setCsiId(codigoConcesion);
            contratoSupervisoraVO.setTinId(codigoTipoInfra);
            contratoSupervisoraVO.setMcoId(codigoModalidadConcesion);
            //contratoSupervisoraVO.setInfId(1);
            //contratoSupervisoraVO.setInfId(1);
            contratoSupervisoraVO.setCcoPlazo(plazo);//plazo
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
                                                                          "Se Modifico con Exito"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    // --------editar ------


    public void cargarListaContratosE() {
        try {
            listanombrerol();
            listaContratosE = contratoConcesionServiceImp.query();

            for (ContratoVO contra : listaContratosE) {
                concesionVO = concesionServiceImpl.get(contra.getCsiId());
                contratoVO = contratoConcesionServiceImp.get(contra.getConId());

                modalidadConcesionVO = modalidadConcesionServiceImpl.get(contra.getMcoId());
                infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(contra.getTinId());

                codigoContratoE = contratoVO.getConId();

                contra.setConId(concesionVO.getCsiId());
                contra.setNombreConcesion(concesionVO.getCsiNombre());

                contra.setNombreModalidad(modalidadConcesionVO.getMcoNombre());
                contra.setMcoId(modalidadConcesionVO.getMcoId());

                contra.setNombreInfraTipo(infraestructuraTipoVO.getTinNombre());
                contra.setTinId(infraestructuraTipoVO.getTinId());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elegirContratoE(ContratoVO contrato1) {
        try {
            //listanombrerol();
            codigoContratoE = contrato1.getConId();

            concesionVO = concesionServiceImpl.get(contrato1.getCncId());
            listaInfraestructurasE = infraestructuraServiceImpl.query2(concesionVO.getCsiId());
            listaContratoCompromisoE = contratoCompromisoServiceImpl.query1(codigoContratoE);

            t_conce = contrato1.getNombreConcesion();
            codigoConcesion = contrato1.getCsiId();

            t_tinfra = contrato1.getNombreInfraTipo();
            codigoTipoInfra = contrato1.getTinId();

            t_modconc = contrato1.getNombreModalidad();
            codigoModalidadConcesion = contrato1.getMcoId();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarDatosCompromisoE() {
        try {
            listanombrerol();
            contratoCompromisoVO = contratoCompromisoServiceImpl.get(contratoCompromisoSeleccionadoE);
            plazo = contratoCompromisoVO.getCcoPlazo();
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
        System.out.println("EL CODIGO ES :     " + codigoEliminar);
    }

    public void eliminar() throws SQLException {
        try {
            contratoEmpresaSupervisoraServiceImpl.delete(codigoEliminar);
            cargarListaContratosEmpresaSupervisora();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se Elimino con Exito"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //--fin eliminar--//


    //---guardar tabla   ---//
    public void tAdenda() {
        if (cpsNroDeContrato == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Ingresar Número de contrato"));
        } else {
            RequestContext.getCurrentInstance().execute("agregarAdenda.show();");
        }

    }

    public void guardarTabla() {
        if (adendaPlazo == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Ingresar plazo"));
        } else if (adendaMonto == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Ingresar Monto"));
        } else if (adendaFecha == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Ingresar Fecha"));
        } else {
            try {
                MonedaVO monNombre = getMonedaServiceImpl().get(monedaSeleccionada1);
                contratoSupervisoraAdendaVO = new ContratoSupervisoraAdendaVO();
                contratoSupervisoraAdendaVO.setCpsNroDeContrato(cpsNroDeContrato);
                if (dia) {
                    contratoSupervisoraAdendaVO.setCsaPlazo(adendaPlazo + " " + "dias");
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
                                                                              "Se agrego Adenda Correctamente"));
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

    public void setTipoInfraestructuraSeleccionada(int tipoInfraestructuraSeleccionada) {
        this.tipoInfraestructuraSeleccionada = tipoInfraestructuraSeleccionada;
    }

    public int getTipoInfraestructuraSeleccionada() {
        return tipoInfraestructuraSeleccionada;
    }

    public void setListaInfraestructuraTipo(List<InfraestructuraTipoVO> listaInfraestructuraTipo) {
        this.listaInfraestructuraTipo = listaInfraestructuraTipo;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructuraTipo() {
        return listaInfraestructuraTipo;
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

    public void setListaContratoSupervisora(List<ContratoSupervisoraVO> listaContratoSupervisora) {
        this.listaContratoSupervisora = listaContratoSupervisora;
    }

    public List<ContratoSupervisoraVO> getListaContratoSupervisora() {
        return listaContratoSupervisora;
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

    public void setAñohrbus(int añohrbus) {
        this.añohrbus = añohrbus;
    }

    public int getAñohrbus() {
        return añohrbus;
    }

    public void setNrohrbus(int nrohrbus) {
        this.nrohrbus = nrohrbus;
    }

    public int getNrohrbus() {
        return nrohrbus;
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

    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public int getCodigoContrato() {
        return codigoContrato;
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

    public void setListaContratos(List<ContratoVO> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<ContratoVO> getListaContratos() {
        return listaContratos;
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

    public void setInfraestructuraSeleccionada(int infraestructuraSeleccionada) {
        this.infraestructuraSeleccionada = infraestructuraSeleccionada;
    }

    public int getInfraestructuraSeleccionada() {
        return infraestructuraSeleccionada;
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

    public void setInversionSeleccionada(int inversionSeleccionada) {
        this.inversionSeleccionada = inversionSeleccionada;
    }

    public int getInversionSeleccionada() {
        return inversionSeleccionada;
    }

    public void setContratoCompromisoSeleccionado(int contratoCompromisoSeleccionado) {
        this.contratoCompromisoSeleccionado = contratoCompromisoSeleccionado;
    }

    public int getContratoCompromisoSeleccionado() {
        return contratoCompromisoSeleccionado;
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

    public void setCodigoMoneda(int codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public int getCodigoMoneda() {
        return codigoMoneda;
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


    public void setContratoEmpresaSupervisoraServiceImpl(ContratoEmpresaSupervisoraServiceImpl contratoEmpresaSupervisoraServiceImpl) {
        this.contratoEmpresaSupervisoraServiceImpl = contratoEmpresaSupervisoraServiceImpl;
    }

    public ContratoEmpresaSupervisoraServiceImpl getContratoEmpresaSupervisoraServiceImpl() {
        return contratoEmpresaSupervisoraServiceImpl;
    }

    public void setMonedaSeleccionada(int monedaSeleccionada) {
        this.monedaSeleccionada = monedaSeleccionada;
    }

    public int getMonedaSeleccionada() {
        return monedaSeleccionada;
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

    public void setMonedaServiceImpl(MonedaServiceImpl monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }

    public MonedaServiceImpl getMonedaServiceImpl() {
        return monedaServiceImpl;
    }

    public void setListaEmpresaSup(List<EmpresaSupervisoraVO> listaEmpresaSup) {
        this.listaEmpresaSup = listaEmpresaSup;
    }

    public List<EmpresaSupervisoraVO> getListaEmpresaSup() {
        return listaEmpresaSup;
    }

    public void setEmpresaSupervisoraServiceImpl(EmpresaSupervisoraService empresaSupervisoraServiceImpl) {
        this.empresaSupervisoraServiceImpl = empresaSupervisoraServiceImpl;
    }

    public EmpresaSupervisoraService getEmpresaSupervisoraServiceImpl() {
        return empresaSupervisoraServiceImpl;
    }


    public void setNombreEmpresaSupervisora(String nombreEmpresaSupervisora) {
        this.nombreEmpresaSupervisora = nombreEmpresaSupervisora;
    }

    public String getNombreEmpresaSupervisora() {
        return nombreEmpresaSupervisora;
    }


    public void setContratoNuevaAdendaVO(ContratoAdendaVO contratoNuevaAdendaVO) {
        this.contratoNuevaAdendaVO = contratoNuevaAdendaVO;
    }

    public ContratoAdendaVO getContratoNuevaAdendaVO() {
        return contratoNuevaAdendaVO;
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

    public void setEmpresaSupervisora(String empresaSupervisora) {
        this.empresaSupervisora = empresaSupervisora;
    }

    public String getEmpresaSupervisora() {
        return empresaSupervisora;
    }

    public void setCodigoEliminar(int codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }

    public int getCodigoEliminar() {
        return codigoEliminar;
    }

    //---//


    public void setListarEntregas(List<ContratoSupervisoraVO> listarEntregas) {
        this.listarEntregas = listarEntregas;
    }

    public List<ContratoSupervisoraVO> getListarEntregas() {
        return listarEntregas;
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


    public void setUtil(Util util) {
        this.util = util;
    }

    public Util getUtil() {
        return util;
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


    public void setT_modconcE(String t_modconcE) {
        this.t_modconcE = t_modconcE;
    }

    public String getT_modconcE() {
        return t_modconcE;
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

    public void setCodigoConcesion(int codigoConcesion) {
        this.codigoConcesion = codigoConcesion;
    }

    public int getCodigoConcesion() {
        return codigoConcesion;
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

    public void setContratoSupervisoraAdendaVO(ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO) {
        this.contratoSupervisoraAdendaVO = contratoSupervisoraAdendaVO;
    }

    public ContratoSupervisoraAdendaVO getContratoSupervisoraAdendaVO() {
        return contratoSupervisoraAdendaVO;
    }

    public void setListaAdenda(List<ContratoSupervisoraAdendaVO> listaAdenda) {
        this.listaAdenda = listaAdenda;
    }

    public List<ContratoSupervisoraAdendaVO> getListaAdenda() {
        return listaAdenda;
    }

    public void setContratoEmpresaSupervisoraAdendaServiceImpl(ContratoEmpresaSupervisoraAdendaServiceImpl contratoEmpresaSupervisoraAdendaServiceImpl) {
        this.contratoEmpresaSupervisoraAdendaServiceImpl = contratoEmpresaSupervisoraAdendaServiceImpl;
    }

    public ContratoEmpresaSupervisoraAdendaServiceImpl getContratoEmpresaSupervisoraAdendaServiceImpl() {
        return contratoEmpresaSupervisoraAdendaServiceImpl;
    }


    public void setListaAdenda1(List<ContratoSupervisoraAdendaVO> listaAdenda1) {
        this.listaAdenda1 = listaAdenda1;
    }

    public List<ContratoSupervisoraAdendaVO> getListaAdenda1() {
        return listaAdenda1;
    }

    public void setCodigoEmpresaSupervisora(int codigoEmpresaSupervisora) {
        this.codigoEmpresaSupervisora = codigoEmpresaSupervisora;
    }

    public int getCodigoEmpresaSupervisora() {
        return codigoEmpresaSupervisora;
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

    public void setMonedaSeleccionada1(int monedaSeleccionada1) {
        this.monedaSeleccionada1 = monedaSeleccionada1;
    }

    public int getMonedaSeleccionada1() {
        return monedaSeleccionada1;
    }


    public void setCenDocumentoFisico(String cenDocumentoFisico) {
        this.cenDocumentoFisico = cenDocumentoFisico;
    }

    public String getCenDocumentoFisico() {
        return cenDocumentoFisico;
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

    public void setT_conce(String t_conce) {
        this.t_conce = t_conce;
    }

    public String getT_conce() {
        return t_conce;
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

    public void setInfraestructuraSeleccionadaE(int infraestructuraSeleccionadaE) {
        this.infraestructuraSeleccionadaE = infraestructuraSeleccionadaE;
    }

    public int getInfraestructuraSeleccionadaE() {
        return infraestructuraSeleccionadaE;
    }

    public void setInversionSeleccionadaE(int inversionSeleccionadaE) {
        this.inversionSeleccionadaE = inversionSeleccionadaE;
    }

    public int getInversionSeleccionadaE() {
        return inversionSeleccionadaE;
    }

    public void setContratoCompromisoSeleccionadoE(int contratoCompromisoSeleccionadoE) {
        this.contratoCompromisoSeleccionadoE = contratoCompromisoSeleccionadoE;
    }

    public int getContratoCompromisoSeleccionadoE() {
        return contratoCompromisoSeleccionadoE;
    }

    public void setListaContratosE(List<ContratoVO> listaContratosE) {
        this.listaContratosE = listaContratosE;
    }

    public List<ContratoVO> getListaContratosE() {
        return listaContratosE;
    }

    public void setListaEmpresaSupE(List<EmpresaSupervisoraVO> listaEmpresaSupE) {
        this.listaEmpresaSupE = listaEmpresaSupE;
    }

    public List<EmpresaSupervisoraVO> getListaEmpresaSupE() {
        return listaEmpresaSupE;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }


    public void setCodigoContratoE(int codigoContratoE) {
        this.codigoContratoE = codigoContratoE;
    }

    public int getCodigoContratoE() {
        return codigoContratoE;
    }
}
