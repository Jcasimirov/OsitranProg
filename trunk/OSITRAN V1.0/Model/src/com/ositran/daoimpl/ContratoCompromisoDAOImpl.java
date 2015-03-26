package com.ositran.daoimpl;

import com.ositran.dao.ContratoCompromisoDAO;
import com.ositran.model.ContratoCompromiso;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoCompromisoDAOImpl implements ContratoCompromisoDAO {
    public ContratoCompromisoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoCompromiso> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoCompromiso contratoCompromiso) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoCompromiso contratoCompromiso) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoCompromiso get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
