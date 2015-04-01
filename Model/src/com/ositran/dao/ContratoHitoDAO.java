package com.ositran.dao;

import com.ositran.model.ContratoHito;

import java.sql.SQLException;

import java.util.List;

public interface ContratoHitoDAO {
    public List<ContratoHito> query() throws SQLException;
    public String insert(ContratoHito contratoHito) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoHito contratoHito) throws SQLException;
    public ContratoHito get(Integer id) throws SQLException;
    public List<ContratoHito> getHitosContrato(Integer conId) throws SQLException;
}
