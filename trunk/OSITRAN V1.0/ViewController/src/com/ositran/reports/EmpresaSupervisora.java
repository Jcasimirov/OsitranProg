package com.ositran.reports;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.component.html.HtmlForm;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_reports_empresaSupervisora")
@RequestScoped
@Generated(value = "1ositran/reports/empresaSupervisora.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class EmpresaSupervisora {
    private HtmlForm formSupervisora;
    private PanelGrid pnlgSupervisora;
    private OutputLabel lblTipoInfraestructura;
    private OutputLabel lblConcesion;
    private OutputLabel lblEstado;
    private SelectOneMenu selectTipoInfraestructura;
    private SelectOneMenu selectConcesion;
    private SelectOneMenu selectEstado;
    private OutputLabel outputLabel2;
    private OutputLabel lblFecIni;
    private OutputLabel lblFecFin;
    private Calendar calendarFecIni;
    private Calendar calendarFecFin;
    private CommandButton cmbGenerar;

    public void setForm1(HtmlForm form1) {
        this.formSupervisora = form1;
    }

    public HtmlForm getForm1() {
        return formSupervisora;
    }

    public void setPnlgSupervisora(PanelGrid panelGrid1) {
        this.pnlgSupervisora = panelGrid1;
    }

    public PanelGrid getPnlgSupervisora() {
        return pnlgSupervisora;
    }

    public void setLblTipoInfraestructura(OutputLabel outputLabel3) {
        this.lblTipoInfraestructura = outputLabel3;
    }

    public OutputLabel getLblTipoInfraestructura() {
        return lblTipoInfraestructura;
    }

    public void setLblConcesion(OutputLabel outputLabel1) {
        this.lblConcesion = outputLabel1;
    }

    public OutputLabel getLblConcesion() {
        return lblConcesion;
    }

    public void setLblEstado(OutputLabel outputLabel4) {
        this.lblEstado = outputLabel4;
    }

    public OutputLabel getLblEstado() {
        return lblEstado;
    }

    public void setSelectTipoInfraestructura(SelectOneMenu selectOneMenu2) {
        this.selectTipoInfraestructura = selectOneMenu2;
    }

    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
    }

    public void setSelectConcesion(SelectOneMenu selectOneMenu3) {
        this.selectConcesion = selectOneMenu3;
    }

    public SelectOneMenu getSelectConcesion() {
        return selectConcesion;
    }

    public void setSelectEstado(SelectOneMenu selectOneMenu4) {
        this.selectEstado = selectOneMenu4;
    }

    public SelectOneMenu getSelectEstado() {
        return selectEstado;
    }

    public void setOutputLabel2(OutputLabel outputLabel2) {
        this.outputLabel2 = outputLabel2;
    }

    public OutputLabel getOutputLabel2() {
        return outputLabel2;
    }

    public void setLblFecIni(OutputLabel outputLabel5) {
        this.lblFecIni = outputLabel5;
    }

    public OutputLabel getLblFecIni() {
        return lblFecIni;
    }

    public void setLblFecFin(OutputLabel outputLabel6) {
        this.lblFecFin = outputLabel6;
    }

    public OutputLabel getLblFecFin() {
        return lblFecFin;
    }

    public void setCalendarFecIni(Calendar calendar1) {
        this.calendarFecIni = calendar1;
    }

    public Calendar getCalendarFecIni() {
        return calendarFecIni;
    }

    public void setCalendarFecFin(Calendar calendar2) {
        this.calendarFecFin = calendar2;
    }

    public Calendar getCalendarFecFin() {
        return calendarFecFin;
    }

    public void setCmbGenerar(CommandButton commandButton2) {
        this.cmbGenerar = commandButton2;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
    }
}
