package com.ositran;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.password.Password;

@ManagedBean(name = "backing_ositran_logueo")
@RequestScoped
@Generated(value = "1ositran/logueo.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Logueo {
    
    private HtmlForm form1;
        private OutputLabel outputLabel1;
        private CommandButton commandButton1;
        private InputText usuario;
        private Password pass;


    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

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
    
    public String logear() {
            String usu = (String)usuario.getValue();
            String passw = (String)pass.getValue();
            if (usu.equals("admin") && passw.equals("admin")) {
                return "login";
            } else {
                return "error";
            }
        }
}
