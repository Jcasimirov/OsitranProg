package com.ositran.contratos;

import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.ContratoJefeAreaService;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoJefeAreaServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.JefeAreaContratoConcecionServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoJefeAreaVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.JefeAreaContratoConcecionVO;
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
    private String numeroDocumento = "";
    private String tipoDocumento = "";
    private String nombreJefeArea = "";
    private String contratoConcesion;
    private int tipoInfraestructuraC;
    private String modalidadConcecion;
    private int codigoConcesion;
    private int codigoContrato;
    private List<ContratoVO> listaContratos = new ArrayList<>();
    private List<InfraestructuraTipoVO> listaInfraestructuraTipo = new ArrayList<>();
    private List<JefeAreaContratoConcecionVO> listaJefeArea = new ArrayList<>();
       
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


    public void cargarListaContratos() {
        try {
            listaContratos = contratoConcesionServiceImp.query();
            System.out.println(listaContratos.size());
            for (ContratoVO contra : listaContratos) {
                ConcesionVO concesion = new ConcesionVO();

                concesion = concesionServiceImpl.get(contra.getCsiId());
                contra.setNombreConcesion(concesion.getCsiNombre());
                contra.setCodigoConcesion(concesion.getCsiId());
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void elegirContrato(ContratoVO contrato1) {
        contratoConcesion = contrato1.getNombreConcesion();
        tipoInfraestructuraC = contrato1.getTinId();
        codigoContrato = contrato1.getConId();
        codigoConcesion = contrato1.getCsiId();
        modalidadConcecion = "Modalidad1";

    }

    public void registrarContrato() {
        try {
            contratoJefeAreaVO.setCjaEstado(1);
            contratoJefeAreaVO.setCjaFechaInicial(new Date());
            contratoJefeAreaVO.setTdoId(1);
            contratoJefeAreaVO.setCsiId(codigoConcesion);
            contratoJefeAreaVO.setConId(codigoContrato);
            contratoJefeAreaVO.setCjaNroDocumento(numeroDocumento);
            contratoJefeAreaVO.setTinId(tipoInfraestructuraC);
            contratoJefeAreaServiceImpl.insert(contratoJefeAreaVO);
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro con Exito");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (Exception e) {
            System.out.println("SE CALLO EN EL METODO REGISTRAR CONTRATO");
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
}
