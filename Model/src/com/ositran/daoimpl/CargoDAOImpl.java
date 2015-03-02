package com.ositran.daoimpl;

import com.ositran.dao.CargoDAO;
import com.ositran.model.Cargo;


import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

public class CargoDAOImpl implements CargoDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource ds){
        this.jdbcTemplate=new JdbcTemplate(ds);
    }
    
    private static final Logger logger = LoggerFactory.getLogger(CargoDAOImpl.class);

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }
    
    
    public CargoDAOImpl() {
        super();
    }

    @Override
    public List<Cargo> query() throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from Cargo o").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Cargo cargo) throws SQLException{
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(cargo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Cargo cargo=(Cargo)session.get(Cargo.class, id);
            session.delete(cargo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Cargo cargo) throws SQLException{
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(cargo);
            session.getTransaction().commit();
            logger.info("Cargo updated successfully, Cargo Details="+cargo);
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public Cargo get(Integer id) throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Cargo cargo=(Cargo)session.get(Cargo.class, id);
        session.getTransaction().commit();
        return cargo;
    }

    
}
