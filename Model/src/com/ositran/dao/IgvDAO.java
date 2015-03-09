package com.ositran.dao;

import com.ositran.model.Igv;

import java.sql.SQLException;

import java.util.List;

public interface IgvDAO {
    public List<Igv> query()throws SQLException;
    public String insert(Igv igv)throws SQLException;
    public String delete(Integer id)throws SQLException;
    public String update(Igv igv)throws SQLException;
    public Igv get(Integer id)throws SQLException;
}
