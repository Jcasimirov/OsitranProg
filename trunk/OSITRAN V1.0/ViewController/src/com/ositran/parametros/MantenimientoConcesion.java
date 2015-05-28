package com.ositran.parametros;

import com.ositran.service.InfraestructuraService;
import com.ositran.service.InfraestructuraTipoService;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.util.Util;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "mantenimientoconcesionMB")
@ViewScoped

public class MantenimientoConcesion {
    //sesiones inicio
    public  final int formulario=7;
    private RolOpcionesVO rolOpcion;
    //sessiones 
    int contador = 0;
    private int codigoT;
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
    List<InfraestructuraVO> listaEliminarInfraestructura = new ArrayList<InfraestructuraVO>();
    List<InfraestructuraVO> listaAgregarInfraestructura = new ArrayList<InfraestructuraVO>();
    private int codigoConcesionNuevo;
    private String nombreInfraestructuraNueva;
    private String nombreInfraestructura;
    private int codigoConcesion;
    private String nombreConcesion;
    List<ConcesionVO> listaConcesiones;
    List<InfraestructuraVO> listaInfraestructuras;
    List<InfraestructuraVO> listaInfraestructurasBD;
    List<InfraestructuraVO> lis;
    private List<String> listaInfra = new ArrayList<String>();
    private List<InfraestructuraTipoVO> listaInfraestructuraTipos = new ArrayList<InfraestructuraTipoVO>();
    private String nombreTipoInfra;

    Util util = new Util();
    List<String> listaAgregarInfra = new ArrayList<String>();
    List<String> listaQuitarInfra = new ArrayList<String>();

    @ManagedProperty(value = "#{concesionServicesImpl}")
    ConcesionServiceImpl concesionServicesImpl;

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoService infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{infraestructuraServiceImpl}")
    private InfraestructuraService infraestructuraServiceImpl;
                                    

    @ManagedProperty(value = "#{concesionVO}")
    ConcesionVO concesionVO;

    @ManagedProperty(value = "#{infraestructuraVO}")
    InfraestructuraVO infraestructuraVO;
    UsuarioVO usuario=new UsuarioVO();

    public void validarSesion() throws IOException{
      rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
        usuario = Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
    }
    

    public void guardar() {

        if (codigoTipoInfraestructuraInsert == 0) {
            FacesMessage mensaje =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Debe ingresar el Tipo de Infraestructura");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else if (nombre.equals("")) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Debe ingrear nombre de concesión");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            try {
                int codigogenerado = 0;

                concesionVO.setTinId(codigoTipoInfraestructuraInsert);
                concesionVO.setCsiNombre(nombre);
                concesionVO.setCsiEstado(1);
                concesionVO.setCsiUsuarioAlta(usuario.getUsuAlias());
                concesionVO.setCsiFechaAlta(util.getObtenerFechaHoy());
                concesionVO.setCsiTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
                codigogenerado = getConcesionServicesImpl().idConcesion(concesionVO);



                for (InfraestructuraVO infraestructuraVO : infraestructuras) {
                    infraestructuraVO.setTinId(codigoTipoInfraestructuraInsert);
                    infraestructuraVO.setCsiId(codigogenerado);
                    infraestructuraVO.setInfNombre(infraestructuraVO.getInfNombre());
                    infraestructuraVO.setInfUsuarioAlta(usuario.getUsuAlias());
                    infraestructuraVO.setInfTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
                    infraestructuraVO.setInfFechaAlta(new Date());
                    
                    infraestructuraVO.setInfEstado(1);
                    infraestructuraServiceImpl.insert(infraestructuraVO);
                }
                RequestContext.getCurrentInstance().execute("insertarPanel.hide()");
                infraestructuras.clear();

                listaInfraestructuraTipos = new ArrayList<InfraestructuraTipoVO>();
                listarInfraestructuras();
                RequestContext.getCurrentInstance().execute("window.location.reload()");
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se agregó exitosamente");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);

              
            }

            catch (Exception e) {
                System.out.println(e.getMessage());
                FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "HA HABIADO UN ERROR" + e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, mensaje);

            }
        }
    }


    public void cargarEditar() throws SQLException {
        try{
            System.out.println("entro cargarEditar()");
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
        codigoT = concesionVO.getTinId();

        codigoTipoInfraestructura = concesionVO.getTinId();
        System.out.println("concesionVO.getCsiId(): "+concesionVO.getCsiId());
        listaInfraestructuras = infraestructuraServiceImpl.query1(concesionVO.getCsiId());
        System.out.println("listaInfraestructuras size: "+listaInfraestructuras.size());
        //listaInfraestructuras = infraestructuraServiceImpl.query1(codigoE);
        }catch(Exception ex){
            ex.printStackTrace();
            }
    }


    public void cargarEliminar(int codigo, String nombre) {
        nombreEliminar = nombre;
        codigoEliminar = codigo;
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


   

    public InfraestructuraVO getInfraestructuraVO() {
        return infraestructuraVO;
    }

    public InfraestructuraTipoVO infraestructuraTipoVO = new InfraestructuraTipoVO();


    public List<ConcesionVO> ListarConcesiones() {
        try {
          
            listaConcesiones = getConcesionServicesImpl().query();
            int contador = 1;
            for (ConcesionVO conc : listaConcesiones) {
                conc.setCorrela(contador);
                contador++;
            }

            listarInfraestructuras();


        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }


        return listaConcesiones;
    }

    public void resetear() {
        //   infraestructura.getConcesion().setCsiNombre(""); //para el carrito resetear nombre
        infraestructura = new InfraestructuraVO();
    }


  

    public String obtenerIpCliente() {
        String remoteAddr =
            ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
        return remoteAddr;
    }


    // Buscar por filtro

    private String concesionbuscar;
    private int codigoTipoInfraestructurafiltro;
    public List<ConcesionVO> buscarconcesion() {
        try {
            listaConcesiones =
                getConcesionServicesImpl().buscarconcesionfiltro(codigoTipoInfraestructurafiltro, concesionbuscar);

            int contador = 1;
            for (ConcesionVO conc : listaConcesiones) {
                conc.setCorrela(contador);
                contador++;
            }
            
            listarInfraestructuras();


        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }


        return listaConcesiones;
    }


    //---------------------------------------------

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
            infraestructuraVO.setInfUsuarioBaja(usuario.getUsuAlias());
            infraestructuraVO.setInfFechaBaja(new Date());
            infraestructuraVO.setInfTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
            infraestructuraServiceImpl.update(infraestructuraVO);

            listaInfraestructuras = infraestructuraServiceImpl.query1(concesionVO.getCsiId());
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se eliminó con Exito");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            
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
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se eliminó con éxito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        

    }

    public void eliminacionConfirmadaConcesion() throws SQLException {
        listaInfraestructuras = infraestructuraServiceImpl.query1(concesionVO.getCsiId());
        for (InfraestructuraVO infra : listaInfraestructuras) {
            infra.setInfEstado(0);
            infra.setInfFechaBaja(new Date());
            infra.setInfUsuarioBaja(Reutilizar.getNewInstance().obtenerIpCliente());
            
            infraestructuraServiceImpl.update(infra);

        }
        concesionVO.setCsiEstado(0);
        concesionServicesImpl.update(concesionVO);
        
        ListarConcesiones();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se eliminó correctamente");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

    public void agregacionConfirmadaInfraestructura2() {


        InfraestructuraVO infra = new InfraestructuraVO();
        infra.setInfId(0);
        infra.setTinId(codigoT);
        infra.setInfNombre(nombreInfraestructuraNueva);
        listaInfraestructuras.add(infra);
        nombreInfraestructuraNueva = "";
        contador++;
        

    }

    public void eliminacionConfirmadaInfraestructura2() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("rowId");
        int idcodigo = Integer.valueOf(str.toString());
        listaInfraestructuras.remove(idcodigo);
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se eliminó con éxito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }


    public void editar() throws SQLException {

        concesionVO.setCsiEstado(1);
        concesionVO.setCsiId(codigoE);
        concesionVO.setCsiNombre(nombreE);
        concesionVO.setTinId(codigoTipoInfraestructura);
        concesionVO.setCsiFechaCambio(util.getObtenerFechaHoy());
        concesionVO.setCsiUsuarioCambio(usuario.getUsuAlias());
        concesionVO.setCsiTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
        getConcesionServicesImpl().update(concesionVO);


        int a = 0;

        listaInfraestructurasBD = infraestructuraServiceImpl.query1(codigoE);

        //Metodo Agregar Registros
        for (int c = 0; c < listaInfraestructuras.size(); c++) {
            if (listaInfraestructuras.get(c).getInfId() == 0) {          
         
                InfraestructuraVO vo = new InfraestructuraVO();               
                vo.setInfNombre(listaInfraestructuras.get(c).getInfNombre());
                vo.setInfEstado(1);
                vo.setTinId(concesionVO.getTinId());
                vo.setCsiId(concesionVO.getCsiId());
                vo.setInfFechaAlta(util.getObtenerFechaHoy());
                vo.setInfTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
                vo.setInfUsuarioAlta(usuario.getUsuAlias());
                infraestructuraServiceImpl.insert(vo);
            }
        }
        for (int f = 0; f < listaInfraestructurasBD.size(); f++) {
            for (int c = 0; c < listaInfraestructuras.size(); c++) {
              String a1 = ""+listaInfraestructurasBD.get(f).getInfId();
                String a2 = ""+listaInfraestructuras.get(c).getInfId();
                if (listaInfraestructuras.get(c).getInfId() != 0 &&
                    (a1.equals(a2))) {
                    a = 1;
                }
            }
            if (a == 0) {
                InfraestructuraVO infra = listaInfraestructurasBD.get(f);
                infra.setInfEstado(0);


                concesionVO.setCsiFechaCambio(new Date());
                concesionVO.setCsiUsuarioCambio(usuario.getUsuAlias());
                concesionVO.setCsiUsuarioBaja(usuario.getUsuAlias());
                getConcesionServicesImpl().update(concesionVO);


                infraestructuraServiceImpl.update(infra);
                
            
            }
            a = 0;
        }


        ListarConcesiones();
          
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "se actualizó con éxito");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Implement this method
        super.finalize();
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
            FacesMessage mensaje2 = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "HA HABIADO UN ERROR");
            FacesContext.getCurrentInstance().addMessage(null, mensaje2);
        } else {
            infraestructuras.add(infraestructura);
            infraestructura = new InfraestructuraVO();

        }
    }
int valida_infraestructura;

    public void setValida_infraestructura(int valida_infraestructura) {
        this.valida_infraestructura = valida_infraestructura;
    }

    public int getValida_infraestructura() {
        return valida_infraestructura;
    }

    public String reinit() {
        if (infraestructura.getInfNombre().trim().equals("")){
            FacesMessage mensaje2 = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ingrese Nombre de Infraestructura");
            FacesContext.getCurrentInstance().addMessage(null, mensaje2);
        }else{
            infraestructuras.add(infraestructura);
        }           
        return null;
    }


    // -------------------------FIN VOO CARRITO VER CLASE InfraestructuraVO--------------------------------------/

    public void listarInfraestructuras() throws Exception{

            for (int i = 0; i < listaConcesiones.size(); i++) {
                nombreTipoInfra = infraestructuraTipoServiceImpl.getNombre(listaConcesiones.get(i).getTinId());
                listaConcesiones.get(i).setNombreTipoInfra(nombreTipoInfra);
            }
        }


    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setCodigoT(int codigoT) {
        this.codigoT = codigoT;
    }

    public int getCodigoT() {
        return codigoT;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAddInfraestructura(String addInfraestructura) {
        this.addInfraestructura = addInfraestructura;
    }

    public String getAddInfraestructura() {
        return addInfraestructura;
    }

    public void setNombreEliminar(String nombreEliminar) {
        this.nombreEliminar = nombreEliminar;
    }

    public String getNombreEliminar() {
        return nombreEliminar;
    }

    public void setCodigoEliminar(int codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }

    public int getCodigoEliminar() {
        return codigoEliminar;
    }

    public void setCodigoTipoInfraestructura(int codigoTipoInfraestructura) {
        this.codigoTipoInfraestructura = codigoTipoInfraestructura;
    }

    public int getCodigoTipoInfraestructura() {
        return codigoTipoInfraestructura;
    }

    public void setCodigoInfraestructura(int codigoInfraestructura) {
        this.codigoInfraestructura = codigoInfraestructura;
    }

    public int getCodigoInfraestructura() {
        return codigoInfraestructura;
    }

    public void setCodigoCarritoConcesion(int codigoCarritoConcesion) {
        this.codigoCarritoConcesion = codigoCarritoConcesion;
    }

    public int getCodigoCarritoConcesion() {
        return codigoCarritoConcesion;
    }

    public void setListaEliminarInfraestructura(List<InfraestructuraVO> listaEliminarInfraestructura) {
        this.listaEliminarInfraestructura = listaEliminarInfraestructura;
    }

    public List<InfraestructuraVO> getListaEliminarInfraestructura() {
        return listaEliminarInfraestructura;
    }

    public void setListaAgregarInfraestructura(List<InfraestructuraVO> listaAgregarInfraestructura) {
        this.listaAgregarInfraestructura = listaAgregarInfraestructura;
    }

    public List<InfraestructuraVO> getListaAgregarInfraestructura() {
        return listaAgregarInfraestructura;
    }

    public void setCodigoConcesionNuevo(int codigoConcesionNuevo) {
        this.codigoConcesionNuevo = codigoConcesionNuevo;
    }

    public int getCodigoConcesionNuevo() {
        return codigoConcesionNuevo;
    }

    public void setNombreInfraestructuraNueva(String nombreInfraestructuraNueva) {
        this.nombreInfraestructuraNueva = nombreInfraestructuraNueva;
    }

    public String getNombreInfraestructuraNueva() {
        return nombreInfraestructuraNueva;
    }

    public void setNombreInfraestructura(String nombreInfraestructura) {
        this.nombreInfraestructura = nombreInfraestructura;
    }

    public String getNombreInfraestructura() {
        return nombreInfraestructura;
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

    public void setListaConcesiones(List<ConcesionVO> listaConcesiones) {
        this.listaConcesiones = listaConcesiones;
    }

    public List<ConcesionVO> getListaConcesiones() {
        return listaConcesiones;
    }

    public void setListaInfraestructuras(List<InfraestructuraVO> listaInfraestructuras) {
        this.listaInfraestructuras = listaInfraestructuras;
    }

    public List<InfraestructuraVO> getListaInfraestructuras() {
        return listaInfraestructuras;
    }

    public void setListaInfraestructurasBD(List<InfraestructuraVO> listaInfraestructurasBD) {
        this.listaInfraestructurasBD = listaInfraestructurasBD;
    }

    public List<InfraestructuraVO> getListaInfraestructurasBD() {
        return listaInfraestructurasBD;
    }

    public void setLis(List<InfraestructuraVO> lis) {
        this.lis = lis;
    }

    public List<InfraestructuraVO> getLis() {
        return lis;
    }

    public void setListaInfra(List<String> listaInfra) {
        this.listaInfra = listaInfra;
    }

    public List<String> getListaInfra() {
        return listaInfra;
    }

    public void setListaInfraestructuraTipos(List<InfraestructuraTipoVO> listaInfraestructuraTipos) {
        this.listaInfraestructuraTipos = listaInfraestructuraTipos;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructuraTipos() {
        return listaInfraestructuraTipos;
    }

    public void setNombreTipoInfra(String nombreTipoInfra) {
        this.nombreTipoInfra = nombreTipoInfra;
    }

    public String getNombreTipoInfra() {
        return nombreTipoInfra;
    }

    public void setUtil(Util util) {
        this.util = util;
    }

    public Util getUtil() {
        return util;
    }

    public void setListaAgregarInfra(List<String> listaAgregarInfra) {
        this.listaAgregarInfra = listaAgregarInfra;
    }

    public List<String> getListaAgregarInfra() {
        return listaAgregarInfra;
    }

    public void setListaQuitarInfra(List<String> listaQuitarInfra) {
        this.listaQuitarInfra = listaQuitarInfra;
    }

    public List<String> getListaQuitarInfra() {
        return listaQuitarInfra;
    }

    public void setConcesionServicesImpl(ConcesionServiceImpl concesionServicesImpl) {
        this.concesionServicesImpl = concesionServicesImpl;
    }

    public ConcesionServiceImpl getConcesionServicesImpl() {
        return concesionServicesImpl;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoService infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoService getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }

    public void setInfraestructuraServiceImpl(InfraestructuraService infraestructuraServiceImpl) {
        this.infraestructuraServiceImpl = infraestructuraServiceImpl;
    }

    public InfraestructuraService getInfraestructuraServiceImpl() {
        return infraestructuraServiceImpl;
    }

    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }

    public void setInfraestructuraVO(InfraestructuraVO infraestructuraVO) {
        this.infraestructuraVO = infraestructuraVO;
    }

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }

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

    public void setInfraestructura(InfraestructuraVO infraestructura) {
        this.infraestructura = infraestructura;
    }

    public InfraestructuraVO getInfraestructura() {
        return infraestructura;
    }

    public void setInfraestructuras(List<InfraestructuraVO> infraestructuras) {
        this.infraestructuras = infraestructuras;
    }

    public List<InfraestructuraVO> getInfraestructuras() {
        return infraestructuras;
    }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

}
