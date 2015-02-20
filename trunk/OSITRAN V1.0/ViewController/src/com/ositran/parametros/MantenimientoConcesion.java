package com.ositran.parametros;
import com.ositran.service.ConcesionService;
import com.ositran.serviceimpl.InfraestructuraServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "backing_ositran_parametros_mantenimientoconcesion")
@ViewScoped
public class MantenimientoConcesion {

    
    private int codigoTipoInfraestructura;
    private int codigoEliminar;
    private String nombreEliminar;
    private List<ConcesionVO> listaConcesiones;

    private String nombre;
    private String addInfraestructura;
    private List<String> listaInfra = new ArrayList<>();

    


    private List<InfraestructuraTipoVO> listaInfraestructura = new ArrayList<>();

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

    public void listarTipInfraestructura() {
        System.out.println("llego");
        listaInfraestructura = infraestructuraTipoServiceImpl.query();
    }
    public ConcesionVO concesionVO = new ConcesionVO();


    public void guardar() {
        int codigogenerado=0;
        concesionVO.setTinId(codigoTipoInfraestructura);
        concesionVO.setCsiNombre(nombre);
        concesionVO.setCsiEstado(1);
        concesionVO.setCsiFechaAlta(new Date());
        concesionVO.setCsiUsuarioAlta(obtenerIpCliente());
        codigogenerado=getConcesionServicesImpl().idConcesion(concesionVO);
        
        for(InfraestructuraVO infraestructuraVO: infraestructuras){
            infraestructuraVO.setCsiId(codigogenerado);
            InfraestructuraVO infraestructuraVO1=new InfraestructuraVO();
            infraestructuraVO1.setInfNombre(infraestructuraVO.getInfNombre());
            infraestructuraVO1.setInfUsuarioAlta(obtenerIpCliente());
            infraestructuraVO1.setInfFechaAlta(new Date());
            infraestructuraVO1.setInfEstado(1);
            infraestructuraServiceImpl.insert(infraestructuraVO);
            
            }
        
        
        
        /*   Iterator<PartidoFutbol> itrPartidos = partidos.iterator();
        while(itrPartidos.hasNext()){
                PartidoFutbol partido = itrPartidos.next();
                System.out.println(partido.getEquipoLocal() + " "
                                + partido.getGolesLocal() + "-"
                                + partido.getGolesVisitante() + " "
                                + partido.getEquipo */
        
        
        limpiarcampos();
        ListarConcesiones();

    }


    public String obtenerIpCliente() {
        String remoteAddr =
            ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
        return remoteAddr;
    }


    public void limpiar() {
        nombre = "";

    }

    public void cargarEditar(ConcesionVO concesionV) {
        System.out.println(concesionVO.getCsiNombre());
        System.out.println(concesionVO.getCsiId());
        concesionVO = concesionV;
        codigoE = concesionVO.getCsiId();
        nombreE = concesionVO.getCsiNombre();

    }

    public void editar() {
        System.out.println(codigoE);
        System.out.println(nombreE);

        concesionVO.setCsiId(codigoE);
        concesionVO.setCsiNombre(nombreE);


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
        getConcesionServicesImpl().delete(codigoEliminar);
        ListarConcesiones();
    }

    public void limpiarcampos() {
        nombre = "";

    }

    public List<ConcesionVO> ListarConcesiones() {
        System.out.println("llego al MB");
        listaConcesiones = getConcesionServicesImpl().query();
        return listaConcesiones;
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

  


    public void setListaInfraestructura(List<InfraestructuraTipoVO> listaInfraestructura) {
        this.listaInfraestructura = listaInfraestructura;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructura() {
        return listaInfraestructura;
    }

    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
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
          
        @PostConstruct  // INICIO CONSTRUCTOR VOO CARRITO VER CLASE InfraestructuraVO
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
           
        


}
