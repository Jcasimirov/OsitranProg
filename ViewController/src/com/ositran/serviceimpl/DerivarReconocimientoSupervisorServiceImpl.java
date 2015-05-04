package com.ositran.serviceimpl;

import com.ositran.dao.DerivarReconocimientoSupervisorDAO;
import com.ositran.daoimpl.DerivarReconocimientoSupervisorDAOImpl;
import com.ositran.model.DerivarReconocimientoSupervisor;
import com.ositran.model.Rol;
import com.ositran.service.DerivarReconocimientoSupervisorService;
import com.ositran.vo.bean.DerivarReconocimientoSupervisorVO;

import com.ositran.vo.bean.RolVO;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.Collections;
import java.util.List;

public class DerivarReconocimientoSupervisorServiceImpl implements DerivarReconocimientoSupervisorService{
                DerivarReconocimientoSupervisor derivarReconocimientoSupervisor=new DerivarReconocimientoSupervisor();
                DerivarReconocimientoSupervisorVO derivarReconocimientoSupervisorVO=new DerivarReconocimientoSupervisorVO();
                DerivarReconocimientoSupervisorDAO derivarReconocimientoSupervisorDAOImpl=new DerivarReconocimientoSupervisorDAOImpl();
    
    public DerivarReconocimientoSupervisorServiceImpl() {
        super();
    }

    @Override
    public List<DerivarReconocimientoSupervisorVO> queryDerivarInversion(int codigoCnotrato,
                                                                         int codigoContratoCompromiso,
                                                                         int estado) throws SQLException, Exception {
       
        return Collections.emptyList();
    }
    @Override
    public List<DerivarReconocimientoSupervisorVO> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(DerivarReconocimientoSupervisorVO derivarReconocimientoSupervisorVO1) throws SQLException,Exception{
        System.out.println("LLEGO AL SERVICES IMPL");
            derivarReconocimientoSupervisor=toDerivarReconocimientoSupervisor(derivarReconocimientoSupervisorVO1);
            String result=derivarReconocimientoSupervisorDAOImpl.insert(derivarReconocimientoSupervisor);
            return result;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(DerivarReconocimientoSupervisorVO derivarReconocimientoSupervisorVO) throws ParseException,
                                                                                                     SQLException,
                                                                                                     Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public DerivarReconocimientoSupervisorVO get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
    
    //CONVERSIONES
    private DerivarReconocimientoSupervisor toDerivarReconocimientoSupervisor(DerivarReconocimientoSupervisorVO derivarReconocimientoSupervisorVO1)  {
        DerivarReconocimientoSupervisor derivarReconocimientoSupervisor1=new DerivarReconocimientoSupervisor();
        derivarReconocimientoSupervisor1.setCsiId(derivarReconocimientoSupervisorVO1.getCsiId());
        derivarReconocimientoSupervisor1.setIadAnyo(derivarReconocimientoSupervisorVO1.getIadAnyo());
        derivarReconocimientoSupervisor1.setIadAsunto(derivarReconocimientoSupervisorVO1.getIadAsunto());
        derivarReconocimientoSupervisor1.setIadDiasHabiles(derivarReconocimientoSupervisorVO1.getIadDiasHabiles());
        derivarReconocimientoSupervisor1.setIadFechaEmisión(derivarReconocimientoSupervisorVO1.getIadFechaEmisión());
        derivarReconocimientoSupervisor1.setIadFechaFin(derivarReconocimientoSupervisorVO1.getIadFechaFin());
        derivarReconocimientoSupervisor1.setIadFechaInicio(derivarReconocimientoSupervisorVO1.getIadFechaInicio());
        derivarReconocimientoSupervisor1.setIadFechaRecepción(derivarReconocimientoSupervisorVO1.getIadFechaRecepción());
        derivarReconocimientoSupervisor1.setIadFechaRegistro(derivarReconocimientoSupervisorVO1.getIadFechaRegistro());
        derivarReconocimientoSupervisor1.setIadFechaRespuesta(derivarReconocimientoSupervisorVO1.getIadFechaRespuesta());
        derivarReconocimientoSupervisor1.setIadFechaVencimiento(derivarReconocimientoSupervisorVO1.getIadFechaVencimiento());
        derivarReconocimientoSupervisor1.setIadHr(derivarReconocimientoSupervisorVO1.getIadHr());
        derivarReconocimientoSupervisor1.setIadNroCarta(derivarReconocimientoSupervisorVO1.getIadNroCarta());
        derivarReconocimientoSupervisor1.setIadNumero(derivarReconocimientoSupervisorVO1.getIadNumero());
        derivarReconocimientoSupervisor1.setIadPlazoDías(derivarReconocimientoSupervisorVO1.getIadPlazoDías());
        derivarReconocimientoSupervisor1.setIadPlazoEnDías(derivarReconocimientoSupervisorVO1.getIadPlazoEnDías());
        derivarReconocimientoSupervisor1.setIadRegSalida(derivarReconocimientoSupervisorVO1.getIadRegSalida());
        derivarReconocimientoSupervisor1.setIadTipoDías(derivarReconocimientoSupervisorVO1.getIadTipoDías());
        derivarReconocimientoSupervisor1.setIasEstado(derivarReconocimientoSupervisorVO1.getIasEstado());
        derivarReconocimientoSupervisor1.setIasFechaAlta(derivarReconocimientoSupervisorVO1.getIasFechaAlta());
        derivarReconocimientoSupervisor1.setIasFechaBaja(derivarReconocimientoSupervisorVO1.getIasFechaBaja());
        derivarReconocimientoSupervisor1.setIasFechaCambio(derivarReconocimientoSupervisorVO1.getIasFechaCambio());
        derivarReconocimientoSupervisor1.setIasTerminal(derivarReconocimientoSupervisorVO1.getIasTerminal());
        derivarReconocimientoSupervisor1.setIasUsuarioAlta(derivarReconocimientoSupervisorVO1.getIasUsuarioAlta());
        derivarReconocimientoSupervisor1.setIasUsuarioBaja(derivarReconocimientoSupervisorVO1.getIasUsuarioBaja());
        derivarReconocimientoSupervisor1.setIasUsuarioCambio(derivarReconocimientoSupervisorVO1.getIasUsuarioCambio());
        derivarReconocimientoSupervisor1.setInvId(derivarReconocimientoSupervisorVO1.getInvId());
        derivarReconocimientoSupervisor1.setMcoId(derivarReconocimientoSupervisorVO1.getMcoId());
        derivarReconocimientoSupervisor1.setNroOficio(derivarReconocimientoSupervisorVO1.getNroOficio());
        derivarReconocimientoSupervisor1.setTinId(derivarReconocimientoSupervisorVO1.getTinId());
        return derivarReconocimientoSupervisor1;
    }

 

  
}
