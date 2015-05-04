
package com.ositran.valorizaciones;

import com.ositran.model.Infraestructura;
import com.ositran.service.ConcesionService;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.service.ContratoConcesionService;
import com.ositran.service.DatosStdService;
import com.ositran.service.InversionService;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.InversionDescripcionServicesImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.serviceimpl.MonedaServiceImpl;
import com.ositran.serviceimpl.SupervisorInversionesServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ContratoCompromisoVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InversionDescripcionVO;
import com.ositran.vo.bean.InversionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.MonedaVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.SupervisorInversionesVO;
import com.ositran.vo.bean.ValorizacionSupDetalleVO;
import com.ositran.vo.bean.ViewTdInternosVO;

import java.io.IOException;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "regValorizacionSupervisionMB")
@ViewScoped

public class RegistrarValorizacionSupervision {
    public final int formulario = 35;
    private RolOpcionesVO rolOpcion;

    private String nombreConcesion;
    private String contratoConcesion;
    private String nombreTipoInfraestructura;
    private String t_concesion;
    private String t_modconc;
    private String nrohr;
    private String añohr;
    private String freg;
    private String asuntohr;
    private String nomSupervisor;
    private int monedaSeleccionada;
    private int conceptoSeleccionada;
    private int infraestructuraSeleccionada;
    private int inversionSeleccionada;
    private int contratoCompromisoSeleccionado;
    private int conId;
    private int t_tinfra;
    private int codigoInversion;
    private int tipoInfraestructura;
    private int codigoInfraestructura;
    private int idTipoInfraestructura;
    private int añohrbus;
    private int nrohrbus;
    private String plazo;
    private int codigoMoneda;
    private int codigoContrato;
    private BigDecimal total;
    private BigDecimal montoTabla;
    private int cvaId;
    private boolean igv;

    private List<ContratoVO> listaContratos = new ArrayList<>();
    private List<InversionDescripcionVO> listaConcepto = new ArrayList<>();
    private List<MonedaVO> listaMoneda = new ArrayList<>();
    private List<InfraestructuraVO> listaInfraestructuras = new ArrayList<>();
    private List<InfraestructuraTipoVO> listaInfraestructuraTipos = new ArrayList<>();
    private List<InversionVO> listaInversiones = new ArrayList<>();
    private List<ContratoVO> listaContratosConcesion = new ArrayList<>();
    private List<ContratoCompromisoVO> listaContratoCompromiso = new ArrayList<>();
    private List<ValorizacionSupDetalleVO> listaValorizacion = new ArrayList<>();


    @ManagedProperty(value = "#{monedaServiceImpl}")
    private MonedaServiceImpl monedaServiceImpl;
    @ManagedProperty(value = "#{monedaVO}")
    private MonedaVO monedaVO;
    @ManagedProperty(value = "#{inversionDescripcionServicesImpl}")
    private InversionDescripcionServicesImpl inversionDescripcionServicesImpl;
    @ManagedProperty(value = "#{inversionDescripcionVO}")
    private InversionDescripcionVO inversionDescripcionVO;
    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionService contratoConcesionServiceImp;
    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionService concesionServiceImpl;
    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;
    @ManagedProperty(value = "#{ViewTdInternosVO}")
    ViewTdInternosVO viewTdInternosVO;
    @ManagedProperty(value = "#{datosStdServiceImpl}")
    DatosStdService datosStdServiceImpl;
    @ManagedProperty(value = "#{contratoCompromisoServiceImpl}")
    ContratoCompromisoService contratoCompromisoServiceImpl;
    @ManagedProperty(value = "#{contratoCompromisoVO}")
    ContratoCompromisoVO contratoCompromisoVO;
    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    InfraestructuraTipoVO infraestructuraTipoVO;
    @ManagedProperty(value = "#{concesionVO}")
    ConcesionVO concesionVO;
    @ManagedProperty(value = "#{modalidadConcesionVO}")
    ModalidadConcesionVO modalidadConcesionVO;
    @ManagedProperty(value = "#{modalidadConcesionServiceImpl}")
    ModalidadConcesionServiceImpl modalidadConcesionServiceImpl;
    @ManagedProperty(value = "#{infraestructura}")
    Infraestructura infraestructura;
    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    InfraestructuraServiceImpl infraestructuraServiceImpl;
    @ManagedProperty(value = "#{infraestructuraVO}")
    InfraestructuraVO infraestructuraVO;
    @ManagedProperty(value = "#{inversionServiceImpl}")
    InversionService inversionServiceImpl;
    @ManagedProperty(value = "#{inversionVO}")
    InversionVO inversionVO;
    @ManagedProperty(value = "#{contratoVO}")
    ContratoVO contratoVO;

    public void validarSesion() throws IOException {

        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
    }


    public void cargarListaContratos() {
        try {
            listaContratos = contratoConcesionServiceImp.query();
            for (ContratoVO contra : listaContratos) {
                concesionVO = concesionServiceImpl.get(contra.getCsiId());
                contratoVO = contratoConcesionServiceImp.get(contra.getConId());
                codigoContrato = contratoVO.getConId();
                modalidadConcesionVO = modalidadConcesionServiceImpl.get(contra.getMcoId());
                contra.setNombreConcesion(concesionVO.getCsiNombre());
                contra.setNombreModalidad(modalidadConcesionVO.getMcoNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elegirContrato(ContratoVO contrato1) {
        try {
            concesionVO = concesionServiceImpl.get(contrato1.getCncId());
            listaInfraestructuras = infraestructuraServiceImpl.query2(concesionVO.getCsiId());
            t_concesion = contrato1.getNombreConcesion();
            t_tinfra = contrato1.getTinId();
            t_modconc = contrato1.getNombreModalidad();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void cargarInversion() {
        try {
            infraestructuraVO = infraestructuraServiceImpl.get2(infraestructuraSeleccionada);
            infraestructura.setCsiId(infraestructuraVO.getCsiId());
            infraestructura.setInfId(infraestructuraVO.getInfId());
            infraestructura.setTinId(infraestructuraVO.getTinId());
            listaInversiones = inversionServiceImpl.query1(infraestructura, codigoContrato);
            listaContratoCompromiso = contratoCompromisoServiceImpl.query1(codigoContrato);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarDatosCompromiso() {
        try {
            contratoCompromisoVO = contratoCompromisoServiceImpl.get(contratoCompromisoSeleccionado);
            plazo = contratoCompromisoVO.getCcoPlazo();
            total = contratoCompromisoVO.getCcoTotal();
            codigoMoneda = contratoCompromisoVO.getMonId();
        } catch (Exception e) {
            System.out.println("PROBLEMAS AL CARGAR LA LISTA CONTRATOS COMPROMISO");
            e.printStackTrace();
        }
    }


    //--buscar std--//
    public void BuscarStd() throws SQLException {
        if (nrohr.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!nrohr.trim().equals("") && Integer.parseInt(nrohr) < 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nro de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (añohr.trim().equals("")) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese un Año de Hoja de Ruta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!añohr.trim().equals("") && Integer.parseInt(añohr) < 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (!añohr.trim().equals("") && añohr.length() < 4) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Año de Hoja de Ruta Válido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
            try {
                viewTdInternosVO = datosStdServiceImpl.BuscaStd(Integer.parseInt(añohr), nrohr);
                if (viewTdInternosVO != null) {
                    freg = dt1.format(viewTdInternosVO.getFechaRegistro());
                    asuntohr = viewTdInternosVO.getAsunto();
                    añohrbus = viewTdInternosVO.getAnyo();
                    nrohrbus = Integer.parseInt(viewTdInternosVO.getNroRegistro());
                } else {
                    freg = "";
                    asuntohr = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //----------------------//


    //---------DATOS VALORIZACION-------------//

    public void cargarListaMoneda() {
        try {

            listaMoneda = monedaServiceImpl.query();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void cargarListaconcepto() {
        try {

            listaConcepto = inversionDescripcionServicesImpl.query();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void guardarTabla() {

        try {
            listaMoneda = monedaServiceImpl.query();
            BigDecimal igv1;

            //neto = getMontoTabla();
            ValorizacionSupDetalleVO valorizacionSupDetalleVO = new ValorizacionSupDetalleVO();
            valorizacionSupDetalleVO.setCvaId(conceptoSeleccionada);
            valorizacionSupDetalleVO.setMonId(monedaSeleccionada);
            valorizacionSupDetalleVO.setNeto(Long.parseLong(String.valueOf(montoTabla)));
            
            if(igv){
                    igv1= new BigDecimal(0.18);
                    valorizacionSupDetalleVO.setIgv(igv1.multiply(montoTabla).doubleValue());
                }
            else{
                    igv1= new BigDecimal(0);
                    valorizacionSupDetalleVO.setIgv(igv1.doubleValue());
                }
            //valorizacionSupDetalleVO.settTotal(montoTabla.add(igv1.multiply(montoTabla))); 
            listaValorizacion.add(valorizacionSupDetalleVO);


          
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }


    }


    //--------- FIN DATOS VALORIZACION-------------//

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

    public void setTipoInfraestructura(int tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public int getTipoInfraestructura() {
        return tipoInfraestructura;
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

    public void setAñohrbus(int añohrbus) {
        this.añohrbus = añohrbus;
    }

    public int getAñohrbus() {
        return añohrbus;
    }

    public void setFreg(String freg) {
        this.freg = freg;
    }

    public String getFreg() {
        return freg;
    }

    public void setAsuntohr(String asuntohr) {
        this.asuntohr = asuntohr;
    }

    public String getAsuntohr() {
        return asuntohr;
    }

    public void setViewTdInternosVO(ViewTdInternosVO viewTdInternosVO) {
        this.viewTdInternosVO = viewTdInternosVO;
    }

    public ViewTdInternosVO getViewTdInternosVO() {
        return viewTdInternosVO;
    }

    public void setDatosStdServiceImpl(DatosStdService datosStdServiceImpl) {
        this.datosStdServiceImpl = datosStdServiceImpl;
    }

    public DatosStdService getDatosStdServiceImpl() {
        return datosStdServiceImpl;
    }

    public void setNrohrbus(int nrohrbus) {
        this.nrohrbus = nrohrbus;
    }

    public int getNrohrbus() {
        return nrohrbus;
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

    public void setNombreTipoInfraestructura(String nombreTipoInfraestructura) {
        this.nombreTipoInfraestructura = nombreTipoInfraestructura;
    }

    public String getNombreTipoInfraestructura() {
        return nombreTipoInfraestructura;
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

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    public void setListaContratoCompromiso(List<ContratoCompromisoVO> listaContratoCompromiso) {
        this.listaContratoCompromiso = listaContratoCompromiso;
    }

    public List<ContratoCompromisoVO> getListaContratoCompromiso() {
        return listaContratoCompromiso;
    }

    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }

    public void setInversionServiceImpl(InversionService inversionServiceImpl) {
        this.inversionServiceImpl = inversionServiceImpl;
    }

    public InversionService getInversionServiceImpl() {
        return inversionServiceImpl;
    }

    public void setCodigoInversion(int codigoInversion) {
        this.codigoInversion = codigoInversion;
    }

    public int getCodigoInversion() {
        return codigoInversion;
    }


    public void setContratoCompromisoSeleccionado(int contratoCompromisoSeleccionado) {
        this.contratoCompromisoSeleccionado = contratoCompromisoSeleccionado;
    }

    public int getContratoCompromisoSeleccionado() {
        return contratoCompromisoSeleccionado;
    }


    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getPlazo() {
        return plazo;
    }


    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setCodigoMoneda(int codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public int getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setListaMoneda(List<MonedaVO> listaMoneda) {
        this.listaMoneda = listaMoneda;
    }

    public List<MonedaVO> getListaMoneda() {
        return listaMoneda;
    }

    public void setListaInfraestructuraTipos(List<InfraestructuraTipoVO> listaInfraestructuraTipos) {
        this.listaInfraestructuraTipos = listaInfraestructuraTipos;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructuraTipos() {
        return listaInfraestructuraTipos;
    }

    public void setListaContratosConcesion(List<ContratoVO> listaContratosConcesion) {
        this.listaContratosConcesion = listaContratosConcesion;
    }

    public List<ContratoVO> getListaContratosConcesion() {
        return listaContratosConcesion;
    }

    public void setMonedaServiceImpl(MonedaServiceImpl monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }

    public MonedaServiceImpl getMonedaServiceImpl() {
        return monedaServiceImpl;
    }


    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }

    public void setMonedaSeleccionada(int monedaSeleccionada) {
        this.monedaSeleccionada = monedaSeleccionada;
    }

    public int getMonedaSeleccionada() {
        return monedaSeleccionada;
    }

    public void setConceptoSeleccionada(int conceptoSeleccionada) {
        this.conceptoSeleccionada = conceptoSeleccionada;
    }

    public int getConceptoSeleccionada() {
        return conceptoSeleccionada;
    }


    public void setListaConcepto(List<InversionDescripcionVO> listaConcepto) {
        this.listaConcepto = listaConcepto;
    }

    public List<InversionDescripcionVO> getListaConcepto() {
        return listaConcepto;
    }

    public void setInversionDescripcionServicesImpl(InversionDescripcionServicesImpl inversionDescripcionServicesImpl) {
        this.inversionDescripcionServicesImpl = inversionDescripcionServicesImpl;
    }

    public InversionDescripcionServicesImpl getInversionDescripcionServicesImpl() {
        return inversionDescripcionServicesImpl;
    }

    public void setInversionDescripcionVO(InversionDescripcionVO inversionDescripcionVO) {
        this.inversionDescripcionVO = inversionDescripcionVO;
    }

    public InversionDescripcionVO getInversionDescripcionVO() {
        return inversionDescripcionVO;
    }

    public void setInfraestructuraSeleccionada(int infraestructuraSeleccionada) {
        this.infraestructuraSeleccionada = infraestructuraSeleccionada;
    }

    public int getInfraestructuraSeleccionada() {
        return infraestructuraSeleccionada;
    }

    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }

    public Infraestructura getInfraestructura() {
        return infraestructura;
    }


    public void setInversionSeleccionada(int inversionSeleccionada) {
        this.inversionSeleccionada = inversionSeleccionada;
    }

    public int getInversionSeleccionada() {
        return inversionSeleccionada;
    }

    public void setInversionVO(InversionVO inversionVO) {
        this.inversionVO = inversionVO;
    }

    public InversionVO getInversionVO() {
        return inversionVO;
    }

    public void setModalidadConcesionVO(ModalidadConcesionVO modalidadConcesionVO) {
        this.modalidadConcesionVO = modalidadConcesionVO;
    }

    public ModalidadConcesionVO getModalidadConcesionVO() {
        return modalidadConcesionVO;
    }

    public void setModalidadConcesionServiceImpl(ModalidadConcesionServiceImpl modalidadConcesionServiceImpl) {
        this.modalidadConcesionServiceImpl = modalidadConcesionServiceImpl;
    }

    public ModalidadConcesionServiceImpl getModalidadConcesionServiceImpl() {
        return modalidadConcesionServiceImpl;
    }


    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    public void setNomSupervisor(String nomSupervisor) {
        this.nomSupervisor = nomSupervisor;
    }

    public String getNomSupervisor() {
        return nomSupervisor;
    }


    public void setMontoTabla(BigDecimal montoTabla) {
        this.montoTabla = montoTabla;
    }

    public BigDecimal getMontoTabla() {
        return montoTabla;
    }


    public void setCvaId(int cvaId) {
        this.cvaId = cvaId;
    }

    public int getCvaId() {
        return cvaId;
    }


    public void setListaValorizacion(List<ValorizacionSupDetalleVO> listaValorizacion) {
        this.listaValorizacion = listaValorizacion;
    }

    public List<ValorizacionSupDetalleVO> getListaValorizacion() {
        return listaValorizacion;
    }


    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }


    public void setIgv(boolean igv) {
        this.igv = igv;
    }

    public boolean isIgv() {
        return igv;
    }
    
}
