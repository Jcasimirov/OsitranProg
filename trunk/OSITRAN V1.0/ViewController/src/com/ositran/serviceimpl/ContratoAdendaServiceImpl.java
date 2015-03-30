package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoAdendaDAOImpl;
import com.ositran.model.ContratoAdenda;
import com.ositran.service.ContratoAdendaService;

import com.ositran.vo.bean.ContratoAdendaVO;



import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContratoAdendaServiceImpl implements ContratoAdendaService {
    
    private ContratoAdendaDAOImpl contratoAdendaDAOImpl;
    
    public ContratoAdendaServiceImpl() {
        super();
    }

    @Override
    public List<ContratoAdendaVO> query() throws SQLException {
        List<ContratoAdenda> list = contratoAdendaDAOImpl.query();
        List<ContratoAdendaVO> listVO=toListContratoAdendaVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoAdendaVO contratoAdendaVO) throws SQLException {
        ContratoAdenda contratoAdenda=toContratoAdenda(contratoAdendaVO);
        String result = contratoAdendaDAOImpl.insert(contratoAdenda);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = contratoAdendaDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoAdendaVO contratoAdendaVO) throws SQLException {
        ContratoAdenda contratoAdenda=toContratoAdenda(contratoAdendaVO);
        String result = contratoAdendaDAOImpl.update(contratoAdenda);
        return result;
    }

    @Override
    public ContratoAdendaVO get(Integer id) throws SQLException {
        ContratoAdenda contratoAdenda= contratoAdendaDAOImpl.get(id);
        ContratoAdendaVO contratoAdendaVO=toContratoAdendaVO(contratoAdenda);
        return contratoAdendaVO;
    }
    
    // conversiones
    private List<ContratoAdendaVO> toListContratoAdendaVO(List<ContratoAdenda> list){
        List<ContratoAdendaVO> listVO=new ArrayList<ContratoAdendaVO>();
        for(int i=0;i<list.size();i++){
            ContratoAdenda contratoAdenda=(ContratoAdenda)list.get(i);
            ContratoAdendaVO contratoAdendaVO=toContratoAdendaVO(contratoAdenda);
            listVO.add(contratoAdendaVO);
        }
        return listVO;
    }
    
    private ContratoAdendaVO toContratoAdendaVO(ContratoAdenda contratoAdenda){
        ContratoAdendaVO contratoAdendaVO=new ContratoAdendaVO();
        
        contratoAdendaVO.setTadId(contratoAdenda.getTadId());
        contratoAdendaVO.setMonId(contratoAdenda.getMonId());
        contratoAdendaVO.setConId(contratoAdenda.getConId());
        contratoAdendaVO.setCadMonto(contratoAdenda.getCadMonto());
        contratoAdendaVO.setCadId(contratoAdenda.getCadId());
        contratoAdendaVO.setCadFecha(contratoAdenda.getCadFecha());
        contratoAdendaVO.setCadDescripcion(contratoAdenda.getCadDescripcion());
        contratoAdendaVO.setCadDocumentoFisico(contratoAdenda.getCadDocumentoFisico());
        contratoAdendaVO.setCadEstado(contratoAdenda.getCadEstado());
        contratoAdendaVO.setCadNombre(contratoAdenda.getCadNombre());
    
        return contratoAdendaVO;
    }
    
    private ContratoAdenda toContratoAdenda(ContratoAdendaVO contratoAdendaVO){
        ContratoAdenda contratoAdenda=new ContratoAdenda();        
        
        contratoAdenda.setTadId(contratoAdendaVO.getTadId());
        contratoAdenda.setMonId(contratoAdendaVO.getMonId());
        contratoAdenda.setConId(contratoAdendaVO.getConId());
        contratoAdenda.setCadMonto(contratoAdendaVO.getCadMonto());
        contratoAdenda.setCadId(contratoAdendaVO.getCadId());
        contratoAdenda.setCadFecha(contratoAdendaVO.getCadFecha());
        contratoAdenda.setCadDescripcion(contratoAdendaVO.getCadDescripcion());
        contratoAdenda.setCadDocumentoFisico(contratoAdendaVO.getCadDocumentoFisico());
        contratoAdenda.setCadEstado(contratoAdenda.getCadEstado());
        contratoAdenda.setCadNombre(contratoAdenda.getCadNombre());
        return contratoAdenda;
        
    }

    public ContratoAdendaDAOImpl getContratoAdendaDAOImpl() {
        return contratoAdendaDAOImpl;
    }

    public void setContratoAdendaDAOImpl(ContratoAdendaDAOImpl contratoAdendaDAOImpl) {
        this.contratoAdendaDAOImpl = contratoAdendaDAOImpl;
    }
    
    @Override    
    public List<ContratoAdendaVO> getAdendasContrato(Integer ConId) throws SQLException{
        List<ContratoAdenda> list = contratoAdendaDAOImpl.getAdendasContrato(ConId);
        List<ContratoAdendaVO> listVO=toListContratoAdendaVO(list);
        return listVO;
    }
}
