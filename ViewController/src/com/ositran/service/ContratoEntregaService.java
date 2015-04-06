package com.ositran.service;

import com.ositran.vo.bean.ContratoEntregaVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoEntregaService {
    public List<ContratoEntregaVO> query() throws SQLException;
    public String insert(ContratoEntregaVO contratoEntregaVO) throws SQLException;
    public String update(ContratoEntregaVO contratoEntregaVO) throws SQLException;
    public ContratoEntregaVO get(Integer id) throws SQLException;    
    public List<ContratoEntregaVO> getEntregasContrato(Integer ConId) throws SQLException;
    
}
