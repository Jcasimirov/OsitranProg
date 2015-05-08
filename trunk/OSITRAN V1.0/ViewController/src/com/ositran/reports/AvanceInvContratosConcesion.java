package com.ositran.reports;

import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

@ManagedBean(name = "backing_ositran_reports_avanceInvContratosConcesion")
@RequestScoped
@Generated(value = "1ositran/reports/avanceInvContratosConcesion.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class AvanceInvContratosConcesion {
    private HtmlForm formAvanceInversion;
    private PanelGrid pnlgAvanceInversion;
    private OutputLabel lblAnnio;
    private OutputLabel lblMes;
    private CommandButton cmbGenerar;
    private SelectOneMenu selectMes;
    private SelectOneMenu selectAnnio;
    private OutputLabel lblTipoInfraestructura;
    private OutputLabel lblConcesion;
    private OutputLabel lblModalidad;
    private SelectOneMenu selectModalidad;
    private SelectOneMenu selectConcesion;
    private SelectOneMenu selectTipoInfraestructura;
    private String annio;
    List<SelectItem> annioSelectItems=new ArrayList<SelectItem>();
    private String mes;
    List<SelectItem> mesSelectItems=new ArrayList<SelectItem>();
    private String concesion;
    List<SelectItem> concesionSelectItems=new ArrayList<SelectItem>();    
    private String modalidad;
    List<SelectItem> modalidadesSelectItems=new ArrayList<SelectItem>();
    private String tipoInfraestructura;
    List<SelectItem> tipoInfraestructuraSelectItems=new ArrayList<SelectItem>();    
    
    //EAPR: metodo agregado para inicializar los combos con valores actuales
    public AvanceInvContratosConcesion(){
        this.setAnnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        this.setMes(String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1));
    }

    public void setFormAvanceInversion(HtmlForm formAvanceInversion) {
        this.formAvanceInversion = formAvanceInversion;
    }

    public HtmlForm getFormAvanceInversion() {
        return formAvanceInversion;
    }

    public void setPnlgAvanceInversion(PanelGrid panelGrid1) {
        this.pnlgAvanceInversion = panelGrid1;
    }

    public PanelGrid getPnlgAvanceInversion() {
        return pnlgAvanceInversion;
    }

    public void setLblAnnio(OutputLabel outputLabel6) {
        this.lblAnnio = outputLabel6;
    }

    public OutputLabel getLblAnnio() {
        return lblAnnio;
    }

    public void setLblMes(OutputLabel outputLabel1) {
        this.lblMes = outputLabel1;
    }

    public OutputLabel getLblMes() {
        return lblMes;
    }

    public void setCmbGenerar(CommandButton commandButton1) {
        this.cmbGenerar = commandButton1;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
    }

    public void setSelectMes(SelectOneMenu selectOneMenu6) {
        this.selectMes = selectOneMenu6;
    }

    public SelectOneMenu getSelectMes() {
        return selectMes;
    }

    public void setSelectAnnio(SelectOneMenu selectOneMenu1) {
        this.selectAnnio = selectOneMenu1;
    }

    public SelectOneMenu getSelectAnnio() {
        return selectAnnio;
    }

    public void setLblTipoInfraestructura(OutputLabel outputLabel2) {
        this.lblTipoInfraestructura = outputLabel2;
    }

    public OutputLabel getLblTipoInfraestructura() {
        return lblTipoInfraestructura;
    }

    public void setLblConcesion(OutputLabel outputLabel3) {
        this.lblConcesion = outputLabel3;
    }

    public OutputLabel getLblConcesion() {
        return lblConcesion;
    }

    public void setLblModalidad(OutputLabel outputLabel4) {
        this.lblModalidad = outputLabel4;
    }

    public OutputLabel getLblModalidad() {
        return lblModalidad;
    }

    public void setSelectModalidad(SelectOneMenu selectOneMenu4) {
        this.selectModalidad = selectOneMenu4;
    }

    public SelectOneMenu getSelectModalidad() {
        return selectModalidad;
    }

    public void setSelectConcesion(SelectOneMenu selectOneMenu5) {
        this.selectConcesion = selectOneMenu5;
    }

    public SelectOneMenu getSelectConcesion() {
        return selectConcesion;
    }

    public void setSelectTipoInfraestructura(SelectOneMenu selectOneMenu3) {
        this.selectTipoInfraestructura = selectOneMenu3;
    }

    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
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

    public void setConcesion(String concesion) {
        this.concesion = concesion;
    }

    public String getConcesion() {
        return concesion;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setTipoInfraestructura(String tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public String getTipoInfraestructura() {
        return tipoInfraestructura;
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
        //EAPR: Metodo modificado para que el listado siempre se inicialice vacio y evitar duplicados
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
        //annioSelectItems.add(new SelectItem("-1","Seleccione"));
        //EAPR: Metodo modificado para evitar que el año maximo este hardcoded y siempre se inicialice
        annioSelectItems = new ArrayList<SelectItem>();
        int annioLim = Calendar.getInstance().get(Calendar.YEAR) + 1;     
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
        //mesSelectItems.add(new SelectItem("-1","Seleccione"));
        //EAPR: Metodo modificado para que el listado siempre se inicialice vacio 
        //(evitar duplicados) y el indice de la lista empiece en 1 (Enero)
        mesSelectItems = new ArrayList<SelectItem>();
        String[] mes=new String[12];
        mes[0]="Enero";
        mes[1]="Febrero";
        mes[2]="Marzo";
        mes[3]="Abril";
        mes[4]="Mayo";
        mes[5]="Junio";
        mes[6]="Julio";
        mes[7]="Agosto";
        mes[8]="Septiembre";
        mes[9]="Octubre";
        mes[10]="Noviembre";
        mes[11]="Diciembre";
        for (int i = 0; i < mes.length; i++) {
            mesSelectItems.add(new SelectItem(i + 1, String.valueOf(mes[i])));
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
        //EAPR: Metodo modificado para que el listado siempre se inicialice vacio y evitar duplicados
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
     * @return lista de modalidades para que se renderize en el combo
     */
    public List<SelectItem> getModalidadesSelectItems() {
        //EAPR: Metodo modificado para que el listado siempre se inicialice vacio y evitar duplicados
        modalidadesSelectItems = new ArrayList<SelectItem>();
        modalidadesSelectItems.add(new SelectItem("-1","Seleccione"));
        String[] modalidad=new String[2];
        modalidad[0]="honerosa";
        modalidad[1]="autosostenible";
        for (int i = 0; i < modalidad.length; i++) {
            modalidadesSelectItems.add(new SelectItem(i, String.valueOf(modalidad[i])));
        }
        return modalidadesSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return modalidad seleccionada del combo
     */
    public String getSelectedModalidades(){
        if("".equals(getModalidad()) || getModalidad() ==null){
            return "";
        }else{
            return getModalidad();
        }
    }    
    
    
}
