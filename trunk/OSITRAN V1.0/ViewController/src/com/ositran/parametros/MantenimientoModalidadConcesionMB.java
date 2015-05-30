package com.ositran.parametros;

import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.util.Util;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "backing_mantenimientoModalidadConcesion")
@ViewScoped

public class MantenimientoModalidadConcesionMB {
    
    
    //-----------------SESSION-----------------------//
    public  final int formulario=22;
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

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }
    //---------------------------------------------//

    //Mantenimiento Modalidad Concesion

    private HtmlForm form1;
    Util util = new Util();
    
    
    //Service    
    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionServiceImpl modalidadServiceImp;
    
    //Bean    
    @ManagedProperty(value="#{modalidadVO}")
    public ModalidadConcesionVO modalidadVO;
    
    //Listas
    List<ModalidadConcesionVO> listaMod;

    
    // Get Y Set

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

    public void getQuery() throws SQLException {
        listaMod = this.modalidadServiceImp.query();
        nombremodbuscar = "";
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

    public void EmpSupUpd2() throws SQLException {
        this.modalidadServiceImp.update(modalidadVO);
    }
    public int validarNombre (String Nombre) throws SQLException{
        int resultado = this.modalidadServiceImp.ValidaNombre(Nombre);
        return resultado;
    }
    public int validarNombreMod (String Nombre,String nombremod) throws SQLException{
        int resultado = this.modalidadServiceImp.ValidaNombreMod(Nombre,nombremod);
        return resultado;
    }
    public void guardar() throws SQLException {
        if (nombremod.equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                 "No ha Ingresado el Nombre de la Modalidad de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (descripcionmod.equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                 "No ha Ingresado Descripción de la Modalidad de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarNombre(nombremod) > 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                 "El Nombre Ingresado ya existe");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            try {
                modalidadVO.setMcoDescripcion(descripcionmod);
                modalidadVO.setMcoNombre(nombremod);
                modalidadVO.setMcoEstado(1);
                modalidadVO.setMcoTerminal(ipcliente);
                modalidadVO.setMcoFechaAlta(util.getObtenerFechaHoy());
                modalidadVO.setMcoUsuarioAlta(usuario.getUsuAlias());
                this.modalidadServiceImp.insert(modalidadVO);
                getQuery();
                limpiarCampos();
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Registró con Éxito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                RequestContext.getCurrentInstance().execute("regModalidad.hide()");
                
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
    
    int idEliminar;
    String nombreEliminar;


    public void setIdEliminar(int idEliminar) {
        this.idEliminar = idEliminar;
    }

    public int getIdEliminar() {
        return idEliminar;
    }

    public void setNombreEliminar(String nombreEliminar) {
        this.nombreEliminar = nombreEliminar;
    }

    public String getNombreEliminar() {
        return nombreEliminar;
    }

    public void confirmarEliminar() throws SQLException{
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idEliminar");
        Integer idModalidad = Integer.valueOf(str.toString());
        modalidadVO = this.modalidadServiceImp.get(idModalidad);
        idEliminar = modalidadVO.getMcoId();
        nombreEliminar = modalidadVO.getMcoNombre().toUpperCase();
    }

    public void EliminarModalidad() throws SQLException {
        try {
            boolean codigoValido = modalidadServiceImp.validarCodigoEnUso(idEliminar);
            if (codigoValido) {
                modalidadVO = this.modalidadServiceImp.get(idEliminar);
                modalidadVO.setMcoEstado(0);
                //this.modalidadServiceImp.delete(idModalidad);
                modalidadVO.setMcoTerminal(ipcliente);
                modalidadVO.setMcoFechaBaja(util.getObtenerFechaHoy());
                modalidadVO.setMcoUsuarioBaja(usuario.getUsuAlias());
                modalidadServiceImp.update(modalidadVO);
                getQuery();
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Eliminó con Éxito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                modalidadVO.setMcoId(null);
            } else {
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                     "No se puede Eliminar porque la Concesion esta en Uso!");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrió un Error" + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            
        }

    }

    //Modificar Modalidad de Concesión

    String nombremodAct;
    String descripcionmodAct;
    int idmodalidadAct;
    int estadomodAct;
    String nommod;


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


    public void setNommod(String nommod) {
        this.nommod = nommod;
    }

    public String getNommod() {
        return nommod;
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
        nommod = modalidadVO.getMcoNombre();
    }

    public void Modificar() throws SQLException {
        if (nombremodAct.equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                 "No ha Ingresado el Nombre de la Modalidad de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (descripcionmodAct.equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                 "No ha Ingresado Descripción de la Modalidad de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarNombreMod(nombremodAct,nommod) > 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                 "El Nombre Ingresado ya existe");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            try {
                modalidadVO.setMcoDescripcion(descripcionmodAct);
                modalidadVO.setMcoEstado(estadomodAct);
                modalidadVO.setMcoNombre(nombremodAct);
                //modalidadVO.setMcoId(idmodalidadAct);
                modalidadVO.setMcoTerminal(ipcliente);
                modalidadVO.setMcoFechaCambio(util.getObtenerFechaHoy());
                modalidadVO.setMcoUsuarioCambio(usuario.getUsuAlias());
                this.modalidadServiceImp.update(modalidadVO);
                getQuery();
                limpiarCampos();
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Actualizó con Éxito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);                 
                RequestContext.getCurrentInstance().execute("modModalidad.hide()");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrió un Error" + e.getMessage());
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

    public void FiltrarListaModalidad() throws SQLException {
        System.out.println(nombremodbuscar);
        listaMod = this.modalidadServiceImp.FiltrarBusqueda(nombremodbuscar);
        //limpiarCampos ();
    }

    public void LimpiarFiltro() {
        nombremodbuscar = "";
    }


    public void setUtil(Util util) {
        this.util = util;
    }

    public Util getUtil() {
        return util;
    }
}
