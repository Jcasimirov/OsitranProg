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
    public List<ConcesionarioVO> queryTD(int filtro) throws SQLException, Exception {
        List<Concesionario> list=concesionarioDAOImpl.queryTD(filtro);
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
           ConcesionarioVO conce=new ConcesionarioVO();
        conce.setCncCorreo(concesionario.getCncCorreo());
        conce.setCncDescripcion(concesionario.getCncDescripcion());
        conce.setCncDireccion(concesionario.getCncDireccion());
        conce.setCncEstado(concesionario.getCncEstado());
        conce.setCncFechaAlta(concesionario.getCncFechaAlta());
        conce.setCncFechaBaja(concesionario.getCncFechaBaja());
        conce.setCncFechaCambio(concesionario.getCncFechaCambio());
        conce.setCncId(concesionario.getCncId());
        conce.setCncNombre(concesionario.getCncNombre());
        conce.setCncNroDocumento(concesionario.getCncNroDocumento());
        conce.setCncRepresentanteLegal(concesionario.getCncRepresentanteLegal());
        conce.setCncTelefono(concesionario.getCncTelefono());
        conce.setCncTerminal(concesionario.getCncTerminal());
        conce.setCncUsuarioAlta(concesionario.getCncUsuarioAlta());
        conce.setCncUsuarioBaja(concesionario.getCncUsuarioBaja());
        conce.setCncUsuarioCambio(concesionario.getCncUsuarioCambio());
        conce.setCncSiglas(concesionario.getCncSiglas());
      
        conce.setTdoId(concesionario.getTdoId());        
        return conce;
    }
    private Concesionario toConcesionario(ConcesionarioVO concesionarioVO){
        Concesionario concec=new Concesionario();
        concec.setCncId(concesionarioVO.getCncId());
        concec.setCncSiglas(concesionarioVO.getCncSiglas());
        concec.setCncCorreo(concesionarioVO.getCncCorreo());
        concec.setCncDescripcion(concesionarioVO.getCncDescripcion());
        concec.setCncDireccion(concesionarioVO.getCncDireccion());
        concec.setCncEstado(concesionarioVO.getCncEstado());
        concec.setCncFechaAlta(concesionarioVO.getCncFechaAlta());
        concec.setCncFechaBaja(concesionarioVO.getCncFechaBaja());
        concec.setCncFechaCambio(concesionarioVO.getCncFechaCambio());
        concec.setCncNombre(concesionarioVO.getCncNombre());
        concec.setCncNroDocumento(concesionarioVO.getCncNroDocumento());
        concec.setCncRepresentanteLegal(concesionarioVO.getCncRepresentanteLegal());
        concec.setCncTelefono(concesionarioVO.getCncTelefono());
        concec.setCncTerminal(concesionarioVO.getCncTerminal());
        concec.setCncUsuarioAlta(concesionarioVO.getCncUsuarioAlta());
        concec.setCncUsuarioBaja(concesionarioVO.getCncUsuarioBaja());
        concec.setCncUsuarioCambio(concesionarioVO.getCncUsuarioCambio());
     
        concec.setTdoId(concesionarioVO.getTdoId());
        return concec;
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
    
    //Ivan
        public List<ConcesionarioVO> BusquedaConcesionario(String nombre, String Siglas, int tipodoc, String nrodoc)  throws SQLException ,Exception{
            List<Concesionario> list=concesionarioDAOImpl.BusquedaConcesionario(nombre,Siglas,tipodoc,nrodoc);
            List<ConcesionarioVO> listVO=toListConcesionarioVO(list);
            
            return listVO;
        }

  
}

