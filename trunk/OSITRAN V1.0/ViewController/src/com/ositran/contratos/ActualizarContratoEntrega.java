package com.ositran.contratos;

import com.ositran.serviceimpl.ContratoEntregaServiceImpl;
import com.ositran.util.Util;


import java.io.File;
import com.ositran.vo.bean.ContratoEntregaVO;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

@ManagedBean(name = "actualizarContratoEntregaMB")

public class ActualizarContratoEntrega {
    private HtmlForm form;
    Util util = new Util();


    // campos de formulario
    private String nombre;
    private String objeto;
    private Date fecha;
    private String documento;
    private Integer contratoAdenda;

    private List<ContratoEntregaVO> listContratoEntrega;
    @ManagedProperty(value = "#{ContratoEntregaVO}")
    ContratoEntregaVO contratoEntregaVO;    
    @ManagedProperty(value = "#{contratoEntregaServiceImpl}")
    private ContratoEntregaServiceImpl contratoEntregaServiceImpl;

    // Services

    public ActualizarContratoEntrega() {
        super();

    }

    
    

    public List<ContratoEntregaVO> getListContratoEntrega() {
        return listContratoEntrega;
    }

    public void setListContratoEntrega(List<ContratoEntregaVO> listContratoEntrega) {
        this.listContratoEntrega = listContratoEntrega;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getContratoEntrega() {
        return contratoAdenda;
    }

    public void setContratoEntrega(Integer contratoAdenda) {
        this.contratoAdenda = contratoAdenda;
    }

    public void subirArchivo(FileUploadEvent event) throws IOException {
        System.out.println("Inicio Carga documendo Adenda");
        System.out.println(event.getFile().getFileName());
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        ///////////////////////////////////////////////////////
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
        /*String name = fmt.format(new Date())
                        + event.getFile().getFileName().substring(
                              event.getFile().getFileName().lastIndexOf('.'));*/
        File file = new File("D:/files_ositran/temp/" + event.getFile().getFileName());

        InputStream is = event.getFile().getInputstream();
        OutputStream out = new FileOutputStream(file);
        byte buf[] = new byte[1024];
        int len;
        while ((len = is.read(buf)) > 0)
            out.write(buf, 0, len);
        is.close();
        out.close();
        //////////////////////////////////////////////////////
        documento = event.getFile().getFileName();
        System.out.println("Fin Carga documendo Adenda");
    }

    public void guardar() {

        if (nombre.equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "no ha ingresado nombre");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            try {
                
                contratoEntregaVO.setCenNombre(nombre);
                contratoEntregaVO.setCenDescripcion(objeto);
                contratoEntregaVO.setCenFecha(fecha);
                contratoEntregaVO.setCenDocumentoFisico(documento);
                contratoEntregaVO.setConId(contratoAdenda);
                contratoEntregaServiceImpl.insert(contratoEntregaVO);
                
                cargarListaContratoEntrega();
                limpiarCampos();
                
            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",                                                                              
                                                                              " No se pudo registrar la Adenda "));

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar la Adenda "));
            }

        }

    }
    
    public void cargarListaContratoEntrega() {
        try {
            //int contador=1;
           listContratoEntrega = contratoEntregaServiceImpl.query();
            /*for(int i=0;i<listContratoEntrega.size();i++){
              listContratoEntrega.get(i).setContador(contador);
                contador++;
                }*/
       }
        catch (SQLException s) {
            s.printStackTrace();
                   FacesContext.getCurrentInstance().addMessage(null,
                                                                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",                                                                                 
                                                                                 " No se pudo editar el concecionario ")); 
                   
               } 
               catch ( Exception e){
            e.printStackTrace();
                       FacesContext.getCurrentInstance().addMessage(null,
                                                                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",                                                                                     
                                                                                     " No se pudo editar el concecionario "));
                   }
        
    }
    
    public void limpiarCampos() {
        nombre = "";
        contratoAdenda = 0;
        documento = "";
        objeto = "";
        fecha = null;        
    }
    
    public void setContratoEntregaVO(ContratoEntregaVO contratoEntregaVO) {
        this.contratoEntregaVO = contratoEntregaVO;
    }

    public ContratoEntregaVO getContratoEntregaVO() {
        return contratoEntregaVO;
    }
    
    public void setContratoEntregaServiceImpl(ContratoEntregaServiceImpl contratoEntregaServiceImpl) {
        this.contratoEntregaServiceImpl = contratoEntregaServiceImpl;
    }

    public ContratoEntregaServiceImpl    getContratoEntregaServiceImpl() {
        return contratoEntregaServiceImpl;
    }
 
    
}
