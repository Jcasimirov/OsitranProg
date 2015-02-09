package com.ositran.parametros;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;

@ManagedBean(name = "backing_parametros_mantenimientoEmpresaSupervisora")
@RequestScoped
@Generated(value = "1parametros/mantenimientoEmpresaSupervisora.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoEmpresaSupervisora {
    private HtmlForm form1;

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }
}
