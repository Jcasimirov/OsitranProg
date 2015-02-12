package com.ositran.serviceimpl;

import com.ositran.daoimpl.ConcesionDAOImpl;
import com.ositran.daoimpl.IgvDAOImpl;
import com.ositran.model.Concesion;
import com.ositran.model.Igv;
import com.ositran.service.ConcesionService;
import com.ositran.vo.bean.ConcesionVO;

import com.ositran.vo.bean.IgvVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcesionServiceImpl implements ConcesionService{
    public ConcesionServiceImpl() {
        super();
    }
    
    private ConcesionDAOImpl concesionDAOImpl;

    public void setConcesionDAOImpl(ConcesionDAOImpl concesionDAOImpl) {
        this.concesionDAOImpl = concesionDAOImpl;
    }

    public ConcesionDAOImpl getConcesionDAOImpl() {
        return concesionDAOImpl;
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
        concesionVO.setConId(concesion.getConId());
        concesionVO.setConNombre(concesion.getConNombre());
        concesionVO.setConNominfra(concesion.getConNominfra());
        concesionVO.setConTipoinfra(concesion.getConTipoinfra());
        return concesionVO;
    }
    private Concesion toConcesion(ConcesionVO concesionVO){
        Concesion concesion =new Concesion();
        concesion.setConId(concesionVO.getConId());
        concesion.setConNombre(concesionVO.getConNombre());
        concesion.setConNominfra(concesionVO.getConNominfra());
        concesion.setConTipoinfra(concesionVO.getConTipoinfra());
         return concesion;
        
    }
    
    
}
