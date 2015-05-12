package com.ositran.daoimpl;

import com.ositran.dao.ContratoInversionDAO;
import com.ositran.model.ContratoInversion;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoInversionDAOImpl implements ContratoInversionDAO {
    public ContratoInversionDAOImpl() {
        super();
    }

    @Override
    public List<ContratoInversion> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("from ContratoInversion ca where ca.invEstado != 0").list();
        session.getTransaction().commit();
        return list;      
    }

    @Override
    public String insert(ContratoInversion contratoInversion) throws SQLException {
        String result=null;
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(contratoInversion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            e.printStackTrace();
        }
        session.flush();
        session.close();
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            ContratoInversion contratoInversion=(ContratoInversion)session.get(ContratoInversion.class, id);
            session.delete(contratoInversion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoInversion contratoInversion) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoInversion);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        session.flush();
        session.close();
        return result;
    }

    @Override
    public ContratoInversion get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoInversion contratoInversion=(ContratoInversion)session.get(ContratoInversion.class, id);
        session.getTransaction().commit();
        return contratoInversion;
    }
    @Override
    public List<ContratoInversion> getInversionesContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM ContratoInversion o where o.invEstado <> 0 and o.conId = :busqueda1 order by o.invId DESC");
        query.setParameter("busqueda1",conId);            
        List<ContratoInversion> list = query.list();
        session.getTransaction().commit();
        return list;        
              
        
        
    }   
    public List<ContratoInversion> getInversionesContratoenRectificacion(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM ContratoInversion o where o.conId = :busqueda1 order by o.invId DESC");
        query.setParameter("busqueda1",conId);            
        List<ContratoInversion> list = query.list();
        session.getTransaction().commit();
        return list;        
              
        
        
    }  
    @Override
        public List<ContratoInversion> ListaPorAeropuerto(int contrato, int tipoInfraestructura, int concesion, int infraestructura) throws SQLException {
            Query query;
            System.out.println("contrato: " + contrato);
            System.out.println("tipoInfraestructura: " + tipoInfraestructura);
            System.out.println("concesion: " + concesion);
            System.out.println("infraestructura: " + infraestructura);
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            query =session.createQuery("FROM ContratoInversion ci where ci.invEstado <> 0  AND ci.conId = :contrato and ci.tinId = :tipoInfraestructura and ci.csiId = :concesion and ci.infId = :infraestructura");
            query.setParameter("contrato",contrato);
            query.setParameter("tipoInfraestructura",tipoInfraestructura);
            query.setParameter("concesion",concesion);
            query.setParameter("infraestructura",infraestructura);
            List<ContratoInversion> list = query.list();
            session.getTransaction().commit();
            return list;        
        }
}
