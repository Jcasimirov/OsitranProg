package com.ositran.daoimpl;

import com.ositran.dao.ValorizacionSupDAO;
import com.ositran.model.JefeAreaContratoConcecion;
import com.ositran.model.ValorizacionSup;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ValorizacionSupDAOImpl implements ValorizacionSupDAO {
    public ValorizacionSupDAOImpl() {
        super();
    }


    @Override
    public List<ValorizacionSup> query() throws SQLException, Exception {
        return Collections.emptyList();
    }

    @Override
    public String insert(ValorizacionSup valorizacionSup) throws SQLException, Exception {
        String result = null;
        System.out.println("Entro al metodo  INSERT dao implement");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(valorizacionSup);
            session.getTransaction().commit();
        } 
        catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        return null;
    }

    @Override
    public String update(ValorizacionSup valorizacionSup) throws SQLException, Exception {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(valorizacionSup);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            System.out.println(result);
        }
        session.close();
        return result;
    }

    @Override
    public ValorizacionSup get(Integer id) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ValorizacionSup valorizacionSup=(ValorizacionSup)session.get(ValorizacionSup.class, id); 
        session.getTransaction().commit();
        return valorizacionSup;
    }
	
	//Ivan 
    
    @Override
    public List<ValorizacionSup> ListaValorizacionesRegistradas(Integer id) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();    
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("from ValorizacionSup val where val.tvsEstado = 1  and val.supId = :busqueda");
        query.setParameter("busqueda",id);
        List<ValorizacionSup> Lista= query.list();
        session.getTransaction().commit();
        session.close();
        return Lista;     
    }
    
    
}
