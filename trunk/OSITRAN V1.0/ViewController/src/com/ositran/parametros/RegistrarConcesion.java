package com.ositran.parametros;
import com.ositran.vo.bean.ConcesionVO;
import javax.annotation.Generated;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;

import org.primefaces.component.panelgrid.PanelGrid;

@ManagedBean(name = "backing_ositran_parametros_registrarconcesion_MB")
@RequestScoped
@Generated(value = "1ositran/parametros/registrarconcesion.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class RegistrarConcesion {
    private HtmlForm formConcesion;
    public ConcesionVO concesionVO=new ConcesionVO();
    private PanelGrid panelGridConcesion;
   // @ManagedProperty(value="#{concesionServiceImpl}")

    public void setFormConcesion(HtmlForm formConcesion) {
        this.formConcesion = formConcesion;
    }

    public HtmlForm getFormConcesion() {
        return formConcesion;
    }


    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }


    public void setPanelGridConcesion(PanelGrid panelGridConcesion) {
        this.panelGridConcesion = panelGridConcesion;
    }

    public PanelGrid getPanelGridConcesion() {
        return panelGridConcesion;
    }
}
