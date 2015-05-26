package com.ositran;

import com.ositran.service.RolOpcionesService;
import com.ositran.service.SupervisorInversionesService;
import com.ositran.service.UsuarioService;
import com.ositran.util.ControlAcceso;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "loginMB")
@RequestScoped
public class Logueo {
    
    private  HttpServletRequest httpServletRequest=null;
    private  FacesContext faceContext=null;
    private List<UsuarioVO> listaUsuario= new ArrayList<UsuarioVO>();
    private List<RolOpcionesVO> listaRolOpciones=new ArrayList<RolOpcionesVO>();
    private String password;
    private int codigoRol;
    private String usuario;
    private String contrasenha;
    private  boolean validar=false;
    
    @ManagedProperty(value = "#{usuarioServiceImpl}")
    UsuarioService usuarioServiceImpl;
    @ManagedProperty(value = "#{rolOpcionesServiceImpl}")
    RolOpcionesService rolOpcionesServiceImpl;
    @ManagedProperty(value = "#{supervisorInversionesServiceImpl}")
    SupervisorInversionesService supervisorInversionesServiceImpl;
    

    public void logear() {
        int codusuario=0;
        try {
           FacesContext context = FacesContext.getCurrentInstance();
           ExternalContext externalContext = context.getExternalContext();
           ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
           listaUsuario=usuarioServiceImpl.query();
            for(UsuarioVO usua: listaUsuario){
                if (usuario.equals(usua.getUsuAlias())){
                    validar=true;
                    password=usua.getUsuContrasenya();
                    codigoRol=usua.getRolId();
                    listaRolOpciones=rolOpcionesServiceImpl.query1(codigoRol);
                    codusuario=usua.getUsuId();}
                }
           
            if (validar==false){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                                  "El usuario ingresado no existe"));
                }
            else if (validar==true && contrasenha.equals(password)){
                   
                   UsuarioVO  usuario=usuarioServiceImpl.get(codusuario);
                    faceContext=FacesContext.getCurrentInstance();
                    httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
                    HttpSession session = httpServletRequest.getSession();
                    session.setAttribute("UsuarioSesion", usuario);
                    session.setAttribute("PassSesion", contrasenha);
                    session.setAttribute("listaPermisos", listaRolOpciones);
                    session.setAttribute("listaUsuario", listaUsuario);
                    session.setAttribute("atributosUsuario", usuario);
                    //session.setAttribute("atributosEmpleado", supervisorInversionesServiceImpl.getSupervisorInversiones(usuario.getSupInvId()));                   
                     String redirectPath = "/faces/ositran/principal.xhtml";
                     externalContext.redirect(servletContext.getContextPath() + redirectPath);
                }
            else {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                                  "Error en la contraseña"));
                }
            
           
       } catch (Exception e) {
            System.out.println("No pudo completar le logeo con exito");
            e.printStackTrace();
        } 
        

    }

    public void logout(){
        try {
            ControlAcceso.getNewInstance().logoutSesionInvalidate();
        } catch (IOException ioe) {
            // TODO: Add catch code
            ioe.printStackTrace();
        }
    }
    
    


    public void setListaUsuario(List<UsuarioVO> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<UsuarioVO> getListaUsuario() {
        return listaUsuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setValidar(boolean validar) {
        this.validar = validar;
    }

    public boolean isValidar() {
        return validar;
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


    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    public int getCodigoRol() {
        return codigoRol;
    }


    public void setListaRolOpciones(List<RolOpcionesVO> listaRolOpciones) {
        this.listaRolOpciones = listaRolOpciones;
    }

    public List<RolOpcionesVO> getListaRolOpciones() {
        return listaRolOpciones;
    }


    public void setRolOpcionesServiceImpl(RolOpcionesService rolOpcionesServiceImpl) {
        this.rolOpcionesServiceImpl = rolOpcionesServiceImpl;
    }

    public RolOpcionesService getRolOpcionesServiceImpl() {
        return rolOpcionesServiceImpl;
    }


    public void setUsuarioServiceImpl(UsuarioService usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    public UsuarioService getUsuarioServiceImpl() {
        return usuarioServiceImpl;
    }

    public void setSupervisorInversionesServiceImpl(SupervisorInversionesService supervisorInversionesServiceImpl) {
        this.supervisorInversionesServiceImpl = supervisorInversionesServiceImpl;
    }

    public SupervisorInversionesService getSupervisorInversionesServiceImpl() {
        return supervisorInversionesServiceImpl;
    }
}
