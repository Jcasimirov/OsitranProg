package com.ositran.daoimpl;

import com.ositran.dao.TipoInversionDAO;
import com.ositran.model.InversionTipo;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;
import org.hibernate.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TipoInversionDAOImpl implements TipoInversionDAO {

    InversionTipo inversionTipo;

    @Override
    @SuppressWarnings("unchecked")
    public List<InversionTipo> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(InversionTipo.class).list();
    }
    
    @Override
    public int getCanNombres(String nombre) throws SQLException, Exception {
        int cantidad=0;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        List list;
        query=session.createQuery("FROM InversionTipo  E WHERE upper(E.tivNombre)  like :nombre");
        query.setParameter("nombre",nombre );
        list= query.list();   
        cantidad=list.size();
        return cantidad;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<InversionTipo> query1(String buscar) throws SQLException, Exception {
        /*
        ----------BUSQUEDA SIN LIKE-------
        System.out.println(buscar);
        Query query;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        query=session.createQuery("FROM InversionTipo  E WHERE E.tivNombre = :busqueda ");
        query.setParameter("busqueda",buscar);
        List list= query.list();
        session.getTransaction().commit();
        return list;*/
        
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =session.createQuery("FROM InversionTipo  E WHERE upper(E.tivNombre) like  :busqueda");
        query.setParameter("busqueda", "%" + buscar + "%");
        /*  query =session.createQuery("FROM InversionTipo  E WHERE E.tivNombre like  :busqueda  or E.tivId like :busqueda or E.tivDescripcion like :busqueda");
        query.setParameter("busqueda", "%" + buscar + "%"); */
        return query.list();
    }

    @Override
    public String insert(InversionTipo inversionTipo) throws SQLException, Exception {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(inversionTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;

    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        System.out.println(id);
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            InversionTipo inversionTipo = (InversionTipo) session.get(InversionTipo.class, id);
            session.delete(inversionTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(InversionTipo inversionTipo) throws SQLException, Exception {

        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(inversionTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }


    @Override
    public InversionTipo get(Integer id) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        inversionTipo = (InversionTipo) session.get(InversionTipo.class, id);
        return inversionTipo;
    }

    public void setInversionTipo(InversionTipo inversionTipo) {
        this.inversionTipo = inversionTipo;
    }

    public InversionTipo getInversionTipo() {
        return inversionTipo;
    }

   
}