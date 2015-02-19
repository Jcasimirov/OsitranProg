package com.ositran.parametros;

import com.ositran.service.TipoInversionServices;
import com.ositran.vo.bean.TipoInversionVO;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "tipoInversionMB")
@RequestScoped
public class TipoInversion{
    private int codigoEliminar;
    private String nombreEliminar;
    private List<TipoInversionVO> listaInversiones;
    private String nombre;
   
    private String descripcion; 
    private String buscar;
    //----------------EDITAR------------------------//
    private int codigoE;
    private String nombreE;
    private String descripcionE;
    //----------------EDITAR------------------------//
    
    //----------------MENSAJE VALIDACION------------------------//
    private int tipoMensaje;
    private String mensaje;
    //----------------MENSAJE VALIDACION------------------------//

    @ManagedProperty(value="#{tipoInversionServicesImpl}")
        TipoInversionServices tipoInversionServicesImpl;

    public void setTipoInversionServicesImpl(TipoInversionServices tipoInversionServicesImpl) {
        this.tipoInversionServicesImpl = tipoInversionServicesImpl;
    }

    public TipoInversionServices getTipoInversionServicesImpl() {
        return tipoInversionServicesImpl;
    }
    public TipoInversionVO tipoInversionVO= new TipoInversionVO();
      
  
        public void guardar(){
            tipoInversionVO.setTivNombre(nombre);
            tipoInversionVO.setTivDescripcion(descripcion);              
            tipoInversionVO.setTivEstado(1);   
            tipoInversionVO.setTivFechaAlta(new Date());
            tipoInversionVO.setTivUsuarioAlta("Abel Huarca");
            getTipoInversionServicesImpl().insert(tipoInversionVO);
            limpiarcampos();
            ListarInversiones();
            /*FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se registro con Exito");
                                                FacesContext.getCurrentInstance().addMessage(null, mensaje);*/
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Registro con Exito"));
            }
        public void limpiar(){
            nombre="";
            descripcion="";
            }
        public void cargarEditar(TipoInversionVO tipoInversionV){
                tipoInversionVO=tipoInversionV;
                codigoE=tipoInversionVO.getTivId();
                nombreE=tipoInversionVO.getTivNombre();
                descripcionE=tipoInversionVO.getTivDescripcion();
            }
        
        public void editar(){
            System.out.println(codigoE);
            System.out.println(nombreE);
            System.out.println(descripcionE);
            tipoInversionVO.setTivId(codigoE);
            tipoInversionVO.setTivNombre(nombreE);
            tipoInversionVO.setTivDescripcion(descripcionE);
            tipoInversionVO.setTivFechaCambio(new Date());
            tipoInversionVO.setTivUsuarioCambio("Editor");
        try {
            getTipoInversionServicesImpl().update(tipoInversionVO);
            ListarInversiones();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Actualizo con Exito");
                                                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
                
            }
        public void cargarEliminar(int codigo,String nombre ){
            nombreEliminar=nombre;
            codigoEliminar=codigo;
            }
        public void busqueda(){
            if (buscar.equals(null)){
                ListarInversiones();
                }
            else{
             listaInversiones=getTipoInversionServicesImpl().query1(buscar);
                    System.out.println( listaInversiones.size());
            }
        }
        
        
        public void eliminar(){
        getTipoInversionServicesImpl().delete(codigoEliminar);
        ListarInversiones();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se elimino con Exito");
                                                            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        
        public void limpiarcampos(){
            nombre="";
            descripcion="";
            }
        
        public List<TipoInversionVO> ListarInversiones(){
            listaInversiones= getTipoInversionServicesImpl().query(); 
            return listaInversiones;
        }

        
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }
        
        public void setTipoInversionVO(TipoInversionVO tipoInversionVO) {
            this.tipoInversionVO = tipoInversionVO;
        }

        public TipoInversionVO getTipoInversionVO() {
            return tipoInversionVO;
        }

        public void setListaInversiones(List<TipoInversionVO> listaInversiones) {
            this.listaInversiones = listaInversiones;
        }
    
        public List<TipoInversionVO> getListaInversiones() {
            return listaInversiones;
        }
        public void setCodigoEliminar(int codigoEliminar) {
            this.codigoEliminar = codigoEliminar;
        }
    
        public int getCodigoEliminar() {
            return codigoEliminar;
        }

        public void setNombreEliminar(String nombreEliminar) {
            this.nombreEliminar = nombreEliminar;
        }
    
        public String getNombreEliminar() {
            return nombreEliminar;
        }

        public void setCodigoE(int codigoE) {
            this.codigoE = codigoE;
        }
    
        public int getCodigoE() {
            return codigoE;
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
        
        public void setBuscar(String buscar) {
            this.buscar = buscar;
        }
    
        public String getBuscar() {
            return buscar;
        }

        public void setTipoMensaje(int tipoMensaje) {
            this.tipoMensaje = tipoMensaje;
        }
    
        public int getTipoMensaje() {
            return tipoMensaje;
        }
    
        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    
        public String getMensaje() {
            return mensaje;
        }

}
