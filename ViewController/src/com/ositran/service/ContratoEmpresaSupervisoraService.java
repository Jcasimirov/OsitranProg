package com.ositran.service;

import com.ositran.model.ContratoSupervisora;
import com.ositran.vo.bean.ContratoSupervisoraVO;

import com.ositran.vo.bean.UsuarioVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoEmpresaSupervisoraService {
    public List<ContratoSupervisoraVO> query() throws SQLException;

    public int insert(ContratoSupervisoraVO contratoSupervisoraVO) throws SQLException;

    public String delete(Integer id) throws SQLException;

    public String update(ContratoSupervisoraVO contratoSupervisoraVO) throws SQLException;

    public ContratoSupervisoraVO get(Integer id) throws SQLException;

    public int ValidarContratoSupervisora(int concesion, int tipoinfra) throws SQLException;
    
    public List<ContratoSupervisoraVO> filtrarContraEmpSup(String empresaSupervisora) throws SQLException;
    
    public List<ContratoSupervisoraVO> queryTD(int filtro)  throws SQLException;
}
