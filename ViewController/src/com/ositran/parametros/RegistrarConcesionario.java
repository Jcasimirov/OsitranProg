package com.ositran.parametros;

import com.ositran.serviceimpl.ConcesionarioServiceImpl;

import com.ositran.vo.bean.ConcesionarioVO;

import java.io.IOException;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.outputpanel.OutputPanel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_parametros_registrarConcesionario")
@RequestScoped
@Generated(value = "1ositran/parametros/registrarConcesionario.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class RegistrarConcesionario {
    
    @ManagedProperty(value="#{concesionarioServiceImpl}")
    private ConcesionarioServiceImpl concesionarioServiceImpl;
    
    private ConcesionarioVO concesionarioVO=new ConcesionarioVO();

    private DataGrid dataGrid1;
    private OutputLabel outputLabelNombre;
    private InputText inputTextNombreConcesionario;
    private OutputLabel outputLabelSiglas;
    private InputText inputTextSiglasNombre;
    private OutputLabel outputLabelTelefono;
    private InputText inputTextTelefono;
    private OutputPanel outputPanelTipoDocu;
    private InputText inputTextNroDocumento;
    private OutputLabel outputLabelNroDocu;
    private SelectOneMenu selectOneMenuTipoDocu;
    private OutputLabel outputLabelDir;
    private InputText inputTextDireccion;
    private OutputLabel outputLabelCorreo;
    private InputText inputTextCorreo;
    private OutputLabel outputLabelRepreLegal;
    private InputText inputTextRepreLegal;
    private OutputLabel outputLabelCargo;
    private InputText inputTextCargoRepreLegal;
    private OutputLabel outputLabelTipoDocu;
    private PanelGrid panelGrid1;
    private CommandButton commandButton1;
    private CommandButton commandButton2;

    public void setDataGrid1(DataGrid dataGrid1) {
        this.dataGrid1 = dataGrid1;
    }

    public DataGrid getDataGrid1() {
        return dataGrid1;
    }

    public void setOutputLabelNombre(OutputLabel outputLabel1) {
        this.outputLabelNombre = outputLabel1;
    }

    public OutputLabel getOutputLabelNombre() {
        return outputLabelNombre;
    }

    public void setInputTextNombreConcesionario(InputText inputText1) {
        this.inputTextNombreConcesionario = inputText1;
    }

    public InputText getInputTextNombreConcesionario() {
        return inputTextNombreConcesionario;
    }

    public void setOutputLabelSiglas(OutputLabel outputLabel1) {
        this.outputLabelSiglas = outputLabel1;
    }

    public OutputLabel getOutputLabelSiglas() {
        return outputLabelSiglas;
    }

    public void setInputTextSiglasNombre(InputText inputText1) {
        this.inputTextSiglasNombre = inputText1;
    }

    public InputText getInputTextSiglasNombre() {
        return inputTextSiglasNombre;
    }

    public void setOutputLabelTelefono(OutputLabel outputLabel1) {
        this.outputLabelTelefono = outputLabel1;
    }

    public OutputLabel getOutputLabelTelefono() {
        return outputLabelTelefono;
    }

    public void setInputTextTelefono(InputText inputText1) {
        this.inputTextTelefono = inputText1;
    }

    public InputText getInputTextTelefono() {
        return inputTextTelefono;
    }

    public void setOutputPanelTipoDocu(OutputPanel outputPanel1) {
        this.outputPanelTipoDocu = outputPanel1;
    }

    public OutputPanel getOutputPanelTipoDocu() {
        return outputPanelTipoDocu;
    }

    public void setInputTextNroDocumento(InputText inputText1) {
        this.inputTextNroDocumento = inputText1;
    }

    public InputText getInputTextNroDocumento() {
        return inputTextNroDocumento;
    }

    public void setOutputLabelNroDocu(OutputLabel outputLabel1) {
        this.outputLabelNroDocu = outputLabel1;
    }

    public OutputLabel getOutputLabelNroDocu() {
        return outputLabelNroDocu;
    }

    public void setSelectOneMenuTipoDocu(SelectOneMenu selectOneMenu1) {
        this.selectOneMenuTipoDocu = selectOneMenu1;
    }

    public SelectOneMenu getSelectOneMenuTipoDocu() {
        return selectOneMenuTipoDocu;
    }

    public void setOutputLabelDir(OutputLabel outputLabel1) {
        this.outputLabelDir = outputLabel1;
    }

    public OutputLabel getOutputLabelDir() {
        return outputLabelDir;
    }

    public void setInputTextDireccion(InputText inputText1) {
        this.inputTextDireccion = inputText1;
    }

    public InputText getInputTextDireccion() {
        return inputTextDireccion;
    }

    public void setOutputLabelCorreo(OutputLabel outputLabel1) {
        this.outputLabelCorreo = outputLabel1;
    }

    public OutputLabel getOutputLabelCorreo() {
        return outputLabelCorreo;
    }

    public void setInputTextCorreo(InputText inputText1) {
        this.inputTextCorreo = inputText1;
    }

    public InputText getInputTextCorreo() {
        return inputTextCorreo;
    }

    public void setOutputLabelRepreLegal(OutputLabel outputLabel1) {
        this.outputLabelRepreLegal = outputLabel1;
    }

    public OutputLabel getOutputLabelRepreLegal() {
        return outputLabelRepreLegal;
    }

    public void setInputTextRepreLegal(InputText inputText1) {
        this.inputTextRepreLegal = inputText1;
    }

    public InputText getInputTextRepreLegal() {
        return inputTextRepreLegal;
    }

    public void setOutputLabelCargo(OutputLabel outputLabel1) {
        this.outputLabelCargo = outputLabel1;
    }

    public OutputLabel getOutputLabelCargo() {
        return outputLabelCargo;
    }

    public void setInputTextCargoRepreLegal(InputText inputText1) {
        this.inputTextCargoRepreLegal = inputText1;
    }

    public InputText getInputTextCargoRepreLegal() {
        return inputTextCargoRepreLegal;
    }

    public void setOutputLabelTipoDocu(OutputLabel outputLabel1) {
        this.outputLabelTipoDocu = outputLabel1;
    }

    public OutputLabel getOutputLabelTipoDocu() {
        return outputLabelTipoDocu;
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

    public void setCommandButton2(CommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CommandButton getCommandButton2() {
        return commandButton2;
    }
    
    public void concesionarioIns() throws IOException{
        concesionarioVO.setCncDescripcion("cncDescripcion");
        concesionarioVO.setCncEstado(1);
        this.concesionarioServiceImpl.insert(concesionarioVO);
        FacesContext context=FacesContext.getCurrentInstance();
        ExternalContext externalContext=context.getExternalContext();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        String redirectPath="/faces/ositran/parametros/mantenimientoConcesionario.xhtml";
        externalContext.redirect(servletContext.getContextPath()+redirectPath);        
    }

    public void setConcesionarioVO(ConcesionarioVO concesionarioVO) {
        this.concesionarioVO = concesionarioVO;
    }

    public ConcesionarioVO getConcesionarioVO() {
        return concesionarioVO;
    }

    public void setConcesionarioServiceImpl(ConcesionarioServiceImpl concesionarioServiceImpl) {
        this.concesionarioServiceImpl = concesionarioServiceImpl;
    }

}
