package com.ositran.seguridad;

import com.ositran.service.RolOpcionesService;
import com.ositran.serviceimpl.MenServiceImpl;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.MenVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@ManagedBean(name = "menuMB")
@SessionScoped
public class MenuMB {

    private MenuModel model;
    private  HttpServletRequest httpServletRequest=null;
    private  FacesContext faceContext=null;
    private List<RolOpcionesVO> listaRolOpciones=new ArrayList<>();
    private List<MenVO> listaMenu=new ArrayList<>();
    private List<UsuarioVO> listaUsuarios=new ArrayList<>();
    private int padre;
    
    
    @ManagedProperty(value = "#{rolOpcionesServiceImpl}")
    RolOpcionesService rolOpcionesServiceImpl;
    
    @ManagedProperty(value = "#{rolOpcionesVO}")
    RolOpcionesVO rolOpcionesVO;
    
    @ManagedProperty(value = "#{menServiceImpl}")
    MenServiceImpl menServiceImpl;
    
    @ManagedProperty(value = "#{menVO}")
    MenVO menVO;
    private UsuarioVO usuarioLogueado;
    public MenuMB(){
        
        }
    
    @PostConstruct
    public void init(){
        
            model = new DefaultMenuModel();
            faceContext=FacesContext.getCurrentInstance();
            httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
            HttpSession session = httpServletRequest.getSession();
            listaUsuarios=(List<UsuarioVO>)session.getAttribute("listaUsuario");
            listaRolOpciones=(List<RolOpcionesVO>)session.getAttribute("listaPermisos");
            //primer submenu
            Submenu primersubmenu = new Submenu();  
            primersubmenu.setLabel("PARÁMETROS "); 
            for (int i=0;i<listaRolOpciones.size();i++){ 
                 menVO=menServiceImpl.get(listaRolOpciones.get(i).getMenId());
                if (menVO.getMenPadre()==1){
                MenuItem item= new MenuItem();
                item.setValue(menVO.getMenNombre());
                item.setUrl(menVO.getMenUrl());
                 primersubmenu.getChildren().add(item);
                 }
                }
        
           
            //segundo submenu
            Submenu segundoSubmenu = new Submenu();           
            segundoSubmenu.setLabel("SEGURIDAD ");  
            for (int i=0;i<listaRolOpciones.size();i++){ 
                 menVO=menServiceImpl.get(listaRolOpciones.get(i).getMenId());
                if (menVO.getMenPadre()==2){
                MenuItem item= new MenuItem();
                item.setValue(menVO.getMenNombre());
                item.setUrl(menVO.getMenUrl());
                 segundoSubmenu.getChildren().add(item);
                 }
                }
                    
            //tercero submenu
            Submenu tercerSubmenu = new Submenu();           
            tercerSubmenu.setLabel("CONTRATO ");  
            for (int i=0;i<listaRolOpciones.size();i++){ 
                 menVO=menServiceImpl.get(listaRolOpciones.get(i).getMenId());
                if (menVO.getMenPadre()==3)
                {
                MenuItem item= new MenuItem();
                item.setValue(menVO.getMenNombre());
                item.setUrl(menVO.getMenUrl());
                 tercerSubmenu.getChildren().add(item);
                 }
                }
            
            //cuarto submenu
            Submenu cuartoSubmenu = new Submenu();           
            cuartoSubmenu.setLabel("REPORTE ");  
            for (int i=0;i<listaRolOpciones.size();i++){ 
                 menVO=menServiceImpl.get(listaRolOpciones.get(i).getMenId());
                if (menVO.getMenPadre()==4)
                {
                MenuItem item= new MenuItem();
                item.setValue(menVO.getMenNombre());
                item.setUrl(menVO.getMenUrl());
                 cuartoSubmenu.getChildren().add(item);
                 }
                }
            
            
            //quinto submenu
            Submenu quintoSubmenu = new Submenu();           
            quintoSubmenu.setLabel("VALORIZACIONES ");  

            for (int i=0;i<listaRolOpciones.size();i++){ 
                 menVO=menServiceImpl.get(listaRolOpciones.get(i).getMenId());
                if (menVO.getMenPadre()==5)
                {
                MenuItem item= new MenuItem();
                item.setValue(menVO.getMenNombre());
                item.setUrl(menVO.getMenUrl());
                 quintoSubmenu.getChildren().add(item);
                 }
                } 



  
            
            model.addSubmenu(primersubmenu);
            model.addSubmenu(segundoSubmenu);
            model.addSubmenu(tercerSubmenu);
            model.addSubmenu(cuartoSubmenu);
            model.addSubmenu(quintoSubmenu);  
            usuarioLogueado=Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        }
        
    public void llego(){
        System.out.println("llego al metodo");
        }
    
    public void prueba(){
            faceContext=FacesContext.getCurrentInstance();
            httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
            HttpSession session = httpServletRequest.getSession();
        }
    
    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setFaceContext(FacesContext faceContext) {
        this.faceContext = faceContext;
    }

    public FacesContext getFaceContext() {
        return faceContext;
    }
    public void setListaRolOpciones(List<RolOpcionesVO> listaRolOpciones) {
        this.listaRolOpciones = listaRolOpciones;
    }

    public List<RolOpcionesVO> getListaRolOpciones() {
        return listaRolOpciones;
    }

    public void setListaUsuarios(List<UsuarioVO> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<UsuarioVO> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public int getPadre() {
        return padre;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public MenuModel getModel() {
        return model;
    }


    public void setRolOpcionesServiceImpl(RolOpcionesService rolOpcionesServiceImpl) {
        this.rolOpcionesServiceImpl = rolOpcionesServiceImpl;
    }

    public RolOpcionesService getRolOpcionesServiceImpl() {
        return rolOpcionesServiceImpl;
    }

    public void setListaMenu(List<MenVO> listaMenu) {
        this.listaMenu = listaMenu;
    }

    public List<MenVO> getListaMenu() {
        return listaMenu;
    }

    public void setRolOpcionesVO(RolOpcionesVO rolOpcionesVO) {
        this.rolOpcionesVO = rolOpcionesVO;
    }

    public RolOpcionesVO getRolOpcionesVO() {
        return rolOpcionesVO;
    }

    public void setMenServiceImpl(MenServiceImpl menServiceImpl) {
        this.menServiceImpl = menServiceImpl;
    }

    public MenServiceImpl getMenServiceImpl() {
        return menServiceImpl;
    }

    public void setMenVO(MenVO menVO) {
        this.menVO = menVO;
    }

    public MenVO getMenVO() {
        return menVO;
    }

    public void setUsuarioLogueado(UsuarioVO usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public UsuarioVO getUsuarioLogueado() {
        return usuarioLogueado;
    }
}
