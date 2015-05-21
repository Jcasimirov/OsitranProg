package com.ositran.serviceimpl;

import com.ositran.daoimpl.ValorizacionInversionAvanceDAOImpl;
import com.ositran.model.ValorizacionInversionAvance;
import com.ositran.service.ValorizacionInversionAvanceService;
import com.ositran.vo.bean.ValorizacionInversionAvanceVO;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;

public class ValorizacionInversionAvanceServiceImpl implements ValorizacionInversionAvanceService{
    ValorizacionInversionAvanceVO valorizacionInversionAvanceVO=new ValorizacionInversionAvanceVO();
    ValorizacionInversionAvance valorizacionInversionAvance=new ValorizacionInversionAvance();
    ValorizacionInversionAvanceDAOImpl valorizacionInversionAvanceDAOImpl= new ValorizacionInversionAvanceDAOImpl();


    @Override
    public List<ValorizacionInversionAvanceVO> query() throws SQLException, Exception {
        List<ValorizacionInversionAvance> list=valorizacionInversionAvanceDAOImpl.query();
        List<ValorizacionInversionAvanceVO> listVO=toListValorizacionInversionAvanceVO(list);
        return listVO;
    }
    
    
    @Override
    public List<ValorizacionInversionAvanceVO> queryDerivarInversion(int codigoContrato, int codigoContratoCompromiso,
                                                                     int estado) throws SQLException, Exception {
        List<ValorizacionInversionAvance> list=valorizacionInversionAvanceDAOImpl.queryDerivarInversion(codigoContrato,codigoContratoCompromiso,estado);
        List<ValorizacionInversionAvanceVO> listVO=toListValorizacionInversionAvanceVO(list);
        System.out.println(listVO.size());
        return listVO;
    }
    
    @Override
    public List<ValorizacionInversionAvanceVO> query1(int codigoContrato) throws SQLException, Exception {
        List<ValorizacionInversionAvance> list=valorizacionInversionAvanceDAOImpl.query1(codigoContrato);
        List<ValorizacionInversionAvanceVO> listVO=toListValorizacionInversionAvanceVO(list);
        System.out.println(listVO.size());
        return listVO;
    }
    

    @Override
    public int insert(ValorizacionInversionAvanceVO valorizacionInversionAvanceVO1) throws SQLException, Exception {
        valorizacionInversionAvance=toValorizacionInversionAvance(valorizacionInversionAvanceVO1);
        int result=valorizacionInversionAvanceDAOImpl.insert(valorizacionInversionAvance);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
    
    @Override
    public String update(ValorizacionInversionAvanceVO valorizacionInversionAvanceVO) throws ParseException, SQLException, Exception {
         valorizacionInversionAvance=toValorizacionInversionAvance(valorizacionInversionAvanceVO);
        String result=this.valorizacionInversionAvanceDAOImpl.update(valorizacionInversionAvance);
        return result;  
    }

    @Override
    public ValorizacionInversionAvanceVO get(Integer id) throws SQLException, Exception {
        valorizacionInversionAvance =valorizacionInversionAvanceDAOImpl.get(id);
        valorizacionInversionAvanceVO=toValorizacionInversionAvanceVO(valorizacionInversionAvance);
        return valorizacionInversionAvanceVO;
    }
    
    
    //conversiones
    private List<ValorizacionInversionAvanceVO> toListValorizacionInversionAvanceVO(List<ValorizacionInversionAvance> list)  {
       List<ValorizacionInversionAvanceVO> listVO=new ArrayList<ValorizacionInversionAvanceVO>();
       for(int i=0;i<list.size();i++){
           valorizacionInversionAvance=(ValorizacionInversionAvance)list.get(i);
           valorizacionInversionAvanceVO=toValorizacionInversionAvanceVO(valorizacionInversionAvance);
           listVO.add(valorizacionInversionAvanceVO);
       }
       return listVO;
    }
    
    
  
    
    
    private ValorizacionInversionAvanceVO toValorizacionInversionAvanceVO(ValorizacionInversionAvance valorizacionInversionAvance1)  {
       ValorizacionInversionAvanceVO valorizacionInversionAvanceVO1=new ValorizacionInversionAvanceVO();
       valorizacionInversionAvanceVO1.setConId(valorizacionInversionAvance1.getConId());
       valorizacionInversionAvanceVO1.setCsiId(valorizacionInversionAvance1.getCsiId());
       valorizacionInversionAvanceVO1.setInvId(valorizacionInversionAvance1.getInvId());
       valorizacionInversionAvanceVO1.setMcoId(valorizacionInversionAvance1.getMcoId());
       valorizacionInversionAvanceVO1.setTiaAnyo(valorizacionInversionAvance1.getTiaAnyo());
       valorizacionInversionAvanceVO1.setTiaAsunto(valorizacionInversionAvance1.getTiaAsunto());
       valorizacionInversionAvanceVO1.setTiaDiasHabiles(valorizacionInversionAvance1.getTiaDiasHabiles());
       valorizacionInversionAvanceVO1.setTiaFechaFin(valorizacionInversionAvance1.getTiaFechaFin());
       valorizacionInversionAvanceVO1.setTiaFechaInicio(valorizacionInversionAvance1.getTiaFechaInicio());
       valorizacionInversionAvanceVO1.setTiaFechaRegistro(valorizacionInversionAvance1.getTiaFechaRegistro());
       valorizacionInversionAvanceVO1.setTiaFechaVencimientoPlazo(valorizacionInversionAvance1.getTiaFechaVencimientoPlazo());
       valorizacionInversionAvanceVO1.setTiaHr(valorizacionInversionAvance1.getTiaHr());
       valorizacionInversionAvanceVO1.setTiaNumero(valorizacionInversionAvance1.getTiaNumero());
       valorizacionInversionAvanceVO1.setTiaPlazoEnDias(valorizacionInversionAvance1.getTiaPlazoEnDias());
       valorizacionInversionAvanceVO1.setTinId(valorizacionInversionAvance1.getTinId());
       valorizacionInversionAvanceVO1.setTiaMontoTotalAprobado(valorizacionInversionAvance1.getTiaMontoTotalAprobado());
       valorizacionInversionAvanceVO1.setTiaMontoTotalPresentado(valorizacionInversionAvance1.getTiaMontoTotalPresentado());
       valorizacionInversionAvanceVO1.setTiaMontoTotalReajustado(valorizacionInversionAvance1.getTiaMontoTotalReajustado());
       valorizacionInversionAvanceVO1.setMonId(valorizacionInversionAvance1.getMonId());
       valorizacionInversionAvanceVO1.setIaeId(valorizacionInversionAvance1.getIaeId());
       valorizacionInversionAvanceVO1.setCcoId(valorizacionInversionAvance1.getCcoId());
       valorizacionInversionAvanceVO1.setTiaRutaNot(valorizacionInversionAvance1.getTiaRutaNot());
       valorizacionInversionAvanceVO1.setTccTipo(valorizacionInversionAvance1.getTccTipo());
       valorizacionInversionAvanceVO1.setTiaAprobadoPor(valorizacionInversionAvance1.getTiaAprobadoPor());
       valorizacionInversionAvanceVO1.setTiaIgvMonto(valorizacionInversionAvance1.getTiaIgvMonto());
        valorizacionInversionAvanceVO1.setTiaIgv(valorizacionInversionAvance1.getTiaIgv());
       return valorizacionInversionAvanceVO1;
    }
    private ValorizacionInversionAvance toValorizacionInversionAvance(ValorizacionInversionAvanceVO valorizacionInversionAvanceVO1)  {
       ValorizacionInversionAvance valorizacionInversionAvance1=new ValorizacionInversionAvance();
        valorizacionInversionAvance1.setConId(valorizacionInversionAvanceVO1.getConId());
        valorizacionInversionAvance1.setCsiId(valorizacionInversionAvanceVO1.getCsiId());
        valorizacionInversionAvance1.setInvId(valorizacionInversionAvanceVO1.getInvId());
        valorizacionInversionAvance1.setMcoId(valorizacionInversionAvanceVO1.getMcoId());
        valorizacionInversionAvance1.setTiaAnyo(valorizacionInversionAvanceVO1.getTiaAnyo());
        valorizacionInversionAvance1.setTiaAsunto(valorizacionInversionAvanceVO1.getTiaAsunto());
        valorizacionInversionAvance1.setTiaDiasHabiles(valorizacionInversionAvanceVO1.getTiaDiasHabiles());
        valorizacionInversionAvance1.setTiaFechaFin(valorizacionInversionAvanceVO1.getTiaFechaFin());
        valorizacionInversionAvance1.setTiaFechaInicio(valorizacionInversionAvanceVO1.getTiaFechaInicio());
        valorizacionInversionAvance1.setTiaFechaRegistro(valorizacionInversionAvanceVO1.getTiaFechaRegistro());
        valorizacionInversionAvance1.setTiaFechaVencimientoPlazo(valorizacionInversionAvanceVO1.getTiaFechaVencimientoPlazo());
        valorizacionInversionAvance1.setTiaHr(valorizacionInversionAvanceVO1.getTiaHr());
        valorizacionInversionAvance1.setTiaNumero(valorizacionInversionAvanceVO1.getTiaNumero());
        valorizacionInversionAvance1.setTiaPlazoEnDias(valorizacionInversionAvanceVO1.getTiaPlazoEnDias());
        valorizacionInversionAvance1.setTinId(valorizacionInversionAvanceVO1.getTinId());
        valorizacionInversionAvance1.setTiaMontoTotalAprobado(valorizacionInversionAvanceVO1.getTiaMontoTotalAprobado());
        valorizacionInversionAvance1.setTiaMontoTotalPresentado(valorizacionInversionAvanceVO1.getTiaMontoTotalPresentado());
        valorizacionInversionAvance1.setTiaMontoTotalReajustado(valorizacionInversionAvanceVO1.getTiaMontoTotalReajustado());
        valorizacionInversionAvance1.setMonId(valorizacionInversionAvanceVO1.getMonId());
        valorizacionInversionAvance1.setIaeId(valorizacionInversionAvanceVO1.getIaeId());
        valorizacionInversionAvance1.setCcoId(valorizacionInversionAvanceVO1.getCcoId());
        valorizacionInversionAvance1.setTiaRutaNot(valorizacionInversionAvanceVO1.getTiaRutaNot());
        valorizacionInversionAvance1.setTccTipo(valorizacionInversionAvanceVO1.getTccTipo());
        valorizacionInversionAvance1.setTiaAprobadoPor(valorizacionInversionAvanceVO1.getTiaAprobadoPor());
        valorizacionInversionAvance1.setTiaIgvMonto(valorizacionInversionAvanceVO1.getTiaIgvMonto());
        valorizacionInversionAvance1.setTiaIgv(valorizacionInversionAvanceVO1.getTiaIgv());
       return valorizacionInversionAvance1;
    }


    public void setValorizacionInversionAvanceDAOImpl(ValorizacionInversionAvanceDAOImpl valorizacionInversionAvanceDAOImpl) {
        this.valorizacionInversionAvanceDAOImpl = valorizacionInversionAvanceDAOImpl;
    }

    public ValorizacionInversionAvanceDAOImpl getValorizacionInversionAvanceDAOImpl() {
        return valorizacionInversionAvanceDAOImpl;
    }

    public ValorizacionInversionAvanceServiceImpl() {
        super();
    }
}
