package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoEntregaDAOImpl;
import com.ositran.model.ContratoEntrega;
import com.ositran.service.ContratoEntregaService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ContratoEntregaVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ContratoEntregaServiceImpl  implements ContratoEntregaService{
    private ContratoEntregaDAOImpl contratoEntregaDAOImpl;
    
    public ContratoEntregaServiceImpl() {
        super();
    }

    @Override
    public List<ContratoEntregaVO> query() throws SQLException {
        List<ContratoEntrega> list = contratoEntregaDAOImpl.query();
        List<ContratoEntregaVO> listVO=toListContratoEntregaVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoEntregaVO contratoEntregaVO) throws SQLException {
        ContratoEntrega contratoEntrega=toContratoEntrega(contratoEntregaVO);
        String result = contratoEntregaDAOImpl.insert(contratoEntrega);
        return result;
    }

 

    @Override
    public String update(ContratoEntregaVO contratoEntregaVO) throws SQLException {
        ContratoEntrega contratoEntrega=toContratoEntrega(contratoEntregaVO);
        String result = contratoEntregaDAOImpl.update(contratoEntrega);
        return result;
    }

    @Override
    public ContratoEntregaVO get(Integer id) throws SQLException {
        ContratoEntrega contratoEntrega= contratoEntregaDAOImpl.get(id);
        ContratoEntregaVO contratoEntregaVO=toContratoEntregaVO(contratoEntrega);
        return contratoEntregaVO;
    }
    
    // conversiones
    private List<ContratoEntregaVO> toListContratoEntregaVO(List<ContratoEntrega> list){
        List<ContratoEntregaVO> listVO=new ArrayList<ContratoEntregaVO>();
        for(int i=0;i<list.size();i++){
            ContratoEntrega contratoEntrega=(ContratoEntrega)list.get(i);
            ContratoEntregaVO contratoEntregaVO=toContratoEntregaVO(contratoEntrega);
            listVO.add(contratoEntregaVO);
        }
        return listVO;
    }
    
    private ContratoEntregaVO toContratoEntregaVO(ContratoEntrega contratoEntrega){
        ContratoEntregaVO contratoEntregaVO=new ContratoEntregaVO();   
        contratoEntregaVO.setCenNombre(contratoEntrega.getCenNombre());
        contratoEntregaVO.setMonId(contratoEntrega.getMonId());
        contratoEntregaVO.setConId(contratoEntrega.getConId());                
        contratoEntregaVO.setCenId(contratoEntrega.getCenId());  
        contratoEntregaVO.setCenDescripcion(contratoEntrega.getCenDescripcion());
        contratoEntregaVO.setCenDocumentoFisico(contratoEntrega.getCenDocumentoFisico());
        contratoEntregaVO.setCenMonto(contratoEntrega.getCenMonto());
        contratoEntregaVO.setCenEntrega(contratoEntrega.getCenEntrega());
        contratoEntregaVO.setCenFecha(contratoEntrega.getCenFecha());
        contratoEntregaVO.setCenFechaDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoEntrega.getCenFecha()));
        return contratoEntregaVO;
    }
    
    private ContratoEntrega toContratoEntrega(ContratoEntregaVO contratoEntregaVO){
        ContratoEntrega contratoEntrega=new ContratoEntrega();        
                
        contratoEntrega.setMonId(contratoEntregaVO.getMonId());
        contratoEntrega.setConId(contratoEntregaVO.getConId());
        contratoEntrega.setCenMonto(contratoEntregaVO.getCenMonto());
        contratoEntrega.setCenId(contratoEntregaVO.getCenId());
        contratoEntrega.setCenFecha(contratoEntregaVO.getCenFecha());
        contratoEntrega.setCenDescripcion(contratoEntregaVO.getCenDescripcion());
        contratoEntrega.setCenDocumentoFisico(contratoEntregaVO.getCenDocumentoFisico());
        contratoEntrega.setCenEntrega(contratoEntregaVO.getCenEntrega());
        contratoEntrega.setCenEstado(contratoEntregaVO.getCenEstado());
        contratoEntrega.setCenNombre(contratoEntregaVO.getCenNombre());
        return contratoEntrega;
        
    }

    public ContratoEntregaDAOImpl getContratoEntregaDAOImpl() {
        return contratoEntregaDAOImpl;
    }

    public void setContratoEntregaDAOImpl(ContratoEntregaDAOImpl contratoEntregaDAOImpl) {
        this.contratoEntregaDAOImpl = contratoEntregaDAOImpl;
    }
    
    @Override    
    public List<ContratoEntregaVO> getEntregasContrato(Integer ConId) throws SQLException{
        List<ContratoEntrega> list = contratoEntregaDAOImpl.getEntregasContrato(ConId);
        List<ContratoEntregaVO> listVO=toListContratoEntregaVO(list);
        return listVO;
    }


}
