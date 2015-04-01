package com.ositran.dao;


import com.ositran.model.ContratoCao;

import java.sql.SQLException;

import java.util.List;

public interface ContratoCaoDAO {
    
    public List<ContratoCao> query() throws SQLException;
    public String insert(ContratoCao contratoCao) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoCao contratoCao) throws SQLException;
    public ContratoCao get(Integer id) throws SQLException;
    public List<ContratoCao> getCaosContrato(Integer conId) throws SQLException;
}
