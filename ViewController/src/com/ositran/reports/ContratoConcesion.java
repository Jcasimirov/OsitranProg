package com.ositran.reports;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.component.html.HtmlForm;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_reports_contratoConcesion")
@RequestScoped
@Generated(value = "1ositran/reports/contratoConcesion.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class ContratoConcesion {
    private HtmlForm formContratoConcesion;
    private PanelGrid pnlgContratoConcesion;
    private OutputLabel lblTipoInfraestructura;
    private OutputLabel lblConcesion;
    private OutputLabel lblModalidad;
    private SelectOneMenu selectTipoInfraestructura;
    private SelectOneMenu selectConcesion;
    private SelectOneMenu selectModalidad;
    private CommandButton cmbGenerar;

    public void setFormContratoConcesion(HtmlForm formContratoConcesion) {
        this.formContratoConcesion = formContratoConcesion;
    }

    public HtmlForm getFormContratoConcesion() {
        return formContratoConcesion;
    }

    public void setPnlgContratoConcesion(PanelGrid pnlgContratoConcesion) {
        this.pnlgContratoConcesion = pnlgContratoConcesion;
    }

    public PanelGrid getPnlgContratoConcesion() {
        return pnlgContratoConcesion;
    }

    public void setLblTipoInfraestructura(OutputLabel outputLabel1) {
        this.lblTipoInfraestructura = outputLabel1;
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

    public void setSelectTipoInfraestructura(SelectOneMenu selectOneMenu4) {
        this.selectTipoInfraestructura = selectOneMenu4;
    }

    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
    }

    public void setSelectConcesion(SelectOneMenu selectOneMenu1) {
        this.selectConcesion = selectOneMenu1;
    }

    public SelectOneMenu getSelectConcesion() {
        return selectConcesion;
    }

    public void setSelectModalidad(SelectOneMenu selectOneMenu5) {
        this.selectModalidad = selectOneMenu5;
    }

    public SelectOneMenu getSelectModalidad() {
        return selectModalidad;
    }

    public void setCmbGenerar(CommandButton commandButton2) {
        this.cmbGenerar = commandButton2;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
    }
}
