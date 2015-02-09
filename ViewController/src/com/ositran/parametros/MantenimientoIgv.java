package com.ositran.parametros;

import com.ositran.serviceimpl.IgvServiceImpl;
import com.ositran.vo.bean.IgvVO;

import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.commandbutton.CommandButton;

@ManagedBean(name = "backing_parametros_mantenimientoIgv")
@RequestScoped
@Generated(value = "1parametros/mantenimientoIgv.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoIgv {
    private HtmlForm form1;
    private CommandButton commandButton1;
    private CommandButton commandButtonNuevo;

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }
    
    
    @ManagedProperty(value="#{igvServiceImpl}")
    private IgvServiceImpl igvServiceImpl;

    public void setigvServiceImpl(IgvServiceImpl igvServiceImpl) {
        this.igvServiceImpl = igvServiceImpl;
    }
    
    public IgvVO igvVO=new IgvVO();


    public void setIgvVO(IgvVO igvVO) {
        this.igvVO = igvVO;
    }

    public IgvVO getIgvVO() {
        return igvVO;
    }

    public List<IgvVO> getQuery(){
        List<IgvVO> list=this.igvServiceImpl.query();
        return list;
    }
    
    public String igvIns(){
       
        this.igvServiceImpl.insert(igvVO);
        return "/index?faces-redirect=true";
    }
    
    public String igvDel(ActionEvent event){
        UIParameter parameter=(UIParameter)event.getComponent().findComponent("id1");
        Integer idigv=(Integer)parameter.getValue();
        this.igvServiceImpl.delete(idigv);
        return "/index?faces-redirect=true";
    }
    
    public String igvUpd1(){
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("id2");
        Integer idigv=Integer.valueOf(str.toString());
        igvVO=this.igvServiceImpl.get(idigv);
        return "infraestructuraUpd";
    }
    
    public String igvUpd2(){
        this.igvServiceImpl.update(igvVO);
        return "/index?faces-redirect=true";
    }


    public void setCommandButton1(CommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setCommandButtonNuevo(CommandButton commandButton2) {
        this.commandButtonNuevo = commandButton2;
    }

    public CommandButton getCommandButtonNuevo() {
        return commandButtonNuevo;
    }
}
