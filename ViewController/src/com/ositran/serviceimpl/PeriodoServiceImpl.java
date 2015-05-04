package com.ositran.serviceimpl;

import com.ositran.daoimpl.PeriodoDAOImpl;
import com.ositran.model.Periodo;
import com.ositran.service.PeriodoService;
import com.ositran.vo.bean.PeriodoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class PeriodoServiceImpl implements PeriodoService {
    private PeriodoDAOImpl periodoDAOImpl;
    
    public PeriodoServiceImpl() {
        super();
    }

    @Override
    public List<PeriodoVO> query() throws SQLException {
        List<Periodo> list=periodoDAOImpl.query();
        List<PeriodoVO> listVO=toListPeriodoVO(list);
        return listVO;
    }

    @Override
    public String insert(PeriodoVO periodoVO) throws SQLException {
        Periodo periodo=toPeriodo(periodoVO);
        String result=periodoDAOImpl.insert(periodo);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=this.periodoDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(PeriodoVO periodoVO) throws SQLException {
        Periodo periodo=toPeriodo(periodoVO);
        String result=this.periodoDAOImpl.update(periodo);
        return result;
    }

    @Override
    public PeriodoVO get(Integer id) throws SQLException {
        Periodo periodo= periodoDAOImpl.get(id);
        PeriodoVO periodoVO=toPeriodoVO(periodo);
        return periodoVO;
    }

    public PeriodoDAOImpl getPeriodoDAOImpl() {
        return periodoDAOImpl;
    }

    public void setPeriodoDAOImpl(PeriodoDAOImpl periodoDAOImpl) {
        this.periodoDAOImpl = periodoDAOImpl;
    }
    
    // conversiones
    private List<PeriodoVO> toListPeriodoVO(List<Periodo> list){
        List<PeriodoVO> listVO=new ArrayList<PeriodoVO>();
        for(int i=0;i<list.size();i++){
            Periodo periodo=(Periodo)list.get(i);
            PeriodoVO periodoVO=toPeriodoVO(periodo);
            listVO.add(periodoVO);
        }
        return listVO;
    }
    
    private PeriodoVO toPeriodoVO(Periodo periodo){
        PeriodoVO periodoVO=new PeriodoVO();
        
        periodoVO.setPerId(periodo.getPerId());
        periodoVO.setPerCantidadendias(periodo.getPerCantidadendias());
        periodoVO.setPerDescripcion(periodo.getPerDescripcion());
        periodoVO.setPerNombre(periodo.getPerNombre());
    
        return periodoVO;
    }
    
    private Periodo toPeriodo(PeriodoVO periodoVO){
        Periodo periodo=new Periodo();
        
        periodo.setPerId(periodoVO.getPerId());
        periodo.setPerCantidadendías(periodoVO.getPerCantidadendias());
        periodo.setPerDescripcion(periodoVO.getPerDescripcion());
        periodo.setPerNombre(periodoVO.getPerNombre());

        return periodo;
        
    }
}
