package com.ositran.serviceimpl;

import com.ositran.dao.InvAvnSupervisadaDetalleDAO;
import com.ositran.daoimpl.InvAvnSupervisadaDetalleDAOImpl;
import com.ositran.model.InvAvnSupervisadaDetalle;
import com.ositran.service.InvAvnSupervisadaDetalleService;
import com.ositran.vo.bean.InvAvnSupervisadaDetalleVO;

import java.sql.SQLException;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvAvnSupervisadaDetalleServiceImpl implements InvAvnSupervisadaDetalleService{
    public InvAvnSupervisadaDetalleServiceImpl() {
        super();
    }
    InvAvnSupervisadaDetalle invAvnSupervisadaDetalle=new InvAvnSupervisadaDetalle();
    InvAvnSupervisadaDetalleVO invAvnSupervisadaDetalleVO=new InvAvnSupervisadaDetalleVO();
    InvAvnSupervisadaDetalleDAO invAvnSupervisadaDetalleDAOImpl=new InvAvnSupervisadaDetalleDAOImpl();
    @Override
    public List<InvAvnSupervisadaDetalle> query() throws SQLException, Exception {
        return Collections.emptyList();
    }

    @Override
    public int insert(InvAvnSupervisadaDetalleVO invAvnSupervisadaDetalleVO) throws SQLException, Exception {
        int codigoSupervisadaCabecera=0;
        invAvnSupervisadaDetalle=toInvAvnSupervisadaDetalle(invAvnSupervisadaDetalleVO);
        codigoSupervisadaCabecera=invAvnSupervisadaDetalleDAOImpl.insert(invAvnSupervisadaDetalle);
        return codigoSupervisadaCabecera; 
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(InvAvnSupervisadaDetalle invAvnSupervisadaDetalle) throws ParseException, SQLException,
                                                                                   Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public InvAvnSupervisadaDetalle get(Integer id) throws SQLException, Exception {
        return null;
    }
    
    //conversiones
    private List<InvAvnSupervisadaDetalleVO> toListInvAvnSupervisadaDetalleVO(List<InvAvnSupervisadaDetalle> list)  {
       List<InvAvnSupervisadaDetalleVO> listVO=new ArrayList<InvAvnSupervisadaDetalleVO>();
       for(int i=0;i<list.size();i++){
           invAvnSupervisadaDetalle=(InvAvnSupervisadaDetalle)list.get(i);
           invAvnSupervisadaDetalleVO=toInvAvnSupervisadaDetalleVO(invAvnSupervisadaDetalle);
           listVO.add(invAvnSupervisadaDetalleVO);
       }
       return listVO;
    }
    private InvAvnSupervisadaDetalleVO toInvAvnSupervisadaDetalleVO(InvAvnSupervisadaDetalle invAvnSupervisadaDetalle1)  {
       InvAvnSupervisadaDetalleVO invAvnSupervisadaDetalleVO1=new InvAvnSupervisadaDetalleVO();
       invAvnSupervisadaDetalleVO1.setAsdEstado(invAvnSupervisadaDetalle1.getAsdEstado());
       invAvnSupervisadaDetalleVO1.setAsdFechaRegistro(invAvnSupervisadaDetalle1.getAsdFechaRegistro());
       invAvnSupervisadaDetalleVO1.setAsdId(invAvnSupervisadaDetalle1.getAsdId());
       invAvnSupervisadaDetalleVO1.setIasNumero(invAvnSupervisadaDetalle1.getIasNumero());
       invAvnSupervisadaDetalleVO1.setIsdIgv(invAvnSupervisadaDetalle1.getIsdIgv());
       invAvnSupervisadaDetalleVO1.setIsdMontoPresentado(invAvnSupervisadaDetalle1.getIsdMontoPresentado());
       invAvnSupervisadaDetalleVO1.setMonId(invAvnSupervisadaDetalle1.getMonId());
       invAvnSupervisadaDetalleVO1.setTiaTotal(invAvnSupervisadaDetalle1.getTiaTotal());
       invAvnSupervisadaDetalleVO1.setIasMontoRevisado(invAvnSupervisadaDetalle1.getIasMontoRevisado());    
       return invAvnSupervisadaDetalleVO1;
    }
    private InvAvnSupervisadaDetalle toInvAvnSupervisadaDetalle(InvAvnSupervisadaDetalleVO invAvnSupervisadaDetalleVO1)  {
       InvAvnSupervisadaDetalle invAvnSupervisadaDetalle1=new InvAvnSupervisadaDetalle();
        invAvnSupervisadaDetalle1.setAsdEstado(invAvnSupervisadaDetalleVO1.getAsdEstado());
        invAvnSupervisadaDetalle1.setAsdFechaRegistro(invAvnSupervisadaDetalleVO1.getAsdFechaRegistro());
        invAvnSupervisadaDetalle1.setAsdId(invAvnSupervisadaDetalleVO1.getAsdId());
        invAvnSupervisadaDetalle1.setIasNumero(invAvnSupervisadaDetalleVO1.getIasNumero());
        invAvnSupervisadaDetalle1.setIsdIgv(invAvnSupervisadaDetalleVO1.getIsdIgv());
        invAvnSupervisadaDetalle1.setIsdMontoPresentado(invAvnSupervisadaDetalleVO1.getIsdMontoPresentado());
        invAvnSupervisadaDetalle1.setMonId(invAvnSupervisadaDetalleVO1.getMonId());
        invAvnSupervisadaDetalle1.setTiaTotal(invAvnSupervisadaDetalleVO1.getTiaTotal());
       invAvnSupervisadaDetalle1.setIasMontoRevisado(invAvnSupervisadaDetalleVO1.getIasMontoRevisado());
       return invAvnSupervisadaDetalle1;
    }


    public void setInvAvnSupervisadaDetalle(InvAvnSupervisadaDetalle invAvnSupervisadaDetalle) {
        this.invAvnSupervisadaDetalle = invAvnSupervisadaDetalle;
    }

    public InvAvnSupervisadaDetalle getInvAvnSupervisadaDetalle() {
        return invAvnSupervisadaDetalle;
    }

    public void setInvAvnSupervisadaDetalleVO(InvAvnSupervisadaDetalleVO invAvnSupervisadaDetalleVO) {
        this.invAvnSupervisadaDetalleVO = invAvnSupervisadaDetalleVO;
    }

    public InvAvnSupervisadaDetalleVO getInvAvnSupervisadaDetalleVO() {
        return invAvnSupervisadaDetalleVO;
    }

    public void setInvAvnSupervisadaDetalleDAOImpl(InvAvnSupervisadaDetalleDAO invAvnSupervisadaDetalleDAOImpl) {
        this.invAvnSupervisadaDetalleDAOImpl = invAvnSupervisadaDetalleDAOImpl;
    }

    public InvAvnSupervisadaDetalleDAO getInvAvnSupervisadaDetalleDAOImpl() {
        return invAvnSupervisadaDetalleDAOImpl;
    }

}
