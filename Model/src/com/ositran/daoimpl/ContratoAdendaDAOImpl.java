package com.ositran.daoimpl;

import com.ositran.dao.ContratoAdendaDAO;
import com.ositran.model.ContratoAdenda;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoAdendaDAOImpl implements ContratoAdendaDAO {
    public ContratoAdendaDAOImpl() {
        super();
    }

    @Override
    public List<ContratoAdenda> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("from ContratoAdenda ca where ca.cadEstado != 0").list();
        session.getTransaction().commit();
        return list;      
    }

    @Override
    public String insert(ContratoAdenda contratoAdenda) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(contratoAdenda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        session.flush();
        session.close();
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            ContratoAdenda contratoAdenda=(ContratoAdenda)session.get(ContratoAdenda.class, id);
            session.delete(contratoAdenda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoAdenda contratoAdenda) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoAdenda);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoAdenda get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoAdenda contratoAdenda=(ContratoAdenda)session.get(ContratoAdenda.class, id);
        session.getTransaction().commit();
        return contratoAdenda;
    }
    
    @Override
    public List<ContratoAdenda> getAdendasContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query; 
        query = session.createQuery("FROM ContratoAdenda o where o.cadEstado <> 0 and o.conId = :busqueda1 order by o.cadId DESC");
        query.setParameter("busqueda1",conId);            
        List<ContratoAdenda> list = query.list();    
        session.close();
        return list;        
              
        
        
    }   
}
