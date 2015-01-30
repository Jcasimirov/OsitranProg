package BeansDatos;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="ositranMB")
@SessionScoped
public class OsitranMB {
	
	private String mensaje;
	
	public void validar(){
		mensaje="error";
		FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_FATAL, "mensaje de la clase","");  
        FacesContext.getCurrentInstance().addMessage(null, error);   	
	}
	
	public void guardar(){
		mensaje="Ha selecionado guardar";
		FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje,"");  
        FacesContext.getCurrentInstance().addMessage(null, error);   	
	}
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
