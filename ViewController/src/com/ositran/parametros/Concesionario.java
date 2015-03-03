package com.ositran.parametros;

import com.ositran.service.CargoService;
import com.ositran.service.ConcesionarioService;
import com.ositran.serviceimpl.CargoServiceImpl;
import com.ositran.serviceimpl.ConcesionarioServiceImpl;
import com.ositran.serviceimpl.TipoDocumentoServiceImpl;
import com.ositran.vo.bean.CargoVO;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.TipoDocumentoVO;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "concesionarioMB")
@RequestScoped
public class Concesionario{
    private int tipoD=0;
    private String buscar;
   private int codigoConcesionario; 
   private String nombre;
   private String descripcion;
   private String siglasNombre;
   private String telefono;
   private int tipDocumento;
   private String numeroDocumento;
   private String direccion;
   private String correo;
   private String representante;
   private int codigoCargo;
   //********************EDITAR***********************************/
   private int codigoConcesionarioE;
   private String nombreE;
   private String descripcionE;
   private String siglasNombreE;
   private String telefonoE;
   private int tipDocumentoE;
   private String numeroDocumentoE;
   private String direccionE;
   private String correoE;
   private String representanteE;
   private int codigoCargoE;
   private int concesionarioId;
    //********************EDITAR***********************************/
   List<ConcesionarioVO> listaCon;
   List<TipoDocumentoVO> listaTipoDoc;
   List<CargoVO> listCargo;
                    @ManagedProperty(value="#{concesionarioVO}")
                        ConcesionarioVO concesionarioVO;    
                    @ManagedProperty(value="#{tipoDocumentoServiceImp}")
                        TipoDocumentoServiceImpl tipoDocumentoServiceImp;
                    @ManagedProperty(value="#{concesionarioServiceImpl}")
                        ConcesionarioService concesionarioServiceImpl;
                    @ManagedProperty(value="#{cargoServiceImp}")
                        CargoService cargoServiceImp;
    
   public  void guardar(){
       System.out.println(tipDocumento);
       System.out.println(numeroDocumento.length());
       if (nombre.equals("")){
               FacesContext.getCurrentInstance().addMessage(null, 
               new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe ingresar el nombre"));
           }
       else if (descripcion.equals("")){
               FacesContext.getCurrentInstance().addMessage(null, 
               new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe ingresar la descripcion"));
           }
       else if (tipDocumento==0){
               FacesContext.getCurrentInstance().addMessage(null, 
               new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe selecionar tipo documento"));
           }
       else if (tipDocumento==2 && numeroDocumento.length()!=11){
               FacesContext.getCurrentInstance().addMessage(null, 
               new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El RUC debe de tener 11 dijitos"));
           }
           else if (tipDocumento==1 && numeroDocumento.length()!=8){
                   FacesContext.getCurrentInstance().addMessage(null, 
                   new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El DNI debe de tener 8 dijitos"));
               }
       
       else {
       concesionarioVO.setCncCorreo(correo);
       concesionarioVO.setCncDescripcion(descripcion);
       concesionarioVO.setCncDireccion(direccion);
       concesionarioVO.setCncEstado(1);
       concesionarioVO.setCncFechaAlta(new Date());
       concesionarioVO.setCncNombre(nombre);
       concesionarioVO.setCncNroDocumento(numeroDocumento);
       concesionarioVO.setCncRepresentanteLegal(representante);
       concesionarioVO.setCncTelefono(telefono);
       concesionarioVO.setCrgId(codigoCargo);
       concesionarioVO.setTdoId(tipDocumento);
       concesionarioServiceImpl.insert(concesionarioVO);
       cargarListaConcesionarios();
        limpiarCampos();
        RequestContext.getCurrentInstance().execute("insertarPanel.hide()");
        FacesContext.getCurrentInstance().addMessage(null, 
        new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Registro con Exito"));
       }
       }
   public void cargarEditar(ConcesionarioVO concesionarioVOE){
                    concesionarioId=concesionarioVOE.getCncId();
                    codigoConcesionarioE=concesionarioVOE.getCncId();
                    nombreE=concesionarioVOE.getCncNombre();
                    descripcionE=concesionarioVOE.getCncDescripcion();
                    siglasNombre="SIGLASS";
                    telefonoE=concesionarioVOE.getCncTelefono();
                    tipDocumentoE=concesionarioVOE.getTdoId();
                    numeroDocumentoE=concesionarioVOE.getCncNroDocumento();
                    direccionE=concesionarioVOE.getCncDireccion();
                    correoE=concesionarioVOE.getCncCorreo();
                    representanteE=concesionarioVOE.getCncRepresentanteLegal();
                    codigoCargoE=concesionarioVOE.getCrgId();
       }
   
   public void editar(){
        if (nombreE.equals("")){
                FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe infresar el nombre"));
            }
        else if (descripcionE.equals("")){
                FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe de Ingresar la Descripcion"));
            }
        else if (tipDocumentoE==0){
                FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe selecionar tipo documento"));
            }
        else {
          concesionarioVO.setCncId(concesionarioId);
          concesionarioVO.setCncCorreo(correoE);
          concesionarioVO.setCncDescripcion(descripcionE);
          concesionarioVO.setCncDireccion(direccionE);
          concesionarioVO.setCncEstado(2);
          concesionarioVO.setCncFechaCambio(new Date());
          concesionarioVO.setCncNombre(nombreE);
          concesionarioVO.setCncNroDocumento(numeroDocumentoE);
          concesionarioVO.setCncRepresentanteLegal(representanteE);
          concesionarioVO.setCncTelefono(telefonoE);
          concesionarioVO.setCrgId(codigoCargoE);
          concesionarioVO.setTdoId(tipDocumentoE);
          concesionarioServiceImpl.update(concesionarioVO);
          cargarListaConcesionarios();
          
          FacesContext.getCurrentInstance().addMessage(null, 
          new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Edito con Exito"));
        }
    }
   public void busqueda(){
       System.out.println("hola MB");
      listaCon= concesionarioServiceImpl.queryF(buscar);
       }
   public void  cargarListaTipoDocumento()throws SQLException{
           listaTipoDoc=tipoDocumentoServiceImp.query();
       }
   public void cargarListaCargo()throws SQLException{
            listCargo=cargoServiceImp.query();
       }
   public void cargarListaConcesionarios(){
       listaCon=concesionarioServiceImpl.query();
       }
   
   public void cargarEliminar(ConcesionarioVO concesionarioVO){
        
        descripcion=concesionarioVO.getCncDescripcion();
        codigoConcesionario=concesionarioVO.getCncId();
       }
   
   public void eliminar(){
       concesionarioServiceImpl.delete(codigoConcesionario);
       cargarListaConcesionarios();
       }

   public void limpiarCampos(){
             buscar="";
             codigoConcesionario=0; 
             nombre="";
             descripcion="";
             siglasNombre="";
             telefono="";
             tipDocumento=0;
             numeroDocumento="";
             direccion="";
             correo="";
             representante="";
             codigoCargo=0;
       }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSiglasNombre(String siglasNombre) {
        this.siglasNombre = siglasNombre;
    }

    public String getSiglasNombre() {
        return siglasNombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTipDocumento(int tipDocumento) {
        this.tipDocumento = tipDocumento;
    }

    public int getTipDocumento() {
        return tipDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getRepresentante() {
        return representante;
    }


    public void setCodigoCargo(int codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public int getCodigoCargo() {
        return codigoCargo;
    }

    public void setConcesionarioVO(ConcesionarioVO concesionarioVO) {
        this.concesionarioVO = concesionarioVO;
    }

    public ConcesionarioVO getConcesionarioVO() {
        return concesionarioVO;
    }

    public void setListaTipoDoc(List<TipoDocumentoVO> listaTipoDoc) {
        this.listaTipoDoc = listaTipoDoc;
    }

    public List<TipoDocumentoVO> getListaTipoDoc() {
        return listaTipoDoc;
    }


    public void setTipoDocumentoServiceImp(TipoDocumentoServiceImpl tipoDocumentoServiceImp) {
        this.tipoDocumentoServiceImp = tipoDocumentoServiceImp;
    }

    public TipoDocumentoServiceImpl getTipoDocumentoServiceImp() {
        return tipoDocumentoServiceImp;
    }


    public void setListCargo(List<CargoVO> listCargo) {
        this.listCargo = listCargo;
    }

    public List<CargoVO> getListCargo() {
        return listCargo;
    }

    public void setConcesionarioServiceImpl(ConcesionarioService concesionarioServiceImpl) {
        this.concesionarioServiceImpl = concesionarioServiceImpl;
    }

    public ConcesionarioService getConcesionarioServiceImpl() {
        return concesionarioServiceImpl;
    }

    public void setCargoServiceImp(CargoService cargoServiceImp) {
        this.cargoServiceImp = cargoServiceImp;
    }

    public CargoService getCargoServiceImp() {
        return cargoServiceImp;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setListaCon(List<ConcesionarioVO> listaCon) {
        this.listaCon = listaCon;
    }

    public List<ConcesionarioVO> getListaCon() {
        return listaCon;
    }

    public void setCodigoConcesionario(int codigoConcesionario) {
        this.codigoConcesionario = codigoConcesionario;
    }

    public int getCodigoConcesionario() {
        return codigoConcesionario;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setCodigoConcesionarioE(int codigoConcesionarioE) {
        this.codigoConcesionarioE = codigoConcesionarioE;
    }

    public int getCodigoConcesionarioE() {
        return codigoConcesionarioE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setSiglasNombreE(String siglasNombreE) {
        this.siglasNombreE = siglasNombreE;
    }

    public String getSiglasNombreE() {
        return siglasNombreE;
    }

    public void setTelefonoE(String telefonoE) {
        this.telefonoE = telefonoE;
    }

    public String getTelefonoE() {
        return telefonoE;
    }

    public void setTipDocumentoE(int tipDocumentoE) {
        this.tipDocumentoE = tipDocumentoE;
    }

    public int getTipDocumentoE() {
        return tipDocumentoE;
    }

    public void setNumeroDocumentoE(String numeroDocumentoE) {
        this.numeroDocumentoE = numeroDocumentoE;
    }

    public String getNumeroDocumentoE() {
        return numeroDocumentoE;
    }

    public void setDireccionE(String direccionE) {
        this.direccionE = direccionE;
    }

    public String getDireccionE() {
        return direccionE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setRepresentanteE(String representanteE) {
        this.representanteE = representanteE;
    }

    public String getRepresentanteE() {
        return representanteE;
    }

    public void setCodigoCargoE(int codigoCargoE) {
        this.codigoCargoE = codigoCargoE;
    }

    public int getCodigoCargoE() {
        return codigoCargoE;
    }

    public void setConcesionarioId(int concesionarioId) {
        this.concesionarioId = concesionarioId;
    }

    public int getConcesionarioId() {
        return concesionarioId;
    }

    public void setTipoD(int tipoD) {
        this.tipoD = tipoD;
    }

    public int getTipoD() {
        return tipoD;
    }
}
