package com.ositran.dao;

import com.ositran.model.ContratoAlerta;

import java.sql.SQLException;

import java.util.List;

public interface ContratoAlertaDAO {
    public List<ContratoAlerta> query() throws SQLException;
    public String insert(ContratoAlerta contratoAlerta) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoAlerta contratoAlerta) throws SQLException;
    public ContratoAlerta get(Integer id) throws SQLException;
    public List<ContratoAlerta> getAlertasContrato(Integer conId) throws SQLException;
}
