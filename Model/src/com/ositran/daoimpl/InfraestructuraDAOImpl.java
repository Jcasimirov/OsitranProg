package com.ositran.daoimpl;

import com.ositran.dao.InfraestructuraDAO;
import com.ositran.model.Concesion;
import com.ositran.model.Infraestructura;
import com.ositran.model.InfraestructuraTipo;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InfraestructuraDAOImpl implements InfraestructuraDAO{

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    @Override
    public List<Infraestructura> query1(Integer codigoC) {
          Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query;
        query = session.createQuery("From Infraestructura i WHERE i.concesion.csiId = :busqueda1");
        query.setParameter("busqueda1",codigoC);
        List<Infraestructura> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list; 
    }

    @Override
    public List<Infraestructura> query() {
        System.out.println("DAO");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("select o from Infraestructura o ").list();
        
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Infraestructura infraestructura) {
        String result=null;
        System.out.println("DaoInfra");
           Session session = sessionFactory.openSession();
           try {
               session.beginTransaction();
               session.persist(infraestructura);
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
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(Infraestructura infraestructura) {
        // TODO Implement this method
        return null;
    }

    @Override
    public InfraestructuraTipo get(Integer id) {
        // TODO Implement this method
        return null;
    }

}
