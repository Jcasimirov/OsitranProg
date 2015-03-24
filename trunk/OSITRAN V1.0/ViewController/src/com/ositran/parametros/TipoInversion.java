package com.ositran.parametros;

import com.ositran.service.TipoInversionServices;
import com.ositran.vo.bean.MenVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TipoDocumentoVO;
import com.ositran.vo.bean.TipoInversionVO;

import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.sql.SQLException;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import java.util.Map;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "tipoInversionMB")
@RequestScoped
public class TipoInversion {
    private String nombreAntiguo;
    private int codigoEliminar;
    private String nombreEliminar;
    private List<TipoInversionVO> listaInversiones;
    private String nombre;
    private String descripcion;
    private String buscar;
    
    //-----------------SESSION-----------------------//
    public  final int formulario=1;
    private  HttpServletRequest httpServletRequest=null;
    private  FacesContext faceContext=null;
     private   int leerSesion;
    private   int ingresarSesion;
    private  int eliminarSesion;
    private   int actualizarSesion;
    private List<RolOpcionesVO> listaRolOpciones=new ArrayList<>();
    private List<UsuarioVO> listaUsuarios=new ArrayList<>();
    private String parametroValidacion;
      
    //----------------EDITAR------------------------//
    private int codigoE;
    private String nombreE;
    private String descripcionE;
    
   
    @ManagedProperty(value = "#{tipoInversionVO}")
    TipoInversionVO tipoInversionVO;
    @ManagedProperty(value = "#{tipoInversionServicesImpl}")
    TipoInversionServices tipoInversionServicesImpl;


    public void validarSesion() throws IOException{
        
        try {
           faceContext=FacesContext.getCurrentInstance();
           httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
           HttpSession session = httpServletRequest.getSession();
           listaUsuarios=(List<UsuarioVO>)session.getAttribute("listaUsuario");
           listaRolOpciones=(List<RolOpcionesVO>)session.getAttribute("listaPermisos");
          
            for (RolOpcionesVO rolO:listaRolOpciones){
                if (rolO.getMenId()==formulario){
                    parametroValidacion="true";
                    }
                }
           
            if (!"true".equals(parametroValidacion)) {
                    
                    FacesContext context = FacesContext.getCurrentInstance();
                    ExternalContext externalContext = context.getExternalContext();
                    ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
                    faceContext=FacesContext.getCurrentInstance();
                    httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
                     String redirectPath = "/faces/ositran/logueo.xhtml";
                     externalContext.redirect(servletContext.getContextPath() + redirectPath);
                }
            else {
                
                for (RolOpcionesVO rolOpcion:listaRolOpciones){
                    if (rolOpcion.getMenId()==formulario){
                        leerSesion=rolOpcion.getTroConsultar();
                        ingresarSesion=rolOpcion.getTroAgregar();
                        actualizarSesion=rolOpcion.getTroModificar();
                        eliminarSesion=rolOpcion.getTroEliminar();

                        }
                    }
                
                
                }
          
           
       } catch (Exception e) {
            e.printStackTrace();
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            faceContext=FacesContext.getCurrentInstance();
            httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
             String redirectPath = "/faces/ositran/logueo.xhtml";
             externalContext.redirect(servletContext.getContextPath() + redirectPath);
        }
            
            
        
        
        
        
        }
    public void guardar() {
        int cantidad;
        cantidad=validarNombre(nombre);
        if (cantidad>0){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Advertencia",
                                                                              "El nombre que quiere ingresar ya existe"));
            }
        else   if (nombre.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe de Ingresar el Nombre"));
        } else if (descripcion.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe de Ingresar la Descripcion"));
        } else {
            try {
                tipoInversionVO.setTivNombre(nombre);
                tipoInversionVO.setTivDescripcion(descripcion);
                tipoInversionVO.setTivEstado(1);
                tipoInversionVO.setTivFechaAlta(new Date());
                tipoInversionVO.setTivUsuarioAlta("Abel Huarca");
                getTipoInversionServicesImpl().insert(tipoInversionVO);
                limpiarcamposInsertar();
                RequestContext.getCurrentInstance().execute("insertarPanel.hide()");
                ListarInversiones();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                              "Se Registro con Exito"));
            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar el tipo de inversion "));

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar el tipo de inversion "));
            }
        }
    }

    public int validarNombre(String nombre){
            int cantidad=0;

        try {
           cantidad=tipoInversionServicesImpl.getCanNombres(nombre);
       } catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                        
                                                                          " No se pudo validar el nombre "));  
        } 
        catch ( Exception e){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                            
                                                                              " No se pudo validar el nombre "));
            }
        return cantidad;
        }
    public void limpiar() {
        nombre = "";
        descripcion = "";
    }

    public void cargarEditar() {
        try {
           FacesContext context=FacesContext.getCurrentInstance();
           Map requestMap=context.getExternalContext().getRequestParameterMap();
           Object str=requestMap.get("idModificar");
           Integer idcodigo=Integer.valueOf(str.toString());
           tipoInversionVO=tipoInversionServicesImpl.get(idcodigo);
           nombreAntiguo = tipoInversionVO.getTivNombre();
           codigoE = tipoInversionVO.getTivId();
           nombreE = tipoInversionVO.getTivNombre();
           descripcionE = tipoInversionVO.getTivDescripcion();
       }catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " No se pudo cargar los datos de edicion "));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "  No se pudo cargar los datos de edicion"));

        }

    }

    public void editar() {
        try {
            int cantidad;
            cantidad=validarNombre(nombreE);        
            if (cantidad>0 && !nombreAntiguo.equals(nombreE)){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_FATAL, "Advertencia",
                                                                                  "El nombre que quiere ingresar ya existe"));
                }
            else 
            if (nombreE.equals("")) {
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Debe ingresar el campo nombre");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } else if (descripcionE.equals("")) {
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Debe Ingresar la Descripcion");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } else {
                tipoInversionVO.setTivId(codigoE);
                tipoInversionVO.setTivNombre(nombreE);
                tipoInversionVO.setTivDescripcion(descripcionE);
                tipoInversionVO.setTivFechaCambio(new Date());
                tipoInversionVO.setTivUsuarioCambio("Editor");

                getTipoInversionServicesImpl().update(tipoInversionVO);
                ListarInversiones();
                RequestContext.getCurrentInstance().execute("editarPanel.hide()");
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Actualizo con Exito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        } catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " No se pudo registrar el tipo de inversion "));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " No se pudo registrar el tipo de inversion "));

        }

    }

    public void cargarEliminar(int codigo, String nombre) {
        nombreEliminar = nombre;
        codigoEliminar = codigo;
    }

    public void busqueda() {
        if (buscar.equals(null)) {
            ListarInversiones();
        } else {
            
            try {
                listaInversiones.clear();
                
                int contador=1;
                listaInversiones = getTipoInversionServicesImpl().query1(buscar);
                
                
                for(int i=0;i<listaInversiones.size();i++){
                  listaInversiones.get(i).setContador(contador);
                    contador++;
                    }
                
                
                
                buscar = "";
            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar el tipo de inversion "));

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " No se pudo registrar el tipo de inversion "));
            }
        }
    }


    public void eliminar() {
        try {
            getTipoInversionServicesImpl().delete(codigoEliminar);
            ListarInversiones();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se elimino con Exito");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " No se pudo registrar el tipo de inversion "));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " No se pudo registrar el tipo de inversion "));
        }

    }

    public void limpiarcamposInsertar() {
        nombre = "";
        descripcion = "";
    }

    public List<TipoInversionVO> ListarInversiones() {
        try {
            
            int contador=1;
            listaInversiones = getTipoInversionServicesImpl().query();
            
            
            for(int i=0;i<listaInversiones.size();i++){
              listaInversiones.get(i).setContador(contador);
                contador++;
                }
            
            
            

        } catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " No se pudo registrar el tipo de inversion "));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " No se pudo registrar el tipo de inversion "));
        }
        return listaInversiones;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setTipoInversionVO(TipoInversionVO tipoInversionVO) {
        this.tipoInversionVO = tipoInversionVO;
    }

    public TipoInversionVO getTipoInversionVO() {
        return tipoInversionVO;
    }

    public void setListaInversiones(List<TipoInversionVO> listaInversiones) {
        this.listaInversiones = listaInversiones;
    }

    public List<TipoInversionVO> getListaInversiones() {
        return listaInversiones;
    }

    public void setCodigoEliminar(int codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }

    public int getCodigoEliminar() {
        return codigoEliminar;
    }

    public void setNombreEliminar(String nombreEliminar) {
        this.nombreEliminar = nombreEliminar;
    }

    public String getNombreEliminar() {
        return nombreEliminar;
    }

    public void setCodigoE(int codigoE) {
        this.codigoE = codigoE;
    }

    public int getCodigoE() {
        return codigoE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setNombreAntiguo(String nombreAntiguo) {
        this.nombreAntiguo = nombreAntiguo;
    }

    public String getNombreAntiguo() {
        return nombreAntiguo;
    }
    public void setTipoInversionServicesImpl(TipoInversionServices tipoInversionServicesImpl) {
        this.tipoInversionServicesImpl = tipoInversionServicesImpl;
    }

    public TipoInversionServices getTipoInversionServicesImpl() {
        return tipoInversionServicesImpl;
    }


    public void setLeerSesion(int leerSesion) {
        this.leerSesion = leerSesion;
    }

    public int getLeerSesion() {
        return leerSesion;
    }

    public void setIngresarSesion(int ingresarSesion) {
        this.ingresarSesion = ingresarSesion;
    }

    public int getIngresarSesion() {
        return ingresarSesion;
    }

    public void setEliminarSesion(int eliminarSesion) {
        this.eliminarSesion = eliminarSesion;
    }

    public int getEliminarSesion() {
        return eliminarSesion;
    }

    public void setActualizarSesion(int actualizarSesion) {
        this.actualizarSesion = actualizarSesion;
    }

    public int getActualizarSesion() {
        return actualizarSesion;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setFaceContext(FacesContext faceContext) {
        this.faceContext = faceContext;
    }

    public FacesContext getFaceContext() {
        return faceContext;
    }

    public void setListaRolOpciones(List<RolOpcionesVO> listaRolOpciones) {
        this.listaRolOpciones = listaRolOpciones;
    }

    public List<RolOpcionesVO> getListaRolOpciones() {
        return listaRolOpciones;
    }

    public void setListaUsuarios(List<UsuarioVO> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<UsuarioVO> getListaUsuarios() {
        return listaUsuarios;
    }


    public void setParametroValidacion(String parametroValidacion) {
        this.parametroValidacion = parametroValidacion;
    }

    public String getParametroValidacion() {
        return parametroValidacion;
    }


}
