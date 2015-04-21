package com.ositran.dao;


import com.ositran.model.Inv;

import java.sql.SQLException;

import java.util.List;

public interface InvDAO {
    public List<Inv> query() throws SQLException;
    public String insert(Inv inv) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(Inv inv) throws SQLException;
    public Inv get(Integer id) throws SQLException;
    public List<Inv> getInvsAvance(Integer tiaNumero) throws SQLException;
}
