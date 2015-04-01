package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoAlertaEstadoDAOImpl;
import com.ositran.model.ContratoAlertaEstado;
import com.ositran.service.ContratoAlertaEstadoService;
import com.ositran.vo.bean.ContratoAlertaEstadoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContratoAlertaEstadoServiceImpl implements ContratoAlertaEstadoService {
    private ContratoAlertaEstadoDAOImpl contratoAlertaEstadoDAOImpl;
    
    public ContratoAlertaEstadoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoAlertaEstadoVO> query() throws SQLException {
        List<ContratoAlertaEstado> list=contratoAlertaEstadoDAOImpl.query();
        List<ContratoAlertaEstadoVO> listVO=toListContratoAlertaEstadoVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoAlertaEstadoVO contratoAlertaEstadoVO) throws SQLException {
        ContratoAlertaEstado contratoAlertaEstado=toContratoAlertaEstado(contratoAlertaEstadoVO);
        String result=contratoAlertaEstadoDAOImpl.insert(contratoAlertaEstado);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=this.contratoAlertaEstadoDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoAlertaEstadoVO contratoAlertaEstadoVO) throws SQLException {
        ContratoAlertaEstado contratoAlertaEstado=toContratoAlertaEstado(contratoAlertaEstadoVO);
        String result=this.contratoAlertaEstadoDAOImpl.update(contratoAlertaEstado);
        return result;
    }

    @Override
    public ContratoAlertaEstadoVO get(Integer id) throws SQLException {
        ContratoAlertaEstado contratoAlertaEstado= contratoAlertaEstadoDAOImpl.get(id);
        ContratoAlertaEstadoVO contratoAlertaEstadoVO=toContratoAlertaEstadoVO(contratoAlertaEstado);
        return contratoAlertaEstadoVO;
    }

    public ContratoAlertaEstadoDAOImpl getContratoAlertaEstadoDAOImpl() {
        return contratoAlertaEstadoDAOImpl;
    }

    public void setContratoAlertaEstadoDAOImpl(ContratoAlertaEstadoDAOImpl contratoAlertaEstadoDAOImpl) {
        this.contratoAlertaEstadoDAOImpl = contratoAlertaEstadoDAOImpl;
    }
    
    // conversiones
    private List<ContratoAlertaEstadoVO> toListContratoAlertaEstadoVO(List<ContratoAlertaEstado> list){
        List<ContratoAlertaEstadoVO> listVO=new ArrayList<ContratoAlertaEstadoVO>();
        for(int i=0;i<list.size();i++){
            ContratoAlertaEstado contratoAlertaEstado=(ContratoAlertaEstado)list.get(i);
            ContratoAlertaEstadoVO contratoAlertaEstadoVO=toContratoAlertaEstadoVO(contratoAlertaEstado);
            listVO.add(contratoAlertaEstadoVO);
        }
        return listVO;
    }
    
    private ContratoAlertaEstadoVO toContratoAlertaEstadoVO(ContratoAlertaEstado contratoAlertaEstado){
        ContratoAlertaEstadoVO contratoAlertaEstadoVO=new ContratoAlertaEstadoVO();
        
        contratoAlertaEstadoVO.setCaeId(contratoAlertaEstado.getCaeId());
        contratoAlertaEstadoVO.setCaeNombre(contratoAlertaEstado.getCaeNombre());        
    
        return contratoAlertaEstadoVO;
    }
    
    private ContratoAlertaEstado toContratoAlertaEstado(ContratoAlertaEstadoVO contratoAlertaEstadoVO){
        ContratoAlertaEstado contratoAlertaEstado=new ContratoAlertaEstado();
        
        contratoAlertaEstado.setCaeId(contratoAlertaEstadoVO.getCaeId());
        contratoAlertaEstado.setCaeNombre(contratoAlertaEstadoVO.getCaeNombre());

        return contratoAlertaEstado;
        
    }
}
