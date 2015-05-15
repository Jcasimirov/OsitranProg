package com.ositran.valorizaciones;

import com.ositran.model.Infraestructura;
import com.ositran.model.Inv;
import com.ositran.service.AvanceInversionWebService;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.DatosStdService;
import com.ositran.service.EmpresaSupervisoraService;
import com.ositran.service.IgvService;
import com.ositran.service.InfraestructuraService;
import com.ositran.service.InfraestructuraTipoService;
import com.ositran.service.InvAvnDerivadaService;
import com.ositran.service.InvAvnSupervisadaDetalleService;
import com.ositran.service.InvAvnSupervisadaService;
import com.ositran.service.InversionDescripcionServices;
import com.ositran.service.InversionService;
import com.ositran.service.ModalidadConcesionService;
import com.ositran.service.MonedaService;
import com.ositran.service.SupervisorInversionesService;
import com.ositran.service.ValorizacionInversionAvanceDetalleService;
import com.ositran.service.ValorizacionInversionAvanceService;
import com.ositran.serviceimpl.EmpresaSupervisoraServiceImpl;
import com.ositran.serviceimpl.InvAvnDerivadaServiceImpl;
import com.ositran.serviceimpl.InvAvnSupervisadaDetalleServiceImpl;
import com.ositran.serviceimpl.InvAvnSupervisadaServiceImpl;
import com.ositran.serviceimpl.SupervisorInversionesServiceImpl;
import com.ositran.serviceimpl.ValorizacionInversionAvanceDetalleServiceImpl;
import com.ositran.serviceimpl.ValorizacionInversionAvanceServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.AvanceInversionWebVO;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.IgvVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InvAvnDerivadaVO;
import com.ositran.vo.bean.InvAvnSupervisadaDetalleVO;
import com.ositran.vo.bean.InvAvnSupervisadaVO;
import com.ositran.vo.bean.InversionDescripcionVO;
import com.ositran.vo.bean.InversionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.SupervisorInversionesVO;
import com.ositran.vo.bean.ValorizacionInversionAvanceDetalleVO;
import com.ositran.vo.bean.ValorizacionInversionAvanceVO;
import com.ositran.vo.bean.ValorizacionSupDetalleVO;
import com.ositran.vo.bean.ValorizacionSupVO;
import com.ositran.vo.bean.ViewTdInternosVO;

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

@ManagedBean(name = "registrarRevisionSupervisorMB")
@ViewScoped
public class RegistrarRevisionSupervisorMB {
    
    private String nombreRevisor;
    MonedaVO monedaVO = new MonedaVO();
    public final int formulario = 37;
    private RolOpcionesVO rolOpcion;
    private int tipoInfraestructuraGlobal;

    public void validarSesion() throws IOException {
        tipoInfraestructuraGlobal = Reutilizar.getNewInstance().obtenerDatosEmpleadoLogueado().getTinId();
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
    }

    private int fichaRegistro;
    private int codigoInfraestructura;
    private String nombreConcecion;
    private String nombreTipoInfraestructura;
    private String nombreModalidadConceción;
    private int idModalidadConcesion;
    private int codigoConcesion;
    private int codigoInversion;
    private int idTipoInfraestructura;
    private int codigoContrato;
    private int codigoDetalle;
    //***************************DATOS SDT******************************//
    private String numero;
    private int anio;
    private Date fechaRegistroSDT;
    private String asunto;
    //*********************DATOS CONTRATO COMPROMISO********************//
    private int contratoCompromisoSeleccionado;
    private String plazo;
    private BigDecimal total;
    private int codigoMoneda;
    private int codigoInversionDescripcion;
    //*********************DATOS VALORIZACION********************//
    private int codMoneda;
    private List<MonedaVO> listaMoneda = new ArrayList<>();
    private int codigoInfraValSelecionado;
    private List<InversionDescripcionVO> listaDescripcionTipoInversion = new ArrayList<>();
    List<ValorizacionInversionAvanceDetalleVO> listValorizacionInversionAvanceDetalleVO = new ArrayList<>();
    private BigDecimal montoAjustado;
    private Date inicioPeriodo;
    private Date finPeriodo;
    private BigDecimal montoPrestado;
    private boolean igv;
    private int contador = 0;
    private BigDecimal totalMonto = new BigDecimal("0");
    private BigDecimal totalIgv = new BigDecimal("0");
    private BigDecimal totalTotal = new BigDecimal("0");
    private BigDecimal totalRevisado= new BigDecimal("0");
    private int tipoComtratoCompromiso;
    private String descripcionValorizacionDetalle;
    private int codigoContratoCompromiso;
    private String nombreMoneda;
    private int numeroOficio;
    private int registroSalida;
    private int fechaLimite;
    private int estadoRevision;
    //CALENDARIO
    private boolean diasCalendario;
    private boolean diasHabiles;
    private int ocultarPanelDetalle = 0;
    private String observaciones;

    ValorizacionInversionAvanceService valorizacionInversionAvanceServiceImpl =
        new ValorizacionInversionAvanceServiceImpl();

    InvAvnSupervisadaVO invAvnSupervisadaVO = new InvAvnSupervisadaVO();
    InvAvnSupervisadaService InvAvnSupervisadaServiceImpl = new InvAvnSupervisadaServiceImpl();

    InvAvnSupervisadaDetalleVO invAvnSupervisadaDetalleVO = new InvAvnSupervisadaDetalleVO();
    InvAvnSupervisadaDetalleService invAvnSupervisadaServiceDetalleImpl = new InvAvnSupervisadaDetalleServiceImpl();
    List<InvAvnSupervisadaDetalleVO> listaInvAvnSupervisadaDetalle= new ArrayList<>();
    
    
    List<InfraestructuraVO> listaInfraestructuras = new ArrayList<>();
    List<InfraestructuraVO> listaInfraestructurasC = new ArrayList<>();
    List<ValorizacionSupDetalleVO> listaValorizacionSup = new ArrayList<>();
    ValorizacionInversionAvanceDetalleService valorizacionInversionAvanceDetalleService =
        new ValorizacionInversionAvanceDetalleServiceImpl();

    ValorizacionInversionAvanceDetalleServiceImpl valorizacionInversionAvanceDetalleServiceImpl =
        new ValorizacionInversionAvanceDetalleServiceImpl();
    List<InversionVO> listaInversiones = new ArrayList<>();
    List<ContratoCompromisoVO> listaContratoCompromiso = new ArrayList<>();
    List<ContratoVO> listaContratos = new ArrayList<>();

    ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO =
        new ValorizacionInversionAvanceDetalleVO();
    @ManagedProperty(value = "#{inversionVO}")
    InversionVO inversionVO;
    
    InvAvnDerivadaVO invAvnDerivadaVO = new InvAvnDerivadaVO();
    InvAvnDerivadaService invAvnDerivadaServiceImpl = new InvAvnDerivadaServiceImpl();

    ValorizacionInversionAvanceVO valorizacionInversionAvanceVO = new ValorizacionInversionAvanceVO();
    List<ValorizacionInversionAvanceVO> listValorizacionInversionAvanceVO = new ArrayList<>();


    @ManagedProperty(value = "#{inversionDescripcionVO}")
    InversionDescripcionVO inversionDescripcionVO;

    @ManagedProperty(value = "#{inversionDescripcionServicesImpl}")
    InversionDescripcionServices inversionDescripcionServicesImpl;

    @ManagedProperty(value = "#{AvanceInversionWebServiceImpl}")
    AvanceInversionWebService avanceInversionWebServiceImpl;

    @ManagedProperty(value = "#{AvanceInversionWebVO}")
    AvanceInversionWebVO avanceInversionWebVO;

    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionService concesionServiceImpl;

    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionService modalidadServiceImp;

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoService infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{concesionVO}")
    ConcesionVO concesionVO;

    @ManagedProperty(value = "#{modalidadVO}")
    ModalidadConcesionVO modalidadVO;

    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    InfraestructuraTipoVO infraestructuraTipoVO;

    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    InfraestructuraService infraestructuraServiceImpl;

    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
    ContratoCompromisoService contratoCompromisoServiceImpl;

    @ManagedProperty(value = "#{inversionServiceImpl}")
    InversionService inversionServiceImpl;

    @ManagedProperty(value = "#{infraestructuraVO}")
    InfraestructuraVO infraestructuraVO;

    @ManagedProperty(value = "#{infraestructura}")
    Infraestructura infraestructura;

    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionService contratoConcesionServiceImp;

    @ManagedProperty(value = "#{contratoVO}")
    ContratoVO contratoVO;

    @ManagedProperty(value = "#{contratoCompromisoVO}")
    ContratoCompromisoVO contratoCompromisoVO;

    @ManagedProperty(value = "#{datosStdServiceImpl}")
    DatosStdService datosStdServiceImpl;

    @ManagedProperty(value = "#{viewTdInternosVO}")
    ViewTdInternosVO viewTdInternosVO;

    @ManagedProperty(value = "#{monedaServiceImpl}")
    MonedaService monedaServiceImpl;

    @ManagedProperty(value = "#{valorizacionSupVO}")
    ValorizacionSupVO valorizacionSupVO;

    @ManagedProperty(value = "#{valorizacionSupDetalleVO}")
    ValorizacionSupDetalleVO valorizacionSupDetalleVO;

    @ManagedProperty(value = "#{igvVO}")
    IgvVO igvVO;

    @ManagedProperty(value = "#{igvServiceImpl}")
    IgvService igvServiceImpl;

    SupervisorInversionesService supervisorInversionesServiceImpl = new SupervisorInversionesServiceImpl();
    SupervisorInversionesVO supervisorInversionesVO = new SupervisorInversionesVO();
    EmpresaSupervisoraVO empresaSupervisoraVO = new EmpresaSupervisoraVO();
    EmpresaSupervisoraService empresaSupervisoraService = new EmpresaSupervisoraServiceImpl();
    
 

    public void limpiarTodo() {
        fichaRegistro = 0;
        codigoInfraestructura = 0;
        nombreConcecion = "";
        nombreTipoInfraestructura = "";
        nombreModalidadConceción = "";
        idModalidadConcesion = 0;
        codigoConcesion = 0;
        codigoInversion = 0;
        idTipoInfraestructura = 0;
        codigoContrato = 0;
        numero = "";
        anio = 0;
        fechaRegistroSDT = null;
        asunto = "";
        contratoCompromisoSeleccionado = 1;
        plazo = "";
        codigoMoneda = 0;
        codigoInversionDescripcion = 0;
        codMoneda = 0;
        codigoInfraValSelecionado = 0;
        inicioPeriodo = null;
        finPeriodo = null;
        montoPrestado = new BigDecimal("0");
        contador = 0;
        totalTotal = new BigDecimal("0");
        nombreRevisor = "";
        listValorizacionInversionAvanceDetalleVO = new ArrayList();
        listValorizacionInversionAvanceVO = new ArrayList();
    }

    public void desDiasHabiles() {
        diasHabiles = false;

    }

    public void desDiasCalendario() {
        diasCalendario = false;
    }

    public void cargarListaContratos() {
        try {
            listaContratos = contratoConcesionServiceImp.query();

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
            idModalidadConcesion = contratoVO.getMcoId();
            idTipoInfraestructura = concesionVO.getTinId();
            codigoContrato = contratoVO.getConId();
            nombreConcecion = concesionVO.getCsiNombre();
            modalidadVO = modalidadServiceImp.get(idModalidadConcesion);
            nombreModalidadConceción = modalidadVO.getMcoNombre();
            infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(idTipoInfraestructura);
            nombreTipoInfraestructura = infraestructuraTipoVO.getTinNombre();
            listaInfraestructuras = infraestructuraServiceImpl.query2(concesionVO.getCsiId());
            listaContratoCompromiso = contratoCompromisoServiceImpl.query1(codigoContrato);

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso",
                                                                          "La ficha ingresada no existe. Puede hacer el ingreso manualmente"));
            e.printStackTrace();
        }
    }

    public void cargarMoneda() {
        try {
            listaMoneda = monedaServiceImpl.query();

        } catch (Exception e) {
            System.out.println("PROBLEMAS CON CARGAR LA LISTA DE MONEDAS");
            e.printStackTrace();
        }

    }


    public void cargarListaValorizacionDetalle(int detalle) {
        try {
            
            valorizacionInversionAvanceVO = valorizacionInversionAvanceServiceImpl.get(detalle);
            
            invAvnDerivadaVO=invAvnDerivadaServiceImpl.get1(valorizacionInversionAvanceVO.getTiaNumero());
            /*
            if (invAvnDerivadaVO.getIadTipoSup()==1){
             supervisorInversionesVO=supervisorInversionesServiceImpl.get(invAvnDerivadaVO.getSupID());   
             nombreRevisor=supervisorInversionesVO.getTsiNombre();
                }
            
            if (invAvnDerivadaVO.getIadTipoSup()==2){
                    empresaSupervisoraVO=empresaSupervisoraService.get(invAvnDerivadaVO.getSupID());   
                    nombreRevisor=empresaSupervisoraVO.getSupNombre();
                }
            
           */
            /*
            invAvnDerivadaVO=invAvnDerivadaServiceImpl.getAvanceInversion(detalle);
            System.out.println(invAvnDerivadaVO.getIadTipoSup());

            if (invAvnDerivadaVO.getIadTipoSup()==1){
                supervisorInversionesVO=supervisorInversionesServiceImpl.getSupervisorInversiones(invAvnDerivadaVO.getIadIdSup());
                nombreRevisor=supervisorInversionesVO.getTsiNombre();
                }
            if (invAvnDerivadaVO.getIadTipoSup()==2){
                empresaSupervisoraVO=empresaSupervisoraService.get(invAvnDerivadaVO.getIadIdSup());
                nombreRevisor=empresaSupervisoraVO.getSupNombre();
                }
            */
          
            
            anio = valorizacionInversionAvanceVO.getTiaAnyo();
            listValorizacionInversionAvanceDetalleVO = valorizacionInversionAvanceDetalleServiceImpl.query1(detalle);
            for (ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO1 : listValorizacionInversionAvanceDetalleVO) {
            inversionDescripcionVO = inversionDescripcionServicesImpl.get(valorizacionInversionAvanceDetalleVO1.getDtiId());
            valorizacionInversionAvanceDetalleVO1.setDescripcionInversion(inversionDescripcionVO.getItdNombre());
            totalTotal = totalTotal.add(valorizacionInversionAvanceDetalleVO1.getMontoPresentado());
            totalRevisado = totalRevisado.add(valorizacionInversionAvanceDetalleVO1.getMontoPresentado());
            valorizacionInversionAvanceDetalleVO1.setIasMontoRevisado(valorizacionInversionAvanceDetalleVO1.getMontoPresentado());
            monedaVO=monedaServiceImpl.get(valorizacionInversionAvanceDetalleVO1.getMonId());
            valorizacionInversionAvanceDetalleVO1.setNombreMoneda(monedaVO.getMonSimbolo());
               
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void actualizarValoresAjustados(int codigoValorizacion) {
       
        montoAjustado = new BigDecimal("0");
        codigoDetalle = codigoValorizacion;
    }

    public void ajustarMonto() {
        totalRevisado=new BigDecimal("0");
        for (ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO : listValorizacionInversionAvanceDetalleVO) {
            if (valorizacionInversionAvanceDetalleVO.getIad_Id() == codigoDetalle) {
                valorizacionInversionAvanceDetalleVO.setIasMontoRevisado(montoAjustado);
            }
            totalRevisado = totalRevisado.add(valorizacionInversionAvanceDetalleVO.getIasMontoRevisado());
            
        }
    }

    public void cargarAeropuertoValoracion() {
        if (codigoInfraestructura == 111) {
            listaInfraestructurasC = new ArrayList<>();
            for (InfraestructuraVO infraVO : listaInfraestructuras) {
                listaInfraestructurasC.add(infraVO);
            }
        } else {
            listaInfraestructurasC = new ArrayList<>();
            for (InfraestructuraVO infraVO : listaInfraestructuras) {
                if (infraVO.getInfId() == codigoInfraestructura) {
                    listaInfraestructurasC.add(infraVO);
                }
            }
        }

    }

    public void listarInversionDescripcion() {
        try {
            listaDescripcionTipoInversion = inversionDescripcionServicesImpl.query();

        } catch (Exception e) {
            System.out.println("   PROBLEMAS CON EL LISTADO DE INVERSION DESCRIPCION");
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
            cargarListaValorizacion();


        } catch (Exception e) {
            System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
        }
    }

    public void cargarDatosSDT() {
        try {
            viewTdInternosVO = datosStdServiceImpl.BuscaStd(anio, numero);
            fechaRegistroSDT = viewTdInternosVO.getFechaRegistro();
            asunto = viewTdInternosVO.getAsunto();
        } catch (Exception e) {
            asunto = "";
            System.out.println("PROBLEMAS AL TRAER LOS DATOS INTERNOS");
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso",
                                                                          "NO HAY DATOS SDT QUE MOSTRAR"));
            e.printStackTrace();
        }
    }

    public void agregar() {
        try {

            if (montoPrestado == new BigDecimal("0")) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "AVISO",
                                                                              "DEBE INGRASAR EL MONTO PRESENTADO"));
            } else if (codMoneda == 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "AVISO",
                                                                              "DEBE SELECCIONAR MONEDA"));
            } else if (codigoInversionDescripcion == 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "AVISO",
                                                                              "DEBE SELECIONAR CONCEPTO"));
            } else {
                BigDecimal igv1= new BigDecimal("0");
                ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO1 =new ValorizacionInversionAvanceDetalleVO();
               
                valorizacionInversionAvanceDetalleVO1.setMonId(codMoneda);
                valorizacionInversionAvanceDetalleVO1.setDtiId(codigoInversionDescripcion);
                inversionDescripcionVO = inversionDescripcionServicesImpl.get(codigoInversionDescripcion);
                valorizacionInversionAvanceDetalleVO1.setDescripcionInversion(inversionDescripcionVO.getItdNombre());
                valorizacionInversionAvanceDetalleVO1.setTivId(inversionDescripcionVO.getTivId());
                valorizacionInversionAvanceDetalleVO1.setIadDescripcion(descripcionValorizacionDetalle);
                valorizacionInversionAvanceDetalleVO1.setIadFechaInicio(getInicioPeriodo());
                valorizacionInversionAvanceDetalleVO1.setIadFechaFin(getFinPeriodo());


                for (MonedaVO mon : listaMoneda) {
                    if (mon.getMonId() == codMoneda) {
                        valorizacionInversionAvanceDetalleVO1.setNombreMoneda(mon.getMonNombre());
                    }
                }
                valorizacionInversionAvanceDetalleVO1.setMontoPresentado(new java.math.BigDecimal(String.valueOf(montoPrestado)));
                if (igv) {
                    igv1 =new BigDecimal("0.18");
                    valorizacionInversionAvanceDetalleVO1.setIgv(montoPrestado.multiply(igv1));
                } else {
                    igv1 = new BigDecimal("0");
                }
                valorizacionInversionAvanceDetalleVO1.setTiaTotal(montoPrestado.add(montoPrestado.multiply(igv1)));
                listValorizacionInversionAvanceDetalleVO.add(valorizacionInversionAvanceDetalleVO1);
                totalMonto = totalMonto.add(valorizacionInversionAvanceDetalleVO1.getMontoPresentado()).setScale(2,BigDecimal.ROUND_UP);
                totalIgv = totalIgv.add(valorizacionInversionAvanceDetalleVO1.getIgv());
                totalTotal = totalTotal.add(valorizacionInversionAvanceDetalleVO1.getMontoPresentado());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void quitarLista() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("indexLista");
        int idcodigo = Integer.valueOf(str.toString());
        
        totalTotal = totalTotal.subtract(listValorizacionInversionAvanceDetalleVO.get(idcodigo).getTiaTotal());
        totalMonto =totalMonto.subtract(listValorizacionInversionAvanceDetalleVO.get(idcodigo).getMontoPresentado());
        totalIgv = totalIgv.subtract(listValorizacionInversionAvanceDetalleVO.get(idcodigo).getIgv());
        listValorizacionInversionAvanceDetalleVO.remove(idcodigo);

    }

    public void guardar() {
        try {
            int codigoSupervisadaCaebcera=0;
            invAvnSupervisadaVO.setIasPlazoDias(new java.math.BigDecimal(String.valueOf(valorizacionInversionAvanceVO.getTiaPlazoEnDias())));
            invAvnSupervisadaVO.setTiaNumero(valorizacionInversionAvanceVO.getTiaNumero());
            invAvnSupervisadaVO.setCsiId(new java.math.BigDecimal(String.valueOf(codigoConcesion)));
            invAvnSupervisadaVO.setTinId(new java.math.BigDecimal(String.valueOf(idTipoInfraestructura)));
            invAvnSupervisadaVO.setIasAnyo(anio);
            invAvnSupervisadaVO.setIasAsunto(asunto);
            invAvnSupervisadaVO.setIasHr(new java.math.BigDecimal(String.valueOf(numero)));
            invAvnSupervisadaVO.setIasFechaRegistro(new Date());
            invAvnSupervisadaVO.setIasObservaciones(observaciones);
            if (estadoRevision == 1) {
                invAvnSupervisadaVO.setIasEstado("Aprobado");
            }
            if (estadoRevision == 2) {
                invAvnSupervisadaVO.setIasEstado("Rechasado");
            }
            invAvnSupervisadaVO.setIasFechaEmision(inicioPeriodo);
            invAvnSupervisadaVO.setIasFechaRecepcion(finPeriodo);
            valorizacionInversionAvanceVO.setIaeId(3);
            valorizacionInversionAvanceVO.setTiaMontoTotalReajustado(totalRevisado);
            valorizacionInversionAvanceServiceImpl.update(valorizacionInversionAvanceVO);
            codigoSupervisadaCaebcera=InvAvnSupervisadaServiceImpl.insert(invAvnSupervisadaVO);
            
            for (ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO : listValorizacionInversionAvanceDetalleVO) {
                InvAvnSupervisadaDetalleVO invAvnSupervisadaDetalleVO1 =new InvAvnSupervisadaDetalleVO();
                invAvnSupervisadaDetalleVO1.setIasNumero(new java.math.BigDecimal(String.valueOf(codigoSupervisadaCaebcera)));
                invAvnSupervisadaDetalleVO1.setAsdEstado( new BigDecimal("1"));
                invAvnSupervisadaDetalleVO1.setAsdFechaRegistro(new Date());
                invAvnSupervisadaDetalleVO1.setIsdMontoPresentado(valorizacionInversionAvanceDetalleVO.getMontoPresentado());
                if (valorizacionInversionAvanceDetalleVO.getMontoRevisado()==null){
                        invAvnSupervisadaDetalleVO1.setIasMontoRevisado(valorizacionInversionAvanceDetalleVO.getMontoPresentado());  
                    }
                else {
                        invAvnSupervisadaDetalleVO1.setIasMontoRevisado(valorizacionInversionAvanceDetalleVO.getMontoRevisado()); 
                    }
                
                
                invAvnSupervisadaDetalleVO1.setMonId(valorizacionInversionAvanceVO.getMonId());
                invAvnSupervisadaDetalleVO1.setIsdIgv(valorizacionInversionAvanceDetalleVO.getIgv());
                  listaInvAvnSupervisadaDetalle.add(invAvnSupervisadaDetalleVO1); 
            }
            for (InvAvnSupervisadaDetalleVO invAvnSupervisadaDetalleVO3: listaInvAvnSupervisadaDetalle){
                    invAvnSupervisadaServiceDetalleImpl.insert(invAvnSupervisadaDetalleVO3);
                }
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO","SE REGISTRO CON EXITO LA REVISIÓN DE SUPERVISOR"));
       limpiarTodo();
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarListaValorizacion() {
        try {
            listValorizacionInversionAvanceVO =
                valorizacionInversionAvanceServiceImpl.queryDerivarInversion(codigoContrato,
                                                                             contratoCompromisoSeleccionado, 2);
            for (ValorizacionInversionAvanceVO valorizacionInversionAvanceVO : listValorizacionInversionAvanceVO) {
                monedaVO = monedaServiceImpl.get(valorizacionInversionAvanceVO.getMonId());
                valorizacionInversionAvanceVO.setMonedaNombre(monedaVO.getMonSimbolo());
                if (valorizacionInversionAvanceVO.getIaeId() == 2) {
                    valorizacionInversionAvanceVO.setEstadoNombre("DERIVADA");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void ocultarPanel() {
        System.out.println("ver estado");
        System.out.println(estadoRevision);
        if (estadoRevision == 1) {
            ocultarPanelDetalle = 0;
        } else {
            ocultarPanelDetalle = 1;
        }
    }

    public void setFichaRegistro(int fichaRegistro) {
        this.fichaRegistro = fichaRegistro;
    }

    public int getFichaRegistro() {
        return fichaRegistro;
    }

    public void setCodigoInfraestructura(int codigoInfraestructura) {
        this.codigoInfraestructura = codigoInfraestructura;
    }

    public int getCodigoInfraestructura() {
        return codigoInfraestructura;
    }

    public void setNombreConcecion(String nombreConcecion) {
        this.nombreConcecion = nombreConcecion;
    }

    public String getNombreConcecion() {
        return nombreConcecion;
    }

    public void setNombreTipoInfraestructura(String nombreTipoInfraestructura) {
        this.nombreTipoInfraestructura = nombreTipoInfraestructura;
    }

    public String getNombreTipoInfraestructura() {
        return nombreTipoInfraestructura;
    }

    public void setNombreModalidadConceción(String nombreModalidadConceción) {
        this.nombreModalidadConceción = nombreModalidadConceción;
    }

    public String getNombreModalidadConceción() {
        return nombreModalidadConceción;
    }

    public void setIdModalidadConcesion(int idModalidadConcesion) {
        this.idModalidadConcesion = idModalidadConcesion;
    }

    public int getIdModalidadConcesion() {
        return idModalidadConcesion;
    }

    public void setCodigoConcesion(int codigoConcesion) {
        this.codigoConcesion = codigoConcesion;
    }

    public int getCodigoConcesion() {
        return codigoConcesion;
    }

    public void setIdTipoInfraestructura(int idTipoInfraestructura) {
        this.idTipoInfraestructura = idTipoInfraestructura;
    }

    public int getIdTipoInfraestructura() {
        return idTipoInfraestructura;
    }

    public void setListaInfraestructuras(List<InfraestructuraVO> listaInfraestructuras) {
        this.listaInfraestructuras = listaInfraestructuras;
    }

    public List<InfraestructuraVO> getListaInfraestructuras() {
        return listaInfraestructuras;
    }

    public void setListaInversiones(List<InversionVO> listaInversiones) {
        this.listaInversiones = listaInversiones;
    }

    public List<InversionVO> getListaInversiones() {
        return listaInversiones;
    }

    public void setAvanceInversionWebServiceImpl(AvanceInversionWebService avanceInversionWebServiceImpl) {
        this.avanceInversionWebServiceImpl = avanceInversionWebServiceImpl;
    }

    public AvanceInversionWebService getAvanceInversionWebServiceImpl() {
        return avanceInversionWebServiceImpl;
    }

    public void setAvanceInversionWebVO(AvanceInversionWebVO avanceInversionWebVO) {
        this.avanceInversionWebVO = avanceInversionWebVO;
    }

    public AvanceInversionWebVO getAvanceInversionWebVO() {
        return avanceInversionWebVO;
    }

    public void setConcesionServiceImpl(ConcesionService concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public ConcesionService getConcesionServiceImpl() {
        return concesionServiceImpl;
    }

    public void setModalidadServiceImp(ModalidadConcesionService modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionService getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoService infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoService getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }

    public void setModalidadVO(ModalidadConcesionVO modalidadVO) {
        this.modalidadVO = modalidadVO;
    }

    public ModalidadConcesionVO getModalidadVO() {
        return modalidadVO;
    }

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    public void setInfraestructuraServiceImpl(InfraestructuraService infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public InfraestructuraService getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }

    public void setInversionServiceImpl(InversionService inversionServiceImpl) {
        this.inversionServiceImpl = inversionServiceImpl;
    }

    public InversionService getInversionServiceImpl() {
        return inversionServiceImpl;
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

    public void setCodigoInversion(int codigoInversion) {
        this.codigoInversion = codigoInversion;
    }

    public int getCodigoInversion() {
        return codigoInversion;
    }


    public void setListaContratoCompromiso(List<ContratoCompromisoVO> listaContratoCompromiso) {
        this.listaContratoCompromiso = listaContratoCompromiso;
    }

    public List<ContratoCompromisoVO> getListaContratoCompromiso() {
        return listaContratoCompromiso;
    }

    public void setContratoCompromisoServiceImpl(ContratoCompromisoService contratoCompromisoServiceImpl) {
        this.contratoCompromisoServiceImpl = contratoCompromisoServiceImpl;
    }

    public ContratoCompromisoService getContratoCompromisoServiceImpl() {
        return contratoCompromisoServiceImpl;
    }

    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setContratoConcesionServiceImp(ContratoConcesionService contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public ContratoConcesionService getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    public void setContratoCompromisoSeleccionado(int contratoCompromisoSeleccionado) {
        this.contratoCompromisoSeleccionado = contratoCompromisoSeleccionado;
    }

    public int getContratoCompromisoSeleccionado() {
        return contratoCompromisoSeleccionado;
    }


    public void setContratoCompromisoVO(ContratoCompromisoVO contratoCompromisoVO) {
        this.contratoCompromisoVO = contratoCompromisoVO;
    }

    public ContratoCompromisoVO getContratoCompromisoVO() {
        return contratoCompromisoVO;
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

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setDatosStdServiceImpl(DatosStdService datosStdServiceImpl) {
        this.datosStdServiceImpl = datosStdServiceImpl;
    }

    public DatosStdService getDatosStdServiceImpl() {
        return datosStdServiceImpl;
    }


    public void setViewTdInternosVO(ViewTdInternosVO viewTdInternosVO) {
        this.viewTdInternosVO = viewTdInternosVO;
    }

    public ViewTdInternosVO getViewTdInternosVO() {
        return viewTdInternosVO;
    }


    public void setFechaRegistroSDT(Date fechaRegistroSDT) {
        this.fechaRegistroSDT = fechaRegistroSDT;
    }

    public Date getFechaRegistroSDT() {
        return fechaRegistroSDT;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setDiasCalendario(boolean diasCalendario) {
        this.diasCalendario = diasCalendario;
    }

    public boolean isDiasCalendario() {
        return diasCalendario;
    }

    public void setDiasHabiles(boolean diasHabiles) {
        this.diasHabiles = diasHabiles;
    }

    public boolean isDiasHabiles() {
        return diasHabiles;
    }


    public void setCodMoneda(int codMoneda) {
        this.codMoneda = codMoneda;
    }

    public int getCodMoneda() {
        return codMoneda;
    }

    public void setListaMoneda(List<MonedaVO> listaMoneda) {
        this.listaMoneda = listaMoneda;
    }

    public List<MonedaVO> getListaMoneda() {
        return listaMoneda;
    }

    public void setMonedaServiceImpl(MonedaService monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }

    public MonedaService getMonedaServiceImpl() {
        return monedaServiceImpl;
    }


    public void setListaInfraestructurasC(List<InfraestructuraVO> listaInfraestructurasC) {
        this.listaInfraestructurasC = listaInfraestructurasC;
    }

    public List<InfraestructuraVO> getListaInfraestructurasC() {
        return listaInfraestructurasC;
    }


    public void setCodigoInfraValSelecionado(int codigoInfraValSelecionado) {
        this.codigoInfraValSelecionado = codigoInfraValSelecionado;
    }

    public int getCodigoInfraValSelecionado() {
        return codigoInfraValSelecionado;
    }


    public void setListaDescripcionTipoInversion(List<InversionDescripcionVO> listaDescripcionTipoInversion) {
        this.listaDescripcionTipoInversion = listaDescripcionTipoInversion;
    }

    public List<InversionDescripcionVO> getListaDescripcionTipoInversion() {
        return listaDescripcionTipoInversion;
    }


    public void setInversionDescripcionServicesImpl(InversionDescripcionServices inversionDescripcionServicesImpl) {
        this.inversionDescripcionServicesImpl = inversionDescripcionServicesImpl;
    }

    public InversionDescripcionServices getInversionDescripcionServicesImpl() {
        return inversionDescripcionServicesImpl;
    }


    public void setCodigoInversionDescripcion(int codigoInversionDescripcion) {
        this.codigoInversionDescripcion = codigoInversionDescripcion;
    }

    public int getCodigoInversionDescripcion() {
        return codigoInversionDescripcion;
    }


    public void setInicioPeriodo(Date inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    public Date getInicioPeriodo() {
        return inicioPeriodo;
    }

    public void setFinPeriodo(Date finPeriodo) {
        this.finPeriodo = finPeriodo;
    }

    public Date getFinPeriodo() {
        return finPeriodo;
    }

    public void setListaValorizacionSup(List<ValorizacionSupDetalleVO> listaValorizacionSup) {
        this.listaValorizacionSup = listaValorizacionSup;
    }

    public List<ValorizacionSupDetalleVO> getListaValorizacionSup() {
        return listaValorizacionSup;
    }

    public void setValorizacionSupVO(ValorizacionSupVO valorizacionSupVO) {
        this.valorizacionSupVO = valorizacionSupVO;
    }

    public ValorizacionSupVO getValorizacionSupVO() {
        return valorizacionSupVO;
    }

    public void setValorizacionSupDetalleVO(ValorizacionSupDetalleVO valorizacionSupDetalleVO) {
        this.valorizacionSupDetalleVO = valorizacionSupDetalleVO;
    }

    public ValorizacionSupDetalleVO getValorizacionSupDetalleVO() {
        return valorizacionSupDetalleVO;
    }


    public void setMontoPrestado(BigDecimal montoPrestado) {
        this.montoPrestado = montoPrestado;
    }

    public BigDecimal getMontoPrestado() {
        return montoPrestado;
    }

    public void setIgv(boolean igv) {
        this.igv = igv;
    }

    public boolean isIgv() {
        return igv;
    }

    public void setIgvVO(IgvVO igvVO) {
        this.igvVO = igvVO;
    }

    public IgvVO getIgvVO() {
        return igvVO;
    }

    public void setIgvServiceImpl(IgvService igvServiceImpl) {
        this.igvServiceImpl = igvServiceImpl;
    }

    public IgvService getIgvServiceImpl() {
        return igvServiceImpl;
    }


    public void setInversionVO(InversionVO inversionVO) {
        this.inversionVO = inversionVO;
    }

    public InversionVO getInversionVO() {
        return inversionVO;
    }

    public void setInversionDescripcionVO(InversionDescripcionVO inversionDescripcionVO) {
        this.inversionDescripcionVO = inversionDescripcionVO;
    }

    public InversionDescripcionVO getInversionDescripcionVO() {
        return inversionDescripcionVO;
    }


    public void setTotalMonto(BigDecimal totalMonto) {
        this.totalMonto = totalMonto;
    }

    public BigDecimal getTotalMonto() {
        return totalMonto;
    }

    public void setTotalIgv(BigDecimal totalIgv) {
        this.totalIgv = totalIgv;
    }

    public BigDecimal getTotalIgv() {
        return totalIgv;
    }

    public void setTotalTotal(BigDecimal totalTotal) {
        this.totalTotal = totalTotal;
    }

    public BigDecimal getTotalTotal() {
        return totalTotal;
    }

    public void setInvAvnDerivadaVO(InvAvnDerivadaVO invAvnDerivadaVO) {
        this.invAvnDerivadaVO = invAvnDerivadaVO;
    }

    public InvAvnDerivadaVO getInvAvnDerivadaVO() {
        return invAvnDerivadaVO;
    }

    public void setInvAvnDerivadaServiceImpl(InvAvnDerivadaService invAvnDerivadaServiceImpl) {
        this.invAvnDerivadaServiceImpl = invAvnDerivadaServiceImpl;
    }

    public InvAvnDerivadaService getInvAvnDerivadaServiceImpl() {
        return invAvnDerivadaServiceImpl;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setListaContratos(List<ContratoVO> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<ContratoVO> getListaContratos() {
        return listaContratos;
    }


    public void setListValorizacionInversionAvanceDetalleVO(List<ValorizacionInversionAvanceDetalleVO> listValorizacionInversionAvanceDetalleVO) {
        this.listValorizacionInversionAvanceDetalleVO = listValorizacionInversionAvanceDetalleVO;
    }

    public List<ValorizacionInversionAvanceDetalleVO> getListValorizacionInversionAvanceDetalleVO() {
        return listValorizacionInversionAvanceDetalleVO;
    }

    public void setValorizacionInversionAvanceDetalleVO(ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO) {
        this.valorizacionInversionAvanceDetalleVO = valorizacionInversionAvanceDetalleVO;
    }

    public ValorizacionInversionAvanceDetalleVO getValorizacionInversionAvanceDetalleVO() {
        return valorizacionInversionAvanceDetalleVO;
    }


    public void setValorizacionInversionAvanceServiceImpl(ValorizacionInversionAvanceService valorizacionInversionAvanceServiceImpl) {
        this.valorizacionInversionAvanceServiceImpl = valorizacionInversionAvanceServiceImpl;
    }

    public ValorizacionInversionAvanceService getValorizacionInversionAvanceServiceImpl() {
        return valorizacionInversionAvanceServiceImpl;
    }

    public void setValorizacionInversionAvanceDetalleService(ValorizacionInversionAvanceDetalleService valorizacionInversionAvanceDetalleService) {
        this.valorizacionInversionAvanceDetalleService = valorizacionInversionAvanceDetalleService;
    }

    public ValorizacionInversionAvanceDetalleService getValorizacionInversionAvanceDetalleService() {
        return valorizacionInversionAvanceDetalleService;
    }

    public void setValorizacionInversionAvanceVO(ValorizacionInversionAvanceVO valorizacionInversionAvanceVO) {
        this.valorizacionInversionAvanceVO = valorizacionInversionAvanceVO;
    }

    public ValorizacionInversionAvanceVO getValorizacionInversionAvanceVO() {
        return valorizacionInversionAvanceVO;
    }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }


    public void setTipoComtratoCompromiso(int tipoComtratoCompromiso) {
        this.tipoComtratoCompromiso = tipoComtratoCompromiso;
    }

    public int getTipoComtratoCompromiso() {
        return tipoComtratoCompromiso;
    }


    public void setDescripcionValorizacionDetalle(String descripcionValorizacionDetalle) {
        this.descripcionValorizacionDetalle = descripcionValorizacionDetalle;
    }

    public String getDescripcionValorizacionDetalle() {
        return descripcionValorizacionDetalle;
    }

    public void setNumeroOficio(int numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    public int getNumeroOficio() {
        return numeroOficio;
    }


    public void setRegistroSalida(int registroSalida) {
        this.registroSalida = registroSalida;
    }

    public int getRegistroSalida() {
        return registroSalida;
    }

    public void setFechaLimite(int fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public int getFechaLimite() {
        return fechaLimite;
    }

    public void setListValorizacionInversionAvanceVO(List<ValorizacionInversionAvanceVO> listValorizacionInversionAvanceVO) {
        this.listValorizacionInversionAvanceVO = listValorizacionInversionAvanceVO;
    }

    public List<ValorizacionInversionAvanceVO> getListValorizacionInversionAvanceVO() {
        return listValorizacionInversionAvanceVO;
    }

    public void setValorizacionInversionAvanceDetalleServiceImpl(ValorizacionInversionAvanceDetalleServiceImpl valorizacionInversionAvanceDetalleServiceImpl) {
        this.valorizacionInversionAvanceDetalleServiceImpl = valorizacionInversionAvanceDetalleServiceImpl;
    }

    public ValorizacionInversionAvanceDetalleServiceImpl getValorizacionInversionAvanceDetalleServiceImpl() {
        return valorizacionInversionAvanceDetalleServiceImpl;
    }


    public void setEstadoRevision(int estadoRevision) {
        this.estadoRevision = estadoRevision;
    }

    public int getEstadoRevision() {
        return estadoRevision;
    }


    public void setOcultarPanelDetalle(int ocultarPanelDetalle) {
        this.ocultarPanelDetalle = ocultarPanelDetalle;
    }

    public int getOcultarPanelDetalle() {
        return ocultarPanelDetalle;
    }


    public void setCodigoDetalle(int codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public int getCodigoDetalle() {
        return codigoDetalle;
    }


    public void setMontoAjustado(BigDecimal montoAjustado) {
        this.montoAjustado = montoAjustado;
    }

    public BigDecimal getMontoAjustado() {
        return montoAjustado;
    }

    public void setNombreRevisor(String nombreRevisor) {
        this.nombreRevisor = nombreRevisor;
    }

    public String getNombreRevisor() {
        return nombreRevisor;
    }

    public void setSupervisorInversionesServiceImpl(SupervisorInversionesService supervisorInversionesServiceImpl) {
        this.supervisorInversionesServiceImpl = supervisorInversionesServiceImpl;
    }

    public SupervisorInversionesService getSupervisorInversionesServiceImpl() {
        return supervisorInversionesServiceImpl;
    }

    public void setSupervisorInversionesVO(SupervisorInversionesVO supervisorInversionesVO) {
        this.supervisorInversionesVO = supervisorInversionesVO;
    }

    public SupervisorInversionesVO getSupervisorInversionesVO() {
        return supervisorInversionesVO;
    }

    public void setEmpresaSupervisoraVO(EmpresaSupervisoraVO empresaSupervisoraVO) {
        this.empresaSupervisoraVO = empresaSupervisoraVO;
    }

    public EmpresaSupervisoraVO getEmpresaSupervisoraVO() {
        return empresaSupervisoraVO;
    }

    public void setEmpresaSupervisoraService(EmpresaSupervisoraService empresaSupervisoraService) {
        this.empresaSupervisoraService = empresaSupervisoraService;
    }

    public EmpresaSupervisoraService getEmpresaSupervisoraService() {
        return empresaSupervisoraService;
    }

    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }

    public void setCodigoContratoCompromiso(int codigoContratoCompromiso) {
        this.codigoContratoCompromiso = codigoContratoCompromiso;
    }

    public int getCodigoContratoCompromiso() {
        return codigoContratoCompromiso;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setInvAvnSupervisadaVO(InvAvnSupervisadaVO invAvnSupervisadaVO) {
        this.invAvnSupervisadaVO = invAvnSupervisadaVO;
    }

    public InvAvnSupervisadaVO getInvAvnSupervisadaVO() {
        return invAvnSupervisadaVO;
    }

    public void setInvAvnSupervisadaServiceImpl(InvAvnSupervisadaService InvAvnSupervisadaServiceImpl) {
        this.InvAvnSupervisadaServiceImpl = InvAvnSupervisadaServiceImpl;
    }

    public InvAvnSupervisadaService getInvAvnSupervisadaServiceImpl() {
        return InvAvnSupervisadaServiceImpl;
    }


    public void setTotalRevisado(BigDecimal totalRevisado) {
        this.totalRevisado = totalRevisado;
    }

    public BigDecimal getTotalRevisado() {
        return totalRevisado;
    }


    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }


    public void setInvAvnSupervisadaDetalleVO(InvAvnSupervisadaDetalleVO invAvnSupervisadaDetalleVO) {
        this.invAvnSupervisadaDetalleVO = invAvnSupervisadaDetalleVO;
    }

    public InvAvnSupervisadaDetalleVO getInvAvnSupervisadaDetalleVO() {
        return invAvnSupervisadaDetalleVO;
    }

    public void setInvAvnSupervisadaServiceDetalleImpl(InvAvnSupervisadaDetalleService invAvnSupervisadaServiceDetalleImpl) {
        this.invAvnSupervisadaServiceDetalleImpl = invAvnSupervisadaServiceDetalleImpl;
    }

    public InvAvnSupervisadaDetalleService getInvAvnSupervisadaServiceDetalleImpl() {
        return invAvnSupervisadaServiceDetalleImpl;
    }

    public void setListaInvAvnSupervisadaDetalle(List<InvAvnSupervisadaDetalleVO> listaInvAvnSupervisadaDetalle) {
        this.listaInvAvnSupervisadaDetalle = listaInvAvnSupervisadaDetalle;
    }

    public List<InvAvnSupervisadaDetalleVO> getListaInvAvnSupervisadaDetalle() {
        return listaInvAvnSupervisadaDetalle;
    }

    public void setTipoInfraestructuraGlobal(int tipoInfraestructuraGlobal) {
        this.tipoInfraestructuraGlobal = tipoInfraestructuraGlobal;
    }

    public int getTipoInfraestructuraGlobal() {
        return tipoInfraestructuraGlobal;
    }

}
