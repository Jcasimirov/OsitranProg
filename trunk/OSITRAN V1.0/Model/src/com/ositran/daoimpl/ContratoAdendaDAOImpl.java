package com.ositran.daoimpl;

import com.ositran.dao.ContratoAdendaDAO;
import com.ositran.model.AdendaTipo;
import com.ositran.model.ContratoAdenda;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class ContratoAdendaDAOImpl implements ContratoAdendaDAO {
    public ContratoAdendaDAOImpl() {
        super();
    }

    @Override
    public List<ContratoAdenda> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from ContratoAdenda ca o where ca.cadEstado != 0").list();
        session.getTransaction().commit();
        return list;
       /*
        query.setParameter("busqueda", "%" + a + "%");
        query.setParameter("busqueda2", "%" + b + "%");
         * */
    }

    @Override
    public String insert(ContratoAdenda contratoAdenda) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contratoAdenda);
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
            ContratoAdenda contratoAdenda=(ContratoAdenda)session.get(ContratoAdenda.class, id);
            session.delete(contratoAdenda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoAdenda contratoAdenda) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoAdenda);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoAdenda get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoAdenda contratoAdenda=(ContratoAdenda)session.get(ContratoAdenda.class, id);
        session.getTransaction().commit();
        return contratoAdenda;
    }
}
