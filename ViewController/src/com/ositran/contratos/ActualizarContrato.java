package com.ositran.contratos;

import com.ositran.service.ConcesionarioService;
import com.ositran.service.DatosStdService;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.DatosStdServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.serviceimpl.TipoDocumentoServiceImpl;
import com.ositran.util.Util;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.TipoDocumentoVO;
//import com.ositran.vo.bean.VwDocInternoVO;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;

@ManagedBean(name = "actualizarContratoMB")
@ViewScoped
public class ActualizarContrato {


    private HtmlForm form;
    Util util = new Util();

    // Service

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{concesionServicesImpl}")
    ConcesionServiceImpl concesionServicesImpl;

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

    //@ManagedProperty(value = "#{vwDocInternoVO}")
    //VwDocInternoVO vwDocInternoVO;
    
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


    public void setConcesionServicesImpl(ConcesionServiceImpl concesionServicesImpl) {
        this.concesionServicesImpl = concesionServicesImpl;
    }

    public ConcesionServiceImpl getConcesionServicesImpl() {
        return concesionServicesImpl;
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

    /*     public void setVwDocInternoVO(VwDocInternoVO vwDocInternoVO) {
        this.vwDocInternoVO = vwDocInternoVO;
    } */

    /*  public VwDocInternoVO getVwDocInternoVO() {
        return vwDocInternoVO;
    } */

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
            listaConcesiones = concesionServicesImpl.filtrarConcesion(tipoinfra);
        } catch (Exception e) {
            // TODO: Add catch code
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

    // Get y Set de los Parametros

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
        nomconcesionario = busqueda;
        if (busqueda != null && !busqueda.trim().equals("")) {
            try {
                listaConcesionario = this.concesionarioServiceImpl.BusquedaConcesionario(nomconcesionario, "", 0, "");
            } catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
            }
        }
    }

    public void BusquedaConcesionario() throws SQLException {

        try {
            listaConcesionario = this.concesionarioServiceImpl.BusquedaConcesionario(nomconcesionario, "", 0, "");
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
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
            siglasConcesionarioBus = concesionarioVO.getCncDescripcion();
            direccionConcesionarioBus = concesionarioVO.getCncDireccion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* public void BuscarStd() throws SQLException{
        int año = 1900;
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
        try {
            if (añohr.matches("[0-9]*")){
                año = Integer.parseInt(añohr);
            }
            vwDocInternoVO = datosStdServiceImpl.BuscaStd(año, nrohr);
            if (vwDocInternoVO !=null){
                freghr = dt1.format(vwDocInternoVO.getVdiFechaRegistro());
                asuntohr = vwDocInternoVO.getVdiAsunto();
            }else{
                freghr = "";
                asuntohr = "";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    } */
    
    public void GrabarConcesion() throws SQLException{
        try{
            contratoVO.setConTerminal(util.obtenerIpCliente());
           // contratoVO.setConFechaAlta(util.getObtenerFechaHoy());
            contratoVO.setMcoId(modalidad);
            //contratoVO.setConTipo(tipoinfra);
            contratoVO.setCsiId(concesion);
            contratoVO.setCncId(concesionario);
            contratoVO.setConEstado(1);          
            
            contratoConcesionServiceImp.insert(contratoVO);
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
