package com.ositran.parametros;

import com.ositran.serviceimpl.IgvServiceImpl;
import com.ositran.vo.bean.IgvVO;

import java.util.Date;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.event.ActionEvent;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.column.Column;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.message.Message;
import org.primefaces.component.messages.Messages;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;

@ManagedBean(name = "backing_parametros_registrarIgv")
@RequestScoped
@Generated(value = "1parametros/registrarIgv.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class RegistrarIgv {
    private HtmlForm form1;
    public IgvVO igvVO=new IgvVO();
    //www.journaldev.com/3851/primefaces-message-messages-growl-components-example
    @ManagedProperty(value="#{igvServiceImpl}")
    private IgvServiceImpl igvServiceImpl;
    private OutputLabel outputLabelPorcentaje;
    private InputText inputTextPorcentaje;
    private InputText inputTextFechaVigencia;
    private OutputLabel outputLabelFechavigencia;
    private Calendar calendarFechaVigencia=new Calendar();
    private OutputLabel outputLabelFechaCaducidad;
    private Calendar calendarFechaCaducidad=new Calendar();
    private PanelGrid panelGrid1;
    private Message message1=new Message();
    private Message message2;
    private Message message3;
    private CommandButton commandButton1;

    public void setigvServiceImpl(IgvServiceImpl igvServiceImpl) {
        this.igvServiceImpl = igvServiceImpl;
    }
    
    
    
    
    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setIgvVO(IgvVO igvVO) {
        this.igvVO = igvVO;
    }

    public IgvVO getIgvVO() {
        return igvVO;
    }
    
    
  
 
    /*  public void validarFecha(){
       Date d1= (Date)this.calendarFechaVigencia.getValue();
        Date d2= (Date)this.calendarFechaCaducidad.getValue();
        if(d1==d2){
            this.message1.setDisplay("El rango de fechas tiene que ser diferentes");
        }
    } */

    public void igvInsertar(ActionEvent actionEvent) {
        this.igvServiceImpl.insert(igvVO);
       
    }




  

    public void setOutputLabelPorcentaje(OutputLabel outputLabel1) {
        this.outputLabelPorcentaje = outputLabel1;
    }

    public OutputLabel getOutputLabelPorcentaje() {
        return outputLabelPorcentaje;
    }

    public void setInputTextPorcentaje(InputText inputText1) {
        this.inputTextPorcentaje = inputText1;
    }

    public InputText getInputTextPorcentaje() {
        return inputTextPorcentaje;
    }



    public void setInputTextFechaVigencia(InputText inputText2) {
        this.inputTextFechaVigencia = inputText2;
    }

    public InputText getInputTextFechaVigencia() {
        return inputTextFechaVigencia;
    }

    public void setOutputLabelFechavigencia(OutputLabel outputLabel1) {
        this.outputLabelFechavigencia = outputLabel1;
    }

    public OutputLabel getOutputLabelFechavigencia() {
        return outputLabelFechavigencia;
    }

    public void setCalendarFechaVigencia(Calendar calendar1) {
        this.calendarFechaVigencia = calendar1;
    }

    public Calendar getCalendarFechaVigencia() {
        return calendarFechaVigencia;
    }

    public void setOutputLabelFechaCaducidad(OutputLabel outputLabel1) {
        this.outputLabelFechaCaducidad = outputLabel1;
    }

    public OutputLabel getOutputLabelFechaCaducidad() {
        return outputLabelFechaCaducidad;
    }

    public void setCalendarFechaCaducidad(Calendar calendar1) {
        this.calendarFechaCaducidad = calendar1;
    }

    public Calendar getCalendarFechaCaducidad() {
        return calendarFechaCaducidad;
    }

    public void setPanelGrid1(PanelGrid panelGrid1) {
        this.panelGrid1 = panelGrid1;
    }

    public PanelGrid getPanelGrid1() {
        return panelGrid1;
    }
    




    public void setMessage1(Message message1) {
        this.message1 = message1;
    }

    public Message getMessage1() {
        return message1;
    }

    public void setMessage2(Message message2) {
        this.message2 = message2;
    }

    public Message getMessage2() {
        return message2;
    }

    public void setMessage3(Message message3) {
        this.message3 = message3;
    }

    public Message getMessage3() {
        return message3;
    }

    public void setCommandButton1(CommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CommandButton getCommandButton1() {
        return commandButton1;
    }
}
