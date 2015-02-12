package com.ositran.parametros;

import com.ositran.serviceimpl.IgvServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.IgvVO;

import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.util.List;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;

import javax.faces.event.ActionEvent;

import org.primefaces.component.commandbutton.CommandButton;

@ManagedBean(name = "backing_ositran_parametros_mantenimientoTipoInfraestructura")
@RequestScoped
@Generated(value = "1ositran/parametros/mantenimientoTipoInfraestructura.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoTipoInfraestructura {
    private HtmlForm form1;
    private CommandButton commandButtonCrear;
    
    
    @ManagedProperty(value="#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;


    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

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
    
    public List<InfraestructuraTipoVO> getQuery(){
        List<InfraestructuraTipoVO> list=this.infraestructuraTipoServiceImpl.query();
        return list;
    }
  
   
 
    
}
