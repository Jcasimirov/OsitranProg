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
    ConcesionarioVO conc;

    public void setConc(ConcesionarioVO conc) {
        this.conc = conc;
    }

    public ConcesionarioVO getConc() {
        return conc;
    }

    public void setConce(Concesionario conce) {
        this.conce = conce;
    }

    public Concesionario getConce() {
        return conce;
    }
    Concesionario conce;
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
        
        conc.setCncCorreo(concesionario.getCncCorreo());
        conc.setCncDescripcion(concesionario.getCncDescripcion());
        conc.setCncDireccion(concesionario.getCncDireccion());
        conc.setCncEstado(concesionario.getCncEstado());
        conc.setCncFechaAlta(concesionario.getCncFechaAlta());
        conc.setCncFechaBaja(concesionario.getCncFechaBaja());
        conc.setCncFechaCambio(concesionario.getCncFechaCambio());
        conc.setCncId(concesionario.getCncId());
        conc.setCncNombre(concesionario.getCncNombre());
        conc.setCncNroDocumento(concesionario.getCncNroDocumento());
        conc.setCncRepresentanteLegal(concesionario.getCncRepresentanteLegal());
        conc.setCncTelefono(concesionario.getCncTelefono());
        conc.setCncTerminal(concesionario.getCncTerminal());
        conc.setCncUsuarioAlta(concesionario.getCncUsuarioAlta());
        conc.setCncUsuarioBaja(concesionario.getCncUsuarioBaja());
        conc.setCncUsuarioCambio(concesionario.getCncUsuarioCambio());
        conc.setCrgId(concesionario.getCrgId());
        conc.setTdoId(concesionario.getTdoId());        
        return conc;
    }
    private Concesionario toConcesionario(ConcesionarioVO concesionarioVO){
        
        conce.setCncId(concesionarioVO.getCncId());
        conce.setCncCorreo(concesionarioVO.getCncCorreo());
        conce.setCncDescripcion(concesionarioVO.getCncDescripcion());
        conce.setCncDireccion(concesionarioVO.getCncDireccion());
        conce.setCncEstado(concesionarioVO.getCncEstado());
        conce.setCncFechaAlta(concesionarioVO.getCncFechaAlta());
        conce.setCncFechaBaja(concesionarioVO.getCncFechaBaja());
        conce.setCncFechaCambio(concesionarioVO.getCncFechaCambio());
        conce.setCncNombre(concesionarioVO.getCncNombre());
        conce.setCncNroDocumento(concesionarioVO.getCncNroDocumento());
        conce.setCncRepresentanteLegal(concesionarioVO.getCncRepresentanteLegal());
        conce.setCncTelefono(concesionarioVO.getCncTelefono());
        conce.setCncTerminal(concesionarioVO.getCncTerminal());
        conce.setCncUsuarioAlta(concesionarioVO.getCncUsuarioAlta());
        conce.setCncUsuarioBaja(concesionarioVO.getCncUsuarioBaja());
        conce.setCncUsuarioCambio(concesionarioVO.getCncUsuarioCambio());
        conce.setCrgId(concesionarioVO.getCrgId());
        conce.setTdoId(concesionarioVO.getTdoId());
        return conce;
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

