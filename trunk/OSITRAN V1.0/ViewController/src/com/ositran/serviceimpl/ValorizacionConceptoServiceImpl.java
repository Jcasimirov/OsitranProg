package com.ositran.serviceimpl;

import com.ositran.daoimpl.ValorizacionConceptoDAOImpl;
import com.ositran.model.InvReajuste;
import com.ositran.model.ValorizacionConcepto;
import com.ositran.service.ValorizacionConceptoService;
import com.ositran.vo.bean.ValorizacionConceptoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ValorizacionConceptoServiceImpl implements ValorizacionConceptoService{
private ValorizacionConceptoDAOImpl valorizacionConceptoDAOImpl;

    public void setValorizacionConceptoDAOImpl(ValorizacionConceptoDAOImpl valorizacionConceptoDAOImpl) {
        this.valorizacionConceptoDAOImpl = valorizacionConceptoDAOImpl;
    }

    public ValorizacionConceptoDAOImpl getValorizacionConceptoDAOImpl() {
        return valorizacionConceptoDAOImpl;
    }

    @Override
    public List<ValorizacionConceptoVO> query() throws SQLException {
        List<ValorizacionConcepto> list=  valorizacionConceptoDAOImpl.query();
         List<ValorizacionConceptoVO> lista= toListValorizacionConceptoVO(list);
          return lista;
    }

    @Override
    public String insert(InvReajuste invReajuste) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(InvReajuste invReajuste) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public InvReajuste get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }


    //conversiones
    private List<ValorizacionConceptoVO> toListValorizacionConceptoVO(List<ValorizacionConcepto> list){
        List<ValorizacionConceptoVO> listVO=new ArrayList<ValorizacionConceptoVO>();
        for(int i=0;i<list.size();i++){
            ValorizacionConcepto valorizacionConcepto=(ValorizacionConcepto)list.get(i);
            ValorizacionConceptoVO valorizacionConceptoVO=toValorizacionConceptoVO(valorizacionConcepto);
            listVO.add(valorizacionConceptoVO);
        }
        return listVO;
    }
    private ValorizacionConceptoVO toValorizacionConceptoVO(ValorizacionConcepto ValorizacionConcepto1){
        ValorizacionConceptoVO valorizacionConceptoVO1=new ValorizacionConceptoVO();
        valorizacionConceptoVO1.setCvaId(ValorizacionConcepto1.getCvaId());
        valorizacionConceptoVO1.setCvaNombre(ValorizacionConcepto1.getCvaNombre());
        valorizacionConceptoVO1.setCvaDescripcion(ValorizacionConcepto1.getCvaDescripcion());
        valorizacionConceptoVO1.setCvaEstado(ValorizacionConcepto1.getCvaEstado());

        return valorizacionConceptoVO1;
    }
    private ValorizacionConcepto toValorizacionConcepto(ValorizacionConceptoVO valorizacionConceptoVO1){
        ValorizacionConcepto valorizacionConcepto1=new ValorizacionConcepto();
        valorizacionConcepto1.setCvaId(valorizacionConceptoVO1.getCvaId());
        valorizacionConcepto1.setCvaNombre(valorizacionConceptoVO1.getCvaNombre());
        valorizacionConcepto1.setCvaDescripcion(valorizacionConceptoVO1.getCvaDescripcion());
        valorizacionConcepto1.setCvaEstado(valorizacionConceptoVO1.getCvaEstado());
        return valorizacionConcepto1;
        
    }

    

    
}