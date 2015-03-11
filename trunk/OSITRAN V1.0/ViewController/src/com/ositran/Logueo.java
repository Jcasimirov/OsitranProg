package com.ositran;

import java.io.IOException;

import java.sql.SQLException;

import javax.annotation.Generated;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

@ManagedBean(name = "loginMB")
@RequestScoped
@Generated(value = "1ositran/logueo.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Logueo {

    private InputText usuario;
    private Password contrasenha;

    public void setUsuario(InputText usuario) {
        this.usuario = usuario;
    }

    public InputText getUsuario() {
        return usuario;
    }


    public void setContrasenha(Password contrasenha) {
        this.contrasenha = contrasenha;
    }

    public Password getContrasenha() {
        return contrasenha;
    }

    public void logear() throws IOException {
        String usu = (String) usuario.getValue();
        String passw = (String) contrasenha.getValue();
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();

        
        
        
       
        
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
        }


    }


}
