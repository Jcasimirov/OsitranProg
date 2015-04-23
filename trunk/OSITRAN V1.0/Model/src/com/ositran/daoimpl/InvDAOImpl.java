package com.ositran.daoimpl;

import com.ositran.dao.InvDAO;
import com.ositran.model.Inv;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class InvDAOImpl implements InvDAO {
    public InvDAOImpl() {
        super();
    }

    @Override
    public List<Inv> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("from Inv cc where cc.invEstado != 0").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Inv inv) throws SQLException {
        String result=null;
        System.out.println("## INI INSERT INV");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(inv);
            session.getTransaction().commit();
            System.out.println("## Insert OK");
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            System.out.println("## Insert rollback");
        }
        System.out.println("## FIN INSERT INV");
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            Inv inv=(Inv)session.get(Inv.class, id);
            session.delete(inv);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Inv inv) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(inv);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public Inv get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

        Inv inv = (Inv) session.get(Inv.class, id);
        session.close();
        return inv;
    }
    
    @Override
    public List<Inv> getInvsAvance(Integer tiaNumero) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM Inv cc where cc.invEstado <> 0 and cc.tiaNumero = :busqueda1 order by invId DESC");
        query.setParameter("busqueda1",tiaNumero);            
        List<Inv> list = query.list();
        session.getTransaction().commit();
        return list;        
              
        
        
    }  
}
