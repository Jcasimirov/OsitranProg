package com.ositran.parametros;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.IgvServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.IgvVO;

import java.util.List;
import javax.annotation.Generated;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;
@ManagedBean(name = "backing_ositran_parametros_mantenimientoconcesion")
@RequestScoped
@Generated(value = "1ositran/parametros/mantenimientoconcesion.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoConcesion {
    private HtmlForm formConcesion;


    public void setFormConcesion(HtmlForm formConcesion) {
        this.formConcesion = formConcesion;
    }

    public HtmlForm getFormConcesion() {
        return formConcesion;
    }
    
    @ManagedProperty(value="#{concesionServiceImpl}")
    private ConcesionServiceImpl concesionServiceImpl;
    
    public void setconcesionServiceImpl(ConcesionServiceImpl concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }
    public List<ConcesionVO> getQuery(){
        List<ConcesionVO> list=this.concesionServiceImpl.query();
        return list;
    }
    
    public ConcesionVO concesionVO=new ConcesionVO();


    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }
    
    
    
    
    

}
