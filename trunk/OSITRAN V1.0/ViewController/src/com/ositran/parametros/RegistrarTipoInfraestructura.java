package com.ositran.parametros;

import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;

import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "backing_ositran_parametros_registrarTipoInfraestructura")
@RequestScoped
@Generated(value = "1ositran/parametros/registrarTipoInfraestructura.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class RegistrarTipoInfraestructura {
    @ManagedProperty(value="#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;

    public void setinfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }
    
    public InfraestructuraTipoVO infraestructuraTipoVO=new InfraestructuraTipoVO();


    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    public List<InfraestructuraTipoVO> getQuery() throws SQLException{
        List<InfraestructuraTipoVO> list=this.infraestructuraTipoServiceImpl.query();
        return list;
    }
    
    public void infraestructuraTipoIns() throws SQLException{
        this.infraestructuraTipoServiceImpl.insert(infraestructuraTipoVO);
           
        /*   System.out.println("id = "+infraestructuraTipoVO.getTinId());
        System.out.println("Nombre = "+infraestructuraTipoVO.getTinNombre());
        System.out.println("Descripcion = "+infraestructuraTipoVO.getTinDescripcion());
        System.out.println("infraestructuraTipoVO: "+infraestructuraTipoVO);
        System.out.println("infraestructuraTipoServiceImpl ="+infraestructuraTipoServiceImpl);
        this.infraestructuraTipoServiceImpl.insert(infraestructuraTipoVO);
        return "/index?faces-redirect=true"; */
    }
    
    public String infraestructuraTipoDel(ActionEvent event) throws SQLException{
        UIParameter parameter=(UIParameter)event.getComponent().findComponent("id1");
        Integer idinfraestructuraTipo=(Integer)parameter.getValue();
        this.infraestructuraTipoServiceImpl.delete(idinfraestructuraTipo);
        return "/index?faces-redirect=true";
    }
    
    public String infraestructuraTipoUpd1() throws SQLException{
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("id2");
        Integer idinfraestructuraTipo=Integer.valueOf(str.toString());
        infraestructuraTipoVO=this.infraestructuraTipoServiceImpl.get(idinfraestructuraTipo);
        return "infraestructuraUpd";
    }
    
    public String infraestructuraTipoUpd2() throws SQLException{
        this.infraestructuraTipoServiceImpl.update(infraestructuraTipoVO);
        return "/index?faces-redirect=true";
    }
}
