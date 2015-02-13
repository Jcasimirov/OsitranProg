package com.ositran.parametros;

import com.ositran.service.TipoInversionServices;
import com.ositran.vo.bean.TipoInversionVO;

import java.util.Date;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "tipoInversionMB")
@RequestScoped
public class TipoInversionMB {
    private int codigoEliminar;
    private String nombreEliminar;
    private List<TipoInversionVO> listaInversiones;
    private String nombre;
    private String descripcion; 

    @ManagedProperty(value="#{tipoInversionServicesImpl}")
        TipoInversionServices tipoInversionServicesImpl;

    public void setTipoInversionServicesImpl(TipoInversionServices tipoInversionServicesImpl) {
        this.tipoInversionServicesImpl = tipoInversionServicesImpl;
    }

    public TipoInversionServices getTipoInversionServicesImpl() {
        return tipoInversionServicesImpl;
    }
    public TipoInversionVO tipoInversionVO= new TipoInversionVO();
      
  
        public void guardar(){
          
            tipoInversionVO.setTivNombre(nombre);
            tipoInversionVO.setTivDescripcion(descripcion);              
            tipoInversionVO.setTivEstado(1);   
            tipoInversionVO.setTivFechaAlta(new Date());
            tipoInversionVO.setTivUsuarioAlta("Abel Huarca");
               
           getTipoInversionServicesImpl().insert(tipoInversionVO);
            
            ListarInversiones();
            }
        public void limpiar(){
            nombre="";
            descripcion="";
            }
        
        public void cargarEliminar(int codigo,String nombre ){
            System.out.println(nombre);
            nombreEliminar=nombre;
            System.out.println(nombreEliminar);
            codigoEliminar=codigo;
            System.out.println(codigoEliminar);
            }
        
        public void eliminar(int codigo){
        System.out.println(""+codigo+"");
        System.out.println(codigoEliminar);
            ListarInversiones();
            }
        
        public List<TipoInversionVO> ListarInversiones(){
            listaInversiones= getTipoInversionServicesImpl().query();           
            return listaInversiones;
        }
        
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }
        
        public void setTipoInversionVO(TipoInversionVO tipoInversionVO) {
            this.tipoInversionVO = tipoInversionVO;
        }

        public TipoInversionVO getTipoInversionVO() {
            return tipoInversionVO;
        }

        public void setListaInversiones(List<TipoInversionVO> listaInversiones) {
            this.listaInversiones = listaInversiones;
        }
    
        public List<TipoInversionVO> getListaInversiones() {
            return listaInversiones;
        }
        public void setCodigoEliminar(int codigoEliminar) {
            this.codigoEliminar = codigoEliminar;
        }
    
        public int getCodigoEliminar() {
            return codigoEliminar;
        }

        public void setNombreEliminar(String nombreEliminar) {
            this.nombreEliminar = nombreEliminar;
        }
    
        public String getNombreEliminar() {
            return nombreEliminar;
        }
  
}
