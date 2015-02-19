package com.ositran.daoimpl;

import com.ositran.dao.TipoInversionDAO;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.InversionTipo;
import org.hibernate.Query;
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
    public List<InversionTipo> query1(String buscar) {
       /* 
        ----------BUSQUEDA SIN LIKE-------
        System.out.println(buscar);
        Query query;
        Session session = sessionFactory.openSession();
        session.beginTransaction();      
        query=session.createQuery("FROM InversionTipo  E WHERE E.tivNombre = :busqueda ");
        query.setParameter("busqueda",buscar);
        List list= query.list();
        session.getTransaction().commit();
        return list;*/
        
         System.out.println(buscar);
        Query query;
        Session session = sessionFactory.openSession();
        session.beginTransaction();      
        query=session.createQuery("FROM InversionTipo  E WHERE E.tivNombre like  :busqueda ");
        query.setParameter("busqueda","%"+buscar+"%");
        List list= query.list();
        session.getTransaction().commit();
        return list;
    }


    @Override
    public String insert(InversionTipo inversionTipo) {
         String result=null;

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
        System.out.println(id);
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            InversionTipo inversionTipo=(InversionTipo)session.get(InversionTipo.class, id);
            session.delete(inversionTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(InversionTipo inversionTipo) {
      
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(inversionTipo);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public InversionTipo get(Integer id) {
       
        return null;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
