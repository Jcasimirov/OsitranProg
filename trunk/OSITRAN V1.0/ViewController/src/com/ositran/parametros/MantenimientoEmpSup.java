package com.ositran.parametros;

import com.ositran.model.EmpresaSupervisora;
import com.ositran.serviceimpl.EmpresaSupervisoraServiceImpl;

import com.ositran.vo.bean.EmpresaSupervisoraVO;


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

@ManagedBean(name = "backing_ositran_parametros_MantenimientoEmpSup")
@RequestScoped
@Generated(value = "1ositran/parametros/MantenimientoEmpSup.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoEmpSup {
    private HtmlForm form1;

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }
    
    @ManagedProperty(value="#{empSupServiceImp}")
    private EmpresaSupervisoraServiceImpl empSupServiceImp;
    
    public EmpresaSupervisoraVO empSupVO;

    public void setEmpSupServiceImp(EmpresaSupervisoraServiceImpl empSupServiceImp) {
        this.empSupServiceImp = empSupServiceImp;
    }

    public EmpresaSupervisoraServiceImpl getEmpSupServiceImp() {
        return empSupServiceImp;
    }


    public void setEmpSupVO(EmpresaSupervisoraVO empSupVO) {
        this.empSupVO = empSupVO;
    }

    public EmpresaSupervisoraVO getEmpSupVO() {
        return empSupVO;
    }
    
    public List<EmpresaSupervisoraVO> getQuery(){
        List<EmpresaSupervisoraVO> list=this.empSupServiceImp.query();        
        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+list.size());
        return list; 
    }
    
    public String EmpSupDel(ActionEvent event){
        UIParameter parameter=(UIParameter)event.getComponent().findComponent("id1");
        Integer idEmpSup=(Integer)parameter.getValue();
        this.empSupServiceImp.delete(idEmpSup);
        return "/index?faces-redirect=true";
    }
    
    public String EmpSupUpd1(){
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("id2");
        Integer idEmpSup=Integer.valueOf(str.toString());
        empSupVO=this.empSupServiceImp.get(idEmpSup);
        return "/index?faces-redirect=true";
    }
    
    public String EmpSupUpd2(){
        this.empSupServiceImp.update(empSupVO);
        return "/index?faces-redirect=true";
    }

}
