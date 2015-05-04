package com.ositran.serviceimpl;

import com.ositran.dao.InvAvnSupervisadaDAO;
import com.ositran.daoimpl.InvAvnSupervisadaDAOImpl;
import com.ositran.model.InvAvnSupervisada;
import com.ositran.model.Inversion;
import com.ositran.service.InvAvnSupervisadaService;
import com.ositran.vo.bean.InvAvnSupervisadaVO;
import com.ositran.vo.bean.InversionVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvAvnSupervisadaServiceImpl implements InvAvnSupervisadaService{
    InvAvnSupervisada invAvnSupervisada=new InvAvnSupervisada();
    InvAvnSupervisadaVO invAvnSupervisadaVO=new InvAvnSupervisadaVO();
    InvAvnSupervisadaDAO invAvnSupervisadaDAOImpl=new InvAvnSupervisadaDAOImpl();
    
    public InvAvnSupervisadaServiceImpl() {
        super();
    }


    @Override
    public List<InvAvnSupervisadaVO> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public int insert(InvAvnSupervisadaVO invAvnSupervisadaVO) throws SQLException, Exception {
        int codigoCabecera=0;
        invAvnSupervisada=toInvAvnSupervisada(invAvnSupervisadaVO);
        codigoCabecera=invAvnSupervisadaDAOImpl.insert(invAvnSupervisada);
        return codigoCabecera; 
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(InvAvnSupervisadaVO invAvnSupervisadaVO) throws ParseException, SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public TipoInversionVO get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
    
    //conversiones
    private List<InvAvnSupervisadaVO> toInvAvnSupervisadaVO(List<InvAvnSupervisada> list){
        List<InvAvnSupervisadaVO> listVO=new ArrayList<InvAvnSupervisadaVO>();
        for(int i=0;i<list.size();i++){
            invAvnSupervisada=(InvAvnSupervisada)list.get(i);
            invAvnSupervisadaVO=toInvAvnSupervisadaVO(invAvnSupervisada);
            listVO.add(invAvnSupervisadaVO);
        }
        return listVO;
    }
    private InvAvnSupervisadaVO toInvAvnSupervisadaVO(InvAvnSupervisada invAvnSupervisada1){
        InvAvnSupervisadaVO invAvnSupervisadaVO1=new InvAvnSupervisadaVO();
        invAvnSupervisadaVO1.setCsiId(invAvnSupervisada1.getCsiId());
        invAvnSupervisadaVO1.setIasAnyo(invAvnSupervisada1.getIasAnyo());
        invAvnSupervisadaVO1.setIasAsunto(invAvnSupervisada1.getIasAsunto());
        invAvnSupervisadaVO1.setIasFechaEmision(invAvnSupervisada1.getIasFechaEmision());
        invAvnSupervisadaVO1.setIasFechaRecepcion(invAvnSupervisada1.getIasFechaRecepcion());
        invAvnSupervisadaVO1.setIasFechaRegistro(invAvnSupervisada1.getIasFechaRegistro());
        invAvnSupervisadaVO1.setIasFechaRespuesta(invAvnSupervisada1.getIasFechaRespuesta());
        invAvnSupervisadaVO1.setIasHr(invAvnSupervisada1.getIasHr());
        invAvnSupervisadaVO1.setIasNroCarta(invAvnSupervisada1.getIasNroCarta());
        invAvnSupervisadaVO1.setIasNroOficio(invAvnSupervisada1.getIasNroOficio());
        invAvnSupervisadaVO1.setIasNumero(invAvnSupervisada1.getIasNumero());
        invAvnSupervisadaVO1.setIasObservaciones(invAvnSupervisada1.getIasObservaciones());
        invAvnSupervisadaVO1.setIasPlazoDias(invAvnSupervisada1.getIasPlazoDias());
        invAvnSupervisadaVO1.setIasRegSalida(invAvnSupervisada1.getIasRegSalida());
        invAvnSupervisadaVO1.setInvId(invAvnSupervisada1.getInvId());
        invAvnSupervisadaVO1.setTinId(invAvnSupervisada1.getTinId());
        invAvnSupervisadaVO1.setTiaNumero(invAvnSupervisada1.getTiaNumero());
        

        return invAvnSupervisadaVO1;
    }
    private InvAvnSupervisada toInvAvnSupervisada(InvAvnSupervisadaVO invAvnSupervisadaVO1){
        InvAvnSupervisada invAvnSupervisada1=new InvAvnSupervisada();
        
        invAvnSupervisada1.setCsiId(invAvnSupervisadaVO1.getCsiId());
        invAvnSupervisada1.setIasAnyo(invAvnSupervisadaVO1.getIasAnyo());
        invAvnSupervisada1.setIasAsunto(invAvnSupervisadaVO1.getIasAsunto());
        invAvnSupervisada1.setIasFechaEmision(invAvnSupervisadaVO1.getIasFechaEmision());
        invAvnSupervisada1.setIasFechaRecepcion(invAvnSupervisadaVO1.getIasFechaRecepcion());
        invAvnSupervisada1.setIasFechaRegistro(invAvnSupervisadaVO1.getIasFechaRegistro());
        invAvnSupervisada1.setIasFechaRespuesta(invAvnSupervisadaVO1.getIasFechaRespuesta());
        invAvnSupervisada1.setIasHr(invAvnSupervisadaVO1.getIasHr());
        invAvnSupervisada1.setIasNroCarta(invAvnSupervisadaVO1.getIasNroCarta());
        invAvnSupervisada1.setIasNroOficio(invAvnSupervisadaVO1.getIasNroOficio());
        invAvnSupervisada1.setIasNumero(invAvnSupervisadaVO1.getIasNumero());
        invAvnSupervisada1.setIasObservaciones(invAvnSupervisadaVO1.getIasObservaciones());
        invAvnSupervisada1.setIasPlazoDias(invAvnSupervisadaVO1.getIasPlazoDias());
        invAvnSupervisada1.setIasRegSalida(invAvnSupervisadaVO1.getIasRegSalida());
        invAvnSupervisada1.setInvId(invAvnSupervisadaVO1.getInvId());
        invAvnSupervisada1.setTinId(invAvnSupervisadaVO1.getTinId());
        invAvnSupervisada1.setTiaNumero(invAvnSupervisadaVO1.getTiaNumero());
        
        return invAvnSupervisada1;
        
    }
    
}
