package com.ositran.daoimpl;

import com.ositran.dao.ContratoEmpresaSupervisoraDAO;
import com.ositran.model.ContratoSupervisora;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class ContratoEmpresaSupervisoraDAOImpl implements ContratoEmpresaSupervisoraDAO{
    List<ContratoSupervisora> list = null;
    
    @Override
    public List<ContratoSupervisora> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        list= session.createQuery("select o from ContratoSupervisora o").list();
        session.getTransaction().commit();
        session.close();
        return list;    
    }

    @Override
    public String insert(ContratoSupervisora contratoSupervisora) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contratoSupervisora);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        session.close();
        return result;
    }

    @Override
    public String delete(Integer integer) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoSupervisora contratoSupervisora) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoSupervisora get(Integer integer) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public int ValidarContratoSupervisora(int i, int i2) throws SQLException {
        // TODO Implement this method
        return 0;
    }
}

