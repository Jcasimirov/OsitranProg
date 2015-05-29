package com.ositran.daoimpl;

import com.ositran.dao.TipoInversionDAO;
import com.ositran.model.InversionTipo;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TipoInversionDAOImpl implements TipoInversionDAO {
    InversionTipo inversionTipo;

    @Override
    @SuppressWarnings("unchecked")
    public List<InversionTipo> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        List list=session.createQuery("FROM InversionTipo  E WHERE E.tivEstado <> 0 and E.tivId <> 0").list();
        session.close();
        return list;
    }
    
    @Override
    public int getCanNombres(String nombre) throws SQLException, Exception {
        int cantidad=0;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        List list;
        query=session.createQuery("FROM InversionTipo  E WHERE upper(E.tivNombre)  like :nombre and upper(E.tivEstado) <> 0 ");
        query.setParameter("nombre",nombre );
        list= query.list();   
        cantidad=list.size();
        return cantidad;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<InversionTipo> query1(String buscar) throws SQLException, Exception {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =session.createQuery("FROM InversionTipo  E WHERE (upper(E.tivNombre) like  :busqueda or  upper(E.tivDescripcion) like  :busqueda ) and E.tivEstado <> 0 ");
        query.setParameter("busqueda", "%" + buscar + "%");
        return query.list();
    }

    @Override
    public String insert(InversionTipo inversionTipo) throws SQLException, Exception {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(inversionTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
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
            session.update(inversionTipo);
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
    public boolean validarCodigoEnUso(Integer tivId) throws Exception{
        boolean valido=false;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query=null;  
            query =session.createQuery("Select count(o.tivId) From ContratoCompromiso o where o.ccoEstado = 1 and o.tivId=:tivId");
            query.setParameter("tivId",tivId);
            Long contador=(Long)query.uniqueResult();
            valido=(contador>0)?false:true;            
            tx.commit();
            return valido;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
   
}