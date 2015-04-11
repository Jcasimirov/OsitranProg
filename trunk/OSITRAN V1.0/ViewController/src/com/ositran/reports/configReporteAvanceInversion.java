package com.ositran.parametros;

import com.ositran.service.configReporteAvanceInversionService;
import com.ositran.util.ControlAcceso;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TRepCnfgAvncInvCabVO;
import com.ositran.vo.bean.TRepCnfgAvncInvDetVO;

import java.io.IOException;

import java.math.BigDecimal;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "configReporteAvanceInversionMB")
@ViewScoped
public class configReporteAvanceInversion {
    
    
    private List<TRepCnfgAvncInvDetVO> reporteInversion;
    private TRepCnfgAvncInvCabVO cabReporteInversionActivo;
    public  final int formulario=1;
    private RolOpcionesVO rolOpcion;
    public void validarSesion() throws IOException{
            rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
        }
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
    
    public void cambia(ValueChangeEvent event) throws AbortProcessingException {
        FacesContext context = FacesContext.getCurrentInstance();
        TRepCnfgAvncInvDetVO detalle = context.getApplication().evaluateExpressionGet(context, "#{unidadReporteInversion}", TRepCnfgAvncInvDetVO.class);
        System.out.println(detalle.isCaiMontoTotalSinAjuste()+"   "+detalle.isCaiMontoTotalConReajuste());
        if ((Boolean)event.getNewValue()) {
            System.out.println(event.getNewValue());
            detalle.setCaiMontoTotalConReajuste(false);
//            FacesContext.getCurrentInstance().getExternalContext().
//                    getSessionMap().put("name", event.getNewValue());
        }
    }
    
    public void validaCambio(ValueChangeEvent event) throws AbortProcessingException {
        if (event.getNewValue().equals(event.getOldValue())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", "Debe ingresar un nuevo valor."));
        }
    }
    
    public String guardar() {
        mostrar();
        cabReporteInversionActivo.setCaiFechaCambio(new GregorianCalendar().getTime());
        //cabReporteInversionActivo.setCaiUsuarioCambio(algo);
        if(cabReporteInversionActivo.getCaiId()==null) {
            //llenar cab
            cabReporteInversionActivo.setCaiEstado(new BigDecimal(1));
            cabReporteInversionActivo.setCaiFechaAlta(new GregorianCalendar().getTime());
            //cabReporteInversionActivo.setCaiUsuarioAlta(algo);
        }
        try {
            servicio.guardarConfigReporteInversiones(reporteInversion, cabReporteInversionActivo);
        } catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", "Ha ocurrido un error en el sistema."));
            e.printStackTrace();
        }
        return null;
    }
    
    public void sincroniza(AjaxBehaviorEvent event) throws AbortProcessingException {
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
