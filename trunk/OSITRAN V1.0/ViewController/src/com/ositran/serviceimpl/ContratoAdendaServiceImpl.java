package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoAdendaDAOImpl;
import com.ositran.model.ContratoAdenda;
import com.ositran.service.ContratoAdendaService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ContratoAdendaVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ContratoAdendaServiceImpl implements ContratoAdendaService {
    
    private ContratoAdendaDAOImpl contratoAdendaDAOImpl;
    
    public ContratoAdendaServiceImpl() {
        super();
    }

    @Override
    public List<ContratoAdendaVO> query() throws SQLException {
        List<ContratoAdenda> list = contratoAdendaDAOImpl.query();
        List<ContratoAdendaVO> listVO=toListContratoAdendaVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoAdendaVO contratoAdendaVO) throws SQLException {
        ContratoAdenda contratoAdenda=toContratoAdenda(contratoAdendaVO);
        String result = contratoAdendaDAOImpl.insert(contratoAdenda);
        return result;
    }



    @Override
    public String update(ContratoAdendaVO contratoAdendaVO) throws SQLException {
        ContratoAdenda contratoAdenda=toContratoAdenda(contratoAdendaVO);
        String result = contratoAdendaDAOImpl.update(contratoAdenda);
        return result;
    }

    @Override
    public ContratoAdendaVO get(Integer id) throws SQLException {
        ContratoAdenda contratoAdenda= contratoAdendaDAOImpl.get(id);
        ContratoAdendaVO contratoAdendaVO=toContratoAdendaVO(contratoAdenda);
        return contratoAdendaVO;
    }
    
    // conversiones
    private List<ContratoAdendaVO> toListContratoAdendaVO(List<ContratoAdenda> list){
        List<ContratoAdendaVO> listVO=new ArrayList<ContratoAdendaVO>();
        for(int i=0;i<list.size();i++){
            ContratoAdenda contratoAdenda=(ContratoAdenda)list.get(i);
            ContratoAdendaVO contratoAdendaVO=toContratoAdendaVO(contratoAdenda);
            listVO.add(contratoAdendaVO);
        }
        return listVO;
    }
    
    private ContratoAdendaVO toContratoAdendaVO(ContratoAdenda contratoAdenda){
        ContratoAdendaVO contratoAdendaVO=new ContratoAdendaVO();
        
        
        contratoAdendaVO.setMonId(contratoAdenda.getMonId());
        contratoAdendaVO.setConId(contratoAdenda.getConId());
        contratoAdendaVO.setCadMonto(contratoAdenda.getCadMonto());
        contratoAdendaVO.setCadId(contratoAdenda.getCadId());
        contratoAdendaVO.setCadFecha(contratoAdenda.getCadFecha());
        contratoAdendaVO.setCadFechaDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoAdenda.getCadFecha()));
        contratoAdendaVO.setCadDescripcion(contratoAdenda.getCadDescripcion());
        contratoAdendaVO.setCadDocumentoFisico(contratoAdenda.getCadDocumentoFisico());
        contratoAdendaVO.setCadEstado(contratoAdenda.getCadEstado());
        contratoAdendaVO.setCadNombre(contratoAdenda.getCadNombre());
        contratoAdendaVO.setTadId(contratoAdenda.getTadId());
        contratoAdendaVO.setCadCompromisoInversion(contratoAdenda.getCadCompromisoInversion());
        contratoAdendaVO.setBoocadCompromisoInversion(contratoAdenda.getCadCompromisoInversion()==1?true:false);
        
        contratoAdendaVO.setCadFechaAlta(contratoAdenda.getCadFechaAlta());
        contratoAdendaVO.setCadUsuarioAlta(contratoAdenda.getCadUsuarioAlta());
        contratoAdendaVO.setCadFechaCambio(contratoAdenda.getCadFechaCambio());
        contratoAdendaVO.setCadUsuarioCambio(contratoAdenda.getCadUsuarioCambio());
        contratoAdendaVO.setCadFechaBaja(contratoAdenda.getCadFechaBaja());
        contratoAdendaVO.setCadUsuarioBaja(contratoAdenda.getCadUsuarioBaja());
        return contratoAdendaVO;
    }
    
    private ContratoAdenda toContratoAdenda(ContratoAdendaVO contratoAdendaVO){
        ContratoAdenda contratoAdenda=new ContratoAdenda();        
        System.out.println("contratoNuevaAdendaVO.getTadId():"+contratoAdendaVO.getTadId());
        contratoAdenda.setMonId(contratoAdendaVO.getMonId());
        contratoAdenda.setConId(contratoAdendaVO.getConId());
        contratoAdenda.setCadMonto(contratoAdendaVO.getCadMonto());
        contratoAdenda.setCadId(contratoAdendaVO.getCadId());
        contratoAdenda.setCadFecha(contratoAdendaVO.getCadFecha());
        contratoAdenda.setCadDescripcion(contratoAdendaVO.getCadDescripcion());
        contratoAdenda.setCadDocumentoFisico(contratoAdendaVO.getCadDocumentoFisico());
        contratoAdenda.setCadEstado(contratoAdendaVO.getCadEstado());
        contratoAdenda.setCadNombre(contratoAdendaVO.getCadNombre());
        contratoAdenda.setTadId(contratoAdendaVO.getTadId());
        contratoAdenda.setCadCompromisoInversion(contratoAdendaVO.getCadCompromisoInversion());
        
        contratoAdenda.setCadFechaAlta(contratoAdendaVO.getCadFechaAlta());
        contratoAdenda.setCadUsuarioAlta(contratoAdendaVO.getCadUsuarioAlta());
        contratoAdenda.setCadFechaCambio(contratoAdendaVO.getCadFechaCambio());
        contratoAdenda.setCadUsuarioCambio(contratoAdendaVO.getCadUsuarioCambio());
        contratoAdenda.setCadFechaBaja(contratoAdendaVO.getCadFechaBaja());
        contratoAdenda.setCadUsuarioBaja(contratoAdendaVO.getCadUsuarioBaja());
        contratoAdenda.setCadTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
        
        return contratoAdenda;
        
    }

    public ContratoAdendaDAOImpl getContratoAdendaDAOImpl() {
        return contratoAdendaDAOImpl;
    }

    public void setContratoAdendaDAOImpl(ContratoAdendaDAOImpl contratoAdendaDAOImpl) {
        this.contratoAdendaDAOImpl = contratoAdendaDAOImpl;
    }
    
    @Override    
    public List<ContratoAdendaVO> getAdendasContrato(Integer ConId) throws SQLException{
        List<ContratoAdenda> list = contratoAdendaDAOImpl.getAdendasContrato(ConId);
        List<ContratoAdendaVO> listVO=toListContratoAdendaVO(list);
        return listVO;
    }


}
