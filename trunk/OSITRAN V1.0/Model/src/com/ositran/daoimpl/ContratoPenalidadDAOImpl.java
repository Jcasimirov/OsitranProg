package com.ositran.daoimpl;

import com.ositran.dao.ContratoPenalidadDAO;
import com.ositran.model.ContratoPenalidad;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;
@Repository
public class ContratoPenalidadDAOImpl implements ContratoPenalidadDAO {
    public ContratoPenalidadDAOImpl() {
        super();
    }

    @Override
    public List<ContratoPenalidad> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("from ContratoPenalidad cp where cp.tcpEstado <> 0").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(ContratoPenalidad contratoPenalidad) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contratoPenalidad);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            ContratoPenalidad contratoPenalidad=(ContratoPenalidad)session.get(ContratoPenalidad.class, id);
            session.delete(contratoPenalidad);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoPenalidad contratoPenalidad) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoPenalidad);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoPenalidad get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoPenalidad contratoPenalidad=(ContratoPenalidad)session.get(ContratoPenalidad.class, id);
        session.getTransaction().commit();
        return contratoPenalidad;
    }
    
    @Override
    public List<ContratoPenalidad> getPenalidadesContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM ContratoPenalidad cp where cp.tcpEstado <> 0 and cp.conId = :busqueda1 order by tcpId DESC");
        query.setParameter("busqueda1",conId);            
        List<ContratoPenalidad> list = query.list();
        session.getTransaction().commit();
        return list;        
              
        
        
    }  
}
