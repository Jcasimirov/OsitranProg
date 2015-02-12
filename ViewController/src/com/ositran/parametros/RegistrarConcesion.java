package com.ositran.parametros;

import com.ositran.dao.ConcesionDAO;
import com.ositran.daoimpl.ConcesionDAOImpl;
import com.ositran.serviceimpl.ConcesionServiceImpl;
import com.ositran.serviceimpl.InfraestructuraTipoServiceImpl;

import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.util.List;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;

@ManagedBean(name = "backing_ositran_parametros_registrarConcesion")
@RequestScoped
@Generated(value = "1ositran/parametros/registrarConcesion.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class RegistrarConcesion {
    
    @ManagedProperty(value="#{concesionServiceImpl}")
    private ConcesionServiceImpl concesionServiceImpl;
    private InputTextarea inputTextareaInfraestructura;    
    public ConcesionVO concesionVO=new ConcesionVO();

    public void setInputTextareaInfraestructura(InputTextarea inputTextareaInfraestructura) {
        this.inputTextareaInfraestructura = inputTextareaInfraestructura;
    }

    public InputTextarea getInputTextareaInfraestructura() {
        return inputTextareaInfraestructura;
    }

    public void setConcesionServiceImpl(ConcesionServiceImpl concesionServiceImpl) {
        this.concesionServiceImpl = concesionServiceImpl;
    }

    public ConcesionServiceImpl getConcesionServiceImpl() {
        return concesionServiceImpl;
    }


    public void setConcesionVO(ConcesionVO concesionVO) {
        this.concesionVO = concesionVO;
    }

    public ConcesionVO getConcesionVO() {
        return concesionVO;
    }

    public void concesionguardar(){
          
        
        System.out.println("Nombre concesion = "+concesionVO.getConNombre());
        this.concesionServiceImpl.insert(concesionVO);
    }
    
    public void infraestructuraInsertar(ActionEvent actionEvent) {
        this.concesionServiceImpl.insert(concesionVO);
        limpiar();       
    }

    public void limpiar(){
      
        }

}
