package com.ositran.serviceimpl;


import com.ositran.daoimpl.InvTipoRevisionDAOImpl;
import com.ositran.model.InvTipoRevision;
import com.ositran.service.InvTipoRevisionService;
import com.ositran.vo.bean.InvTipoRevisionVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvTipoRevisionServiceImpl implements InvTipoRevisionService{
    private InvTipoRevisionDAOImpl invTipoRevisionDAOImpl;


    public void setInvTipoRevisionDAOImpl(InvTipoRevisionDAOImpl invTipoRevisionDAOImpl) {
        this.invTipoRevisionDAOImpl = invTipoRevisionDAOImpl;
    }

    public InvTipoRevisionDAOImpl getInvTipoRevisionDAOImpl() {
        return invTipoRevisionDAOImpl;
    }


    public InvTipoRevisionServiceImpl() {
        super();
    }

    @Override
    public List<InvTipoRevisionVO> ListarAprobaciones() throws SQLException{
        List<InvTipoRevision> list=invTipoRevisionDAOImpl.ListarAprobaciones();
        List<InvTipoRevisionVO> listVO=toListInvTipoRevisionVO(list);
        return listVO;
        
    }
    
    //conversiones
    private List<InvTipoRevisionVO> toListInvTipoRevisionVO(List<InvTipoRevision> list){
        List<InvTipoRevisionVO> listVO=new ArrayList<InvTipoRevisionVO>();
        for(int i=0;i<list.size();i++){           
            InvTipoRevision invTipoRevision=(InvTipoRevision)list.get(i);            
            InvTipoRevisionVO invTipoRevisionVO=toInvTipoRevisionVO(invTipoRevision);
            listVO.add(invTipoRevisionVO);
        }
        return listVO;
    }
    private InvTipoRevisionVO toInvTipoRevisionVO(InvTipoRevision invTipoRevision){
        InvTipoRevisionVO invTipoRevisionVO=new InvTipoRevisionVO();
        invTipoRevisionVO.setItrDescripcion(invTipoRevision.getItrDescripcion());
        invTipoRevisionVO.setItrId(invTipoRevision.getItrId());       
        return invTipoRevisionVO;
    } 
    

}
