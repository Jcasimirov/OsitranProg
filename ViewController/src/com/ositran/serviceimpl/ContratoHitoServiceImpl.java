package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoHitoDAOImpl;
import com.ositran.model.ContratoHito;
import com.ositran.service.ContratoHitoService;
import com.ositran.vo.bean.ContratoHitoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContratoHitoServiceImpl implements ContratoHitoService {
    private ContratoHitoDAOImpl contratoHitoDAOImpl;
    
    public ContratoHitoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoHitoVO> query() throws SQLException {
        List<ContratoHito> list = contratoHitoDAOImpl.query();
        List<ContratoHitoVO> listVO=toListContratoHitoVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoHitoVO contratoHitoVO) throws SQLException {
        ContratoHito contratoHito=toContratoHito(contratoHitoVO);
        String result = contratoHitoDAOImpl.insert(contratoHito);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = contratoHitoDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoHitoVO contratoHitoVO) throws SQLException {
        ContratoHito contratoHito=toContratoHito(contratoHitoVO);
        String result = contratoHitoDAOImpl.update(contratoHito);
        return result;
    }

    @Override
    public ContratoHitoVO get(Integer id) throws SQLException {
        ContratoHito contratoHito= contratoHitoDAOImpl.get(id);
        ContratoHitoVO contratoHitoVO=toContratoHitoVO(contratoHito);
        return contratoHitoVO;
    }
    
    // conversiones
    private List<ContratoHitoVO> toListContratoHitoVO(List<ContratoHito> list){
        List<ContratoHitoVO> listVO=new ArrayList<ContratoHitoVO>();
        for(int i=0;i<list.size();i++){
            ContratoHito contratoHito=(ContratoHito)list.get(i);
            ContratoHitoVO contratoHitoVO=toContratoHitoVO(contratoHito);
            listVO.add(contratoHitoVO);
        }
        return listVO;
    }
    
    private ContratoHitoVO toContratoHitoVO(ContratoHito contratoHito){
        ContratoHitoVO contratoHitoVO=new ContratoHitoVO();
        
        contratoHitoVO.setConId(contratoHito.getConId());
        contratoHitoVO.setHtoEstado(contratoHito.getHtoEstado());
        contratoHitoVO.setHtoFecha(contratoHito.getHtoFecha());
        contratoHitoVO.setHtoId(contratoHito.getHtoId());
        contratoHitoVO.setHtoMonto(contratoHito.getHtoMonto());
        contratoHitoVO.setHtoOficio(contratoHito.getHtoOficio());
        contratoHitoVO.setHtoPdf(contratoHito.getHtoPdf());
        contratoHitoVO.setMonId(contratoHito.getMonId());
                    
    
        return contratoHitoVO;
    }
    
    private ContratoHito toContratoHito(ContratoHitoVO contratoHitoVO){
        ContratoHito contratoHito=new ContratoHito();           
        
        contratoHito.setConId(contratoHitoVO.getConId());
        contratoHito.setHtoEstado(contratoHitoVO.getHtoEstado());
        contratoHito.setHtoFecha(contratoHitoVO.getHtoFecha());
        contratoHito.setHtoId(contratoHitoVO.getHtoId());
        contratoHito.setHtoMonto(contratoHitoVO.getHtoMonto());
        contratoHito.setHtoOficio(contratoHitoVO.getHtoOficio());
        contratoHito.setHtoPdf(contratoHitoVO.getHtoPdf());
        contratoHito.setMonId(contratoHitoVO.getMonId());
        
        return contratoHito;
        
    }

    public ContratoHitoDAOImpl getContratoHitoDAOImpl() {
        return contratoHitoDAOImpl;
    }

    public void setContratoHitoDAOImpl(ContratoHitoDAOImpl contratoHitoDAOImpl) {
        this.contratoHitoDAOImpl = contratoHitoDAOImpl;
    }
    
    @Override    
    public List<ContratoHitoVO> getHitosContrato(Integer ConId) throws SQLException{
        List<ContratoHito> list = contratoHitoDAOImpl.getHitosContrato(ConId);
        List<ContratoHitoVO> listVO=toListContratoHitoVO(list);
        return listVO;
    }
}
