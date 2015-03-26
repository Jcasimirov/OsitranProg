package com.ositran.dao;

import com.ositran.model.ContratoPenalidad;

import java.sql.SQLException;

import java.util.List;

public interface ContratoPenalidadDAO {
    public List<ContratoPenalidad> query() throws SQLException;
    public String insert(ContratoPenalidad contratoPenalidad) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoPenalidad contratoPenalidad) throws SQLException;
    public ContratoPenalidad get(Integer id) throws SQLException;
}
