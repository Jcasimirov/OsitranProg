package com.ositran.serviceimpl;

import com.ositran.dao.ValorizacionSupDetalleDAO;
import com.ositran.daoimpl.ValorizacionInversionAvanceDetalleDAOImpl;
import com.ositran.daoimpl.ValorizacionSupDetalleDAOImpl;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.ValorizacionInversionAvanceDetalle;
import com.ositran.model.ValorizacionSup;
import com.ositran.model.ValorizacionSupDetalle;
import com.ositran.service.ValorizacionSupDetalleService;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.ValorizacionInversionAvanceDetalleVO;
import com.ositran.vo.bean.ValorizacionSupDetalleVO;
import com.ositran.vo.bean.ValorizacionSupVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValorizacionSupDetalleServiceImpl implements ValorizacionSupDetalleService{
    
    ValorizacionSupDetalleDAOImpl valorizacionSupDetalleDAOImpl = new ValorizacionSupDetalleDAOImpl();
    ValorizacionSupDetalle valorizacionSupDetalle = new ValorizacionSupDetalle();
    ValorizacionSupDetalleVO valorizacionSupDetalleVO = new ValorizacionSupDetalleVO();
    
    
    public ValorizacionSupDetalleServiceImpl() {
    }
    
    


    @Override
    public List<ValorizacionSupDetalleVO> query() throws SQLException {
        List<ValorizacionSupDetalle> list=valorizacionSupDetalleDAOImpl.query();
        List<ValorizacionSupDetalleVO> listVO=toListValorizacionSupDetalleVO(list);
        return listVO;
    }

    @Override
    public String insert(ValorizacionSupDetalleVO valorizacionSupDetalleVO) throws SQLException {
        ValorizacionSupDetalle valorizacionSupDetalle=toValorizacionSupDetalle(valorizacionSupDetalleVO);
        String result=valorizacionSupDetalleDAOImpl.insert(valorizacionSupDetalle);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=this.valorizacionSupDetalleDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ValorizacionSupDetalleVO valorizacionSupDetalleVO) throws SQLException {
        ValorizacionSupDetalle valorizacionSupDetalle=toValorizacionSupDetalle(valorizacionSupDetalleVO);
        String result=this.valorizacionSupDetalleDAOImpl.update(valorizacionSupDetalle);
        return result;
    }

    @Override
    public ValorizacionSupDetalleVO get(Integer id) throws SQLException {
        ValorizacionSupDetalle valorizacionSupDetalle=this.valorizacionSupDetalleDAOImpl.get(id);
        ValorizacionSupDetalleVO valorizacionSupDetalleVO=toValorizacionSupDetalleVO(valorizacionSupDetalle);
        return valorizacionSupDetalleVO;
    }

    
    //conversiones
    private List<ValorizacionSupDetalleVO> toListValorizacionSupDetalleVO(List<ValorizacionSupDetalle> list){
        List<ValorizacionSupDetalleVO> listVO=new ArrayList<ValorizacionSupDetalleVO>();
        for(int i=0;i<list.size();i++){
            ValorizacionSupDetalle valorizacionSupDetalle=(ValorizacionSupDetalle)list.get(i);
            ValorizacionSupDetalleVO valorizacionSupDetalleVO=toValorizacionSupDetalleVO(valorizacionSupDetalle);
            listVO.add(valorizacionSupDetalleVO);
        }
        return listVO;
    }
    private ValorizacionSupDetalleVO toValorizacionSupDetalleVO(ValorizacionSupDetalle valorizacionSupDetalle){
        ValorizacionSupDetalleVO valorizacionSupDetalleVO=new ValorizacionSupDetalleVO();
        valorizacionSupDetalleVO.setTvsId(valorizacionSupDetalle.getTvsId());
        valorizacionSupDetalleVO.setCvaId(valorizacionSupDetalle.getCvaId()); 
        valorizacionSupDetalleVO.setIgv(valorizacionSupDetalle.getIgv());
        valorizacionSupDetalleVO.setMonId(valorizacionSupDetalle.getMonId());
        valorizacionSupDetalleVO.setNeto(valorizacionSupDetalle.getNeto());
        valorizacionSupDetalleVO.setTtotal(valorizacionSupDetalle.getTtotal());
        valorizacionSupDetalleVO.setTotalAprobado(valorizacionSupDetalle.getTotalAprobado());
        valorizacionSupDetalleVO.setVsdId(valorizacionSupDetalle.getVsdId());
        return valorizacionSupDetalleVO;
    }
    private ValorizacionSupDetalle toValorizacionSupDetalle(ValorizacionSupDetalleVO valorizacionSupDetalleVO){
        ValorizacionSupDetalle valorizacionSupDetalle=new ValorizacionSupDetalle();
        valorizacionSupDetalle.setTvsId(valorizacionSupDetalleVO.getTvsId());
        valorizacionSupDetalle.setCvaId(valorizacionSupDetalleVO.getCvaId());
        valorizacionSupDetalle.setIgv(valorizacionSupDetalleVO.getIgv());
        valorizacionSupDetalle.setMonId(valorizacionSupDetalleVO.getMonId());
        valorizacionSupDetalle.setNeto(valorizacionSupDetalleVO.getNeto());
        valorizacionSupDetalle.setTtotal(valorizacionSupDetalleVO.getTtotal());
        valorizacionSupDetalle.setTotalAprobado(valorizacionSupDetalleVO.getTotalAprobado());
        valorizacionSupDetalle.setVsdId(valorizacionSupDetalleVO.getVsdId());
        return valorizacionSupDetalle;
        
    }


    public void setValorizacionSupDetalleDAOImpl(ValorizacionSupDetalleDAOImpl valorizacionSupDetalleDAOImpl) {
        this.valorizacionSupDetalleDAOImpl = valorizacionSupDetalleDAOImpl;
    }

    public ValorizacionSupDetalleDAOImpl getValorizacionSupDetalleDAOImpl() {
        return valorizacionSupDetalleDAOImpl;
    }

    public void setValorizacionSupDetalle(ValorizacionSupDetalle valorizacionSupDetalle) {
        this.valorizacionSupDetalle = valorizacionSupDetalle;
    }

    public ValorizacionSupDetalle getValorizacionSupDetalle() {
        return valorizacionSupDetalle;
    }

    public void setValorizacionSupDetalleVO(ValorizacionSupDetalleVO valorizacionSupDetalleVO) {
        this.valorizacionSupDetalleVO = valorizacionSupDetalleVO;
    }

    public ValorizacionSupDetalleVO getValorizacionSupDetalleVO() {
        return valorizacionSupDetalleVO;
    }


    //Ivan
    @Override
    public List<ValorizacionSupDetalleVO> ListaValorizacionesDetRegistradas(Integer id) throws SQLException, Exception {
        List<ValorizacionSupDetalle> Lista = valorizacionSupDetalleDAOImpl.ListaValorizacionesDetRegistradas(id);
        List<ValorizacionSupDetalleVO> ListaVO = toListValorizacionSupDetalleVO(Lista);
        return ListaVO;
    }

}
