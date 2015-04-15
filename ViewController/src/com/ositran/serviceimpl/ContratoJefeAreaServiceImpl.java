package com.ositran.serviceimpl;

import com.ositran.dao.ContratoJefeAreaDAO;
import com.ositran.daoimpl.ContratoJefeAreaDAOImpl;
import com.ositran.model.ContratoJefeArea;
import com.ositran.model.InversionTipo;
import com.ositran.service.ContratoJefeAreaService;
import com.ositran.vo.bean.ContratoJefeAreaVO;

import com.ositran.vo.bean.TipoInversionVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContratoJefeAreaServiceImpl implements ContratoJefeAreaService {
    private ContratoJefeArea contratoJefeArea;
    private ContratoJefeAreaVO contratoJefeAreaVO;
    private ContratoJefeAreaDAO contratoJefeAreaDAOImpl;
    
    public ContratoJefeAreaServiceImpl() {
        super();
    }

    @Override
    public List<ContratoJefeAreaVO> query() {
        List<ContratoJefeArea> list=contratoJefeAreaDAOImpl.query();
        List<ContratoJefeAreaVO> listVO=toListContratoJefeAreaVO(list);
        return listVO;
    }

    
    @Override
    public List<ContratoJefeAreaVO> query1(int filtro) {
        List<ContratoJefeArea> list=contratoJefeAreaDAOImpl.query1(filtro);
        List<ContratoJefeAreaVO> listVO=toListContratoJefeAreaVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoJefeAreaVO contratoJefeAreaVO) {
        ContratoJefeArea contratoJefeArea=toContratoJefeArea(contratoJefeAreaVO);
        String result=contratoJefeAreaDAOImpl.insert(contratoJefeArea);
        return result;
    }

    @Override
    public String delete(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoJefeAreaVO contratoJefeAreaVO) {
        contratoJefeArea=toContratoJefeArea(contratoJefeAreaVO);
        String result=this.contratoJefeAreaDAOImpl.update(contratoJefeArea);
        return result;
    }

    @Override
    public ContratoJefeAreaVO get(Integer id) {
        contratoJefeArea =contratoJefeAreaDAOImpl.get(id);
        contratoJefeAreaVO=toContratoJefeAreaVO(contratoJefeArea);
        return contratoJefeAreaVO;
    }


    @Override
    public int getCodigo(ContratoJefeAreaVO contratoJefeAreaVO) {
        // TODO Implement this method
        return 0;
    }
    
    //conversiones
    private List<ContratoJefeAreaVO> toListContratoJefeAreaVO(List<ContratoJefeArea> list)  {
       List<ContratoJefeAreaVO> listVO=new ArrayList<ContratoJefeAreaVO>();
       for(int i=0;i<list.size();i++){
           contratoJefeArea=(ContratoJefeArea)list.get(i);
           contratoJefeAreaVO=toContratoJefeAreaVO(contratoJefeArea);
           listVO.add(contratoJefeAreaVO);
       }
       return listVO;
    }
    private ContratoJefeAreaVO toContratoJefeAreaVO(ContratoJefeArea contratoJefeArea1)  {
       ContratoJefeAreaVO contratoJefeAreaVO1=new ContratoJefeAreaVO();
       contratoJefeAreaVO1.setCjaEstado(contratoJefeArea1.getCjaEstado());
       contratoJefeAreaVO1.setCjaFechaFinal(contratoJefeArea1.getCjaFechaFinal());
       contratoJefeAreaVO1.setCjaFechaInicial(contratoJefeArea1.getCjaFechaInicial());
       contratoJefeAreaVO1.setCjaId(contratoJefeArea1.getCjaId());
       contratoJefeAreaVO1.setCjaNroDocumento(contratoJefeArea1.getCjaNroDocumento());
       contratoJefeAreaVO1.setConId(contratoJefeArea1.getConId());
       contratoJefeAreaVO1.setCsiId(contratoJefeArea1.getCsiId());
       contratoJefeAreaVO1.setTdoId(contratoJefeArea1.getTdoId());
       contratoJefeAreaVO1.setTinId(contratoJefeArea1.getTinId());
       return contratoJefeAreaVO1;
    }
    private ContratoJefeArea toContratoJefeArea(ContratoJefeAreaVO contratoJefeAreaVO1)  {
       ContratoJefeArea contratoJefeArea1=new ContratoJefeArea();
        contratoJefeArea1.setCjaEstado(contratoJefeAreaVO1.getCjaEstado());
        contratoJefeArea1.setCjaFechaFinal(contratoJefeAreaVO1.getCjaFechaFinal());
        contratoJefeArea1.setCjaFechaInicial(contratoJefeAreaVO1.getCjaFechaInicial());
        contratoJefeArea1.setCjaId(contratoJefeAreaVO1.getCjaId());
        contratoJefeArea1.setCjaNroDocumento(contratoJefeAreaVO1.getCjaNroDocumento());
        contratoJefeArea1.setConId(contratoJefeAreaVO1.getConId());
        contratoJefeArea1.setCsiId(contratoJefeAreaVO1.getCsiId());
        contratoJefeArea1.setTdoId(contratoJefeAreaVO1.getTdoId());
        contratoJefeArea1.setTinId(contratoJefeAreaVO1.getTinId());
       return contratoJefeArea1;
    }


    public void setContratoJefeArea(ContratoJefeArea contratoJefeArea) {
        this.contratoJefeArea = contratoJefeArea;
    }

    public ContratoJefeArea getContratoJefeArea() {
        return contratoJefeArea;
    }

    public void setContratoJefeAreaVO(ContratoJefeAreaVO contratoJefeAreaVO) {
        this.contratoJefeAreaVO = contratoJefeAreaVO;
    }

    public ContratoJefeAreaVO getContratoJefeAreaVO() {
        return contratoJefeAreaVO;
    }

    public void setContratoJefeAreaDAOImpl(ContratoJefeAreaDAO contratoJefeAreaDAOImpl) {
        this.contratoJefeAreaDAOImpl = contratoJefeAreaDAOImpl;
    }

    public ContratoJefeAreaDAO getContratoJefeAreaDAOImpl() {
        return contratoJefeAreaDAOImpl;
    }

}
