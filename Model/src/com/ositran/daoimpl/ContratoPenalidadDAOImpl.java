package com.ositran.daoimpl;

import com.ositran.dao.ContratoPenalidadDAO;
import com.ositran.model.ContratoPenalidad;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoPenalidadDAOImpl implements ContratoPenalidadDAO {
    public ContratoPenalidadDAOImpl() {
        super();
    }

    @Override
    public List<ContratoPenalidad> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoPenalidad contratoPenalidad) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoPenalidad contratoPenalidad) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoPenalidad get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
