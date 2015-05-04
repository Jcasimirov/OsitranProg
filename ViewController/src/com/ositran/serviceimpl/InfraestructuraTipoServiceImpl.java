package com.ositran.serviceimpl;


import com.ositran.dao.InfraestructuraTipoDAO;
import com.ositran.daoimpl.InfraestructuraTipoDAOImpl;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.service.InfraestructuraTipoService;

import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfraestructuraTipoServiceImpl implements InfraestructuraTipoService{
    
    InfraestructuraTipoDAO infraestructuraTipoDAOImpl;
    InfraestructuraTipo infraestructuraTipo;
    InfraestructuraTipoVO infraestructuraTipoVO;
    InfraestructuraTipoDAOImpl infraestructuraTipoDAOImpl1=new InfraestructuraTipoDAOImpl();
    
    public List<InfraestructuraTipoVO> query1() throws SQLException{
        List<InfraestructuraTipo> list=infraestructuraTipoDAOImpl1.query();
        List<InfraestructuraTipoVO> listVO=toListInfraestructuraTiposVO(list);
        return listVO;
    }  

    @Override
    public List<InfraestructuraTipoVO> query() throws SQLException{
        List<InfraestructuraTipo> list=infraestructuraTipoDAOImpl.query();
        List<InfraestructuraTipoVO> listVO=toListInfraestructuraTiposVO(list);
        return listVO;
    }

    @Override
    public String insert(InfraestructuraTipoVO infraestructuraTipoVO) throws SQLException{
        InfraestructuraTipo infraestructuraTipo=toInfraestructuraTipo(infraestructuraTipoVO);
        String result=infraestructuraTipoDAOImpl.insert(infraestructuraTipo);
        return result;
    }

   

    @Override
    public String update(InfraestructuraTipoVO infraestructuraTipoVO) throws SQLException {
        InfraestructuraTipo infraestructuraTipo=toInfraestructuraTipo(infraestructuraTipoVO);
        String result=this.infraestructuraTipoDAOImpl.update(infraestructuraTipo);
        return result;
    }

    @Override
    public InfraestructuraTipoVO get(Integer id) throws SQLException {
        InfraestructuraTipo infraestructuraTipo=this.infraestructuraTipoDAOImpl.get(id);
        InfraestructuraTipoVO infraestructuraTipoVO=toInfraestructuraTipoVO(infraestructuraTipo);
        return infraestructuraTipoVO;
    }
    
    @Override
    public List<InfraestructuraTipoVO> AllSearch(String a) throws SQLException{
        List<InfraestructuraTipo> list=infraestructuraTipoDAOImpl.AllSearch(a);
        List<InfraestructuraTipoVO> listVO=toListInfraestructuraTiposVO(list);
        return listVO;
    }
    
    //conversiones
    private List<InfraestructuraTipoVO> toListInfraestructuraTiposVO(List<InfraestructuraTipo> list){
        List<InfraestructuraTipoVO> listVO=new ArrayList<InfraestructuraTipoVO>();
        for(int i=0;i<list.size();i++){
            InfraestructuraTipo infraestructuraTipo=(InfraestructuraTipo)list.get(i);
            InfraestructuraTipoVO infraestructuraTipoVO=toInfraestructuraTipoVO(infraestructuraTipo);
            listVO.add(infraestructuraTipoVO);
        }
        return listVO;
    }
    private InfraestructuraTipoVO toInfraestructuraTipoVO(InfraestructuraTipo infraestructuraTipo){
        InfraestructuraTipoVO infraestructuraTipoVO=new InfraestructuraTipoVO();
        infraestructuraTipoVO.setTinId(infraestructuraTipo.getTinId());
        infraestructuraTipoVO.setTinDescripcion(infraestructuraTipo.getTinDescripcion());
        infraestructuraTipoVO.setTinEstado(infraestructuraTipo.getTinEstado());
        infraestructuraTipoVO.setTinFechaAlta(infraestructuraTipo.getTinFechaAlta());
        infraestructuraTipoVO.setTinFechaBaja(infraestructuraTipo.getTinFechaBaja());
        infraestructuraTipoVO.setTinFechaCambio(infraestructuraTipo.getTinFechaCambio());
        infraestructuraTipoVO.setTinNombre(infraestructuraTipo.getTinNombre());
        infraestructuraTipoVO.setTinTerminal(infraestructuraTipo.getTinTerminal());
        infraestructuraTipoVO.setTinUsuarioAlta(infraestructuraTipo.getTinUsuarioAlta());
        infraestructuraTipoVO.setTinUsuarioBaja(infraestructuraTipo.getTinUsuarioBaja());
        infraestructuraTipoVO.setTinUsuarioCambio(infraestructuraTipo.getTinUsuarioCambio());
        
            
            
            
       
        return infraestructuraTipoVO;
    }
    private InfraestructuraTipo toInfraestructuraTipo(InfraestructuraTipoVO infraestructuraTipoVO){
        InfraestructuraTipo infraestructuraTipo=new InfraestructuraTipo();
        infraestructuraTipo.setTinId(infraestructuraTipoVO.getTinId());
        infraestructuraTipo.setTinDescripcion(infraestructuraTipoVO.getTinDescripcion());
        infraestructuraTipo.setTinEstado(infraestructuraTipoVO.getTinEstado());
        infraestructuraTipo.setTinFechaAlta(infraestructuraTipoVO.getTinFechaAlta());
        infraestructuraTipo.setTinFechaBaja(infraestructuraTipoVO.getTinFechaBaja());
        infraestructuraTipo.setTinFechaCambio(infraestructuraTipoVO.getTinFechaCambio());
        infraestructuraTipo.setTinNombre(infraestructuraTipoVO.getTinNombre());
        infraestructuraTipo.setTinTerminal(infraestructuraTipoVO.getTinTerminal());
        infraestructuraTipo.setTinUsuarioAlta(infraestructuraTipoVO.getTinUsuarioAlta());
        infraestructuraTipo.setTinUsuarioBaja(infraestructuraTipoVO.getTinUsuarioBaja());
        infraestructuraTipo.setTinUsuarioCambio(infraestructuraTipoVO.getTinUsuarioCambio());
        
        return infraestructuraTipo;
        
    }


    public void setInfraestructuraTipoDAOImpl(InfraestructuraTipoDAO infraestructuraTipoDAOImpl) {
        this.infraestructuraTipoDAOImpl = infraestructuraTipoDAOImpl;
    }

    public InfraestructuraTipoDAO getInfraestructuraTipoDAOImpl() {
        return infraestructuraTipoDAOImpl;
    }

    public void setInfraestructuraTipo(InfraestructuraTipo infraestructuraTipo) {
        this.infraestructuraTipo = infraestructuraTipo;
    }

    public InfraestructuraTipo getInfraestructuraTipo() {
        return infraestructuraTipo;
    }

    public void setInfraestructuraTipoVO(InfraestructuraTipoVO infraestructuraTipoVO) {
        this.infraestructuraTipoVO = infraestructuraTipoVO;
    }

    public InfraestructuraTipoVO getInfraestructuraTipoVO() {
        return infraestructuraTipoVO;
    }


    @Override
    public String delete(Integer id) throws SQLException {
        String result=this.infraestructuraTipoDAOImpl.delete(id);
        return result;
    }
    
    
    @Override
    public String getNombre(int codigo) throws SQLException {
        String nombre=this.infraestructuraTipoDAOImpl.getNombre(codigo);
        return nombre;
    }
    
    
}
