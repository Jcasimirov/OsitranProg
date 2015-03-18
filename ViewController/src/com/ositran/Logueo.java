package com.ositran;

import com.ositran.service.UsuarioService;
import com.ositran.serviceimpl.UsuarioServiceImpl;
import com.ositran.vo.bean.MenVO;

import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

@ManagedBean(name = "loginMB")
@RequestScoped
//@Generated(value = "1ositran/logueo.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Logueo {
    
    private List<UsuarioVO> listaUsuario= new ArrayList<>();
    private String susuario;
    private String password;
    @ManagedProperty(value = "#{usuarioServiceImpl}")
    UsuarioService usuarioServiceImpl;
    private String usuario;
    private String contrasenha;
    private  boolean validar=false;


    public void logear() {
        try {
            
           
           FacesContext context = FacesContext.getCurrentInstance();
           ExternalContext externalContext = context.getExternalContext();
           ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
           
            
           listaUsuario=usuarioServiceImpl.query();
            
            for(UsuarioVO usua: listaUsuario){
                if (usuario.equals(usua.getUsuAlias())){
                    validar=true;
                    password=usua.getUsuContrasenya();
                    }
                }
            System.out.println(validar);
            if (validar==false){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                                  "El usuario ingresado no existe"));
                }
            else if (validar==true && contrasenha.equals(password)){
                    String redirectPath = "/faces/ositran/principal.xhtml";
                    externalContext.redirect(servletContext.getContextPath() + redirectPath);
                }
            else {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                                  "Error en la contraseña"));
                }
            
           
           /*
           if (usu.equals("admin") && passw.equals("admin")) {
               String redirectPath = "/faces/ositran/principal.xhtml";
               externalContext.redirect(servletContext.getContextPath() + redirectPath);
           }
           else         if (usu.equals("") && passw.equals("")) {
               FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                             "Debe ingresar un Usuario y una Contraseña"));
           }
           else         if (usu.equals("")) {
               FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                             "Debe ingresar un Usuario"));
           }
           else         if (passw.equals("")) {
               FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                             "Debe ingresar una contraseña"));
           }
           else {
               String redirectPath = "/faces/error.xhtml";
               externalContext.redirect(servletContext.getContextPath() + redirectPath);
           }*/
       } catch (Exception e) {
            System.out.println("No pudo completar le logeo con exito");
            e.printStackTrace();
        } 

    }


    public void setListaUsuario(List<UsuarioVO> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<UsuarioVO> getListaUsuario() {
        return listaUsuario;
    }


    public void setSusuario(String susuario) {
        this.susuario = susuario;
    }

    public String getSusuario() {
        return susuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuarioServiceImpl(UsuarioService usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    public UsuarioService getUsuarioServiceImpl() {
        return usuarioServiceImpl;
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

}
