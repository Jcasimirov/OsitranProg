package com.ositran.serviceimpl;

import com.ositran.daoimpl.InvDAOImpl;
import com.ositran.model.Inv;
import com.ositran.model.InvAvn;
import com.ositran.model.InvReajuste;
import com.ositran.model.InvReconocimiento;
import com.ositran.service.InvService;
import com.ositran.vo.bean.InvAvnVO;
import com.ositran.vo.bean.InvReajusteVO;
import com.ositran.vo.bean.InvReconocimientoVO;
import com.ositran.vo.bean.InvVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class InvServiceImpl implements InvService {
    private InvDAOImpl invDAOImpl;
    private NotificacionServiceImpl notificacionServiceImpl;
    private InvReconocimientoServiceImpl invReconocimientoServiceImpl;
    private InvReajusteServiceImpl invReajusteServiceImpl;
    
    public InvServiceImpl() {
        super();
    }

    @Override
    public List<InvVO> query() throws SQLException {
        List<Inv> list = invDAOImpl.query();
        List<InvVO> listVO=toListInvVO(list);
        return listVO;
    }

    @Override
    public String insert(InvVO invVO) throws SQLException {
        Inv inv=toInv(invVO);
        String result = invDAOImpl.insert(inv);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = invDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(InvVO invVO) throws SQLException {
        Inv inv=toInv(invVO);
        String result = invDAOImpl.update(inv);
        return result;
    }

    @Override
    public InvVO get(Integer tiaNumero) throws SQLException {
        Inv inv= invDAOImpl.get(tiaNumero);
        InvVO invVO=toInvVO(inv);
        return invVO;
    }
    
    // conversiones
    private List<InvVO> toListInvVO(List<Inv> list){
        List<InvVO> listVO=new ArrayList<InvVO>();
        for(int i=0;i<list.size();i++){
            Inv inv=(Inv)list.get(i);
            InvVO invVO=toInvVO(inv);
            listVO.add(invVO);
        }
        return listVO;
    }
    
    private InvVO toInvVO(Inv inv){
        InvVO invVO=new InvVO();
        
        invVO.setInvEstado(inv.getInvEstado());
        invVO.setInvEstadoReconocimiento(inv.getInvEstadoReconocimiento());
        invVO.setInvFechaEmisionInforme(inv.getInvFechaEmisionInforme());
        invVO.setInvFechaEmisionOficio(inv.getInvFechaEmisionOficio());
        invVO.setInvId(inv.getInvId());
        invVO.setInvMontoTipoCambio(inv.getInvMontoTipoCambio());
        invVO.setInvMontoTotalAprobado(inv.getInvMontoTotalAprobado());
        invVO.setInvMontoTotalReajuste(inv.getInvMontoTotalReajuste());
        invVO.setInvNota(inv.getInvNota());
        invVO.setInvNumeroInforme(inv.getInvNumeroInforme());
        invVO.setInvNumeroOficio(inv.getInvNumeroOficio());
        invVO.setInvObservaciones(inv.getInvObservaciones());
        invVO.setInvRegSalidaInforme(inv.getInvRegSalidaInforme());
        invVO.setInvRegSalidaOficio(inv.getInvRegSalidaOficio());
        invVO.setMonId(inv.getMonId());
        invVO.setTiaNumero(inv.getTiaNumero());
        invVO.setInvNroDocFormalizacion(inv.getInvNroDocFormalizacion());
        invVO.setInvFechaEmisionDocFomalizacion(inv.getInvFechaEmisionDocFomalizacion());
        invVO.setInvIgv(inv.getInvIgv());
        return invVO;
    }
    
    public Inv toInv(InvVO invVO){
        Inv inv=new Inv();        
            
        inv.setInvEstado(invVO.getInvEstado());
        inv.setInvEstadoReconocimiento(invVO.getInvEstadoReconocimiento());
        inv.setInvFechaEmisionInforme(invVO.getInvFechaEmisionInforme());
        inv.setInvFechaEmisionOficio(invVO.getInvFechaEmisionOficio());
        inv.setInvId(invVO.getInvId());
        inv.setInvMontoTipoCambio(invVO.getInvMontoTipoCambio());
        inv.setInvMontoTotalAprobado(invVO.getInvMontoTotalAprobado());
        inv.setInvMontoTotalReajuste(invVO.getInvMontoTotalReajuste());
        inv.setInvNota(invVO.getInvNota());
        inv.setInvNumeroInforme(invVO.getInvNumeroInforme());
        inv.setInvNumeroOficio(invVO.getInvNumeroOficio());
        inv.setInvObservaciones(invVO.getInvObservaciones());
        inv.setInvRegSalidaInforme(invVO.getInvRegSalidaInforme());
        inv.setInvRegSalidaOficio(invVO.getInvRegSalidaOficio());
        inv.setMonId(invVO.getMonId());
        inv.setTiaNumero(invVO.getTiaNumero());
        inv.setInvNroDocFormalizacion(invVO.getInvNroDocFormalizacion());
        inv.setInvFechaEmisionDocFomalizacion(invVO.getInvFechaEmisionDocFomalizacion());
        inv.setInvIgv(invVO.getInvIgv());
        return inv;
        
    }
    
    private List<Inv> toListInv(List<InvVO> listVO){
        List<Inv> list=new ArrayList<Inv>();
        for(int i=0;i<listVO.size();i++){
            InvVO invVO=(InvVO)listVO.get(i);
            Inv inv=toInv(invVO);
            list.add(inv);
        }
        return list;
    }

    public InvDAOImpl getInvDAOImpl() {
        return invDAOImpl;
    }

    public void setInvDAOImpl(InvDAOImpl invDAOImpl) {
        this.invDAOImpl = invDAOImpl;
    }
    
    @Override    
    public List<InvVO> getInvsAvance(Integer ConId) throws SQLException{
        List<Inv> list = invDAOImpl.getInvsAvance(ConId);
        List<InvVO> listVO=toListInvVO(list);
        return listVO;
    }
    @Override    
    public String insertDeclaracion(InvAvnVO invAvnVO,InvVO invVO, List<InvReconocimientoVO> listInvReconocimientoVO,List<InvReajusteVO> listInvReajusteVO) throws SQLException{
        Inv inv = toInv(invVO);
        List<InvReconocimiento> listInvReconocimiento = invReconocimientoServiceImpl.toListInvReconocimiento(listInvReconocimientoVO);
        List<InvReajuste> listInvReajuste = invReajusteServiceImpl.toListInvReajuste(listInvReajusteVO);
        System.out.println("invAvnVO.getIaeId();"+invAvnVO.getIaeId());
        InvAvn invAvn= notificacionServiceImpl.toInvAvn(invAvnVO);
        String result = invDAOImpl.insertDeclaracion(invAvn,inv,listInvReconocimiento, listInvReajuste);
        return result;
    }
    public InvVO obtenerInversion(Integer invId, Integer tiaNumero) throws SQLException{
        Inv inv = invDAOImpl.obtenerInversion(invId, tiaNumero);
        InvVO invVO=toInvVO(inv);
        return invVO;
    }
    public InvReconocimientoServiceImpl getInvReconocimientoServiceImpl() {
        return invReconocimientoServiceImpl;
    }

    public void setInvReconocimientoServiceImpl(InvReconocimientoServiceImpl invReconocimientoServiceImpl) {
        this.invReconocimientoServiceImpl = invReconocimientoServiceImpl;
    }

    public InvReajusteServiceImpl getInvReajusteServiceImpl() {
        return invReajusteServiceImpl;
    }

    public void setInvReajusteServiceImpl(InvReajusteServiceImpl invReajusteServiceImpl) {
        this.invReajusteServiceImpl = invReajusteServiceImpl;
    }

    public void setNotificacionServiceImpl(NotificacionServiceImpl notificacionServiceImpl) {
        this.notificacionServiceImpl = notificacionServiceImpl;
    }

    public NotificacionServiceImpl getNotificacionServiceImpl() {
        return notificacionServiceImpl;
    }
}
