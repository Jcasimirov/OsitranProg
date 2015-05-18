package com.ositran.seguridad;

import com.ositran.service.MenService;
import com.ositran.service.RolOpcionesService;
import com.ositran.service.RolService;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.MenVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.RolVO;
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

@ManagedBean(name = "rolMB")
@ViewScoped
public class RolMB {

    public RolMB() {
        super();
    }
    private String nombre;
    private String descripcion;
    private List<RolVO> listaRoles;
    private List<MenVO> listaMen;
    private Boolean actualizarB;
    private Boolean leerB;
    private Boolean insertarB;
    private Boolean eliminarB;
    private Boolean todo;
    private String buscar;
    private List<MenVO> listaMenSeleccionado;
    private List<MenVO> listaMenSeleccionado2;
    private List<MenVO> listaMenNueva=new ArrayList<MenVO>();
    private List<RolOpcionesVO> listaRolOpciones;
    private int codigoRol;

    //*******EDITAR************************//
    private List<MenVO> listaMenE;
    private List<MenVO> listaMenNuevaE=new ArrayList<MenVO>();
    private List<MenVO> listaMenSeleccionadoE=new ArrayList<MenVO>();
    private List<MenVO> listaMenSeleccionadoE2;
    private Boolean actualizarBE;
    private Boolean leerBE;
    private Boolean insertarBE;
    private Boolean eliminarBE;
    private String nombreE;
    private String descripcionE;
    private Boolean todoE;
    private int idE;
    @ManagedProperty(value = "#{rolVO}")
    RolVO rolVO;

    @ManagedProperty(value = "#{rolServiceImpl}")
    RolService rolServiceImpl;

    @ManagedProperty(value = "#{menServiceImpl}")
    MenService menServiceImpl;

    @ManagedProperty(value = "#{menVO}")
    MenVO menVO;

    @ManagedProperty(value = "#{rolOpcionesServiceImpl}")
    RolOpcionesService rolOpcionesServiceImpl;
    
    UsuarioVO usuario=new UsuarioVO();
    public  final int formulario=1;
    private RolOpcionesVO rolOpcion;
    public void validarSesion() throws IOException{
            rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
            usuario = Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        }

    public void actualizarTodo(){
        if (actualizarB){
            for (MenVO menVOT: listaMenNueva){
            menVOT.setActualizar(true);
                }
            } 
        else {
              for (MenVO menVOT: listaMenNueva){
            menVOT.setActualizar(false);
                }
            
            }
                    }
    public void eliminarTodo(){
              if (eliminarB){
            for (MenVO menVOT: listaMenNueva){
            menVOT.setEliminar(true);
                }
            } 
        else {
              for (MenVO menVOT: listaMenNueva){
            menVOT.setEliminar(false);
                }
            
            }       
                    }
    public void leerTodo(){
                        if (leerB){
            for (MenVO menVOT: listaMenNueva){
            menVOT.setLectura(true);
                }
            } 
        else {
              for (MenVO menVOT: listaMenNueva){
            menVOT.setLectura(false);
                }
            
            }  
                    }
    public void insertarTodo(){
                            if (insertarB){
            for (MenVO menVOT: listaMenNueva){
            menVOT.setCrear(true);
                }
            } 
        else {
              for (MenVO menVOT: listaMenNueva){
            menVOT.setCrear(false);
                }
            
            }     
                    }
    
    public void todo(){
        if (todo){
            for (MenVO menVOT: listaMenNueva){
            menVOT.setCrear(true);
            menVOT.setActualizar(true);
                menVOT.setEliminar(true);
                menVOT.setLectura(true);
                }
            } 
        else {
              for (MenVO menVOT: listaMenNueva){
            menVOT.setCrear(false);
                   menVOT.setActualizar(false);
                menVOT.setEliminar(false);
                menVOT.setLectura(false);
                }
            
            }     
                    }


public void actualizarTodoE(){
        if (actualizarBE){
            for (MenVO menVOT: listaMenNuevaE){
            menVOT.setActualizar(true);
                }
            } 
        else {
              for (MenVO menVOT: listaMenNuevaE){
            menVOT.setActualizar(false);
                }
            
            }
                    }
    public void eliminarTodoE(){
              if (eliminarBE){
            for (MenVO menVOT: listaMenNuevaE){
            menVOT.setEliminar(true);
                }
            } 
        else {
              for (MenVO menVOT: listaMenNuevaE){
            menVOT.setEliminar(false);
                }
            
            }       
                    }
    public void leerTodoE(){
                        if (leerBE){
            for (MenVO menVOT: listaMenNuevaE){
            menVOT.setLectura(true);
                }
            } 
        else {
              for (MenVO menVOT: listaMenNuevaE){
            menVOT.setLectura(false);
                }
            
            }  
                    }
    public void insertarTodoE(){
                            if (insertarBE){
            for (MenVO menVOT: listaMenNuevaE){
            menVOT.setCrear(true);
                }
            } 
        else {
              for (MenVO menVOT: listaMenNuevaE){
            menVOT.setCrear(false);
                }
            
            }     
                    }
    
     public void todoE(){
        if (todoE){
            for (MenVO menVOT: listaMenNuevaE){
            menVOT.setCrear(true);
            menVOT.setActualizar(true);
                menVOT.setEliminar(true);
                menVOT.setLectura(true);
                }
            } 
        else {
              for (MenVO menVOT: listaMenNuevaE){
            menVOT.setCrear(false);
                   menVOT.setActualizar(false);
                menVOT.setEliminar(false);
                menVOT.setLectura(false);
                }
            
            }     
                    }

    public void cargarListaRoles() {
        int contador = 1;
        listaRoles = rolServiceImpl.query();
        for (int i = 0; i < listaRoles.size(); i++) {
            listaRoles.get(i).setContador(contador);
            contador++;
        }
    }

    public void limpiarListas() {
        listaMenSeleccionado.clear();
        listaMenNueva.clear();
        limpiarRegistrar();
        
        
    }
    public void limpiarRegistrar() {
        nombre = "";
        descripcion = "";
        listaMenSeleccionado.clear();
        listaMenNueva.clear();
        listaMenSeleccionado2.clear();
        actualizarB=false;
        leerB=false;
        insertarB=false;
        eliminarB=false;
    }
    public void menuSeleccionado(int index){
        
        if (listaMenNueva.get(index).isTodo()){
           listaMenNueva.get(index).setActualizar(true);
           listaMenNueva.get(index).setCrear(true);
           listaMenNueva.get(index).setEliminar(true);
           listaMenNueva.get(index).setLectura(true);
            }
        else { 
           listaMenNueva.get(index).setActualizar(false);
           listaMenNueva.get(index).setCrear(false);
           listaMenNueva.get(index).setEliminar(false);
           listaMenNueva.get(index).setLectura(false);
            
            }
        }
    
      public void menuSeleccionadoE(int index){
        if (listaMenNuevaE.get(index).isTodo()){
           listaMenNuevaE.get(index).setActualizar(true);
           listaMenNuevaE.get(index).setCrear(true);
           listaMenNuevaE.get(index).setEliminar(true);
           listaMenNuevaE.get(index).setLectura(true);
            }
        else {
           listaMenNuevaE.get(index).setActualizar(false);
           listaMenNuevaE.get(index).setCrear(false);
           listaMenNuevaE.get(index).setEliminar(false);
           listaMenNuevaE.get(index).setLectura(false);
            
            }
        }
    public void limpiarEditar() {
        nombreE = "";
        descripcionE = "";
        listaMenSeleccionadoE.clear();
        listaMenNuevaE.clear();
        listaMenSeleccionadoE2.clear();
        actualizarBE=false;
        leerBE=false;
        insertarBE=false;
        eliminarBE=false;
    }

    public void cargarEditar() {
        limpiarEditar();
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idActualizar");
        idE = Integer.parseInt(str.toString());
        rolVO = rolServiceImpl.get(idE);
        nombreE=rolVO.getRolNombre();
        descripcionE=rolVO.getRolDescripcion();
        listaMenE=menServiceImpl.query();
        listaRolOpciones=rolOpcionesServiceImpl.query1(idE);
        for(RolOpcionesVO rolOpciones1 : listaRolOpciones){
              String nombre="";
              MenVO menVO2=new MenVO();
              
              menVO2.setMenId(rolOpciones1.getMenId());
              nombre =menServiceImpl.getNombre(rolOpciones1.getMenId());
              menVO2.setMenNombre(nombre);
              menVO2.setActualizar( rolOpciones1.getTroModificar()==1 ?true : false);
              menVO2.setEliminar(rolOpciones1.getTroEliminar()==1 ? true : false );
              menVO2.setLectura(rolOpciones1.getTroConsultar()==1 ? true : false);
              menVO2.setCrear(rolOpciones1.getTroAgregar()==1 ? true : false);
            System.out.println();
              listaMenNuevaE.add(menVO2);
            }
        
        for (MenVO menVOSE: listaMenNuevaE){
                for (int i=0;i<listaMenE.size();i++){
                if (listaMenE.get(i).getMenId()==menVOSE.getMenId()){
                    listaMenE.remove(i);
                    }
                
                }
            }
        
    }
    
    public void editar(){
    
            
         if (nombreE.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe de Ingresar el Nombre"));
        } else if (descripcionE.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe ingresar la desripción"));
        }

        else if (listaMenNuevaE.size() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe Seleccionar al menos una opción del menú para este rol"));
        } else {
         rolVO=rolServiceImpl.get(idE);
         rolVO.setRolNombre(nombreE);
         rolVO.setRolDescripcion(descripcionE);
         rolVO.setRolEstado(1);
         rolVO.setRolFechaCambio(new Date());
         rolVO.setRolUsuarioCambio(usuario.getUsuAlias());
         rolVO.setRolId(idE);
         rolServiceImpl.update(rolVO);
         listaMenE=menServiceImpl.query();
            for (MenVO menVO : listaMenNuevaE) {
                
                RolOpcionesVO rolOpcionesVO = new RolOpcionesVO();
                rolOpcionesVO.setRolId(idE);
                rolOpcionesVO.setDescripcion("Descripcion");
                rolOpcionesVO.setMenId(menVO.getMenId());
                rolOpcionesVO.setTroEstado(1);
                rolOpcionesVO.setTroFechaAlta(new Date());
                rolOpcionesVO.setTroAgregar((menVO.isCrear()) ? 1 : 0);
                rolOpcionesVO.setTroConsultar((menVO.isLectura()) ? 1 : 0);
                rolOpcionesVO.setTroEliminar((menVO.isEliminar()) ? 1 : 0);
                rolOpcionesVO.setTroModificar((menVO.isActualizar()) ? 1 : 0);
                rolOpcionesServiceImpl.insertOrUpdate(rolOpcionesVO);
                RequestContext.getCurrentInstance().execute("panelEditar.hide()");
                cargarListaRoles();

            }
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se edito el Rol y sus permisos con exito"));
        }
        
        }
    public void filtrarRol(){
        if (buscar.equals("")){
            
            }
        else {
        int contador = 1;
        listaRoles = rolServiceImpl.query1(buscar);
        for (int i = 0; i < listaRoles.size(); i++) {
            listaRoles.get(i).setContador(contador);
            contador++;
        } 
            }
       
        }
    
    
    

    public void cargarListaMenu() {
        listaMen = menServiceImpl.query();
        System.out.println("  Cantidad de Menu " + listaMen.size());
        limpiarRegistrar();
      

    }

    public void cargarListaRolOpciones() {
        listaRolOpciones = rolOpcionesServiceImpl.query();
        System.out.println("cantidad de lista de rolOpciones " + listaRolOpciones.size());
    }

    public void pasarLista() {
        
            for (MenVO menVOS: listaMenSeleccionado){
                for (int i=0;i<listaMen.size();i++){
                if (listaMen.get(i).getMenId()==menVOS.getMenId()){
                    listaMen.remove(i);
                    }
                
                }
            }
        
        if (listaMenNueva.size()==0){
            listaMenNueva=listaMenSeleccionado;
            }
        else{
            for (MenVO menVONueva:listaMenSeleccionado){
                  listaMenNueva.add(menVONueva);
                }
            }
           
    }
    
     public void pasarListaE() {
        for (MenVO menVOS: listaMenSeleccionadoE){
                for (int i=0;i<listaMenE.size();i++){
                if (listaMenE.get(i).getMenId()==menVOS.getMenId()){
                    listaMenE.remove(i);
                    }
                
                }
            }
        
        if (listaMenNuevaE.size()==0){
            listaMenNuevaE=listaMenSeleccionadoE;
            }
        else{
            for (MenVO menVONueva:listaMenSeleccionadoE){
                  listaMenNuevaE.add(menVONueva);
                }
            }
          
           
    }
     
     public void quitarListaE(){
         for (MenVO menVOS: listaMenSeleccionadoE2){
                for (int i=0;i<listaMenNuevaE.size();i++){
                if (listaMenNuevaE.get(i).getMenId()==menVOS.getMenId()){
                    listaMenNuevaE.remove(i);
                    }
                
                }
            }
        
        if (listaMenE.size()==0){
            listaMenE=listaMenSeleccionadoE2;
            }
        else{
            for (MenVO menVONueva:listaMenSeleccionadoE2){
                  listaMenE.add(menVONueva);
                }
            }
     
        }
    public void quitarLista(){
         for (MenVO menVOS: listaMenSeleccionado2){
                for (int i=0;i<listaMenNueva.size();i++){
                if (listaMenNueva.get(i).getMenId()==menVOS.getMenId()){
                    listaMenNueva.remove(i);
                    }
                
                }
            }
        
        if (listaMen.size()==0){
            listaMen=listaMenSeleccionado2;
            }
        else{
            for (MenVO menVONueva:listaMenSeleccionado2){
                  listaMen.add(menVONueva);
                }
            }
     
        }

    public void cargarEliminarRol() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        Object str = requestMap.get("idEliminar");
        idE = Integer.parseInt(str.toString());

    }

    public void eliminarRol() {
        listaRolOpciones = rolOpcionesServiceImpl.query1(idE);
        for (RolOpcionesVO rolOpcionesVO : listaRolOpciones) {
            rolOpcionesServiceImpl.updateEstado(rolOpcionesVO.getRolId(),rolOpcionesVO.getMenId());
        }
        rolServiceImpl.delete(idE);
        FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                      "Se elemino el rol y sus permisos con exito"));
        cargarListaRoles();
    }


    public void guardar() {
        if (nombre.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe de Ingresar el Nombre"));
        } else if (descripcion.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe ingresar la desripción"));
        }

        else if (listaMenNueva.size() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe Seleccionar al menos una opción del menú para este rol"));
        } else {


            rolVO.setRolNombre(nombre);
            rolVO.setRolDescripcion(descripcion);
            rolVO.setRolEstado(1);
            rolVO.setRolFechaAlta(new Date());
            rolVO.setRolUsuarioAlta(usuario.getUsuAlias());
          
            
            codigoRol = rolServiceImpl.getCodigo(rolVO);

            for (MenVO menVO : listaMenNueva) {
                RolOpcionesVO rolOpcionesVO = new RolOpcionesVO();
                rolOpcionesVO.setRolId(codigoRol);
                rolOpcionesVO.setMenId(menVO.getMenId());
                rolOpcionesVO.setTroEstado(1);
                rolOpcionesVO.setDescripcion("Descripcion");
                rolOpcionesVO.setTroFechaAlta(new Date());
                rolOpcionesVO.setTroAgregar((menVO.isCrear()) ? 1 : 0);
                rolOpcionesVO.setTroConsultar((menVO.isLectura()) ? 1 : 0);
                rolOpcionesVO.setTroEliminar((menVO.isEliminar()) ? 1 : 0);
                rolOpcionesVO.setTroModificar((menVO.isActualizar()) ? 1 : 0);
                rolOpcionesServiceImpl.insert(rolOpcionesVO);
                RequestContext.getCurrentInstance().execute("insertarPanel.hide()");
                cargarListaRoles();

            }
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se registro el Rol y sus permisos con exito"));
        }
    }


    public void setRolVO(RolVO rolVO) {
        this.rolVO = rolVO;
    }

    public RolVO getRolVO() {
        return rolVO;
    }

    public void setRolServiceImpl(RolService rolServiceImpl) {
        this.rolServiceImpl = rolServiceImpl;
    }

    public RolService getRolServiceImpl() {
        return rolServiceImpl;
    }

    public void setListaRoles(List<RolVO> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public List<RolVO> getListaRoles() {
        return listaRoles;
    }

    public void setMenServiceImpl(MenService menServiceImpl) {
        this.menServiceImpl = menServiceImpl;
    }

    public MenService getMenServiceImpl() {
        return menServiceImpl;
    }

    public void setListaMen(List<MenVO> listaMen) {
        this.listaMen = listaMen;
    }

    public List<MenVO> getListaMen() {
        return listaMen;
    }

    public void setMenVO(MenVO menVO) {
        this.menVO = menVO;
    }

    public MenVO getMenVO() {
        return menVO;
    }

    public void setRolOpcionesServiceImpl(RolOpcionesService rolOpcionesServiceImpl) {
        this.rolOpcionesServiceImpl = rolOpcionesServiceImpl;
    }

    public RolOpcionesService getRolOpcionesServiceImpl() {
        return rolOpcionesServiceImpl;
    }

    public void setListaRolOpciones(List<RolOpcionesVO> listaRolOpciones) {
        this.listaRolOpciones = listaRolOpciones;
    }

    public List<RolOpcionesVO> getListaRolOpciones() {
        return listaRolOpciones;
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

    public void setListaMenSeleccionado(List<MenVO> listaMenSeleccionado) {
        this.listaMenSeleccionado = listaMenSeleccionado;
    }

    public List<MenVO> getListaMenSeleccionado() {
        return listaMenSeleccionado;
    }

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    public int getCodigoRol() {
        return codigoRol;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNombreE() {
        return nombreE;
    }


    public void setIdE(int idE) {
        this.idE = idE;
    }

    public int getIdE() {
        return idE;
    }

  

    public void setListaMenSeleccionadoE(List<MenVO> listaMenSeleccionadoE) {
        this.listaMenSeleccionadoE = listaMenSeleccionadoE;
    }

    public List<MenVO> getListaMenSeleccionadoE() {
        return listaMenSeleccionadoE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setListaMenNueva(List<MenVO> listaMenNueva) {
        this.listaMenNueva = listaMenNueva;
    }

    public List<MenVO> getListaMenNueva() {
        return listaMenNueva;
    }


    public void setListaMenSeleccionado2(List<MenVO> listaMenSeleccionado2) {
        this.listaMenSeleccionado2 = listaMenSeleccionado2;
    }

    public List<MenVO> getListaMenSeleccionado2() {
        return listaMenSeleccionado2;
    }


    public void setListaMenE(List<MenVO> listaMenE) {
        this.listaMenE = listaMenE;
    }

    public List<MenVO> getListaMenE() {
        return listaMenE;
    }


    public void setListaMenNuevaE(List<MenVO> listaMenNuevaE) {
        this.listaMenNuevaE = listaMenNuevaE;
    }

    public List<MenVO> getListaMenNuevaE() {
        return listaMenNuevaE;
    }


    public void setListaMenSeleccionadoE2(List<MenVO> listaMenSeleccionadoE2) {
        this.listaMenSeleccionadoE2 = listaMenSeleccionadoE2;
    }

    public List<MenVO> getListaMenSeleccionadoE2() {
        return listaMenSeleccionadoE2;
    }


    public void setActualizarB(Boolean actualizarB) {
        this.actualizarB = actualizarB;
    }

    public Boolean getActualizarB() {
        return actualizarB;
    }

    public void setLeerB(Boolean leerB) {
        this.leerB = leerB;
    }

    public Boolean getLeerB() {
        return leerB;
    }

    public void setInsertarB(Boolean insertarB) {
        this.insertarB = insertarB;
    }

    public Boolean getInsertarB() {
        return insertarB;
    }

    public void setEliminarB(Boolean eliminarB) {
        this.eliminarB = eliminarB;
    }

    public Boolean getEliminarB() {
        return eliminarB;
    }


    public void setActualizarBE(Boolean actualizarBE) {
        this.actualizarBE = actualizarBE;
    }

    public Boolean getActualizarBE() {
        return actualizarBE;
    }

    public void setLeerBE(Boolean leerBE) {
        this.leerBE = leerBE;
    }

    public Boolean getLeerBE() {
        return leerBE;
    }

    public void setInsertarBE(Boolean insertarBE) {
        this.insertarBE = insertarBE;
    }

    public Boolean getInsertarBE() {
        return insertarBE;
    }

    public void setEliminarBE(Boolean eliminarBE) {
        this.eliminarBE = eliminarBE;
    }

    public Boolean getEliminarBE() {
        return eliminarBE;
    }


    public void setTodo(Boolean todo) {
        this.todo = todo;
    }

    public Boolean getTodo() {
        return todo;
    }

    public void setTodoE(Boolean todoE) {
        this.todoE = todoE;
    }

    public Boolean getTodoE() {
        return todoE;
    }


    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

}


