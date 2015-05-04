package com.ositran.serviceimpl;

import com.ositran.dao.ContratoEmpresaSupervisoraAdendaDAO;
import com.ositran.dao.InfraestructuraTipoDAO;
import com.ositran.model.ContratoSupervisoraAdenda;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.ValorizacionSup;
import com.ositran.service.ContratoEmpresaSupervisoraAdendaService;
import com.ositran.vo.bean.ContratoSupervisoraAdendaVO;

import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.ValorizacionSupVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContratoEmpresaSupervisoraAdendaServiceImpl implements ContratoEmpresaSupervisoraAdendaService {
    
    ContratoEmpresaSupervisoraAdendaDAO contratoEmpresaSupervisoraAdendaDAOImpl;
    ContratoSupervisoraAdenda contratoSupervisoraAdenda;
    ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO;
    
    public ContratoEmpresaSupervisoraAdendaServiceImpl() {
        super();
    }

    @Override
    public List<ContratoSupervisoraAdendaVO> query() throws SQLException {
        List<ContratoSupervisoraAdenda> list=contratoEmpresaSupervisoraAdendaDAOImpl.query();
        List<ContratoSupervisoraAdendaVO> listVO=toListContratoSupervisoraAdendaVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO) throws SQLException {
        ContratoSupervisoraAdenda contratoSupervisoraAdenda=toContratoSupervisoraAdenda(contratoSupervisoraAdendaVO);
        String result=contratoEmpresaSupervisoraAdendaDAOImpl.insert(contratoSupervisoraAdenda);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=this.contratoEmpresaSupervisoraAdendaDAOImpl.delete(id);
        return result;
    }
    
    //conversiones
    private List<ContratoSupervisoraAdendaVO> toListContratoSupervisoraAdendaVO(List<ContratoSupervisoraAdenda> list){
        List<ContratoSupervisoraAdendaVO> listVO=new ArrayList<ContratoSupervisoraAdendaVO>();
        for(int i=0;i<list.size();i++){
            ContratoSupervisoraAdenda contratoSupervisoraAdenda=(ContratoSupervisoraAdenda)list.get(i);
            ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO=toContratoSupervisoraAdendaVO(contratoSupervisoraAdenda);
            listVO.add(contratoSupervisoraAdendaVO);
        }
        return listVO;
    }
    
    
    private ContratoSupervisoraAdendaVO toContratoSupervisoraAdendaVO(ContratoSupervisoraAdenda contratoSupervisoraAdenda){
        ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO=new ContratoSupervisoraAdendaVO();
        contratoSupervisoraAdendaVO.setCpsId(contratoSupervisoraAdenda.getCpsId());
        contratoSupervisoraAdendaVO.setCpsNroDeContrato(contratoSupervisoraAdenda.getCpsNroDeContrato());
        contratoSupervisoraAdendaVO.setCsaAdenda(contratoSupervisoraAdenda.getCsaAdenda());
        contratoSupervisoraAdendaVO.setCsaFecha(contratoSupervisoraAdenda.getCsaFecha());
        contratoSupervisoraAdendaVO.setCsaMonto(contratoSupervisoraAdenda.getCsaMonto());
        contratoSupervisoraAdendaVO.setCsaPlazo(contratoSupervisoraAdenda.getCsaPlazo());
        contratoSupervisoraAdendaVO.setMonId(contratoSupervisoraAdenda.getMonId());
        return contratoSupervisoraAdendaVO;
    }
    private ContratoSupervisoraAdenda toContratoSupervisoraAdenda(ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO){
        ContratoSupervisoraAdenda contratoSupervisoraAdenda=new ContratoSupervisoraAdenda();
        contratoSupervisoraAdenda.setCpsId(contratoSupervisoraAdendaVO.getCpsId());
        contratoSupervisoraAdenda.setCpsNroDeContrato(contratoSupervisoraAdendaVO.getCpsNroDeContrato());
        contratoSupervisoraAdenda.setCsaAdenda(contratoSupervisoraAdendaVO.getCsaAdenda());
        contratoSupervisoraAdenda.setCsaFecha(contratoSupervisoraAdendaVO.getCsaFecha());
        contratoSupervisoraAdenda.setCsaMonto(contratoSupervisoraAdendaVO.getCsaMonto());
        contratoSupervisoraAdenda.setCsaPlazo(contratoSupervisoraAdendaVO.getCsaPlazo());
        contratoSupervisoraAdenda.setMonId(contratoSupervisoraAdendaVO.getMonId());
        return contratoSupervisoraAdenda;
        
    }
    
    
    
    public void setContratoEmpresaSupervisoraAdendaDAOImpl(ContratoEmpresaSupervisoraAdendaDAO contratoEmpresaSupervisoraAdendaDAOImpl) {
        this.contratoEmpresaSupervisoraAdendaDAOImpl = contratoEmpresaSupervisoraAdendaDAOImpl;
    }

    public ContratoEmpresaSupervisoraAdendaDAO getContratoEmpresaSupervisoraAdendaDAOImpl() {
        return contratoEmpresaSupervisoraAdendaDAOImpl;
    }

    public void setContratoSupervisoraAdenda(ContratoSupervisoraAdenda contratoSupervisoraAdenda) {
        this.contratoSupervisoraAdenda = contratoSupervisoraAdenda;
    }

    public ContratoSupervisoraAdenda getContratoSupervisoraAdenda() {
        return contratoSupervisoraAdenda;
    }

    public void setContratoSupervisoraAdendaVO(ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO) {
        this.contratoSupervisoraAdendaVO = contratoSupervisoraAdendaVO;
    }

    public ContratoSupervisoraAdendaVO getContratoSupervisoraAdendaVO() {
        return contratoSupervisoraAdendaVO;
    }


}