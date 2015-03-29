
package com.ositran.valorizaciones;

import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "RegValorizacionSupervisionMB")
@ViewScoped
public class RegistrarValorizacionSupervision {

    private int conId;
    private int t_tinfra;
    private String nombreConcesion;
    private String contratoConcesion;
    private int codigoContrato;
    private int tipoInfraestructura;
    private int codigoConcesion;
    private int codigoInfraestructura;
    private String t_concesion;
    private String t_modconc;


    private List<ContratoVO> listaContratos = new ArrayList<>();

    private InfraestructuraServiceImpl infraestructuraServiceImpl = new InfraestructuraServiceImpl();
    private InfraestructuraVO infraestructuraVO = new InfraestructuraVO();
    private ContratoConcesionServiceImpl contratoServicesImpl = new ContratoConcesionServiceImpl();
    
    
    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionService contratoConcesionServiceImp;

    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionService concesionServiceImpl;
    
    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;


   public void cargarListaContratos() {
       System.out.println("hola");
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
        System.out.println("hola1");
        t_concesion = contrato1.getNombreConcesion();
        t_tinfra = contrato1.getTinId();
        codigoContrato = contrato1.getConId();
        codigoConcesion = contrato1.getCsiId();
        t_modconc = "Modalidad1";

    }


    public void setConId(int conId) {
        this.conId = conId;
    }

    public int getConId() {
        return conId;
    }

    public void setNombreConcesion(String nombreConcesion) {
        this.nombreConcesion = nombreConcesion;
    }

    public String getNombreConcesion() {
        return nombreConcesion;
    }

    public void setContratoConcesion(String contratoConcesion) {
        this.contratoConcesion = contratoConcesion;
    }

    public String getContratoConcesion() {
        return contratoConcesion;
    }

    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setTipoInfraestructura(int tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public int getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setCodigoConcesion(int codigoConcesion) {
        this.codigoConcesion = codigoConcesion;
    }

    public int getCodigoConcesion() {
        return codigoConcesion;
    }

    public void setCodigoInfraestructura(int codigoInfraestructura) {
        this.codigoInfraestructura = codigoInfraestructura;
    }

    public int getCodigoInfraestructura() {
        return codigoInfraestructura;
    }

    public void setListaContratos(List<ContratoVO> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<ContratoVO> getListaContratos() {
        return listaContratos;
    }

    public void setInfraestructuraServiceImpl(InfraestructuraServiceImpl infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public InfraestructuraServiceImpl getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }

    public void setInfraestructuraVO(InfraestructuraVO infraestructuraVO) {
        this.infraestructuraVO = infraestructuraVO;
    }

    public InfraestructuraVO getInfraestructuraVO() {
        return infraestructuraVO;
    }

    public void setContratoServicesImpl(ContratoConcesionServiceImpl contratoServicesImpl) {
        this.contratoServicesImpl = contratoServicesImpl;
    }

    public ContratoConcesionServiceImpl getContratoServicesImpl() {
        return contratoServicesImpl;
    }

   

    public void setT_concesion(String t_concesion) {
        this.t_concesion = t_concesion;
    }

    public String getT_concesion() {
        return t_concesion;
    }


    public void setT_tinfra(int t_tinfra) {
        this.t_tinfra = t_tinfra;
    }

    public int getT_tinfra() {
        return t_tinfra;
    }

    public void setT_modconc(String t_modconc) {
        this.t_modconc = t_modconc;
    }

    public String getT_modconc() {
        return t_modconc;
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

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

}
