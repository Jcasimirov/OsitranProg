package com.ositran.parametros;

import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.ositran.util.Util;
import com.ositran.vo.bean.RolOpcionesVO;

import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.sql.SQLException;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "infraestructuraMB")
@ViewScoped

public class MantenimientoTipoInfraestructura {

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

    @ManagedProperty(value = "#{infraestructuraTipoVO}")
    private InfraestructuraTipoVO infraestructuraTipoVO;

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;


    public void validarSesion() throws IOException {
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
        tipoInfraestructuraGlobal = Reutilizar.getNewInstance().obtenerDatosEmpleadoLogueado().getTinId();
        usuario = Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
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
    public void guardar() {

        if (tinNombre.equals("")) {
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
                infraestructuraTipoVO.setTinTerminal(util.obtenerIpCliente());
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
            }

        }
    }


    /* Fin Guardar */


    /* Editar */
    public void cargarEditar(InfraestructuraTipoVO infraestructuraTipoV) {

        infraestructuraTipoVO = infraestructuraTipoV;
        codigoE = infraestructuraTipoVO.getTinId();
        tinNombreE = infraestructuraTipoVO.getTinNombre();
        tinDescripcionE = infraestructuraTipoVO.getTinDescripcion();
    }

    public void editar() throws SQLException {

        try {
            infraestructuraTipoVO.setTinId(codigoE);
            infraestructuraTipoVO.setTinNombre(tinNombreE.toUpperCase());
            infraestructuraTipoVO.setTinEstado(1);
            infraestructuraTipoVO.setTinDescripcion(tinDescripcionE.toUpperCase());
            infraestructuraTipoVO.setTinFechaCambio(new Date());
            infraestructuraTipoVO.setTinUsuarioCambio(usuario.getUsuAlias());
            getInfraestructuraTipoServiceImpl().update(infraestructuraTipoVO);
            ListarInfraestructura();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se actualizó correctamente"));
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
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

    public void cargarEliminar(int codigo, String nombre) {
        nombreEliminar = nombre;
        codigoEliminar = codigo;
    }

    public void eliminar() throws SQLException {
        try {
            getInfraestructuraTipoServiceImpl().delete(codigoEliminar);
            ListarInfraestructura();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se eliminó correctamente"));
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
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

    /* buscar  */
    String nomInfraSearch;
    private String buscar;
    private List<InfraestructuraTipoVO> filtrar;

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



    public List<InfraestructuraTipoVO> SearchListaInfra() throws SQLException {
        try {
            listaInfraestructura = this.infraestructuraTipoServiceImpl.AllSearch(nomInfraSearch);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }


        return listaInfraestructura;
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
}
