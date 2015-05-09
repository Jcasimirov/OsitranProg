package com.ositran.reports;

import com.ositran.service.InversionService;
import com.ositran.service.PeriodoService;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoAlertaEstadoServiceImpl;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.serviceimpl.ReportesServiceImpl;
import com.ositran.util.reportes.AvaInvConConcDataSource;
import com.ositran.util.reportes.AvaInvRecConConcDataSource;
import com.ositran.util.reportes.ControlPlazosFlujoValorizacionesEmpresaSupervisoraDataSource;
import com.ositran.util.reportes.ControlPlazosFlujoValorizacionesInversionesDataSource;
import com.ositran.util.reportes.EmpSupInfAeropuertoDataSource;
import com.ositran.util.reportes.EmpSupInfDataSource;
import com.ositran.util.reportes.InversionesTipoConceptoDataSource;
import com.ositran.util.reportes.ReporteAlertaAeropuertoDataSource;
import com.ositran.util.reportes.ReporteAlertaDataSource;
import com.ositran.util.reportes.TrazabilidadPrincipalesEventosDataSource;
import com.ositran.vo.bean.ConcesionVO;

import com.ositran.vo.bean.ContratoAlertaEstadoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InversionVO;
import com.ositran.vo.bean.ModalidadConcesionVO;

import com.ositran.vo.bean.PeriodoVO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Generated;

import javax.faces.component.html.HtmlForm;
import javax.faces.model.SelectItem;
import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name="backing_ositran_reports_reporte_alerta")
@ViewScoped
@Generated(value = "1ositran/reports/reporteAlerta.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class ReporteAlertaController  {

    private HtmlForm form1;
    private OutputLabel lblTipoAlerta;
    private OutputLabel lblTipoInfraestructura;
    private OutputLabel lblConcesion;
    private OutputLabel lblModalidad;
    private OutputLabel lblEtapa;
    private OutputLabel lblEstado;
    private SelectOneMenu selectTipoAlerta;
    private SelectOneMenu selectTipoInfraestructura;
    private SelectOneMenu selectConcesion;
    private SelectOneMenu selectModalidad;
    private SelectOneMenu selectEtapa;
    private SelectOneMenu selectEstado;

    private SelectOneMenu selectAeropuerto;
    private SelectOneMenu selectInversion;

    private String tipoAlerta="1";
    private List<SelectItem> tipoAlertaSelectItems = new ArrayList<SelectItem>();
    private String tipoInfraestructura="-1";
    private List<SelectItem> tipoInfraestructuraSelectItems = new ArrayList<SelectItem>();
    private String concesion="-1";
    private List<SelectItem> concesionSelectItems = new ArrayList<SelectItem>();
    private String modalidad="-1";
    private List<SelectItem> modalidadSelectItems = new ArrayList<SelectItem>();
    private String etapa="-1";
    private List<SelectItem> etapaSelectItems = new ArrayList<SelectItem>();
    private String estado="-1";
    private List<SelectItem> estadoSelectItems = new ArrayList<SelectItem>();

    private String aeropuerto="-1";
    private List<SelectItem> aeropuertoSelectItems = new ArrayList<SelectItem>();
    private String inversion="-1";
    private List<SelectItem> inversionSelectItems = new ArrayList<SelectItem>();
    
    public ReporteAlertaController(){
        
    }
private boolean habilitarFiltrosDemas=false;
public void validarHabilitarFiltrosAeropuertos(){
    System.out.println("VALOR TIPO = tipoInfraestructura = "+tipoInfraestructura);
    if (tipoInfraestructura!=null && tipoInfraestructura.equals("2")){
        habilitarFiltrosDemas=true;
    }else{
        habilitarFiltrosDemas=false;
    }
}
    /**
     * @return the form1
     */
    public HtmlForm getForm1() {
        return form1;
    }

    /**
     * @param form1 the form1 to set
     */
    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    /**
     * @return the lblTipoAlerta
     */
    public OutputLabel getLblTipoAlerta() {
        return lblTipoAlerta;
    }

    /**
     * @param lblTipoAlerta the lblTipoAlerta to set
     */
    public void setLblTipoAlerta(OutputLabel lblTipoAlerta) {
        this.lblTipoAlerta = lblTipoAlerta;
    }

    /**
     * @return the lblTipoInfraestructura
     */
    public OutputLabel getLblTipoInfraestructura() {
        return lblTipoInfraestructura;
    }

    /**
     * @param lblTipoInfraestructura the lblTipoInfraestructura to set
     */
    public void setLblTipoInfraestructura(OutputLabel lblTipoInfraestructura) {
        this.lblTipoInfraestructura = lblTipoInfraestructura;
    }

    /**
     * @return the lblConcesion
     */
    public OutputLabel getLblConcesion() {
        return lblConcesion;
    }

    /**
     * @param lblConcesion the lblConcesion to set
     */
    public void setLblConcesion(OutputLabel lblConcesion) {
        this.lblConcesion = lblConcesion;
    }

    /**
     * @return the lblModalidad
     */
    public OutputLabel getLblModalidad() {
        return lblModalidad;
    }

    /**
     * @param lblModalidad the lblModalidad to set
     */
    public void setLblModalidad(OutputLabel lblModalidad) {
        this.lblModalidad = lblModalidad;
    }

    /**
     * @return the lblEtapa
     */
    public OutputLabel getLblEtapa() {
        return lblEtapa;
    }

    /**
     * @param lblEtapa the lblEtapa to set
     */
    public void setLblEtapa(OutputLabel lblEtapa) {
        this.lblEtapa = lblEtapa;
    }

    /**
     * @return the lblEstado
     */
    public OutputLabel getLblEstado() {
        return lblEstado;
    }

    /**
     * @param lblEstado the lblEstado to set
     */
    public void setLblEstado(OutputLabel lblEstado) {
        this.lblEstado = lblEstado;
    }

    /**
     * @return the selectTipoAlerta
     */
    public SelectOneMenu getSelectTipoAlerta() {
        return selectTipoAlerta;
    }

    /**
     * @param selectTipoAlerta the selectTipoAlerta to set
     */
    public void setSelectTipoAlerta(SelectOneMenu selectTipoAlerta) {
        this.selectTipoAlerta = selectTipoAlerta;
    }

    /**
     * @return the selectTipoInfraestructura
     */
    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
    }

    /**
     * @param selectTipoInfraestructura the selectTipoInfraestructura to set
     */
    public void setSelectTipoInfraestructura(SelectOneMenu selectTipoInfraestructura) {

        this.selectTipoInfraestructura = selectTipoInfraestructura;
    }

    /**
     * @return the selectConcesion
     */
    public SelectOneMenu getSelectConcesion() {
        return selectConcesion;
    }

    /**
     * @param selectConcesion the selectConcesion to set
     */
    public void setSelectConcesion(SelectOneMenu selectConcesion) {
        this.selectConcesion = selectConcesion;
    }

    /**
     * @return the selectModalidad
     */
    public SelectOneMenu getSelectModalidad() {
        return selectModalidad;
    }

    /**
     * @param selectModalidad the selectModalidad to set
     */
    public void setSelectModalidad(SelectOneMenu selectModalidad) {
        this.selectModalidad = selectModalidad;
    }

    /**
     * @return the selectEtapa
     */
    public SelectOneMenu getSelectEtapa() {
        return selectEtapa;
    }

    /**
     * @param selectEtapa the selectEtapa to set
     */
    public void setSelectEtapa(SelectOneMenu selectEtapa) {
        this.selectEtapa = selectEtapa;
    }

    /**
     * @return the selectEstado
     */
    public SelectOneMenu getSelectEstado() {
        return selectEstado;
    }

    /**
     * @param selectEstado the selectEstado to set
     */
    public void setSelectEstado(SelectOneMenu selectEstado) {
        this.selectEstado = selectEstado;
    }

    /**
     * @return the tipoAlerta
     */
    public String getTipoAlerta() {
        return tipoAlerta;
    }

    /**
     * @param tipoAlerta the tipoAlerta to set
     */
    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    /**
     * @return the tipoAlertaSelectItems
     */
    public List<SelectItem> getTipoAlertaSelectItems() {
        tipoAlertaSelectItems = new ArrayList<SelectItem>();
        //tipoAlertaSelectItems.add(new SelectItem( -1 ,"Seleccione el tipo","Seleccione el tipo",true));
        tipoAlertaSelectItems.add(new SelectItem( 1 ,"Tipo 1"));
        tipoAlertaSelectItems.add(new SelectItem( 2 ,"Tipo 2"));
        tipoAlertaSelectItems.add(new SelectItem( 3 ,"Tipo 3"));
        tipoAlertaSelectItems.add(new SelectItem( 4 ,"Tipo 4"));
        return tipoAlertaSelectItems;
    }

    /**
     * @param tipoAlertaSelectItems the tipoAlertaSelectItems to set
     */
    public void setTipoAlertaSelectItems(List<SelectItem> tipoAlertaSelectItems) {
        this.tipoAlertaSelectItems = tipoAlertaSelectItems;
    }

    /**
     * @return the tipoInfraestructura
     */
    public String getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    /**
     * @param tipoInfraestructura the tipoInfraestructura to set
     */
    public void setTipoInfraestructura(String tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    /**
     * @return the tipoInfraestructuraSelectItems
     */
    public List<SelectItem> getTipoInfraestructuraSelectItems() throws SQLException {
        tipoInfraestructuraSelectItems=new ArrayList<SelectItem>();
        tipoInfraestructuraSelectItems.add(new SelectItem("-1","Seleccione"));
        List<InfraestructuraTipoVO> lista=listarInfraestructuraTipo();
        int i=0;
        for(InfraestructuraTipoVO ivo:lista){
            tipoInfraestructuraSelectItems.add(new SelectItem(ivo.getTinId()+"", String.valueOf(ivo.getTinNombre())));
        }
        return tipoInfraestructuraSelectItems;
    }

    /**
     * @param tipoInfraestructuraSelectItems the tipoInfraestructuraSelectItems to set
     */
    public void setTipoInfraestructuraSelectItems(List<SelectItem> tipoInfraestructuraSelectItems) {

        this.tipoInfraestructuraSelectItems = tipoInfraestructuraSelectItems;
    }

    /**
     * @return the concesion
     */
    public String getConcesion() {
        return concesion;
    }

    /**
     * @param concesion the concesion to set
     */
    public void setConcesion(String concesion) {
        this.concesion = concesion;
    }

    /**
     * @return the concesionSelectItems
     */
    public List<SelectItem> getConcesionSelectItems() throws SQLException {
        concesionSelectItems=new ArrayList<SelectItem>();
        concesionSelectItems.add(new SelectItem("-1","Seleccione","Seleccione"));
        List<ConcesionVO> lista=listarConcesion();
        int i=0;
        for(ConcesionVO cvo:lista){
            concesionSelectItems.add(new SelectItem(cvo.getCsiId()+"", String.valueOf(cvo.getCsiNombre())));
        }
        return concesionSelectItems;
    }

    /**
     * @param concesionSelectItems the concesionSelectItems to set
     */
    public void setConcesionSelectItems(List<SelectItem> concesionSelectItems) {
        this.concesionSelectItems = concesionSelectItems;
    }

    /**
     * @return the modalidad
     */
    public String getModalidad() {
        
        return modalidad;
    }

    /**
     * @param modalidad the modalidad to set
     */
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    /**
     * @return the modalidadSelectItems
     */
    public List<SelectItem> getModalidadSelectItems() throws SQLException {
        modalidadSelectItems=new ArrayList<SelectItem>();
        modalidadSelectItems.add(new SelectItem("-1","Seleccione","Seleccione"));
        List<ModalidadConcesionVO> lista=listarModalidad();
        int i=0;
        for(ModalidadConcesionVO cvo:lista){
            modalidadSelectItems.add(new SelectItem(cvo.getMcoId()+"", String.valueOf(cvo.getMcoNombre())));
        }
        return modalidadSelectItems;
    }

    /**
     * @param modalidadSelectItems the modalidadSelectItems to set
     */
    public void setModalidadSelectItems(List<SelectItem> modalidadSelectItems) {
        this.modalidadSelectItems = modalidadSelectItems;
    }

    /**
     * @return the etapa
     */
    public String getEtapa() {
        return etapa;
    }

    /**
     * @param etapa the etapa to set
     */
    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    /**
     * @return the etapaSelectItems
     */
    public List<SelectItem> getEtapaSelectItems() {
        etapaSelectItems=new ArrayList<SelectItem>();
        etapaSelectItems.add(new SelectItem("-1","Seleccione"));
        List<PeriodoVO> lista=listarPeriodo();
        int i=0;
        for(PeriodoVO cvo:lista){
            etapaSelectItems.add(new SelectItem(cvo.getPerId()+"", String.valueOf(cvo.getPerNombre())));
        }
        return etapaSelectItems;
    }

    /**
     * @param etapaSelectItems the etapaSelectItems to set
     */
    public void setEtapaSelectItems(List<SelectItem> etapaSelectItems) {
        this.etapaSelectItems = etapaSelectItems;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the estadoSelectItems
     */
    public List<SelectItem> getEstadoSelectItems() {
        estadoSelectItems=new ArrayList<SelectItem>();
        estadoSelectItems.add(new SelectItem("-1","Seleccione"));
        List<ContratoAlertaEstadoVO> lista=listarEstadosAlerta();
        int i=0;
        for(ContratoAlertaEstadoVO cvo:lista){
            estadoSelectItems.add(new SelectItem(cvo.getCaeId(), String.valueOf(cvo.getCaeNombre())));
        }
        return estadoSelectItems;
    }

    /**
     * @param estadoSelectItems the estadoSelectItems to set
     */
    public void setEstadoSelectItems(List<SelectItem> estadoSelectItems) {
        this.estadoSelectItems = estadoSelectItems;
    }

    /**
     * @return the selectAeropuerto
     */
    public SelectOneMenu getSelectAeropuerto() {
        return selectAeropuerto;
    }

    /**
     * @param selectAeropuerto the selectAeropuerto to set
     */
    public void setSelectAeropuerto(SelectOneMenu selectAeropuerto) {
        this.selectAeropuerto = selectAeropuerto;
    }

    /**
     * @return the selectInversion
     */
    public SelectOneMenu getSelectInversion() {
        return selectInversion;
    }

    /**
     * @param selectInversion the selectInversion to set
     */
    public void setSelectInversion(SelectOneMenu selectInversion) {
        this.selectInversion = selectInversion;
    }

    /**
     * @return the aeropuerto
     */
    public String getAeropuerto() {
        return aeropuerto;
    }

    /**
     * @param aeropuerto the aeropuerto to set
     */
    public void setAeropuerto(String aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    /**
     * @return the aeropuertoSelectItems
     */
    public List<SelectItem> getAeropuertoSelectItems() {
        aeropuertoSelectItems=new ArrayList<SelectItem>();
        aeropuertoSelectItems.add(new SelectItem("-1","Seleccione"));
        List<InfraestructuraVO> lista=listarInfraestructuraAeropuertos();
        int i=0;
        for(InfraestructuraVO cvo:lista){
            try {
                if(cvo.getTinId()==2){
                    aeropuertoSelectItems.add(new SelectItem(cvo.getInfId(), String.valueOf(cvo.getInfNombre())));    
                }  
            } catch (Exception ex){
                
            }
            
            
        }
        return aeropuertoSelectItems;
    }

    /**
     * @param aeropuertoSelectItems the aeropuertoSelectItems to set
     */
    public void setAeropuertoSelectItems(List<SelectItem> aeropuertoSelectItems) {
        this.aeropuertoSelectItems = aeropuertoSelectItems;
    }

    /**
     * @return the inversion
     */
    public String getInversion() {
        return inversion;
    }

    /**
     * @param inversion the inversion to set
     */
    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    /**
     * @return the inversionSelectItems
     */
    public List<SelectItem> getInversionSelectItems() {
        inversionSelectItems=new ArrayList<SelectItem>();
        inversionSelectItems.add(new SelectItem("-1","Seleccione"));
        List<InversionVO> lista=listarInversion();
        int i=0;
        for(InversionVO cvo:lista){
            inversionSelectItems.add(new SelectItem(cvo.getInvId(), String.valueOf(cvo.getInvDescripcion())));
        }
        return inversionSelectItems;
    }

    /**
     * @param inversionSelectItems the inversionSelectItems to set
     */
    public void setInversionSelectItems(List<SelectItem> inversionSelectItems) {
        this.inversionSelectItems = inversionSelectItems;
    }
    
    /*
     * CONCESION
     */
    @ManagedProperty(value="#{concesionServiceImpl}")
    private ConcesionServiceImpl concesionServiceImpl;
    public ConcesionVO concesionVO=new ConcesionVO();
    public void setConcesionServiceImpl(ConcesionServiceImpl concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionarioVO() {
        return concesionVO;
    }


    public List<ConcesionVO> listarConcesion() throws SQLException{
        List<ConcesionVO> list=this.concesionServiceImpl.listarConcesiones();
        return list;
    }
    /*
     * TIPO INFRAESTRUCTURA
     */
    
    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    private InfraestructuraTipoVO infraestructuraTipoVO;
    
    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;


    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    private List<InfraestructuraTipoVO> listaInfraestructuraTipo;
    
    public List<InfraestructuraTipoVO> listarInfraestructuraTipo() throws SQLException {
        try {
            listaInfraestructuraTipo = getInfraestructuraTipoServiceImpl().query();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaInfraestructuraTipo;
    }  
    /*
     * MODALIDAD
     */
    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionServiceImpl modalidadServiceImp;
    public void setModalidadServiceImp(ModalidadConcesionServiceImpl modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionServiceImpl getModalidadServiceImp() {
        return modalidadServiceImp;
    }
    // Metodo para Listar Modalidad de Concesión
    public List<ModalidadConcesionVO> listarModalidad() throws SQLException {
        List<ModalidadConcesionVO> listaModalidad = new ArrayList<ModalidadConcesionVO>();
        try {
            listaModalidad = this.modalidadServiceImp.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return listaModalidad;
    }
    /*
     * CONTRATO ALERTA ESTADO
     */
       
    @ManagedProperty(value = "#{contratoAlertaEstadoServiceImpl}")
    private ContratoAlertaEstadoServiceImpl contratoAlertaEstadoServiceImpl;
    
    public ContratoAlertaEstadoServiceImpl getContratoAlertaEstadoServiceImpl() {
        return contratoAlertaEstadoServiceImpl;
    }

    public void setContratoAlertaEstadoServiceImpl(ContratoAlertaEstadoServiceImpl contratoAlertaEstadoServiceImpl) {
        this.contratoAlertaEstadoServiceImpl = contratoAlertaEstadoServiceImpl;
    }
   
    public List<ContratoAlertaEstadoVO> listarEstadosAlerta() {
        List<ContratoAlertaEstadoVO> listContratoAlertaEstado=new ArrayList<ContratoAlertaEstadoVO>();
        try {
            listContratoAlertaEstado = contratoAlertaEstadoServiceImpl.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return listContratoAlertaEstado;
    }
    /*
     * INFRAESTRUCTURA AEROPUERTO
     */
    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    private InfraestructuraServiceImpl infraestructuraServiceImpl;

    public InfraestructuraServiceImpl getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }

    public void setInfraestructuraServiceImpl(InfraestructuraServiceImpl infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }
    public List<InfraestructuraVO> listarInfraestructuraAeropuertos() {
        List<InfraestructuraVO> listContratoAlertaEstado=new ArrayList<InfraestructuraVO>();
        try {
            listContratoAlertaEstado = infraestructuraServiceImpl.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return listContratoAlertaEstado;
    }
    /*
     * INVERSION
     */
    @ManagedProperty(value = "#{inversionServiceImpl}")
    InversionService inversionServiceImpl;
    
    public void setInversionServiceImpl(InversionService inversionServiceImpl) {
        this.inversionServiceImpl = inversionServiceImpl;
    }

    public InversionService getInversionServiceImpl() {
        return inversionServiceImpl;
    }
    public List<InversionVO> listarInversion() {
        List<InversionVO> listContratoAlertaEstado=new ArrayList<InversionVO>();
        try {
            listContratoAlertaEstado = inversionServiceImpl.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return listContratoAlertaEstado;
    }
    /*
     * ETAPA - PERIODO
     */
    @ManagedProperty(value = "#{periodoServiceImpl}")
    private PeriodoService periodoServiceImpl;

    public PeriodoService getPeriodoServiceImpl() {
        return periodoServiceImpl;
    }

    public void setPeriodoServiceImpl(PeriodoService periodoServiceImpl) {
        this.periodoServiceImpl = periodoServiceImpl;
    }
    public List<PeriodoVO> listarPeriodo() {
        List<PeriodoVO> listContratoAlertaEstado=new ArrayList<PeriodoVO>();
        try {
            listContratoAlertaEstado = periodoServiceImpl.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return listContratoAlertaEstado;
    }

    public boolean isHabilitarFiltrosDemas() {
        return habilitarFiltrosDemas;
    }

    public void setHabilitarFiltrosDemas(boolean habilitarFiltrosDemas) {
        this.habilitarFiltrosDemas = habilitarFiltrosDemas;
    }
}
