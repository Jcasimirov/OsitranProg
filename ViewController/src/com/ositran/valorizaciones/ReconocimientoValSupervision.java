package com.ositran.valorizaciones;

import com.ositran.service.EmpresaSupervisoraService;
import com.ositran.service.InversionService;
import com.ositran.service.TipoDocumentoService;
import com.ositran.service.ValorizacionSupService;
import com.ositran.serviceimpl.ValorizacionSupDetalleServiceImpl;
import com.ositran.serviceimpl.ValorizacionSupServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TipoDocumentoVO;

import com.ositran.vo.bean.ValorizacionSupDetalleVO;

import com.ositran.vo.bean.ValorizacionSupVO;

import java.io.IOException;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "ReconocimientoValSupervisionMB")
@ViewScoped
@Generated(value = "1ositran/valorizaciones/ReconocimientoValorizacionSupervision.jsf",
           comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class ReconocimientoValSupervision {
    
    //-----------------SESSION-----------------------//
    public  final int formulario=38;
    private RolOpcionesVO rolOpcion;

    public void validarSesion() throws IOException{              
            rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
        }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }
    //---------------------------------------------//
    
    private HtmlForm form;


    private String nombreEmpSup;
    private String nombreEmpSupEncontrada;
    private int idEmpresaSup;
    private int estadoReconocimiento;
    private String observacion;
    private String nroInforme;
    private Date fechaInforme;
    private String regInforme;
    private String nroOficio;
    private Date fechaOficio;
    private String regOficio;
    private String nroMemo;
    private Date fechaMemo;
    private String regMemo;
    private double totalpresentado;
    private double totalAprobado;
    private double montoAprobado;
    private String montoIngresado;
    private double montoTotal;
    private int filaSeleccionada;

    //Bean Vo
    @ManagedProperty(value="#{valorizacionSupVO}")
    private ValorizacionSupVO valorizacionSupVO;
    
    @ManagedProperty(value="#{valorizacionSupDetalleVO}")
    private ValorizacionSupDetalleVO valorizacionSupDetalleVO;
    
    //Listas
    
    List<EmpresaSupervisoraVO> listaEmpresasSup=new ArrayList<EmpresaSupervisoraVO>();
    List<TipoDocumentoVO> listaTipoDocumento = new ArrayList<TipoDocumentoVO>();
    List<ValorizacionSupDetalleVO> listaValorizaciondetalle=new ArrayList<ValorizacionSupDetalleVO>();
    List<ValorizacionSupVO> listaValorizacion=new ArrayList<ValorizacionSupVO>();
    
    
    
    //Services 
    
    @ManagedProperty(value="#{empSupServiceImp}")
    private EmpresaSupervisoraService empSupServiceImp;
    
    @ManagedProperty(value="#{tipoDocumentoServiceImp}")
    private TipoDocumentoService tipoDocumentoServiceImp;
    
    @ManagedProperty(value="#{valorizacionSupServiceImpl}")
    private ValorizacionSupService valorizacionSupServiceImpl;
    
    @ManagedProperty(value="#{valorizacionSupDetalleServiceImpl}")
    private ValorizacionSupDetalleServiceImpl valorizacionSupDetalleServiceImpl;
    
   
    
    //Metodos Get y Set


    public void setForm(HtmlForm form) {
        this.form = form;
    }

    public HtmlForm getForm() {
        return form;
    }

    public void setNombreEmpSup(String nombreEmpSup) {
        this.nombreEmpSup = nombreEmpSup;
    }

    public String getNombreEmpSup() {
        return nombreEmpSup;
    }

    public void setIdEmpresaSup(int idEmpresaSup) {
        this.idEmpresaSup = idEmpresaSup;
    }

    public int getIdEmpresaSup() {
        return idEmpresaSup;
    }

    public void setEstadoReconocimiento(int estadoReconocimiento) {
        this.estadoReconocimiento = estadoReconocimiento;
    }

    public int getEstadoReconocimiento() {
        return estadoReconocimiento;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setNroInforme(String nroInforme) {
        this.nroInforme = nroInforme;
    }

    public String getNroInforme() {
        return nroInforme;
    }

    public void setFechaInforme(Date fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public Date getFechaInforme() {
        return fechaInforme;
    }

    public void setRegInforme(String regInforme) {
        this.regInforme = regInforme;
    }

    public String getRegInforme() {
        return regInforme;
    }

    public void setNroOficio(String nroOficio) {
        this.nroOficio = nroOficio;
    }

    public String getNroOficio() {
        return nroOficio;
    }

    public void setFechaOficio(Date fechaOficio) {
        this.fechaOficio = fechaOficio;
    }

    public Date getFechaOficio() {
        return fechaOficio;
    }

    public void setRegOficio(String regOficio) {
        this.regOficio = regOficio;
    }

    public String getRegOficio() {
        return regOficio;
    }

    public void setNroMemo(String nroMemo) {
        this.nroMemo = nroMemo;
    }

    public String getNroMemo() {
        return nroMemo;
    }

    public void setFechaMemo(Date fechaMemo) {
        this.fechaMemo = fechaMemo;
    }

    public Date getFechaMemo() {
        return fechaMemo;
    }

    public void setRegMemo(String regMemo) {
        this.regMemo = regMemo;
    }

    public String getRegMemo() {
        return regMemo;
    }

    public void setListaEmpresasSup(List<EmpresaSupervisoraVO> listaEmpresasSup) {
        this.listaEmpresasSup = listaEmpresasSup;
    }

    public List<EmpresaSupervisoraVO> getListaEmpresasSup() {
        return listaEmpresasSup;
    }

    public void setListaTipoDocumento(List<TipoDocumentoVO> listaTipoDocumento) {
        this.listaTipoDocumento = listaTipoDocumento;
    }

    public List<TipoDocumentoVO> getListaTipoDocumento() {
        return listaTipoDocumento;
    }

    public void setEmpSupServiceImp(EmpresaSupervisoraService empSupServiceImp) {
        this.empSupServiceImp = empSupServiceImp;
    }

    public EmpresaSupervisoraService getEmpSupServiceImp() {
        return empSupServiceImp;
    }

    public void setTipoDocumentoServiceImp(TipoDocumentoService tipoDocumentoServiceImp) {
        this.tipoDocumentoServiceImp = tipoDocumentoServiceImp;
    }

    public TipoDocumentoService getTipoDocumentoServiceImp() {
        return tipoDocumentoServiceImp;
    }

    public void setNombreEmpSupEncontrada(String nombreEmpSupEncontrada) {
        this.nombreEmpSupEncontrada = nombreEmpSupEncontrada;
    }

    public String getNombreEmpSupEncontrada() {
        return nombreEmpSupEncontrada;
    }

    public void setListaValorizaciondetalle(List<ValorizacionSupDetalleVO> listaValorizaciondetalle) {
        this.listaValorizaciondetalle = listaValorizaciondetalle;
    }

    public List<ValorizacionSupDetalleVO> getListaValorizaciondetalle() {
        return listaValorizaciondetalle;
    }

    public void setListaValorizacion(List<ValorizacionSupVO> listaValorizacion) {
        this.listaValorizacion = listaValorizacion;
    }

    public List<ValorizacionSupVO> getListaValorizacion() {
        return listaValorizacion;
    }

    public void setValorizacionSupServiceImpl(ValorizacionSupService valorizacionSupServiceImpl) {
        this.valorizacionSupServiceImpl = valorizacionSupServiceImpl;
    }

    public ValorizacionSupService getValorizacionSupServiceImpl() {
        return valorizacionSupServiceImpl;
    }

    public void setValorizacionSupDetalleServiceImpl(ValorizacionSupDetalleServiceImpl valorizacionSupDetalleServiceImpl) {
        this.valorizacionSupDetalleServiceImpl = valorizacionSupDetalleServiceImpl;
    }

    public ValorizacionSupDetalleServiceImpl getValorizacionSupDetalleServiceImpl() {
        return valorizacionSupDetalleServiceImpl;
    }

    public void setTotalpresentado(double totalpresentado) {
        this.totalpresentado = totalpresentado;
    }

    public double getTotalpresentado() {
        return totalpresentado;
    }

    public void setTotalAprobado(double totalAprobado) {
        this.totalAprobado = totalAprobado;
    }

    public double getTotalAprobado() {
        return totalAprobado;
    }

    public void setValorizacionSupVO(ValorizacionSupVO valorizacionSupVO) {
        this.valorizacionSupVO = valorizacionSupVO;
    }

    public ValorizacionSupVO getValorizacionSupVO() {
        return valorizacionSupVO;
    }

    public void setMontoAprobado(double montoAprobado) {
        this.montoAprobado = montoAprobado;
    }

    public double getMontoAprobado() {
        return montoAprobado;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setValorizacionSupDetalleVO(ValorizacionSupDetalleVO valorizacionSupDetalleVO) {
        this.valorizacionSupDetalleVO = valorizacionSupDetalleVO;
    }

    public ValorizacionSupDetalleVO getValorizacionSupDetalleVO() {
        return valorizacionSupDetalleVO;
    }

    public void setFilaSeleccionada(int filaSeleccionada) {
        this.filaSeleccionada = filaSeleccionada;
    }

    public int getFilaSeleccionada() {
        return filaSeleccionada;
    }

    public void setMontoIngresado(String montoIngresado) {
        this.montoIngresado = montoIngresado;
    }

    public String getMontoIngresado() {
        return montoIngresado;
    }

    //Buscar Empresa Supervisora
    
    public void filtrarListaEmpSup(){
        
        try {
            System.out.println("entro FiltrarListaEmpSup: " + listaEmpresasSup.size());
            listaEmpresasSup = empSupServiceImp.FiltrarEmpSup(nombreEmpSup);
            listaTipoDocumento = tipoDocumentoServiceImp.query();
            for (int i = 0; i < listaEmpresasSup.size(); i++) {
                for (int j = 0; j < listaTipoDocumento.size(); j++) {
                    if (listaEmpresasSup.get(i).getTdoId() == listaTipoDocumento.get(j).getTdoId()) {
                        listaEmpresasSup.get(i).setDescripcionDoc(listaTipoDocumento.get(j).getTdoNombre());
                    }
                }
                System.out.println(""+listaEmpresasSup.get(i).getSupNombre());
            }
            System.out.println("entro FiltrarListaEmpSup: " + listaEmpresasSup.size());
        } catch (SQLException sqle) {
            // TODO: Add catch code
            sqle.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("Dialog_ResultadoBusquedaEmpresa.show()");
        
    }
    
    public void seleccionarEmpresa(ActionEvent actionEvent) throws Exception{
        System.out.println("Entro");
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        EmpresaSupervisoraVO empresa = (EmpresaSupervisoraVO) actionEvent.getComponent().getAttributes().get("empresa");
        nombreEmpSupEncontrada = empresa.getSupNombre();
        listaValorizacion = valorizacionSupServiceImpl.ListaValorizacionesRegistradas(empresa.getSupId());
        for (ValorizacionSupVO val : listaValorizacion){
            if(val.getMonId() == 1){
                val.setNombreMoneda("Nuevos Soles");
            }else{
                val.setNombreMoneda("Dolares Americanos");
            }
            val.setNombreEstado("Registrado");
        }
        System.out.println(empresa.getSupNombre());
    }
    
    public void seleccionarValorizacion(ActionEvent actionEvent) throws Exception{
        System.out.println("Entro");
        valorizacionSupVO = (ValorizacionSupVO) actionEvent.getComponent().getAttributes().get("valorizacion");
        listaValorizaciondetalle = valorizacionSupDetalleServiceImpl.ListaValorizacionesDetRegistradas(valorizacionSupVO.getTvsHr());
        for (int i=0 ;i<listaValorizaciondetalle.size();i++){
            
            listaValorizaciondetalle.get(i).setTotalAprobado(listaValorizaciondetalle.get(i).getTtotal());
            totalpresentado = totalpresentado + listaValorizaciondetalle.get(i).getTtotal(); 
            listaValorizaciondetalle.get(i).setFila(i);
            if(listaValorizaciondetalle.get(i).getMonId() == 1){
                listaValorizaciondetalle.get(i).setNombreMoneda("Nuevos Soles");
            }else{
                listaValorizaciondetalle.get(i).setNombreMoneda("Dolares Americanos");
            }
        }
        totalAprobado = totalpresentado;
    }
    
    public void seleccionarValorizaciondet(ActionEvent actionEvent) throws Exception{
        valorizacionSupDetalleVO = (ValorizacionSupDetalleVO) actionEvent.getComponent().getAttributes().get("valorizaciodet");
        montoTotal = valorizacionSupDetalleVO.getTtotal();
        montoIngresado = ""+montoTotal;
        filaSeleccionada = valorizacionSupDetalleVO.getFila();
    }
    
    public void aprobarMontoIngresado(){
        double totalcalculado = 0;
        System.out.println("entrooo");
        if(montoIngresado == null || montoIngresado.trim().equals("") ){
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Monto");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }else if(!montoIngresado.matches("^(\\d|-)?(\\d|,)*\\.?\\d*$")){
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese un Número");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            
        }else{
            montoAprobado = Double.parseDouble(montoIngresado);
            if(montoAprobado > montoTotal){
                        FacesMessage mensaje =
                            new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El MontoAprobado no puede ser mayor al Monto Presentado");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }else{
                for (int i=0; i<listaValorizaciondetalle.size();i++){
                    if (filaSeleccionada == listaValorizaciondetalle.get(i).getFila()){
                        listaValorizaciondetalle.get(i).setTotalAprobado(montoAprobado);
                    }
                    totalcalculado = totalcalculado+listaValorizaciondetalle.get(i).getTotalAprobado();           
                }
                totalAprobado = totalcalculado;
                RequestContext.getCurrentInstance().execute("Dialog_AprobarMonto.hide()");
            }            
            
        }
    }
    
    public void reconocerValorizacion (){
        System.out.println("entrooooooooooooooo");
        if(estadoReconocimiento == 0 ){
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Estado de Valorización");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }else if(observacion == null || observacion.trim().equals("")){
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese una Observación");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }else{
        try{
            if(estadoReconocimiento == 1){
                valorizacionSupVO.setTvsEstado(2);
                valorizacionSupVO.setTvsInfNumero(nroInforme);
                valorizacionSupVO.setTvsInfFechaEmision(fechaInforme);
                valorizacionSupVO.setTvsInfRegSalida(regInforme);
                valorizacionSupVO.setTvsMemNumero(nroMemo);
                valorizacionSupVO.setTvsMemFechaEmision(fechaMemo);
                valorizacionSupVO.setTvsMemRegSalida(regMemo);
                valorizacionSupVO.setTvsOfiNumero(nroOficio);
                valorizacionSupVO.setTvsOfiFechaEmision(fechaOficio);
                valorizacionSupVO.setTvsOfiRegSalida(regOficio);
                valorizacionSupVO.setTvsObservacion(observacion);
                valorizacionSupServiceImpl.update(valorizacionSupVO);
                for(ValorizacionSupDetalleVO detalle : listaValorizaciondetalle){
                valorizacionSupDetalleServiceImpl.update(detalle);
                
                    }
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Reconocio con Exito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }else{
                        valorizacionSupVO.setTvsEstado(0);
                        valorizacionSupVO.setTvsObservacion(observacion);
                        valorizacionSupServiceImpl.update(valorizacionSupVO);
                        FacesMessage mensaje =
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Reconocio con Exito");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
                    }
            
        }catch(Exception e){
            System.out.println(e);
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se Pudo Reconocer la Valorización");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        }
    }
    
   

}
