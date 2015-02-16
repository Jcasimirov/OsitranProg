package com.ositran.serviceimpl;

import com.ositran.daoimpl.ConcesionDAOImpl;

import com.ositran.model.Concesion;
import com.ositran.service.ConcesionService;
import com.ositran.vo.bean.ConcesionVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

public class ConcesionServiceImpl implements ConcesionService{
    private ConcesionDAOImpl concesionDAOImpl;

    public void setConcesionDAOImpl(ConcesionDAOImpl concesionDAOImpl) {
        this.concesionDAOImpl = concesionDAOImpl;
    }

    public ConcesionDAOImpl getConcesionDAOImpl() {
        return concesionDAOImpl;
    }


    public ConcesionServiceImpl() {
        super();
    }

    @Override
    public List<ConcesionVO> query() {
        List<Concesion> list=concesionDAOImpl.query();
        List<ConcesionVO> listVO=toListConcesionVO(list);
        return listVO;
    }

    @Override
    public String insert(ConcesionVO concesionVO) {
        Concesion concesion=toConcesion(concesionVO);
        String result=concesionDAOImpl.insert(concesion);
        return result;
    }

    @Override
    public String delete(Integer id) {
        String result=this.concesionDAOImpl.delete(id);
        return result;
    }
    
     
    /*   public Integer cambiarEstado(Integer estado) {
        Integer result=this.concesionDAOImpl.update(estado);
        return result;
    }  */

    @Override
    public String update(ConcesionVO concesionVO) {
        Concesion concesion=toConcesion(concesionVO);
        String result=this.concesionDAOImpl.update(concesion);
        return result;
    }

    @Override
    public ConcesionVO get(Integer id) {
        Concesion concesion=this.concesionDAOImpl.get(id);
        ConcesionVO concesionVO=toConcesionVO(concesion);
        return concesionVO;
    }
    
    
    
    //conversiones
    private List<ConcesionVO> toListConcesionVO(List<Concesion> list){
        List<ConcesionVO> listVO=new ArrayList<ConcesionVO>();
        for(int i=0;i<list.size();i++){
            Concesion concesion=(Concesion)list.get(i);
            ConcesionVO concesionVO=toConcesionVO(concesion);
            listVO.add(concesionVO);
        }
        return listVO;
    }
    private ConcesionVO toConcesionVO(Concesion concesion){
        ConcesionVO concesionVO=new ConcesionVO();
       
         concesionVO.setTcoFechaAlta(concesion.getTcoFechaAlta());
        concesionVO.setTcoFechaBaja(concesion.getTcoFechaBaja());
        concesionVO.setTcoFechaCambio(concesion.getTcoFechaCambio());
        concesionVO.setTcoTerminal(concesion.getTcoTerminal());
        concesionVO.setTcoUsuarioAlta(concesion.getTcoUsuarioAlta());
        concesionVO.setTcoUsuarioBaja(concesion.getTcoUsuarioBaja());
        concesionVO.setTcoUsuarioCambio(concesion.getTcoUsuarioCambio());   
        concesionVO.setTcoId(concesion.getTcoId());
        concesionVO.setTinId(concesion.getTinId());
        concesionVO.setTcoNombre(concesion.getTcoNombre());
       
        return concesionVO;
    }
    private Concesion toConcesion(ConcesionVO concesionVO){
        Concesion concesion=new Concesion();
     
          concesion.setTcoFechaAlta(concesionVO.getTcoFechaAlta());
        concesion.setTcoFechaBaja(concesionVO.getTcoFechaBaja());
        concesion.setTcoFechaCambio(concesionVO.getTcoFechaCambio());
        concesion.setTcoTerminal(concesionVO.getTcoTerminal());
        concesion.setTcoUsuarioAlta(concesionVO.getTcoUsuarioAlta());
        concesion.setTcoUsuarioBaja(concesionVO.getTcoUsuarioBaja());
        concesion.setTcoUsuarioCambio(concesionVO.getTcoUsuarioCambio());
        concesion.setTcoId(concesionVO.getTcoId());
        concesion.setTinId(concesionVO.getTinId());   
        concesion.setTcoNombre(concesionVO.getTcoNombre());
       
        return concesion; 
        
    }







   
}
