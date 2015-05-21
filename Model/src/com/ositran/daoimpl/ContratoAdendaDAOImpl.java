package com.ositran.daoimpl;

import com.ositran.dao.ContratoAdendaDAO;
import com.ositran.model.ContratoAdenda;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoAdendaDAOImpl implements ContratoAdendaDAO {
    public ContratoAdendaDAOImpl() {
        super();
    }

    @Override
    public List<ContratoAdenda> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List list=session.createQuery("from ContratoAdenda ca where ca.cadEstado != 0").list();
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
    public String insert(ContratoAdenda contratoAdenda) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(contratoAdenda);
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
            ContratoAdenda contratoAdenda=(ContratoAdenda)session.get(ContratoAdenda.class, id);
            session.delete(contratoAdenda);
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
    public String update(ContratoAdenda contratoAdenda) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoAdenda);
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
    public ContratoAdenda get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoAdenda contratoAdenda=(ContratoAdenda)session.get(ContratoAdenda.class, id);
            tx.commit();
            return contratoAdenda;
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
    public List<ContratoAdenda> getAdendasContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query; 
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            query = session.createQuery("FROM ContratoAdenda o where o.cadEstado <> 0 and o.conId = :busqueda1 order by o.cadId DESC");
            query.setParameter("busqueda1",conId);            
            List<ContratoAdenda> list = query.list();
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
