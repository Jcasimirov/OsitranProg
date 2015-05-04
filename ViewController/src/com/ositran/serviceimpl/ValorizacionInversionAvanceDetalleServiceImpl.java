package com.ositran.serviceimpl;

import com.ositran.daoimpl.ValorizacionInversionAvanceDetalleDAOImpl;
import com.ositran.model.ValorizacionInversionAvanceDetalle;
import com.ositran.service.ValorizacionInversionAvanceDetalleService;
import com.ositran.vo.bean.ValorizacionInversionAvanceDetalleVO;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;

public class ValorizacionInversionAvanceDetalleServiceImpl implements ValorizacionInversionAvanceDetalleService{
    ValorizacionInversionAvanceDetalleDAOImpl valorizacionInversionAvanceDetalleDAOImpl = new ValorizacionInversionAvanceDetalleDAOImpl();
    ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO=new ValorizacionInversionAvanceDetalleVO();
    ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle=new ValorizacionInversionAvanceDetalle();

    public void setValorizacionInversionAvanceDetalleDAOImpl(ValorizacionInversionAvanceDetalleDAOImpl valorizacionInversionAvanceDetalleDAOImpl) {
        this.valorizacionInversionAvanceDetalleDAOImpl = valorizacionInversionAvanceDetalleDAOImpl;
    }

    public ValorizacionInversionAvanceDetalleDAOImpl getValorizacionInversionAvanceDetalleDAOImpl() {
        return valorizacionInversionAvanceDetalleDAOImpl;
    }

    public void setValorizacionInversionAvanceDetalleVO(ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO) {
        this.valorizacionInversionAvanceDetalleVO = valorizacionInversionAvanceDetalleVO;
    }

    public ValorizacionInversionAvanceDetalleVO getValorizacionInversionAvanceDetalleVO() {
        return valorizacionInversionAvanceDetalleVO;
    }

    public void setValorizacionInversionAvanceDetalle(ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle) {
        this.valorizacionInversionAvanceDetalle = valorizacionInversionAvanceDetalle;
    }

    public ValorizacionInversionAvanceDetalle getValorizacionInversionAvanceDetalle() {
        return valorizacionInversionAvanceDetalle;
    }

    public ValorizacionInversionAvanceDetalleServiceImpl() {
        super();
    }
    

    public List<ValorizacionInversionAvanceDetalleVO> query1(int codigoValorizacion) throws SQLException, Exception {
        List<ValorizacionInversionAvanceDetalle> list=valorizacionInversionAvanceDetalleDAOImpl.query1(codigoValorizacion);
        List<ValorizacionInversionAvanceDetalleVO> listVO=toValorizacionInversionAvanceDetalleVO(list);
        return listVO;
    }

    @Override
    public List<ValorizacionInversionAvanceDetalleVO> query() throws SQLException, Exception {
        List<ValorizacionInversionAvanceDetalle> list=valorizacionInversionAvanceDetalleDAOImpl.query();
        List<ValorizacionInversionAvanceDetalleVO> listVO=toValorizacionInversionAvanceDetalleVO(list);
        return listVO;
    }

    @Override
    public String insert(ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO1) throws SQLException, Exception {
        valorizacionInversionAvanceDetalle=toValorizacionInversionAvanceDetalle(valorizacionInversionAvanceDetalleVO1);
        String result=valorizacionInversionAvanceDetalleDAOImpl.insert(valorizacionInversionAvanceDetalle);
        return result;
        
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO) throws ParseException,
                                                                                                           SQLException,
                                                                                                           Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public ValorizacionInversionAvanceDetalleVO get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
    
    
    
    //conversiones
    private List<ValorizacionInversionAvanceDetalleVO> toValorizacionInversionAvanceDetalleVO(List<ValorizacionInversionAvanceDetalle> list)  {
       List<ValorizacionInversionAvanceDetalleVO> listVO=new ArrayList<ValorizacionInversionAvanceDetalleVO>();
       for(int i=0;i<list.size();i++){
           valorizacionInversionAvanceDetalle=(ValorizacionInversionAvanceDetalle)list.get(i);
           valorizacionInversionAvanceDetalleVO=toValorizacionInversionAvanceDetalleVO(valorizacionInversionAvanceDetalle);
           listVO.add(valorizacionInversionAvanceDetalleVO);
       }
       return listVO;
    }
    private ValorizacionInversionAvanceDetalleVO toValorizacionInversionAvanceDetalleVO(ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle1)  {
       ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO1=new ValorizacionInversionAvanceDetalleVO();
       valorizacionInversionAvanceDetalleVO1.setIgv(valorizacionInversionAvanceDetalle1.getIgv());
       valorizacionInversionAvanceDetalleVO1.setMonId(valorizacionInversionAvanceDetalle1.getMonId());
       valorizacionInversionAvanceDetalleVO1.setMontoPresentado(valorizacionInversionAvanceDetalle1.getMontoPresentado());
       valorizacionInversionAvanceDetalleVO1.setTiaNumero(valorizacionInversionAvanceDetalle1.getTiaNumero());
       valorizacionInversionAvanceDetalleVO1.setTiaTotal(valorizacionInversionAvanceDetalle1.getTiaTotal());
       valorizacionInversionAvanceDetalleVO1.setIad_Id(valorizacionInversionAvanceDetalle1.getIad_Id());
       valorizacionInversionAvanceDetalleVO1.setDtiId(valorizacionInversionAvanceDetalle1.getDtiId());
       valorizacionInversionAvanceDetalleVO1.setIadPDF(valorizacionInversionAvanceDetalle1.getIadPDF());
       valorizacionInversionAvanceDetalleVO1.setTivId(valorizacionInversionAvanceDetalle1.getTivId());
        valorizacionInversionAvanceDetalleVO1.setInfId(valorizacionInversionAvanceDetalle1.getInfId());
       /*        valorizacionInversionAvanceDetalleVO1.setIadDescripcion(valorizacionInversionAvanceDetalle1.getIadDescripcion());
       valorizacionInversionAvanceDetalleVO1.setIadFechaInicio(valorizacionInversionAvanceDetalle1.getIadFechaInicio());
       valorizacionInversionAvanceDetalleVO1.setIadFechaFin(valorizacionInversionAvanceDetalle1.getIadFechaFin()); */
       
       
       return valorizacionInversionAvanceDetalleVO1;
    }
    private ValorizacionInversionAvanceDetalle toValorizacionInversionAvanceDetalle(ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO1)  {
       ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle1=new ValorizacionInversionAvanceDetalle();
        valorizacionInversionAvanceDetalle1.setIgv(valorizacionInversionAvanceDetalleVO1.getIgv());
        valorizacionInversionAvanceDetalle1.setMonId(valorizacionInversionAvanceDetalleVO1.getMonId());
        valorizacionInversionAvanceDetalle1.setMontoPresentado(valorizacionInversionAvanceDetalleVO1.getMontoPresentado());
        valorizacionInversionAvanceDetalle1.setTiaNumero(valorizacionInversionAvanceDetalleVO1.getTiaNumero());
        valorizacionInversionAvanceDetalle1.setTiaTotal(valorizacionInversionAvanceDetalleVO1.getTiaTotal());
        valorizacionInversionAvanceDetalle1.setIad_Id(valorizacionInversionAvanceDetalleVO1.getIad_Id());
        valorizacionInversionAvanceDetalle1.setDtiId(valorizacionInversionAvanceDetalleVO1.getDtiId());
        valorizacionInversionAvanceDetalle1.setIadPDF(valorizacionInversionAvanceDetalleVO1.getIadPDF());
        valorizacionInversionAvanceDetalle1.setTivId(valorizacionInversionAvanceDetalleVO1.getTivId());
        valorizacionInversionAvanceDetalle1.setInfId(valorizacionInversionAvanceDetalleVO1.getInfId());
        /*  valorizacionInversionAvanceDetalle1.setIadDescripcion(valorizacionInversionAvanceDetalleVO1.getIadDescripcion());
        valorizacionInversionAvanceDetalle1.setIadFechaInicio(valorizacionInversionAvanceDetalleVO1.getIadFechaInicio());
        valorizacionInversionAvanceDetalle1.setIadFechaFin(valorizacionInversionAvanceDetalleVO1.getIadFechaFin()); */
       
       return valorizacionInversionAvanceDetalle1;
    }


    public List<ValorizacionInversionAvanceDetalleVO> getInvAvanceDetallesInvAvance(Integer tiaNumero) throws SQLException ,Exception {
        System.out.println("INI getInvAvanceDetallesInvAvance");
        List<ValorizacionInversionAvanceDetalle> list=valorizacionInversionAvanceDetalleDAOImpl.getInvAvanceDetallesInvAvance(tiaNumero);
        List<ValorizacionInversionAvanceDetalleVO> listVO=toValorizacionInversionAvanceDetalleVO(list);
        System.out.println("FIN getInvAvanceDetallesInvAvance");
        return listVO;
    }
}
