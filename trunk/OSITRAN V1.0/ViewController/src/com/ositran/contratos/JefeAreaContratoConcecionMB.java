package com.ositran.contratos;

import com.ositran.model.Infraestructura;

import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.JefeAreaContratoConcecionServiceImpl;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.JefeAreaContratoConcecionVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "jefeAreaContratoConcecionMB")
@RequestScoped
@ViewScoped
public class JefeAreaContratoConcecionMB {
    private int tipoInfraestructura;
    private String numeroDocumento="";
    private String tipoDocumento="";
    private String nombreJefeArea="";
    private String  contratoConcesion;
    private int tipoInfraestructuraC;
    private String modalidadConcecion;
    
    
    
    
    private List<InfraestructuraTipoVO> listaInfraestructuraTipo=new ArrayList<>();
    private List<JefeAreaContratoConcecionVO> listaJefeArea=new ArrayList<>();
    
    @ManagedProperty(value = "#{jefeAreaContratoConcecionServiceImpl}")
    JefeAreaContratoConcecionServiceImpl jefeAreaContratoConcecionServiceImpl;
    
    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;
    
    @ManagedProperty(value = "#{jefeAreaContratoConcecionVO}")
    JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO;
   
   
   
    public void cargarListaInfraestructura(){
        try {
            
            
           listaInfraestructuraTipo=infraestructuraTipoServiceImpl.query();
       } catch (Exception e) {
            e.printStackTrace();
        }
          
        }
    
    public void cargarJefeAreaContratoConcesion(){
        try {
            
            if (tipoInfraestructura!=0){
            jefeAreaContratoConcecionVO =jefeAreaContratoConcecionServiceImpl.get(tipoInfraestructura);
            nombreJefeArea=jefeAreaContratoConcecionVO.getSjaNombre();
            tipoDocumento=jefeAreaContratoConcecionVO.getSjaTipoDocumento();
            numeroDocumento=jefeAreaContratoConcecionVO.getSjaNumeroDocumento();
            }
            
            else {
                    nombreJefeArea="";
                    tipoDocumento="";
                    numeroDocumento="";
                }
       } catch (Exception e) {
            e.printStackTrace();
        }
     
        }





    public void setListaInfraestructuraTipo(List<InfraestructuraTipoVO> listaInfraestructuraTipo) {
        this.listaInfraestructuraTipo = listaInfraestructuraTipo;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructuraTipo() {
        return listaInfraestructuraTipo;
    }

    public void setJefeAreaContratoConcecionServiceImpl(JefeAreaContratoConcecionServiceImpl jefeAreaContratoConcecionServiceImpl) {
        this.jefeAreaContratoConcecionServiceImpl = jefeAreaContratoConcecionServiceImpl;
    }

    public JefeAreaContratoConcecionServiceImpl getJefeAreaContratoConcecionServiceImpl() {
        return jefeAreaContratoConcecionServiceImpl;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void setJefeAreaContratoConcecionVO(JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO) {
        this.jefeAreaContratoConcecionVO = jefeAreaContratoConcecionVO;
    }

    public JefeAreaContratoConcecionVO getJefeAreaContratoConcecionVO() {
        return jefeAreaContratoConcecionVO;
    }

    public void setTipoInfraestructura(int tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public int getTipoInfraestructura() {
        return tipoInfraestructura;
    }


    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setNombreJefeArea(String nombreJefeArea) {
        this.nombreJefeArea = nombreJefeArea;
    }

    public String getNombreJefeArea() {
        return nombreJefeArea;
    }


    public void setListaJefeArea(List<JefeAreaContratoConcecionVO> listaJefeArea) {
        this.listaJefeArea = listaJefeArea;
    }

    public List<JefeAreaContratoConcecionVO> getListaJefeArea() {
        return listaJefeArea;
    }


    public void setContratoConcesion(String contratoConcesion) {
        this.contratoConcesion = contratoConcesion;
    }

    public String getContratoConcesion() {
        return contratoConcesion;
    }

    public void setTipoInfraestructuraC(int tipoInfraestructuraC) {
        this.tipoInfraestructuraC = tipoInfraestructuraC;
    }

    public int getTipoInfraestructuraC() {
        return tipoInfraestructuraC;
    }

    public void setModalidadConcecion(String modalidadConcecion) {
        this.modalidadConcecion = modalidadConcecion;
    }

    public String getModalidadConcecion() {
        return modalidadConcecion;
    }
}
