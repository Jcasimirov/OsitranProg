package com.ositran.daoimpl;

import com.ositran.dao.InversionDescripcionDAO;
import com.ositran.model.InversionTipo;
import com.ositran.model.InversionTipoDescripcion;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InversionDescripcionDAOImpl implements InversionDescripcionDAO{
    
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public List<InversionTipoDescripcion> query() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from InversionTipoDescripcion o").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(InversionTipoDescripcion inversionTipoDes) {
        
        String result=null;
           Session session = sessionFactory.openSession();
           try {
               session.beginTransaction();
               session.save(inversionTipoDes);
               session.getTransaction().commit();
          } catch (Exception e) {
               
               e.printStackTrace();
                   
               session.getTransaction().rollback();
               result=e.getMessage();
           }
           return result;
    }

    @Override
    public String delete(Integer id) {
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            InversionTipoDescripcion inversionTipoDescripcion=(InversionTipoDescripcion)session.get(InversionTipoDescripcion.class, id);
            session.delete(inversionTipoDescripcion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(InversionTipoDescripcion inversionTipoDes) {
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(inversionTipoDes);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public InversionTipoDescripcion get(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public List<InversionTipo> query1(String buscar) {
        // TODO Implement this method
        return Collections.emptyList();
    }
}
