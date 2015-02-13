package com.ositran.daoimpl;

import com.ositran.dao.TipoInversionDAO;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.InversionTipo;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TipoInversionDAOImpl implements TipoInversionDAO{

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

  

    @Override
    public List<InversionTipo> query() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from InversionTipo o").list();
        System.out.println("LISTA = "+list);
        session.getTransaction().commit();
        return list;
    }

   


    @Override
    public String insert(InversionTipo inversionTipo) {
         String result=null;
         System.out.println("Dao");
            Session session = sessionFactory.openSession();
            try {
                session.beginTransaction();
                session.persist(inversionTipo);
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
        
        return null;
    }

    @Override
    public String update(InversionTipo inversionTipo) {
        
        return null;
    }

    @Override
    public InfraestructuraTipo get(Integer id) {
       
        return null;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
