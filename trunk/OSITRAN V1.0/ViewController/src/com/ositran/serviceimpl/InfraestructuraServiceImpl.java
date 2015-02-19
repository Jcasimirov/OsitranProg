package com.ositran.serviceimpl;

import com.ositran.dao.InfraestructuraDAO;
import com.ositran.dao.TipoInversionDAO;
import com.ositran.model.Infraestructura;
import com.ositran.model.InversionTipo;
import com.ositran.service.InfraestructuraService;
import com.ositran.vo.bean.InfraestructuraVO;

import com.ositran.vo.bean.TipoInversionVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InfraestructuraServiceImpl implements InfraestructuraService{


    private InfraestructuraDAO infraestructuraDAOImpl;




    @Override
    public List<InfraestructuraVO> query() {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(InfraestructuraVO infraestructuraVO) {  
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
    public String update(InfraestructuraVO infraestructuraVO) {
        // TODO Implement this method
        return null;
    }

    @Override
    public InfraestructuraVO get(Integer id) {
        // TODO Implement this method
        return null;
    }
    
    

    
    //conversiones
    private List<InfraestructuraVO> toListInfraestructuraVO(List<Infraestructura> list){
       List<InfraestructuraVO> listVO=new ArrayList<InfraestructuraVO>();
       for(int i=0;i<list.size();i++){
           Infraestructura infraestructura=(Infraestructura)list.get(i);
           InfraestructuraVO infraestructuraVO=toInfraestructuraVO(infraestructura);
           listVO.add(infraestructuraVO);
       }
       return listVO;
    }
    private InfraestructuraVO toInfraestructuraVO(Infraestructura infraestructura){
       InfraestructuraVO infraestructuraVO=new InfraestructuraVO();
        infraestructuraVO.setCsiId(infraestructura.getCsiId());
        infraestructuraVO.setInfFechaAlta(infraestructura.getInfFechaAlta());
        infraestructuraVO.setInfFechaBaja(infraestructura.getInfFechaBaja());
        infraestructuraVO.setInfFechaCambio(infraestructura.getInfFechaCambio());
        infraestructuraVO.setInfId(infraestructura.getInfId());
        infraestructuraVO.setInfNombre(infraestructura.getInfNombre());
        infraestructuraVO.setInfTerminal(infraestructura.getInfTerminal());
        infraestructuraVO.setInfUsuarioAlta(infraestructura.getInfUsuarioAlta());
        infraestructuraVO.setInfUsuarioBaja(infraestructura.getInfUsuarioBaja());
        infraestructuraVO.setInfUsuarioCambio(infraestructura.getInfUsuarioCambio());
       return infraestructuraVO;
    }
    private Infraestructura toInfraestructura(InfraestructuraVO infraestructuraVO){
       Infraestructura infraestructura=new Infraestructura();
        infraestructura.setCsiId(infraestructuraVO.getCsiId());
        infraestructura.setInfFechaAlta(infraestructuraVO.getInfFechaAlta());
        infraestructura.setInfFechaBaja(infraestructuraVO.getInfFechaBaja());
        infraestructura.setInfFechaCambio(infraestructuraVO.getInfFechaCambio());
        infraestructura.setInfId(infraestructuraVO.getInfId());
        infraestructura.setInfNombre(infraestructuraVO.getInfNombre());
        infraestructura.setInfTerminal(infraestructuraVO.getInfTerminal());
        infraestructura.setInfUsuarioAlta(infraestructuraVO.getInfUsuarioAlta());
        infraestructura.setInfUsuarioBaja(infraestructuraVO.getInfUsuarioBaja());
        infraestructura.setInfUsuarioCambio(infraestructuraVO.getInfUsuarioCambio());
       
       return infraestructura;
       
    }
    public void setInfraestructuraDAOImpl(InfraestructuraDAO infraestructuraDAOImpl) {
        this.infraestructuraDAOImpl = infraestructuraDAOImpl;
    }

    public InfraestructuraDAO getInfraestructuraDAOImpl() {
        return infraestructuraDAOImpl;
    }
    
    
}


