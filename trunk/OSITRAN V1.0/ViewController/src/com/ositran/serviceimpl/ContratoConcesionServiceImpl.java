package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoConcesionDAOImpl;
import com.ositran.model.Contrato;
import com.ositran.service.ContratoConcesionService;
import com.ositran.vo.bean.ContratoVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContratoConcesionServiceImpl implements ContratoConcesionService{
    public ContratoConcesionServiceImpl() {
        super();
    }
    
    private ContratoConcesionDAOImpl contratoConcesionDAOImpl;


    public void setContratoConcesionDAOImpl(ContratoConcesionDAOImpl contratoConcesionDAOImpl) {
        this.contratoConcesionDAOImpl = contratoConcesionDAOImpl;
    }

    public ContratoConcesionDAOImpl getContratoConcesionDAOImpl() {
        return contratoConcesionDAOImpl;
    }

    @Override
    public List<ContratoVO> query() throws SQLException{
        List<Contrato> list=contratoConcesionDAOImpl.query();
        List<ContratoVO> listVO=toListContratoVO(list);
        return listVO;
        
    }

    @Override
    public String insert(ContratoVO contratoVO) throws SQLException{
        Contrato contrato=toContrato(contratoVO);
        String result=contratoConcesionDAOImpl.insert(contrato);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result=this.contratoConcesionDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoVO contratoVO) throws SQLException{
        Contrato contrato=toContrato(contratoVO);
        String result=this.contratoConcesionDAOImpl.update(contrato);
        return result;
    }

    @Override
    public ContratoVO get(Integer id) throws SQLException{
        Contrato contrato=this.contratoConcesionDAOImpl.get(id);
        ContratoVO contratoVO=toContratoVO(contrato);
        return contratoVO;
    }
    
    @Override
    public int ValidarContratoConcesion(int concesion, int tipoinfra) throws SQLException{
        int respuesta =contratoConcesionDAOImpl.ValidarContratoConcesion(concesion,tipoinfra);
        return respuesta;        
    }
    
    //conversiones
    
    private List<ContratoVO> toListContratoVO(List<Contrato> list){
        List<ContratoVO> listVO=new ArrayList<ContratoVO>();
        for(int i=0;i<list.size();i++){           
            Contrato contrato=(Contrato)list.get(i);            
            ContratoVO contratoVO=toContratoVO(contrato);
            listVO.add(contratoVO);
        }
        return listVO;
    }
    private ContratoVO toContratoVO(Contrato contrato){
        ContratoVO contratoVO=new ContratoVO();
        contratoVO.setCncId(contrato.getCncId());
        contratoVO.setConAnyo(contrato.getConAnyo());
        contratoVO.setConAsunto(contrato.getConAsunto());
        contratoVO.setConAvanceobra(contrato.getConAvanceobra());
        contratoVO.setConDiames(contrato.getConDiames());
        contratoVO.setConDomicilioLegal(contrato.getConDomicilioLegal());
        contratoVO.setConEstado(contrato.getConEstado());
        contratoVO.setConFechaAlta(contrato.getConFechaAlta());
        contratoVO.setConFechaBaja(contrato.getConFechaBaja());
        contratoVO.setConFechaCambio(contrato.getConFechaCambio());
        contratoVO.setConFechaRegistro(contrato.getConFechaRegistro());
        contratoVO.setConFechaSuscripcion(contrato.getConFechaSuscripcion());
        contratoVO.setConFicharesumen(contrato.getConFicharesumen());
        contratoVO.setConId(contrato.getConId());
        contratoVO.setConNumero(contrato.getConNumero());
        contratoVO.setConPdfcontrato(contrato.getConPdfcontrato());
        contratoVO.setConPlazoconcesion(contrato.getConPlazoconcesion());
        contratoVO.setConPlazorevision(contrato.getConPlazorevision());
        contratoVO.setConTerminal(contrato.getConTerminal());
        contratoVO.setConTipodias(contrato.getConTipodias());
        contratoVO.setConUsuarioAlta(contrato.getConUsuarioAlta());
        contratoVO.setConUsuarioBaja(contrato.getConUsuarioBaja());
        contratoVO.setConUsuarioCambio(contrato.getConUsuarioCambio());
        contratoVO.setCsiId(contrato.getCsiId());
        contratoVO.setMcoId(contrato.getMcoId());
        contratoVO.setPerId(contrato.getPerId());
        contratoVO.setTinId(contrato.getTinId());
        
       
        return contratoVO;
    }
    private Contrato toContrato(ContratoVO contratoVO){
        Contrato contrato=new Contrato();
        contrato.setCncId(contratoVO.getCncId());
        contrato.setConAnyo(contratoVO.getConAnyo());
        contrato.setConAsunto(contratoVO.getConAsunto());
        contrato.setConAvanceobra(contratoVO.getConAvanceobra());
        contrato.setConDiames(contratoVO.getConDiames());
        contrato.setConDomicilioLegal(contratoVO.getConDomicilioLegal());
        contrato.setConEstado(contratoVO.getConEstado());
        contrato.setConFechaAlta(contratoVO.getConFechaAlta());
        contrato.setConFechaBaja(contratoVO.getConFechaBaja());
        contrato.setConFechaCambio(contratoVO.getConFechaCambio());
        contrato.setConFechaRegistro(contratoVO.getConFechaRegistro());
        contrato.setConFechaSuscripcion(contratoVO.getConFechaSuscripcion());
        contrato.setConFicharesumen(contratoVO.getConFicharesumen());
        contrato.setConId(contratoVO.getConId());
        contrato.setConNumero(contratoVO.getConNumero());
        contrato.setConPdfcontrato(contratoVO.getConPdfcontrato());
        contrato.setConPlazoconcesion(contratoVO.getConPlazoconcesion());
        contrato.setConPlazorevision(contratoVO.getConPlazorevision());
        contrato.setConTerminal(contratoVO.getConTerminal());
        contrato.setConTipodias(contratoVO.getConTipodias());
        contrato.setConUsuarioAlta(contratoVO.getConUsuarioAlta());
        contrato.setConUsuarioBaja(contratoVO.getConUsuarioBaja());
        contrato.setConUsuarioCambio(contratoVO.getConUsuarioCambio());
        contrato.setCsiId(contratoVO.getCsiId());
        contrato.setMcoId(contratoVO.getMcoId());
        contrato.setPerId(contratoVO.getPerId());
        contrato.setTinId(contratoVO.getTinId());
        
        return contrato;
        
    }

    
}
