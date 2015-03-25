package com.ositran.reports;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
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
    List<SelectItem> concesionesSelectItems=new ArrayList<SelectItem>();    
    private String modalidad;
    List<SelectItem> modalidadesSelectItems=new ArrayList<SelectItem>();
    private String tipoInfraestructura;
    List<SelectItem> tipoInfraestructuraSelectItems=new ArrayList<SelectItem>();    
    

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

    /**
     * @author Paul Rivera
     * @return lista de años para que se renderize en el combo
     */
    public List<SelectItem> getAnnioSelectItems() {
        annioSelectItems.add(new SelectItem("-1","Seleccione"));
        for (int i = 1990; i < 2016; i++) {
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
            mesSelectItems.add(new SelectItem(i, String.valueOf(mes[i])));
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
     * @return lista de tipo de infraestructura para que se renderize en el combo
     */
    public List<SelectItem> getTipoInfraestructuraSelectItems() {
        tipoInfraestructuraSelectItems.add(new SelectItem("-1","Seleccione"));
        String[] tipoInfraestructura=new String[2];
        tipoInfraestructura[0]="Aeropuertos";
        tipoInfraestructura[1]="Ferrocarriles";
        for (int i = 0; i < tipoInfraestructura.length; i++) {
            tipoInfraestructuraSelectItems.add(new SelectItem(i, String.valueOf(tipoInfraestructura[i])));
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
     * @return lista de concesiones para que se renderize en el combo
     */
    public List<SelectItem> getConcesionesSelectItems() {
        concesionesSelectItems.add(new SelectItem("-1","Seleccione"));
        String[] concesion=new String[2];
        concesion[0]="concesion1";
        concesion[1]="concesion2";
        for (int i = 0; i < concesion.length; i++) {
            concesionesSelectItems.add(new SelectItem(i, String.valueOf(concesion[i])));
        }
        return concesionesSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return concesion seleccionada del combo
     */
    public String getSelectedConcesiones(){
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
