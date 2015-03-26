package com.ositran.daoimpl;

import com.ositran.dao.ContratoHitoDAO;
import com.ositran.model.ContratoHito;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoHitoDAOImpl implements ContratoHitoDAO {
    public ContratoHitoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoHito> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoHito contratoHito) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoHito contratoHito) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoHito get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
