package com.ositran.daoimpl;

import com.ositran.dao.ContratoJefeAreaDAO;
import com.ositran.model.ContratoJefeArea;
import com.ositran.model.InversionTipo;

import com.ositran.util.HibernateUtil;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContratoJefeAreaDAOImpl implements ContratoJefeAreaDAO{
    public ContratoJefeAreaDAOImpl() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ContratoJefeArea> query() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List a=session.createCriteria(ContratoJefeArea.class).list();
            tx.commit();
            return a;
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
    public String insert(ContratoJefeArea contratoJefeArea) {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(contratoJefeArea);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx!=null) {
                tx.rollback();
            }
            result = e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public String delete(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoJefeArea contratoJefeArea) {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoJefeArea);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result = e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public ContratoJefeArea get(Integer id) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoJefeArea contratoJefeArea = (ContratoJefeArea) session.get(ContratoJefeArea.class, id);
            tx.commit();
            return contratoJefeArea;
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
    public List<ContratoJefeArea> query1(String buscar) {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public int getCanNombres(String nombre) {
        // TODO Implement this method
        return 0;
    }

    @Override
    public List<ContratoJefeArea> query1(int filtro) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query;
            List list;
            query=session.createQuery("FROM ContratoJefeArea  E WHERE E.conId=:filtro");
            query.setParameter("filtro",filtro );
            list= query.list();
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
}
