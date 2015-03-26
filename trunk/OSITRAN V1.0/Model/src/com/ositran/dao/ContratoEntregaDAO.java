package com.ositran.dao;


import com.ositran.model.ContratoEntrega;

import com.ositran.model.ContratoHito;

import java.sql.SQLException;

import java.util.List;

public interface ContratoEntregaDAO {
    public List<ContratoEntrega> query() throws SQLException;
    public String insert(ContratoEntrega contratoEntrega) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoEntrega contratoEntrega) throws SQLException;
    public ContratoEntrega get(Integer id) throws SQLException;
}
