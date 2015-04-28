package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoHitoDAOImpl;
import com.ositran.model.ContratoHito;
import com.ositran.service.ContratoHitoService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ContratoHitoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ContratoHitoServiceImpl implements ContratoHitoService {
    private ContratoHitoDAOImpl contratoHitoDAOImpl;
    
    public ContratoHitoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoHitoVO> query() throws SQLException {
        List<ContratoHito> list = contratoHitoDAOImpl.query();
        List<ContratoHitoVO> listVO=toListContratoHitoVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoHitoVO contratoHitoVO) throws SQLException {
        System.out.println("INICIO HitoServ");
        ContratoHito contratoHito=toContratoHito(contratoHitoVO);
        String result = contratoHitoDAOImpl.insert(contratoHito);
        System.out.println("FIN HitoServ");
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = contratoHitoDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoHitoVO contratoHitoVO) throws SQLException {
        ContratoHito contratoHito=toContratoHito(contratoHitoVO);
        String result = contratoHitoDAOImpl.update(contratoHito);
        return result;
    }

    @Override
    public ContratoHitoVO get(Integer id) throws SQLException {
        ContratoHito contratoHito= contratoHitoDAOImpl.get(id);
        ContratoHitoVO contratoHitoVO=toContratoHitoVO(contratoHito);
        return contratoHitoVO;
    }
    
    // conversiones
    private List<ContratoHitoVO> toListContratoHitoVO(List<ContratoHito> list){
        List<ContratoHitoVO> listVO=new ArrayList<ContratoHitoVO>();
        for(int i=0;i<list.size();i++){
            ContratoHito contratoHito=(ContratoHito)list.get(i);
            ContratoHitoVO contratoHitoVO=toContratoHitoVO(contratoHito);
            listVO.add(contratoHitoVO);
        }
        return listVO;
    }
    
    private ContratoHitoVO toContratoHitoVO(ContratoHito contratoHito){
        ContratoHitoVO contratoHitoVO=new ContratoHitoVO();
        
        contratoHitoVO.setConId(contratoHito.getConId());
        contratoHitoVO.setHtoEstado(contratoHito.getHtoEstado());
        contratoHitoVO.setHtoFecha(contratoHito.getHtoFecha());
        contratoHitoVO.setHtoFechaDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoHito.getHtoFecha()));
        contratoHitoVO.setHtoId(contratoHito.getHtoId());
        contratoHitoVO.setHtoMonto(contratoHito.getHtoMonto());        
        contratoHitoVO.setHtoPdf(contratoHito.getHtoPdf());
        contratoHitoVO.setMonId(contratoHito.getMonId());
        contratoHitoVO.setHtoNombre(contratoHito.getHtoNombre());
                    
        contratoHitoVO.setHtoFechaAlta(contratoHito.getHtoFechaAlta());
        contratoHitoVO.setHtoUsuarioAlta(contratoHito.getHtoUsuarioAlta());
        contratoHitoVO.setHtoFechaCambio(contratoHito.getHtoFechaCambio());
        contratoHitoVO.setHtoUsuarioCambio(contratoHito.getHtoUsuarioCambio());
        contratoHitoVO.setHtoFechaBaja(contratoHito.getHtoFechaBaja());
        contratoHitoVO.setHtoUsuarioBaja(contratoHito.getHtoUsuarioBaja());
        
        return contratoHitoVO;
    }
    
    private ContratoHito toContratoHito(ContratoHitoVO contratoHitoVO){
        ContratoHito contratoHito=new ContratoHito();           
        
        contratoHito.setConId(contratoHitoVO.getConId());
        contratoHito.setHtoEstado(contratoHitoVO.getHtoEstado());
        contratoHito.setHtoFecha(contratoHitoVO.getHtoFecha());
        contratoHito.setHtoId(contratoHitoVO.getHtoId());
        contratoHito.setHtoMonto(contratoHitoVO.getHtoMonto());        
        contratoHito.setHtoPdf(contratoHitoVO.getHtoPdf());
        contratoHito.setMonId(contratoHitoVO.getMonId());
        contratoHito.setHtoNombre(contratoHitoVO.getHtoNombre());
        
        contratoHito.setHtoFechaAlta(contratoHitoVO.getHtoFechaAlta());
        contratoHito.setHtoUsuarioAlta(contratoHitoVO.getHtoUsuarioAlta());
        contratoHito.setHtoFechaCambio(contratoHitoVO.getHtoFechaCambio());
        contratoHito.setHtoUsuarioCambio(contratoHitoVO.getHtoUsuarioCambio());
        contratoHito.setHtoFechaBaja(contratoHitoVO.getHtoFechaBaja());
        contratoHito.setHtoUsuarioBaja(contratoHitoVO.getHtoUsuarioBaja());
        return contratoHito;
        
    }

    public ContratoHitoDAOImpl getContratoHitoDAOImpl() {
        return contratoHitoDAOImpl;
    }

    public void setContratoHitoDAOImpl(ContratoHitoDAOImpl contratoHitoDAOImpl) {
        this.contratoHitoDAOImpl = contratoHitoDAOImpl;
    }
    
    @Override    
    public List<ContratoHitoVO> getHitosContrato(Integer ConId) throws SQLException{
        List<ContratoHito> list = contratoHitoDAOImpl.getHitosContrato(ConId);
        List<ContratoHitoVO> listVO=toListContratoHitoVO(list);
        return listVO;
    }
}
