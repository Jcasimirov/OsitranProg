package com.ositran.contratos;
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

@ManagedBean(name = "asignarResponsableMB")
@ViewScoped
public class AsignarResponsableSupervision {


//sesiones inicio
public  final int formulario=7;

//sessiones


private String nameContrato;
private String nameTipoInfraestructura;
private String nameModalidadConcesion;
private int contratoCompromisoSeleccionado;
private String nombreDescripcionModalidadConcesion;
private String nombreDescripcionTipoInfraestructura;
private String nombreDescripcionContratoConcesion;
private int codigoEtapa;
private int plazo;
private Double moneda;
private int codigoMoneda;
private long total;
HtmlForm form1;
HtmlForm form2;
private String nombreEmpresaSupervisora;
private String rucEmpresaSupervisora;
private String nombreContratoConcesion;
private int codigoTipoInfraestructurafiltro;
private int codigoSupervisor;
private int codigoContrato;

// de  abel 
  
  
  //Bean VO
    private RolOpcionesVO rolOpcion;

    @ManagedProperty(value = "#{contratoCompromisoVO}")
      ContratoCompromisoVO contratoCompromisoVO;

    @ManagedProperty(value = "#{empSupVO}")
    private EmpresaSupervisoraVO empSupVO;
    
    @ManagedProperty(value = "#{supervisorInversionesVO}")
    private SupervisorInversionesVO supervisorInversionesVO;



    public void validarSesion() throws IOException{
      rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
    }


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



//get y set
    
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

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setMoneda(Double moneda) {
        this.moneda = moneda;
    }

    public Double getMoneda() {
        return moneda;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotal() {
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


    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
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





    public void eliminacionConfirmadaResponsable() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("rowId");
        int idcodigo = Integer.valueOf(str.toString());
        listaResponsables.remove(idcodigo);
    }


    public void filtrarListaEmpSup(){
        try {
            System.out.println("entro FiltrarListaEmpSup: " + listaEmpresasSup.size());
            System.out.println(nombreEmpresaSupervisora);
            System.out.println(rucEmpresaSupervisora);
            listaEmpresasSup = empSupServiceImp.FiltrarEmpSup(nombreEmpresaSupervisora, rucEmpresaSupervisora);
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
 
 
    
   
    public void seleccionarContratoConcesion(ActionEvent actionEvent){
            ContratoVO contrato = (ContratoVO) actionEvent.getComponent().getAttributes().get("contrato");
            nombreDescripcionModalidadConcesion=contrato.getConAsunto();
            nombreDescripcionContratoConcesion=contrato.getNombreConcesion();
            for (InfraestructuraTipoVO infraes: listaInfraestructuraTipos) {
                if(infraes.getTinId()==contrato.getTinId()){
                nombreDescripcionTipoInfraestructura=infraes.getTinDescripcion();
                } 
            }          
        }
    
    public void seleccionarContratoConcesion1(ActionEvent actionEvent) throws Exception{      
            ContratoVO contrato = (ContratoVO) actionEvent.getComponent().getAttributes().get("contrato");
         
            nameTipoInfraestructura=contrato.getNombreTipoInfraestructura();
            System.out.println(nameTipoInfraestructura);
                nameContrato=contrato.getNombreConcesion();
                System.out.println(nameContrato);
            nameModalidadConcesion=contrato.getNombreModalidad();
            System.out.println(nameModalidadConcesion);
                codigoContrato = contrato.getConId();
                codigoTipoInfraestructurafiltro = contrato.getTinId();
                listarSupervisoresxInfraestructura =
                    supervisorInversionesServiceImpl.buscarSupervisoresxInfraestructura(codigoTipoInfraestructurafiltro);
                System.out.println(""+listarSupervisoresxInfraestructura.size());
                cargarInversion();
                
            }
    
    
    public void seleccionarEmpresa(ActionEvent actionEvent) {
        EmpresaSupervisoraVO empresa = (EmpresaSupervisoraVO) actionEvent.getComponent().getAttributes().get("empresa");
        System.out.println(empresa.getSupNombre());
        HashMap<String, Object> record = new HashMap<String, Object>();
        record.put("Etapa", "Falta");
        record.put("nombre", empresa.getSupNombre());
        record.put("tipoDocumento", empresa.getDescripcionDoc());
        record.put("numeroDocumento", empresa.getSupNroDocumento()); 
        record.put("fechaAsignacion", (new Date()));        
        if (empresa.getSupEstado() == 1){
            record.put("estado", "Activo");
            }else{
                record.put("estado", "Inactivo");
            }
        listaResponsables.add(record);


    }
    
    

    
    
    public void seleccionarSupervisor() {
       
        System.out.println(listarSupervisoresxInfraestructura.size());
        System.out.println(codigoSupervisor);
        HashMap<String, Object> record = new HashMap<String, Object>();
        for (SupervisorInversionesVO supervisor : listarSupervisoresxInfraestructura) {
            if (supervisor.getTsiId() == codigoSupervisor) {
                record.put("numeroDocumento", supervisor.getTsiNroDocumento());
                record.put("tipoDocumento", supervisor.getTdoId());
                record.put("nombre", supervisor.getTsiNombre());
                record.put("fechaAsignacion", (new Date()));
                if (supervisor.getTsiHabilitado() == 1){
                    record.put("estado", "Activo");
                    }else{
                        record.put("estado", "Inactivo");
                    }
                
            }
        }

        listaResponsables.add(record);
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
            System.out.println("1");
            listaContratosConcesion = contratoConcesionServiceImp.query();
                System.out.println("2");
            listaInfraestructuraTipos = infraestructuraTipoServiceImpl.query();
                System.out.println("3");
            for (ContratoVO contra : listaContratosConcesion) {
                ConcesionVO concesion = new ConcesionVO();
                System.out.println("4");
                concesion = concesionServicesImpl.get(contra.getCsiId());
                System.out.println("5");
                contra.setNombreConcesion(concesion.getCsiNombre());
                System.out.println("6");
                contra.setCodigoConcesion(concesion.getCsiId());
                
                InfraestructuraTipoVO objtipinfra = new InfraestructuraTipoVO();
                System.out.println("7");
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
        listaContratoCompromiso=contratoCompromisoServiceImpl.query1(codigoContrato);
          } catch (Exception e) {
               e.printStackTrace();
           }   
           }
                   
                   
   // Para que se carge o selecionado
     public void cargarDatosCompromiso(){
           try {
              contratoCompromisoVO=contratoCompromisoServiceImpl.get(contratoCompromisoSeleccionado);
              plazo=contratoCompromisoVO.getCcoPlazo();
              total=contratoCompromisoVO.getCcoTotal();
              codigoMoneda=contratoCompromisoVO.getMonId();
               
          } catch (Exception e) {
              System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
              e.printStackTrace();
           }        
       }
    
    
   

   
    
    
    

}

