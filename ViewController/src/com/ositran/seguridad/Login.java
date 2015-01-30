package com.ositran.seguridad;

import javax.annotation.Generated;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlForm;

import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

@ManagedBean(name = "backing_seguridad_login")
@RequestScoped
@Generated(value = "1seguridad/login.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Login {
    private HtmlForm form1;
    private InputText usuario;
    private Password contrasennia;
    private CommandButton cbIngresar;
    private CommandButton cbSalir;
    private static final String[] users = {"admin:12345","admin:12345"}; 
    private String username;
    private String password;     
    private boolean loggedIn;
    @ManagedProperty(value="#{navigationBean}")
    private NavigationBean navigationBean;
    

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setUsuario(InputText inputText1) {
        this.usuario = inputText1;
    }

    public InputText getUsuario() {
        return usuario;
    }

    public void setContrasennia(Password password1) {
        this.contrasennia = password1;
    }

    public Password getContrasennia() {
        return contrasennia;
    }

    public void setCbIngresar(CommandButton commandButton1) {
        this.cbIngresar = commandButton1;
    }

    public CommandButton getCbIngresar() {
        return cbIngresar;
    }

    public void setCbSalir(CommandButton commandButton1) {
        this.cbSalir = commandButton1;
    }

    public CommandButton getCbSalir() {
        return cbSalir;
    }
    
    
    
    public String doLogin(){
        // Get every user from our sample database :)
                for (String user: users) {
                    String dbUsername = user.split(":")[0];
                    String dbPassword = user.split(":")[1];
                     
                    // Successful login
                    //si ingresa pero no es el string
                    if (dbUsername.equals(username) && dbPassword.equals(password)) {
                        loggedIn = true;
                        return navigationBean.redirectToWelcome();
                    }
                }
        // Set login ERROR
                FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, msg);
                 
                // To to login page
                return navigationBean.toLogin();
    }
    
    /**
         * Logout operation.
         * @return
         */
        public String doLogout() {
            // Set the paremeter indicating that user is logged in to false
            loggedIn = false;
             
            // Set logout message
            FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, msg);
             
            return navigationBean.toLogin();
        }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public NavigationBean getNavigationBean() {
        return navigationBean;
    }
}
