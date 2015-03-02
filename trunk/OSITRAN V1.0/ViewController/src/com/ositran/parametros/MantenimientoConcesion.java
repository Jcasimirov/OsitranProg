package com.ositran.parametros;

import com.ositran.model.Concesion;
import com.ositran.model.Infraestructura;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.service.ConcesionService;
import com.ositran.service.InfraestructuraService;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import javax.annotation.PostConstruct;

import javax.faces.bean.ViewScoped;

import org.hibernate.HibernateException;

//@ManagedBean(name = "backing_ositran_parametros_mantenimientoconcesion")
@ManagedBean(name = "backing_ositran_parametros_mantenimientoconcesion")
@ViewScoped
public class MantenimientoConcesion {


    private int codigoEliminar;
    private String nombreEliminar;
    private int codigoTipoInfraestructura;
    private int codigoTipoInfraestructuraInsert;
    private int codigoInfraestructura;
    private List<ConcesionVO> listaConcesiones;
    private List<InfraestructuraVO> listaInfraestructuras;


    private String nombre;
    private String addInfraestructura;
    private List<String> listaInfra = new ArrayList<>();


    private List<InfraestructuraTipoVO> listaInfraestructuraTipos = new ArrayList<>();

    public void setAddInfraestructura(String addInfraestructura) {
        this.addInfraestructura = addInfraestructura;
    }

    public String getAddInfraestructura() {
        return addInfraestructura;
    }

    public void agregarInfraestructuras() {
        listaInfra.add("charles");
        listaInfra.add(addInfraestructura);

    }

    //----------------EDITAR------------------------//
    private int codigoE;
    private String nombreE;
    /*  private int codigoUpdate;
    private String nombreUpdate; */


    //----------------EDITAR------------------------//

    @ManagedProperty(value = "#{concesionServicesImpl}")
    ConcesionService concesionServicesImpl;

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    private InfraestructuraServiceImpl infraestructuraServiceImpl;

    public void setInfraestructuraServiceImpl(InfraestructuraServiceImpl infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public InfraestructuraServiceImpl getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }


    public void setConcesionServicesImpl(ConcesionService concesionServicesImpl) {
        this.concesionServicesImpl = concesionServicesImpl;
    }

    public ConcesionService getConcesionServicesImpl() {
        return concesionServicesImpl;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void listarTipInfraestructura() {
        listaInfraestructuraTipos = infraestructuraTipoServiceImpl.query();
    }
    @ManagedProperty(value = "#{concesionVO}")
     ConcesionVO concesionVO;
    
    public InfraestructuraTipoVO infraestructuraTipoVO = new InfraestructuraTipoVO();

    public void guardar() {
        System.out.println("ANtessssss");
        System.out.println(codigoTipoInfraestructuraInsert);
        if (codigoTipoInfraestructuraInsert == 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha selecionado tipo de infraestructura");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (nombre.equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "no ha ingresado nombre");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            try {
                int codigogenerado = 0;
                //inicio de la carga para foreing key
                InfraestructuraTipo infraestructuraTipo1 = new InfraestructuraTipo();
                infraestructuraTipo1.setTinId(codigoTipoInfraestructuraInsert);
                concesionVO.setInfraestructuraTipo(infraestructuraTipo1);
                //finalización de la carga para foreing key
                concesionVO.setCsiNombre(nombre);
                concesionVO.setCsiEstado(1);
                concesionVO.setCsiFechaAlta(new Date());
                concesionVO.setCsiUsuarioAlta(obtenerIpCliente());
                codigogenerado = getConcesionServicesImpl().idConcesion(concesionVO);
                System.out.println("codigo generado--------------");
                System.out.println(codigogenerado);

                for (InfraestructuraVO infraestructuraVO : infraestructuras) {
                    //inicio captura fk concesion para infraestructura
                    Concesion con = new Concesion();
                    con.setCsiId(codigogenerado);
                    infraestructuraVO.setConcesion(con);
                    //fin captura fk
                    infraestructuraVO.setInfNombre(infraestructuraVO.getInfNombre());
                    infraestructuraVO.setInfUsuarioAlta(obtenerIpCliente());
                    infraestructuraVO.setInfFechaAlta(new Date());
                    infraestructuraVO.setInfEstado(1);
                    infraestructuraServiceImpl.insert(infraestructuraVO);
                    FacesMessage mensaje =
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se registro con Exito");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);

                }


                limpiarcampos();
                ListarConcesiones();
            }

            catch (Exception e) {
                System.out.println(e.getMessage());
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "A HABIADO UN ERROR" + e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, mensaje);

            }
        }

    }


    public String obtenerIpCliente() {
        String remoteAddr =
            ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
        return remoteAddr;
    }


    public void limpiar() {
        nombre = "";

    }

    public void cargarEditar() throws SQLException{
        FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("idModificar");
        Integer idcodigo=Integer.valueOf(str.toString());
        concesionVO = concesionServicesImpl.get(idcodigo);
        codigoE = concesionVO.getCsiId();
        nombreE = concesionVO.getCsiNombre();
        codigoTipoInfraestructura = concesionVO.getInfraestructuraTipo().getTinId();
        /*  codigoUpdate= infraestructuraTipoVO.getTinId();
        nombreUpdate= infraestructuraTipoVO.getTinNombre(); */
        listaInfraestructuras = infraestructuraServiceImpl.query1(concesionVO.getCsiId());
        //listaInfraestructuras = infraestructuraServiceImpl.query1(codigoE);

    }

    public void editar() throws SQLException {
        System.out.println(codigoE);
        System.out.println(nombreE);

        concesionVO.setCsiId(codigoE);
        concesionVO.setCsiNombre(nombreE);

        InfraestructuraTipo infraestructuraTipo1 = new InfraestructuraTipo();
        infraestructuraTipo1.setTinId(codigoTipoInfraestructura);
        concesionVO.setInfraestructuraTipo(infraestructuraTipo1);

        concesionVO.setCsiFechaCambio(new Date());
        concesionVO.setCsiUsuarioCambio(obtenerIpCliente());
        getConcesionServicesImpl().update(concesionVO);
        ListarConcesiones();

    }

    public void cargarEliminar(int codigo, String nombre) {
        nombreEliminar = nombre;
        codigoEliminar = codigo;
    }

    public void eliminar() {
        try {
            getConcesionServicesImpl().delete(codigoEliminar);
            ListarConcesiones();
        } catch (Exception e) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                 "No se ´pudo eliminar-Comuniquese conel departamento de sistemas");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }

    }

    public void limpiarcampos() {
        nombre = "";

    }

    public List<ConcesionVO> ListarConcesiones() {
        try {
            System.out.println("llego al MB");
            listaConcesiones = getConcesionServicesImpl().query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }


        return listaConcesiones;
    }
    /*
    public List<InfraestructuraVO> ListarInfraestructuras() {
        System.out.println("llego al MB");
        listaInfraestructuras = getInfraestructuraServiceImpl().query();
        System.out.println("Anets");

        return listaInfraestructuras;
    }
*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }

    public void setListaInversiones(List<ConcesionVO> listaConcesiones) {
        this.listaConcesiones = listaConcesiones;
    }

    public List<ConcesionVO> getListaConcesiones() {
        return listaConcesiones;
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


    public void setListaInfraestructura(List<InfraestructuraTipoVO> listaInfraestructuraTipos) {
        this.listaInfraestructuraTipos = listaInfraestructuraTipos;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructuraTipos() {
        return listaInfraestructuraTipos;
    }


    public void setListaInfra(List<String> listaInfra) {
        this.listaInfra = listaInfra;
    }

    public List<String> getListaInfra() {
        return listaInfra;
    }


    public void setCodigoTipoInfraestructura(int codigoTipoInfraestructura) {
        this.codigoTipoInfraestructura = codigoTipoInfraestructura;
    }

    public int getCodigoTipoInfraestructura() {
        return codigoTipoInfraestructura;
    }


    // -------------------------INICIO VOO CARRITO VER CLASE InfraestructuraVO--------------------------------------/
    private InfraestructuraVO infraestructura;
    private List<InfraestructuraVO> infraestructuras;

    @PostConstruct // INICIO CONSTRUCTOR VOO CARRITO VER CLASE InfraestructuraVO
    public void init() {
        infraestructura = new InfraestructuraVO();
        infraestructuras = new ArrayList<InfraestructuraVO>();
    }


    public void createNew() {
        if (infraestructuras.contains(infraestructura)) {
            FacesMessage msg = new FacesMessage("Dublicated", "This book has already been added");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            infraestructuras.add(infraestructura);
            infraestructura = new InfraestructuraVO();
        }
    }

    public String reinit() {
        infraestructura = new InfraestructuraVO();

        return null;
    }

    public List<InfraestructuraVO> getInfraestructuras() {
        return infraestructuras;
    }

    public InfraestructuraVO getInfraestructura() {
        return infraestructura;
    }

    // -------------------------FIN VOO CARRITO VER CLASE InfraestructuraVO--------------------------------------/


    // Buscar por filtro

    private String concesionbuscar;
    private int codigoTipoInfraestructurafiltro;

    public void setConcesionbuscar(String concesionbuscar) {
        this.concesionbuscar = concesionbuscar;
    }

    public String getConcesionbuscar() {
        return concesionbuscar;
    }


    public void setCodigoTipoInfraestructurafiltro(int codigoTipoInfraestructurafiltro) {
        this.codigoTipoInfraestructurafiltro = codigoTipoInfraestructurafiltro;
    }

    public int getCodigoTipoInfraestructurafiltro() {
        return codigoTipoInfraestructurafiltro;
    }

    public List<ConcesionVO> buscarconcesion() {
        try {
            listaConcesiones =
                getConcesionServicesImpl().buscarconcesionfiltro(codigoTipoInfraestructurafiltro, concesionbuscar);

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }


        return listaConcesiones;
    }


    //---------------------------------------------

    public void setListaInfraestructuras(List<InfraestructuraVO> listaInfraestructuras) {
        this.listaInfraestructuras = listaInfraestructuras;
    }

    public List<InfraestructuraVO> getListaInfraestructuras() {
        return listaInfraestructuras;
    }
    //----------------------------------------------


    public void setCodigoTipoInfraestructuraInsert(int codigoTipoInfraestructuraInsert) {
        this.codigoTipoInfraestructuraInsert = codigoTipoInfraestructuraInsert;
    }

    public int getCodigoTipoInfraestructuraInsert() {
        return codigoTipoInfraestructuraInsert;
    }


}
