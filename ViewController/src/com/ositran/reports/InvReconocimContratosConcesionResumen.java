package com.ositran.reports;

import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ConcesionarioServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import com.ositran.vo.bean.ModalidadConcesionVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.component.html.HtmlForm;

import javax.faces.model.SelectItem;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_reports_invReconocimContratosConcesionResumen")
@RequestScoped
@Generated(value = "1ositran/reports/invReconocimContratosConcesionResumen.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class InvReconocimContratosConcesionResumen {
    private HtmlForm formReconocimientoContratos;
    private OutputLabel lblAnnio;
    private OutputLabel lblTipoReporte;
    private SelectOneMenu selectAnnio;
    private SelectOneMenu selectTipoReporte;
    private CommandButton cmbGenerar;
    private OutputLabel lblTipoInfraestructura;
    private SelectOneMenu selectTipoInfraestructura;
    private OutputLabel lblConcesion;
    private SelectOneMenu selectConcesion;
    private OutputLabel lblModalidad;
    private SelectOneMenu selectModalidad;
    private PanelGrid pnlgReconocimientoContratos;
    private String tipoInfraestructura;
    List<SelectItem> tipoInfraestructuraSelectItems=new ArrayList<SelectItem>();    
    private String concesion;
    List<SelectItem> concesionSelectItems=new ArrayList<SelectItem>();    
    private String annio;
    List<SelectItem> annioSelectItems=new ArrayList<SelectItem>();
    private String mes;
    List<SelectItem> mesSelectItems=new ArrayList<SelectItem>();
    private String modalidadConcesion;
    List<SelectItem> modalidadConcesionSelectItems=new ArrayList<SelectItem>();
    private String tipoReporte;
    List<SelectItem> tipoReporteSelectItems=new ArrayList<SelectItem>();
    ///
    private OutputLabel lblTrimestre;
    private SelectOneMenu selectTrimestre;
    private String trimestre;
    private List<SelectItem> trimestreSelectItems = new ArrayList<SelectItem>();

    //EAPR: metodo agregado para inicializar los combos con valores actuales
    public InvReconocimContratosConcesionResumen(){
        this.setAnnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        this.setMes(String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1));
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setConcesion(String concesion) {
        this.concesion = concesion;
    }

    public String getConcesion() {
        return concesion;
    }

    public void setModalidadConcesion(String modalidadConcesion) {
        this.modalidadConcesion = modalidadConcesion;
    }

    public String getModalidadConcesion() {
        return modalidadConcesion;
    }

    public void setTipoInfraestructura(String tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public String getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getAnnio() {
        return annio;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMes() {
        return mes;
    }

    public void setForm1(HtmlForm form1) {
        this.formReconocimientoContratos = form1;
    }

    public HtmlForm getForm1() {
        return formReconocimientoContratos;
    }

    public void setLblAnnio(OutputLabel outputLabel1) {
        this.lblAnnio = outputLabel1;
    }

    public OutputLabel getLblAnnio() {
        return lblAnnio;
    }

    public void setLblTipoReporte(OutputLabel outputLabel2) {
        this.lblTipoReporte = outputLabel2;
    }

    public OutputLabel getLblTipoReporte() {
        return lblTipoReporte;
    }

    public void setSelectAnnio(SelectOneMenu selectOneMenu4) {
        this.selectAnnio = selectOneMenu4;
    }

    public SelectOneMenu getSelectAnnio() {
        return selectAnnio;
    }

    public void setSelectTipoReporte(SelectOneMenu selectOneMenu1) {
        this.selectTipoReporte = selectOneMenu1;
    }

    public SelectOneMenu getSelectTipoReporte() {
        return selectTipoReporte;
    }

    public void setCmbGenerar(CommandButton commandButton2) {
        this.cmbGenerar = commandButton2;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
    }

    public void setLblTipoInfraestructura(OutputLabel outputLabel3) {
        this.lblTipoInfraestructura = outputLabel3;
    }

    public OutputLabel getLblTipoInfraestructura() {
        return lblTipoInfraestructura;
    }

    public void setSelectTipoInfraestructura(SelectOneMenu selectOneMenu2) {
        this.selectTipoInfraestructura = selectOneMenu2;
    }

    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
    }

    public void setLblConcesion(OutputLabel outputLabel4) {
        this.lblConcesion = outputLabel4;
    }

    public OutputLabel getLblConcesion() {
        return lblConcesion;
    }

    public void setSelectConcesion(SelectOneMenu selectOneMenu3) {
        this.selectConcesion = selectOneMenu3;
    }

    public SelectOneMenu getSelectConcesion() {
        return selectConcesion;
    }

    public void setLblModalidad(OutputLabel outputLabel5) {
        this.lblModalidad = outputLabel5;
    }

    public OutputLabel getLblModalidad() {
        return lblModalidad;
    }

    public void setSelectModalidad(SelectOneMenu selectOneMenu5) {
        this.selectModalidad = selectOneMenu5;
    }

    public SelectOneMenu getSelectModalidad() {
        return selectModalidad;
    }

    public void setPnlgReconocimientoContratos(PanelGrid panelGrid2) {
        this.pnlgReconocimientoContratos = panelGrid2;
    }

    public PanelGrid getPnlgReconocimientoContratos() {
        return pnlgReconocimientoContratos;
    }
    
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

    private List<InfraestructuraTipoVO> listaInfraestructura;
    
    public List<InfraestructuraTipoVO> listarInfraestructura() throws SQLException {
        try {
            listaInfraestructura = getInfraestructuraTipoServiceImpl().query();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaInfraestructura;
    }    
    
    /**
     * @author Paul Rivera
     * @return lista de concesiones para que se renderize en el combo
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
    
    
    /**
     * @author Paul Rivera
     * @return concesion para que se renderize en el combo
     */
    public List<SelectItem> getConcesionSelectItems() throws SQLException {
        concesionSelectItems = new ArrayList<SelectItem>();
        concesionSelectItems.add(new SelectItem("-1","Seleccione"));
        List<ConcesionVO> lista=listarConcesion();
        int i=0;
        for(ConcesionVO cvo:lista){
            concesionSelectItems.add(new SelectItem(i++, String.valueOf(cvo.getCsiNombre())));
        }
        return concesionSelectItems;
    }    
    /**
     * @author Paul Rivera
     * @return concesion seleccionado del combo
     */
    public String getSelectedConcesion(){
        if("".equals(getConcesion()) || getConcesion() ==null){
            return "";
        }else{
            return getConcesion();
        }
    }    
    
    /**
     * @author Paul Rivera
     * @return tipo de infraestructura para que se renderize en el combo
     */
    public List<SelectItem> getTipoInfraestructuraSelectItems() throws SQLException {
        tipoInfraestructuraSelectItems = new ArrayList<SelectItem>();
        tipoInfraestructuraSelectItems.add(new SelectItem("-1","Seleccione"));
        List<InfraestructuraTipoVO> lista=listarInfraestructura();
        int i=0;
        for(InfraestructuraTipoVO ivo:lista){
            tipoInfraestructuraSelectItems.add(new SelectItem(i++, String.valueOf(ivo.getTinNombre())));
        }
        return tipoInfraestructuraSelectItems;
    }
    /**
     * @author Paul Rivera
     * @return tipo de infraestructura seleccionado del combo
     */
    public String getSelectedTipoInfraestructura(){
        if("".equals(getTipoInfraestructura()) || getTipoInfraestructura() ==null){
            return "";
        }else{
            return getTipoInfraestructura();
        }
    }
        
    /**
     * @author Paul Rivera
     * @return lista de años para que se renderize en el combo
     */
    public List<SelectItem> getAnnioSelectItems() {
        annioSelectItems = new ArrayList<SelectItem>();
        int annioLim = Calendar.getInstance().get(Calendar.YEAR) + 1;  
        //annioSelectItems.add(new SelectItem("-1","Seleccione"));
        for (int i = 1990; i < annioLim; i++) {
            annioSelectItems.add(new SelectItem(i, String.valueOf(i)));
        }
        return annioSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return año seleccionado del combo
     */
    public String getSelectedAnnio(){
        if("".equals(getAnnio()) || getAnnio() ==null){
            return "";
        }else{
            return getAnnio();
        }
    }   
    
    @ManagedProperty(value="#{modalidadConcesionServiceImpl}")
    private ModalidadConcesionServiceImpl modalidadConcesionServiceImpl;
    public ModalidadConcesionVO modalidadConcesionVO=new ModalidadConcesionVO();
    public void setModalidadConcesionServiceImpl(ModalidadConcesionServiceImpl modalidadConcesionServiceImpl) {
        this.modalidadConcesionServiceImpl = modalidadConcesionServiceImpl;
    }

    public void setModalidadConcesionVO(ModalidadConcesionVO modalidadConcesionVO) {
        this.modalidadConcesionVO = modalidadConcesionVO;
    }

    public ModalidadConcesionVO getModalidadConcesionVO() {
        return modalidadConcesionVO;
    }


    public List<ModalidadConcesionVO> listarModalidadConcesion() throws SQLException{
        List<ModalidadConcesionVO> list=this.modalidadConcesionServiceImpl.query();
        return list;
    }
    
    /**
     * @author Paul Rivera
     * @return modalidad para que se renderize en el combo
     */
    public List<SelectItem> getModalidadConcesionSelectItems() throws SQLException {
        modalidadConcesionSelectItems = new ArrayList<SelectItem>();
        modalidadConcesionSelectItems.add(new SelectItem("-1","Seleccione"));
        List<ModalidadConcesionVO> lista=listarModalidadConcesion();
        int i=0;
        for(ModalidadConcesionVO mcvo:lista){
            modalidadConcesionSelectItems.add(new SelectItem(i++, String.valueOf(mcvo.getMcoNombre())));
        }
        return modalidadConcesionSelectItems;
    }    
    /**
     * @author Paul Rivera
     * @return modalidad seleccionado del combo
     */
    public String getSelectedModalidad(){
        if("".equals(getModalidadConcesion()) || getModalidadConcesion() ==null){
            return "";
        }else{
            return getModalidadConcesion();
        }
    }    
    
    /**
     * @author Paul Rivera
     * @return lista de tipoReporte para que se renderize en el combo
     */
    public List<SelectItem> getTipoReporteSelectItems() {
        tipoReporteSelectItems = new ArrayList<SelectItem>();
        tipoReporteSelectItems.add(new SelectItem("-1","Seleccione"));
        String[] reporte=new String[2];
        reporte[0]="bimestral";
        reporte[1]="trimestral";
        for (int i = 0; i < reporte.length; i++) {
            tipoReporteSelectItems.add(new SelectItem(i, String.valueOf(reporte[i])));
        }
        return tipoReporteSelectItems;
    }

     public List<SelectItem> getTrimestreSelectItems() {
         trimestreSelectItems = new ArrayList<SelectItem>();
         trimestreSelectItems.add(new SelectItem("1","Primero"));
         trimestreSelectItems.add(new SelectItem("2","Segundo"));
         trimestreSelectItems.add(new SelectItem("3","Trecero"));
         trimestreSelectItems.add(new SelectItem("4","Cuarto"));
         return trimestreSelectItems;
     }

    /**
     * @author Paul Rivera
     * @return tipoReporte seleccionado del combo
     */
    public String getSelectedTipoReporte(){
        if("".equals(getTipoReporte()) || getTipoReporte() ==null){
            return "";
        }else{
            return getTipoReporte();
        }
    }   
    public OutputLabel getLblTrimestre() {
        return lblTrimestre;
    }

    public void setLblTrimestre(OutputLabel lblTrimestre) {
        this.lblTrimestre = lblTrimestre;
    }

    public SelectOneMenu getSelectTrimestre() {
        return selectTrimestre;
    }

    public void setSelectTrimestre(SelectOneMenu selectTrimestre) {
        this.selectTrimestre = selectTrimestre;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    

    public void setTrimestreSelectItems(List<SelectItem> trimestreSelectItems) {
        this.trimestreSelectItems = trimestreSelectItems;
    }
    
}