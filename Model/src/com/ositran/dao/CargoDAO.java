package com.ositran.dao;

import com.ositran.model.Cargo;

import java.sql.SQLException;

import java.util.List;

public interface CargoDAO {
    public List<Cargo> query() throws SQLException;
    public String insert(Cargo cargo) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(Cargo cargo) throws SQLException;
    public Cargo get(Integer id) throws SQLException;
}
