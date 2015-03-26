package com.ositran.daoimpl;

import com.ositran.dao.ContratoCaoDAO;
import com.ositran.model.ContratoCao;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoCaoDAOImpl implements ContratoCaoDAO {
    public ContratoCaoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoCao> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoCao contratoCao) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoCao contratoCao) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoCao get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
