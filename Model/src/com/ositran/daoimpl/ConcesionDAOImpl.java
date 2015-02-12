package com.ositran.daoimpl;

import com.ositran.dao.ConcesionDAO;
import com.ositran.model.Concesion;

import com.ositran.model.Igv;
import com.ositran.model.InfraestructuraTipo;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

public class ConcesionDAOImpl implements ConcesionDAO {
    public ConcesionDAOImpl() {
        super();
    }

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
    public List<Concesion> query() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("select o from Concesion o").list();
        System.out.println("LISTA = " + list);
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Concesion concesion) {
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(concesion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) {
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Concesion concesion =(Concesion) session.get(Concesion.class,id);
            session.delete(concesion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Concesion concesion) {
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(concesion);
            session.getTransaction().commit();
            logger.info("Concesion updated successfully, Concesion Details="+concesion);
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public Concesion get(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Concesion concesion=(Concesion)session.get(Concesion.class, id);
        session.getTransaction().commit();
        return concesion;
    }
}
