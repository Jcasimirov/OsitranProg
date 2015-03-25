package com.ositran.reports;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.component.html.HtmlForm;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_reports_empresaSupervisoraVSInfraestructuraAeropuertos")
@RequestScoped
@Generated(value = "1ositran/reports/empresaSupervisoraVSInfraestructuraAeropuertos.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class EmpresaSupervisoraVSInfraestructuraAeropuertos {
    private HtmlForm formSupervisoraInfraestructuraAeropuertos;
    private PanelGrid pnlgSupervisoraInfraestructuraAeropuertos;
    private OutputLabel lblTipoInfraestructura;
    private OutputLabel lblConcesion;
    private OutputLabel lblEmpresaSupervisora;
    private SelectOneMenu selectTipoInfraestructura;
    private SelectOneMenu selectConcesion;
    private SelectOneMenu selectEmpresaSupervisora;
    private CommandButton cmbGenerar;

    public void setFormSupervisoraInfraestructuraAeropuertos(HtmlForm formSupervisoraInfraestructuraAeropuertos) {
        this.formSupervisoraInfraestructuraAeropuertos = formSupervisoraInfraestructuraAeropuertos;
    }

    public HtmlForm getFormSupervisoraInfraestructuraAeropuertos() {
        return formSupervisoraInfraestructuraAeropuertos;
    }

    public void setPnlgSupervisoraInfraestructuraAeropuertos(PanelGrid panelGrid1) {
        this.pnlgSupervisoraInfraestructuraAeropuertos = panelGrid1;
    }

    public PanelGrid getPnlgSupervisoraInfraestructuraAeropuertos() {
        return pnlgSupervisoraInfraestructuraAeropuertos;
    }

    public void setLblTipoInfraestructura(OutputLabel outputLabel1) {
        this.lblTipoInfraestructura = outputLabel1;
    }

    public OutputLabel getLblTipoInfraestructura() {
        return lblTipoInfraestructura;
    }

    public void setLblConcesion(OutputLabel outputLabel2) {
        this.lblConcesion = outputLabel2;
    }

    public OutputLabel getLblConcesion() {
        return lblConcesion;
    }

    public void setLblEmpresaSupervisora(OutputLabel outputLabel3) {
        this.lblEmpresaSupervisora = outputLabel3;
    }

    public OutputLabel getLblEmpresaSupervisora() {
        return lblEmpresaSupervisora;
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

    public void setSelectEmpresaSupervisora(SelectOneMenu selectOneMenu2) {
        this.selectEmpresaSupervisora = selectOneMenu2;
    }

    public SelectOneMenu getSelectEmpresaSupervisora() {
        return selectEmpresaSupervisora;
    }

    public void setCmbGenerar(CommandButton commandButton2) {
        this.cmbGenerar = commandButton2;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
    }
}
