package com.ositran.parametros;

import com.ositran.serviceimpl.ConcesionarioServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "backing_ositran_parametros_mantenimientoConcesionario")
@RequestScoped
@Generated(value = "1ositran/parametros/mantenimientoConcesionario.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoConcesionario {

    @ManagedProperty(value="#{concesionarioServiceImpl}")
    private ConcesionarioServiceImpl concesionarioServiceImpl;
    public ConcesionarioVO concesionarioVO=new ConcesionarioVO();

    public void setConcesionarioServiceImpl(ConcesionarioServiceImpl concesionarioServiceImpl) {
        this.concesionarioServiceImpl = concesionarioServiceImpl;
    }

    public void setConcesionarioVO(ConcesionarioVO concesionarioVO) {
        this.concesionarioVO = concesionarioVO;
    }

    public ConcesionarioVO getConcesionarioVO() {
        return concesionarioVO;
    }


    public List<ConcesionarioVO> getQuery(){
        List<ConcesionarioVO> list=this.concesionarioServiceImpl.query();
        return list;
    }
    
    public String concesionarioIns(){
        this.concesionarioServiceImpl.insert(concesionarioVO);
        return "/index?faces-redirect=true";
    }
    
    public String concesionarioDel(ActionEvent event){
        UIParameter parameter=(UIParameter)event.getComponent().findComponent("id1");
        Integer idConcesionario=(Integer)parameter.getValue();
        this.concesionarioServiceImpl.delete(idConcesionario);
        return "/index?faces-redirect=true";
    }
    
    public String concesionarioUpd1(){
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("id2");
        Integer idConcesionario=Integer.valueOf(str.toString());
        concesionarioVO=this.concesionarioServiceImpl.get(idConcesionario);
        return "infraestructuraUpd";
    }
    
    public String concesionarioUpd2(){
        this.concesionarioServiceImpl.update(concesionarioVO);
        return "/index?faces-redirect=true";
    }    
}
