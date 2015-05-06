package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoAlertaDAOImpl;
import com.ositran.model.ContratoAlerta;
import com.ositran.service.ContratoAlertaService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ContratoAlertaVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ContratoAlertaServiceImpl implements ContratoAlertaService {
    private ContratoAlertaDAOImpl contratoAlertaDAOImpl;
    
    public ContratoAlertaServiceImpl() {
        super();
    }

    @Override
    public List<ContratoAlertaVO> query() throws SQLException {
        List<ContratoAlerta> list = contratoAlertaDAOImpl.query();
        List<ContratoAlertaVO> listVO=toListContratoAlertaVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoAlertaVO contratoAlertaVO) throws SQLException {
        ContratoAlerta contratoAlerta=toContratoAlerta(contratoAlertaVO);
        String result = contratoAlertaDAOImpl.insert(contratoAlerta);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = contratoAlertaDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoAlertaVO contratoAlertaVO) throws SQLException {
        ContratoAlerta contratoAlerta=toContratoAlerta(contratoAlertaVO);
        String result = contratoAlertaDAOImpl.update(contratoAlerta);
        return result;
    }

    @Override
    public ContratoAlertaVO get(Integer id) throws SQLException {
        ContratoAlerta contratoAlerta= contratoAlertaDAOImpl.get(id);
        ContratoAlertaVO contratoAlertaVO=toContratoAlertaVO(contratoAlerta);
        return contratoAlertaVO;
    }
    
    // conversiones
    private List<ContratoAlertaVO> toListContratoAlertaVO(List<ContratoAlerta> list){
        List<ContratoAlertaVO> listVO=new ArrayList<ContratoAlertaVO>();
        for(int i=0;i<list.size();i++){
            ContratoAlerta contratoAlerta=(ContratoAlerta)list.get(i);
            ContratoAlertaVO contratoAlertaVO=toContratoAlertaVO(contratoAlerta);
            listVO.add(contratoAlertaVO);
        }
        return listVO;
    }
    
    public ContratoAlertaVO toContratoAlertaVO(ContratoAlerta contratoAlerta){
        ContratoAlertaVO contratoAlertaVO=new ContratoAlertaVO();            
        
        contratoAlertaVO.setCaeId(contratoAlerta.getCaeId());
        contratoAlertaVO.setCalAeropuerto(contratoAlerta.getCalAeropuerto());
        contratoAlertaVO.setCalDiaPresentacion(contratoAlerta.getCalDiaPresentacion());
        contratoAlertaVO.setCalEstado(contratoAlerta.getCalEstado());
        contratoAlertaVO.setCalFechaFin(contratoAlerta.getCalFechaFin());
        contratoAlertaVO.setCalFechaInicio(contratoAlerta.getCalFechaInicio());
        contratoAlertaVO.setCalFechaLimite(contratoAlerta.getCalFechaLimite());
        contratoAlertaVO.setCalFechaFinDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoAlerta.getCalFechaFin()));
        contratoAlertaVO.setCalFechaInicioDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoAlerta.getCalFechaInicio()));
        contratoAlertaVO.setCalFechaLimiteDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoAlerta.getCalFechaLimite()));
        
        contratoAlertaVO.setCalId(contratoAlerta.getCalId());
        contratoAlertaVO.setCalNombreconcesion(contratoAlerta.getCalNombreconcesion());
        contratoAlertaVO.setCalPlazo(contratoAlerta.getCalPlazo());
        contratoAlertaVO.setCalPlazoDescripcion(contratoAlerta.getCalPlazoDescripcion());
        
        contratoAlertaVO.setConId(contratoAlerta.getConId());
        contratoAlertaVO.setPerId(contratoAlerta.getPerId());
        contratoAlertaVO.setTinId(contratoAlerta.getTinId());
        contratoAlertaVO.setCsiId(contratoAlerta.getCsiId());
        contratoAlertaVO.setInfId(contratoAlerta.getInfId());
        contratoAlertaVO.setInvId(contratoAlerta.getInvId());
        contratoAlertaVO.setTccTipo(contratoAlerta.getTccTipo());
        contratoAlertaVO.setCcoId(contratoAlerta.getCcoId());
        contratoAlertaVO.setMcoId(contratoAlerta.getMcoId());
                    
        contratoAlertaVO.setCalFechaAlta(contratoAlerta.getCalFechaAlta());
        contratoAlertaVO.setCalUsuarioAlta(contratoAlerta.getCalUsuarioAlta());
        contratoAlertaVO.setCalFechaCambio(contratoAlerta.getCalFechaCambio());
        contratoAlertaVO.setCalUsuarioCambio(contratoAlerta.getCalUsuarioCambio());
        contratoAlertaVO.setCalFechaBaja(contratoAlerta.getCalFechaBaja());
        contratoAlertaVO.setCalUsuarioBaja(contratoAlerta.getCalUsuarioBaja());
        contratoAlertaVO.setCalTerminal(contratoAlerta.getCalTerminal());
        return contratoAlertaVO;
    }
    
    public ContratoAlerta toContratoAlerta(ContratoAlertaVO contratoAlertaVO){
        ContratoAlerta contratoAlerta=new ContratoAlerta();           
                
        contratoAlerta.setCaeId(contratoAlertaVO.getCaeId());
        contratoAlerta.setCalAeropuerto(contratoAlertaVO.getCalAeropuerto());
        contratoAlerta.setCalDiaPresentacion(contratoAlertaVO.getCalDiaPresentacion());
        contratoAlerta.setCalEstado(contratoAlertaVO.getCalEstado());
        contratoAlerta.setCalFechaFin(contratoAlertaVO.getCalFechaFin());
        contratoAlerta.setCalFechaInicio(contratoAlertaVO.getCalFechaInicio());
        contratoAlerta.setCalFechaLimite(contratoAlertaVO.getCalFechaLimite());
        contratoAlerta.setCalId(contratoAlertaVO.getCalId());
        contratoAlerta.setCalNombreconcesion(contratoAlertaVO.getCalNombreconcesion());
        contratoAlerta.setCalPlazo(contratoAlertaVO.getCalPlazo());
        contratoAlerta.setConId(contratoAlertaVO.getConId());
        contratoAlerta.setPerId(contratoAlertaVO.getPerId());
        contratoAlerta.setTinId(contratoAlertaVO.getTinId());
        contratoAlerta.setCsiId(contratoAlertaVO.getCsiId());
        contratoAlerta.setInfId(contratoAlertaVO.getInfId());
        contratoAlerta.setInvId(contratoAlertaVO.getInvId());
        contratoAlerta.setTccTipo(contratoAlertaVO.getTccTipo());
        contratoAlerta.setCcoId(contratoAlertaVO.getCcoId());
        contratoAlerta.setMcoId(contratoAlertaVO.getMcoId());
        
        contratoAlerta.setCalFechaAlta(contratoAlertaVO.getCalFechaAlta());
        contratoAlerta.setCalUsuarioAlta(contratoAlertaVO.getCalUsuarioAlta());
        contratoAlerta.setCalFechaCambio(contratoAlertaVO.getCalFechaCambio());
        contratoAlerta.setCalUsuarioCambio(contratoAlertaVO.getCalUsuarioCambio());
        contratoAlerta.setCalFechaBaja(contratoAlertaVO.getCalFechaBaja());
        contratoAlerta.setCalUsuarioBaja(contratoAlertaVO.getCalUsuarioBaja());
        contratoAlerta.setCalTerminal(contratoAlertaVO.getCalTerminal());
        contratoAlerta.setCalCorreo(contratoAlertaVO.getCalCorreo());

        
        contratoAlerta.setCalTipo(contratoAlertaVO.getCalTipo());
        contratoAlerta.setCalCantidadPlazo(contratoAlertaVO.getCalCantidadPlazo());
        contratoAlerta.setCalMesoanioPlazo(contratoAlertaVO.getCalMesoanioPlazo());
        contratoAlerta.setCalPlazoDescripcion(contratoAlertaVO.getCalPlazoDescripcion());
        return contratoAlerta;
        
    }

    public ContratoAlertaDAOImpl getContratoAlertaDAOImpl() {
        return contratoAlertaDAOImpl;
    }

    public void setContratoAlertaDAOImpl(ContratoAlertaDAOImpl contratoAlertaDAOImpl) {
        this.contratoAlertaDAOImpl = contratoAlertaDAOImpl;
    }
    
    @Override    
    public List<ContratoAlertaVO> getAlertasContrato(Integer ConId) throws SQLException{
        List<ContratoAlerta> list = contratoAlertaDAOImpl.getAlertasContrato(ConId);
        List<ContratoAlertaVO> listVO=toListContratoAlertaVO(list);
        return listVO;
    }
}
