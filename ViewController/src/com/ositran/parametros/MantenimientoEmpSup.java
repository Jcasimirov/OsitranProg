package com.ositran.parametros;

import com.ositran.model.EmpresaSupervisora;
import com.ositran.model.TipoDocumento;
import com.ositran.serviceimpl.EmpresaSupervisoraServiceImpl;
import com.ositran.serviceimpl.TipoDocumentoServiceImpl;
import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.TipoDocumentoVO;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import com.ositran.util.util;

@ManagedBean(name = "backing_ositran_parametros_MantenimientoEmpSup")
@RequestScoped
@Generated(value = "1ositran/parametros/MantenimientoEmpSup.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class MantenimientoEmpSup {
    private HtmlForm form1;
    
    util util = new util();
    List<EmpresaSupervisoraVO> listaEmpSup;    
    List<TipoDocumentoVO> listaTipoDocumento;    
    public EmpresaSupervisoraVO empSupVO = new EmpresaSupervisoraVO();
    
    @ManagedProperty(value="#{empSupServiceImp}")
    private EmpresaSupervisoraServiceImpl empSupServiceImp;   
    
    @ManagedProperty(value="#{tipoDocumentoServiceImp}")
    private TipoDocumentoServiceImpl tipoDocumentoServiceImp;
    


    public void setListaTipoDocumento(List<TipoDocumentoVO> listaTipoDocumento) {
        this.listaTipoDocumento = listaTipoDocumento;
    }

    public void setListaEmpSup(List<EmpresaSupervisoraVO> listaEmpSup) {
        this.listaEmpSup = listaEmpSup;
    }

    public List<EmpresaSupervisoraVO> getListaEmpSup() {
        return listaEmpSup;
    }

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }
    
    
    public void setTipoDocumentoServiceImp(TipoDocumentoServiceImpl tipoDocumentoServiceImp) {
        this.tipoDocumentoServiceImp = tipoDocumentoServiceImp;
    }

    public TipoDocumentoServiceImpl getTipoDocumentoServiceImp() {
        return tipoDocumentoServiceImp;
    }

    

    public void setEmpSupServiceImp(EmpresaSupervisoraServiceImpl empSupServiceImp) {
        this.empSupServiceImp = empSupServiceImp;
    }

    public EmpresaSupervisoraServiceImpl getEmpSupServiceImp() {
        return empSupServiceImp;
    }


    public void setEmpSupVO(EmpresaSupervisoraVO empSupVO) {
        this.empSupVO = empSupVO;
    }

    public EmpresaSupervisoraVO getEmpSupVO() {
        return empSupVO;
    }
    
    public List<EmpresaSupervisoraVO> getQuery(){
        listaEmpSup=this.empSupServiceImp.query();
        //limpiarCampos ();
        return listaEmpSup; 
    }
    
    public List<TipoDocumentoVO> getListaTipoDocumento(){
        listaTipoDocumento = this.tipoDocumentoServiceImp.query(); 
        System.out.println("El tamaño de listaTipoDocumento = "+ listaTipoDocumento.size());
        return listaTipoDocumento;
    }
    

    
    public String EmpSupUpd1(){
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("id2");
        Integer idEmpSup=Integer.valueOf(str.toString());
        empSupVO=this.empSupServiceImp.get(idEmpSup);
        return "/index?faces-redirect=true";
    }
    
    public String EmpSupUpd2(){
        this.empSupServiceImp.update(empSupVO);
        return "/index?faces-redirect=true";
    }

    // Registrar Tipo Documento
    
     private String nomEmpSup;
     private String dirEmpSup;
     private String repLegal;
     private int cargo;
     private String telefono;
     private int tipoDocumento;
     private String nroDoc;
     private String correo;
     private String siglasNom;


    public void setNomEmpSup(String nomEmpSup) {
        this.nomEmpSup = nomEmpSup;
    }

    public String getNomEmpSup() {
        return nomEmpSup;
    }

    public void setDirEmpSup(String dirEmpSup) {
        this.dirEmpSup = dirEmpSup;
    }

    public String getDirEmpSup() {
        return dirEmpSup;
    }

    public void setRepLegal(String repLegal) {
        this.repLegal = repLegal;
    }

    public String getRepLegal() {
        return repLegal;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setSiglasNom(String siglasNom) {
        this.siglasNom = siglasNom;
    }

    public String getSiglasNom() {
        return siglasNom;
    }


    public void limpiarCampos (){
        nomEmpSup = "";
        dirEmpSup = "";
        repLegal = "" ;
        cargo = 0;
        telefono = "";
        tipoDocumento = 0;
        nroDoc = "";
        correo = "";
        siglasNom = "";
        
    }
    
    
    public String EmpSupDel(ActionEvent event){
        
        UIParameter parameter=(UIParameter)event.getComponent().findComponent("id1");
        Integer idEmpSup=(Integer)parameter.getValue();
        this.empSupServiceImp.delete(idEmpSup);
        getQuery();
        return "/index?faces-redirect=true";
        
    }

    public void guardar(){

        empSupVO.setSupNombre(nomEmpSup);
        empSupVO.setSupDireccion(dirEmpSup);
        empSupVO.setSupRepresentanteLegal(repLegal);
        empSupVO.setCrgId(cargo);
        empSupVO.setSupTelefono(telefono);
        empSupVO.setSupNroDocumento(nroDoc);
        empSupVO.setTdoId(tipoDocumento);
        empSupVO.setSupCorreo(correo);
        empSupVO.setSupDescripcion(siglasNom); 
        empSupVO.setSupEstado(1);
        empSupVO.setSupFechaAlta(util.getObtenerFechaHoy());
        empSupVO.setSupTerminal(util.obtenerIpCliente());
        this.empSupServiceImp.insert(empSupVO);        
        getQuery();
        limpiarCampos();
    } 

}
