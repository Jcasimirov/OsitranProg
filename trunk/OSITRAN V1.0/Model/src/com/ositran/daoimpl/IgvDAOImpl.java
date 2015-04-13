package com.ositran.daoimpl;

import com.ositran.dao.IgvDAO;
import com.ositran.model.Igv;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class IgvDAOImpl implements IgvDAO {
    
   

    @Override
    public List<Igv> query() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        List list=session.createQuery("select o from Igv o where o.igvEstado <> 0").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Igv igv) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.persist(igv);
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
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Igv igv=(Igv)session.get(Igv.class, id);
            session.delete(igv);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Igv igv) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(igv);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }
    

    @Override
    public Igv get(Integer id) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        Igv igv=(Igv)session.get(Igv.class, id);
        session.getTransaction().commit();
        return igv;
    }
    
    
    
    
    
}
