package com.ositran.daoimpl;

import com.ositran.dao.MonedaDAO;
import com.ositran.model.Moneda;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;

@Repository
public class MonedaDAOImpl implements MonedaDAO{
    
    @Override    
    public String insert(Moneda moneda) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(moneda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            Moneda moneda = (Moneda) session.get(Moneda.class, id);
            session.delete(moneda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Moneda moneda)throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(moneda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }
    

    @Override
    public Moneda get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Moneda moneda = (Moneda) session.get(Moneda.class, id);
        session.getTransaction().commit();
        return moneda;
    }

    @Override
    @SuppressWarnings("unchecked")    
    public List<Moneda> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(Moneda.class).add(Restrictions.not(Restrictions.eq("monId", 0))).list();
    }

    @Override
    public List<Moneda> MonedaSearch(String searchMoneda, String searchAbreviatura) throws SQLException {
        
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            Query query;
            if(searchMoneda == null && searchMoneda.isEmpty() && searchAbreviatura!= null && !searchAbreviatura.isEmpty()){
                query=session.createQuery("FROM Moneda u WHERE lower(u.monNombre) like lower(:busqueda1) and lower(u.monAbreviatura) like lower(:busqueda2) order by MON_ID asc");                    
                    query.setParameter("busqueda2", "%" + searchAbreviatura + "%");
                }
            else if( searchMoneda != null && !searchMoneda.isEmpty() && searchAbreviatura == null && searchAbreviatura.isEmpty()){
                query=session.createQuery("FROM Moneda u WHERE lower(u.monNombre) like lower(:busqueda1)  order by MON_ID asc");
                        query.setParameter("busqueda1", "%" + searchMoneda + "%");
                }
            else{
                query=session.createQuery("FROM Moneda u WHERE  and lower(u.monAbreviatura) like lower(:busqueda2) order by MON_ID asc");                    
                    query.setParameter("busqueda2", "%" + searchAbreviatura + "%");
                query.setParameter("busqueda1", "%" + searchMoneda + "%");                
            }
            return query.list();
        }


}
