package com.ositran.serviceimpl;

import com.ositran.daoimpl.InversionDAOImpl;
import com.ositran.model.Infraestructura;
import com.ositran.model.Inversion;
import com.ositran.service.InversionService;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InversionVO;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InversionServiceImpl implements InversionService {
    InversionVO inversionVO;
    Inversion inversion;
    InversionDAOImpl inversionDAOImpl;
    Infraestructura infraestructura;
    
    public InversionServiceImpl() {
        super();
    }

    @Override
    public List<InversionVO> query1(Infraestructura infraestructura,int codigoContrato) throws SQLException {
        System.out.println("LLEGO al services");
        List<Inversion> list=inversionDAOImpl.query1(infraestructura,codigoContrato);
        List<InversionVO> listVO=toListInversionVO(list);
        return listVO;
    }
    
    @Override
    public List<InversionVO> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(InversionVO inversionVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(InversionVO inversionVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public InversionVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
    //conversiones
    private List<InversionVO> toListInversionVO(List<Inversion> list){
        List<InversionVO> listVO=new ArrayList<InversionVO>();
        for(int i=0;i<list.size();i++){
            inversion=(Inversion)list.get(i);
            inversionVO=toInversionVO(inversion);
            listVO.add(inversionVO);
        }
        return listVO;
    }
    private InversionVO toInversionVO(Inversion inversion1){
        InversionVO inversionVO1=new InversionVO();
        inversionVO1.setConId(inversion1.getConId());
        inversionVO1.setCsiId(inversion1.getCsiId());
        inversionVO1.setInfId(inversion1.getInfId());
        inversionVO1.setInvDescripcion(inversion1.getInvDescripcion());
        inversionVO1.setInvId(inversion1.getInvId());
        inversionVO1.setTinId(inversion1.getTinId()); 
        return inversionVO1;
    }
    private Inversion toInversion(InversionVO inversionVO1){
        Inversion inversion1=new Inversion();
        inversion1.setConId(inversionVO1.getConId());
        inversion1.setCsiId(inversionVO1.getCsiId());
        inversion1.setInfId(inversionVO1.getInfId());
        inversion1.setInvDescripcion(inversionVO1.getInvDescripcion());
        inversion1.setInvId(inversionVO1.getInvId());
        inversion1.setTinId(inversionVO1.getTinId()); 
        return inversion1;
        
    }

    public void setInversionVO(InversionVO inversionVO) {
        this.inversionVO = inversionVO;
    }

    public InversionVO getInversionVO() {
        return inversionVO;
    }

    public void setInversion(Inversion inversion) {
        this.inversion = inversion;
    }

    public Inversion getInversion() {
        return inversion;
    }

    public void setInversionDAOImpl(InversionDAOImpl inversionDAOImpl) {
        this.inversionDAOImpl = inversionDAOImpl;
    }

    public InversionDAOImpl getInversionDAOImpl() {
        return inversionDAOImpl;
    }

    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }

    public Infraestructura getInfraestructura() {
        return infraestructura;
    }

}
