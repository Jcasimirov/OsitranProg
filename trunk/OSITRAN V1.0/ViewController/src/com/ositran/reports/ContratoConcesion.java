package com.ositran.reports;

import com.ositran.vo.bean.ReporteContratoConcesionVO;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.serviceimpl.ReporteContratoConcesionServiceImpl;
import com.ositran.util.ReportesJDBC;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import com.ositran.vo.bean.ModalidadConcesionVO;

import com.ositran.vo.bean.ReporteEmpresaSupervisoraVO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;

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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.component.UISelectItem;
import javax.faces.component.html.HtmlForm;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;

import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.apache.lucene.util.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Workbook;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_reports_contratoConcesion")
@RequestScoped
@Generated(value = "1ositran/reports/contratoConcesion.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class ContratoConcesion {
    private HtmlForm formContratoConcesion;
    private PanelGrid pnlgContratoConcesion;
    private OutputLabel lblTipoInfraestructura;
    private OutputLabel lblConcesion;
    private OutputLabel lblModalidad;
    private SelectOneMenu selectTipoInfraestructura;
    private SelectOneMenu selectConcesion;
    private SelectOneMenu selectModalidad;
    private CommandButton cmbGenerar;
    private String tipoInfraestructura;
    List<SelectItem> tipoInfraestructuraSelectItems = new ArrayList<SelectItem>();
    private String concesion;
    List<SelectItem> concesionSelectItems = new ArrayList<SelectItem>();
    private String modalidadConcesion;
    List<SelectItem> modalidadConcesionSelectItems = new ArrayList<SelectItem>();
    private UISelectItem selectItemTipoInfraestructura;
    private UISelectItem selectItemConcesion;
    private UISelectItem selectItemModalidad;


    public void setModalidadConcesion(String modalidadConcesion) {
        this.modalidadConcesion = modalidadConcesion;
    }

    public String getModalidadConcesion() {
        return modalidadConcesion;
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

    public void setFormContratoConcesion(HtmlForm formContratoConcesion) {
        this.formContratoConcesion = formContratoConcesion;
    }

    public HtmlForm getFormContratoConcesion() {
        return formContratoConcesion;
    }

    public void setPnlgContratoConcesion(PanelGrid pnlgContratoConcesion) {
        this.pnlgContratoConcesion = pnlgContratoConcesion;
    }

    public PanelGrid getPnlgContratoConcesion() {
        return pnlgContratoConcesion;
    }

    public void setLblTipoInfraestructura(OutputLabel outputLabel1) {
        this.lblTipoInfraestructura = outputLabel1;
    }

    public OutputLabel getLblTipoInfraestructura() {
        return lblTipoInfraestructura;
    }

    public void setLblConcesion(OutputLabel outputLabel3) {
        this.lblConcesion = outputLabel3;
    }

    public OutputLabel getLblConcesion() {
        return lblConcesion;
    }

    public void setLblModalidad(OutputLabel outputLabel4) {
        this.lblModalidad = outputLabel4;
    }

    public OutputLabel getLblModalidad() {
        return lblModalidad;
    }

    public void setSelectTipoInfraestructura(SelectOneMenu selectOneMenu4) {
        this.selectTipoInfraestructura = selectOneMenu4;
    }

    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
    }

    public void setSelectConcesion(SelectOneMenu selectOneMenu1) {
        this.selectConcesion = selectOneMenu1;
    }

    public SelectOneMenu getSelectConcesion() {
        return selectConcesion;
    }

    public void setSelectModalidad(SelectOneMenu selectOneMenu5) {
        this.selectModalidad = selectOneMenu5;
    }

    public SelectOneMenu getSelectModalidad() {
        return selectModalidad;
    }

    public void setCmbGenerar(CommandButton commandButton2) {
        this.cmbGenerar = commandButton2;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
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

    private List<InfraestructuraTipoVO> listaInfraestructura=new ArrayList<InfraestructuraTipoVO>();;

    public List<InfraestructuraTipoVO> listarInfraestructura() throws SQLException {
        try {
            listaInfraestructura = getInfraestructuraTipoServiceImpl().query1();
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
        tipoInfraestructuraSelectItems.add(new SelectItem("0", "Seleccione"));
        List<InfraestructuraTipoVO> lista = listarInfraestructura();
        int i = 0;
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


    public List<ConcesionVO> listarConcesion() throws SQLException {
        List<ConcesionVO> list = this.concesionServiceImpl.listarConcesiones();
        return list;
    }


    /**
     * @author Paul Rivera
     * @return concesion para que se renderize en el combo
     */
    public List<SelectItem> getConcesionSelectItems() throws SQLException {
        concesionSelectItems.add(new SelectItem("0", "Seleccione"));
        List<ConcesionVO> lista = listarConcesion();
        int i = 0;
        for (ConcesionVO cvo : lista) {
            concesionSelectItems.add(new SelectItem(cvo.getCsiId(), String.valueOf(cvo.getCsiNombre())));
            //concesionSelectItems.add(new SelectItem(i++, String.valueOf(cvo.getCsiNombre())));
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

    private ModalidadConcesionServiceImpl modalidadConcesionServiceImpl = new ModalidadConcesionServiceImpl();
    public ModalidadConcesionVO modalidadConcesionVO = new ModalidadConcesionVO();

    public void setModalidadConcesionServiceImpl(ModalidadConcesionServiceImpl modalidadConcesionServiceImpl) {
        this.modalidadConcesionServiceImpl = modalidadConcesionServiceImpl;
    }

    public void setModalidadConcesionVO(ModalidadConcesionVO modalidadConcesionVO) {
        this.modalidadConcesionVO = modalidadConcesionVO;
    }

    public ModalidadConcesionVO getModalidadConcesionVO() {
        return modalidadConcesionVO;
    }


    public List<ModalidadConcesionVO> listarModalidadConcesion() throws SQLException {
        List<ModalidadConcesionVO> list = this.modalidadConcesionServiceImpl.query1();
        return list;
    }

    /**
     * @author Paul Rivera
     * @return modalidad para que se renderize en el combo
     */
    public List<SelectItem> getModalidadConcesionSelectItems() throws SQLException {
        modalidadConcesionSelectItems.add(new SelectItem("0", "Seleccione"));
        List<ModalidadConcesionVO> lista = listarModalidadConcesion();
        ///int i=0;
        for (ModalidadConcesionVO mcvo : lista) {
            modalidadConcesionSelectItems.add(new SelectItem(mcvo.getMcoId(), String.valueOf(mcvo.getMcoNombre())));
        }
        return modalidadConcesionSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return modalidad seleccionado del combo
     */
    public String getSelectedModalidad() {
        if ("".equals(getModalidadConcesion()) || getModalidadConcesion() == null) {
            return "";
        } else {
            return getModalidadConcesion();
        }
    }


    private ReporteContratoConcesionVO contratoConcesionVO = new ReporteContratoConcesionVO();
    private ReporteContratoConcesionServiceImpl reporteContratoConcesionServiceImpl =
        new ReporteContratoConcesionServiceImpl();

    public void setContratoConcesionVO(ReporteContratoConcesionVO contratoConcesionVO) {
        this.contratoConcesionVO = contratoConcesionVO;
    }

    public ReporteContratoConcesionVO getContratoConcesionVO() {
        return contratoConcesionVO;
    }

    public void setReporteContratoConcesionServiceImpl(ReporteContratoConcesionServiceImpl reporteContratoConcesionServiceImpl) {
        this.reporteContratoConcesionServiceImpl = reporteContratoConcesionServiceImpl;
    }

    public ReporteContratoConcesionServiceImpl getReporteContratoConcesionServiceImpl() {
        return reporteContratoConcesionServiceImpl;
    }

    private List<ReporteContratoConcesionVO> listaReporteContratoConcesion;

    public boolean validarCampos() {
        if ((this.selectTipoInfraestructura.getValue().equals(null)) ||
            (this.selectTipoInfraestructura.getValue().equals(""))||(this.selectTipoInfraestructura.getValue().toString().equalsIgnoreCase("0"))) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese el tipo de infraestructura.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return false;
        } else if ((this.selectConcesion.getValue().equals(null)) || (this.selectConcesion.getValue().equals(""))||(this.selectConcesion.getValue().toString().equalsIgnoreCase("0"))) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese la concesión.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return false;
        } else if ((this.selectModalidad.getValue().equals(null)) || (this.selectModalidad.getValue().equals(""))||(this.selectModalidad.getValue().toString().equalsIgnoreCase("0"))) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese la modalidad.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return false;
        } else {
            return true;
        }
    }


    public List<ReporteContratoConcesionVO> generarExcel() throws SQLException, Exception {
        System.out.println("======================");
        System.out.println("METODO DESCARGA EXCEL");
        System.out.println("======================");
        if (validarCampos()) {
            System.out.println("tipoInfraestructuraStr: " + selectTipoInfraestructura.getValue());
            System.out.println("itemConcesionStr: " + selectConcesion.getValue());
            System.out.println("itemModalidadStr: " + selectModalidad.getValue());
            String tinID = (String) selectTipoInfraestructura.getValue();
            String csiID = (String) selectConcesion.getValue();
            String mcoModalidad = (String) selectModalidad.getValue();
            try {
                listaReporteContratoConcesion =
                    getReporteContratoConcesionServiceImpl().generarReporteContratoConcesion(tinID, csiID,
                                                                                             mcoModalidad);
                if (listaReporteContratoConcesion != null) {
                    ReporteContratoConcesionVO reporte = listaReporteContratoConcesion.get(0);
                    HSSFWorkbook libro = new HSSFWorkbook();
                    HSSFSheet hoja = libro.createSheet("Contrato Concesion");
                    HSSFRow fila = hoja.createRow(0);
                    HSSFCell celda = fila.createCell((short) 0);
                    HSSFRichTextString texto = new HSSFRichTextString("REPORTE DE CONTRATO DE CONCESIÓN");
                    celda.setCellValue(texto);
                    
                    Row rowHeader = hoja.createRow(3);
                    rowHeader.createCell(0).setCellValue("Concesión");
                    rowHeader.createCell(1).setCellValue("Concesionario");
                    rowHeader.createCell(2).setCellValue("Tipo de Infraestructura");
                    rowHeader.createCell(3).setCellValue("Modalidad");
                    rowHeader.createCell(4).setCellValue("Fecha de Suscripción del Contrato");
                    rowHeader.createCell(5).setCellValue("Plazo de Concesión");
                    rowHeader.createCell(6).setCellValue("Tipo Doc.");
                    rowHeader.createCell(7).setCellValue("Fecha");
                    rowHeader.createCell(8).setCellValue("Objeto");
                    rowHeader.createCell(9).setCellValue("Período/Etapa");
                    rowHeader.createCell(10).setCellValue("Alcance");
                    rowHeader.createCell(11).setCellValue("Tipo de Inversión");
                    rowHeader.createCell(12).setCellValue("Moneda");
                    rowHeader.createCell(12).setCellValue("Total Compromiso");

                    for (int i = 4; i < 4 + listaReporteContratoConcesion.size(); i++) {
                        Row row = hoja.createRow(i);
                        int j = 0;
                        row.createCell(j++).setCellValue(reporte.getCsiNombre().toString());
                        row.createCell(j++).setCellValue(reporte.getCncNombre());
                        row.createCell(j++).setCellValue(reporte.getTinNombre());
                        row.createCell(j++).setCellValue(reporte.getMcoNombreModalidad());
                        row.createCell(j++).setCellValue(reporte.getConFechaSuscripcion());
                        row.createCell(j++).setCellValue(reporte.getConPlazoConcesion());
                        row.createCell(j++).setCellValue(reporte.getTadTipoDocumento());
                        row.createCell(j++).setCellValue(reporte.getCadFecha());
                        row.createCell(j++).setCellValue(reporte.getCadDescripcion());
                        row.createCell(j++).setCellValue(reporte.getCcoPeriodo());
                        row.createCell(j++).setCellValue(reporte.getCcoAlcance());
                        row.createCell(j++).setCellValue(reporte.getTivNomTipoInversion());
                        row.createCell(j++).setCellValue(reporte.getMonMoneda().toString());
                        row.createCell(j++).setCellValue(reporte.getCcoTotal());
                    }

                    String fileName = "reporte_contrato_concesion.xls";
                    File f = new File(fileName);
                    FileOutputStream elFichero = new FileOutputStream(fileName);
                    libro.write(elFichero);
                    elFichero.close();
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ExternalContext ectx = ctx.getExternalContext();
                    HttpServletResponse response = (HttpServletResponse) ectx.getResponse();
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "inline; filename=" + fileName);
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
        return listaReporteContratoConcesion;
    }

    public List<ReporteContratoConcesionVO> generarPDF() throws SQLException, Exception {
        System.out.println("======================");
        System.out.println("METODO DESCARGA PDF");
        System.out.println("======================");
        if (validarCampos()) {
            System.out.println("tipoInfraestructuraStr: " + selectTipoInfraestructura.getValue());
            System.out.println("itemConcesionStr: " + selectConcesion.getValue());
            System.out.println("itemModalidadStr: " + selectModalidad.getValue());
            String tinID = (String) selectTipoInfraestructura.getValue();
            String csiID = (String) selectConcesion.getValue();
            String mcoModalidad = (String) selectModalidad.getValue();
            try {
                listaReporteContratoConcesion =
                    getReporteContratoConcesionServiceImpl().generarReporteContratoConcesion(tinID, csiID,
                                                                                             mcoModalidad);
                
                
                if (listaReporteContratoConcesion != null) {
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ExternalContext ectx = ctx.getExternalContext();

                    String contratoConcesionMaster="\\reportes\\reporteContratoConcesionMaster.jasper";
                    String imagenLogo = "\\reportes\\logo.jpg";
                    String contratoConcesionDetail = "\\reportes\\";

                    Map parameters = new HashMap();
                    parameters.put("NVO_NO", 1);
                    parameters.put("P_TIP_INFRA", tinID);
                    parameters.put("P_CONCESION", csiID);
                    parameters.put("P_MODALIDAD", mcoModalidad);
                    parameters.put("LOGO", ectx.getRealPath(imagenLogo));
                    parameters.put("SUBREPORT_DIR", ectx.getRealPath(contratoConcesionDetail)+ "\\");
                    System.out.println("logo"+ectx.getRealPath(imagenLogo));
                    System.out.println("contratoConcesionDetail servidor: " + ectx.getRealPath(contratoConcesionDetail));
                    Connection conn = ReportesJDBC.getConnection();
                    byte[] bytes = JasperRunManager.runReportToPdf(ectx.getRealPath(contratoConcesionMaster), parameters, conn);
                    JRPdfExporter pdfExporter = new JRPdfExporter();    
                    JasperPrint print = JasperFillManager.fillReport(ectx.getRealPath(contratoConcesionMaster),parameters,conn);
                    pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "file.file");
                    pdfExporter.exportReport();
                    HttpServletResponse response = (HttpServletResponse) ectx.getResponse();
                    response.addHeader("Content-disposition", "attachment;filename=Reporte_de_Contrato_de_Concesión.pdf");
                    response.setContentType("application/pdf");
                    response.setContentLength(bytes.length);
                    ServletOutputStream ouputStream = response.getOutputStream();
                    ouputStream.write(bytes, 0, bytes.length);
                    ouputStream.flush();
                    ouputStream.close();
                    ctx.responseComplete();                    
                }else{
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "La lista no tiene registros.");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);                    
                }              
  
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace() ;
            }
        }
        return listaReporteContratoConcesion;
    }

    public void setSelectedTipoInfraestructura(String str) {
        this.tipoInfraestructura = str;
    }

    public void setSelectedConcesion(String str) {
        this.concesion = str;
    }

    public void setSelectedModalidad(String str) {
        this.modalidadConcesion = str;
    }

    public void setSelectItemTipoInfraestructura(UISelectItem selectItem1) {
        this.selectItemTipoInfraestructura = selectItem1;
    }

    public UISelectItem getSelectItemTipoInfraestructura() {
        return selectItemTipoInfraestructura;
    }

    public void setSelectItemConcesion(UISelectItem selectItem1) {
        this.selectItemConcesion = selectItem1;
    }

    public UISelectItem getSelectItemConcesion() {
        return selectItemConcesion;
    }

    public void setSelectItemModalidad(UISelectItem selectItem1) {
        this.selectItemModalidad = selectItem1;
    }

    public UISelectItem getSelectItemModalidad() {
        return selectItemModalidad;
    }
}
