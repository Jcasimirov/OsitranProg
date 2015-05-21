package com.ositran.daoimpl;

import com.ositran.dao.ContratoAlertaEstadoDAO;
import com.ositran.model.ContratoAlertaEstado;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;

import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;
@Repository
public class ContratoAlertaEstadoDAOImpl implements ContratoAlertaEstadoDAO {
    public ContratoAlertaEstadoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoAlertaEstado> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List list=session.createQuery("select o from ContratoAlertaEstado o").list();
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public String insert(ContratoAlertaEstado contratoAlertaEstado) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.persist(contratoAlertaEstado);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoAlertaEstado contratoAlertaEstado=(ContratoAlertaEstado)session.get(ContratoAlertaEstado.class, id);
            session.delete(contratoAlertaEstado);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public String update(ContratoAlertaEstado contratoAlertaEstado) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoAlertaEstado);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public ContratoAlertaEstado get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoAlertaEstado contratoAlertaEstado=(ContratoAlertaEstado)session.get(ContratoAlertaEstado.class, id);
            tx.commit();
            return contratoAlertaEstado;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}