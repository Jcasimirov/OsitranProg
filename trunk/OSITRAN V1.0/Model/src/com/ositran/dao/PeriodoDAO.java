package com.ositran.dao;

import com.ositran.model.Periodo;

import java.sql.SQLException;

import java.util.List;

public interface PeriodoDAO {
    public List<Periodo> query() throws SQLException;
    public String insert(Periodo periodo) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(Periodo periodo) throws SQLException;
    public Periodo get(Integer id) throws SQLException;
}
