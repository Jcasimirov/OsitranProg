package com.ositran.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.ositran.dao.InfraestructuraTipoDAO;
import com.ositran.model.InfraestructuraTipo;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class InfraestructuraTipoDAOImpl implements InfraestructuraTipoDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    private static final Logger logger = LoggerFactory.getLogger(InfraestructuraTipoDAOImpl.class);

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public String insert(InfraestructuraTipo infraestructuraTipo) {
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(infraestructuraTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) {
        System.out.println(id);
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            InfraestructuraTipo infraestructuraTipo = (InfraestructuraTipo) session.get(InfraestructuraTipo.class, id);
            session.delete(infraestructuraTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(InfraestructuraTipo infraestructuraTipo) {
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(infraestructuraTipo);
            session.getTransaction().commit();
            logger.info("InfraestructuraTipo updated successfully, InfraestructuraTipo Details=" + infraestructuraTipo);
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public InfraestructuraTipo get(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        InfraestructuraTipo infraestructuraTipo = (InfraestructuraTipo) session.get(InfraestructuraTipo.class, id);
        session.getTransaction().commit();
        return infraestructuraTipo;
    }

    @Override
    public List query() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("select o from InfraestructuraTipo o").list();
        System.out.println("LISTA = " + list);
        session.getTransaction().commit();
        return list;
    }


    @Override
    public List<InfraestructuraTipo> AllSearch(String a) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM InfraestructuraTipo  I WHERE lower(I.tinNombre) like  lower(:busqueda)");
        query.setParameter("busqueda","%"+a+"%");
        List<InfraestructuraTipo> list= query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    
    
    
}
