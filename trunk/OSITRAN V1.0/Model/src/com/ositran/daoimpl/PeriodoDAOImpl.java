package com.ositran.daoimpl;

import com.ositran.dao.PeriodoDAO;
import com.ositran.model.Periodo;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class PeriodoDAOImpl implements PeriodoDAO {
    public PeriodoDAOImpl() {
        super();
    }

    @Override
    public List<Periodo> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        
        List list=session.createQuery("From Periodo o WHERE o.perId <> -1").list();
        session.close();
        return list;
    }

    @Override
    public String insert(Periodo periodo) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(periodo);
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
            Periodo periodo=(Periodo)session.get(Periodo.class, id);
            session.delete(periodo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Periodo periodo) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(periodo);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public Periodo get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Periodo periodo=(Periodo)session.get(Periodo.class, id);
        session.getTransaction().commit();
        return periodo;
    }
}
