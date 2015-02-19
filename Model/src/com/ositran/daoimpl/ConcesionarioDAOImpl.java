package com.ositran.daoimpl;

import com.ositran.dao.ConcesionarioDAO;
import com.ositran.model.Concesionario;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

public class ConcesionarioDAOImpl implements ConcesionarioDAO{
    
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource ds){
        this.jdbcTemplate=new JdbcTemplate(ds);
    }
    
    private static final Logger logger = LoggerFactory.getLogger(InfraestructuraTipoDAOImpl.class);

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    public ConcesionarioDAOImpl() {
        super();
    }

    @Override
    public List<Concesionario> query() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from Concesionario o").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Concesionario concesionario) {
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(concesionario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) {
        String result=null;
        //Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Concesionario concesionario=(Concesionario)session.get(Concesionario.class, id);
            session.delete(concesionario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Concesionario concesionario) {
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(concesionario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public Concesionario get(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Concesionario concesionario=(Concesionario)session.get(Concesionario.class, id);
        session.getTransaction().commit();
        return concesionario;
    }
}
