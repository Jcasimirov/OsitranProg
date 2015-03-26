package com.ositran;

/** @author Jim Casimiro
   * Método que loguea la aplicacion con el mantenimiento de usuarios y el Active Directory
   * @param login
   * @version 26/03/2015
*/

import com.ositran.service.RolOpcionesService;
import com.ositran.service.UsuarioService;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.UsuarioVO;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;

import javax.naming.directory.InitialDirContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "loginMB")
@RequestScoped
public class Logueo {

    private HttpServletRequest httpServletRequest = null;
    private FacesContext faceContext = null;
    private List<UsuarioVO> listaUsuario = new ArrayList<>();
    private List<RolOpcionesVO> listaRolOpciones = new ArrayList<>();
    private int codigoRol;
    private String password;
    private String usuario;
    private String contrasenha;
    private int externo = 0;
    private boolean validar = false;

    /* -- active directory -- */
    private String user;
    private String pass;
    private String domain = "proyositran.com";
    private String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory";
    private String MY_HOST = "ldap://192.168.2.23";
    /* -- active directory -- */

    @ManagedProperty(value = "#{usuarioServiceImpl}")
    UsuarioService usuarioServiceImpl;
    @ManagedProperty(value = "#{rolOpcionesServiceImpl}")
    RolOpcionesService rolOpcionesServiceImpl;

    public void logear() {

        try {
            // metodo para hacer el redireth y direccionar ala pagina deseada
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();

            //aqui listamos y validamos que el usuario exista en la base de datos
            listaUsuario = usuarioServiceImpl.query();
            for (UsuarioVO usua : listaUsuario) {
                if (usuario.equals(usua.getUsuAlias())) {
                    validar = true;
                    password = usua.getUsuContrasenya();
                    externo = usua.getUsuEsexterno();
                    codigoRol = usua.getRolId();
                    listaRolOpciones = rolOpcionesServiceImpl.query1(codigoRol);
                }
            }

            //si el usuario no existe entonces validar es falso y nos devuelve mensaje que no existe usuario
            if (validar == false) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                              "El usuario ingresado no existe"));
            }
            //si el usuario existe y ala vez es un usuario interno validara el usuario con el active directory
            else if (1 == externo && contrasenha.equals(password)) {

                faceContext = FacesContext.getCurrentInstance();
                httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute("UsuarioSesion", usuario);
                session.setAttribute("PassSesion", contrasenha);
                session.setAttribute("listaPermisos", listaRolOpciones);
                session.setAttribute("listaUsuario", listaUsuario);

                DirContext ctx = null;
                setUser(getUsuario());
                setPass(getContrasenha());
                Hashtable<String, String> env = new Hashtable<String, String>();
                env.put(Context.INITIAL_CONTEXT_FACTORY, INITCTX);
                env.put(Context.PROVIDER_URL, MY_HOST);
                env.put(Context.SECURITY_AUTHENTICATION, "simple");
                env.put(Context.SECURITY_PRINCIPAL, user + "@" + domain);
                env.put(Context.SECURITY_CREDENTIALS, pass);
                //si el usuario interno existe en el active directory  hace la conexion
                try {
                    ctx = new InitialDirContext(env);
                    // connected. Login success
                    System.out.println("SE HA CONECTADOOOO !!!.. !!!!");
                    System.out.println("validacion de active directory y base de datos");
                    String redirectPath = "/faces/ositran/principal.xhtml";
                    externalContext.redirect(servletContext.getContextPath() + redirectPath);

                    // si el usuario interno no exite en el active directory no se puede conectar
                } catch (Exception ex) {
                    System.out.println("no se ha conectado1");
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                                  "User or password are wrong"));

                } finally {
                    if (ctx != null) {
                        try {
                            ctx.close();
                        } catch (NamingException e) {
                            System.out.println("no se ha conectado2");
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                          "Aviso",
                                                                                          "El usuario o contraseña son incorrectas"));
                        }
                    }
                }
                // si el usuario es externo solo valida con la base de datos y direcciona a la pagina principal
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                              "No tiene permisos"));
            }
        } catch (Exception s) {
            System.out.println("error con la conexion...!");
            s.printStackTrace();
        }
    }

    //metodos
    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setFaceContext(FacesContext faceContext) {
        this.faceContext = faceContext;
    }

    public FacesContext getFaceContext() {
        return faceContext;
    }

    public void setListaUsuario(List<UsuarioVO> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<UsuarioVO> getListaUsuario() {
        return listaUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setExterno(int externo) {
        this.externo = externo;
    }

    public int getExterno() {
        return externo;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setINITCTX(String INITCTX) {
        this.INITCTX = INITCTX;
    }

    public String getINITCTX() {
        return INITCTX;
    }

    public void setMY_HOST(String MY_HOST) {
        this.MY_HOST = MY_HOST;
    }

    public String getMY_HOST() {
        return MY_HOST;
    }

    public void setUsuarioServiceImpl(UsuarioService usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    public UsuarioService getUsuarioServiceImpl() {
        return usuarioServiceImpl;
    }

    public void setValidar(boolean validar) {
        this.validar = validar;
    }

    public boolean isValidar() {
        return validar;
    }


    public void setListaRolOpciones(List<RolOpcionesVO> listaRolOpciones) {
        this.listaRolOpciones = listaRolOpciones;
    }

    public List<RolOpcionesVO> getListaRolOpciones() {
        return listaRolOpciones;
    }

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    public int getCodigoRol() {
        return codigoRol;
    }

    public void setRolOpcionesServiceImpl(RolOpcionesService rolOpcionesServiceImpl) {
        this.rolOpcionesServiceImpl = rolOpcionesServiceImpl;
    }

    public RolOpcionesService getRolOpcionesServiceImpl() {
        return rolOpcionesServiceImpl;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
