package com.ositran.serviceimpl;

import com.ositran.dao.InvAvnDerivadaDAO;
import com.ositran.daoimpl.InvAvnDerivadaDAOImpl;
import com.ositran.model.InvAvnDerivada;
import com.ositran.service.InvAvnDerivadaService;
import com.ositran.vo.bean.InvAvnDerivadaVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvAvnDerivadaServiceImpl implements InvAvnDerivadaService{
    
    InvAvnDerivada invAvnDerivada=new InvAvnDerivada();
    InvAvnDerivadaVO invAvnDerivadaVO=new InvAvnDerivadaVO();
    InvAvnDerivadaDAO invAvnDerivadaDAOImpl=new InvAvnDerivadaDAOImpl();
    
    public InvAvnDerivadaServiceImpl() {
        super();
    }

    @Override
    public List<InvAvnDerivadaVO> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(InvAvnDerivadaVO invAvnDerivadaVO) throws SQLException, Exception {
        invAvnDerivada=toInvAvnDerivada(invAvnDerivadaVO);
        String result=invAvnDerivadaDAOImpl.insert(invAvnDerivada);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
    

    @Override
    public InvAvnDerivadaVO getAvanceInversion(int id) throws SQLException, Exception {
        invAvnDerivada =invAvnDerivadaDAOImpl.getAvanceInversion(id);
        
        System.out.println(id);
        
        invAvnDerivadaVO=toInvAvnDerivadaVO(invAvnDerivada);
        return invAvnDerivadaVO;
    }

    @Override
    public String update(InvAvnDerivadaVO invAvnDerivadaVO) throws ParseException, SQLException, Exception {
         invAvnDerivada=toInvAvnDerivada(invAvnDerivadaVO);
        String result=this.invAvnDerivadaDAOImpl.update(invAvnDerivada);
        return result;
    }

    @Override
    public InvAvnDerivadaVO get(Integer id) throws SQLException, Exception {
        invAvnDerivada =invAvnDerivadaDAOImpl.get(id);
        invAvnDerivadaVO=toInvAvnDerivadaVO(invAvnDerivada);
        return invAvnDerivadaVO;
    }
    
    @Override
    public InvAvnDerivadaVO get1(Integer id) throws SQLException, Exception {
        System.out.println("LLEGO ACA");
        invAvnDerivada =invAvnDerivadaDAOImpl.get1(id);
        System.out.println("LLEGO ACAAAAAAAAAAAAA");
        System.out.println(invAvnDerivada.getIadTipoSup() );
        invAvnDerivadaVO=toInvAvnDerivadaVO(invAvnDerivada);
        return invAvnDerivadaVO;
    }
    
    //conversiones
    private List<InvAvnDerivadaVO> toListInvAvnDerivadaVO(List<InvAvnDerivada> list)  {
       List<InvAvnDerivadaVO> listVO=new ArrayList<InvAvnDerivadaVO>();
       for(int i=0;i<list.size();i++){
           invAvnDerivada=(InvAvnDerivada)list.get(i);
           invAvnDerivadaVO=toInvAvnDerivadaVO(invAvnDerivada);
           listVO.add(invAvnDerivadaVO);
       }
       return listVO;
    }
    private InvAvnDerivadaVO toInvAvnDerivadaVO(InvAvnDerivada invAvnDerivada1)  {
       InvAvnDerivadaVO invAvnDerivadaVO1=new InvAvnDerivadaVO();
       invAvnDerivadaVO1.setCsiId(invAvnDerivada1.getCsiId());
       invAvnDerivadaVO1.setIadAnyo(invAvnDerivada1.getIadAnyo());
       invAvnDerivadaVO1.setIadAsunto(invAvnDerivada1.getIadAsunto());
       invAvnDerivadaVO1.setIadDiasHabiles(invAvnDerivada1.getIadDiasHabiles());
       invAvnDerivadaVO1.setIadFechaEmision(invAvnDerivada1.getIadFechaEmision());
       invAvnDerivadaVO1.setIadFechaFin(invAvnDerivada1.getIadFechaFin());
       invAvnDerivadaVO1.setIadFechaInicio(invAvnDerivada1.getIadFechaInicio());
       invAvnDerivadaVO1.setIadFechaRecepcion(invAvnDerivada1.getIadFechaRecepcion());
       invAvnDerivadaVO1.setIadFechaRegistro(invAvnDerivada1.getIadFechaRegistro());
       invAvnDerivadaVO1.setIadFechaRespuesta(invAvnDerivada1.getIadFechaRespuesta());
       invAvnDerivadaVO1.setIadFechaVencimiento(invAvnDerivada1.getIadFechaVencimiento());
       invAvnDerivadaVO1.setIadHr(invAvnDerivada1.getIadHr());
       invAvnDerivadaVO1.setIadNroCarta(invAvnDerivada1.getIadNroCarta());
       invAvnDerivadaVO1.setIadNumero(invAvnDerivada1.getIadNumero());
       invAvnDerivadaVO1.setIadPlazoDias(invAvnDerivada1.getIadPlazoDias());
       invAvnDerivadaVO1.setIadPlazoEnDias(invAvnDerivada1.getIadPlazoEnDias());
       invAvnDerivadaVO1.setIadRegSalida(invAvnDerivada1.getIadRegSalida());
       invAvnDerivadaVO1.setIadTipoDias(invAvnDerivada1.getIadTipoDias());
       invAvnDerivadaVO1.setIasEstado(invAvnDerivada1.getIasEstado());
       invAvnDerivadaVO1.setIasFechaAlta(invAvnDerivada1.getIasFechaAlta());
       invAvnDerivadaVO1.setIasFechaBaja(invAvnDerivada1.getIasFechaBaja());
       invAvnDerivadaVO1.setIasFechaCambio(invAvnDerivada1.getIasFechaCambio());
       invAvnDerivadaVO1.setIasTerminal(invAvnDerivada1.getIasTerminal());
       invAvnDerivadaVO1.setIasUsuarioAlta(invAvnDerivada1.getIasUsuarioAlta());
       invAvnDerivadaVO1.setIasUsuarioBaja(invAvnDerivada1.getIasUsuarioBaja());
       invAvnDerivadaVO1.setIasUsuarioCambio(invAvnDerivada1.getIasUsuarioCambio());
       invAvnDerivadaVO1.setInvId(invAvnDerivada1.getInvId());
       invAvnDerivadaVO1.setMcoId(invAvnDerivada1.getMcoId());
        invAvnDerivadaVO1.setNroOficio(invAvnDerivada1.getNroOficio());
        invAvnDerivadaVO1.setTinId(invAvnDerivada1.getTinId());
        invAvnDerivadaVO1.setIadTipoSup(invAvnDerivada1.getIadTipoSup());
        invAvnDerivadaVO1.setSupID(invAvnDerivada1.getSupID());
        invAvnDerivadaVO1.setTsiID(invAvnDerivada1.getTsiID());
        invAvnDerivadaVO1.setTiaNumero(invAvnDerivada1.getTiaNumero());
        
       return invAvnDerivadaVO1;
    }
    
    private InvAvnDerivada toInvAvnDerivada(InvAvnDerivadaVO invAvnDerivadaVO1)  {
       InvAvnDerivada invAvnDerivada1=new InvAvnDerivada();
       
        invAvnDerivada1.setIadAnyo(invAvnDerivadaVO1.getIadAnyo());
          invAvnDerivada1.setIadAsunto(invAvnDerivadaVO1.getIadAsunto());
          invAvnDerivada1.setIadDiasHabiles(invAvnDerivadaVO1.getIadDiasHabiles());
          invAvnDerivada1.setIadFechaEmision(invAvnDerivadaVO1.getIadFechaEmision());
          invAvnDerivada1.setIadFechaFin(invAvnDerivadaVO1.getIadFechaFin());
          invAvnDerivada1.setIadFechaInicio(invAvnDerivadaVO1.getIadFechaInicio());
          invAvnDerivada1.setIadFechaRecepcion(invAvnDerivadaVO1.getIadFechaRecepcion());
          invAvnDerivada1.setIadFechaRegistro(invAvnDerivadaVO1.getIadFechaRegistro());
          invAvnDerivada1.setIadFechaRespuesta(invAvnDerivadaVO1.getIadFechaRespuesta());
          invAvnDerivada1.setIadFechaVencimiento(invAvnDerivadaVO1.getIadFechaVencimiento());
          invAvnDerivada1.setIadHr(invAvnDerivadaVO1.getIadHr());
          invAvnDerivada1.setIadNroCarta(invAvnDerivadaVO1.getIadNroCarta());
          invAvnDerivada1.setIadNumero(invAvnDerivadaVO1.getIadNumero());
          invAvnDerivada1.setIadPlazoDias(invAvnDerivadaVO1.getIadPlazoDias());
          invAvnDerivada1.setIadPlazoEnDias(invAvnDerivadaVO1.getIadPlazoEnDias());
          invAvnDerivada1.setIadRegSalida(invAvnDerivadaVO1.getIadRegSalida());
          invAvnDerivada1.setIadTipoDias(invAvnDerivadaVO1.getIadTipoDias());
          invAvnDerivada1.setIasEstado(invAvnDerivadaVO1.getIasEstado());
          invAvnDerivada1.setIasFechaAlta(invAvnDerivadaVO1.getIasFechaAlta());
          invAvnDerivada1.setIasFechaBaja(invAvnDerivadaVO1.getIasFechaBaja());
          invAvnDerivada1.setIasFechaCambio(invAvnDerivadaVO1.getIasFechaCambio());
          invAvnDerivada1.setIasTerminal(invAvnDerivadaVO1.getIasTerminal());
          invAvnDerivada1.setIasUsuarioAlta(invAvnDerivadaVO1.getIasUsuarioAlta());
          invAvnDerivada1.setIasUsuarioBaja(invAvnDerivadaVO1.getIasUsuarioBaja());
          invAvnDerivada1.setIasUsuarioCambio(invAvnDerivadaVO1.getIasUsuarioCambio());
          invAvnDerivada1.setInvId(invAvnDerivadaVO1.getInvId());
          invAvnDerivada1.setMcoId(invAvnDerivadaVO1.getMcoId());
           invAvnDerivada1.setNroOficio(invAvnDerivadaVO1.getNroOficio());
           invAvnDerivada1.setTinId(invAvnDerivadaVO1.getTinId());
        invAvnDerivada1.setIadTipoSup(invAvnDerivadaVO1.getIadTipoSup());
        invAvnDerivada1.setSupID(invAvnDerivadaVO1.getSupID());
        invAvnDerivada1.setTsiID(invAvnDerivadaVO1.getTsiID());
        invAvnDerivada1.setTiaNumero(invAvnDerivadaVO1.getTiaNumero());
       return invAvnDerivada1;
    }


    public void setInvAvnDerivada(InvAvnDerivada invAvnDerivada) {
        this.invAvnDerivada = invAvnDerivada;
    }

    public InvAvnDerivada getInvAvnDerivada() {
        return invAvnDerivada;
    }

    public void setInvAvnDerivadaVO(InvAvnDerivadaVO invAvnDerivadaVO) {
        this.invAvnDerivadaVO = invAvnDerivadaVO;
    }

    public InvAvnDerivadaVO getInvAvnDerivadaVO() {
        return invAvnDerivadaVO;
    }

    public void setInvAvnDerivadaDAOImpl(InvAvnDerivadaDAO invAvnDerivadaDAOImpl) {
        this.invAvnDerivadaDAOImpl = invAvnDerivadaDAOImpl;
    }

    public InvAvnDerivadaDAO getInvAvnDerivadaDAOImpl() {
        return invAvnDerivadaDAOImpl;
    }

}
