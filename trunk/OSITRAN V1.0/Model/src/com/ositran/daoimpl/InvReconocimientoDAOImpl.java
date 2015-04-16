package com.ositran.daoimpl;

import com.ositran.dao.InvReconocimientoDAO;
import com.ositran.model.InvReconocimiento;
import com.ositran.model.InvReconocimiento;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class InvReconocimientoDAOImpl implements InvReconocimientoDAO {
    public InvReconocimientoDAOImpl() {
        super();
    }

    @Override
    public List<InvReconocimiento> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("from InvReconocimiento cc where cc.ireEstado != 0").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(InvReconocimiento invReconocimiento) throws SQLException {
        String result=null;
        System.out.println("INICIO DAOInvReconocimiento");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(invReconocimiento);
            session.getTransaction().commit();
            System.out.println("guardo DAOInvReconocimiento");
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            e.printStackTrace();
            System.out.println("rollback DAOInvReconocimiento");
        }
        
        System.out.println("FIN DAOInvReconocimiento");
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            InvReconocimiento invReconocimiento=(InvReconocimiento)session.get(InvReconocimiento.class, id);
            session.delete(invReconocimiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(InvReconocimiento invReconocimiento) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(invReconocimiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public InvReconocimiento get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        InvReconocimiento invReconocimiento = (InvReconocimiento) session.get(InvReconocimiento.class, id);
        session.getTransaction().commit();
        return invReconocimiento;
    }
    
    @Override
    public List<InvReconocimiento> getInvReconocimientosAvance(Integer invId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM InvReconocimiento cc where cc.ireEstado <> 0 and cc.tiaNumero = :busqueda1 order by ireId DESC");
        query.setParameter("busqueda1",invId);            
        List<InvReconocimiento> list = query.list();
        session.getTransaction().commit();
        return list;        
              
        
        
    }  
}
