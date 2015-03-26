package com.ositran.daoimpl;

import com.ositran.dao.AdendaTipoDAO;
import com.ositran.model.AdendaTipo;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class AdendaTipoDAOImpl implements AdendaTipoDAO {
    public AdendaTipoDAOImpl() {
        super();
    }

    @Override
    public List<AdendaTipo> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from AdendaTipo o").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(AdendaTipo adendaTipo) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(adendaTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            AdendaTipo adendaTipo=(AdendaTipo)session.get(AdendaTipo.class, id);
            session.delete(adendaTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(AdendaTipo adendaTipo) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(adendaTipo);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public AdendaTipo get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        AdendaTipo adendaTipo=(AdendaTipo)session.get(AdendaTipo.class, id);
        session.getTransaction().commit();
        return adendaTipo;
    }
}
