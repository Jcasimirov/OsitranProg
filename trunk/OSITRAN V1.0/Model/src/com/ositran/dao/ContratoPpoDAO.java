package com.ositran.dao;

import com.ositran.model.ContratoPpo;

import java.sql.SQLException;

import java.util.List;

public interface ContratoPpoDAO {
    public List<ContratoPpo> query() throws SQLException;
    public String insert(ContratoPpo contratoPpo) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoPpo contratoPpo) throws SQLException;
    public ContratoPpo get(Integer id) throws SQLException;
    public List<ContratoPpo> getPposContrato(Integer conId) throws SQLException;
}
