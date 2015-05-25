package com.ositran.daoimpl;

import com.ositran.dao.ContratoPenalidadDAO;
import com.ositran.model.ContratoPenalidad;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoPenalidadDAOImpl implements ContratoPenalidadDAO {
    public ContratoPenalidadDAOImpl() {
        super();
    }

    @Override
    public List<ContratoPenalidad> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List list=session.createQuery("from ContratoPenalidad cp").list();
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
    public String insert(ContratoPenalidad contratoPenalidad) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(contratoPenalidad);
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
            ContratoPenalidad contratoPenalidad=(ContratoPenalidad)session.get(ContratoPenalidad.class, id);
            session.delete(contratoPenalidad);
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
    public String update(ContratoPenalidad contratoPenalidad) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoPenalidad);
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
    public ContratoPenalidad get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoPenalidad contratoPenalidad=(ContratoPenalidad)session.get(ContratoPenalidad.class, id);
            tx.commit();
            return contratoPenalidad;
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
    public List<ContratoPenalidad> getPenalidadesContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query;
            query = session.createQuery("FROM ContratoPenalidad cp where cp.conId = :busqueda1 and cp.tcpEstado<>0 order by tcpId DESC");
            query.setParameter("busqueda1",conId);            
            List<ContratoPenalidad> list = query.list();
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
