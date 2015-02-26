package com.ositran.util;

import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class Util{
    public Date getObtenerFechaHoy(){
        Date date=null;
        try{
            date=new Date();
        }catch(Exception e){
            e.getMessage();
        }
        return date;
    }
    
    public String obtenerIpCliente(){
        String remoteAddr = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr(); 
        return remoteAddr;
    }
}