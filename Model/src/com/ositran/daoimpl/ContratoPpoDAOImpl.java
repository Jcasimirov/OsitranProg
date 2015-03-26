package com.ositran.daoimpl;

import com.ositran.dao.ContratoPpoDAO;
import com.ositran.model.ContratoPpo;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoPpoDAOImpl implements ContratoPpoDAO {
    public ContratoPpoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoPpo> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoPpo c) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoPpo contratoPpo) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoPpo get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
