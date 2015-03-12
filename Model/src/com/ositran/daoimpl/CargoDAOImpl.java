package com.ositran.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import java.sql.SQLException;
import com.ositran.util.HibernateUtil;
import com.ositran.dao.CargoDAO;
import com.ositran.model.Cargo;

import org.hibernate.SessionFactory;

import org.springframework.jdbc.core.JdbcTemplate;

public class CargoDAOImpl implements CargoDAO {
    

    public CargoDAOImpl() {
        super();
    }

    @Override
    public List<Cargo> query() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from Cargo o").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Cargo cargo) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
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
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
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
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(cargo);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public Cargo get(Integer id) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Cargo cargo=(Cargo)session.get(Cargo.class, id);
        session.getTransaction().commit();
        return cargo;
    }

    
}
