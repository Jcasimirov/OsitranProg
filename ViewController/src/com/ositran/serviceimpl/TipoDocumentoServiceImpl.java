package com.ositran.serviceimpl;


import com.ositran.daoimpl.TipoDocumentoDAOImpl;
import com.ositran.model.TipoDocumento;
import com.ositran.service.TipoDocumentoService;
import com.ositran.vo.bean.TipoDocumentoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

public class TipoDocumentoServiceImpl implements TipoDocumentoService{
    private TipoDocumentoDAOImpl tipodocumentoDAOImpl;


    public void setTipodocumentoDAOImpl(TipoDocumentoDAOImpl tipodocumentoDAOImpl) {
        this.tipodocumentoDAOImpl = tipodocumentoDAOImpl;
    }

    public TipoDocumentoDAOImpl getTipodocumentoDAOImpl() {
        return tipodocumentoDAOImpl;
    }

    public TipoDocumentoServiceImpl() {
        super();
    }

    @Override
    public List<TipoDocumentoVO> query() throws SQLException{
        List<TipoDocumento> list=tipodocumentoDAOImpl.query();
        List<TipoDocumentoVO> listVO=toListTipoDocumentoVO(list);
        return listVO;
    }

    @Override
    public String insert(TipoDocumentoVO tipodocumentoVO) throws SQLException{
        TipoDocumento tipodocumento=toTipoDocumento(tipodocumentoVO);
        String result=tipodocumentoDAOImpl.insert(tipodocumento);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result=this.tipodocumentoDAOImpl.delete(id);
        return result;
    }
    
     
    /*   public Integer cambiarEstado(Integer estado) {
        Integer result=this.igvDAOImpl.update(estado);
        return result;
    }  */

    @Override
    public String update(TipoDocumentoVO tipoDocumentoVO) throws SQLException{
        TipoDocumento tipoDocumento=toTipoDocumento(tipoDocumentoVO);
        String result=this.tipodocumentoDAOImpl.update(tipoDocumento);
        return result;
    }

    @Override
    public TipoDocumentoVO get(Integer id) throws SQLException{
        TipoDocumento tipoDocumento=this.tipodocumentoDAOImpl.get(id);
        TipoDocumentoVO tipoDocumentoVO=toTipoDocumentoVO(tipoDocumento);
        return tipoDocumentoVO;
    }
    
    
    
    //conversiones
    private List<TipoDocumentoVO> toListTipoDocumentoVO(List<TipoDocumento> list){
        List<TipoDocumentoVO> listVO=new ArrayList<TipoDocumentoVO>();
        for(int i=0;i<list.size();i++){
            TipoDocumento tipoDocumento=(TipoDocumento)list.get(i);
            TipoDocumentoVO tipoDocumentoVO=toTipoDocumentoVO(tipoDocumento);
            listVO.add(tipoDocumentoVO);
        }
        return listVO;
    }
    private TipoDocumentoVO toTipoDocumentoVO(TipoDocumento tipoDocumento){
        TipoDocumentoVO tipoDocumentoVO=new TipoDocumentoVO();
        tipoDocumentoVO.setTdoDescripcion(tipoDocumento.getTdoDescripcion());
        tipoDocumentoVO.setTdoEstado(tipoDocumento.getTdoEstado());
        tipoDocumentoVO.setTdoFechaAlta(tipoDocumento.getTdoFechaAlta());
        tipoDocumentoVO.setTdoFechaBaja(tipoDocumento.getTdoFechaBaja());
        tipoDocumentoVO.setTdoFechaCambio(tipoDocumento.getTdoFechaCambio());
        tipoDocumentoVO.setTdoId(tipoDocumento.getTdoId());
        tipoDocumentoVO.setTdoNombre(tipoDocumento.getTdoNombre());
        tipoDocumentoVO.setTdoTerminal(tipoDocumento.getTdoTerminal());
        tipoDocumentoVO.setTdoUsuarioAlta(tipoDocumento.getTdoUsuarioAlta());
        tipoDocumentoVO.setTdoUsuarioBaja(tipoDocumento.getTdoUsuarioBaja());
        tipoDocumentoVO.setTdoUsuarioCambio(tipoDocumento.getTdoUsuarioCambio()); 
              
        return tipoDocumentoVO;
    }
    private TipoDocumento toTipoDocumento(TipoDocumentoVO tipoDocumentoVO){
        TipoDocumento tipoDocumento=new TipoDocumento();
        tipoDocumento.setTdoDescripcion(tipoDocumentoVO.getTdoDescripcion());
        tipoDocumento.setTdoEstado(tipoDocumentoVO.getTdoEstado());
        tipoDocumento.setTdoFechaAlta(tipoDocumentoVO.getTdoFechaAlta());
        tipoDocumento.setTdoFechaBaja(tipoDocumentoVO.getTdoFechaBaja());
        tipoDocumento.setTdoFechaCambio(tipoDocumentoVO.getTdoFechaCambio());
        tipoDocumento.setTdoId(tipoDocumentoVO.getTdoId());
        tipoDocumento.setTdoNombre(tipoDocumentoVO.getTdoNombre());
        tipoDocumento.setTdoTerminal(tipoDocumentoVO.getTdoTerminal());
        tipoDocumento.setTdoUsuarioAlta(tipoDocumentoVO.getTdoUsuarioAlta());
        tipoDocumento.setTdoUsuarioBaja(tipoDocumentoVO.getTdoUsuarioBaja());
        tipoDocumento.setTdoUsuarioCambio(tipoDocumentoVO.getTdoUsuarioCambio()); 
        
        
        return tipoDocumento;
        
    }







   
}
