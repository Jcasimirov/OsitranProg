package com.ositran.parametros;

import com.ositran.serviceimpl.ConcesionarioServiceImpl;
import com.ositran.vo.bean.ConcesionarioVO;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_parametros_modificarConcesionario")
@RequestScoped
@Generated(value = "1ositran/parametros/modificarConcesionario.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class ModificarConcesionario {
    @ManagedProperty(value="#{concesionarioServiceImpl}")
    private ConcesionarioServiceImpl concesionarioServiceImpl;
    
    private ConcesionarioVO concesionarioVO=new ConcesionarioVO();

    private PanelGrid panelGrid1;
    private OutputLabel outputLabel1;
    private InputText inputTextNombreConcesionario;
    private OutputLabel outputLabelSiglasNombre;
    private InputText inputTextSiglasNombre;
    private OutputLabel outputLabelTelefono;
    private InputText inputTextTelefono;
    private OutputLabel outputLabelTipoDocu;
    private InputText inputTextNroDocumento;
    private SelectOneMenu selectOneMenuTipoDocu;
    private OutputLabel outputLabelNroDocu;
    private OutputLabel outputLabelDireccion;
    private InputText inputTextDireccion;
    private OutputLabel outputLabelCorreo;
    private InputText inputTextCorreo;
    private OutputLabel outputLabelRepreLegal;
    private InputText inputTextRepreLegal;
    private OutputLabel outputLabelCargo;
    private InputText inputTextCargo;
    private CommandButton commandButtonGuardar;
    private CommandButton commandButtonSalir;

    public void setPanelGrid1(PanelGrid panelGrid1) {
        this.panelGrid1 = panelGrid1;
    }

    public PanelGrid getPanelGrid1() {
        return panelGrid1;
    }

    public void setOutputLabel1(OutputLabel outputLabel1) {
        this.outputLabel1 = outputLabel1;
    }

    public OutputLabel getOutputLabel1() {
        return outputLabel1;
    }

    public void setInputTextNombreConcesionario(InputText inputText1) {
        this.inputTextNombreConcesionario = inputText1;
    }

    public InputText getInputTextNombreConcesionario() {
        return inputTextNombreConcesionario;
    }

    public void setOutputLabelSiglasNombre(OutputLabel outputLabel2) {
        this.outputLabelSiglasNombre = outputLabel2;
    }

    public OutputLabel getOutputLabelSiglasNombre() {
        return outputLabelSiglasNombre;
    }

    public void setInputTextSiglasNombre(InputText inputText1) {
        this.inputTextSiglasNombre = inputText1;
    }

    public InputText getInputTextSiglasNombre() {
        return inputTextSiglasNombre;
    }

    public void setOutputLabelTelefono(OutputLabel outputLabel3) {
        this.outputLabelTelefono = outputLabel3;
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

    public void setOutputLabelTipoDocu(OutputLabel outputLabel2) {
        this.outputLabelTipoDocu = outputLabel2;
    }

    public OutputLabel getOutputLabelTipoDocu() {
        return outputLabelTipoDocu;
    }

    public void setInputTextNroDocumento(InputText inputText1) {
        this.inputTextNroDocumento = inputText1;
    }

    public InputText getInputTextNroDocumento() {
        return inputTextNroDocumento;
    }

    public void setSelectOneMenuTipoDocu(SelectOneMenu selectOneMenu1) {
        this.selectOneMenuTipoDocu = selectOneMenu1;
    }

    public SelectOneMenu getSelectOneMenuTipoDocu() {
        return selectOneMenuTipoDocu;
    }

    public void setOutputLabelNroDocu(OutputLabel outputLabel2) {
        this.outputLabelNroDocu = outputLabel2;
    }

    public OutputLabel getOutputLabelNroDocu() {
        return outputLabelNroDocu;
    }

    public void setOutputLabelDireccion(OutputLabel outputLabel2) {
        this.outputLabelDireccion = outputLabel2;
    }

    public OutputLabel getOutputLabelDireccion() {
        return outputLabelDireccion;
    }

    public void setInputTextDireccion(InputText inputText1) {
        this.inputTextDireccion = inputText1;
    }

    public InputText getInputTextDireccion() {
        return inputTextDireccion;
    }

    public void setOutputLabelCorreo(OutputLabel outputLabel2) {
        this.outputLabelCorreo = outputLabel2;
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

    public void setOutputLabelRepreLegal(OutputLabel outputLabel2) {
        this.outputLabelRepreLegal = outputLabel2;
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

    public void setOutputLabelCargo(OutputLabel outputLabel2) {
        this.outputLabelCargo = outputLabel2;
    }

    public OutputLabel getOutputLabelCargo() {
        return outputLabelCargo;
    }

    public void setInputTextCargo(InputText inputText1) {
        this.inputTextCargo = inputText1;
    }

    public InputText getInputTextCargo() {
        return inputTextCargo;
    }

    public void setCommandButtonGuardar(CommandButton commandButton1) {
        this.commandButtonGuardar = commandButton1;
    }

    public CommandButton getCommandButtonGuardar() {
        return commandButtonGuardar;
    }

    public void setCommandButtonSalir(CommandButton commandButton1) {
        this.commandButtonSalir = commandButton1;
    }

    public CommandButton getCommandButtonSalir() {
        return commandButtonSalir;
    }


    public void setConcesionarioServiceImpl(ConcesionarioServiceImpl concesionarioServiceImpl) {
        this.concesionarioServiceImpl = concesionarioServiceImpl;
    }

    public void setConcesionarioVO(ConcesionarioVO concesionarioVO) {
        this.concesionarioVO = concesionarioVO;
    }

    public ConcesionarioVO getConcesionarioVO() {
        return concesionarioVO;
    }

}
