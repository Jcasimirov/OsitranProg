package com.ositran.daoimpl;

import com.ositran.dao.ContratoAlertaDAO;
import com.ositran.model.ContratoAlerta;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoAlertaDAOImpl implements ContratoAlertaDAO {
    public ContratoAlertaDAOImpl() {
        super();
    }

    @Override
    public List<ContratoAlerta> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("FROM ContratoAlerta  ca where ca.calEstado != 0").list();
        session.getTransaction().commit();
        return list;      
    }

    @Override
    public String insert(ContratoAlerta contratoAlerta) throws SQLException {
        String result=null;
        System.out.print("#######  INCIO INSERT contratoAlerta \n ");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(contratoAlerta);
            session.getTransaction().commit();
            System.out.print("inserto contratoAlerta \n ");
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            System.out.print(" error al insertar contratoAlerta \n ");
            e.printStackTrace();
        }
        session.flush();
        session.close();
        System.out.print("#######   FIN INSERT contratoAlerta \n ");
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            ContratoAlerta contratoAlerta=(ContratoAlerta)session.get(ContratoAlerta.class, id);
            session.delete(contratoAlerta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoAlerta contratoAlerta) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoAlerta);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoAlerta get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoAlerta contratoAlerta=(ContratoAlerta)session.get(ContratoAlerta.class, id);
        session.getTransaction().commit();
        return contratoAlerta;
    }
    
    @Override
    public List<ContratoAlerta> getAlertasContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM ContratoAlerta ca where ca.conId = :busqueda1 and ca.calTipo=4 order by calId DESC");
        query.setParameter("busqueda1",conId);            
        List<ContratoAlerta> list = query.list();
        session.getTransaction().commit();
        return list;        
              
        
        
    }   

}
