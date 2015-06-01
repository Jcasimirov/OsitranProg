package com.ositran.contratos;

import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.ModalidadConcesionService;
import com.ositran.service.TipoDocumentoService;
import com.ositran.serviceimpl.ContratoJefeAreaServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.JefeAreaContratoConcecionServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoJefeAreaVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.JefeAreaContratoConcecionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.TipoDocumentoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "jefeAreaContratoConcecionMB")
@ViewScoped
public class JefeAreaContratoConcecionMB {
    
    private int tipoInfraestructura;
    private String tipoInfraestructuraS;
    private String buscar;
    private String numeroDocumento = "";
    private String tipoDocumento = "";
    private int tipoDocumentoI;
    private String nombreJefeArea = "";
    private String contratoConcesion;
    private int tipoInfraestructuraC;
    private String modalidadConcecion;
    private int codigoConcesion;
    private int codigoContratoP;
    private int codigoContrato;
    private List<ContratoVO> listaContratos = new ArrayList<ContratoVO>();
    private List<InfraestructuraTipoVO> listaInfraestructuraTipo = new ArrayList<InfraestructuraTipoVO>();
    private List<ContratoJefeAreaVO> listaJefeArea = new ArrayList<ContratoJefeAreaVO>();

    @ManagedProperty(value = "#{contratoJefeAreaVO}")
    ContratoJefeAreaVO contratoJefeAreaVO;

    @ManagedProperty(value = "#{contratoJefeAreaServiceImpl}")
    ContratoJefeAreaServiceImpl contratoJefeAreaServiceImpl;

    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionService contratoConcesionServiceImp;

    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionService concesionServiceImpl;

    @ManagedProperty(value = "#{jefeAreaContratoConcecionServiceImpl}")
    JefeAreaContratoConcecionServiceImpl jefeAreaContratoConcecionServiceImpl;

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{jefeAreaContratoConcecionVO}")
    JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO;

    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionService modalidadServiceImp;

    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    InfraestructuraTipoVO infraestructuraTipoVO;

    @ManagedProperty(value = "#{tipoDocumentoServiceImp}")
    TipoDocumentoService tipoDocumentoServiceImp;
    
    @ManagedProperty(value = "#{concesionVO}")
    ConcesionVO concesionVO;
    TipoDocumentoVO tipoDocumentoVO = new TipoDocumentoVO();
    ModalidadConcesionVO modalidadConcesionVO = new ModalidadConcesionVO();

    public void busqueda(){
        
        }
    public void limpiar() {
        tipoInfraestructura = 0;
        numeroDocumento = "";
        tipoDocumento = "";
        nombreJefeArea = "";
        contratoConcesion = "";
        tipoInfraestructuraC = 0;
        modalidadConcecion = "";
        codigoConcesion = 0;
        codigoContrato = 0;
        tipoInfraestructuraS="";
    }
    public void limpiarTodo(){
            tipoInfraestructura = 0;
            numeroDocumento = "";
            tipoDocumento = "";
            nombreJefeArea = "";
            contratoConcesion = "";
            tipoInfraestructuraC = 0;
            modalidadConcecion = "";
            codigoConcesion = 0;
            codigoContrato = 0;
            tipoInfraestructuraS="";
            listaJefeArea=new ArrayList<ContratoJefeAreaVO>();
        
        }

    public void limpiarAbajo    (){
            contratoConcesion = "";
            tipoInfraestructuraC = 0;
            modalidadConcecion = "";
            codigoConcesion = 0;
            codigoContrato = 0;
            tipoInfraestructuraS="";
            listaJefeArea=new ArrayList<ContratoJefeAreaVO>();
        
        }

    public void cargarListaInfraestructura() {
        try {
            listaInfraestructuraTipo = infraestructuraTipoServiceImpl.query();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarJefeAreaContratoConcesion() {
        try {

            if (tipoInfraestructura != 0) {
                jefeAreaContratoConcecionVO = jefeAreaContratoConcecionServiceImpl.get(tipoInfraestructura);
                nombreJefeArea = jefeAreaContratoConcecionVO.getSjaNombre();
                tipoDocumento = jefeAreaContratoConcecionVO.getSjaTipoDocumento();
                numeroDocumento = jefeAreaContratoConcecionVO.getSjaNumeroDocumento();

                if (jefeAreaContratoConcecionVO.getSjaTipoDocumento().equals(1)) {
                    tipoDocumento = "DNI";
                    tipoDocumentoI=1;
                } else {
                    tipoDocumento = "RUC";
                    tipoDocumentoI=2;
                }
                limpiarAbajo();
            }

            else {
                nombreJefeArea = "";
                tipoDocumento = "";
                numeroDocumento = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

    public void desabilitar(int codigo){
            contratoJefeAreaVO=new ContratoJefeAreaVO();
        contratoJefeAreaVO=contratoJefeAreaServiceImpl.get(codigo);
        contratoJefeAreaVO.setCjaEstado(0);
        contratoJefeAreaVO.setCjaFechaFinal(new Date());
        contratoJefeAreaServiceImpl.update(contratoJefeAreaVO); 
        listarJefeAreaContrato();
        }
    
    
    public void activar(int codigo){
            contratoJefeAreaVO=new ContratoJefeAreaVO();
        contratoJefeAreaVO=contratoJefeAreaServiceImpl.get(codigo);
        contratoJefeAreaVO.setCjaEstado(0);
        contratoJefeAreaVO.setCjaFechaFinal(new Date());
        contratoJefeAreaServiceImpl.update(contratoJefeAreaVO); 
        listarJefeAreaContrato();
        }
    
    public void cargarListaContratos() {
        try {
            if (tipoInfraestructura == 0){
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso","Debe seleccionar tipo infraestructura");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            else {
            
                    listaContratos = contratoConcesionServiceImp.buscarContratos1(tipoInfraestructura);
                    int numero =1;
                    for (ContratoVO contra : listaContratos) {
                        ConcesionVO concesion = new ConcesionVO();
                        
                        concesion = concesionServiceImpl.get(contra.getCsiId());
                        contra.setCorrela(numero);
                        contra.setNombreConcesion(concesion.getCsiNombre());
                        contra.setCodigoConcesion(concesion.getCsiId());
                        numero++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elegirContrato(ContratoVO contrato1) {
        try {
            contratoConcesion = contrato1.getNombreConcesion();
            codigoContrato = contrato1.getConId();
            codigoContratoP= codigoContrato;
            codigoConcesion = contrato1.getCsiId();
            infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(contrato1.getTinId());
            modalidadConcesionVO = modalidadServiceImp.get(contrato1.getMcoId());
            tipoInfraestructuraS = infraestructuraTipoVO.getTinDescripcion();
            modalidadConcecion = modalidadConcesionVO.getMcoNombre();
            tipoInfraestructuraC=contrato1.getTinId();
            listarJefeAreaContrato();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registrarContrato() {
        contratoJefeAreaVO=new ContratoJefeAreaVO();
        try {
            boolean decicion=false;
            
            for (ContratoJefeAreaVO contratoJefeAreaVO:listaJefeArea){
                if (contratoJefeAreaVO.getCjaEstado()==1){
                    decicion=true;
                    }
                }
            if (decicion){
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Debe deshabilitar al jefe de área actual");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
           else  if (tipoInfraestructura == 0) {
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Debe selecionar el tipo de infraestructura");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } else if (codigoConcesion == 0) {
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Debe selecionar un contrato");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }

            else {
                contratoJefeAreaVO.setCjaEstado(1);
                contratoJefeAreaVO.setCjaFechaInicial(new Date());
                contratoJefeAreaVO.setTdoId(tipoDocumentoI);
                contratoJefeAreaVO.setCsiId(codigoConcesion);
                contratoJefeAreaVO.setConId(codigoContrato);
                contratoJefeAreaVO.setCjaNroDocumento(numeroDocumento);
                contratoJefeAreaVO.setTinId(tipoInfraestructuraC);
                contratoJefeAreaServiceImpl.insert(contratoJefeAreaVO);
                
                listarJefeAreaContrato();
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró con Éxito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                limpiar(); 
            }
        } catch (Exception e) {
            System.out.println("SE CALLO EN EL METODO REGISTRAR CONTRATO");
            e.printStackTrace();
        }
    }
    
    public void listarJefeAreaContrato(){ 
        try {
           int contador=1;
                listaJefeArea=contratoJefeAreaServiceImpl.query1(codigoContratoP);
            for (ContratoJefeAreaVO contratoJefeAreaVO1:listaJefeArea){
                concesionVO=concesionServiceImpl.get(contratoJefeAreaVO1.getCsiId());
                contratoJefeAreaVO1.setConcesionNombre(concesionVO.getCsiNombre());
                contratoJefeAreaVO1.setNombreJefeArea(jefeAreaContratoConcecionVO.getSjaNombre());
                contratoJefeAreaVO1.setContador(contador);
                contratoJefeAreaVO1.setEstadoDes(contratoJefeAreaVO1.getCjaEstado()==1 ? "ACTIVO":"INACTIVO" );
                contador++;    
                }
       } catch (Exception e) {
            System.out.println("PROBLEMAS AL LISTAR LISTA JEFE DE AREA CONTRATO CONCECION");
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


    public void setListaContratos(List<ContratoVO> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<ContratoVO> getListaContratos() {
        return listaContratos;
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


    public void setContratoJefeAreaServiceImpl(ContratoJefeAreaServiceImpl contratoJefeAreaServiceImpl) {
        this.contratoJefeAreaServiceImpl = contratoJefeAreaServiceImpl;
    }

    public ContratoJefeAreaServiceImpl getContratoJefeAreaServiceImpl() {
        return contratoJefeAreaServiceImpl;
    }

    public void setContratoJefeAreaVO(ContratoJefeAreaVO contratoJefeAreaVO) {
        this.contratoJefeAreaVO = contratoJefeAreaVO;
    }

    public ContratoJefeAreaVO getContratoJefeAreaVO() {
        return contratoJefeAreaVO;
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


    public void setTipoInfraestructuraS(String tipoInfraestructuraS) {
        this.tipoInfraestructuraS = tipoInfraestructuraS;
    }

    public String getTipoInfraestructuraS() {
        return tipoInfraestructuraS;
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

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    public void setTipoDocumentoVO(TipoDocumentoVO tipoDocumentoVO) {
        this.tipoDocumentoVO = tipoDocumentoVO;
    }

    public TipoDocumentoVO getTipoDocumentoVO() {
        return tipoDocumentoVO;
    }


    public void setTipoDocumentoServiceImp(TipoDocumentoService tipoDocumentoServiceImp) {
        this.tipoDocumentoServiceImp = tipoDocumentoServiceImp;
    }

    public TipoDocumentoService getTipoDocumentoServiceImp() {
        return tipoDocumentoServiceImp;
    }


    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setListaJefeArea(List<ContratoJefeAreaVO> listaJefeArea) {
        this.listaJefeArea = listaJefeArea;
    }

    public List<ContratoJefeAreaVO> getListaJefeArea() {
        return listaJefeArea;
    }


    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }


    public void setTipoDocumentoI(int tipoDocumentoI) {
        this.tipoDocumentoI = tipoDocumentoI;
    }

    public int getTipoDocumentoI() {
        return tipoDocumentoI;
    }


    public void setCodigoContratoP(int codigoContratoP) {
        this.codigoContratoP = codigoContratoP;
    }

    public int getCodigoContratoP() {
        return codigoContratoP;
    }
}


