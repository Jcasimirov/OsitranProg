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
}