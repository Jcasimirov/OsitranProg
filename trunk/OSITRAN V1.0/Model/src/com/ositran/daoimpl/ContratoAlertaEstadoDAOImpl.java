package com.ositran.daoimpl;

import com.ositran.dao.ContratoAlertaEstadoDAO;
import com.ositran.model.ContratoAlertaEstado;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;
@Repository
public class ContratoAlertaEstadoDAOImpl implements ContratoAlertaEstadoDAO {
    public ContratoAlertaEstadoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoAlertaEstado> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from ContratoAlertaEstado o").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(ContratoAlertaEstado contratoAlertaEstado) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contratoAlertaEstado);
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
            ContratoAlertaEstado contratoAlertaEstado=(ContratoAlertaEstado)session.get(ContratoAlertaEstado.class, id);
            session.delete(contratoAlertaEstado);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoAlertaEstado contratoAlertaEstado) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoAlertaEstado);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoAlertaEstado get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoAlertaEstado contratoAlertaEstado=(ContratoAlertaEstado)session.get(ContratoAlertaEstado.class, id);
        session.getTransaction().commit();
        return contratoAlertaEstado;
    }
}
