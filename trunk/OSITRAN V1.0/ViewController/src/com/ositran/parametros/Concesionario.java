package com.ositran.parametros;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ositran.service.CargoService;
import com.ositran.service.ConcesionarioService;
import com.ositran.service.TipoInversionServices;
import com.ositran.serviceimpl.TipoDocumentoServiceImpl;
import com.ositran.util.ControlAcceso;
import com.ositran.vo.bean.CargoVO;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.TipoDocumentoVO;

import com.ositran.vo.bean.TipoInversionVO;

import com.ositran.vo.bean.UsuarioVO;

import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
@ManagedBean(name = "concesionarioMB")
@RequestScoped
public class Concesionario {
    private int tipoD = 0;
    private String buscar;
    private int codigoConcesionario;
    private String nombreAntiguo;
    private String nombre;
    private String descripcion;
    private String siglasNombre;
    private String telefono;
    private int tipDocumento;
    private String numeroDocumento;
    private String direccion;
    private String correo;
    private String representante;
    private int codigoCargo;
    private int codigoDocumentoFiltro;
    //********************EDITAR***********************************/
    private int codigoConcesionarioE;
    private String nombreE;
    private String descripcionE;
    private String siglasNombreE;
    private String telefonoE;
    private int tipDocumentoE;
    private String numeroDocumentoE;
    private String direccionE;
    private String correoE;
    private String representanteE;
    private int codigoCargoE;
    private int concesionarioId;
    //********************EDITAR***********************************/
    
    public  final int formulario=2;
    
    
    private RolOpcionesVO rolOpcion;
    
    public void validarSesion() throws IOException{
            rolOpcion=ControlAcceso.getNewInstance().validarSesion(formulario);
        }
    
    private Pattern pattern;
    private Matcher matcher;
    int cantidad;

    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    List<ConcesionarioVO> listaCon;
    List<TipoDocumentoVO> listaTipDoc1;
    List<TipoDocumentoVO> listaTipoDoc;
    List<CargoVO> listCargo;
    @ManagedProperty(value = "#{concesionarioVO}")
    ConcesionarioVO concesionarioVO;
    @ManagedProperty(value = "#{tipoDocumentoServiceImp}")
    TipoDocumentoServiceImpl tipoDocumentoServiceImp;
    @ManagedProperty(value = "#{concesionarioServiceImpl}")
    ConcesionarioService concesionarioServiceImpl;
    @ManagedProperty(value = "#{cargoServiceImp}")
    CargoService cargoServiceImp;

   


    public void guardar() {
        
        cantidad=validarNombre(nombre);
        
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(correo);
        if (cantidad>0){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Advertencia",
                                                                              "El nombre que quiere ingresar ya existe"));
            }
        else if (nombre.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso",
                                                                          "Debe ingresar el nombre"));
        } else if (descripcion.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso",
                                                                          "Debe ingresar la descripcion"));
        } else if (tipDocumento == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso",
                                                                          "Debe selecionar tipo documento"));
        } else if (tipDocumento == 2 && numeroDocumento.length() != 11) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso",
                                                                          "El RUC debe de tener 11 dijitos"));
        } else if (tipDocumento == 1 && numeroDocumento.length() != 8) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso",
                                                                          "El DNI debe de tener 8 dijitos"));
        } else if (!correo.equals("") && matcher.find() != true) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso",
                                                                          correo +
                                                                          " No es un formato de correo valido "));

        } else if (representante.equals("")){
                          FacesContext.getCurrentInstance().addMessage(null,
                                                                       new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso",
                                                                                        " Debe ingresar el representante legal ")); 
                      }
        
        else {
            try {
               concesionarioVO.setCncCorreo(correo);
               concesionarioVO.setCncDescripcion(descripcion);
               concesionarioVO.setCncDireccion(direccion);
               concesionarioVO.setCncEstado(1);
               concesionarioVO.setCncFechaAlta(new Date());
               concesionarioVO.setCncNombre(nombre);
                concesionarioVO.setCncSiglas(siglasNombre);
               concesionarioVO.setCncNroDocumento(numeroDocumento);
               concesionarioVO.setCncRepresentanteLegal(representante);
               concesionarioVO.setCncTelefono(telefono);
               concesionarioVO.setTdoId(tipDocumento);
               concesionarioServiceImpl.insert(concesionarioVO);
               cargarListaConcesionarios();
               limpiarCampos();
               RequestContext.getCurrentInstance().execute("insertarPanel.hide()");
               FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                             "Se agregó el concesionario con éxito"));
           } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              correo +
                                                                              " No se pudo agregar el concecionario ")); 
                
            } 
            catch ( Exception e){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                  correo +
                                                                                  " No se pudo agregar el concecionario "));
                }
          
        }
    }

    public void cargarEditar() {
        try {         
           FacesContext context=FacesContext.getCurrentInstance();
           Map requestMap=context.getExternalContext().getRequestParameterMap();
           Object str=requestMap.get("idModificar");
           Integer idcodigo=Integer.valueOf(str.toString());
           concesionarioVO=concesionarioServiceImpl.get(idcodigo);
           concesionarioId = concesionarioVO.getCncId();
           codigoConcesionarioE = concesionarioVO.getCncId();
            nombreAntiguo=concesionarioVO.getCncNombre();
           nombreE = concesionarioVO.getCncNombre();
           descripcionE = concesionarioVO.getCncDescripcion();
           siglasNombreE = concesionarioVO.getCncSiglas();
           telefonoE = concesionarioVO.getCncTelefono();
           tipDocumentoE = concesionarioVO.getTdoId();
           numeroDocumentoE = concesionarioVO.getCncNroDocumento();
           direccionE = concesionarioVO.getCncDireccion();
           correoE = concesionarioVO.getCncCorreo();
           representanteE = concesionarioVO.getCncRepresentanteLegal();
       } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              correo +
                                                                              " No se pudo cargar los datos para editar concecionario ")); 
            } 
            catch ( Exception e){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                  correo +
                                                                                  " No se pudo cargar los datos para editar concecionario "));
                }
    }
    
     
    
    public void editar() {
        cantidad=validarNombre(nombreE);
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(correoE);
        
        if (cantidad>0 && !nombreE.equals(nombreAntiguo)){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Advertencia","El nuevo nombre que quiere ingresar ya existe"));
            }
        
        else if (nombreE.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe infresar el nombre"));
        } else if (descripcionE.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe de Ingresar la Descripcion"));
        } else if (tipDocumentoE == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          "Debe selecionar tipo documento"));
        } else if (tipDocumentoE == 2 && numeroDocumentoE.length() != 11) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              "El RUC debe de tener 11 dijitos"));
        } else if (tipDocumentoE == 1 && numeroDocumentoE.length() != 8) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              "El DNI debe de tener 8 dijitos"));
        } else if (!correoE.equals("") && matcher.find() != true) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          correoE +
                                                                          " No es un formato de correo valido "));

        } 
        
        else if (representanteE.equals("")){
                                  FacesContext.getCurrentInstance().addMessage(null,
                                                                               new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                                " Debe ingresar el representante legal ")); 
                              }
        
        else {
            
            try {
                
                concesionarioVO=concesionarioServiceImpl.get(concesionarioId);
                System.out.println("hola");
                System.out.println(concesionarioVO.getCncFechaAlta());
                concesionarioVO.setCncId(concesionarioId);
                concesionarioVO.setCncCorreo(correoE);
                concesionarioVO.setCncDescripcion(descripcionE);
                concesionarioVO.setCncDireccion(direccionE);
                concesionarioVO.setCncEstado(1);
                concesionarioVO.setCncFechaCambio(new Date());
                concesionarioVO.setCncNombre(nombreE);
                concesionarioVO.setCncNroDocumento(numeroDocumentoE);
                concesionarioVO.setCncRepresentanteLegal(representanteE);
                concesionarioVO.setCncTelefono(telefonoE);
                concesionarioVO.setCncSiglas(siglasNombreE);
                concesionarioVO.setTdoId(tipDocumentoE);
                concesionarioServiceImpl.update(concesionarioVO);
                cargarListaConcesionarios();
                RequestContext.getCurrentInstance().execute("editarPanel.hide()");
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                              "Se actualizó correctamente."));
            } catch (SQLException s) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              correo +
                                                                              " No se pudo editar el concecionario ")); 
                
            } 
            catch ( Exception e){
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                  correo +
                                                                                  " No se pudo editar el concecionario "));
                }
            
          
        }
    }
    
    
    
    public void buscarTipoDocumento(){
        try {
            
          
            
            
            if (codigoDocumentoFiltro==0){
                    int contador=1;
                    listaCon = concesionarioServiceImpl.query();
                    for(int i=0;i<listaCon.size();i++){
                      listaCon.get(i).setContador(contador);
                        contador++;
                        }
                
                }
            else{
                    
                    int contador=1;
                    listaCon = concesionarioServiceImpl.queryTD(codigoDocumentoFiltro);
                    for(int i=0;i<listaCon.size();i++){
                      listaCon.get(i).setContador(contador);
                        contador++;
                        }
                }
            
           
       } catch (Exception e) {
            
            e.printStackTrace();
        }
           
        
        }

    public void busqueda() {
       
                try {
                    
                      if (!buscar.equals("")){
                      int contador=1;
                      listaCon = concesionarioServiceImpl.queryF(buscar);
                      for(int i=0;i<listaCon.size();i++){
                        listaCon.get(i).setContador(contador);
                          contador++;
                          }}
                      else {
                              FacesContext.getCurrentInstance().addMessage(null,
                                                                           new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                            correo +
                                                                                            " Debe ingresar criterios de busqueda "));
                          }
                    
                    
                  } catch (SQLException s) {
                      FacesContext.getCurrentInstance().addMessage(null,
                                                                   new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                    correo +
                                                                                    " Problemas en la busqueda de concesionario ")); 
                      
                  } 
                    
                  catch ( Exception e){
                          FacesContext.getCurrentInstance().addMessage(null,
                                                                       new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                        correo +
                                                                                        "Problemas en la busqueda de concesionario  "));
                      
            
            }
        
       
      
      
    }

    public void cargarListaTipoDocumento() {
        try {
            listaTipDoc1=tipoDocumentoServiceImp.query();
           listaTipoDoc = tipoDocumentoServiceImp.query();
       } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          correo +
                                                                          " No se pudo editar el concecionario "));
        }
        
    }


    public void cargarListaConcesionarios() {
        try {
            int contador=1;
           listaCon = concesionarioServiceImpl.query();
            for(int i=0;i<listaCon.size();i++){
              listaCon.get(i).setContador(contador);
                contador++;
                }
       }
        catch (SQLException s) {
            s.printStackTrace();
                   FacesContext.getCurrentInstance().addMessage(null,
                                                                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                 correo +
                                                                                 " No se pudo editar el concecionario ")); 
                   
               } 
               catch ( Exception e){
            e.printStackTrace();
                       FacesContext.getCurrentInstance().addMessage(null,
                                                                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                                     correo +
                                                                                     " No se pudo editar el concecionario "));
                   }
        
    }

    public void cargarEliminar() {
        try {
           FacesContext context=FacesContext.getCurrentInstance();
           Map requestMap=context.getExternalContext().getRequestParameterMap();
            System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
           Object str=requestMap.get("idEliminar");
           System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
           int idcodigo=Integer.valueOf(str.toString());
           System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
           concesionarioVO=concesionarioServiceImpl.get(idcodigo);
           System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
           descripcion = concesionarioVO.getCncDescripcion();
           System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
           codigoConcesionario = concesionarioVO.getCncId();
           System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
       } catch (Exception e) {
            
            e.printStackTrace();
        }
      
    }

    public void eliminar() {
        try {
           concesionarioServiceImpl.delete(codigoConcesionario);
           cargarListaConcesionarios();
           FacesContext.getCurrentInstance().addMessage(null,
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso",
                                                                         "Se eliminó correctamente"));
       }  catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                          correo +
                                                                          " No se pudo eliminar ")); 
            
        } 
        catch ( Exception e){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                              correo +
                                                                              " No se pudo eliminar "));
            }
 
    }
    public int validarNombre(String nombre){
            int cantidad=0;

        try {
           cantidad=concesionarioServiceImpl.getCanNombres(nombre);
       } catch (SQLException s) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                        
                                                                          " No se pudo validar el nombre "));  
        } 
        catch ( Exception e){
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",
                                                                             
                                                                              " No se pudo validar el nombre "));
            }
        return cantidad;
        }
    public void limpiarCampos() {
        buscar = "";
        codigoConcesionario = 0;
        nombre = "";
        descripcion = "";
        siglasNombre = "";
        telefono = "";
        tipDocumento = 0;
        numeroDocumento = "";
        direccion = "";
        correo = "";
        representante = "";
        codigoCargo = 0;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSiglasNombre(String siglasNombre) {
        this.siglasNombre = siglasNombre;
    }

    public String getSiglasNombre() {
        return siglasNombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTipDocumento(int tipDocumento) {
        this.tipDocumento = tipDocumento;
    }

    public int getTipDocumento() {
        return tipDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getRepresentante() {
        return representante;
    }


    public void setCodigoCargo(int codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public int getCodigoCargo() {
        return codigoCargo;
    }

    public void setConcesionarioVO(ConcesionarioVO concesionarioVO) {
        this.concesionarioVO = concesionarioVO;
    }

    public ConcesionarioVO getConcesionarioVO() {
        return concesionarioVO;
    }

    public void setListaTipoDoc(List<TipoDocumentoVO> listaTipoDoc) {
        this.listaTipoDoc = listaTipoDoc;
    }

    public List<TipoDocumentoVO> getListaTipoDoc() {
        return listaTipoDoc;
    }


    public void setTipoDocumentoServiceImp(TipoDocumentoServiceImpl tipoDocumentoServiceImp) {
        this.tipoDocumentoServiceImp = tipoDocumentoServiceImp;
    }

    public TipoDocumentoServiceImpl getTipoDocumentoServiceImp() {
        return tipoDocumentoServiceImp;
    }


    public void setListCargo(List<CargoVO> listCargo) {
        this.listCargo = listCargo;
    }

    public List<CargoVO> getListCargo() {
        return listCargo;
    }

    public void setConcesionarioServiceImpl(ConcesionarioService concesionarioServiceImpl) {
        this.concesionarioServiceImpl = concesionarioServiceImpl;
    }

    public ConcesionarioService getConcesionarioServiceImpl() {
        return concesionarioServiceImpl;
    }

    public void setCargoServiceImp(CargoService cargoServiceImp) {
        this.cargoServiceImp = cargoServiceImp;
    }

    public CargoService getCargoServiceImp() {
        return cargoServiceImp;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setListaCon(List<ConcesionarioVO> listaCon) {
        this.listaCon = listaCon;
    }

    public List<ConcesionarioVO> getListaCon() {
        return listaCon;
    }

    public void setCodigoConcesionario(int codigoConcesionario) {
        this.codigoConcesionario = codigoConcesionario;
    }

    public int getCodigoConcesionario() {
        return codigoConcesionario;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setCodigoConcesionarioE(int codigoConcesionarioE) {
        this.codigoConcesionarioE = codigoConcesionarioE;
    }

    public int getCodigoConcesionarioE() {
        return codigoConcesionarioE;
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

    public void setSiglasNombreE(String siglasNombreE) {
        this.siglasNombreE = siglasNombreE;
    }

    public String getSiglasNombreE() {
        return siglasNombreE;
    }

    public void setTelefonoE(String telefonoE) {
        this.telefonoE = telefonoE;
    }

    public String getTelefonoE() {
        return telefonoE;
    }

    public void setTipDocumentoE(int tipDocumentoE) {
        this.tipDocumentoE = tipDocumentoE;
    }

    public int getTipDocumentoE() {
        return tipDocumentoE;
    }

    public void setNumeroDocumentoE(String numeroDocumentoE) {
        this.numeroDocumentoE = numeroDocumentoE;
    }

    public String getNumeroDocumentoE() {
        return numeroDocumentoE;
    }

    public void setDireccionE(String direccionE) {
        this.direccionE = direccionE;
    }

    public String getDireccionE() {
        return direccionE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setRepresentanteE(String representanteE) {
        this.representanteE = representanteE;
    }

    public String getRepresentanteE() {
        return representanteE;
    }

    public void setCodigoCargoE(int codigoCargoE) {
        this.codigoCargoE = codigoCargoE;
    }

    public int getCodigoCargoE() {
        return codigoCargoE;
    }

    public void setConcesionarioId(int concesionarioId) {
        this.concesionarioId = concesionarioId;
    }

    public int getConcesionarioId() {
        return concesionarioId;
    }

    public void setTipoD(int tipoD) {
        this.tipoD = tipoD;
    }

    public int getTipoD() {
        return tipoD;
    }


    public void setNombreAntiguo(String nombreAntiguo) {
        this.nombreAntiguo = nombreAntiguo;
    }

    public String getNombreAntiguo() {
        return nombreAntiguo;
    }


    public void setRolOpcion(RolOpcionesVO rolOpcion) {
        this.rolOpcion = rolOpcion;
    }

    public RolOpcionesVO getRolOpcion() {
        return rolOpcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }


    public void setCodigoDocumentoFiltro(int codigoDocumentoFiltro) {
        this.codigoDocumentoFiltro = codigoDocumentoFiltro;
    }

    public int getCodigoDocumentoFiltro() {
        return codigoDocumentoFiltro;
    }

    public void setListaTipDoc1(List<TipoDocumentoVO> listaTipDoc1) {
        this.listaTipDoc1 = listaTipDoc1;
    }

    public List<TipoDocumentoVO> getListaTipDoc1() {
        return listaTipDoc1;
    }
}
