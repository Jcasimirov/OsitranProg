package com.ositran.parametros;

import com.ositran.service.InversionDescripcionServices;
import com.ositran.service.TipoInversionServices;
import com.ositran.vo.bean.InversionDescripcionVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

@ManagedBean(name = "descripcionInversionMB")
@RequestScoped
public class DescripcionTipoInversion {
    
    private List<TipoInversionVO> listTipoInversion= new ArrayList<>();
    private List<InversionDescripcionVO> listaInversionDescripcion = new ArrayList<>();
    private String mensaje;
    private int tipoMensaje;
    private int codigoInversion;
    private String nombre;
    private String descripcion;
    private int codigoInversionDescripcion;
    public InversionDescripcionVO inversionDescripcionVO= new InversionDescripcionVO();
    
    //--------EDITAR-------------//
    private  int codigoInversionE;
    private String nombreE;
    private String descripcionE;
    //--------EDITAR-------------//
    
        @ManagedProperty(value="#{inversionDescripcionServicesImpl}")
        InversionDescripcionServices inversionDescripcionServicesImpl;
        
         @ManagedProperty(value="#{tipoInversionServicesImpl}")
        TipoInversionServices tipoInversionServicesImpl;

    public void guardar(){
        if (codigoInversion==0){
            System.out.println(" Debe elegir el tipo de inversion");
            }
        else {
                inversionDescripcionVO.setTivId(codigoInversion);
                inversionDescripcionVO.setItdNombre(nombre);
                inversionDescripcionVO.setItdDescripcion(descripcion);
                inversionDescripcionVO.setItdEstado(1);
                inversionDescripcionVO.setItdFechaAlta(new Date());
                inversionDescripcionVO.setItdUsuarioAlta("Abel Huarca");
                inversionDescripcionServicesImpl.insert(inversionDescripcionVO);
                cargarListaInversionDescripcion();
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se elimino con Exito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
       
        }    
    public void cargarEliminar(Integer codigo){
             System.out.println(codigo);
            codigoInversionDescripcion=codigo;
            System.out.println(codigoInversionDescripcion);
            
            
        }
    public void eliminar(){
        System.out.println(codigoInversionDescripcion);
        System.out.println("llego a eliminar");
        getInversionDescripcionServicesImpl().delete(codigoInversionDescripcion);
        cargarListaInversionDescripcion();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se elimino con Exito");
                                FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    public void cargarListaInversion(){
            listTipoInversion= getTipoInversionServicesImpl().query();
        }
    public void cargarEditar(InversionDescripcionVO inversionDesVO){
        codigoInversionE=inversionDesVO.getItdId();
        nombreE=inversionDesVO.getItdNombre();
        descripcionE=inversionDesVO.getItdDescripcion();
    }
    public void editar(){
            inversionDescripcionVO.setItdId(codigoInversionE);
            inversionDescripcionVO.setItdNombre(nombreE);
            inversionDescripcionVO.setItdDescripcion(descripcionE);
            inversionDescripcionVO.setItdUsuarioCambio("Abel Huarca");
            inversionDescripcionVO.setItdFechaCambio(new Date());
            getInversionDescripcionServicesImpl().update(inversionDescripcionVO);
            cargarListaInversionDescripcion();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Actualizo con Exito");                                            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }

    public void cargarListaInversionDescripcion(){
        listaInversionDescripcion=getInversionDescripcionServicesImpl().query();
      /*  for (InversionDescripcionVO inversionDescripcionVO: listaInversionDescripcion){
            System.out.println(inversionDescripcionVO.getItdDescripcion());
            }
        */
        
        }
    public void setInversionDescripcionVO(InversionDescripcionVO inversionDescripcionVO) {
        this.inversionDescripcionVO = inversionDescripcionVO;
    }

    public InversionDescripcionVO getInversionDescripcionVO() {
        return inversionDescripcionVO;
    }
    public void setCodigoInversion(int codigoInversion) {
        this.codigoInversion = codigoInversion;
    }

    public int getCodigoInversion() {
        return codigoInversion;
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
    public void setListaInversionDescripcion(List<InversionDescripcionVO> listaInversionDescripcion) {
        this.listaInversionDescripcion = listaInversionDescripcion;
    }

    public List<InversionDescripcionVO> getListaInversionDescripcion() {
        return listaInversionDescripcion;
    }
    public void setInversionDescripcionServicesImpl(InversionDescripcionServices inversionDescripcionServicesImpl) {
        this.inversionDescripcionServicesImpl = inversionDescripcionServicesImpl;
    }

    public InversionDescripcionServices getInversionDescripcionServicesImpl() {
        return inversionDescripcionServicesImpl;
    }
    public void setListTipoInversion(List<TipoInversionVO> listTipoInversion) {
        this.listTipoInversion = listTipoInversion;
    }
    
    public List<TipoInversionVO> getListTipoInversion() {
        return listTipoInversion;
    }
    public void setTipoInversionServicesImpl(TipoInversionServices tipoInversionServicesImpl) {
        this.tipoInversionServicesImpl = tipoInversionServicesImpl;
    }

    public TipoInversionServices getTipoInversionServicesImpl() {
        return tipoInversionServicesImpl;
    }
    public void setCodigoInversionDescripcion(int codigoInversionDescripcion) {
        this.codigoInversionDescripcion = codigoInversionDescripcion;
    }

    public int getCodigoInversionDescripcion() {
        return codigoInversionDescripcion;
    }
    public void setCodigoInversionE(int codigoInversionE) {
        this.codigoInversionE = codigoInversionE;
    }

    public int getCodigoInversionE() {
        return codigoInversionE;
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

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setTipoMensaje(int tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public int getTipoMensaje() {
        return tipoMensaje;
    }
}
