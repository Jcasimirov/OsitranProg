package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoPenalidadDAOImpl;
import com.ositran.model.ContratoPenalidad;
import com.ositran.service.ContratoPenalidadService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ContratoPenalidadVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ContratoPenalidadServiceImpl implements ContratoPenalidadService {
    private ContratoPenalidadDAOImpl contratoPenalidadDAOImpl;
    
    public ContratoPenalidadServiceImpl() {
        super();
    }

    @Override
    public List<ContratoPenalidadVO> query() throws SQLException {
        List<ContratoPenalidad> list = contratoPenalidadDAOImpl.query();
        List<ContratoPenalidadVO> listVO=toListContratoPenalidadVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoPenalidadVO contratoPenalidadVO) throws SQLException {
        ContratoPenalidad contratoPenalidad=toContratoPenalidad(contratoPenalidadVO);
        String result = contratoPenalidadDAOImpl.insert(contratoPenalidad);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = contratoPenalidadDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoPenalidadVO contratoPenalidadVO) throws SQLException {
        ContratoPenalidad contratoPenalidad=toContratoPenalidad(contratoPenalidadVO);
        String result = contratoPenalidadDAOImpl.update(contratoPenalidad);
        return result;
    }

    @Override
    public ContratoPenalidadVO get(Integer id) throws SQLException {
        ContratoPenalidad contratoPenalidad= contratoPenalidadDAOImpl.get(id);
        ContratoPenalidadVO contratoPenalidadVO=toContratoPenalidadVO(contratoPenalidad);
        return contratoPenalidadVO;
    }
    
    // conversiones
    private List<ContratoPenalidadVO> toListContratoPenalidadVO(List<ContratoPenalidad> list){
        List<ContratoPenalidadVO> listVO=new ArrayList<ContratoPenalidadVO>();
        for(int i=0;i<list.size();i++){
            ContratoPenalidad contratoPenalidad=(ContratoPenalidad)list.get(i);
            ContratoPenalidadVO contratoPenalidadVO=toContratoPenalidadVO(contratoPenalidad);
            listVO.add(contratoPenalidadVO);
        }
        return listVO;
    }
    
    private ContratoPenalidadVO toContratoPenalidadVO(ContratoPenalidad contratoPenalidad){
        ContratoPenalidadVO contratoPenalidadVO=new ContratoPenalidadVO();
        
        contratoPenalidadVO.setConId(contratoPenalidad.getConId());
        contratoPenalidadVO.setMonId(contratoPenalidad.getMonId());
        contratoPenalidadVO.setPesId(contratoPenalidad.getPesId());
        contratoPenalidadVO.setTcpTotal(contratoPenalidad.getTcpTotal());
        contratoPenalidadVO.setTcpEstado(contratoPenalidad.getTcpEstado());
        contratoPenalidadVO.setTcpId(contratoPenalidad.getTcpId());
        contratoPenalidadVO.setTcpFecha(contratoPenalidad.getTcpFecha());
        contratoPenalidadVO.setTcpMotivo(contratoPenalidad.getTcpMotivo());
        contratoPenalidadVO.setTcpFechaDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoPenalidad.getTcpFecha()));
        contratoPenalidadVO.setTcpDocumentoFisico(contratoPenalidad.getTcpDocumentoFisico());
        
        contratoPenalidadVO.setTcpFechaAlta(contratoPenalidad.getTcpFechaAlta());
        contratoPenalidadVO.setTcpUsuarioAlta(contratoPenalidad.getTcpUsuarioAlta());
        contratoPenalidadVO.setTcpFechaCambio(contratoPenalidad.getTcpFechaCambio());
        contratoPenalidadVO.setTcpUsuarioCambio(contratoPenalidad.getTcpUsuarioCambio());
        contratoPenalidadVO.setTcpFechaBaja(contratoPenalidad.getTcpFechaBaja());
        contratoPenalidadVO.setTcpUsuarioBaja(contratoPenalidad.getTcpUsuarioBaja());
        return contratoPenalidadVO;
    }
    
    private ContratoPenalidad toContratoPenalidad(ContratoPenalidadVO contratoPenalidadVO){
        ContratoPenalidad contratoPenalidad=new ContratoPenalidad();        
        
        contratoPenalidad.setConId(contratoPenalidadVO.getConId());
        contratoPenalidad.setMonId(contratoPenalidadVO.getMonId());
        contratoPenalidad.setPesId(contratoPenalidadVO.getPesId());
        System.out.println("contratoPenalidadVO.getPesId()"+contratoPenalidadVO.getPesId());
        contratoPenalidad.setTcpTotal(contratoPenalidadVO.getTcpTotal());
        contratoPenalidad.setTcpDocumentoFisico(contratoPenalidadVO.getTcpDocumentoFisico());
        contratoPenalidad.setTcpEstado(contratoPenalidadVO.getTcpEstado());
        contratoPenalidad.setTcpId(contratoPenalidadVO.getTcpId());
        contratoPenalidad.setTcpFecha(contratoPenalidadVO.getTcpFecha());
        contratoPenalidad.setTcpMotivo(contratoPenalidadVO.getTcpMotivo());
        
        contratoPenalidad.setTcpFechaAlta(contratoPenalidadVO.getTcpFechaAlta());
        contratoPenalidad.setTcpUsuarioAlta(contratoPenalidadVO.getTcpUsuarioAlta());
        contratoPenalidad.setTcpFechaCambio(contratoPenalidadVO.getTcpFechaCambio());
        contratoPenalidad.setTcpUsuarioCambio(contratoPenalidadVO.getTcpUsuarioCambio());
        contratoPenalidad.setTcpFechaBaja(contratoPenalidadVO.getTcpFechaBaja());
        contratoPenalidad.setTcpUsuarioBaja(contratoPenalidadVO.getTcpUsuarioBaja());
        contratoPenalidad.setTcpTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
        return contratoPenalidad;
        
    }

    public ContratoPenalidadDAOImpl getContratoPenalidadDAOImpl() {
        return contratoPenalidadDAOImpl;
    }

    public void setContratoPenalidadDAOImpl(ContratoPenalidadDAOImpl contratoPenalidadDAOImpl) {
        this.contratoPenalidadDAOImpl = contratoPenalidadDAOImpl;
    }
    
    @Override    
    public List<ContratoPenalidadVO> getPenalidadesContrato(Integer ConId) throws SQLException{
        List<ContratoPenalidad> list = contratoPenalidadDAOImpl.getPenalidadesContrato(ConId);
        List<ContratoPenalidadVO> listVO=toListContratoPenalidadVO(list);
        return listVO;
    }
}
