package com.ositran.contratos;

import com.ositran.serviceimpl.AdendaTipoServiceImpl;
import com.ositran.serviceimpl.ContratoAdendaServiceImpl;
import com.ositran.util.Util;
import com.ositran.vo.bean.AdendaTipoVO;
import com.ositran.vo.bean.ContratoAdendaVO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

@ManagedBean(name = "actualizarContratoAdendaMB")

public class ActualizarContratoAdenda {
    private HtmlForm form;
    Util util = new Util();


    // campos de formulario
    private List<AdendaTipoVO> listaAdendaTipo;
    private Integer adendaTipo = 0;
    private String nombre;
    private String objeto;
    private Date fecha;
    private String documento;
    private Integer contratoId;
    private Integer adendaId;

    private List<ContratoAdendaVO> listContratoAdenda;
    @ManagedProperty(value = "#{ContratoAdendaVO}")
    ContratoAdendaVO contratoAdendaVO;
    @ManagedProperty(value = "#{adendaTipoServiceImpl}")
    private AdendaTipoServiceImpl adendaTipoServiceImpl;
    @ManagedProperty(value = "#{contratoAdendaServiceImpl}")
    private ContratoAdendaServiceImpl contratoAdendaServiceImpl;

    // Services

    public ActualizarContratoAdenda() {
        super();

    }

    public void cargarListaAdendaTipo() {
        try {
            listaAdendaTipo = adendaTipoServiceImpl.query();
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",

                                                                                " No se puede listar los tipos de Adenda"));
        }

    }

    public List<AdendaTipoVO> getListaAdendaTipo() {
        return listaAdendaTipo;
    }

    public void setListaAdendaTipo(List<AdendaTipoVO> listaAdendaTipo) {
        this.listaAdendaTipo = listaAdendaTipo;
    }

    public List<ContratoAdendaVO> getListContratoAdenda() {
        return listContratoAdenda;
    }

    public void setListContratoAdenda(List<ContratoAdendaVO> listContratoAdenda) {
        this.listContratoAdenda = listContratoAdenda;
    }

    public AdendaTipoServiceImpl getAdendaTipoServiceImpl() {
        return adendaTipoServiceImpl;
    }

    public void setAdendaTipoServiceImpl(AdendaTipoServiceImpl adendaTipoServiceImpl) {
        this.adendaTipoServiceImpl = adendaTipoServiceImpl;
    }

    public Integer getAdendaTipo() {
        return adendaTipo;
    }

    public void setAdendaTipo(int adendaTipo) {
        this.adendaTipo = adendaTipo;
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

    public Integer getContratoId() {
        return contratoId;
    }

    public void setContratoId(Integer contratoId) {
        this.contratoId = contratoId;
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
        if (adendaTipo == 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha selecionado el tipo de Adenda");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (nombre.equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "no ha ingresado nombre");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            try {

                contratoAdendaVO.setConId(contratoId);
                contratoAdendaVO.setCadNombre(nombre);
                contratoAdendaVO.setCadDescripcion(objeto);
                contratoAdendaVO.setCadFecha(fecha);
                contratoAdendaVO.setCadDocumentoFisico(documento);
                contratoAdendaVO.setTadId(adendaTipo);
                contratoAdendaServiceImpl.insert(contratoAdendaVO);
                
                cargarListaContratoAdenda();
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
    
    public void cargarListaContratoAdenda() {
        try {
            //int contador=1;
            System.out.println("########################### llego ################");
            System.out.println(contratoId);
           listContratoAdenda = contratoAdendaServiceImpl.getAdendasContrato(contratoId);
            /*for(int i=0;i<listContratoAdenda.size();i++){
              listContratoAdenda.get(i).setContador(contador);
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
        contratoId = 0;
        documento = "";
        objeto = "";
        fecha = null;
        adendaTipo = 0;
    }
    
    public void setContratoAdendaVO(ContratoAdendaVO contratoAdendaVO) {
        this.contratoAdendaVO = contratoAdendaVO;
    }

    public ContratoAdendaVO getContratoAdendaVO() {
        return contratoAdendaVO;
    }
    
    public void setContratoAdendaServiceImpl(ContratoAdendaServiceImpl contratoAdendaServiceImpl) {
        this.contratoAdendaServiceImpl = contratoAdendaServiceImpl;
    }

    public ContratoAdendaServiceImpl    getContratoAdendaServiceImpl() {
        return contratoAdendaServiceImpl;
    }
 

    public void cargarEliminar(ContratoAdendaVO contratoAdendaVO) {
        nombre = contratoAdendaVO.getCadNombre();
        adendaId = contratoAdendaVO.getCadId();
    }

   

    public Integer getAdendaId() {
        return adendaId;
    }

    public void setAdendaId(Integer adendaId) {
        this.adendaId = adendaId;
    }
}
