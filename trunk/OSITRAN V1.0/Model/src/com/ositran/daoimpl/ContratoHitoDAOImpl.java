package com.ositran.daoimpl;

import com.ositran.dao.ContratoHitoDAO;
import com.ositran.model.ContratoHito;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoHitoDAOImpl implements ContratoHitoDAO {
    public ContratoHitoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoHito> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List list=session.createQuery("from ContratoHito cc where cc.htoEstado != 0").list();
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
    public String insert(ContratoHito contratoHito) throws SQLException {
        String result=null;
        System.out.println("INICIO DAOHito");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(contratoHito);
            tx.commit();
            System.out.println("guardo DAOHito");
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
            e.printStackTrace();
            System.out.println("rollback DAOHito");
        } finally {
            session.close();
	}
        System.out.println("FIN DAOHito");
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoHito contratoHito=(ContratoHito)session.get(ContratoHito.class, id);
            session.delete(contratoHito);
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
    public String update(ContratoHito contratoHito) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoHito);
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
    public ContratoHito get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoHito contratoHito = (ContratoHito) session.get(ContratoHito.class, id);
            tx.commit();
            return contratoHito;
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
    public List<ContratoHito> getHitosContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query; 
            query = session.createQuery("FROM ContratoHito cc where cc.htoEstado <> 0 and cc.conId = :busqueda1 order by htoId DESC");
            query.setParameter("busqueda1",conId);            
            List<ContratoHito> list = query.list();
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
