package com.ositran.parametros;

import com.ositran.serviceimpl.IgvServiceImpl;
import com.ositran.vo.bean.IgvVO;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "backing_parametros_registrarIgv")
@RequestScoped
@Generated(value = "1parametros/registrarIgv.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class RegistrarIgv {
    private HtmlForm form1;
    public IgvVO igvVO=new IgvVO();
    
    @ManagedProperty(value="#{igvServiceImpl}")
    private IgvServiceImpl igvServiceImpl;

    public void setigvServiceImpl(IgvServiceImpl igvServiceImpl) {
        this.igvServiceImpl = igvServiceImpl;
    }
    
    
    
    
    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setIgvVO(IgvVO igvVO) {
        this.igvVO = igvVO;
    }

    public IgvVO getIgvVO() {
        return igvVO;
    }
    
    
  
    public String igvIns(){
       
        this.igvServiceImpl.insert(igvVO);
        return "listarIgv";
    }


    public void igvIns(ActionEvent actionEvent) {
        // Add event code here...
    }
}
