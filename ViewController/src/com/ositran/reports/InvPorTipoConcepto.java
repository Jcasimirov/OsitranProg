package com.ositran.reports;

import com.ositran.service.InversionDescripcionServices;
import com.ositran.serviceimpl.ConceptoInversionServiceImpl;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.ConceptoInversionVO;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import com.ositran.vo.bean.InversionDescripcionVO;

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

@ManagedBean(name = "backing_ositran_reports_invPorTipoConcepto")
@RequestScoped
@Generated(value = "1ositran/reports/invPorTipoConcepto.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class InvPorTipoConcepto {
    private HtmlForm form1;
    private PanelGrid pnlgInversionTIpoConcepto;
    private OutputLabel lblAnnio;
    private SelectOneMenu selectAnnio;
    private OutputLabel lblMes;
    private SelectOneMenu selectMes;
    private CommandButton cmbGenerar;
    private OutputLabel lblTipoInfraestructura;
    private SelectOneMenu selectTipoInfraestructura;
    private OutputLabel lblConcesion;
    private SelectOneMenu selectConcesion;
    private OutputLabel lblConcepto;
    private SelectOneMenu selectConceptoInversion;
    private String tipoInfraestructura;
    List<SelectItem> tipoInfraestructuraSelectItems=new ArrayList<SelectItem>();        
    private String concesion;
    List<SelectItem> concesionSelectItems=new ArrayList<SelectItem>();        
    private String annio;
    List<SelectItem> annioSelectItems=new ArrayList<SelectItem>();
    private String mes;
    List<SelectItem> mesSelectItems=new ArrayList<SelectItem>();
    private String conceptoInversion;
    List<SelectItem> conceptoInversionSelectItems=new ArrayList<SelectItem>();


    public void setConceptoInversion(String conceptoInversion) {
        this.conceptoInversion = conceptoInversion;
    }

    public String getConceptoInversion() {
        return conceptoInversion;
    }

    public void setConcesion(String concesion) {
        this.concesion = concesion;
    }

    public String getConcesion() {
        return concesion;
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
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setPnlgInversionTIpoConcepto(PanelGrid panelGrid1) {
        this.pnlgInversionTIpoConcepto = panelGrid1;
    }

    public PanelGrid getPnlgInversionTIpoConcepto() {
        return pnlgInversionTIpoConcepto;
    }

    public void setLblAnnio(OutputLabel outputLabel6) {
        this.lblAnnio = outputLabel6;
    }

    public OutputLabel getLblAnnio() {
        return lblAnnio;
    }

    public void setSelectAnnio(SelectOneMenu selectOneMenu6) {
        this.selectAnnio = selectOneMenu6;
    }

    public SelectOneMenu getSelectAnnio() {
        return selectAnnio;
    }

    public void setLblMes(OutputLabel outputLabel1) {
        this.lblMes = outputLabel1;
    }

    public OutputLabel getLblMes() {
        return lblMes;
    }

    public void setSelectMes(SelectOneMenu selectOneMenu4) {
        this.selectMes = selectOneMenu4;
    }

    public SelectOneMenu getSelectMes() {
        return selectMes;
    }

    public void setCmbGenerar(CommandButton commandButton1) {
        this.cmbGenerar = commandButton1;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
    }

    public void setLblTipoInfraestructura(OutputLabel outputLabel2) {
        this.lblTipoInfraestructura = outputLabel2;
    }

    public OutputLabel getLblTipoInfraestructura() {
        return lblTipoInfraestructura;
    }

    public void setSelectTipoInfraestructura(SelectOneMenu selectOneMenu1) {
        this.selectTipoInfraestructura = selectOneMenu1;
    }

    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
    }

    public void setLblConcesion(OutputLabel outputLabel3) {
        this.lblConcesion = outputLabel3;
    }

    public OutputLabel getLblConcesion() {
        return lblConcesion;
    }

    public void setSelectConcesion(SelectOneMenu selectOneMenu2) {
        this.selectConcesion = selectOneMenu2;
    }

    public SelectOneMenu getSelectConcesion() {
        return selectConcesion;
    }

    public void setLblConcepto(OutputLabel outputLabel4) {
        this.lblConcepto = outputLabel4;
    }

    public OutputLabel getLblConcepto() {
        return lblConcepto;
    }

    public void setSelectConceptoInversion(SelectOneMenu selectOneMenu3) {
        this.selectConceptoInversion = selectOneMenu3;
    }

    public SelectOneMenu getSelectConceptoInversion() {
        return selectConceptoInversion;
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
     * @return tipo de infraestructura para que se renderize en el combo
     */
    public List<SelectItem> getTipoInfraestructuraSelectItems() throws SQLException {
        tipoInfraestructuraSelectItems.add(new SelectItem("-1","Seleccione"));
        List<InfraestructuraTipoVO> lista=listarInfraestructura();
        int i=0;
        for(InfraestructuraTipoVO ivo:lista){
            tipoInfraestructuraSelectItems.add(new SelectItem(ivo.getTinId(), String.valueOf(ivo.getTinNombre())));
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
        concesionSelectItems.add(new SelectItem("-1","Seleccione"));
        List<ConcesionVO> lista=listarConcesion();
        int i=0;
        for(ConcesionVO cvo:lista){
            concesionSelectItems.add(new SelectItem(cvo.getCsiId()+"", String.valueOf(cvo.getCsiNombre())));
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
    
    /**
     * @author Paul Rivera
     * @return lista de meses para que se renderize en el combo
     */
    public List<SelectItem> getMesesSelectItems() {
        mesSelectItems.add(new SelectItem("-1","Seleccione"));
        String[] mes=new String[12];
        mes[0]="enero";
        mes[1]="febrero";
        mes[2]="marzo";
        mes[3]="abril";
        mes[4]="mayo";
        mes[5]="junio";
        mes[6]="julio";
        mes[7]="agosto";
        mes[8]="septiembre";
        mes[9]="octubre";
        mes[10]="noviembre";
        mes[11]="diciembre";
        for (int i = 0; i < mes.length; i++) {
            mesSelectItems.add(new SelectItem(i+1, String.valueOf(mes[i])));
        }
        return mesSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return mes seleccionado del combo
     */
    public String getSelectedMes(){
        if("".equals(getMes()) || getMes() ==null){
            return "";
        }else{
            return getMes();
        }
    }
    
    @ManagedProperty(value="#{conceptoInversionVO}")
    ConceptoInversionVO conceptoInversionVO;
        
    @ManagedProperty(value = "#{inversionDescripcionServicesImpl}")
    private InversionDescripcionServices inversionDescripcionServicesImpl;    
        
    @ManagedProperty(value="#{conceptoInversionServiceImpl}")
    private ConceptoInversionServiceImpl conceptoInversionServiceImpl;
    public void setConceptoInversionServiceImpl(ConceptoInversionServiceImpl conceptoInversionServiceImpl) {
        this.conceptoInversionServiceImpl = conceptoInversionServiceImpl;
    }
    public void setConceptoInversionVO(ConceptoInversionVO conceptoInversionVO) {
        this.conceptoInversionVO = conceptoInversionVO;
    }
    
    public ConceptoInversionVO getConceptoInversionVO() {
        return conceptoInversionVO;
    }

    public List<ConceptoInversionVO> listarConceptoInversion() throws SQLException{
        List<ConceptoInversionVO> list=this.conceptoInversionServiceImpl.query();
        return list;
    }
    public List<InversionDescripcionVO> listarInversionDescripcion() {
        List<InversionDescripcionVO> listaDescripcionTipoInversion=new ArrayList<InversionDescripcionVO>();
        try {
            listaDescripcionTipoInversion = inversionDescripcionServicesImpl.query();

        } catch (Exception e) {
            System.out.println("   PROBLEMAS CON EL LISTADO DE INVERSION DESCRIPCION");
            e.printStackTrace();
        }
return listaDescripcionTipoInversion;
    }
    /**
     * @author Paul Rivera
     * @return concepto para que se renderize en el combo
     */
    public List<SelectItem> getConceptoInversionSelectItems() throws SQLException {
        conceptoInversionSelectItems.add(new SelectItem("-1","Seleccione"));
        List<InversionDescripcionVO> lista=listarInversionDescripcion();
        int i=0;
        for(InversionDescripcionVO cvo:lista){
            conceptoInversionSelectItems.add(new SelectItem(cvo.getItdId()+"", String.valueOf(cvo.getItdDescripcion())));
        }
        return conceptoInversionSelectItems;
    }    
    /**
     * @author Paul Rivera
     * @return concepto seleccionado del combo
     */
    public String getSelectedConceptoInversion(){
        if("".equals(getConceptoInversion()) || getConceptoInversion() ==null){
            return "";
        }else{
            return getConceptoInversion();
        }
    }

    public InversionDescripcionServices getInversionDescripcionServicesImpl() {
        return inversionDescripcionServicesImpl;
    }

    public void setInversionDescripcionServicesImpl(InversionDescripcionServices inversionDescripcionServicesImpl) {
        this.inversionDescripcionServicesImpl = inversionDescripcionServicesImpl;
    }
}
