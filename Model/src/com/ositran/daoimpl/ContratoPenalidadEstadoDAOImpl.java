package com.ositran.daoimpl;

import com.ositran.dao.ContratoPenalidadEstadoDAO;
import com.ositran.model.ContratoPenalidadEstado;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoPenalidadEstadoDAOImpl implements ContratoPenalidadEstadoDAO {
    public ContratoPenalidadEstadoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoPenalidadEstado> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoPenalidadEstado contratoPenalidadEstado) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoPenalidadEstado contratoPenalidadEstado) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoPenalidadEstado get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
