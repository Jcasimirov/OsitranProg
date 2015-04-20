package com.ositran.daoimpl;

import com.ositran.dao.InvReajusteDAO;
import com.ositran.model.InvReajuste;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class InvReajusteDAOImpl implements InvReajusteDAO {
    public InvReajusteDAOImpl() {
        super();
    }

    @Override
    public List<InvReajuste> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("from InvReajuste cc").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(InvReajuste invReajuste) throws SQLException {
        String result=null;
        System.out.println("INICIO DAOInvReajuste");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(invReajuste);
            session.getTransaction().commit();
            System.out.println("guardo DAOInvReajuste");
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            e.printStackTrace();
            System.out.println("rollback DAOInvReajuste");
        }
        
        System.out.println("FIN DAOInvReajuste");
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            InvReajuste invReajuste=(InvReajuste)session.get(InvReajuste.class, id);
            session.delete(invReajuste);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(InvReajuste invReajuste) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(invReajuste);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public InvReajuste get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        InvReajuste invReajuste = (InvReajuste) session.get(InvReajuste.class, id);
        session.getTransaction().commit();
        return invReajuste;
    }
    
    @Override
    public List<InvReajuste> getInvReajustesAvance(Integer tiaNumero) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM InvReajuste cc where cc.tiaNumero = :busqueda1 order by irjId DESC");
        query.setParameter("busqueda1",tiaNumero);            
        List<InvReajuste> list = query.list();
        session.getTransaction().commit();
        return list;   
    }
}
