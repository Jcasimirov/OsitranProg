package com.ositran.dao;

import com.ositran.model.ContratoCompromiso;

import java.sql.SQLException;

import java.util.List;

public interface ContratoCompromisoDAO {
    public List<ContratoCompromiso> query() throws SQLException;
    public String insert(ContratoCompromiso contratoCompromiso) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoCompromiso contratoCompromiso) throws SQLException;
    public ContratoCompromiso get(Integer id) throws SQLException;
}
