package com.ositran.contratos;

import com.ositran.serviceimpl.ContratoEmpresaSupervisoraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.MonedaServiceImpl;
import com.ositran.vo.bean.ContratoSupervisoraVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import com.ositran.vo.bean.MonedaVO;

import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.column.Column;
import org.primefaces.component.columngroup.ColumnGroup;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.fieldset.Fieldset;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.layout.Layout;
import org.primefaces.component.layout.LayoutUnit;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "backing_ositran_parametros_mantenimientoContratEmprSupervisor")
@RequestScoped
@Generated(value = "1ositran/parametros/mantenimientoContratEmprSupervisor.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoContratEmprSupervisor {
    private HtmlForm form1;
    private Layout layout1;
    private LayoutUnit layoutUnit1;
    private PanelGrid panelGrid1;
    private OutputLabel outputLabelEmpresaSupervisora;
    private InputText inputTextEmpresaSupervisora;
    private OutputLabel outputLabelTipoInfraestructura;
    private InputText inputTextTipoInfraestructura;
    private CommandButton commandButton1;
    private OutputLabel outputLabelNroContrato;
    private InputText inputTextNroContrato;
    private CommandButton commandButton2;
    private DataTable dataTableConEmprSupr;
    private Column columnN;
    private Column columnNumContrato;
    private Column column3;
    private Column columnEmpresaSupervisora;
    private Column columnVer;
    private Column columnModificar;
    private CommandButton commandButtonVer;
    private CommandButton commandButtonModificar;
    private CommandButton commandButtonEliminar;
    private Column columnEliminar;
    private Column column8;
    private HtmlOutputText outputText2;
    private HtmlOutputText outputText3;
    private OutputLabel outputLabel1;
    private OutputLabel outputLabel2;
    private SelectOneMenu selectOneMenuTipoInfraestructura;
    private String tipoInfraestructura;
    List<SelectItem> tipoInfraestructuraSelectItems = new ArrayList<SelectItem>();
    private HtmlInputHidden inputHiddenItemTipoInfraestructura;
    private Dialog dialogRegConEmpSup;
    private PanelGrid panelGrid2;
    private ColumnGroup columnGroup1;
    private Dialog dialogConfirmarEliminar;
    private HtmlInputHidden inputHidden1;
    private Dialog dialogVerContEmpSup;
    private PanelGrid panelGridDatosContraConcesion;
    private OutputLabel outputLabelConcesion;
    private InputText inputTextConcesion;
    private OutputLabel outputLabelTipoInfra;
    private InputText inputTextTipoInfra;
    private OutputLabel outputLabelModaConcesion;
    private InputText inputTextModalidadConcesion;
    private OutputLabel outputLabelAeropuerto;
    private SelectOneMenu selectOneMenuAeropuerto;
    private OutputLabel outputLabelInversion;
    private InputText inputTextInversion;
    private OutputLabel outputLabelEtapaPeriodo;
    private InputText inputTextEtapaPeriodo;
    private OutputLabel outputLabelPlazo;
    private InputText inputTextPlazo;
    private Layout layoutMoneda;
    private InputText inputTextMoneda;
    private OutputLabel outputLabelTotal;
    private InputText inputTextTotal;
    private ColumnGroup columnGroup2;
    private Fieldset fieldset1;
    private OutputLabel outputLabelNroContratoNew;
    private InputText inputTextNroContratoNew;
    private OutputLabel outputLabelPlazoContratoNew;
    private InputText inputTextPlazoContratoNew;
    private OutputLabel outputLabelFechaInicioNew;
    private OutputLabel outputLabelFechaSuscripcionNew;
    private OutputLabel outputLabelMontoNew;
    private InputText inputTextMontoContratadoNew;
    private OutputLabel outputLabelMonedaNew;
    private SelectOneMenu selectOneMenuMoneda;
    private String moneda;
    List<SelectItem> monedaSelectItems = new ArrayList<SelectItem>();
    private OutputLabel outputLabelAdelantoOtorgadoNew;
    private InputText inputTextAdelantoOtorgadoNew;
    private OutputLabel outputLabelFechaAdelantoNew;
    private Calendar calendarFechaAdelantoNew;
    private OutputLabel outputLabelRefPenalidadNew;
    private InputTextarea inputTextareaRefPenalidadNew;
    private OutputLabel outputLabelRefCausalesCaduNew;
    private InputTextarea inputTextareaRefCausalesCaduNew;
    private OutputLabel outputLabelGarantiasNew;
    private InputTextarea inputTextareaGarantiasFavorNew;
    private OutputLabel outputLabelMoneda;
    private DataGrid dataGridDatosContrato;
    private PanelGrid panelGridDatosContrato;
    private PanelGrid panelGridEtapaConcesion;
    private OutputLabel outputLabel3;
    private OutputLabel outputLabel4;
    private DataGrid dataGridDatosSTD;
    private OutputLabel outputLabel5;
    private OutputLabel outputLabelNroSTDNew;
    private InputText inputTextNumero;
    private OutputLabel outputLabelAnnioNew;
    private InputText inputTextAnnio;
    private OutputLabel outputLabelIconBuscarFecReg;
    private OutputLabel outputLabelFechaRegistro;
    private Calendar calendarFechaRegistro;
    private OutputLabel outputLabelAsunto;
    private InputTextarea inputTextareaAsunto;
    private PanelGrid panelGridDatosSTD;
    private Calendar calendarFecIniContratoNew;
    private Calendar calendarFecSuscripcionNew;
    private DataTable dataTableContratoNew;
    private OutputLabel outputLabelAdjuntarContratoNew;
    private InputText inputTextAdjutarContratoNew;
    private CommandButton commandButtonAgregarAdenda;
    private SelectOneMenu selectOneMenuEtapaPeriodo;
    private HtmlInputHidden inputHidden2;
    private CommandButton commandButtonGrabar;
    private CommandButton commandButtonCancelar;

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public void setTipoInfraestructura(String tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public String getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public HtmlForm getForm1() {
        return form1;
    }

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

    public void setPanelGrid1(PanelGrid panelGrid1) {
        this.panelGrid1 = panelGrid1;
    }

    public PanelGrid getPanelGrid1() {
        return panelGrid1;
    }

    public void setOutputLabelEmpresaSupervisora(OutputLabel outputLabel1) {
        this.outputLabelEmpresaSupervisora = outputLabel1;
    }

    public OutputLabel getOutputLabelEmpresaSupervisora() {
        return outputLabelEmpresaSupervisora;
    }

    public void setInputTextEmpresaSupervisora(InputText inputText1) {
        this.inputTextEmpresaSupervisora = inputText1;
    }

    public InputText getInputTextEmpresaSupervisora() {
        return inputTextEmpresaSupervisora;
    }

    public void setOutputLabelTipoInfraestructura(OutputLabel outputLabel2) {
        this.outputLabelTipoInfraestructura = outputLabel2;
    }

    public OutputLabel getOutputLabelTipoInfraestructura() {
        return outputLabelTipoInfraestructura;
    }

    public void setInputTextTipoInfraestructura(InputText inputText2) {
        this.inputTextTipoInfraestructura = inputText2;
    }

    public InputText getInputTextTipoInfraestructura() {
        return inputTextTipoInfraestructura;
    }

    public void setCommandButton1(CommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setOutputLabelNroContrato(OutputLabel outputLabel3) {
        this.outputLabelNroContrato = outputLabel3;
    }

    public OutputLabel getOutputLabelNroContrato() {
        return outputLabelNroContrato;
    }

    public void setInputTextNroContrato(InputText inputText3) {
        this.inputTextNroContrato = inputText3;
    }

    public InputText getInputTextNroContrato() {
        return inputTextNroContrato;
    }

    public void setCommandButton2(CommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CommandButton getCommandButton2() {
        return commandButton2;
    }

    public void setDataTableConEmprSupr(DataTable dataTable1) {
        this.dataTableConEmprSupr = dataTable1;
    }

    public DataTable getDataTableConEmprSupr() {
        return dataTableConEmprSupr;
    }

    public void setColumnN(Column column1) {
        this.columnN = column1;
    }

    public Column getColumnN() {
        return columnN;
    }

    public void setColumnNumContrato(Column column2) {
        this.columnNumContrato = column2;
    }

    public Column getColumnNumContrato() {
        return columnNumContrato;
    }

    public void setColumn3(Column column3) {
        this.column3 = column3;
    }

    public Column getColumn3() {
        return column3;
    }

    public void setColumnEmpresaSupervisora(Column column4) {
        this.columnEmpresaSupervisora = column4;
    }

    public Column getColumnEmpresaSupervisora() {
        return columnEmpresaSupervisora;
    }

    public void setColumnVer(Column column5) {
        this.columnVer = column5;
    }

    public Column getColumnVer() {
        return columnVer;
    }

    public void setColumnModificar(Column column6) {
        this.columnModificar = column6;
    }

    public Column getColumnModificar() {
        return columnModificar;
    }

    public void setCommandButtonVer(CommandButton commandButton3) {
        this.commandButtonVer = commandButton3;
    }

    public CommandButton getCommandButtonVer() {
        return commandButtonVer;
    }

    public void setCommandButtonModificar(CommandButton commandButton4) {
        this.commandButtonModificar = commandButton4;
    }

    public CommandButton getCommandButtonModificar() {
        return commandButtonModificar;
    }

    public void setCommandButtonEliminar(CommandButton commandButton5) {
        this.commandButtonEliminar = commandButton5;
    }

    public CommandButton getCommandButtonEliminar() {
        return commandButtonEliminar;
    }

    public void setColumnEliminar(Column column7) {
        this.columnEliminar = column7;
    }

    public Column getColumnEliminar() {
        return columnEliminar;
    }

    public void setColumn8(Column column8) {
        this.column8 = column8;
    }

    public Column getColumn8() {
        return column8;
    }

    public void setOutputText2(HtmlOutputText outputText2) {
        this.outputText2 = outputText2;
    }

    public HtmlOutputText getOutputText2() {
        return outputText2;
    }

    public void setOutputText3(HtmlOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public HtmlOutputText getOutputText3() {
        return outputText3;
    }

    public void setOutputLabel1(OutputLabel outputLabel1) {
        this.outputLabel1 = outputLabel1;
    }

    public OutputLabel getOutputLabel1() {
        return outputLabel1;
    }

    public void setOutputLabel2(OutputLabel outputLabel2) {
        this.outputLabel2 = outputLabel2;
    }

    public OutputLabel getOutputLabel2() {
        return outputLabel2;
    }

    public void setSelectOneMenuTipoInfraestructura(SelectOneMenu selectOneMenu1) {
        this.selectOneMenuTipoInfraestructura = selectOneMenu1;
    }

    public SelectOneMenu getSelectOneMenuTipoInfraestructura() {
        return selectOneMenuTipoInfraestructura;
    }


    /**
     * @author Paul Rivera
     * @return Tipo de Infraestructura
     */

    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    private InfraestructuraTipoVO infraestructuraTipoVO;

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;


    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

    private List<InfraestructuraTipoVO> listaInfraestructura;

    public List<InfraestructuraTipoVO> listarInfraestructura() throws SQLException {
        try {
            listaInfraestructura = getInfraestructuraTipoServiceImpl().query();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaInfraestructura;
    }

    /**
     * @author Paul Rivera
     * @return tipo de infraestructura para que se renderize en el combo
     */
    public List<SelectItem> getTipoInfraestructuraSelectItems() throws SQLException {
        tipoInfraestructuraSelectItems.add(new SelectItem("-1", "Seleccione"));
        List<InfraestructuraTipoVO> lista = listarInfraestructura();
        int i = 0;
        for (InfraestructuraTipoVO ivo : lista) {
            tipoInfraestructuraSelectItems.add(new SelectItem(i++, String.valueOf(ivo.getTinNombre())));
        }
        return tipoInfraestructuraSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return tipo de infraestructura seleccionado del combo
     */
    public String getInputHiddenSelectedTipoInfraestructura() {
        if ("".equals(getTipoInfraestructura()) || getTipoInfraestructura() == null) {
            return "";
        } else {
            return getTipoInfraestructura();
        }
    }

    public void setInputHiddenItemTipoInfraestructura(HtmlInputHidden inputHiddenItemTipoInfraestructura) {
        this.inputHiddenItemTipoInfraestructura = inputHiddenItemTipoInfraestructura;
    }

    public HtmlInputHidden getInputHiddenItemTipoInfraestructura() {
        return inputHiddenItemTipoInfraestructura;
    }

    /**
     * @author Paul Rivera
     * @return Contrato Empresa Supervisora
     */

    //@ManagedProperty(value = "#{contratoSupervisoraVO}")
    private ContratoSupervisoraVO contratoSupervisoraVO = new ContratoSupervisoraVO();

    //@ManagedProperty(value = "#{contratoSupervisoraVOServiceImpl}")
    private ContratoEmpresaSupervisoraServiceImpl contratoEmpresaSupervisoraServiceImpl =
        new ContratoEmpresaSupervisoraServiceImpl();

    public void setContratoSupervisoraVO(ContratoSupervisoraVO contratoSupervisoraVO) {
        this.contratoSupervisoraVO = contratoSupervisoraVO;
    }

    public void setContratoEmpresaSupervisoraServiceImpl(ContratoEmpresaSupervisoraServiceImpl contratoEmpresaSupervisoraServiceImpl) {
        this.contratoEmpresaSupervisoraServiceImpl = contratoEmpresaSupervisoraServiceImpl;
    }

    public ContratoEmpresaSupervisoraServiceImpl getContratoEmpresaSupervisoraServiceImpl() {
        return contratoEmpresaSupervisoraServiceImpl;
    }

    private List<ContratoSupervisoraVO> listaContratoSupervisora;

    public List<ContratoSupervisoraVO> getListarContratoSupervisora() throws SQLException {
        try {
            listaContratoSupervisora = getContratoEmpresaSupervisoraServiceImpl().query();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaContratoSupervisora;
    }

    /**
     * @author Paul Rivera
     * @return Contrato Empresa Supervisora para que se renderize en el combo
     */
    /*public List<SelectItem> getTipoInfraestructuraSelectItems() throws SQLException {
        tipoInfraestructuraSelectItems.add(new SelectItem("-1","Seleccione"));
        List<InfraestructuraTipoVO> lista=listarInfraestructura();
        int i=0;
        for(InfraestructuraTipoVO ivo:lista){
            tipoInfraestructuraSelectItems.add(new SelectItem(i++, String.valueOf(ivo.getTinNombre())));
        }
        return tipoInfraestructuraSelectItems;
    }*/

    /**
     * @author Paul Rivera
     * @return Contrato Empresa Supervisora seleccionado del combo
     */
    /*public String getInputHiddenSelectedTipoInfraestructura(){
        if("".equals(getTipoInfraestructura()) || getTipoInfraestructura() ==null){
            return "";
        }else{
            return getTipoInfraestructura();
        }
    }*/

    public List<ContratoSupervisoraVO> buscarConEmpSup() throws SQLException {
        /*listaEmpSup=this.contratoEmpresaSupervisoraServiceImpl.FiltrarEmpSup(nomEmpSupBus,rucbus);
        listaTipoDocumento = this.tipoDocumentoServiceImp.query();
        for (int i = 0 ; i< listaEmpSup.size();i++){
            for(int j=0; j<listaTipoDocumento.size();j++){
                if(listaEmpSup.get(i).getTdoId() == listaTipoDocumento.get(j).getTdoId()){
                    listaEmpSup.get(i).setDescripcionDoc(listaTipoDocumento.get(j).getTdoNombre());
                }
            }
        }
        //limpiarCampos ();
        return listaEmpSup; */
        return new ArrayList();
    }


    public void setDialogRegConEmpSup(Dialog dialog1) {
        this.dialogRegConEmpSup = dialog1;
    }

    public Dialog getDialogRegConEmpSup() {
        return dialogRegConEmpSup;
    }

    public void setPanelGrid2(PanelGrid panelGrid2) {
        this.panelGrid2 = panelGrid2;
    }

    public PanelGrid getPanelGrid2() {
        return panelGrid2;
    }

    public void setColumnGroup1(ColumnGroup columnGroup1) {
        this.columnGroup1 = columnGroup1;
    }

    public ColumnGroup getColumnGroup1() {
        return columnGroup1;
    }

    public void setDialogConfirmarEliminar(Dialog dialog1) {
        this.dialogConfirmarEliminar = dialog1;
    }

    public Dialog getDialogConfirmarEliminar() {
        return dialogConfirmarEliminar;
    }

    public void setInputHidden1(HtmlInputHidden inputHidden1) {
        this.inputHidden1 = inputHidden1;
    }

    public HtmlInputHidden getInputHidden1() {
        return inputHidden1;
    }

    public void setDialogVerContEmpSup(Dialog dialog1) {
        this.dialogVerContEmpSup = dialog1;
    }

    public Dialog getDialogVerContEmpSup() {
        return dialogVerContEmpSup;
    }

    public void setPanelGridDatosContraConcesion(PanelGrid panelGrid3) {
        this.panelGridDatosContraConcesion = panelGrid3;
    }

    public PanelGrid getPanelGridDatosContraConcesion() {
        return panelGridDatosContraConcesion;
    }

    public void setOutputLabelConcesion(OutputLabel outputLabel3) {
        this.outputLabelConcesion = outputLabel3;
    }

    public OutputLabel getOutputLabelConcesion() {
        return outputLabelConcesion;
    }

    public void setInputTextConcesion(InputText inputText1) {
        this.inputTextConcesion = inputText1;
    }

    public InputText getInputTextConcesion() {
        return inputTextConcesion;
    }

    public void setOutputLabelTipoInfra(OutputLabel outputLabel3) {
        this.outputLabelTipoInfra = outputLabel3;
    }

    public OutputLabel getOutputLabelTipoInfra() {
        return outputLabelTipoInfra;
    }

    public void setInputTextTipoInfra(InputText inputText1) {
        this.inputTextTipoInfra = inputText1;
    }

    public InputText getInputTextTipoInfra() {
        return inputTextTipoInfra;
    }

    public void setOutputLabelModaConcesion(OutputLabel outputLabel3) {
        this.outputLabelModaConcesion = outputLabel3;
    }

    public OutputLabel getOutputLabelModaConcesion() {
        return outputLabelModaConcesion;
    }

    public void setInputTextModalidadConcesion(InputText inputText1) {
        this.inputTextModalidadConcesion = inputText1;
    }

    public InputText getInputTextModalidadConcesion() {
        return inputTextModalidadConcesion;
    }

    public void setOutputLabelAeropuerto(OutputLabel outputLabel3) {
        this.outputLabelAeropuerto = outputLabel3;
    }

    public OutputLabel getOutputLabelAeropuerto() {
        return outputLabelAeropuerto;
    }

    public void setSelectOneMenuAeropuerto(SelectOneMenu selectOneMenu1) {
        this.selectOneMenuAeropuerto = selectOneMenu1;
    }

    public SelectOneMenu getSelectOneMenuAeropuerto() {
        return selectOneMenuAeropuerto;
    }

    public void setOutputLabelInversion(OutputLabel outputLabel3) {
        this.outputLabelInversion = outputLabel3;
    }

    public OutputLabel getOutputLabelInversion() {
        return outputLabelInversion;
    }

    public void setInputTextInversion(InputText inputText1) {
        this.inputTextInversion = inputText1;
    }

    public InputText getInputTextInversion() {
        return inputTextInversion;
    }

    public void setOutputLabelEtapaPeriodo(OutputLabel outputLabel3) {
        this.outputLabelEtapaPeriodo = outputLabel3;
    }

    public OutputLabel getOutputLabelEtapaPeriodo() {
        return outputLabelEtapaPeriodo;
    }

    public void setInputTextEtapaPeriodo(InputText inputText1) {
        this.inputTextEtapaPeriodo = inputText1;
    }

    public InputText getInputTextEtapaPeriodo() {
        return inputTextEtapaPeriodo;
    }

    public void setOutputLabelPlazo(OutputLabel outputLabel3) {
        this.outputLabelPlazo = outputLabel3;
    }

    public OutputLabel getOutputLabelPlazo() {
        return outputLabelPlazo;
    }

    public void setInputTextPlazo(InputText inputText1) {
        this.inputTextPlazo = inputText1;
    }

    public InputText getInputTextPlazo() {
        return inputTextPlazo;
    }

    public void setLayoutMoneda(Layout layout2) {
        this.layoutMoneda = layout2;
    }

    public Layout getLayoutMoneda() {
        return layoutMoneda;
    }

    public void setInputTextMoneda(InputText inputText1) {
        this.inputTextMoneda = inputText1;
    }

    public InputText getInputTextMoneda() {
        return inputTextMoneda;
    }

    public void setOutputLabelTotal(OutputLabel outputLabel3) {
        this.outputLabelTotal = outputLabel3;
    }

    public OutputLabel getOutputLabelTotal() {
        return outputLabelTotal;
    }

    public void setInputTextTotal(InputText inputText1) {
        this.inputTextTotal = inputText1;
    }

    public InputText getInputTextTotal() {
        return inputTextTotal;
    }

    public void setColumnGroup2(ColumnGroup columnGroup2) {
        this.columnGroup2 = columnGroup2;
    }

    public ColumnGroup getColumnGroup2() {
        return columnGroup2;
    }

    public void setFieldset1(Fieldset fieldset1) {
        this.fieldset1 = fieldset1;
    }

    public Fieldset getFieldset1() {
        return fieldset1;
    }

    public void setOutputLabelNroContratoNew(OutputLabel outputLabel3) {
        this.outputLabelNroContratoNew = outputLabel3;
    }

    public OutputLabel getOutputLabelNroContratoNew() {
        return outputLabelNroContratoNew;
    }

    public void setInputTextNroContratoNew(InputText inputText1) {
        this.inputTextNroContratoNew = inputText1;
    }

    public InputText getInputTextNroContratoNew() {
        return inputTextNroContratoNew;
    }

    public void setOutputLabelPlazoContratoNew(OutputLabel outputLabel3) {
        this.outputLabelPlazoContratoNew = outputLabel3;
    }

    public OutputLabel getOutputLabelPlazoContratoNew() {
        return outputLabelPlazoContratoNew;
    }

    public void setInputTextPlazoContratoNew(InputText inputText1) {
        this.inputTextPlazoContratoNew = inputText1;
    }

    public InputText getInputTextPlazoContratoNew() {
        return inputTextPlazoContratoNew;
    }

    public void setOutputLabelFechaInicioNew(OutputLabel outputLabel3) {
        this.outputLabelFechaInicioNew = outputLabel3;
    }

    public OutputLabel getOutputLabelFechaInicioNew() {
        return outputLabelFechaInicioNew;
    }

    public void setOutputLabelFechaSuscripcionNew(OutputLabel outputLabel3) {
        this.outputLabelFechaSuscripcionNew = outputLabel3;
    }

    public OutputLabel getOutputLabelFechaSuscripcionNew() {
        return outputLabelFechaSuscripcionNew;
    }

    public void setOutputLabelMontoNew(OutputLabel outputLabel3) {
        this.outputLabelMontoNew = outputLabel3;
    }

    public OutputLabel getOutputLabelMontoNew() {
        return outputLabelMontoNew;
    }

    public void setInputTextMontoContratadoNew(InputText inputText1) {
        this.inputTextMontoContratadoNew = inputText1;
    }

    public InputText getInputTextMontoContratadoNew() {
        return inputTextMontoContratadoNew;
    }

    public void setOutputLabelMonedaNew(OutputLabel outputLabel3) {
        this.outputLabelMonedaNew = outputLabel3;
    }

    public OutputLabel getOutputLabelMonedaNew() {
        return outputLabelMonedaNew;
    }

    public void setSelectOneMenuMoneda(SelectOneMenu selectOneMenu1) {
        this.selectOneMenuMoneda = selectOneMenu1;
    }

    public SelectOneMenu getSelectOneMenuMoneda() {
        return selectOneMenuMoneda;
    }

    public void setOutputLabelAdelantoOtorgadoNew(OutputLabel outputLabel3) {
        this.outputLabelAdelantoOtorgadoNew = outputLabel3;
    }

    public OutputLabel getOutputLabelAdelantoOtorgadoNew() {
        return outputLabelAdelantoOtorgadoNew;
    }

    public void setInputTextAdelantoOtorgadoNew(InputText inputText1) {
        this.inputTextAdelantoOtorgadoNew = inputText1;
    }

    public InputText getInputTextAdelantoOtorgadoNew() {
        return inputTextAdelantoOtorgadoNew;
    }

    public void setOutputLabelFechaAdelantoNew(OutputLabel outputLabel3) {
        this.outputLabelFechaAdelantoNew = outputLabel3;
    }

    public OutputLabel getOutputLabelFechaAdelantoNew() {
        return outputLabelFechaAdelantoNew;
    }

    public void setCalendarFechaAdelantoNew(Calendar calendar1) {
        this.calendarFechaAdelantoNew = calendar1;
    }

    public Calendar getCalendarFechaAdelantoNew() {
        return calendarFechaAdelantoNew;
    }

    public void setOutputLabelRefPenalidadNew(OutputLabel outputLabel3) {
        this.outputLabelRefPenalidadNew = outputLabel3;
    }

    public OutputLabel getOutputLabelRefPenalidadNew() {
        return outputLabelRefPenalidadNew;
    }

    public void setInputTextareaRefPenalidadNew(InputTextarea inputTextarea1) {
        this.inputTextareaRefPenalidadNew = inputTextarea1;
    }

    public InputTextarea getInputTextareaRefPenalidadNew() {
        return inputTextareaRefPenalidadNew;
    }

    public void setOutputLabelRefCausalesCaduNew(OutputLabel outputLabel3) {
        this.outputLabelRefCausalesCaduNew = outputLabel3;
    }

    public OutputLabel getOutputLabelRefCausalesCaduNew() {
        return outputLabelRefCausalesCaduNew;
    }

    public void setInputTextareaRefCausalesCaduNew(InputTextarea inputTextarea1) {
        this.inputTextareaRefCausalesCaduNew = inputTextarea1;
    }

    public InputTextarea getInputTextareaRefCausalesCaduNew() {
        return inputTextareaRefCausalesCaduNew;
    }

    public void setOutputLabelGarantiasNew(OutputLabel outputLabel3) {
        this.outputLabelGarantiasNew = outputLabel3;
    }

    public OutputLabel getOutputLabelGarantiasNew() {
        return outputLabelGarantiasNew;
    }

    public void setInputTextareaGarantiasFavorNew(InputTextarea inputTextarea1) {
        this.inputTextareaGarantiasFavorNew = inputTextarea1;
    }

    public InputTextarea getInputTextareaGarantiasFavorNew() {
        return inputTextareaGarantiasFavorNew;
    }

    public void setOutputLabelMoneda(OutputLabel outputLabel3) {
        this.outputLabelMoneda = outputLabel3;
    }

    public OutputLabel getOutputLabelMoneda() {
        return outputLabelMoneda;
    }

    public void setDataGridDatosContrato(DataGrid dataGrid1) {
        this.dataGridDatosContrato = dataGrid1;
    }

    public DataGrid getDataGridDatosContrato() {
        return dataGridDatosContrato;
    }

    public void setPanelGridDatosContrato(PanelGrid panelGrid3) {
        this.panelGridDatosContrato = panelGrid3;
    }

    public PanelGrid getPanelGridDatosContrato() {
        return panelGridDatosContrato;
    }

    public void setPanelGridEtapaConcesion(PanelGrid panelGrid3) {
        this.panelGridEtapaConcesion = panelGrid3;
    }

    public PanelGrid getPanelGridEtapaConcesion() {
        return panelGridEtapaConcesion;
    }

    public void setOutputLabel3(OutputLabel outputLabel3) {
        this.outputLabel3 = outputLabel3;
    }

    public OutputLabel getOutputLabel3() {
        return outputLabel3;
    }

    public void setOutputLabel4(OutputLabel outputLabel4) {
        this.outputLabel4 = outputLabel4;
    }

    public OutputLabel getOutputLabel4() {
        return outputLabel4;
    }

    public void setDataGridDatosSTD(DataGrid dataGrid1) {
        this.dataGridDatosSTD = dataGrid1;
    }

    public DataGrid getDataGridDatosSTD() {
        return dataGridDatosSTD;
    }

    public void setOutputLabel5(OutputLabel outputLabel5) {
        this.outputLabel5 = outputLabel5;
    }

    public OutputLabel getOutputLabel5() {
        return outputLabel5;
    }

    public void setOutputLabelNroSTDNew(OutputLabel outputLabel6) {
        this.outputLabelNroSTDNew = outputLabel6;
    }

    public OutputLabel getOutputLabelNroSTDNew() {
        return outputLabelNroSTDNew;
    }

    public void setInputTextNumero(InputText inputText1) {
        this.inputTextNumero = inputText1;
    }

    public InputText getInputTextNumero() {
        return inputTextNumero;
    }

    public void setOutputLabelAnnioNew(OutputLabel outputLabel7) {
        this.outputLabelAnnioNew = outputLabel7;
    }

    public OutputLabel getOutputLabelAnnioNew() {
        return outputLabelAnnioNew;
    }

    public void setInputTextAnnio(InputText inputText2) {
        this.inputTextAnnio = inputText2;
    }

    public InputText getInputTextAnnio() {
        return inputTextAnnio;
    }

    public void setOutputLabelIconBuscarFecReg(OutputLabel outputLabel8) {
        this.outputLabelIconBuscarFecReg = outputLabel8;
    }

    public OutputLabel getOutputLabelIconBuscarFecReg() {
        return outputLabelIconBuscarFecReg;
    }

    public void setOutputLabelFechaRegistro(OutputLabel outputLabel9) {
        this.outputLabelFechaRegistro = outputLabel9;
    }

    public OutputLabel getOutputLabelFechaRegistro() {
        return outputLabelFechaRegistro;
    }

    public void setCalendarFechaRegistro(Calendar calendar1) {
        this.calendarFechaRegistro = calendar1;
    }

    public Calendar getCalendarFechaRegistro() {
        return calendarFechaRegistro;
    }

    public void setOutputLabelAsunto(OutputLabel outputLabel8) {
        this.outputLabelAsunto = outputLabel8;
    }

    public OutputLabel getOutputLabelAsunto() {
        return outputLabelAsunto;
    }

    public void setInputTextareaAsunto(InputTextarea inputTextarea1) {
        this.inputTextareaAsunto = inputTextarea1;
    }

    public InputTextarea getInputTextareaAsunto() {
        return inputTextareaAsunto;
    }

    public void setPanelGridDatosSTD(PanelGrid panelGrid3) {
        this.panelGridDatosSTD = panelGrid3;
    }

    public PanelGrid getPanelGridDatosSTD() {
        return panelGridDatosSTD;
    }

    public void setCalendarFecIniContratoNew(Calendar calendar1) {
        this.calendarFecIniContratoNew = calendar1;
    }

    public Calendar getCalendarFecIniContratoNew() {
        return calendarFecIniContratoNew;
    }

    public void setCalendarFecSuscripcionNew(Calendar calendar1) {
        this.calendarFecSuscripcionNew = calendar1;
    }

    public Calendar getCalendarFecSuscripcionNew() {
        return calendarFecSuscripcionNew;
    }

    public void setDataTableContratoNew(DataTable dataTable1) {
        this.dataTableContratoNew = dataTable1;
    }

    public DataTable getDataTableContratoNew() {
        return dataTableContratoNew;
    }

    public void setOutputLabelAdjuntarContratoNew(OutputLabel outputLabel8) {
        this.outputLabelAdjuntarContratoNew = outputLabel8;
    }

    public OutputLabel getOutputLabelAdjuntarContratoNew() {
        return outputLabelAdjuntarContratoNew;
    }

    public void setInputTextAdjutarContratoNew(InputText inputText1) {
        this.inputTextAdjutarContratoNew = inputText1;
    }

    public InputText getInputTextAdjutarContratoNew() {
        return inputTextAdjutarContratoNew;
    }

    public void setCommandButtonAgregarAdenda(CommandButton commandButton3) {
        this.commandButtonAgregarAdenda = commandButton3;
    }

    public CommandButton getCommandButtonAgregarAdenda() {
        return commandButtonAgregarAdenda;
    }

    public void setSelectOneMenuEtapaPeriodo(SelectOneMenu selectOneMenu1) {
        this.selectOneMenuEtapaPeriodo = selectOneMenu1;
    }

    public SelectOneMenu getSelectOneMenuEtapaPeriodo() {
        return selectOneMenuEtapaPeriodo;
    }

    public void setInputHidden2(HtmlInputHidden inputHidden2) {
        this.inputHidden2 = inputHidden2;
    }

    public HtmlInputHidden getInputHidden2() {
        return inputHidden2;
    }

    /**
     * @author Paul Rivera
     * @return Moneda
     */

    //@ManagedProperty(value = "#{monedaVO}")
    private MonedaVO monedaVO = new MonedaVO();

    //@ManagedProperty(value = "#{monedaServiceImpl}")
    private MonedaServiceImpl monedaServiceImpl = new MonedaServiceImpl();


    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }

    public void setMonedaServiceImpl(MonedaServiceImpl monedaServiceImpl) {
        this.monedaServiceImpl = monedaServiceImpl;
    }

    public MonedaServiceImpl getMonedaServiceImpl() {
        return monedaServiceImpl;
    }


    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMonedaSelectItems(List<SelectItem> monedaSelectItems) {
        this.monedaSelectItems = monedaSelectItems;
    }

    private List<MonedaVO> listaMoneda;

    public List<MonedaVO> listarMoneda() throws SQLException {
        try {
            System.out.println("llego a contrato");
            listaMoneda = getMonedaServiceImpl().query();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMoneda;
    }

    /**
     * @author Paul Rivera
     * @return moneda para que se renderize en el combo
     */
    public List<SelectItem> getMonedaSelectItems() throws SQLException {
        
        System.out.println("1");
        monedaSelectItems.add(new SelectItem("-1", "Seleccione"));
        System.out.println("2");
        List<MonedaVO> lista = listarMoneda();
        System.out.println("3");
        int i = 0;
        for (MonedaVO mvo : lista) {
            System.out.println("4");
            monedaSelectItems.add(new SelectItem(i++, String.valueOf(mvo.getMonNombre())));
        }
        return monedaSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return moneda seleccionado del combo
     */
    public String getInputHiddenSelectedMoneda() {
        if ("".equals(getMoneda()) || getMoneda() == null) {
            return "";
        } else {
            return getMoneda();
        }
    }


    public void setCommandButtonGrabar(CommandButton commandButton3) {
        this.commandButtonGrabar = commandButton3;
    }

    public CommandButton getCommandButtonGrabar() {
        return commandButtonGrabar;
    }

    public void grabar() throws SQLException {
        System.out.println("=====================================================");
        System.out.println("INGRESA A ESTE METODO!!!!!!!!!!!!!!!");
        System.out.println("=====================================================");
        /*if (nomEmpSup.trim().equals("")) {
            FacesMessage mensaje =
                            new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado el Nombre de la Empresa Supervisora");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (dirEmpSup.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado la Dirección de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (repLegal.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado al Representante Legal de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!correo.matches("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Correo de la Empresa Supervisora Invalido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (siglasNom.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado las Siglas del Nombre de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarNombre(nomEmpSup.trim())>0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nombre de Empresa Supervisora ya Registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!telefono.trim().equals("") && !telefono.matches("[0-9]*")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Telefono Inválido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento>0 && !nroDoc.matches("[0-9]*") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento Inválido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento == 0 && !nroDoc.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione Tipo de Documento");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento==1 && nroDoc.matches("[0-9]*") && (nroDoc.trim().length() > 8 ||nroDoc.trim().length() < 8)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento debe tener 8 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumento==2 && nroDoc.matches("[0-9]*") && (nroDoc.trim().length() > 11 ||nroDoc.trim().length() < 11)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento debe tener 11 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarRuc(nroDoc.trim(),tipoDocumento) > 0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El Nro de Documento Ingresado, ya fue registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }

        else{*/
        try {
            contratoSupervisoraVO.setCpsNroDeContrato(Integer.valueOf(String.valueOf(inputTextNroContrato)));
            contratoSupervisoraVO.setCpsFechaInicio(new SimpleDateFormat().parse(String.valueOf(calendarFecIniContratoNew)));
            contratoSupervisoraVO.setCpsFechaSuscripcion(new SimpleDateFormat().parse(String.valueOf(calendarFecSuscripcionNew)));
            contratoSupervisoraVO.setCpsPlazoContrato(Integer.valueOf(String.valueOf(inputTextPlazoContratoNew)));
            contratoSupervisoraVO.setCpsMontoContratado(Integer.valueOf(String.valueOf(inputTextMontoContratadoNew)));
            contratoSupervisoraVO.setCpsAdelantoOtorgado(Integer.valueOf(String.valueOf(inputTextAdelantoOtorgadoNew)));
            contratoSupervisoraVO.setCpsFechaAdelanto(new SimpleDateFormat().parse(String.valueOf(Integer.valueOf(String.valueOf(inputTextAdelantoOtorgadoNew)))));
            contratoSupervisoraVO.setCpsStd(Integer.valueOf(String.valueOf(inputTextNroContratoNew)));
            contratoSupervisoraVO.setCpsEstado(1);
            contratoSupervisoraVO.setCpsAnyo(Integer.valueOf(String.valueOf(inputTextAnnio)));
            contratoSupervisoraVO.setCpsFechaRegistro(new SimpleDateFormat().parse(String.valueOf(calendarFechaRegistro)));
            contratoSupervisoraVO.setCpsAsunto(String.valueOf(inputTextareaAsunto));
            contratoSupervisoraVO.setEmpresaSupervisora(Integer.valueOf(String.valueOf(inputTextEmpresaSupervisora)));
            contratoSupervisoraVO.setContrato(Integer.valueOf(String.valueOf(inputTextNroContratoNew)));
            contratoSupervisoraVO.setInfraestructura(1);
            contratoSupervisoraVO.setCpsEstado(1);
            contratoSupervisoraVO.setTipoInfraestructura(Integer.valueOf(String.valueOf(inputTextTipoInfraestructura)));
            contratoSupervisoraVO.setConcesion(1);
            contratoSupervisoraVO.setCpsPenalidades("1");
            contratoSupervisoraVO.setCpsCaducidad("1");
            contratoSupervisoraVO.setCpsGarantias("1");
            this.contratoEmpresaSupervisoraServiceImpl.insert(contratoSupervisoraVO);
            //getQuery();
            //limpiarCampos();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Registro con Exito");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            RequestContext.getCurrentInstance().execute("dialogRegConEmpSup.hide()");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Error" + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }


    public void setCommandButtonCancelar(CommandButton commandButton3) {
        this.commandButtonCancelar = commandButton3;
    }

    public CommandButton getCommandButtonCancelar() {
        return commandButtonCancelar;
    }
}

