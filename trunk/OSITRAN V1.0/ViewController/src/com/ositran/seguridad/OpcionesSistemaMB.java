package com.ositran.seguridad;

import com.ositran.service.RolOpcionesService;
import com.ositran.serviceimpl.MenServiceImpl;
import com.ositran.serviceimpl.RolServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.MenVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.util.ArrayList;
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

@ManagedBean(name = "opcionesSistemasMB")
@ViewScoped
public class OpcionesSistemaMB {
    private String buscar;
    private int contador;
    private String  nombreE;
    private String descripcionE;
    private int formulario;
    private int codigoMenu;
    private List<MenVO> listaOpcionesSistema= new ArrayList<>();
    
    private String nombre;
    private String descripcion;
    private String formularioO;
    private int padre;
    private int estado;
    private String url;
    
    @ManagedProperty(value = "#{menServiceImpl}")
    MenServiceImpl menServiceImpl;
    
    @ManagedProperty(value = "#{menVO}")
    MenVO menVO;
   
    public  final int formulario1=5;
    private RolOpcionesVO rolOpcion;
    UsuarioVO usuario=new UsuarioVO();

    public void validarSesion() throws IOException{
      rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario1);
        usuario = Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
    }
    
    
    
    
    public void cargarRegistrar(){
              nombre="";
              descripcion="";
             formularioO="";
              padre=1;
              url="";
        }
    
    public OpcionesSistemaMB() {
        super();
    }
    
    
    
    public void guardar(){
       menVO=new MenVO();
       menVO.setMenNombre(nombre);
       menVO.setDescripcion(descripcion);
       menVO.setMenEstado(1);
       menVO.setMenPadre(padre);
       menVO.setMenFormulario("1");
       menVO.setMenUrl(url);
       menVO.setMenTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
       menVO.setMenUsuarioAlta(usuario.getUsuAlias());
       menVO.setMenFechaAlta(new Date());
       
       menServiceImpl.insert(menVO);
            RequestContext.getCurrentInstance().execute("insertarPanel.hide()");
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
            "Se Registro Exitosamente la opcion del sistema"));
            listarOpcionesSistema();
        }
    
    public void busqueda(){
        if (buscar.equals("")){
            listarOpcionesSistema();
            }
        else {
        listaOpcionesSistema=menServiceImpl.query1(buscar); 
        for (int i = 0; i < listaOpcionesSistema.size(); i++) {
            listaOpcionesSistema.get(i).setContador(contador);
            contador++;
        }
    }
        }
    
    public void listarOpcionesSistema(){
            int contador = 1;
            listaOpcionesSistema=menServiceImpl.query();
            for (int i = 0; i < listaOpcionesSistema.size(); i++) {
                listaOpcionesSistema.get(i).setContador(contador);
                contador++;
            }
        }
    public void limpiar(){
        
        }
    public void cargarEliminar(){
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            Object str = requestMap.get("idEliminar");
            codigoMenu = Integer.parseInt(str.toString());
            menVO=menServiceImpl.get(codigoMenu);
            menVO.setMenEstado(0);   
         menVO.setMenFechaBaja(new Date());
         menVO.setMenUsuarioBaja(usuario.getUsuAlias());
         menVO.setMenTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
        }
    
    
    public  void eliminar(){
        menServiceImpl.update(menVO);
        System.out.println("Llego a eliminar");
        
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
            "Se elimino la Opcion del Sistema"));
        
        }

    public void cargarEditar(){
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            Object str = requestMap.get("idModificar");
            codigoMenu = Integer.parseInt(str.toString());
            menVO=menServiceImpl.get(codigoMenu);
            nombreE=menVO.getMenNombre();
            descripcionE=menVO.getDescripcion();       
        }
    
    
   
    public void editar(){
        menVO=getMenServiceImpl().get(codigoMenu);
            if (nombreE.equals("")) {
               FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                             "Debe de Ingresar el Nombre"));
            } else if (descripcionE.equals("")) {
               FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                             "Debe ingresar la desripción"));
            }else {
            menVO.setMenNombre(nombreE);
            menVO.setDescripcion(descripcionE);
            menVO.setMenFormulario("1");
            menVO.setMenFechaCambio(new Date());
            menVO.setMenTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
            menVO.setMenUsuarioCambio(usuario.getUsuAlias());    
            menServiceImpl.update(menVO);
            
            RequestContext.getCurrentInstance().execute("editarPanel.hide()");   
            listarOpcionesSistema();
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
            "Se actulizo la opcion del sistema con Exito"));
            
            
            }
        
        }
    
    

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
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

    public void setFormulario(int formulario) {
        this.formulario = formulario;
    }

    public int getFormulario() {
        return formulario;
    }

    public void setListaOpcionesSistema(List<MenVO> listaOpcionesSistema) {
        this.listaOpcionesSistema = listaOpcionesSistema;
    }

    public List<MenVO> getListaOpcionesSistema() {
        return listaOpcionesSistema;
    }

    public void setMenServiceImpl(MenServiceImpl menServiceImpl) {
        this.menServiceImpl = menServiceImpl;
    }

    public MenServiceImpl getMenServiceImpl() {
        return menServiceImpl;
    }


    public void setMenVO(MenVO menVO) {
        this.menVO = menVO;
    }

    public MenVO getMenVO() {
        return menVO;
    }

    public void setCodigoMenu(int codigoMenu) {
        this.codigoMenu = codigoMenu;
    }

    public int getCodigoMenu() {
        return codigoMenu;
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

    public void setFormularioO(String formularioO) {
        this.formularioO = formularioO;
    }

    public String getFormularioO() {
        return formularioO;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public int getPadre() {
        return padre;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
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
}
