package com.ositran.daoimpl;

import com.ositran.dao.ContratoSubInversionesDAO;
import com.ositran.model.ContratoJefeArea;
import com.ositran.model.ContratoSupInversiones;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ContratoSubInversionesDAOImpl implements ContratoSubInversionesDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<ContratoSupInversiones> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(ContratoSupInversiones.class).list();
    }

    @Override
    public ContratoSupInversiones get1(Integer id) throws SQLException, Exception {
        ContratoSupInversiones contratoSupInversiones= new ContratoSupInversiones();
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        List list;
        query=session.createQuery("FROM ContratoSupInversiones  E WHERE E.conId=:id and E.sivEstado=1");
        query.setParameter("id",id );
        contratoSupInversiones=(ContratoSupInversiones)query.uniqueResult();  
        return contratoSupInversiones;
    }
    
    @Override
    public List<ContratoSupInversiones> query1(int filtro) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        List list;
        query=session.createQuery("FROM ContratoSupInversiones  E WHERE E.conId=:filtro");
        query.setParameter("filtro",filtro );
        list= query.list();   
        return list;
    }
    @Override
    public String insert(ContratoSupInversiones contratoSupInversiones) throws SQLException, Exception {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(contratoSupInversiones);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            e.printStackTrace();
        }
        return result;
        
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoSupInversiones contratoSupInversiones) throws SQLException, Exception {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoSupInversiones);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoSupInversiones get(Integer id) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        ContratoSupInversiones contratoSupInversiones = (ContratoSupInversiones) session.get(ContratoSupInversiones.class, id);
        return contratoSupInversiones;
    }


  
}
