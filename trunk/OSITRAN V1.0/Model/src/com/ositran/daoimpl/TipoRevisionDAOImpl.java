package com.ositran.daoimpl;

import com.ositran.dao.TipoRevisionDAO;
import com.ositran.model.InversionTipo;
import com.ositran.model.TipoRevision;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class TipoRevisionDAOImpl implements TipoRevisionDAO{
    public TipoRevisionDAOImpl() {
        super();
    }

    @Override
    public List<TipoRevision> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list = session.createQuery("from TipoRevision").list();
        return list;
    }

    @Override
    public String insert(TipoRevision tipoRevision) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(InversionTipo inversionTipo) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public TipoRevision get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
}
