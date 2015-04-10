package com.ositran.valorizaciones;

import com.ositran.model.Infraestructura;
import com.ositran.service.AvanceInversionWebService;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.DatosStdService;
import com.ositran.service.InfraestructuraService;
import com.ositran.service.InfraestructuraTipoService;
import com.ositran.service.InversionService;
import com.ositran.service.ModalidadConcesionService;
import com.ositran.vo.bean.AvanceInversionWebVO;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InversionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.ViewTdInternosVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="registrarAvanceInversionMB")
@ViewScoped
public class RegistrarAvanceInversionMB {
    private int fichaRegistro;
    private int codigoInfraestructura;
    private String  nombreConcecion;
    private String nombreTipoInfraestructura;
    private String  nombreModalidadConceci�n;
    private int idModalidadConcesion;
    private int codigoConcesion;
    private int codigoInversion;
    private int idTipoInfraestructura;
    private int codigoContrato;
    //***************************DATOS SDT******************************//
    private String numero;
    private int anio;
    private Date fechaRegistroSDT;
    private String asunto;
    //*********************DATOS CONTRATO COMPROMISO********************//
    private int contratoCompromisoSeleccionado;
    private String plazo;
    private long total;
    private int codigoMoneda;
    
    List<InfraestructuraVO> listaInfraestructuras=new ArrayList<>();
    List<InversionVO> listaInversiones=new ArrayList<>();
    List<ContratoCompromisoVO> listaContratoCompromiso=new ArrayList<>();
    
    @ManagedProperty(value = "#{AvanceInversionWebServiceImpl}")
    AvanceInversionWebService avanceInversionWebServiceImpl;
    
    @ManagedProperty(value = "#{AvanceInversionWebVO}")
    AvanceInversionWebVO avanceInversionWebVO;
    
    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionService concesionServiceImpl;
    
    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionService modalidadServiceImp;
    
    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoService infraestructuraTipoServiceImpl;
    
    @ManagedProperty(value = "#{concesionVO}")
    ConcesionVO concesionVO;
    
    @ManagedProperty(value = "#{modalidadVO}")
    ModalidadConcesionVO modalidadVO;
    
    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    InfraestructuraTipoVO infraestructuraTipoVO;
    
    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    InfraestructuraService infraestructuraServiceImpl;
    
    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
    ContratoCompromisoService contratoCompromisoServiceImpl;
    
    @ManagedProperty(value = "#{inversionServiceImpl}")
    InversionService inversionServiceImpl;
    
    @ManagedProperty(value = "#{infraestructuraVO}")
    InfraestructuraVO infraestructuraVO;
    
    @ManagedProperty(value = "#{infraestructura}")
    Infraestructura infraestructura;
    
    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionService contratoConcesionServiceImp;
    
    @ManagedProperty(value = "#{contratoVO}")
    ContratoVO contratoVO;
    
    @ManagedProperty(value = "#{contratoCompromisoVO}")
    ContratoCompromisoVO contratoCompromisoVO;  
    
    @ManagedProperty(value = "#{datosStdServiceImpl}")
    DatosStdService datosStdServiceImpl;  
    
    @ManagedProperty(value = "#{viewTdInternosVO}")
    ViewTdInternosVO viewTdInternosVO; 
    
    
    public void buscarFichaRegistroWeb(){
        try {
            
            avanceInversionWebVO=avanceInversionWebServiceImpl.get(fichaRegistro);
            codigoConcesion=avanceInversionWebVO.getCsiId();
            idModalidadConcesion=avanceInversionWebVO.getMcoId();
            idTipoInfraestructura=avanceInversionWebVO.getTinId();
            contratoVO=contratoConcesionServiceImp.get(avanceInversionWebVO.getCsiId());
            codigoContrato=contratoVO.getConId();
            concesionVO=concesionServiceImpl.get(codigoConcesion);
            nombreConcecion=concesionVO.getCsiNombre();
            modalidadVO=modalidadServiceImp.get(idModalidadConcesion);
            nombreModalidadConceci�n=modalidadVO.getMcoNombre();           
            infraestructuraTipoVO=infraestructuraTipoServiceImpl.get(idTipoInfraestructura);
            nombreTipoInfraestructura=infraestructuraTipoVO.getTinNombre();           
            listaInfraestructuras=infraestructuraServiceImpl.query2(concesionVO.getCsiId());
            
       } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","La ficha ingresada no existe. Puede hacer el ingreso manualmente"));
                e.printStackTrace();
            }
        }
    
    public void cargarInversion(){
        try {
            infraestructuraVO=infraestructuraServiceImpl.get2(codigoInfraestructura);
            infraestructura.setCsiId(infraestructuraVO.getCsiId());
            infraestructura.setInfId(infraestructuraVO.getInfId());
            infraestructura.setTinId(infraestructuraVO.getTinId()); 
            listaInversiones=inversionServiceImpl.query1(infraestructura,codigoContrato);           
            listaContratoCompromiso=contratoCompromisoServiceImpl.query1(codigoContrato);
           
       } catch (Exception e) {
            e.printStackTrace();
        }   }
    
    public void cargarDatosCompromiso(){
        try {
           contratoCompromisoVO=contratoCompromisoServiceImpl.get(contratoCompromisoSeleccionado);
           plazo=contratoCompromisoVO.getCcoPlazo();
           total=contratoCompromisoVO.getCcoTotal();
           codigoMoneda=contratoCompromisoVO.getMonId();  
       } catch (Exception e) {
           System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
            
        }        
    }
    public void cargarDatosSDT(){
        try {
        viewTdInternosVO=datosStdServiceImpl.BuscaStd(anio,numero);
        
        fechaRegistroSDT=viewTdInternosVO.getFechaRegistro();
        asunto=viewTdInternosVO.getAsunto();
           
       } catch (Exception e) {
            asunto="";
                System.out.println("PROBLEMAS AL TRAER LOS DATOS INTERNOS");
                e.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","NO HAY DATOS SDT QUE MOSTRAR"));
                e.printStackTrace();
        }
    }
    
    public void setFichaRegistro(int fichaRegistro) {
        this.fichaRegistro = fichaRegistro;
    }

    public int getFichaRegistro() {
        return fichaRegistro;
    }

    public void setCodigoInfraestructura(int codigoInfraestructura) {
        this.codigoInfraestructura = codigoInfraestructura;
    }

    public int getCodigoInfraestructura() {
        return codigoInfraestructura;
    }

    public void setNombreConcecion(String nombreConcecion) {
        this.nombreConcecion = nombreConcecion;
    }

    public String getNombreConcecion() {
        return nombreConcecion;
    }

    public void setNombreTipoInfraestructura(String nombreTipoInfraestructura) {
        this.nombreTipoInfraestructura = nombreTipoInfraestructura;
    }

    public String getNombreTipoInfraestructura() {
        return nombreTipoInfraestructura;
    }

    public void setNombreModalidadConceci�n(String nombreModalidadConceci�n) {
        this.nombreModalidadConceci�n = nombreModalidadConceci�n;
    }

    public String getNombreModalidadConceci�n() {
        return nombreModalidadConceci�n;
    }

    public void setIdModalidadConcesion(int idModalidadConcesion) {
        this.idModalidadConcesion = idModalidadConcesion;
    }

    public int getIdModalidadConcesion() {
        return idModalidadConcesion;
    }

    public void setCodigoConcesion(int codigoConcesion) {
        this.codigoConcesion = codigoConcesion;
    }

    public int getCodigoConcesion() {
        return codigoConcesion;
    }

    public void setIdTipoInfraestructura(int idTipoInfraestructura) {
        this.idTipoInfraestructura = idTipoInfraestructura;
    }

    public int getIdTipoInfraestructura() {
        return idTipoInfraestructura;
    }

    public void setListaInfraestructuras(List<InfraestructuraVO> listaInfraestructuras) {
        this.listaInfraestructuras = listaInfraestructuras;
    }

    public List<InfraestructuraVO> getListaInfraestructuras() {
        return listaInfraestructuras;
    }

    public void setListaInversiones(List<InversionVO> listaInversiones) {
        this.listaInversiones = listaInversiones;
    }

    public List<InversionVO> getListaInversiones() {
        return listaInversiones;
    }

    public void setAvanceInversionWebServiceImpl(AvanceInversionWebService avanceInversionWebServiceImpl) {
        this.avanceInversionWebServiceImpl = avanceInversionWebServiceImpl;
    }

    public AvanceInversionWebService getAvanceInversionWebServiceImpl() {
        return avanceInversionWebServiceImpl;
    }

    public void setAvanceInversionWebVO(AvanceInversionWebVO avanceInversionWebVO) {
        this.avanceInversionWebVO = avanceInversionWebVO;
    }

    public AvanceInversionWebVO getAvanceInversionWebVO() {
        return avanceInversionWebVO;
    }

    public void setConcesionServiceImpl(ConcesionService concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public ConcesionService getConcesionServiceImpl() {
        return concesionServiceImpl;
    }

    public void setModalidadServiceImp(ModalidadConcesionService modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionService getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoService infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoService getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }

    public void setModalidadVO(ModalidadConcesionVO modalidadVO) {
        this.modalidadVO = modalidadVO;
    }

    public ModalidadConcesionVO getModalidadVO() {
        return modalidadVO;
    }

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    public void setInfraestructuraServiceImpl(InfraestructuraService infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public InfraestructuraService getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }

    public void setInversionServiceImpl(InversionService inversionServiceImpl) {
        this.inversionServiceImpl = inversionServiceImpl;
    }

    public InversionService getInversionServiceImpl() {
        return inversionServiceImpl;
    }

    public void setInfraestructuraVO(InfraestructuraVO infraestructuraVO) {
        this.infraestructuraVO = infraestructuraVO;
    }

    public InfraestructuraVO getInfraestructuraVO() {
        return infraestructuraVO;
    }

    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }

    public Infraestructura getInfraestructura() {
        return infraestructura;
    }

    public void setCodigoInversion(int codigoInversion) {
        this.codigoInversion = codigoInversion;
    }

    public int getCodigoInversion() {
        return codigoInversion;
    }


    public void setListaContratoCompromiso(List<ContratoCompromisoVO> listaContratoCompromiso) {
        this.listaContratoCompromiso = listaContratoCompromiso;
    }

    public List<ContratoCompromisoVO> getListaContratoCompromiso() {
        return listaContratoCompromiso;
    }

    public void setContratoCompromisoServiceImpl(ContratoCompromisoService contratoCompromisoServiceImpl) {
        this.contratoCompromisoServiceImpl = contratoCompromisoServiceImpl;
    }

    public ContratoCompromisoService getContratoCompromisoServiceImpl() {
        return contratoCompromisoServiceImpl;
    }

    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }
    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setContratoConcesionServiceImp(ContratoConcesionService contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public ContratoConcesionService getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    public void setContratoCompromisoSeleccionado(int contratoCompromisoSeleccionado) {
        this.contratoCompromisoSeleccionado = contratoCompromisoSeleccionado;
    }

    public int getContratoCompromisoSeleccionado() {
        return contratoCompromisoSeleccionado;
    }


    public void setContratoCompromisoVO(ContratoCompromisoVO contratoCompromisoVO) {
        this.contratoCompromisoVO = contratoCompromisoVO;
    }

    public ContratoCompromisoVO getContratoCompromisoVO() {
        return contratoCompromisoVO;
    }


    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setCodigoMoneda(int codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public int getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setDatosStdServiceImpl(DatosStdService datosStdServiceImpl) {
        this.datosStdServiceImpl = datosStdServiceImpl;
    }

    public DatosStdService getDatosStdServiceImpl() {
        return datosStdServiceImpl;
    }


    public void setViewTdInternosVO(ViewTdInternosVO viewTdInternosVO) {
        this.viewTdInternosVO = viewTdInternosVO;
    }

    public ViewTdInternosVO getViewTdInternosVO() {
        return viewTdInternosVO;
    }


    public void setFechaRegistroSDT(Date fechaRegistroSDT) {
        this.fechaRegistroSDT = fechaRegistroSDT;
    }

    public Date getFechaRegistroSDT() {
        return fechaRegistroSDT;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }
    
    
}
