package com.ositran.daoimpl;

import com.ositran.dao.InversionDAO;
import com.ositran.model.Inversion;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class InversionDAOImpl implements InversionDAO {
    public InversionDAOImpl() {
        super();
    }

    @Override
    public List<Inversion> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(Inversion inversion) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(Inversion inversion) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public Inversion get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
