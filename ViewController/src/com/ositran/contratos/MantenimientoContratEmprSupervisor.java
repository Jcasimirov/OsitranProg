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
import java.util.Date;
import java.util.List;

import java.util.Map;

import javax.annotation.Generated;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
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
@ViewScoped
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
    private Column columnTipoInfraestructura;
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
    private Date fechaInicio;
    private Date fechaSuscripcion;
    private String inputHiddenSelectedTipoInfraestructura;
    private String inputHiddenSelectedMoneda;
    private HtmlCommandButton commandButton3;
    private LayoutUnit layoutUnit2;
    private CommandButton commandButton4;
    private CommandButton commandButton5;
    private HtmlOutputText outputText4;
    private HtmlOutputText outputText5;
    private HtmlOutputText outputText6;
    private HtmlOutputText outputText7;
    private InputText inputTextIdEliminar;
    private HtmlInputHidden inputHidden3;
    private Dialog dialogModificarConEmpSup;
    private PanelGrid panelGrid3;
    private ColumnGroup columnGroup3;
    private PanelGrid panelGridDatosSTDModif;
    private InputText inputTextNumeroModif;
    private InputText inputTextAnnioModif;
    private Calendar calendarFechaRegistroModif;
    private InputTextarea inputTextareaAsuntoModif;
    private PanelGrid panelGridContratConcesionModif;
    private InputText inputTextConcesionModif;
    private InputText inputTextTipoInfraModif;
    private InputText inputTextModalidadConcesionModif;
    private SelectOneMenu selectOneMenuAeropuertoModif;
    private InputText inputTextInversionModif;
    private PanelGrid panelGridEtapaConcesionModif;
    private InputText inputTextTotalModif;
    private InputText inputTextMonedaModif;
    private InputText inputTextPlazoModif;
    private SelectOneMenu selectOneMenuEtapaPeriodoModif;
    private ColumnGroup columnGroup4;
    private Fieldset fieldset2;
    private PanelGrid panelGridDatosContratoModif;
    private InputText inputTextNroContratoModif;
    private Calendar calendarFecIniContratoModif;
    private Calendar calendarFecSuscripcionModif;
    private InputText inputTextPlazoContratoModif;
    private InputText inputTextMontoContratadoModif;
    private InputTextarea inputTextareaRefCausalesCaduModif;
    private InputTextarea inputTextareaRefPenalidadModif;
    private Calendar calendarFechaAdelantoModif;
    private InputText inputTextAdelantoOtorgadoModif;
    private InputText inputTextAdjutarContratoModif;
    private InputTextarea inputTextareaGarantiasFavorModif;
    private DataTable dataTableContratoModif;
    private String inputHiddenSelectedMonedaModif;
    private CommandButton commandButtonAgregarAdendaModif;
    private CommandButton commandButtonCancelarModif;
    private CommandButton commandButtonDialModificar;
    private HtmlInputHidden inputHidden4;


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

    public void setColumnTipoInfraestructura(Column column8) {
        this.columnTipoInfraestructura = column8;
    }

    public Column getColumnTipoInfraestructura() {
        return columnTipoInfraestructura;
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

    public void setInputHiddenSelectedTipoInfraestructura(String inputHiddenSelectedTipoInfraestructura) {
        this.inputHiddenSelectedTipoInfraestructura = inputHiddenSelectedTipoInfraestructura;
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


    public ContratoSupervisoraVO getContratoSupervisoraVO() {
        return contratoSupervisoraVO;
    }

    public void setContratoSupervisoraVO(ContratoSupervisoraVO contratoSupervisoraVO) {
        this.contratoSupervisoraVO = contratoSupervisoraVO;
    }

    public void setContratoEmpresaSupervisoraServiceImpl(ContratoEmpresaSupervisoraServiceImpl contratoEmpresaSupervisoraServiceImpl) {
        this.contratoEmpresaSupervisoraServiceImpl = contratoEmpresaSupervisoraServiceImpl;
    }

    public ContratoEmpresaSupervisoraServiceImpl getContratoEmpresaSupervisoraServiceImpl() {
        return contratoEmpresaSupervisoraServiceImpl;
    }

    ///private List<ContratoSupervisoraVO> listaContratoSupervisora;
    private List<ContratoSupervisoraVO> listaContratoSupervisora=new ArrayList<ContratoSupervisoraVO>();

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
        monedaSelectItems.add(new SelectItem("-1", "Seleccione"));
        List<MonedaVO> lista = listarMoneda();
        int i = 0;
        for (MonedaVO mvo : lista) {
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

    public void setInputHiddenSelectedMoneda(String inputHiddenSelectedMoneda) {
        this.inputHiddenSelectedMoneda = inputHiddenSelectedMoneda;
    }

    public void setCommandButtonGrabar(CommandButton commandButton3) {
        this.commandButtonGrabar = commandButton3;
    }

    public CommandButton getCommandButtonGrabar() {
        return commandButtonGrabar;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaSuscripcion(Date fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public Date getFechaSuscripcion() {
        return fechaSuscripcion;
    }


    public void grabar() throws SQLException {
        try {
            contratoSupervisoraVO.setCpsFechaInicio((Date)calendarFecIniContratoNew.getValue());
            contratoSupervisoraVO.setCpsFechaSuscripcion((Date)calendarFecSuscripcionNew.getValue());
            contratoSupervisoraVO.setCpsPlazoContrato(Integer.valueOf((String)inputTextPlazoContratoNew.getValue()));
            contratoSupervisoraVO.setCpsMontoContratado(Integer.valueOf(String.valueOf(inputTextMontoContratadoNew.getValue())));
            contratoSupervisoraVO.setCpsAdelantoOtorgado(Integer.valueOf(String.valueOf(inputTextAdelantoOtorgadoNew.getValue())));
            contratoSupervisoraVO.setCpsFechaAdelanto((Date)calendarFechaAdelantoNew.getValue());
            contratoSupervisoraVO.setCpsStd(Integer.valueOf(String.valueOf(inputTextNroContratoNew.getValue())));
            contratoSupervisoraVO.setCpsEstado(1);
            contratoSupervisoraVO.setCpsAnyo(Integer.valueOf(String.valueOf(inputTextAnnio.getValue())));
            contratoSupervisoraVO.setCpsFechaRegistro((Date)calendarFechaRegistro.getValue());
            contratoSupervisoraVO.setCpsAsunto(String.valueOf(inputTextareaAsunto.getValue()));
            //contratoSupervisoraVO.setEmpresaSupervisora(Integer.valueOf(String.valueOf(inputTextEmpresaSupervisora.getValue())));
            contratoSupervisoraVO.setEmpresaSupervisora(1);
            System.out.println("empresa: "+contratoSupervisoraVO.getEmpresaSupervisora());
            contratoSupervisoraVO.setContrato(22);
            contratoSupervisoraVO.setInfraestructura(1);
            contratoSupervisoraVO.setCpsEstado(1);
            contratoSupervisoraVO.setTipoInfraestructura(Integer.valueOf(String.valueOf(inputHiddenItemTipoInfraestructura.getValue())));
            System.out.println("tipo infra: "+contratoSupervisoraVO.getTipoInfraestructura());
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


    

    public void setCommandButton3(HtmlCommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public HtmlCommandButton getCommandButton3() {
        return commandButton3;
    }

    public void setLayoutUnit2(LayoutUnit layoutUnit2) {
        this.layoutUnit2 = layoutUnit2;
    }

    public LayoutUnit getLayoutUnit2() {
        return layoutUnit2;
    }

    public void setCommandButton4(CommandButton commandButton4) {
        this.commandButton4 = commandButton4;
    }

    public CommandButton getCommandButton4() {
        return commandButton4;
    }

    public void setCommandButton5(CommandButton commandButton5) {
        this.commandButton5 = commandButton5;
    }

    public CommandButton getCommandButton5() {
        return commandButton5;
    }

    public void setOutputText4(HtmlOutputText outputText4) {
        this.outputText4 = outputText4;
    }

    public HtmlOutputText getOutputText4() {
        return outputText4;
    }

    public void setOutputText5(HtmlOutputText outputText5) {
        this.outputText5 = outputText5;
    }

    public HtmlOutputText getOutputText5() {
        return outputText5;
    }
    
    int idEliminar;
    String nombreEliminar;

    public void setIdEliminar(int idEliminar) {
        this.idEliminar = idEliminar;
    }

    public int getIdEliminar() {
        return idEliminar;
    }
    
    public void setNombreEliminar(String nombreEliminar) {
        this.nombreEliminar = nombreEliminar;
    }

    public String getNombreEliminar() {
        return nombreEliminar;
    }
        
    public void confirmarEliminar() throws SQLException{
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("id3");
        Integer idContEmpSup = Integer.valueOf(str.toString());
        contratoSupervisoraVO=this.contratoEmpresaSupervisoraServiceImpl.get(idContEmpSup);
        //contratoSupervisoraVO.setCpsNroDeContrato(idContEmpSup);
        idEliminar = contratoSupervisoraVO.getCpsNroDeContrato();
        nombreEliminar = String.valueOf(contratoSupervisoraVO.getCpsNroDeContrato()); //.toUpperCase();
    }
    
    public String empSupDel() throws SQLException{
        try{            
            contratoSupervisoraVO=this.contratoEmpresaSupervisoraServiceImpl.get(idEliminar);
            ///contratoSupervisoraVO.setCpsNroDeContrato(idEliminar);
            contratoSupervisoraVO.setCpsEstado(2);
            //contratoSupervisoraVO.setSupFechaBaja(util.getObtenerFechaHoy());
            //contratoSupervisoraVO.setSupTerminal(util.obtenerIpCliente());
            this.contratoEmpresaSupervisoraServiceImpl.update(contratoSupervisoraVO);
            //this.empSupServiceImp.delete(idEmpSup);
            ///getQuery();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Elimino con Exito");
                                                        FacesContext.getCurrentInstance().addMessage(null, mensaje);        
        }catch(Exception e){
            System.out.println(e.getMessage());
                            FacesMessage mensaje =
                                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Error" + e.getMessage());
                            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        return "/index?faces-redirect=true";        
    }


    public void setOutputText6(HtmlOutputText outputText6) {
        this.outputText6 = outputText6;
    }

    public HtmlOutputText getOutputText6() {
        return outputText6;
    }

    public void setOutputText7(HtmlOutputText outputText7) {
        this.outputText7 = outputText7;
    }

    public HtmlOutputText getOutputText7() {
        return outputText7;
    }

    public void setInputTextIdEliminar(InputText inputText1) {
        this.inputTextIdEliminar = inputText1;
    }

    public InputText getInputTextIdEliminar() {
        return inputTextIdEliminar;
    }

    public void setInputHidden3(HtmlInputHidden inputHidden3) {
        this.inputHidden3 = inputHidden3;
    }

    public HtmlInputHidden getInputHidden3() {
        return inputHidden3;
    }

    public void setDialogModificarConEmpSup(Dialog dialog1) {
        this.dialogModificarConEmpSup = dialog1;
    }

    public Dialog getDialogModificarConEmpSup() {
        return dialogModificarConEmpSup;
    }

    public void setPanelGrid3(PanelGrid panelGrid3) {
        this.panelGrid3 = panelGrid3;
    }

    public PanelGrid getPanelGrid3() {
        return panelGrid3;
    }

    public void setColumnGroup3(ColumnGroup columnGroup3) {
        this.columnGroup3 = columnGroup3;
    }

    public ColumnGroup getColumnGroup3() {
        return columnGroup3;
    }

    public void setPanelGridDatosSTDModif(PanelGrid panelGrid4) {
        this.panelGridDatosSTDModif = panelGrid4;
    }

    public PanelGrid getPanelGridDatosSTDModif() {
        return panelGridDatosSTDModif;
    }

    public void setInputTextNumeroModif(InputText inputText1) {
        this.inputTextNumeroModif = inputText1;
    }

    public InputText getInputTextNumeroModif() {
        return inputTextNumeroModif;
    }

    public void setInputTextAnnioModif(InputText inputText1) {
        this.inputTextAnnioModif = inputText1;
    }

    public InputText getInputTextAnnioModif() {
        return inputTextAnnioModif;
    }

    public void setCalendarFechaRegistroModif(Calendar calendar1) {
        this.calendarFechaRegistroModif = calendar1;
    }

    public Calendar getCalendarFechaRegistroModif() {
        return calendarFechaRegistroModif;
    }

    public void setInputTextareaAsuntoModif(InputTextarea inputTextarea1) {
        this.inputTextareaAsuntoModif = inputTextarea1;
    }

    public InputTextarea getInputTextareaAsuntoModif() {
        return inputTextareaAsuntoModif;
    }

    public void setPanelGridContratConcesionModif(PanelGrid panelGrid4) {
        this.panelGridContratConcesionModif = panelGrid4;
    }

    public PanelGrid getPanelGridContratConcesionModif() {
        return panelGridContratConcesionModif;
    }

    public void setInputTextConcesionModif(InputText inputText1) {
        this.inputTextConcesionModif = inputText1;
    }

    public InputText getInputTextConcesionModif() {
        return inputTextConcesionModif;
    }

    public void setInputTextTipoInfraModif(InputText inputText1) {
        this.inputTextTipoInfraModif = inputText1;
    }

    public InputText getInputTextTipoInfraModif() {
        return inputTextTipoInfraModif;
    }

    public void setInputTextModalidadConcesionModif(InputText inputText1) {
        this.inputTextModalidadConcesionModif = inputText1;
    }

    public InputText getInputTextModalidadConcesionModif() {
        return inputTextModalidadConcesionModif;
    }

    public void setSelectOneMenuAeropuertoModif(SelectOneMenu selectOneMenu1) {
        this.selectOneMenuAeropuertoModif = selectOneMenu1;
    }

    public SelectOneMenu getSelectOneMenuAeropuertoModif() {
        return selectOneMenuAeropuertoModif;
    }

    public void setInputTextInversionModif(InputText inputText1) {
        this.inputTextInversionModif = inputText1;
    }

    public InputText getInputTextInversionModif() {
        return inputTextInversionModif;
    }

    public void setPanelGridEtapaConcesionModif(PanelGrid panelGrid4) {
        this.panelGridEtapaConcesionModif = panelGrid4;
    }

    public PanelGrid getPanelGridEtapaConcesionModif() {
        return panelGridEtapaConcesionModif;
    }

    public void setInputTextTotalModif(InputText inputText1) {
        this.inputTextTotalModif = inputText1;
    }

    public InputText getInputTextTotalModif() {
        return inputTextTotalModif;
    }

    public void setInputTextMonedaModif(InputText inputText1) {
        this.inputTextMonedaModif = inputText1;
    }

    public InputText getInputTextMonedaModif() {
        return inputTextMonedaModif;
    }

    public void setInputTextPlazoModif(InputText inputText1) {
        this.inputTextPlazoModif = inputText1;
    }

    public InputText getInputTextPlazoModif() {
        return inputTextPlazoModif;
    }

    public void setSelectOneMenuEtapaPeriodoModif(SelectOneMenu selectOneMenu1) {
        this.selectOneMenuEtapaPeriodoModif = selectOneMenu1;
    }

    public SelectOneMenu getSelectOneMenuEtapaPeriodoModif() {
        return selectOneMenuEtapaPeriodoModif;
    }

    public void setColumnGroup4(ColumnGroup columnGroup4) {
        this.columnGroup4 = columnGroup4;
    }

    public ColumnGroup getColumnGroup4() {
        return columnGroup4;
    }

    public void setFieldset2(Fieldset fieldset2) {
        this.fieldset2 = fieldset2;
    }

    public Fieldset getFieldset2() {
        return fieldset2;
    }

    public void setPanelGridDatosContratoModif(PanelGrid panelGrid4) {
        this.panelGridDatosContratoModif = panelGrid4;
    }

    public PanelGrid getPanelGridDatosContratoModif() {
        return panelGridDatosContratoModif;
    }

    public void setInputTextNroContratoModif(InputText inputText1) {
        this.inputTextNroContratoModif = inputText1;
    }

    public InputText getInputTextNroContratoModif() {
        return inputTextNroContratoModif;
    }

    public void setCalendarFecIniContratoModif(Calendar calendar1) {
        this.calendarFecIniContratoModif = calendar1;
    }

    public Calendar getCalendarFecIniContratoModif() {
        return calendarFecIniContratoModif;
    }

    public void setCalendarFecSuscripcionModif(Calendar calendar1) {
        this.calendarFecSuscripcionModif = calendar1;
    }

    public Calendar getCalendarFecSuscripcionModif() {
        return calendarFecSuscripcionModif;
    }

    public void setInputTextPlazoContratoModif(InputText inputText1) {
        this.inputTextPlazoContratoModif = inputText1;
    }

    public InputText getInputTextPlazoContratoModif() {
        return inputTextPlazoContratoModif;
    }

    public void setInputTextMontoContratadoModif(InputText inputText1) {
        this.inputTextMontoContratadoModif = inputText1;
    }

    public InputText getInputTextMontoContratadoModif() {
        return inputTextMontoContratadoModif;
    }

    public void setInputTextareaRefCausalesCaduModif(InputTextarea inputTextarea1) {
        this.inputTextareaRefCausalesCaduModif = inputTextarea1;
    }

    public InputTextarea getInputTextareaRefCausalesCaduModif() {
        return inputTextareaRefCausalesCaduModif;
    }

    public void setInputTextareaRefPenalidadModif(InputTextarea inputTextarea1) {
        this.inputTextareaRefPenalidadModif = inputTextarea1;
    }

    public InputTextarea getInputTextareaRefPenalidadModif() {
        return inputTextareaRefPenalidadModif;
    }

    public void setCalendarFechaAdelantoModif(Calendar calendar1) {
        this.calendarFechaAdelantoModif = calendar1;
    }

    public Calendar getCalendarFechaAdelantoModif() {
        return calendarFechaAdelantoModif;
    }

    public void setInputTextAdelantoOtorgadoModif(InputText inputText1) {
        this.inputTextAdelantoOtorgadoModif = inputText1;
    }

    public InputText getInputTextAdelantoOtorgadoModif() {
        return inputTextAdelantoOtorgadoModif;
    }

    public void setInputTextAdjutarContratoModif(InputText inputText1) {
        this.inputTextAdjutarContratoModif = inputText1;
    }

    public InputText getInputTextAdjutarContratoModif() {
        return inputTextAdjutarContratoModif;
    }

    public void setInputTextareaGarantiasFavorModif(InputTextarea inputTextarea1) {
        this.inputTextareaGarantiasFavorModif = inputTextarea1;
    }

    public InputTextarea getInputTextareaGarantiasFavorModif() {
        return inputTextareaGarantiasFavorModif;
    }

    public void setDataTableContratoModif(DataTable dataTable1) {
        this.dataTableContratoModif = dataTable1;
    }

    public DataTable getDataTableContratoModif() {
        return dataTableContratoModif;
    }


    public void setCommandButtonAgregarAdendaModif(CommandButton commandButton6) {
        this.commandButtonAgregarAdendaModif = commandButton6;
    }

    public CommandButton getCommandButtonAgregarAdendaModif() {
        return commandButtonAgregarAdendaModif;
    }

    public void setCommandButtonCancelarModif(CommandButton commandButton6) {
        this.commandButtonCancelarModif = commandButton6;
    }

    public CommandButton getCommandButtonCancelarModif() {
        return commandButtonCancelarModif;
    }

    public void setCommandButtonDialModificar(CommandButton commandButton6) {
        this.commandButtonDialModificar = commandButton6;
    }

    public CommandButton getCommandButtonDialModificar() {
        return commandButtonDialModificar;
    }

    public void setSelectOneMenuMonedaModif(SelectOneMenu selectOneMenu1) {
        this.selectOneMenuMonedaModif = selectOneMenu1;
    }

    public SelectOneMenu getSelectOneMenuMonedaModif() {
        return selectOneMenuMonedaModif;
    }

    private String inputTextNumeroModifStr;
    private String inputTextAnnioModifStr;
    private String calendarFecIniContratoModifStr;
    private String calendarFecSuscripcionModifStr;
    private String inputTextPlazoContratoModifStr;
    private String inputTextMontoContratadoModifStr;
    private String inputTextAdelantoOtorgadoModifStr;
    private String calendarFechaAdelantoModifStr;
    private String inputTextNroContratoModifStr;
    private String calendarFechaRegistroModifStr;
    private String inputTextareaAsuntoModifStr;
    private String inputTextTipoInfraModifStr;
    private String inputTextareaRefPenalidadModifStr;
    private String inputTextareaRefCausalesCaduModifStr;
    private String inputTextareaGarantiasFavorModifStr;


    public void setInputTextNumeroModifStr(String inputTextNumeroModifStr) {
        this.inputTextNumeroModifStr = inputTextNumeroModifStr;
    }

    public String getInputTextNumeroModifStr() {
        return inputTextNumeroModifStr;
    }

    public void setInputTextAnnioModifStr(String inputTextAnnioModifStr) {
        this.inputTextAnnioModifStr = inputTextAnnioModifStr;
    }

    public String getInputTextAnnioModifStr() {
        return inputTextAnnioModifStr;
    }

    public void setCalendarFecIniContratoModifStr(String calendarFecIniContratoModifStr) {
        this.calendarFecIniContratoModifStr = calendarFecIniContratoModifStr;
    }

    public String getCalendarFecIniContratoModifStr() {
        return calendarFecIniContratoModifStr;
    }

    public void setCalendarFecSuscripcionModifStr(String calendarFecSuscripcionModifStr) {
        this.calendarFecSuscripcionModifStr = calendarFecSuscripcionModifStr;
    }

    public String getCalendarFecSuscripcionModifStr() {
        return calendarFecSuscripcionModifStr;
    }

    public void setInputTextPlazoContratoModifStr(String inputTextPlazoContratoModifStr) {
        this.inputTextPlazoContratoModifStr = inputTextPlazoContratoModifStr;
    }

    public String getInputTextPlazoContratoModifStr() {
        return inputTextPlazoContratoModifStr;
    }

    public void setInputTextMontoContratadoModifStr(String inputTextMontoContratadoModifStr) {
        this.inputTextMontoContratadoModifStr = inputTextMontoContratadoModifStr;
    }

    public String getInputTextMontoContratadoModifStr() {
        return inputTextMontoContratadoModifStr;
    }

    public void setInputTextAdelantoOtorgadoModifStr(String inputTextAdelantoOtorgadoModifStr) {
        this.inputTextAdelantoOtorgadoModifStr = inputTextAdelantoOtorgadoModifStr;
    }

    public String getInputTextAdelantoOtorgadoModifStr() {
        return inputTextAdelantoOtorgadoModifStr;
    }

    public void setCalendarFechaAdelantoModifStr(String calendarFechaAdelantoModifStr) {
        this.calendarFechaAdelantoModifStr = calendarFechaAdelantoModifStr;
    }

    public String getCalendarFechaAdelantoModifStr() {
        return calendarFechaAdelantoModifStr;
    }

    public void setInputTextNroContratoModifStr(String inputTextNroContratoModifStr) {
        this.inputTextNroContratoModifStr = inputTextNroContratoModifStr;
    }

    public String getInputTextNroContratoModifStr() {
        return inputTextNroContratoModifStr;
    }

    public void setCalendarFechaRegistroModifStr(String calendarFechaRegistroModifStr) {
        this.calendarFechaRegistroModifStr = calendarFechaRegistroModifStr;
    }

    public String getCalendarFechaRegistroModifStr() {
        return calendarFechaRegistroModifStr;
    }

    public void setInputTextareaAsuntoModifStr(String inputTextareaAsuntoModifStr) {
        this.inputTextareaAsuntoModifStr = inputTextareaAsuntoModifStr;
    }

    public String getInputTextareaAsuntoModifStr() {
        return inputTextareaAsuntoModifStr;
    }

    public void setInputTextTipoInfraModifStr(String inputTextTipoInfraModifStr) {
        this.inputTextTipoInfraModifStr = inputTextTipoInfraModifStr;
    }

    public String getInputTextTipoInfraModifStr() {
        return inputTextTipoInfraModifStr;
    }

    public void setInputTextareaRefPenalidadModifStr(String inputTextareaRefPenalidadModifStr) {
        this.inputTextareaRefPenalidadModifStr = inputTextareaRefPenalidadModifStr;
    }

    public String getInputTextareaRefPenalidadModifStr() {
        return inputTextareaRefPenalidadModifStr;
    }

    public void setInputTextareaRefCausalesCaduModifStr(String inputTextareaRefCausalesCaduModifStr) {
        this.inputTextareaRefCausalesCaduModifStr = inputTextareaRefCausalesCaduModifStr;
    }

    public String getInputTextareaRefCausalesCaduModifStr() {
        return inputTextareaRefCausalesCaduModifStr;
    }

    public void setInputTextareaGarantiasFavorModifStr(String inputTextareaGarantiasFavorModifStr) {
        this.inputTextareaGarantiasFavorModifStr = inputTextareaGarantiasFavorModifStr;
    }

    public String getInputTextareaGarantiasFavorModifStr() {
        return inputTextareaGarantiasFavorModifStr;
    }

    public void contraEmpSupUpd1() throws SQLException{
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("id2");
        Integer idEmpSup=Integer.valueOf(str.toString());        
        contratoSupervisoraVO=this.contratoEmpresaSupervisoraServiceImpl.get(idEmpSup);   
        inputTextNumeroModifStr=String.valueOf(contratoSupervisoraVO.getCpsStd());
        inputTextAnnioModifStr=String.valueOf(contratoSupervisoraVO.getCpsAnyo());
        calendarFecIniContratoModifStr=String.valueOf(contratoSupervisoraVO.getCpsFechaInicio());
        calendarFecSuscripcionModifStr=String.valueOf(contratoSupervisoraVO.getCpsFechaSuscripcion());
        inputTextPlazoContratoModifStr=String.valueOf(contratoSupervisoraVO.getCpsPlazoContrato());
        inputTextMontoContratadoModifStr=String.valueOf(contratoSupervisoraVO.getCpsMontoContratado());
        inputTextAdelantoOtorgadoModifStr=String.valueOf(contratoSupervisoraVO.getCpsAdelantoOtorgado());
        calendarFechaAdelantoModifStr=String.valueOf(contratoSupervisoraVO.getCpsFechaAdelanto());
        inputTextNroContratoModifStr=String.valueOf(contratoSupervisoraVO.getCpsNroDeContrato());
        calendarFechaRegistroModifStr=String.valueOf(contratoSupervisoraVO.getCpsFechaRegistro());
        inputTextareaAsuntoModifStr=String.valueOf(contratoSupervisoraVO.getCpsAsunto());
        inputTextTipoInfraModifStr=String.valueOf(contratoSupervisoraVO.getTipoInfraestructura());
        inputTextareaRefPenalidadModifStr=contratoSupervisoraVO.getCpsPenalidades();
        inputTextareaRefCausalesCaduModifStr=contratoSupervisoraVO.getCpsCaducidad();
        inputTextareaGarantiasFavorModifStr=contratoSupervisoraVO.getCpsGarantias();

    }
    
    
    private SelectOneMenu selectOneMenuMonedaModif;
    private String monedaModif;
    List<SelectItem> monedaSelectItemsModif = new ArrayList<SelectItem>();

    public void setMonedaModif(String monedaModif) {
        this.monedaModif = monedaModif;
    }

    public String getMonedaModif() {
        return monedaModif;
    }

    public void setMonedaSelectItemsModif(List<SelectItem> monedaSelectItemsModif) {
        this.monedaSelectItemsModif = monedaSelectItemsModif;
    }


    /**
     * @author Paul Rivera
     * @return Moneda para el dialog de modificar
     */
    private List<MonedaVO> listaMonedaModif;

    public List<MonedaVO> listarMonedaModif() throws SQLException {
        try {
            listaMonedaModif = getMonedaServiceImpl().query();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMonedaModif;
    }

    /**
     * @author Paul Rivera
     * @return moneda para que se renderize en el combo para modificar
     */
    public List<SelectItem> getMonedaSelectItemsModif() throws SQLException {
        monedaSelectItemsModif.add(new SelectItem("-1", "Seleccione"));
        List<MonedaVO> lista = listarMonedaModif();
        int i = 0;
        for (MonedaVO mvo : lista) {
            monedaSelectItemsModif.add(new SelectItem(i++, String.valueOf(mvo.getMonNombre())));
        }
        return monedaSelectItemsModif;
    }

    
    /**
     * @author Paul Rivera
     * @return moneda seleccionado del combo
     */
    public String getInputHiddenSelectedMonedaModif() {
        if ("".equals(getMoneda()) || getMoneda() == null) {
            return "";
        } else {
            return getMoneda();
        }
    }

    public void setInputHiddenSelectedMonedaModif(String inputHiddenSelectedMoneda) {
        this.inputHiddenSelectedMonedaModif = inputHiddenSelectedMoneda;
    }


    public void setInputHidden4(HtmlInputHidden inputHidden4) {
        this.inputHidden4 = inputHidden4;
    }

    public HtmlInputHidden getInputHidden4() {
        return inputHidden4;
    }
    
    public void modificar() throws SQLException{
        /*if (nomEmpSupMod.trim().equals("")) {
            FacesMessage mensaje =
                            new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado el Nombre de la Empresa Supervisora");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (dirEmpSupMod.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado la Dirección de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (repLegalMod.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado al Representante Legal de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!correoMod.matches("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Correo de la Empresa Supervisora Invalido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (siglasNomMod.trim().equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha Ingresado las Siglas del Nombre de la Empresa Supervisora");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarNombreMod(nomEmpSupMod.trim(),nommod.trim())>0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nombre de Empresa Supervisora ya Registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (!telefonoMod.trim().equals("") && !telefonoMod.matches("[0-9]*")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Telefono Inválido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod>0 && !nroDocMod.matches("[0-9]*") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento Inválido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod == 0 && !nroDocMod.trim().equals("") ) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione Tipo de Documento");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod==1 && nroDocMod.matches("[0-9]*") && (nroDocMod.trim().length() > 8 ||nroDocMod.trim().length() < 8)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento debe tener 8 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (tipoDocumentoMod==2 && nroDocMod.matches("[0-9]*") && (nroDocMod.trim().length() > 11 ||nroDocMod.trim().length() < 11)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nro de Documento debe tener 11 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else if (validarRucMod(nroDocMod.trim(),nroRuc,tipoDocumentoMod) > 0) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El Nro de Documento Ingresado, ya fue registrado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        else{*/
            try{
                contratoSupervisoraVO.setCpsStd(Integer.valueOf(inputTextNumeroModifStr));
                contratoSupervisoraVO.setCpsAnyo(Integer.valueOf(inputTextAnnioModifStr));
                contratoSupervisoraVO.setCpsAsunto(inputTextareaAsuntoModifStr);
                contratoSupervisoraVO.setCpsNroDeContrato(Integer.valueOf(inputTextNroContratoModifStr));
                contratoSupervisoraVO.setCpsFechaInicio(new SimpleDateFormat("dd-MM-yy").parse(calendarFecIniContratoModifStr));
                contratoSupervisoraVO.setCpsFechaSuscripcion(new SimpleDateFormat("dd-MM-yy").parse(calendarFecSuscripcionModifStr));
                contratoSupervisoraVO.setCpsPlazoContrato(Integer.valueOf(inputTextPlazoContratoModifStr));
                contratoSupervisoraVO.setCpsMontoContratado(Integer.valueOf(inputTextMontoContratadoModifStr));
                contratoSupervisoraVO.setCpsAdelantoOtorgado(Integer.valueOf(inputTextAdelantoOtorgadoModifStr));
                contratoSupervisoraVO.setCpsPenalidades(inputTextareaRefPenalidadModifStr);
                contratoSupervisoraVO.setCpsCaducidad(inputTextareaRefCausalesCaduModifStr);
                contratoSupervisoraVO.setCpsGarantias(inputTextareaGarantiasFavorModifStr);
                contratoSupervisoraVO.setTipoInfraestructura(Integer.valueOf(inputTextTipoInfraModifStr));
                contratoSupervisoraVO.setCpsFechaAdelanto(new SimpleDateFormat("dd-MM-yy").parse(calendarFechaAdelantoModifStr));
                contratoSupervisoraVO.setCpsFechaRegistro(new SimpleDateFormat("dd-MM-yy").parse(calendarFechaRegistroModifStr));
                    
                    
                this.contratoEmpresaSupervisoraServiceImpl.update(contratoSupervisoraVO);        
                ///getQuery();
                ///limpiarCampos();
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Actualizo con Exito");
                                                            FacesContext.getCurrentInstance().addMessage(null, mensaje);
                RequestContext.getCurrentInstance().execute("ModEmpSup.hide()");
            }catch(Exception e){
                System.out.println(e.getMessage());
                                FacesMessage mensaje =
                                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un Error" + e.getMessage());
                                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        //}
        
    } 
    
}
