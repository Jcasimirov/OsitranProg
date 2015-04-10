package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoPpoDAOImpl;
import com.ositran.model.ContratoPpo;
import com.ositran.service.ContratoPpoService;
import com.ositran.vo.bean.ContratoPpoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContratoPpoServiceImpl implements ContratoPpoService {
    private ContratoPpoDAOImpl contratoPpoDAOImpl;
    
    public ContratoPpoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoPpoVO> query() throws SQLException {
        List<ContratoPpo> list = contratoPpoDAOImpl.query();
        List<ContratoPpoVO> listVO=toListContratoPpoVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoPpoVO contratoPpoVO) throws SQLException {
        ContratoPpo contratoPpo=toContratoPpo(contratoPpoVO);
        String result = contratoPpoDAOImpl.insert(contratoPpo);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = contratoPpoDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoPpoVO contratoPpoVO) throws SQLException {
        ContratoPpo contratoPpo=toContratoPpo(contratoPpoVO);
        String result = contratoPpoDAOImpl.update(contratoPpo);
        return result;
    }

    @Override
    public ContratoPpoVO get(Integer id) throws SQLException {
        ContratoPpo contratoPpo= contratoPpoDAOImpl.get(id);
        ContratoPpoVO contratoPpoVO=toContratoPpoVO(contratoPpo);
        return contratoPpoVO;
    }
    
    // conversiones
    private List<ContratoPpoVO> toListContratoPpoVO(List<ContratoPpo> list){
        List<ContratoPpoVO> listVO=new ArrayList<ContratoPpoVO>();
        for(int i=0;i<list.size();i++){
            ContratoPpo contratoPpo=(ContratoPpo)list.get(i);
            ContratoPpoVO contratoPpoVO=toContratoPpoVO(contratoPpo);
            listVO.add(contratoPpoVO);
        }
        return listVO;
    }
    
    private ContratoPpoVO toContratoPpoVO(ContratoPpo contratoPpo){
        ContratoPpoVO contratoPpoVO=new ContratoPpoVO();
        
        
        contratoPpoVO.setConId(contratoPpo.getConId());
        contratoPpoVO.setMonId(contratoPpo.getMonId());
        contratoPpoVO.setPpoArchivoPdf(contratoPpo.getPpoArchivoPdf());
        contratoPpoVO.setPpoEstado(contratoPpo.getPpoEstado());
        contratoPpoVO.setPpoFecha(contratoPpo.getPpoFecha());
        contratoPpoVO.setPpoId(contratoPpo.getPpoId());
        contratoPpoVO.setPpoMonto(contratoPpo.getPpoMonto());        
        
                    
    
        return contratoPpoVO;
    }
    
    private ContratoPpo toContratoPpo(ContratoPpoVO contratoPpoVO){
        ContratoPpo contratoPpo=new ContratoPpo();           
        
        
        contratoPpo.setConId(contratoPpoVO.getConId());
        contratoPpo.setMonId(contratoPpoVO.getMonId());
        contratoPpo.setPpoArchivoPdf(contratoPpoVO.getPpoArchivoPdf());
        contratoPpo.setPpoEstado(contratoPpoVO.getPpoEstado());
        contratoPpo.setPpoFecha(contratoPpoVO.getPpoFecha());
        contratoPpo.setPpoId(contratoPpoVO.getPpoId());
        contratoPpo.setPpoMonto(contratoPpoVO.getPpoMonto());        
        
        return contratoPpo;
        
    }

    public ContratoPpoDAOImpl getContratoPpoDAOImpl() {
        return contratoPpoDAOImpl;
    }

    public void setContratoPpoDAOImpl(ContratoPpoDAOImpl contratoPpoDAOImpl) {
        this.contratoPpoDAOImpl = contratoPpoDAOImpl;
    }
    
    @Override    
    public List<ContratoPpoVO> getPposContrato(Integer ConId) throws SQLException{
        List<ContratoPpo> list = contratoPpoDAOImpl.getPposContrato(ConId);
        List<ContratoPpoVO> listVO=toListContratoPpoVO(list);
        return listVO;
    }
}
