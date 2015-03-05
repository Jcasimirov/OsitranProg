package com.ositran.valorizaciones;

import com.ositran.vo.bean.InfraestructuraVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "backing_ositran_valorizaciones_registrarAvanceInversionWeb")
@RequestScoped
@Generated(value = "1ositran/valorizaciones/registrarAvanceInversionWeb.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class RegistrarAvanceInversionWeb {
    // -------------------------INICIO VOO CARRITO VER CLASE InfraestructuraVO--------------------------------------/
    private InfraestructuraVO infraestructura;
    private List<InfraestructuraVO> infraestructuras;

    @PostConstruct // INICIO CONSTRUCTOR VOO CARRITO VER CLASE InfraestructuraVO
    public void init() {
        infraestructura = new InfraestructuraVO();
        infraestructuras = new ArrayList<InfraestructuraVO>();
       
    }
    
    public String reinit() {        
        infraestructura = new InfraestructuraVO();
        return null;
    }


    public void setInfraestructura(InfraestructuraVO infraestructura) {
        this.infraestructura = infraestructura;
    }

    public InfraestructuraVO getInfraestructura() {
        return infraestructura;
    }

    public void setInfraestructuras(List<InfraestructuraVO> infraestructuras) {
        this.infraestructuras = infraestructuras;
    }

    public List<InfraestructuraVO> getInfraestructuras() {
        return infraestructuras;
    }

}
