package com.ositran;

import java.io.IOException;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

@ManagedBean(name = "backing_index")
@RequestScoped
@Generated(value = "1index.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Index {
    public void redirigir() throws IOException{
        FacesContext context=FacesContext.getCurrentInstance();
        ExternalContext externalContext=context.getExternalContext();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        String redirectPath="/faces/ositran/logueo.xhtml";
        //String redirectPath="/login?faces-redirect=true";
        //String redirectPath="/com/ositran/seguridad/login?faces-redirect=true";
        //String redirectPath="com/ositran/seguridad/usuarioLista?faces-redirect=true";
        externalContext.redirect(servletContext.getContextPath()+redirectPath);
    }    
}
