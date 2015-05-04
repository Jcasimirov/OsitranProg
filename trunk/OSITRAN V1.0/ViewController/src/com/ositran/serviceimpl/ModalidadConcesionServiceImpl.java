package com.ositran.serviceimpl;


import com.ositran.daoimpl.ModalidadConcesionDAOImpl;
import com.ositran.model.ModalidadConcesion;
import com.ositran.service.ModalidadConcesionService;
import com.ositran.vo.bean.ModalidadConcesionVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ModalidadConcesionServiceImpl implements ModalidadConcesionService{
    public ModalidadConcesionServiceImpl() {
        super();
    }
    
    private ModalidadConcesionDAOImpl modalidadConcesionDAOImpl;
    private ModalidadConcesionDAOImpl modalidadConcesionDAOImpl1=new ModalidadConcesionDAOImpl();


    public void setModalidadConcesionDAOImpl(ModalidadConcesionDAOImpl modalidadConcesionDAOImpl) {
        this.modalidadConcesionDAOImpl = modalidadConcesionDAOImpl;
    }

    public ModalidadConcesionDAOImpl getModalidadConcesionDAOImpl() {
        return modalidadConcesionDAOImpl;
    }
    
    public List<ModalidadConcesionVO> query1() throws SQLException{
        List<ModalidadConcesion> list=modalidadConcesionDAOImpl1.query();
        List<ModalidadConcesionVO> listVO=toListModalidadConcesionVO(list);
        return listVO;        
    }
    

    @Override
    public List<ModalidadConcesionVO> query() throws SQLException{
        List<ModalidadConcesion> list=modalidadConcesionDAOImpl.query();
        List<ModalidadConcesionVO> listVO=toListModalidadConcesionVO(list);
        return listVO;
        
    }
    
    @Override
    public String insert(ModalidadConcesionVO modalidadConcesionVO) throws SQLException{
        ModalidadConcesion modalidadConcesion=toModalidadConcesion(modalidadConcesionVO);
        String result=modalidadConcesionDAOImpl.insert(modalidadConcesion);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result=this.modalidadConcesionDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ModalidadConcesionVO modalidadConcesionVO) throws SQLException{
        ModalidadConcesion modalidadConcesion=toModalidadConcesion(modalidadConcesionVO);
        String result=this.modalidadConcesionDAOImpl.update(modalidadConcesion);
        return result;
    }

    @Override
    public ModalidadConcesionVO get(Integer id) throws SQLException{
        ModalidadConcesion modalidadConcesion=this.modalidadConcesionDAOImpl.get(id);
        ModalidadConcesionVO modalidadConcesionVO=toModalidadConcesionVO(modalidadConcesion);
        return modalidadConcesionVO;
    }
    
    //conversiones
    private List<ModalidadConcesionVO> toListModalidadConcesionVO(List<ModalidadConcesion> list) throws SQLException{
        List<ModalidadConcesionVO> listVO=new ArrayList<ModalidadConcesionVO>();
        for(int i=0;i<list.size();i++){           
            ModalidadConcesion modalidadConcesion=(ModalidadConcesion)list.get(i);            
            ModalidadConcesionVO modalidadConcesionVO=toModalidadConcesionVO(modalidadConcesion);
            listVO.add(modalidadConcesionVO);
        }
        return listVO;
    }
    private ModalidadConcesionVO toModalidadConcesionVO(ModalidadConcesion modalidadConcesion) throws SQLException{
        ModalidadConcesionVO modalidadConcesionVO=new ModalidadConcesionVO();
        modalidadConcesionVO.setMcoDescripcion(modalidadConcesion.getMcoDescripcion());
        modalidadConcesionVO.setMcoEstado(modalidadConcesion.getMcoEstado());
        modalidadConcesionVO.setMcoFechaAlta(modalidadConcesion.getMcoFechaAlta());
        modalidadConcesionVO.setMcoFechaBaja(modalidadConcesion.getMcoFechaBaja());
        modalidadConcesionVO.setMcoFechaCambio(modalidadConcesion.getMcoFechaCambio());
        modalidadConcesionVO.setMcoId(modalidadConcesion.getMcoId());
        modalidadConcesionVO.setMcoNombre(modalidadConcesion.getMcoNombre());
        modalidadConcesionVO.setMcoTerminal(modalidadConcesion.getMcoTerminal());
        modalidadConcesionVO.setMcoUsuarioAlta(modalidadConcesion.getMcoUsuarioAlta());
        modalidadConcesionVO.setMcoUsuarioBaja(modalidadConcesion.getMcoUsuarioBaja());
        modalidadConcesionVO.setMcoUsuarioCambio(modalidadConcesion.getMcoUsuarioCambio());

        return modalidadConcesionVO;
    }
    private ModalidadConcesion toModalidadConcesion(ModalidadConcesionVO modalidadConcesionVO) throws SQLException{
        ModalidadConcesion modalidadConcesion=new ModalidadConcesion();
        modalidadConcesion.setMcoDescripcion(modalidadConcesionVO.getMcoDescripcion());
        modalidadConcesion.setMcoEstado(modalidadConcesionVO.getMcoEstado());
        modalidadConcesion.setMcoFechaAlta(modalidadConcesionVO.getMcoFechaAlta());
        modalidadConcesion.setMcoFechaBaja(modalidadConcesionVO.getMcoFechaBaja());
        modalidadConcesion.setMcoFechaCambio(modalidadConcesionVO.getMcoFechaCambio());
        modalidadConcesion.setMcoId(modalidadConcesionVO.getMcoId());
        modalidadConcesion.setMcoNombre(modalidadConcesionVO.getMcoNombre());
        modalidadConcesion.setMcoTerminal(modalidadConcesionVO.getMcoTerminal());
        modalidadConcesion.setMcoUsuarioAlta(modalidadConcesionVO.getMcoUsuarioAlta());
        modalidadConcesion.setMcoUsuarioBaja(modalidadConcesionVO.getMcoUsuarioBaja());
        modalidadConcesion.setMcoUsuarioCambio(modalidadConcesionVO.getMcoUsuarioCambio());
        
        return modalidadConcesion;
        
    }
    
    // Filtros de busqueda
    
    @Override
    public List<ModalidadConcesionVO> FiltrarBusqueda(String atributo) throws SQLException{
        List<ModalidadConcesion> list=modalidadConcesionDAOImpl.FiltrarModalidad(atributo);
        List<ModalidadConcesionVO> listVO=toListModalidadConcesionVO(list);
        return listVO;
        
    }
    
    // Validaciones
    
    @Override
    public int ValidaNombre(String atributo) throws SQLException{
        int respuesta =modalidadConcesionDAOImpl.ValidarNombre(atributo);
        return respuesta;
        
    }
    
    @Override
    public int ValidaNombreMod(String atributo,String nombre) throws SQLException{
        int respuesta =modalidadConcesionDAOImpl.ValidarNombreMod(atributo,nombre);
        return respuesta;
        
    }

    
}
