package com.ositran.seguridad;

import com.ositran.service.RolService;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.MonedaServiceImpl;
import com.ositran.serviceimpl.UsuarioServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.util.Reutilizar;
import com.ositran.util.Util;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.RolVO;
import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "mantenimientoUsuarioMB")
@RequestScoped

public class MantenimientoUsuario {
    public final int formulario = 4;
    private RolOpcionesVO rolOpcion;
    private UsuarioVO usuario;
    private int tipoInfraestructura;

    
    public void validarSesion() throws IOException {
        rolOpcion = ControlAcceso.getNewInstance().validarSesion(formulario);
        usuario = Reutilizar.getNewInstance().obtenerDatosUsuarioLogueado();
        tipoInfraestructura = Reutilizar.getNewInstance().obtenerDatosEmpleadoLogueado().getTinId();
    }
    
    
    private String usuAlias;
    private String usuCorreo;
    private String usuContrasenya;
    private String usuNombre;
    private int usuEstado;
    private List<RolVO> listaRoles = new ArrayList<>();
    private List<RolVO> listaRoles1 = new ArrayList<>();
    private List<InfraestructuraTipoVO> listaTipoInfraestructura = new ArrayList<>();
    private int codigoROl;
    private int codigoROl1;
    private int codigoROl2;
    private int codigoE;
    private int usuEsexterno;

    private int usuEsexternoE;

    private int codigoEE;
    private int usuEstadoE;
    private int codigoDocumentoFiltro;
    private int tinId;
    private String usuAliasE;
    private String usuContrasenyaE;
    private String usuNombreE;
    private String usuCorreoE;
    private String buscar;
    private String nomUserSearch;
    private int infraestructuraSeleccionada;
    private int infraestructuraSeleccionadaE;
    private int nomTipoSearch;
    private List<UsuarioVO> listaCon;
    int nomRolSearch;
    int nomEstSearch;
    private List<UsuarioVO> filtrar;
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @ManagedProperty(value = "#{usuarioVO}")
    private UsuarioVO usuarioVO;

    @ManagedProperty(value = "#{rolServiceImpl}")
    RolService rolServiceImpl;

    @ManagedProperty(value = "#{usuarioServiceImpl}")
    private UsuarioServiceImpl usuarioServiceImpl;
    
    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;
    
    private List<UsuarioVO> listaUsuario;
    Util util = new Util();
    
    public void listanombrerol() throws Exception{
        try {
           for (UsuarioVO usu : listaUsuario) {
               RolVO rol = getRolServiceImpl().get(usu.getRolId());
               usu.setNombreRol(rol.getRolNombre());
               
               InfraestructuraTipoVO infra = infraestructuraTipoServiceImpl.get(usu.getTinId());
               usu.setNombreInfra(infra.getTinNombre());
           }
           
       } catch (Exception e) {
           System.out.println(e);
        }
        }
    
    
    public List<UsuarioVO> ListarUsuario() throws SQLException {
        try {
            listaUsuario = getUsuarioServiceImpl().query();
            listanombrerol();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaUsuario;
    }
    
    
    public void cargarListaInfraestructura() {
        try {
            listaTipoInfraestructura = infraestructuraTipoServiceImpl.query();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    
    
    
    
    
    /*  -----Activar y Desactivar Usuario--------- */
    public void activarUsuario(UsuarioVO usuarioV) throws SQLException, Exception {
        try {
            usuarioVO = usuarioV;
            codigoE = usuarioVO.getUsuId();
            usuarioVO.setUsuId(codigoE);
            System.out.println(codigoE + " codigo E para activar usuario");
            usuarioVO.setUsuEstado(1);
            usuarioVO.setUsuFechaCambio(new Date());
            usuarioVO.setUsuFechaAlta(new Date());
            usuarioVO.setUsuUsuarioAlta("jim Alta");
            getUsuarioServiceImpl().update(usuarioVO);
            ListarUsuario();
            listanombrerol();
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
            System.out.println(codigoE + " codigo E para desactivar usuario");
            usuarioVO.setUsuEstado(2);
            usuarioVO.setUsuFechaCambio(new Date());
            usuarioVO.setUsuFechaBaja(new Date());
            usuarioVO.setUsuUsuarioBaja("jim Baja");
            getUsuarioServiceImpl().update(usuarioVO);
            ListarUsuario();
            listanombrerol();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
    /*  -----Fin Activar y Desactivar Usuario--------- */

    /* Guardar */
    public void guardarUsuario() throws Exception{
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(usuCorreo);

        if (usuEsexterno == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar tipo de usuario"));
        } else if (usuAlias.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar usuario"));
        } else if (usuContrasenya.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar contraseña"));
        } else if (usuNombre.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar nombre de usuario"));
        } else if (usuCorreo.equals("") || matcher.find() != true) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar correo de usuario"));
        }   else if (codigoROl == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso",
                                                                          "Ingresar rol de usuario"));
        }  else {
            try {
                usuEsexterno = getUsuEsexterno();
                codigoROl = getCodigoROl();
                usuarioVO.setUsuEsexterno(usuEsexterno);
                usuarioVO.setUsuAlias(usuAlias.toUpperCase());
                usuarioVO.setUsuContrasenya(usuContrasenya);
                usuarioVO.setUsuNombre(usuNombre.toUpperCase());
                usuarioVO.setUsuCorreo(usuCorreo);
                usuarioVO.setRolId(codigoROl);
                usuarioVO.setTinId(infraestructuraSeleccionada);
                usuarioVO.setUsuEstado(1);
                usuarioVO.setUsuUsuarioAlta(usuario.getUsuAlias());
                usuarioVO.setUsuFechaAlta(util.getObtenerFechaHoy());
                usuarioVO.setUsuTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
                System.out.println("antes del insetr");
                getUsuarioServiceImpl().insert(usuarioVO);

                RequestContext.getCurrentInstance().execute("agregarUsuario.hide()");
                ListarUsuario();
                listanombrerol();
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
    public void cargarEditar() {
        try {
            //inicio de captura de codigo a modificar
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            Object str = requestMap.get("idModificar");
            Integer idcodigo = Integer.valueOf(str.toString());
            usuarioVO = usuarioServiceImpl.get(idcodigo);
            //fin de de captura de codigo a modificar
            
            infraestructuraSeleccionadaE=usuarioVO.getTinId();
            codigoEE = usuarioVO.getUsuId();
            usuEsexternoE = usuarioVO.getUsuEsexterno();
            usuAliasE = usuarioVO.getUsuAlias();
            usuContrasenyaE = usuarioVO.getUsuContrasenya();
            usuNombreE = usuarioVO.getUsuNombre();
            usuCorreoE = usuarioVO.getUsuCorreo();
            usuEstadoE = usuarioVO.getUsuEstado();
            codigoROl1 = usuarioVO.getRolId();
        } catch (SQLException e) {
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
            usuarioVO.setTinId(infraestructuraSeleccionadaE);
            usuarioVO.setUsuAlias(usuAliasE.toUpperCase());
            usuarioVO.setUsuContrasenya(usuContrasenyaE);
            usuarioVO.setUsuNombre(usuNombreE.toUpperCase());
            usuarioVO.setUsuCorreo(usuCorreoE);
            usuarioVO.setRolId(codigoROl1);
            usuarioVO.setUsuEstado(usuEstadoE);
            usuarioVO.setUsuUsuarioCambio(usuario.getUsuAlias());
            usuarioVO.setUsuFechaCambio(util.getObtenerFechaHoy());
            usuarioVO.setUsuTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
            getUsuarioServiceImpl().update(usuarioVO);
            ListarUsuario();
            listanombrerol();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                          "Se Modifico con Exito"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " error "));
        }
    }
    /*  -----Fin Editar Usuario--------- */

    /*  -----Buscar--------- */
    public List<UsuarioVO> SearchListaUsuario() throws SQLException {
        try {  
            listanombrerol();
            listaUsuario = this.usuarioServiceImpl.UserSearch(nomUserSearch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaUsuario;
    }

    public void buscarTipo() {
        try {
            if (nomTipoSearch == 0) {
            } else {
                int contador = 1;
                listaUsuario = usuarioServiceImpl.queryTD(nomTipoSearch);
                for (int i = 0; i < listaUsuario.size(); i++) {
                    listaUsuario.get(i).setContador(contador);
                    contador++;
                }
                listanombrerol();            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarRol() {
        try {
            if (codigoROl2 == 0) {
            } else {
                int contador = 1;
                listaUsuario = usuarioServiceImpl.queryTD(codigoROl2);
                for (int i = 0; i < listaUsuario.size(); i++) {
                    listaUsuario.get(i).setContador(contador);
                    contador++;
                }
                listanombrerol();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarTodo() {
        try {
            int contador = 1;
            listaUsuario = usuarioServiceImpl.query();
            for (int i = 0; i < listaUsuario.size(); i++) {
                listaUsuario.get(i).setContador(contador);
                contador++;
            }
            listanombrerol();
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          " No se pudo listar"));
        }
    }
    /*  -----Fin Buscar --------- */

    public void setNomUserSearch(String nomUserSearch) {
        this.nomUserSearch = nomUserSearch;
    }

    public String getNomUserSearch() {
        return nomUserSearch;
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


    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

    public void setUsuEsexterno(int usuEsexterno) {
        this.usuEsexterno = usuEsexterno;
    }

    public int getUsuEsexterno() {
        return usuEsexterno;
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

    

    public void listarRoles() {
        listaRoles = rolServiceImpl.query();
    }

    public void listarRoles2() {
        listaRoles1 = rolServiceImpl.query();
    }


    public void setUsuarioServiceImpl(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    public UsuarioServiceImpl getUsuarioServiceImpl() {
        return usuarioServiceImpl;
    }

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

    public void setCodigoE(int codigoE) {
        this.codigoE = codigoE;
    }

    public int getCodigoE() {
        return codigoE;
    }


    public void setNomTipoSearch(int nomTipoSearch) {
        this.nomTipoSearch = nomTipoSearch;
    }

    public int getNomTipoSearch() {
        return nomTipoSearch;
    }

    public void setCodigoDocumentoFiltro(int codigoDocumentoFiltro) {
        this.codigoDocumentoFiltro = codigoDocumentoFiltro;
    }

    public int getCodigoDocumentoFiltro() {
        return codigoDocumentoFiltro;
    }


    public void setListaCon(List<UsuarioVO> listaCon) {
        this.listaCon = listaCon;
    }

    public List<UsuarioVO> getListaCon() {
        return listaCon;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setTipoInfraestructura(int tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public int getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setListaTipoInfraestructura(List<InfraestructuraTipoVO> listaTipoInfraestructura) {
        this.listaTipoInfraestructura = listaTipoInfraestructura;
    }

    public List<InfraestructuraTipoVO> getListaTipoInfraestructura() {
        return listaTipoInfraestructura;
    }


    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }


    public void setInfraestructuraSeleccionada(int infraestructuraSeleccionada) {
        this.infraestructuraSeleccionada = infraestructuraSeleccionada;
    }

    public int getInfraestructuraSeleccionada() {
        return infraestructuraSeleccionada;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }

    public int getTinId() {
        return tinId;
    }

    public void setCodigoROl1(int codigoROl1) {
        this.codigoROl1 = codigoROl1;
    }

    public int getCodigoROl1() {
        return codigoROl1;
    }

    public void setInfraestructuraSeleccionadaE(int infraestructuraSeleccionadaE) {
        this.infraestructuraSeleccionadaE = infraestructuraSeleccionadaE;
    }

    public int getInfraestructuraSeleccionadaE() {
        return infraestructuraSeleccionadaE;
    }
}
