package com.ositran.parametros;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;

import org.primefaces.component.commandbutton.CommandButton;

@ManagedBean(name = "backing_ositran_parametros_mantenimientoTipoInfraestructura")
@RequestScoped
@Generated(value = "1ositran/parametros/mantenimientoTipoInfraestructura.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoTipoInfraestructura {
    private HtmlForm form1;
    private CommandButton commandButtonCrear;

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setCommandButtonCrear(CommandButton commandButton2) {
        this.commandButtonCrear = commandButton2;
    }

    public CommandButton getCommandButtonCrear() {
        return commandButtonCrear;
    }
}
