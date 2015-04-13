package com.ositran.serviceimpl;

import com.ositran.daoimpl.ValorizacionInversionAvanceDAOImpl;
import com.ositran.model.InversionTipo;
import com.ositran.model.ValorizacionInversionAvance;
import com.ositran.service.ValorizacionInversionAvanceService;
import com.ositran.vo.bean.TipoInversionVO;
import com.ositran.vo.bean.ValorizacionInversionAvanceVO;
import java.sql.SQLException;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValorizacionInversionAvanceServiceImpl implements ValorizacionInversionAvanceService{
    ValorizacionInversionAvanceVO valorizacionInversionAvanceVO=new ValorizacionInversionAvanceVO();
    ValorizacionInversionAvance valorizacionInversionAvance=new ValorizacionInversionAvance();
    ValorizacionInversionAvanceDAOImpl valorizacionInversionAvanceDAOImpl=new ValorizacionInversionAvanceDAOImpl();
    
    
    public ValorizacionInversionAvanceServiceImpl() {
        super();
    }

    @Override
    public List<ValorizacionInversionAvanceVO> query() throws SQLException, Exception {
        List<ValorizacionInversionAvance> list=valorizacionInversionAvanceDAOImpl.query();
        List<ValorizacionInversionAvanceVO> listVO=toListValorizacionInversionAvanceVO(list);
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
    public String update(ValorizacionInversionAvanceVO valorizacionInversionAvanceVO) throws ParseException,
                                                                                             SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public ValorizacionInversionAvanceVO get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
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
       valorizacionInversionAvanceVO1.setTiaPlazoEnDías(valorizacionInversionAvance1.getTiaPlazoEnDías());
       valorizacionInversionAvanceVO1.setTinId(valorizacionInversionAvance1.getTinId());
       
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
        valorizacionInversionAvance1.setTiaPlazoEnDías(valorizacionInversionAvanceVO1.getTiaPlazoEnDías());
        valorizacionInversionAvance1.setTinId(valorizacionInversionAvanceVO1.getTinId());
       
       return valorizacionInversionAvance1;
    }
}
