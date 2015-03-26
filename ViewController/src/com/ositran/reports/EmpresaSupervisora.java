package com.ositran.reports;

import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.component.html.HtmlForm;

import javax.faces.model.SelectItem;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_reports_empresaSupervisora")
@RequestScoped
@Generated(value = "1ositran/reports/empresaSupervisora.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class EmpresaSupervisora {
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
    private CommandButton cmbGenerar;
    private String tipoInfraestructura;
    List<SelectItem> tipoInfraestructuraSelectItems=new ArrayList<SelectItem>();
    private String concesion;
    List<SelectItem> concesionSelectItems=new ArrayList<SelectItem>();
    private String estado;
    List<SelectItem> estadoSelectItems=new ArrayList<SelectItem>();


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

    public void setForm1(HtmlForm form1) {
        this.formSupervisora = form1;
    }

    public HtmlForm getForm1() {
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

    public void setCmbGenerar(CommandButton commandButton2) {
        this.cmbGenerar = commandButton2;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
    }
    
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
        tipoInfraestructuraSelectItems.add(new SelectItem("-1","Seleccione"));
        List<InfraestructuraTipoVO> lista=listarInfraestructura();
        int i=0;
        for(InfraestructuraTipoVO ivo:lista){
            tipoInfraestructuraSelectItems.add(new SelectItem(i++, String.valueOf(ivo.getTinNombre())));
        }
        return tipoInfraestructuraSelectItems;
    }
    /**
     * @author Paul Rivera
     * @return tipo de infraestructura seleccionado del combo
     */
    public String getSelectedTipoInfraestructura(){
        if("".equals(getTipoInfraestructura()) || getTipoInfraestructura() ==null){
            return "";
        }else{
            return getTipoInfraestructura();
        }
    }        
    @ManagedProperty(value="#{concesionServiceImpl}")
    private ConcesionServiceImpl concesionServiceImpl;
    public ConcesionVO concesionVO=new ConcesionVO();
    public void setConcesionServiceImpl(ConcesionServiceImpl concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionarioVO() {
        return concesionVO;
    }


    public List<ConcesionVO> listarConcesion() throws SQLException{
        List<ConcesionVO> list=this.concesionServiceImpl.listarConcesiones();
        return list;
    }
    
    
    /**
     * @author Paul Rivera
     * @return concesion para que se renderize en el combo
     */
    public List<SelectItem> getConcesionSelectItems() throws SQLException {
        concesionSelectItems.add(new SelectItem("-1","Seleccione"));
        List<ConcesionVO> lista=listarConcesion();
        int i=0;
        for(ConcesionVO cvo:lista){
            concesionSelectItems.add(new SelectItem(i++, String.valueOf(cvo.getCsiNombre())));
        }
        return concesionSelectItems;
    }    
    /**
     * @author Paul Rivera
     * @return concesion seleccionado del combo
     */
    public String getSelectedConcesion(){
        if("".equals(getConcesion()) || getConcesion() ==null){
            return "";
        }else{
            return getConcesion();
        }
    }        

    /**
     * @author Paul Rivera
     * @return lista de estados para que se renderize en el combo
     */
    public List<SelectItem> getEstadoSelectItems() {
        estadoSelectItems.add(new SelectItem("-1","Seleccione"));
        String[] reporte=new String[3];
        reporte[0]="Activo";
        reporte[1]="Inactivo";
        reporte[2]="Todos";
        for (int i = 0; i < reporte.length; i++) {
            estadoSelectItems.add(new SelectItem(i, String.valueOf(reporte[i])));
        }
        return estadoSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return estado seleccionado del combo
     */
    public String getSelectedEstado(){
        if("".equals(getEstado()) || getEstado() ==null){
            return "";
        }else{
            return getEstado();
        }
    }    
    
}
