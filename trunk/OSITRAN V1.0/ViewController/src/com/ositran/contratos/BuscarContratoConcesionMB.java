package com.ositran.contratos;

import com.ositran.service.ConcesionarioService;
import com.ositran.service.DatosStdService;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.ContratoConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;
import com.ositran.serviceimpl.ModalidadConcesionServiceImpl;
import com.ositran.serviceimpl.TipoDocumentoServiceImpl;

import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.ContratoVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.ModalidadConcesionVO;
import com.ositran.vo.bean.TipoDocumentoVO;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;

@ManagedBean(name = "bk_buscarContratoConcesion")
@ViewScoped
public class BuscarContratoConcesionMB {
    private HtmlForm form;


    public void setForm(HtmlForm form) {
        this.form = form;
    }

    public HtmlForm getForm() {
        return form;
    }
    
    // Service

    @ManagedProperty(value = "#{infraestructuraTipoServiceImpl}")
    private InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl;

    @ManagedProperty(value = "#{concesionServiceImpl}")
    ConcesionServiceImpl concesionServiceImpl;

    @ManagedProperty(value = "#{modalidadServiceImp}")
    ModalidadConcesionServiceImpl modalidadServiceImp;
    
    @ManagedProperty(value = "#{contratoConcesionServiceImp}")
    ContratoConcesionServiceImpl contratoConcesionServiceImp;
    
    @ManagedProperty(value = "#{concesionarioServiceImpl}")
    ConcesionarioService concesionarioServiceImpl;
    
    // Lista Bean VO

    List<InfraestructuraTipoVO> listaInfraestructura;

    List<ConcesionVO> listaConcesiones;

    List<ModalidadConcesionVO> listaModalidad;
    
    List<ContratoVO> listaContrato;
    
    // Metodos Get y Set


    public void setInfraestructuraTipoServiceImpl(InfraestructuraTipoServiceImpl infraestructuraTipoServiceImpl) {
        this.infraestructuraTipoServiceImpl = infraestructuraTipoServiceImpl;
    }

    public InfraestructuraTipoServiceImpl getInfraestructuraTipoServiceImpl() {
        return infraestructuraTipoServiceImpl;
    }


    public void setConcesionServiceImpl(ConcesionServiceImpl concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public ConcesionServiceImpl getConcesionServiceImpl() {
        return concesionServiceImpl;
    }

    public void setModalidadServiceImp(ModalidadConcesionServiceImpl modalidadServiceImp) {
        this.modalidadServiceImp = modalidadServiceImp;
    }

    public ModalidadConcesionServiceImpl getModalidadServiceImp() {
        return modalidadServiceImp;
    }

    public void setContratoConcesionServiceImp(ContratoConcesionServiceImpl contratoConcesionServiceImp) {
        this.contratoConcesionServiceImp = contratoConcesionServiceImp;
    }

    public ContratoConcesionServiceImpl getContratoConcesionServiceImp() {
        return contratoConcesionServiceImp;
    }

    public void setListaInfraestructura(List<InfraestructuraTipoVO> listaInfraestructura) {
        this.listaInfraestructura = listaInfraestructura;
    }

    public List<InfraestructuraTipoVO> getListaInfraestructura() {
        return listaInfraestructura;
    }

    public void setListaConcesiones(List<ConcesionVO> listaConcesiones) {
        this.listaConcesiones = listaConcesiones;
    }

    public List<ConcesionVO> getListaConcesiones() {
        return listaConcesiones;
    }

    public void setListaModalidad(List<ModalidadConcesionVO> listaModalidad) {
        this.listaModalidad = listaModalidad;
    }

    public List<ModalidadConcesionVO> getListaModalidad() {
        return listaModalidad;
    }

    public void setListaContrato(List<ContratoVO> listaContrato) {
        this.listaContrato = listaContrato;
    }

    public List<ContratoVO> getListaContrato() {
        return listaContrato;
    }


    public void setConcesionarioServiceImpl(ConcesionarioService concesionarioServiceImpl) {
        this.concesionarioServiceImpl = concesionarioServiceImpl;
    }

    public ConcesionarioService getConcesionarioServiceImpl() {
        return concesionarioServiceImpl;
    }
    
    // Parametros de busqueda
    int tipoinfra,modalidad,concesion ;
    Date fechaInicio,fechaFin;


    public void setTipoinfra(int tipoinfra) {
        this.tipoinfra = tipoinfra;
    }

    public int getTipoinfra() {
        return tipoinfra;
    }


    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }

    public int getModalidad() {
        return modalidad;
    }


    public void setConcesion(int concesion) {
        this.concesion = concesion;
    }

    public int getConcesion() {
        return concesion;
    }


    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFin() {
        return fechaFin;
    }


    // Metodo Para Listar Tipo de Infraestructuras

    public void ListarInfraestructura() throws SQLException {
        try {
            listaInfraestructura = getInfraestructuraTipoServiceImpl().query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    // Metodo para Filtrar la Lista de Concesión
    public void filtrarConcesion() throws SQLException {
        try {
            listaConcesiones = concesionServiceImpl.filtrarConcesion(tipoinfra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Metodo para Listar Modalidad de Concesión
    public void ListarModalidad() throws SQLException {
        try {
            listaModalidad = this.modalidadServiceImp.query();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
    
    // Metodo para Buscar Contrato de Concesion
    
    public void BuscarContratos() throws SQLException {
       
        try {
            listaContrato = this.contratoConcesionServiceImp.buscarContratos(tipoinfra,concesion,modalidad,fechaInicio,fechaFin);
            for (int i=0; i< listaContrato.size(); i++){                
                listaContrato.get(i).setNombreConcesion(concesionServiceImpl.get(listaContrato.get(i).getCsiId()).getCsiNombre());
                //listaContrato.get(i).setNombreConcesionario(concesionarioServiceImpl.get(listaContrato.get(i).getCncId()).getCncNombre());
                listaContrato.get(i).setNombreModalidad(modalidadServiceImp.get(listaContrato.get(i).getMcoId()).getMcoNombre());
                listaContrato.get(i).setNombreTipoInfraestructura(infraestructuraTipoServiceImpl.get(listaContrato.get(i).getTinId()).getTinNombre());
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
            System.out.println(listaContrato.size());
    }
}
