package com.ositran.daoimpl;

import com.ositran.dao.ContratoEmpresaSupervisoraDAO;
import com.ositran.model.ContratoSupervisora;

import com.ositran.model.EmpresaSupervisora;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ContratoEmpresaSupervisoraDAOImpl implements ContratoEmpresaSupervisoraDAO{
    List<ContratoSupervisora> list = null;
    
    @Override
    public List<ContratoSupervisora> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        list= session.createQuery("select o from ContratoSupervisora o where o.cpsEstado <> 2").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public String insert(ContratoSupervisora contratoSupervisora) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(contratoSupervisora);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        session.close();
        return result;
    }

    @Override
    public String delete(Integer integer) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoSupervisora contratoSupervisora) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoSupervisora);
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
    public ContratoSupervisora get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoSupervisora contratoSupervisora=(ContratoSupervisora)session.get(ContratoSupervisora.class, id);
        session.getTransaction().commit();
        session.close();
        return contratoSupervisora;        
    }

    @Override
    public int ValidarContratoSupervisora(int i, int i2) throws SQLException {
        // TODO Implement this method
        return 0;
    }

    @Override
    public List<ContratoSupervisora> filtrarContraEmpSup(String empresaSupervisora, String tipoInfraestructura,
                                                         String nroContrato) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();    
        session.beginTransaction();    
        Query query;
        /*query=session.createQuery("select o from ContratoSupervisora o where o.empresaSupervisora like :busqueda1 " +
            "and o.tipoInfraestructura like :busqueda2 " +
            "and o.cpsNroDeContrato like :busqueda3 " +
            "and o.cpsEstado <> 2");*/
        query=session.createQuery("select o from ContratoSupervisora o where o.cpsNroDeContrato like :busqueda3 " +
            "and o.cpsEstado <> 2");
        System.out.println("query:");
        System.out.println(query);
        String empresaSupervisoraStr="";
        String tipoInfraestructuraStr="";
        
        Integer nroContratoStr=Integer.valueOf(nroContrato);
        //query.setParameter("busqueda1","%"+empresaSupervisoraStr+"%");
        //query.setParameter("busqueda2","%"+tipoInfraestructuraStr+"%");
        query.setParameter("busqueda3",nroContratoStr);
        System.out.println("query:");
        System.out.println(query);
        
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
