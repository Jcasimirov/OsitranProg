package com.ositran.daoimpl;

import com.ositran.dao.ContratoAlertaDAO;
import com.ositran.model.ContratoAlerta;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoAlertaDAOImpl implements ContratoAlertaDAO {
    public ContratoAlertaDAOImpl() {
        super();
    }

    @Override
    public List<ContratoAlerta> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List list=session.createQuery("FROM ContratoAlerta  ca where ca.calEstado != 0").list();
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
    public String insert(ContratoAlerta contratoAlerta) throws SQLException {
        String result=null;
        System.out.print("#######  INCIO INSERT contratoAlerta \n ");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(contratoAlerta);
            tx.commit();
            System.out.print("inserto contratoAlerta \n ");
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
            System.out.print(" error al insertar contratoAlerta \n ");
            e.printStackTrace();
        } finally {
            session.close();
	}
        System.out.print("#######   FIN INSERT contratoAlerta \n ");
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoAlerta contratoAlerta=(ContratoAlerta)session.get(ContratoAlerta.class, id);
            session.delete(contratoAlerta);
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
    public String update(ContratoAlerta contratoAlerta) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoAlerta);
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
    public ContratoAlerta get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoAlerta contratoAlerta=(ContratoAlerta)session.get(ContratoAlerta.class, id);
            tx.commit();
            return contratoAlerta;
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
    public List<ContratoAlerta> getAlertasContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query; 
            query = session.createQuery("FROM ContratoAlerta ca where ca.calEstado<>0 and ca.conId = :busqueda1 and ca.calTipo=4 order by calId DESC");
            query.setParameter("busqueda1",conId);            
            List<ContratoAlerta> list = query.list();
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