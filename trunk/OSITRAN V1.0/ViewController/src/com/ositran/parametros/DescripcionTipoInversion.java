package com.ositran.parametros;

import com.ositran.service.InversionDescripcionServices;
import com.ositran.service.TipoInversionServices;
import com.ositran.vo.bean.InversionDescripcionVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "descripcionInversionMB")
@RequestScoped
public class DescripcionTipoInversion {
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
    //--------EDITAR-------------//
    private int codigoInversionE;
    private String nombreE;
    private String descripcionE;
    //--------EDITAR-------------//
    @ManagedProperty(value = "#{inversionDescripcionVO}")
    InversionDescripcionVO inversionDescripcionVO;

    @ManagedProperty(value = "#{inversionDescripcionServicesImpl}")
    InversionDescripcionServices inversionDescripcionServicesImpl;

    @ManagedProperty(value = "#{tipoInversionServicesImpl}")
    TipoInversionServices tipoInversionServicesImpl;

    public void guardar() {
        if (codigoInversion == 0) {
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
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro con exito");
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

    public void cargarEliminar(Integer codigo) {
        codigoInversionDescripcion = codigo;
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

    public void cargarListaInversion() {
        try {
            listTipoInversion = getTipoInversionServicesImpl().query();

        } catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",

                                                                                " No se pudo optener la lista de inversiones "));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",

                                                                                " No se pudo optener la lista de inversiones "));
        }
    }

    public void cargarEditar(InversionDescripcionVO inversionDesVO) {
        codigoInversionE = inversionDesVO.getItdId();
        nombreE = inversionDesVO.getItdNombre();
        descripcionE = inversionDesVO.getItdDescripcion();
        codigoInversion1 = inversionDesVO.getTivId();
    }

    public void editar() {

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
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Actualizo con Exito");
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
                listaInversionDescripcion = getInversionDescripcionServicesImpl().query1(buscar);
                listaInversionDescripcion.size();
                System.out.println(listaInversionDescripcion.size());
                buscar = "";
            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                              "Error",

                                                                                    " No se pudo listar las descripciones "));

            } catch (Exception e) {
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
            listaInversionDescripcion = getInversionDescripcionServicesImpl().query();

        } catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                                                          "Error",

                                                                                " No se pudo listar las descripciones "));

        } catch (Exception e) {
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
}
