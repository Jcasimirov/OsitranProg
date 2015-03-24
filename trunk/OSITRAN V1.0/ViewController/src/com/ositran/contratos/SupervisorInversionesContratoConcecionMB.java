package com.ositran.contratos;

import com.ositran.service.SupervisorInversionesService;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.SupervisorInversionesVO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "supervisorContratoConcesionMB")
@ViewScoped
public class SupervisorInversionesContratoConcecionMB {
    private int tipoInfraestructura;
    private String numeroDocumento="";
    private String tipoDocumento="";
    private String nombreJefeArea="";
    private String  contratoConcesion;
    private int tipoInfraestructuraC;
    private String modalidadConcecion;
    private int supervisorSelecionado;
    private List<InfraestructuraTipoVO> listaInfraestructuraTipo=new ArrayList<>();
    private List<SupervisorInversionesVO> listaSupervisor=new ArrayList<>();

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;
    
    @ManagedProperty(value = "#{supervisorInversionesServiceImpl}")
    SupervisorInversionesService supervisorInversionesServiceImpl;
    

    public void cargarListaInfraestructura(){
        try { 
           listaInfraestructuraTipo=infraestructuraTipoServiceImpl.query();
       } catch (Exception e) {
            e.printStackTrace();
        } 
     }
    
    public void cargarListaSupervisorInversiones(){
       
        try { 
            if (tipoInfraestructura!=0){
                    listaSupervisor=supervisorInversionesServiceImpl.buscarCoordinadorInSitu(tipoInfraestructura);
                    
                   
                }
            else {}
            
            
       } catch (Exception e) {
            e.printStackTrace();
        } 
     }
    
    public void cargarDatosSupervisor(){
        
        System.out.println("hola");
        System.out.println(supervisorSelecionado);
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

    public void setListaInfraestructuraTipo(List<InfraestructuraTipoVO> listaInfraestructuraTipo) {
        this.listaInfraestructuraTipo = listaInfraestructuraTipo;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructuraTipo() {
        return listaInfraestructuraTipo;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }


    public void setListaSupervisor(List<SupervisorInversionesVO> listaSupervisor) {
        this.listaSupervisor = listaSupervisor;
    }

    public List<SupervisorInversionesVO> getListaSupervisor() {
        return listaSupervisor;
    }

    public void setSupervisorSelecionado(int supervisorSelecionado) {
        this.supervisorSelecionado = supervisorSelecionado;
    }

    public int getSupervisorSelecionado() {
        return supervisorSelecionado;
    }


    public void setSupervisorInversionesServiceImpl(SupervisorInversionesService supervisorInversionesServiceImpl) {
        this.supervisorInversionesServiceImpl = supervisorInversionesServiceImpl;
    }

    public SupervisorInversionesService getSupervisorInversionesServiceImpl() {
        return supervisorInversionesServiceImpl;
    }

}
