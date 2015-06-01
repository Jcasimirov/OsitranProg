package com.ositran.contratos;

import com.ositran.service.ConcesionarioService;
import com.ositran.service.DatosStdService;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.serviceimpl.TipoDocumentoServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.util.Util;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TipoDocumentoVO;
import com.ositran.vo.bean.UsuarioVO;
import com.ositran.vo.bean.ViewTdInternosVO;

import java.io.IOException;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;

@ManagedBean(name = "bk_registrarContrato")
@ViewScoped
public class RegistrarContratoMB {
    
    //-----------------SESSION-----------------------//
    public  final int formulario=26;
    private RolOpcionesVO rolOpcion;
    private UsuarioVO usuario;
    private int tipoInfraestructura;
    private String ipcliente;

    public void validarSesion() throws IOException {
        usuario = Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
        setUsuario(Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado());
        setTipoInfraestructura(usuario.getTinId());
        ipcliente = Reutilizar.getNewInstance().obtenerIpCliente();
    }
    //---------------------------------------------//

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setTipoInfraestructura(int tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public int getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setIpcliente(String ipcliente) {
        this.ipcliente = ipcliente;
    }

    public String getIpcliente() {
        return ipcliente;
    }

    private HtmlForm form;
    Util util = new Util();

    // Service

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionServiceImpl concesionServiceImpl;

    @ManagedProperty(value = "#{tipoDocumentoServiceImp}")
    private TipoDocumentoServiceImpl tipoDocumentoServiceImp;

    @ManagedProperty(value = "#{concesionarioServiceImpl}")
    ConcesionarioService concesionarioServiceImpl;

    @ManagedProperty(value = "#{datosStdServiceImpl}")
    DatosStdService datosStdServiceImpl;

    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionServiceImpl modalidadServiceImp;
    
    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionServiceImpl contratoConcesionServiceImp;

    // Bean VO

    @ManagedProperty(value = "#{concesionarioVO}")
    ConcesionarioVO concesionarioVO;

    @ManagedProperty(value = "#{ViewTdInternosVO}")
    ViewTdInternosVO viewTdInternosVO;
    
    @ManagedProperty(value = "#{contratoVO}")
    ContratoVO contratoVO;

    // Lista Bean VO

    List<InfraestructuraTipoVO> listaInfraestructura;

    List<ConcesionVO> listaConcesiones;

    List<TipoDocumentoVO> listaTipoDocumento;

    List<ConcesionarioVO> listaConcesionario;

    List<ModalidadConcesionVO> listaModalidad;

    // Metodos Get y Set de los Valores Declarados

    public void setForm(HtmlForm form) {
        this.form = form;
    }

    public HtmlForm getForm() {
        return form;
    }


    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }


    public void setListaInfraestructura(List<InfraestructuraTipoVO> listaInfraestructura) {
        this.listaInfraestructura = listaInfraestructura;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructura() {
        return listaInfraestructura;
    }


    public void setConcesionServiceImpl(ConcesionServiceImpl concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public ConcesionServiceImpl getConcesionServiceImpl() {
        return concesionServiceImpl;
    }

    public void setListaConcesiones(List<ConcesionVO> listaConcesiones) {
        this.listaConcesiones = listaConcesiones;
    }

    public List<ConcesionVO> getListaConcesiones() {
        return listaConcesiones;
    }


    public void setTipoDocumentoServiceImp(TipoDocumentoServiceImpl tipoDocumentoServiceImp) {
        this.tipoDocumentoServiceImp = tipoDocumentoServiceImp;
    }

    public TipoDocumentoServiceImpl getTipoDocumentoServiceImp() {
        return tipoDocumentoServiceImp;
    }

    public void setListaTipoDocumento(List<TipoDocumentoVO> listaTipoDocumento) {
        this.listaTipoDocumento = listaTipoDocumento;
    }

    public List<TipoDocumentoVO> getListaTipoDocumento() {
        return listaTipoDocumento;
    }


    public void setConcesionarioServiceImpl(ConcesionarioService concesionarioServiceImpl) {
        this.concesionarioServiceImpl = concesionarioServiceImpl;
    }

    public ConcesionarioService getConcesionarioServiceImpl() {
        return concesionarioServiceImpl;
    }

    public void setListaConcesionario(List<ConcesionarioVO> listaConcesionario) {
        this.listaConcesionario = listaConcesionario;
    }

    public List<ConcesionarioVO> getListaConcesionario() {
        return listaConcesionario;
    }


    public void setConcesionarioVO(ConcesionarioVO concesionarioVO) {
        this.concesionarioVO = concesionarioVO;
    }

    public ConcesionarioVO getConcesionarioVO() {
        return concesionarioVO;
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

    public void setModalidadServiceImp(ModalidadConcesionServiceImpl modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionServiceImpl getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public void setListaModalidad(List<ModalidadConcesionVO> listaModalidad) {
        this.listaModalidad = listaModalidad;
    }

    public List<ModalidadConcesionVO> getListaModalidad() {
        return listaModalidad;
    }

    public void setContratoConcesionServiceImp(ContratoConcesionServiceImpl contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public ContratoConcesionServiceImpl getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    // Metodo Para Listar Tipo de Infraestructuras

    public void ListarInfraestructura() throws SQLException {
        try {
            listaInfraestructura = getInfraestructuraTipoServiceImpl().query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    // Metodo para Filtrar la Lista de Concesión
    public void filtrarConcesion() throws SQLException {
        try {
            listaConcesiones = concesionServiceImpl.filtrarConcesion(tipoinfra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo para Listar Tipo de Documento

    public void ListarTipoDocumento() throws SQLException {
        try {
            listaTipoDocumento = this.tipoDocumentoServiceImp.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    // Metodo para Listar Modalidad de Concesión
    public void ListarModalidad() throws SQLException {
        try {
            listaModalidad = this.modalidadServiceImp.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    // Buscar Concesionario

    //Parametros
    String nomconcesionario;
    String siglasconcesionario;
    int tipodocumento;
    String nrodocumento;
    String busqueda;


    public void setNomconcesionario(String nomconcesionario) {
        this.nomconcesionario = nomconcesionario;
    }

    public String getNomconcesionario() {
        return nomconcesionario;
    }

    public void setSiglasconcesionario(String siglasconcesionario) {
        this.siglasconcesionario = siglasconcesionario;
    }

    public String getSiglasconcesionario() {
        return siglasconcesionario;
    }

    public void setTipodocumento(int tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public int getTipodocumento() {
        return tipodocumento;
    }

    public void setNrodocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    public String getNrodocumento() {
        return nrodocumento;
    }


    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public String getBusqueda() {
        return busqueda;
    }

    // Registrar Contrato de Concesion

    // Parametros
    String nrohr;
    String añohr;
    String freghr;
    String asuntohr;
    String nombreConcesionarioBus;
    String siglasConcesionarioBus;
    String direccionConcesionarioBus;
    int tipoinfra;
    int concesion;
    int concesionario;
    int modalidad;
    int añohrbus;
    int nrohrbus;

    // Get y Set de los Parametros


    public void setAñohrbus(int añohrbus) {
        this.añohrbus = añohrbus;
    }

    public int getAñohrbus() {
        return añohrbus;
    }

    public void setNrohrbus(int nrohrbus) {
        this.nrohrbus = nrohrbus;
    }

    public int getNrohrbus() {
        return nrohrbus;
    }

    public void setNrohr(String nrohr) {
        this.nrohr = nrohr;
    }

    public String getNrohr() {
        return nrohr;
    }


    public void setAñohr(String añohr) {
        this.añohr = añohr;
    }

    public String getAñohr() {
        return añohr;
    }


    public void setFreghr(String freghr) {
        this.freghr = freghr;
    }

    public String getFreghr() {
        return freghr;
    }

    public void setAsuntohr(String asuntohr) {
        this.asuntohr = asuntohr;
    }

    public String getAsuntohr() {
        return asuntohr;
    }

    public void setTipoinfra(int tipoinfra) {
        this.tipoinfra = tipoinfra;
    }

    public int getTipoinfra() {
        return tipoinfra;
    }

    public void setConcesion(int concesion) {
        this.concesion = concesion;
    }

    public int getConcesion() {
        return concesion;
    }

    public void setConcesionario(int concesionario) {
        this.concesionario = concesionario;
    }

    public int getConcesionario() {
        return concesionario;
    }


    public void setNombreConcesionarioBus(String nombreConcesionarioBus) {
        this.nombreConcesionarioBus = nombreConcesionarioBus;
    }

    public String getNombreConcesionarioBus() {
        return nombreConcesionarioBus;
    }


    public void setSiglasConcesionarioBus(String siglasConcesionarioBus) {
        this.siglasConcesionarioBus = siglasConcesionarioBus;
    }

    public String getSiglasConcesionarioBus() {
        return siglasConcesionarioBus;
    }

    public void setDireccionConcesionarioBus(String direccionConcesionarioBus) {
        this.direccionConcesionarioBus = direccionConcesionarioBus;
    }

    public String getDireccionConcesionarioBus() {
        return direccionConcesionarioBus;
    }

    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }

    public int getModalidad() {
        return modalidad;
    }
    // Cargar Campo de Busqueda
    public void BusquedaAutomatica() throws SQLException {
        busqueda="";
        listaConcesionario=new ArrayList<ConcesionarioVO>();
        nomconcesionario="";
        nrodocumento="";
        /*
        nomconcesionario = busqueda;
        if (busqueda != null && !busqueda.trim().equals("")) {
            try {
                listaConcesionario = this.concesionarioServiceImpl.BusquedaConcesionario(nomconcesionario, "", 0, "");
            } catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
            }
        }
*/
    }

    public void BusquedaConcesionario() throws SQLException {
         
        if (tipodocumento == 0 && nrodocumento.trim().equals("") && nomconcesionario.trim().equals("") && siglasconcesionario.trim().equals("") ) {
                        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Criterio de Busqueda");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
                    
        }else if (tipodocumento >0 && !nrodocumento.matches("[0-9]*") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento Inválido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipodocumento == 0 && !nrodocumento.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione Tipo de Documento");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipodocumento > 0 && nrodocumento.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro. de Documento");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else{

        try {
            listaConcesionario = this.concesionarioServiceImpl.BusquedaConcesionario(nomconcesionario.trim(), siglasconcesionario.trim(), tipodocumento, nrodocumento.trim());
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        }
    }


    public void datosConcesionario() throws SQLException{
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("id");
        Integer idConcesionario = Integer.valueOf(str.toString());
        try {
            concesionarioVO = concesionarioServiceImpl.get(idConcesionario);
            nombreConcesionarioBus = concesionarioVO.getCncNombre();
            siglasConcesionarioBus = concesionarioVO.getCncSiglas();
            direccionConcesionarioBus = concesionarioVO.getCncDireccion();
            concesionario = concesionarioVO.getCncId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void BuscarStd() throws SQLException{
        if (nrohr.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!nrohr.trim().equals("") && Integer.parseInt(nrohr) < 0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (añohr.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese un Año de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!añohr.trim().equals("") &&  Integer.parseInt(añohr) < 0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!añohr.trim().equals("") && añohr.length() < 4 ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else{
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            viewTdInternosVO = datosStdServiceImpl.BuscaStd(Integer.parseInt(añohr), nrohr);
            if (viewTdInternosVO !=null && viewTdInternosVO.getFechaRegistro() != null){
                freghr = dt1.format(viewTdInternosVO.getFechaRegistro());
                asuntohr = viewTdInternosVO.getAsunto();
                añohrbus = viewTdInternosVO.getAnyo();
                nrohrbus = Integer.parseInt(viewTdInternosVO.getNroRegistro());
            }else{
                freghr = "";
                asuntohr = "";
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se Encontraron Registros");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
    
    public void GrabarContratoConcesion() throws SQLException{
        if (freghr == null || freghr.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (freghr.trim().equals("") && asuntohr.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Asunto del Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoinfra == 0 ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione una Tipo de Infraestructura");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (modalidad == 0 ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione una Modalidad de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (concesion == 0 ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione una Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (concesionario == 0 ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese un Concesionario");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (ValidaContratoConcesion(concesion,tipoinfra) > 0 ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ya Existe el Contrato de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else{
        try{
            contratoVO.setConTerminal(ipcliente);
            contratoVO.setConUsuarioAlta(usuario.getUsuAlias());
            contratoVO.setConFechaAlta(util.getObtenerFechaHoy());
            contratoVO.setMcoId(modalidad);
            contratoVO.setTinId(tipoinfra);
            contratoVO.setCsiId(concesion);
            contratoVO.setCncId(concesionario);
            contratoVO.setConAnyo(añohrbus);
            contratoVO.setConNumero(nrohrbus);
            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
            contratoVO.setConFechaRegistro(dt1.parse(freghr));
            contratoVO.setConAsunto(asuntohr);
            contratoVO.setConEstado(1);          
            contratoConcesionServiceImp.insert(contratoVO);
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Registro con Exito");
                                                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
            limpiarCamposTotales();
        }catch(Exception e){
            System.out.println(e);
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se Puedo Registrar el Contrato de Concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        }
    }
    
    public int ValidaContratoConcesion (int concesion, int tipoinfra) throws SQLException{
        int resultado = this.contratoConcesionServiceImp.ValidarContratoConcesion(concesion,tipoinfra);
        return resultado;
    }
    
    public void limpiarCamposTotales()throws SQLException{
        nomconcesionario = "";
        siglasconcesionario = "";
        tipodocumento = 0;
        nrodocumento = "";
        busqueda = "";
        nrohr = "";
        añohr = "";
        freghr = "";
        asuntohr = "";
        nombreConcesionarioBus = "";
        siglasConcesionarioBus = "";
        direccionConcesionarioBus = "";
        tipoinfra = 0;
        concesion = 0;
        concesionario = 0;
        modalidad = 0;
        añohrbus = 0;
        nrohrbus = 0;
        filtrarConcesion();
    }


}
