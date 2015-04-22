package com.ositran.serviceimpl;

import com.ositran.daoimpl.InvReajusteDAOImpl;
import com.ositran.model.InvReajuste;
import com.ositran.service.InvReajusteService;
import com.ositran.vo.bean.InvReajusteVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class InvReajusteServiceImpl implements InvReajusteService{
    private InvReajusteDAOImpl invReajusteDAOImpl;

    public void setInvReajusteDAOImpl(InvReajusteDAOImpl invReajusteDAOImpl) {
        this.invReajusteDAOImpl = invReajusteDAOImpl;
    }

    public InvReajusteDAOImpl getInvReajusteDAOImpl() {
        return invReajusteDAOImpl;
    }

    public InvReajusteServiceImpl() {
        super();
    }

    @Override
    public List<InvReajusteVO> query() throws SQLException {
        List<InvReajuste> list=  invReajusteDAOImpl.query();
         List<InvReajusteVO> lista= toListInvReajusteVO(list);
          return lista;
    }

    @Override
    public String insert(InvReajusteVO invReajuste) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(InvReajusteVO invReajuste) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public InvReajuste get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public List<InvReajusteVO> getInvReajustesAvance(Integer tiaNumero) throws SQLException {
        List<InvReajuste> list = invReajusteDAOImpl.getInvReajustesAvance(tiaNumero);        
        List<InvReajusteVO> lista= toListInvReajusteVO(list);
         return lista;
    }
    
    //conversiones
    private List<InvReajusteVO> toListInvReajusteVO(List<InvReajuste> list){
        List<InvReajusteVO> listVO=new ArrayList<InvReajusteVO>();
        for(int i=0;i<list.size();i++){
            InvReajuste InvReajuste=(InvReajuste)list.get(i);
            InvReajusteVO invReajusteVO=toInvReajusteVO(InvReajuste);
            listVO.add(invReajusteVO);
        }
        return listVO;
    }
    private InvReajusteVO toInvReajusteVO(InvReajuste InvReajuste1){
        InvReajusteVO invReajusteVO1=new InvReajusteVO();
        invReajusteVO1.setTiaNumero(InvReajuste1.getTiaNumero());
        invReajusteVO1.setIrjId(InvReajuste1.getIrjId());
        invReajusteVO1.setIrjMontoAprobado(InvReajuste1.getIrjMontoAprobado());
        invReajusteVO1.setIrjMontoReajuste(InvReajuste1.getIrjMontoReajuste());
        invReajusteVO1.setCsiId(InvReajuste1.getCsiId());
        invReajusteVO1.setTinId(InvReajuste1.getTinId());
        invReajusteVO1.setInfId(InvReajuste1.getInfId());  
        invReajusteVO1.setMonId(InvReajuste1.getMonId());
        invReajusteVO1.setCvaId(InvReajuste1.getCvaId());
 
        return invReajusteVO1;
    }
    private InvReajuste toInvReajuste(InvReajusteVO InvReajusteVO1){
        InvReajuste InvReajuste1=new InvReajuste();
        InvReajuste1.setIrjId(InvReajusteVO1.getIrjId());
        InvReajuste1.setIrjMontoAprobado(InvReajusteVO1.getIrjMontoAprobado());
        InvReajuste1.setIrjMontoReajuste(InvReajusteVO1.getIrjMontoReajuste());
        InvReajuste1.setCsiId(InvReajusteVO1.getCsiId());
        InvReajuste1.setTinId(InvReajusteVO1.getTinId());
        InvReajuste1.setInfId(InvReajusteVO1.getInfId());  
        InvReajuste1.setMonId(InvReajusteVO1.getMonId()); 
        return InvReajuste1;
        
    } 
}
