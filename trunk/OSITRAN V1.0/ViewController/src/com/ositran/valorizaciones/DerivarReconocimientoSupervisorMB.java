package com.ositran.valorizaciones;

import com.ositran.model.Infraestructura;
import com.ositran.service.AvanceInversionWebService;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.DatosStdService;
import com.ositran.service.DerivarReconocimientoSupervisorService;
import com.ositran.service.EmpresaSupervisoraService;
import com.ositran.service.InfraestructuraService;
import com.ositran.service.InfraestructuraTipoService;
import com.ositran.service.InvAvnDerivadaService;
import com.ositran.service.InversionDescripcionServices;
import com.ositran.service.InversionService;
import com.ositran.service.ModalidadConcesionService;
import com.ositran.service.MonedaService;
import com.ositran.service.SupervisorInversionesService;
import com.ositran.service.TipoRevisionService;
import com.ositran.serviceimpl.DerivarReconocimientoSupervisorServiceImpl;
import com.ositran.serviceimpl.EmpresaSupervisoraServiceImpl;
import com.ositran.serviceimpl.InvAvnDerivadaServiceImpl;
import com.ositran.serviceimpl.TipoRevisionServiceImpl;
import com.ositran.serviceimpl.ValorizacionInversionAvanceDetalleServiceImpl;
import com.ositran.serviceimpl.ValorizacionInversionAvanceServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.FechasUtil;
import com.ositran.vo.bean.AvanceInversionWebVO;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.DerivarReconocimientoSupervisorVO;
import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.IgvVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InvAvnDerivadaVO;
import com.ositran.vo.bean.InversionDescripcionVO;
import com.ositran.vo.bean.InversionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.SupervisorInversionesVO;
import com.ositran.vo.bean.TipoRevisionVO;
import com.ositran.vo.bean.ValorizacionInversionAvanceDetalleVO;
import com.ositran.vo.bean.ValorizacionInversionAvanceVO;
import com.ositran.vo.bean.ValorizacionSupDetalleVO;
import com.ositran.vo.bean.ValorizacionSupVO;
import com.ositran.vo.bean.ViewTdInternosVO;

import java.io.IOException;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name = "derivarReconocimientoSupervisorMB")
@ViewScoped
public class DerivarReconocimientoSupervisorMB {
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
    private Date inicioPeriodo;
    private Date finPeriodo;
    private BigDecimal montoPrestado;
    private int contador = 0;
    private BigDecimal totalTotal;
    private String nombreMoneda;
    //CALENDARIO
    private boolean diasCalendario;
    private boolean diasHabiles;

    //TIPO REVISION
    private String nombreSupervisor;
    private int codigoTipoRevision;

    //DERIVAR RECONOCIMIENTO DE INVESION
    private int codigoSupervisor;
    private String numeroOficio;
    private String registroSalida;
    private Date fechaEmisionDS;
    private int plazoOtorgado;
    private Date fechaLimiteDS;
    private int codigoModalidadConcecion;
    private int codigoTipoInversion;
    private String nombreRevisor;
    private int codigoContratoCompromiso;
    public final int formulario = 33;
    private RolOpcionesVO rolOpcion;

    public void validarSesion() throws IOException {
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
    }

    MonedaVO monedaVO = new MonedaVO();
    InvAvnDerivadaService invAvnDerivadaServiceImpl = new InvAvnDerivadaServiceImpl();
    InvAvnDerivadaVO invAvnDerivadaVO = new InvAvnDerivadaVO();
    ValorizacionInversionAvanceDetalleServiceImpl valorizacionInversionAvanceDetalleServiceImpl =
        new ValorizacionInversionAvanceDetalleServiceImpl();
    ValorizacionInversionAvanceServiceImpl valorizacionInversionAvanceServiceImpl =
        new ValorizacionInversionAvanceServiceImpl();
    List<TipoRevisionVO> listaTipoRevision = new ArrayList<>();
    TipoRevisionService tipoRevisionService = new TipoRevisionServiceImpl();
    DerivarReconocimientoSupervisorVO derivarReconocimientoSupervisorVO = new DerivarReconocimientoSupervisorVO();
    DerivarReconocimientoSupervisorService derivarReconocimientoServiceImpl =
        new DerivarReconocimientoSupervisorServiceImpl();
    List<InfraestructuraVO> listaInfraestructuras = new ArrayList<>();
    List<InfraestructuraVO> listaInfraestructurasC = new ArrayList<>();
    List<ValorizacionSupDetalleVO> listaValorizacionSup = new ArrayList<>();
    List<ValorizacionInversionAvanceDetalleVO> listValorizacionInversionAvanceDetalleVO = new ArrayList<>();
    List<ValorizacionInversionAvanceVO> listValorizacionInversionAvanceVO = new ArrayList<>();
    List<InversionVO> listaInversiones = new ArrayList<>();
    List<ContratoCompromisoVO> listaContratoCompromiso = new ArrayList<>();
    List<ContratoVO> listaContratos = new ArrayList<>();

    ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO =
        new ValorizacionInversionAvanceDetalleVO();
    @ManagedProperty(value = "#{inversionVO}")
    InversionVO inversionVO;
    ValorizacionInversionAvanceVO valorizacionInversionAvanceVO = new ValorizacionInversionAvanceVO();

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

    @ManagedProperty(value = "#{supervisorInversionesServiceImpl}")
    SupervisorInversionesService supervisorInversionesServiceImpl;

    @ManagedProperty(value = "#{supervisorInversionesVO}")
    private SupervisorInversionesVO supervisorInversionesVO;

    EmpresaSupervisoraVO empresaSupervisoraVO = new EmpresaSupervisoraVO();
    EmpresaSupervisoraService empresaSupervisoraService = new EmpresaSupervisoraServiceImpl();

    private List<SupervisorInversionesVO> listaSupervisor = new ArrayList<>();
    private List<EmpresaSupervisoraVO> listaEmpresaSupervisora = new ArrayList<>();
    

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
        nombreSupervisor = "";
        codigoTipoRevision = 0;
        codigoSupervisor = 0;
        numeroOficio = "";
        registroSalida = "";
        plazoOtorgado = 0;
        codigoModalidadConcecion = 0;
        codigoTipoInversion = 0;
        nombreRevisor = "";
        listValorizacionInversionAvanceDetalleVO = new ArrayList();
        listValorizacionInversionAvanceVO = new ArrayList();
    }

    public void cambiarDatos() {
    }

    public void cargarListaSupervisores() {
        try {
           
                listaSupervisor =
                    supervisorInversionesServiceImpl.buscarSupervisoresxInfraestructura(codigoInfraValSelecionado);
                listaEmpresaSupervisora = empresaSupervisoraService.query();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void elegirEmpresaSup(EmpresaSupervisoraVO empresaSupervisoraVO) {
        codigoSupervisor = empresaSupervisoraVO.getSupId();
        nombreSupervisor = empresaSupervisoraVO.getSupNombre();
    }

    public void elegirSupervisor(SupervisorInversionesVO supervisorInversionesSVO) {
        codigoSupervisor = supervisorInversionesSVO.getTsiId();
        nombreSupervisor = supervisorInversionesSVO.getTsiNombre();

    }

    public void listarTipoRevision() {
        try {
            listaTipoRevision = tipoRevisionService.query();
            listarInfraestructura();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarInfraestructura() {
        try {
            listaInfraestructuras = infraestructuraServiceImpl.query();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void desDiasHabiles() {
        try { 
           diasHabiles = false;

       } catch (Exception e) {
            e.printStackTrace();
        }
      
    }

    public void desDiasCalendario() {
        try {
           diasCalendario = false;
       } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void obtenerFechaLimite(){
        try {
           FechasUtil fechasUtil=new FechasUtil();
           Date fechacalculada;
            if (isDiasHabiles()){
                    
                    fechacalculada= fechasUtil.adicionaDias(fechaEmisionDS,plazoOtorgado,1);
                    fechaLimiteDS=fechacalculada; 
                }
            if (isDiasCalendario())
            {
          
           fechacalculada= fechasUtil.adicionaDias(fechaEmisionDS,plazoOtorgado,0);
           fechaLimiteDS=fechacalculada;
            }
       } catch (Exception e) {
            e.printStackTrace();
        }
          
        
        }

    public void cargarListaContratos() {
        try {
            listaContratos = contratoConcesionServiceImp.query();
            System.out.println("tamaño de la lista");


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
            codigoConcesion = contratoVO.getCncId();
            concesionVO = concesionServiceImpl.get(codigoConcesion);
            codigoTipoInversion = concesionVO.getTinId();
            idModalidadConcesion = contratoVO.getMcoId();
            idTipoInfraestructura = concesionVO.getTinId();
            codigoContrato = contratoVO.getConId();
            nombreConcecion = concesionVO.getCsiNombre();
            modalidadVO = modalidadServiceImp.get(idModalidadConcesion);
            codigoModalidadConcecion = modalidadVO.getMcoId();
            nombreModalidadConceción = modalidadVO.getMcoNombre();
            infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(idTipoInfraestructura);
            nombreTipoInfraestructura = infraestructuraTipoVO.getTinNombre();
            listaInfraestructuras = infraestructuraServiceImpl.query2(concesionVO.getCsiId());
            listaContratoCompromiso = contratoCompromisoServiceImpl.query1(codigoContrato);

            listarInversionDescripcion();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso",
                                                                          "La ficha ingresada no existe. Puede hacer el ingreso manualmente"));
            e.printStackTrace();
        }
    }

    public void cargarListaValorizacion() {
        try {
            listValorizacionInversionAvanceVO =
                valorizacionInversionAvanceServiceImpl.queryDerivarInversion(codigoContrato, codigoContratoCompromiso,
                                                                             1);
            for (ValorizacionInversionAvanceVO valorizacionInversionAvanceVO : listValorizacionInversionAvanceVO) {
                monedaVO = monedaServiceImpl.get(valorizacionInversionAvanceVO.getMonId());
                valorizacionInversionAvanceVO.setMonedaNombre(monedaVO.getMonSimbolo());
                if (valorizacionInversionAvanceVO.getIaeId() == 1) {
                    valorizacionInversionAvanceVO.setEstadoNombre("REGISTRADA");
                }
            }

        } catch (Exception e) {
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
            BigDecimal  totalTemporal = new BigDecimal("0");
            valorizacionInversionAvanceVO = valorizacionInversionAvanceServiceImpl.get(detalle);
            anio = valorizacionInversionAvanceVO.getTiaAnyo();
            totalTotal = valorizacionInversionAvanceVO.getTiaMontoTotalPresentado();
            listValorizacionInversionAvanceDetalleVO = valorizacionInversionAvanceDetalleServiceImpl.query1(detalle);
            for (ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO1 :
                 listValorizacionInversionAvanceDetalleVO) {
                inversionDescripcionVO =
                    inversionDescripcionServicesImpl.get(valorizacionInversionAvanceDetalleVO1.getDtiId());
                valorizacionInversionAvanceDetalleVO1.setDescripcionInversion(inversionDescripcionVO.getItdNombre());
                totalTemporal = totalTemporal.add(valorizacionInversionAvanceDetalleVO1.getMontoPresentado());
                monedaVO = monedaServiceImpl.get(valorizacionInversionAvanceDetalleVO1.getMonId());
                valorizacionInversionAvanceDetalleVO1.setNombreMoneda(monedaVO.getMonSimbolo());
            }
            totalTotal = totalTemporal;

        } catch (Exception e) {
            e.printStackTrace();
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

    public void guardar() {
        try {
            System.out.println("HOLA1");
            invAvnDerivadaVO.setTiaNumero(valorizacionInversionAvanceVO.getTiaNumero());
            System.out.println("HOLA3");
            invAvnDerivadaVO.setCsiId(new java.math.BigDecimal(String.valueOf(codigoConcesion)));
            invAvnDerivadaVO.setInvId(new java.math.BigDecimal(String.valueOf(codigoInversion)));
            invAvnDerivadaVO.setMcoId(new java.math.BigDecimal(String.valueOf(codigoModalidadConcecion)));
            invAvnDerivadaVO.setTinId(new java.math.BigDecimal(String.valueOf(codigoTipoInversion)));
            invAvnDerivadaVO.setIadAnyo(anio);
            invAvnDerivadaVO.setIadAsunto(asunto);
            invAvnDerivadaVO.setIadFechaEmision(fechaEmisionDS);
            invAvnDerivadaVO.setIadFechaFin(fechaLimiteDS);
            invAvnDerivadaVO.setIadFechaRegistro(fechaRegistroSDT);
            invAvnDerivadaVO.setIadPlazoDias(plazoOtorgado);
            invAvnDerivadaVO.setIasEstado(new java.math.BigDecimal(String.valueOf(1)));
            invAvnDerivadaVO.setIasFechaAlta(new Date());
            invAvnDerivadaVO.setNroOficio(numeroOficio);
            System.out.println("HOLA");
            invAvnDerivadaVO.setIadTipoSup(codigoTipoRevision);
            System.out.println("HOLA2");
                
            if (isDiasCalendario()){
                    invAvnDerivadaVO.setIadTipoDias(new BigDecimal("0"));
                }
            if (isDiasHabiles()){
                    invAvnDerivadaVO.setIadTipoDias(new BigDecimal("1"));
                }
            
            
            
            if (codigoTipoRevision==1){
                    invAvnDerivadaVO.setSupID(supervisorInversionesVO.getTsiId());
                }
            
            if (codigoTipoRevision==2){
                
                    invAvnDerivadaVO.setTsiID(codigoSupervisor);
                   
                }
            valorizacionInversionAvanceVO.setIaeId(2);
            valorizacionInversionAvanceServiceImpl.update(valorizacionInversionAvanceVO);
            invAvnDerivadaServiceImpl.insert(invAvnDerivadaVO);
            limpiarTodo();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                          "SE REGISTRO EL AVANCE CON EXITO"));


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("PROBLEMAS AL GUARDAR AQUI");
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

    public void setCodigoInversion(int codigoInversion) {
        this.codigoInversion = codigoInversion;
    }

    public int getCodigoInversion() {
        return codigoInversion;
    }

    public void setIdTipoInfraestructura(int idTipoInfraestructura) {
        this.idTipoInfraestructura = idTipoInfraestructura;
    }

    public int getIdTipoInfraestructura() {
        return idTipoInfraestructura;
    }

    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
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

    public void setCodigoInversionDescripcion(int codigoInversionDescripcion) {
        this.codigoInversionDescripcion = codigoInversionDescripcion;
    }

    public int getCodigoInversionDescripcion() {
        return codigoInversionDescripcion;
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


    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
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

    public void setNombreSupervisor(String nombreSupervisor) {
        this.nombreSupervisor = nombreSupervisor;
    }

    public String getNombreSupervisor() {
        return nombreSupervisor;
    }

    public void setCodigoTipoRevision(int codigoTipoRevision) {
        this.codigoTipoRevision = codigoTipoRevision;
    }

    public int getCodigoTipoRevision() {
        return codigoTipoRevision;
    }

    public void setCodigoSupervisor(int codigoSupervisor) {
        this.codigoSupervisor = codigoSupervisor;
    }

    public int getCodigoSupervisor() {
        return codigoSupervisor;
    }

    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    public String getNumeroOficio() {
        return numeroOficio;
    }

    public void setRegistroSalida(String registroSalida) {
        this.registroSalida = registroSalida;
    }

    public String getRegistroSalida() {
        return registroSalida;
    }

    public void setPlazoOtorgado(int plazoOtorgado) {
        this.plazoOtorgado = plazoOtorgado;
    }

    public int getPlazoOtorgado() {
        return plazoOtorgado;
    }

    public void setCodigoModalidadConcecion(int codigoModalidadConcecion) {
        this.codigoModalidadConcecion = codigoModalidadConcecion;
    }

    public int getCodigoModalidadConcecion() {
        return codigoModalidadConcecion;
    }

    public void setCodigoTipoInversion(int codigoTipoInversion) {
        this.codigoTipoInversion = codigoTipoInversion;
    }

    public int getCodigoTipoInversion() {
        return codigoTipoInversion;
    }

    public void setNombreRevisor(String nombreRevisor) {
        this.nombreRevisor = nombreRevisor;
    }

    public String getNombreRevisor() {
        return nombreRevisor;
    }

    public void setCodigoContratoCompromiso(int codigoContratoCompromiso) {
        this.codigoContratoCompromiso = codigoContratoCompromiso;
    }

    public int getCodigoContratoCompromiso() {
        return codigoContratoCompromiso;
    }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }


    public void setFechaEmisionDS(Date fechaEmisionDS) {
        this.fechaEmisionDS = fechaEmisionDS;
    }

    public Date getFechaEmisionDS() {
        return fechaEmisionDS;
    }

    public void setFechaLimiteDS(Date fechaLimiteDS) {
        this.fechaLimiteDS = fechaLimiteDS;
    }

    public Date getFechaLimiteDS() {
        return fechaLimiteDS;
    }

    public void setInvAvnDerivadaServiceImpl(InvAvnDerivadaService invAvnDerivadaServiceImpl) {
        this.invAvnDerivadaServiceImpl = invAvnDerivadaServiceImpl;
    }

    public InvAvnDerivadaService getInvAvnDerivadaServiceImpl() {
        return invAvnDerivadaServiceImpl;
    }

    public void setInvAvnDerivadaVO(InvAvnDerivadaVO invAvnDerivadaVO) {
        this.invAvnDerivadaVO = invAvnDerivadaVO;
    }

    public InvAvnDerivadaVO getInvAvnDerivadaVO() {
        return invAvnDerivadaVO;
    }

    public void setValorizacionInversionAvanceDetalleServiceImpl(ValorizacionInversionAvanceDetalleServiceImpl valorizacionInversionAvanceDetalleServiceImpl) {
        this.valorizacionInversionAvanceDetalleServiceImpl = valorizacionInversionAvanceDetalleServiceImpl;
    }

    public ValorizacionInversionAvanceDetalleServiceImpl getValorizacionInversionAvanceDetalleServiceImpl() {
        return valorizacionInversionAvanceDetalleServiceImpl;
    }

    public void setValorizacionInversionAvanceServiceImpl(ValorizacionInversionAvanceServiceImpl valorizacionInversionAvanceServiceImpl) {
        this.valorizacionInversionAvanceServiceImpl = valorizacionInversionAvanceServiceImpl;
    }

    public ValorizacionInversionAvanceServiceImpl getValorizacionInversionAvanceServiceImpl() {
        return valorizacionInversionAvanceServiceImpl;
    }

    public void setListaTipoRevision(List<TipoRevisionVO> listaTipoRevision) {
        this.listaTipoRevision = listaTipoRevision;
    }

    public List<TipoRevisionVO> getListaTipoRevision() {
        return listaTipoRevision;
    }

    public void setTipoRevisionService(TipoRevisionService tipoRevisionService) {
        this.tipoRevisionService = tipoRevisionService;
    }

    public TipoRevisionService getTipoRevisionService() {
        return tipoRevisionService;
    }

    public void setDerivarReconocimientoSupervisorVO(DerivarReconocimientoSupervisorVO derivarReconocimientoSupervisorVO) {
        this.derivarReconocimientoSupervisorVO = derivarReconocimientoSupervisorVO;
    }

    public DerivarReconocimientoSupervisorVO getDerivarReconocimientoSupervisorVO() {
        return derivarReconocimientoSupervisorVO;
    }

    public void setDerivarReconocimientoServiceImpl(DerivarReconocimientoSupervisorService derivarReconocimientoServiceImpl) {
        this.derivarReconocimientoServiceImpl = derivarReconocimientoServiceImpl;
    }

    public DerivarReconocimientoSupervisorService getDerivarReconocimientoServiceImpl() {
        return derivarReconocimientoServiceImpl;
    }

    public void setListaInfraestructuras(List<InfraestructuraVO> listaInfraestructuras) {
        this.listaInfraestructuras = listaInfraestructuras;
    }

    public List<InfraestructuraVO> getListaInfraestructuras() {
        return listaInfraestructuras;
    }

    public void setListaInfraestructurasC(List<InfraestructuraVO> listaInfraestructurasC) {
        this.listaInfraestructurasC = listaInfraestructurasC;
    }

    public List<InfraestructuraVO> getListaInfraestructurasC() {
        return listaInfraestructurasC;
    }

    public void setListaValorizacionSup(List<ValorizacionSupDetalleVO> listaValorizacionSup) {
        this.listaValorizacionSup = listaValorizacionSup;
    }

    public List<ValorizacionSupDetalleVO> getListaValorizacionSup() {
        return listaValorizacionSup;
    }

    public void setListValorizacionInversionAvanceDetalleVO(List<ValorizacionInversionAvanceDetalleVO> listValorizacionInversionAvanceDetalleVO) {
        this.listValorizacionInversionAvanceDetalleVO = listValorizacionInversionAvanceDetalleVO;
    }

    public List<ValorizacionInversionAvanceDetalleVO> getListValorizacionInversionAvanceDetalleVO() {
        return listValorizacionInversionAvanceDetalleVO;
    }

    public void setListValorizacionInversionAvanceVO(List<ValorizacionInversionAvanceVO> listValorizacionInversionAvanceVO) {
        this.listValorizacionInversionAvanceVO = listValorizacionInversionAvanceVO;
    }

    public List<ValorizacionInversionAvanceVO> getListValorizacionInversionAvanceVO() {
        return listValorizacionInversionAvanceVO;
    }

    public void setListaInversiones(List<InversionVO> listaInversiones) {
        this.listaInversiones = listaInversiones;
    }

    public List<InversionVO> getListaInversiones() {
        return listaInversiones;
    }

    public void setListaContratoCompromiso(List<ContratoCompromisoVO> listaContratoCompromiso) {
        this.listaContratoCompromiso = listaContratoCompromiso;
    }

    public List<ContratoCompromisoVO> getListaContratoCompromiso() {
        return listaContratoCompromiso;
    }

    public void setListaContratos(List<ContratoVO> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<ContratoVO> getListaContratos() {
        return listaContratos;
    }

    public void setValorizacionInversionAvanceDetalleVO(ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO) {
        this.valorizacionInversionAvanceDetalleVO = valorizacionInversionAvanceDetalleVO;
    }

    public ValorizacionInversionAvanceDetalleVO getValorizacionInversionAvanceDetalleVO() {
        return valorizacionInversionAvanceDetalleVO;
    }

    public void setInversionVO(InversionVO inversionVO) {
        this.inversionVO = inversionVO;
    }

    public InversionVO getInversionVO() {
        return inversionVO;
    }

    public void setValorizacionInversionAvanceVO(ValorizacionInversionAvanceVO valorizacionInversionAvanceVO) {
        this.valorizacionInversionAvanceVO = valorizacionInversionAvanceVO;
    }

    public ValorizacionInversionAvanceVO getValorizacionInversionAvanceVO() {
        return valorizacionInversionAvanceVO;
    }

    public void setInversionDescripcionVO(InversionDescripcionVO inversionDescripcionVO) {
        this.inversionDescripcionVO = inversionDescripcionVO;
    }

    public InversionDescripcionVO getInversionDescripcionVO() {
        return inversionDescripcionVO;
    }

    public void setInversionDescripcionServicesImpl(InversionDescripcionServices inversionDescripcionServicesImpl) {
        this.inversionDescripcionServicesImpl = inversionDescripcionServicesImpl;
    }

    public InversionDescripcionServices getInversionDescripcionServicesImpl() {
        return inversionDescripcionServicesImpl;
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

    public void setContratoCompromisoServiceImpl(ContratoCompromisoService contratoCompromisoServiceImpl) {
        this.contratoCompromisoServiceImpl = contratoCompromisoServiceImpl;
    }

    public ContratoCompromisoService getContratoCompromisoServiceImpl() {
        return contratoCompromisoServiceImpl;
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

    public void setContratoCompromisoVO(ContratoCompromisoVO contratoCompromisoVO) {
        this.contratoCompromisoVO = contratoCompromisoVO;
    }

    public ContratoCompromisoVO getContratoCompromisoVO() {
        return contratoCompromisoVO;
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

    public void setMonedaServiceImpl(MonedaService monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }

    public MonedaService getMonedaServiceImpl() {
        return monedaServiceImpl;
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

    public void setListaSupervisor(List<SupervisorInversionesVO> listaSupervisor) {
        this.listaSupervisor = listaSupervisor;
    }

    public List<SupervisorInversionesVO> getListaSupervisor() {
        return listaSupervisor;
    }

    public void setListaEmpresaSupervisora(List<EmpresaSupervisoraVO> listaEmpresaSupervisora) {
        this.listaEmpresaSupervisora = listaEmpresaSupervisora;
    }

    public List<EmpresaSupervisoraVO> getListaEmpresaSupervisora() {
        return listaEmpresaSupervisora;
    }


    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setMontoPrestado(BigDecimal montoPrestado) {
        this.montoPrestado = montoPrestado;
    }

    public BigDecimal getMontoPrestado() {
        return montoPrestado;
    }

    public void setTotalTotal(BigDecimal totalTotal) {
        this.totalTotal = totalTotal;
    }

    public BigDecimal getTotalTotal() {
        return totalTotal;
    }

}


