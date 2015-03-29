package com.ositran.valorizaciones;
import com.ositran.serviceimpl.MonedaServiceImpl;
import com.ositran.vo.bean.InfraestructuraVO;

import com.ositran.vo.bean.MonedaVO;


import java.util.List;

import javax.annotation.Generated;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "registrarAvanceInversionWebMB")
@ViewScoped
public class RegistrarAvanceInversionWeb {
    // -------------------------INICIO VOO CARRITO VER CLASE InfraestructuraVO--------------------------------------/
    private InfraestructuraVO infraestructura;
    private List<InfraestructuraVO> infraestructuras;
    private List<MonedaVO> listMoneda;
  
    @ManagedProperty(value = "#{monedaServiceImpl}")
    private MonedaServiceImpl monedaServiceImpl;


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
    
    
    public void cargarListaTipoMoneda(){
        
         try {
            listMoneda = getMonedaServiceImpl().query();
             
            } catch (Exception e) {
                e.printStackTrace();
             }
    }





    public MonedaServiceImpl getMonedaServiceImpl() {
        return monedaServiceImpl;
    }

    public void setMonedaService(MonedaServiceImpl monedaServiceImpl) {
        this.setMonedaServiceImpl(monedaServiceImpl);
    }

    public List<MonedaVO> getListMoneda() {
        return listMoneda;
    }

    public void setListMoneda(List<MonedaVO> listMoneda) {
        this.listMoneda = listMoneda;
    }

    public void setMonedaServiceImpl(MonedaServiceImpl monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }
}
