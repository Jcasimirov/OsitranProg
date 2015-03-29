package com.ositran.daoimpl;

import com.ositran.dao.ContratoCompromisoDAO;
import com.ositran.model.ContratoCompromiso;

import com.ositran.model.RolOpciones;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ContratoCompromisoDAOImpl implements ContratoCompromisoDAO {
    public ContratoCompromisoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoCompromiso> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(ContratoCompromiso.class).list();
    }

    @Override
    public List<ContratoCompromiso> query1(int codigo) throws SQLException {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =session.createQuery("FROM ContratoCompromiso  E WHERE upper(E.conId) = :filtro");
        query.setParameter("filtro",codigo);
        return query.list();
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
