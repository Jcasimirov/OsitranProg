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
    public static ControlAcceso newInstance;   
    private HttpServletRequest httpServletRequest = null;
    private FacesContext faceContext = null;
    private List<RolOpcionesVO> listaRolOpciones = new ArrayList<>();
    private List<UsuarioVO> listaUsuarios = new ArrayList<>();
    private boolean parametroValidacion = false;

    public RolOpcionesVO validarSesion(int formulario) throws IOException {
        RolOpcionesVO roles = new RolOpcionesVO();
        try {
            faceContext = FacesContext.getCurrentInstance();
            httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
            HttpSession session = httpServletRequest.getSession();
            listaUsuarios = (List<UsuarioVO>) session.getAttribute("listaUsuario");
            listaRolOpciones = (List<RolOpcionesVO>) session.getAttribute("listaPermisos");

            for (RolOpcionesVO rolO : listaRolOpciones) {
                if (rolO.getMenId() == formulario) 
                    parametroValidacion = true;                
            }
            if (!parametroValidacion) {
              logout();
            } else {
                for (RolOpcionesVO rolOpcion : listaRolOpciones) {
                    if (rolOpcion.getMenId() == formulario) 
                        return rolOpcion;                    
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            logout();
        }
        return null;
    }
    public void logout()throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        String redirectPath = "/faces/ositran/logueo.xhtml";
        externalContext.redirect(servletContext.getContextPath() + redirectPath);
    }
    public void logoutSesionInvalidate()throws IOException{
        faceContext = FacesContext.getCurrentInstance();
        

       
        ExternalContext externalContext = faceContext.getExternalContext();
        ServletContext servletContext = (ServletContext) faceContext.getExternalContext().getContext();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        HttpSession session = httpServletRequest.getSession();
        session.invalidate();
        String redirectPath = "/faces/ositran/logueo.xhtml";
        externalContext.redirect(servletContext.getContextPath() + redirectPath);
    }
    public static void setNewInstance(ControlAcceso newInstance) {
        ControlAcceso.newInstance = newInstance;
    }

    public static ControlAcceso getNewInstance() {
        return newInstance;
    }
}
