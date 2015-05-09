package com.ositran.reports;

import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
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

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonebutton.SelectOneButton;
import org.primefaces.component.selectonemenu.SelectOneMenu;

@ManagedBean(name = "backing_ositran_reports_trazabilidadPrincipalesEventos")
@RequestScoped
@Generated(value = "1ositran/reports/trazabilidadPrincipalesEventos.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class TrazabilidadPrincipalesEventos {
    private HtmlForm formInversionTipoConcepto;
    private OutputLabel outputLabel1;
    private PanelGrid pnlgTrazabilidad;
    private OutputLabel lblTipoInfraestructura;
    private SelectOneMenu selectTipoInfraestructura;
    private OutputLabel lblAnnio;
    private SelectOneMenu selectAnnio;
    private OutputLabel lblMes;
    private SelectOneButton selectOneButton1;
    private SelectOneMenu selectMes;
    private CommandButton cmbGenerar;
    private CommandButton commandButton2;
    private CommandButton commandButton3;
    private String tipoInfraestructura;
    List<SelectItem> tipoInfraestructuraSelectItems=new ArrayList<SelectItem>();
    private String annio;
    List<SelectItem> annioSelectItems=new ArrayList<SelectItem>();
    private String mes;
    List<SelectItem> mesSelectItems=new ArrayList<SelectItem>();


    public void setTipoInfraestructura(String tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public String getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getAnnio() {
        return annio;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMes() {
        return mes;
    }

    public void setForm1(HtmlForm form1) {
        this.formInversionTipoConcepto = form1;
    }

    public HtmlForm getForm1() {
        return formInversionTipoConcepto;
    }

    public void setOutputLabel1(OutputLabel outputLabel1) {
        this.outputLabel1 = outputLabel1;
    }

    public OutputLabel getOutputLabel1() {
        return outputLabel1;
    }

    public void setPnlgTrazabilidad(PanelGrid panelGrid1) {
        this.pnlgTrazabilidad = panelGrid1;
    }

    public PanelGrid getPnlgTrazabilidad() {
        return pnlgTrazabilidad;
    }

    public void setLblTipoInfraestructura(OutputLabel outputLabel2) {
        this.lblTipoInfraestructura = outputLabel2;
    }

    public OutputLabel getLblTipoInfraestructura() {
        return lblTipoInfraestructura;
    }

    public void setSelectTipoInfraestructura(SelectOneMenu selectOneMenu1) {
        this.selectTipoInfraestructura = selectOneMenu1;
    }

    public SelectOneMenu getSelectTipoInfraestructura() {
        return selectTipoInfraestructura;
    }

    public void setLblAnnio(OutputLabel outputLabel3) {
        this.lblAnnio = outputLabel3;
    }

    public OutputLabel getLblAnnio() {
        return lblAnnio;
    }

    public void setSelectAnnio(SelectOneMenu selectOneMenu2) {
        this.selectAnnio = selectOneMenu2;
    }

    public SelectOneMenu getSelectAnnio() {
        return selectAnnio;
    }

    public void setLblMes(OutputLabel outputLabel4) {
        this.lblMes = outputLabel4;
    }

    public OutputLabel getLblMes() {
        return lblMes;
    }

    public void setSelectOneButton1(SelectOneButton selectOneButton1) {
        this.selectOneButton1 = selectOneButton1;
    }

    public SelectOneButton getSelectOneButton1() {
        return selectOneButton1;
    }

    public void setSelectMes(SelectOneMenu selectOneMenu3) {
        this.selectMes = selectOneMenu3;
    }

    public SelectOneMenu getSelectMes() {
        return selectMes;
    }

    public void setCmbGenerar(CommandButton commandButton1) {
        this.cmbGenerar = commandButton1;
    }

    public CommandButton getCmbGenerar() {
        return cmbGenerar;
    }

    public void setCommandButton2(CommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CommandButton getCommandButton2() {
        return commandButton2;
    }

    public void setCommandButton3(CommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public CommandButton getCommandButton3() {
        return commandButton3;
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
            tipoInfraestructuraSelectItems.add(new SelectItem(ivo.getTinId()+"", String.valueOf(ivo.getTinNombre())));
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
    
    
    /**
     * @author Paul Rivera
     * @return lista de años para que se renderize en el combo
     */
    public List<SelectItem> getAnnioSelectItems() {
        annioSelectItems.add(new SelectItem("-1","Seleccione"));
        for (int i = 1990; i < 2016; i++) {
            annioSelectItems.add(new SelectItem(i, String.valueOf(i)));
        }
        return annioSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return año seleccionado del combo
     */
    public String getSelectedAnnio(){
        if("".equals(getAnnio()) || getAnnio() ==null){
            return "";
        }else{
            return getAnnio();
        }
    }
    
    /**
     * @author Paul Rivera
     * @return lista de meses para que se renderize en el combo
     */
    public List<SelectItem> getMesesSelectItems() {
        mesSelectItems.add(new SelectItem("-1","Seleccione"));
        String[] mes=new String[12];
        mes[0]="enero";
        mes[1]="febrero";
        mes[2]="marzo";
        mes[3]="abril";
        mes[4]="mayo";
        mes[5]="junio";
        mes[6]="julio";
        mes[7]="agosto";
        mes[8]="septiembre";
        mes[9]="octubre";
        mes[10]="noviembre";
        mes[11]="diciembre";
        for (int i = 0; i < mes.length; i++) {
            mesSelectItems.add(new SelectItem(i+1, String.valueOf(mes[i])));
        }
        return mesSelectItems;
    }

    /**
     * @author Paul Rivera
     * @return mes seleccionado del combo
     */
    public String getSelectedMes(){
        if("".equals(getMes()) || getMes() ==null){
            return "";
        }else{
            return getMes();
        }
    }
    
}
