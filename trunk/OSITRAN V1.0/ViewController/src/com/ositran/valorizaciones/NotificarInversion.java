package com.ositran.valorizaciones;


import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.DatosStdService;
import com.ositran.service.InfraestructuraTipoService;
import com.ositran.service.InvReajusteService;
import com.ositran.service.InvReconocimientoService;
import com.ositran.service.InvService;
import com.ositran.service.InvTipoRevisionService;
import com.ositran.service.InversionDescripcionServices;
import com.ositran.service.MonedaService;
import com.ositran.service.NotificacionService;
import com.ositran.service.ValorizacionInversionAvanceDetalleService;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.util.Constantes;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.util.Util;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InvAvnVO;
import com.ositran.vo.bean.InvReajusteVO;
import com.ositran.vo.bean.InvReconocimientoVO;
import com.ositran.vo.bean.InvTipoRevisionVO;
import com.ositran.vo.bean.InvVO;
import com.ositran.vo.bean.InversionDescripcionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.UsuarioVO;
import com.ositran.vo.bean.ValorizacionInversionAvanceDetalleVO;
import com.ositran.vo.bean.ValorizacionNotificacionVO;
import com.ositran.vo.bean.ViewTdInternosVO;

import java.io.IOException;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

@ManagedBean(name = "bk_NotificarInversion")
@ViewScoped
public class NotificarInversion {


    //-----------------SESSION-----------------------//
    public final int formulario = 33;
    private RolOpcionesVO rolOpcion;
    private UsuarioVO usuario;
    private int tipoInfraestructura;
    private String ipcliente;

    public void validarSesion() throws IOException {
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
        setUsuario(Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado());
        setTipoInfraestructura(usuario.getTinId());
        ipcliente = Reutilizar.getNewInstance().obtenerIpCliente();
    }

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

    public void setIpcliente(String ipcliente) {
        this.ipcliente = ipcliente;
    }

    public String getIpcliente() {
        return ipcliente;
    }
    //---------------------------------------------//


    private HtmlForm form;

    // Services

    @ManagedProperty(value = "#{notificacionServiceImpl}")
    private NotificacionService notificacionServiceImpl;

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoService infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{datosStdServiceImpl}")
    private DatosStdService datosStdServiceImpl;

    @ManagedProperty(value = "#{invTipoRevisionServiceImpl}")
    private InvTipoRevisionService invTipoRevisionServiceImpl;

    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    private ContratoConcesionService contratoConcesionServiceImp;

    @ManagedProperty(value = "#{concesionServicesImpl}")
    ConcesionService concesionServicesImpl;

    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
    ContratoCompromisoService contratoCompromisoServiceImpl;

    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionServiceImpl modalidadServiceImp;

    @ManagedProperty(value = "#{invReconocimientoServiceImpl}")
    InvReconocimientoService invReconocimientoServiceImpl;

    @ManagedProperty(value = "#{invReajusteServiceImpl}")
    InvReajusteService invReajusteServiceImpl;

    @ManagedProperty(value = "#{invServiceImpl}")
    InvService invServiceImpl;

    @ManagedProperty(value = "#{valorizacionInversionAvanceDetalleServiceImpl}")
    ValorizacionInversionAvanceDetalleService valorizacionInversionAvanceDetalleServiceImpl;

    @ManagedProperty(value = "#{monedaServiceImpl}")
    MonedaService monedaServiceImpl;

    @ManagedProperty(value = "#{inversionDescripcionServicesImpl}")
    InversionDescripcionServices inversionDescripcionServicesImpl;

    // Listas
    List<InvAvnVO> listaValorizaciones;

    List<InvTipoRevisionVO> listaAprobaciones;

    private List<InvReconocimientoVO> listaReconocimiento = new ArrayList<InvReconocimientoVO>();

    private List<InvReajusteVO> listaReajuste = new ArrayList<InvReajusteVO>();

    private List<InfraestructuraVO> listarInfraestructura = new ArrayList<InfraestructuraVO>();

    List<MonedaVO> listarTipoMonedas = new ArrayList<MonedaVO>();

    private List<ValorizacionInversionAvanceDetalleVO> listaValorizacionInversionAvanceDetalleVO =
        new ArrayList<ValorizacionInversionAvanceDetalleVO>();

    private List<InversionDescripcionVO> listaConceptos = new ArrayList<InversionDescripcionVO>();

    //Bean VO
    @ManagedProperty(value = "#{invAvnVO}")
    InvAvnVO invAvnVO;

    @ManagedProperty(value = "#{viewTdInternosVO}")
    ViewTdInternosVO viewTdInternosVO;

    @ManagedProperty(value = "#{valorizacionNotificacionVO}")
    ValorizacionNotificacionVO valorizacionNotificacionVO;

    @ManagedProperty(value = "#{concesionVO}")
    ConcesionVO concesionVO;

    @ManagedProperty(value = "#{contratoVO}")
    private ContratoVO contratoVO;

    @ManagedProperty(value = "#{contratoCompromisoVO}")
    ContratoCompromisoVO contratoCompromisoVO;

    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    InfraestructuraTipoVO infraestructuraTipoVO;

    @ManagedProperty(value = "#{modalidadConcesionVO}")
    ModalidadConcesionVO modalidadConcesionVO;

    @ManagedProperty(value = "#{invVO}")
    private InvVO invVO;

    Util util = new Util();

    // Get y Set


    public void setValorizacionNotificacionVO(ValorizacionNotificacionVO valorizacionNotificacionVO) {
        this.valorizacionNotificacionVO = valorizacionNotificacionVO;
    }

    public ValorizacionNotificacionVO getValorizacionNotificacionVO() {
        return valorizacionNotificacionVO;
    }

    public void setForm(HtmlForm form) {
        this.form = form;
    }

    public HtmlForm getForm() {
        return form;
    }


    public void setNotificacionServiceImpl(NotificacionService notificacionServiceImpl) {
        this.notificacionServiceImpl = notificacionServiceImpl;
    }

    public NotificacionService getNotificacionServiceImpl() {
        return notificacionServiceImpl;
    }


    public void setListaValorizaciones(List<InvAvnVO> listaValorizaciones) {
        this.listaValorizaciones = listaValorizaciones;
    }

    public List<InvAvnVO> getListaValorizaciones() {
        return listaValorizaciones;
    }

    public void setInvAvnVO(InvAvnVO invAvnVO) {
        this.invAvnVO = invAvnVO;
    }

    public InvAvnVO getInvAvnVO() {
        return invAvnVO;
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


    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoService infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoService getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void setInvTipoRevisionServiceImpl(InvTipoRevisionService invTipoRevisionServiceImpl) {
        this.invTipoRevisionServiceImpl = invTipoRevisionServiceImpl;
    }

    public InvTipoRevisionService getInvTipoRevisionServiceImpl() {
        return invTipoRevisionServiceImpl;
    }

    public void setListaAprobaciones(List<InvTipoRevisionVO> listaAprobaciones) {
        this.listaAprobaciones = listaAprobaciones;
    }

    public List<InvTipoRevisionVO> getListaAprobaciones() {
        return listaAprobaciones;
    }

    public void setContratoConcesionServiceImp(ContratoConcesionService contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public ContratoConcesionService getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }

    public void setConcesionServicesImpl(ConcesionService concesionServicesImpl) {
        this.concesionServicesImpl = concesionServicesImpl;
    }

    public ConcesionService getConcesionServicesImpl() {
        return concesionServicesImpl;
    }

    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
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

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    public void setModalidadServiceImp(ModalidadConcesionServiceImpl modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionServiceImpl getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public void setModalidadConcesionVO(ModalidadConcesionVO modalidadConcesionVO) {
        this.modalidadConcesionVO = modalidadConcesionVO;
    }

    public ModalidadConcesionVO getModalidadConcesionVO() {
        return modalidadConcesionVO;
    }

    public void setListaReconocimiento(List<InvReconocimientoVO> listaReconocimiento) {
        this.listaReconocimiento = listaReconocimiento;
    }

    public List<InvReconocimientoVO> getListaReconocimiento() {
        return listaReconocimiento;
    }

    public void setInvReconocimientoServiceImpl(InvReconocimientoService invReconocimientoServiceImpl) {
        this.invReconocimientoServiceImpl = invReconocimientoServiceImpl;
    }

    public InvReconocimientoService getInvReconocimientoServiceImpl() {
        return invReconocimientoServiceImpl;
    }

    public void setListaReajuste(List<InvReajusteVO> listaReajuste) {
        this.listaReajuste = listaReajuste;
    }

    public List<InvReajusteVO> getListaReajuste() {
        return listaReajuste;
    }

    public void setMonedaServiceImpl(MonedaService monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }

    public MonedaService getMonedaServiceImpl() {
        return monedaServiceImpl;
    }

    public void setInversionDescripcionServicesImpl(InversionDescripcionServices inversionDescripcionServicesImpl) {
        this.inversionDescripcionServicesImpl = inversionDescripcionServicesImpl;
    }

    public InversionDescripcionServices getInversionDescripcionServicesImpl() {
        return inversionDescripcionServicesImpl;
    }

    // Metodo de Listar Declaraciones
    public void listarDeclaraciones() throws Exception {
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            listaValorizaciones = notificacionServiceImpl.ListarDeclaraciones();
            for (int i = 0; i < listaValorizaciones.size(); i++) {
                listaValorizaciones.get(i).setNombreTipoInfraestructura(infraestructuraTipoServiceImpl.get(listaValorizaciones.get(i).getTinId()).getTinNombre());

                //Cambiar el formato de fecha de notificacion y de registro
                //freghrnot = dt1.format(viewTdInternosVO.getFechaRegistro());
                listaValorizaciones.get(i).setTiaFechaRegistroDescripcion(dt1.format(listaValorizaciones.get(i).getTiaFechaRegistro()));
                if (listaValorizaciones.get(i).getIaeId() == 4) {
                    listaValorizaciones.get(i).setEstado("Declarado");
                    listaValorizaciones.get(i).setAprobadopor("Por Aprobar");
                } else if (listaValorizaciones.get(i).getIaeId() == 5) {
                    listaValorizaciones.get(i).setEstado("Rectificado");
                    listaValorizaciones.get(i).setAprobadopor("Por Aprobar");
                } else {
                    listaValorizaciones.get(i).setEstado("Notificado");
                    for (int j = 0; j < listaAprobaciones.size(); j++) {
                        if (listaValorizaciones.get(i).getTiaAprobadoPor() == listaAprobaciones.get(j).getItrId()) {
                            listaValorizaciones.get(i).setAprobadopor(listaAprobaciones.get(j).getItrDescripcion());
                        }
                    }

                }
                if (listaValorizaciones.get(i).getMonId() == 1) {
                    listaValorizaciones.get(i).setNombreMoneda("Nuevos Soles");
                } else {
                    listaValorizaciones.get(i).setNombreMoneda("Dolares Americanos");
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Metodo Listar Tipo Aprobaciones
    public void listarTipoAprobaciones() throws Exception {
        System.out.println("entro");
        try {
            listaAprobaciones = invTipoRevisionServiceImpl.ListarAprobaciones();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Notificar

    String nrohrnot;
    String añohrnot;
    String freghrnot;
    String asuntohrnot;
    int añohrbusnot;
    int nrohrbusnot;
    String nrocargo;
    Date fnotificacion;
    String rutapdf;
    int aprobadopor;


    public void setNrohrnot(String nrohrnot) {
        this.nrohrnot = nrohrnot;
    }

    public String getNrohrnot() {
        return nrohrnot;
    }

    public void setAñohrnot(String añohrnot) {
        this.añohrnot = añohrnot;
    }

    public String getAñohrnot() {
        return añohrnot;
    }


    public void setFreghrnot(String freghrnot) {
        this.freghrnot = freghrnot;
    }

    public String getFreghrnot() {
        return freghrnot;
    }

    public void setAsuntohrnot(String asuntohrnot) {
        this.asuntohrnot = asuntohrnot;
    }

    public String getAsuntohrnot() {
        return asuntohrnot;
    }

    public void setAñohrbusnot(int añohrbusnot) {
        this.añohrbusnot = añohrbusnot;
    }

    public int getAñohrbusnot() {
        return añohrbusnot;
    }

    public void setNrohrbusnot(int nrohrbusnot) {
        this.nrohrbusnot = nrohrbusnot;
    }

    public int getNrohrbusnot() {
        return nrohrbusnot;
    }


    public void setNrocargo(String nrocargo) {
        this.nrocargo = nrocargo;
    }

    public String getNrocargo() {
        return nrocargo;
    }

    public void setFnotificacion(Date fnotificacion) {
        this.fnotificacion = fnotificacion;
    }

    public Date getFnotificacion() {
        return fnotificacion;
    }

    public void setRutapdf(String rutapdf) {
        this.rutapdf = rutapdf;
    }

    public String getRutapdf() {
        return rutapdf;
    }


    public void setAprobadopor(int aprobadopor) {
        this.aprobadopor = aprobadopor;
    }

    public int getAprobadopor() {
        return aprobadopor;
    }


    public void setInvServiceImpl(InvService invServiceImpl) {
        this.invServiceImpl = invServiceImpl;
    }

    public InvService getInvServiceImpl() {
        return invServiceImpl;
    }

    public void setValorizacionInversionAvanceDetalleServiceImpl(ValorizacionInversionAvanceDetalleService valorizacionInversionAvanceDetalleServiceImpl) {
        this.valorizacionInversionAvanceDetalleServiceImpl = valorizacionInversionAvanceDetalleServiceImpl;
    }

    public ValorizacionInversionAvanceDetalleService getValorizacionInversionAvanceDetalleServiceImpl() {
        return valorizacionInversionAvanceDetalleServiceImpl;
    }

    public void setListarInfraestructura(List<InfraestructuraVO> listarInfraestructura) {
        this.listarInfraestructura = listarInfraestructura;
    }

    public List<InfraestructuraVO> getListarInfraestructura() {
        return listarInfraestructura;
    }

    public void setListarTipoMonedas(List<MonedaVO> listarTipoMonedas) {
        this.listarTipoMonedas = listarTipoMonedas;
    }

    public List<MonedaVO> getListarTipoMonedas() {
        return listarTipoMonedas;
    }

    public void setListaValorizacionInversionAvanceDetalleVO(List<ValorizacionInversionAvanceDetalleVO> listaValorizacionInversionAvanceDetalleVO) {
        this.listaValorizacionInversionAvanceDetalleVO = listaValorizacionInversionAvanceDetalleVO;
    }

    public List<ValorizacionInversionAvanceDetalleVO> getListaValorizacionInversionAvanceDetalleVO() {
        return listaValorizacionInversionAvanceDetalleVO;
    }

    public void setListaConceptos(List<InversionDescripcionVO> listaConceptos) {
        this.listaConceptos = listaConceptos;
    }

    public List<InversionDescripcionVO> getListaConceptos() {
        return listaConceptos;
    }

    public void setInvVO(InvVO invVO) {
        this.invVO = invVO;
    }

    public InvVO getInvVO() {
        return invVO;
    }

    public void notificarDeclaracion(ActionEvent event) {
        invAvnVO = (InvAvnVO) event.getComponent().getAttributes().get("valorizacion");
        System.out.println("invAvnVO.getConId():" + invAvnVO.getConId());
    }

    public void BuscarStd() throws SQLException {
        if (nrohrnot.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!nrohrnot.trim().equals("") && Integer.parseInt(nrohrnot) < 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (añohrnot.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese un Año de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!añohrnot.trim().equals("") && Integer.parseInt(añohrnot) < 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!añohrnot.trim().equals("") && añohrnot.length() < 4) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
            try {
                viewTdInternosVO = datosStdServiceImpl.BuscaStd(Integer.parseInt(añohrnot), nrohrnot);
                if (viewTdInternosVO != null && viewTdInternosVO.getFechaRegistro() != null) {
                    freghrnot = dt1.format(viewTdInternosVO.getFechaRegistro());
                    asuntohrnot = viewTdInternosVO.getAsunto();
                    añohrbusnot = viewTdInternosVO.getAnyo();
                    nrohrbusnot = Integer.parseInt(viewTdInternosVO.getNroRegistro());

                    //Lleno el Bean VO de Notificacion
                    valorizacionNotificacionVO.setVanFechaRegistro(viewTdInternosVO.getFechaRegistro());
                    valorizacionNotificacionVO.setVanAnyoHr(añohrbusnot);
                    valorizacionNotificacionVO.setVanNroHr(nrohrbusnot);
                } else {
                    freghrnot = "";
                    asuntohrnot = "";
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se Encontraron Registros");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Guardar Notificación
    public void GrabarNotificacion() throws Exception {

        if (freghrnot == null || freghrnot.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!freghrnot.trim().equals("") && asuntohrnot.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Asunto del Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (nrocargo == null || nrocargo.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro. de Cargo");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (aprobadopor == 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione Tipo de Aprobación");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (fnotificacion == null) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Fecha de Notificación");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);


        } else {

            long fechaInicialMs = fnotificacion.getTime();
            long fechaFinalMs = util.getObtenerFechaHoy().getTime();
            long diferencia = fechaFinalMs - fechaInicialMs;
            double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
            if (dias < 1) {
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                     "La Fecha de Notificación no puede ser Mayor a la Fecha Actual");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } else {
                try {


                    invAvnVO.setIaeId(6);

                    valorizacionNotificacionVO.setVanFechaRegistro(fnotificacion);
                    invAvnVO.setTiaAprobadoPor(aprobadopor);
                    valorizacionNotificacionVO.setVanNroCargo(nrocargo);
                    valorizacionNotificacionVO.setTiaNumero(invAvnVO.getTiaNumero());
                    valorizacionNotificacionVO.setMonId(invAvnVO.getMonId());
                    valorizacionNotificacionVO.setTinId(invAvnVO.getTinId());
                    valorizacionNotificacionVO.setVanFechaAlta(util.getObtenerFechaHoy());
                    valorizacionNotificacionVO.setVanTerminal(ipcliente);
                    valorizacionNotificacionVO.setVanEstado(1);
                    valorizacionNotificacionVO.setVanTotalPresentado(invAvnVO.getTiaMontoTotalPresentado());
                    valorizacionNotificacionVO.setVanTotalReconocido(invAvnVO.getTiaMontoTotalReajustado());
                    valorizacionNotificacionVO.setVanUsuarioAlta(usuario.getUsuAlias());
                    //Para Gaurdar Documento
                    Reutilizar.getNewInstance().copiarArchivoenServidor(Constantes.RUTANOTIFICACION + rutapdf,
                                                                        invAvnVO.getNombreFile());
                    invAvnVO.setTiaRutaNot(rutapdf);                 
                    notificacionServiceImpl.NotificarInversion(invAvnVO, valorizacionNotificacionVO);
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Notifico con Exito");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                    listarDeclaraciones();
                    RequestContext.getCurrentInstance().execute("notificar_inv.hide()");

                } catch (Exception e) {
                    System.out.println(e);
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se Pudo Notificar la Declaración");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            }
        }

    }

    // Para Guardar Archivo


    public void subirArchivo(FileUploadEvent event) throws IOException {
        System.out.println("rutapdf: " + rutapdf);
        rutapdf = event.getFile().getFileName();
        invAvnVO.setNombreFile(event.getFile().getInputstream());
        System.out.println("rutapdf: " + rutapdf);
    }

    private DefaultStreamedContent downloadNotificacion;

    public void setDownloadNotificacion(DefaultStreamedContent downloadNotificacion) {
        this.downloadNotificacion = downloadNotificacion;
    }

    public DefaultStreamedContent getDownloadNotificacion() {
        return downloadNotificacion;
    }

    public void preDownloadNotificacion(String nombreArchivo) {
        try {
            downloadNotificacion = Reutilizar.getNewInstance().preDownload(Constantes.RUTANOTIFICACION + nombreArchivo);
        } catch (Exception fnfe) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                          Constantes.ARCHIVONOENCONTRADO));
        }
    }

    // VER DECLARACIÓN

    private String nombreConcesion;
    private String nombreTipoInfraestructura;
    private String nombreModalidad;
    private String nombreEtapa;
    private String desPlazo;
    private String etapaTotal;
    private String monNombre;
    private String estadoReconocimiento;
    private String observacionReconocimiento;

    private BigDecimal totalivrMontoPresentado = BigDecimal.ZERO;
    private BigDecimal totalivrMontoAprobado = BigDecimal.ZERO;
    private BigDecimal totalirjMontoAprobado = BigDecimal.ZERO;
    private BigDecimal totalirjMontoReajuste = BigDecimal.ZERO;
    private BigDecimal igv = BigDecimal.ZERO;
    private BigDecimal totalivrMontoAprobadoI = BigDecimal.ZERO;
    private BigDecimal totalirjMontoReajusteI = BigDecimal.ZERO;

    private boolean deshabilitadoxDeclaracionNoCargada = true;
    private boolean mostrarxDeclaracionCargada = false;
    private boolean renderMostrarIGV = false;


    public void setNombreConcesion(String nombreConcesion) {
        this.nombreConcesion = nombreConcesion;
    }

    public String getNombreConcesion() {
        return nombreConcesion;
    }

    public void setNombreTipoInfraestructura(String nombreTipoInfraestructura) {
        this.nombreTipoInfraestructura = nombreTipoInfraestructura;
    }

    public String getNombreTipoInfraestructura() {
        return nombreTipoInfraestructura;
    }

    public void setNombreModalidad(String nombreModalidad) {
        this.nombreModalidad = nombreModalidad;
    }

    public String getNombreModalidad() {
        return nombreModalidad;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setDesPlazo(String desPlazo) {
        this.desPlazo = desPlazo;
    }

    public String getDesPlazo() {
        return desPlazo;
    }

    public void setEtapaTotal(String etapaTotal) {
        this.etapaTotal = etapaTotal;
    }

    public String getEtapaTotal() {
        return etapaTotal;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setEstadoReconocimiento(String estadoReconocimiento) {
        this.estadoReconocimiento = estadoReconocimiento;
    }

    public String getEstadoReconocimiento() {
        return estadoReconocimiento;
    }

    public void setObservacionReconocimiento(String observacionReconocimiento) {
        this.observacionReconocimiento = observacionReconocimiento;
    }

    public String getObservacionReconocimiento() {
        return observacionReconocimiento;
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


    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setInvReajusteServiceImpl(InvReajusteService invReajusteServiceImpl) {
        this.invReajusteServiceImpl = invReajusteServiceImpl;
    }

    public InvReajusteService getInvReajusteServiceImpl() {
        return invReajusteServiceImpl;
    }

    public void setTotalivrMontoAprobadoI(BigDecimal totalivrMontoAprobadoI) {
        this.totalivrMontoAprobadoI = totalivrMontoAprobadoI;
    }

    public BigDecimal getTotalivrMontoAprobadoI() {
        return totalivrMontoAprobadoI;
    }

    public void setTotalirjMontoReajusteI(BigDecimal totalirjMontoReajusteI) {
        this.totalirjMontoReajusteI = totalirjMontoReajusteI;
    }

    public BigDecimal getTotalirjMontoReajusteI() {
        return totalirjMontoReajusteI;
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

    public void setRenderMostrarIGV(boolean renderMostrarIGV) {
        this.renderMostrarIGV = renderMostrarIGV;
    }

    public boolean isRenderMostrarIGV() {
        return renderMostrarIGV;
    }

    public void verDeclaracion(ActionEvent event) throws Exception {
        invAvnVO = (InvAvnVO) event.getComponent().getAttributes().get("valorizacionDec");
        try {
            contratoVO = contratoConcesionServiceImp.get(invAvnVO.getConId());
            concesionVO = concesionServicesImpl.get(contratoVO.getCsiId());
            infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(contratoVO.getTinId());
            modalidadConcesionVO = modalidadServiceImp.get(contratoVO.getMcoId());
            nombreConcesion = concesionVO.getCsiNombre();
            nombreTipoInfraestructura = infraestructuraTipoVO.getTinNombre();
            nombreModalidad = modalidadConcesionVO.getMcoNombre();
            contratoCompromisoVO = contratoCompromisoServiceImpl.get(invAvnVO.getCcoId());
            nombreEtapa = contratoCompromisoVO.getCcoPeriodo();
            desPlazo = contratoCompromisoVO.getCcoPlazo();
            etapaTotal = "" + contratoCompromisoVO.getCcoTotal();
            if (contratoCompromisoVO.getMonId() == 1) {
                monNombre = "Nuevos Soles";
            } else {
                monNombre = "Nuevos Soles";
            }

            invAvnVO.setNombreConcesion(nombreConcesion);
            invAvnVO.setNombreTipoInfraestructura(nombreTipoInfraestructura);
            invAvnVO.setNombreModalidad(nombreModalidad);
            System.out.println("invAvnVO.getInvId(),invAvnVO.getTiaNumero():" + invAvnVO.getInvId() + " Y " +
                               invAvnVO.getTiaNumero());
            cargarInvxTiaNumero(invAvnVO.getInvId(), invAvnVO.getTiaNumero());
            obtenerDeatalleInvAvn(invAvnVO.getTiaNumero());
            cargarDatosCompromiso(invAvnVO.getCcoId());
            System.out.println("invAvnVO.getTiaNumero():" + invAvnVO.getTiaNumero());
            cargarReconocimiento(invAvnVO.getTiaNumero());
            cargarReajuste(invAvnVO.getTiaNumero());
            deshabilitadoxDeclaracionNoCargada = false;
            mostrarxDeclaracionCargada = true;
            resetCamposIGV();

            if (invAvnVO.getIaeId() == 0) {
                estadoReconocimiento = "Observado";
            } else if (invAvnVO.getIaeId() == 4) {
                estadoReconocimiento = "Declarado";
            } else if (invAvnVO.getIaeId() == 5) {
                estadoReconocimiento = "Rectificado";
            } else if (invAvnVO.getIaeId() == 6) {
                estadoReconocimiento = "Notificado";
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cargarReconocimiento(int tiaNumero) {
        try {
            listaReconocimiento = invReconocimientoServiceImpl.getInvReconocimientosAvance(tiaNumero);
            System.out.println("listaReconocimiento.size():" + listaReconocimiento.size());
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
            calcularTotalesReajuste(listaReajuste);
            cargarDescripcionesInfraestructura(listaReajuste);
            cargarDescripcionesMonedas(listaReajuste);
            cargarDescripcionesConcepto(listaReajuste);

        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }

    public void calcularTotalesReajuste(List<InvReajusteVO> listaReajuste) {
        setTotalirjMontoAprobado(BigDecimal.ZERO);
        setTotalirjMontoReajuste(BigDecimal.ZERO);
        setTotalivrMontoAprobadoI(BigDecimal.ZERO);
        setTotalirjMontoReajusteI(BigDecimal.ZERO);
        for (InvReajusteVO invReajuste : listaReajuste) {
            if (invReajuste.getIrjMontoAprobado() != null) {
                totalirjMontoAprobado = totalirjMontoAprobado.add(invReajuste.getIrjMontoAprobado());
            }

            if (invReajuste.getIrjMontoReajuste() != null) {
                totalirjMontoReajuste = totalirjMontoReajuste.add(invReajuste.getIrjMontoReajuste());
            }
        }
        setTotalivrMontoAprobadoI(totalirjMontoAprobado);
        setTotalirjMontoReajusteI(totalirjMontoReajuste);
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
                    System.out.println("aux.getMonId()+aux.getNombreMoneda()&&&&&&" + aux.getMonId() +
                                       aux.getNombreMoneda());
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

    public void cargarDescripcionesConcepto(List<?> lista) {
        for (Object item : lista) {

            if (item instanceof InvReconocimientoVO) {
                InvReconocimientoVO aux = ((InvReconocimientoVO) item);
                for (ValorizacionInversionAvanceDetalleVO val : listaValorizacionInversionAvanceDetalleVO) {
                    if (val.getTiaNumero() == aux.getTiaNumero() && val.getIad_Id() == aux.getIadId()) {
                        for (InversionDescripcionVO concepto : listaConceptos) {
                            if (val.getTivId() == concepto.getTivId() && val.getDtiId() == concepto.getItdId()) {
                                aux.setDesConcepto(concepto.getItdNombre());
                            }
                        }
                    }
                }
            }
            if (item instanceof InvReajusteVO) {
                InvReajusteVO aux = ((InvReajusteVO) item);

                for (ValorizacionInversionAvanceDetalleVO val : listaValorizacionInversionAvanceDetalleVO) {
                    if (val.getTiaNumero() == aux.getTiaNumero() && val.getIad_Id() == aux.getIadId()) {
                        for (InversionDescripcionVO concepto : listaConceptos) {
                            if (val.getTivId() == concepto.getTivId() && val.getDtiId() == concepto.getItdId()) {
                                aux.setDesConcepto(concepto.getItdNombre());
                            }
                        }
                    }
                }
            }

        }
    }

    public void cargarInvxTiaNumero(int numeroInversion, int tianumero) {
        try {
            invVO = invServiceImpl.obtenerInversion(tianumero);
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }


    public void seleccionarDeclaracion(ActionEvent e) throws SQLException {
        invAvnVO = (InvAvnVO) e.getComponent().getAttributes().get("idDeclaracion");
        invAvnVO.setNombreConcesion(contratoVO.getNombreConcesion());
        invAvnVO.setNombreTipoInfraestructura(contratoVO.getNombreTipoInfraestructura());
        invAvnVO.setNombreModalidad(contratoVO.getNombreModalidad());
        System.out.println("invAvnVO.getInvId(),invAvnVO.getTiaNumero():" + invAvnVO.getInvId() + " Y " +
                           invAvnVO.getTiaNumero());
        cargarInvxTiaNumero(invAvnVO.getInvId(), invAvnVO.getTiaNumero());
        obtenerDeatalleInvAvn(invAvnVO.getTiaNumero());
        cargarDatosCompromiso(invAvnVO.getCcoId());
        System.out.println("invAvnVO.getTiaNumero():" + invAvnVO.getTiaNumero());
        cargarReconocimiento(invAvnVO.getTiaNumero());
        cargarReajuste(invAvnVO.getTiaNumero());
        deshabilitadoxDeclaracionNoCargada = false;
        mostrarxDeclaracionCargada = true;
        resetCamposIGV();
    }

    public void obtenerDeatalleInvAvn(int tiaNumero) {
        try {
            listaValorizacionInversionAvanceDetalleVO =
                valorizacionInversionAvanceDetalleServiceImpl.getInvAvanceDetallesInvAvance(tiaNumero);
            System.out.println("####################listaValorizacionInversionAvanceDetalleVO:" +
                               listaValorizacionInversionAvanceDetalleVO.size());
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
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

    public void resetCamposIGV() {
        renderMostrarIGV = false;
        igv = BigDecimal.ZERO;

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

    public void cargarConceptos() {
        try {
            listaConceptos = inversionDescripcionServicesImpl.query();
        } catch (Exception sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
    }

    public void setUtil(Util util) {
        this.util = util;
    }

    public Util getUtil() {
        return util;
    }
}
