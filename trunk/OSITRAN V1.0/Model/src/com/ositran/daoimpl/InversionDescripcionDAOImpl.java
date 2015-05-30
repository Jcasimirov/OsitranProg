package com.ositran.daoimpl;

import com.ositran.dao.InversionDescripcionDAO;
import com.ositran.model.InversionTipoDescripcion;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InversionDescripcionDAOImpl implements InversionDescripcionDAO{
    InversionTipoDescripcion inversionTipoDescripcion;
    
    @Override
    public List<InversionTipoDescripcion> query()  throws SQLException ,Exception{
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        List list=session.createQuery("from InversionTipoDescripcion E WHERE E.itdEstado <> 0 order by itdFechaAlta desc").list();
        session.getTransaction().commit();
        return list;
    }
    public List<InversionTipoDescripcion> queryAllIdtEstado()  throws SQLException ,Exception{
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        List list=session.createQuery("from InversionTipoDescripcion E ").list();
        session.getTransaction().commit();
        return list;
    }   
    @Override
    public int getCanNombres(String filtro) throws SQLException, Exception {
        int cantidad=0;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        Query query;
        List list;
        session.getTransaction();
        session.beginTransaction();
        query=session.createQuery("FROM InversionTipoDescripcion  E WHERE  E.itdNombre like :filtro and   E.itdEstado <> 0 ");
        query.setParameter("filtro",filtro );
        list= query.list();   
        cantidad=list.size();
        session.getTransaction().commit();
        return cantidad;
    }
    
    
    @Override
    public String insert(InversionTipoDescripcion inversionTipoDes)  throws SQLException ,Exception{
        
        String result=null;
           Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
           try {
               session.beginTransaction();
               session.save(inversionTipoDes);
               session.getTransaction().commit();
          } catch (Exception e) {
               session.getTransaction().rollback();
               result=e.getMessage();
           }
           return result;
    }


    @Override
    public String update(InversionTipoDescripcion inversionTipoDes) throws SQLException ,Exception {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(inversionTipoDes);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public InversionTipoDescripcion get(Integer id) throws SQLException ,Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        inversionTipoDescripcion = (InversionTipoDescripcion) session.get(InversionTipoDescripcion.class, id);
        session.getTransaction().commit();
        return inversionTipoDescripcion;
    }

    @Override
    public List<InversionTipoDescripcion> query1(String buscar) throws SQLException ,Exception {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();     
        query=session.createQuery("FROM InversionTipoDescripcion  E WHERE (upper(E.itdNombre) like  :busqueda or upper(E.itdDescripcion) like  :busqueda) and E.itdEstado <> 0");  
        query.setParameter("busqueda","%"+buscar+"%");
        List list= query.list();
        session.getTransaction().commit();
        return list;
    }
    
    @Override
    public List<InversionTipoDescripcion> query1(int codigoCompromiso) throws SQLException, Exception {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();     
        query=session.createQuery("FROM InversionTipoDescripcion  E WHERE E.tivId=:codigoCompromiso");  
        query.setParameter("codigoCompromiso",codigoCompromiso);
        List list= query.list();
        session.getTransaction().commit();
        return list;
    }


    public void setInversionTipoDescripcion(InversionTipoDescripcion inversionTipoDescripcion) {
        this.inversionTipoDescripcion = inversionTipoDescripcion;
    }

    public InversionTipoDescripcion getInversionTipoDescripcion() {
        return inversionTipoDescripcion;
    }
    public boolean validarCodigoEnUso(InversionTipoDescripcion des) throws Exception{
        boolean valido=false;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query=null;  
            query =session.createQuery(" Select count(o.dtiId) " +
                                       " From ValorizacionInversionAvanceDetalle o " +
                                       " where o.tivId=:tivId " +
                                       "   and o.dtiId=:itdId ");
            query.setParameter("tivId",des.getTivId());
            query.setParameter("itdId",des.getItdId());
            Long contador=(Long)query.uniqueResult();
            valido=(contador>0)?false:true;            
            tx.commit();
            return valido;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    
}
