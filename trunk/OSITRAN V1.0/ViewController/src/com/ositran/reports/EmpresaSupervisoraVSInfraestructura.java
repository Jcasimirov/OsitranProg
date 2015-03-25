package com.ositran.reports;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.component.html.HtmlForm;

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
}
