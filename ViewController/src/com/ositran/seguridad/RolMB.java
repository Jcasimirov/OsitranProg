package com.ositran.seguridad;

import com.ositran.service.MenService;
import com.ositran.service.RolOpcionesService;
import com.ositran.service.RolService;
import com.ositran.vo.bean.MenVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.RolVO;

import java.util.ArrayList;
import java.util.Date;
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
    private List<MenVO> listaMenSeleccionado=new ArrayList<>();
    private List<RolOpcionesVO> listaRolOpciones;
    private int codigoRol;
    
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
    
    public void limpiar() {
        nombre = "";
        descripcion = "";
    }
    
    public void cargarListaRoles(){
            int contador=1;
            listaRoles=rolServiceImpl.query();
            for(int i=0;i<listaRoles.size();i++){
              listaRoles.get(i).setContador(contador);
                contador++;
                }
        }
    public void limpiarListas(){
            limpiar();
            listaRolOpciones.clear();
            listaMenSeleccionado.clear();
        }
    public void cargarEditar(){
        
        }
    public void cargarEliminar(){
        
        }
     public void cargarListaMenu(){
        listaMen=menServiceImpl.query();
        System.out.println("  Cantidad de Menu "+listaMen.size());
        limpiar();
        listaMenSeleccionado.clear();
        
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
          if(nombre.equals("")){
                    FacesContext.getCurrentInstance().addMessage(null,
                     new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                      "Debe de Ingresar el Nombre"));                     
                                   }
          else if (descripcion.equals("")){
                  FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                    "Debe ingresar la desripción"));
              }
          
          else if (listaMenSeleccionado.size()==0){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                    "Debe Seleccionar al menos una opción del menú para este rol"));
              }
          else {
              
              System.out.println("Antes");
              System.out.println(listaMenSeleccionado.get(0).isActualizar()+" -- "+listaMenSeleccionado.get(0).isCrear());
              
            rolVO.setRolNombre(nombre);
            rolVO.setRolDescripcion(descripcion);
            rolVO.setRolEstado(1);
            rolVO.setRolFechaAlta(new Date());
            rolVO.setRolUsuarioAlta("Abel Huarca");
          codigoRol=  rolServiceImpl.getCodigo(rolVO);
              
              for(MenVO menVO: listaMenSeleccionado ){
                  System.out.println(menVO.isActualizar());
                  System.out.println(menVO.isCrear());
                  System.out.println(menVO.isEliminar());
                  System.out.println(menVO.isLectura());
                  RolOpcionesVO rolOpcionesVO=new RolOpcionesVO();
                  rolOpcionesVO.setRolId(codigoRol);
                  rolOpcionesVO.setMenId(menVO.getMenId());
                  rolOpcionesVO.setRolId(1);  
                  rolOpcionesVO.setTroAgregar( (menVO.isCrear()) ? 1 : 0);
                  rolOpcionesVO.setTroConsultar( (menVO.isLectura()) ? 1 : 0 ); 
                  rolOpcionesVO.setTroEliminar(  (menVO.isEliminar()) ? 1 : 0 );
                  rolOpcionesVO.setTroModificar( (menVO.isActualizar()) ? 1 : 0 );
                  rolOpcionesServiceImpl.insert(rolOpcionesVO);
                  
                  cargarListaRoles();
                  
                  }
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

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    public int getCodigoRol() {
        return codigoRol;
    }
}
