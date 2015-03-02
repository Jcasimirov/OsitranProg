package com.ositran.parametros;

import com.ositran.serviceimpl.EmpresaSupervisoraServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.util.Util;

import com.ositran.vo.bean.EmpresaSupervisoraVO;

import com.ositran.vo.bean.ModalidadConcesionVO;

import java.sql.SQLException;

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

@ManagedBean(name = "backing_mantenimientoModalidadConcesion")
@RequestScoped
@Generated(value = "1ositran/parametros/mantenimientoModalidadConcesion.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoModalidadConcesion {


    //Mantenimiento Modalidad Concesion

    private HtmlForm form1;
    Util util = new Util();
    List<ModalidadConcesionVO> listaMod;
    
    @ManagedProperty(value="#{modalidadVO}")
    public ModalidadConcesionVO modalidadVO;

    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionServiceImpl modalidadServiceImp;


    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setListaMod(List<ModalidadConcesionVO> listaMod) {
        this.listaMod = listaMod;
    }

    public List<ModalidadConcesionVO> getListaMod() {
        return listaMod;
    }

    public void setModalidadVO(ModalidadConcesionVO modalidadVO) {
        this.modalidadVO = modalidadVO;
    }

    public ModalidadConcesionVO getModalidadVO() {
        return modalidadVO;
    }

    public void setModalidadServiceImp(ModalidadConcesionServiceImpl modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionServiceImpl getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public List<ModalidadConcesionVO> getQuery() throws SQLException {
        listaMod = this.modalidadServiceImp.query();
        //limpiarCampos ();
        return listaMod;
    }


    //Registrar Modalidad de Concesión
    String nombremod;
    String descripcionmod;


    public void setNombremod(String nombremod) {
        this.nombremod = nombremod;
    }

    public String getNombremod() {
        return nombremod;
    }

    public void setDescripcionmod(String descripcionmod) {
        this.descripcionmod = descripcionmod;
    }

    public String getDescripcionmod() {
        return descripcionmod;
    }

    public String EmpSupUpd2() throws SQLException {
        this.modalidadServiceImp.update(modalidadVO);
        return "/index?faces-redirect=true";
    }

    public void guardar() throws SQLException {
        if (nombremod.equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                 "No ha Ingresado el Nombre de la Modalidad de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (descripcionmod.equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                 "No ha Ingresado Descripción de la Modalidad de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            try {
                modalidadVO.setMcoDescripcion(descripcionmod);
                modalidadVO.setMcoNombre(nombremod);
                modalidadVO.setMcoEstado(1);
                modalidadVO.setMcoTerminal(util.obtenerIpCliente());
                modalidadVO.setMcoFechaAlta(util.getObtenerFechaHoy());

                this.modalidadServiceImp.insert(modalidadVO);
                getQuery();
                limpiarCampos();
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Registro con Exito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Error" + e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        }

    }

    public void limpiarCampos() {
        nombremod = "";
        descripcionmod = "";
    }


    // Eliminar Modalidad Concesión

    public String EliminarModalidad(ActionEvent event) throws SQLException {
        try {
            UIParameter parameter = (UIParameter) event.getComponent().findComponent("idEliminar");
            Integer idModalidad = (Integer) parameter.getValue();
            this.modalidadServiceImp.delete(idModalidad);
            getQuery();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Elimino con Exito");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Error" + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        return "/index?faces-redirect=true";

    }

    //Modificar Modalidad de Concesión

    String nombremodAct;
    String descripcionmodAct;
    int idmodalidadAct;
    int estadomodAct;


    public void setNombremodAct(String nombremodAct) {
        this.nombremodAct = nombremodAct;
    }

    public String getNombremodAct() {
        return nombremodAct;
    }

    public void setDescripcionmodAct(String descripcionmodAct) {
        this.descripcionmodAct = descripcionmodAct;
    }

    public String getDescripcionmodAct() {
        return descripcionmodAct;
    }


    public void setIdmodalidadAct(int idmodalidadAct) {
        this.idmodalidadAct = idmodalidadAct;
    }

    public int getIdmodalidadAct() {
        return idmodalidadAct;
    }


    public void setEstadomodAct(int estadomodAct) {
        this.estadomodAct = estadomodAct;
    }

    public int getEstadomodAct() {
        return estadomodAct;
    }

    public void EmpSupUpd1() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idModificar");
        Integer idModalidad = Integer.valueOf(str.toString());
        modalidadVO = this.modalidadServiceImp.get(idModalidad);
        nombremodAct = modalidadVO.getMcoNombre();
        descripcionmodAct = modalidadVO.getMcoDescripcion();
        idmodalidadAct = modalidadVO.getMcoId();
        estadomodAct = modalidadVO.getMcoEstado();
    }

    public void Modificar() throws SQLException {
        if (nombremodAct.equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                 "No ha Ingresado el Nombre de la Modalidad de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (descripcionmodAct.equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                 "No ha Ingresado Descripción de la Modalidad de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            try {
                modalidadVO.setMcoDescripcion(descripcionmodAct);
                modalidadVO.setMcoEstado(estadomodAct);
                modalidadVO.setMcoNombre(nombremodAct);
                modalidadVO.setMcoId(idmodalidadAct);
                modalidadVO.setMcoFechaCambio(util.getObtenerFechaHoy());
                modalidadVO.setMcoTerminal(util.obtenerIpCliente());
                this.modalidadServiceImp.update(modalidadVO);
                getQuery();
                limpiarCampos();
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Actualizo con Exito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Error" + e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        }
    }


    //Ver Modalidad de Inversión
    String nombremodVer;
    String descripcionmodVer;


    public void setNombremodVer(String nombremodVer) {
        this.nombremodVer = nombremodVer;
    }

    public String getNombremodVer() {
        return nombremodVer;
    }

    public void setDescripcionmodVer(String descripcionmodVer) {
        this.descripcionmodVer = descripcionmodVer;
    }

    public String getDescripcionmodVer() {
        return descripcionmodVer;
    }

    public void EmpSupUpd3() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idVer");
        Integer idModalidad = Integer.valueOf(str.toString());
        modalidadVO = this.modalidadServiceImp.get(idModalidad);
        nombremodVer = modalidadVO.getMcoNombre();
        descripcionmodVer = modalidadVO.getMcoDescripcion();
    }

    //Busqueda por filtro

    String nombremodbuscar;


    public void setNombremodbuscar(String nombremodbuscar) {
        this.nombremodbuscar = nombremodbuscar;
    }

    public String getNombremodbuscar() {
        return nombremodbuscar;
    }


    public List<ModalidadConcesionVO> FiltrarListaModalidad() throws SQLException {
        System.out.println(nombremodbuscar);
        listaMod = this.modalidadServiceImp.FiltrarBusqueda(nombremodbuscar);
        //limpiarCampos ();
        return listaMod;
    }

    public void LimpiarFiltro() {
        nombremodbuscar = "";
    }


}
