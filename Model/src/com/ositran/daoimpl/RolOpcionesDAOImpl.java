package com.ositran.daoimpl;

import com.ositran.dao.RolOpcionesDAO;
import com.ositran.model.RolOpciones;
import com.ositran.util.HibernateUtil;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RolOpcionesDAOImpl implements RolOpcionesDAO{
    
    private  RolOpciones rolOpciones;
    public RolOpcionesDAOImpl() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RolOpciones> query() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(RolOpciones.class).list();
    }

    @Override
    public void updateEstado(int codigo) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.getTransaction().begin();
        Query query;
        query=session.createQuery("update RolOpciones E set E.troEstado = 0 WHERE  E.rxoId= :codigo");
        query.setParameter("codigo",codigo );
        query.executeUpdate();
        session.getTransaction().commit();
    }
    
    @Override
    public List<RolOpciones> query1(Integer codigoRol) {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =session.createQuery("FROM RolOpciones  E WHERE upper(E.rolId) like  :busqueda");
        query.setParameter("busqueda",codigoRol);
       
        return query.list();
    }
    @Override
    public String insert(RolOpciones rolOpciones) {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(rolOpciones);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }
    
    @Override
    public String insertOrUpdate(RolOpciones rolOpciones) {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(rolOpciones);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result; // TODO Implement this method
        
    }

    @Override
    public String delete(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(RolOpciones rolOpciones) {
        // TODO Implement this method
        return null;
    }

    @Override
    public RolOpciones get(Integer id) {
        // TODO Implement this method
        return null;
    }
    
    public void setRolOpciones(RolOpciones rolOpciones) {
        this.rolOpciones = rolOpciones;
    }

    public RolOpciones getRolOpciones() {
        return rolOpciones;
    }


   
}
