package com.ositran.daoimpl;

import com.ositran.dao.ValorizacionInversionAvanceDetalleDAO;
import com.ositran.model.ValorizacionInversionAvanceDetalle;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;
@Repository
public class ValorizacionInversionAvanceDetalleDAOImpl implements ValorizacionInversionAvanceDetalleDAO {
    
    public ValorizacionInversionAvanceDetalleDAOImpl() {
        super();
    }

    @Override
    public List<ValorizacionInversionAvanceDetalle> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(ValorizacionInversionAvanceDetalle.class).list();
    }
    
    @Override
    public List<ValorizacionInversionAvanceDetalle> query1(int codigoValorizacion) throws SQLException, Exception {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =session.createQuery("FROM ValorizacionInversionAvanceDetalle  E WHERE E.tiaNumero=:busqueda ");
        query.setParameter("busqueda",codigoValorizacion);
        return query.list();
    }

    @Override
    public String insert(ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle) throws SQLException,
                                                                                                       Exception {
        System.out.println("DAO");
        System.out.println("monead"+valorizacionInversionAvanceDetalle.getMonId());
        System.out.println("CABECERA"+valorizacionInversionAvanceDetalle.getTiaNumero());
        System.out.println("INVER"+valorizacionInversionAvanceDetalle.getDtiId());
        System.out.println("INVERTIPO"+valorizacionInversionAvanceDetalle.getTivId());
        
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(valorizacionInversionAvanceDetalle);
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
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle) throws SQLException,
                                                                                                       Exception {

        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(valorizacionInversionAvanceDetalle);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public ValorizacionInversionAvanceDetalle get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    
    @Override
    public List<ValorizacionInversionAvanceDetalle> getInvAvanceDetallesInvAvance(Integer tiaNumero) throws SQLException, Exception {
        
        System.out.println("INI DAO METHOD: getInvAvanceDetallesInvAvance");
        System.out.println("tiaNumero:" + tiaNumero);    
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
 
        Query query; 
        query = session.createQuery("FROM ValorizacionInversionAvanceDetalle ia where ia.tiaNumero = :tianumero order by ia.iad_Id DESC");
        query.setParameter("tianumero",tiaNumero);            

        List<ValorizacionInversionAvanceDetalle> list = query.list();
        System.out.println("FIN DAO METHOD: getInvAvanceDetallesInvAvance");
        session.close();
        return list; 


    }
    
    
}
