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

    @Override
    public String insert(InversionDescripcionVO inversionDescrpcionVO)  throws SQLException ,Exception{
        inversionTipoDescripcion=inversionTipoDescripcion(inversionDescrpcionVO);
        String result=inversionDescripcionDAOimpl.insert(inversionTipoDescripcion);
        return result;      
    }

    @Override
    public String delete(Integer id)  throws SQLException ,Exception{
        String result=this.getInversionDescripcionDAOimpl().delete(id);
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
       inversionDescripcionVO.setItdDescripcion(inversionDescripcion.getItdDescripcion());
       inversionDescripcionVO.setItdEstado(inversionDescripcion.getItdEstado());
       inversionDescripcionVO.setItdFechaAlta(inversionDescripcion.getItdFechaAlta());
       inversionDescripcionVO.setItdFechaBaja(inversionDescripcion.getItdFechaBaja());
       inversionDescripcionVO.setItdFechaCambio(inversionDescripcion.getItdFechaCambio());
       inversionDescripcionVO.setItdNombre(inversionDescripcion.getItdNombre());
       inversionDescripcionVO.setItdTerminal(inversionDescripcion.getItdTerminal());
       inversionDescripcionVO.setItdUsuarioAlta(inversionDescripcion.getItdUsuarioAlta());
       inversionDescripcionVO.setItdUsuarioBaja(inversionDescripcion.getItdUsuarioBaja());
       inversionDescripcionVO.setItdUsuarioCambio(inversionDescripcion.getItdUsuarioCambio());
       inversionDescripcionVO.setItdId(inversionDescripcion.getItdId());
       inversionDescripcionVO.setTivId(inversionDescripcion.getTivId());
       return inversionDescripcionVO;
        
    }
    private InversionTipoDescripcion inversionTipoDescripcion(InversionDescripcionVO inversionDescripcionVO){
       inversionTipoDescripcion.setItdDescripcion(inversionDescripcionVO.getItdDescripcion());
       inversionTipoDescripcion.setItdEstado(inversionDescripcionVO.getItdEstado());
       inversionTipoDescripcion.setItdFechaAlta(inversionDescripcionVO.getItdFechaAlta());
       inversionTipoDescripcion.setItdFechaBaja(inversionDescripcionVO.getItdFechaBaja());
       inversionTipoDescripcion.setItdFechaCambio(inversionDescripcionVO.getItdFechaCambio());
       inversionTipoDescripcion.setItdNombre(inversionDescripcionVO.getItdNombre());
       inversionTipoDescripcion.setItdTerminal(inversionDescripcionVO.getItdTerminal());
       inversionTipoDescripcion.setItdUsuarioAlta(inversionDescripcionVO.getItdUsuarioAlta());
       inversionTipoDescripcion.setItdUsuarioBaja(inversionDescripcionVO.getItdUsuarioBaja());
       inversionTipoDescripcion.setItdUsuarioCambio(inversionDescripcionVO.getItdUsuarioCambio());
       inversionTipoDescripcion.setItdId(inversionDescripcionVO.getItdId());
       inversionTipoDescripcion.setTivId(inversionDescripcionVO.getTivId());
       
       return inversionTipoDescripcion;
       
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

   
}
