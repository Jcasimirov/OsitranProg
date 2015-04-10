package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoPenalidadEstadoDAOImpl;
import com.ositran.model.ContratoPenalidadEstado;
import com.ositran.service.ContratoPenalidadEstadoService;
import com.ositran.vo.bean.ContratoPenalidadEstadoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ContratoPenalidadEstadoServiceImpl implements ContratoPenalidadEstadoService {
    private ContratoPenalidadEstadoDAOImpl contratoPenalidadEstadoDaoImpl;

    public void setContratoPenalidadEstadoDaoImpl(ContratoPenalidadEstadoDAOImpl contratoPenalidadEstadoDaoImpl) {
        this.contratoPenalidadEstadoDaoImpl = contratoPenalidadEstadoDaoImpl;
    }

    public ContratoPenalidadEstadoDAOImpl getContratoPenalidadEstadoDaoImpl() {
        return contratoPenalidadEstadoDaoImpl;
    }

    public ContratoPenalidadEstadoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoPenalidadEstadoVO> query() throws SQLException {
        List<ContratoPenalidadEstado> list = contratoPenalidadEstadoDaoImpl.query();
        List<ContratoPenalidadEstadoVO> listVO=toListContratoPenalidadEstadoVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoPenalidadEstadoVO contratoPenalidadEstadoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoPenalidadEstadoVO contratoPenalidadEstadoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoPenalidadEstadoVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
    
    private ContratoPenalidadEstadoVO toContratoPenalidadEstadoVO(ContratoPenalidadEstado contratoPenalidadestado){
        ContratoPenalidadEstadoVO contratoPenalidadEstadoVO=new ContratoPenalidadEstadoVO();        
        contratoPenalidadEstadoVO.setPesId(contratoPenalidadestado.getPesId());
        contratoPenalidadEstadoVO.setPesNombre(contratoPenalidadestado.getPesNombre()); 
        return contratoPenalidadEstadoVO;
    }
    
    private ContratoPenalidadEstado toContratoPenalidadEstado(ContratoPenalidadEstadoVO contratoPenalidadEstadoVO){
        ContratoPenalidadEstado contratoPenalidadEstado=new ContratoPenalidadEstado();        
        contratoPenalidadEstado.setPesId(contratoPenalidadEstadoVO.getPesId());
        contratoPenalidadEstado.setPesNombre(contratoPenalidadEstadoVO.getPesNombre());
        return contratoPenalidadEstado;
    }
    private List<ContratoPenalidadEstadoVO> toListContratoPenalidadEstadoVO(List<ContratoPenalidadEstado> list){
        List<ContratoPenalidadEstadoVO> listVO=new ArrayList<ContratoPenalidadEstadoVO>();
        for(int i=0;i<list.size();i++){
            ContratoPenalidadEstado contratoPenalidadEstado=(ContratoPenalidadEstado)list.get(i);
            ContratoPenalidadEstadoVO contratoPenalidadEstadoVO=toContratoPenalidadEstadoVO(contratoPenalidadEstado);
            listVO.add(contratoPenalidadEstadoVO);
        }
        return listVO;
    }
}
