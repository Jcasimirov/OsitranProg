package com.ositran.reports;

import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ReporteEmpresaSupervisoraServiceImpl;
import com.ositran.util.ReportesJDBC;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import com.ositran.vo.bean.ReporteEmpresaSupervisoraVO;

import java.io.FileOutputStream;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Generated;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.component.UISelectItem;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import net.sf.jasperreports.export.SimpleExporterInput;

import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;


@ManagedBean(name = "backing_ositran_reports_empresaSupervisora")
@RequestScoped
@Generated(value = "1ositran/reports/empresaSupervisora.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class EmpresaSupervisora extends HttpServlet {
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
    private CommandButton cmbGenerarAcrobatReaderPDF;
    private String tipoInfraestructura;
    List<SelectItem> tipoInfraestructuraSelectItems;
    private String concesion;
    List<SelectItem> concesionSelectItems;
    private String estado;
    List<SelectItem> estadoSelectItems;

    private HtmlCommandButton commandButton1;

    private String reporteEmpresaSupervisora;
    private CommandButton cmbGenerarMSExcel;
    private CommandButton cmbLimpiar;
    private UISelectItem selectItemConcesion;
    private UISelectItem selectItemTipoInfraestructura;
    private UISelectItem selectItemEstado;


    public EmpresaSupervisora() {
        super();
        tipoInfraestructuraSelectItems = new ArrayList<SelectItem>();
        concesionSelectItems = new ArrayList<SelectItem>();
        estadoSelectItems = new ArrayList<SelectItem>();
    }


    public String getReporteEmpresaSupervisora() {
        return reporteEmpresaSupervisora;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setConcesion(String concesion) {
        this.concesion = concesion;
    }

    public String getConcesion() {
        return concesion;
    }

    public void setTipoInfraestructura(String tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public String getTipoInfraestructura() {
        return tipoInfraestructura;
    }


    public void setFormSupervisora(HtmlForm formSupervisora) {
        this.formSupervisora = formSupervisora;
    }

    public HtmlForm getFormSupervisora() {
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

    public void setCmbGenerarAcrobatReaderPDF(CommandButton commandButton2) {
        this.cmbGenerarAcrobatReaderPDF = commandButton2;
    }

    public CommandButton getCmbGenerarAcrobatReaderPDF() {
        return cmbGenerarAcrobatReaderPDF;
    }


    private InfraestructuraTipoVO infraestructuraTipoVO = new InfraestructuraTipoVO();

    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl = new InfraestructuraTipoServiceImpl();


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

    private List<InfraestructuraTipoVO> listaInfraestructura=new ArrayList<InfraestructuraTipoVO>();
    

    public List<InfraestructuraTipoVO> listarInfraestructura() throws SQLException {
        try {
            listaInfraestructura = getInfraestructuraTipoServiceImpl().query1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaInfraestructura;
    }
    
    /*
    private List<String> listaInfraestructuraStrings=new ArrayList<String>();
    public List<String> getListarInfraestructuraStr() throws SQLException {
        try {
            listaInfraestructuraStrings = (String)getInfraestructuraTipoServiceImpl().query1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaInfraestructura;
    }*/


    /**
     * @author Paul Rivera
     * @return tipo de infraestructura para que se renderize en el combo
     */
    public List<SelectItem> getTipoInfraestructuraSelectItems() throws SQLException {
        tipoInfraestructuraSelectItems.add(new SelectItem("0", "Seleccione"));
        List<InfraestructuraTipoVO> lista = listarInfraestructura();
        for (InfraestructuraTipoVO ivo : lista) {
            tipoInfraestructuraSelectItems.add(new SelectItem(ivo.getTinId(), String.valueOf(ivo.getTinNombre())));
        }
        return tipoInfraestructuraSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return tipo de infraestructura seleccionado del combo
     */
    public String getSelectedTipoInfraestructura() {
        if ("".equals(getTipoInfraestructura()) || getTipoInfraestructura() == null) {
            return "";
        } else {
            return getTipoInfraestructura();
        }
    }

    public void setSelectedTipoInfraestructura(String str) {
        this.tipoInfraestructura = str;
    }

    public void setSelectedConcesion(String str) {
        this.concesion = str;
    }

    public void setSelectedEstado(String str) {
        this.estado = str;
    }

    public void setSelectedReporteEmpresaSupervisora(String str) {
        this.reporteEmpresaSupervisora = str;
    }

    //@ManagedProperty(value = "#{concesionServiceImpl}")
    private ConcesionServiceImpl concesionServiceImpl = new ConcesionServiceImpl();
    public ConcesionVO concesionVO = new ConcesionVO();

    public void setConcesionServiceImpl(ConcesionServiceImpl concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionarioVO() {
        return concesionVO;
    }

    private List<ConcesionVO> listaConcesion=new ArrayList<ConcesionVO>();

    public List<ConcesionVO> listarConcesion() throws SQLException {
        listaConcesion = this.concesionServiceImpl.listarConcesiones();
        return listaConcesion;
    }


    /**
     * @author Paul Rivera
     * @return concesion para que se renderize en el combo
     */
    public List<SelectItem> getConcesionSelectItems() throws SQLException {
        concesionSelectItems.add(new SelectItem("0", "Seleccione"));
        List<ConcesionVO> lista = listarConcesion();
        ///int i=1;
        if (lista != null) {
            for (ConcesionVO cvo : lista) {
                concesionSelectItems.add(new SelectItem(cvo.getCsiId(), String.valueOf(cvo.getCsiNombre())));
                ///concesionSelectItems.add(new SelectItem(i++, String.valueOf(cvo.getCsiNombre())));
            }
        }
        return concesionSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return concesion seleccionado del combo
     */
    public String getSelectedConcesion() {
        if ("".equals(getConcesion()) || getConcesion() == null) {
            return "";
        } else {
            return getConcesion();
        }
    }

    /**
     * @author Paul Rivera
     * @return lista de estados para que se renderize en el combo
     */
    public List<SelectItem> getEstadoSelectItems() {
        estadoSelectItems.add(new SelectItem("0", "Seleccione"));
        String[] reporte = new String[2];
        reporte[0] = "Inactivo";
        reporte[1] = "Activo";
        //reporte[2]="Todos";
        if (reporte != null) {
            for (int i = 0; i < reporte.length; i++) {
                estadoSelectItems.add(new SelectItem(i, String.valueOf(reporte[i])));
            }
        }
        return estadoSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return estado seleccionado del combo
     */
    public String getSelectedEstado() {
        if ("".equals(getEstado()) || getEstado() == null) {
            return "";
        } else {
            return getEstado();
        }
    }
    public List<AnidadoEstado> listarEstados() throws SQLException {
        String[] estado = new String[2];
        estado[0] = "Inactivo";
        estado[1] = "Activo";
        List<AnidadoEstado> listaEstados=new ArrayList<AnidadoEstado>();
        for (int i = 0; i < estado.length; i++) {
            AnidadoEstado anidadoEstado=new AnidadoEstado();
            if(i==0){
                anidadoEstado.setId(2);
            }else{
                anidadoEstado.setId(i);
            }
            anidadoEstado.setNombre(estado[i]);
            listaEstados.add(anidadoEstado);
        }
        return listaEstados;
    }

    public void setTipoInfraestructuraSelectItems(List<SelectItem> tipoInfraestructuraSelectItems) {
        this.tipoInfraestructuraSelectItems = tipoInfraestructuraSelectItems;
    }

    public void setEstadoSelectItems(List<SelectItem> estadoSelectItems) {
        this.estadoSelectItems = estadoSelectItems;
    }


    private ReporteEmpresaSupervisoraVO empresaSupervisoraVO = new ReporteEmpresaSupervisoraVO();

    private ReporteEmpresaSupervisoraServiceImpl reporteEmpresaSupervisoraServiceImpl =
        new ReporteEmpresaSupervisoraServiceImpl();

    public void setEmpresaSupervisoraVO(ReporteEmpresaSupervisoraVO empresaSupervisoraVO) {
        this.empresaSupervisoraVO = empresaSupervisoraVO;
    }

    public ReporteEmpresaSupervisoraVO getEmpresaSupervisoraVO() {
        return empresaSupervisoraVO;
    }

    public void setReporteEmpresaSupervisoraServiceImpl(ReporteEmpresaSupervisoraServiceImpl reporteEmpresaSupervisoraServiceImpl) {
        this.reporteEmpresaSupervisoraServiceImpl = reporteEmpresaSupervisoraServiceImpl;
    }

    public ReporteEmpresaSupervisoraServiceImpl getReporteEmpresaSupervisoraServiceImpl() {
        return reporteEmpresaSupervisoraServiceImpl;
    }

    private List<ReporteEmpresaSupervisoraVO> listaReporteEmpresaSupervisora;

    public boolean validarCampos() {
        if ((this.selectTipoInfraestructura.getValue().equals(null)) ||
			(this.selectTipoInfraestructura.getValue().equals("")) ||(this.selectTipoInfraestructura.getValue().toString().equalsIgnoreCase("0"))) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese el tipo de infraestructura.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            tipoInfraestructuraSelectItems.removeAll(this.listaInfraestructura);
            return false;
        } else if ((this.selectConcesion.getValue().equals(null)) || (this.selectConcesion.getValue().equals(""))||
				   (this.selectConcesion.getValue().toString().equalsIgnoreCase("0"))) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese la concesión.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return false;
        } else if ((this.selectEstado.getValue().equals(null)) || (this.selectEstado.getValue().equals(""))||
			(this.selectEstado.getValue().toString().equalsIgnoreCase("0"))) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese el estado.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return false;
        } else if ((this.calendarFecIni.getValue() == null) || (this.calendarFecIni.getValue().equals(""))) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese la fecha de inicio.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return false;
        } else if ((this.calendarFecFin.getValue() == null) || (this.calendarFecFin.getValue().equals(""))) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese la fecha final.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return false;
        } else {
            return true;
        }
    }

    public List<ReporteEmpresaSupervisoraVO> generarExcel() {
        System.out.println("======================");
        System.out.println("METODO DESCARGA EXCEL");
        System.out.println("======================");
        if (validarCampos()) {
            System.out.println("tipoInfraestructuraStr: " + selectTipoInfraestructura.getValue());
            System.out.println("itemConcesionStr: " + selectConcesion.getValue());
            System.out.println("itemEstadoStr: " + selectEstado.getValue());
            System.out.println("fechaInicio: " + calendarFecIni.getValue());
            System.out.println("fechaFin: " + calendarFecFin.getValue());
            String tinID = (String) selectTipoInfraestructura.getValue();
            String csiID = (String) selectConcesion.getValue();
            String supESTADO = (String) selectEstado.getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecIni = sdf.format(calendarFecIni.getValue());
            String fecFin = sdf.format(calendarFecFin.getValue());
            System.out.println("fecIni = " + fecIni);
            System.out.println("fecFin = " + fecFin);
            try {
                listaReporteEmpresaSupervisora =
                    getReporteEmpresaSupervisoraServiceImpl().generarReporteEmpresaSupervisora(tinID, csiID, supESTADO,
                                                                                               fecIni, fecFin);

                if (listaReporteEmpresaSupervisora != null) {
                    ReporteEmpresaSupervisoraVO reporte = listaReporteEmpresaSupervisora.get(0);
                    HSSFWorkbook libro = new HSSFWorkbook();
                    HSSFSheet hoja = libro.createSheet("Empresa Supervisora");
                    HSSFRow fila = hoja.createRow(0);
                    HSSFCell celda = fila.createCell((short) 0);
                    HSSFRichTextString texto = new HSSFRichTextString("REPORTE DE EMPRESA SUPERVISORA");
                    celda.setCellValue(texto);

                    Row rowHeader = hoja.createRow(3);
                    rowHeader.createCell(0).setCellValue("Nombre");
                    rowHeader.createCell(1).setCellValue("Direccion");
                    rowHeader.createCell(2).setCellValue("Correo");
                    rowHeader.createCell(3).setCellValue("Siglas");
                    rowHeader.createCell(4).setCellValue("Representante Legal");
                    rowHeader.createCell(5).setCellValue("Jefe de Supervisión");
                    rowHeader.createCell(6).setCellValue("Fecha de Suscripción");
                    rowHeader.createCell(7).setCellValue("Modalidad");
                    rowHeader.createCell(8).setCellValue("Fecha de Inicio de Supervisión");
                    rowHeader.createCell(9).setCellValue("Fecha de Fin de Supervisión");
                    rowHeader.createCell(10).setCellValue("Tipo de Infraestructura");
                    rowHeader.createCell(11).setCellValue("Monto Contratado");
                    rowHeader.createCell(12).setCellValue("Concesión");

                    for (int i = 4; i < 4 + listaReporteEmpresaSupervisora.size(); i++) {
                        Row row = hoja.createRow(i);
                        int j = 0;
                        row.createCell(j++).setCellValue(reporte.getSupNombre().toString());
                        row.createCell(j++).setCellValue(reporte.getSupDireccion());
                        row.createCell(j++).setCellValue(reporte.getSupCorreo());
                        row.createCell(j++).setCellValue(reporte.getSupSiglas());
                        row.createCell(j++).setCellValue(reporte.getSupRepresentanteLegal());
                        row.createCell(j++).setCellValue(reporte.getSupJefeSupervision());
                        row.createCell(j++).setCellValue(reporte.getCpsFechaSuscripcion());
                        row.createCell(j++).setCellValue(reporte.getMcoNombre());
                        row.createCell(j++).setCellValue(reporte.getCpsFechaInicio());
                        row.createCell(j++).setCellValue(reporte.getCpsPlazoContrato());
                        row.createCell(j++).setCellValue(reporte.getTinNombre());
                        row.createCell(j++).setCellValue(reporte.getCpsMontoContratado());
                        row.createCell(j++).setCellValue(reporte.getCsiNombre().toString());
                    }

                    FileOutputStream elFichero = new FileOutputStream("reporte_empresa_supervisora.xls");
                    libro.write(elFichero);
                    elFichero.close();
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ExternalContext ectx = ctx.getExternalContext();
                    HttpServletResponse response = (HttpServletResponse) ectx.getResponse();
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "inline; filename=" + "reporte_empresa_supervisora.xls");
                    try {
                        ServletOutputStream outputStream = response.getOutputStream();
                        hoja.getWorkbook().write(outputStream);
                        outputStream.flush();
                        outputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "La lista no tiene registros.");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaReporteEmpresaSupervisora;
    }

    public List<ReporteEmpresaSupervisoraVO> generarPDF() throws SQLException, Exception, JRException {
        if (validarCampos()) {
            String tinID = (String) selectTipoInfraestructura.getValue();
            String csiID = (String) selectConcesion.getValue();
            String supESTADO = (String) selectEstado.getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecIni = sdf.format(calendarFecIni.getValue());
            String fecFin = sdf.format(calendarFecFin.getValue());
            try {
                listaReporteEmpresaSupervisora =
                    getReporteEmpresaSupervisoraServiceImpl().generarReporteEmpresaSupervisora(tinID, csiID, supESTADO,
                                                                                               fecIni, fecFin);
                if (listaReporteEmpresaSupervisora != null) {
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ExternalContext ectx = ctx.getExternalContext();

                    String empresaSupervisoraMaster = "\\reportes\\reporteEmpresaSupervisoraMaster.jasper";
                    String imagenLogo = "\\reportes\\logo.jpg";
                    String empresaSupervisoraDetail = "\\reportes\\";

                    Map parameters = new HashMap();
                    parameters.put("INV_NO", 1);
                    parameters.put("TIP_INFRA", tinID);
                    parameters.put("CONCESION", csiID);
                    parameters.put("ESTADO", supESTADO);
                    parameters.put("FEC_INI", fecIni);
                    parameters.put("FEC_FIN", fecFin);
                    parameters.put("LOGO", ectx.getRealPath(imagenLogo));
                    parameters.put("SUBREPORT_DIR", ectx.getRealPath(empresaSupervisoraDetail)+ "\\");
                    System.out.println("logo"+ectx.getRealPath(imagenLogo));
                    System.out.println("empresaSupervisoraDetail servidor: " + ectx.getRealPath(empresaSupervisoraDetail));
                    Connection conn = ReportesJDBC.getConnection();
                    byte[] bytes =
                        JasperRunManager.runReportToPdf(ectx.getRealPath(empresaSupervisoraMaster), parameters, conn);
                    JRPdfExporter pdfExporter = new JRPdfExporter();    
                    JasperPrint print = JasperFillManager.fillReport(ectx.getRealPath(empresaSupervisoraMaster),parameters,conn);
                    pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "file.file");
                    pdfExporter.exportReport();
                    HttpServletResponse response = (HttpServletResponse) ectx.getResponse();
                    response.addHeader("Content-disposition", "attachment;filename=Reporte_de_Empresa_Supervisora.pdf");
                    response.setContentType("application/pdf");
                    response.setContentLength(bytes.length);
                    ServletOutputStream ouputStream = response.getOutputStream();
                    ouputStream.write(bytes, 0, bytes.length);
                    ouputStream.flush();
                    ouputStream.close();
                    ctx.responseComplete();
                } else {
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "La lista no tiene registros.");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);                    
                }                
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaReporteEmpresaSupervisora;
    }

    public void setCommandButton1(HtmlCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public HtmlCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setCmbGenerarMSExcel(CommandButton commandButton2) {
        this.cmbGenerarMSExcel = commandButton2;
    }

    public CommandButton getCmbGenerarMSExcel() {
        return cmbGenerarMSExcel;
    }

    public void setCmbLimpiar(CommandButton commandButton2) {
        this.cmbLimpiar = commandButton2;
    }

    public CommandButton getCmbLimpiar() {
        return cmbLimpiar;
    }

    public void setSelectItemConcesion(UISelectItem selectItem1) {
        this.selectItemConcesion = selectItem1;
    }

    public UISelectItem getSelectItemConcesion() {
        return selectItemConcesion;
    }

    public void setSelectItemTipoInfraestructura(UISelectItem selectItem1) {
        this.selectItemTipoInfraestructura = selectItem1;
    }

    public UISelectItem getSelectItemTipoInfraestructura() {
        return selectItemTipoInfraestructura;
    }

    public void setSelectItemEstado(UISelectItem selectItem1) {
        this.selectItemEstado = selectItem1;
    }

    public UISelectItem getSelectItemEstado() {
        return selectItemEstado;
    }
}
