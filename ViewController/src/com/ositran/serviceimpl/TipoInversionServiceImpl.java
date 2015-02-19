package com.ositran.serviceimpl;

import com.ositran.dao.TipoInversionDAO;
import com.ositran.daoimpl.TipoInversionDAOImpl;
import com.ositran.model.Igv;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.service.TipoInversionServices;
import com.ositran.model.InversionTipo;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.TipoInversionVO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TipoInversionServiceImpl implements TipoInversionServices{
    
    private TipoInversionDAO tipoInversionDAOImpl;

    @Override
    public List<TipoInversionVO> query()  {
        List<InversionTipo> list=tipoInversionDAOImpl.query();
        List<TipoInversionVO> listVO=toListTipoInversionVO(list);
        return listVO;
    }
    

    @Override
    public String insert(TipoInversionVO tipoInversionVO) {
        InversionTipo inversionTipo=toTipoInversion(tipoInversionVO);
        String result=tipoInversionDAOImpl.insert(inversionTipo);
        return result;
       
    }
    
    @Override
    public List<TipoInversionVO> query1(String buscar)  {
    
        List<InversionTipo> list=tipoInversionDAOImpl.query1(buscar);
        List<TipoInversionVO> listVO=toListTipoInversionVO(list);
        return listVO;
    }
    
    @Override
    public String delete(Integer id) {
        String result=this.getTipoInversionDAOImpl().delete(id);
        return result;
    }

    @Override
    public String update(TipoInversionVO tipoInversionVO)  {
        InversionTipo inversionTipo=toTipoInversion(tipoInversionVO);
        String result=this.getTipoInversionDAOImpl().update(inversionTipo);
        return result;
    }

    @Override
    public TipoInversionVO get(Integer id) {
        
        return null;
    }
     //conversiones
    private List<TipoInversionVO> toListTipoInversionVO(List<InversionTipo> list)  {
        List<TipoInversionVO> listVO=new ArrayList<TipoInversionVO>();
        for(int i=0;i<list.size();i++){
            InversionTipo inversionTipo=(InversionTipo)list.get(i);
            TipoInversionVO tipoInversionVO=toTipoInversionVO(inversionTipo);
            listVO.add(tipoInversionVO);
        }
        return listVO;
    }
    private TipoInversionVO toTipoInversionVO(InversionTipo inversionTipo)  {
        TipoInversionVO tipoInversionVO=new TipoInversionVO();
        tipoInversionVO.setTivDescripcion(inversionTipo.getTivDescripcion());
        tipoInversionVO.setTivEstado(inversionTipo.getTivEstado());
        try {
            tipoInversionVO.setTivFechaAlta(inversionTipo.getTivFechaAlta());
            tipoInversionVO.setTivFechaBaja(inversionTipo.getTivFechaBaja());
        } catch (ParseException e) {
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
}
