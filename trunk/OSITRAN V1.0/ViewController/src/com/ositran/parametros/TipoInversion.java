package com.ositran.parametros;

import com.ositran.service.TipoInversionServices;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TipoInversionVO;
import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "tipoInversionMB")
@ViewScoped
public class TipoInversion {
    private String nombreAntiguo;
    private int codigoEliminar;
    private String nombreEliminar;
    private List<TipoInversionVO> listaInversiones;
    private String nombre;
    private String descripcion;
    private String buscar;
    private int codigoE;
    private String nombreE;
    private String descripcionE;

    @ManagedProperty(value = "#{tipoInversionVO}")
    TipoInversionVO tipoInversionVO;
    @ManagedProperty(value = "#{tipoInversionServicesImpl}")
    TipoInversionServices tipoInversionServicesImpl;

    UsuarioVO usuario=new UsuarioVO();

    public  final int formulario=1;
    private RolOpcionesVO rolOpcion;
    public void validarSesion() throws IOException{
            rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
            usuario = Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        }
    
    public void guardar() {
        int cantidad;
        cantidad=validarNombre(nombre);
        if (cantidad>0){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                              "El nombre que quiere ingresar ya existe"));
            }
        else   if (nombre.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Debe de Ingresar el Nombre"));
        } else if (descripcion.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Debe de Ingresar la Descripcion"));
        } else {
            try {
                tipoInversionVO.setTivNombre(nombre);
                tipoInversionVO.setTivDescripcion(descripcion);
                tipoInversionVO.setTivEstado(1);
                tipoInversionVO.setTivFechaAlta(new Date());
                tipoInversionVO.setTivUsuarioAlta(usuario.getUsuAlias());
                tipoInversionVO.setTivTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
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
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                                  "El nombre que quiere ingresar ya existe"));
                }
            else 
            if (nombreE.equals("")) {
                FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Debe ingresar el campo nombre");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } else if (descripcionE.equals("")) {
                FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Debe Ingresar la Descripcion");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } else {
                tipoInversionVO.setTivId(codigoE);
                tipoInversionVO.setTivNombre(nombreE);
                tipoInversionVO.setTivDescripcion(descripcionE);
                tipoInversionVO.setTivFechaCambio(new Date());
                tipoInversionVO.setTivUsuarioCambio(usuario.getUsuAlias());
                tipoInversionVO.setTivTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
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

    public void cargarEliminar() {
        try {
           FacesContext context=FacesContext.getCurrentInstance();
           Map requestMap=context.getExternalContext().getRequestParameterMap();
           Object str=requestMap.get("idEliminar");
           Integer idcodigo=Integer.valueOf(str.toString());
           tipoInversionVO=tipoInversionServicesImpl.get(idcodigo);
           tipoInversionVO.setTivEstado(0);
           tipoInversionVO.setTivUsuarioCambio(usuario.getUsuAlias());
            tipoInversionVO.setTivTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
            tipoInversionVO.setTivFechaCambio(new Date());
           nombreEliminar = tipoInversionVO.getTivNombre();
           codigoEliminar = tipoInversionVO.getTivId();
       } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void busqueda() {
        if (buscar.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          " Debe ingresar criterio de busqueda"));
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
            tipoInversionServicesImpl.update(tipoInversionVO);
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

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

}
