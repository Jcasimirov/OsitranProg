package com.ositran.serviceimpl;

import com.ositran.daoimpl.ConcesionarioDAOImpl;
import com.ositran.model.Concesionario;
import com.ositran.service.ConcesionarioService;
import com.ositran.vo.bean.ConcesionarioVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
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
        ConcesionarioVO con= new ConcesionarioVO();
        con.setCncCorreo(concesionario.getCncCorreo());
        con.setCncDescripcion(concesionario.getCncDescripcion());
        con.setCncDireccion(concesionario.getCncDireccion());
        con.setCncEstado(concesionario.getCncEstado());
        con.setCncFechaAlta(concesionario.getCncFechaAlta());
        con.setCncFechaBaja(concesionario.getCncFechaBaja());
        con.setCncFechaCambio(concesionario.getCncFechaCambio());
        con.setCncId(concesionario.getCncId());
        con.setCncNombre(concesionario.getCncNombre());
        con.setCncNroDocumento(concesionario.getCncNroDocumento());
        con.setCncRepresentanteLegal(concesionario.getCncRepresentanteLegal());
        con.setCncTelefono(concesionario.getCncTelefono());
        con.setCncTerminal(concesionario.getCncTerminal());
        con.setCncUsuarioAlta(concesionario.getCncUsuarioAlta());
        con.setCncUsuarioBaja(concesionario.getCncUsuarioBaja());
        con.setCncUsuarioCambio(concesionario.getCncUsuarioCambio());
        con.setCrgId(concesionario.getCrgId());
        con.setTdoId(concesionario.getTdoId());        
        return con;
    }
    private Concesionario toConcesionario(ConcesionarioVO concesionarioVO){
        Concesionario conc= new Concesionario();
        conc.setCncId(concesionarioVO.getCncId());
        conc.setCncCorreo(concesionarioVO.getCncCorreo());
        conc.setCncDescripcion(concesionarioVO.getCncDescripcion());
        conc.setCncDireccion(concesionarioVO.getCncDireccion());
        conc.setCncEstado(concesionarioVO.getCncEstado());
        conc.setCncFechaAlta(concesionarioVO.getCncFechaAlta());
        conc.setCncFechaBaja(concesionarioVO.getCncFechaBaja());
        conc.setCncFechaCambio(concesionarioVO.getCncFechaCambio());
        conc.setCncNombre(concesionarioVO.getCncNombre());
        conc.setCncNroDocumento(concesionarioVO.getCncNroDocumento());
        conc.setCncRepresentanteLegal(concesionarioVO.getCncRepresentanteLegal());
        conc.setCncTelefono(concesionarioVO.getCncTelefono());
        conc.setCncTerminal(concesionarioVO.getCncTerminal());
        conc.setCncUsuarioAlta(concesionarioVO.getCncUsuarioAlta());
        conc.setCncUsuarioBaja(concesionarioVO.getCncUsuarioBaja());
        conc.setCncUsuarioCambio(concesionarioVO.getCncUsuarioCambio());
        conc.setCrgId(concesionarioVO.getCrgId());
        conc.setTdoId(concesionarioVO.getTdoId());
        return conc;
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

