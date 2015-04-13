package com.ositran.reports;

import com.ositran.service.configReporteAvanceInversionService;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TRepCnfgAvncInvCabVO;
import com.ositran.vo.bean.TRepCnfgAvncInvDetVO;

import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.math.BigDecimal;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "configReporteAvanceInversionMB")
@ViewScoped
public class configReporteAvanceInversion {
    private List<TRepCnfgAvncInvDetVO> reporteInversion;
    private TRepCnfgAvncInvCabVO cabReporteInversionActivo;
    public  final int formulario=30;
    private RolOpcionesVO rolOpcion;
    @ManagedProperty(value = "#{configReporteAvanceInversionServiceImpl}")
    private configReporteAvanceInversionService servicio;
    
    public void cargaDatosDelModelo(ComponentSystemEvent evento) throws AbortProcessingException {
        try {
            cabReporteInversionActivo=servicio.obtenConfigAvanceCab();
            reporteInversion=servicio.obtenReporteInversion();
            if(cabReporteInversionActivo==null) {
                cabReporteInversionActivo=new TRepCnfgAvncInvCabVO();
            }
            mostrar();
        } catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", "Ha ocurrido un error en el sistema."));
            e.printStackTrace();
        }
    }
    
    public void validarSesion() throws IOException{
            rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
    }
    
    public void verificaDiferenteNroDocumento(FacesContext context, UIComponent toValidate, Object value) {
        String input = (String) value;
        if (input.equals(cabReporteInversionActivo.getCaiNumeroDeDocumento())) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", "El número del documento no ha sido modificado."));
        }
    }
    
    public void verificaDiferenteFechaEmision(FacesContext context, UIComponent toValidate, Object value) {
        Date input = (Date) value;
        if (input.equals(cabReporteInversionActivo.getCaiFechaEmision())) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", "La fecha de emisión no ha sido modificada."));
        }
    }
    
    public void verificaDiferenteReferencia(FacesContext context, UIComponent toValidate, Object value) {
        String input = (String) value;
        if (input.equals(cabReporteInversionActivo.getCaiReferencia())) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", "La referencia no ha sido modificado."));
        }
    }
    
    public String guardar() {
        mostrar();
        UsuarioVO usuario=Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        cabReporteInversionActivo.setCaiFechaCambio(new GregorianCalendar().getTime());
        cabReporteInversionActivo.setCaiUsuarioCambio(usuario.getUsuNombre());
        if(cabReporteInversionActivo.getCaiId()==null) {
            //llenar cab
            cabReporteInversionActivo.setCaiEstado(new BigDecimal(1));
            cabReporteInversionActivo.setCaiFechaAlta(new GregorianCalendar().getTime());
            cabReporteInversionActivo.setCaiUsuarioAlta(usuario.getUsuNombre());
        }
        try {
            servicio.guardarConfigReporteInversiones(reporteInversion, cabReporteInversionActivo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Exito!", "Se han guardado los datos exitosamente."));
        } catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", "Ha ocurrido un error en el sistema.\nNo se pudo guardar los datos"));
            e.printStackTrace();
        }
        return null;
    }
    
    public void reset() {
            RequestContext.getCurrentInstance().reset("formulario_principal");
            //FacesContext.getCurrentInstance().renderResponse();
    }
    
    public void setServicio(configReporteAvanceInversionService servicio) {
        this.servicio = servicio;
    }

    public configReporteAvanceInversionService getServicio() {
        return servicio;
    }

    public void setReporteInversion(List<TRepCnfgAvncInvDetVO> reporteInversion) {
        this.reporteInversion = reporteInversion;
    }

    public List<TRepCnfgAvncInvDetVO> getReporteInversion() {
        return reporteInversion;
    }

    public void setCabReporteInversionActivo(TRepCnfgAvncInvCabVO cabReporteInversionActivo) {
        this.cabReporteInversionActivo = cabReporteInversionActivo;
    }

    public TRepCnfgAvncInvCabVO getCabReporteInversionActivo() {
        return cabReporteInversionActivo;
    }
    
    private void mostrar() {
        if(reporteInversion!=null) {
            for(TRepCnfgAvncInvDetVO aux : reporteInversion) {
                System.out.println(aux.getTipoMontoTotal());
            }
        }
        if(cabReporteInversionActivo!=null) {
            System.out.println(cabReporteInversionActivo.getCaiMotivoDeCambio());
            System.out.println(cabReporteInversionActivo.getCaiNumeroDeDocumento());
            System.out.println(cabReporteInversionActivo.getCaiFechaEmision());
            System.out.println(cabReporteInversionActivo.getCaiReferencia());
        }
    }


    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

}