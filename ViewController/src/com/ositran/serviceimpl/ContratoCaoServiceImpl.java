package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoCaoDAOImpl;
import com.ositran.model.ContratoCao;
import com.ositran.service.ContratoCaoService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ContratoCaoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ContratoCaoServiceImpl implements ContratoCaoService {
    private ContratoCaoDAOImpl contratoCaoDAOImpl;
    
    public ContratoCaoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoCaoVO> query() throws SQLException {
        List<ContratoCao> list = contratoCaoDAOImpl.query();
        List<ContratoCaoVO> listVO=toListContratoCaoVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoCaoVO contratoCaoVO) throws SQLException {
        ContratoCao contratoCao=toContratoCao(contratoCaoVO);
        String result = contratoCaoDAOImpl.insert(contratoCao);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = contratoCaoDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoCaoVO contratoCaoVO) throws SQLException {
        ContratoCao contratoCao=toContratoCao(contratoCaoVO);
        String result = contratoCaoDAOImpl.update(contratoCao);
        return result;
    }

    @Override
    public ContratoCaoVO get(Integer id) throws SQLException {
        ContratoCao contratoCao= contratoCaoDAOImpl.get(id);
        ContratoCaoVO contratoCaoVO=toContratoCaoVO(contratoCao);
        return contratoCaoVO;
    }
    
    // conversiones
    private List<ContratoCaoVO> toListContratoCaoVO(List<ContratoCao> list){
        List<ContratoCaoVO> listVO=new ArrayList<ContratoCaoVO>();
        for(int i=0;i<list.size();i++){
            ContratoCao contratoCao=(ContratoCao)list.get(i);
            ContratoCaoVO contratoCaoVO=toContratoCaoVO(contratoCao);
            listVO.add(contratoCaoVO);
        }
        return listVO;
    }
    
    private ContratoCaoVO toContratoCaoVO(ContratoCao contratoCao){
        ContratoCaoVO contratoCaoVO=new ContratoCaoVO();
        
        contratoCaoVO.setCaoEstado(contratoCao.getCaoEstado());
        contratoCaoVO.setCaoFecha(contratoCao.getCaoFecha());
        contratoCaoVO.setCaoFechaDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(contratoCao.getCaoFecha()));
        contratoCaoVO.setCaoId(contratoCao.getCaoId());
        contratoCaoVO.setCaoMonto(contratoCao.getCaoMonto());        
        contratoCaoVO.setCaoPdf(contratoCao.getCaoPdf());
        contratoCaoVO.setConId(contratoCao.getConId());
        contratoCaoVO.setMonId(contratoCao.getMonId());                
        contratoCaoVO.setCaoNombre(contratoCao.getCaoNombre());
    
        contratoCaoVO.setCaoFechaAlta(contratoCao.getCaoFechaAlta());
        contratoCaoVO.setCaoUsuarioAlta(contratoCao.getCaoUsuarioAlta());
        contratoCaoVO.setCaoFechaCambio(contratoCao.getCaoFechaCambio());
        contratoCaoVO.setCaoUsuarioCambio(contratoCao.getCaoUsuarioCambio());
        contratoCaoVO.setCaoFechaBaja(contratoCao.getCaoFechaBaja());
        contratoCaoVO.setCaoUsuarioBaja(contratoCao.getCaoUsuarioBaja());
        return contratoCaoVO;
    }
    
    private ContratoCao toContratoCao(ContratoCaoVO contratoCaoVO){
        ContratoCao contratoCao=new ContratoCao();        
            
        contratoCao.setCaoEstado(contratoCaoVO.getCaoEstado());
        contratoCao.setCaoFecha(contratoCaoVO.getCaoFecha());
        contratoCao.setCaoId(contratoCaoVO.getCaoId());
        contratoCao.setCaoMonto(contratoCaoVO.getCaoMonto());    
        contratoCao.setCaoPdf(contratoCaoVO.getCaoPdf());
        contratoCao.setConId(contratoCaoVO.getConId());
        contratoCao.setMonId(contratoCaoVO.getMonId());
        contratoCao.setCaoNombre(contratoCaoVO.getCaoNombre());
        
        contratoCao.setCaoFechaAlta(contratoCaoVO.getCaoFechaAlta());
        contratoCao.setCaoUsuarioAlta(contratoCaoVO.getCaoUsuarioAlta());
        contratoCao.setCaoFechaCambio(contratoCaoVO.getCaoFechaCambio());
        contratoCao.setCaoUsuarioCambio(contratoCaoVO.getCaoUsuarioCambio());
        contratoCao.setCaoFechaBaja(contratoCaoVO.getCaoFechaBaja());
        contratoCao.setCaoUsuarioBaja(contratoCaoVO.getCaoUsuarioBaja());
        contratoCao.setCaoTerminal(Reutilizar.getNewInstance().obtenerIpCliente());
        
        return contratoCao;
        
    }

    public ContratoCaoDAOImpl getContratoCaoDAOImpl() {
        return contratoCaoDAOImpl;
    }

    public void setContratoCaoDAOImpl(ContratoCaoDAOImpl contratoCaoDAOImpl) {
        this.contratoCaoDAOImpl = contratoCaoDAOImpl;
    }
    
    @Override    
    public List<ContratoCaoVO> getCaosContrato(Integer ConId) throws SQLException{
        List<ContratoCao> list = contratoCaoDAOImpl.getCaosContrato(ConId);
        List<ContratoCaoVO> listVO=toListContratoCaoVO(list);
        return listVO;
    }
}
