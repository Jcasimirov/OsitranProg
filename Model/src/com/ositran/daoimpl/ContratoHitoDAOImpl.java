package com.ositran.daoimpl;

import com.ositran.dao.ContratoHitoDAO;
import com.ositran.model.ContratoHito;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoHitoDAOImpl implements ContratoHitoDAO {
    public ContratoHitoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoHito> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("from ContratoHito cc where cc.htoEstado != 0").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(ContratoHito contratoHito) throws SQLException {
        String result=null;
        System.out.println("INICIO DAOHito");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(contratoHito);
            session.getTransaction().commit();
            System.out.println("guardo DAOHito");
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            e.printStackTrace();
            System.out.println("rollback DAOHito");
        }
        session.flush();
        session.close();
        System.out.println("FIN DAOHito");
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            ContratoHito contratoHito=(ContratoHito)session.get(ContratoHito.class, id);
            session.delete(contratoHito);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoHito contratoHito) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoHito);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoHito get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoHito contratoHito = (ContratoHito) session.get(ContratoHito.class, id);
        session.getTransaction().commit();
        return contratoHito;
    }
    
    @Override
    public List<ContratoHito> getHitosContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM ContratoHito cc where cc.htoEstado <> 0 and cc.conId = :busqueda1 order by htoId DESC");
        query.setParameter("busqueda1",conId);            
        List<ContratoHito> list = query.list();
        session.getTransaction().commit();
        return list;        
              
        
        
    }  
}
