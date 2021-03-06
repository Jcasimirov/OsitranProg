package com.ositran.serviceimpl;
import com.ositran.daoimpl.IgvDAOImpl;
import com.ositran.model.Igv;
import com.ositran.service.IgvService;
import com.ositran.vo.bean.IgvVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class IgvServiceImpl implements IgvService{
    private IgvDAOImpl igvDAOImpl;

    public void setIgvDAOImpl(IgvDAOImpl igvDAOImpl) {
        this.igvDAOImpl = igvDAOImpl;
    }

    public IgvDAOImpl getIgvDAOImpl() {
        return igvDAOImpl;
    }


    public IgvServiceImpl() {
        super();
    }

    @Override
    public List<IgvVO> query()  throws SQLException{
        List<Igv> list=igvDAOImpl.query();
        List<IgvVO> listVO=toListIgvVO(list);
        return listVO;
    }

    @Override
    public String insert(IgvVO igvVO) throws SQLException{
        Igv igv=toIgv(igvVO);
        String result=igvDAOImpl.insert(igv);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result=this.igvDAOImpl.delete(id);
        return result;
    }
    
     
    /*   public Integer cambiarEstado(Integer estado) {
        Integer result=this.igvDAOImpl.update(estado);
        return result;
    }  */

    @Override
    public String update(IgvVO igvVO) throws SQLException{
        Igv igv=toIgv(igvVO);
        String result=this.igvDAOImpl.update(igv);
        return result;
    }

    @Override
    public IgvVO get(Integer id) throws SQLException{
        Igv igv=this.igvDAOImpl.get(id);
        IgvVO igvVO=toIgvVO(igv);
        return igvVO;
    }
    
    
    
    //conversiones
    private List<IgvVO> toListIgvVO(List<Igv> list)throws SQLException{
        List<IgvVO> listVO=new ArrayList<IgvVO>();
        for(int i=0;i<list.size();i++){
            Igv igv=(Igv)list.get(i);
            IgvVO igvVO=toIgvVO(igv);//enviando a la clase IgvVO el arreglo
            listVO.add(igvVO);
        }
        return listVO;
    }
    private IgvVO toIgvVO(Igv igv)throws SQLException{
        IgvVO igvVO=new IgvVO();
        igvVO.setIgvEstado(igv.getIgvEstado());
        igvVO.setIgvFechaAlta(igv.getIgvFechaAlta());
        igvVO.setIgvFechaBaja(igv.getIgvFechaBaja());
        igvVO.setIgvFechaCambio(igv.getIgvFechaCambio());
        igvVO.setIgvFechacaducidad(igv.getIgvFechacaducidad());
        igvVO.setIgvFechavigencia(igv.getIgvFechavigencia());
        igvVO.setIgvPorcentaje(igv.getIgvPorcentaje());
        igvVO.setIgvTerminal(igv.getIgvTerminal());
        igvVO.setIgvUsuarioAlta(igv.getIgvUsuarioAlta());
        igvVO.setIgvUsuarioBaja(igv.getIgvUsuarioBaja());
        igvVO.setIgvUsuarioCambio(igv.getIgvUsuarioCambio());   
        igvVO.setIgvId(igv.getIgvId());
        
        return igvVO;
    }
    private Igv toIgv(IgvVO igvVO) throws SQLException{
        Igv igv=new Igv();
     
        igv.setIgvEstado(igvVO.getIgvEstado());
        igv.setIgvFechaAlta(igvVO.getIgvFechaAlta());
        igv.setIgvFechaBaja(igvVO.getIgvFechaBaja());
        igv.setIgvFechaCambio(igvVO.getIgvFechaCambio());
        igv.setIgvFechacaducidad(igvVO.getIgvFechacaducidad());
        igv.setIgvFechavigencia(igvVO.getIgvFechavigencia());
        igv.setIgvPorcentaje(igvVO.getIgvPorcentaje());
        igv.setIgvTerminal(igvVO.getIgvTerminal());
        igv.setIgvUsuarioAlta(igvVO.getIgvUsuarioAlta());
        igv.setIgvUsuarioBaja(igvVO.getIgvUsuarioBaja());
        igv.setIgvUsuarioCambio(igvVO.getIgvUsuarioCambio());   
        igv.setIgvId(igvVO.getIgvId());
        
        return igv;
        
    }







   
}
