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
        contratoVO.setAvanceObra(contrato.getAvanceObra());
        contratoVO.setCncId(contrato.getCncId());
        contratoVO.setConConcesion(contrato.getConConcesion());
        contratoVO.setConEstado(contrato.getConEstado());
        contratoVO.setConFechaAlta(contrato.getConFechaAlta());
        contratoVO.setConFechaBaja(contrato.getConFechaBaja());
        contratoVO.setConFechaCambio(contrato.getConFechaCambio());
        contratoVO.setConId(contrato.getConId());
        contratoVO.setConTerminal(contrato.getConTerminal());
        contratoVO.setConUsuarioAlta(contrato.getConUsuarioAlta());
        contratoVO.setConUsuarioBaja(contrato.getConUsuarioBaja());
        contratoVO.setConUsuarioCambio(contrato.getConUsuarioCambio());
        contratoVO.setMcoId(contrato.getMcoId());
        contratoVO.setMonId(contrato.getMonId());
        contratoVO.setTinId(contrato.getTinId());
        contratoVO.setTivId(contrato.getTivId());
        contratoVO.setTotalDeLaValorización(contrato.getTotalDeLaValorización());
       
        return contratoVO;
    }
    private Contrato toContrato(ContratoVO contratoVO){
        Contrato contrato=new Contrato();
        contrato.setAvanceObra(contratoVO.getAvanceObra());
        contrato.setCncId(contratoVO.getCncId());
        contrato.setConConcesion(contratoVO.getConConcesion());
        contrato.setConEstado(contratoVO.getConEstado());
        contrato.setConFechaAlta(contratoVO.getConFechaAlta());
        contrato.setConFechaBaja(contratoVO.getConFechaBaja());
        contrato.setConFechaCambio(contratoVO.getConFechaCambio());
        contrato.setConId(contratoVO.getConId());
        contrato.setConTerminal(contratoVO.getConTerminal());
        contrato.setConUsuarioAlta(contratoVO.getConUsuarioAlta());
        contrato.setConUsuarioBaja(contratoVO.getConUsuarioBaja());
        contrato.setConUsuarioCambio(contratoVO.getConUsuarioCambio());
        contrato.setMcoId(contratoVO.getMcoId());
        contrato.setMonId(contratoVO.getMonId());
        contrato.setTinId(contratoVO.getTinId());
        contrato.setTivId(contratoVO.getTivId());
        contrato.setTotalDeLaValorización(contratoVO.getTotalDeLaValorización());
        
        return contrato;
        
    }

    
}
