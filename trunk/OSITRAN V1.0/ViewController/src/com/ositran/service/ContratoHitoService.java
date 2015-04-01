package com.ositran.service;

import com.ositran.vo.bean.ContratoHitoVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoHitoService {
    public List<ContratoHitoVO> query() throws SQLException;
    public String insert(ContratoHitoVO contratoHitoVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoHitoVO contratoHitoVO) throws SQLException;
    public ContratoHitoVO get(Integer id) throws SQLException;
    public List<ContratoHitoVO> getHitosContrato(Integer conId) throws SQLException;
}
