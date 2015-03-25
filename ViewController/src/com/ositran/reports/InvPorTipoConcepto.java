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
    private SelectOneMenu selectConcepto;
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

    public void setSelectConcepto(SelectOneMenu selectOneMenu3) {
        this.selectConcepto = selectOneMenu3;
    }

    public SelectOneMenu getSelectConcepto() {
        return selectConcepto;
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
