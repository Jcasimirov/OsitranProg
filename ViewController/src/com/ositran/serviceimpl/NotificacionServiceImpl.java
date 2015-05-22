package com.ositran.serviceimpl;

import com.ositran.daoimpl.NotificacionDAOImpl;
import com.ositran.model.Inv;
import com.ositran.model.InvAvn;
import com.ositran.model.InvReajuste;
import com.ositran.model.InvReconocimiento;
import com.ositran.model.ValorizacionNotificacion;
import com.ositran.service.NotificacionService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.InvAvnVO;
import com.ositran.vo.bean.InvReajusteVO;
import com.ositran.vo.bean.InvReconocimientoVO;
import com.ositran.vo.bean.InvVO;
import com.ositran.vo.bean.ValorizacionNotificacionVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class NotificacionServiceImpl implements NotificacionService{
    private NotificacionDAOImpl notificacionDAOImpl;
    private InvReajusteServiceImpl invReajusteServiceImpl;
    private InvReconocimientoServiceImpl invReconocimientoServiceImpl;
    private InvServiceImpl invServiceImpl;

    public void setNotificacionDAOImpl(NotificacionDAOImpl notificacionDAOImpl) {
        this.notificacionDAOImpl = notificacionDAOImpl;
    }

    public NotificacionDAOImpl getNotificacionDAOImpl() {
        return notificacionDAOImpl;
    }


    public NotificacionServiceImpl() {
        super();
    }

    @Override
    public List<InvAvnVO> ListarDeclaraciones() throws SQLException{
        List<InvAvn> list=notificacionDAOImpl.ListarDeclaraciones();
        List<InvAvnVO> listVO=toListInvAvnVO(list);
        return listVO;
    }
    
    
    public String NotificarInversion(InvAvnVO invAvnVO, ValorizacionNotificacionVO valorizacionNotificacionVO) throws SQLException{
        ValorizacionNotificacion valorizacionNotificacion=toValorizacionNotificacion(valorizacionNotificacionVO);
        InvAvn invAvn=toInvAvn(invAvnVO);
        String result=this.notificacionDAOImpl.NotificarInversion(invAvn, valorizacionNotificacion);
        return result;
    }
     
    //conversiones
    private List<ValorizacionNotificacionVO> toListValorizacionNotificacionVO(List<ValorizacionNotificacion> list){
        List<ValorizacionNotificacionVO> listVO=new ArrayList<ValorizacionNotificacionVO>();
        for(int i=0;i<list.size();i++){
            ValorizacionNotificacion valorizacionNotificacion=(ValorizacionNotificacion)list.get(i);
            ValorizacionNotificacionVO valorizacionNotificacionVO=toValorizacionNotificacionVO(valorizacionNotificacion);
            listVO.add(valorizacionNotificacionVO);
        }
        return listVO;
    }
    
    
    
    private ValorizacionNotificacionVO toValorizacionNotificacionVO(ValorizacionNotificacion valorizacionNotificacion){
        ValorizacionNotificacionVO valorizacionNotificacionVO=new ValorizacionNotificacionVO();
        
        valorizacionNotificacionVO.setItrId(valorizacionNotificacion.getItrId());
        valorizacionNotificacionVO.setMonId(valorizacionNotificacion.getMonId());
        valorizacionNotificacionVO.setTiaNumero(valorizacionNotificacion.getTiaNumero());
        valorizacionNotificacionVO.setTinId(valorizacionNotificacion.getTinId());
        valorizacionNotificacionVO.setVanAnyoHr(valorizacionNotificacion.getVanAnyoHr());
        valorizacionNotificacionVO.setVanArchivoCargo(valorizacionNotificacion.getVanArchivoCargo());
        valorizacionNotificacionVO.setVanArchivoInversion(valorizacionNotificacion.getVanArchivoInversion());
        valorizacionNotificacionVO.setVanEstado(valorizacionNotificacion.getVanEstado());
        valorizacionNotificacionVO.setVanFechaAlta(valorizacionNotificacion.getVanFechaAlta());
        valorizacionNotificacionVO.setVanFechaBaja(valorizacionNotificacion.getVanFechaBaja());
        valorizacionNotificacionVO.setVanFechaCambio(valorizacionNotificacion.getVanFechaCambio());
        valorizacionNotificacionVO.setVanFechaNotificacion(valorizacionNotificacion.getVanFechaNotificacion());
        valorizacionNotificacionVO.setVanFechaRegistro(valorizacionNotificacion.getVanFechaRegistro());
        valorizacionNotificacionVO.setVanId(valorizacionNotificacion.getVanId());
        valorizacionNotificacionVO.setVanNroCargo(valorizacionNotificacion.getVanNroCargo());
        valorizacionNotificacionVO.setVanNroHr(valorizacionNotificacion.getVanNroHr());
        valorizacionNotificacionVO.setVanTerminal(valorizacionNotificacion.getVanTerminal());
        valorizacionNotificacionVO.setVanTotalPresentado(valorizacionNotificacion.getVanTotalPresentado());
        valorizacionNotificacionVO.setVanTotalReconocido(valorizacionNotificacion.getVanTotalReconocido());
        valorizacionNotificacionVO.setVanUsuarioAlta(valorizacionNotificacion.getVanUsuarioAlta());
        valorizacionNotificacionVO.setVanUsuarioBaja(valorizacionNotificacion.getVanUsuarioBaja());
        valorizacionNotificacionVO.setVanUsuarioCambio(valorizacionNotificacion.getVanUsuarioCambio());
        
        
        return valorizacionNotificacionVO;
    }
    private ValorizacionNotificacion toValorizacionNotificacion(ValorizacionNotificacionVO valorizacionNotificacionVO){
        ValorizacionNotificacion valorizacionNotificacion=new ValorizacionNotificacion();
        
        valorizacionNotificacion.setItrId(valorizacionNotificacionVO.getItrId());
        valorizacionNotificacion.setMonId(valorizacionNotificacionVO.getMonId());
        valorizacionNotificacion.setTiaNumero(valorizacionNotificacionVO.getTiaNumero());
        valorizacionNotificacion.setTinId(valorizacionNotificacionVO.getTinId());
        valorizacionNotificacion.setVanAnyoHr(valorizacionNotificacionVO.getVanAnyoHr());
        valorizacionNotificacion.setVanArchivoCargo(valorizacionNotificacionVO.getVanArchivoCargo());
        valorizacionNotificacion.setVanArchivoInversion(valorizacionNotificacionVO.getVanArchivoInversion());
        valorizacionNotificacion.setVanEstado(valorizacionNotificacionVO.getVanEstado());
        valorizacionNotificacion.setVanFechaAlta(valorizacionNotificacionVO.getVanFechaAlta());
        valorizacionNotificacion.setVanFechaBaja(valorizacionNotificacionVO.getVanFechaBaja());
        valorizacionNotificacion.setVanFechaCambio(valorizacionNotificacionVO.getVanFechaCambio());
        valorizacionNotificacion.setVanFechaNotificacion(valorizacionNotificacionVO.getVanFechaNotificacion());
        valorizacionNotificacion.setVanFechaRegistro(valorizacionNotificacionVO.getVanFechaRegistro());
        valorizacionNotificacion.setVanId(valorizacionNotificacionVO.getVanId());
        valorizacionNotificacion.setVanNroCargo(valorizacionNotificacionVO.getVanNroCargo());
        valorizacionNotificacion.setVanNroHr(valorizacionNotificacionVO.getVanNroHr());
        valorizacionNotificacion.setVanTerminal(valorizacionNotificacionVO.getVanTerminal());
        valorizacionNotificacion.setVanTotalPresentado(valorizacionNotificacionVO.getVanTotalPresentado());
        valorizacionNotificacion.setVanTotalReconocido(valorizacionNotificacionVO.getVanTotalReconocido());
        valorizacionNotificacion.setVanUsuarioAlta(valorizacionNotificacionVO.getVanUsuarioAlta());
        valorizacionNotificacion.setVanUsuarioBaja(valorizacionNotificacionVO.getVanUsuarioBaja());
        valorizacionNotificacion.setVanUsuarioCambio(valorizacionNotificacionVO.getVanUsuarioCambio());
        
        return valorizacionNotificacion;
        
    }
    
    private List<InvAvnVO> toListInvAvnVO(List<InvAvn> list){
            List<InvAvnVO> listVO=new ArrayList<InvAvnVO>();
            for(int i=0;i<list.size();i++){
                InvAvn invAvn=(InvAvn)list.get(i);
                InvAvnVO invAvnVO=toInvAvnVO(invAvn);
                listVO.add(invAvnVO);
            }
            return listVO;
        }
        
        
        
        private InvAvnVO toInvAvnVO(InvAvn invAvn){
            InvAvnVO invAvnVO=new InvAvnVO();
            
            invAvnVO.setConId(invAvn.getConId());
            invAvnVO.setCsiId(invAvn.getCsiId());
            invAvnVO.setIaeId(invAvn.getIaeId());
            invAvnVO.setInvId(invAvn.getInvId());
            invAvnVO.setMcoId(invAvn.getMcoId());
            invAvnVO.setMonId(invAvn.getMonId());
            invAvnVO.setTiaAnyo(invAvn.getTiaAnyo());
            invAvnVO.setTiaAsunto(invAvn.getTiaAsunto());
            invAvnVO.setTiaDiasHabiles(invAvn.getTiaDiasHabiles());
            invAvnVO.setTiaFechaFin(invAvn.getTiaFechaFin());
            invAvnVO.setTiaFechaInicio(invAvn.getTiaFechaInicio());
            invAvnVO.setTiaFechaRegistro(invAvn.getTiaFechaRegistro());
            invAvnVO.setTiaFechaRegistroDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(invAvn.getTiaFechaRegistro()));
            invAvnVO.setTiaFechaVencimientoPlazo(invAvn.getTiaFechaVencimientoPlazo());
            invAvnVO.setTiaHr(invAvn.getTiaHr());
            invAvnVO.setTiaMontoTotalAprobado(invAvn.getTiaMontoTotalAprobado());
            invAvnVO.setTiaMontoTotalPresentado(invAvn.getTiaMontoTotalPresentado());
            invAvnVO.setTiaMontoTotalReajustado(invAvn.getTiaMontoTotalReajustado());
            invAvnVO.setTiaNumero(invAvn.getTiaNumero());
            invAvnVO.setTiaPlazoEnDías(invAvn.getTiaPlazoEnDías());
            invAvnVO.setTinId(invAvn.getTinId());
            invAvnVO.setTiaAprobadoPor(invAvn.getTiaAprobadoPor());
            invAvnVO.setTiaRutaNot(invAvn.getTiaRutaNot());
            invAvnVO.setCcoId(invAvn.getCcoId());
            invAvnVO.setTiaObservaciones(invAvn.getTiaObservaciones());
            invAvnVO.setTiaIgv(invAvn.getTiaIgv());
            invAvnVO.setTiaIgvMonto(invAvn.getTiaIgvMonto());
            return invAvnVO;
        }
        public InvAvn toInvAvn(InvAvnVO invAvnVO){
            InvAvn invAvn=new InvAvn();            
            invAvn.setConId(invAvnVO.getConId());
            invAvn.setCcoId(invAvnVO.getCcoId());
            invAvn.setCsiId(invAvnVO.getCsiId());
            invAvn.setIaeId(invAvnVO.getIaeId());
            invAvn.setInvId(invAvnVO.getInvId());
            invAvn.setMcoId(invAvnVO.getMcoId());
            invAvn.setMonId(invAvnVO.getMonId());
            invAvn.setTiaAnyo(invAvnVO.getTiaAnyo());
            invAvn.setTiaAsunto(invAvnVO.getTiaAsunto());
            invAvn.setTiaDiasHabiles(invAvnVO.getTiaDiasHabiles());
            invAvn.setTiaFechaFin(invAvnVO.getTiaFechaFin());
            invAvn.setTiaFechaInicio(invAvnVO.getTiaFechaInicio());
            invAvn.setTiaFechaRegistro(invAvnVO.getTiaFechaRegistro());
            invAvn.setTiaFechaVencimientoPlazo(invAvnVO.getTiaFechaVencimientoPlazo());
            invAvn.setTiaHr(invAvnVO.getTiaHr());
            invAvn.setTiaMontoTotalAprobado(invAvnVO.getTiaMontoTotalAprobado());
            invAvn.setTiaMontoTotalPresentado(invAvnVO.getTiaMontoTotalPresentado());
            invAvn.setTiaMontoTotalReajustado(invAvnVO.getTiaMontoTotalReajustado());
            invAvn.setTiaNumero(invAvnVO.getTiaNumero());
            invAvn.setTiaPlazoEnDías(invAvnVO.getTiaPlazoEnDías());
            invAvn.setTinId(invAvnVO.getTinId());
            invAvn.setTiaAprobadoPor(invAvnVO.getTiaAprobadoPor());
            invAvn.setTiaRutaNot(invAvnVO.getTiaRutaNot());
            invAvn.setTiaObservaciones(invAvnVO.getTiaObservaciones());
            invAvn.setTiaIgv(invAvnVO.getTiaIgv());
            invAvn.setTiaIgvMonto(invAvnVO.getTiaIgvMonto());
            return invAvn;
            
        }

        
        public List<InvAvnVO> ListarDeclaracionesSupervContratoCompromiso(int contratoCompromisoId) throws SQLException{
            System.out.println("INI NotificacionServiceImpl.ListarDeclaracionesSupervContratoCompromiso");
            List<InvAvn> list=notificacionDAOImpl.ListarDeclaracionesSupervContratoCompromiso(contratoCompromisoId);
            List<InvAvnVO> listVO=toListInvAvnVO(list);
            System.out.println("INI NotificacionServiceImpl.ListarDeclaracionesSupervContratoCompromiso");
            return listVO;
            
        }

    public List<InvAvnVO> obtenerDeclaracionesxIdContrato(int idcontrato) throws SQLException{
        List<InvAvn> list=notificacionDAOImpl.obtenerDeclaracionesxIdContrato(idcontrato);
        List<InvAvnVO> listVO=toListInvAvnVO(list);
        return listVO;
    }


    @Override
    public void updateRectificacion(InvAvnVO invAvnvo,List<InvReconocimientoVO> reconocimientoVO,List<InvReajusteVO> reajusteVO,InvVO invVO)throws Exception {
     InvAvn invAvn=toInvAvn(invAvnvo);
     List<InvReajuste> invReajuste=invReajusteServiceImpl.toListInvReajuste(reajusteVO);
     List<InvReconocimiento> reconocimiento=invReconocimientoServiceImpl.toListInvReconocimiento(reconocimientoVO);
     Inv inv=invServiceImpl.toInv(invVO);
     notificacionDAOImpl.updateRectificacion(invAvn,reconocimiento,invReajuste,inv);
    }
  

    public void setInvReajusteServiceImpl(InvReajusteServiceImpl invReajusteServiceImpl) {
        this.invReajusteServiceImpl = invReajusteServiceImpl;
    }

    public InvReajusteServiceImpl getInvReajusteServiceImpl() {
        return invReajusteServiceImpl;
    }

    public void setInvReconocimientoServiceImpl(InvReconocimientoServiceImpl invReconocimientoServiceImpl) {
        this.invReconocimientoServiceImpl = invReconocimientoServiceImpl;
    }

    public InvReconocimientoServiceImpl getInvReconocimientoServiceImpl() {
        return invReconocimientoServiceImpl;
    }

    public void setInvServiceImpl(InvServiceImpl invServiceImpl) {
        this.invServiceImpl = invServiceImpl;
    }

    public InvServiceImpl getInvServiceImpl() {
        return invServiceImpl;
    }


}
