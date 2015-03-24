package com.ositran.util;

import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ControlAcceso {
     
    private  HttpServletRequest httpServletRequest=null;
    private  FacesContext faceContext=null;
    private int leerSesion;
    private List<RolOpcionesVO> listaRolOpciones=new ArrayList<>();
    private List<UsuarioVO> listaUsuarios=new ArrayList<>();
    private int ingresarSesion;
    private int eliminarSesion;
    private int actualizarSesion;
    private String parametroValidacion;
    
    public boolean validarSesion(int formulario){
        try {
           faceContext=FacesContext.getCurrentInstance();
           httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
           HttpSession session = httpServletRequest.getSession();
           listaUsuarios=(List<UsuarioVO>)session.getAttribute("listaUsuario");
           listaRolOpciones=(List<RolOpcionesVO>)session.getAttribute("listaPermisos");
        
           for (RolOpcionesVO rolO:listaRolOpciones){
               if (rolO.getMenId()==formulario){
                   parametroValidacion="true";
                   }
               }
           
           if (!"true".equals(parametroValidacion)) {
                   
                   FacesContext context = FacesContext.getCurrentInstance();
                   ExternalContext externalContext = context.getExternalContext();
                   ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
                   faceContext=FacesContext.getCurrentInstance();
                   httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
                    String redirectPath = "/faces/ositran/logueo.xhtml";
                    externalContext.redirect(servletContext.getContextPath() + redirectPath);
               }
           else {
               
               for (RolOpcionesVO rolOpcion:listaRolOpciones){
                   if (rolOpcion.getMenId()==formulario){
                       leerSesion=rolOpcion.getTroConsultar();
                       ingresarSesion=rolOpcion.getTroAgregar();
                       actualizarSesion=rolOpcion.getTroModificar();
                       eliminarSesion=rolOpcion.getTroEliminar();

                       }
                   }
               } 
            
            }
        
            catch(IOException io){
            io.printStackTrace();
            }
        catch (Exception ex){
            ex.printStackTrace();
            }
        finally{
            
            
            }
        
        
        
        
        return true;
        }
    
}
