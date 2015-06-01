    package com.ositran.contratos;

import com.ositran.model.ContratoSupInversiones;
import com.ositran.model.Infraestructura;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.ContratoSubInversionesService;
import com.ositran.service.InfraestructuraService;
import com.ositran.service.ModalidadConcesionService;
import com.ositran.service.SupervisorInversionesService;
import com.ositran.service.TipoDocumentoService;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.SupervisorInversionesServiceImpl;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoSubInversionesVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
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
    private String tipoInfraestructuraS;
    private String tipoDocumento="";
    private int tipoDocumentoI;
    private String nombreSupervisor="";
    private String  contratoConcesion;
    private int tipoInfraestructuraC;
    private int tipoInfraestructuraF;
    private String modalidadConcecion;
    private int supervisorSelecionado;
    private int codigoContrato;
    private int codigoConcesion;
    private int codigoContratoP;
    private ContratoSubInversionesVO contratoSupInversionesVO= new ContratoSubInversionesVO();
    private ContratoSupInversiones contratoSupInversiones= new ContratoSupInversiones();
    private List<InfraestructuraTipoVO> listaInfraestructuraTipo=new ArrayList<InfraestructuraTipoVO>();
    private List<ContratoVO> listaContratos=new ArrayList<ContratoVO>();
    private List<SupervisorInversionesVO> listaSupervisor=new ArrayList<SupervisorInversionesVO>();
    private List<ContratoSubInversionesVO> listaContratoSupervisor = new ArrayList<ContratoSubInversionesVO>();
    private  Infraestructura infraestructura = new Infraestructura();
    
    @ManagedProperty(value = "#{contratoSubInversionesServiceImpl}")
    ContratoSubInversionesService contratoSubInversionesServiceImpl;
    
    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    InfraestructuraService infraestructuraServiceImpl;
    
    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionService contratoConcesionServiceImp;
    
    @ManagedProperty(value = "#{infraestructuraVO}")
    InfraestructuraVO infraestructuraVO;
    
    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionService concesionServiceImpl;
    
    @ManagedProperty(value = "#{tipoDocumentoVO}")
    TipoDocumentoVO tipoDocumentoVO;
    
    @ManagedProperty(value = "#{tipoDocumentoServiceImp}")
    TipoDocumentoService tipoDocumentoServiceImp;
    
    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;
    
    @ManagedProperty(value = "#{supervisorInversionesServiceImpl}")
    SupervisorInversionesService supervisorInversionesServiceImpl;
    
    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    InfraestructuraTipoVO infraestructuraTipoVO;
    
    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionService modalidadServiceImp;
    
    @ManagedProperty(value = "#{concesionVO}")
    ConcesionVO concesionVO;
    
    ModalidadConcesionVO modalidadConcesionVO=new ModalidadConcesionVO();
    

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
            
            listaSupervisor=supervisorInversionesServiceImpl.buscarSupervisoresxInfraestructura(tipoInfraestructura); 
        
               
                }
            else {
                   
                }
            
            limpiarCasiTodo();
       } catch (Exception e) {
            e.printStackTrace();
        } 
     }
    
    public void cargarDatosSupervisor(){
        try {
            if (supervisorSelecionado!=0){
            listaSupervisor=supervisorInversionesServiceImpl.buscarSupervisoresxInfraestructura(tipoInfraestructura);  
            for (SupervisorInversionesVO supervisor: listaSupervisor){                
                if (supervisor.getTsiId()==supervisorSelecionado){
                    nombreSupervisor=supervisor.getTsiNombre();
                    codigoSupervisor=supervisor.getTsiId();
                    tipoDocumentoI=supervisor.getTdoId();
                    tipoDocumentoVO=tipoDocumentoServiceImp.get(tipoDocumentoI);
                    tipoDocumento=tipoDocumentoVO.getTdoNombre();
                    numeroDocumento=supervisor.getTsiNroDocumento();  
                    
                    }
                }

                }
            else {
                    nombreSupervisor="";
                    tipoDocumento="";
                    numeroDocumento="";  
                }
           limpiarAbajo();
       } catch (Exception e) {
            e.printStackTrace();
        }
        }

    public void desabilitar(int codigo){
        try {
           contratoSupInversionesVO=contratoSubInversionesServiceImpl.get(codigo);
           contratoSupInversionesVO.setSivEstado(0);
            contratoSupInversionesVO.setSivFechaFinal(new Date());
           contratoSubInversionesServiceImpl.update(contratoSupInversionesVO); 
           listarSupervisionDeInversiones();
       } catch (Exception e) {
            e.printStackTrace();
        }
       
        }

    public void cargarListaContratos(){
        try {
            if (tipoInfraestructura==0){
                    FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe selecionar tipo de infraestructura");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            else {
                int numero=1;
           listaContratos=contratoConcesionServiceImp.buscarContratos1(tipoInfraestructura);
            for (ContratoVO contra: listaContratos){ 
                ConcesionVO concesion=new ConcesionVO();
                
                concesion=concesionServiceImpl.get(contra.getCsiId());         
                contra.setNombreConcesion(concesion.getCsiNombre()); 
                contra.setCorrela(numero);
                codigoContrato = contra.getConId();
                codigoContratoP=codigoContrato;
                infraestructuraVO=infraestructuraServiceImpl.get2(concesion.getTinId());
                tipoInfraestructuraF=infraestructuraVO.getTinId();
                codigoConcesion=infraestructuraVO.getCsiId();
                codigoInfraestructura=infraestructuraVO.getInfId();     
                numero++;
                }
            }
       } catch (Exception e) {
            
            e.printStackTrace();
        } }
    
    
    
    public void elegirContrato(ContratoVO contrato1){
        try {
           contratoConcesion=contrato1.getNombreConcesion();
           tipoInfraestructuraC=contrato1.getTinId();
            codigoContrato=contrato1.getConId();
            codigoContratoP=contrato1.getConId();
            codigoConcesion=contrato1.getCsiId();
               infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(contrato1.getTinId());
               modalidadConcesionVO = modalidadServiceImp.get(contrato1.getMcoId());
                   tipoInfraestructuraS = infraestructuraTipoVO.getTinNombre();
               modalidadConcecion = modalidadConcesionVO.getMcoNombre();
               tipoInfraestructuraC=contrato1.getTinId();
            
            listarSupervisionDeInversiones();
       } catch (Exception e) {
            System.out.println("ERROR EN EL METODO ELEGIR CONTRATO");
            e.printStackTrace();
        }
       
            
        }
    
    public void registrarContrato() {
        try {
            
            boolean decicion=false;
            
            for (ContratoSubInversionesVO contratoSubInversionesVO1: listaContratoSupervisor){
                if (contratoSubInversionesVO1.getSivEstado()==1){
                    decicion=true;
                    }
                }
            if (decicion){
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe deshabilitar el supervisor de inversiones actual");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            
            else if (supervisorSelecionado==0){
                    FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe selecionar un supervisor de inversiones");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            else if (tipoInfraestructuraC==0){
                    FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe selecionar un contrato concesion");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            else {
            contratoSupInversionesVO.setSivUmero(numeroDocumento);
            contratoSupInversionesVO.setTinId(tipoInfraestructuraF);  
            contratoSupInversionesVO.setTsiId(codigoSupervisor);
            contratoSupInversionesVO.setConId(codigoContrato);
            contratoSupInversionesVO.setCsiId(codigoConcesion);
            contratoSupInversionesVO.setSivEstado(1);
            contratoSupInversionesVO.setInfId(codigoInfraestructura);
            contratoSupInversionesVO.setTdoId(1);
            contratoSupInversionesVO.setSivFechaInicial(new Date());
            contratoSupInversionesVO.setSivNombre(nombreSupervisor);
            contratoSubInversionesServiceImpl.insert(contratoSupInversionesVO);
                listarSupervisionDeInversiones();
            limpiar();
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro con Exito");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
                
            }

        } catch (Exception e) {
            System.out.println("SE CALLO EN EL METODO REGISTRAR CONTRATO");
            e.printStackTrace();
        }
    
    }
    
    public void listarSupervisionDeInversiones(){
       
        try {
           int contador=1;
           listaContratoSupervisor=contratoSubInversionesServiceImpl.query1(codigoContratoP);
            System.out.println(listaContratoSupervisor.size());
            
            for (ContratoSubInversionesVO contratoSubInversionesVO1:listaContratoSupervisor){
                concesionVO=concesionServiceImpl.get(contratoSubInversionesVO1.getCsiId());
                contratoSubInversionesVO1.setConcesionNombre(concesionVO.getCsiNombre());
                SupervisorInversionesVO supervisorInversionesVO=new SupervisorInversionesVO();
                SupervisorInversionesService supervisorInversionesService=new SupervisorInversionesServiceImpl();
                
                supervisorInversionesVO=supervisorInversionesService.getSupervisorInversiones(contratoSubInversionesVO1.getTsiId());
                
                
                contratoSubInversionesVO1.setNombreSupervicion(supervisorInversionesVO.getTsiNombre());
                contratoSubInversionesVO1.setContador(contador);
                contratoSubInversionesVO1.setEstadoNombre(contratoSubInversionesVO1.getSivEstado()==1 ? "ACTIVO" : "INACTIVO");
            }
       } catch (Exception e) {
            System.out.println("PROBLEMAS AL LISTAR SUPERVISOR DE INVERSIONES");
            e.printStackTrace();
        }
        }
    
    public void limpiar(){
        codigoSupervisor=0;
        codigoInfraestructura=0;
        tipoInfraestructura=0;
        numeroDocumento="";
        tipoInfraestructuraS="";
        tipoDocumento="";
        tipoDocumentoI=0;
        nombreSupervisor="";
        contratoConcesion="";
        tipoInfraestructuraC=0;
          tipoInfraestructuraF=0;
          modalidadConcecion="";
          supervisorSelecionado=0;
          codigoContrato=0;
          codigoConcesion=0;
            tipoInfraestructura=Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado().getTinId();
        }
    
    public void limpiar1(){
        codigoSupervisor=0;
        codigoInfraestructura=0;
            tipoInfraestructura=0;
            numeroDocumento="";
            tipoInfraestructuraS="";
            tipoDocumento="";
            tipoDocumentoI=0;
            nombreSupervisor="";
        contratoConcesion="";
        tipoInfraestructuraC=0;
          tipoInfraestructuraF=0;
          modalidadConcecion="";
          supervisorSelecionado=0;
          codigoContrato=0;
          codigoConcesion=0;
          listaContratoSupervisor.clear();
          listaSupervisor.clear();
            tipoInfraestructura=Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado().getTinId();
        }
    
  public void  limpiarAbajo(){
            tipoInfraestructuraS="";
            contratoConcesion="";
            tipoInfraestructuraC=0;
              tipoInfraestructuraF=0;
              modalidadConcecion="";
              supervisorSelecionado=0;
              codigoContrato=0;
              codigoConcesion=0;
              listaContratoSupervisor.clear();
        
        
        }
  
  
    public void  limpiarCasiTodo(){
              numeroDocumento="";
              tipoInfraestructuraS="";
              tipoDocumento="";
              tipoDocumentoI=0;
              nombreSupervisor="";
              contratoConcesion="";
              tipoInfraestructuraC=0;
                tipoInfraestructuraF=0;
                modalidadConcecion="";
                supervisorSelecionado=0;
                codigoContrato=0;
                codigoConcesion=0;
                listaContratoSupervisor.clear();
                
          
          
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


    public void setTipoDocumentoVO(TipoDocumentoVO tipoDocumentoVO) {
        this.tipoDocumentoVO = tipoDocumentoVO;
    }

    public TipoDocumentoVO getTipoDocumentoVO() {
        return tipoDocumentoVO;
    }

    public void setListaContratos(List<ContratoVO> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<ContratoVO> getListaContratos() {
        return listaContratos;
    }


    public void setTipoDocumentoServiceImp(TipoDocumentoService tipoDocumentoServiceImp) {
        this.tipoDocumentoServiceImp = tipoDocumentoServiceImp;
    }

    public TipoDocumentoService getTipoDocumentoServiceImp() {
        return tipoDocumentoServiceImp;
    }

    public void setContratoSupInversiones(ContratoSupInversiones contratoSupInversiones) {
        this.contratoSupInversiones = contratoSupInversiones;
    }

    public ContratoSupInversiones getContratoSupInversiones() {
        return contratoSupInversiones;
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


    public void setInfraestructuraServiceImpl(InfraestructuraService infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public InfraestructuraService getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }


    public void setContratoConcesionServiceImp(ContratoConcesionService contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public ContratoConcesionService getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }


    public void setConcesionServiceImpl(ConcesionService concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public ConcesionService getConcesionServiceImpl() {
        return concesionServiceImpl;
    }

    public void setTipoInfraestructuraF(int tipoInfraestructuraF) {
        this.tipoInfraestructuraF = tipoInfraestructuraF;
    }

    public int getTipoInfraestructuraF() {
        return tipoInfraestructuraF;
    }


    public void setTipoInfraestructuraS(String tipoInfraestructuraS) {
        this.tipoInfraestructuraS = tipoInfraestructuraS;
    }

    public String getTipoInfraestructuraS() {
        return tipoInfraestructuraS;
    }

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    public void setModalidadServiceImp(ModalidadConcesionService modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionService getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public void setModalidadConcesionVO(ModalidadConcesionVO modalidadConcesionVO) {
        this.modalidadConcesionVO = modalidadConcesionVO;
    }

    public ModalidadConcesionVO getModalidadConcesionVO() {
        return modalidadConcesionVO;
    }


    public void setListaContratoSupervisor(List<ContratoSubInversionesVO> listaContratoSupervisor) {
        this.listaContratoSupervisor = listaContratoSupervisor;
    }

    public List<ContratoSubInversionesVO> getListaContratoSupervisor() {
        return listaContratoSupervisor;
    }


    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }


    public void setCodigoContratoP(int codigoContratoP) {
        this.codigoContratoP = codigoContratoP;
    }

    public int getCodigoContratoP() {
        return codigoContratoP;
    }
    
    
}
