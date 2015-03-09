package com.ositran.seguridad;

import com.ositran.service.MenService;
import com.ositran.service.RolOpcionesService;
import com.ositran.service.RolService;
import com.ositran.vo.bean.MenVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.RolVO;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;


@ManagedBean(name = "rolMB")
@RequestScoped
public class RolMB {
    public RolMB() {
        super();
    }
    private String nombre;
    private String descripcion;
    private List<RolVO> listaRoles;
    private List<MenVO> listaMen;
    private List<MenVO> listaMenSeleccionado;
    private List<RolOpcionesVO> listaRolOpciones;
    
    @ManagedProperty(value = "#{rolVO}")
    RolVO rolVO;
    
    @ManagedProperty(value = "#{rolServiceImpl}")
    RolService rolServiceImpl; 
    
    @ManagedProperty(value = "#{menServiceImpl}")
    MenService menServiceImpl;
    
    @ManagedProperty(value = "#{menVO}")
    MenVO menVO;
    
    @ManagedProperty(value = "#{rolOpcionesServiceImpl}")
    RolOpcionesService rolOpcionesServiceImpl;
    
    
    public void cargarListaRoles(){
        listaRoles=rolServiceImpl.query();
        System.out.println("cantidad de lista de roles "+ listaRoles.size());
        }
     public void cargarListaMenu(){
        listaMen=menServiceImpl.query();
      System.out.println(listaMen.get(0).getMenNombre());
        
        System.out.println("cantidad de lista de menu "+ listaMen.size());
        }
     
      public void cargarListaRolOpciones(){
        listaRolOpciones=rolOpcionesServiceImpl.query();   
        System.out.println("cantidad de lista de rolOpciones "+ listaRolOpciones.size());
        }
      public void pasarLista(){
          
          }
    
      public void onSelect(SelectEvent event){
          menVO=(MenVO)event.getObject(); 
          System.out.println("llego al onselecr");
          System.out.println(menVO.getMenNombre());
           
          }
      public void guardar(){
          for (MenVO menVO: listaMenSeleccionado){
              System.out.println(menVO.getMenNombre()+"---"+menVO.isEliminar()+"--"+menVO.isActualizar()+"---"+menVO.isCrear());
              }
          
          }
      
    public void setRolVO(RolVO rolVO) {
        this.rolVO = rolVO;
    }

    public RolVO getRolVO() {
        return rolVO;
    }

    public void setRolServiceImpl(RolService rolServiceImpl) {
        this.rolServiceImpl = rolServiceImpl;
    }

    public RolService getRolServiceImpl() {
        return rolServiceImpl;
    }


    public void setListaRoles(List<RolVO> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public List<RolVO> getListaRoles() {
        return listaRoles;
    }

    public void setMenServiceImpl(MenService menServiceImpl) {
        this.menServiceImpl = menServiceImpl;
    }

    public MenService getMenServiceImpl() {
        return menServiceImpl;
    }

    public void setListaMen(List<MenVO> listaMen) {
        this.listaMen = listaMen;
    }

    public List<MenVO> getListaMen() {
        return listaMen;
    }

    public void setMenVO(MenVO menVO) {
        this.menVO = menVO;
    }

    public MenVO getMenVO() {
        return menVO;
    }

    public void setRolOpcionesServiceImpl(RolOpcionesService rolOpcionesServiceImpl) {
        this.rolOpcionesServiceImpl = rolOpcionesServiceImpl;
    }

    public RolOpcionesService getRolOpcionesServiceImpl() {
        return rolOpcionesServiceImpl;
    }

    public void setListaRolOpciones(List<RolOpcionesVO> listaRolOpciones) {
        this.listaRolOpciones = listaRolOpciones;
    }

    public List<RolOpcionesVO> getListaRolOpciones() {
        return listaRolOpciones;
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

    public void setListaMenSeleccionado(List<MenVO> listaMenSeleccionado) {
        this.listaMenSeleccionado = listaMenSeleccionado;
    }

    public List<MenVO> getListaMenSeleccionado() {
        return listaMenSeleccionado;
    }

}
