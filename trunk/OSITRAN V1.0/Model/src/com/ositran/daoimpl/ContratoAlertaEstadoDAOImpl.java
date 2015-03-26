package com.ositran.daoimpl;

import com.ositran.dao.ContratoAlertaEstadoDAO;
import com.ositran.model.ContratoAlertaEstado;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoAlertaEstadoDAOImpl implements ContratoAlertaEstadoDAO {
    public ContratoAlertaEstadoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoAlertaEstado> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoAlertaEstado contratoAlertaEstado) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoAlertaEstado contratoAlertaEstado) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoAlertaEstado get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
