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
    
    public boolean validarCodigoEnUso(Integer tivId) throws Exception{
        boolean valido=tipoInversionDAOImpl.validarCodigoEnUso(tivId);
        return valido;
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
        TipoInversionVO toTipoInversionVO2=new TipoInversionVO();
        
        toTipoInversionVO2.setTivDescripcion(inversionTipo.getTivDescripcion());
        toTipoInversionVO2.setTivEstado(inversionTipo.getTivEstado());
        try {
            toTipoInversionVO2.setTivFechaAlta(inversionTipo.getTivFechaAlta());
            toTipoInversionVO2.setTivFechaBaja(inversionTipo.getTivFechaBaja());
        } catch (Exception e) {
            e.printStackTrace();
        }
        toTipoInversionVO2.setTivFechaCambio(inversionTipo.getTivFechaCambio());
        toTipoInversionVO2.setTivNombre(inversionTipo.getTivNombre());
        toTipoInversionVO2.setTivTerminal(inversionTipo.getTivTerminal());
        toTipoInversionVO2.setTivUsuarioAlta(inversionTipo.getTivUsuarioAlta());
        toTipoInversionVO2.setTivUsuarioBaja(inversionTipo.getTivUsuarioBaja());
        toTipoInversionVO2.setTivUsuarioCambio(inversionTipo.getTivUsuarioCambio());
        toTipoInversionVO2.setTivId(inversionTipo.getTivId());
        return toTipoInversionVO2;
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
