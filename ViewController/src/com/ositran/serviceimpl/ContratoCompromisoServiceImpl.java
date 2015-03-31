package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoCompromisoDAOImpl;

import com.ositran.model.ContratoCompromiso;
import com.ositran.service.ContratoCompromisoService;
import com.ositran.vo.bean.ContratoCompromisoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContratoCompromisoServiceImpl implements ContratoCompromisoService {
    ContratoCompromisoVO contratoCompromisoVO;
    ContratoCompromiso contratoCompromiso;
    ContratoCompromisoDAOImpl contratoCompromisoDAOImpl;
    
    public ContratoCompromisoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoCompromisoVO> query() throws SQLException {
        List<ContratoCompromiso> list=contratoCompromisoDAOImpl.query();
        List<ContratoCompromisoVO> listVO=toListContratoCompromisoVO(list);
        return listVO;
    }


    @Override
    public List<ContratoCompromisoVO> query1(int codigo) throws SQLException {
        System.out.println("LEGO AL SERVICES");
        List<ContratoCompromiso> list=contratoCompromisoDAOImpl.query1(codigo);
        List<ContratoCompromisoVO> listVO=toListContratoCompromisoVO(list);
        return listVO;
    }
    
    @Override
    public String insert(ContratoCompromisoVO contratoCompromisoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoCompromisoVO contratoCompromisoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoCompromisoVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
    
    
    //conversiones
    private List<ContratoCompromisoVO> toListContratoCompromisoVO(List<ContratoCompromiso> list){
        List<ContratoCompromisoVO> listVO=new ArrayList<ContratoCompromisoVO>();
        for(int i=0;i<list.size();i++){
            ContratoCompromiso contratoCompromiso=(ContratoCompromiso)list.get(i);
            ContratoCompromisoVO contratoCompromisoVO=toContratoCompromisoVO(contratoCompromiso);
            listVO.add(contratoCompromisoVO);
        }
        return listVO;
    }
    private ContratoCompromisoVO toContratoCompromisoVO(ContratoCompromiso contratoCompromiso1){
        ContratoCompromisoVO contratoCompromisoVO1=new ContratoCompromisoVO();
        contratoCompromisoVO1.setCcoAlcance(contratoCompromiso1.getCcoAlcance());
        contratoCompromisoVO1.setCcoId(contratoCompromiso1.getCcoId());
        contratoCompromisoVO1.setCcoIgv(contratoCompromiso1.getCcoIgv());
        contratoCompromisoVO1.setCcoNeto(contratoCompromiso1.getCcoNeto());
        contratoCompromisoVO1.setCcoPeriodo(contratoCompromiso1.getCcoPeriodo());
        contratoCompromisoVO1.setCcoPlazo(contratoCompromiso1.getCcoPlazo());
        contratoCompromisoVO1.setCcoTipoCambio(contratoCompromiso1.getCcoTipoCambio());
        contratoCompromisoVO1.setCcoTotal(contratoCompromiso1.getCcoTotal());
        contratoCompromisoVO1.setConId(contratoCompromiso1.getConId());
        contratoCompromisoVO1.setMonId(contratoCompromiso1.getMonId());
        contratoCompromisoVO1.setPorIgv(contratoCompromiso1.getPorIgv());
        contratoCompromisoVO1.setTccTipo(contratoCompromiso1.getTccTipo());
        contratoCompromisoVO1.setTivId(contratoCompromiso1.getTivId());
        return contratoCompromisoVO1;
    }
    private ContratoCompromiso toContratoCompromiso(ContratoCompromisoVO contratoCompromisoVO1){
        ContratoCompromiso contratoCompromiso1=new ContratoCompromiso();
        contratoCompromiso1.setCcoAlcance(contratoCompromisoVO1.getCcoAlcance());
        contratoCompromiso1.setCcoId(contratoCompromisoVO1.getCcoId());
        contratoCompromiso1.setCcoIgv(contratoCompromisoVO1.getCcoIgv());
        contratoCompromiso1.setCcoNeto(contratoCompromisoVO1.getCcoNeto());
        contratoCompromiso1.setCcoPeriodo(contratoCompromisoVO1.getCcoPeriodo());
        contratoCompromiso1.setCcoPlazo(contratoCompromisoVO1.getCcoPlazo());
        contratoCompromiso1.setCcoTipoCambio(contratoCompromisoVO1.getCcoTipoCambio());
        contratoCompromiso1.setCcoTotal(contratoCompromisoVO1.getCcoTotal());
        contratoCompromiso1.setConId(contratoCompromisoVO1.getConId());
        contratoCompromiso1.setMonId(contratoCompromisoVO1.getMonId());
        contratoCompromiso1.setPorIgv(contratoCompromisoVO1.getPorIgv());
        contratoCompromiso1.setTccTipo(contratoCompromisoVO1.getTccTipo());
        contratoCompromiso1.setTivId(contratoCompromisoVO1.getTivId());
        return contratoCompromiso;
        
    }

    public void setContratoCompromisoVO(ContratoCompromisoVO contratoCompromisoVO) {
        this.contratoCompromisoVO = contratoCompromisoVO;
    }

    public ContratoCompromisoVO getContratoCompromisoVO() {
        return contratoCompromisoVO;
    }

    public void setContratoCompromiso(ContratoCompromiso contratoCompromiso) {
        this.contratoCompromiso = contratoCompromiso;
    }

    public ContratoCompromiso getContratoCompromiso() {
        return contratoCompromiso;
    }

    public void setContratoCompromisoDAOImpl(ContratoCompromisoDAOImpl contratoCompromisoDAOImpl) {
        this.contratoCompromisoDAOImpl = contratoCompromisoDAOImpl;
    }

    public ContratoCompromisoDAOImpl getContratoCompromisoDAOImpl() {
        return contratoCompromisoDAOImpl;
    }

    public List<ContratoCompromisoVO> getCompromisosContrato(Integer conId,Integer tccTipo) throws SQLException{
        
        List<ContratoCompromiso> list = contratoCompromisoDAOImpl.getCompromisosContrato(conId,tccTipo );
        List<ContratoCompromisoVO> listVO=toListContratoCompromisoVO(list);
        return listVO;
    }
    
    
    

    
}
