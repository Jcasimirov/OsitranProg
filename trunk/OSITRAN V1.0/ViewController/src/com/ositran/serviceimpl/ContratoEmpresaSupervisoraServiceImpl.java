package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoEmpresaSupervisoraDAOImpl;
import com.ositran.model.ContratoSupervisora;
import com.ositran.model.EmpresaSupervisora;

import java.sql.SQLException;
import com.ositran.service.ContratoEmpresaSupervisoraService;
import com.ositran.util.HibernateUtil;
import com.ositran.vo.bean.ContratoSupervisoraVO;
import com.ositran.vo.bean.EmpresaSupervisoraVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class ContratoEmpresaSupervisoraServiceImpl implements ContratoEmpresaSupervisoraService{
    private ContratoEmpresaSupervisoraDAOImpl contratoEmpresaSupervisoraDAOImpl=new ContratoEmpresaSupervisoraDAOImpl();

    @Override
    public List<ContratoSupervisoraVO> query() throws SQLException {
        List<ContratoSupervisora> list=contratoEmpresaSupervisoraDAOImpl.query();
        List<ContratoSupervisoraVO> listVO=toListContratoSupervisoraVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoSupervisoraVO contratoSupervisoraVO) throws SQLException {
        ContratoSupervisora empresaSupervisora=toContratoSupervisora(contratoSupervisoraVO);
        String result=contratoEmpresaSupervisoraDAOImpl.insert(empresaSupervisora);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoSupervisoraVO contratoSupervisoraVO) throws SQLException {
        ContratoSupervisora contratoSupervisora=toContratoSupervisora(contratoSupervisoraVO);
        String result=this.contratoEmpresaSupervisoraDAOImpl.update(contratoSupervisora);
        return result;
    }

    @Override
    public ContratoSupervisoraVO get(Integer id) throws SQLException {
        ContratoSupervisora contratoSupervisora=this.contratoEmpresaSupervisoraDAOImpl.get(id);
        ContratoSupervisoraVO contratoSupervisoraVO=toContratoSupervisoraVO(contratoSupervisora);
        return contratoSupervisoraVO;
    }

    @Override
    public int ValidarContratoSupervisora(int concesion, int tipoinfra) throws SQLException {
        // TODO Implement this method
        return 0;
    }
    
    
    //conversiones
    private List<ContratoSupervisoraVO> toListContratoSupervisoraVO(List<ContratoSupervisora> list)throws SQLException{
        List<ContratoSupervisoraVO> listVO=new ArrayList<ContratoSupervisoraVO>();
        for(int i=0;i<list.size();i++){
            ContratoSupervisora contratoSupervisora=(ContratoSupervisora)list.get(i);
            ContratoSupervisoraVO contratoSupervisoraVO=toContratoSupervisoraVO(contratoSupervisora);
            listVO.add(contratoSupervisoraVO);
        }
        return listVO;
    }
    
    private ContratoSupervisoraVO toContratoSupervisoraVO(ContratoSupervisora contratoSupervisora)throws SQLException{
        ContratoSupervisoraVO contratoSupervisoraVO=new ContratoSupervisoraVO();
        contratoSupervisoraVO.setContrato(contratoSupervisora.getContrato());
        //contratoSupervisoraVO.setContratoSupervisoraAdendaList(contratoSupervisora.getContratoSupervisoraAdendaList());
        contratoSupervisoraVO.setCpsAdelantoOtorgado(contratoSupervisora.getCpsAdelantoOtorgado());
        contratoSupervisoraVO.setCpsAnyo(contratoSupervisora.getCpsAnyo());
        contratoSupervisoraVO.setCpsArchivoPdf(contratoSupervisora.getCpsArchivoPdf());
        contratoSupervisoraVO.setCpsAsunto(contratoSupervisora.getCpsAsunto());
        contratoSupervisoraVO.setCpsCaducidad(contratoSupervisora.getCpsCaducidad());
        contratoSupervisoraVO.setCpsEstado(contratoSupervisora.getCpsEstado());
        contratoSupervisoraVO.setCpsFechaAdelanto(contratoSupervisora.getCpsFechaAdelanto());
        contratoSupervisoraVO.setCpsFechaAlta(contratoSupervisora.getCpsFechaAlta());
        contratoSupervisoraVO.setCpsFechaBaja(contratoSupervisora.getCpsFechaBaja());
        contratoSupervisoraVO.setCpsFechaCambio(contratoSupervisora.getCpsFechaCambio());
        contratoSupervisoraVO.setCpsFechaInicio(contratoSupervisora.getCpsFechaInicio());
        contratoSupervisoraVO.setCpsFechaRegistro(contratoSupervisora.getCpsFechaRegistro());
        contratoSupervisoraVO.setCpsFechaSuscripcion(contratoSupervisora.getCpsFechaSuscripcion());
        contratoSupervisoraVO.setCpsGarantias(contratoSupervisora.getCpsGarantias());
        contratoSupervisoraVO.setCpsMontoContratado(contratoSupervisora.getCpsMontoContratado());
        contratoSupervisoraVO.setCpsNroDeContrato(contratoSupervisora.getCpsNroDeContrato());
        contratoSupervisoraVO.setCpsPenalidades(contratoSupervisora.getCpsPenalidades());
        contratoSupervisoraVO.setCpsPlazoContrato(contratoSupervisora.getCpsPlazoContrato());
        contratoSupervisoraVO.setCpsStd(contratoSupervisora.getCpsStd());
        contratoSupervisoraVO.setCpsTerminal(contratoSupervisora.getCpsTerminal());
        contratoSupervisoraVO.setCpsUsuarioAlta(contratoSupervisora.getCpsUsuarioAlta());
        contratoSupervisoraVO.setCpsUsuarioBaja(contratoSupervisora.getCpsUsuarioBaja());
        contratoSupervisoraVO.setCpsUsuarioCambio(contratoSupervisora.getCpsUsuarioCambio());
        contratoSupervisoraVO.setEmpresaSupervisora(contratoSupervisora.getEmpresaSupervisora());
        contratoSupervisoraVO.setInfraestructura(contratoSupervisora.getInfraestructura());
        return contratoSupervisoraVO;
    }
        
    private ContratoSupervisora toContratoSupervisora(ContratoSupervisoraVO contratoSupervisoraVO){
        ContratoSupervisora contratoSupervisora=new ContratoSupervisora();
        contratoSupervisora.setContrato(contratoSupervisoraVO.getContrato());
        //contratoSupervisoraVO.setContratoSupervisoraAdendaList(contratoSupervisora.getContratoSupervisoraAdendaList());
        contratoSupervisora.setCpsAdelantoOtorgado(contratoSupervisoraVO.getCpsAdelantoOtorgado());
        contratoSupervisora.setCpsAnyo(contratoSupervisoraVO.getCpsAnyo());
        contratoSupervisora.setCpsArchivoPdf(contratoSupervisoraVO.getCpsArchivoPdf());
        contratoSupervisora.setCpsAsunto(contratoSupervisoraVO.getCpsAsunto());
        contratoSupervisora.setCpsCaducidad(contratoSupervisoraVO.getCpsCaducidad());
        contratoSupervisora.setCpsEstado(contratoSupervisoraVO.getCpsEstado());
        contratoSupervisora.setCpsFechaAdelanto(contratoSupervisoraVO.getCpsFechaAdelanto());
        contratoSupervisora.setCpsFechaAlta(contratoSupervisoraVO.getCpsFechaAlta());
        contratoSupervisora.setCpsFechaBaja(contratoSupervisoraVO.getCpsFechaBaja());
        contratoSupervisora.setCpsFechaCambio(contratoSupervisoraVO.getCpsFechaCambio());
        contratoSupervisora.setCpsFechaInicio(contratoSupervisoraVO.getCpsFechaInicio());
        contratoSupervisora.setCpsFechaRegistro(contratoSupervisoraVO.getCpsFechaRegistro());
        contratoSupervisora.setCpsFechaSuscripcion(contratoSupervisoraVO.getCpsFechaSuscripcion());
        contratoSupervisora.setCpsGarantias(contratoSupervisoraVO.getCpsGarantias());
        contratoSupervisora.setCpsMontoContratado(contratoSupervisoraVO.getCpsMontoContratado());
        contratoSupervisora.setCpsNroDeContrato(contratoSupervisoraVO.getCpsNroDeContrato());
        contratoSupervisora.setCpsPenalidades(contratoSupervisoraVO.getCpsPenalidades());
        contratoSupervisora.setCpsPlazoContrato(contratoSupervisoraVO.getCpsPlazoContrato());
        contratoSupervisora.setCpsStd(contratoSupervisoraVO.getCpsStd());
        contratoSupervisora.setCpsTerminal(contratoSupervisoraVO.getCpsTerminal());
        contratoSupervisora.setCpsUsuarioAlta(contratoSupervisoraVO.getCpsUsuarioAlta());
        contratoSupervisora.setCpsUsuarioBaja(contratoSupervisoraVO.getCpsUsuarioBaja());
        contratoSupervisora.setCpsUsuarioCambio(contratoSupervisoraVO.getCpsUsuarioCambio());
        contratoSupervisora.setEmpresaSupervisora(contratoSupervisoraVO.getEmpresaSupervisora());
        contratoSupervisora.setInfraestructura(contratoSupervisoraVO.getInfraestructura());
        return contratoSupervisora;
    }
}
