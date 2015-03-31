package com.ositran.daoimpl;

import com.ositran.dao.ContratoEntregaDAO;
import com.ositran.model.ContratoEntrega;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoEntregaDAOImpl implements ContratoEntregaDAO {
    
    public ContratoEntregaDAOImpl() {
        super();
    }

    @Override
    public List<ContratoEntrega> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from ContratoEntrega  o where ca.cadEstado != 0").list();
        session.getTransaction().commit();
        return list;      
    }

    @Override
    public String insert(ContratoEntrega contratoEntrega) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contratoEntrega);
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
            ContratoEntrega contratoEntrega=(ContratoEntrega)session.get(ContratoEntrega.class, id);
            session.delete(contratoEntrega);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoEntrega contratoEntrega) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoEntrega);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoEntrega get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoEntrega contratoEntrega=(ContratoEntrega)session.get(ContratoEntrega.class, id);
        session.getTransaction().commit();
        return contratoEntrega;
    }
    
    public List<ContratoEntrega> getEntregasContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM ContratoEntrega ca where ca.cenEstado <> 0 and ca.conId = :busqueda1 order by cenId DESC");
        query.setParameter("busqueda1",conId);            
        List<ContratoEntrega> list = query.list();
        session.getTransaction().commit();
        return list;        
              
        
        
    }   
}
