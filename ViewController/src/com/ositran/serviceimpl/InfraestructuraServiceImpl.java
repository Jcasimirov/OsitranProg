package com.ositran.serviceimpl;

import com.ositran.dao.InfraestructuraDAO;
import com.ositran.model.Infraestructura;
import com.ositran.service.InfraestructuraService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.InfraestructuraVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class InfraestructuraServiceImpl implements InfraestructuraService{
    private InfraestructuraDAO infraestructuraDAOImpl;

    @Override
    public List<InfraestructuraVO> query1(int CodigoC) throws SQLException{
        List<Infraestructura> list=infraestructuraDAOImpl.query1(CodigoC);
        List<InfraestructuraVO> listVO=toListInfraestructuraVO(list);
        return listVO;
    }
    
    @Override
    public List<InfraestructuraVO> query2(int CodigoC) throws SQLException {
        
        List<Infraestructura> list=infraestructuraDAOImpl.query2(CodigoC);
        List<InfraestructuraVO> listVO=toListInfraestructuraVO(list);
        return listVO;
    }

    @Override
    public List<InfraestructuraVO> query() throws SQLException{
        List<Infraestructura> list=infraestructuraDAOImpl.query();
        List<InfraestructuraVO> listVO=toListInfraestructuraVO(list);
        return listVO;
    }

    @Override
    public String insert(InfraestructuraVO infraestructuraVO) throws SQLException{  
        Infraestructura infraestructura=toInfraestructura(infraestructuraVO);
        String result=infraestructuraDAOImpl.insert(infraestructura);
        return result;
    }

    @Override
    public String delete(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(InfraestructuraVO infraestructuraVO) throws SQLException{
        Infraestructura infraestructura=toInfraestructura(infraestructuraVO);
        String result=infraestructuraDAOImpl.update(infraestructura);
        return result;
    }

    
    public InfraestructuraVO get2(Integer id) throws SQLException{
        Infraestructura infraestructura=infraestructuraDAOImpl.get2(id);
        InfraestructuraVO infraestructuraVO=toInfraestructuraVO(infraestructura);
        return infraestructuraVO;
    }
    
    @Override
    public InfraestructuraVO get(int codifoInfraestructura, int codigoConcesion,
                                 int tipoInfraestructura) throws SQLException {
        Infraestructura infraestructura=infraestructuraDAOImpl.get(codifoInfraestructura,codigoConcesion,tipoInfraestructura);
        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(infraestructura.getCsiId());
        System.out.println(infraestructura.getInfEstado());
        InfraestructuraVO infraestructuraVO=toInfraestructuraVO(infraestructura);
        return infraestructuraVO;
    }

    
    //conversiones
    private List<InfraestructuraVO> toListInfraestructuraVO(List<Infraestructura> list)throws SQLException{
       List<InfraestructuraVO> listVO=new ArrayList<InfraestructuraVO>();
       for(int i=0;i<list.size();i++){
           Infraestructura infraestructura=(Infraestructura)list.get(i);
           InfraestructuraVO infraestructuraVO=toInfraestructuraVO(infraestructura);
           listVO.add(infraestructuraVO);
       }
       return listVO;
    }
    private InfraestructuraVO toInfraestructuraVO(Infraestructura infraestructura)throws SQLException{
       InfraestructuraVO infraestructuraVO1=new InfraestructuraVO();
        infraestructuraVO1.setInfFechaAlta(infraestructura.getInfFechaAlta());
        infraestructuraVO1.setInfFechaBaja(infraestructura.getInfFechaBaja());
        infraestructuraVO1.setInfId(infraestructura.getInfId());
        infraestructuraVO1.setInfNombre(infraestructura.getInfNombre());
        infraestructuraVO1.setInfTerminal(infraestructura.getInfTerminal());
        infraestructuraVO1.setInfUsuarioAlta(infraestructura.getInfUsuarioAlta());
        infraestructuraVO1.setInfUsuarioBaja(infraestructura.getInfUsuarioBaja());
        infraestructuraVO1.setInfUsuarioCambio(infraestructura.getInfUsuarioCambio());
        infraestructuraVO1.setInfEstado(infraestructura.getInfEstado());
        infraestructuraVO1.setCsiId(infraestructura.getCsiId());
        infraestructuraVO1.setTinId(infraestructura.getTinId());
       return infraestructuraVO1;
    }
    
    
    private Infraestructura toInfraestructura(InfraestructuraVO infraestructuraVO)throws SQLException{
       Infraestructura infraestructura=new Infraestructura();
        
        infraestructura.setInfFechaAlta(infraestructuraVO.getInfFechaAlta());
        infraestructura.setInfFechaBaja(infraestructuraVO.getInfFechaBaja());
        infraestructura.setInfNombre(infraestructuraVO.getInfNombre());
        infraestructura.setInfTerminal(Reutilizar.obtenerIpCliente());
        infraestructura.setInfUsuarioAlta(infraestructuraVO.getInfUsuarioAlta());
        infraestructura.setInfUsuarioBaja(infraestructuraVO.getInfUsuarioBaja());
        infraestructura.setInfUsuarioCambio(infraestructuraVO.getInfUsuarioCambio());
        infraestructura.setInfEstado(infraestructuraVO.getInfEstado());
        infraestructura.setCsiId(infraestructuraVO.getCsiId());
        infraestructura.setTinId(infraestructuraVO.getTinId());
        infraestructura.setInfId(infraestructuraVO.getInfId());
       
       return infraestructura;
       
    }
    public void setInfraestructuraDAOImpl(InfraestructuraDAO infraestructuraDAOImpl) throws SQLException{
        this.infraestructuraDAOImpl = infraestructuraDAOImpl;
    }

    public InfraestructuraDAO getInfraestructuraDAOImpl() throws SQLException{
        return infraestructuraDAOImpl;
    }
    
    public List<InfraestructuraVO> getInfraestructurasContrato(int codigoContrato) throws SQLException{
        List<Infraestructura> list =infraestructuraDAOImpl.getInfraestructurasContrato(codigoContrato);;        
        List<InfraestructuraVO> listVO=toListInfraestructuraVO(list);
        return listVO;
    }
    public List<InfraestructuraVO> getInfraestructurasInversion(int codigoConcesion) throws Exception{
        List<Infraestructura> list =infraestructuraDAOImpl.getInfraestructurasInversion(codigoConcesion);;        
        List<InfraestructuraVO> listVO=toListInfraestructuraVO(list);
        return listVO;
    }
    public boolean validarCodigoEnUso(Integer csiId) throws Exception{
        boolean concesion=infraestructuraDAOImpl.validarCodigoEnUso(csiId);
        return concesion;
    }

}


