package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoInversionDAOImpl;
import com.ositran.model.ContratoInversion;
import com.ositran.service.ContratoInversionService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ContratoInversionVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ContratoInversionServiceImpl implements ContratoInversionService {
    private ContratoInversionDAOImpl contratoInversionDAOImpl;
    
    public ContratoInversionServiceImpl() {
        super();
    }

    @Override
    public List<ContratoInversionVO> query() throws SQLException {
        List<ContratoInversion> list = contratoInversionDAOImpl.query();
        List<ContratoInversionVO> listVO=toListContratoInversionVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoInversionVO contratoInversionVO) throws SQLException {
        ContratoInversion contratoInversion=toContratoInversion(contratoInversionVO);
        String result = contratoInversionDAOImpl.insert(contratoInversion);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = contratoInversionDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoInversionVO contratoInversionVO) throws SQLException {
        ContratoInversion contratoInversion=toContratoInversion(contratoInversionVO);
        String result = contratoInversionDAOImpl.update(contratoInversion);
        return result;
    }

    @Override
    public ContratoInversionVO get(Integer id) throws SQLException {
        ContratoInversion contratoInversion= contratoInversionDAOImpl.get(id);
        ContratoInversionVO contratoInversionVO=toContratoInversionVO(contratoInversion);
        return contratoInversionVO;
    }
    
    // conversiones
    private List<ContratoInversionVO> toListContratoInversionVO(List<ContratoInversion> list){
        List<ContratoInversionVO> listVO=new ArrayList<ContratoInversionVO>();
        for(int i=0;i<list.size();i++){
            ContratoInversion contratoInversion=(ContratoInversion)list.get(i);
            ContratoInversionVO contratoInversionVO=toContratoInversionVO(contratoInversion);
            listVO.add(contratoInversionVO);
        }
        return listVO;
    }
    
    private ContratoInversionVO toContratoInversionVO(ContratoInversion contratoInversion){
        ContratoInversionVO contratoInversionVO=new ContratoInversionVO();
        
        contratoInversionVO.setConId(contratoInversion.getConId());
        contratoInversionVO.setCsiId(contratoInversion.getCsiId());
        contratoInversionVO.setInfId(contratoInversion.getInfId());
        contratoInversionVO.setInvDescripcion(contratoInversion.getInvDescripcion());
        contratoInversionVO.setInvEstado(contratoInversion.getInvEstado());
        contratoInversionVO.setInvId(contratoInversion.getInvId());
        contratoInversionVO.setTinId(contratoInversion.getTinId());                        
        
        contratoInversionVO.setInvFechaAlta(contratoInversion.getInvFechaAlta());
        contratoInversionVO.setInvUsuarioAlta(contratoInversion.getInvUsuarioAlta());
        contratoInversionVO.setInvFechaCambio(contratoInversion.getInvFechaCambio());
        contratoInversionVO.setInvUsuarioCambio(contratoInversion.getInvUsuarioCambio());
        contratoInversionVO.setInvFechaBaja(contratoInversion.getInvFechaBaja());
        contratoInversionVO.setInvUsuarioBaja(contratoInversion.getInvUsuarioBaja());
        return contratoInversionVO;
    }
    
    private ContratoInversion toContratoInversion(ContratoInversionVO contratoInversionVO){
        ContratoInversion contratoInversion=new ContratoInversion();           
        
        contratoInversion.setConId(contratoInversionVO.getConId());
        contratoInversion.setCsiId(contratoInversionVO.getCsiId());
        contratoInversion.setInfId(contratoInversionVO.getInfId());
        contratoInversion.setInvDescripcion(contratoInversionVO.getInvDescripcion());
        contratoInversion.setInvEstado(contratoInversionVO.getInvEstado());
        contratoInversion.setInvId(contratoInversionVO.getInvId());
        contratoInversion.setTinId(contratoInversionVO.getTinId());  
        
        contratoInversion.setInvFechaAlta(contratoInversionVO.getInvFechaAlta());
        contratoInversion.setInvUsuarioAlta(contratoInversionVO.getInvUsuarioAlta());
        contratoInversion.setInvFechaCambio(contratoInversionVO.getInvFechaCambio());
        contratoInversion.setInvUsuarioCambio(contratoInversionVO.getInvUsuarioCambio());
        contratoInversion.setInvFechaBaja(contratoInversionVO.getInvFechaBaja());
        contratoInversion.setInvUsuarioBaja(contratoInversionVO.getInvUsuarioBaja());
        contratoInversion.setInvTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
        return contratoInversion;
        
    }

    public ContratoInversionDAOImpl getContratoInversionDAOImpl() {
        return contratoInversionDAOImpl;
    }

    public void setContratoInversionDAOImpl(ContratoInversionDAOImpl contratoInversionDAOImpl) {
        this.contratoInversionDAOImpl = contratoInversionDAOImpl;
    }
    

    public List<ContratoInversionVO> getInversionesContratoenRectificacion(Integer conId) throws SQLException{
        List<ContratoInversion> list = contratoInversionDAOImpl.getInversionesContratoenRectificacion(conId);
        List<ContratoInversionVO> listVO=toListContratoInversionVO(list);
        return listVO;
    }
    @Override
        public List<ContratoInversionVO> ListaPorAeropuerto(int contrato, int tipoInfraestructura, int concesion, int infraestructura) throws SQLException{
            List<ContratoInversion> list=contratoInversionDAOImpl.ListaPorAeropuerto(contrato,tipoInfraestructura,concesion,infraestructura);
            List<ContratoInversionVO> listVO=toListContratoInversionVO(list);
            return listVO;
        }
    public String insertListaInversion(List<ContratoInversionVO> lista) throws SQLException {
        List<ContratoInversion> ci=new ArrayList<ContratoInversion>();
        for (ContratoInversionVO inversion : lista) {
           ContratoInversion contratoInversion=toContratoInversion(inversion);
           ci.add(contratoInversion);          
       }
        String result="";
        result=contratoInversionDAOImpl.insertListaInversion(ci);
        return result;
    }
    public String updateInversionxInfraestructuras(int contratoId,
                                                   int csiId,
                                                   int tinId,
                                                   int infId,
                                                   String usuario,String terminal) throws SQLException{
        String result="";
        result=contratoInversionDAOImpl.updateInversionxInfraestructuras(contratoId,
                                                                         csiId, 
                                                                         tinId,
                                                                         infId,
                                                                         usuario,terminal);
        return result;
    }
    public boolean validaNoExisteNombreInversion(int contratoId,
                                                   int csiId,
                                                   int tinId,
                                                   int infId,
                                                String nombreInversion)throws Exception{
        boolean noExiste=false;
        noExiste=contratoInversionDAOImpl.validaNoExisteNombreInversion(contratoId,
                                                                         csiId, 
                                                                         tinId,
                                                                         infId,nombreInversion);
        return noExiste;                                              
    }
    public boolean validaInversionNoEstaEnUso(Integer idInversion)throws Exception{
      boolean noEstaEnUso=  contratoInversionDAOImpl.validaInversionNoEstaEnUso(idInversion);
      return noEstaEnUso;
    }
}
