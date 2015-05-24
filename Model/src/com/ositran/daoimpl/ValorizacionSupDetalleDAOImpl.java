package com.ositran.daoimpl;

import com.ositran.dao.ValorizacionSupDetalleDAO;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.ValorizacionSupDetalle;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ValorizacionSupDetalleDAOImpl implements ValorizacionSupDetalleDAO{
    public ValorizacionSupDetalleDAOImpl() {
    }
    
    ValorizacionSupDetalle valorizacionSupDetalle;

    @Override
    public List<ValorizacionSupDetalle> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list = session.createQuery("select o from ValorizacionSupDetalle o order by CVA_ID asc").list();
        return list;
    }

    @Override
    public String insert(ValorizacionSupDetalle valorizacionSupDetalle) throws SQLException {
        
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(valorizacionSupDetalle);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            ValorizacionSupDetalle valorizacionSupDetalle = (ValorizacionSupDetalle) session.get(ValorizacionSupDetalle.class, id);
            session.delete(valorizacionSupDetalle);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ValorizacionSupDetalle valorizacionSupDetalle) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(valorizacionSupDetalle);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public ValorizacionSupDetalle get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        valorizacionSupDetalle = (ValorizacionSupDetalle) session.get(ValorizacionSupDetalle.class, id);
        return valorizacionSupDetalle;
    }

    public void setValorizacionSupDetalle(ValorizacionSupDetalle valorizacionSupDetalle) {
        this.valorizacionSupDetalle = valorizacionSupDetalle;
    }

    public ValorizacionSupDetalle getValorizacionSupDetalle() {
        return valorizacionSupDetalle;
    }
	
	//Ivan
    @Override
    public List<ValorizacionSupDetalle> ListaValorizacionesDetRegistradas(Integer id) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();    
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("from ValorizacionSupDetalle val where val.tvsId = :busqueda");
        query.setParameter("busqueda",id);
        List<ValorizacionSupDetalle> Lista= query.list();
        session.getTransaction().commit();
        session.close();
        return Lista;     
    }

}
