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

@ManagedBean(name = "backing_ositran_reports_controlPlazosFlujoValorizacionesSupervision")
@RequestScoped
@Generated(value = "1ositran/reports/controlPlazosFlujoValorizacionesSupervision.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class ControlPlazosFlujoValorizacionesSupervision {
    private HtmlForm formControlPlazosFlujoSupervision;
    private PanelGrid pnlgControlPlazosSupervision;
    private OutputLabel lblTipoInfraestructura;
    private OutputLabel lblAnnio;
    private OutputLabel lblMes;
    private SelectOneMenu selectTipoInfraestructura;
    private SelectOneMenu selectAnnio;
    private SelectOneMenu selectMes;
    private CommandButton cmbGenerar;
    private String annio;
    List<SelectItem> annioSelectItems=new ArrayList<SelectItem>();
    private String mes;
    List<SelectItem> mesSelectItems=new ArrayList<SelectItem>();


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

    public void setFormControlPlazosFlujoSupervision(HtmlForm formControlPlazosFlujoSupervision) {
        this.formControlPlazosFlujoSupervision = formControlPlazosFlujoSupervision;
    }

    public HtmlForm getFormControlPlazosFlujoSupervision() {
        return formControlPlazosFlujoSupervision;
    }

    public void setPnlgControlPlazosSupervision(PanelGrid panelGrid1) {
        this.pnlgControlPlazosSupervision = panelGrid1;
    }

    public PanelGrid getPnlgControlPlazosSupervision() {
        return pnlgControlPlazosSupervision;
    }

    public void setLblTipoInfraestructura(OutputLabel outputLabel1) {
        this.lblTipoInfraestructura = outputLabel1;
    }

    public OutputLabel getLblTipoInfraestructura() {
        return lblTipoInfraestructura;
    }

    public void setLblAnnio(OutputLabel outputLabel2) {
        this.lblAnnio = outputLabel2;
    }

    public OutputLabel getLblAnnio() {
        return lblAnnio;
    }

    public void setLblMes(OutputLabel outputLabel3) {
        this.lblMes = outputLabel3;
    }

    public OutputLabel getLblMes() {
        return lblMes;
    }

    public void setSelectTipoInfraestructura(SelectOneMenu selectOneMenu4) {
        this.selectTipoInfraestructura = selectOneMenu4;
    }

    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
    }

    public void setSelectAnnio(SelectOneMenu selectOneMenu1) {
        this.selectAnnio = selectOneMenu1;
    }

    public SelectOneMenu getSelectAnnio() {
        return selectAnnio;
    }

    public void setSelectMes(SelectOneMenu selectOneMenu2) {
        this.selectMes = selectOneMenu2;
    }

    public SelectOneMenu getSelectMes() {
        return selectMes;
    }

    public void setCmbGenerar(CommandButton commandButton2) {
        this.cmbGenerar = commandButton2;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
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
    
    
}
