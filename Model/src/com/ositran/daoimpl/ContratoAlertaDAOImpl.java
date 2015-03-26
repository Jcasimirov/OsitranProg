package com.ositran.daoimpl;

import com.ositran.dao.ContratoAlertaDAO;
import com.ositran.model.ContratoAlerta;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoAlertaDAOImpl implements ContratoAlertaDAO {
    public ContratoAlertaDAOImpl() {
        super();
    }

    @Override
    public List<ContratoAlerta> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoAlerta contratoAlerta) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoAlerta contratoAlerta) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoAlerta get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
