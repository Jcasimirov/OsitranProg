package com.ositran.dao;

import com.ositran.model.AdendaTipo;

import java.sql.SQLException;

import java.util.List;

public interface AdendaTipoDAO {
    public List<AdendaTipo> query() throws SQLException;
    public String insert(AdendaTipo adendaTipo) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(AdendaTipo adendaTipo) throws SQLException;
    public AdendaTipo get(Integer id) throws SQLException;
}
