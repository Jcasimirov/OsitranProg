package com.ositran.parametros;

import com.ositran.service.TipoInversionServices;
import com.ositran.vo.bean.TipoInversionVO;

import java.sql.SQLException;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "tipoInversionMB")
@RequestScoped
public class TipoInversion {
    private int codigoEliminar;
    private String nombreEliminar;
    private List<TipoInversionVO> listaInversiones;
    private String nombre;
    private String descripcion;
    private String buscar;
    //----------------EDITAR------------------------//
    private int codigoE;
    private String nombreE;
    private String descripcionE;
    //----------------EDITAR------------------------//

    //----------------MENSAJE VALIDACION------------------------//

    @ManagedProperty(value = "#{tipoInversionServicesImpl}")
    TipoInversionServices tipoInversionServicesImpl;

    public void setTipoInversionServicesImpl(TipoInversionServices tipoInversionServicesImpl) {
        this.tipoInversionServicesImpl = tipoInversionServicesImpl;
    }

    public TipoInversionServices getTipoInversionServicesImpl() {
        return tipoInversionServicesImpl;
    }
    public TipoInversionVO tipoInversionVO = new TipoInversionVO();


    public void guardar() {

        if (nombre.equals("")) {
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

    public void limpiar() {
        nombre = "";
        descripcion = "";
    }

    public void cargarEditar(TipoInversionVO tipoInversionV) {
        TipoInversionVO tipoIn = new TipoInversionVO();
        tipoIn = tipoInversionV;
        codigoE = tipoIn.getTivId();
        nombreE = tipoIn.getTivNombre();
        descripcionE = tipoIn.getTivDescripcion();
    }

    public void editar() {
        try {
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
            System.out.println(listaInversiones.size());
            try {
                listaInversiones.clear();
                listaInversiones = getTipoInversionServicesImpl().query1(buscar);
                System.out.println(listaInversiones.size());
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
            listaInversiones = getTipoInversionServicesImpl().query();

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

}