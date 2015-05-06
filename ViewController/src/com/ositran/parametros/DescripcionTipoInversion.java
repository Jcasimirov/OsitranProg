package com.ositran.parametros;

import com.ositran.service.InversionDescripcionServices;
import com.ositran.service.TipoInversionServices;
import com.ositran.serviceimpl.TipoInversionServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.vo.bean.InversionDescripcionVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TipoInversionVO;

import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "descripcionInversionMB")
@ViewScoped
public class DescripcionTipoInversion {
    private String nombreAntiguo;
    private List<TipoInversionVO> listTipoInversion;
    private List<InversionDescripcionVO> listaInversionDescripcion;
    private String mensaje;
    private int tipoMensaje;
    private String buscar;
    private int codigoInversion;
    private int codigoInversion1;
    private String nombre;
    private String descripcion;
    private int codigoInversionDescripcion;
    
    //-----------------SESSION-----------------------//
   
    //--------EDITAR-------------//
    private int codigoInversionE;
    private String nombreE;
    private String descripcionE;
    //--------EDITAR-------------//
    int cantidad;
    
    public  final int formulario=21;
    private RolOpcionesVO rolOpcion;
    public void validarSesion() throws IOException{
            rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
        }
    
  
    
    
    @ManagedProperty(value = "#{inversionDescripcionVO}")
    InversionDescripcionVO inversionDescripcionVO;

    @ManagedProperty(value = "#{inversionDescripcionServicesImpl}")
    InversionDescripcionServices inversionDescripcionServicesImpl;

    @ManagedProperty(value = "#{tipoInversionServicesImpl}")
    TipoInversionServices tipoInversionServicesImpl;

    public void guardar() {
       
        cantidad=validarNombre(nombre);
        
        
        if (cantidad>0){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Advertencia",
                                                                              "El nombre que quiere ingresar ya existe"));
            }
        else  if (codigoInversion == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Advertencia",
                                                                          "Debe de Selecionar un tipo de Inversión"));
        } else if (nombre.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Advertencia",
                                                                          "Debe de Ingresar el nombre"));
        } else if (descripcion.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Advertencia",
                                                                          "Debe  de ingresar la descripción"));
        } else {
            try {
                inversionDescripcionVO.setTivId(codigoInversion);
                inversionDescripcionVO.setItdNombre(nombre);
                inversionDescripcionVO.setItdDescripcion(descripcion);
                inversionDescripcionVO.setItdEstado(1);
                inversionDescripcionVO.setItdFechaAlta(new Date());
                inversionDescripcionVO.setItdUsuarioAlta("Abel Huarca");
                inversionDescripcionServicesImpl.insert(inversionDescripcionVO);
                cargarListaInversionDescripcion();
                limpiarCampos();
                RequestContext.getCurrentInstance().execute("insertarDesc.hide()");
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró con éxito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                              "Error",
                                                                                    " No se pudo registrar la descripcion tipo inversion "));

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                              "Error",
                                                                                    " No se pudo registrar la descripcion tpo inversion "));
            }

        }

    }

    public void cargarEliminar() {
        try {
           FacesContext context=FacesContext.getCurrentInstance();
           Map requestMap=context.getExternalContext().getRequestParameterMap();
           Object str=requestMap.get("idEliminar");
           Integer idcodigo=Integer.valueOf(str.toString());
           inversionDescripcionVO=inversionDescripcionServicesImpl.get(idcodigo);
           codigoInversionDescripcion = inversionDescripcionVO.getItdId();
       } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",
                                                                                " Problemas al intentar Eliminar "));
        }
      
    }

    public void eliminar() {
        try {
            getInversionDescripcionServicesImpl().delete(codigoInversionDescripcion);
            cargarListaInversionDescripcion();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se elimino con Exito");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",
                                                                                " No se pudo eliminar la descripcion tipo inversion "));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",
                                                                                " No se pudo eliminar la descripcion tpo inversion "));
        }

    }
    public int validarNombre(String nombre){
            int cantidad=0;

        try {
           cantidad=inversionDescripcionServicesImpl.getCanNombres(nombre);
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
    public void cargarListaInversion() {
        try {
            listTipoInversion = getTipoInversionServicesImpl().query();
            
            

        } catch (SQLException s) {
            s.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",
                                                                                " No se pudo optener la lista de inversiones "));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",
                                                                                " No se pudo optener la lista de inversiones "));
        }
    }

    public void cargarEditar() {
        try {
                
               FacesContext context=FacesContext.getCurrentInstance();
               Map requestMap=context.getExternalContext().getRequestParameterMap();
               Object str=requestMap.get("idModificar");
               Integer idcodigo=Integer.valueOf(str.toString());
               inversionDescripcionVO=inversionDescripcionServicesImpl.get(idcodigo);
                codigoInversionE=inversionDescripcionVO.getItdId();
                nombreAntiguo=inversionDescripcionVO.getItdNombre();
                nombreE=inversionDescripcionVO.getItdNombre();
                descripcionE=inversionDescripcionVO.getItdDescripcion();
                codigoInversion1=inversionDescripcionVO.getTivId();
            
              
            
       }
        catch (SQLException s) {
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",

                                                                                       " No se realizo la actualizacion "));

               } catch (Exception e) {
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",

                                                                                       " No se realizo la actualizacion "));
               }
        
            
    }

    public void editar() {
        int cantidad;
        cantidad=validarNombre(nombreE);
        if (cantidad>0 && !nombreAntiguo.equals(nombreE)){
                FacesContext.getCurrentInstance().addMessage(null,
                                 new FacesMessage(FacesMessage.SEVERITY_FATAL, "Advertencia",
                                "El nuevo nombre que quiere ingresar ya existe"));
            }
        else 
        if (codigoInversionE == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe de Selecionar un tipo de Inversión"));
        } else if (nombreE.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "Debe de Ingresar el nombre"));
        } else if (descripcionE.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                                                                          "Debe  de ingresar la descripción"));
        }else {
        try {
            inversionDescripcionVO.setItdId(codigoInversionE);
            inversionDescripcionVO.setItdNombre(nombreE);
            inversionDescripcionVO.setItdDescripcion(descripcionE);
            inversionDescripcionVO.setItdUsuarioCambio("Abel Huarca");
            inversionDescripcionVO.setItdFechaCambio(new Date());
            getInversionDescripcionServicesImpl().update(inversionDescripcionVO);
            cargarListaInversionDescripcion();
            RequestContext.getCurrentInstance().execute("editarPanel.hide()");
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se actualizó con éxito");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",

                                                                                " No se realizo la actualizacion "));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",

                                                                                " No se realizo la actualizacion "));
        }
        }
    }

    public void busqueda() {
        if (buscar.equals(null)) {
            cargarListaInversion();
        } else {
            try {
                int contador=1;
            listaInversionDescripcion = getInversionDescripcionServicesImpl().query1(buscar);
                for(int i=0;i<listaInversionDescripcion.size();i++){
                  listaInversionDescripcion.get(i).setContador(contador);
                    contador++;
                
                }
               
                
                buscar = "";
            } catch (SQLException s) {
                s.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                              "Error",

                                                                                    " No se pudo listar las descripciones "));

            } catch (Exception e) {
                e.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                              "Error",

                                                                                    " No se pudo listar las descripciones "));
            }

        }
    }

    public void limpiarCampos() {
        nombre = "";
        descripcion = "";
        codigoInversion = 0;
    }

    public void cargarListaInversionDescripcion() {
        try {
            int contador=1;
            listaInversionDescripcion = getInversionDescripcionServicesImpl().query();
            
            for (InversionDescripcionVO descripcionTipo: listaInversionDescripcion){
                TipoInversionServiceImpl tipoInversionServiceImpl= new TipoInversionServiceImpl();
                TipoInversionVO tipoInversion1=tipoInversionServicesImpl.get(descripcionTipo.getTivId());
                descripcionTipo.setNombreTI(tipoInversion1.getTivNombre());
                descripcionTipo.setContador(contador);
                contador++;
                }
           
        } catch (SQLException s) {
            s.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",

                                                                                " No se pudo listar las descripciones "));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",

                                                                                " No se pudo listar las descripciones "));
        }
    }

    public void setInversionDescripcionVO(InversionDescripcionVO inversionDescripcionVO) {
        this.inversionDescripcionVO = inversionDescripcionVO;
    }

    public InversionDescripcionVO getInversionDescripcionVO() {
        return inversionDescripcionVO;
    }

    public void setCodigoInversion(int codigoInversion) {
        this.codigoInversion = codigoInversion;
    }

    public int getCodigoInversion() {
        return codigoInversion;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getBuscar() {
        return buscar;
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

    public void setListaInversionDescripcion(List<InversionDescripcionVO> listaInversionDescripcion) {
        this.listaInversionDescripcion = listaInversionDescripcion;
    }

    public List<InversionDescripcionVO> getListaInversionDescripcion() {
        return listaInversionDescripcion;
    }

    public void setInversionDescripcionServicesImpl(InversionDescripcionServices inversionDescripcionServicesImpl) {
        this.inversionDescripcionServicesImpl = inversionDescripcionServicesImpl;
    }

    public InversionDescripcionServices getInversionDescripcionServicesImpl() {
        return inversionDescripcionServicesImpl;
    }

    public void setListTipoInversion(List<TipoInversionVO> listTipoInversion) {
        this.listTipoInversion = listTipoInversion;
    }

    public List<TipoInversionVO> getListTipoInversion() {
        return listTipoInversion;
    }

    public void setTipoInversionServicesImpl(TipoInversionServices tipoInversionServicesImpl) {
        this.tipoInversionServicesImpl = tipoInversionServicesImpl;
    }

    public TipoInversionServices getTipoInversionServicesImpl() {
        return tipoInversionServicesImpl;
    }

    public void setCodigoInversionDescripcion(int codigoInversionDescripcion) {
        this.codigoInversionDescripcion = codigoInversionDescripcion;
    }

    public int getCodigoInversionDescripcion() {
        return codigoInversionDescripcion;
    }

    public void setCodigoInversionE(int codigoInversionE) {
        this.codigoInversionE = codigoInversionE;
    }

    public int getCodigoInversionE() {
        return codigoInversionE;
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

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setTipoMensaje(int tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public int getTipoMensaje() {
        return tipoMensaje;
    }

    public void setCodigoInversion1(int codigoInversion1) {
        this.codigoInversion1 = codigoInversion1;
    }

    public int getCodigoInversion1() {
        return codigoInversion1;
    }

    public void setNombreAntiguo(String nombreAntiguo) {
        this.nombreAntiguo = nombreAntiguo;
    }

    public String getNombreAntiguo() {
        return nombreAntiguo;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }
}
