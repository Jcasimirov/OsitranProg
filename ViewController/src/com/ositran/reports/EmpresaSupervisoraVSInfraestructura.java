package com.ositran.reports;

import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.EmpresaSupervisoraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.sql.SQLException;

import java.util.ArrayList;
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

@ManagedBean(name = "backing_ositran_reports_empresaSupervisoraVSInfraestructura")
@RequestScoped
@Generated(value = "1ositran/reports/empresaSupervisoraVSInfraestructura.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class EmpresaSupervisoraVSInfraestructura {
    private HtmlForm form1;
    private OutputLabel lblTipoInfraestructura;
    private OutputLabel lblConcesion;
    private OutputLabel lblEmpresaSupervisora;
    private SelectOneMenu selectTipoInfraestructura;
    private SelectOneMenu selectConcesion;
    private SelectOneMenu selectEmpresaSupervisora;
    private CommandButton cmbGenerar;
    private PanelGrid pnlgSupervisoraInfraestructura;
    private String tipoInfraestructura;
    List<SelectItem> tipoInfraestructuraSelectItems=new ArrayList<SelectItem>();
    private String concesion;
    List<SelectItem> concesionSelectItems=new ArrayList<SelectItem>();
    private String empresaSupervisora;
    List<SelectItem> empresaSupervisoraSelectItems=new ArrayList<SelectItem>();


    public void setEmpresaSupervisora(String empresaSupervisora) {
        this.empresaSupervisora = empresaSupervisora;
    }

    public String getEmpresaSupervisora() {
        return empresaSupervisora;
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

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setLblTipoInfraestructura(OutputLabel outputLabel1) {
        this.lblTipoInfraestructura = outputLabel1;
    }

    public OutputLabel getLblTipoInfraestructura() {
        return lblTipoInfraestructura;
    }

    public void setLblConcesion(OutputLabel outputLabel4) {
        this.lblConcesion = outputLabel4;
    }

    public OutputLabel getLblConcesion() {
        return lblConcesion;
    }

    public void setLblEmpresaSupervisora(OutputLabel outputLabel2) {
        this.lblEmpresaSupervisora = outputLabel2;
    }

    public OutputLabel getLblEmpresaSupervisora() {
        return lblEmpresaSupervisora;
    }

    public void setSelectTipoInfraestructura(SelectOneMenu selectOneMenu3) {
        this.selectTipoInfraestructura = selectOneMenu3;
    }

    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
    }

    public void setSelectConcesion(SelectOneMenu selectOneMenu4) {
        this.selectConcesion = selectOneMenu4;
    }

    public SelectOneMenu getSelectConcesion() {
        return selectConcesion;
    }

    public void setSelectEmpresaSupervisora(SelectOneMenu selectOneMenu1) {
        this.selectEmpresaSupervisora = selectOneMenu1;
    }

    public SelectOneMenu getSelectEmpresaSupervisora() {
        return selectEmpresaSupervisora;
    }

    public void setCmbGenerar(CommandButton commandButton1) {
        this.cmbGenerar = commandButton1;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
    }

    public void setPnlgSupervisoraInfraestructura(PanelGrid panelGrid2) {
        this.pnlgSupervisoraInfraestructura = panelGrid2;
    }

    public PanelGrid getPnlgSupervisoraInfraestructura() {
        return pnlgSupervisoraInfraestructura;
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
    List<EmpresaSupervisoraVO> listaEmpSup;    
    
    @ManagedProperty(value="#{empSupVO}")
    EmpresaSupervisoraVO empresaSupervisoraVO;
    
    @ManagedProperty(value="#{empresaSupervisoraServiceImpl}")
    private EmpresaSupervisoraServiceImpl empresaSupervisoraServiceImpl;
    public void setEmpresaSupervisoraServiceImpl(EmpresaSupervisoraServiceImpl empresaSupervisoraServiceImpl) {
        this.empresaSupervisoraServiceImpl = empresaSupervisoraServiceImpl;
    }
    public void setEmpresaSupervisoraVO(EmpresaSupervisoraVO empresaSupervisoraVO) {
        this.empresaSupervisoraVO = empresaSupervisoraVO;
    }

    public EmpresaSupervisoraVO getEmpresaSupervisoraVO() {
        return empresaSupervisoraVO;
    }

    public List<EmpresaSupervisoraVO> listarEmpresaSupervisora() throws SQLException{
        listaEmpSup=this.empresaSupervisoraServiceImpl.query();
        return listaEmpSup; 
    }
    
    /**
     * @author Paul Rivera
     * @return empresa supervisora para que se renderize en el combo
     */
    public List<SelectItem> getEmpresaSupervisoraSelectItems() throws SQLException {
        empresaSupervisoraSelectItems.add(new SelectItem("-1","Seleccione"));
        List<EmpresaSupervisoraVO> lista=listarEmpresaSupervisora();
        int i=0;
        for(EmpresaSupervisoraVO cvo:lista){
            empresaSupervisoraSelectItems.add(new SelectItem(i++, String.valueOf(cvo.getSupNombre())));
        }
        return empresaSupervisoraSelectItems;
    }    
    /**
     * @author Paul Rivera
     * @return empresa supervisora seleccionado del combo
     */
    public String getSelectedEmpresaSupervisora(){
        if("".equals(getEmpresaSupervisora()) || getEmpresaSupervisora() ==null){
            return "";
        }else{
            return getEmpresaSupervisora();
        }
    }  

}