package com.ositran.parametros;

import com.ositran.model.EmpresaSupervisora;
import com.ositran.model.TipoDocumento;
import com.ositran.serviceimpl.CargoServiceImpl;
import com.ositran.serviceimpl.EmpresaSupervisoraServiceImpl;
import com.ositran.serviceimpl.TipoDocumentoServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.TipoDocumentoVO;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import com.ositran.util.Util;
import com.ositran.vo.bean.CargoVO;

import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "backing_ositran_parametros_MantenimientoEmpSup")
@ViewScoped
@Generated(value = "1ositran/parametros/MantenimientoEmpSup.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoEmpSup {
    
    
    //-----------------SESSION-----------------------//
    public  final int formulario=8;
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

    public void setIpcliente(String ipcliente) {
        this.ipcliente = ipcliente;
    }

    public String getIpcliente() {
        return ipcliente;
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

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }
    //---------------------------------------------//
  
  
    private HtmlForm form1;
    
    Util util = new Util();
    List<EmpresaSupervisoraVO> listaEmpSup;    
    List<TipoDocumentoVO> listaTipoDocumento;
    List<CargoVO> listaCargo;  
    
    @ManagedProperty(value="#{empSupVO}")
    public EmpresaSupervisoraVO empSupVO;
    
    @ManagedProperty(value="#{empSupServiceImp}")
    private EmpresaSupervisoraServiceImpl empSupServiceImp;   
    
    @ManagedProperty(value="#{tipoDocumentoServiceImp}")
    private TipoDocumentoServiceImpl tipoDocumentoServiceImp;
    
    @ManagedProperty(value="#{cargoServiceImp}")
     private CargoServiceImpl cargoServiceImp;


    public void setListaCargo(List<CargoVO> listaCargo) {
        this.listaCargo = listaCargo;
    }

    public void setListaTipoDocumento(List<TipoDocumentoVO> listaTipoDocumento) {
        this.listaTipoDocumento = listaTipoDocumento;
    }

    public void setListaEmpSup(List<EmpresaSupervisoraVO> listaEmpSup) {
        this.listaEmpSup = listaEmpSup;
    }

    public List<EmpresaSupervisoraVO> getListaEmpSup() {
        return listaEmpSup;
    }

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }
    
    
    public void setTipoDocumentoServiceImp(TipoDocumentoServiceImpl tipoDocumentoServiceImp) {
        this.tipoDocumentoServiceImp = tipoDocumentoServiceImp;
    }

    public TipoDocumentoServiceImpl getTipoDocumentoServiceImp() {
        return tipoDocumentoServiceImp;
    }

    

    public void setEmpSupServiceImp(EmpresaSupervisoraServiceImpl empSupServiceImp) {
        this.empSupServiceImp = empSupServiceImp;
    }

    public EmpresaSupervisoraServiceImpl getEmpSupServiceImp() {
        return empSupServiceImp;
    }


    public void setCargoServiceImp(CargoServiceImpl cargoServiceImp) {
        this.cargoServiceImp = cargoServiceImp;
    }

    public CargoServiceImpl getCargoServiceImp() {
        return cargoServiceImp;
    }

    public void setEmpSupVO(EmpresaSupervisoraVO empSupVO) {
        this.empSupVO = empSupVO;
    }

    public EmpresaSupervisoraVO getEmpSupVO() {
        return empSupVO;
    }
    
    public List<EmpresaSupervisoraVO> getQuery() throws SQLException{
        listaEmpSup=this.empSupServiceImp.query();
        listaTipoDocumento = this.tipoDocumentoServiceImp.query();
        for (int i = 0 ; i< listaEmpSup.size();i++){
            for(int j=0; j<listaTipoDocumento.size();j++){
                if(listaEmpSup.get(i).getTdoId() == listaTipoDocumento.get(j).getTdoId()){
                    listaEmpSup.get(i).setDescripcionDoc(listaTipoDocumento.get(j).getTdoNombre());
                }
            }
        }
        nomEmpSupBus = "";
        //limpiarCampos ();
        return listaEmpSup; 
        
    }
    
    public List<TipoDocumentoVO> getListaTipoDocumento() throws SQLException{
        listaTipoDocumento = this.tipoDocumentoServiceImp.query(); 
        return listaTipoDocumento;
    }
    
    public List<CargoVO> getListaCargo() throws SQLException{
        listaCargo = this.cargoServiceImp.query(); 
        return listaCargo;
    }
    

    public String EmpSupUpd2() throws SQLException{
        this.empSupServiceImp.update(empSupVO);
        return "/index?faces-redirect=true";
    }

    // Registrar Empresa Supervisora
    
     private String nomEmpSup;
     private String dirEmpSup;
     private String repLegal;     
     private String telefono;
     private int tipoDocumento;
     private String nroDoc;
     private String correo;
     private String siglasNom;
     private String jefesup;
     private String dirObra;


    public void setJefesup(String jefesup) {
        this.jefesup = jefesup;
    }

    public String getJefesup() {
        return jefesup;
    }

    public void setDirObra(String dirObra) {
        this.dirObra = dirObra;
    }

    public String getDirObra() {
        return dirObra;
    }

    public void setNomEmpSup(String nomEmpSup) {
        this.nomEmpSup = nomEmpSup;
    }

    public String getNomEmpSup() {
        return nomEmpSup;
    }

    public void setDirEmpSup(String dirEmpSup) {
        this.dirEmpSup = dirEmpSup;
    }

    public String getDirEmpSup() {
        return dirEmpSup;
    }

    public void setRepLegal(String repLegal) {
        this.repLegal = repLegal;
    }

    public String getRepLegal() {
        return repLegal;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setSiglasNom(String siglasNom) {
        this.siglasNom = siglasNom;
    }

    public String getSiglasNom() {
        return siglasNom;
    }


    public void limpiarCampos (){
        nomEmpSup = "";
        dirEmpSup = "";
        repLegal = "" ;       
        telefono = "";
        tipoDocumento = 0;
        nroDoc = "";
        correo = "";
        siglasNom = "";    
        jefesup="";
        dirObra="";
    }
    
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
        Object str = requestMap.get("id3");
        Integer idEmpSup = Integer.valueOf(str.toString());
        empSupVO=this.empSupServiceImp.get(idEmpSup);
        idEliminar = empSupVO.getSupId();
        nombreEliminar = empSupVO.getSupNombre().toUpperCase();
    }
    
    public String EmpSupDel() throws SQLException{
        try{            
            empSupVO=this.empSupServiceImp.get(idEliminar);
            empSupVO.setSupEstado(0);
            empSupVO.setSupFechaBaja(util.getObtenerFechaHoy());
            empSupVO.setSupTerminal(ipcliente);
            empSupVO.setSupUsuarioBaja(usuario.getUsuAlias());
            empSupVO.setSupFechaBaja(util.getObtenerFechaHoy());
            
            this.empSupServiceImp.update(empSupVO);
            //this.empSupServiceImp.delete(idEmpSup);
            getQuery();
            empSupVO.setSupId(null);
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Elimino con Exito");
                                                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
           
                                                    
        }catch(Exception e){
            System.out.println(e.getMessage());
                            FacesMessage mensaje =
                                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Error" + e.getMessage());
                            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        return "/index?faces-redirect=true";
        
    }
    public int validarNombre (String Nombre) throws SQLException{
        int resultado = this.empSupServiceImp.ValidaNombre(Nombre);
        return resultado;
    }
    public int validarRuc (String ruc, int documento) throws SQLException{
        int resultado = this.empSupServiceImp.ValidaRuc(ruc,documento);
        return resultado;
    }
    
    public void guardar() throws SQLException{
        if (nomEmpSup.trim().equals("")) {
            FacesMessage mensaje =
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No ha Ingresado el Nombre de la Empresa Supervisora");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (dirEmpSup.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No ha Ingresado la Dirección de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (repLegal.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No ha Ingresado al Representante Legal de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!correo.matches("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Correo de la Empresa Supervisora Invalido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (siglasNom.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No ha Ingresado las Siglas del Nombre de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarNombre(nomEmpSup.trim())>0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Nombre de Empresa Supervisora ya Registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!telefono.trim().equals("") && !telefono.matches("[0-9]*")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Teléfono Inválido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (telefono.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese Teléfono");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento>0 && !nroDoc.matches("[0-9]*") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Nro de Documento Inválido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento == 0 && !nroDoc.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Seleccione Tipo de Documento");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento==1 && nroDoc.matches("[0-9]*") && (nroDoc.trim().length() > 8 ||nroDoc.trim().length() < 8)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Nro de Documento debe tener 8 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento==2 && nroDoc.matches("[0-9]*") && (nroDoc.trim().length() > 11 ||nroDoc.trim().length() < 11)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Nro de Documento debe tener 11 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (nroDoc.trim().length() >0 && validarRuc(nroDoc.trim(),tipoDocumento) > 0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Nro de Documento Ingresado, ya fue registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        
        else{
            try{
                empSupVO.setSupNombre(nomEmpSup);
                empSupVO.setSupDireccion(dirEmpSup);
                empSupVO.setSupRepresentanteLegal(repLegal);
                empSupVO.setSupTelefono(telefono);                
                if (tipoDocumento == 0){
                    empSupVO.setTdoId(null);
                    empSupVO.setSupNroDocumento(null);
                }else{
                    empSupVO.setTdoId(tipoDocumento);
                    empSupVO.setSupNroDocumento(nroDoc);
                }                
                empSupVO.setSupCorreo(correo);
                empSupVO.setSupSiglas(siglasNom); 
                empSupVO.setSupEstado(1);
                empSupVO.setSupJefeSupervision(jefesup);
                empSupVO.setSupObra(dirObra);
                empSupVO.setSupFechaAlta(util.getObtenerFechaHoy());
                empSupVO.setSupTerminal(ipcliente);  
                empSupVO.setSupUsuarioAlta(usuario.getUsuAlias());
                this.empSupServiceImp.insert(empSupVO);        
                getQuery();
                limpiarCampos();
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Registro con Exito");
                                                            FacesContext.getCurrentInstance().addMessage(null, mensaje);
                RequestContext.getCurrentInstance().execute("regEmpSup.hide()");
            }catch(Exception e){
                System.out.println(e.getMessage());
                                FacesMessage mensaje =
                                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Error" + e.getMessage());
                                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        }
        
    } 
    

    
    // Mofificar Empresa Supervisora
    
    private String nomEmpSupMod;
    private String dirEmpSupMod;
    private String repLegalMod;
    private String telefonoMod;
    private int tipoDocumentoMod;
    private String nroDocMod;
    private String correoMod;
    private String siglasNomMod;
    private int idMod;
    private int estadoMod;
    private String nommod;
    private String nroRuc;
    private String jefesupMod;
    private String dirObraMod;
    private Date fechaaltaMod;
    private String terminalMod;


    public void setFechaaltaMod(Date fechaaltaMod) {
        this.fechaaltaMod = fechaaltaMod;
    }

    public Date getFechaaltaMod() {
        return fechaaltaMod;
    }

    public void setTerminalMod(String terminalMod) {
        this.terminalMod = terminalMod;
    }

    public String getTerminalMod() {
        return terminalMod;
    }


    public void setJefesupMod(String jefesupMod) {
        this.jefesupMod = jefesupMod;
    }

    public String getJefesupMod() {
        return jefesupMod;
    }

    public void setDirObraMod(String dirObraMod) {
        this.dirObraMod = dirObraMod;
    }

    public String getDirObraMod() {
        return dirObraMod;
    }

    public void setNomEmpSupMod(String nomEmpSupMod) {
        this.nomEmpSupMod = nomEmpSupMod;
    }

    public String getNomEmpSupMod() {
        return nomEmpSupMod;
    }

    public void setDirEmpSupMod(String dirEmpSupMod) {
        this.dirEmpSupMod = dirEmpSupMod;
    }

    public String getDirEmpSupMod() {
        return dirEmpSupMod;
    }

    public void setRepLegalMod(String repLegalMod) {
        this.repLegalMod = repLegalMod;
    }

    public String getRepLegalMod() {
        return repLegalMod;
    }

    public void setTelefonoMod(String telefonoMod) {
        this.telefonoMod = telefonoMod;
    }

    public String getTelefonoMod() {
        return telefonoMod;
    }

    public void setTipoDocumentoMod(int tipoDocumentoMod) {
        this.tipoDocumentoMod = tipoDocumentoMod;
    }

    public int getTipoDocumentoMod() {
        return tipoDocumentoMod;
    }

    public void setNroDocMod(String nroDocMod) {
        this.nroDocMod = nroDocMod;
    }

    public String getNroDocMod() {
        return nroDocMod;
    }

    public void setCorreoMod(String correoMod) {
        this.correoMod = correoMod;
    }

    public String getCorreoMod() {
        return correoMod;
    }

    public void setSiglasNomMod(String siglasNomMod) {
        this.siglasNomMod = siglasNomMod;
    }

    public String getSiglasNomMod() {
        return siglasNomMod;
    }


    public void setIdMod(int idMod) {
        this.idMod = idMod;
    }

    public int getIdMod() {
        return idMod;
    }


    public void setEstadoMod(int estadoMod) {
        this.estadoMod = estadoMod;
    }

    public int getEstadoMod() {
        return estadoMod;
    }


    public void setNommod(String nommod) {
        this.nommod = nommod;
    }

    public String getNommod() {
        return nommod;
    }


    public void setNroRuc(String nroRuc) {
        this.nroRuc = nroRuc;
    }

    public String getNroRuc() {
        return nroRuc;
    }

    public void EmpSupUpd1() throws SQLException{
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("id2");
        Integer idEmpSup=Integer.valueOf(str.toString());
        empSupVO=this.empSupServiceImp.get(idEmpSup);        
        nomEmpSupMod = empSupVO.getSupNombre();
        dirEmpSupMod = empSupVO.getSupDireccion();
        repLegalMod = empSupVO.getSupRepresentanteLegal();        
        telefonoMod = empSupVO.getSupTelefono();        
        nroDocMod = empSupVO.getSupNroDocumento();
        correoMod = empSupVO.getSupCorreo();
        siglasNomMod = empSupVO.getSupSiglas();
        idMod = empSupVO.getSupId();
        estadoMod = empSupVO.getSupEstado();
        tipoDocumentoMod = empSupVO.getTdoId();
        nommod = empSupVO.getSupNombre();
        nroRuc = empSupVO.getSupNroDocumento();
        jefesupMod = empSupVO.getSupJefeSupervision();
        dirObraMod = empSupVO.getSupObra();
        fechaaltaMod = empSupVO.getSupFechaAlta();
        terminalMod = empSupVO.getSupTerminal();
    }
    
    public int validarRucMod (String ruc,String RucAnt, int documento) throws SQLException{
        int resultado = this.empSupServiceImp.ValidarRucMod(ruc,RucAnt,documento);
        return resultado;
    }
    public int validarNombreMod (String Nombre,String NombreEmpMod) throws SQLException{
        int resultado = this.empSupServiceImp.ValidaNombreMod(Nombre,NombreEmpMod);
        return resultado;
    }
    
    public void Modificar() throws SQLException{
        if (nomEmpSupMod.trim().equals("")) {
            FacesMessage mensaje =
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No ha Ingresado el Nombre de la Empresa Supervisora");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (dirEmpSupMod.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No ha Ingresado la Dirección de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (repLegalMod.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No ha Ingresado al Representante Legal de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!correoMod.matches("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Correo de la Empresa Supervisora Invalido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (siglasNomMod.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No ha Ingresado las Siglas del Nombre de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarNombreMod(nomEmpSupMod.trim(),nomEmpSupMod.trim())>0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Nombre de Empresa Supervisora ya Registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!telefonoMod.trim().equals("") && !telefonoMod.matches("[0-9]*")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Telefono Inválido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (telefonoMod.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Ingrese Teléfono");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod>0 && !nroDocMod.matches("[0-9]*") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Nro de Documento Inválido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod == 0 && !nroDocMod.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Seleccione Tipo de Documento");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod==1 && nroDocMod.matches("[0-9]*") && (nroDocMod.trim().length() > 8 ||nroDocMod.trim().length() < 8)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Nro de Documento debe tener 8 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod==2 && nroDocMod.matches("[0-9]*") && (nroDocMod.trim().length() > 11 ||nroDocMod.trim().length() < 11)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Nro de Documento debe tener 11 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarRucMod(nroDocMod.trim(),nroRuc,tipoDocumentoMod) > 0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Nro de Documento Ingresado, ya fue registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        else{
            try{
                empSupVO.setSupNombre(nomEmpSupMod);
                empSupVO.setSupDireccion(dirEmpSupMod);
                empSupVO.setSupRepresentanteLegal(repLegalMod);
                empSupVO.setSupTelefono(telefonoMod);
                if (tipoDocumentoMod == 0){
                    empSupVO.setTdoId(null);
                    empSupVO.setSupNroDocumento(null);
                }else{
                    empSupVO.setTdoId(tipoDocumentoMod);
                    empSupVO.setSupNroDocumento(nroDocMod);
                }                
                empSupVO.setSupCorreo(correoMod);
                empSupVO.setSupSiglas(siglasNomMod); 
                empSupVO.setSupId(idMod);
                empSupVO.setSupEstado(estadoMod);
                empSupVO.setSupJefeSupervision(jefesupMod);
                empSupVO.setSupObra(dirObraMod);            
                empSupVO.setSupTerminal(ipcliente);
                empSupVO.setSupUsuarioCambio(usuario.getUsuAlias());
                empSupVO.setSupFechaCambio(util.getObtenerFechaHoy());                
                this.empSupServiceImp.update(empSupVO);
                empSupVO.setSupId(null);
                getQuery();
                limpiarCampos();
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Actualizo con Exito");
                                                            FacesContext.getCurrentInstance().addMessage(null, mensaje);
                RequestContext.getCurrentInstance().execute("ModEmpSup.hide()");
            }catch(Exception e){
                System.out.println(e.getMessage());
                                FacesMessage mensaje =
                                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Error" + e.getMessage());
                                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        }
        
    } 
    
    
    // Ver Empresa Supervisora
    
    
    private String nomEmpSupVer;
    private String dirEmpSupVer;
    private String repLegalVer;
    private String telefonoVer;
    private String tipoDocumentoVer;
    private String nroDocVer;
    private String correoVer;
    private String siglasNomVer;
    private String jefesupVer;
    private String dirObraVer;


    public void setJefesupVer(String jefesupVer) {
        this.jefesupVer = jefesupVer;
    }

    public String getJefesupVer() {
        return jefesupVer;
    }

    public void setDirObraVer(String dirObraVer) {
        this.dirObraVer = dirObraVer;
    }

    public String getDirObraVer() {
        return dirObraVer;
    }


    public void setNomEmpSupVer(String nomEmpSupVer) {
        this.nomEmpSupVer = nomEmpSupVer;
    }

    public String getNomEmpSupVer() {
        return nomEmpSupVer;
    }

    public void setDirEmpSupVer(String dirEmpSupVer) {
        this.dirEmpSupVer = dirEmpSupVer;
    }

    public String getDirEmpSupVer() {
        return dirEmpSupVer;
    }

    public void setRepLegalVer(String repLegalVer) {
        this.repLegalVer = repLegalVer;
    }

    public String getRepLegalVer() {
        return repLegalVer;
    }

    public void setTelefonoVer(String telefonoVer) {
        this.telefonoVer = telefonoVer;
    }

    public String getTelefonoVer() {
        return telefonoVer;
    }

    public void setTipoDocumentoVer(String tipoDocumentoVer) {
        this.tipoDocumentoVer = tipoDocumentoVer;
    }

    public String getTipoDocumentoVer() {
        return tipoDocumentoVer;
    }

    public void setNroDocVer(String nroDocVer) {
        this.nroDocVer = nroDocVer;
    }

    public String getNroDocVer() {
        return nroDocVer;
    }

    public void setCorreoVer(String correoVer) {
        this.correoVer = correoVer;
    }

    public String getCorreoVer() {
        return correoVer;
    }

    public void setSiglasNomVer(String siglasNomVer) {
        this.siglasNomVer = siglasNomVer;
    }

    public String getSiglasNomVer() {
        return siglasNomVer;
    }

    public void EmpSupVer() throws SQLException{
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("id1");
        Integer idEmpSup=Integer.valueOf(str.toString());
        listaTipoDocumento = tipoDocumentoServiceImp.query(); 
        listaCargo = cargoServiceImp.query();        
        empSupVO=this.empSupServiceImp.get(idEmpSup);        
        nomEmpSupVer = empSupVO.getSupNombre();
        dirEmpSupVer = empSupVO.getSupDireccion();
        repLegalVer = empSupVO.getSupRepresentanteLegal();
        telefonoVer = empSupVO.getSupTelefono();        
        nroDocVer = empSupVO.getSupNroDocumento();
        correoVer = empSupVO.getSupCorreo();
        siglasNomVer = empSupVO.getSupSiglas();
        jefesupVer = empSupVO.getSupJefeSupervision();
        dirObraVer = empSupVO.getSupObra();
        for (int i=0; i<listaTipoDocumento.size();i++){
            if(listaTipoDocumento.get(i).getTdoId() == empSupVO.getTdoId()){
                tipoDocumentoVer = listaTipoDocumento.get(i).getTdoNombre();
            }
        }
        
    }
    
    
    // Busqueda Por Nombre Empresa Supervisora
    
    String nomEmpSupBus;
    String rucbus;


    public void setNomEmpSupBus(String nomEmpSupBus) {
        this.nomEmpSupBus = nomEmpSupBus;
    }

    public String getNomEmpSupBus() {
        return nomEmpSupBus;
    }


    public void setRucbus(String rucbus) {
        this.rucbus = rucbus;
    }

    public String getRucbus() {
        return rucbus;
    }

    public List<EmpresaSupervisoraVO> FiltrarListaEmpSup() throws SQLException{
        System.out.println(nomEmpSupBus);
        System.out.println(rucbus);
        listaEmpSup=this.empSupServiceImp.FiltrarEmpSup(nomEmpSupBus);
        listaTipoDocumento = this.tipoDocumentoServiceImp.query();
        for (int i = 0 ; i< listaEmpSup.size();i++){
            for(int j=0; j<listaTipoDocumento.size();j++){
                if(listaEmpSup.get(i).getTdoId() == listaTipoDocumento.get(j).getTdoId()){
                    listaEmpSup.get(i).setDescripcionDoc(listaTipoDocumento.get(j).getTdoNombre());
                }
            }
        }
        //limpiarCampos ();
        return listaEmpSup; 
    }
    
    public void LimpiarFiltro(){
        nomEmpSupBus = "";
        rucbus="";
    }
    
    


}

