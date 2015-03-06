package com.ositran.serviceimpl;

import com.ositran.daoimpl.ConcesionarioDAOImpl;
import com.ositran.model.Concesionario;
import com.ositran.service.ConcesionarioService;
import com.ositran.vo.bean.ConcesionarioVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConcesionarioServiceImpl implements ConcesionarioService{
    int cantidad;
    Concesionario concesionario;
    ConcesionarioVO concesionarioVO;
    private ConcesionarioDAOImpl concesionarioDAOImpl;
     public ConcesionarioServiceImpl() {
        super();
    }

    @Override
    public List<ConcesionarioVO> query()  throws SQLException ,Exception{
        List<Concesionario> list=concesionarioDAOImpl.query();
        List<ConcesionarioVO> listVO=toListConcesionarioVO(list);
        
        return listVO;
    }
    @Override
    public List<ConcesionarioVO> queryF(String filtro)  throws SQLException ,Exception{
        List<Concesionario> list=concesionarioDAOImpl.queryF(filtro);
        List<ConcesionarioVO> listVO=toListConcesionarioVO(list);
        return listVO;
    }
    @Override
    public int getCanNombres(String nombre) throws SQLException, Exception {
        
        cantidad =concesionarioDAOImpl.getCanNombres(nombre);
        return cantidad;
    }
    
    @Override
    public String insert(ConcesionarioVO concesionarioVO)  throws SQLException ,Exception{
        Concesionario concesionario=toConcesionario(concesionarioVO);
        String result=concesionarioDAOImpl.insert(concesionario);
        return result;
    }

    @Override
    public String delete(Integer id)  throws SQLException ,Exception{
        String result=this.concesionarioDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ConcesionarioVO concesionarioVO)  throws SQLException ,Exception{
        Concesionario concesionario=toConcesionario(concesionarioVO);
        String result=this.concesionarioDAOImpl.update(concesionario);
        return result;
    }

    @Override
    public ConcesionarioVO get(Integer id)  throws SQLException ,Exception{
        Concesionario concesionario=this.concesionarioDAOImpl.get(id);
        ConcesionarioVO concecionarioVO=toConcesionarioVO(concesionario);
        return concecionarioVO;
    }
    
    //conversiones
    private List<ConcesionarioVO> toListConcesionarioVO(List<Concesionario> list){
        List<ConcesionarioVO> listVO=new ArrayList<ConcesionarioVO>();
        for(int i=0;i<list.size();i++){
            Concesionario concesionario=(Concesionario)list.get(i);
            ConcesionarioVO concesionarioVO=toConcesionarioVO(concesionario);
            listVO.add(concesionarioVO);
        }
        return listVO;
    }
    private ConcesionarioVO toConcesionarioVO(Concesionario concesionario){
        
        concesionarioVO.setCncCorreo(concesionario.getCncCorreo());
        concesionarioVO.setCncDescripcion(concesionario.getCncDescripcion());
        concesionarioVO.setCncDireccion(concesionario.getCncDireccion());
        concesionarioVO.setCncEstado(concesionario.getCncEstado());
        concesionarioVO.setCncFechaAlta(concesionario.getCncFechaAlta());
        concesionarioVO.setCncFechaBaja(concesionario.getCncFechaBaja());
        concesionarioVO.setCncFechaCambio(concesionario.getCncFechaCambio());
        concesionarioVO.setCncId(concesionario.getCncId());
        concesionarioVO.setCncNombre(concesionario.getCncNombre());
        concesionarioVO.setCncNroDocumento(concesionario.getCncNroDocumento());
        concesionarioVO.setCncRepresentanteLegal(concesionario.getCncRepresentanteLegal());
        concesionarioVO.setCncTelefono(concesionario.getCncTelefono());
        concesionarioVO.setCncTerminal(concesionario.getCncTerminal());
        concesionarioVO.setCncUsuarioAlta(concesionario.getCncUsuarioAlta());
        concesionarioVO.setCncUsuarioBaja(concesionario.getCncUsuarioBaja());
        concesionarioVO.setCncUsuarioCambio(concesionario.getCncUsuarioCambio());
        concesionarioVO.setCrgId(concesionario.getCrgId());
        concesionarioVO.setTdoId(concesionario.getTdoId());        
        return concesionarioVO;
    }
    private Concesionario toConcesionario(ConcesionarioVO concesionarioVO){
        
        concesionario.setCncId(concesionarioVO.getCncId());
        concesionario.setCncCorreo(concesionarioVO.getCncCorreo());
        concesionario.setCncDescripcion(concesionarioVO.getCncDescripcion());
        concesionario.setCncDireccion(concesionarioVO.getCncDireccion());
        concesionario.setCncEstado(concesionarioVO.getCncEstado());
        concesionario.setCncFechaAlta(concesionarioVO.getCncFechaAlta());
        concesionario.setCncFechaBaja(concesionarioVO.getCncFechaBaja());
        concesionario.setCncFechaCambio(concesionarioVO.getCncFechaCambio());
        concesionario.setCncNombre(concesionarioVO.getCncNombre());
        concesionario.setCncNroDocumento(concesionarioVO.getCncNroDocumento());
        concesionario.setCncRepresentanteLegal(concesionarioVO.getCncRepresentanteLegal());
        concesionario.setCncTelefono(concesionarioVO.getCncTelefono());
        concesionario.setCncTerminal(concesionarioVO.getCncTerminal());
        concesionario.setCncUsuarioAlta(concesionarioVO.getCncUsuarioAlta());
        concesionario.setCncUsuarioBaja(concesionarioVO.getCncUsuarioBaja());
        concesionario.setCncUsuarioCambio(concesionarioVO.getCncUsuarioCambio());
        concesionario.setCrgId(concesionarioVO.getCrgId());
        concesionario.setTdoId(concesionarioVO.getTdoId());
        return concesionario;
    }
    public void setConcesionarioDAOImpl(ConcesionarioDAOImpl concesionarioDAOImpl) {
        this.concesionarioDAOImpl = concesionarioDAOImpl;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionarioVO(ConcesionarioVO concesionarioVO) {
        this.concesionarioVO = concesionarioVO;
    }

    public ConcesionarioVO getConcesionarioVO() {
        return concesionarioVO;
    }

    public ConcesionarioDAOImpl getConcesionarioDAOImpl() {
        return concesionarioDAOImpl;
    }
}

