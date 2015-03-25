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
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_reports_controlPlazosFlujoValorizacionesInversiones")
@RequestScoped
@Generated(value = "1ositran/reports/controlPlazosFlujoValorizacionesInversiones.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class ControlPlazosFlujoValorizacionesInversiones {
    private HtmlForm form1;
    private OutputLabel lblTipoInfraestructura;
    private OutputLabel lblAnnio;
    private OutputLabel lblMes;
    private SelectOneMenu selectMes;
    private SelectOneMenu selectAnnio;
    private SelectOneMenu selectTipoInfraestructura;
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

    public void setLblAnnio(OutputLabel outputLabel4) {
        this.lblAnnio = outputLabel4;
    }

    public OutputLabel getLblAnnio() {
        return lblAnnio;
    }

    public void setLblMes(OutputLabel outputLabel2) {
        this.lblMes = outputLabel2;
    }

    public OutputLabel getLblMes() {
        return lblMes;
    }

    public void setSelectMes(SelectOneMenu selectOneMenu3) {
        this.selectMes = selectOneMenu3;
    }

    public SelectOneMenu getSelectMes() {
        return selectMes;
    }

    public void setSelectAnnio(SelectOneMenu selectOneMenu2) {
        this.selectAnnio = selectOneMenu2;
    }

    public SelectOneMenu getSelectAnnio() {
        return selectAnnio;
    }

    public void setSelectTipoInfraestructura(SelectOneMenu selectOneMenu1) {
        this.selectTipoInfraestructura = selectOneMenu1;
    }

    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
    }

    public void setCmbGenerar(CommandButton commandButton1) {
        this.cmbGenerar = commandButton1;
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
