package com.ositran.valorizaciones;

import com.ositran.model.Infraestructura;
import com.ositran.service.AvanceInversionWebService;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.DatosStdService;
import com.ositran.service.IgvService;
import com.ositran.service.InfraestructuraService;
import com.ositran.service.InfraestructuraTipoService;
import com.ositran.service.InversionDescripcionServices;
import com.ositran.service.InversionService;
import com.ositran.service.ModalidadConcesionService;
import com.ositran.service.MonedaService;
import com.ositran.service.ValorizacionInversionAvanceDetalleService;
import com.ositran.service.ValorizacionInversionAvanceService;
import com.ositran.serviceimpl.ValorizacionInversionAvanceDetalleServiceImpl;
import com.ositran.serviceimpl.ValorizacionInversionAvanceServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.FechasUtil;
import com.ositran.vo.bean.AvanceInversionWebVO;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.IgvVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InversionDescripcionVO;
import com.ositran.vo.bean.InversionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.RolOpcionesVO;
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
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "registrarAvanceInversionMB")
@ViewScoped
public class RegistrarAvanceInversionMB {
    private int fichaRegistro;
    private int codigoInfraestructura;
    private String nombreConcecion;
    private String nombreTipoInfraestructura;
    private String nombreModalidadConceción;
    private int idModalidadConcesion;
    private int codigoConcesion;
    private int codigoInversion;
    private int codigoTipoInversion;
    private int idTipoInfraestructura;
    private int codigoContrato;
    //***************************DATOS SDT******************************//
    private String numero;
    private int anio;
    private Date fechaRegistroSDT;
    private String asunto;
    //*********************DATOS CONTRATO COMPROMISO********************//
    private int contratoCompromisoSeleccionado;
    private int plazoContrato;
    private String plazoCompromiso;
    private BigDecimal total;
    private int codigoMoneda;
    private int codigoInversionDescripcion;
    //*********************DATOS VALORIZACION********************//
    private int codMoneda;
    private String nombreMoneda;
    private List<MonedaVO> listaMoneda = new ArrayList<>();
    private int codigoInfraValSelecionado;
    private List<InversionDescripcionVO> listaDescripcionTipoInversion = new ArrayList<>();
    private Date inicioPeriodo;
    private Date finPeriodo;
    private BigDecimal montoPrestado;
    private boolean igv;
    private String descripcionValorizacionDetalle;
    private int contador = 0;
    private BigDecimal totalMonto = new BigDecimal("0");
    private BigDecimal totalIgv = new BigDecimal("0"); ;
    private BigDecimal totalPresentado = new BigDecimal("0"); ;
    private int tipoComtratoCompromiso;
    public final int formulario = 32;
    private RolOpcionesVO rolOpcion;
    private Date fechaVencimiento;

    //CALENDARIO
    private boolean diasCalendario=false;
    private boolean diasHabiles=false;
    MonedaVO monedaVO = new MonedaVO();
    ValorizacionInversionAvanceService valorizacionInversionAvanceServiceImpl =
        new ValorizacionInversionAvanceServiceImpl();
    List<InfraestructuraVO> listaInfraestructuras = new ArrayList<>();
    List<InfraestructuraVO> listaInfraestructurasC = new ArrayList<>();
    List<ValorizacionSupDetalleVO> listaValorizacionSup = new ArrayList<>();
    List<ValorizacionInversionAvanceDetalleVO> listValorizacionInversionAvanceDetalleVO = new ArrayList<>();
    List<InversionVO> listaInversiones = new ArrayList<>();
    List<ContratoCompromisoVO> listaContratoCompromiso = new ArrayList<>();
    List<ContratoVO> listaContratos = new ArrayList<>();
    ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO =
        new ValorizacionInversionAvanceDetalleVO();
    ValorizacionInversionAvanceDetalleService valorizacionInversionAvanceDetalleService =
        new ValorizacionInversionAvanceDetalleServiceImpl();
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

    @ManagedProperty(value = "#{igvVO}")
    IgvVO igvVO;

    @ManagedProperty(value = "#{igvServiceImpl}")
    IgvService igvServiceImpl;


    public void validarSesion() throws IOException {
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
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
        plazoContrato = 0;
        plazoCompromiso = "";
        codigoMoneda = 0;
        codigoInversionDescripcion = 0;
        codMoneda = 0;
        codigoInfraValSelecionado = 0;
        inicioPeriodo = null;
        finPeriodo = null;
        montoPrestado = new BigDecimal("0");
        contador = 0;
        totalMonto = new BigDecimal("0");
        totalIgv = new BigDecimal("0");
        totalPresentado = new BigDecimal("0");
        codigoTipoInversion = 0;
        listValorizacionInversionAvanceDetalleVO = new ArrayList();
        listValorizacionInversionAvanceDetalleVO = new ArrayList();
    }

    public void elegirContrato(ContratoVO contratoVO) {
        try {
            plazoContrato = contratoVO.getConPlazorevision();
            codigoConcesion = contratoVO.getCncId();
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
            listaContratoCompromiso = contratoCompromisoServiceImpl.querySupervisado(codigoContrato);
            if (contratoVO.getConTipodias() == 0) {
                diasCalendario = true;
            }
            if (contratoVO.getConTipodias() == 1) {
                diasHabiles = true;
            }


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
            tipoComtratoCompromiso = contratoCompromisoVO.getTccTipo();
            plazoCompromiso = contratoCompromisoVO.getCcoPlazo();
            total = contratoCompromisoVO.getCcoTotal();
            codigoMoneda = contratoCompromisoVO.getMonId();
            monedaVO = monedaServiceImpl.get(codigoMoneda);
            nombreMoneda = monedaVO.getMonNombre();
            codigoInversionDescripcion = contratoCompromisoVO.getTivId();
            listarInversionDescripcion(contratoCompromisoVO.getTivId());
            
        } catch (Exception e) {
            System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
            e.printStackTrace();
            
        }
    }


    public void listarInversionDescripcion(int tipoInversion) {
        try {

            listaDescripcionTipoInversion = inversionDescripcionServicesImpl.query1(tipoInversion);

        } catch (Exception e) {
            System.out.println("   PROBLEMAS CON EL LISTADO DE INVERSION DESCRIPCION");
            e.printStackTrace();
        }
    }

    public void cargarDatosSDT() {
        try {
            viewTdInternosVO = datosStdServiceImpl.BuscaStd(anio, numero);
            fechaRegistroSDT = viewTdInternosVO.getFechaRegistro();
            asunto = viewTdInternosVO.getAsunto();
            FechasUtil fechasUtil=new FechasUtil();
            Date fechacalculada;
            fechacalculada= fechasUtil.adicionaDias(fechaRegistroSDT,plazoContrato,0);
            fechaVencimiento=fechacalculada;
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
            boolean validarMonto = String.valueOf(montoPrestado).matches("^(\\d|-)?(\\d|,)*\\.?\\d*$");
            if (validarMonto == false) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "AVISO",
                                                                              "EL MONTO PRESENTADO NO TIENE EL FORMATO CORRECTO"));
            } else if (montoPrestado.compareTo(BigDecimal.ZERO) == 0) {
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
            } else if (codigoInfraestructura == 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "AVISO",
                                                                              "DEBE SELECIONAR AEROPUERTO"));
            } else {

                ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO1 =
                    new ValorizacionInversionAvanceDetalleVO();
                valorizacionInversionAvanceDetalleVO1.setMonId(codMoneda);
                infraestructuraVO = infraestructuraServiceImpl.get2(codigoInfraestructura);
                valorizacionInversionAvanceDetalleVO1.setAeropuertos(infraestructuraVO.getInfNombre());
                valorizacionInversionAvanceDetalleVO1.setDtiId(codigoInversionDescripcion);
                inversionDescripcionVO = inversionDescripcionServicesImpl.get(codigoInversionDescripcion);
                valorizacionInversionAvanceDetalleVO1.setTivId(inversionDescripcionVO.getTivId());
                valorizacionInversionAvanceDetalleVO1.setCsiId(codigoConcesion);
                valorizacionInversionAvanceDetalleVO1.setInfId(codigoInfraestructura);
                valorizacionInversionAvanceDetalleVO1.setTinId(idTipoInfraestructura);
                valorizacionInversionAvanceDetalleVO1.setDescripcionInversion(inversionDescripcionVO.getItdNombre());
                valorizacionInversionAvanceDetalleVO1.setIadDescripcion(descripcionValorizacionDetalle);
                valorizacionInversionAvanceDetalleVO1.setIadFechaInicio(inicioPeriodo);
                valorizacionInversionAvanceDetalleVO1.setIadFechaFin(finPeriodo);
                BigDecimal igv1 = new BigDecimal("0");
                for (MonedaVO mon : listaMoneda) {
                    if (mon.getMonId() == codMoneda) {
                        valorizacionInversionAvanceDetalleVO1.setNombreMoneda(mon.getMonNombre());
                    }
                }
                
                if (igv) {
                    igv1 = new BigDecimal("0.18");
                    valorizacionInversionAvanceDetalleVO1.setIgv(montoPrestado.multiply(igv1).setScale(2,BigDecimal.ROUND_UP));
                } else {
                    igv1 = new BigDecimal("0");
                }
                valorizacionInversionAvanceDetalleVO1.setTiaTotal(montoPrestado.subtract(valorizacionInversionAvanceDetalleVO1.getIgv()));
                valorizacionInversionAvanceDetalleVO1.setMontoPresentado(montoPrestado);
                
             listValorizacionInversionAvanceDetalleVO.add(valorizacionInversionAvanceDetalleVO1);   
                
             totalPresentado= totalPresentado.add(montoPrestado).setScale(2, BigDecimal.ROUND_UP);
             totalIgv =totalIgv.add(valorizacionInversionAvanceDetalleVO1.getIgv().setScale(2, BigDecimal.ROUND_UP));
             totalMonto= totalMonto.add(valorizacionInversionAvanceDetalleVO1.getTiaTotal()).setScale(2,BigDecimal.ROUND_UP);
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
        
        
        totalPresentado = totalPresentado.subtract(listValorizacionInversionAvanceDetalleVO.get(idcodigo).getMontoPresentado()).setScale(2,
                                                                                                               BigDecimal.ROUND_UP);
        totalMonto = totalMonto.subtract(listValorizacionInversionAvanceDetalleVO.get(idcodigo).getTiaTotal()).setScale(2,
                                                                                                                      BigDecimal.ROUND_UP);
        totalIgv =totalIgv.subtract(listValorizacionInversionAvanceDetalleVO.get(idcodigo).getIgv()).setScale(2,
                                                                                                        BigDecimal.ROUND_UP);
        
        listValorizacionInversionAvanceDetalleVO.remove(idcodigo);
    }


    public void guardar() {
        try {
            
            valorizacionInversionAvanceVO.setConId(codigoContrato);
            valorizacionInversionAvanceVO.setInvId(codigoInversion);
            valorizacionInversionAvanceVO.setCsiId(codigoConcesion);
            valorizacionInversionAvanceVO.setMcoId(idModalidadConcesion);
            valorizacionInversionAvanceVO.setTinId(idTipoInfraestructura);
            valorizacionInversionAvanceVO.setCcoId(contratoCompromisoSeleccionado);
            valorizacionInversionAvanceVO.setMonId(codigoMoneda);
            valorizacionInversionAvanceVO.setIaeId(1);
            valorizacionInversionAvanceVO.setTiaAnyo(anio);
            valorizacionInversionAvanceVO.setTiaAsunto(asunto);
            if (diasCalendario){
                    valorizacionInversionAvanceVO.setTiaDiasHabiles(0); 
                }
            if (diasHabiles){
                    valorizacionInversionAvanceVO.setTiaDiasHabiles(1); 
                }
            valorizacionInversionAvanceVO.setTiaFechaRegistro(fechaRegistroSDT);
            valorizacionInversionAvanceVO.setTiaFechaVencimientoPlazo(fechaVencimiento);
            valorizacionInversionAvanceVO.setTiaPlazoEnDias(plazoContrato);
            valorizacionInversionAvanceVO.setTiaHr(Integer.parseInt(numero));
            valorizacionInversionAvanceVO.setTccTipo(tipoComtratoCompromiso);
            valorizacionInversionAvanceVO.setTiaMontoTotalPresentado(totalPresentado);

            int idCabecera = valorizacionInversionAvanceServiceImpl.insert(valorizacionInversionAvanceVO);

            for (ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO3 :
                 listValorizacionInversionAvanceDetalleVO) {
                valorizacionInversionAvanceDetalleVO3.setTiaNumero(idCabecera);
                valorizacionInversionAvanceDetalleService.insert(valorizacionInversionAvanceDetalleVO3);
            }


            
        
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                          "SE REGISTRO EL AVANCE CON EXITO"));
            limpiarTodo();

        } catch (Exception e) {
            e.printStackTrace();
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

    public void setTotalPresentado(BigDecimal totalPresentado) {
        this.totalPresentado = totalPresentado;
    }

    public BigDecimal getTotalPresentado() {
        return totalPresentado;
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

    public void setCodigoTipoInversion(int codigoTipoInversion) {
        this.codigoTipoInversion = codigoTipoInversion;
    }

    public int getCodigoTipoInversion() {
        return codigoTipoInversion;
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

    public void setPlazoContrato(int plazoContrato) {
        this.plazoContrato = plazoContrato;
    }

    public int getPlazoContrato() {
        return plazoContrato;
    }

    public void setPlazoCompromiso(String plazoCompromiso) {
        this.plazoCompromiso = plazoCompromiso;
    }

    public String getPlazoCompromiso() {
        return plazoCompromiso;
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


    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
}

