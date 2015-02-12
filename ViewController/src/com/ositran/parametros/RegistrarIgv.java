package com.ositran.parametros;

import com.ositran.serviceimpl.IgvServiceImpl;
import com.ositran.vo.bean.IgvVO;

import java.util.Date;

import javax.annotation.Generated;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpServletRequest;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.column.Column;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.component.dialog.Dialog;
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
  
   
   
    private CommandButton commandButton1;
    private Dialog dialog1;

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
    
    public Date getObtenerFechaHoy(){
        Date date=null;
        try{
            date=new Date();
        }catch(Exception e){
            e.getMessage();
        }
        return date;
    }
    
    public static void main(String[] args) {
        System.out.println(new RegistrarIgv().getObtenerFechaHoy());
        ;
   }

    public void igvInsertar(ActionEvent actionEvent) {
        igvVO.setIgvEstado(1);
        igvVO.setIgvFechaAlta(getObtenerFechaHoy());
        igvVO.setIgvTerminal(obtenerIpCliente());
        this.igvServiceImpl.insert(igvVO);
      
    }
    
    public String obtenerIpCliente(){
        String remoteAddr = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr(); 
        return remoteAddr;
    }
    
    
    
    public void addMessage(String summary) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
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
    





    public void setCommandButton1(CommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setDialog1(Dialog dialog1) {
        this.dialog1 = dialog1;
    }

    public Dialog getDialog1() {
        return dialog1;
    }
}
