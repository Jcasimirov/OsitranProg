package com.ositran.parametros;


import com.ositran.model.Concesion;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import javax.annotation.PostConstruct;

import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

//@ManagedBean(name = "backing_ositran_parametros_mantenimientoconcesion")
@ManagedBean(name = "mantenimientoconcesionMB")
@ViewScoped

public class MantenimientoConcesion {

    int contador = 0;
    private int codigoE;
    private String nombreE;
    private String nombre;
    private String addInfraestructura;
    private String nombreEliminar;
    private int codigoEliminar;
    private int codigoTipoInfraestructura;
    private int codigoTipoInfraestructuraInsert;
    private int codigoInfraestructura;
    private int codigoCarritoConcesion;
    List<InfraestructuraVO> listaEliminarInfraestructura = new ArrayList<>();
    List<InfraestructuraVO> listaAgregarInfraestructura = new ArrayList<>();
    private int codigoConcesionNuevo;
    private String nombreInfraestructuraNueva;
    private String nombreInfraestructura;
    private int codigoConcesion;
    private String nombreConcesion;
    List<ConcesionVO> listaConcesiones;
    List<InfraestructuraVO> listaInfraestructuras;
    List<InfraestructuraVO> listaInfraestructurasBD;
    List<InfraestructuraVO> lis;
    private List<String> listaInfra = new ArrayList<>();
    private List<InfraestructuraTipoVO> listaInfraestructuraTipos = new ArrayList<>();


    List<String> listaAgregarInfra = new ArrayList<>();
    List<String> listaQuitarInfra = new ArrayList<>();

    @ManagedProperty(value = "#{concesionServicesImpl}")
    ConcesionServiceImpl concesionServicesImpl;

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    private InfraestructuraServiceImpl infraestructuraServiceImpl;

    @ManagedProperty(value = "#{concesionVO}")
    ConcesionVO concesionVO;

    @ManagedProperty(value = "#{infraestructuraVO}")
    InfraestructuraVO infraestructuraVO;


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


                }


                RequestContext.getCurrentInstance().execute("insertarPanel.hide()");
                infraestructuras.clear();

                RequestContext.getCurrentInstance().execute("window.location.reload()");


                listaInfraestructuraTipos = new ArrayList<InfraestructuraTipoVO>();


                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se registro con Exito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);


            }

            catch (Exception e) {
                System.out.println(e.getMessage());
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "A HABIADO UN ERROR" + e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, mensaje);

            }
        }
    }


    public void cargarEditar() throws SQLException {

        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idModificar");
        Integer idcodigo = Integer.valueOf(str.toString());
        concesionVO =
            concesionServicesImpl.get(idcodigo); //OJO IMPORTANTE AQUI ES DONDE TIENE CARGADO EL VO DE TODOS LOS OBJETOS
        //fin de de captura de codigo a modificar

        codigoE = concesionVO.getCsiId();
        nombreE = concesionVO.getCsiNombre();


        codigoTipoInfraestructura = concesionVO.getInfraestructuraTipo().getTinId();
        /*  codigoUpdate= infraestructuraTipoVO.getTinId();
        nombreUpdate= infraestructuraTipoVO.getTinNombre(); */
        listaInfraestructuras = infraestructuraServiceImpl.query1(concesionVO.getCsiId());
        //listaInfraestructuras = infraestructuraServiceImpl.query1(codigoE);

    }


    public void cargarEliminar(int codigo, String nombre) {
        nombreEliminar = nombre;
        codigoEliminar = codigo;
    }

    public void setAddInfraestructura(String addInfraestructura) {
        this.addInfraestructura = addInfraestructura;
    }

    public String getAddInfraestructura() {
        return addInfraestructura;
    }

    public void agregarInfraestructuras() {
        listaInfra.add(addInfraestructura);

    }


    public void setInfraestructuraServiceImpl(InfraestructuraServiceImpl infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public InfraestructuraServiceImpl getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }


    public void setConcesionServicesImpl(ConcesionServiceImpl concesionServicesImpl) {
        this.concesionServicesImpl = concesionServicesImpl;
    }

    public ConcesionServiceImpl getConcesionServicesImpl() {
        return concesionServicesImpl;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void listarTipInfraestructura() {
        try {
            listaInfraestructuraTipos = infraestructuraTipoServiceImpl.query();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ListarInfraestructuras() {
        try {
            listaInfraestructuras = infraestructuraServiceImpl.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

    }


    public void setNombreInfraestructuraNueva(String nombreInfraestructuraNueva) {
        this.nombreInfraestructuraNueva = nombreInfraestructuraNueva;
    }

    public String getNombreInfraestructuraNueva() {
        return nombreInfraestructuraNueva;
    }

    public void setCodigoCarritoConcesion(int codigoCarritoConcesion) {
        this.codigoCarritoConcesion = codigoCarritoConcesion;
    }

    public int getCodigoCarritoConcesion() {
        return codigoCarritoConcesion;
    }

    public void setInfraestructuraVO(InfraestructuraVO infraestructuraVO) {
        this.infraestructuraVO = infraestructuraVO;
    }

    public InfraestructuraVO getInfraestructuraVO() {
        return infraestructuraVO;
    }

    public InfraestructuraTipoVO infraestructuraTipoVO = new InfraestructuraTipoVO();


    public List<ConcesionVO> ListarConcesiones() {
        try {
            System.out.println("llego al MB");
            listaConcesiones = getConcesionServicesImpl().query();
            int contador = 1;
            for (ConcesionVO conc : listaConcesiones) {
                conc.setCorrela(contador);
                contador++;
            }

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }


        return listaConcesiones;
    }

    public void resetear() {
        //   infraestructura.getConcesion().setCsiNombre(""); //para el carrito resetear nombre
    }

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

    public String obtenerIpCliente() {
        String remoteAddr =
            ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
        return remoteAddr;
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
            FacesMessage mensaje2 = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "A HABIADO UN ERROR");
            FacesContext.getCurrentInstance().addMessage(null, mensaje2);
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

            int contador = 1;
            for (ConcesionVO conc : listaConcesiones) {
                conc.setCorrela(contador);
                contador++;
            }


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


    ////////////////////////////////////////////ELIMINAR INFRAESTRUCTURA/////////////////////////////7
    public void cargarEliminarInfraestructura() throws SQLException {
        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idEliminarInfraestructura");
        Integer idcodigo = Integer.valueOf(str.toString());
        infraestructuraVO = infraestructuraServiceImpl.get2(idcodigo);
        //fin de de captura de codigo a modificar
        codigoInfraestructura = infraestructuraVO.getInfId();
        nombreInfraestructura = infraestructuraVO.getInfNombre();

        listaInfraestructuras = infraestructuraServiceImpl.query1(concesionVO.getCsiId());
    }

    public void eliminacionConfirmadaInfraestructura() {
        try {

            infraestructuraVO.setInfEstado(0);
            infraestructuraVO.setInfNombre(nombreInfraestructura);
            infraestructuraVO.setInfId(codigoInfraestructura);
            infraestructuraServiceImpl.update(infraestructuraVO);

            listaInfraestructuras = infraestructuraServiceImpl.query1(concesionVO.getCsiId());
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

    }
    ////////////FIN ELIMINAR INFRAESTRUCTURA
    //////////////////////////ELIMINAR CONCESION/////////////////////////

    public void cargarEliminarConcesion() throws SQLException {

        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idEliminarConcesion");
        Integer idcodigo = Integer.valueOf(str.toString());
        concesionVO = concesionServicesImpl.get(idcodigo);
        //fin de de captura de codigo a modificar
        codigoConcesion = concesionVO.getCsiId();
        nombreConcesion = concesionVO.getCsiNombre();


    }

    public void eliminacionConfirmadaConcesion() throws SQLException {

        concesionVO.setCsiEstado(0);
        concesionVO.setCsiNombre(nombreConcesion);
        concesionVO.setCsiId(concesionVO.getCsiId());
        concesionServicesImpl.update(concesionVO);


        ListarConcesiones();

    }


    public void agregacionConfirmadaInfraestructura() throws SQLException {
        //inicio de captura de codigo a modificar
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("codNuevoConcesion");
        Integer idcodigo = Integer.valueOf(str.toString());
        concesionVO =
            concesionServicesImpl.get(idcodigo); //OJO IMPORTANTE AQUI ES DONDE TIENE CARGADO EL VO DE TODOS LOS OBJETOS
        //fin de de captura de codigo a modificar
        codigoE = concesionVO.getCsiId();
        nombreE = concesionVO.getCsiNombre();
        infraestructuraVO.setInfNombre(nombreInfraestructuraNueva);
        //inicio captura fk concesion para infraestructura
        Concesion con = new Concesion();
        con.setCsiId(codigoE);
        infraestructuraVO.setConcesion(con);
        //fin captura fk

        infraestructuraVO.setInfFechaCambio(new Date());
        infraestructuraVO.setInfEstado(1);
        infraestructuraServiceImpl.insert(infraestructuraVO);
        listaInfraestructuras = infraestructuraServiceImpl.query1(concesionVO.getCsiId());

        //listaInfraestructuras = infraestructuraServiceImpl.query1(concesionVO.getCsiId());

        //RequestContext.getCurrentInstance().execute("agregarInfraestructuraPanel.show()");
    }


    public void agregacionConfirmadaInfraestructura2() throws SQLException {
        InfraestructuraVO infra = new InfraestructuraVO();
        infra.setInfId(0);
        infra.setInfNombre(nombreInfraestructuraNueva);
        listaInfraestructuras.add(infra);
        contador++;
    }

    public void eliminacionConfirmadaInfraestructura2() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("rowId");
        int idcodigo = Integer.valueOf(str.toString());
        listaInfraestructuras.remove(idcodigo);
        System.out.println(listaInfraestructuras.size());
    }

    public void setListaAgregarInfraestructura(List<InfraestructuraVO> listaAgregarInfraestructura) {
        this.listaAgregarInfraestructura = listaAgregarInfraestructura;
    }

    public List<InfraestructuraVO> getListaAgregarInfraestructura() {
        return listaAgregarInfraestructura;
    }

    public void setListaInfraestructurasBD(List<InfraestructuraVO> listaInfraestructurasBD) {
        this.listaInfraestructurasBD = listaInfraestructurasBD;
    }

    public List<InfraestructuraVO> getListaInfraestructurasBD() {
        return listaInfraestructurasBD;
    }


    public void setListaEliminarInfraestructura(List<InfraestructuraVO> listaEliminarInfraestructura) {
        this.listaEliminarInfraestructura = listaEliminarInfraestructura;
    }

    public List<InfraestructuraVO> getListaEliminarInfraestructura() {
        return listaEliminarInfraestructura;
    }

    public void editar() throws SQLException {
      
        concesionVO.setCsiEstado(1);
        concesionVO.setCsiId(codigoE);
        concesionVO.setCsiNombre(nombreE);
        InfraestructuraTipo infraestructuraTipo1 = new InfraestructuraTipo();
        infraestructuraTipo1.setTinId(codigoTipoInfraestructura);
        concesionVO.setInfraestructuraTipo(infraestructuraTipo1);
        concesionVO.setCsiFechaCambio(new Date());
        concesionVO.setCsiUsuarioCambio(obtenerIpCliente());
    
        getConcesionServicesImpl().update(concesionVO);
   
        List<InfraestructuraVO> listaEliminarInfraestructura = new ArrayList<>();
        List<InfraestructuraVO> listaAgregarInfraestructura = new ArrayList<>();

        int a = 0;

        listaInfraestructurasBD = infraestructuraServiceImpl.query1(codigoE);

        //Metodo Agregar Registros
        for (int c = 0; c < listaInfraestructuras.size(); c++) {
            if (listaInfraestructuras.get(c).getInfId() == 0) {
                InfraestructuraVO vo = new InfraestructuraVO();
                vo.setInfNombre(listaInfraestructuras.get(c).getInfNombre());
                vo.setInfEstado(1);
                Concesion concesion = new Concesion();
                concesion.setCsiFechaAlta(concesionVO.getCsiFechaAlta());
                concesion.setCsiFechaBaja(concesionVO.getCsiFechaBaja());
                concesion.setCsiFechaCambio(concesionVO.getCsiFechaCambio());
                concesion.setCsiTerminal(concesionVO.getCsiTerminal());
                concesion.setCsiUsuarioAlta(concesionVO.getCsiUsuarioAlta());
                concesion.setCsiUsuarioBaja(concesionVO.getCsiUsuarioBaja());
                concesion.setCsiUsuarioCambio(concesionVO.getCsiUsuarioCambio());
                concesion.setCsiId(concesionVO.getCsiId());
                concesion.setInfraestructuraTipo(concesionVO.getInfraestructuraTipo());
                concesion.setCsiNombre(concesionVO.getCsiNombre());
                concesion.setCsiEstado(concesionVO.getCsiEstado());
                vo.setConcesion(concesion);
                infraestructuraServiceImpl.insert(vo);
            }
        }
        for (int f = 0; f < listaInfraestructurasBD.size(); f++) {
            for (int c = 0; c < listaInfraestructuras.size(); c++) {
                if (listaInfraestructuras.get(c).getInfId() != 0 &&
                    (listaInfraestructurasBD.get(f).getInfId().toString().trim().equals(listaInfraestructuras.get(c).getInfId().toString().trim()))) {

                    /*   if (listaInfraestructuras.get(c).getInfId() != 0 &&
                        (listaInfraestructurasBD.get(f).getInfId()==listaInfraestructuras.get(c).getInfId())) {    */

                    a = 1;
                }
            }
            if (a == 0) {
                InfraestructuraVO infra = listaInfraestructurasBD.get(f);
                infra.setInfEstado(0);
            
                      
                       concesionVO.setCsiFechaCambio(new Date());
                       concesionVO.setCsiUsuarioCambio(obtenerIpCliente());
                       getConcesionServicesImpl().update(concesionVO);
            
            
            
            
                
                infraestructuraServiceImpl.update(infra);
            }
            a = 0;
        }


        /*   for (InfraestructuraVO listaActual : listaInfraestructuras) {
                System.out.println("Entro al for");
                    for (InfraestructuraVO listaNueva : listaInfraestructurasNueva) {
                        System.out.println("Entro al for 2");
                        if(listaActual.getInfId()==0){
                            infraestructuraVO.setInfNombre(listaActual.getInfNombre());
                            infraestructuraServiceImpl.insert(infraestructuraVO);

                        }

                          else if(listaActual.getInfId()==listaNueva.getInfId()){
                            System.out.println("estos son iguales++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println(listaActual.getInfId());
                            System.out.println(listaNueva.getInfId());
                            }
                    }
                }

            for(InfraestructuraVO infra4 :listaInfraestructurasNueva){
              int existe=0;
                for (InfraestructuraVO infra5:listaInfraestructuras){
                    if (infra4.getInfId()==infra5.getInfId()){
                        existe=1;
                        }
                    }
                    if (existe==0){
                        InfraestructuraVO infra11= new InfraestructuraVO();
                        infra11.setInfId(infra4.getInfId());
                        infra11.setInfNombre(infra4.getInfNombre());
                        infraestructuraServiceImpl.update(infra11);
                        }
                }
      */

        ListarConcesiones();


        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se registro con Exito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Implement this method
        super.finalize();
    }


    public void setCodigoConcesion(int codigoConcesion) {
        this.codigoConcesion = codigoConcesion;
    }

    public int getCodigoConcesion() {
        return codigoConcesion;
    }

    public void setNombreConcesion(String nombreConcesion) {
        this.nombreConcesion = nombreConcesion;
    }

    public String getNombreConcesion() {
        return nombreConcesion;
    }

    //////////////////////////////FIN ELIMINAR CONSECION


    public void setCodigoInfraestructura(int codigoInfraestructura) {
        this.codigoInfraestructura = codigoInfraestructura;
    }

    public int getCodigoInfraestructura() {
        return codigoInfraestructura;
    }

    public void setNombreInfraestructura(String nombreInfraestructura) {
        this.nombreInfraestructura = nombreInfraestructura;
    }

    public String getNombreInfraestructura() {
        return nombreInfraestructura;
    }
    //FIN DE ELIMINAR DE INFRAESTRUCTURA POR SU CODIGO


    public void setCodigoConcesionNuevo(int codigoConcesionNuevo) {
        this.codigoConcesionNuevo = codigoConcesionNuevo;
    }

    public int getCodigoConcesionNuevo() {
        return codigoConcesionNuevo;
    }

    public void agregarInfraestructuraNueva() {


    }


}
