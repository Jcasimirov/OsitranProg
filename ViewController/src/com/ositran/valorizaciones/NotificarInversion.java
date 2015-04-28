package com.ositran.valorizaciones;


import com.ositran.service.DatosStdService;
import com.ositran.service.InfraestructuraTipoService;
import com.ositran.service.InvTipoRevisionService;
import com.ositran.service.NotificacionService;
import com.ositran.util.Constantes;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.InvAvnVO;
import com.ositran.vo.bean.InvTipoRevisionVO;
import com.ositran.vo.bean.ValorizacionNotificacionVO;
import com.ositran.vo.bean.ViewTdInternosVO;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.ositran.util.Util;

import com.ositran.vo.bean.RolOpcionesVO;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

@ManagedBean(name = "bk_NotificarInversion")
@ViewScoped
public class NotificarInversion {
    
    
    //-----------------SESSION-----------------------//
    public  final int formulario=33;
    private RolOpcionesVO rolOpcion;

    public void validarSesion() throws IOException{              
            rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
        }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
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

    // Listas
    List<InvAvnVO> listaValorizaciones;

    List<InvTipoRevisionVO> listaAprobaciones;

    //Bean VO
    @ManagedProperty(value = "#{invAvnVO}")
    InvAvnVO invAvnVO;

    @ManagedProperty(value = "#{viewTdInternosVO}")
    ViewTdInternosVO viewTdInternosVO;

    @ManagedProperty(value = "#{valorizacionNotificacionVO}")
    ValorizacionNotificacionVO valorizacionNotificacionVO;


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

    // Metodo de Listar Declaraciones
    public void listarDeclaraciones() throws Exception {
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            listaValorizaciones = notificacionServiceImpl.ListarDeclaraciones();
            for (int i = 0; i < listaValorizaciones.size(); i++) {
                listaValorizaciones.get(i).setNombreTipoInfraestructura(infraestructuraTipoServiceImpl.get(listaValorizaciones.get(i).getTinId()).getTinNombre());

                //Cambiar el formato de fecha de notificacion y de registro
                //freghrnot = dt1.format(viewTdInternosVO.getFechaRegistro());

                if (listaValorizaciones.get(i).getIaeId() == 4) {
                    listaValorizaciones.get(i).setEstado("Declarado");
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
                    FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se Encontraron Registros");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Guardar Notificación
    public void GrabarNotificacion() throws Exception {
        
        if (freghrnot == null || freghrnot.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!freghrnot.trim().equals("") && asuntohrnot.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Asunto del Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (nrocargo == null || nrocargo.trim().equals("")) {
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


                    invAvnVO.setIaeId(5);

                    valorizacionNotificacionVO.setVanFechaRegistro(fnotificacion);
                    invAvnVO.setTiaAprobadoPor(aprobadopor);
                    valorizacionNotificacionVO.setVanNroCargo(nrocargo);
                    valorizacionNotificacionVO.setTiaNumero(invAvnVO.getTiaNumero());
                    valorizacionNotificacionVO.setMonId(invAvnVO.getMonId());
                    valorizacionNotificacionVO.setTinId(invAvnVO.getTinId());
                    valorizacionNotificacionVO.setVanFechaAlta(util.getObtenerFechaHoy());
                    valorizacionNotificacionVO.setVanTerminal(util.obtenerIpCliente());
                    valorizacionNotificacionVO.setVanEstado(1);
                    valorizacionNotificacionVO.setVanTotalPresentado(invAvnVO.getTiaMontoTotalPresentado());
                    valorizacionNotificacionVO.setVanTotalReconocido(invAvnVO.getTiaMontoTotalReajustado());
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
                downloadNotificacion =
                    Reutilizar.getNewInstance().preDownload(Constantes.RUTANOTIFICACION + nombreArchivo);
            } catch (FileNotFoundException fnfe) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, Constantes.ERROR,
                                                                              Constantes.ARCHIVONOENCONTRADO));
            }
        }

    

}
