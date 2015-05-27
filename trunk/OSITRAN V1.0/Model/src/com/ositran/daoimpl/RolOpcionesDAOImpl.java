package com.ositran.daoimpl;

import com.ositran.dao.RolOpcionesDAO;
import com.ositran.model.InversionTipo;
import com.ositran.model.RolOpciones;
import com.ositran.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
    public void updateEstado(int codigoRol,int codigoMen) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.getTransaction().begin();
        Query query;
        query=session.createQuery("update RolOpciones E set E.troEstado = 0 WHERE  E.menId= :codigoM and E.rolId= :codigoR" );
        query.setParameter("codigoR",codigoRol );
        query.setParameter("codigoM",codigoMen );
        query.executeUpdate();
        session.getTransaction().commit();
    }
    
    @Override
    public List<RolOpciones> query1(Integer codigoRol) {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =session.createQuery("FROM RolOpciones  E WHERE upper(E.rolId) like  :busqueda and E.troEstado<>0");
        query.setParameter("busqueda",codigoRol);
        return query.list();
    }
    @Override
    public String insert(RolOpciones rolOpciones) {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(rolOpciones);
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
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        rolOpciones = (RolOpciones) session.get(InversionTipo.class, id);
        return rolOpciones;
    }
    
    public void setRolOpciones(RolOpciones rolOpciones) {
        this.rolOpciones = rolOpciones;
    }

    public RolOpciones getRolOpciones() {
        return rolOpciones;
    }


   
}
