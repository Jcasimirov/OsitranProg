package com.ositran.util;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

@ManagedBean(name = "viewcontroller")
@RequestScoped
public class ViewController {


    public ViewController() {
        super();
    }

    public String redirect(String url) {

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();


        try {
            externalContext.redirect(servletContext.getContextPath() + "/faces/" + url);


        } catch (IOException ioe) {
            throw new FacesException(ioe);

        }
        return null;
    }
}
