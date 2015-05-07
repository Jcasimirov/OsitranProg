package com.ositran.serviceimpl;

import com.ositran.daoimpl.InvReconocimientoDAOImpl;
import com.ositran.model.InvReconocimiento;
import com.ositran.service.InvReconocimientoService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.InvReconocimientoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class InvReconocimientoServiceImpl implements InvReconocimientoService{
    private InvReconocimientoDAOImpl invReconocimientoDAOImpl;

    public void setInvReconocimientoDAOImpl(InvReconocimientoDAOImpl invReconocimientoDAOImpl) {
        this.invReconocimientoDAOImpl = invReconocimientoDAOImpl;
    }

    public InvReconocimientoDAOImpl getInvReconocimientoDAOImpl() {
        return invReconocimientoDAOImpl;
    }

    public InvReconocimientoServiceImpl() {
        super();
    }

    @Override
    public List<InvReconocimientoVO> query() throws SQLException {
      List<InvReconocimiento> list=  invReconocimientoDAOImpl.query();
       List<InvReconocimientoVO> lista= toListInvReconocimientoVO(list);
        return lista;
    }

    @Override
    public String insert(InvReconocimientoVO invReconocimiento) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(InvReconocimientoVO invReconocimiento) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public InvReconocimiento get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public List<InvReconocimientoVO> getInvReconocimientosAvance(Integer invId) throws SQLException {
        List<InvReconocimiento> list=  invReconocimientoDAOImpl.getInvReconocimientosAvance(invId);
         List<InvReconocimientoVO> lista= toListInvReconocimientoVO(list);
          return lista; 
    }
    //conversiones
    private List<InvReconocimientoVO> toListInvReconocimientoVO(List<InvReconocimiento> list){
        List<InvReconocimientoVO> listVO=new ArrayList<InvReconocimientoVO>();
        for(int i=0;i<list.size();i++){
            InvReconocimiento InvReconocimiento=(InvReconocimiento)list.get(i);
            InvReconocimientoVO invReconocimientoVO=toInvReconocimientoVO(InvReconocimiento);
            listVO.add(invReconocimientoVO);
        }
        return listVO;
    }
    public List<InvReconocimiento> toListInvReconocimiento(List<InvReconocimientoVO> list){
        List<InvReconocimiento> lista=new ArrayList<InvReconocimiento>();
        System.out.println("INI FIN DE toListInvReconocimiento ");
        for(int i=0;i<list.size();i++){
            InvReconocimientoVO InvReconocimiento=(InvReconocimientoVO)list.get(i);
            InvReconocimiento invReconocimiento=toInvReconocimiento(InvReconocimiento);
            lista.add(invReconocimiento);
        }
        System.out.println("FIN DE toListInvReconocimiento ");
        return lista;
    }
    private InvReconocimientoVO toInvReconocimientoVO(InvReconocimiento InvReconocimiento1){
        InvReconocimientoVO InvReconocimientoVO1=new InvReconocimientoVO();
        InvReconocimientoVO1.setTiaNumero(InvReconocimiento1.getTiaNumero());
        InvReconocimientoVO1.setIreId(InvReconocimiento1.getIreId());
        InvReconocimientoVO1.setCsiId(InvReconocimiento1.getCsiId());
        InvReconocimientoVO1.setInfId(InvReconocimiento1.getInfId());
        InvReconocimientoVO1.setIadId(InvReconocimiento1.getIadId());
        InvReconocimientoVO1.setMonId(InvReconocimiento1.getMonId());
        InvReconocimientoVO1.setIvrMontoAprobado(Reutilizar.getNewInstance().redondearBigDecimal(InvReconocimiento1.getIvrMontoAprobado())); 
        InvReconocimientoVO1.setIvrMontoPresentado(Reutilizar.getNewInstance().redondearBigDecimal(InvReconocimiento1.getIvrMontoPresentado())); 
        InvReconocimientoVO1.setIreEstado(InvReconocimiento1.getIreEstado());
        return InvReconocimientoVO1;
    }
    public InvReconocimiento toInvReconocimiento(InvReconocimientoVO InvReconocimientoVO1){
        InvReconocimiento InvReconocimiento1=new InvReconocimiento();
        InvReconocimiento1.setIreId(InvReconocimientoVO1.getIreId());
        InvReconocimiento1.setCsiId(InvReconocimientoVO1.getCsiId());
        InvReconocimiento1.setInfId(InvReconocimientoVO1.getInfId());
        InvReconocimiento1.setIadId(InvReconocimientoVO1.getIadId());
        InvReconocimiento1.setMonId(InvReconocimientoVO1.getMonId());
        InvReconocimiento1.setTinId(InvReconocimientoVO1.getTinId());
        InvReconocimiento1.setIvrMontoAprobado(InvReconocimientoVO1.getIvrMontoAprobado()); 
        InvReconocimiento1.setIvrMontoPresentado(InvReconocimientoVO1.getIvrMontoPresentado());  
        InvReconocimiento1.setIreEstado(InvReconocimientoVO1.getIreEstado());  
        InvReconocimiento1.setTiaNumero(InvReconocimientoVO1.getTiaNumero());

        return InvReconocimiento1;
        
    }

}
