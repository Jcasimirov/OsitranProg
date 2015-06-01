package com.ositran.parametros;

import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.util.Util;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "infraestructuraMB")
@ViewScoped

public class MantenimientoTipoInfraestructura {
    private String nombreAntiguo;
    private String tinNombre;
    private String tinDescripcion;
    private int codigoEliminar;
    private String nombreEliminar;
    private int codigoE;
    private String tinNombreE;
    private String tinDescripcionE;
    public final int formulario = 9;
    private RolOpcionesVO rolOpcion;
    private UsuarioVO usuario;
    private int tipoInfraestructura;
    private int tipoInfraestructuraGlobal;

    private int idEliminar;

    /* buscar  */
    String nomInfraSearch;
    private String buscar;
    private List<InfraestructuraTipoVO> filtrar;
    
    
    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    private InfraestructuraTipoVO infraestructuraTipoVO;

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;


    //Listas
    List<InfraestructuraTipoVO> listaMod;

    public void validarSesion() throws IOException {
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
        usuario = Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        tipoInfraestructuraGlobal = usuario.getTinId();
        tipoInfraestructura = usuario.getTinId();

    }


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
    Util util = new Util();

    public void setListaInfraestructura(List<InfraestructuraTipoVO> listaInfraestructura) {
        this.listaInfraestructura = listaInfraestructura;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructura() {
        return listaInfraestructura;
    }


    /* Guardar */
    public int validarNombre(String tinNombre){
            int cantidad=0;

        try {
           cantidad=infraestructuraTipoServiceImpl.getCanNombres(tinNombre);
       } catch ( Exception e){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",                                                                           
                                                                              " No se pudo validar el nombre de tipo de infraestructura "));
            }
        return cantidad;
        }
    public void guardar() {
        int cantidad;
        cantidad=validarNombre(tinNombre);
        if (cantidad>0){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                              "El tipo de Infraestructura que quiere ingresar ya existe"));
        } else if (tinNombre.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Debe ingresar el nombre"));
        } else if (tinDescripcion.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Debe ingresar la descripción"));
        } else {
            try {

                infraestructuraTipoVO.setTinNombre(tinNombre.toUpperCase());
                infraestructuraTipoVO.setTinDescripcion(tinDescripcion.toUpperCase());
                infraestructuraTipoVO.setTinEstado(1);
                infraestructuraTipoVO.setTinFechaAlta(util.getObtenerFechaHoy());
                infraestructuraTipoVO.setTinTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
                infraestructuraTipoVO.setTinUsuarioAlta(usuario.getUsuAlias());
                getInfraestructuraTipoServiceImpl().insert(infraestructuraTipoVO);
                RequestContext.getCurrentInstance().execute("popupagregar.hide()");
                limpiar();

                ListarInfraestructura();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                              "Se agregó exitosamente"));
            } catch (SQLException e) {
                e.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error",
                                                                              " No se pudo guardar el tipo de infraestructura "));
            }

        }
    }
    /* Fin Guardar */


    /* Editar */
    public void cargarEditar() {
        
        try {
            //inicio de captura de codigo a modificar
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            Object str = requestMap.get("idModificar");
            Integer idcodigo = Integer.valueOf(str.toString());
            infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(idcodigo);
            //fin de de captura de codigo a modificar
            codigoE = infraestructuraTipoVO.getTinId();
            nombreAntiguo = infraestructuraTipoVO.getTinNombre();
            tinNombreE = infraestructuraTipoVO.getTinNombre();
            tinDescripcionE = infraestructuraTipoVO.getTinDescripcion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar() {
        int cantidad;
        cantidad=validarNombre(tinNombreE);        
        if (cantidad>0 && !nombreAntiguo.equals(tinNombreE)){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                              "El nombre de tipo Infraestructura que quiere ingresar ya existe"));
        }else if (tinNombreE.trim().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Debe ingresar el nombre"));
        } else if (tinDescripcionE.trim().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Debe ingresar la descripción"));
        } else{
        try {
            infraestructuraTipoVO.setTinId(codigoE);
            infraestructuraTipoVO.setTinNombre(tinNombreE.toUpperCase());
            infraestructuraTipoVO.setTinEstado(1);
            infraestructuraTipoVO.setTinDescripcion(tinDescripcionE.toUpperCase());
            infraestructuraTipoVO.setTinFechaCambio(new Date());
            infraestructuraTipoVO.setTinUsuarioCambio(usuario.getUsuAlias());
            getInfraestructuraTipoServiceImpl().update(infraestructuraTipoVO);
            RequestContext.getCurrentInstance().execute("popupeditar.hide()");
            ListarInfraestructura();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se actualizó correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error",
                                                                          " No se pudo editar el tipo de infraestructura "));
        }
        }
    }
    /* Fin Editar */

    public void limpiar() {
        tinNombre = " ";
        tinDescripcion = " ";
    }

    public List<InfraestructuraTipoVO> ListarInfraestructura() throws SQLException {
        try {
            listaInfraestructura = getInfraestructuraTipoServiceImpl().query();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaInfraestructura;
    }

    public void getQuery() throws SQLException {
        listaMod = this.infraestructuraTipoServiceImpl.query();
    }

    public void cargarEliminar() {
        try {

            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            Object str = requestMap.get("idEliminar");
            Integer idInfra = Integer.valueOf(str.toString());
            infraestructuraTipoVO = this.infraestructuraTipoServiceImpl.get(idInfra);
            idEliminar = infraestructuraTipoVO.getTinId();
            nombreEliminar = infraestructuraTipoVO.getTinNombre().toUpperCase();

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

    }

    public void eliminar() throws SQLException {
        try {
            boolean codigoValido = infraestructuraTipoServiceImpl.validarCodigoEnUso(idEliminar);
            if (codigoValido) {
                infraestructuraTipoVO = infraestructuraTipoServiceImpl.get(idEliminar);
                infraestructuraTipoVO.setTinEstado(0);
                infraestructuraTipoVO.setTinTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
                infraestructuraTipoVO.setTinUsuarioBaja(usuario.getUsuAlias());
                infraestructuraTipoVO.setTinUsuarioCambio(usuario.getUsuAlias());
                infraestructuraTipoVO.setTinFechaBaja(util.getObtenerFechaHoy());
                this.infraestructuraTipoServiceImpl.update(infraestructuraTipoVO);
                getQuery();
                ListarInfraestructura();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                              "Se eliminó correctamente"));
            } else {
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                     "No se puede Eliminar porque el Tipo de Infraestructura esta en Uso!");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrió un Error" + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensaje);

        }


    }


    public void cargarTodo() {
        try {
            int contador = 1;
            listaInfraestructura = infraestructuraTipoServiceImpl.query();
            for (int i = 0; i < listaInfraestructura.size(); i++) {
                listaInfraestructura.get(i).setContador(contador);
                contador++;
            }


        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " No se pudo listar"));
        }

    }
    
    
    public List<InfraestructuraTipoVO> SearchListaInfra() throws SQLException {
        if(nomInfraSearch.trim().equals("")){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                              "Ingresar criterio de busqueda"));
            }
        else{
        try {
            listaInfraestructura = this.infraestructuraTipoServiceImpl.AllSearch(nomInfraSearch);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        }

        return listaInfraestructura;
  }


    public void setTinNombre(String tinNombre) {
        this.tinNombre = tinNombre;
    }

    public String getTinNombre() {
        return tinNombre;
    }

    public void setTinDescripcion(String tinDescripcion) {
        this.tinDescripcion = tinDescripcion;
    }

    public String getTinDescripcion() {
        return tinDescripcion;
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

    public void setUtil(Util util) {
        this.util = util;
    }

    public Util getUtil() {
        return util;
    }

    public void setTinNombreE(String tinNombreE) {
        this.tinNombreE = tinNombreE;
    }

    public String getTinNombreE() {
        return tinNombreE;
    }

    public void setTinDescripcionE(String tinDescripcionE) {
        this.tinDescripcionE = tinDescripcionE;
    }

    public String getTinDescripcionE() {
        return tinDescripcionE;
    }

    public void setCodigoE(int codigoE) {
        this.codigoE = codigoE;
    }

    public int getCodigoE() {
        return codigoE;
    }

    public void setFiltrar(List<InfraestructuraTipoVO> filtrar) {
        this.filtrar = filtrar;
    }

    public List<InfraestructuraTipoVO> getFiltrar() {
        return filtrar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setNomInfraSearch(String nomInfraSearch) {
        this.nomInfraSearch = nomInfraSearch;
    }

    public String getNomInfraSearch() {
        return nomInfraSearch;
    }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setTipoInfraestructura(int tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public int getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setTipoInfraestructuraGlobal(int tipoInfraestructuraGlobal) {
        this.tipoInfraestructuraGlobal = tipoInfraestructuraGlobal;
    }

    public int getTipoInfraestructuraGlobal() {
        return tipoInfraestructuraGlobal;
    }

    public void setIdEliminar(int idEliminar) {
        this.idEliminar = idEliminar;
    }

    public int getIdEliminar() {
        return idEliminar;
    }

    public void setListaMod(List<InfraestructuraTipoVO> listaMod) {
        this.listaMod = listaMod;
    }

    public List<InfraestructuraTipoVO> getListaMod() {
        return listaMod;
    }

    public void setNombreAntiguo(String nombreAntiguo) {
        this.nombreAntiguo = nombreAntiguo;
    }

    public String getNombreAntiguo() {
        return nombreAntiguo;
    }

}
