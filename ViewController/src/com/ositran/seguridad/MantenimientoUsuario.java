package com.ositran.seguridad;

import com.ositran.serviceimpl.UsuarioServiceImpl;
import com.ositran.vo.bean.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "backing_mantenimientoUsuario")
@RequestScoped
@Generated(value = "1seguridad/mantenimientoUsuario.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoUsuario {
    @ManagedProperty(value="#{usuarioServiceImpl}")
    private UsuarioServiceImpl usuarioServiceImpl;

    public void setUsuarioServiceImpl(UsuarioServiceImpl UsuarioServiceImpl) {
        this.usuarioServiceImpl = UsuarioServiceImpl;
    }
    
    public UsuarioVO usuarioVO=new UsuarioVO();


    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }

    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }
    
    public List<UsuarioVO> getQuery(){
        List<UsuarioVO> list=this.usuarioServiceImpl.query();
        return list;
    }
    
    public String usuarioIns(){
        this.usuarioServiceImpl.insert(usuarioVO);
        return "/index?faces-redirect=true";
    }
    
    public String usuarioDel(ActionEvent event){
        UIParameter parameter=(UIParameter)event.getComponent().findComponent("id1");
        Integer idUsuario=(Integer)parameter.getValue();
        this.usuarioServiceImpl.delete(idUsuario);
        return "/index?faces-redirect=true";
    }
    
    public String usuarioUpd1(){
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("id2");
        Integer idUsuario=Integer.valueOf(str.toString());
        usuarioVO=this.usuarioServiceImpl.get(idUsuario);
        return "usuarioUpd";
    }
    
    public String usuarioUpd2(){
        this.usuarioServiceImpl.update(usuarioVO);
        return "/index?faces-redirect=true";
    }
}