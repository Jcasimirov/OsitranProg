package com.ositran.parametros;

import com.ositran.model.EmpresaSupervisora;
import com.ositran.model.TipoDocumento;
import com.ositran.serviceimpl.CargoServiceImpl;
import com.ositran.serviceimpl.EmpresaSupervisoraServiceImpl;
import com.ositran.serviceimpl.TipoDocumentoServiceImpl;
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

import java.sql.SQLException;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "backing_ositran_parametros_MantenimientoEmpSup")
@RequestScoped
@Generated(value = "1ositran/parametros/MantenimientoEmpSup.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoEmpSup {
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
     private int cargo;
     private String telefono;
     private int tipoDocumento;
     private String nroDoc;
     private String correo;
     private String siglasNom;


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

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
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
        cargo = 0;
        telefono = "";
        tipoDocumento = 0;
        nroDoc = "";
        correo = "";
        siglasNom = "";    
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
            empSupVO.setSupEstado(2);
            empSupVO.setSupFechaBaja(util.getObtenerFechaHoy());
            empSupVO.setSupTerminal(util.obtenerIpCliente());
            this.empSupServiceImp.update(empSupVO);
            //this.empSupServiceImp.delete(idEmpSup);
            getQuery();
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
                            new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado el Nombre de la Empresa Supervisora");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (dirEmpSup.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado la Direcci�n de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (repLegal.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado al Representante Legal de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (cargo == 0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado el Cargo del Representante Legal");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!correo.matches("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Correo de la Empresa Supervisora Invalido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (siglasNom.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado las Siglas del Nombre de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarNombre(nomEmpSup.trim())>0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nombre de Empresa Supervisora ya Registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!telefono.trim().equals("") && !telefono.matches("[0-9]*")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Telefono Inv�lido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento>0 && !nroDoc.matches("[0-9]*") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento Inv�lido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento == 0 && !nroDoc.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione Tipo de Documento");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento==1 && nroDoc.matches("[0-9]*") && (nroDoc.trim().length() > 8 ||nroDoc.trim().length() < 8)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento debe tener 8 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento==2 && nroDoc.matches("[0-9]*") && (nroDoc.trim().length() > 11 ||nroDoc.trim().length() < 11)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento debe tener 11 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarRuc(nroDoc.trim(),tipoDocumento) > 0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El Nro de Documento Ingresado, ya fue registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        
        else{
            try{
                empSupVO.setSupNombre(nomEmpSup);
                empSupVO.setSupDireccion(dirEmpSup);
                empSupVO.setSupRepresentanteLegal(repLegal);
                empSupVO.setCrgId(cargo);
                empSupVO.setSupTelefono(telefono);
                empSupVO.setSupNroDocumento(nroDoc);
                empSupVO.setTdoId(tipoDocumento);
                empSupVO.setSupCorreo(correo);
                empSupVO.setSupDescripcion(siglasNom); 
                empSupVO.setSupEstado(1);
                empSupVO.setSupFechaAlta(util.getObtenerFechaHoy());
                empSupVO.setSupTerminal(util.obtenerIpCliente());
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
    private int cargoMod;
    private String telefonoMod;
    private int tipoDocumentoMod;
    private String nroDocMod;
    private String correoMod;
    private String siglasNomMod;
    private int idMod;
    private int estadoMod;
    private String nommod;
    private String nroRuc;

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

    public void setCargoMod(int cargoMod) {
        this.cargoMod = cargoMod;
    }

    public int getCargoMod() {
        return cargoMod;
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
        siglasNomMod = empSupVO.getSupDescripcion();
        idMod = empSupVO.getSupId();
        estadoMod = empSupVO.getSupEstado();
        cargoMod = empSupVO.getCrgId();
        tipoDocumentoMod = empSupVO.getTdoId();
        nommod = empSupVO.getSupNombre();
        nroRuc = empSupVO.getSupNroDocumento();
        
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
                            new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado el Nombre de la Empresa Supervisora");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (dirEmpSupMod.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado la Direcci�n de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (repLegalMod.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado al Representante Legal de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (cargoMod == 0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado el Cargo del Representante Legal");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!correoMod.matches("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Correo de la Empresa Supervisora Invalido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (siglasNomMod.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado las Siglas del Nombre de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarNombreMod(nomEmpSupMod.trim(),nommod.trim())>0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nombre de Empresa Supervisora ya Registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!telefonoMod.trim().equals("") && !telefonoMod.matches("[0-9]*")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Telefono Inv�lido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod>0 && !nroDocMod.matches("[0-9]*") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento Inv�lido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod == 0 && !nroDocMod.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione Tipo de Documento");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod==1 && nroDocMod.matches("[0-9]*") && (nroDocMod.trim().length() > 8 ||nroDocMod.trim().length() < 8)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento debe tener 8 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod==2 && nroDocMod.matches("[0-9]*") && (nroDocMod.trim().length() > 11 ||nroDocMod.trim().length() < 11)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento debe tener 11 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarRucMod(nroDocMod.trim(),nroRuc,tipoDocumentoMod) > 0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El Nro de Documento Ingresado, ya fue registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        else{
            try{
                empSupVO.setSupNombre(nomEmpSupMod);
                empSupVO.setSupDireccion(dirEmpSupMod);
                empSupVO.setSupRepresentanteLegal(repLegalMod);
                empSupVO.setCrgId(cargoMod);
                empSupVO.setSupTelefono(telefonoMod);
                empSupVO.setSupNroDocumento(nroDocMod);
                empSupVO.setTdoId(tipoDocumentoMod);
                empSupVO.setSupCorreo(correoMod);
                empSupVO.setSupDescripcion(siglasNomMod); 
                empSupVO.setSupFechaCambio(util.getObtenerFechaHoy());
                empSupVO.setSupTerminal(util.obtenerIpCliente());
                empSupVO.setSupId(idMod);
                empSupVO.setSupEstado(estadoMod);
                this.empSupServiceImp.update(empSupVO);        
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
    private String cargoVer;
    private String telefonoVer;
    private String tipoDocumentoVer;
    private String nroDocVer;
    private String correoVer;
    private String siglasNomVer;


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

    public void setCargoVer(String cargoVer) {
        this.cargoVer = cargoVer;
    }

    public String getCargoVer() {
        return cargoVer;
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
        siglasNomVer = empSupVO.getSupDescripcion();
        for (int i=0; i<listaTipoDocumento.size();i++){
            if(listaTipoDocumento.get(i).getTdoId() == empSupVO.getTdoId()){
                tipoDocumentoVer = listaTipoDocumento.get(i).getTdoNombre();
            }
        }
        
        for (int i=0; i<listaCargo.size();i++){
            if(listaCargo.get(i).getCrgId() == empSupVO.getCrgId()){
                cargoVer = listaCargo.get(i).getCrgNombre();
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
        listaEmpSup=this.empSupServiceImp.FiltrarEmpSup(nomEmpSupBus,rucbus);
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

