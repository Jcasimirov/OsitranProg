
package com.ositran.valorizaciones;

import com.ositran.model.Infraestructura;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.DatosStdService;
import com.ositran.service.InversionService;
import com.ositran.service.ModalidadConcesionService;
import com.ositran.service.ValorizacionSupService;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.serviceimpl.MonedaServiceImpl;
import com.ositran.serviceimpl.SupervisorInversionesServiceImpl;
import com.ositran.serviceimpl.ValorizacionConceptoServiceImpl;
import com.ositran.serviceimpl.ValorizacionSupDetalleServiceImpl;
import com.ositran.serviceimpl.ValorizacionSupServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InversionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.SupervisorInversionesVO;
import com.ositran.vo.bean.UsuarioVO;
import com.ositran.vo.bean.ValorizacionConceptoVO;
import com.ositran.vo.bean.ValorizacionSupDetalleVO;
import com.ositran.vo.bean.ValorizacionSupVO;
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

@ManagedBean(name = "regValorizacionSupervisionMB")
@ViewScoped

public class RegistrarValorizacionSupervision {
    public final int formulario = 35;
    private RolOpcionesVO rolOpcion;
    private int tipoInfraestructuraGlobal;
    private UsuarioVO usuario;
    private int tipoInfraestructura;
    
    
    public void validarSesion() throws IOException {
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
        tipoInfraestructuraGlobal = Reutilizar.getNewInstance().obtenerDatosEmpleadoLogueado().getTinId();
        usuario = Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        tipoInfraestructura = tipoInfraestructura = usuario.getTinId();
    }
    
    
    
    
    private String t_conce;
    private int codigoConcesion;
    private int codigoTipoInfra;
    private int codigoModalidadConcesion;
    private int ccoId;
    private int tccTipo;
    private String nombreConcesion;
    private String contratoConcesion;
    private String t_concesion;
    private String t_modconc;
    private String nrohr;
    private String añohr;
    private String freg;
    private String asuntohr;
    private String nomSupervisor;
    private int monedaSeleccionada;
    private int conceptoSeleccionada;
    private int infraestructuraSeleccionada;
    private int inversionSeleccionada;
    private int contratoCompromisoSeleccionado;
    private int conId;
    private String t_tinfra;
    private int codigoInversion;
    private int codigoContratoCompromiso;
    private String nombreMoneda;
    
    private int codigoInfraestructura;
    private int añohrbus;
    private int nrohrbus;
    private String plazo;
    private int codigoMoneda;
    private int codigoContrato;
    private BigDecimal total;
    private BigDecimal montoTabla;
    private int cvaId;
    private boolean igv;
    private double ttotal;
    private BigDecimal tvsNeto=BigDecimal.ZERO;;
    private BigDecimal tvsBruto=BigDecimal.ZERO;;
    private BigDecimal tvsIgv=BigDecimal.ZERO; ;
    
    private int codigoSupervisor;
    
    ValorizacionSupDetalleServiceImpl valorizacionSupDetalleServiceImpl= new ValorizacionSupDetalleServiceImpl(); 
        
    private List<ContratoVO> listaContratos = new ArrayList<ContratoVO>();
    private List<MonedaVO> listaMoneda = new ArrayList<MonedaVO>();
    private List<InfraestructuraVO> listaInfraestructuras = new ArrayList<InfraestructuraVO>();
    private List<InfraestructuraVO> listaInfraestructurasC = new ArrayList<InfraestructuraVO>();
    private List<InfraestructuraTipoVO> listaInfraestructuraTipos = new ArrayList<InfraestructuraTipoVO>();
    private List<InversionVO> listaInversiones = new ArrayList<InversionVO>();
    private List<SupervisorInversionesVO> listaSupervisor = new ArrayList<SupervisorInversionesVO>();
    private List<ContratoVO> listaContratosConcesion = new ArrayList<ContratoVO>();
    private List<ValorizacionConceptoVO> listaConcepto = new ArrayList<ValorizacionConceptoVO>();
    private List<ContratoCompromisoVO> listaContratoCompromiso = new ArrayList<ContratoCompromisoVO>();
    private List<ValorizacionSupDetalleVO> listaValorizacion = new ArrayList<ValorizacionSupDetalleVO>();
    
    
    MonedaVO monedaVO = new MonedaVO();
    SupervisorInversionesVO supervisorInversionesVO = new SupervisorInversionesVO();
    
    ValorizacionSupVO valorizacionSupVO = new ValorizacionSupVO();
    ValorizacionSupService valorizacionSupServiceImpl = new ValorizacionSupServiceImpl();

    @ManagedProperty(value = "#{monedaServiceImpl}")
    private MonedaServiceImpl monedaServiceImpl;
    
    
   
    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionService contratoConcesionServiceImp;
    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionService concesionServiceImpl;
    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;
    @ManagedProperty(value = "#{ViewTdInternosVO}")
    ViewTdInternosVO viewTdInternosVO;
    @ManagedProperty(value = "#{datosStdServiceImpl}")
    DatosStdService datosStdServiceImpl;
    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
    ContratoCompromisoService contratoCompromisoServiceImpl;
    @ManagedProperty(value = "#{contratoCompromisoVO}")
    ContratoCompromisoVO contratoCompromisoVO;
    
    ValorizacionConceptoServiceImpl valorizacionConceptoServiceImpl= new ValorizacionConceptoServiceImpl();
    @ManagedProperty(value = "#{valorizacionConceptoVO}")
    ValorizacionConceptoVO valorizacionConceptoVO;
    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    InfraestructuraTipoVO infraestructuraTipoVO;
    @ManagedProperty(value = "#{concesionVO}")
    ConcesionVO concesionVO;
    @ManagedProperty(value = "#{modalidadConcesionVO}")
    ModalidadConcesionVO modalidadConcesionVO;
    @ManagedProperty(value = "#{modalidadConcesionServiceImpl}")
    ModalidadConcesionServiceImpl modalidadConcesionServiceImpl;
    @ManagedProperty(value = "#{infraestructura}")
    Infraestructura infraestructura;
    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    InfraestructuraServiceImpl infraestructuraServiceImpl;
    @ManagedProperty(value = "#{infraestructuraVO}")
    InfraestructuraVO infraestructuraVO;
    @ManagedProperty(value = "#{inversionServiceImpl}")
    InversionService inversionServiceImpl;
    @ManagedProperty(value = "#{supervisorInversionesServiceImpl}")
    SupervisorInversionesServiceImpl supervisorInversionesServiceImpl;
    @ManagedProperty(value = "#{inversionVO}")
    InversionVO inversionVO;
    @ManagedProperty(value = "#{contratoVO}")
    ContratoVO contratoVO;

    @ManagedProperty(value = "#{modalidadVO}")
    ModalidadConcesionVO modalidadVO;    
    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionService modalidadServiceImp;

    public void cargarListaContratos() {
        try {
            listaContratos = contratoConcesionServiceImp.query(); //buscarContratos1(tipoInfraestructura);
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
            supervisorInversionesVO = supervisorInversionesServiceImpl.get(codigoTipoInfra);
            nomSupervisor=supervisorInversionesVO.getTsiNombre();
            codigoSupervisor=supervisorInversionesVO.getTsiId();
            
            cargarListaconcepto();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso",
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
    //--buscar std--//
    public void BuscarStd() throws SQLException {

        if (nrohr.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!nrohr.trim().equals("") && Integer.parseInt(nrohr) < 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (añohr.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese un Año de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!añohr.trim().equals("") && Integer.parseInt(añohr) < 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!añohr.trim().equals("") && añohr.length() < 4) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Año de Hoja de Ruta Válido");
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
                        new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se Encontraron Registros");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    //----------------------//
    //---------DATOS VALORIZACION-------------//
    public void cargarListaMoneda() {
        try {

            listaMoneda = monedaServiceImpl.query();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void cargarListaconcepto() {
        try {
            listaConcepto = valorizacionConceptoServiceImpl.query();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //--quitar lista---//
    public void quitarLista(){
        
            FacesContext context=FacesContext.getCurrentInstance();
            Map requestMap=context.getExternalContext().getRequestParameterMap();
            Object str=requestMap.get("indexLista");
            int idcodigo=Integer.valueOf(str.toString());            
            tvsNeto=tvsNeto.subtract(listaValorizacion.get(idcodigo).getNeto());
            tvsIgv=tvsIgv.subtract(listaValorizacion.get(idcodigo).getIgv());
            tvsBruto=tvsBruto.subtract(listaValorizacion.get(idcodigo).getTtotal());
            listaValorizacion.remove(idcodigo);
        }
    //--fin quitar lista--//
    public void guardarTabla() {
        
       if(conceptoSeleccionada==0){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                          "Seleccionar Concepto"));   
        }else if(monedaSeleccionada == 0){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                          "Seleccionar Moneda"));   
        } else if(montoTabla==null){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                          "Insertar Monto"));  
        }else{
            
            try {
                listaMoneda = monedaServiceImpl.query();
                listaConcepto=valorizacionConceptoServiceImpl.query();
                BigDecimal igv1;
                MonedaVO monNombre = getMonedaServiceImpl().get(monedaSeleccionada);
                ValorizacionConceptoVO cvaNombre = valorizacionConceptoServiceImpl.get(conceptoSeleccionada);
                ValorizacionSupDetalleVO valorizacionSupDetalleVO = new ValorizacionSupDetalleVO();
                valorizacionSupDetalleVO.setCvaId(conceptoSeleccionada);
                valorizacionSupDetalleVO.setDescripcionInversion(cvaNombre.getCvaNombre());
                valorizacionSupDetalleVO.setMonId(monedaSeleccionada);
                valorizacionSupDetalleVO.setNombreMoneda(monNombre.getMonNombre());
                valorizacionSupDetalleVO.setNeto(montoTabla);
                if (igv) {
                    igv1 = new BigDecimal(0.18).setScale(2,BigDecimal.ROUND_UP);
                    valorizacionSupDetalleVO.setIgv(igv1.multiply(montoTabla));
                } else {
                    igv1 = new BigDecimal(0).setScale(2,BigDecimal.ROUND_UP);
                    valorizacionSupDetalleVO.setIgv(igv1);
                }
                valorizacionSupDetalleVO.setTtotal(montoTabla.add(igv1.setScale(2,BigDecimal.ROUND_UP).multiply(montoTabla).setScale(2,BigDecimal.ROUND_UP)));
                
                listaValorizacion.add(valorizacionSupDetalleVO);
                tvsNeto = tvsNeto.add(montoTabla);
                tvsIgv = tvsIgv.add(valorizacionSupDetalleVO.getIgv());
                tvsBruto = tvsBruto.add(valorizacionSupDetalleVO.getTtotal());


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void guardar() {
        if (nrohr.trim().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                          "INGRESAR NUMERO DE HR."));
        } else if (añohr.trim().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                          "INGRESAR AÑO DE HR."));

        }  else if (t_conce=="") {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                          "SELECCIONAR DATOS DE CONTRATO"));
        }  else if (contratoCompromisoSeleccionado==0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                          "SELECCIONAR ETAPA"));
        } else if(tvsBruto==null){
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                          "INGRESAR VALORIZACION"));
        }else {
            try {
                valorizacionSupVO.setTvsHr(Integer.parseInt(nrohr));
                valorizacionSupVO.setTvsAnyo(Integer.parseInt(añohr));
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                valorizacionSupVO.setTvsFechaRegistro(dt1.parse(freg));
                valorizacionSupVO.setTvsAsunto(asuntohr);
                valorizacionSupVO.setTvsNeto(tvsNeto);
                valorizacionSupVO.setTvsIgv(tvsIgv);
                valorizacionSupVO.setTvsBruto(tvsBruto);
                valorizacionSupVO.setMonId(monedaSeleccionada);
                valorizacionSupVO.setSupId(1);
                valorizacionSupVO.setTvsEstado(1);
                valorizacionSupVO.setTvsTinId(codigoTipoInfra);
                valorizacionSupVO.setTvsCsiId(codigoConcesion);
                valorizacionSupVO.setTvsCcoId(ccoId);
                valorizacionSupVO.setTvsTccTipo(tccTipo);
                valorizacionSupVO.setTvsMcoId(codigoModalidadConcesion);
                valorizacionSupVO.setTvsInfId(codigoInfraestructura);
                valorizacionSupVO.setTvsInvId(codigoInversion);
                valorizacionSupVO.setTvsCcoPlazo(plazo);
                valorizacionSupVO.setTvsCcoTotal(total);
                
                
                
                
                int idCabecera=valorizacionSupServiceImpl.insert(valorizacionSupVO);

                for (ValorizacionSupDetalleVO valorizacionSupDetalleVO : listaValorizacion) {
                    valorizacionSupDetalleVO.setTvsId(idCabecera);
                    valorizacionSupDetalleServiceImpl.insert(valorizacionSupDetalleVO);
                }
                limpiarCampos();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO",
                                                                              "SE REGISTRO LA VALORIZACION DE SUPERVISIÓN CON EXITO"));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void limpiarCampos() {
        nrohr = "";
        añohr = "";
        freg = "";
        asuntohr = "";
        listaMoneda = new ArrayList<MonedaVO>();
        montoTabla= BigDecimal.ZERO;
        listaConcepto = new ArrayList<ValorizacionConceptoVO>();
        listaValorizacion = new ArrayList<ValorizacionSupDetalleVO>();
        tvsNeto= BigDecimal.ZERO;
        tvsIgv= BigDecimal.ZERO;
        tvsBruto= BigDecimal.ZERO;
        t_conce="";
        t_tinfra="";
        t_modconc="";
        listaInfraestructuras = new ArrayList<InfraestructuraVO>();
        listaInversiones = new ArrayList<InversionVO>();
        listaContratoCompromiso = new ArrayList<ContratoCompromisoVO>();
        plazo="";
        total= BigDecimal.ZERO;
        codigoMoneda=0;
        nomSupervisor="";
    }






    //--------- FIN DATOS VALORIZACION-------------//

    public void setConId(int conId) {
        this.conId = conId;
    }

    public int getConId() {
        return conId;
    }

    public void setNombreConcesion(String nombreConcesion) {
        this.nombreConcesion = nombreConcesion;
    }

    public String getNombreConcesion() {
        return nombreConcesion;
    }

    public void setContratoConcesion(String contratoConcesion) {
        this.contratoConcesion = contratoConcesion;
    }

    public String getContratoConcesion() {
        return contratoConcesion;
    }

  

    public void setCodigoInfraestructura(int codigoInfraestructura) {
        this.codigoInfraestructura = codigoInfraestructura;
    }

    public int getCodigoInfraestructura() {
        return codigoInfraestructura;
    }

    public void setListaContratos(List<ContratoVO> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<ContratoVO> getListaContratos() {
        return listaContratos;
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

    public void setT_concesion(String t_concesion) {
        this.t_concesion = t_concesion;
    }

    public String getT_concesion() {
        return t_concesion;
    }


    public void setT_conce(String t_conce) {
        this.t_conce = t_conce;
    }

    public String getT_conce() {
        return t_conce;
    }

    public void setCodigoConcesion(int codigoConcesion) {
        this.codigoConcesion = codigoConcesion;
    }

    public int getCodigoConcesion() {
        return codigoConcesion;
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

    public void setContratoConcesionServiceImp(ContratoConcesionService contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public ContratoConcesionService getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }

    public void setConcesionServiceImpl(ConcesionService concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public ConcesionService getConcesionServiceImpl() {
        return concesionServiceImpl;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
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

    public void setAñohrbus(int añohrbus) {
        this.añohrbus = añohrbus;
    }

    public int getAñohrbus() {
        return añohrbus;
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

    public void setNrohrbus(int nrohrbus) {
        this.nrohrbus = nrohrbus;
    }

    public int getNrohrbus() {
        return nrohrbus;
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

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    public void setListaContratoCompromiso(List<ContratoCompromisoVO> listaContratoCompromiso) {
        this.listaContratoCompromiso = listaContratoCompromiso;
    }

    public List<ContratoCompromisoVO> getListaContratoCompromiso() {
        return listaContratoCompromiso;
    }

    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }

    public void setInversionServiceImpl(InversionService inversionServiceImpl) {
        this.inversionServiceImpl = inversionServiceImpl;
    }

    public InversionService getInversionServiceImpl() {
        return inversionServiceImpl;
    }

    public void setCodigoInversion(int codigoInversion) {
        this.codigoInversion = codigoInversion;
    }

    public int getCodigoInversion() {
        return codigoInversion;
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


    public void setCodigoMoneda(int codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public int getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setListaMoneda(List<MonedaVO> listaMoneda) {
        this.listaMoneda = listaMoneda;
    }

    public List<MonedaVO> getListaMoneda() {
        return listaMoneda;
    }

    public void setListaInfraestructuraTipos(List<InfraestructuraTipoVO> listaInfraestructuraTipos) {
        this.listaInfraestructuraTipos = listaInfraestructuraTipos;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructuraTipos() {
        return listaInfraestructuraTipos;
    }

    public void setListaContratosConcesion(List<ContratoVO> listaContratosConcesion) {
        this.listaContratosConcesion = listaContratosConcesion;
    }

    public List<ContratoVO> getListaContratosConcesion() {
        return listaContratosConcesion;
    }

    public void setMonedaServiceImpl(MonedaServiceImpl monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }

    public MonedaServiceImpl getMonedaServiceImpl() {
        return monedaServiceImpl;
    }


    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }

    public void setMonedaSeleccionada(int monedaSeleccionada) {
        this.monedaSeleccionada = monedaSeleccionada;
    }

    public int getMonedaSeleccionada() {
        return monedaSeleccionada;
    }

    public void setConceptoSeleccionada(int conceptoSeleccionada) {
        this.conceptoSeleccionada = conceptoSeleccionada;
    }

    public int getConceptoSeleccionada() {
        return conceptoSeleccionada;
    }


    public void setListaConcepto(List<ValorizacionConceptoVO> listaConcepto) {
        this.listaConcepto = listaConcepto;
    }

    public List<ValorizacionConceptoVO> getListaConcepto() {
        return listaConcepto;
    }

    public void setValorizacionSupVO(ValorizacionSupVO valorizacionSupVO) {
        this.valorizacionSupVO = valorizacionSupVO;
    }

    public ValorizacionSupVO getValorizacionSupVO() {
        return valorizacionSupVO;
    }

    public void setValorizacionSupServiceImpl(ValorizacionSupService valorizacionSupServiceImpl) {
        this.valorizacionSupServiceImpl = valorizacionSupServiceImpl;
    }

    public ValorizacionSupService getValorizacionSupServiceImpl() {
        return valorizacionSupServiceImpl;
    }

   
    public void setInfraestructuraSeleccionada(int infraestructuraSeleccionada) {
        this.infraestructuraSeleccionada = infraestructuraSeleccionada;
    }

    public int getInfraestructuraSeleccionada() {
        return infraestructuraSeleccionada;
    }

    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }

    public Infraestructura getInfraestructura() {
        return infraestructura;
    }


    public void setInversionSeleccionada(int inversionSeleccionada) {
        this.inversionSeleccionada = inversionSeleccionada;
    }

    public int getInversionSeleccionada() {
        return inversionSeleccionada;
    }

    public void setInversionVO(InversionVO inversionVO) {
        this.inversionVO = inversionVO;
    }

    public InversionVO getInversionVO() {
        return inversionVO;
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


    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    public void setNomSupervisor(String nomSupervisor) {
        this.nomSupervisor = nomSupervisor;
    }

    public String getNomSupervisor() {
        return nomSupervisor;
    }


    public void setMontoTabla(BigDecimal montoTabla) {
        this.montoTabla = montoTabla;
    }

    public BigDecimal getMontoTabla() {
        return montoTabla;
    }


    public void setCvaId(int cvaId) {
        this.cvaId = cvaId;
    }

    public int getCvaId() {
        return cvaId;
    }


    public void setListaValorizacion(List<ValorizacionSupDetalleVO> listaValorizacion) {
        this.listaValorizacion = listaValorizacion;
    }

    public List<ValorizacionSupDetalleVO> getListaValorizacion() {
        return listaValorizacion;
    }


    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }


    public void setIgv(boolean igv) {
        this.igv = igv;
    }

    public boolean isIgv() {
        return igv;
    }


    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }


    public void setTtotal(double ttotal) {
        this.ttotal = ttotal;
    }

    public double getTtotal() {
        return ttotal;
    }


    public void setTvsNeto(BigDecimal tvsNeto) {
        this.tvsNeto = tvsNeto;
    }

    public BigDecimal getTvsNeto() {
        return tvsNeto;
    }


    public void setTvsBruto(BigDecimal tvsBruto) {
        this.tvsBruto = tvsBruto;
    }

    public BigDecimal getTvsBruto() {
        return tvsBruto;
    }

    public void setTvsIgv(BigDecimal tvsIgv) {
        this.tvsIgv = tvsIgv;
    }

    public BigDecimal getTvsIgv() {
        return tvsIgv;
    }

    public void setListaSupervisor(List<SupervisorInversionesVO> listaSupervisor) {
        this.listaSupervisor = listaSupervisor;
    }

    public List<SupervisorInversionesVO> getListaSupervisor() {
        return listaSupervisor;
    }

    public void setSupervisorInversionesServiceImpl(SupervisorInversionesServiceImpl supervisorInversionesServiceImpl) {
        this.supervisorInversionesServiceImpl = supervisorInversionesServiceImpl;
    }

    public SupervisorInversionesServiceImpl getSupervisorInversionesServiceImpl() {
        return supervisorInversionesServiceImpl;
    }

    public void setValorizacionConceptoServiceImpl(ValorizacionConceptoServiceImpl valorizacionConceptoServiceImpl) {
        this.valorizacionConceptoServiceImpl = valorizacionConceptoServiceImpl;
    }

    public ValorizacionConceptoServiceImpl getValorizacionConceptoServiceImpl() {
        return valorizacionConceptoServiceImpl;
    }

    public void setValorizacionConceptoVO(ValorizacionConceptoVO valorizacionConceptoVO) {
        this.valorizacionConceptoVO = valorizacionConceptoVO;
    }

    public ValorizacionConceptoVO getValorizacionConceptoVO() {
        return valorizacionConceptoVO;
    }

    public void setValorizacionSupDetalleServiceImpl(ValorizacionSupDetalleServiceImpl valorizacionSupDetalleServiceImpl) {
        this.valorizacionSupDetalleServiceImpl = valorizacionSupDetalleServiceImpl;
    }

    public ValorizacionSupDetalleServiceImpl getValorizacionSupDetalleServiceImpl() {
        return valorizacionSupDetalleServiceImpl;
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


    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
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

    public void setCodigoContratoCompromiso(int codigoContratoCompromiso) {
        this.codigoContratoCompromiso = codigoContratoCompromiso;
    }

    public int getCodigoContratoCompromiso() {
        return codigoContratoCompromiso;
    }


    public void setSupervisorInversionesVO(SupervisorInversionesVO supervisorInversionesVO) {
        this.supervisorInversionesVO = supervisorInversionesVO;
    }

    public SupervisorInversionesVO getSupervisorInversionesVO() {
        return supervisorInversionesVO;
    }

    public void setCodigoSupervisor(int codigoSupervisor) {
        this.codigoSupervisor = codigoSupervisor;
    }

    public int getCodigoSupervisor() {
        return codigoSupervisor;
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
}
