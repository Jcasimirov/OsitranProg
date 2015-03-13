package com.ositran.seguridad;

import com.ositran.service.MenService;
import com.ositran.service.RolOpcionesService;
import com.ositran.service.RolService;
import com.ositran.vo.bean.MenVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.RolVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "rolMB")
@RequestScoped
public class RolMB {

    public RolMB() {
        super();
    }

    private String nombre;
    private String descripcion;
    private List<RolVO> listaRoles;
    private List<MenVO> listaMen;
    private List<MenVO> listaMenSeleccionado;
    private List<MenVO> listaMenSeleccionado1;
    
    private List<MenVO> listaMenSeleccionadoE;
    private List<MenVO> listaMenSeleccionadoE1;
    
    private List<RolOpcionesVO> listaRolOpciones;
    private int codigoRol;

    //*******EDITAR************************//
    private String nombreE;
    private String descripcionE;
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
        listaMenSeleccionado1.clear();
        limpiar();
        
    }
    public void limpiar() {
        nombre = "";
        descripcion = "";
    }

    public void cargarEditar() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("1");
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        System.out.println("2");
        Object str = requestMap.get("idActualizar");
        idE = Integer.parseInt(str.toString());
        System.out.println("4");
        rolVO = rolServiceImpl.get(idE);
        nombreE=rolVO.getRolNombre();
        descripcionE=rolVO.getRolDescripcion();
        System.out.println("5");
        listaMen=menServiceImpl.query();
        listaRolOpciones=rolOpcionesServiceImpl.query1(idE);
        System.out.println("6");
        
        System.out.println("7");
        for(RolOpcionesVO rolOpciones1 : listaRolOpciones){
              String nombre="";
              MenVO menVO2=new MenVO();
              menVO2.setCodigoRolOpciones(rolOpciones1.getRxoId());
              nombre =menServiceImpl.getNombre(rolOpciones1.getRolId());
            
            
            }
        
        
    }
    public void editar(){
        
        }


    public void cargarListaMenu() {
        listaMen = menServiceImpl.query();
        System.out.println("  Cantidad de Menu " + listaMen.size());
        limpiar();
        listaMenSeleccionado.clear();

    }

    public void cargarListaRolOpciones() {
        listaRolOpciones = rolOpcionesServiceImpl.query();
        System.out.println("cantidad de lista de rolOpciones " + listaRolOpciones.size());
    }

    public void pasarLista() {
      /*  FacesContext context=FacesContext.getCurrentInstance();
        Map requestMap=context.getExternalContext().getRequestParameterMap();
        Object str=requestMap.get("idEliminarLista");
        Integer idcodigo=Integer.valueOf(str.toString()); */
       // listaMenSeleccionado.clear();
        System.out.println(listaMenSeleccionado.size());
        System.out.println(listaMenSeleccionado1.size());
       // listaMenSeleccionado=listaMenSeleccionado1;
           
    }
    public void quitarLista(){
        //listaMenSeleccionado.clear();
        for (MenVO menVO :listaMenSeleccionado1){
            
            for (int i=0;i<listaMenSeleccionado.size();i++){
                if (menVO.getMenId()==listaMenSeleccionado.get(i).getMenId()){
                         listaMenSeleccionado.remove(i);
                    }
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
            System.out.println(rolOpcionesVO.getRxoId());
            System.out.println(rolOpcionesVO.getRolId());
            rolOpcionesServiceImpl.updateEstado(rolOpcionesVO.getRxoId());
        }
        rolServiceImpl.delete(idE);
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

        else if (listaMenSeleccionado.size() == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe Seleccionar al menos una opción del menú para este rol"));
        } else {


            rolVO.setRolNombre(nombre);
            rolVO.setRolDescripcion(descripcion);
            rolVO.setRolEstado(1);
            rolVO.setRolFechaAlta(new Date());
            rolVO.setRolUsuarioAlta("Abel Huarca");
            codigoRol = rolServiceImpl.getCodigo(rolVO);

            for (MenVO menVO : listaMenSeleccionado) {
                System.out.println(menVO.isActualizar());
                System.out.println(menVO.isCrear());
                System.out.println(menVO.isEliminar());
                System.out.println(menVO.isLectura());
                RolOpcionesVO rolOpcionesVO = new RolOpcionesVO();
                rolOpcionesVO.setRolId(codigoRol);
                rolOpcionesVO.setMenId(menVO.getMenId());
                rolOpcionesVO.setTroEstado(1);
                rolOpcionesVO.setTroAgregar((menVO.isCrear()) ? 1 : 0);
                rolOpcionesVO.setTroConsultar((menVO.isLectura()) ? 1 : 0);
                rolOpcionesVO.setTroEliminar((menVO.isEliminar()) ? 1 : 0);
                rolOpcionesVO.setTroModificar((menVO.isActualizar()) ? 1 : 0);
                rolOpcionesServiceImpl.insert(rolOpcionesVO);
                RequestContext.getCurrentInstance().execute("insertarPanel.hide()");
                cargarListaRoles();

            }
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

    public void setListaMenSeleccionado1(List<MenVO> listaMenSeleccionado1) {
        this.listaMenSeleccionado1 = listaMenSeleccionado1;
    }

    public List<MenVO> getListaMenSeleccionado1() {
        return listaMenSeleccionado1;
    }

    public void setListaMenSeleccionadoE(List<MenVO> listaMenSeleccionadoE) {
        this.listaMenSeleccionadoE = listaMenSeleccionadoE;
    }

    public List<MenVO> getListaMenSeleccionadoE() {
        return listaMenSeleccionadoE;
    }

    public void setListaMenSeleccionadoE1(List<MenVO> listaMenSeleccionadoE1) {
        this.listaMenSeleccionadoE1 = listaMenSeleccionadoE1;
    }

    public List<MenVO> getListaMenSeleccionadoE1() {
        return listaMenSeleccionadoE1;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }
}
