package com.ositran;

import java.io.IOException;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;

import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.password.Password;

@ManagedBean(name = "loginMB")
@RequestScoped
@Generated(value = "1ositran/logueo.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Logueo {
    

        private OutputLabel outputLabel1;
        private CommandButton commandButton1;
        private InputText usuario;
        private Password pass;
    private HtmlGraphicImage graphicImage1;


  

    public void setOutputLabel1(OutputLabel outputLabel1) {
        this.outputLabel1 = outputLabel1;
    }

    public OutputLabel getOutputLabel1() {
        return outputLabel1;
    }

    public void setCommandButton1(CommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setUsuario(InputText usuario) {
        this.usuario = usuario;
    }

    public InputText getUsuario() {
        return usuario;
    }

    public void setPass(Password pass) {
        this.pass = pass;
    }

    public Password getPass() {
        return pass;
    }
    
    public void logear() throws IOException{
            String usu = (String)usuario.getValue();
            String passw = (String)pass.getValue();
            FacesContext context=FacesContext.getCurrentInstance();
            ExternalContext externalContext=context.getExternalContext();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            if (usu.equals("admin") && passw.equals("admin")) {
                String redirectPath="/faces/ositran/principal.xhtml";
                externalContext.redirect(servletContext.getContextPath()+redirectPath);
            } else {
                String redirectPath="/faces/error.jsf";
                externalContext.redirect(servletContext.getContextPath()+redirectPath);
            }
        }

    public void setGraphicImage1(HtmlGraphicImage graphicImage1) {
        this.graphicImage1 = graphicImage1;
    }

    public HtmlGraphicImage getGraphicImage1() {
        return graphicImage1;
    }
}
