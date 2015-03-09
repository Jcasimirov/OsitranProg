package com.ositran.parametros;

import com.ositran.serviceimpl.IgvServiceImpl;
import com.ositran.vo.bean.IgvVO;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;
import java.util.Map;



import javax.annotation.Generated;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpServletRequest;


import org.primefaces.component.commandbutton.CommandButton;

import org.primefaces.context.RequestContext;

import com.ositran.util.Util;

import java.text.SimpleDateFormat;

import java.util.Calendar;




@ManagedBean(name = "backing_parametros_mantenimientoIgv")
@RequestScoped
@Generated(value = "1parametros/mantenimientoIgv.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoIgv {
    private HtmlForm form1;
    private HtmlForm form2;
    private CommandButton commandButton1;
    private CommandButton commandButtonNuevo;
    private CommandButton nuevo;
    
    private int igvCodigoEliminar;
    private int igvCodigo;
    private Double igvPorcentaje;
    private Date igvFechavigencia;
    private Date igvFechacaducidad;
    Util util = new Util();

    java.util.Date fechaVigencia;
    java.util.Date fechaCaducidad;


    public void setIgvCodigoEliminar(int igvCodigoEliminar) {
        this.igvCodigoEliminar = igvCodigoEliminar;
    }

    public int getIgvCodigoEliminar() {
        return igvCodigoEliminar;
    }


    public void setIgvPorcentaje(Double igvPorcentaje) {
        this.igvPorcentaje = igvPorcentaje;
    }

    public Double getIgvPorcentaje() {
        return igvPorcentaje;
    }

    public void setIgvFechavigencia(Date igvFechavigencia) {
        this.igvFechavigencia = igvFechavigencia;
    }

    public Date getIgvFechavigencia() {
        return igvFechavigencia;
    }

    public void setIgvFechacaducidad(Date igvFechacaducidad) {
        this.igvFechacaducidad = igvFechacaducidad;
    }

    public Date getIgvFechacaducidad() {
        return igvFechacaducidad;
    }


    public String obtenerIpCliente() {
        String remoteAddr =
            ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
        return remoteAddr;
    }


    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setForm2(HtmlForm form2) {
        this.form2 = form2;
    }

    public HtmlForm getForm2() {
        return form2;
    }

    @ManagedProperty(value = "#{igvServiceImpl}")
    private IgvServiceImpl igvServiceImpl;

    public void setigvServiceImpl(IgvServiceImpl igvServiceImpl) {
        this.igvServiceImpl = igvServiceImpl;
    }

    public IgvVO igvVO = new IgvVO();


    public void setIgvVO(IgvVO igvVO) {
        this.igvVO = igvVO;
    }

    public IgvVO getIgvVO() {
        return igvVO;
    }

    public List<IgvVO> getQuery() throws SQLException {
        List<IgvVO> list = this.igvServiceImpl.query();
        return list;
    }


    public void igvDel(ActionEvent event) throws SQLException {
        UIParameter parameter = (UIParameter) event.getComponent().findComponent("id3");
        Integer idigv = (Integer) parameter.getValue();
        this.igvServiceImpl.delete(idigv);
        //return "/index?faces-redirect=true";
    }


    public Date getObtenerFechaHoy() {
        Date date = null;
        try {
            date = new Date();
        } catch (Exception e) {
            e.getMessage();
        }
        return date;
    }


    public void igvInsertar() {


        System.out.println(igvPorcentaje);
        if (igvPorcentaje == null) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Falta Igv");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {


            if (igvFechavigencia == null) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Faltan datos de fechas");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } else {
                try {

                    igvVO.setIgvPorcentaje(igvPorcentaje);
                    igvVO.setIgvFechavigencia(igvFechavigencia);
                    igvVO.setIgvEstado(1);
                    igvVO.setIgvFechaAlta(getObtenerFechaHoy());
                    igvVO.setIgvTerminal(obtenerIpCliente());
                    this.igvServiceImpl.insert(igvVO);

                    RequestContext.getCurrentInstance().execute("insertarPanel.hide()");
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Se registro correctamente el IGV");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }

                catch (Exception e) {
                    System.out.println(e.getMessage());
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "A HABIADO UN ERROR" + e.getMessage());
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);

                }
            }

        }
    }

    // Cesar Igv


    


    public void setIgvCodigo(int igvCodigo) {
        this.igvCodigo = igvCodigo;
    }

    public int getIgvCodigo() {
        return igvCodigo;
    }


    public void cargarCesarIgv() throws SQLException {


        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            Object str = requestMap.get("id2");
            Integer idigv = Integer.valueOf(str.toString());
            igvVO = this.igvServiceImpl.get(idigv);
            igvCodigo = igvVO.getIgvId();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "A HABIADO UN ERROR" + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }
    public void cargarEliminarIgv() throws SQLException {


        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            Object str = requestMap.get("id3");
            Integer idigv = Integer.valueOf(str.toString());
            igvVO = this.igvServiceImpl.get(idigv);
            igvCodigoEliminar = igvVO.getIgvId();
            igvPorcentaje=igvVO.getIgvPorcentaje();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "A HABIADO UN ERROR" + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }
    public void eliminarIgv() throws SQLException {
        
        igvVO = this.igvServiceImpl.get(igvCodigoEliminar);
        igvVO.setIgvEstado(0);
        igvVO.setIgvFechaBaja(getObtenerFechaHoy());
        //ejecutar transaccion
        this.igvServiceImpl.update(igvVO);
        RequestContext.getCurrentInstance().execute("eliminarPanel.hide()");
        FacesMessage mensaje =
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Se eliminó correctamente el IGV");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
     
    }
    
    
    public void cesarIgv() throws SQLException {
        igvVO = this.igvServiceImpl.get(igvCodigo);
        long fechaInicialMs = igvVO.getIgvFechavigencia().getTime();
        long fechaFinalMs = igvFechacaducidad.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));

        if (igvFechacaducidad == null) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Faltan datos de fechas");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (igvFechacaducidad != null && dias < 1) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                 "La Fecha de Caducidad No puede ser menor a la Fecha de Vigencia");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            try {

                igvVO.setIgvEstado(2);
                igvVO.setIgvFechaCambio(util.getObtenerFechaHoy());
                igvVO.setIgvTerminal(util.obtenerIpCliente());
                igvVO.setIgvFechacaducidad(igvFechacaducidad);
                this.igvServiceImpl.update(igvVO);


                //  return "listarIgv";
                RequestContext.getCurrentInstance().execute("actualizarPanel.hide()");
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Se Ceso correctamente el IGV");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "A HABIADO UN ERROR" + e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        }
    }

    public void igvActualizarEstado() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("id2");
        Integer idigv = Integer.valueOf(str.toString());
        igvVO = this.igvServiceImpl.get(idigv);
       
       
    
       
        igvVO.setIgvEstado(2);
        igvVO.setIgvFechaCambio(getObtenerFechaHoy());
        this.igvServiceImpl.update(igvVO);
        //  return "listarIgv";

        FacesMessage mensaje =
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Se actualizó correctamente el IGV");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
   }

    public void igvEliminar() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("id1");
        Integer idigv = Integer.valueOf(str.toString());
        igvVO = this.igvServiceImpl.get(idigv);
        igvVO.setIgvEstado(0);
        igvVO.setIgvFechaBaja(getObtenerFechaHoy());
        this.igvServiceImpl.update(igvVO);
        FacesMessage mensaje =
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Se eliminó correctamente el IGV");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        // return "listarIgv";
    }


    public void setCommandButton1(CommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setCommandButtonNuevo(CommandButton commandButton2) {
        this.commandButtonNuevo = commandButton2;
    }

    public CommandButton getCommandButtonNuevo() {
        return commandButtonNuevo;
    }

    public void setNuevo(CommandButton commandButtonNuevo) {
        this.nuevo = commandButtonNuevo;
    }

    public CommandButton getNuevo() {
        return nuevo;
    }

    Date fechavigencia;

    public void setFechavigencia(Date fechavigencia) {
        this.fechavigencia = fechavigencia;
    }

    public Date getFechavigencia() {
        return fechavigencia;
    }

    public void validarIgv() throws SQLException {
        List<IgvVO> list = this.igvServiceImpl.query();
        int valida = 0;
        
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIgvEstado() == 1) {
                valida++;
            }
        }
        if (valida > 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                 "YA EXISTE UN IGV ACTIVO, NO SE PUEDE REGISTRAR UNO NUEVO");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            if (list.size() > 0){
                fechavigencia = list.get(list.size()-1).getIgvFechacaducidad();
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(fechavigencia);
                calendario.add(Calendar.DAY_OF_YEAR, 1);
                igvFechavigencia = calendario.getTime();
                SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
                formatoDeFecha.format(igvFechavigencia);
                RequestContext context = RequestContext.getCurrentInstance();   
            }else{
                igvFechavigencia = null;
                
            }
            
            
            RequestContext.getCurrentInstance().execute("insertarPanel.show()");
        }


    }


}
