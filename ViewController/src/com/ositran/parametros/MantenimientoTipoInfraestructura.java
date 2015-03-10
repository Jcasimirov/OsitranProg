package com.ositran.parametros;

import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.ositran.util.util;

import java.sql.SQLException;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "infraestructuraMB")
@RequestScoped

public class MantenimientoTipoInfraestructura {

    private String tinNombre;
    private String tinDescripcion;
    private int codigoEliminar;
    private String nombreEliminar;
    private int codigoE;
    private String tinNombreE;
    private String tinDescripcionE;

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
    util util = new util();

    public void setListaInfraestructura(List<InfraestructuraTipoVO> listaInfraestructura) {
        this.listaInfraestructura = listaInfraestructura;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructura() {
        return listaInfraestructura;
    }

    public InfraestructuraTipoVO infraestructuraTipoVO = new InfraestructuraTipoVO();

    /* Guardar */
    public void guardar() throws SQLException {

        if (tinNombre.equals("") || tinDescripcion.equals("")) {
            System.out.println("no se puede guardar");

            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No se ha completado con el Registro"));
        } else {
            try {

                infraestructuraTipoVO.setTinNombre(tinNombre.toUpperCase());
                infraestructuraTipoVO.setTinDescripcion(tinDescripcion.toUpperCase());
                infraestructuraTipoVO.setTinEstado(1);
                infraestructuraTipoVO.setTinFechaAlta(util.getObtenerFechaHoy());
                infraestructuraTipoVO.setTinTerminal(util.obtenerIpCliente());
                getInfraestructuraTipoServiceImpl().insert(infraestructuraTipoVO);
                RequestContext.getCurrentInstance().execute("popupagregar.hide()");
                limpiar();
                
                ListarInfraestructura();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                              "Se Registro con Exito"));
            } catch (Exception e) {
                // TODO: Add catch code
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
            getInfraestructuraTipoServiceImpl().update(infraestructuraTipoVO);
            ListarInfraestructura();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se Modifico con Exito"));
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
            // TODO: Add catch code
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
                                                                          "Se Elimino con Exito"));
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
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

    public void setUtil(util util) {
        this.util = util;
    }

    public util getUtil() {
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
    String desInfraSearch;
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


    public void setDesInfraSearch(String desInfraSearch) {
        this.desInfraSearch = desInfraSearch;
    }

    public String getDesInfraSearch() {
        return desInfraSearch;
    }


    public List<InfraestructuraTipoVO> SearchListaInfra() throws SQLException {
        try {
            listaInfraestructura = this.infraestructuraTipoServiceImpl.AllSearch(nomInfraSearch, desInfraSearch);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }


        return listaInfraestructura;
    }

}
