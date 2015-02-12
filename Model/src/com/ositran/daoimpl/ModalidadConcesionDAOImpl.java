package com.ositran.daoimpl;

import com.ositran.dao.ModalidadConcesionDAO;
import com.ositran.model.ModalidadConcesion;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

public class ModalidadConcesionDAOImpl implements ModalidadConcesionDAO{
    
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource ds){
        this.jdbcTemplate=new JdbcTemplate(ds);
    }
    
    private static final Logger logger = LoggerFactory.getLogger(InfraestructuraTipoDAOImpl.class);

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }

    public ModalidadConcesionDAOImpl() {
        super();
    }

    @Override
    public List<ModalidadConcesion> query() {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ModalidadConcesion modalidadConcesion) {
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(modalidadConcesion);
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
            ModalidadConcesion modalidadConcesion=(ModalidadConcesion)session.get(ModalidadConcesion.class, id);
            session.delete(modalidadConcesion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ModalidadConcesion modalidadConcesion) {
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(modalidadConcesion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public ModalidadConcesion get(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ModalidadConcesion modalidadConcesion=(ModalidadConcesion)session.get(ModalidadConcesion.class, id);
        session.getTransaction().commit();
        return modalidadConcesion;
    }
}
