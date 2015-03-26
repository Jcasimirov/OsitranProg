package com.ositran.daoimpl;

import com.ositran.dao.ContratoEntregaDAO;
import com.ositran.model.ContratoEntrega;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoEntregaDAOImpl implements ContratoEntregaDAO {
    public ContratoEntregaDAOImpl() {
        super();
    }

    @Override
    public List<ContratoEntrega> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoEntrega contratoEntrega) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoEntrega contratoEntrega) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoEntrega get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
