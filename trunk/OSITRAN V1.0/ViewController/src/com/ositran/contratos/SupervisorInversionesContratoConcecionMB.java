package com.ositran.contratos;

import com.ositran.model.ContratoSupInversiones;
import com.ositran.model.Infraestructura;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.ContratoSubInversionesService;
import com.ositran.service.SupervisorInversionesService;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoSubInversionesServiceImpl;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.TipoDocumentoServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoSubInversionesVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.SupervisorInversionesVO;
import com.ositran.vo.bean.TipoDocumentoVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "supervisorContratoConcesionMB")
@ViewScoped
public class SupervisorInversionesContratoConcecionMB {
    private int codigoSupervisor;
    private int codigoInfraestructura;
    private int tipoInfraestructura;
    private String numeroDocumento="";
    private String tipoDocumento="";
    private int tipoDocumentoI;
    private String nombreSupervisor="";
    private String  contratoConcesion;
    private int tipoInfraestructuraC;
    private String modalidadConcecion;
    private int supervisorSelecionado;
    private int codigoContrato;
    private int codigoConcesion;
    private ContratoSubInversionesVO contratoSupInversionesVO= new ContratoSubInversionesVO();
    private ContratoSupInversiones contratoSupInversiones= new ContratoSupInversiones();
    private ContratoSubInversionesService  contratoSubInversionesServiceImpl=new ContratoSubInversionesServiceImpl();
    private List<InfraestructuraTipoVO> listaInfraestructuraTipo=new ArrayList<>();
    private List<ContratoVO> listaContratos=new ArrayList<>();
   private  Infraestructura infraestructura = new Infraestructura();
    private  InfraestructuraVO infraestructuraVO = new InfraestructuraVO();
   private InfraestructuraServiceImpl infraestructuraServiceImpl= new InfraestructuraServiceImpl();
    
    private ContratoConcesionServiceImpl  contratoServicesImpl=new ContratoConcesionServiceImpl();
    ConcesionServiceImpl concesionServiceImpl=new ConcesionServiceImpl();
    
    private List<SupervisorInversionesVO> listaSupervisor=new ArrayList<>();
    TipoDocumentoVO tipDoc=new TipoDocumentoVO();
    
    TipoDocumentoServiceImpl tipoDocumentoServicesIm=new TipoDocumentoServiceImpl();

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
            
            for (InfraestructuraTipoVO infraestructuraTipoVO: listaInfraestructuraTipo){
                if(infraestructuraTipoVO.getTinId()==tipoInfraestructura){
                    codigoInfraestructura=infraestructuraTipoVO.getTinId();
                    
                    
                    }
                
                }
            
            
            if (tipoInfraestructura!=0){
            listaSupervisor=supervisorInversionesServiceImpl.buscarCoordinadorInSitu(tipoInfraestructura);   
               
                }
            else {
                
                }
       } catch (Exception e) {
            e.printStackTrace();
        } 
     }
    
    public void cargarDatosSupervisor(){
        try {
            if (supervisorSelecionado!=0){
               
            listaSupervisor=supervisorInversionesServiceImpl.buscarCoordinadorInSitu(tipoInfraestructura);
                   
            for (SupervisorInversionesVO supervisor: listaSupervisor){                
                if (supervisor.getTsiId()==supervisorSelecionado){
                    nombreSupervisor=supervisor.getTsiNombre();
                    codigoSupervisor=supervisor.getTsiId();
                    tipoDocumentoI=supervisor.getTdoId();
                    tipDoc=tipoDocumentoServicesIm.get(tipoDocumentoI);
                    tipoDocumento=tipDoc.getTdoNombre();
                    numeroDocumento=supervisor.getTsiNroDocumento();  
                    
                    }
                
                }

                }
            else {
                    nombreSupervisor="";
                    tipoDocumento="";
                    numeroDocumento="";  
                }
            
       } catch (Exception e) {
            e.printStackTrace();
        }
        }

    public void cargarListaContratos(){
        try {
           listaContratos=contratoServicesImpl.query();
            for (ContratoVO contra: listaContratos){ 
                ConcesionVO concesion=new ConcesionVO();
                concesion=concesionServiceImpl.get(contra.getCsiId());
                contra.setNombreConcesion(concesion.getCsiNombre()); 
                codigoContrato = contra.getConId();
                infraestructuraVO=infraestructuraServiceImpl.get2(concesion.getTinId());
                tipoInfraestructura=infraestructuraVO.getTinId();
                codigoConcesion=infraestructuraVO.getCsiId();
                codigoInfraestructura=infraestructuraVO.getInfId();
                }
       } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        
        }
    
    public void elegirContrato(ContratoVO contrato1){
        contratoConcesion=contrato1.getNombreConcesion();
        tipoInfraestructuraC=contrato1.getTinId();
        modalidadConcecion="Modalidad1";
            
        }
    
    public void registrarContrato() {
        try {
         
            contratoSupInversionesVO.setTinId(tipoInfraestructura);  
            contratoSupInversionesVO.setTsiId(codigoSupervisor);
            contratoSupInversionesVO.setConId(codigoContrato);
            contratoSupInversionesVO.setCsiId(codigoConcesion);
            contratoSupInversionesVO.setSivEstado(1);
            contratoSupInversionesVO.setInfId(codigoInfraestructura);
            contratoSupInversionesVO.setTdoId(1);
            contratoSupInversionesVO.setSivFechaInicial(new Date());
            contratoSupInversionesVO.setSivNombre(nombreSupervisor);
            contratoSubInversionesServiceImpl.insert(contratoSupInversionesVO);
            
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro con Exito");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);

        } catch (Exception e) {
            System.out.println("SE CALLO EN EL METODO REGISTRAR CONTRATO");
            e.printStackTrace();
        }
    
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


    public void setNombreSupervisor(String nombreSupervisor) {
        this.nombreSupervisor = nombreSupervisor;
    }

    public String getNombreSupervisor() {
        return nombreSupervisor;
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


    public void setTipoDocumentoI(int tipoDocumentoI) {
        this.tipoDocumentoI = tipoDocumentoI;
    }

    public int getTipoDocumentoI() {
        return tipoDocumentoI;
    }


    public void setTipDoc(TipoDocumentoVO tipDoc) {
        this.tipDoc = tipDoc;
    }

    public TipoDocumentoVO getTipDoc() {
        return tipDoc;
    }

    public void setListaContratos(List<ContratoVO> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<ContratoVO> getListaContratos() {
        return listaContratos;
    }

    public void setTipoDocumentoServicesIm(TipoDocumentoServiceImpl tipoDocumentoServicesIm) {
        this.tipoDocumentoServicesIm = tipoDocumentoServicesIm;
    }

    public TipoDocumentoServiceImpl getTipoDocumentoServicesIm() {
        return tipoDocumentoServicesIm;
    }


    public void setContratoSupInversiones(ContratoSupInversiones contratoSupInversiones) {
        this.contratoSupInversiones = contratoSupInversiones;
    }

    public ContratoSupInversiones getContratoSupInversiones() {
        return contratoSupInversiones;
    }

    public void setContratoServicesImpl(ContratoConcesionServiceImpl contratoServicesImpl) {
        this.contratoServicesImpl = contratoServicesImpl;
    }

    public ContratoConcesionServiceImpl getContratoServicesImpl() {
        return contratoServicesImpl;
    }

    public void setConcesionServiceImpl(ConcesionServiceImpl concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public ConcesionServiceImpl getConcesionServiceImpl() {
        return concesionServiceImpl;
    }


    public void setContratoSupInversionesVO(ContratoSubInversionesVO contratoSupInversionesVO) {
        this.contratoSupInversionesVO = contratoSupInversionesVO;
    }

    public ContratoSubInversionesVO getContratoSupInversionesVO() {
        return contratoSupInversionesVO;
    }


    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoConcesion(int codigoConcesion) {
        this.codigoConcesion = codigoConcesion;
    }

    public int getCodigoConcesion() {
        return codigoConcesion;
    }

    public void setCodigoSupervisor(int codigoSupervisor) {
        this.codigoSupervisor = codigoSupervisor;
    }

    public int getCodigoSupervisor() {
        return codigoSupervisor;
    }

    public void setContratoSubInversionesServiceImpl(ContratoSubInversionesService contratoSubInversionesServiceImpl) {
        this.contratoSubInversionesServiceImpl = contratoSubInversionesServiceImpl;
    }

    public ContratoSubInversionesService getContratoSubInversionesServiceImpl() {
        return contratoSubInversionesServiceImpl;
    }


    public void setCodigoInfraestructura(int codigoInfraestructura) {
        this.codigoInfraestructura = codigoInfraestructura;
    }

    public int getCodigoInfraestructura() {
        return codigoInfraestructura;
    }


    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }

    public Infraestructura getInfraestructura() {
        return infraestructura;
    }


    public void setInfraestructuraVO(InfraestructuraVO infraestructuraVO) {
        this.infraestructuraVO = infraestructuraVO;
    }

    public InfraestructuraVO getInfraestructuraVO() {
        return infraestructuraVO;
    }

    public void setInfraestructuraServiceImpl(InfraestructuraServiceImpl infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public InfraestructuraServiceImpl getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }
}
