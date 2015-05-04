package com.ositran.serviceimpl;

import com.ositran.daoimpl.AsignarResponsableSupDAOImpl;
import com.ositran.model.ContratoResSupDetalle;
import com.ositran.model.ContratoRespSup;
import com.ositran.service.AsignarResponsableSupervisionService;
import com.ositran.vo.bean.ContratoResSupDetalleVO;
import com.ositran.vo.bean.ContratoRespSupVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsignarResponsableSupervisionServiceImpl implements AsignarResponsableSupervisionService{
    private AsignarResponsableSupDAOImpl asignarResponsableSupDAOImpl;


    public void setAsignarResponsableSupDAOImpl(AsignarResponsableSupDAOImpl asignarResponsableSupDAOImpl) {
        this.asignarResponsableSupDAOImpl = asignarResponsableSupDAOImpl;
    }

    public AsignarResponsableSupDAOImpl getAsignarResponsableSupDAOImpl() {
        return asignarResponsableSupDAOImpl;
    }


    public AsignarResponsableSupervisionServiceImpl() {
        super();
    }

    @Override
    public List<ContratoResSupDetalleVO> ListarDetalle(int codigoContrato, int compromiso) throws SQLException{
        List<ContratoResSupDetalle> list=asignarResponsableSupDAOImpl.ListarDetalle(codigoContrato,compromiso);
        List<ContratoResSupDetalleVO> listVO=toListContratoResSupDetalleVO(list);
        return listVO;
    }
    
    @Override
    public ContratoRespSupVO insertCab(ContratoRespSupVO contratoRespSupVO) throws SQLException{
        ContratoRespSup contratoRespSup=toContratoRespSup(contratoRespSupVO);
        contratoRespSup=asignarResponsableSupDAOImpl.insertCab(contratoRespSup);
        contratoRespSupVO=toContratoRespSupVO(contratoRespSup);
        return contratoRespSupVO;
    }
    
    @Override
    public String insertDet(ContratoResSupDetalleVO contratoResSupDetalleVO) throws SQLException{
        ContratoResSupDetalle contratoResSupDetalle=toContratoResSupDetalle(contratoResSupDetalleVO);
        String result=asignarResponsableSupDAOImpl.insertDet(contratoResSupDetalle);
        return result;
    }
    

    @Override
    public String updateDet(ContratoResSupDetalleVO contratoResSupDetalleVO) throws SQLException{
        ContratoResSupDetalle contratoResSupDetalle=toContratoResSupDetalle(contratoResSupDetalleVO);
        String result=this.asignarResponsableSupDAOImpl.updateDet(contratoResSupDetalle);
        return result;
    }

    @Override
    public ContratoRespSupVO getCab(Integer id) throws SQLException{
        ContratoRespSup contratoRespSup=this.asignarResponsableSupDAOImpl.getCab(id);
        ContratoRespSupVO contratoRespSupVO=toContratoRespSupVO(contratoRespSup);
        return contratoRespSupVO;
    }
    
    @Override
    public ContratoResSupDetalleVO getDet(Integer id) throws SQLException{
        ContratoResSupDetalle contratoResSupDetalle=this.asignarResponsableSupDAOImpl.getDet(id);
        ContratoResSupDetalleVO contratoResSupDetalleVO=toContratoResSupDetalleVO(contratoResSupDetalle);
        return contratoResSupDetalleVO;
    }
    
     
    //conversiones
    private List<ContratoRespSupVO> toListContratoRespSupVO(List<ContratoRespSup> list){
        List<ContratoRespSupVO> listVO=new ArrayList<ContratoRespSupVO>();
        for(int i=0;i<list.size();i++){
            ContratoRespSup contratoRespSup=(ContratoRespSup)list.get(i);
            ContratoRespSupVO contratoRespSupVO=toContratoRespSupVO(contratoRespSup);
            listVO.add(contratoRespSupVO);
        }
        return listVO;
    }
    private ContratoRespSupVO toContratoRespSupVO(ContratoRespSup contratoRespSup){
        ContratoRespSupVO contratoRespSupVO=new ContratoRespSupVO();
        
        contratoRespSupVO.setCsiId(contratoRespSup.getCsiId());
        contratoRespSupVO.setInfId(contratoRespSup.getInfId());
        contratoRespSupVO.setInvId(contratoRespSup.getInvId());
        contratoRespSupVO.setMcoId(contratoRespSup.getMcoId());
        contratoRespSupVO.setRsuId(contratoRespSup.getRsuId());
        contratoRespSupVO.setTinId(contratoRespSup.getTinId());
        contratoRespSupVO.setTsiId(contratoRespSup.getTsiId()); 
        contratoRespSupVO.setCcoId(contratoRespSup.getCcoId());
        contratoRespSupVO.setConId(contratoRespSup.getConId());
        contratoRespSupVO.setTccTipo(contratoRespSup.getTccTipo());        
    
        return contratoRespSupVO;
    }
    private ContratoRespSup toContratoRespSup(ContratoRespSupVO contratoRespSupVO){
        ContratoRespSup contratoRespSup=new ContratoRespSup();
        
        contratoRespSup.setCsiId(contratoRespSupVO.getCsiId());
        contratoRespSup.setInfId(contratoRespSupVO.getInfId());
        contratoRespSup.setInvId(contratoRespSupVO.getInvId());
        contratoRespSup.setMcoId(contratoRespSupVO.getMcoId());
        contratoRespSup.setRsuId(contratoRespSupVO.getRsuId());
        contratoRespSup.setTinId(contratoRespSupVO.getTinId());
        contratoRespSup.setTsiId(contratoRespSupVO.getTsiId()); 
        contratoRespSup.setCcoId(contratoRespSupVO.getCcoId());
        contratoRespSup.setConId(contratoRespSupVO.getConId());
        contratoRespSup.setTccTipo(contratoRespSupVO.getTccTipo());    
        
        return contratoRespSup;
        
    }
    
    private List<ContratoResSupDetalleVO> toListContratoResSupDetalleVO(List<ContratoResSupDetalle> list){
        List<ContratoResSupDetalleVO> listVO=new ArrayList<ContratoResSupDetalleVO>();
        for(int i=0;i<list.size();i++){
            ContratoResSupDetalle contratoResSupDetalle=(ContratoResSupDetalle)list.get(i);
            ContratoResSupDetalleVO contratoResSupDetalleVO=toContratoResSupDetalleVO(contratoResSupDetalle);
            listVO.add(contratoResSupDetalleVO);
        }
        return listVO;
    }
    
    private ContratoResSupDetalleVO toContratoResSupDetalleVO(ContratoResSupDetalle contratoResSupDetalle){
        ContratoResSupDetalleVO contratoResSupDetalleVO=new ContratoResSupDetalleVO();
        
        contratoResSupDetalleVO.setConId(contratoResSupDetalle.getConId());
        contratoResSupDetalleVO.setRsdEstado(contratoResSupDetalle.getRsdEstado());
        contratoResSupDetalleVO.setRsdFechaAsignacion(contratoResSupDetalle.getRsdFechaAsignacion());
        contratoResSupDetalleVO.setRsdId(contratoResSupDetalle.getRsdId());
        contratoResSupDetalleVO.setRsdNroDocumento(contratoResSupDetalle.getRsdNroDocumento());
        contratoResSupDetalleVO.setRsuId(contratoResSupDetalle.getRsuId());
        contratoResSupDetalleVO.setTccTipo(contratoResSupDetalle.getTccTipo());
        contratoResSupDetalleVO.setTdoId(contratoResSupDetalle.getTdoId());
        contratoResSupDetalleVO.setTipoSup(contratoResSupDetalle.getTipoSup());
        contratoResSupDetalleVO.setCcoId(contratoResSupDetalle.getCcoId());
        contratoResSupDetalleVO.setInfId(contratoResSupDetalle.getInfId());
        contratoResSupDetalleVO.setInvId(contratoResSupDetalle.getInvId());
        contratoResSupDetalleVO.setCodigoSup(contratoResSupDetalle.getCodigoSup());
    
        return contratoResSupDetalleVO;
    }
    
    private ContratoResSupDetalle toContratoResSupDetalle(ContratoResSupDetalleVO contratoResSupDetalleVO){
        ContratoResSupDetalle contratoResSupDetalle=new ContratoResSupDetalle();
        
        contratoResSupDetalle.setConId(contratoResSupDetalleVO.getConId());
        contratoResSupDetalle.setRsdEstado(contratoResSupDetalleVO.getRsdEstado());
        contratoResSupDetalle.setRsdFechaAsignacion(contratoResSupDetalleVO.getRsdFechaAsignacion());
        contratoResSupDetalle.setRsdId(contratoResSupDetalleVO.getRsdId());
        contratoResSupDetalle.setRsdNroDocumento(contratoResSupDetalleVO.getRsdNroDocumento());
        contratoResSupDetalle.setRsuId(contratoResSupDetalleVO.getRsuId());
        contratoResSupDetalle.setTccTipo(contratoResSupDetalleVO.getTccTipo());
        contratoResSupDetalle.setTdoId(contratoResSupDetalleVO.getTdoId());
        contratoResSupDetalle.setTipoSup(contratoResSupDetalleVO.getTipoSup());
        contratoResSupDetalle.setCcoId(contratoResSupDetalleVO.getCcoId());
        contratoResSupDetalle.setInfId(contratoResSupDetalleVO.getInfId());
        contratoResSupDetalle.setInvId(contratoResSupDetalleVO.getInvId());
        contratoResSupDetalle.setCodigoSup(contratoResSupDetalleVO.getCodigoSup());

        return contratoResSupDetalle;
    }
    
    // Validar si Existe Concesion 
    public ContratoRespSupVO ValidaCab(Integer concesion, Integer compromiso) throws SQLException{
        ContratoRespSup contratoRespSup= asignarResponsableSupDAOImpl.ValidaCab(concesion,compromiso);
        if(contratoRespSup != null){
            ContratoRespSupVO contratoRespSupVO=toContratoRespSupVO(contratoRespSup);
            return contratoRespSupVO;
        }
        return null;  
    }
    
    
    public String ObtieneNombre(Integer tipoDoc, String NroDocumento,Integer tipoSup) throws SQLException{
        String nombre = asignarResponsableSupDAOImpl.ObtieneNombre(tipoDoc, NroDocumento, tipoSup );
        return nombre;
    }
    
    public int ValidaAsignación(Integer contrato, Integer tipoInfra, Integer compromiso, Integer concesion, Integer aeropuerto, Integer inversion, Integer tipoDoc, String nroDoc, Integer tipoQuery) throws SQLException{
        int validacion = asignarResponsableSupDAOImpl.ValidaAsignación(contrato, tipoInfra, compromiso, concesion, aeropuerto, inversion, tipoDoc, nroDoc, tipoQuery);
        return validacion;
    }
    
    @Override
    public List<ContratoResSupDetalleVO> BuscarAsignacion(Integer contrato, Integer etapa, Integer aeropuerto, Integer inversion, Integer tipoSupervision) throws SQLException{
        List<ContratoResSupDetalle> list=asignarResponsableSupDAOImpl.BuscarAsignacion(contrato, etapa,aeropuerto,inversion,tipoSupervision);        
        List<ContratoResSupDetalleVO> listVO=toListContratoResSupDetalleVO(list);
        for (int i =0 ; i< listVO.size() ; i++){
            String nombre = ObtieneNombre(listVO.get(i).getTdoId(), listVO.get(i).getRsdNroDocumento(),listVO.get(i).getTipoSup());
            listVO.get(i).setNombresup(nombre);
        }
        
        return listVO;
    }

   
}
