package com.ositran.seguridad;

import com.ositran.service.RolOpcionesService;
import com.ositran.serviceimpl.MenServiceImpl;
import com.ositran.serviceimpl.RolServiceImpl;
import com.ositran.vo.bean.MenVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "opcionesSistemasMB")
@RequestScoped
public class OpcionesSistemaMB {
    private String buscar;
    private int contador;
    private String  nombreE;
    private String descripcionE;
    private int formulario;
    private int codigoMenu;
    private List<MenVO> listaOpcionesSistema= new ArrayList<>();
    
    @ManagedProperty(value = "#{menServiceImpl}")
    MenServiceImpl menServiceImpl;
    
    @ManagedProperty(value = "#{menVO}")
    MenVO menVO;
   
    
    public OpcionesSistemaMB() {
        super();
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
        System.out.println("**********************");
        System.out.println(codigoMenu);
            System.out.println("**********************");
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
            menVO.setMenId(codigoMenu);
            menVO.setMenFormulario("1");
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

}
