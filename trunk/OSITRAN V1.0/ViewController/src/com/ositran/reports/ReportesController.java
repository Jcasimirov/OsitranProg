package com.ositran.reports;

/*
 * Clase: ReportesController
 * Descripcion: Esta clase controla todos los reportes generados por las diferentes opciones de la web
 * Autor: E. Alfredo Panitz R.
 * Fecha: 30/04/2015
 */
import javax.faces.event.ActionEvent;
import com.ositran.model.reportes.*;
import com.ositran.service.reportes.ReportesService;
import com.ositran.serviceimpl.reportes.ReportesServiceImpl;
import com.ositran.util.reportes.AvaInvConConcDataSource;
import com.ositran.util.reportes.AvaInvRecConConcDataSource;
import com.ositran.util.reportes.ControlPlazosFlujoValorizacionesEmpresaSupervisoraDataSource;
import com.ositran.util.reportes.ControlPlazosFlujoValorizacionesInversionesDataSource;
import com.ositran.util.reportes.EmpSupInfAeropuertoDataSource;
import com.ositran.util.reportes.EmpSupInfDataSource;

import com.ositran.util.reportes.InversionesTipoConceptoDataSource;

import com.ositran.util.reportes.InversionesTipoConceptoDetalleDataSource;

import com.ositran.util.reportes.TrazabilidadPrincipalesEventosDataSource;

import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@ManagedBean(name = "backing_ositran_reports_reportesController")
@RequestScoped
@Component
public class ReportesController {

    JasperPrint jasperPrint;
    int bit;
    File reportFile;
    InputStream in;
    
    String paramUno="";

    public String getValuesControlView(String nameControl) throws Exception {
        System.out.println("BUSCANDO EXP = "+nameControl);
        FacesContext fc = FacesContext.getCurrentInstance();
        String value = fc.getExternalContext().getRequestParameterMap().get(nameControl);
        System.out.println("VALOR SELECCIONADO = "+value);
        return value;
    }
    
    public String getValuesControlSelectOneMenuView(String nameControl) throws Exception {
        System.out.println("SO BUSCANDO EXP = "+nameControl);
        FacesContext context = FacesContext.getCurrentInstance();
        String value = context.getApplication().evaluateExpressionGet(context, nameControl, String.class);
        System.out.println("SO VALOR SELECCIONADO = "+value);
        return value;
    }
   

    public JRDataSource getDataSource(String nomEntidad, String tipoReporte) throws Exception {
        ReportesServiceImpl reportesSrv = new ReportesServiceImpl();

        if (nomEntidad.equals("empresaSupervisoraVSInfraestructura")) {
            EmpSupInfDataSource dataSource = new EmpSupInfDataSource();
            dataSource.setListadoEmpSupInf(reportesSrv.getEmpresaSupervisoraVsInfraestructura(Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_empresaSupervisoraVSInfraestructura.tipoInfraestructura}")),
                                                                                              Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_empresaSupervisoraVSInfraestructura.concesion}")),
                                                                                              Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_empresaSupervisoraVSInfraestructura.empresaSupervisora}"))));
            return dataSource;
        } else if (nomEntidad.equals("avanceInvContratosConcesion")) {
            AvaInvConConcDataSource dataSource = new AvaInvConConcDataSource();
            dataSource.setDatos(reportesSrv.getAvanceInversionesContratosConcesion(Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_avanceInvContratosConcesion.annio}")),
                                                                                   Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_avanceInvContratosConcesion.mes}")),
                                                                                   Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_avanceInvContratosConcesion.tipoInfraestructura}")),
                                                                                   Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_avanceInvContratosConcesion.concesion}")),
                                                                                   Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_avanceInvContratosConcesion.modalidad}"))));
            return dataSource;
        }else if (nomEntidad.equals("invPorTipoConcepto")) {
            InversionesTipoConceptoDataSource dataSource = new InversionesTipoConceptoDataSource();
            dataSource.setDatos(reportesSrv.getInversionesTipoConcepto(Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_invPorTipoConcepto.annio}")),
                                                                                   Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_invPorTipoConcepto.mes}")),
                                                                                   Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_invPorTipoConcepto.tipoInfraestructura}")),
                                                                                   Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_invPorTipoConcepto.concesion}")),
                                                                                   Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_invPorTipoConcepto.conceptoInversion}"))));
            return dataSource;
        }else if (nomEntidad.equals("empresaSupervisoraVSInfraestructuraAeropuertos")) {
            EmpSupInfAeropuertoDataSource dataSource = new EmpSupInfAeropuertoDataSource();
            dataSource.setDatos(reportesSrv.getEmpresaSupervisoraVsInfraestructuraAeropuerto(Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_empresaSupervisoraVSInfraestructura.tipoInfraestructura}")),
                                                                                              Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_empresaSupervisoraVSInfraestructura.concesion}")),
                                                                                              Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_empresaSupervisoraVSInfraestructura.empresaSupervisora}"))));
            return dataSource;
        } else if (nomEntidad.equals("trazabilidadPrincipalesEventos")) {
            TrazabilidadPrincipalesEventosDataSource dataSource = new TrazabilidadPrincipalesEventosDataSource();
            dataSource.setDatos(reportesSrv.getTrazabilidadPrincipalesEventos(Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_trazabilidadPrincipalesEventos.tipoInfraestructura}")),
                                                                                              Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_trazabilidadPrincipalesEventos.annio}")),
                                                                                              Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_trazabilidadPrincipalesEventos.mes}"))));
            return dataSource;
        } else if (nomEntidad.equals("controlPlazosFlujoValorizacionesInversiones")) {
            ControlPlazosFlujoValorizacionesInversionesDataSource dataSource = new ControlPlazosFlujoValorizacionesInversionesDataSource();
            dataSource.setDatos(reportesSrv.getControlPlazosFlujoValorizacionesInversiones(Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_controlPlazosFlujoValorizacionesInversiones.tipoInfraestructura}")),
                                                                                              Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_controlPlazosFlujoValorizacionesInversiones.annio}")),
                                                                                              Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_controlPlazosFlujoValorizacionesInversiones.mes}"))));
            return dataSource;
        } else if (nomEntidad.equals("controlPlazosFlujoValorizacionesSupervision")) {
            ControlPlazosFlujoValorizacionesEmpresaSupervisoraDataSource dataSource = new ControlPlazosFlujoValorizacionesEmpresaSupervisoraDataSource();
            dataSource.setDatos(reportesSrv.getControlPlazosFlujoValorizacionesEmpresaSupervisora(Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_controlPlazosFlujoValorizacionesSupervision.tipoInfraestructura}")),
                                                                                              Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_controlPlazosFlujoValorizacionesSupervision.annio}")),
                                                                                              Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_controlPlazosFlujoValorizacionesSupervision.mes}"))));
            return dataSource;
        }  else if (nomEntidad.equals("invReconocimContratosConcesionResumen")) {
                   AvaInvRecConConcDataSource dataSource = new AvaInvRecConConcDataSource();
                   dataSource.setDatos(reportesSrv.getAvaInvRecConConc(
                    Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_invReconocimContratosConcesionResumen.annio}")),
                    Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_invReconocimContratosConcesionResumen.trimestre}")),
                    Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_invReconocimContratosConcesionResumen.tipoInfraestructura}")),
                    Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_invReconocimContratosConcesionResumen.concesion}")),
                    Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_invReconocimContratosConcesionResumen.modalidadConcesion}"))));
                   return dataSource;
               }  
        return null;
    }

    public void generarReporte(ActionEvent event) throws Exception {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = ctx.getExternalContext();
        HttpServletResponse res = (HttpServletResponse) ectx.getResponse();
        
        String nomEntidad=(String)event.getComponent().getAttributes().get("nomentidad");
        String tipoReporte=(String)event.getComponent().getAttributes().get("tiporeporte");
        
        Map parameterMap = new HashMap();      
        String path = ectx.getRealPath("\\reportes\\");
        String extension = "";
        String nomReporte = ""; // "reporte_clientes.xlsx";                
        String nomJasper = ""; // "rptCliente.jasper";
        String nomSubReporte = ""; //este solo debe cambiar cuando el reporte lo requiera, sino queda vacio

        if (tipoReporte.equals("pdf")) {
            extension = ".pdf";
        } else if (tipoReporte.equals("excel")) {
            extension = ".xlsx";
        }
        
        if (nomEntidad.equals("avanceInvContratosConcesion")) {
            nomReporte = "reporte_avanceInvContratosConcesion" + extension;
            nomJasper = "\\rptAvanceInvContConc_" + tipoReporte + ".jasper";
            
            parameterMap.put("P_ANNIO", getValuesControlSelectOneMenuView("#{backing_ositran_reports_avanceInvContratosConcesion.annio}"));
            parameterMap.put("P_MES", getValuesControlSelectOneMenuView("#{backing_ositran_reports_avanceInvContratosConcesion.mes}"));            
        } else if (nomEntidad.equals("controlPlazosFlujoValorizacionesSupervision")) {
            nomReporte = "reporte_controlPlazosFlujoValorizacionesSupervision" + extension;
            nomJasper = "\\rptControlPlazosFlujoPagosEmpSup_" + tipoReporte + ".jasper";
        } else if (nomEntidad.equals("controlPlazosFlujoValorizacionesInversiones")) {
            nomReporte = "reporte_controlPlazosFlujoValorizacionesInversiones" + extension;
            nomJasper = "\\rptControlPlazosFlujoValInv_" + tipoReporte + ".jasper";
        } else if (nomEntidad.equals("empresaSupervisoraVSInfraestructura")) {
            int idTipoInfraestructura = Integer.parseInt(getValuesControlSelectOneMenuView("#{backing_ositran_reports_empresaSupervisoraVSInfraestructura.tipoInfraestructura}"));
            if(idTipoInfraestructura==1){
                //Si es solo Aeropuertos, usar el otro formato
                nomEntidad = "empresaSupervisoraVSInfraestructuraAeropuertos";
                nomReporte = "reporte_empresaSupervisoraVSInfraestructuraAeropuertos" + extension;
                nomJasper = "\\rptEmpSupInfAeropuertos_" + tipoReporte + ".jasper"; 
            }else{
                nomReporte = "reporte_empresaSupervisoraVsInfraestructura" + extension;
                nomJasper = "\\rptEmpSupInf_" + tipoReporte + ".jasper";
            }            
        } else if (nomEntidad.equals("invPorTipoConcepto")) {
            nomReporte = "reporte_inversionPorTipoConcepto" + extension;
            nomJasper = "\\rptInvTipConcepto_" + tipoReporte + ".jasper";
            nomSubReporte = "\\rptInvTipConcepto_detalle_" + tipoReporte + ".jasper";
            
            parameterMap.put("SUBREPORT_DIR", path + nomSubReporte);
        } else if (nomEntidad.equals("invReconocimContratosConcesionResumen")) {
            nomReporte = "reporte_invReconContConResumen" + extension;
            nomJasper = "\\rptInvReconContConResumen_" + tipoReporte + ".jasper";
            
            parameterMap.put("P_ANNIO", getValuesControlSelectOneMenuView("#{backing_ositran_reports_invReconocimContratosConcesionResumen.annio}"));
            parameterMap.put("P_MES", getValuesControlSelectOneMenuView("#{backing_ositran_reports_invReconocimContratosConcesionResumen.mes}"));            
        } else if (nomEntidad.equals("trazabilidadPrincipalesEventos")){
            nomReporte = "reporte_trazabilidadPrincipalesEventos" + extension;
            nomJasper = "\\rptTrazabilidadEventos_" + tipoReporte + ".jasper";
        } else if (nomEntidad.equals("alertas")){
            //TODO: agregar vista que invoca a este reporte - EAPR
            nomReporte = "reporte_alertas" + extension;
            nomJasper = "\\rptAlertas_" + tipoReporte + ".jasper";
        } else if (nomEntidad.equals("alertasAeropuertos")){
            //TODO: agregar vista que invoca a este reporte - EAPR
            nomReporte = "reporte_alertasAeropuertos" + extension;
            nomJasper = "\\rptAlertasAeropuertos_" + tipoReporte + ".jasper";
        }
        //avanceInvContratosConcesion
        //contratoConcesion - NO, hecho por equipo
        //controlPlazosFlujoValorizacionesSupervision
        //empresaSupervisora - NO, hecho por equipo
        //controlPlazosFlujoValorizacionesInversion
        //empresaSupervisoraVsInfraestructura
        //empresaSupervisoraVSInfraestructuraAeropuertos
        //invPorTipoConcepto
        //invReconocimContratosConcesionResumen
        //trazabilidadPrincipalesEventos
        //alertas - TODO: agregar opcion en el menu
        //alertasAeropeurtos - TODO: agregar opcion en el menu
        //Config Reporte - NO es reporte

        String rutaJasper = path + nomJasper;
        parameterMap.put("IMAGE_URL", path + "\\logo_200_100.jpg");

        JRDataSource dataSource = getDataSource(nomEntidad, tipoReporte);
        jasperPrint = new JasperPrint();

        if (dataSource != null) {
            ServletOutputStream out;
            jasperPrint = JasperFillManager.fillReport(rutaJasper, parameterMap, dataSource);

            if (tipoReporte.equals("pdf")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, nomReporte);
            } else if (tipoReporte.equals("excel")) {
                JRXlsxExporter exporter = new JRXlsxExporter();

                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(nomReporte));
                exporter.exportReport();
            }

            reportFile = new File(nomReporte);

            if (tipoReporte.equals("pdf")) {
                res.setContentType("application/pdf");
            } else if (tipoReporte.equals("excel")) {
                res.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            }

            res.setHeader("Content-disposition", "attachment;filename=\"" + nomReporte + "\"");

            in = new FileInputStream(reportFile);
            out = res.getOutputStream();
            bit = 256;
            while ((bit) >= 0) {
                bit = in.read();
                out.write(bit);
            }
            out.flush();
            out.close();
            in.close();
        }
    }

}
