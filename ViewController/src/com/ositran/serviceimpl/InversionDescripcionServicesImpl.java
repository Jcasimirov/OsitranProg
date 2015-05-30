package com.ositran.serviceimpl;

import com.ositran.dao.InversionDescripcionDAO;
import com.ositran.model.InversionTipoDescripcion;
import com.ositran.service.InversionDescripcionServices;
import com.ositran.vo.bean.InversionDescripcionVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class InversionDescripcionServicesImpl implements InversionDescripcionServices {
    
    private InversionDescripcionDAO inversionDescripcionDAOimpl;
    private InversionTipoDescripcion inversionTipoDescripcion;
    private InversionDescripcionVO inversionDescripcionVO;

    @Override
    public int getCanNombres(String nombre) throws SQLException, Exception {
        int cantidad;
        cantidad =inversionDescripcionDAOimpl.getCanNombres(nombre);
        return cantidad;
    }

    @Override
    public List<InversionDescripcionVO> query()  throws SQLException ,Exception{
        List<InversionTipoDescripcion> list=inversionDescripcionDAOimpl.query();
        List<InversionDescripcionVO> listVO=toListInversionDescripcionVO(list);
        return listVO;
    }
    public List<InversionDescripcionVO> queryAllIdtEstado()  throws SQLException ,Exception{
        List<InversionTipoDescripcion> list=inversionDescripcionDAOimpl.queryAllIdtEstado();
        List<InversionDescripcionVO> listVO=toListInversionDescripcionVO(list);
        return listVO;
    }
    
    @Override
    public List<InversionDescripcionVO> query1(int codigoCompromiso) throws SQLException, Exception {
        List<InversionTipoDescripcion> list=inversionDescripcionDAOimpl.query1(codigoCompromiso);
        List<InversionDescripcionVO> listVO=toListInversionDescripcionVO(list);
        return listVO;
    }
    

    @Override
    public String insert(InversionDescripcionVO inversionDescrpcionVO)  throws SQLException ,Exception{
        inversionTipoDescripcion=inversionTipoDescripcion(inversionDescrpcionVO);
        String result=inversionDescripcionDAOimpl.insert(inversionTipoDescripcion);
        return result;      
    }

 

    @Override
    public String update(InversionDescripcionVO inversionDescrpcionVO) throws SQLException ,Exception {
        inversionTipoDescripcion=inversionTipoDescripcion(inversionDescrpcionVO);
        String result=this.getInversionDescripcionDAOimpl().update(inversionTipoDescripcion);
        return result;
    }

    @Override
    public InversionDescripcionVO get(Integer id) throws SQLException ,Exception {
        inversionTipoDescripcion =inversionDescripcionDAOimpl.get(id);
        inversionDescripcionVO=toInversionDescripcionVO(inversionTipoDescripcion);
        return inversionDescripcionVO;
    }

    @Override
    public List<InversionDescripcionVO> query1(String buscar) throws SQLException ,Exception {
        List<InversionTipoDescripcion> list=inversionDescripcionDAOimpl.query1(buscar);
        List<InversionDescripcionVO> listVO=toListInversionDescripcionVO(list);
        return listVO;
    }
    //conversiones
    private List<InversionDescripcionVO> toListInversionDescripcionVO(List<InversionTipoDescripcion> list){
       List<InversionDescripcionVO> listVO=new ArrayList<InversionDescripcionVO>();
       for(int i=0;i<list.size();i++){
           InversionTipoDescripcion inversionDescripcion=(InversionTipoDescripcion)list.get(i);
           InversionDescripcionVO inversionDescripcionVO=toInversionDescripcionVO(inversionDescripcion);
           listVO.add(inversionDescripcionVO);
       }
       return listVO;
    }
    private InversionDescripcionVO toInversionDescripcionVO(InversionTipoDescripcion inversionDescripcion){
        InversionDescripcionVO inversionDescripcionVO1 = new InversionDescripcionVO();
       inversionDescripcionVO1.setItdDescripcion(inversionDescripcion.getItdDescripcion());
       inversionDescripcionVO1.setItdEstado(inversionDescripcion.getItdEstado());
       inversionDescripcionVO1.setItdFechaAlta(inversionDescripcion.getItdFechaAlta());
       inversionDescripcionVO1.setItdFechaBaja(inversionDescripcion.getItdFechaBaja());
       inversionDescripcionVO1.setItdFechaCambio(inversionDescripcion.getItdFechaCambio());
       inversionDescripcionVO1.setItdNombre(inversionDescripcion.getItdNombre());
       inversionDescripcionVO1.setItdTerminal(inversionDescripcion.getItdTerminal());
       inversionDescripcionVO1.setItdUsuarioAlta(inversionDescripcion.getItdUsuarioAlta());
       inversionDescripcionVO1.setItdUsuarioBaja(inversionDescripcion.getItdUsuarioBaja());
       inversionDescripcionVO1.setItdUsuarioCambio(inversionDescripcion.getItdUsuarioCambio());
       inversionDescripcionVO1.setItdId(inversionDescripcion.getItdId());
       inversionDescripcionVO1.setTivId(inversionDescripcion.getTivId());
       return inversionDescripcionVO1;
        
    }
    private InversionTipoDescripcion inversionTipoDescripcion(InversionDescripcionVO inversionDescripcionVO){
        
        InversionTipoDescripcion inversionTipoDescripcion1=new InversionTipoDescripcion();
       inversionTipoDescripcion1.setItdDescripcion(inversionDescripcionVO.getItdDescripcion());
       inversionTipoDescripcion1.setItdEstado(inversionDescripcionVO.getItdEstado());
       inversionTipoDescripcion1.setItdFechaAlta(inversionDescripcionVO.getItdFechaAlta());
       inversionTipoDescripcion1.setItdFechaBaja(inversionDescripcionVO.getItdFechaBaja());
       inversionTipoDescripcion1.setItdFechaCambio(inversionDescripcionVO.getItdFechaCambio());
       inversionTipoDescripcion1.setItdNombre(inversionDescripcionVO.getItdNombre());
       inversionTipoDescripcion1.setItdTerminal(inversionDescripcionVO.getItdTerminal());
       inversionTipoDescripcion1.setItdUsuarioAlta(inversionDescripcionVO.getItdUsuarioAlta());
       inversionTipoDescripcion1.setItdUsuarioBaja(inversionDescripcionVO.getItdUsuarioBaja());
       inversionTipoDescripcion1.setItdUsuarioCambio(inversionDescripcionVO.getItdUsuarioCambio());
       inversionTipoDescripcion1.setItdId(inversionDescripcionVO.getItdId());
       inversionTipoDescripcion1.setTivId(inversionDescripcionVO.getTivId());
       return inversionTipoDescripcion1;
       
    }
    public void setInversionDescripcionDAOimpl(InversionDescripcionDAO inversionDescripcionDAOimpl) {
        this.inversionDescripcionDAOimpl = inversionDescripcionDAOimpl;
    }

    public InversionDescripcionDAO getInversionDescripcionDAOimpl() {
        return inversionDescripcionDAOimpl;
    }
    
    public void setInversionTipoDescripcion(InversionTipoDescripcion inversionTipoDescripcion) {
        this.inversionTipoDescripcion = inversionTipoDescripcion;
    }

    public InversionTipoDescripcion getInversionTipoDescripcion() {
        return inversionTipoDescripcion;
    }

    public void setInversionDescripcionVO(InversionDescripcionVO inversionDescripcionVO) {
        this.inversionDescripcionVO = inversionDescripcionVO;
    }

    public InversionDescripcionVO getInversionDescripcionVO() {
        return inversionDescripcionVO;
    }
    public boolean validarCodigoEnUso(InversionDescripcionVO inversionDescrpcionVO) throws Exception{
       InversionTipoDescripcion tipoDescripcion= inversionTipoDescripcion(inversionDescripcionVO);
        boolean concesion=inversionDescripcionDAOimpl.validarCodigoEnUso(tipoDescripcion);
        return concesion;
    }

   
}
