package com.ositran.daoimpl;

import com.ositran.dao.ContratoPpoDAO;
import com.ositran.model.ContratoPpo;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;
@Repository
public class ContratoPpoDAOImpl implements ContratoPpoDAO {
    public ContratoPpoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoPpo> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("from ContratoPpo cc where cc.ppoEstado != 0").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(ContratoPpo contratoPpo) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contratoPpo);
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
            ContratoPpo contratoPpo=(ContratoPpo)session.get(ContratoPpo.class, id);
            session.delete(contratoPpo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoPpo contratoPpo) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoPpo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoPpo get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoPpo contratoPpo = (ContratoPpo) session.get(ContratoPpo.class, id);
        session.getTransaction().commit();
        return contratoPpo;
    }
    
    @Override
    public List<ContratoPpo> getPposContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM ContratoPpo cc where cc.ppoEstado <> 0 and cc.conId = :busqueda1 order by ppoId DESC");
        query.setParameter("busqueda1",conId);            
        List<ContratoPpo> list = query.list();
        session.getTransaction().commit();
        return list;        
              
        
        
    }  
}
