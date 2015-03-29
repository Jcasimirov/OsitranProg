package com.ositran.dao;


import com.ositran.model.Infraestructura;
import com.ositran.model.Inversion;

import java.sql.SQLException;

import java.util.List;

public interface InversionDAO {
    public List<Inversion> query() throws SQLException;
    public List<Inversion> query1(Infraestructura infraestructura,int codigoContrato) throws SQLException;
    public String insert(Inversion inversion) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(Inversion inversion) throws SQLException;
    public Inversion get(Integer id) throws SQLException;
}
