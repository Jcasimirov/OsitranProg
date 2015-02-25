package com.ositran.parametros;

import com.ositran.serviceimpl.ConcesionarioServiceImpl;
import com.ositran.vo.bean.ConcesionarioVO;

import java.util.List;

import java.util.Map;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.column.Column;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.layout.Layout;
import org.primefaces.component.layout.LayoutUnit;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_parametros_mantenimientoConcesionario")
@RequestScoped
@Generated(value = "1ositran/parametros/mantenimientoConcesionario.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoConcesionario {
    
    @ManagedProperty(value="#{concesionarioServiceImpl}")
    private ConcesionarioServiceImpl concesionarioServiceImpl;
    
    private ConcesionarioVO concesionarioVO=new ConcesionarioVO();
    
    private Layout layout1;
    private LayoutUnit layoutUnit1;
    private LayoutUnit layoutUnit2;
    private OutputLabel outputLabel1;
    private Layout layout2;
    private DataTable dataTable1;
    private Column column1;
    private Column column2;
    private Column column3;
    private Column column4;
    private Column column5;
    private Column column6;
    private DataGrid dataGrid1;
    private OutputLabel outputLabel2;
    private InputText inputText1;
    private OutputLabel outputLabel3;
    private InputText inputText2;
    private CommandButton commandButton1;
    private OutputLabel outputLabel4;
    private InputText inputText3;
    private SelectOneMenu selectOneMenu1;
    private LayoutUnit layoutUnit3;
    private CommandButton commandButton2;
    private PanelGrid panelGrid1;
    private Column column7;
    private CommandButton commandButton3;
    private LayoutUnit layoutUnit4;
    private LayoutUnit layoutUnit5;
    private int codigoEliminar;
    private String nombreEliminar;

    public void setLayout1(Layout layout1) {
        this.layout1 = layout1;
    }

    public Layout getLayout1() {
        return layout1;
    }

    public void setLayoutUnit1(LayoutUnit layoutUnit1) {
        this.layoutUnit1 = layoutUnit1;
    }

    public LayoutUnit getLayoutUnit1() {
        return layoutUnit1;
    }

    public void setLayoutUnit2(LayoutUnit layoutUnit2) {
        this.layoutUnit2 = layoutUnit2;
    }

    public LayoutUnit getLayoutUnit2() {
        return layoutUnit2;
    }

    public void setOutputLabel1(OutputLabel outputLabel1) {
        this.outputLabel1 = outputLabel1;
    }

    public OutputLabel getOutputLabel1() {
        return outputLabel1;
    }

    public void setLayout2(Layout layout2) {
        this.layout2 = layout2;
    }

    public Layout getLayout2() {
        return layout2;
    }

    public void setDataTable1(DataTable dataTable1) {
        this.dataTable1 = dataTable1;
    }

    public DataTable getDataTable1() {
        return dataTable1;
    }

    public void setColumn1(Column column1) {
        this.column1 = column1;
    }

    public Column getColumn1() {
        return column1;
    }

    public void setColumn2(Column column2) {
        this.column2 = column2;
    }

    public Column getColumn2() {
        return column2;
    }

    public void setColumn3(Column column3) {
        this.column3 = column3;
    }

    public Column getColumn3() {
        return column3;
    }

    public void setColumn4(Column column4) {
        this.column4 = column4;
    }

    public Column getColumn4() {
        return column4;
    }

    public void setColumn5(Column column5) {
        this.column5 = column5;
    }

    public Column getColumn5() {
        return column5;
    }

    public void setColumn6(Column column6) {
        this.column6 = column6;
    }

    public Column getColumn6() {
        return column6;
    }

    public void setDataGrid1(DataGrid dataGrid1) {
        this.dataGrid1 = dataGrid1;
    }

    public DataGrid getDataGrid1() {
        return dataGrid1;
    }

    public void setOutputLabel2(OutputLabel outputLabel2) {
        this.outputLabel2 = outputLabel2;
    }

    public OutputLabel getOutputLabel2() {
        return outputLabel2;
    }

    public void setInputText1(InputText inputText1) {
        this.inputText1 = inputText1;
    }

    public InputText getInputText1() {
        return inputText1;
    }

    public void setOutputLabel3(OutputLabel outputLabel3) {
        this.outputLabel3 = outputLabel3;
    }

    public OutputLabel getOutputLabel3() {
        return outputLabel3;
    }

    public void setInputText2(InputText inputText2) {
        this.inputText2 = inputText2;
    }

    public InputText getInputText2() {
        return inputText2;
    }

    public void setCommandButton1(CommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setOutputLabel4(OutputLabel outputLabel4) {
        this.outputLabel4 = outputLabel4;
    }

    public OutputLabel getOutputLabel4() {
        return outputLabel4;
    }

    public void setInputText3(InputText inputText3) {
        this.inputText3 = inputText3;
    }

    public InputText getInputText3() {
        return inputText3;
    }

    public void setSelectOneMenu1(SelectOneMenu selectOneMenu1) {
        this.selectOneMenu1 = selectOneMenu1;
    }

    public SelectOneMenu getSelectOneMenu1() {
        return selectOneMenu1;
    }

    public void setLayoutUnit3(LayoutUnit layoutUnit3) {
        this.layoutUnit3 = layoutUnit3;
    }

    public LayoutUnit getLayoutUnit3() {
        return layoutUnit3;
    }

    public void setCommandButton2(CommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CommandButton getCommandButton2() {
        return commandButton2;
    }

    public void setPanelGrid1(PanelGrid panelGrid1) {
        this.panelGrid1 = panelGrid1;
    }

    public PanelGrid getPanelGrid1() {
        return panelGrid1;
    }

    public void setColumn7(Column column7) {
        this.column7 = column7;
    }

    public Column getColumn7() {
        return column7;
    }

    public void setCommandButton3(CommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public CommandButton getCommandButton3() {
        return commandButton3;
    }

    public void setLayoutUnit4(LayoutUnit layoutUnit4) {
        this.layoutUnit4 = layoutUnit4;
    }

    public LayoutUnit getLayoutUnit4() {
        return layoutUnit4;
    }

    public void setLayoutUnit5(LayoutUnit layoutUnit5) {
        this.layoutUnit5 = layoutUnit5;
    }

    public LayoutUnit getLayoutUnit5() {
        return layoutUnit5;
    }
    
    public List<ConcesionarioVO> getQuery(){
        List<ConcesionarioVO> list=this.concesionarioServiceImpl.query();
        return list;
    }
    
    public void cargarEliminarXX(ActionEvent event) {
        UIParameter parameter=(UIParameter)event.getComponent().findComponent("id1");
        Integer idinfraestructuraTipo=(Integer)parameter.getValue();
        this.codigoEliminar=idinfraestructuraTipo;
    }
    
    public void cargarEliminar(int codigo, String nombre) {
        codigoEliminar = codigo;
        nombreEliminar = nombre;
    }
    
    public void eliminar() {
        getConcesionarioServiceImpl().delete(codigoEliminar);
        System.out.println("codigoEliminar = "+codigoEliminar);
        getQuery();
    }
    
    public String concesionarioDel(ActionEvent event){
        UIParameter parameter=(UIParameter)event.getComponent().findComponent("codEliminar");
        Integer idinfraestructuraTipo=(Integer)parameter.getValue();
        this.concesionarioServiceImpl.delete(idinfraestructuraTipo);
        return "recargar";
    }
    
    public void concesionarioUpd1(ActionEvent event){
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("id2");
        Integer idConcesionario=Integer.valueOf(str.toString());
        System.out.println("================================");
        System.out.println("idConcesionario = "+idConcesionario);
        concesionarioVO=this.concesionarioServiceImpl.get(idConcesionario);
        System.out.println("concesionarioVO = "+concesionarioVO);
        System.out.println("================================");
        //return "concesionarioUpd";
    }
    /*
    public void concesionarioUpd1(ConcesionarioVO consecionarioVO){
            / *concesionarioVO=concesionarioVO;
            codigoE=tipoInversionVO.getTivId();
            nombreE=tipoInversionVO.getTivNombre();
            descripcionE=tipoInversionVO.getTivDescripcion();* /
            FacesContext context=FacesContext.getCurrentInstance();
            Object str=requestMap.get("id2");            Map requestMap=context.getExternalContext().getRequestParameterMap();

            Integer idConcesionario=Integer.valueOf(str.toString());
            concesionarioVO=this.concesionarioServiceImpl.get(idConcesionario);        
        }*/
    
    
    public String concesionarioUpd2(){
        this.concesionarioServiceImpl.update(concesionarioVO);
        return "/index?faces-redirect=true";
    }    

    public void setConcesionarioServiceImpl(ConcesionarioServiceImpl concesionarioServiceImpl) {
        this.concesionarioServiceImpl = concesionarioServiceImpl;
    }

    public ConcesionarioServiceImpl getConcesionarioServiceImpl() {
        return concesionarioServiceImpl;
    }

    public void setConcesionarioVO(ConcesionarioVO concesionarioVO) {
        this.concesionarioVO = concesionarioVO;
    }

    public ConcesionarioVO getConcesionarioVO() {
        return concesionarioVO;
    }    

    public void setCodigoEliminar(int codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }

    public int getCodigoEliminar() {
        return codigoEliminar;
    }

    public void setNombreEliminar(String nombreEliminar) {
        this.nombreEliminar = nombreEliminar;
    }

    public String getNombreEliminar() {
        return nombreEliminar;
    }
}