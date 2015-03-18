package com.ositran.seguridad;

import com.ositran.model.Rol;
import com.ositran.service.RolService;
import com.ositran.serviceimpl.RolServiceImpl;
import com.ositran.serviceimpl.UsuarioServiceImpl;
import com.ositran.util.Util;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.RolVO;
import com.ositran.vo.bean.UsuarioVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Generated;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import javax.swing.JOptionPane;

import org.hibernate.sql.Alias;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "mantenimientoUsuarioMB")
@RequestScoped

public class MantenimientoUsuario {
    private String usuAlias;
    private String usuCorreo;
    private String usuContrasenya;
    private String usuNombre;
    private int usuEstado;
    private List<RolVO> listaRoles=new ArrayList<>();
    private List<RolVO> listaRoles1=new ArrayList<>();
    private int codigoROl;
    private int codigoROl2;

    @ManagedProperty(value = "#{usuarioVO}")
    private UsuarioVO usuarioVO;
    
    @ManagedProperty(value = "#{rolServiceImpl}")
    RolService rolServiceImpl;

    @ManagedProperty(value = "#{usuarioServiceImpl}")
    private UsuarioServiceImpl usuarioServiceImpl;

    public void  listarRoles(){
        listaRoles=rolServiceImpl.query();
        }
    public void  listarRoles2(){
        listaRoles1=rolServiceImpl.query();
        }
    

    public void setUsuarioServiceImpl(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    public UsuarioServiceImpl getUsuarioServiceImpl() {
        return usuarioServiceImpl;
    }

    private List<UsuarioVO> listaUsuario;
    Util util = new Util();

    public void setListaUsuario(List<UsuarioVO> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<UsuarioVO> getListaUsuario() {
        return listaUsuario;
    }

    public void setUtil(Util util) {
        this.util = util;
    }

    public Util getUtil() {
        return util;
    }

    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }

    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    public List<UsuarioVO> ListarUsuario() throws SQLException {
        try {
            listaUsuario = getUsuarioServiceImpl().query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

        return listaUsuario;
    }
    /* fin listar */

    /*  -----Activar y Desactivar Usuario--------- */
    private int codigoE;

    public void setCodigoE(int codigoE) {
        this.codigoE = codigoE;
    }

    public int getCodigoE() {
        return codigoE;
    }

    public void activarUsuario(UsuarioVO usuarioV) throws SQLException, Exception {
        try {
            usuarioVO = usuarioV;
            codigoE = usuarioVO.getUsuId(); 
            usuarioVO.setUsuId(codigoE);
            System.out.println(codigoE +" codigo E para activar usuario");
            usuarioVO.setUsuEstado(1);
            usuarioVO.setUsuFechaCambio(new Date());
            usuarioVO.setUsuFechaAlta(new Date());
            usuarioVO.setUsuUsuarioAlta("jim Alta");
            getUsuarioServiceImpl().update(usuarioVO);
            ListarUsuario();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    public void desactivarUsuario(UsuarioVO usuarioV) throws SQLException, Exception {
        try {
            usuarioVO = usuarioV;
            codigoE = usuarioVO.getUsuId();
            usuarioVO.setUsuId(codigoE);
            System.out.println(codigoE +" codigo E para desactivar usuario");
            usuarioVO.setUsuEstado(2);
            usuarioVO.setUsuFechaCambio(new Date());
            usuarioVO.setUsuFechaBaja(new Date());
            usuarioVO.setUsuUsuarioBaja("jim Baja");
            getUsuarioServiceImpl().update(usuarioVO);
            ListarUsuario();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

    }
    /*  -----Fin Activar y Desactivar Usuario--------- */

    /* Guardar */
    private int usuEsexterno;
    private int rol;
    private Pattern pattern;
    private Matcher matcher;

    public void setUsuEsexterno(int usuEsexterno) {
        this.usuEsexterno = usuEsexterno;
    }

    public int getUsuEsexterno() {
        return usuEsexterno;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getRol() {
        return rol;
    }


    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public void guardarUsuario()  {

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(usuCorreo);

         if (usuEsexterno == 0 || usuAlias.equals("") || usuContrasenya.equals("") || usuNombre.equals("") ||
            codigoROl == 0 ||  usuCorreo.equals("") || matcher.find() != true) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "No se Registro por problemas, try again"));
        } 
           else  {
            try {
                usuEsexterno = getUsuEsexterno();
                rol = getRol();
                usuarioVO.setUsuEsexterno(usuEsexterno);
                usuarioVO.setUsuAlias(usuAlias.toUpperCase());
                usuarioVO.setUsuContrasenya(usuContrasenya);
                usuarioVO.setUsuNombre(usuNombre.toUpperCase());
                usuarioVO.setUsuCorreo(usuCorreo);
                usuarioVO.setRolId(codigoROl);              
                usuarioVO.setUsuEstado(1);
                usuarioVO.setUsuFechaAlta(util.getObtenerFechaHoy());
                usuarioVO.setUsuTerminal(util.obtenerIpCliente());
                System.out.println("antes del insetr");
                getUsuarioServiceImpl().insert(usuarioVO);
                
                RequestContext.getCurrentInstance().execute("agregarUsuario.hide()");
                ListarUsuario();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                              "Se Registro con Exito"));
            } catch (SQLException e) {
                e.printStackTrace();
        } 
        
           }

    }
    /* Fin Guardar */

    /*  -----Editar Usuario--------- */
    private int usuEsexternoE;
    private int rolE;
    private int codigoEE;
    private int usuEstadoE;
    private String usuAliasE;
    private String usuContrasenyaE;
    private String usuNombreE;
    private String usuCorreoE;


    public void cargarEditar()  {
        try {
            //inicio de captura de codigo a modificar
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            Object str = requestMap.get("idModificar");
            Integer idcodigo = Integer.valueOf(str.toString());
            usuarioVO = usuarioServiceImpl.get(idcodigo);
            //fin de de captura de codigo a modificar

            codigoEE = usuarioVO.getUsuId();
            System.out.println(codigoEE);
            usuEsexternoE = usuarioVO.getUsuEsexterno();
            
            rolE = usuarioVO.getRolId();
            usuAliasE = usuarioVO.getUsuAlias();
            usuContrasenyaE = usuarioVO.getUsuContrasenya();
            usuNombreE = usuarioVO.getUsuNombre();
            usuCorreoE = usuarioVO.getUsuCorreo();
            usuEstadoE = usuarioVO.getUsuEstado();
        } catch (SQLException e) {
            // TODO: Add catch code
            e.printStackTrace();
        } catch (Exception s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " error "));
            }

    }

    public void modificarUsuario() throws SQLException {

        try {
            usuarioVO.setUsuId(codigoEE);
            System.out.println(codigoEE);
            usuarioVO.setUsuEsexterno(usuEsexternoE);
            usuarioVO.setUsuAlias(usuAliasE.toUpperCase());
            usuarioVO.setUsuContrasenya(usuContrasenyaE);
            usuarioVO.setUsuNombre(usuNombreE.toUpperCase());
            usuarioVO.setUsuCorreo(usuCorreoE);
            usuarioVO.setRolId(rolE);
            
            usuarioVO.setUsuEstado(usuEstadoE);
            usuarioVO.setUsuFechaCambio(new Date());
            usuarioVO.setUsuTerminal(util.obtenerIpCliente());
            getUsuarioServiceImpl().update(usuarioVO);
            ListarUsuario();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se Modifico con Exito"));
        } catch (SQLException e) {
            // TODO: Add catch code
            e.printStackTrace();
        } catch (Exception s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              " error "));
            }


    }
    /*  -----Fin Editar Usuario--------- */

    /*  -----Buscar--------- */

    private String buscar;
    private List<UsuarioVO> filtrar;

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setFiltrar(List<UsuarioVO> filtrar) {
        this.filtrar = filtrar;
    }

    public List<UsuarioVO> getFiltrar() {
        return filtrar;
    }

    public List<UsuarioVO> SearchListaUsuario() throws SQLException {
        try {
            listaUsuario = this.usuarioServiceImpl.UserSearch(nomUserSearch, nomNomSearch, nomTipoSearch);


        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return listaUsuario;
    }


    String nomUserSearch;
    String nomNomSearch;
    int nomTipoSearch;
    int nomRolSearch;
    int nomEstSearch;

    public void setNomUserSearch(String nomUserSearch) {
        this.nomUserSearch = nomUserSearch;
    }

    public String getNomUserSearch() {
        return nomUserSearch;
    }

    public void setNomNomSearch(String nomNomSearch) {
        this.nomNomSearch = nomNomSearch;
    }

    public String getNomNomSearch() {
        return nomNomSearch;
    }


    public void setNomTipoSearch(int nomTipoSearch) {
        this.nomTipoSearch = nomTipoSearch;
    }

    public int getNomTipoSearch() {
        return nomTipoSearch;
    }

    public void setNomRolSearch(int nomRolSearch) {
        this.nomRolSearch = nomRolSearch;
    }

    public int getNomRolSearch() {
        return nomRolSearch;
    }

    public void setNomEstSearch(int nomEstSearch) {
        this.nomEstSearch = nomEstSearch;
    }

    public int getNomEstSearch() {
        return nomEstSearch;
    }


    /*  -----Fin Buscar --------- */


    public void setUsuEstadoE(int usuEstadoE) {
        this.usuEstadoE = usuEstadoE;
    }

    public int getUsuEstadoE() {
        return usuEstadoE;
    }

    public void setCodigoEE(int codigoEE) {
        this.codigoEE = codigoEE;
    }

    public int getCodigoEE() {
        return codigoEE;
    }

    public void setUsuEsexternoE(int usuEsexternoE) {
        this.usuEsexternoE = usuEsexternoE;
    }

    public int getUsuEsexternoE() {
        return usuEsexternoE;
    }



    public void setRolE(int rolE) {
        this.rolE = rolE;
    }

    public int getRolE() {
        return rolE;
    }

    public void setUsuAliasE(String usuAliasE) {
        this.usuAliasE = usuAliasE;
    }

    public String getUsuAliasE() {
        return usuAliasE;
    }

    public void setUsuCorreoE(String usuCorreoE) {
        this.usuCorreoE = usuCorreoE;
    }

    public String getUsuCorreoE() {
        return usuCorreoE;
    }

    public void setUsuContrasenyaE(String usuContrasenyaE) {
        this.usuContrasenyaE = usuContrasenyaE;
    }

    public String getUsuContrasenyaE() {
        return usuContrasenyaE;
    }

    public void setUsuNombreE(String usuNombreE) {
        this.usuNombreE = usuNombreE;
    }

    public String getUsuNombreE() {
        return usuNombreE;
    }


    public void setUsuAlias(String usuAlias) {
        this.usuAlias = usuAlias;
    }

    public String getUsuAlias() {
        return usuAlias;
    }


    public void setUsuContrasenya(String usuContrasenya) {
        this.usuContrasenya = usuContrasenya;
    }

    public String getUsuContrasenya() {
        return usuContrasenya;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuEstado(int usuEstado) {
        this.usuEstado = usuEstado;
    }

    public int getUsuEstado() {
        return usuEstado;
    }


    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }


    public void setListaRoles(List<RolVO> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public List<RolVO> getListaRoles() {
        return listaRoles;
    }

    public void setCodigoROl(int codigoROl) {
        this.codigoROl = codigoROl;
    }

    public int getCodigoROl() {
        return codigoROl;
    }

    public void setRolServiceImpl(RolService rolServiceImpl) {
        this.rolServiceImpl = rolServiceImpl;
    }

    public RolService getRolServiceImpl() {
        return rolServiceImpl;
    }


    public void setListaRoles1(List<RolVO> listaRoles1) {
        this.listaRoles1 = listaRoles1;
    }

    public List<RolVO> getListaRoles1() {
        return listaRoles1;
    }

    public void setCodigoROl2(int codigoROl2) {
        this.codigoROl2 = codigoROl2;
    }

    public int getCodigoROl2() {
        return codigoROl2;
    }
}
