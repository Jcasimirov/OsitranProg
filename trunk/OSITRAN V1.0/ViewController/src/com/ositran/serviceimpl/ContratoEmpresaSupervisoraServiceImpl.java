package com.ositran.serviceimpl;

//import com.ositran.daoimpl.ContratoEmpresaSupervisoraDAOImpl;
import com.ositran.daoimpl.ContratoEmpresaSupervisoraDAOImpl;
import com.ositran.model.ContratoSupervisora;
import java.sql.SQLException;
import com.ositran.service.ContratoEmpresaSupervisoraService;
import com.ositran.vo.bean.ContratoSupervisoraVO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContratoEmpresaSupervisoraServiceImpl implements ContratoEmpresaSupervisoraService{
    private ContratoEmpresaSupervisoraDAOImpl contratoEmpresaSupervisoraDAOImpl=new ContratoEmpresaSupervisoraDAOImpl();

    @Override
    public List<ContratoSupervisoraVO> query() throws SQLException {
        List<ContratoSupervisora> list=contratoEmpresaSupervisoraDAOImpl.query();
        List<ContratoSupervisoraVO> listVO=toListContratoSupervisoraVO(list);
        return listVO;
        
    }

    @Override
    public String insert(ContratoSupervisoraVO contrato) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoSupervisoraVO contrato) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoSupervisoraVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
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
        
        
}

