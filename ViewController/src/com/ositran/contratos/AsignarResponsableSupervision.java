package com.ositran.contratos;

import com.ositran.service.AsignarResponsableSupervisionService;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.EmpresaSupervisoraService;
import com.ositran.service.SupervisorInversionesService;
import com.ositran.service.TipoDocumentoService;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoResSupDetalleVO;
import com.ositran.vo.bean.ContratoRespSupVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.SupervisorInversionesVO;
import com.ositran.vo.bean.TipoDocumentoVO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.event.ActionEvent;
import com.ositran.util.Util;

import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "asignarResponsableMB")
@ViewScoped
public class AsignarResponsableSupervision {
    
    
    //-----------------SESSION-----------------------//
    public  final int formulario=24;
    private RolOpcionesVO rolOpcion;

    public void validarSesion() throws IOException{              
            rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
        }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }
    //---------------------------------------------//



private String nameContrato;
private String nameTipoInfraestructura;
private String nameModalidadConcesion;
private int contratoCompromisoSeleccionado;
private String nombreDescripcionModalidadConcesion;
private String nombreDescripcionTipoInfraestructura;
private String nombreDescripcionContratoConcesion;
private int codigoEtapa;
private String plazo;
private Double moneda;
private int codigoMoneda;
private String nombreMoneda;
private String total;
HtmlForm form1;
HtmlForm form2;
private String nombreEmpresaSupervisora;
private String rucEmpresaSupervisora;
private String nombreContratoConcesion;
private int codigoTipoInfraestructurafiltro;
private int codigoSupervisor;
private int codigoContrato;

    Util util = new Util();

// de  abel 
  
  
  //Bean VO


    @ManagedProperty(value = "#{contratoCompromisoVO}")
      ContratoCompromisoVO contratoCompromisoVO;

    @ManagedProperty(value = "#{empSupVO}")
    private EmpresaSupervisoraVO empSupVO;
    
    @ManagedProperty(value = "#{supervisorInversionesVO}")
    private SupervisorInversionesVO supervisorInversionesVO;
    
    @ManagedProperty(value = "#{contratoRespSupVO}")
    private ContratoRespSupVO contratoRespSupVO;
    
    @ManagedProperty(value = "#{contratoResSupDetalleVO}")
    private ContratoResSupDetalleVO contratoResSupDetalleVO;
    
    @ManagedProperty(value = "#{contratoVO}")
    private ContratoVO contratoVO;
    
       



// Listas
    
    private List<InfraestructuraTipoVO> listaInfraestructuraTipos = new ArrayList<>();
    private List<EmpresaSupervisoraVO> empresasSupervisoras ;
    private List<SupervisorInversionesVO> listarSupervisoresxInfraestructura;
    private List<ContratoVO> listaContratos = new ArrayList<>();
    private List<ContratoCompromisoVO> listaContratoCompromiso=new ArrayList<>();
    private List<ContratoVO> listaContratosConcesion = new ArrayList<>();
    List<EmpresaSupervisoraVO> listaEmpresasSup=new ArrayList<EmpresaSupervisoraVO>();
    List<TipoDocumentoVO> listaTipoDocumento;
    List<HashMap<String, Object>>  listaResponsables=new ArrayList<HashMap<String, Object>>();
    
    List<ContratoResSupDetalleVO> listaDetalleAsignacion = new ArrayList<ContratoResSupDetalleVO>();
    List<ContratoResSupDetalleVO> listaBd = new ArrayList<ContratoResSupDetalleVO>();
     
     
     // service implement
    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;
    
    
    @ManagedProperty(value="#{empSupServiceImp}")
    private EmpresaSupervisoraService empSupServiceImp;
    
    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
      ContratoCompromisoService contratoCompromisoServiceImpl;
    
    @ManagedProperty(value="#{tipoDocumentoServiceImp}")
    private TipoDocumentoService tipoDocumentoServiceImp;
    //CARRITO CHARLES -- EMPRESAS SUPERVISORA
   
    @ManagedProperty(value = "#{supervisorInversionesServiceImpl}")
    private SupervisorInversionesService supervisorInversionesServiceImpl;
    
    @ManagedProperty(value = "#{asignarResponsableSupervisionServiceImpl}")
    private AsignarResponsableSupervisionService asignarResponsableSupervisionServiceImpl;



//get y set

    public void setListaBd(List<ContratoResSupDetalleVO> listaBd) {
        this.listaBd = listaBd;
    }

    public List<ContratoResSupDetalleVO> getListaBd() {
        return listaBd;
    }

    public void buscarContratoConcesion(){
        
        
        }


    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setNombreDescripcionModalidadConcesion(String nombreDescripcionModalidadConcesion) {
        this.nombreDescripcionModalidadConcesion = nombreDescripcionModalidadConcesion;
    }

    public String getNombreDescripcionModalidadConcesion() {
        return nombreDescripcionModalidadConcesion;
    }

    public void setNombreDescripcionTipoInfraestructura(String nombreDescripcionTipoInfraestructura) {
        this.nombreDescripcionTipoInfraestructura = nombreDescripcionTipoInfraestructura;
    }

    public String getNombreDescripcionTipoInfraestructura() {
        return nombreDescripcionTipoInfraestructura;
    }

    public void setNombreDescripcionContratoConcesion(String nombreDescripcionContratoConcesion) {
        this.nombreDescripcionContratoConcesion = nombreDescripcionContratoConcesion;
    }

    public String getNombreDescripcionContratoConcesion() {
        return nombreDescripcionContratoConcesion;
    }

    public void setCodigoEtapa(int codigoEtapa) {
        this.codigoEtapa = codigoEtapa;
    }

    public int getCodigoEtapa() {
        return codigoEtapa;
    }


    public void setMoneda(Double moneda) {
        this.moneda = moneda;
    }

    public Double getMoneda() {
        return moneda;
    }


    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setForm2(HtmlForm form2) {
        this.form2 = form2;
    }

    public HtmlForm getForm2() {
        return form2;
    }

    public void setNombreEmpresaSupervisora(String nombreEmpresaSupervisora) {
        this.nombreEmpresaSupervisora = nombreEmpresaSupervisora;
    }

    public String getNombreEmpresaSupervisora() {
        return nombreEmpresaSupervisora;
    }

    public void setRucEmpresaSupervisora(String rucEmpresaSupervisora) {
        this.rucEmpresaSupervisora = rucEmpresaSupervisora;
    }

    public String getRucEmpresaSupervisora() {
        return rucEmpresaSupervisora;
    }

    public void setNombreContratoConcesion(String nombreContratoConcesion) {
        this.nombreContratoConcesion = nombreContratoConcesion;
    }

    public String getNombreContratoConcesion() {
        return nombreContratoConcesion;
    }

    public void setCodigoTipoInfraestructurafiltro(int codigoTipoInfraestructurafiltro) {
        this.codigoTipoInfraestructurafiltro = codigoTipoInfraestructurafiltro;
    }

    public int getCodigoTipoInfraestructurafiltro() {
        return codigoTipoInfraestructurafiltro;
    }

    public void setCodigoSupervisor(int codigoSupervisor) {
        this.codigoSupervisor = codigoSupervisor;
    }

    public int getCodigoSupervisor() {
        return codigoSupervisor;
    }

    public void setListaInfraestructuraTipos(List<InfraestructuraTipoVO> listaInfraestructuraTipos) {
        this.listaInfraestructuraTipos = listaInfraestructuraTipos;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructuraTipos() {
        return listaInfraestructuraTipos;
    }

    public void setListarSupervisoresxInfraestructura(List<SupervisorInversionesVO> listarSupervisoresxInfraestructura) {
        this.listarSupervisoresxInfraestructura = listarSupervisoresxInfraestructura;
    }

    public List<SupervisorInversionesVO> getListarSupervisoresxInfraestructura() {
        return listarSupervisoresxInfraestructura;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void setEmpSupVO(EmpresaSupervisoraVO empSupVO) {
        this.empSupVO = empSupVO;
    }

    public EmpresaSupervisoraVO getEmpSupVO() {
        return empSupVO;
    }


    public void setSupervisorInversionesVO(SupervisorInversionesVO supervisorInversionesVO) {
        this.supervisorInversionesVO = supervisorInversionesVO;
    }

    public SupervisorInversionesVO getSupervisorInversionesVO() {
        return supervisorInversionesVO;
    }

 

    public void setListaTipoDocumento(List<TipoDocumentoVO> listaTipoDocumento) {
        this.listaTipoDocumento = listaTipoDocumento;
    }

    public List<TipoDocumentoVO> getListaTipoDocumento() {
        return listaTipoDocumento;
    }


    public void setContratoConcesionServiceImp(ContratoConcesionService contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public ContratoConcesionService getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }


    public void setConcesionServicesImpl(ConcesionService concesionServicesImpl) {
        this.concesionServicesImpl = concesionServicesImpl;
    }

    public ConcesionService getConcesionServicesImpl() {
        return concesionServicesImpl;
    }



    public void setEmpSupServiceImp(EmpresaSupervisoraService empSupServiceImp) {
        this.empSupServiceImp = empSupServiceImp;
    }

    public EmpresaSupervisoraService getEmpSupServiceImp() {
        return empSupServiceImp;
    }

    public void setTipoDocumentoServiceImp(TipoDocumentoService tipoDocumentoServiceImp) {
        this.tipoDocumentoServiceImp = tipoDocumentoServiceImp;
    }

    public TipoDocumentoService getTipoDocumentoServiceImp() {
        return tipoDocumentoServiceImp;
    }


    public void setSupervisorInversionesServiceImpl(SupervisorInversionesService supervisorInversionesServiceImpl) {
        this.supervisorInversionesServiceImpl = supervisorInversionesServiceImpl;
    }

    public SupervisorInversionesService getSupervisorInversionesServiceImpl() {
        return supervisorInversionesServiceImpl;
    }


    public void setEmpresasSupervisoras(List<EmpresaSupervisoraVO> empresasSupervisoras) {
        this.empresasSupervisoras = empresasSupervisoras;
    }

    public List<EmpresaSupervisoraVO> getEmpresasSupervisoras() {
        return empresasSupervisoras;
    }
    public void setListaEmpresasSup(List<EmpresaSupervisoraVO> listaEmpresasSup) {
        this.listaEmpresasSup = listaEmpresasSup;
    }

    public List<EmpresaSupervisoraVO> getListaEmpresasSup() {
        return listaEmpresasSup;
    }

    public void setListaContratos(List<ContratoVO> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<ContratoVO> getListaContratos() {
        return listaContratos;
    }


    public void setNameContrato(String nameContrato) {
        this.nameContrato = nameContrato;
    }

    public String getNameContrato() {
        return nameContrato;
    }

    public void setNameTipoInfraestructura(String nameTipoInfraestructura) {
        this.nameTipoInfraestructura = nameTipoInfraestructura;
    }

    public String getNameTipoInfraestructura() {
        return nameTipoInfraestructura;
    }


    public void setNameModalidadConcesion(String nameModalidadConcesion) {
        this.nameModalidadConcesion = nameModalidadConcesion;
    }

    public String getNameModalidadConcesion() {
        return nameModalidadConcesion;
    }


  

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }


    public void setModalidadVO(ModalidadConcesionVO modalidadVO) {
        this.modalidadVO = modalidadVO;
    }

    public ModalidadConcesionVO getModalidadVO() {
        return modalidadVO;
    }

    public void setModalidadServiceImp(ModalidadConcesionServiceImpl modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionServiceImpl getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public void setContratoCompromisoServiceImpl(ContratoCompromisoService contratoCompromisoServiceImpl) {
        this.contratoCompromisoServiceImpl = contratoCompromisoServiceImpl;
    }

    public ContratoCompromisoService getContratoCompromisoServiceImpl() {
        return contratoCompromisoServiceImpl;
    }

    public void setContratoCompromisoVO(ContratoCompromisoVO contratoCompromisoVO) {
        this.contratoCompromisoVO = contratoCompromisoVO;
    }

    public ContratoCompromisoVO getContratoCompromisoVO() {
        return contratoCompromisoVO;
    }


    public void setContratoCompromisoSeleccionado(int contratoCompromisoSeleccionado) {
        this.contratoCompromisoSeleccionado = contratoCompromisoSeleccionado;
    }

    public int getContratoCompromisoSeleccionado() {
        return contratoCompromisoSeleccionado;
    }

    public void setListaContratoCompromiso(List<ContratoCompromisoVO> listaContratoCompromiso) {
        this.listaContratoCompromiso = listaContratoCompromiso;
    }

    public List<ContratoCompromisoVO> getListaContratoCompromiso() {
        return listaContratoCompromiso;
    }

    public void setCodigoMoneda(int codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public int getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setAsignarResponsableSupervisionServiceImpl(AsignarResponsableSupervisionService asignarResponsableSupervisionServiceImpl) {
        this.asignarResponsableSupervisionServiceImpl = asignarResponsableSupervisionServiceImpl;
    }

    public AsignarResponsableSupervisionService getAsignarResponsableSupervisionServiceImpl() {
        return asignarResponsableSupervisionServiceImpl;
    }


    public void setContratoRespSupVO(ContratoRespSupVO contratoRespSupVO) {
        this.contratoRespSupVO = contratoRespSupVO;
    }

    public ContratoRespSupVO getContratoRespSupVO() {
        return contratoRespSupVO;
    }

    public void setContratoResSupDetalleVO(ContratoResSupDetalleVO contratoResSupDetalleVO) {
        this.contratoResSupDetalleVO = contratoResSupDetalleVO;
    }

    public ContratoResSupDetalleVO getContratoResSupDetalleVO() {
        return contratoResSupDetalleVO;
    }


    public void setListaDetalleAsignacion(List<ContratoResSupDetalleVO> listaDetalleAsignacion) {
        this.listaDetalleAsignacion = listaDetalleAsignacion;
    }

    public List<ContratoResSupDetalleVO> getListaDetalleAsignacion() {
        return listaDetalleAsignacion;
    }


    public void setUtil(Util util) {
        this.util = util;
    }

    public Util getUtil() {
        return util;
    }


    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void eliminacionConfirmadaResponsable() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("rowId");
        Object str2 = requestMap.get("rowIdCod");
        int tipoSup = 0;
        int codSup = 0;
        int idcodigo = Integer.valueOf(str.toString());
        int idCodigoSup = Integer.valueOf(str2.toString());
        tipoSup = Integer.parseInt(((HashMap<String, Object>)listaResponsables.get(idcodigo)).get("tipoSupervision").toString());
        codSup = Integer.parseInt(((HashMap<String, Object>)listaResponsables.get(idcodigo)).get("codigoSupervisor").toString());
        for(int i=0;i<listaDetalleAsignacion.size();i++){
            if (listaDetalleAsignacion.get(i).getTipoSup() == tipoSup && listaDetalleAsignacion.get(i).getCodigoSup() == codSup){
                listaDetalleAsignacion.remove(listaDetalleAsignacion.get(i));
            }
        }
        listaResponsables.remove(idcodigo);
        if(idCodigoSup > 0){
        for(ContratoResSupDetalleVO detalle : listaDetalleAsignacion){
            if(detalle.getRsdId() == idCodigoSup){
                detalle.setRsdEstado(0);
            }
        }
        }
    }
    
    public void desactivarConfirmadaResponsable() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("rowIdE");
        Object str2 = requestMap.get("rowIdCodDes");
        int idcodigo = Integer.valueOf(str.toString());
        int idCodigoSup = Integer.valueOf(str2.toString());
        listaResponsables.get(idcodigo).put("estado","Inactivo");
        if(idCodigoSup > 0){
        for(ContratoResSupDetalleVO detalle : listaDetalleAsignacion){
            if(detalle.getRsdId() == idCodigoSup){
                detalle.setRsdEstado(2);
            }
        }
        }
    }


    public void filtrarListaEmpSup(){
        if(codigoContrato > 0 && contratoCompromisoSeleccionado > 0){
        try {
            System.out.println("entro FiltrarListaEmpSup: " + listaEmpresasSup.size());
            System.out.println(nombreEmpresaSupervisora);
            System.out.println(rucEmpresaSupervisora);
            listaEmpresasSup = empSupServiceImp.BuscarEmpresaPorContrato(codigoContrato, contratoCompromisoSeleccionado, nombreEmpresaSupervisora);
            //listaEmpresasSup = empSupServiceImp.FiltrarEmpSup(nombreEmpresaSupervisora, rucEmpresaSupervisora);
            listaTipoDocumento = tipoDocumentoServiceImp.query();
            for (int i = 0; i < listaEmpresasSup.size(); i++) {
                for (int j = 0; j < listaTipoDocumento.size(); j++) {
                    if (listaEmpresasSup.get(i).getTdoId() == listaTipoDocumento.get(j).getTdoId()) {
                        listaEmpresasSup.get(i).setDescripcionDoc(listaTipoDocumento.get(j).getTdoNombre());
                    }
                }
                System.out.println(""+listaEmpresasSup.get(i).getSupNombre());
            }
            System.out.println("entro FiltrarListaEmpSup: " + listaEmpresasSup.size());
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
            RequestContext.getCurrentInstance().execute("Dialog_ResultadoBusquedaEmpresa.show()");
        }else{
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione un Contrato de Concesión y una Etapa o Periodo");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }
    public List<EmpresaSupervisoraVO> getQuery() throws SQLException{
        listaEmpresasSup=this.empSupServiceImp.query();
        listaTipoDocumento = this.tipoDocumentoServiceImp.query();
        for (int i = 0 ; i< listaEmpresasSup.size();i++){
            for(int j=0; j<listaTipoDocumento.size();j++){
                if(listaEmpresasSup.get(i).getTdoId() == listaTipoDocumento.get(j).getTdoId()){
                    listaEmpresasSup.get(i).setDescripcionDoc(listaTipoDocumento.get(j).getTdoNombre());
                }
            }
        }

        return listaEmpresasSup; 
        
    }




    public void cargarSupervisoresxInfraestructura() throws Exception {

        listarSupervisoresxInfraestructura =
            supervisorInversionesServiceImpl.buscarSupervisoresxInfraestructura(codigoTipoInfraestructurafiltro);
        System.out.println(""+listarSupervisoresxInfraestructura.size());
    }


    public void setListaResponsables(List<HashMap<String, Object>> listaResponsables) {
        this.listaResponsables = listaResponsables;
    }

    public List<HashMap<String, Object>> getListaResponsables() {
        return listaResponsables;
    }
    
    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }
 
 
    
   
    public void seleccionarContratoConcesion(ActionEvent actionEvent){
            contratoVO = (ContratoVO) actionEvent.getComponent().getAttributes().get("contrato");
            nombreDescripcionModalidadConcesion=contratoVO.getConAsunto();
            nombreDescripcionContratoConcesion=contratoVO.getNombreConcesion();
            for (InfraestructuraTipoVO infraes: listaInfraestructuraTipos) {
                if(infraes.getTinId()==contratoVO.getTinId()){
                nombreDescripcionTipoInfraestructura=infraes.getTinDescripcion();
                } 
            }          
        }
    
    public void seleccionarContratoConcesion1(ActionEvent actionEvent) throws Exception{      
            contratoVO = (ContratoVO) actionEvent.getComponent().getAttributes().get("contrato");
         
            nameTipoInfraestructura=contratoVO.getNombreTipoInfraestructura();
            System.out.println(nameTipoInfraestructura);
                nameContrato=contratoVO.getNombreConcesion();
                System.out.println(nameContrato);
            nameModalidadConcesion=contratoVO.getNombreModalidad();
            System.out.println(nameModalidadConcesion);
                codigoContrato = contratoVO.getConId();
                codigoTipoInfraestructurafiltro = contratoVO.getTinId();
                
                // LLeno el Bean de la Cabecera de la Asignación de Responsable de Supervisión
                System.out.println("concesion = " + contratoVO.getCsiId());
                contratoRespSupVO.setCsiId(contratoVO.getCsiId()); 
                contratoRespSupVO.setTinId(contratoVO.getTinId());
                contratoRespSupVO.setMcoId(contratoVO.getMcoId());                
                cargarInversion();   
            }
    
    
    public void seleccionarEmpresa(ActionEvent actionEvent) throws Exception{
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        EmpresaSupervisoraVO empresa = (EmpresaSupervisoraVO) actionEvent.getComponent().getAttributes().get("empresa");
        int validaReg = 0;
        try{
         validaReg = asignarResponsableSupervisionServiceImpl.ValidaAsignación(contratoVO.getConId(), contratoVO.getTinId(), contratoCompromisoSeleccionado, contratoVO.getCsiId(), 0, 0, empresa.getTdoId(), empresa.getSupNroDocumento(), 2);
             }catch (Exception e){
                 System.out.println(e);
             }
        for(int i=0; i<listaDetalleAsignacion.size();i++){
            if(listaDetalleAsignacion.get(i).getTipoSup() == 2 && listaDetalleAsignacion.get(i).getCodigoSup() == empresa.getSupId()){
                validaReg = 1;
            }
        }
        
        if(validaReg == 0){
            
        System.out.println(empresa.getSupNombre());
        HashMap<String, Object> record = new HashMap<String, Object>();
        record.put("Etapa", "Falta");
        record.put("nombre", empresa.getSupNombre());        
        record.put("tipoDocumento", empresa.getDescripcionDoc());
        record.put("numeroDocumento", empresa.getSupNroDocumento()); 
        record.put("fechaAsignacion", dt1.format(new Date()));    
        record.put("tipoSupervision", 2);
        record.put("codigoSupervisor", empresa.getSupId());        
        if (empresa.getSupEstado() == 1){
            record.put("estado", "Activo");
            }else{
                record.put("estado", "Inactivo");
            }
        record.put("id",0);
        
        listaResponsables.add(record);
        contratoResSupDetalleVO = new ContratoResSupDetalleVO();
        contratoResSupDetalleVO.setRsdEstado(1);
        contratoResSupDetalleVO.setTdoId(empresa.getTdoId());
        contratoResSupDetalleVO.setRsdNroDocumento(empresa.getSupNroDocumento());
        contratoResSupDetalleVO.setTccTipo(1);
        contratoResSupDetalleVO.setRsdFechaAsignacion(util.getObtenerFechaHoy());      
        contratoResSupDetalleVO.setConId(contratoRespSupVO.getCsiId());
        contratoResSupDetalleVO.setTipoSup(2);
        contratoResSupDetalleVO.setCodigoSup(empresa.getSupId());
        listaDetalleAsignacion.add(contratoResSupDetalleVO);
        }else{
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Empresa Supervisora ya Asignada");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }

    }
    
    public void seleccionarSupervisor() {
        if(codigoContrato > 0 && contratoCompromisoSeleccionado > 0){
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        contratoResSupDetalleVO = new ContratoResSupDetalleVO();
        System.out.println(listarSupervisoresxInfraestructura.size());
        System.out.println(codigoSupervisor);
        HashMap<String, Object> record = new HashMap<String, Object>();
        for (SupervisorInversionesVO supervisor : listarSupervisoresxInfraestructura) {
            if (supervisor.getTsiId() == codigoSupervisor) {
                
                int validaReg = 0;
                try{
                 validaReg = asignarResponsableSupervisionServiceImpl.ValidaAsignación(contratoVO.getConId(), contratoVO.getTinId(), contratoCompromisoSeleccionado, contratoVO.getCsiId(), 0, 0, supervisor.getTdoId(), supervisor.getTsiNroDocumento(), 2);
                     }catch (Exception e){
                         System.out.println(e);
                     }
                for(int i=0; i<listaDetalleAsignacion.size();i++){
                    if(listaDetalleAsignacion.get(i).getTipoSup() == 1 && listaDetalleAsignacion.get(i).getCodigoSup() == supervisor.getTsiId()){
                        validaReg = 1;
                    }
                }
                if(validaReg == 0){
                
                
                record.put("numeroDocumento", supervisor.getTsiNroDocumento());
                
                if (supervisor.getTdoId() == 1){
                    record.put("tipoDocumento", "DNI");
                }else{
                    record.put("tipoDocumento", "RUC");
                }
                record.put("nombre", supervisor.getTsiNombre());
                record.put("fechaAsignacion", dt1.format(new Date()));
                record.put("tipoSupervision", 1);
                record.put("codigoSupervisor", supervisor.getTsiId());
                if (supervisor.getTsiHabilitado() == 1){
                    record.put("estado", "Activo");
                    }else{
                        record.put("estado", "Inactivo");
                    }
                record.put("id",0);
                contratoResSupDetalleVO.setRsdEstado(1);
                contratoResSupDetalleVO.setTdoId(supervisor.getTdoId());
                contratoResSupDetalleVO.setRsdNroDocumento(supervisor.getTsiNroDocumento());
                contratoResSupDetalleVO.setConId(contratoRespSupVO.getCsiId());
                contratoResSupDetalleVO.setTccTipo(1);
                contratoResSupDetalleVO.setRsdFechaAsignacion(util.getObtenerFechaHoy());   
                contratoResSupDetalleVO.setTipoSup(1);
                contratoResSupDetalleVO.setCodigoSup(supervisor.getTsiId());
                listaResponsables.add(record);
                listaDetalleAsignacion.add(contratoResSupDetalleVO);
                    }else{
                        FacesMessage mensaje =
                            new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Coordinador InSitu ya Asignado");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
                    }
            }            
        }
    }else{
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione un Contrato de Concesión y una Etapa o Periodo");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }

    public void setListaContratosConcesion(List<ContratoVO> listaContratosConcesion) {
        this.listaContratosConcesion = listaContratosConcesion;
    }

    public List<ContratoVO> getListaContratosConcesion() {
        return listaContratosConcesion;
    }


    //INICIO CONTRATO CONCESION

    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    private ContratoConcesionService contratoConcesionServiceImp;
    @ManagedProperty(value = "#{concesionServicesImpl}")
    ConcesionService concesionServicesImpl;
    
    public void cargarListaTiposInfraestructura() {
        try {
            listaInfraestructuraTipos = infraestructuraTipoServiceImpl.query();
            System.out.println("tamanio infraestructura: " + listaInfraestructuraTipos.size());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    private InfraestructuraTipoVO infraestructuraTipoVO;
   
    @ManagedProperty(value="#{modalidadVO}")
    public ModalidadConcesionVO modalidadVO;

    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionServiceImpl modalidadServiceImp;

    public void cargarListaContratos() {
        try {
            listaContratosConcesion = contratoConcesionServiceImp.query();
            listaInfraestructuraTipos = infraestructuraTipoServiceImpl.query();
            for (ContratoVO contra : listaContratosConcesion) {
                ConcesionVO concesion = new ConcesionVO();
                concesion = concesionServicesImpl.get(contra.getCsiId());
                contra.setNombreConcesion(concesion.getCsiNombre());
                contra.setCodigoConcesion(concesion.getCsiId());
                
                InfraestructuraTipoVO objtipinfra = new InfraestructuraTipoVO();
                objtipinfra = infraestructuraTipoServiceImpl.get(contra.getTinId());
                contra.setNombreTipoInfraestructura(objtipinfra.getTinNombre());
                contra.setTinId(objtipinfra.getTinId());
                
                ModalidadConcesionVO objtmodcon = new ModalidadConcesionVO();
                objtmodcon = modalidadServiceImp.get(contra.getMcoId()); 
                contra.setNombreModalidad(objtmodcon.getMcoNombre());
                contra.setMcoId(objtmodcon.getMcoId());
            }
            
            } catch (Exception e) {

            e.printStackTrace();
        }

    }
    
    
    
    public void cargarInversion(){
           try {
        listaContratoCompromiso=contratoCompromisoServiceImpl.querySupervisado(codigoContrato);
          } catch (Exception e) {
               e.printStackTrace();
           }   
           }
                   
                   
   // Para que se carge o selecionado
     public void cargarDatosCompromiso() throws Exception{
           try {
              SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
              contratoCompromisoVO=contratoCompromisoServiceImpl.get(contratoCompromisoSeleccionado);
              plazo=contratoCompromisoVO.getCcoPlazo();
              total=""+contratoCompromisoVO.getCcoTotal();
              codigoMoneda=contratoCompromisoVO.getMonId();
               if(codigoMoneda == 1){
                   nombreMoneda = "Nuevos Soles";
               }else{
                   nombreMoneda="Dolares Americanos";
               }
              listaDetalleAsignacion = new ArrayList<ContratoResSupDetalleVO>();
               System.out.println("Contrato compromiso seleccionado = "+contratoCompromisoSeleccionado);
              listaDetalleAsignacion = asignarResponsableSupervisionServiceImpl.ListarDetalle(codigoContrato,contratoCompromisoSeleccionado);
               System.out.println("EL TAMAÑO DEL SIZE DE LA LISTA DE DETALLE DE ASIGNACION ES IGUAL A = "+listaDetalleAsignacion.size());
              listaResponsables=new ArrayList<HashMap<String, Object>>();
               
              for (ContratoResSupDetalleVO detalle : listaDetalleAsignacion) {         
                    String nombre = asignarResponsableSupervisionServiceImpl.ObtieneNombre(detalle.getTdoId(), detalle.getRsdNroDocumento(),detalle.getTipoSup());
                    HashMap<String, Object> record = new HashMap<String, Object>();
                    record.put("tipoSupervision", detalle.getTipoSup());
                    record.put("codigoSupervisor", detalle.getCodigoSup());  
                    record.put("Etapa", "Falta");
                    record.put("nombre", nombre);
                    if (detalle.getTdoId() == 1){
                        record.put("tipoDocumento", "DNI");
                    }else{
                        record.put("tipoDocumento", "RUC");
                    }
                    record.put("numeroDocumento", detalle.getRsdNroDocumento()); 
                    record.put("fechaAsignacion", dt1.format(detalle.getRsdFechaAsignacion()));        
                    if (detalle.getRsdEstado() == 1){
                        record.put("estado", "Activo");
                        }else{
                            record.put("estado", "Inactivo");
                        }
                    record.put("id",detalle.getRsdId());
                    record.put("codEstado",detalle.getRsdEstado());                 
                    listaResponsables.add(record);    
                    
                } 
              listarSupervisoresxInfraestructura =
                  supervisorInversionesServiceImpl.buscarSupervisoresxInfraestructura(codigoTipoInfraestructurafiltro);
               
               
          } catch (Exception e) {
              System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
              e.printStackTrace();
           }        
       }
    
    
    // Guardar Cambios
     
    public int ValidarDatos(){
        
        return 0;
        
    }
    
     
     public void Guardar() throws Exception{
         ContratoRespSupVO contrato_Cab = new ContratoRespSupVO();
         int eliminar=0;
         if(ValidarDatos() == 0){
             try{
                 contrato_Cab = asignarResponsableSupervisionServiceImpl.ValidaCab(contratoRespSupVO.getCsiId(),contratoCompromisoSeleccionado);
                 // Nuevo Registro de Supervisión por etapa                 
                 if( contrato_Cab == null){
                     contratoCompromisoVO.setTccTipo(1);                  
                     contratoRespSupVO.setConId(contratoVO.getConId());
                     contratoRespSupVO.setCcoId(contratoCompromisoSeleccionado);
                     contratoRespSupVO.setTccTipo(1);
                     contratoRespSupVO = asignarResponsableSupervisionServiceImpl.insertCab(contratoRespSupVO);
                     for (int i = 0; i<listaDetalleAsignacion.size(); i++){
                         listaDetalleAsignacion.get(i).setRsuId(contratoRespSupVO.getRsuId());
                         listaDetalleAsignacion.get(i).setCcoId(contratoCompromisoSeleccionado);
                         asignarResponsableSupervisionServiceImpl.insertDet(listaDetalleAsignacion.get(i));
                         
                     }
                     FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Registro con Exito");
                                                                 FacesContext.getCurrentInstance().addMessage(null, mensaje);
                     contratoRespSupVO.setRsuId(null);                     
                     contratoRespSupVO.setInfId(null);
                     contratoRespSupVO.setInvId(null);                    
                     contratoRespSupVO.setTsiId(null);
                     
                 }else{
                     for (int i = 0; i<listaDetalleAsignacion.size(); i++){
                         // Nuevo Registro de Supervisor de Inversiones o Empresa Supervisora
                         if(listaDetalleAsignacion.get(i).getRsdId() == null || listaDetalleAsignacion.get(i).getRsdId() == 0){
                             listaDetalleAsignacion.get(i).setRsuId(contrato_Cab.getRsuId());
                             listaDetalleAsignacion.get(i).setRsdFechaAsignacion(util.getObtenerFechaHoy());
                             listaDetalleAsignacion.get(i).setCcoId(contratoCompromisoSeleccionado);
                             asignarResponsableSupervisionServiceImpl.insertDet(listaDetalleAsignacion.get(i));
                             
                             
                             // Desactivación o Eliminación del Supervisor de Inversiones o Empresa Supervisora
                         }else{
                             
                             asignarResponsableSupervisionServiceImpl.updateDet(listaDetalleAsignacion.get(i));
                             
                         }
                     }
                     listaBd = asignarResponsableSupervisionServiceImpl.ListarDetalle(codigoContrato,contratoCompromisoSeleccionado);
                     for(int i=0;i<listaBd.size();i++){
                        for(int j=0;j<listaDetalleAsignacion.size();j++){
                            if(listaBd.get(i).getTipoSup() == listaDetalleAsignacion.get(j).getTipoSup() && listaBd.get(i).getCodigoSup() == listaDetalleAsignacion.get(j).getCodigoSup()){
                                eliminar = 1;
                            }
                        }
                         if(eliminar == 0){
                             listaBd.get(i).setRsdEstado(0);
                             asignarResponsableSupervisionServiceImpl.updateDet(listaBd.get(i));
                         }
                         eliminar = 0;
                     }
                     FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Registro con Exito");
                                                                 FacesContext.getCurrentInstance().addMessage(null, mensaje);
                     
                 }
                 listaResponsables=new ArrayList<HashMap<String, Object>>();
                 cargarDatosCompromiso();
             }catch(Exception e){
                 System.out.println(e);
                 FacesMessage mensaje =
                     new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Error" + e.getMessage());
                 FacesContext.getCurrentInstance().addMessage(null, mensaje);
             }
         }
         
     }
   

   
    
    
    

}

