package com.ositran.daoimpl;

import com.ositran.dao.ContratoDAO;
import com.ositran.model.Contrato;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ContratoDAOImpl implements ContratoDAO{
    
    private Contrato contrato;
    
     
    public String insert(Contrato contrato) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contrato);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    
    public String delete(Integer id) throws SQLException{
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            Contrato contrato = (Contrato) session.get(Contrato.class, id);
            session.delete(contrato);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    
    public String update(Contrato contrato)throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contrato);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }
    

    
    public Contrato get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Contrato contrato = (Contrato) session.get(Contrato.class, id);
        session.getTransaction().commit();
        return contrato;
    }

    
    public List<Contrato> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(Contrato.class).list();
    }

 
    public List<Contrato> ContratoSearch(String searchContrato, String searchAbreviatura) throws SQLException {
        
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            Query query;
            if(searchContrato == null && searchContrato.isEmpty() && searchAbreviatura!= null && !searchAbreviatura.isEmpty()){
                query=session.createQuery("FROM Contrato u WHERE lower(u.monNombre) like lower(:busqueda1) and lower(u.monAbreviatura) like lower(:busqueda2) order by MON_ID asc");                    
                    query.setParameter("busqueda2", "%" + searchAbreviatura + "%");
                }
            else if( searchContrato != null && !searchContrato.isEmpty() && searchAbreviatura == null && searchAbreviatura.isEmpty()){
                query=session.createQuery("FROM Contrato u WHERE lower(u.monNombre) like lower(:busqueda1)  order by MON_ID asc");
                        query.setParameter("busqueda1", "%" + searchContrato + "%");
                }
            else{
                query=session.createQuery("FROM Contrato u WHERE  and lower(u.monAbreviatura) like lower(:busqueda2) order by MON_ID asc");                    
                    query.setParameter("busqueda2", "%" + searchAbreviatura + "%");
                query.setParameter("busqueda1", "%" + searchContrato + "%");                
            }
            return query.list();
        }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
