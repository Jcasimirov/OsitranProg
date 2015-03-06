package com.ositran.serviceimpl;

import com.ositran.dao.TipoInversionDAO;
import com.ositran.service.TipoInversionServices;
import com.ositran.model.InversionTipo;
import com.ositran.vo.bean.TipoInversionVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TipoInversionServiceImpl implements TipoInversionServices{
    TipoInversionDAO tipoInversionDAOImpl;
    InversionTipo inversionTipo;
    TipoInversionVO tipoInversionVO;
    
    
    @Override
    public int getCanNombres(String nombre) throws SQLException, Exception {
        int cantidad;
        cantidad =tipoInversionDAOImpl.getCanNombres(nombre);
        return cantidad;
    }
    
    @Override
    public List<TipoInversionVO> query()  throws SQLException ,Exception{
        List<InversionTipo> list=tipoInversionDAOImpl.query();
        List<TipoInversionVO> listVO=toListTipoInversionVO(list);
        return listVO;
    }
    

    @Override
    public String insert(TipoInversionVO tipoInversionVO) throws SQLException ,Exception{
        InversionTipo inversionTipo=toTipoInversion(tipoInversionVO);
        String result=tipoInversionDAOImpl.insert(inversionTipo);
        return result;
       
    }
    
    @Override
    public List<TipoInversionVO> query1(String buscar)  throws SQLException ,Exception{
    
        List<InversionTipo> list=tipoInversionDAOImpl.query1(buscar);
        List<TipoInversionVO> listVO=toListTipoInversionVO(list);
        return listVO;
    }
    
    @Override
    public String delete(Integer id) throws SQLException ,Exception{
        String result=this.getTipoInversionDAOImpl().delete(id);
        return result;
    }

    @Override
    public String update(TipoInversionVO tipoInversionVO)  throws SQLException ,Exception{
        InversionTipo inversionTipo=toTipoInversion(tipoInversionVO);
        String result=this.getTipoInversionDAOImpl().update(inversionTipo);
        return result;
    }

    @Override
    public TipoInversionVO get(Integer id) throws SQLException ,Exception{
        inversionTipo =tipoInversionDAOImpl.get(id);
        tipoInversionVO=toTipoInversionVO(inversionTipo);
        return tipoInversionVO;
    }
     //conversiones
    private List<TipoInversionVO> toListTipoInversionVO(List<InversionTipo> list)  {
        List<TipoInversionVO> listVO=new ArrayList<TipoInversionVO>();
        for(int i=0;i<list.size();i++){
            inversionTipo=(InversionTipo)list.get(i);
            tipoInversionVO=toTipoInversionVO(inversionTipo);
            listVO.add(tipoInversionVO);
        }
        return listVO;
    }
    private TipoInversionVO toTipoInversionVO(InversionTipo inversionTipo)  {
        tipoInversionVO.setTivDescripcion(inversionTipo.getTivDescripcion());
        tipoInversionVO.setTivEstado(inversionTipo.getTivEstado());
        try {
            tipoInversionVO.setTivFechaAlta(inversionTipo.getTivFechaAlta());
            tipoInversionVO.setTivFechaBaja(inversionTipo.getTivFechaBaja());
        } catch (Exception e) {
            e.printStackTrace();
        }
        tipoInversionVO.setTivFechaCambio(inversionTipo.getTivFechaCambio());
        tipoInversionVO.setTivNombre(inversionTipo.getTivNombre());
        tipoInversionVO.setTivTerminal(inversionTipo.getTivTerminal());
        tipoInversionVO.setTivUsuarioAlta(inversionTipo.getTivUsuarioAlta());
        tipoInversionVO.setTivUsuarioBaja(inversionTipo.getTivUsuarioBaja());
        tipoInversionVO.setTivUsuarioCambio(inversionTipo.getTivUsuarioCambio());
        tipoInversionVO.setTivId(inversionTipo.getTivId());
        return tipoInversionVO;
    }
    private InversionTipo toTipoInversion(TipoInversionVO tipoInversionVO)  {
        InversionTipo inversionTipo=new InversionTipo();
        inversionTipo.setTivDescripcion(tipoInversionVO.getTivDescripcion());
        inversionTipo.setTivEstado(tipoInversionVO.getTivEstado());
        inversionTipo.setTivFechaAlta(tipoInversionVO.getTivFechaAlta());
        inversionTipo.setTivFechaBaja(tipoInversionVO.getTivFechaBaja());
        inversionTipo.setTivFechaCambio(tipoInversionVO.getTivFechaCambio());
        inversionTipo.setTivNombre(tipoInversionVO.getTivNombre());
        inversionTipo.setTivTerminal(tipoInversionVO.getTivTerminal());
        inversionTipo.setTivUsuarioAlta(tipoInversionVO.getTivUsuarioAlta());
        inversionTipo.setTivUsuarioBaja(tipoInversionVO.getTivUsuarioBaja());
        inversionTipo.setTivUsuarioCambio(tipoInversionVO.getTivUsuarioCambio());
        inversionTipo.setTivId(tipoInversionVO.getTivId());
        
        return inversionTipo;
    }
    
    public void setTipoInversionDAOImpl(TipoInversionDAO tipoInversionDAOImpl) {
        this.tipoInversionDAOImpl = tipoInversionDAOImpl;
    }

    public TipoInversionDAO getTipoInversionDAOImpl() {
        return tipoInversionDAOImpl;
    }

    public void setInversionTipo(InversionTipo inversionTipo) {
        this.inversionTipo = inversionTipo;
    }

    public InversionTipo getInversionTipo() {
        return inversionTipo;
    }

    public void setTipoInversionVO(TipoInversionVO tipoInversionVO) {
        this.tipoInversionVO = tipoInversionVO;
    }

    public TipoInversionVO getTipoInversionVO() {
        return tipoInversionVO;
    }

}
