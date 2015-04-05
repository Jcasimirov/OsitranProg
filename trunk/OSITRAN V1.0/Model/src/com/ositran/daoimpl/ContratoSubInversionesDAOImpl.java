package com.ositran.daoimpl;

import com.ositran.dao.ContratoSubInversionesDAO;
import com.ositran.model.ContratoJefeArea;
import com.ositran.model.ContratoSupInversiones;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class ContratoSubInversionesDAOImpl implements ContratoSubInversionesDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<ContratoSupInversiones> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(ContratoSupInversiones.class).list();
    }

    @Override
    public String insert(ContratoSupInversiones contratoSupInversiones) throws SQLException, Exception {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
         System.out.println(contratoSupInversiones.getConId());
            System.out.println(contratoSupInversiones.getCsiId());
            System.out.println(contratoSupInversiones.getInfId());
            System.out.println(contratoSupInversiones.getSivId());
            
            
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
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoSupInversiones get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
}
